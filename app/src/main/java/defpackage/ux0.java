package defpackage;

import android.app.Application;
import androidx.lifecycle.n;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ux0 {
    public static final List a = Arrays.asList(Application.class, n.class);
    public static final List b = Collections.singletonList(n.class);

    public static final Constructor a(List list, Class cls) {
        for (Constructor<?> constructor : cls.getConstructors()) {
            List listM0 = ae.M0(constructor.getParameterTypes());
            if (e4.a(list, listM0)) {
                return constructor;
            }
            if (list.size() == listM0.size() && listM0.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final zd1 b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (zd1) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            d.AnonymousClass0.m("Failed to access ", (Object) cls, (Throwable) e);
            return null;
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
        }
    }
}
