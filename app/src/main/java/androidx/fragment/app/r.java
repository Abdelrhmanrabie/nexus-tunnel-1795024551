package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.f8;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable {
    public static final Parcelable.Creator<r> CREATOR = new a();
    public ArrayList b;
    public ArrayList c;
    public b[] d;
    public int f;
    public String g;
    public final ArrayList i;
    public final ArrayList j;
    public ArrayList n;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Parcelable.Creator<r> {
        @Override // android.os.Parcelable.Creator
        public final r createFromParcel(Parcel parcel) {
            return new r(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final r[] newArray(int i) {
            return new r[i];
        }
    }

    public r() {
        this.g = null;
        this.i = new ArrayList();
        this.j = new ArrayList();
    }

    public r(Parcel parcel) {
        this.g = null;
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.b = parcel.createStringArrayList();
        this.c = parcel.createStringArrayList();
        this.d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.i = parcel.createStringArrayList();
        this.j = parcel.createTypedArrayList(f8.CREATOR);
        this.n = parcel.createTypedArrayList(q.k.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.b);
        parcel.writeStringList(this.c);
        parcel.writeTypedArray(this.d, i);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeStringList(this.i);
        parcel.writeTypedList(this.j);
        parcel.writeTypedList(this.n);
    }
}
