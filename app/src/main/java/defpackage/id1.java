package defpackage;

import android.os.Parcel;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class id1 {
    public final d7 a;
    public final d7 b;
    public final d7 c;
    public final SparseIntArray d;
    public final Parcel e;
    public final int f;
    public final int g;
    public final String h;
    public final int i;
    public final int j;

    public id1(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), AppConfig.CUSTOM, new d7(), new d7(), new d7());
    }

    public id1(Parcel parcel, int i, int i2, String str, d7 d7Var, d7 d7Var2, d7 d7Var3) {
        this.a = d7Var;
        this.b = d7Var2;
        this.c = d7Var3;
        this.d = new SparseIntArray();
        this.i = -1;
        this.e = parcel;
        this.f = i;
        this.g = i2;
        this.j = i;
        this.h = str;
    }

    public final id1 a() {
        Parcel parcel = this.e;
        int iDataPosition = parcel.dataPosition();
        int i = this.f;
        int i2 = this.j;
        if (i2 == i) {
            i2 = this.g;
        }
        return new id1(parcel, iDataPosition, i2, fb$1.m(new StringBuilder(), this.h, "  "), this.a, this.b, this.c);
    }

    public final Class b(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        d7 d7Var = this.c;
        Class cls2 = (Class) d7Var.getOrDefault(name, null);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        d7Var.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) throws NoSuchMethodException {
        d7 d7Var = this.a;
        Method method = (Method) d7Var.getOrDefault(str, null);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, id1.class.getClassLoader()).getDeclaredMethod("read", id1.class);
        d7Var.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method d(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        d7 d7Var = this.b;
        Method method = (Method) d7Var.getOrDefault(name, null);
        if (method != null) {
            return method;
        }
        Class clsB = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsB.getDeclaredMethod("write", cls, id1.class);
        d7Var.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }
}
