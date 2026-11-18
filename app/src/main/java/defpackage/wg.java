package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import java.util.HashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class wg {
    public final boolean a;
    public final int c;
    public int d;
    public float e;
    public String f;
    public boolean g;
    public int h;

    public wg(int i, Object obj, String str, boolean z) {
        this.c = i;
        this.a = z;
        f(obj);
    }

    public wg(wg wgVar, Object obj) {
        this.a = false;
        wgVar.getClass();
        this.c = wgVar.c;
        f(obj);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0069 A[PHI: r12
      0x0069: PHI (r12v1 int) = (r12v0 int), (r12v2 int) binds: [B:18:0x0062, B:21:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    public static void d(Context context, XmlResourceParser xmlResourceParser, HashMap map) {
        int color;
        float dimension;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), ak.r);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        int i = 0;
        boolean z = false;
        Object objValueOf = null;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            int i3 = 1;
            if (index == 0) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == 10) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z = true;
            } else if (index == 1) {
                objValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                i = 6;
            } else {
                int i4 = 3;
                if (index == 3) {
                    color = typedArrayObtainStyledAttributes.getColor(index, 0);
                    i = i4;
                    objValueOf = Integer.valueOf(color);
                } else {
                    i4 = 4;
                    if (index == 2) {
                        color = typedArrayObtainStyledAttributes.getColor(index, 0);
                        i = i4;
                    } else {
                        if (index == 7) {
                            dimension = TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                        } else if (index == 4) {
                            dimension = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                        } else if (index == 5) {
                            objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                            i = 2;
                        } else {
                            if (index == 6) {
                                color = typedArrayObtainStyledAttributes.getInteger(index, -1);
                            } else if (index == 9) {
                                objValueOf = typedArrayObtainStyledAttributes.getString(index);
                                i = 5;
                            } else {
                                i3 = 8;
                                if (index == 8) {
                                    color = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                    if (color == -1) {
                                        color = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    }
                                }
                            }
                            i = i3;
                        }
                        objValueOf = Float.valueOf(dimension);
                        i = 7;
                    }
                    objValueOf = Integer.valueOf(color);
                }
            }
        }
        if (string != null && objValueOf != null) {
            map.put(string, new wg(i, objValueOf, string, z));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void f(Object obj) {
        switch (ak.u(this.c)) {
            case 0:
            case 7:
                this.d = ((Integer) obj).intValue();
                break;
            case 1:
            case 6:
                this.e = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.h = ((Integer) obj).intValue();
                break;
            case 4:
                this.f = (String) obj;
                break;
            case 5:
                this.g = ((Boolean) obj).booleanValue();
                break;
        }
    }
}
