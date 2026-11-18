package kotlin.jvm.internal;

import defpackage.a90;
import defpackage.o90;
import defpackage.ou0;
import java.io.Serializable;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements a90, Serializable {
    public final boolean isTopLevel;
    public final String name;
    public final Class owner;
    public final Object receiver;
    public transient a90 reflected;
    public final String signature;

    /* JADX INFO: renamed from: kotlin.jvm.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class C0035a implements Serializable {
        public static final C0035a b = new C0035a();
    }

    public a(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    public a90 compute() {
        a90 a90Var = this.reflected;
        if (a90Var != null) {
            return a90Var;
        }
        a90 a90VarComputeReflected = computeReflected();
        this.reflected = a90VarComputeReflected;
        return a90VarComputeReflected;
    }

    public abstract a90 computeReflected();

    @Override // defpackage.a90
    public String getName() {
        return this.name;
    }

    public o90 getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? ou0.a.c(cls, AppConfig.CUSTOM) : ou0.a.b(cls);
    }

    public String getSignature() {
        return this.signature;
    }
}
