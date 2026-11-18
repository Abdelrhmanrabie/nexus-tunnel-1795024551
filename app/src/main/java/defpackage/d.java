package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import net.lingala.zip4j.exception.ZipException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements Parcelable {
    public final Parcelable mSuperState;
    public static final a EMPTY_STATE = new a();
    public static final Parcelable.Creator<d> CREATOR = new b();

    /* JADX INFO: renamed from: d$0, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final /* synthetic */ class AnonymousClass0 {
        public static /* synthetic */ void m() {
            throw new we(3);
        }

        public static /* synthetic */ void m(Object obj) {
            throw new IllegalArgumentException(obj.toString());
        }

        public static /* synthetic */ void m(String str) {
            throw new IllegalStateException(str);
        }

        public static /* synthetic */ void m(String str, int i, Object obj, int i2) throws IOException {
            throw new IOException(str + i + obj + i2 + ((Object) ")"));
        }

        public static /* synthetic */ void m(String str, Object obj) {
            throw new IllegalArgumentException(str + obj);
        }

        public static /* synthetic */ void m(String str, Object obj, Object obj2) {
            throw new IllegalStateException(str + obj + obj2);
        }

        public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3) {
            throw new yi(str + obj + obj2 + obj3 + ')');
        }

        public static /* synthetic */ void m(String str, Object obj, Throwable th) {
            throw new RuntimeException(str + obj, th);
        }

        public static /* synthetic */ void m(String str, Throwable th) throws IOException {
            throw new IOException(str, th);
        }

        public static /* synthetic */ void m$1() {
            throw new ClassCastException();
        }

        public static /* synthetic */ void m$1(String str) {
            throw new NullPointerException(str);
        }

        public static /* synthetic */ void m$1(String str, Object obj) {
            throw new IllegalStateException((str + obj).toString());
        }

        public static /* synthetic */ void m$1(String str, Object obj, Object obj2) {
            throw new IllegalArgumentException(str + obj + obj2);
        }

        public static /* synthetic */ void m$1(String str, Object obj, Object obj2, Object obj3) {
            throw new IllegalArgumentException(str + obj + obj2 + obj3);
        }

        public static /* synthetic */ void m$1(String str, Throwable th) {
            throw new RuntimeException(str, th);
        }

        public static /* synthetic */ void m$2(String str) {
            throw new IllegalArgumentException(str);
        }

        public static /* synthetic */ void m$2(String str, Object obj) {
            throw new RuntimeException(str + obj);
        }

        public static /* synthetic */ void m$3(String str) {
            throw new UnsupportedOperationException(str);
        }

        public static /* synthetic */ void m$3(String str, Object obj) {
            throw new IllegalStateException(str + obj);
        }

        public static /* synthetic */ void m$4(String str) {
            throw new IllegalArgumentException(str);
        }

        public static /* synthetic */ void m$5(String str) throws ZipException {
            throw new ZipException(str);
        }

        public static /* synthetic */ void m$6(String str) throws IOException {
            throw new IOException(str);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends d {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements Parcelable.ClassLoaderCreator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            if (parcel.readParcelable(null) == null) {
                return d.EMPTY_STATE;
            }
            AnonymousClass0.m("superState must be null");
            return null;
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return d.EMPTY_STATE;
            }
            AnonymousClass0.m("superState must be null");
            return null;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new d[i];
        }
    }

    public d() {
        this.mSuperState = null;
    }

    public d(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.mSuperState = parcelable == null ? EMPTY_STATE : parcelable;
    }

    public d(Parcelable parcelable) {
        if (parcelable != null) {
            this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
        } else {
            AnonymousClass0.m$2("superState must not be null");
            throw null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }
}
