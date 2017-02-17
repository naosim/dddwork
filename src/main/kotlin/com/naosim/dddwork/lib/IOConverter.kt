package com.naosim.dddwork.lib

import com.naosim.dddwork.domain.work.record.time.Hour
import com.naosim.dddwork.domain.work.record.time.Minute
import com.naosim.dddwork.domain.work.record.time.Time
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class IOConverter {
    companion object {
        @JvmStatic fun convertToLocalDate(v: String): LocalDate {
            return LocalDate.from(DateTimeFormatter.ofPattern("yyyyMMdd").parse(v))
        }

        @JvmStatic fun convertToYearMonth(v: String): YearMonth {
            return YearMonth.from(DateTimeFormatter.ofPattern("yyyyMM").parse(v))
        }

        @JvmStatic fun convertToString(v: LocalDate): String {
            return v.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        }

        @JvmStatic fun convertToTime(h: String, m: String): Time {
            return Time(Hour(h.toInt()), Minute(m.toInt()))
        }

        @JvmStatic fun convertToString(v: Time): String {
            return "%02d%02d".format(v.hour, v.minute)
        }

        @JvmStatic fun convertToTime(hm: String): Time {
            return convertToTime(hm.substring(0, 2), hm.substring(2, 4))
        }
    }
}


