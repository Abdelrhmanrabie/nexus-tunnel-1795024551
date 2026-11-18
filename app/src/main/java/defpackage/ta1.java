package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ta1 {
    public static final ak a;
    public static final vf0 b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends e {
        public final ak m;

        public a(ak akVar) {
            super(6);
            this.m = akVar;
        }
    }

    static {
        ak ua1Var;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            ua1Var = new ua1(1);
        } else if (i >= 28) {
            ua1Var = new xa1();
        } else if (i >= 26) {
            ua1Var = new wa1();
        } else {
            ua1Var = (i < 24 || va1.c == null) ? new ua1(0) : new va1(4);
        }
        a = ua1Var;
        b = new vf0(16);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Multi-variable type inference failed */
    public static Typeface a(Context context, vu$b vu_b, Resources resources, int i, String str, int i2, int i3, ak akVar, boolean z) {
        Typeface typefaceA;
        Typeface typefaceCreate;
        Typeface typeface;
        boolean z2 = false;
        Object[] objArr = 0;
        int i4 = -3;
        if (vu_b instanceof vu$e) {
            vu$e vu_e = (vu$e) vu_b;
            String str2 = vu_e.d;
            Typeface typeface2 = null;
            if (str2 == null || str2.isEmpty()) {
                typefaceCreate = null;
            } else {
                typefaceCreate = Typeface.create(str2, 0);
                Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
                if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
                    typefaceCreate = null;
                }
            }
            if (typefaceCreate != null) {
                if (akVar != null) {
                    new Handler(Looper.getMainLooper()).post(new f2(akVar, typefaceCreate, 9, false));
                }
                return typefaceCreate;
            }
            int i5 = 1;
            Object[] objArr2 = !z ? akVar != null : vu_e.c != 0;
            int i6 = z ? vu_e.b : -1;
            Handler handler = new Handler(Looper.getMainLooper());
            a aVar = new a(akVar);
            pu puVar = vu_e.a;
            g gVar = new g(aVar, handler, 23, z2);
            if (objArr2 == true) {
                vf0 vf0Var = uu.a;
                String str3 = puVar.e + "-" + i3;
                typeface = (Typeface) uu.a.get(str3);
                if (typeface != null) {
                    handler.post(new f2(aVar, typeface, 8, false));
                } else if (i6 == -1) {
                    uu.a aVarA = uu.a(str3, context, puVar, i3);
                    gVar.a(aVarA);
                    typeface2 = aVarA.a;
                } else {
                    try {
                        try {
                            try {
                                try {
                                    uu.a aVar2 = (uu.a) uu.b.submit(new qu(str3, context, puVar, i3, 0)).get(i6, TimeUnit.MILLISECONDS);
                                    gVar.a(aVar2);
                                    typeface2 = aVar2.a;
                                } catch (TimeoutException unused) {
                                    throw new InterruptedException("timeout");
                                }
                            } catch (InterruptedException e) {
                                throw e;
                            }
                        } catch (ExecutionException e2) {
                            throw new RuntimeException(e2);
                        }
                    } catch (InterruptedException unused2) {
                        ((Handler) gVar.b).post(new df((a) gVar.a, i4, i5));
                    }
                }
                typefaceA = typeface;
            } else {
                vf0 vf0Var2 = uu.a;
                String str4 = puVar.e + "-" + i3;
                typefaceA = (Typeface) uu.a.get(str4);
                if (typefaceA != null) {
                    handler.post(new f2(aVar, typefaceA, 8, false));
                } else {
                    ru ruVar = new ru(objArr == true ? 1 : 0, gVar);
                    synchronized (uu.c) {
                        try {
                            o01 o01Var = uu.d;
                            ArrayList arrayList = (ArrayList) o01Var.getOrDefault(str4, null);
                            if (arrayList != null) {
                                arrayList.add(ruVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(ruVar);
                                o01Var.put(str4, arrayList2);
                                uu.b.execute(new dq(Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler(), new qu(str4, context, puVar, i3, 1), new ru(i5, str4), 2, false));
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
            typeface = typeface2;
            typefaceA = typeface;
        } else {
            typefaceA = a.a(context, (vu$c) vu_b, resources, i3);
            if (akVar != null) {
                if (typefaceA != null) {
                    new Handler(Looper.getMainLooper()).post(new f2(akVar, typefaceA, 9, false));
                } else {
                    akVar.callbackFailAsync(-3);
                }
            }
        }
        if (typefaceA != null) {
            b.put(b(resources, i, str, i2, i3), typefaceA);
        }
        return typefaceA;
    }

    public static String b(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }
}
