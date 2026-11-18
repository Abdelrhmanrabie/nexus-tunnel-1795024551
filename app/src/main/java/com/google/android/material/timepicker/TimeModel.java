package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new Parcelable.Creator<TimeModel>() { // from class: com.google.android.material.timepicker.TimeModel.1
        @Override // android.os.Parcelable.Creator
        public final TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final TimeModel[] newArray(int i) {
            return new TimeModel[i];
        }
    };
    public final int format;
    public int hour;
    public final MaxInputValidator hourInputValidator;
    public int minute;
    public final MaxInputValidator minuteInputValidator;
    public int period;
    public int selection;

    public TimeModel() {
        this(0);
    }

    public TimeModel(int i) {
        this(0, 0, 10, i);
    }

    public TimeModel(int i, int i2, int i3, int i4) {
        this.hour = i;
        this.minute = i2;
        this.selection = i3;
        this.format = i4;
        this.period = i >= 12 ? 1 : 0;
        this.minuteInputValidator = new MaxInputValidator(59);
        this.hourInputValidator = new MaxInputValidator(i4 == 1 ? 24 : 12);
    }

    public TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.hour == timeModel.hour && this.minute == timeModel.minute && this.format == timeModel.format && this.selection == timeModel.selection;
    }

    public final int getHourForDisplay() {
        int i = this.hour;
        if (this.format == 1) {
            return i % 24;
        }
        if (i % 12 == 0) {
            return 12;
        }
        return this.period == 1 ? i - 12 : i;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.format), Integer.valueOf(this.hour), Integer.valueOf(this.minute), Integer.valueOf(this.selection)});
    }

    public final void setHour(int i) {
        if (this.format == 1) {
            this.hour = i;
        } else {
            this.hour = (i % 12) + (this.period != 1 ? 0 : 12);
        }
    }

    public final void setPeriod(int i) {
        int i2;
        if (i != this.period) {
            this.period = i;
            int i3 = this.hour;
            if (i3 < 12 && i == 1) {
                i2 = i3 + 12;
            } else if (i3 < 12 || i != 0) {
                return;
            } else {
                i2 = i3 - 12;
            }
            this.hour = i2;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minute);
        parcel.writeInt(this.selection);
        parcel.writeInt(this.format);
    }
}
