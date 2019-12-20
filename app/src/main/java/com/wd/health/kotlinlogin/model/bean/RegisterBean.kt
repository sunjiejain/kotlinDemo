package com.wd.health.kotlinlogin.model.bean

/**
 * date:2019/12/20
 * author:孙杰健(fdg)
 * function:
 */
class RegisterBean {
    /**
     * message : 注册成功
     * status : 0000
     */

    private var message: String? = null
    private var status: String? = null

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String) {
        this.message = message
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String) {
        this.status = status
    }
}