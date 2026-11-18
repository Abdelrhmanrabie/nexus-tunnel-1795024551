package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public final int[] b;
    public final ArrayList c;
    public final int[] d;
    public final int[] f;
    public final int g;
    public final String i;
    public final int j;
    public final int n;
    public final CharSequence o;
    public final int p;
    public final CharSequence q;
    public final ArrayList r;
    public final ArrayList s;
    public final boolean t;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        public final b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(Parcel parcel) {
        this.b = parcel.createIntArray();
        this.c = parcel.createStringArrayList();
        this.d = parcel.createIntArray();
        this.f = parcel.createIntArray();
        this.g = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readInt();
        this.n = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.o = (CharSequence) creator.createFromParcel(parcel);
        this.p = parcel.readInt();
        this.q = (CharSequence) creator.createFromParcel(parcel);
        this.r = parcel.createStringArrayList();
        this.s = parcel.createStringArrayList();
        this.t = parcel.readInt() != 0;
    }

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.a.size();
        this.b = new int[size * 6];
        if (!aVar.g) {
            defpackage.d.AnonymousClass0.m("Not on back stack");
            throw null;
        }
        this.c = new ArrayList(size);
        this.d = new int[size];
        this.f = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            w.a aVar2 = (w.a) aVar.a.get(i2);
            int i3 = i + 1;
            this.b[i] = aVar2.a;
            ArrayList arrayList = this.c;
            Fragment fragment = aVar2.b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.b;
            iArr[i3] = aVar2.c ? 1 : 0;
            iArr[i + 2] = aVar2.d;
            iArr[i + 3] = aVar2.e;
            int i4 = i + 5;
            iArr[i + 4] = aVar2.f;
            i += 6;
            iArr[i4] = aVar2.g;
            this.d[i2] = aVar2.h.ordinal();
            this.f[i2] = aVar2.i.ordinal();
        }
        this.g = aVar.f;
        this.i = aVar.i;
        this.j = aVar.s;
        this.n = aVar.j;
        this.o = aVar.k;
        this.p = aVar.l;
        this.q = aVar.m;
        this.r = aVar.n;
        this.s = aVar.o;
        this.t = aVar.p;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.b);
        parcel.writeStringList(this.c);
        parcel.writeIntArray(this.d);
        parcel.writeIntArray(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.n);
        TextUtils.writeToParcel(this.o, parcel, 0);
        parcel.writeInt(this.p);
        TextUtils.writeToParcel(this.q, parcel, 0);
        parcel.writeStringList(this.r);
        parcel.writeStringList(this.s);
        parcel.writeInt(this.t ? 1 : 0);
    }
}
