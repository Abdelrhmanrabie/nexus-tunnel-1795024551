package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.mikephil.charting.data.Entry;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d00 implements Parcelable.Creator {
    public final /* synthetic */ int G0;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Entry entry = new Entry();
        entry.y = 0.0f;
        entry.mData = null;
        entry.x = 0.0f;
        entry.x = parcel.readFloat();
        entry.y = parcel.readFloat();
        if (parcel.readInt() == 1) {
            entry.mData = parcel.readParcelable(Object.class.getClassLoader());
        }
        return entry;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new Entry[i];
    }
}
