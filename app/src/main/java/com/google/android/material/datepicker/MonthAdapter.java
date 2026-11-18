package com.google.android.material.datepicker;

import android.content.Context;
import android.icu.util.TimeZone;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class MonthAdapter extends BaseAdapter {
    public static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendarOf(null).getMaximum(4);
    public final CalendarConstraints calendarConstraints;
    public CalendarStyle calendarStyle;
    public final DateSelector dateSelector;
    public final Month month;
    public Collection previouslySelectedDates;

    public MonthAdapter(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.month = month;
        this.dateSelector = dateSelector;
        this.calendarConstraints = calendarConstraints;
        this.previouslySelectedDates = dateSelector.getSelectedDays();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        Month month = this.month;
        return month.daysInMonth + month.daysFromStartOfWeekToFirstOfMonth();
    }

    @Override // android.widget.Adapter
    public final Long getItem(int i) {
        Month month = this.month;
        if (i < month.daysFromStartOfWeekToFirstOfMonth() || i > lastPositionInMonth()) {
            return null;
        }
        return Long.valueOf(month.getDay((i - month.daysFromStartOfWeekToFirstOfMonth()) + 1));
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i / this.month.daysInWeek;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        DateFormat format;
        Date date;
        android.icu.text.DateFormat instanceForSkeleton;
        Date date2;
        CharSequence charSequence;
        Context context = viewGroup.getContext();
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dd, viewGroup, false);
        }
        Month month = this.month;
        int iDaysFromStartOfWeekToFirstOfMonth = i - month.daysFromStartOfWeekToFirstOfMonth();
        if (iDaysFromStartOfWeekToFirstOfMonth < 0 || iDaysFromStartOfWeekToFirstOfMonth >= month.daysInMonth) {
            textView.setVisibility(8);
            textView.setEnabled(false);
        } else {
            int i2 = iDaysFromStartOfWeekToFirstOfMonth + 1;
            textView.setTag(month);
            textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i2)));
            long day = month.getDay(i2);
            if (month.year == Month.current().year) {
                Locale locale = Locale.getDefault();
                if (Build.VERSION.SDK_INT >= 24) {
                    instanceForSkeleton = android.icu.text.DateFormat.getInstanceForSkeleton("MMMEd", locale);
                    instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
                    date2 = new Date(day);
                    charSequence = instanceForSkeleton.format(date2);
                } else {
                    format = UtcDates.getFormat(0, locale);
                    date = new Date(day);
                    charSequence = format.format(date);
                }
            } else {
                Locale locale2 = Locale.getDefault();
                if (Build.VERSION.SDK_INT >= 24) {
                    instanceForSkeleton = android.icu.text.DateFormat.getInstanceForSkeleton("yMMMEd", locale2);
                    instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
                    date2 = new Date(day);
                    charSequence = instanceForSkeleton.format(date2);
                } else {
                    format = UtcDates.getFormat(0, locale2);
                    date = new Date(day);
                    charSequence = format.format(date);
                }
            }
            textView.setContentDescription(charSequence);
            textView.setVisibility(0);
            textView.setEnabled(true);
        }
        Long item = getItem(i);
        if (item == null) {
            return textView;
        }
        updateSelectedState(textView, item.longValue());
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }

    public final int lastPositionInMonth() {
        Month month = this.month;
        return (month.daysFromStartOfWeekToFirstOfMonth() + month.daysInMonth) - 1;
    }

    public final void updateSelectedState(TextView textView, long j) {
        CalendarItemStyle calendarItemStyle;
        if (textView == null) {
            return;
        }
        if (this.calendarConstraints.validator.isValid(j)) {
            textView.setEnabled(true);
            Iterator it = this.dateSelector.getSelectedDays().iterator();
            while (it.hasNext()) {
                if (UtcDates.canonicalYearMonthDay(j) == UtcDates.canonicalYearMonthDay(((Long) it.next()).longValue())) {
                    calendarItemStyle = this.calendarStyle.selectedDay;
                }
            }
            long timeInMillis = UtcDates.getTodayCalendar().getTimeInMillis();
            CalendarStyle calendarStyle = this.calendarStyle;
            calendarItemStyle = timeInMillis == j ? calendarStyle.todayDay : calendarStyle.day;
        } else {
            textView.setEnabled(false);
            calendarItemStyle = this.calendarStyle.invalidDay;
        }
        calendarItemStyle.styleItem(textView);
    }

    public final void updateSelectedStateForDate(MaterialCalendarGridView materialCalendarGridView, long j) {
        Month monthCreate = Month.create(j);
        Month month = this.month;
        if (monthCreate.equals(month)) {
            Calendar dayCopy = UtcDates.getDayCopy(month.firstOfMonth);
            dayCopy.setTimeInMillis(j);
            updateSelectedState((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.getAdapter().month.daysFromStartOfWeekToFirstOfMonth() + (dayCopy.get(5) - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }
}
