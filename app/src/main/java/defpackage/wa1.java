package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class wa1 extends ua1 {
    public final Class f;
    public final Constructor g;
    public final Method h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;

    public wa1() throws NoSuchMethodException {
        Method method;
        Method methodN;
        Constructor<?> constructor;
        Method methodL;
        Method method2;
        Method method3;
        super(0);
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodL = l(cls2);
            Class<?> cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodN = n(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            method = null;
            methodN = null;
            constructor = null;
            methodL = null;
            method2 = null;
            method3 = null;
        }
        this.f = cls;
        this.g = constructor;
        this.h = methodL;
        this.i = method;
        this.j = method2;
        this.k = method3;
        this.l = methodN;
    }

    public static Method l(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    @Override // defpackage.ua1, defpackage.ak
    public final Typeface a(Context context, vu$c vu_c, Resources resources, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        if (this.h == null) {
            return super.a(context, vu_c, resources, i);
        }
        try {
            objNewInstance = this.g.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            vu$d[] vu_dArr = vu_c.a;
            int length = vu_dArr.length;
            int i2 = 0;
            while (i2 < length) {
                vu$d vu_d = vu_dArr[i2];
                Context context2 = context;
                if (i(context2, objNewInstance, vu_d.a, vu_d.e, vu_d.b, vu_d.c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(vu_d.d))) {
                    i2++;
                    context = context2;
                } else {
                    try {
                        this.k.invoke(objNewInstance, null);
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
            if (k(objNewInstance)) {
                return j(objNewInstance);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    @Override // defpackage.ua1, defpackage.ak
    public final Typeface b(Context context, xu[] xuVarArr, int i) throws IOException {
        Object objNewInstance;
        Method method;
        Typeface typefaceJ;
        char c;
        boolean zBooleanValue;
        char c2 = 1;
        if (xuVarArr.length >= 1) {
            try {
                if (this.h != null) {
                    HashMap map = new HashMap();
                    for (xu xuVar : xuVarArr) {
                        if (xuVar.e == 0) {
                            Uri uri = xuVar.a;
                            if (!map.containsKey(uri)) {
                                map.put(uri, e4.e(context, uri));
                            }
                        }
                    }
                    Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                    try {
                        objNewInstance = this.g.newInstance(null);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        objNewInstance = null;
                    }
                    if (objNewInstance != null) {
                        int length = xuVarArr.length;
                        int i2 = 0;
                        char c3 = 0;
                        while (true) {
                            method = this.k;
                            if (i2 < length) {
                                xu xuVar2 = xuVarArr[i2];
                                ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(xuVar2.a);
                                if (byteBuffer == null) {
                                    c = c2;
                                } else {
                                    int i3 = xuVar2.b;
                                    int i4 = xuVar2.c;
                                    boolean z = xuVar2.d;
                                    try {
                                        Method method2 = this.i;
                                        c = c2;
                                        try {
                                            Object[] objArr = new Object[5];
                                            objArr[0] = byteBuffer;
                                            objArr[c] = Integer.valueOf(i3);
                                            objArr[2] = null;
                                            objArr[3] = Integer.valueOf(i4);
                                            objArr[4] = Integer.valueOf(z ? 1 : 0);
                                            zBooleanValue = ((Boolean) method2.invoke(objNewInstance, objArr)).booleanValue();
                                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                                            zBooleanValue = false;
                                        }
                                    } catch (IllegalAccessException | InvocationTargetException unused3) {
                                        c = c2;
                                    }
                                    if (!zBooleanValue) {
                                        break;
                                    }
                                    c3 = c;
                                }
                                i2++;
                                c2 = c;
                            } else {
                                if (c3 == 0) {
                                    break;
                                }
                                if (k(objNewInstance) && (typefaceJ = j(objNewInstance)) != null) {
                                    return Typeface.create(typefaceJ, i);
                                }
                            }
                        }
                        method.invoke(objNewInstance, null);
                    }
                } else {
                    xu xuVarF = f(i, xuVarArr);
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(xuVarF.a, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(xuVarF.c).setItalic(xuVarF.d).build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            return typefaceBuild;
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                                throw th;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                                throw th;
                            }
                        }
                    }
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return null;
                    }
                }
            } catch (IOException | IllegalAccessException | InvocationTargetException unused4) {
            }
        }
        return null;
    }

    @Override // defpackage.ua1, defpackage.ak
    public final Typeface d(Context context, Resources resources, int i, String str, int i2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        if (this.h == null) {
            return super.d(context, resources, i, str, i2);
        }
        try {
            objNewInstance = this.g.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            if (!i(context, objNewInstance, str, 0, -1, -1, null)) {
                try {
                    this.k.invoke(objNewInstance, null);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            } else if (k(objNewInstance)) {
                return j(objNewInstance);
            }
        }
        return null;
    }

    public final boolean i(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.h.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface j(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.l.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean k(Object obj) {
        try {
            return ((Boolean) this.j.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method n(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
