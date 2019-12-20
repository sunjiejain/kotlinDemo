package com.wd.health.kotlinlogin.view.activity

import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.wd.health.kotlinlogin.R
import com.wd.health.kotlinlogin.model.IConstractView
import com.wd.health.kotlinlogin.model.bean.RegisterBean
import com.wd.health.kotlinlogin.model.rsa.RsaCoder
import com.wd.health.kotlinlogin.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*
import java.lang.Exception

class RegisterActivity : BaseActivity(),IConstractView.IRegisterView {

    lateinit var registerPresenter: RegisterPresenter

    //注册回调
    override fun registerSuccess(registerBean: RegisterBean) {
        if (registerBean.getStatus().equals("0000")){
            registerBean.getMessage()!!.toast(this,Toast.LENGTH_SHORT)
            finish()
        }else{
            registerBean.getMessage()!!.toast(this,Toast.LENGTH_SHORT)
            return
        }
    }

    //加载布局
    override fun bindLayout(): Int {
        return R.layout.activity_register
    }

    override fun initView() {
        //点击注册
        btn_register.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                var phone = et_phone_register.text.toString().trim()
                var pwd = et_pwd_register.text.toString().trim()
                var nickName = et_nickName.text.toString().trim()
                if (TextUtils.isEmpty(nickName)) {
                    "用户姓名不能为空".toast(this@RegisterActivity, Toast.LENGTH_SHORT)
                    return
                }
                if (TextUtils.isEmpty(phone)) {
                    "手机号不能为空".toast(this@RegisterActivity, Toast.LENGTH_SHORT)
                    return
                }
                if (TextUtils.isEmpty(pwd)) {
                    "密码不能为空".toast(this@RegisterActivity, Toast.LENGTH_SHORT)
                    return
                }
                try {
                    var encryptPwd = RsaCoder.encryptByPublicKey(pwd)
                    Log.i("encryptPwd", encryptPwd)
                    registerPresenter.register(phone, nickName, encryptPwd)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        })
    }

    fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
        return Toast.makeText(context, this.toString(), duration).apply { show() }
    }
    override fun initData() {
        registerPresenter = RegisterPresenter()
        registerPresenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        registerPresenter.detachView()
    }
}
