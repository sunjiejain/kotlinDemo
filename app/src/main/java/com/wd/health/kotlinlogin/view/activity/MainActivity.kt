package com.wd.health.kotlinlogin.view.activity

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.wd.health.kotlinlogin.R
import com.wd.health.kotlinlogin.model.IConstractView
import com.wd.health.kotlinlogin.model.bean.LoginBean
import com.wd.health.kotlinlogin.model.rsa.RsaCoder
import com.wd.health.kotlinlogin.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : BaseActivity() ,IConstractView.ILoginView{

    lateinit var loginPresenter: LoginPresenter

    //登陆成功回调
    override fun loginSuccess(loginBean: LoginBean) {
        if (loginBean.getStatus().equals("0000")){
            loginBean.getMessage()!!.toast(this,Toast.LENGTH_SHORT)
            //跳转首页
            activityTiaozhuan(this,HomePageActivity().javaClass);
        }else{
            loginBean.getMessage()!!.toast(this,Toast.LENGTH_SHORT)
        }
    }

    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

        //点击登录
        btn_login.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                var phone = et_phone.text.toString().trim()
                var pwd = et_pwd.text.toString().trim()
                if (TextUtils.isEmpty(phone)){
                    "手机号不能为空".toast(this@MainActivity,Toast.LENGTH_SHORT)
                    return
                }
                if (TextUtils.isEmpty(pwd)){
                    "密码不能为空".toast(this@MainActivity,Toast.LENGTH_SHORT)
                    return
                }
                try {
                    var encryptPwd = RsaCoder.encryptByPublicKey(pwd)
                    Log.i("encryptPwd",encryptPwd)
                    loginPresenter.login(phone,encryptPwd)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        })

        //点击注册
        btn_re.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                activityTiaozhuan(this@MainActivity,RegisterActivity().javaClass);
            }
        })
    }

    //intent跳转封装
    fun activityTiaozhuan(ctx: Context,clazz:Class<Any>){
        var intent = Intent()
        intent.setClass(ctx,clazz)
        startActivity(intent)
    }

    override fun initData() {
        loginPresenter = LoginPresenter()
        loginPresenter.attachView(this)
    }


    fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
        return Toast.makeText(context, this.toString(), duration).apply { show() }
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.detachView()
    }
}
