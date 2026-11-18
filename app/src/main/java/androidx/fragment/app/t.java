package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Parcelable {
    public static final Parcelable.Creator<t> CREATOR = new a();
    public final String b;
    public final String c;
    public final boolean d;
    public final int f;
    public final int g;
    public final String i;
    public final boolean j;
    public final boolean n;
    public final boolean o;
    public final Bundle p;
    public final boolean q;
    public final int r;
    public Bundle s;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Parcelable.Creator<t> {
        @Override // android.os.Parcelable.Creator
        public final t createFromParcel(Parcel parcel) {
            return new t(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final t[] newArray(int i) {
            return new t[i];
        }
    }

    public t(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readInt() != 0;
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readInt() != 0;
        this.n = parcel.readInt() != 0;
        this.o = parcel.readInt() != 0;
        this.p = parcel.readBundle();
        this.q = parcel.readInt() != 0;
        this.s = parcel.readBundle();
        this.r = parcel.readInt();
    }

    public t(Fragment fragment) {
        this.b = fragment.getClass().getName();
        this.c = fragment.mWho;
        this.d = fragment.mFromLayout;
        this.f = fragment.mFragmentId;
        this.g = fragment.mContainerId;
        this.i = fragment.mTag;
        this.j = fragment.mRetainInstance;
        this.n = fragment.mRemoving;
        this.o = fragment.mDetached;
        this.p = fragment.mArguments;
        this.q = fragment.mHidden;
        this.r = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.b);
        sb.append(" (");
        sb.append(this.c);
        sb.append(")}:");
        if (this.d) {
            sb.append(" fromLayout");
        }
        int i = this.g;
        if (i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i));
        }
        String str = this.i;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.j) {
            sb.append(" retainInstance");
        }
        if (this.n) {
            sb.append(" removing");
        }
        if (this.o) {
            sb.append(" detached");
        }
        if (this.q) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.i);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.n ? 1 : 0);
        parcel.writeInt(this.o ? 1 : 0);
        parcel.writeBundle(this.p);
        parcel.writeInt(this.q ? 1 : 0);
        parcel.writeBundle(this.s);
        parcel.writeInt(this.r);
    }
}
