package com.naosim.dddwork.domain.work.record.time

data class Hour(val value: Int) {
    val totalMinute = TotalMinute(value * 60)
}
