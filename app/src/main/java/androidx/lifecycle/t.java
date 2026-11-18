package androidx.lifecycle;

import android.app.Application;
import defpackage.be1;
import defpackage.cj;
import defpackage.r3;
import defpackage.xi0;
import defpackage.zd1;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class t {
    public final be1 a;
    public final b b;
    public final cj c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends c {
        public static a c;
        public final Application b;

        public a(Application application) {
            this.b = application;
        }

        @Override // androidx.lifecycle.t.c, androidx.lifecycle.t.b
        public final zd1 a(Class cls, xi0 xi0Var) {
            if (this.b != null) {
                return b(cls);
            }
            Application application = (Application) xi0Var.a.get(s.a);
            if (application != null) {
                return c(cls, application);
            }
            if (!r3.class.isAssignableFrom(cls)) {
                return super.b(cls);
            }
            defpackage.d.AnonymousClass0.m$2("CreationExtras must have an application by `APPLICATION_KEY`");
            return null;
        }

        @Override // androidx.lifecycle.t.c, androidx.lifecycle.t.b
        public final zd1 b(Class cls) {
            Application application = this.b;
            if (application != null) {
                return c(cls, application);
            }
            defpackage.d.AnonymousClass0.m$3("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
            return null;
        }

        public final zd1 c(Class cls, Application application) {
            if (!r3.class.isAssignableFrom(cls)) {
                return super.b(cls);
            }
            try {
                return (zd1) cls.getConstructor(Application.class).newInstance(application);
            } catch (IllegalAccessException e) {
                defpackage.d.AnonymousClass0.m("Cannot create an instance of ", (Object) cls, (Throwable) e);
                return null;
            } catch (InstantiationException e2) {
                defpackage.d.AnonymousClass0.m("Cannot create an instance of ", (Object) cls, (Throwable) e2);
                return null;
            } catch (NoSuchMethodException e3) {
                defpackage.d.AnonymousClass0.m("Cannot create an instance of ", (Object) cls, (Throwable) e3);
                return null;
            } catch (InvocationTargetException e4) {
                defpackage.d.AnonymousClass0.m("Cannot create an instance of ", (Object) cls, (Throwable) e4);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface b {
        zd1 a(Class cls, xi0 xi0Var);

        zd1 b(Class cls);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c implements b {
        public static c a;

        @Override // androidx.lifecycle.t.b
        public zd1 a(Class cls, xi0 xi0Var) {
            return b(cls);
        }

        @Override // androidx.lifecycle.t.b
        public zd1 b(Class cls) {
            try {
                return (zd1) cls.getDeclaredConstructor(null).newInstance(null);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e) {
                defpackage.d.AnonymousClass0.m("Cannot create an instance of ", (Object) cls, e);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class d {
        public void c(zd1 zd1Var) {
        }
    }

    public t(be1 be1Var, b bVar) {
        this(be1Var, bVar, cj.a.b);
    }

    public t(be1 be1Var, b bVar, cj cjVar) {
        this.a = be1Var;
        this.b = bVar;
        this.c = cjVar;
    }

    public final zd1 a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b(cls, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
        }
        defpackage.d.AnonymousClass0.m$2("Local and anonymous classes can not be ViewModels");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final zd1 b(Class cls, String str) {
        zd1 zd1VarB;
        be1 be1Var = this.a;
        be1Var.getClass();
        LinkedHashMap linkedHashMap = be1Var.a;
        zd1 zd1Var = (zd1) linkedHashMap.get(str);
        boolean zIsInstance = cls.isInstance(zd1Var);
        b bVar = this.b;
        if (zIsInstance) {
            d dVar = bVar instanceof d ? (d) bVar : null;
            if (dVar != null) {
                dVar.c(zd1Var);
            }
            return zd1Var;
        }
        xi0 xi0Var = new xi0(this.c);
        xi0Var.a.put(u.a, str);
        try {
            zd1VarB = bVar.a(cls, xi0Var);
        } catch (AbstractMethodError unused) {
            zd1VarB = bVar.b(cls);
        }
        zd1 zd1Var2 = (zd1) linkedHashMap.put(str, zd1VarB);
        if (zd1Var2 != null) {
            zd1Var2.onCleared();
        }
        return zd1VarB;
    }
}
