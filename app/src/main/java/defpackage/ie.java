package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.lang.reflect.Array;
import org.hamotunnelplus.xyz.R;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ie {
    public static final ThreadLocal a = new ThreadLocal();

    public static ColorStateList a(Resources resources, XmlResourceParser xmlResourceParser, Resources.Theme theme) {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlResourceParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARN: Code duplicated, block: B:131:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:132:0x02da  */
    /* JADX WARN: Code duplicated, block: B:134:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:135:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:137:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:138:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:141:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:142:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:144:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:145:0x0301  */
    /* JADX WARN: Code duplicated, block: B:148:0x030a  */
    /* JADX WARN: Code duplicated, block: B:32:0x008a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r40v0, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.content.res.TypedArray] */
    public static ColorStateList b(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int color;
        float f;
        int[] iArr;
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z;
        float f6;
        int iC;
        float f7;
        float f8;
        boolean z2;
        TypedValue typedValue;
        resources = resources;
        attributeSet = attributeSet;
        theme = theme;
        String name = xmlResourceParser.getName();
        if (!name.equals("selector")) {
            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": invalid color state list tag " + name);
        }
        ?? r4 = 1;
        int depth2 = xmlResourceParser.getDepth() + 1;
        Object[] objArr = new int[20][];
        int[] iArr2 = new int[20];
        int i = 0;
        int i2 = 0;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == r4 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlResourceParser.getName().equals("item")) {
                int[] iArr3 = e.f34d$1;
                ?? ObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr3) : theme.obtainStyledAttributes(attributeSet, iArr3, i, i);
                int resourceId = ObtainAttributes.getResourceId(i, -1);
                if (resourceId != -1) {
                    ThreadLocal threadLocal = a;
                    TypedValue typedValue2 = (TypedValue) threadLocal.get();
                    if (typedValue2 == null) {
                        typedValue = new TypedValue();
                        threadLocal.set(typedValue);
                    } else {
                        typedValue = typedValue2;
                    }
                    resources.getValue(resourceId, typedValue, r4);
                    int i3 = typedValue.type;
                    if (i3 < 28 || i3 > 31) {
                        try {
                            color = a(resources, resources.getXml(resourceId), theme).getDefaultColor();
                        } catch (Exception unused) {
                            color = ObtainAttributes.getColor(i, -65281);
                        }
                    } else {
                        color = ObtainAttributes.getColor(i, -65281);
                    }
                } else {
                    color = ObtainAttributes.getColor(i, -65281);
                }
                if (ObtainAttributes.hasValue(r4)) {
                    f = ObtainAttributes.getFloat(r4, 1.0f);
                } else {
                    f = ObtainAttributes.hasValue(3) ? ObtainAttributes.getFloat(3, 1.0f) : 1.0f;
                }
                ?? r16 = r4;
                float f9 = ObtainAttributes.getFloat((Build.VERSION.SDK_INT < 31 || !ObtainAttributes.hasValue(2)) ? 4 : 2, -1.0f);
                ObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr4 = new int[attributeCount];
                int i4 = i;
                int i5 = i4;
                while (i4 < attributeCount) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.style.ax && attributeNameResource != R.style.pu) {
                        int i6 = i5 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr4[i5] = attributeNameResource;
                        i5 = i6;
                    }
                    i4++;
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr4, i5);
                float f10 = 100.0f;
                boolean z3 = (f9 < 0.0f || f9 > 100.0f) ? false : r16 == true ? 1 : 0;
                if (f != 1.0f || z3) {
                    int iD = e.d((int) ((Color.alpha(color) * f) + 0.5f), 0, 255);
                    if (z3) {
                        va vaVarA = va.a(color);
                        af1 af1Var = af1.k;
                        float f11 = vaVarA.b;
                        if (f11 >= 1.0d) {
                            iArr = iArr2;
                            if (Math.round(f9) > 0.0d && Math.round(f9) < 100.0d) {
                                float f12 = vaVarA.a;
                                float fMin = f12 < 0.0f ? 0.0f : Math.min(360.0f, f12);
                                float f13 = f11;
                                boolean z4 = r16 == true ? 1 : 0;
                                float f14 = 0.0f;
                                va vaVar = null;
                                while (true) {
                                    if (Math.abs(f14 - f11) >= 0.4f) {
                                        float f15 = 1000.0f;
                                        float f16 = f10;
                                        float f17 = 0.0f;
                                        float f18 = 1000.0f;
                                        va vaVar2 = null;
                                        while (true) {
                                            if (Math.abs(f17 - f16) <= 0.01f) {
                                                iArrTrimStateSet = iArrTrimStateSet;
                                                depth2 = depth2;
                                                f7 = f10;
                                                break;
                                            }
                                            f7 = f10;
                                            float f19 = ((f16 - f17) / 2.0f) + f17;
                                            iArrTrimStateSet = iArrTrimStateSet;
                                            int iC2 = va.b(f19, f13, fMin).c(af1.k);
                                            float fZ0 = e.Z0(Color.red(iC2));
                                            float fZ1 = e.Z0(Color.green(iC2));
                                            float fZ2 = e.Z0(Color.blue(iC2));
                                            float[] fArr = e.k[r16 == true ? 1 : 0];
                                            float f20 = ((fZ2 * fArr[2]) + ((fZ1 * fArr[r16 == true ? 1 : 0]) + (fZ0 * fArr[0]))) / f7;
                                            float fCbrt = f20 <= 0.008856452f ? f20 * 903.2963f : (((float) Math.cbrt(f20)) * 116.0f) - 16.0f;
                                            float fAbs = Math.abs(f9 - fCbrt);
                                            if (fAbs < 0.2f) {
                                                va vaVarA2 = va.a(iC2);
                                                va vaVarB = va.b(vaVarA2.c, vaVarA2.b, fMin);
                                                float f21 = vaVarA2.d - vaVarB.d;
                                                float f22 = vaVarA2.e - vaVarB.e;
                                                float f23 = vaVarA2.f - vaVarB.f;
                                                depth2 = depth2;
                                                float fPow = (float) (Math.pow(Math.sqrt((f23 * f23) + (f22 * f22) + (f21 * f21)), 0.63d) * 1.41d);
                                                if (fPow <= 1.0f) {
                                                    f18 = fPow;
                                                    f15 = fAbs;
                                                    vaVar2 = vaVarA2;
                                                }
                                            } else {
                                                depth2 = depth2;
                                            }
                                            if (f15 == 0.0f && f18 == 0.0f) {
                                                break;
                                            }
                                            if (fCbrt < f9) {
                                                f17 = f19;
                                            } else {
                                                f16 = f19;
                                            }
                                            f10 = f7;
                                            iArrTrimStateSet = iArrTrimStateSet;
                                            depth2 = depth2;
                                        }
                                        va vaVar3 = vaVar2;
                                        if (!z4) {
                                            if (vaVar3 == null) {
                                                f11 = f13;
                                                f13 = f14;
                                            } else {
                                                vaVar = vaVar3;
                                            }
                                            f8 = ((f11 - f13) / 2.0f) + f13;
                                            f14 = f13;
                                            z2 = z4;
                                        } else if (vaVar3 != null) {
                                            iC = vaVar3.c(af1Var);
                                        } else {
                                            f8 = ((f11 - f14) / 2.0f) + f14;
                                            z2 = false;
                                        }
                                        f13 = f8;
                                        f10 = f7;
                                        iArrTrimStateSet = iArrTrimStateSet;
                                        depth2 = depth2;
                                        z4 = z2;
                                    } else {
                                        iArrTrimStateSet = iArrTrimStateSet;
                                        depth2 = depth2;
                                        f2 = 0.008856452f;
                                        if (vaVar != null) {
                                            iC = vaVar.c(af1Var);
                                        } else if (f9 < 1.0f) {
                                            iC = -16777216;
                                        } else if (f9 > 99.0f) {
                                            color = -1;
                                        } else {
                                            f3 = (f9 + 16.0f) / 116.0f;
                                            if (f9 > 8.0f) {
                                                f4 = f3 * f3 * f3;
                                            } else {
                                                f4 = f9 / 903.2963f;
                                            }
                                            f5 = f3 * f3 * f3;
                                            if (f5 > f2) {
                                                z = r16 == true ? 1 : 0;
                                            } else {
                                                z = false;
                                            }
                                            if (z) {
                                                f6 = f5;
                                            } else {
                                                f6 = ((f3 * 116.0f) - 16.0f) / 903.2963f;
                                            }
                                            if (!z) {
                                                f5 = ((f3 * 116.0f) - 16.0f) / 903.2963f;
                                            }
                                            float[] fArr2 = e.j;
                                            color = je.a(f6 * fArr2[0], f4 * fArr2[r16 == true ? 1 : 0], f5 * fArr2[2]);
                                        }
                                    }
                                }
                            }
                            color = iC;
                        } else {
                            iArr = iArr2;
                        }
                        f2 = 0.008856452f;
                        if (f9 < 1.0f) {
                            iC = -16777216;
                            color = iC;
                        } else if (f9 > 99.0f) {
                            color = -1;
                        } else {
                            f3 = (f9 + 16.0f) / 116.0f;
                            if (f9 > 8.0f) {
                                f4 = f3 * f3 * f3;
                            } else {
                                f4 = f9 / 903.2963f;
                            }
                            f5 = f3 * f3 * f3;
                            if (f5 > f2) {
                                z = r16 == true ? 1 : 0;
                            } else {
                                z = false;
                            }
                            if (z) {
                                f6 = f5;
                            } else {
                                f6 = ((f3 * 116.0f) - 16.0f) / 903.2963f;
                            }
                            if (!z) {
                                f5 = ((f3 * 116.0f) - 16.0f) / 903.2963f;
                            }
                            float[] fArr3 = e.j;
                            color = je.a(f6 * fArr3[0], f4 * fArr3[r16 == true ? 1 : 0], f5 * fArr3[2]);
                        }
                    } else {
                        iArrTrimStateSet = iArrTrimStateSet;
                        depth2 = depth2;
                        iArr = iArr2;
                    }
                    color = (16777215 & color) | (iD << 24);
                } else {
                    iArrTrimStateSet = iArrTrimStateSet;
                    depth2 = depth2;
                    iArr = iArr2;
                }
                int i7 = i2 + 1;
                iArr2 = iArr;
                if (i7 > iArr2.length) {
                    int[] iArr5 = new int[i2 <= 4 ? 8 : i2 * 2];
                    System.arraycopy(iArr2, 0, iArr5, 0, i2);
                    iArr2 = iArr5;
                }
                iArr2[i2] = color;
                if (i7 > objArr.length) {
                    Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2 > 4 ? i2 * 2 : 8);
                    System.arraycopy(objArr, 0, objArr2, 0, i2);
                    objArr = objArr2;
                }
                objArr[i2] = iArrTrimStateSet;
                objArr = (int[][]) objArr;
                i2 = i7;
                r4 = r16 == true ? 1 : 0;
                depth2 = depth2;
                i = 0;
            } else {
                int i8 = depth2;
                r4 = r4 == true ? 1 : 0;
                depth2 = i8;
                i = 0;
            }
        }
        int[] iArr6 = new int[i2];
        int[][] iArr7 = new int[i2][];
        System.arraycopy(iArr2, 0, iArr6, 0, i2);
        System.arraycopy(objArr, 0, iArr7, 0, i2);
        return new ColorStateList(iArr7, iArr6);
    }
}
