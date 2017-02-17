package com.naosim.dddwork.api

import com.naosim.dddwork.datasource.work.record.WorkRecordRepositoryIO
import com.naosim.dddwork.lib.Api
import com.naosim.dddwork.lib.IOConverter
import com.naosim.dddwork.service.TotalService
import java.time.YearMonth

class TotalApi : Api<YearMonth> {
    override val methodType = "total"

    val workRecordRepository = WorkRecordRepositoryIO()
    val totalService = TotalService(workRecordRepository)

    override fun createRequest(args: Array<String>): YearMonth {
        val yearMonth = args[1]
        if (args.size < 2) {
            throw RuntimeException("引数が足りません")
        }
        return IOConverter.convertToYearMonth(yearMonth)
    }

    override fun invoke(yearMonth: YearMonth) {
        val workPerformance = totalService.record(yearMonth)
        println("勤務時間: %02d時間%02d分".format(workPerformance.actualWorkTime.value.hour.value, workPerformance.actualWorkTime.value.minute.value))
        println("残業時間: %02d時間%02d分".format(workPerformance.overTime.value.hour.value, workPerformance.overTime.value.minute.value))
    }


}
