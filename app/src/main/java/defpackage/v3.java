package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.LongSparseArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.openvpn.ovpn3.XMLRPC;
import org.xmlpull.v1.XmlPullParserException;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class v3 {
    public static Field a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f57b;
    public static Class c;
    public static boolean d;
    public static Field e;
    public static boolean f;
    public static Field g;
    public static boolean h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final wx$c f56a = new wx$c();
    public static final ke b = new ke(25);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final ke f58c = new ke(26);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements TypeEvaluator {
        public so0$a[] a;

        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f, Object obj, Object obj2) {
            so0$a[] so0_aArr = (so0$a[]) obj;
            so0$a[] so0_aArr2 = (so0$a[]) obj2;
            if (!e4.a(so0_aArr, so0_aArr2)) {
                d.AnonymousClass0.m$2("Can't interpolate between two incompatible pathData");
                return null;
            }
            if (!e4.a(this.a, so0_aArr)) {
                so0$a[] so0_aArr3 = new so0$a[so0_aArr.length];
                for (int i = 0; i < so0_aArr.length; i++) {
                    so0_aArr3[i] = new so0$a(so0_aArr[i]);
                }
                this.a = so0_aArr3;
            }
            int i2 = 0;
            while (true) {
                int length = so0_aArr.length;
                so0$a[] so0_aArr4 = this.a;
                if (i2 >= length) {
                    return so0_aArr4;
                }
                so0$a so0_a = so0_aArr4[i2];
                so0$a so0_a2 = so0_aArr[i2];
                so0$a so0_a3 = so0_aArr2[i2];
                so0_a.getClass();
                so0_a.a = so0_a2.a;
                int i3 = 0;
                while (true) {
                    float[] fArr = so0_a2.b;
                    if (i3 < fArr.length) {
                        so0_a.b[i3] = (so0_a3.b[i3] * f) + ((1.0f - f) * fArr[i3]);
                        i3++;
                    }
                }
                i2++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:202:0x03a8  */
    public static Animator a(Context context, Resources resources, Resources.Theme theme, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i) throws XmlPullParserException, IOException {
        int i2;
        ArrayList arrayList;
        PropertyValuesHolder[] propertyValuesHolderArr;
        int i3;
        String str;
        int i4;
        ArrayList arrayList2;
        int i5;
        int i6;
        PropertyValuesHolder propertyValuesHolderC;
        int size;
        float f2;
        int i7;
        int i8;
        Keyframe keyframeOfFloat;
        Animator animator;
        Resources.Theme theme2;
        XmlResourceParser xmlResourceParser2;
        Resources resources2;
        Animator animatorE;
        int depth = xmlResourceParser.getDepth();
        Animator animator2 = null;
        ArrayList arrayList3 = null;
        while (true) {
            int next = xmlResourceParser.next();
            int i9 = 3;
            int i10 = 0;
            if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                break;
            }
            int i11 = 1;
            if (next == 1) {
                break;
            }
            int i12 = 2;
            if (next == 2) {
                String name = xmlResourceParser.getName();
                if (name.equals("objectAnimator")) {
                    ObjectAnimator objectAnimator = new ObjectAnimator();
                    e(context, resources, theme, attributeSet, objectAnimator, xmlResourceParser);
                    resources2 = resources;
                    theme2 = theme;
                    xmlResourceParser2 = xmlResourceParser;
                    animatorE = objectAnimator;
                } else {
                    if (name.equals("animator")) {
                        theme2 = theme;
                        xmlResourceParser2 = xmlResourceParser;
                        resources2 = resources;
                        animatorE = e(context, resources, theme, attributeSet, null, xmlResourceParser);
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray typedArrayH = ak.h(resources, theme, attributeSet, ak.h$1);
                        a(context, r5, r6, r12, attributeSet, animatorSet2, xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "ordering") != null ? typedArrayH.getInt(0, 0) : 0);
                        typedArrayH.recycle();
                        animator = animatorSet2;
                        animator2 = animator;
                        i2 = depth;
                        arrayList = arrayList3;
                    } else {
                        Resources resources3 = resources;
                        String str2 = "propertyValuesHolder";
                        if (!name.equals("propertyValuesHolder")) {
                            throw new RuntimeException(ak.AnonymousClass0.m("Unknown animator name: ", xmlResourceParser.getName()));
                        }
                        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                        ArrayList arrayList4 = null;
                        while (true) {
                            int eventType = xmlResourceParser.getEventType();
                            if (eventType == i9 || eventType == i11) {
                                break;
                            }
                            if (eventType != i12) {
                                xmlResourceParser.next();
                            } else {
                                if (xmlResourceParser.getName().equals(str2)) {
                                    TypedArray typedArrayH2 = ak.h(resources3, theme, attributeSetAsAttributeSet, ak.i$1);
                                    String strE = ak.e(typedArrayH2, xmlResourceParser, "propertyName", i9);
                                    int i13 = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueType") != null ? typedArrayH2.getInt(i12, 4) : 4;
                                    int i14 = i13;
                                    ArrayList arrayList5 = null;
                                    while (true) {
                                        int next2 = xmlResourceParser.next();
                                        str = str2;
                                        if (next2 == 3 || next2 == 1) {
                                            break;
                                        }
                                        if (xmlResourceParser.getName().equals("keyframe")) {
                                            int[] iArr = ak.j$1;
                                            if (i14 == 4) {
                                                TypedArray typedArrayH3 = ak.h(resources3, theme, Xml.asAttributeSet(xmlResourceParser), iArr);
                                                TypedValue typedValuePeekValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", XMLRPC.TAG_VALUE) != null ? typedArrayH3.peekValue(0) : null;
                                                int i15 = (typedValuePeekValue == null || !d(typedValuePeekValue.type)) ? 0 : 3;
                                                typedArrayH3.recycle();
                                                i14 = i15;
                                            }
                                            TypedArray typedArrayH4 = ak.h(resources3, theme, Xml.asAttributeSet(xmlResourceParser), iArr);
                                            float f3 = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fraction") != null ? typedArrayH4.getFloat(3, -1.0f) : -1.0f;
                                            TypedValue typedValuePeekValue2 = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", XMLRPC.TAG_VALUE) != null ? typedArrayH4.peekValue(0) : null;
                                            boolean z = typedValuePeekValue2 != null;
                                            int i16 = i14 == 4 ? (z && d(typedValuePeekValue2.type)) ? 3 : 0 : i14;
                                            if (!z) {
                                                keyframeOfFloat = i16 == 0 ? Keyframe.ofFloat(f3) : Keyframe.ofInt(f3);
                                            } else if (i16 == 0) {
                                                keyframeOfFloat = Keyframe.ofFloat(f3, xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", XMLRPC.TAG_VALUE) != null ? typedArrayH4.getFloat(0, 0.0f) : 0.0f);
                                            } else if (i16 == 1 || i16 == 3) {
                                                keyframeOfFloat = Keyframe.ofInt(f3, xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", XMLRPC.TAG_VALUE) != null ? typedArrayH4.getInt(0, 0) : 0);
                                            } else {
                                                keyframeOfFloat = null;
                                            }
                                            int resourceId = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") != null ? typedArrayH4.getResourceId(1, 0) : 0;
                                            if (resourceId > 0) {
                                                keyframeOfFloat.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
                                            }
                                            typedArrayH4.recycle();
                                            if (keyframeOfFloat != null) {
                                                if (arrayList5 == null) {
                                                    arrayList5 = new ArrayList();
                                                }
                                                arrayList5.add(keyframeOfFloat);
                                            }
                                            xmlResourceParser.next();
                                        }
                                        resources3 = resources;
                                        str2 = str;
                                        depth = depth;
                                        arrayList3 = arrayList3;
                                    }
                                    i4 = depth;
                                    arrayList2 = arrayList3;
                                    if (arrayList5 == null || (size = arrayList5.size()) <= 0) {
                                        i6 = 3;
                                        propertyValuesHolderC = null;
                                    } else {
                                        Keyframe keyframe = (Keyframe) arrayList5.get(0);
                                        Keyframe keyframe2 = (Keyframe) arrayList5.get(size - 1);
                                        float fraction = keyframe2.getFraction();
                                        if (fraction >= 1.0f) {
                                            f2 = 1.0f;
                                            i7 = size;
                                        } else if (fraction < 0.0f) {
                                            keyframe2.setFraction(1.0f);
                                            f2 = 1.0f;
                                            i7 = size;
                                        } else {
                                            f2 = 1.0f;
                                            arrayList5.add(arrayList5.size(), keyframe2.getType() == Float.TYPE ? Keyframe.ofFloat(1.0f) : keyframe2.getType() == Integer.TYPE ? Keyframe.ofInt(1.0f) : Keyframe.ofObject(1.0f));
                                            i7 = size + 1;
                                        }
                                        float fraction2 = keyframe.getFraction();
                                        if (fraction2 != 0.0f) {
                                            if (fraction2 < 0.0f) {
                                                keyframe.setFraction(0.0f);
                                            } else {
                                                arrayList5.add(0, keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(0.0f) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(0.0f) : Keyframe.ofObject(0.0f));
                                                i7++;
                                            }
                                        }
                                        Keyframe[] keyframeArr = new Keyframe[i7];
                                        arrayList5.toArray(keyframeArr);
                                        int i17 = 0;
                                        while (i17 < i7) {
                                            Keyframe keyframe3 = keyframeArr[i17];
                                            int i18 = i7;
                                            if (keyframe3.getFraction() >= 0.0f) {
                                                i8 = i17;
                                            } else if (i17 == 0) {
                                                keyframe3.setFraction(0.0f);
                                                i8 = i17;
                                            } else {
                                                int i19 = i18 - 1;
                                                float f4 = f2;
                                                if (i17 == i19) {
                                                    keyframe3.setFraction(f4);
                                                    i8 = i17;
                                                } else {
                                                    int i20 = i17;
                                                    for (int i21 = i17 + 1; i21 < i19 && keyframeArr[i21].getFraction() < 0.0f; i21++) {
                                                        i20 = i21;
                                                    }
                                                    float fraction3 = (keyframeArr[i20 + 1].getFraction() - keyframeArr[i17 - 1].getFraction()) / ((i20 - i17) + 2);
                                                    int i22 = i17;
                                                    while (i22 <= i20) {
                                                        float f5 = fraction3;
                                                        keyframeArr[i22].setFraction(keyframeArr[i22 - 1].getFraction() + f5);
                                                        i22++;
                                                        fraction3 = f5;
                                                        i17 = i17;
                                                    }
                                                    i8 = i17;
                                                }
                                            }
                                            i17 = i8 + 1;
                                            i7 = i18;
                                            f2 = 1.0f;
                                        }
                                        propertyValuesHolderC = PropertyValuesHolder.ofKeyframe(strE, keyframeArr);
                                        i6 = 3;
                                        if (i14 == 3) {
                                            propertyValuesHolderC.setEvaluator(w6.a);
                                        }
                                    }
                                    i3 = 1;
                                    i5 = 0;
                                    if (propertyValuesHolderC == null) {
                                        propertyValuesHolderC = c(typedArrayH2, i13, 0, 1, strE);
                                    }
                                    if (propertyValuesHolderC != null) {
                                        if (arrayList4 == null) {
                                            arrayList4 = new ArrayList();
                                        }
                                        arrayList4.add(propertyValuesHolderC);
                                    }
                                    typedArrayH2.recycle();
                                } else {
                                    i3 = i11;
                                    str = str2;
                                    i4 = depth;
                                    arrayList2 = arrayList3;
                                    i5 = i10;
                                    i6 = i9;
                                }
                                xmlResourceParser.next();
                                resources3 = resources;
                                i11 = i3;
                                i10 = i5;
                                i9 = i6;
                                i12 = i12;
                                attributeSetAsAttributeSet = attributeSetAsAttributeSet;
                                str2 = str;
                                depth = i4;
                                arrayList3 = arrayList2;
                            }
                        }
                        int i23 = i11;
                        i2 = depth;
                        arrayList = arrayList3;
                        int i24 = i10;
                        if (arrayList4 != null) {
                            int size2 = arrayList4.size();
                            propertyValuesHolderArr = new PropertyValuesHolder[size2];
                            for (int i25 = i24; i25 < size2; i25++) {
                                propertyValuesHolderArr[i25] = (PropertyValuesHolder) arrayList4.get(i25);
                            }
                        } else {
                            propertyValuesHolderArr = null;
                        }
                        if (propertyValuesHolderArr != null && (animator2 instanceof ValueAnimator)) {
                            ((ValueAnimator) animator2).setValues(propertyValuesHolderArr);
                        }
                        i10 = i23;
                        animator2 = animator2;
                    }
                    if (animatorSet == null && i10 == 0) {
                        arrayList3 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList3.add(animator2);
                    } else {
                        arrayList3 = arrayList;
                    }
                    depth = i2;
                }
                animator = animatorE;
                animator2 = animator;
                i2 = depth;
                arrayList = arrayList3;
                if (animatorSet == null) {
                    arrayList3 = arrayList;
                } else {
                    arrayList3 = arrayList;
                }
                depth = i2;
            }
        }
        ArrayList arrayList6 = arrayList3;
        if (animatorSet != null && arrayList6 != null) {
            Animator[] animatorArr = new Animator[arrayList6.size()];
            Iterator it = arrayList6.iterator();
            int i26 = 0;
            while (it.hasNext()) {
                animatorArr[i26] = (Animator) it.next();
                i26++;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
                return animator2;
            }
            animatorSet.playSequentially(animatorArr);
        }
        return animator2;
    }

    public static tx a(lx lxVar, boolean z) {
        tx txVar = new tx(lxVar, null, la.a.b, z);
        sc0 sc0VarJ0 = lxVar.J0();
        List list = lxVar.q;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((v91) obj).j() != ad1.IN_VARIANCE) {
                break;
            }
            arrayList.add(obj);
        }
        l7 l7VarJ1 = he.j1(arrayList);
        ArrayList arrayList2 = new ArrayList(ae.y0(l7VarJ1));
        Iterator it = l7VarJ1.iterator();
        while (true) {
            c20 c20Var = (c20) it;
            if (!c20Var.b.hasNext()) {
                txVar.X0(null, sc0VarJ0, uq.b, arrayList2, ((v91) he.T0(list)).n(), zh0.f, cn.e, null);
                tx txVar2 = txVar;
                txVar2.C = true;
                return txVar2;
            }
            a20 a20Var = (a20) c20Var.next();
            int i = a20Var.a;
            v91 v91Var = (v91) a20Var.b;
            String strB = v91Var.getName().b();
            tx txVar3 = txVar;
            arrayList2.add(new wc1(txVar3, null, i, e4.f47a, ij0.f(strB.equals("T") ? "instance" : strB.equals("E") ? "receiver" : strB.toLowerCase(Locale.ROOT)), v91Var.n(), false, false, false, null, t11.a));
            txVar = txVar3;
        }
    }

    public static vu$b a(XmlResourceParser xmlResourceParser, Resources resources) {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlResourceParser.require(2, null, "font-family");
        if (!xmlResourceParser.getName().equals("font-family")) {
            c(xmlResourceParser);
            return null;
        }
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), e.f35e);
        String string = typedArrayObtainAttributes.getString(0);
        String string2 = typedArrayObtainAttributes.getString(4);
        String string3 = typedArrayObtainAttributes.getString(5);
        int resourceId = typedArrayObtainAttributes.getResourceId(1, 0);
        int integer = typedArrayObtainAttributes.getInteger(2, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(3, 500);
        String string4 = typedArrayObtainAttributes.getString(6);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlResourceParser.next() != 3) {
                c(xmlResourceParser);
            }
            return new vu$e(new pu(string, string2, string3, b(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlResourceParser.next() != 3) {
            if (xmlResourceParser.getEventType() == 2) {
                if (xmlResourceParser.getName().equals("font")) {
                    TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), e.f36f);
                    int i = typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(8) ? 8 : 1, 400);
                    boolean z = 1 == typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(6) ? 6 : 2, 0);
                    int i2 = typedArrayObtainAttributes2.hasValue(9) ? 9 : 3;
                    String string5 = typedArrayObtainAttributes2.getString(typedArrayObtainAttributes2.hasValue(7) ? 7 : 4);
                    int i3 = typedArrayObtainAttributes2.getInt(i2, 0);
                    int i4 = typedArrayObtainAttributes2.hasValue(5) ? 5 : 0;
                    int resourceId2 = typedArrayObtainAttributes2.getResourceId(i4, 0);
                    String string6 = typedArrayObtainAttributes2.getString(i4);
                    typedArrayObtainAttributes2.recycle();
                    while (xmlResourceParser.next() != 3) {
                        c(xmlResourceParser);
                    }
                    arrayList.add(new vu$d(i, i3, resourceId2, string6, string5, z));
                } else {
                    c(xmlResourceParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new vu$c((vu$d[]) arrayList.toArray(new vu$d[0]));
    }

    public static void a(Object obj) {
        LongSparseArray longSparseArray;
        if (!d) {
            try {
                c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException unused) {
            }
            d = true;
        }
        Class cls = c;
        if (cls == null) {
            return;
        }
        if (!f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            f = true;
        }
        Field field = e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException unused3) {
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public static List b(Resources resources, int i) {
        if (i == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static PropertyValuesHolder c(TypedArray typedArray, int i, int i2, int i3, String str) {
        int color;
        int color2;
        int color3;
        PropertyValuesHolder propertyValuesHolderOfFloat;
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z = typedValuePeekValue != null;
        int i4 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        int i5 = z2 ? typedValuePeekValue2.type : 0;
        if (i == 4) {
            i = ((z && d(i4)) || (z2 && d(i5))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            so0$a[] so0_aArrC = e4.c(string);
            so0$a[] so0_aArrC2 = e4.c(string2);
            if (so0_aArrC != null || so0_aArrC2 != null) {
                if (so0_aArrC != null) {
                    a aVar = new a();
                    if (so0_aArrC2 == null) {
                        return PropertyValuesHolder.ofObject(str, aVar, so0_aArrC);
                    }
                    if (e4.a(so0_aArrC, so0_aArrC2)) {
                        return PropertyValuesHolder.ofObject(str, aVar, so0_aArrC, so0_aArrC2);
                    }
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                if (so0_aArrC2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), so0_aArrC2);
                }
            }
            return null;
        }
        w6 w6Var = i == 3 ? w6.a : null;
        if (z3) {
            if (z) {
                float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                if (z2) {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z) {
            if (i4 == 5) {
                color2 = (int) typedArray.getDimension(i2, 0.0f);
            } else {
                color2 = d(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i5 == 5) {
                    color3 = (int) typedArray.getDimension(i3, 0.0f);
                } else {
                    color3 = d(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z2) {
            if (i5 == 5) {
                color = (int) typedArray.getDimension(i3, 0.0f);
            } else {
                color = d(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt != null && w6Var != null) {
            propertyValuesHolderOfInt.setEvaluator(w6Var);
        }
        return propertyValuesHolderOfInt;
    }

    public static void c(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static boolean d(int i) {
        return i >= 28 && i <= 31;
    }

    public static ValueAnimator e(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ObjectAnimator objectAnimator, XmlResourceParser xmlResourceParser) {
        int i;
        ValueAnimator valueAnimator;
        TypedArray typedArrayH = ak.h(resources, theme, attributeSet, ak.g$1);
        TypedArray typedArrayH2 = ak.h(resources, theme, attributeSet, ak.k$1);
        ValueAnimator valueAnimator2 = objectAnimator == null ? new ValueAnimator() : objectAnimator;
        long j = ak.g(xmlResourceParser, "duration") ? typedArrayH.getInt(1, 300) : 300;
        long j2 = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "startOffset") != null ? typedArrayH.getInt(2, 0) : 0;
        int i2 = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueType") != null ? typedArrayH.getInt(7, 4) : 4;
        if ((xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueFrom") != null) && xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueTo") != null) {
            if (i2 == 4) {
                TypedValue typedValuePeekValue = typedArrayH.peekValue(5);
                boolean z = typedValuePeekValue != null;
                int i3 = z ? typedValuePeekValue.type : 0;
                TypedValue typedValuePeekValue2 = typedArrayH.peekValue(6);
                boolean z2 = typedValuePeekValue2 != null;
                i2 = ((z && d(i3)) || (z2 && d(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
            }
            PropertyValuesHolder propertyValuesHolderC = c(typedArrayH, i2, 5, 6, AppConfig.CUSTOM);
            if (propertyValuesHolderC != null) {
                valueAnimator2.setValues(propertyValuesHolderC);
            }
        }
        valueAnimator2.setDuration(j);
        valueAnimator2.setStartDelay(j2);
        valueAnimator2.setRepeatCount(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "repeatCount") != null ? typedArrayH.getInt(3, 0) : 0);
        valueAnimator2.setRepeatMode(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "repeatMode") != null ? typedArrayH.getInt(4, 1) : 1);
        if (typedArrayH2 != null) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) valueAnimator2;
            String strE = ak.e(typedArrayH2, xmlResourceParser, "pathData", 1);
            if (strE != null) {
                String strE2 = ak.e(typedArrayH2, xmlResourceParser, "propertyXName", 2);
                String strE3 = ak.e(typedArrayH2, xmlResourceParser, "propertyYName", 3);
                if (strE2 == null && strE3 == null) {
                    throw new InflateException(typedArrayH2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path pathD = e4.d(strE);
                PathMeasure pathMeasure = new PathMeasure(pathD, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float length = 0.0f;
                do {
                    length += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(length));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(pathD, false);
                int iMin = Math.min(100, ((int) (length / 0.5f)) + 1);
                float[] fArr = new float[iMin];
                float[] fArr2 = new float[iMin];
                float[] fArr3 = new float[2];
                float f2 = length / (iMin - 1);
                int i4 = 0;
                float f3 = 0.0f;
                int i5 = 0;
                while (true) {
                    if (i4 >= iMin) {
                        break;
                    }
                    int i6 = iMin;
                    pathMeasure2.getPosTan(f3 - ((Float) arrayList.get(i5)).floatValue(), fArr3, null);
                    fArr[i4] = fArr3[0];
                    fArr2[i4] = fArr3[1];
                    int i7 = i5 + 1;
                    f3 += f2;
                    if (i7 < arrayList.size() && f3 > ((Float) arrayList.get(i7)).floatValue()) {
                        pathMeasure2.nextContour();
                        i5 = i7;
                    }
                    i4++;
                    iMin = i6;
                }
                PropertyValuesHolder propertyValuesHolderOfFloat = strE2 != null ? PropertyValuesHolder.ofFloat(strE2, fArr) : null;
                PropertyValuesHolder propertyValuesHolderOfFloat2 = strE3 != null ? PropertyValuesHolder.ofFloat(strE3, fArr2) : null;
                if (propertyValuesHolderOfFloat == null) {
                    objectAnimator2.setValues(propertyValuesHolderOfFloat2);
                } else if (propertyValuesHolderOfFloat2 == null) {
                    objectAnimator2.setValues(propertyValuesHolderOfFloat);
                } else {
                    objectAnimator2.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
                }
                i = 0;
            } else {
                i = 0;
                objectAnimator2.setPropertyName(ak.e(typedArrayH2, xmlResourceParser, "propertyName", 0));
            }
        } else {
            i = 0;
        }
        int resourceId = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") != null ? typedArrayH.getResourceId(i, i) : i;
        if (resourceId > 0) {
            valueAnimator = valueAnimator2;
            valueAnimator.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        } else {
            valueAnimator = valueAnimator2;
        }
        typedArrayH.recycle();
        if (typedArrayH2 != null) {
            typedArrayH2.recycle();
        }
        return valueAnimator;
    }

    public abstract v3 a(Serializable serializable);

    public abstract w01 a(z81 z81Var, jc0 jc0Var);

    public abstract void a(la laVar);

    public abstract int clampViewPositionHorizontal(View view, int i);

    public abstract int clampViewPositionVertical(View view, int i);

    public void f(la laVar, Collection collection) {
        laVar.E0(collection);
    }

    public int getViewHorizontalDragRange(View view) {
        return 0;
    }

    public int getViewVerticalDragRange() {
        return 0;
    }

    public void onEdgeDragStarted(int i, int i2) {
    }

    public void onEdgeTouched() {
    }

    public void onViewCaptured(View view, int i) {
    }

    public abstract void onViewDragStateChanged(int i);

    public abstract void onViewPositionChanged(View view, int i, int i2);

    public abstract void onViewReleased(View view, float f2, float f3);

    public abstract boolean tryCaptureView(View view, int i);
}
