package androidx.lifecycle;

import defpackage.el;
import defpackage.he0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements h {
    public final el b;
    public final h c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.a.values().length];
            try {
                iArr[e.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[e.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[e.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[e.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[e.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[e.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[e.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr;
        }
    }

    public DefaultLifecycleObserverAdapter(el elVar, h hVar) {
        this.b = elVar;
        this.c = hVar;
    }

    @Override // androidx.lifecycle.h
    public final void a(he0 he0Var, e.a aVar) {
        int i = a.a[aVar.ordinal()];
        el elVar = this.b;
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                elVar.getClass();
                break;
            case 3:
                elVar.onResume();
                break;
            case 7:
                defpackage.d.AnonymousClass0.m$2("ON_ANY must not been send by anybody");
                return;
        }
        h hVar = this.c;
        if (hVar != null) {
            hVar.a(he0Var, aVar);
        }
    }
}
