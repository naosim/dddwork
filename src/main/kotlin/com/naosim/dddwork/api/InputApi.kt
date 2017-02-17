package com.naosim.dddwork.api

import com.naosim.dddwork.datasource.work.record.WorkRecordRepositoryIO
import com.naosim.dddwork.domain.work.record.EndTime
import com.naosim.dddwork.domain.work.record.RecordDate
import com.naosim.dddwork.domain.work.record.StartTime
import com.naosim.dddwork.domain.work.record.WorkRecord
import com.naosim.dddwork.lib.Api
import com.naosim.dddwork.lib.IOConverter
import com.naosim.dddwork.service.RecordService

class InputApi : Api<WorkRecord> {
    override val methodType = "input"

    val workRecordRepository = WorkRecordRepositoryIO()
    val recordService = RecordService(workRecordRepository)


    override fun createRequest(args: Array<String>): WorkRecord {
        if (args.size < 4) {
            throw RuntimeException("引数が足りません")
        }
        val date = args[1]
        val start = args[2]
        val end = args[3]

        return WorkRecord(
                RecordDate(IOConverter.convertToLocalDate(date)),
                StartTime(IOConverter.convertToTime(start)),
                EndTime(IOConverter.convertToTime(end))
        )
    }

    override fun invoke(request: WorkRecord) {
        recordService.record(request)
    }


}
