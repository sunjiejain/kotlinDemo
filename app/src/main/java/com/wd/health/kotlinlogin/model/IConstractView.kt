package com.wd.health.kotlinlogin.model

import com.wd.health.kotlinlogin.IBaseView
import com.wd.health.kotlinlogin.model.bean.LoginBean
import com.wd.health.kotlinlogin.model.bean.RegisterBean


/**
 * date:2019/12/20
 * author:孙杰健(fdg)
 * function:
 */
interface IConstractView {

    //登录
    interface ILoginView : IBaseView {
        fun loginSuccess(loginBean:LoginBean)
    }

    //注册
    interface IRegisterView : IBaseView {
        fun registerSuccess(registerBean: RegisterBean)
    }
}