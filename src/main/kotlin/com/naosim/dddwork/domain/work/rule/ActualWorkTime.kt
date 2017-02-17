package com.naosim.dddwork.domain.work.rule

import com.naosim.dddwork.domain.work.record.time.Time

// 実働時間 休憩時間を除いた働いた時間
data class ActualWorkTime(override val value: Time): ScalarTime<ActualWorkTime> {
    override fun create(value: Time): ActualWorkTime {
        return ActualWorkTime(value)
    }
}
