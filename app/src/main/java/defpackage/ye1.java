package defpackage;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ye1 extends e {
    public static boolean j = true;
    public static boolean k = true;
    public static boolean l = true;
    public static boolean m = true;
    public static boolean n = true;

    public static final int e(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final Map h(jo0... jo0VarArr) {
        if (jo0VarArr.length <= 0) {
            return vq.b;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(e(jo0VarArr.length));
        for (jo0 jo0Var : jo0VarArr) {
            linkedHashMap.put(jo0Var.b, jo0Var.c);
        }
        return linkedHashMap;
    }

    public static final Map j(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return vq.b;
        }
        if (size == 1) {
            jo0 jo0Var = (jo0) arrayList.get(0);
            return Collections.singletonMap(jo0Var.b, jo0Var.c);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(e(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jo0 jo0Var2 = (jo0) it.next();
            linkedHashMap.put(jo0Var2.b, jo0Var2.c);
        }
        return linkedHashMap;
    }

    public void d(View view, int i) {
        if (Build.VERSION.SDK_INT != 28) {
            if (n) {
                try {
                    view.setTransitionVisibility(i);
                    return;
                } catch (NoSuchMethodError unused) {
                    n = false;
                    return;
                }
            }
            return;
        }
        if (!e.f42i) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                e.h = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            e.f42i = true;
        }
        Field field = e.h;
        if (field != null) {
            try {
                e.h.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused3) {
            }
        }
    }

    public float e(View view) {
        if (j) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                j = false;
            }
        }
        return view.getAlpha();
    }

    public void f(View view, float f) {
        if (j) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                j = false;
            }
        }
        view.setAlpha(f);
    }

    public void g(View view, Matrix matrix) {
        if (k) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                k = false;
            }
        }
    }

    public void h(ViewGroup viewGroup, Matrix matrix) {
        if (l) {
            try {
                viewGroup.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                l = false;
            }
        }
    }

    public void i(View view, int i, int i2, int i3, int i4) {
        if (m) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                m = false;
            }
        }
    }
}
