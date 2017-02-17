package com.naosim.dddwork.lib

interface Api<T> {
    val methodType: String
    fun createRequest(args: Array<String>): T
    fun invoke(request:T)

    fun run(args: Array<String>) {
        invoke(createRequest(args))
    }
}

