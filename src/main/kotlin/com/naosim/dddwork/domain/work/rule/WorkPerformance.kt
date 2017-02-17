package com.naosim.dddwork.domain.work.rule

data class WorkPerformance(
        val workTime: WorkTime,
        val actualWorkTime: ActualWorkTime,
        val overTime: OverTime
) {
    fun plus(other: WorkPerformance): WorkPerformance {
        return WorkPerformance(
                workTime.plus(other.workTime),
                actualWorkTime.plus(other.actualWorkTime),
                overTime.plus(other.overTime)
        )
    }
}
