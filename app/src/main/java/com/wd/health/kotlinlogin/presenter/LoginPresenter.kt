package com.wd.health.kotlinlogin.presenter

import com.wd.health.kotlinlogin.model.IConstractView
import com.wd.health.kotlinlogin.model.OkHttpUtils
import com.wd.health.kotlinlogin.model.bean.LoginBean
import com.wd.health.kotlinlogin.model.bean.RegisterBean


/**
 * date:2019/12/20
 * author:孙杰健(fdg)
 * function:
 */
class LoginPresenter:BasePresenter<IConstractView.ILoginView>() {

    fun login(phone:String,pwd:String){
        OkHttpUtils.instance.login(object : OkHttpUtils.IOkCallBack {
            override fun callSuccess(loginBean: LoginBean) {
                getView()!!.loginSuccess(loginBean)
            }
        },phone,pwd)
    }
}
