package com.naosim.dddwork.domain.work.record.time

data class Time(val hour: Hour, val minute: Minute) {
    val totalMinute = TotalMinute(hour.totalMinute.value + minute.totalMinute.value)
    fun minus(other: Time): Time {
        return totalMinute.minus(other.totalMinute).time
    }

    fun plus(other: Time): Time {
        return totalMinute.plus(other.totalMinute).time
    }
}
