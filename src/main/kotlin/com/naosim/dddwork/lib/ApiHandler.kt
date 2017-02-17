package com.naosim.dddwork.lib

import com.naosim.dddwork.api.InputApi
import com.naosim.dddwork.api.TotalApi

class ApiHandler {
    val apiList = arrayOf(// APIをここに追加する
            InputApi(), TotalApi()
    )
    fun handle(methodType: String, args: Array<String>) {
        apiList.filter { it.methodType == methodType }.last().run(args)
    }
}
