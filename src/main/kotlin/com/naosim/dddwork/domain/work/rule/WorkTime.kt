package com.naosim.dddwork.domain.work.rule

import com.naosim.dddwork.domain.work.record.time.Time

// 勤務時間 入室から退出まで
data class WorkTime(override val value: Time): ScalarTime<WorkTime> {
    override fun create(value: Time): WorkTime {
        return WorkTime(value)
    }
}
