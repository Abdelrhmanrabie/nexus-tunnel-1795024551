package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    public final CalendarConstraints constraints;
    public final DateFormat dateFormat;
    public final String outOfRange;
    public final Runnable setErrorCallback;
    public Runnable setRangeErrorCallback;
    public final TextInputLayout textInputLayout;

    public DateFormatTextWatcher(final String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.dateFormat = dateFormat;
        this.textInputLayout = textInputLayout;
        this.constraints = calendarConstraints;
        this.outOfRange = textInputLayout.getContext().getString(R.string.j5);
        this.setErrorCallback = new Runnable() { // from class: com.google.android.material.datepicker.DateFormatTextWatcher.1
            @Override // java.lang.Runnable
            public final void run() {
                DateFormatTextWatcher dateFormatTextWatcher = DateFormatTextWatcher.this;
                TextInputLayout textInputLayout2 = dateFormatTextWatcher.textInputLayout;
                DateFormat dateFormat2 = dateFormatTextWatcher.dateFormat;
                Context context = textInputLayout2.getContext();
                textInputLayout2.setError(context.getString(R.string.j0) + "\n" + String.format(context.getString(R.string.j2), str) + "\n" + String.format(context.getString(R.string.j1), dateFormat2.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis()))));
                dateFormatTextWatcher.onInvalidDate();
            }
        };
    }

    public void onInvalidDate() {
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        CalendarConstraints calendarConstraints = this.constraints;
        TextInputLayout textInputLayout = this.textInputLayout;
        Runnable runnable = this.setErrorCallback;
        textInputLayout.removeCallbacks(runnable);
        textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        textInputLayout.setError(null);
        onValidDate(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date date = this.dateFormat.parse(charSequence.toString());
            textInputLayout.setError(null);
            final long time = date.getTime();
            if (calendarConstraints.validator.isValid(time) && calendarConstraints.start.getDay(1) <= time) {
                Month month = calendarConstraints.end;
                if (time <= month.getDay(month.daysInMonth)) {
                    onValidDate(Long.valueOf(date.getTime()));
                    return;
                }
            }
            Runnable runnable2 = new Runnable() { // from class: com.google.android.material.datepicker.DateFormatTextWatcher.2
                @Override // java.lang.Runnable
                public final void run() {
                    DateFormatTextWatcher dateFormatTextWatcher = DateFormatTextWatcher.this;
                    dateFormatTextWatcher.textInputLayout.setError(String.format(dateFormatTextWatcher.outOfRange, DateStrings.getDateString$1(time)));
                    dateFormatTextWatcher.onInvalidDate();
                }
            };
            this.setRangeErrorCallback = runnable2;
            textInputLayout.postDelayed(runnable2, 1000L);
        } catch (ParseException unused) {
            textInputLayout.postDelayed(runnable, 1000L);
        }
    }

    public abstract void onValidDate(Long l);
}
