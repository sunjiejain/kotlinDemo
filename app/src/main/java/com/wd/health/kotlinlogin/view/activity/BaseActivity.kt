package com.wd.health.kotlinlogin.view.activity

import android.app.Activity
import android.os.Bundle

/**
 * date:2019/12/20
 * author:孙杰健(fdg)
 * function:
 */
open class BaseActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindLayout())
        initView()
        initData()
    }

    open fun initData() {

    }

    open fun initView() {

    }

    open fun bindLayout(): Int {
        return 0
    }
}