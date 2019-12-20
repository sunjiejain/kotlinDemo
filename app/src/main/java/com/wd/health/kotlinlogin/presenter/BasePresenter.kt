package com.wd.health.kotlinlogin.presenter

import com.wd.health.kotlinlogin.IBaseView



/**
 * date:2019/12/20
 * author:孙杰健(fdg)
 * function:
 */
open class BasePresenter<V : IBaseView> {
    private var mView: V? = null

    fun attachView(v: V) {
        this.mView = v
    }

    fun detachView() {
        this.mView = null
    }

    fun getView(): V? {
        return mView
    }
}