package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import defpackage.ko0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class RangeDateSelector implements DateSelector<ko0> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new Parcelable.Creator<RangeDateSelector>() { // from class: com.google.android.material.datepicker.RangeDateSelector.3
        @Override // android.os.Parcelable.Creator
        public final RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        public final RangeDateSelector[] newArray(int i) {
            return new RangeDateSelector[i];
        }
    };
    public String invalidRangeStartError;
    public Long selectedStartItem = null;
    public Long selectedEndItem = null;
    public Long proposedTextStart = null;
    public Long proposedTextEnd = null;

    public static void access$100(RangeDateSelector rangeDateSelector, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, OnSelectionChangedListener onSelectionChangedListener) {
        Long l = rangeDateSelector.proposedTextStart;
        if (l == null || rangeDateSelector.proposedTextEnd == null) {
            if (textInputLayout.getError() != null && rangeDateSelector.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
                textInputLayout.setError(null);
            }
            if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
                textInputLayout2.setError(null);
            }
            onSelectionChangedListener.onIncompleteSelectionChanged();
            return;
        }
        if (l.longValue() > rangeDateSelector.proposedTextEnd.longValue()) {
            textInputLayout.setError(rangeDateSelector.invalidRangeStartError);
            textInputLayout2.setError(" ");
            onSelectionChangedListener.onIncompleteSelectionChanged();
        } else {
            Long l2 = rangeDateSelector.proposedTextStart;
            rangeDateSelector.selectedStartItem = l2;
            Long l3 = rangeDateSelector.proposedTextEnd;
            rangeDateSelector.selectedEndItem = l3;
            onSelectionChangedListener.onSelectionChanged(new ko0(l2, l3));
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int getDefaultThemeResId(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return MaterialAttributes.resolveOrThrow(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.l2) ? R.style.ta : R.style.t0, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.selectedStartItem;
        if (l != null) {
            arrayList.add(l);
        }
        Long l2 = this.selectedEndItem;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList getSelectedRanges() {
        if (this.selectedStartItem == null || this.selectedEndItem == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ko0(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Object getSelection() {
        return new ko0(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String getSelectionDisplayString(Context context) {
        ko0 ko0Var;
        Resources resources = context.getResources();
        Long l = this.selectedStartItem;
        if (l == null && this.selectedEndItem == null) {
            return resources.getString(R.string.j_);
        }
        Long l2 = this.selectedEndItem;
        if (l2 == null) {
            return resources.getString(R.string.j7, DateStrings.getDateString$1(l.longValue()));
        }
        if (l == null) {
            return resources.getString(R.string.j6, DateStrings.getDateString$1(l2.longValue()));
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendarOf = UtcDates.getUtcCalendarOf(null);
        utcCalendarOf.setTimeInMillis(l.longValue());
        Calendar utcCalendarOf2 = UtcDates.getUtcCalendarOf(null);
        utcCalendarOf2.setTimeInMillis(l2.longValue());
        if (utcCalendarOf.get(1) == utcCalendarOf2.get(1)) {
            ko0Var = utcCalendarOf.get(1) == todayCalendar.get(1) ? new ko0(DateStrings.getMonthDay(l.longValue(), Locale.getDefault()), DateStrings.getMonthDay(l2.longValue(), Locale.getDefault())) : new ko0(DateStrings.getMonthDay(l.longValue(), Locale.getDefault()), DateStrings.getYearMonthDay(l2.longValue(), Locale.getDefault()));
        } else {
            ko0Var = new ko0(DateStrings.getYearMonthDay(l.longValue(), Locale.getDefault()), DateStrings.getYearMonthDay(l2.longValue(), Locale.getDefault()));
        }
        return resources.getString(R.string.j8, ko0Var.a, ko0Var.b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean isSelectionComplete() {
        Long l = this.selectedStartItem;
        return (l == null || this.selectedEndItem == null || l.longValue() > this.selectedEndItem.longValue()) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, final OnSelectionChangedListener onSelectionChangedListener) {
        View viewInflate = layoutInflater.inflate(R.layout.dz, viewGroup, false);
        final TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.attr.rv);
        final TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R.attr.ru);
        EditText editText = textInputLayout.editText;
        EditText editText2 = textInputLayout2.editText;
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = viewInflate.getResources().getString(R.string.j3);
        SimpleDateFormat textInputFormat = UtcDates.getTextInputFormat();
        Long l = this.selectedStartItem;
        if (l != null) {
            editText.setText(textInputFormat.format(l));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l2 = this.selectedEndItem;
        if (l2 != null) {
            editText2.setText(textInputFormat.format(l2));
            this.proposedTextEnd = this.selectedEndItem;
        }
        String textInputHint = UtcDates.getTextInputHint(viewInflate.getResources(), textInputFormat);
        textInputLayout.setPlaceholderText(textInputHint);
        textInputLayout2.setPlaceholderText(textInputHint);
        editText.addTextChangedListener(new DateFormatTextWatcher(textInputHint, textInputFormat, textInputLayout, calendarConstraints) { // from class: com.google.android.material.datepicker.RangeDateSelector.1
            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            public final void onInvalidDate() {
                RangeDateSelector rangeDateSelector = RangeDateSelector.this;
                rangeDateSelector.proposedTextStart = null;
                RangeDateSelector.access$100(rangeDateSelector, textInputLayout, textInputLayout2, onSelectionChangedListener);
            }

            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            public final void onValidDate(Long l3) {
                RangeDateSelector rangeDateSelector = RangeDateSelector.this;
                rangeDateSelector.proposedTextStart = l3;
                RangeDateSelector.access$100(rangeDateSelector, textInputLayout, textInputLayout2, onSelectionChangedListener);
            }
        });
        editText2.addTextChangedListener(new DateFormatTextWatcher(textInputHint, textInputFormat, textInputLayout2, calendarConstraints) { // from class: com.google.android.material.datepicker.RangeDateSelector.2
            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            public final void onInvalidDate() {
                RangeDateSelector rangeDateSelector = RangeDateSelector.this;
                rangeDateSelector.proposedTextEnd = null;
                RangeDateSelector.access$100(rangeDateSelector, textInputLayout, textInputLayout2, onSelectionChangedListener);
            }

            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            public final void onValidDate(Long l3) {
                RangeDateSelector rangeDateSelector = RangeDateSelector.this;
                rangeDateSelector.proposedTextEnd = l3;
                RangeDateSelector.access$100(rangeDateSelector, textInputLayout, textInputLayout2, onSelectionChangedListener);
            }
        });
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void select(long j) {
        Long l = this.selectedStartItem;
        if (l != null) {
            if (this.selectedEndItem == null && l.longValue() <= j) {
                this.selectedEndItem = Long.valueOf(j);
                return;
            }
            this.selectedEndItem = null;
        }
        this.selectedStartItem = Long.valueOf(j);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }
}
