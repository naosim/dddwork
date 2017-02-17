package com.naosim.dddwork.datasource.work.record

import com.naosim.dddwork.datasource.CSVUtil
import com.naosim.dddwork.domain.work.record.*
import com.naosim.dddwork.lib.IOConverter
import java.io.File
import java.time.YearMonth

class WorkRecordRepositoryIO: WorkRecordRepository {
    val csvFile = File("data.csv")
    override fun record(workRecord: WorkRecord) {
        CSVUtil.insert(
                csvFile,
                IOConverter.convertToString(workRecord.recordDate.value),
                workRecord.startTime.value.hour.value,
                workRecord.startTime.value.minute.value,
                workRecord.endTime.value.hour.value,
                workRecord.endTime.value.minute.value
        )
    }

    override fun find(targetYearMonth: YearMonth): Array<WorkRecord> {
        return CSVUtil.get(csvFile).map {
            WorkRecord(
                    RecordDate(IOConverter.convertToLocalDate(it[0])),
                    StartTime(IOConverter.convertToTime(it[1], it[2])),
                    EndTime(IOConverter.convertToTime(it[3], it[4]))
            )
        }.toTypedArray()
    }
}
