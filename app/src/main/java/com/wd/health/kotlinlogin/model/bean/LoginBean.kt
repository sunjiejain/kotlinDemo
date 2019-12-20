package com.wd.health.kotlinlogin.model.bean

/**
 * date:2019/12/20
 * author:孙杰健(fdg)
 * function:
 */
class LoginBean {
    /**
     * result : {"headPic":"http://172.17.8.100/images/tech/default/tech.jpg","nickName":"秋风扫落叶","phone":"15711497176","pwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","sessionId":"1576808975936960","userId":960,"userName":"Vvcjzx15711497176","whetherFaceId":0,"whetherVip":2}
     * message : 登录成功
     * status : 0000
     */

    private var result: ResultBean? = null
    private var message: String? = null
    private var status: String? = null

    fun getResult(): ResultBean? {
        return result
    }

    fun setResult(result: ResultBean) {
        this.result = result
    }

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

    class ResultBean {
        /**
         * headPic : http://172.17.8.100/images/tech/default/tech.jpg
         * nickName : 秋风扫落叶
         * phone : 15711497176
         * pwd : R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=
         * sessionId : 1576808975936960
         * userId : 960
         * userName : Vvcjzx15711497176
         * whetherFaceId : 0
         * whetherVip : 2
         */

        var headPic: String? = null
        var nickName: String? = null
        var phone: String? = null
        var pwd: String? = null
        var sessionId: String? = null
        var userId: Int = 0
        var userName: String? = null
        var whetherFaceId: Int = 0
        var whetherVip: Int = 0
    }
}