package com.naosim.dddwork.domain.work.rule

import com.naosim.dddwork.domain.work.record.WorkRecord
import com.naosim.dddwork.domain.work.record.time.Hour
import com.naosim.dddwork.domain.work.record.time.Minute
import com.naosim.dddwork.domain.work.record.time.Time

class WorkRule {
    fun calcWorkPerformance(workRecord: WorkRecord): WorkPerformance {
        return WorkPerformance(
                WorkTime(workRecord.endTime.value.minus(workRecord.startTime.value)),
                ActualWorkTime(workRecord.endTime.value.minus(workRecord.startTime.value)), //休憩なし
                OverTime(Time(Hour(0), Minute(0))) //サビなし
        )
    }
}
