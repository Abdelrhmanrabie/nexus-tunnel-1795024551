package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.b;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class f8 implements Parcelable {
    public static final Parcelable.Creator<f8> CREATOR = new a(0);
    public final ArrayList b;
    public final ArrayList c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Parcelable.Creator {
        public final /* synthetic */ int G0;

        public /* synthetic */ a(int i) {
            this.G0 = i;
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            int i = this.G0;
            if (i == 0) {
                return new f8(parcel);
            }
            if (i == 1) {
                e6.e eVar = new e6.e(parcel);
                eVar.b = parcel.readByte() != 0;
                return eVar;
            }
            if (i == 2) {
                return new g30((IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader()), (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            }
            return new j2(parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            int i2 = this.G0;
            if (i2 == 0) {
                return new f8[i];
            }
            if (i2 != 1) {
                return i2 != 2 ? new j2[i] : new g30[i];
            }
            return new e6.e[i];
        }
    }

    public f8(Parcel parcel) {
        this.b = parcel.createStringArrayList();
        this.c = parcel.createTypedArrayList(b.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.b);
        parcel.writeTypedList(this.c);
    }
}
