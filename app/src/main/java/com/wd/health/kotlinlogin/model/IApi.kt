package com.wd.health.kotlinlogin.model

import com.wd.health.kotlinlogin.model.bean.LoginBean
import com.wd.health.kotlinlogin.model.bean.RegisterBean
import okhttp3.ResponseBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable

/**
 * date:2019/12/20
 * author:孙杰健(fdg)
 * function:
 */
interface IApi {

    //登录
    @FormUrlEncoded
    @POST("techApi/user/v1/login")
    fun login(@Field("phone") phone:String,@Field("pwd") pwd:String) : Observable<LoginBean>

    //注册
    @FormUrlEncoded
    @POST("techApi/user/v1/register")
    fun register(@Field("phone") phone:String,@Field("nickName") nickName:String,@Field("pwd") pwd:String) : Observable<RegisterBean>
}