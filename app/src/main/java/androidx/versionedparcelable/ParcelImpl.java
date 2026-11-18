package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.d;
import defpackage.id1;
import defpackage.jd1;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();
    public final jd1 b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a implements Parcelable.Creator<ParcelImpl> {
        @Override // android.os.Parcelable.Creator
        public final ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    }

    public ParcelImpl(Parcel parcel) {
        id1 id1Var = new id1(parcel);
        String string = id1Var.e.readString();
        jd1 jd1Var = null;
        if (string != null) {
            try {
                jd1Var = (jd1) id1Var.c(string).invoke(null, id1Var.a());
            } catch (ClassNotFoundException e) {
                d.AnonymousClass0.m$1("VersionedParcel encountered ClassNotFoundException", (Throwable) e);
                throw null;
            } catch (IllegalAccessException e2) {
                d.AnonymousClass0.m$1("VersionedParcel encountered IllegalAccessException", (Throwable) e2);
                throw null;
            } catch (NoSuchMethodException e3) {
                d.AnonymousClass0.m$1("VersionedParcel encountered NoSuchMethodException", (Throwable) e3);
                throw null;
            } catch (InvocationTargetException e4) {
                if (e4.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e4.getCause());
                }
                d.AnonymousClass0.m$1("VersionedParcel encountered InvocationTargetException", (Throwable) e4);
                throw null;
            }
        }
        this.b = jd1Var;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        id1 id1Var = new id1(parcel);
        Parcel parcel2 = id1Var.e;
        jd1 jd1Var = this.b;
        if (jd1Var == null) {
            parcel2.writeString(null);
            return;
        }
        try {
            parcel2.writeString(id1Var.b(jd1Var.getClass()).getName());
            id1 id1VarA = id1Var.a();
            try {
                id1Var.d(jd1Var.getClass()).invoke(null, jd1Var, id1VarA);
                int i2 = id1VarA.i;
                if (i2 >= 0) {
                    int i3 = id1VarA.d.get(i2);
                    Parcel parcel3 = id1VarA.e;
                    int iDataPosition = parcel3.dataPosition();
                    parcel3.setDataPosition(i3);
                    parcel3.writeInt(iDataPosition - i3);
                    parcel3.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e) {
                d.AnonymousClass0.m$1("VersionedParcel encountered ClassNotFoundException", (Throwable) e);
            } catch (IllegalAccessException e2) {
                d.AnonymousClass0.m$1("VersionedParcel encountered IllegalAccessException", (Throwable) e2);
            } catch (NoSuchMethodException e3) {
                d.AnonymousClass0.m$1("VersionedParcel encountered NoSuchMethodException", (Throwable) e3);
            } catch (InvocationTargetException e4) {
                if (e4.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e4.getCause());
                }
                d.AnonymousClass0.m$1("VersionedParcel encountered InvocationTargetException", (Throwable) e4);
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(jd1Var.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }
}
