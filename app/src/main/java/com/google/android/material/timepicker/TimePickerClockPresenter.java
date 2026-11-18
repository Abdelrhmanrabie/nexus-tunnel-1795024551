package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcelable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import defpackage.qd1;
import java.util.Locale;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.OnSelectionChange, TimePickerView.OnPeriodChangeListener, ClockHandView.OnActionUpListener, TimePickerPresenter {
    public boolean broadcasting = false;
    public float hourRotation;
    public float minuteRotation;
    public final TimeModel time;
    public final TimePickerView timePickerView;
    public static final String[] HOUR_CLOCK_VALUES = {"12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    public static final String[] HOUR_CLOCK_24_VALUES = {"00", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};
    public static final String[] MINUTE_CLOCK_VALUES = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    public TimePickerClockPresenter(TimePickerView timePickerView, TimeModel timeModel) {
        this.timePickerView = timePickerView;
        this.time = timeModel;
        if (timeModel.format == 0) {
            timePickerView.toggle.setVisibility(0);
        }
        timePickerView.clockHandView.listeners.add(this);
        timePickerView.onSelectionChangeListener = this;
        timePickerView.onPeriodChangeListener = this;
        timePickerView.clockHandView.onActionUpListener = this;
        updateValues(HOUR_CLOCK_VALUES, "%d");
        updateValues(HOUR_CLOCK_24_VALUES, "%d");
        updateValues(MINUTE_CLOCK_VALUES, "%02d");
        invalidate();
    }

    public final int getDegreesPerHour() {
        return this.time.format == 1 ? 15 : 30;
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public final void hide() {
        this.timePickerView.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public final void invalidate() {
        TimeModel timeModel = this.time;
        this.hourRotation = timeModel.getHourForDisplay() * getDegreesPerHour();
        this.minuteRotation = timeModel.minute * 6;
        setSelection(timeModel.selection, false);
        updateTime();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public final void onRotate(float f, boolean z) {
        if (this.broadcasting) {
            return;
        }
        TimeModel timeModel = this.time;
        int i = timeModel.hour;
        int i2 = timeModel.minute;
        int iRound = Math.round(f);
        if (timeModel.selection == 12) {
            int i3 = ((iRound + 3) / 6) % 60;
            timeModel.minute = i3;
            this.minuteRotation = (float) Math.floor(i3 * 6);
        } else {
            timeModel.setHour(((getDegreesPerHour() / 2) + iRound) / getDegreesPerHour());
            this.hourRotation = timeModel.getHourForDisplay() * getDegreesPerHour();
        }
        if (z) {
            return;
        }
        updateTime();
        if (timeModel.minute == i2 && timeModel.hour == i) {
            return;
        }
        this.timePickerView.performHapticFeedback(4);
    }

    public final void setSelection(int i, boolean z) {
        String[] strArr;
        boolean z2 = i == 12;
        TimePickerView timePickerView = this.timePickerView;
        ClockHandView clockHandView = timePickerView.clockHandView;
        Chip chip = timePickerView.hourView;
        Chip chip2 = timePickerView.minuteView;
        clockHandView.animatingOnTouchUp = z2;
        TimeModel timeModel = this.time;
        timeModel.selection = i;
        if (z2) {
            strArr = MINUTE_CLOCK_VALUES;
        } else {
            strArr = timeModel.format == 1 ? HOUR_CLOCK_24_VALUES : HOUR_CLOCK_VALUES;
        }
        timePickerView.clockFace.setValues(strArr, z2 ? R.string.h6 : R.string.h4);
        timePickerView.clockHandView.setHandRotation(z2 ? this.minuteRotation : this.hourRotation, z);
        chip2.setChecked(i == 12);
        chip.setChecked(i == 10);
        qd1.l(chip, new ClickActionDelegate(timePickerView.getContext(), R.string.h3));
        qd1.l(chip2, new ClickActionDelegate(timePickerView.getContext(), R.string.h5));
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public final void show() {
        this.timePickerView.setVisibility(0);
    }

    public final void updateTime() {
        MaterialButton materialButton;
        TimeModel timeModel = this.time;
        int i = timeModel.period;
        int hourForDisplay = timeModel.getHourForDisplay();
        int i2 = timeModel.minute;
        TimePickerView timePickerView = this.timePickerView;
        timePickerView.getClass();
        int i3 = i == 1 ? R.attr.q5 : R.attr.q4;
        MaterialButtonToggleGroup materialButtonToggleGroup = timePickerView.toggle;
        if (i3 != materialButtonToggleGroup.checkedId && (materialButton = (MaterialButton) materialButtonToggleGroup.findViewById(i3)) != null) {
            materialButton.setChecked(true);
        }
        Locale locale = timePickerView.getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(i2));
        String str2 = String.format(locale, "%02d", Integer.valueOf(hourForDisplay));
        timePickerView.minuteView.setText(str);
        timePickerView.hourView.setText(str2);
    }

    public final void updateValues(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            Resources resources = this.timePickerView.getResources();
            String str2 = strArr[i];
            Parcelable.Creator<TimeModel> creator = TimeModel.CREATOR;
            strArr[i] = String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(str2))));
        }
    }
}
