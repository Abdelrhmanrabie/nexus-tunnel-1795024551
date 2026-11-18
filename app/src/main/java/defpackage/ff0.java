package defpackage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ff0 {
    public static final String d;
    public static final a e;
    public final s01 a;
    public final defpackage.e b;
    public final String c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends ff0 {
        @Override // defpackage.ff0
        public final c5 k(String str, Object obj) {
            return new c5(4, null, true);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends c {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c extends j {
        public final /* synthetic */ int G0 = 0;

        public c(ff0 ff0Var, ConcurrentHashMap concurrentHashMap) {
            super(ff0Var, concurrentHashMap, new mu(3));
        }

        public /* synthetic */ c(ff0 ff0Var, ConcurrentHashMap concurrentHashMap, nw nwVar) {
            super(ff0Var, concurrentHashMap, nwVar);
        }

        @Override // ff0.j, defpackage.nw
        public Object invoke(Object obj) throws Throwable {
            int i = this.G0;
            Object objInvoke = super.invoke(obj);
            if (i == 1 && objInvoke == null) {
                throw new IllegalStateException("@NotNull method kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke must not return null");
            }
            return objInvoke;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface d {
        public static final defpackage.e a = new defpackage.e(25);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class e {
        public final Object a;
        public final oc0 b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Object obj, lw lwVar) {
            this.a = obj;
            this.b = (oc0) lwVar;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && e.class == obj.getClass() && this.a.equals(((e) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class f implements lw {
        public final ff0 b;
        public final lw c;
        public volatile Object d;

        public f(ff0 ff0Var, lw lwVar) {
            if (ff0Var == null) {
                a(0);
                throw null;
            }
            this.d = l.b;
            this.b = ff0Var;
            this.c = lwVar;
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 2 || i == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 2 || i == 3) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i == 2 || i == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 2) {
                objArr[1] = "recursionDetected";
            } else if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i != 2 && i != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public void b(Object obj) {
        }

        public c5 c(boolean z) {
            c5 c5VarK = this.b.k("in a lazy value", null);
            if (c5VarK != null) {
                return c5VarK;
            }
            a(2);
            throw null;
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0031 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:19:0x0033 A[Catch: all -> 0x001b, TryCatch #1 {all -> 0x001b, blocks: (B:7:0x0011, B:9:0x0017, B:15:0x0023, B:17:0x002e, B:19:0x0033, B:21:0x003c, B:22:0x003f, B:27:0x0055, B:29:0x005b, B:31:0x005f, B:32:0x0066, B:33:0x006d, B:34:0x006e, B:35:0x0074, B:23:0x0041), top: B:40:0x0011, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:21:0x003c A[Catch: all -> 0x001b, TryCatch #1 {all -> 0x001b, blocks: (B:7:0x0011, B:9:0x0017, B:15:0x0023, B:17:0x002e, B:19:0x0033, B:21:0x003c, B:22:0x003f, B:27:0x0055, B:29:0x005b, B:31:0x005f, B:32:0x0066, B:33:0x006d, B:34:0x006e, B:35:0x0074, B:23:0x0041), top: B:40:0x0011, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x003f A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #1 {all -> 0x001b, blocks: (B:7:0x0011, B:9:0x0017, B:15:0x0023, B:17:0x002e, B:19:0x0033, B:21:0x003c, B:22:0x003f, B:27:0x0055, B:29:0x005b, B:31:0x005f, B:32:0x0066, B:33:0x006d, B:34:0x006e, B:35:0x0074, B:23:0x0041), top: B:40:0x0011, inners: #0 }] */
        @Override // defpackage.lw
        public Object invoke() throws Throwable {
            c5 c5VarC;
            Object obj = this.d;
            if (!(obj instanceof l)) {
                uh.a(obj);
                return obj;
            }
            this.b.a.lock();
            try {
                Object objInvoke = this.d;
                if (objInvoke instanceof l) {
                    l lVar = l.c;
                    l lVar2 = l.d;
                    if (objInvoke == lVar) {
                        this.d = lVar2;
                        c5 c5VarC2 = c(true);
                        if (!c5VarC2.f) {
                            objInvoke = c5VarC2.a;
                        } else if (objInvoke == lVar2) {
                            c5VarC = c(false);
                            if (c5VarC.f) {
                                this.d = lVar;
                                try {
                                    objInvoke = this.c.invoke();
                                    b(objInvoke);
                                    this.d = objInvoke;
                                } catch (Throwable th) {
                                    if (defpackage.e.X0(th)) {
                                        this.d = l.b;
                                        throw th;
                                    }
                                    if (this.d == lVar) {
                                        this.d = new zh1$b(th);
                                    }
                                    this.b.b.getClass();
                                    throw th;
                                }
                            } else {
                                objInvoke = c5VarC.a;
                            }
                        } else {
                            this.d = lVar;
                            objInvoke = this.c.invoke();
                            b(objInvoke);
                            this.d = objInvoke;
                        }
                    } else if (objInvoke == lVar2) {
                        c5VarC = c(false);
                        if (c5VarC.f) {
                            objInvoke = c5VarC.a;
                        } else {
                            this.d = lVar;
                            objInvoke = this.c.invoke();
                            b(objInvoke);
                            this.d = objInvoke;
                        }
                    } else {
                        this.d = lVar;
                        objInvoke = this.c.invoke();
                        b(objInvoke);
                        this.d = objInvoke;
                    }
                } else {
                    uh.a(objInvoke);
                }
                this.b.a.unlock();
                return objInvoke;
            } catch (Throwable th2) {
                this.b.a.unlock();
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class h extends f implements ml0 {
        @Override // ff0.f, defpackage.lw
        public final Object invoke() throws Throwable {
            Object objInvoke = super.invoke();
            if (objInvoke != null) {
                return objInvoke;
            }
            throw new IllegalStateException("@NotNull method kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue.invoke must not return null");
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class j implements nw {
        public final ff0 b;
        public final ConcurrentHashMap c;
        public final nw d;

        public j(ff0 ff0Var, ConcurrentHashMap concurrentHashMap, nw nwVar) {
            this.b = ff0Var;
            this.c = concurrentHashMap;
            this.d = nwVar;
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i == 3 || i == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 3) {
                objArr[1] = "recursionDetected";
            } else if (i != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i != 3 && i != 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 3 && i != 4) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public final AssertionError b(Object obj, Object obj2) {
            AssertionError assertionError = new AssertionError("Race condition detected on input " + obj + ". Old value is " + obj2 + " under " + this.b);
            ff0.l(assertionError);
            return assertionError;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0040 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:10:0x001d, B:13:0x0028, B:15:0x002e, B:17:0x0032, B:21:0x003a, B:22:0x003d, B:24:0x0040, B:26:0x0046, B:28:0x004a, B:29:0x004d, B:30:0x0050, B:32:0x0053, B:50:0x007c, B:54:0x0086, B:56:0x0091, B:57:0x0095, B:58:0x0096, B:59:0x0099, B:60:0x009a, B:61:0x009d, B:62:0x009e, B:63:0x00a3, B:39:0x005f, B:43:0x006c, B:47:0x0076, B:48:0x007a), top: B:66:0x001d, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:26:0x0046 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:10:0x001d, B:13:0x0028, B:15:0x002e, B:17:0x0032, B:21:0x003a, B:22:0x003d, B:24:0x0040, B:26:0x0046, B:28:0x004a, B:29:0x004d, B:30:0x0050, B:32:0x0053, B:50:0x007c, B:54:0x0086, B:56:0x0091, B:57:0x0095, B:58:0x0096, B:59:0x0099, B:60:0x009a, B:61:0x009d, B:62:0x009e, B:63:0x00a3, B:39:0x005f, B:43:0x006c, B:47:0x0076, B:48:0x007a), top: B:66:0x001d, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:28:0x004a A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:10:0x001d, B:13:0x0028, B:15:0x002e, B:17:0x0032, B:21:0x003a, B:22:0x003d, B:24:0x0040, B:26:0x0046, B:28:0x004a, B:29:0x004d, B:30:0x0050, B:32:0x0053, B:50:0x007c, B:54:0x0086, B:56:0x0091, B:57:0x0095, B:58:0x0096, B:59:0x0099, B:60:0x009a, B:61:0x009d, B:62:0x009e, B:63:0x00a3, B:39:0x005f, B:43:0x006c, B:47:0x0076, B:48:0x007a), top: B:66:0x001d, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:29:0x004d A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:10:0x001d, B:13:0x0028, B:15:0x002e, B:17:0x0032, B:21:0x003a, B:22:0x003d, B:24:0x0040, B:26:0x0046, B:28:0x004a, B:29:0x004d, B:30:0x0050, B:32:0x0053, B:50:0x007c, B:54:0x0086, B:56:0x0091, B:57:0x0095, B:58:0x0096, B:59:0x0099, B:60:0x009a, B:61:0x009d, B:62:0x009e, B:63:0x00a3, B:39:0x005f, B:43:0x006c, B:47:0x0076, B:48:0x007a), top: B:66:0x001d, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x0051 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:32:0x0053 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:10:0x001d, B:13:0x0028, B:15:0x002e, B:17:0x0032, B:21:0x003a, B:22:0x003d, B:24:0x0040, B:26:0x0046, B:28:0x004a, B:29:0x004d, B:30:0x0050, B:32:0x0053, B:50:0x007c, B:54:0x0086, B:56:0x0091, B:57:0x0095, B:58:0x0096, B:59:0x0099, B:60:0x009a, B:61:0x009d, B:62:0x009e, B:63:0x00a3, B:39:0x005f, B:43:0x006c, B:47:0x0076, B:48:0x007a), top: B:66:0x001d, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:35:0x0059  */
        /* JADX WARN: Code duplicated, block: B:41:0x006a  */
        /* JADX WARN: Code duplicated, block: B:42:0x006b  */
        /* JADX WARN: Code duplicated, block: B:45:0x0072  */
        /* JADX WARN: Code duplicated, block: B:47:0x0076 A[Catch: all -> 0x007b, TRY_ENTER, TryCatch #1 {all -> 0x007b, blocks: (B:39:0x005f, B:43:0x006c, B:47:0x0076, B:48:0x007a), top: B:67:0x005f, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:67:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // defpackage.nw
        public Object invoke(Object obj) throws Throwable {
            Object objInvoke;
            Object objPut;
            Object obj2;
            c5 c5VarK;
            ConcurrentHashMap concurrentHashMap = this.c;
            Object obj3 = concurrentHashMap.get(obj);
            l lVar = l.c;
            Object obj4 = uh.f53a;
            AssertionError assertionErrorB = null;
            if (obj3 != null && obj3 != lVar) {
                uh.a(obj3);
                if (obj3 == obj4) {
                    return null;
                }
                return obj3;
            }
            ff0 ff0Var = this.b;
            s01 s01Var = ff0Var.a;
            s01Var.lock();
            try {
                Object obj5 = concurrentHashMap.get(obj);
                l lVar2 = l.d;
                if (obj5 == lVar) {
                    c5 c5VarK2 = ff0Var.k(AppConfig.CUSTOM, obj);
                    if (c5VarK2 == null) {
                        a(3);
                        throw null;
                    }
                    if (c5VarK2.f) {
                        obj5 = lVar2;
                        if (obj5 != lVar2) {
                            c5VarK = ff0Var.k(AppConfig.CUSTOM, obj);
                            if (c5VarK != null) {
                                a(3);
                                throw null;
                            }
                            if (!c5VarK.f) {
                                obj2 = c5VarK.a;
                            } else {
                                if (obj5 != null) {
                                    concurrentHashMap.put(obj, lVar);
                                    objInvoke = this.d.invoke(obj);
                                    if (objInvoke == null) {
                                        obj4 = objInvoke;
                                    }
                                    objPut = concurrentHashMap.put(obj, obj4);
                                    if (objPut == lVar) {
                                        s01Var.unlock();
                                        return objInvoke;
                                    }
                                    assertionErrorB = b(obj, objPut);
                                    throw assertionErrorB;
                                }
                                uh.a(obj5);
                                obj2 = obj5 != obj4 ? obj5 : null;
                            }
                        } else {
                            if (obj5 != null) {
                                concurrentHashMap.put(obj, lVar);
                                objInvoke = this.d.invoke(obj);
                                if (objInvoke == null) {
                                    obj4 = objInvoke;
                                }
                                objPut = concurrentHashMap.put(obj, obj4);
                                if (objPut == lVar) {
                                    s01Var.unlock();
                                    return objInvoke;
                                }
                                assertionErrorB = b(obj, objPut);
                                throw assertionErrorB;
                            }
                            uh.a(obj5);
                            obj2 = obj5 != obj4 ? obj5 : null;
                        }
                    } else {
                        obj2 = c5VarK2.a;
                    }
                } else if (obj5 != lVar2) {
                    c5VarK = ff0Var.k(AppConfig.CUSTOM, obj);
                    if (c5VarK != null) {
                        a(3);
                        throw null;
                    }
                    if (!c5VarK.f) {
                        obj2 = c5VarK.a;
                    } else {
                        if (obj5 != null) {
                            concurrentHashMap.put(obj, lVar);
                            objInvoke = this.d.invoke(obj);
                            if (objInvoke == null) {
                                obj4 = objInvoke;
                            }
                            objPut = concurrentHashMap.put(obj, obj4);
                            if (objPut == lVar) {
                                s01Var.unlock();
                                return objInvoke;
                            }
                            assertionErrorB = b(obj, objPut);
                            throw assertionErrorB;
                        }
                        uh.a(obj5);
                        obj2 = obj5 != obj4 ? obj5 : null;
                    }
                } else {
                    if (obj5 != null) {
                        try {
                            concurrentHashMap.put(obj, lVar);
                            objInvoke = this.d.invoke(obj);
                            if (objInvoke == null) {
                                obj4 = objInvoke;
                            }
                            objPut = concurrentHashMap.put(obj, obj4);
                            if (objPut == lVar) {
                                s01Var.unlock();
                                return objInvoke;
                            }
                            assertionErrorB = b(obj, objPut);
                            throw assertionErrorB;
                        } catch (Throwable th) {
                            if (defpackage.e.X0(th)) {
                                concurrentHashMap.remove(obj);
                                throw th;
                            }
                            defpackage.e eVar = ff0Var.b;
                            if (th == assertionErrorB) {
                                eVar.getClass();
                                throw th;
                            }
                            Object objPut2 = concurrentHashMap.put(obj, new zh1$b(th));
                            if (objPut2 != lVar) {
                                throw b(obj, objPut2);
                            }
                            eVar.getClass();
                            throw th;
                        }
                    }
                    uh.a(obj5);
                    obj2 = obj5 != obj4 ? obj5 : null;
                }
                s01Var.unlock();
                return obj2;
            } catch (Throwable th2) {
                s01Var.unlock();
                throw th2;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class l {
        public static final l b;
        public static final l c;
        public static final l d;
        public static final /* synthetic */ l[] f;

        static {
            l lVar = new l("NOT_COMPUTED", 0);
            b = lVar;
            l lVar2 = new l("COMPUTING", 1);
            c = lVar2;
            l lVar3 = new l("RECURSION_WAS_DETECTED", 2);
            d = lVar3;
            f = new l[]{lVar, lVar2, lVar3};
        }

        public static l valueOf(String str) {
            return (l) Enum.valueOf(l.class, str);
        }

        public static l[] values() {
            return (l[]) f.clone();
        }
    }

    static {
        String canonicalName = ff0.class.getCanonicalName();
        int iN0 = q31.n0(canonicalName, ".");
        d = iN0 == -1 ? AppConfig.CUSTOM : canonicalName.substring(0, iN0);
        e = new a("NO_LOCKS", defpackage.e.f24b);
    }

    public ff0(String str) {
        this(str, new bj(19, (byte) 0));
    }

    public ff0(String str, s01 s01Var) {
        this.a = s01Var;
        this.b = d.a;
        this.c = str;
    }

    public static void l(AssertionError assertionError) {
        StackTraceElement[] stackTrace = assertionError.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            if (!stackTrace[i].getClassName().startsWith(d)) {
                List listSubList = Arrays.asList(stackTrace).subList(i, length);
                assertionError.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
            }
            i++;
        }
        i = -1;
        List listSubList2 = Arrays.asList(stackTrace).subList(i, length);
        assertionError.setStackTrace((StackTraceElement[]) listSubList2.toArray(new StackTraceElement[listSubList2.size()]));
    }

    public final j d(nw nwVar) {
        return new j(this, new ConcurrentHashMap(3, 1.0f, 2), nwVar);
    }

    public final c g(nw nwVar) {
        return new c(this, new ConcurrentHashMap(3, 1.0f, 2), nwVar);
    }

    public final h h(lw lwVar) {
        return new h(this, lwVar);
    }

    public c5 k(String str, Object obj) {
        String str2;
        StringBuilder sb = new StringBuilder("Recursion detected ");
        sb.append(str);
        if (obj == null) {
            str2 = AppConfig.CUSTOM;
        } else {
            str2 = "on input: " + obj;
        }
        sb.append(str2);
        sb.append(" under ");
        sb.append(this);
        AssertionError assertionError = new AssertionError(sb.toString());
        l(assertionError);
        throw assertionError;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(" (");
        return fb$1.m(sb, this.c, ")");
    }
}
