package defpackage;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class lf1 {
    public final WeakReference a;
    public final int b;

    public lf1(ClassLoader classLoader) {
        this.a = new WeakReference(classLoader);
        this.b = System.identityHashCode(classLoader);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof lf1) && this.a.get() == ((lf1) obj).a.get();
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        ClassLoader classLoader = (ClassLoader) this.a.get();
        return classLoader == null ? "<null>" : classLoader.toString();
    }
}
