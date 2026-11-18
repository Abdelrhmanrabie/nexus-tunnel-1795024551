package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import java.io.IOException;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class sv0 {
    public static final ThreadLocal a = new ThreadLocal();
    public static final WeakHashMap b = new WeakHashMap(0);
    public static final Object c = new Object();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c {
        public final ColorStateList a;
        public final Configuration b;
        public final int c;

        public c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.a = colorStateList;
            this.b = configuration;
            this.c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d {
        public final Resources a;
        public final Resources.Theme b;

        public d(Resources resources, Resources.Theme theme) {
            this.a = resources;
            this.b = theme;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.a.equals(dVar.a) && Objects.equals(this.b, dVar.b);
        }

        public final int hashCode() {
            return Objects.hash(this.a, this.b);
        }
    }

    public static void a(d dVar, int i, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (c) {
            try {
                WeakHashMap weakHashMap = b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(dVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(dVar, sparseArray);
                }
                sparseArray.append(i, new c(colorStateList, dVar.a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface b(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return c(context, i, new TypedValue(), 0, null, false, false);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a1  */
    public static Typeface c(Context context, int i, TypedValue typedValue, int i2, ak akVar, boolean z, boolean z2) {
        Typeface typefaceD;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        if (string.startsWith("res/")) {
            int i3 = typedValue.assetCookie;
            vf0 vf0Var = ta1.b;
            typefaceD = (Typeface) vf0Var.get(ta1.b(resources, i, string, i3, i2));
            boolean z3 = false;
            int i4 = 9;
            if (typefaceD != null) {
                if (akVar != null) {
                    new Handler(Looper.getMainLooper()).post(new f2(akVar, typefaceD, i4, z3));
                }
            } else if (z2) {
                typefaceD = null;
            } else {
                try {
                    if (string.toLowerCase().endsWith(".xml")) {
                        vu$b vu_bA = v3.a(resources.getXml(i), resources);
                        if (vu_bA == null) {
                            if (akVar != null) {
                                akVar.callbackFailAsync(-3);
                            }
                            typefaceD = null;
                        } else {
                            typefaceD = ta1.a(context, vu_bA, resources, i, string, typedValue.assetCookie, i2, akVar, z);
                        }
                    } else {
                        int i5 = typedValue.assetCookie;
                        typefaceD = ta1.a.d(context, resources, i, string, i2);
                        if (typefaceD != null) {
                            vf0Var.put(ta1.b(resources, i, string, i5, i2), typefaceD);
                        }
                        if (akVar != null) {
                            if (typefaceD != null) {
                                new Handler(Looper.getMainLooper()).post(new f2(akVar, typefaceD, i4, z3));
                            } else {
                                akVar.callbackFailAsync(-3);
                            }
                        }
                    }
                } catch (IOException | XmlPullParserException unused) {
                    if (akVar != null) {
                        akVar.callbackFailAsync(-3);
                    }
                }
            }
        } else {
            if (akVar != null) {
                akVar.callbackFailAsync(-3);
            }
            typefaceD = null;
        }
        if (typefaceD == null && akVar == null && !z2) {
            throw new Resources.NotFoundException(ak.AnonymousClass0.m("Font resource ID #0x", Integer.toHexString(i), " could not be retrieved."));
        }
        return typefaceD;
    }
}
