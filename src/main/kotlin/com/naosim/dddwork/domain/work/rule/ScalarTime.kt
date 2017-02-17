package com.naosim.dddwork.domain.work.rule

import com.naosim.dddwork.domain.work.record.time.Time

interface ScalarTime<T> {
    val value: Time
    fun create(value: Time): T
    fun plus(other: ScalarTime<T>): T {
        return create(value.plus(other.value))
    }
}
