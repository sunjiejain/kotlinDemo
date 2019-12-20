package com.wd.health.kotlinlogin.model

import com.wd.health.kotlinlogin.model.bean.LoginBean
import com.wd.health.kotlinlogin.model.bean.RegisterBean
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * date:2019/12/20
 * author:孙杰健(fdg)
 * function:
 */
class OkHttpUtils private constructor() {

    var iApi: IApi? = null

    //单例模式
    companion object {
        val instance: OkHttpUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            OkHttpUtils()
        }
    }

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .build();

        val retrofit: Retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://mobile.bwstudent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

        iApi = retrofit.create(IApi::class.java)
    }

    //登录
    fun login(iOkCallBack: IOkCallBack, phone: String, pwd: String) {
        val login = iApi!!.login(phone, pwd)
        login.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<LoginBean> {

                override fun onCompleted() {

                }

                override fun onError(e: Throwable) {

                }

                override fun onNext(loginBean: LoginBean) {
                    iOkCallBack!!.callSuccess(loginBean)
                }
            })
    }

    //注册
    fun register(
        iOkCallBack: IOkCallBackRegister, phone: String, nickName:String,
        pwd: String) {
        val register = iApi!!.register(phone, nickName, pwd)
        register.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<RegisterBean> {

                override fun onCompleted() {

                }

                override fun onError(e: Throwable) {

                }

                override fun onNext(registerBean: RegisterBean) {
                    iOkCallBack!!.callRegisterSuccess(registerBean)
                }
            })
    }

    open interface IOkCallBack {
        fun callSuccess(loginBean: LoginBean)
    }

    open interface IOkCallBackRegister {
        fun callRegisterSuccess(registerBean: RegisterBean)
    }
}