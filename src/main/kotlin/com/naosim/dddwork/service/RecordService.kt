package com.naosim.dddwork.service

import com.naosim.dddwork.domain.work.record.WorkRecord
import com.naosim.dddwork.domain.work.record.WorkRecordRepository

class RecordService(val workRecordRepository: WorkRecordRepository) {
    fun record(workRecord: WorkRecord) {
        workRecordRepository.record(workRecord)
    }
}
