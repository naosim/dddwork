package com.naosim.dddwork.service

import com.naosim.dddwork.domain.work.record.WorkRecordRepository
import com.naosim.dddwork.domain.work.rule.WorkPerformance
import com.naosim.dddwork.domain.work.rule.WorkRule
import java.time.YearMonth

class TotalService(val workRecordRepository: WorkRecordRepository) {
    val workRule = WorkRule()
    fun record(yearMonth: YearMonth): WorkPerformance {
        val workRecordList = workRecordRepository.find(yearMonth)

        val totalWorkPerformance = workRecordList
                .map { workRule.calcWorkPerformance(it) }
                .reduce(WorkPerformance::plus)

        return totalWorkPerformance
    }
}
