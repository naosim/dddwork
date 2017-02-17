package com.naosim.dddwork.domain.work.rule

import com.naosim.dddwork.domain.work.record.time.Time

// 残業時間
data class OverTime(override val value: Time): ScalarTime<OverTime> {
    override fun create(value: Time): OverTime {
        return OverTime(value)
    }
}
