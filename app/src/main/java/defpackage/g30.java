package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g30 implements Parcelable {
    public static final Parcelable.Creator<g30> CREATOR = new f8.a(2);
    public final IntentSender b;
    public final Intent c;
    public final int d;
    public final int f;

    public g30(IntentSender intentSender, Intent intent, int i, int i2) {
        this.b = intentSender;
        this.c = intent;
        this.d = i;
        this.f = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
        parcel.writeInt(this.d);
        parcel.writeInt(this.f);
    }
}
