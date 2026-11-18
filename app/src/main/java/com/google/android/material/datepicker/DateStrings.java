package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class DateStrings {
    private DateStrings() {
    }

    public static String getDateString$1(long j) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendarOf = UtcDates.getUtcCalendarOf(null);
        utcCalendarOf.setTimeInMillis(j);
        return todayCalendar.get(1) == utcCalendarOf.get(1) ? getMonthDay(j, Locale.getDefault()) : getYearMonthDay(j, Locale.getDefault());
    }

    public static String getMonthDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            AtomicReference atomicReference = UtcDates.timeSourceRef;
            DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("MMMd", locale);
            instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
            return instanceForSkeleton.format(new Date(j));
        }
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) UtcDates.getFormat(2, locale);
        String pattern = simpleDateFormat.toPattern();
        int iFindCharactersInDateFormatPattern = UtcDates.findCharactersInDateFormatPattern(1, 0, pattern, "yY");
        if (iFindCharactersInDateFormatPattern < pattern.length()) {
            int iFindCharactersInDateFormatPattern2 = UtcDates.findCharactersInDateFormatPattern(1, iFindCharactersInDateFormatPattern, pattern, "EMd");
            pattern = pattern.replace(pattern.substring(UtcDates.findCharactersInDateFormatPattern(-1, iFindCharactersInDateFormatPattern, pattern, iFindCharactersInDateFormatPattern2 < pattern.length() ? "EMd," : "EMd") + 1, iFindCharactersInDateFormatPattern2), " ").trim();
        }
        simpleDateFormat.applyPattern(pattern);
        return simpleDateFormat.format(new Date(j));
    }

    public static String getYearMonthDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT < 24) {
            return UtcDates.getFormat(2, locale).format(new Date(j));
        }
        AtomicReference atomicReference = UtcDates.timeSourceRef;
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMd", locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        return instanceForSkeleton.format(new Date(j));
    }
}
