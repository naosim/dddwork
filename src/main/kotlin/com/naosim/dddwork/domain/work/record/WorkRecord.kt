package com.naosim.dddwork.domain.work.record


data class WorkRecord(
        val recordDate: RecordDate,// ID
        val startTime: StartTime,
        val endTime: EndTime
)

