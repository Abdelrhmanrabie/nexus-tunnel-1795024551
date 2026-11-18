package defpackage;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import androidx.activity.ComponentActivity;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.lingala.zip4j.util.InternalZipConstants;
import net.openvpn.ovpn3.XMLRPC;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.vpn.service.RenzOpenVPNservice;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class b2 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static g40$a f11a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final m6 f12a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static pc1$a f15a;
    public static m6 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static RenzOpenVPNservice f19b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f17a = {R.style.bk, R.style.br, R.style.bs, R.style.hc, R.style.hd, R.style.he, R.style.hf, R.style.hg, R.style.hh, R.style.ij, R.style.jb, R.style.jc, R.style.kb, R.style.ng, R.style.nn, R.style.nt, R.style.nu, R.style.ny, R.style.oj, R.style.p8, R.style.sl, R.style.vc, R.style.wx, R.style.xl, R.style.xn, R.style.a1v, R.style.a1z, R.style.a5q, R.style.a63};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f21b = {android.R.attr.layout_gravity};
    public static final int[] c = {android.R.attr.minWidth};
    public static final int[] d = {R.style.bk, R.style.br, R.style.fn, R.style.ng, R.style.a1z, R.style.a63};
    public static final int[] e = {android.R.attr.layout, R.style.da, R.style.db, R.style.sa, R.style.sb, R.style.v8, R.style.a0b, R.style.a0e};
    public static final int[] f = {android.R.attr.src, R.style.a15, R.style.a5n, R.style.a5o};
    public static final int[] g = {android.R.attr.thumb, R.style.a5j, R.style.a5k, R.style.a5l};
    public static final int[] h = {android.R.attr.textAppearance, android.R.attr.drawableTop, android.R.attr.drawableBottom, android.R.attr.drawableLeft, android.R.attr.drawableRight, android.R.attr.drawableStart, android.R.attr.drawableEnd};
    public static final int[] i = {android.R.attr.textAppearance, R.style.be, R.style.bf, R.style.bg, R.style.bh, R.style.bi, R.style.jo, R.style.jp, R.style.jq, R.style.jr, R.style.jt, R.style.ju, R.style.jv, R.style.jw, R.style.kf, R.style.m0, R.style.mu, R.style.n3, R.style.q0, R.style.s4, R.style.a3a, R.style.a4t};
    public static final int[] j = {android.R.attr.windowIsFloating, android.R.attr.windowAnimationStyle, R.style.h, R.style.i, R.style.j, R.style.k, R.style.l, R.style.m, R.style.n, R.style.o, R.style.p, R.style.q, R.style.r, R.style.s, R.style.t, R.style.v, R.style.w, R.style.x, R.style.y, R.style.z, R.style.a0, R.style.a1, R.style.a2, R.style.a3, R.style.a4, R.style.a5, R.style.a6, R.style.a7, R.style.a8, R.style.a9, R.style.a_, R.style.aa, R.style.ab, R.style.ac, R.style.ai, R.style.ap, R.style.aq, R.style.ar, R.style.as, R.style.bd, R.style.cm, R.style.d4, R.style.d5, R.style.d6, R.style.d7, R.style.d8, R.style.dd, R.style.f72de, R.style.e4, R.style.ec, R.style.g0, R.style.g1, R.style.g2, R.style.g4, R.style.g5, R.style.g6, R.style.g7, R.style.gn, R.style.gp, R.style.h0, R.style.hr, R.style.j3, R.style.j8, R.style.j9, R.style.je, R.style.jj, R.style.k2, R.style.k3, R.style.k8, R.style.k9, R.style.ka, R.style.nt, R.style.od, R.style.s7, R.style.s8, R.style.s9, R.style.s_, R.style.sc, R.style.sd, R.style.se, R.style.sf, R.style.sg, R.style.sh, R.style.si, R.style.sj, R.style.sk, R.style.w5, R.style.w6, R.style.w7, R.style.ww, R.style.wy, R.style.y8, R.style.y_, R.style.ya, R.style.yb, R.style.zj, R.style.zo, R.style.zq, R.style.zr, R.style.a0s, R.style.a0t, R.style.a2a, R.style.a3x, R.style.a3z, R.style.a40, R.style.a41, R.style.a43, R.style.a44, R.style.a45, R.style.a46, R.style.a4h, R.style.a4i, R.style.a65, R.style.a66, R.style.a68, R.style.a69, R.style.a77, R.style.a7l, R.style.a7m, R.style.a7n, R.style.a7o, R.style.a7p, R.style.a7q, R.style.a7r, R.style.a7s, R.style.a7t, R.style.a7u};
    public static final int[] k = {R.style.aw};
    public static final int[] l = {android.R.attr.checkMark, R.style.e1, R.style.e2, R.style.e3};
    public static final int[] m = {android.R.attr.button, R.style.d9, R.style.df, R.style.dg};
    public static final int[] n = {R.style.b_, R.style.ba, R.style.c1, R.style.fz, R.style.js, R.style.n9, R.style.a0r, R.style.a56};
    public static final int[] o = {android.R.attr.gravity, android.R.attr.orientation, android.R.attr.baselineAligned, android.R.attr.baselineAlignedChildIndex, android.R.attr.weightSum, R.style.jc, R.style.jh, R.style.tz, R.style.a07};
    public static final int[] p = {android.R.attr.dropDownHorizontalOffset, android.R.attr.dropDownVerticalOffset};
    public static final int[] q = {android.R.attr.enabled, android.R.attr.id, android.R.attr.visible, android.R.attr.menuCategory, android.R.attr.orderInCategory, android.R.attr.checkableBehavior};
    public static final int[] r = {android.R.attr.icon, android.R.attr.enabled, android.R.attr.id, android.R.attr.checked, android.R.attr.visible, android.R.attr.menuCategory, android.R.attr.orderInCategory, android.R.attr.title, android.R.attr.titleCondensed, android.R.attr.alphabeticShortcut, android.R.attr.numericShortcut, android.R.attr.checkable, android.R.attr.onClick, R.style.u, R.style.ad, R.style.af, R.style.ay, R.style.hb, R.style.o6, R.style.o8, R.style.vl, R.style.a05, R.style.a6a};
    public static final int[] s = {android.R.attr.windowAnimationStyle, android.R.attr.itemTextAppearance, android.R.attr.horizontalDivider, android.R.attr.verticalDivider, android.R.attr.headerBackground, android.R.attr.itemBackground, android.R.attr.itemIconDisabledAlpha, R.style.xc, R.style.a1p};
    public static final int[] t = {android.R.attr.popupBackground, android.R.attr.popupAnimationStyle, R.style.vv};
    public static final int[] u = {R.style.vx, R.style.w3};
    public static final int[] v = {android.R.attr.focusable, android.R.attr.maxWidth, android.R.attr.inputType, android.R.attr.imeOptions, R.style.fg, R.style.h3, R.style.iv, R.style.na, R.style.o9, R.style.q2, R.style.y5, R.style.y6, R.style.zh, R.style.zi, R.style.a1u, R.style.a23, R.style.a7c};
    public static final int[] w = {android.R.attr.entries, android.R.attr.popupBackground, android.R.attr.prompt, android.R.attr.dropDownWidth, R.style.wx};
    public static final int[] x = {android.R.attr.textOn, android.R.attr.textOff, android.R.attr.thumb, R.style.a0a, R.style.a0y, R.style.a27, R.style.a28, R.style.a2b, R.style.a5d, R.style.a5e, R.style.a5f, R.style.a6f, R.style.a6m, R.style.a6n};
    public static final int[] y = {android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.textColorHint, android.R.attr.textColorLink, android.R.attr.shadowColor, android.R.attr.shadowDx, android.R.attr.shadowDy, android.R.attr.shadowRadius, android.R.attr.fontFamily, android.R.attr.textFontWeight, R.style.mu, R.style.n3, R.style.a3a, R.style.a4t};
    public static final int[] z = {android.R.attr.gravity, android.R.attr.minHeight, R.style.d_, R.style.fo, R.style.fp, R.style.hc, R.style.hd, R.style.he, R.style.hf, R.style.hg, R.style.hh, R.style.sl, R.style.sm, R.style.ts, R.style.u0, R.style.v_, R.style.va, R.style.wx, R.style.a1v, R.style.a1x, R.style.a1y, R.style.a5q, R.style.a5u, R.style.a5v, R.style.a5w, R.style.a5x, R.style.a5y, R.style.a5z, R.style.a61, R.style.a62};
    public static final int[] A = {android.R.attr.theme, android.R.attr.focusable, R.style.vz, R.style.w2, R.style.a54};
    public static final int[] B = {android.R.attr.background, R.style.bt, R.style.bu};
    public static final int[] C = {android.R.attr.id, android.R.attr.layout, android.R.attr.inflatedId};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f18a = new String[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final defpackage.e f9a = new defpackage.e(21);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final fm$a f10a = new fm$a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f16a = {112, 114, 111, 0};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final byte[] f20b = {112, 114, 109, 0};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final n8$a f13a = new n8$a();
    public static final ci0 a = new ci0("NO_THREAD_ELEMENTS", 1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final nu f14a = new nu(0);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface e {
        void validateRequestPermissionsRequestCode(int i);
    }

    static {
        Object obj = null;
        f12a = new m6(obj, obj, obj);
    }

    public static a70 a(bu0 bu0Var) {
        int modifiers = bu0Var.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            return a70.c$8;
        }
        if (Modifier.isPrivate(modifiers)) {
            return a70.c$5;
        }
        if (Modifier.isProtected(modifiers)) {
            return Modifier.isStatic(modifiers) ? a70.c : a70.c$11;
        }
        return a70.c$10;
    }

    public static ha a(Context context, pu puVar) throws PackageManager.NameNotFoundException {
        Cursor cursorQuery;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = puVar.a;
        int i2 = 0;
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException(ak.m("No package found for authority: ", str));
        }
        String str2 = providerInfoResolveContentProvider.packageName;
        String str3 = puVar.b;
        if (!str2.equals(str3)) {
            throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str3);
        }
        Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        nu nuVar = f14a;
        Collections.sort(arrayList, nuVar);
        List listB = puVar.d;
        if (listB == null) {
            listB = v3.b(resources, 0);
        }
        int i3 = 0;
        loop1: while (true) {
            cursorQuery = null;
            if (i3 >= listB.size()) {
                providerInfoResolveContentProvider = null;
                break;
            }
            ArrayList arrayList2 = new ArrayList((Collection) listB.get(i3));
            Collections.sort(arrayList2, nuVar);
            if (arrayList.size() == arrayList2.size()) {
                int i4 = 0;
                while (true) {
                    if (i4 >= arrayList.size()) {
                        break loop1;
                    }
                    if (!Arrays.equals((byte[]) arrayList.get(i4), (byte[]) arrayList2.get(i4))) {
                        break;
                    }
                    i4++;
                }
            }
            i3++;
        }
        int i5 = 1;
        int i6 = 6;
        if (providerInfoResolveContentProvider == null) {
            return new ha(i5, cursorQuery, i6);
        }
        String str4 = providerInfoResolveContentProvider.authority;
        ArrayList arrayList3 = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str4).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str4).appendPath("file").build();
        ou$b ou_b = Build.VERSION.SDK_INT < 24 ? new ou$b(context, uriBuild, 0) : new ou$b(context, uriBuild, 1);
        try {
            String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
            String[] strArr2 = {puVar.c};
            int i7 = ou_b.G0;
            ContentProviderClient contentProviderClient = ou_b.a;
            if (i7 == 0 ? contentProviderClient != null : contentProviderClient != null) {
                try {
                    cursorQuery = contentProviderClient.query(uriBuild, strArr, "query = ?", strArr2, null, null);
                } catch (RemoteException unused) {
                }
            }
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("result_code");
                arrayList3 = new ArrayList();
                int columnIndex2 = cursorQuery.getColumnIndex("_id");
                int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                while (cursorQuery.moveToNext()) {
                    arrayList3.add(new xu(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : i2, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, columnIndex != -1 ? cursorQuery.getInt(columnIndex) : i2));
                    i2 = 0;
                }
            }
            return new ha(0, (xu[]) arrayList3.toArray(new xu[0]), i6);
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            ou_b.close();
        }
    }

    public static final String a(Method method) {
        return method.getName() + ae.J0(method.getParameterTypes(), "(", ")", p0.b$14) + bt0.b(method.getReturnType());
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.util.Map] */
    public static final String a(ox oxVar) {
        ij0 ij0Var;
        la laVarB = ub0.A(oxVar) ? b((la) oxVar) : null;
        if (laVarB != null) {
            la laVarL = ym.l(laVarB);
            if (laVarL instanceof nq0) {
                ub0.A(laVarL);
                la laVarB2 = ym.b(ym.l(laVarL), ba.b$27);
                if (laVarB2 != null && (ij0Var = (ij0) ca.a.get(ym.g(laVarB2))) != null) {
                    return ij0Var.b();
                }
            } else if (laVarL instanceof q01) {
                int i2 = z9.$r8$clinit;
                LinkedHashMap linkedHashMap = c21.j;
                String strP = defpackage.e.p((q01) laVarL);
                ij0 ij0Var2 = strP == null ? null : (ij0) linkedHashMap.get(strP);
                if (ij0Var2 != null) {
                    return ij0Var2.b();
                }
            }
        }
        return null;
    }

    public static Collection a(vg0 vg0Var, lm lmVar, int i2) {
        if ((i2 & 1) != 0) {
            lmVar = lm.m;
        }
        vg0.a.getClass();
        return vg0Var.f(lmVar, p0.b$13);
    }

    public static ml a(cc1 cc1Var) {
        if (cc1Var instanceof ml) {
            return (ml) cc1Var;
        }
        cc1Var.L0();
        boolean zX = false;
        if ((cc1Var.L0().b() instanceof v91) || (cc1Var instanceof tk0)) {
            od odVarB = cc1Var.L0().b();
            w91 w91Var = odVarB instanceof w91 ? (w91) odVarB : null;
            zX = (w91Var == null || w91Var.s) ? true ^ defpackage.e.x(defpackage.e.s(false, (ld) defpackage.e.f37g, 24), defpackage.e.c1(cc1Var), z81.b.a) : true;
        }
        if (!zX) {
            return null;
        }
        if (cc1Var instanceof zt) {
            zt ztVar = (zt) cc1Var;
            e4.a((Object) ztVar.c.L0(), (Object) ztVar.d.L0());
        }
        return new ml(defpackage.e.c1(cc1Var));
    }

    public static oo a(oo ooVar, co coVar, List list) {
        List parameters = coVar.j.getParameters();
        ArrayList arrayList = new ArrayList(ae.y0(parameters));
        Iterator it = parameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((v91) it.next()).a());
        }
        return new oo(ooVar, coVar, list, ye1.j(he.k1(arrayList, list)));
    }

    public static vg0 a(String str, SequencedCollection sequencedCollection) {
        vg0 ybVar;
        ArrayList arrayList = new ArrayList(ae.y0(sequencedCollection));
        Iterator it = sequencedCollection.iterator();
        while (it.hasNext()) {
            arrayList.add(((fc0) it.next()).m());
        }
        n11 n11VarB1 = defpackage.e.b1(arrayList);
        int i2 = n11VarB1.b;
        if (i2 != 0) {
            ybVar = i2 != 1 ? new yb(str, (vg0[]) n11VarB1.toArray(new vg0[0])) : (vg0) n11VarB1.get(0);
        } else {
            ybVar = vg0.b.b;
        }
        return n11VarB1.b <= 1 ? ybVar : new l91(ybVar);
    }

    public static /* synthetic */ void a(int i2) {
        String str = (i2 == 12 || i2 == 23 || i2 == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 12 || i2 == 23 || i2 == 25) ? 2 : 3];
        switch (i2) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 30:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case 24:
                objArr[0] = "enumClass";
                break;
            case 26:
            case 27:
            case 28:
                objArr[0] = "descriptor";
                break;
            case 29:
                objArr[0] = "owner";
                break;
        }
        if (i2 == 12) {
            objArr[1] = "createSetter";
        } else if (i2 == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i2 != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 27:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 28:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 29:
            case 30:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 12 && i2 != 23 && i2 != 25) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, String[] strArr, int i2) {
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (TextUtils.isEmpty(strArr[i3])) {
                throw new IllegalArgumentException(fb$1.m(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i3], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i3));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < strArr.length; i5++) {
                if (!hashSet.contains(Integer.valueOf(i5))) {
                    strArr2[i4] = strArr[i5];
                    i4++;
                }
            }
        }
        if (activity instanceof e) {
            ((e) activity).validateRequestPermissionsRequestCode(i2);
        }
        activity.requestPermissions(strArr, i2);
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        drawable.applyTheme(theme);
    }

    public static void a(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i2);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i3);
    }

    public static void a(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
            return;
        }
        i71 i71Var = i71.p;
        if (i71Var != null && i71Var.b == view) {
            i71.b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new i71(charSequence, view);
            return;
        }
        i71 i71Var2 = i71.q;
        if (i71Var2 != null && i71Var2.b == view) {
            i71Var2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static final void a(li liVar, Object obj) {
        if (obj == a) {
            return;
        }
        if (!(obj instanceof s61)) {
            liVar.i(null, gm.b$5).getClass();
            d.AnonymousClass0.m$1();
            return;
        }
        s61 s61Var = (s61) obj;
        gi[] giVarArr = s61Var.c;
        int length = giVarArr.length - 1;
        if (length < 0) {
            return;
        }
        gi giVar = giVarArr[length];
        Object obj2 = s61Var.b[length];
        throw null;
    }

    public static final void a(li liVar, Throwable th) {
        try {
            p3 p3Var = (p3) liVar.a(ke.f52b);
            if (p3Var != null) {
                p3Var.v(th);
            } else {
                defpackage.e.K(liVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                defpackage.e.e(runtimeException, th);
                th = runtimeException;
            }
            defpackage.e.K(liVar, th);
        }
    }

    public static void a(ta taVar, Object[] objArr) {
        if (taVar.a().size() == objArr.length) {
            return;
        }
        throw new IllegalArgumentException("Callable expects " + taVar.a().size() + " arguments, but " + objArr.length + " were provided.");
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(Context context, String str, File file, String str2) throws Throwable {
        ZipFile zipFile;
        InputStream inputStream = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        try {
            try {
                zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
                try {
                    ZipEntry entry = zipFile.getEntry("lib/" + str2 + InternalZipConstants.ZIP_FILE_SEPARATOR + str + ".so");
                    if (entry == null) {
                        entry = zipFile.getEntry("jni/" + str2 + InternalZipConstants.ZIP_FILE_SEPARATOR + str + ".so");
                        if (entry == null) {
                            throw new Exception("Unable to find file in apk:lib/" + str2 + InternalZipConstants.ZIP_FILE_SEPARATOR + str);
                        }
                    }
                    InputStream inputStream2 = zipFile.getInputStream(entry);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i2 = inputStream2.read(bArr);
                        if (i2 <= 0) {
                            break;
                        }
                        Thread.yield();
                        fileOutputStream.write(bArr, 0, i2);
                    }
                    fileOutputStream.close();
                    file.setReadable(true, false);
                    file.setExecutable(true, false);
                    file.setWritable(true);
                    try {
                        inputStream2.close();
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                    try {
                        zipFile.close();
                    } catch (Exception e3) {
                        e3.getMessage();
                    }
                    return true;
                } catch (Exception e4) {
                    e = e4;
                    e.getMessage();
                    if (0 != 0) {
                        try {
                            (objArr2 == true ? 1 : 0).close();
                        } catch (Exception e5) {
                            e5.getMessage();
                        }
                    }
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e6) {
                            e6.getMessage();
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e7) {
                        e7.getMessage();
                    }
                }
                if (0 != 0) {
                    throw th;
                }
                try {
                    (objArr == true ? 1 : 0).close();
                    throw th;
                } catch (Exception e8) {
                    e8.getMessage();
                    throw th;
                }
            }
        } catch (Exception e9) {
            e = e9;
            zipFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                inputStream.close();
            }
            if (0 != 0) {
                throw th;
            }
            (objArr == true ? 1 : 0).close();
            throw th;
        }
    }

    public static boolean a(ch chVar) {
        int[] iArr = chVar.V;
        int i2 = iArr[0];
        int i3 = iArr[1];
        dh dhVar = chVar.W;
        if (dhVar == null) {
            dhVar = null;
        }
        if (dhVar != null) {
            int i4 = dhVar.V[0];
        }
        if (dhVar != null) {
            int i5 = dhVar.V[1];
        }
        boolean z2 = i2 == 1 || chVar.x() || i2 == 2 || (i2 == 3 && chVar.s == 0 && chVar.Z == 0.0f && chVar.q(0)) || (i2 == 3 && chVar.s == 1 && chVar.r(0, chVar.n()));
        boolean z3 = i3 == 1 || chVar.y() || i3 == 2 || (i3 == 3 && chVar.t == 0 && chVar.Z == 0.0f && chVar.q(1)) || (i3 == 3 && chVar.t == 1 && chVar.r(1, chVar.i()));
        return (chVar.Z > 0.0f && (z2 || z3)) || (z2 && z3);
    }

    public static boolean a(ja jaVar, ja jaVar2) {
        if (!(jaVar2 instanceof q50) || !(jaVar instanceof ox)) {
            return false;
        }
        q50 q50Var = (q50) jaVar2;
        q50Var.f().size();
        ox oxVar = (ox) jaVar;
        oxVar.f().size();
        for (jo0 jo0Var : he.k1(q50Var.V0().f(), oxVar.a().f())) {
            if ((b((ox) jaVar2, (wc1) jo0Var.b) instanceof y80.c) != (b(oxVar, (wc1) jo0Var.c) instanceof y80.c)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] a(go[] goVarArr, byte[] bArr) throws IOException {
        int i2 = 0;
        int length = 0;
        for (go goVar : goVarArr) {
            length += ((((goVar.g * 2) + 7) & (-8)) / 8) + (goVar.e * 2) + b(goVar.a, goVar.b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + goVar.f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, e4.c)) {
            int length2 = goVarArr.length;
            while (i2 < length2) {
                go goVar2 = goVarArr[i2];
                m(byteArrayOutputStream, goVar2, b(goVar2.a, goVar2.b, bArr));
                l(byteArrayOutputStream, goVar2);
                i2++;
            }
        } else {
            for (go goVar3 : goVarArr) {
                m(byteArrayOutputStream, goVar3, b(goVar3.a, goVar3.b, bArr));
            }
            int length3 = goVarArr.length;
            while (i2 < length3) {
                l(byteArrayOutputStream, goVarArr[i2]);
                i2++;
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0030, code lost:
    
        if (r1.canExecute() != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.File b(android.content.Context r6, java.lang.String r7, java.io.File r8) {
        /*
            java.lang.String r0 = ".so"
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L96
            android.content.pm.ApplicationInfo r2 = r6.getApplicationInfo()     // Catch: java.lang.Throwable -> L96
            java.lang.String r2 = r2.nativeLibraryDir     // Catch: java.lang.Throwable -> L96
            java.lang.String r0 = r7.concat(r0)     // Catch: java.lang.Throwable -> L96
            r1.<init>(r2, r0)     // Catch: java.lang.Throwable -> L96
            boolean r0 = r1.exists()     // Catch: java.lang.Throwable -> L96
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L33
            boolean r0 = r1.canExecute()     // Catch: java.lang.Throwable -> L96
            if (r0 == 0) goto L20
            goto L32
        L20:
            r1.setReadable(r2)     // Catch: java.lang.Throwable -> L96
            r1.setExecutable(r2)     // Catch: java.lang.Throwable -> L96
            r1.setWritable(r3)     // Catch: java.lang.Throwable -> L96
            r1.setWritable(r2, r2)     // Catch: java.lang.Throwable -> L96
            boolean r0 = r1.canExecute()     // Catch: java.lang.Throwable -> L96
            if (r0 == 0) goto L53
        L32:
            return r1
        L33:
            boolean r0 = r8.exists()     // Catch: java.lang.Throwable -> L96
            if (r0 == 0) goto L53
            boolean r0 = r8.canExecute()     // Catch: java.lang.Throwable -> L96
            if (r0 == 0) goto L40
            goto L95
        L40:
            r8.setReadable(r2)     // Catch: java.lang.Throwable -> L96
            r8.setExecutable(r2)     // Catch: java.lang.Throwable -> L96
            r8.setWritable(r3)     // Catch: java.lang.Throwable -> L96
            r8.setWritable(r2, r2)     // Catch: java.lang.Throwable -> L96
            boolean r0 = r8.canExecute()     // Catch: java.lang.Throwable -> L96
            if (r0 == 0) goto L53
            goto L95
        L53:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L96
            r0.<init>()     // Catch: java.lang.Throwable -> L96
            java.lang.String[] r1 = android.os.Build.SUPPORTED_ABIS     // Catch: java.lang.Throwable -> L96
            if (r1 == 0) goto L6d
            int r2 = r1.length     // Catch: java.lang.Throwable -> L96
        L5d:
            if (r3 >= r2) goto L6d
            r4 = r1[r3]     // Catch: java.lang.Throwable -> L96
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L96
            if (r5 != 0) goto L6a
            r0.add(r4)     // Catch: java.lang.Throwable -> L96
        L6a:
            int r3 = r3 + 1
            goto L5d
        L6d:
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L96
        L71:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L96
            if (r1 == 0) goto L9a
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L96
            java.lang.String r2 = "os.arch"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch: java.lang.Throwable -> L96
            if (r2 == 0) goto L8f
            java.lang.String r3 = "686"
            boolean r2 = r2.contains(r3)     // Catch: java.lang.Throwable -> L96
            if (r2 == 0) goto L8f
            java.lang.String r1 = "x86"
        L8f:
            boolean r1 = a(r6, r7, r8, r1)     // Catch: java.lang.Throwable -> L96
            if (r1 == 0) goto L71
        L95:
            return r8
        L96:
            r6 = move-exception
            r6.getMessage()
        L9a:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b2.b(android.content.Context, java.lang.String, java.io.File):java.io.File");
    }

    public static final Object b(li liVar, Object obj) {
        if (obj == null) {
            obj = liVar.i(0, gm.b$4);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return liVar.i(new s61(liVar, ((Number) obj).intValue()), gm.b$6);
        }
        obj.getClass();
        d.AnonymousClass0.m$1();
        return null;
    }

    public static String b(String str, String str2, byte[] bArr) {
        byte[] bArr2 = e4.e;
        boolean zEquals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = e4.d;
        Object obj = (zEquals || Arrays.equals(bArr, bArr3)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(obj)) {
                return str2.replace(":", "!");
            }
            if (":".equals(obj)) {
                return str2.replace("!", ":");
            }
        } else {
            if (str2.equals("classes.dex")) {
                return str;
            }
            if (str2.contains("!") || str2.contains(":")) {
                if ("!".equals(obj)) {
                    return str2.replace(":", "!");
                }
                if (":".equals(obj)) {
                    return str2.replace("!", ":");
                }
            } else if (!str2.endsWith(".apk")) {
                return fb$1.m(defpackage.e.d(str), (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ":" : "!", str2);
            }
        }
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final la b(la laVar) {
        ba baVar;
        if (!c21.k.contains(((pk) laVar).getName()) && !ca.d.contains(((pk) ym.l(laVar)).getName())) {
            return null;
        }
        if (laVar instanceof nq0 ? true : laVar instanceof kq0) {
            baVar = ba.b$1;
        } else {
            if (!(laVar instanceof q01)) {
                return null;
            }
            baVar = ba.b$2;
        }
        return ym.b(laVar, baVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [uq] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.ArrayList] */
    public static qg b(Object obj) {
        wp0 wp0Var;
        ?? r1;
        if (obj instanceof Byte) {
            return new ga(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new a01(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new b30(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new rf0(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new ec((Character) obj);
        }
        if (obj instanceof Float) {
            return new bp(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new bp(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new bp((Boolean) obj);
        }
        if (obj instanceof String) {
            return new h31((String) obj);
        }
        boolean z2 = obj instanceof byte[];
        ?? SingletonList = uq.b;
        int i2 = 0;
        if (z2) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            if (length != 0) {
                if (length != 1) {
                    SingletonList = new ArrayList(bArr.length);
                    int length2 = bArr.length;
                    while (i2 < length2) {
                        SingletonList.add(Byte.valueOf(bArr[i2]));
                        i2++;
                    }
                } else {
                    SingletonList = Collections.singletonList(Byte.valueOf(bArr[0]));
                }
            }
            wp0Var = wp0.BYTE;
            r1 = SingletonList;
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length3 = sArr.length;
            if (length3 != 0) {
                if (length3 != 1) {
                    SingletonList = new ArrayList(sArr.length);
                    int length4 = sArr.length;
                    while (i2 < length4) {
                        SingletonList.add(Short.valueOf(sArr[i2]));
                        i2++;
                    }
                } else {
                    SingletonList = Collections.singletonList(Short.valueOf(sArr[0]));
                }
            }
            wp0Var = wp0.SHORT;
            r1 = SingletonList;
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length5 = iArr.length;
            if (length5 != 0) {
                if (length5 != 1) {
                    SingletonList = new ArrayList(iArr.length);
                    int length6 = iArr.length;
                    while (i2 < length6) {
                        SingletonList.add(Integer.valueOf(iArr[i2]));
                        i2++;
                    }
                } else {
                    SingletonList = Collections.singletonList(Integer.valueOf(iArr[0]));
                }
            }
            wp0Var = wp0.INT;
            r1 = SingletonList;
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length7 = jArr.length;
            if (length7 != 0) {
                if (length7 != 1) {
                    SingletonList = new ArrayList(jArr.length);
                    int length8 = jArr.length;
                    while (i2 < length8) {
                        SingletonList.add(Long.valueOf(jArr[i2]));
                        i2++;
                    }
                } else {
                    SingletonList = Collections.singletonList(Long.valueOf(jArr[0]));
                }
            }
            wp0Var = wp0.LONG;
            r1 = SingletonList;
        } else if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            int length9 = cArr.length;
            if (length9 != 0) {
                if (length9 != 1) {
                    SingletonList = new ArrayList(cArr.length);
                    int length10 = cArr.length;
                    while (i2 < length10) {
                        SingletonList.add(Character.valueOf(cArr[i2]));
                        i2++;
                    }
                } else {
                    SingletonList = Collections.singletonList(Character.valueOf(cArr[0]));
                }
            }
            wp0Var = wp0.CHAR;
            r1 = SingletonList;
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length11 = fArr.length;
            if (length11 != 0) {
                if (length11 != 1) {
                    SingletonList = new ArrayList(fArr.length);
                    int length12 = fArr.length;
                    while (i2 < length12) {
                        SingletonList.add(Float.valueOf(fArr[i2]));
                        i2++;
                    }
                } else {
                    SingletonList = Collections.singletonList(Float.valueOf(fArr[0]));
                }
            }
            wp0Var = wp0.FLOAT;
            r1 = SingletonList;
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length13 = dArr.length;
            if (length13 != 0) {
                if (length13 != 1) {
                    SingletonList = new ArrayList(dArr.length);
                    int length14 = dArr.length;
                    while (i2 < length14) {
                        SingletonList.add(Double.valueOf(dArr[i2]));
                        i2++;
                    }
                } else {
                    SingletonList = Collections.singletonList(Double.valueOf(dArr[0]));
                }
            }
            wp0Var = wp0.DOUBLE;
            r1 = SingletonList;
        } else {
            if (!(obj instanceof boolean[])) {
                if (obj == null) {
                    return new xl0(null);
                }
                return null;
            }
            boolean[] zArr = (boolean[]) obj;
            int length15 = zArr.length;
            if (length15 != 0) {
                if (length15 != 1) {
                    SingletonList = new ArrayList(zArr.length);
                    int length16 = zArr.length;
                    while (i2 < length16) {
                        SingletonList.add(Boolean.valueOf(zArr[i2]));
                        i2++;
                    }
                } else {
                    SingletonList = Collections.singletonList(Boolean.valueOf(zArr[0]));
                }
            }
            wp0Var = wp0.BOOLEAN;
            r1 = SingletonList;
        }
        List listG1 = he.g1(r1);
        ArrayList arrayList = new ArrayList();
        Iterator it = listG1.iterator();
        while (it.hasNext()) {
            qg qgVarB = b(it.next());
            if (qgVarB != null) {
                arrayList.add(qgVarB);
            }
        }
        return new h7(arrayList, new i(13, wp0Var));
    }

    /* JADX WARN: Code duplicated, block: B:31:0x009e  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ec  */
    /* JADX WARN: Multi-variable type inference failed */
    public static y80 b(ox oxVar, wc1 wc1Var) {
        fc0 type;
        ok okVarB;
        ai0 ai0Var;
        ai0 ai0Var2;
        ox oxVarA;
        if (!((pk) oxVar).getName().b().equals("remove") || oxVar.f().size() != 1 || (ym.l(oxVar).b() instanceof xc0) || ub0.A(oxVar)) {
            if (oxVar.f().size() == 1) {
                okVarB = oxVar.b();
                if (okVarB instanceof ai0) {
                    ai0Var = (ai0) okVarB;
                } else {
                    ai0Var = null;
                }
                if (ai0Var != null) {
                    od odVarB = ((wc1) he.a1(oxVar.f())).getType().L0().b();
                    ai0Var2 = odVarB instanceof ai0 ? (ai0) odVarB : null;
                    if (ai0Var2 != null && ub0.u(ai0Var) != null && ym.g(ai0Var).equals(ym.g(ai0Var2))) {
                        type = ma1.j(wc1Var.getType(), true);
                    }
                }
            }
            type = wc1Var.getType();
        } else {
            y80 y80VarB0 = defpackage.e.b0(((wc1) he.a1(oxVar.a().f())).getType());
            y80.c cVar = y80VarB0 instanceof y80.c ? (y80.c) y80VarB0 : null;
            if ((cVar == null ? null : cVar.i) == u80.INT && (oxVarA = aa.a(oxVar)) != null) {
                y80 y80VarB1 = defpackage.e.b0(((wc1) he.a1(oxVarA.a().f())).getType());
                if (xm.g(oxVarA.b()).equals(m21.a.I.i()) && (y80VarB1 instanceof y80.b) && ((y80.b) y80VarB1).i.equals("java/lang/Object")) {
                    type = ma1.j(wc1Var.getType(), true);
                } else {
                    if (oxVar.f().size() == 1) {
                        okVarB = oxVar.b();
                        if (okVarB instanceof ai0) {
                            ai0Var = (ai0) okVarB;
                        } else {
                            ai0Var = null;
                        }
                        if (ai0Var != null) {
                            od odVarB2 = ((wc1) he.a1(oxVar.f())).getType().L0().b();
                            if (odVarB2 instanceof ai0) {
                            }
                            if (ai0Var2 != null) {
                                type = ma1.j(wc1Var.getType(), true);
                            }
                        }
                    }
                    type = wc1Var.getType();
                }
            } else {
                if (oxVar.f().size() == 1) {
                    okVarB = oxVar.b();
                    if (okVarB instanceof ai0) {
                        ai0Var = (ai0) okVarB;
                    } else {
                        ai0Var = null;
                    }
                    if (ai0Var != null) {
                        od odVarB3 = ((wc1) he.a1(oxVar.f())).getType().L0().b();
                        if (odVarB3 instanceof ai0) {
                        }
                        if (ai0Var2 != null) {
                            type = ma1.j(wc1Var.getType(), true);
                        }
                    }
                }
                type = wc1Var.getType();
            }
        }
        return defpackage.e.b0(type);
    }

    public static void b(int i2, ch chVar, n8$b n8_b, boolean z2) {
        vg vgVar;
        vg vgVar2;
        char c2;
        vg vgVar3;
        vg vgVar4;
        if (chVar.n) {
            return;
        }
        if (!(chVar instanceof dh) && chVar.w() && a(chVar)) {
            dh.Q(chVar, n8_b, new n8$a());
        }
        vg vgVarG = chVar.g(vg.a.b);
        vg vgVarG2 = chVar.g(vg.a.d);
        int iC = vgVarG.c();
        int iC2 = vgVarG2.c();
        HashSet<vg> hashSet = vgVarG.a;
        if (hashSet != null && vgVarG.c) {
            for (vg vgVar5 : hashSet) {
                ch chVar2 = vgVar5.d;
                int i3 = i2 + 1;
                boolean zA = a(chVar2);
                if (chVar2.w() && zA) {
                    c2 = 0;
                    dh.Q(chVar2, n8_b, new n8$a());
                } else {
                    c2 = 0;
                }
                vg vgVar6 = chVar2.K;
                vg vgVar7 = chVar2.M;
                char c3 = ((vgVar5 == vgVar6 && (vgVar4 = vgVar7.f) != null && vgVar4.c) || (vgVar5 == vgVar7 && (vgVar3 = vgVar6.f) != null && vgVar3.c)) ? (char) 1 : c2;
                int i4 = chVar2.V[c2];
                if (i4 != 3 || zA) {
                    if (!chVar2.w()) {
                        if (vgVar5 == vgVar6 && vgVar7.f == null) {
                            int iD = vgVar6.d() + iC;
                            chVar2.E(iD, chVar2.n() + iD);
                        } else if (vgVar5 == vgVar7 && vgVar6.f == null) {
                            int iD2 = iC - vgVar7.d();
                            chVar2.E(iD2 - chVar2.n(), iD2);
                        } else if (c3 != 0 && !chVar2.u()) {
                            c(i3, chVar2, n8_b, z2);
                        }
                        b(i3, chVar2, n8_b, z2);
                    }
                } else if (i4 == 3 && chVar2.w >= 0 && chVar2.v >= 0 && (chVar2.j0 == 8 || (chVar2.s == 0 && chVar2.Z == 0.0f))) {
                    if (!chVar2.u() && c3 != 0 && !chVar2.u()) {
                        d(i3, chVar, n8_b, chVar2, z2);
                    }
                }
            }
        }
        if (chVar instanceof py) {
            return;
        }
        HashSet<vg> hashSet2 = vgVarG2.a;
        if (hashSet2 != null && vgVarG2.c) {
            for (vg vgVar8 : hashSet2) {
                ch chVar3 = vgVar8.d;
                int i5 = i2 + 1;
                boolean zA2 = a(chVar3);
                if (chVar3.w() && zA2) {
                    dh.Q(chVar3, n8_b, new n8$a());
                }
                vg vgVar9 = chVar3.K;
                vg vgVar10 = chVar3.M;
                boolean z3 = (vgVar8 == vgVar9 && (vgVar2 = vgVar10.f) != null && vgVar2.c) || (vgVar8 == vgVar10 && (vgVar = vgVar9.f) != null && vgVar.c);
                int i6 = chVar3.V[0];
                if (i6 != 3 || zA2) {
                    if (!chVar3.w()) {
                        if (vgVar8 == vgVar9 && vgVar10.f == null) {
                            int iD3 = vgVar9.d() + iC2;
                            chVar3.E(iD3, chVar3.n() + iD3);
                        } else if (vgVar8 == vgVar10 && vgVar9.f == null) {
                            int iD4 = iC2 - vgVar10.d();
                            chVar3.E(iD4 - chVar3.n(), iD4);
                        } else if (z3 && !chVar3.u()) {
                            c(i5, chVar3, n8_b, z2);
                        }
                        b(i5, chVar3, n8_b, z2);
                    }
                } else if (i6 == 3 && chVar3.w >= 0 && chVar3.v >= 0) {
                    if (chVar3.j0 == 8 || (chVar3.s == 0 && chVar3.Z == 0.0f)) {
                        if (!chVar3.u() && z3 && !chVar3.u()) {
                            d(i5, chVar, n8_b, chVar3, z2);
                        }
                    }
                }
            }
        }
        chVar.n = true;
    }

    public static boolean b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static void c(int i2, ch chVar, n8$b n8_b, boolean z2) {
        float f2 = chVar.g0;
        vg vgVar = chVar.K;
        int iC = vgVar.f.c();
        vg vgVar2 = chVar.M;
        int iC2 = vgVar2.f.c();
        int iD = vgVar.d() + iC;
        int iD2 = iC2 - vgVar2.d();
        if (iC == iC2) {
            f2 = 0.5f;
        } else {
            iC = iD;
            iC2 = iD2;
        }
        int iN = chVar.n();
        int i3 = (iC2 - iC) - iN;
        if (iC > iC2) {
            i3 = (iC - iC2) - iN;
        }
        int i4 = ((int) (i3 > 0 ? (f2 * i3) + 0.5f : f2 * i3)) + iC;
        int i5 = i4 + iN;
        if (iC > iC2) {
            i5 = i4 - iN;
        }
        chVar.E(i4, i5);
        b(i2 + 1, chVar, n8_b, z2);
    }

    public static int checkSelfPermission(ComponentActivity componentActivity, String str) {
        boolean zAreNotificationsEnabled;
        if (str == null) {
            d.AnonymousClass0.m$1("permission must be non-null");
            return 0;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return componentActivity.checkPermission(str, Process.myPid(), Process.myUid());
        }
        wl0 wl0Var = new wl0(componentActivity);
        if (i2 >= 24) {
            zAreNotificationsEnabled = wl0Var.b.areNotificationsEnabled();
        } else {
            AppOpsManager appOpsManager = (AppOpsManager) componentActivity.getSystemService("appops");
            ApplicationInfo applicationInfo = componentActivity.getApplicationInfo();
            String packageName = componentActivity.getApplicationContext().getPackageName();
            int i3 = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
                Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
                num.getClass();
                zAreNotificationsEnabled = ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i3), packageName)).intValue() == 0;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            }
        }
        return zAreNotificationsEnabled ? 0 : -1;
    }

    public static q01 d(ai0 ai0Var) {
        if (ai0Var == null) {
            a(24);
            throw null;
        }
        s4$a$a s4_a_a = e4.f47a;
        q01 q01VarU0 = q01.U0(ai0Var, m21.b, la.a.f, ai0Var.g());
        return q01VarU0.N0(null, null, Collections.EMPTY_LIST, Collections.singletonList(new wc1(q01VarU0, null, 0, s4_a_a, ij0.f(XMLRPC.TAG_VALUE), ym.e(ai0Var).v(), false, false, false, null, ai0Var.g())), ai0Var.n(), zh0.b, cn.e);
    }

    public static void d(int i2, ch chVar, n8$b n8_b, ch chVar2, boolean z2) {
        float f2 = chVar2.g0;
        vg vgVar = chVar2.K;
        int iD = vgVar.d() + vgVar.f.c();
        vg vgVar2 = chVar2.M;
        int iC = vgVar2.f.c() - vgVar2.d();
        if (iC >= iD) {
            int iN = chVar2.n();
            if (chVar2.j0 != 8) {
                int i3 = chVar2.s;
                if (i3 == 2) {
                    if (!(chVar instanceof dh)) {
                        chVar = chVar.W;
                    }
                    iN = (int) (chVar2.g0 * 0.5f * chVar.n());
                } else if (i3 == 0) {
                    iN = iC - iD;
                }
                iN = Math.max(chVar2.v, iN);
                int i4 = chVar2.w;
                if (i4 > 0) {
                    iN = Math.min(i4, iN);
                }
            }
            int i5 = iD + ((int) ((f2 * ((iC - iD) - iN)) + 0.5f));
            chVar2.E(i5, iN + i5);
            b(i2 + 1, chVar2, n8_b, z2);
        }
    }

    public static final boolean d(ai0 ai0Var, la laVar) {
        u01 u01VarN = ((ai0) laVar.b()).n();
        while (true) {
            cc1 cc1VarJ = null;
            if (ai0Var == null) {
                xm.a(44);
                throw null;
            }
            int i2 = xm.$r8$clinit;
            Iterator it = ai0Var.h().d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    ai0Var = null;
                    break;
                }
                ai0 ai0VarC = xm.c((fc0) it.next());
                if (ai0VarC.v() != 2) {
                    ai0Var = ai0VarC;
                    break;
                }
            }
            if (ai0Var == null) {
                return false;
            }
            if (!(ai0Var instanceof xc0)) {
                u01 u01VarN2 = ai0Var.n();
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.add(new d41(u01VarN2, null));
                a91 a91VarL0 = u01VarN.L0();
                while (!arrayDeque.isEmpty()) {
                    d41 d41Var = (d41) arrayDeque.poll();
                    fc0 fc0VarI = d41Var.a;
                    a91 a91VarL1 = fc0VarI.L0();
                    if (a91VarL1 == null) {
                        defpackage.e.a(3);
                        throw null;
                    }
                    if (a91VarL0 == null) {
                        defpackage.e.a(4);
                        throw null;
                    }
                    if (a91VarL1.equals(a91VarL0)) {
                        boolean zM0 = fc0VarI.M0();
                        while (true) {
                            d41Var = d41Var.b;
                            if (d41Var == null) {
                                break;
                            }
                            fc0 fc0Var = d41Var.a;
                            List listK0 = fc0Var.K0();
                            boolean z2 = listK0 != null;
                            ad1 ad1Var = ad1.INVARIANT;
                            if (!z2 || !listK0.isEmpty()) {
                                Iterator it2 = listK0.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        fc0VarI = new ha1(ak.b(fc0Var.L0(), fc0Var.K0())).i(fc0VarI, ad1Var);
                                        break;
                                    }
                                    if (((ca1) it2.next()).c() != ad1Var) {
                                        fc0VarI = (fc0) defpackage.e.t0(new ha1(ak.b(ak.b(fc0Var.L0(), fc0Var.K0()))).i(fc0VarI, ad1Var)).b;
                                        break;
                                    }
                                }
                            } else {
                                fc0VarI = new ha1(ak.b(fc0Var.L0(), fc0Var.K0())).i(fc0VarI, ad1Var);
                                break;
                            }
                            zM0 = zM0 || fc0Var.M0();
                        }
                        a91 a91VarL2 = fc0VarI.L0();
                        if (a91VarL2 == null) {
                            defpackage.e.a(3);
                            throw null;
                        }
                        if (a91VarL2.equals(a91VarL0)) {
                            cc1VarJ = ma1.j(fc0VarI, zM0);
                            break;
                        }
                        throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + defpackage.e.f(a91VarL2) + ", \n\nsupertype: " + defpackage.e.f(a91VarL0) + " \n" + a91VarL2.equals(a91VarL0));
                    }
                    Iterator it3 = a91VarL1.d().iterator();
                    while (it3.hasNext()) {
                        arrayDeque.add(new d41((fc0) it3.next(), d41Var));
                    }
                }
                if (cc1VarJ != null) {
                    return !ub0.A(ai0Var);
                }
            }
        }
    }

    public static int[] d(int i2, ByteArrayInputStream byteArrayInputStream) {
        int[] iArr = new int[i2];
        int iP = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            iP += (int) defpackage.e.p(byteArrayInputStream, 2);
            iArr[i3] = iP;
        }
        return iArr;
    }

    public static q01 e(ai0 ai0Var) {
        if (ai0Var == null) {
            a(22);
            throw null;
        }
        q01 q01VarU0 = q01.U0(ai0Var, m21.a, la.a.f, ai0Var.g());
        List list = Collections.EMPTY_LIST;
        return q01VarU0.N0(null, null, list, list, ym.e(ai0Var).h(ai0Var.n()), zh0.b, cn.e);
    }

    public static void e(int i2, ch chVar, n8$b n8_b) {
        float f2 = chVar.h0;
        vg vgVar = chVar.L;
        int iC = vgVar.f.c();
        vg vgVar2 = chVar.N;
        int iC2 = vgVar2.f.c();
        int iD = vgVar.d() + iC;
        int iD2 = iC2 - vgVar2.d();
        if (iC == iC2) {
            f2 = 0.5f;
        } else {
            iC = iD;
            iC2 = iD2;
        }
        int i3 = chVar.i();
        int i4 = (iC2 - iC) - i3;
        if (iC > iC2) {
            i4 = (iC - iC2) - i3;
        }
        int i5 = (int) (i4 > 0 ? (f2 * i4) + 0.5f : f2 * i4);
        int i6 = iC + i5;
        int i7 = i6 + i3;
        if (iC > iC2) {
            i6 = iC - i5;
            i7 = i6 - i3;
        }
        chVar.F(i6, i7);
        g(i2 + 1, chVar, n8_b);
    }

    public static void e(Drawable drawable, float f2, float f3) {
        drawable.setHotspot(f2, f3);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0087  */
    public static go[] e(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, go[] goVarArr) throws IOException {
        String str;
        byte[] bArr3 = e4.f;
        if (Arrays.equals(bArr, bArr3)) {
            if (Arrays.equals(e4.f49a, bArr2)) {
                str = "Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher";
            } else if (Arrays.equals(bArr, bArr3)) {
                int iP = (int) defpackage.e.p(fileInputStream, 1);
                byte[] bArrO = defpackage.e.o(fileInputStream, (int) defpackage.e.p(fileInputStream, 4), (int) defpackage.e.p(fileInputStream, 4));
                if (fileInputStream.read() <= 0) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrO);
                    try {
                        go[] goVarArrF = f(byteArrayInputStream, iP, goVarArr);
                        byteArrayInputStream.close();
                        return goVarArrF;
                    } catch (Throwable th) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                str = "Content found after the end of file";
            } else {
                str = "Unsupported meta version";
            }
        } else if (Arrays.equals(bArr, e4.g)) {
            int iP2 = (int) defpackage.e.p(fileInputStream, 2);
            byte[] bArrO2 = defpackage.e.o(fileInputStream, (int) defpackage.e.p(fileInputStream, 4), (int) defpackage.e.p(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrO2);
                try {
                    go[] goVarArrG = g(byteArrayInputStream2, bArr2, iP2, goVarArr);
                    byteArrayInputStream2.close();
                    return goVarArrG;
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            }
            str = "Content found after the end of file";
        } else {
            str = "Unsupported meta version";
        }
        d.AnonymousClass0.m(str);
        return null;
    }

    public static sc0 f(ja jaVar, fc0 fc0Var, s4 s4Var) {
        if (fc0Var == null) {
            return null;
        }
        return new sc0(jaVar, new os(jaVar, fc0Var), s4Var);
    }

    public static void f(int i2, ch chVar, n8$b n8_b, ch chVar2) {
        float f2 = chVar2.h0;
        vg vgVar = chVar2.L;
        int iD = vgVar.d() + vgVar.f.c();
        vg vgVar2 = chVar2.N;
        int iC = vgVar2.f.c() - vgVar2.d();
        if (iC >= iD) {
            int i3 = chVar2.i();
            if (chVar2.j0 != 8) {
                int i4 = chVar2.t;
                if (i4 == 2) {
                    if (!(chVar instanceof dh)) {
                        chVar = chVar.W;
                    }
                    i3 = (int) (f2 * 0.5f * chVar.i());
                } else if (i4 == 0) {
                    i3 = iC - iD;
                }
                i3 = Math.max(chVar2.y, i3);
                int i5 = chVar2.z;
                if (i5 > 0) {
                    i3 = Math.min(i5, i3);
                }
            }
            int i6 = iD + ((int) ((f2 * ((iC - iD) - i3)) + 0.5f));
            chVar2.F(i6, i3 + i6);
            g(i2 + 1, chVar2, n8_b);
        }
    }

    public static void f(Drawable drawable, int i2, int i3, int i4, int i5) {
        drawable.setHotspotBounds(i2, i3, i4, i5);
    }

    public static go[] f(ByteArrayInputStream byteArrayInputStream, int i2, go[] goVarArr) {
        String str;
        if (byteArrayInputStream.available() == 0) {
            return new go[0];
        }
        if (i2 == goVarArr.length) {
            String[] strArr = new String[i2];
            int[] iArr = new int[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                int iP = (int) defpackage.e.p(byteArrayInputStream, 2);
                iArr[i3] = (int) defpackage.e.p(byteArrayInputStream, 2);
                strArr[i3] = new String(defpackage.e.n(byteArrayInputStream, iP), StandardCharsets.UTF_8);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                go goVar = goVarArr[i4];
                if (goVar.b.equals(strArr[i4])) {
                    int i5 = iArr[i4];
                    goVar.e = i5;
                    goVar.h = d(i5, byteArrayInputStream);
                } else {
                    str = "Order of dexfiles in metadata did not match baseline";
                }
            }
            return goVarArr;
        }
        str = "Mismatched number of dex files found in metadata";
        d.AnonymousClass0.m(str);
        return null;
    }

    public static pq0 g(nq0 nq0Var, s4 s4Var, boolean z2, t11 t11Var) {
        return new pq0(nq0Var, s4Var, nq0Var.p(), nq0Var.getVisibility(), z2, false, false, la.a.b, null, t11Var);
    }

    public static void g(int i2, ch chVar, n8$b n8_b) {
        vg vgVar;
        boolean z2;
        vg vgVar2;
        vg vgVar3;
        vg vgVar4;
        vg vgVar5;
        if (chVar.o) {
            return;
        }
        if (!(chVar instanceof dh) && chVar.w() && a(chVar)) {
            dh.Q(chVar, n8_b, new n8$a());
        }
        vg vgVarG = chVar.g(vg.a.c);
        vg vgVarG2 = chVar.g(vg.a.f);
        int iC = vgVarG.c();
        int iC2 = vgVarG2.c();
        HashSet<vg> hashSet = vgVarG.a;
        if (hashSet != null && vgVarG.c) {
            for (vg vgVar6 : hashSet) {
                ch chVar2 = vgVar6.d;
                int i3 = i2 + 1;
                boolean zA = a(chVar2);
                if (chVar2.w() && zA) {
                    dh.Q(chVar2, n8_b, new n8$a());
                }
                vg vgVar7 = chVar2.L;
                vg vgVar8 = chVar2.N;
                boolean z3 = (vgVar6 == vgVar7 && (vgVar5 = vgVar8.f) != null && vgVar5.c) || (vgVar6 == vgVar8 && (vgVar4 = vgVar7.f) != null && vgVar4.c);
                int i4 = chVar2.V[1];
                if (i4 != 3 || zA) {
                    if (!chVar2.w()) {
                        if (vgVar6 == vgVar7 && vgVar8.f == null) {
                            int iD = vgVar7.d() + iC;
                            chVar2.F(iD, chVar2.i() + iD);
                        } else if (vgVar6 == vgVar8 && vgVar7.f == null) {
                            int iD2 = iC - vgVar8.d();
                            chVar2.F(iD2 - chVar2.i(), iD2);
                        } else if (z3 && !chVar2.v()) {
                            e(i3, chVar2, n8_b);
                        }
                        g(i3, chVar2, n8_b);
                    }
                } else if (i4 == 3 && chVar2.z >= 0 && chVar2.y >= 0 && (chVar2.j0 == 8 || (chVar2.t == 0 && chVar2.Z == 0.0f))) {
                    if (!chVar2.v() && z3 && !chVar2.v()) {
                        f(i3, chVar, n8_b, chVar2);
                    }
                }
            }
        }
        boolean z4 = true;
        z4 = true;
        z4 = true;
        if (chVar instanceof py) {
            return;
        }
        HashSet<vg> hashSet2 = vgVarG2.a;
        if (hashSet2 != null && vgVarG2.c) {
            for (vg vgVar9 : hashSet2) {
                ch chVar3 = vgVar9.d;
                int i5 = i2 + 1;
                boolean zA2 = a(chVar3);
                if (chVar3.w() && zA2) {
                    dh.Q(chVar3, n8_b, new n8$a());
                }
                vg vgVar10 = chVar3.L;
                vg vgVar11 = chVar3.N;
                boolean z5 = (vgVar9 == vgVar10 && (vgVar3 = vgVar11.f) != null && vgVar3.c) || (vgVar9 == vgVar11 && (vgVar2 = vgVar10.f) != null && vgVar2.c);
                int i6 = chVar3.V[1];
                if (i6 != 3 || zA2) {
                    if (!chVar3.w()) {
                        if (vgVar9 == vgVar10 && vgVar11.f == null) {
                            int iD3 = vgVar10.d() + iC2;
                            chVar3.F(iD3, chVar3.i() + iD3);
                        } else if (vgVar9 == vgVar11 && vgVar10.f == null) {
                            int iD4 = iC2 - vgVar11.d();
                            chVar3.F(iD4 - chVar3.i(), iD4);
                        } else if (z5 && !chVar3.v()) {
                            e(i5, chVar3, n8_b);
                        }
                        g(i5, chVar3, n8_b);
                    }
                } else if (i6 == 3 && chVar3.z >= 0 && chVar3.y >= 0 && (chVar3.j0 == 8 || (chVar3.t == 0 && chVar3.Z == 0.0f))) {
                    if (!chVar3.v() && z5 && !chVar3.v()) {
                        f(i5, chVar, n8_b, chVar3);
                    }
                }
            }
        }
        vg vgVarG3 = chVar.g(vg.a.g);
        if (vgVarG3.a != null && vgVarG3.c) {
            int iC3 = vgVarG3.c();
            for (vg vgVar12 : vgVarG3.a) {
                ch chVar4 = vgVar12.d;
                int i7 = i2 + 1;
                boolean zA3 = a(chVar4);
                if (chVar4.w() && zA3) {
                    dh.Q(chVar4, n8_b, new n8$a());
                }
                if (chVar4.V[z4 ? 1 : 0] != 3 || zA3) {
                    if (!chVar4.w() && vgVar12 == (vgVar = chVar4.O)) {
                        int iD5 = vgVar12.d() + iC3;
                        if (chVar4.F) {
                            int i8 = iD5 - chVar4.d0;
                            int i9 = chVar4.Y + i8;
                            chVar4.c0 = i8;
                            chVar4.L.i(i8);
                            chVar4.N.i(i9);
                            vgVar.i(iD5);
                            z2 = z4 ? 1 : 0;
                            chVar4.m = z2;
                        } else {
                            z2 = z4 ? 1 : 0;
                        }
                        g(i7, chVar4, n8_b);
                        z4 = z2;
                    }
                }
            }
        }
        chVar.o = z4;
    }

    public static go[] g(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i2, go[] goVarArr) throws IOException {
        String strConcat;
        go goVar;
        if (byteArrayInputStream.available() == 0) {
            return new go[0];
        }
        if (i2 == goVarArr.length) {
            for (int i3 = 0; i3 < i2; i3++) {
                defpackage.e.p(byteArrayInputStream, 2);
                String str = new String(defpackage.e.n(byteArrayInputStream, (int) defpackage.e.p(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
                long jP = defpackage.e.p(byteArrayInputStream, 4);
                int iP = (int) defpackage.e.p(byteArrayInputStream, 2);
                if (goVarArr.length <= 0) {
                    goVar = null;
                    break;
                }
                int iIndexOf = str.indexOf("!");
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(":");
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                int i4 = 0;
                while (true) {
                    if (i4 >= goVarArr.length) {
                        goVar = null;
                        break;
                    }
                    if (goVarArr[i4].b.equals(strSubstring)) {
                        goVar = goVarArr[i4];
                        break;
                    }
                    i4++;
                }
                if (goVar != null) {
                    goVar.d = jP;
                    int[] iArrD = d(iP, byteArrayInputStream);
                    if (Arrays.equals(bArr, e4.e)) {
                        goVar.e = iP;
                        goVar.h = iArrD;
                    }
                } else {
                    strConcat = "Missing profile key: ".concat(str);
                }
            }
            return goVarArr;
        }
        strConcat = "Mismatched number of dex files found in metadata";
        d.AnonymousClass0.m(strConcat);
        return null;
    }

    public static ColorStateList getColorStateList(Context context, int i2) {
        ColorStateList colorStateListA;
        ColorStateList colorStateList;
        sv0.c cVar;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        sv0.d dVar = new sv0.d(resources, theme);
        synchronized (sv0.c) {
            try {
                SparseArray sparseArray = (SparseArray) sv0.b.get(dVar);
                colorStateListA = null;
                if (sparseArray == null || sparseArray.size() <= 0 || (cVar = (sv0.c) sparseArray.get(i2)) == null) {
                    colorStateList = null;
                } else {
                    if (cVar.b.equals(resources.getConfiguration())) {
                        if (theme != null || cVar.c != 0) {
                            if (theme == null || cVar.c != theme.hashCode()) {
                            }
                        }
                        colorStateList = cVar.a;
                    }
                    sparseArray.remove(i2);
                    colorStateList = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ThreadLocal threadLocal = sv0.a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        resources.getValue(i2, typedValue, true);
        int i3 = typedValue.type;
        if (i3 < 28 || i3 > 31) {
            try {
                colorStateListA = ie.a(resources, resources.getXml(i2), theme);
            } catch (Exception unused) {
            }
        }
        if (colorStateListA == null) {
            return resources.getColorStateList(i2, theme);
        }
        sv0.a(dVar, i2, colorStateListA, theme);
        return colorStateListA;
    }

    public static wq0 h(nq0 nq0Var, s4 s4Var, s4 s4Var2, boolean z2, cn.d dVar, t11 t11Var) {
        wq0 wq0Var = new wq0(nq0Var, s4Var, nq0Var.p(), dVar, z2, false, false, la.a.b, null, t11Var);
        wq0Var.s = wq0.L0(wq0Var, nq0Var.getType(), s4Var2);
        return wq0Var;
    }

    public static void h(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static go[] h(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        String str2;
        if (Arrays.equals(bArr, e4.f50b)) {
            int iP = (int) defpackage.e.p(fileInputStream, 1);
            byte[] bArrO = defpackage.e.o(fileInputStream, (int) defpackage.e.p(fileInputStream, 4), (int) defpackage.e.p(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrO);
                try {
                    go[] goVarArrI = i(byteArrayInputStream, str, iP);
                    byteArrayInputStream.close();
                    return goVarArrI;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            str2 = "Content found after the end of file";
        } else {
            str2 = "Unsupported version";
        }
        d.AnonymousClass0.m(str2);
        return null;
    }

    public static void i(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }

    public static go[] i(ByteArrayInputStream byteArrayInputStream, String str, int i2) throws IOException {
        TreeMap treeMap;
        if (byteArrayInputStream.available() == 0) {
            return new go[0];
        }
        go[] goVarArr = new go[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iP = (int) defpackage.e.p(byteArrayInputStream, 2);
            int iP2 = (int) defpackage.e.p(byteArrayInputStream, 2);
            goVarArr[i3] = new go(str, new String(defpackage.e.n(byteArrayInputStream, iP), StandardCharsets.UTF_8), defpackage.e.p(byteArrayInputStream, 4), iP2, (int) defpackage.e.p(byteArrayInputStream, 4), (int) defpackage.e.p(byteArrayInputStream, 4), new int[iP2], new TreeMap());
        }
        for (int i4 = 0; i4 < i2; i4++) {
            go goVar = goVarArr[i4];
            int iAvailable = byteArrayInputStream.available() - goVar.f;
            int iP3 = 0;
            while (true) {
                int iAvailable2 = byteArrayInputStream.available();
                treeMap = goVar.i;
                if (iAvailable2 <= iAvailable) {
                    break;
                }
                iP3 += (int) defpackage.e.p(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(iP3), 1);
                for (int iP4 = (int) defpackage.e.p(byteArrayInputStream, 2); iP4 > 0; iP4--) {
                    defpackage.e.p(byteArrayInputStream, 2);
                    int iP5 = (int) defpackage.e.p(byteArrayInputStream, 1);
                    if (iP5 != 6 && iP5 != 7) {
                        while (iP5 > 0) {
                            defpackage.e.p(byteArrayInputStream, 1);
                            for (int iP6 = (int) defpackage.e.p(byteArrayInputStream, 1); iP6 > 0; iP6--) {
                                defpackage.e.p(byteArrayInputStream, 2);
                            }
                            iP5--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() != iAvailable) {
                d.AnonymousClass0.m("Read too much data during profile line parse");
                return null;
            }
            goVar.h = d(goVar.e, byteArrayInputStream);
            int i5 = goVar.g;
            BitSet bitSetValueOf = BitSet.valueOf(defpackage.e.n(byteArrayInputStream, (((i5 * 2) + 7) & (-8)) / 8));
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = bitSetValueOf.get(i6) ? 2 : 0;
                if (bitSetValueOf.get(i6 + i5)) {
                    i7 |= 4;
                }
                if (i7 != 0) {
                    Integer num = (Integer) treeMap.get(Integer.valueOf(i6));
                    if (num == null) {
                        num = 0;
                    }
                    treeMap.put(Integer.valueOf(i6), Integer.valueOf(i7 | num.intValue()));
                }
            }
        }
        return goVarArr;
    }

    /* JADX WARN: Code duplicated, block: B:78:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:79:0x01c7  */
    public static boolean j(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, go[] goVarArr) throws IOException {
        long j2;
        long j3;
        boolean z2;
        byte[] bArr2;
        ArrayList arrayList;
        int length;
        byte[] bArr3 = e4.f49a;
        int i2 = 0;
        if (!Arrays.equals(bArr, bArr3)) {
            byte[] bArr4 = e4.f50b;
            if (Arrays.equals(bArr, bArr4)) {
                byte[] bArrA = a(goVarArr, bArr4);
                defpackage.e.s(byteArrayOutputStream, goVarArr.length, 1);
                defpackage.e.s(byteArrayOutputStream, bArrA.length, 4);
                byte[] bArrE = defpackage.e.e(bArrA);
                defpackage.e.s(byteArrayOutputStream, bArrE.length, 4);
                byteArrayOutputStream.write(bArrE);
                return true;
            }
            byte[] bArr5 = e4.d;
            if (Arrays.equals(bArr, bArr5)) {
                defpackage.e.s(byteArrayOutputStream, goVarArr.length, 1);
                for (go goVar : goVarArr) {
                    int size = goVar.i.size() * 4;
                    String strB = b(goVar.a, goVar.b, bArr5);
                    Charset charset = StandardCharsets.UTF_8;
                    defpackage.e.t(byteArrayOutputStream, strB.getBytes(charset).length);
                    defpackage.e.t(byteArrayOutputStream, goVar.h.length);
                    defpackage.e.s(byteArrayOutputStream, size, 4);
                    defpackage.e.s(byteArrayOutputStream, goVar.c, 4);
                    byteArrayOutputStream.write(strB.getBytes(charset));
                    Iterator it = goVar.i.keySet().iterator();
                    while (it.hasNext()) {
                        defpackage.e.t(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        defpackage.e.t(byteArrayOutputStream, 0);
                    }
                    for (int i3 : goVar.h) {
                        defpackage.e.t(byteArrayOutputStream, i3);
                    }
                }
                return true;
            }
            byte[] bArr6 = e4.c;
            if (Arrays.equals(bArr, bArr6)) {
                byte[] bArrA2 = a(goVarArr, bArr6);
                defpackage.e.s(byteArrayOutputStream, goVarArr.length, 1);
                defpackage.e.s(byteArrayOutputStream, bArrA2.length, 4);
                byte[] bArrE2 = defpackage.e.e(bArrA2);
                defpackage.e.s(byteArrayOutputStream, bArrE2.length, 4);
                byteArrayOutputStream.write(bArrE2);
                return true;
            }
            byte[] bArr7 = e4.e;
            if (!Arrays.equals(bArr, bArr7)) {
                return false;
            }
            defpackage.e.t(byteArrayOutputStream, goVarArr.length);
            for (go goVar2 : goVarArr) {
                String strB2 = b(goVar2.a, goVar2.b, bArr7);
                Charset charset2 = StandardCharsets.UTF_8;
                defpackage.e.t(byteArrayOutputStream, strB2.getBytes(charset2).length);
                TreeMap treeMap = goVar2.i;
                defpackage.e.t(byteArrayOutputStream, treeMap.size());
                defpackage.e.t(byteArrayOutputStream, goVar2.h.length);
                defpackage.e.s(byteArrayOutputStream, goVar2.c, 4);
                byteArrayOutputStream.write(strB2.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    defpackage.e.t(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i4 : goVar2.h) {
                    defpackage.e.t(byteArrayOutputStream, i4);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            defpackage.e.t(byteArrayOutputStream2, goVarArr.length);
            int i5 = 2;
            int i6 = 2;
            for (go goVar3 : goVarArr) {
                defpackage.e.s(byteArrayOutputStream2, goVar3.c, 4);
                defpackage.e.s(byteArrayOutputStream2, goVar3.d, 4);
                defpackage.e.s(byteArrayOutputStream2, goVar3.g, 4);
                String strB3 = b(goVar3.a, goVar3.b, bArr3);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = strB3.getBytes(charset3).length;
                defpackage.e.t(byteArrayOutputStream2, length2);
                i6 = i6 + 14 + length2;
                byteArrayOutputStream2.write(strB3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i6 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i6 + ", does not match actual size " + byteArray.length);
            }
            ai1 ai1Var = new ai1(false, byteArray, 1);
            byteArrayOutputStream2.close();
            arrayList2.add(ai1Var);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i7 = 0;
            int i8 = 0;
            while (i7 < goVarArr.length) {
                try {
                    go goVar4 = goVarArr[i7];
                    defpackage.e.t(byteArrayOutputStream3, i7);
                    defpackage.e.t(byteArrayOutputStream3, goVar4.e);
                    i8 = i8 + 4 + (goVar4.e * i5);
                    int[] iArr = goVar4.h;
                    int length3 = iArr.length;
                    int i9 = i2;
                    while (i2 < length3) {
                        int i10 = iArr[i2];
                        defpackage.e.t(byteArrayOutputStream3, i10 - i9);
                        i2++;
                        i5 = i5;
                        i9 = i10;
                    }
                    i7++;
                    i2 = 0;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            int i11 = i5;
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i8 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i8 + ", does not match actual size " + byteArray2.length);
            }
            ai1 ai1Var2 = new ai1(true, byteArray2, 3);
            byteArrayOutputStream3.close();
            arrayList2.add(ai1Var2);
            ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
            int i12 = 0;
            int i13 = 0;
            while (i12 < goVarArr.length) {
                try {
                    go goVar5 = goVarArr[i12];
                    Iterator it3 = goVar5.i.entrySet().iterator();
                    int iIntValue = 0;
                    while (it3.hasNext()) {
                        iIntValue |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                    try {
                        n(byteArrayOutputStream5, iIntValue, goVar5);
                        byte[] byteArray3 = byteArrayOutputStream5.toByteArray();
                        byteArrayOutputStream5.close();
                        ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                        try {
                            o(byteArrayOutputStream6, goVar5);
                            byte[] byteArray4 = byteArrayOutputStream6.toByteArray();
                            byteArrayOutputStream6.close();
                            defpackage.e.t(byteArrayOutputStream4, i12);
                            int length4 = byteArray3.length + 2 + byteArray4.length;
                            int i14 = i13 + 6;
                            ArrayList arrayList4 = arrayList3;
                            defpackage.e.s(byteArrayOutputStream4, length4, 4);
                            defpackage.e.t(byteArrayOutputStream4, iIntValue);
                            byteArrayOutputStream4.write(byteArray3);
                            byteArrayOutputStream4.write(byteArray4);
                            i13 = i14 + length4;
                            i12++;
                            arrayList3 = arrayList4;
                        } catch (Throwable th3) {
                            try {
                                byteArrayOutputStream6.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            byteArrayOutputStream5.close();
                            throw th5;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                            throw th5;
                        }
                    }
                } catch (Throwable th7) {
                    try {
                        byteArrayOutputStream4.close();
                        throw th7;
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                        throw th7;
                    }
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream4.toByteArray();
            if (i13 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i13 + ", does not match actual size " + byteArray5.length);
            }
            ai1 ai1Var3 = new ai1(true, byteArray5, 4);
            byteArrayOutputStream4.close();
            arrayList2.add(ai1Var3);
            long j4 = 4;
            long j5 = 4;
            long size2 = j4 + j4 + 4 + ((long) (arrayList2.size() * 16));
            defpackage.e.s(byteArrayOutputStream, arrayList2.size(), 4);
            int i15 = 0;
            while (i15 < arrayList2.size()) {
                ai1 ai1Var4 = (ai1) arrayList2.get(i15);
                int i16 = ai1Var4.a;
                int i17 = i11;
                if (i16 == 1) {
                    j3 = 0;
                } else {
                    if (i16 == i17) {
                        j3 = 1;
                    } else {
                        if (i16 == 3) {
                            j2 = 2;
                        } else if (i16 == 4) {
                            j2 = 3;
                        } else if (i16 != 5) {
                            throw null;
                        }
                        j5 = j2;
                    }
                    defpackage.e.s(byteArrayOutputStream, j5, 4);
                    defpackage.e.s(byteArrayOutputStream, size2, 4);
                    z2 = ai1Var4.c;
                    bArr2 = ai1Var4.b;
                    if (z2) {
                        long length5 = bArr2.length;
                        byte[] bArrE3 = defpackage.e.e(bArr2);
                        arrayList = arrayList5;
                        arrayList.add(bArrE3);
                        defpackage.e.s(byteArrayOutputStream, bArrE3.length, 4);
                        defpackage.e.s(byteArrayOutputStream, length5, 4);
                        length = bArrE3.length;
                    } else {
                        arrayList = arrayList5;
                        arrayList.add(bArr2);
                        defpackage.e.s(byteArrayOutputStream, bArr2.length, 4);
                        defpackage.e.s(byteArrayOutputStream, 0L, 4);
                        length = bArr2.length;
                    }
                    size2 += (long) length;
                    i15++;
                    i11 = i17;
                    arrayList5 = arrayList;
                    j5 = 4;
                }
                j5 = j3;
                defpackage.e.s(byteArrayOutputStream, j5, 4);
                defpackage.e.s(byteArrayOutputStream, size2, 4);
                z2 = ai1Var4.c;
                bArr2 = ai1Var4.b;
                if (z2) {
                    long length6 = bArr2.length;
                    byte[] bArrE4 = defpackage.e.e(bArr2);
                    arrayList = arrayList5;
                    arrayList.add(bArrE4);
                    defpackage.e.s(byteArrayOutputStream, bArrE4.length, 4);
                    defpackage.e.s(byteArrayOutputStream, length6, 4);
                    length = bArrE4.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr2);
                    defpackage.e.s(byteArrayOutputStream, bArr2.length, 4);
                    defpackage.e.s(byteArrayOutputStream, 0L, 4);
                    length = bArr2.length;
                }
                size2 += (long) length;
                i15++;
                i11 = i17;
                arrayList5 = arrayList;
                j5 = 4;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i18 = 0; i18 < arrayList6.size(); i18++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i18));
            }
            return true;
        } catch (Throwable th9) {
            try {
                byteArrayOutputStream2.close();
                throw th9;
            } catch (Throwable th10) {
                th9.addSuppressed(th10);
                throw th9;
            }
        }
    }

    public static void l(ByteArrayOutputStream byteArrayOutputStream, go goVar) throws IOException {
        o(byteArrayOutputStream, goVar);
        int[] iArr = goVar.h;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            defpackage.e.t(byteArrayOutputStream, i4 - i3);
            i2++;
            i3 = i4;
        }
        int i5 = goVar.g;
        byte[] bArr = new byte[(((i5 * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : goVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                int i6 = iIntValue / 8;
                bArr[i6] = (byte) (bArr[i6] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i7 = iIntValue + i5;
                int i8 = i7 / 8;
                bArr[i8] = (byte) ((1 << (i7 % 8)) | bArr[i8]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void m(ByteArrayOutputStream byteArrayOutputStream, go goVar, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        defpackage.e.t(byteArrayOutputStream, str.getBytes(charset).length);
        defpackage.e.t(byteArrayOutputStream, goVar.e);
        defpackage.e.s(byteArrayOutputStream, goVar.f, 4);
        defpackage.e.s(byteArrayOutputStream, goVar.c, 4);
        defpackage.e.s(byteArrayOutputStream, goVar.g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void n(ByteArrayOutputStream byteArrayOutputStream, int i2, go goVar) throws IOException {
        int iBitCount = Integer.bitCount(i2 & (-2));
        int i3 = goVar.g;
        byte[] bArr = new byte[(((iBitCount * i3) + 7) & (-8)) / 8];
        for (Map.Entry entry : goVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            int i4 = 0;
            for (int i5 = 1; i5 <= 4; i5 <<= 1) {
                if (i5 != 1 && (i5 & i2) != 0) {
                    if ((i5 & iIntValue2) == i5) {
                        int i6 = (i3 * i4) + iIntValue;
                        int i7 = i6 / 8;
                        bArr[i7] = (byte) ((1 << (i6 % 8)) | bArr[i7]);
                    }
                    i4++;
                }
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void o(ByteArrayOutputStream byteArrayOutputStream, go goVar) throws IOException {
        int i2 = 0;
        for (Map.Entry entry : goVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                defpackage.e.t(byteArrayOutputStream, iIntValue - i2);
                defpackage.e.t(byteArrayOutputStream, 0);
                i2 = iIntValue;
            }
        }
    }

    public static void u(View view, lm0 lm0Var) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.attr.a09, lm0Var);
        }
        if (lm0Var == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.attr.a0g));
        } else {
            view.setOnApplyWindowInsetsListener(new qd1.ViewOnApplyWindowInsetsListenerC0049a(view, lm0Var));
        }
    }

    public void a(Object obj) {
    }

    public boolean a() {
        return false;
    }

    public void b() {
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public abstract boolean mo2b(Object obj);

    public abstract void c();

    public abstract void d();

    public abstract Object result();
}
