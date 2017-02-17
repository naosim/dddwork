package com.naosim.dddwork.domain.work.record

import java.time.YearMonth

interface WorkRecordRepository {
    fun record(workRecord: WorkRecord)
    fun find(targetYearMonth: YearMonth): Array<WorkRecord>
}
