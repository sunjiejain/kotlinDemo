package com.wd.health.kotlinlogin.presenter

import com.wd.health.kotlinlogin.model.IConstractView
import com.wd.health.kotlinlogin.model.OkHttpUtils
import com.wd.health.kotlinlogin.model.bean.RegisterBean

/**
 * date:2019/12/20
 * author:孙杰健(fdg)
 * function:
 */
class RegisterPresenter : BasePresenter<IConstractView.IRegisterView>() {

    fun register(phone:String, nickName:String,pwd:String){
        OkHttpUtils.instance.register(object : OkHttpUtils.IOkCallBackRegister {
            //注册
            override fun callRegisterSuccess(registerBean: RegisterBean) {
                getView()!!.registerSuccess(registerBean)
            }
        },phone,nickName,pwd)
    }

}