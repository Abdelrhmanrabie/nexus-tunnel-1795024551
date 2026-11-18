package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import defpackage.he0;
import defpackage.lw;
import defpackage.oc0;
import defpackage.v41;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ImmLeaksCleaner implements h {
    public static final v41 c = new v41(b.b);
    public final Activity b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class a {
        public abstract boolean a(InputMethodManager inputMethodManager);

        public abstract Object b(InputMethodManager inputMethodManager);

        public abstract View c(InputMethodManager inputMethodManager);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class b extends oc0 implements lw {
        public static final b b = new b();

        public b() {
            super(0);
        }

        @Override // defpackage.lw
        public final Object invoke() {
            try {
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                declaredField3.setAccessible(true);
                return new d(declaredField3, declaredField, declaredField2);
            } catch (NoSuchFieldException unused) {
                return c.a;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class c extends a {
        public static final c a = new c();

        @Override // androidx.activity.ImmLeaksCleaner.a
        public final boolean a(InputMethodManager inputMethodManager) {
            return false;
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public final Object b(InputMethodManager inputMethodManager) {
            return null;
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public final View c(InputMethodManager inputMethodManager) {
            return null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class d extends a {
        public final Field a;
        public final Field b;
        public final Field c;

        public d(Field field, Field field2, Field field3) {
            this.a = field;
            this.b = field2;
            this.c = field3;
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public final boolean a(InputMethodManager inputMethodManager) {
            try {
                this.c.set(inputMethodManager, null);
                return true;
            } catch (IllegalAccessException unused) {
                return false;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public final Object b(InputMethodManager inputMethodManager) {
            try {
                return this.a.get(inputMethodManager);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public final View c(InputMethodManager inputMethodManager) {
            try {
                return (View) this.b.get(inputMethodManager);
            } catch (ClassCastException | IllegalAccessException unused) {
                return null;
            }
        }
    }

    public ImmLeaksCleaner(Activity activity) {
        this.b = activity;
    }

    @Override // androidx.lifecycle.h
    public final void a(he0 he0Var, e.a aVar) {
        InputMethodManager inputMethodManager;
        a aVar2;
        Object objB;
        if (aVar == e.a.ON_DESTROY && (objB = (aVar2 = (a) c.getValue()).b((inputMethodManager = (InputMethodManager) this.b.getSystemService("input_method")))) != null) {
            synchronized (objB) {
                View viewC = aVar2.c(inputMethodManager);
                if (viewC == null) {
                    return;
                }
                if (viewC.isAttachedToWindow()) {
                    return;
                }
                boolean zA = aVar2.a(inputMethodManager);
                if (zA) {
                    inputMethodManager.isActive();
                }
            }
        }
    }
}
