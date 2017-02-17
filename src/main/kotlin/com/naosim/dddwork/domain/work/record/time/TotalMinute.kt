package com.naosim.dddwork.domain.work.record.time

data class TotalMinute(val value: Int) {
    val time: Time
        get() {
            val h = Hour(value / 60)
            val m = Minute(value - h.totalMinute.value)
            return Time(h, m)
        }

    fun minus(other: TotalMinute): TotalMinute {
        return TotalMinute(this.value - other.value)
    }

    fun plus(other: TotalMinute): TotalMinute {
        return TotalMinute(this.value + other.value)
    }
}
