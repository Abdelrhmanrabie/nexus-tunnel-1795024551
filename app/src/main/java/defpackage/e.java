package defpackage;

import android.R;
import android.app.AppOpsManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jcraft.jzlib.GZIPHeader;
import com.trilead.ssh2.sftp.AttribFlags;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import net.lingala.zip4j.util.InternalZipConstants;
import net.openvpn.ovpn3.XMLRPC;
import renz.javacodez.v2ray.viewmodel.MainViewModel;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class e implements yp, ak.c, le1, s01, mr, ld, b60, b40, li.c, ws0, lm0, f3, ff0.d {
    public static final ci0 a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final e f22a;
    public static final ci0 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final e f24b;
    public static final ci0 c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final e f28c;
    public static final ci0 c$1;
    public static final ci0 d;
    public static final ci0 d$1;

    /* JADX INFO: renamed from: d$1, reason: collision with other field name */
    public static final e f33d$1;
    public static final ci0 e;
    public static final ci0 f;
    public static final ci0 f$1;
    public static final ci0 g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final e f37g;
    public static Field h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static boolean f42i;
    public static final e l;
    public static e n;
    public final /* synthetic */ int G0;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final oq f39h = new oq(false);
    public static final oq i = new oq(true);
    public static final int[] m = new int[0];

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public static final Object[] f45n = new Object[0];
    public static final boolean[] o = new boolean[3];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Object[] f26b = new Object[0];

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final e f31d = new e(2);

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public static final int[] f44l = {R.attr.minWidth, R.attr.minHeight, org.hamotunnelplus.xyz.R.style.dh, org.hamotunnelplus.xyz.R.style.di, org.hamotunnelplus.xyz.R.style.dj, org.hamotunnelplus.xyz.R.style.dl, org.hamotunnelplus.xyz.R.style.dm, org.hamotunnelplus.xyz.R.style.dn, org.hamotunnelplus.xyz.R.style.hi, org.hamotunnelplus.xyz.R.style.hj, org.hamotunnelplus.xyz.R.style.hl, org.hamotunnelplus.xyz.R.style.hm, org.hamotunnelplus.xyz.R.style.ho};
    public static final int[] m$1 = {org.hamotunnelplus.xyz.R.style.kb};
    public static final e a$1 = new e(3);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f25b = {R.attr.orientation, R.attr.clipToPadding, R.attr.descendantFocusability, org.hamotunnelplus.xyz.R.style.lr, org.hamotunnelplus.xyz.R.style.ls, org.hamotunnelplus.xyz.R.style.lt, org.hamotunnelplus.xyz.R.style.lu, org.hamotunnelplus.xyz.R.style.lv, org.hamotunnelplus.xyz.R.style.q5, org.hamotunnelplus.xyz.R.style.yn, org.hamotunnelplus.xyz.R.style.a0q, org.hamotunnelplus.xyz.R.style.a16};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int[] f29c = {org.hamotunnelplus.xyz.R.style.pt, org.hamotunnelplus.xyz.R.style.a1k};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int[] f32d = {R.attr.layout_gravity, org.hamotunnelplus.xyz.R.style.q6, org.hamotunnelplus.xyz.R.style.q7, org.hamotunnelplus.xyz.R.style.q8, org.hamotunnelplus.xyz.R.style.rj, org.hamotunnelplus.xyz.R.style.rt, org.hamotunnelplus.xyz.R.style.ru};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f23a = {R.attr.dither, R.attr.visible, R.attr.variablePadding, R.attr.constantSize, R.attr.enterFadeDuration, R.attr.exitFadeDuration};

    /* JADX INFO: renamed from: b$1, reason: collision with other field name */
    public static final int[] f27b$1 = {R.attr.id, R.attr.drawable};

    /* JADX INFO: renamed from: c$1, reason: collision with other field name */
    public static final int[] f30c$1 = {R.attr.drawable, R.attr.toId, R.attr.fromId, R.attr.reversible};

    /* JADX INFO: renamed from: d$1, reason: collision with other field name */
    public static final int[] f34d$1 = {R.attr.color, R.attr.alpha, R.attr.lStar, org.hamotunnelplus.xyz.R.style.ax, org.hamotunnelplus.xyz.R.style.pu};

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final int[] f35e = {org.hamotunnelplus.xyz.R.style.mv, org.hamotunnelplus.xyz.R.style.mw, org.hamotunnelplus.xyz.R.style.mx, org.hamotunnelplus.xyz.R.style.my, org.hamotunnelplus.xyz.R.style.mz, org.hamotunnelplus.xyz.R.style.n0, org.hamotunnelplus.xyz.R.style.n1};

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final int[] f36f = {R.attr.font, R.attr.fontWeight, R.attr.fontStyle, R.attr.ttcIndex, R.attr.fontVariationSettings, org.hamotunnelplus.xyz.R.style.mt, org.hamotunnelplus.xyz.R.style.n2, org.hamotunnelplus.xyz.R.style.n3, org.hamotunnelplus.xyz.R.style.n4, org.hamotunnelplus.xyz.R.style.a6x};

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final int[] f38g = {R.attr.startColor, R.attr.endColor, R.attr.type, R.attr.centerX, R.attr.centerY, R.attr.gradientRadius, R.attr.tileMode, R.attr.centerColor, R.attr.startX, R.attr.startY, R.attr.endX, R.attr.endY};

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final int[] f40h = {R.attr.color, R.attr.offset};

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final float[][] f41h = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final float[][] f43i = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    public static final float[] j = {95.047f, 100.0f, 108.883f};
    public static final float[][] k = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    public static final e a$2 = new e(7);
    public static final e a$3 = new e(8);
    public static final e a$4 = new e(9);
    public static final e a$5 = new e(12);
    public static final /* synthetic */ e b$1 = new e(13);
    public static final /* synthetic */ e b$2 = new e(14);
    public static final e a$6 = new e(18);
    public static final e a$7 = new e(19);
    public static final e a$8 = new e(20);
    public static final e a$9 = new e(24);
    public static final e a$10 = new e(26);
    public static final e b$3 = new e(27);

    static {
        int i2 = 1;
        f22a = new e(i2);
        c = new ci0("COMPLETING_ALREADY", i2);
        d = new ci0("COMPLETING_WAITING_CHILDREN", i2);
        e = new ci0("COMPLETING_RETRY", i2);
        f = new ci0("TOO_LATE_TO_CANCEL", i2);
        g = new ci0("SEALED", i2);
        a = new ci0("NO_DECISION", i2);
        f$1 = new ci0("CLOSED_EMPTY", i2);
        int i3 = 6;
        int i4 = 5;
        f24b = new e(i4);
        f28c = new e(i4);
        f33d$1 = new e(i4);
        b = new ci0("UNDEFINED", i2);
        c$1 = new ci0("REUSABLE_CLAIMED", i2);
        d$1 = new ci0("CONDITION_FALSE", i2);
        f37g = new e(i3);
        l = new e(i3);
    }

    public /* synthetic */ e(int i2) {
        this.G0 = i2;
    }

    public static final Object A(yx.c cVar, yx.e eVar, int i2) {
        cVar.l(eVar);
        dt dtVar = cVar.b;
        dtVar.getClass();
        l11 l11Var = dtVar.a;
        yx.d dVar = eVar.d;
        if (!dVar.d) {
            d.AnonymousClass0.m$2("getRepeatedField() can only be called on repeated fields.");
            return null;
        }
        Object obj = l11Var.get(dVar);
        if (i2 < (obj == null ? 0 : ((List) obj).size())) {
            cVar.l(eVar);
            if (dVar.d) {
                Object obj2 = l11Var.get(dVar);
                if (obj2 != null) {
                    return eVar.a(((List) obj2).get(i2));
                }
                throw new IndexOutOfBoundsException();
            }
            d.AnonymousClass0.m$2("getRepeatedField() can only be called on repeated fields.");
        }
        return null;
    }

    public static void A0(h70 h70Var) {
        Iterator it = new ge(4, new i70(null, h70Var)).iterator();
        while (true) {
            ty0 ty0Var = (ty0) it;
            if (!ty0Var.hasNext()) {
                return;
            }
            h70 h70Var2 = (h70) ty0Var.next();
            h70Var2.getClass();
            h70Var2.C(new d70(h70Var2.E(), null, h70Var2));
        }
    }

    public static final Object B(ra0.a aVar) {
        ra0 ra0VarP = aVar.p();
        return j(ra0VarP.n, ra0VarP.l());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class C(h90 h90Var) {
        Class clsD = ((sc) h90Var).d();
        if (clsD.isPrimitive()) {
            String name = clsD.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals(XMLRPC.TYPE_DOUBLE)) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals(XMLRPC.TYPE_INT)) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals(XMLRPC.TYPE_BOOLEAN)) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return clsD;
    }

    public static final mx C(od odVar) {
        if (!(odVar instanceof ai0) || !ub0.K(odVar)) {
            return null;
        }
        int i2 = ym.$r8$clinit;
        dv dvVarG = xm.g(odVar);
        if (!dvVarG.e() || dvVarG.a.isEmpty()) {
            return null;
        }
        ke keVar = mx.d;
        String strB = dvVarG.g().b();
        cv cvVarE = dvVarG.h().e();
        keVar.getClass();
        mx$a$a mx_a_aA = ke.a(strB, cvVarE);
        if (mx_a_aA == null) {
            return null;
        }
        return mx_a_aA.a;
    }

    public static void C(Class cls, xb0$c xb0_c) throws InvocationTargetException {
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        int length = declaredAnnotations.length;
        int i2 = 0;
        while (i2 < length) {
            Annotation annotation = declaredAnnotations[i2];
            i2++;
            G(xb0_c, annotation);
        }
        xb0_c.mo4a();
    }

    public static void C0(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class D(h90 h90Var) {
        Class clsD = ((sc) h90Var).d();
        if (clsD.isPrimitive()) {
            return clsD;
        }
        String name = clsD.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    public static final String D(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    /* JADX WARN: Code duplicated, block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0057  */
    /* JADX WARN: Code duplicated, block: B:44:0x005a  */
    /* JADX WARN: Code duplicated, block: B:46:0x005d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0070  */
    /* JADX WARN: Code duplicated, block: B:55:0x0076  */
    /* JADX WARN: Code duplicated, block: B:61:0x0081 A[DONT_INVERT] */
    public static int E(byte[] bArr, int i2, int i3) {
        int i4;
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            return 0;
        }
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                i2 = i5;
            } else {
                if (b2 >= -32) {
                    if (b2 < -16) {
                        if (i5 >= i3 - 1) {
                            i4 = i3 - i5;
                            if (i4 != 0) {
                                if (i4 != 1) {
                                    byte b3 = bArr[i5];
                                    if (b2 > -12 && b3 <= -65) {
                                        return (b3 << 8) ^ b2;
                                    }
                                }
                                if (i4 == 2) {
                                    throw new AssertionError();
                                }
                                byte b4 = bArr[i5];
                                byte b5 = bArr[i2 + 2];
                                if (b2 <= -12 || b4 > -65 || b5 > -65) {
                                    return -1;
                                }
                                return (b5 << 16) ^ ((b4 << 8) ^ b2);
                            }
                            if (b2 > -12) {
                                return -1;
                            }
                        } else {
                            int i6 = i2 + 2;
                            byte b6 = bArr[i5];
                            if (b6 > -65) {
                                return -1;
                            }
                            if (b2 == -32 && b6 < -96) {
                                return -1;
                            }
                            if (b2 == -19 && b6 >= -96) {
                                return -1;
                            }
                            i2 += 3;
                            if (bArr[i6] > -65) {
                                return -1;
                            }
                        }
                    } else if (i5 >= i3 - 2) {
                        i4 = i3 - i5;
                        if (i4 != 0) {
                            if (i4 != 1) {
                                byte b7 = bArr[i5];
                                return b2 > -12 ? -1 : -1;
                            }
                            if (i4 == 2) {
                                throw new AssertionError();
                            }
                            byte b8 = bArr[i5];
                            byte b9 = bArr[i2 + 2];
                            return b2 <= -12 ? -1 : -1;
                        }
                        if (b2 > -12) {
                            return -1;
                        }
                    } else {
                        int i7 = i2 + 2;
                        byte b10 = bArr[i5];
                        if (b10 > -65) {
                            return -1;
                        }
                        if ((((b10 + 112) + (b2 << 28)) >> 30) != 0) {
                            return -1;
                        }
                        int i8 = i2 + 3;
                        if (bArr[i7] > -65) {
                            return -1;
                        }
                        i2 += 4;
                        if (bArr[i8] > -65) {
                            return -1;
                        }
                    }
                    return b2;
                }
                if (i5 >= i3) {
                    return b2;
                }
                if (b2 < -62) {
                    return -1;
                }
                i2 += 2;
                if (bArr[i5] > -65) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static final ij0 E(jj0 jj0Var, int i2) {
        return ij0.d(jj0Var.getString(i2));
    }

    public static int E0(Context context, String str) {
        int iNoteProxyOpNoThrow;
        int iMyPid = Process.myPid();
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, iMyPid, iMyUid) != -1) {
            String strPermissionToOp = AppOpsManager.permissionToOp(str);
            if (strPermissionToOp != null) {
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                int iMyUid2 = Process.myUid();
                String packageName2 = context.getPackageName();
                if (iMyUid2 == iMyUid && Objects.equals(packageName2, packageName) && Build.VERSION.SDK_INT >= 29) {
                    AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
                    iNoteProxyOpNoThrow = appOpsManager == null ? 1 : appOpsManager.checkOpNoThrow(strPermissionToOp, Binder.getCallingUid(), packageName);
                    if (iNoteProxyOpNoThrow == 0) {
                        iNoteProxyOpNoThrow = appOpsManager != null ? appOpsManager.checkOpNoThrow(strPermissionToOp, iMyUid, context.getOpPackageName()) : 1;
                    }
                } else {
                    iNoteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(strPermissionToOp, packageName);
                }
                if (iNoteProxyOpNoThrow != 0) {
                    return -2;
                }
            }
            return 0;
        }
        return -1;
    }

    public static final void F0(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                e(th, th2);
            }
        }
    }

    public static final fc0 G(fc0 fc0Var) {
        L(fc0Var);
        if (fc0Var.getAnnotations().c(m21.a.p) != null) {
            return ((ca1) he.K0(fc0Var.K0())).getType();
        }
        return null;
    }

    public static final fc0 G(v91 v91Var) {
        Object obj;
        v91Var.getUpperBounds().isEmpty();
        Iterator it = v91Var.getUpperBounds().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            od odVarB = ((fc0) next).L0().b();
            ai0 ai0Var = odVarB instanceof ai0 ? (ai0) odVarB : null;
            if (ai0Var != null && ai0Var.v() != 2 && ai0Var.v() != 5) {
                obj = next;
                break;
            }
        }
        fc0 fc0Var = (fc0) obj;
        return fc0Var == null ? (fc0) he.K0(v91Var.getUpperBounds()) : fc0Var;
    }

    public static void G(xb0$c xb0_c, Annotation annotation) throws InvocationTargetException {
        Class clsD = ((sc) v(annotation)).d();
        xb0$a xb0_aB = xb0_c.b(bt0.a(clsD), new at0(annotation));
        if (xb0_aB == null) {
            return;
        }
        H(xb0_aB, annotation, clsD);
    }

    public static final List G0(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return uq.b;
        }
        if (size == 1) {
            return Collections.singletonList(he.K0(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static final Method H(Class cls, la laVar) {
        try {
            return cls.getDeclaredMethod("unbox-impl", null);
        } catch (NoSuchMethodException unused) {
            d.AnonymousClass0.m("No unbox method found in inline class: ", cls, " (calling ", laVar);
            return null;
        }
    }

    public static final od H(ok okVar) {
        ok okVarB = okVar.b();
        if (okVarB == null || (okVar instanceof wn0)) {
            return null;
        }
        if (!(okVarB.b() instanceof wn0)) {
            return H(okVarB);
        }
        if (okVarB instanceof od) {
            return (od) okVarB;
        }
        return null;
    }

    public static void H(xb0$a xb0_a, Annotation annotation, Class cls) throws InvocationTargetException {
        String str;
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i2 = 0;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            i2++;
            try {
                Object objInvoke = method.invoke(annotation, null);
                ij0 ij0VarF = ij0.f(method.getName());
                Class<?> enclosingClass = objInvoke.getClass();
                if (enclosingClass.equals(Class.class)) {
                    xb0_a.b(ij0VarF, l((Class) objInvoke));
                } else if (lu0.a.contains(enclosingClass)) {
                    xb0_a.f(objInvoke, ij0VarF);
                } else {
                    List list = bt0.a;
                    if (Enum.class.isAssignableFrom(enclosingClass)) {
                        if (!enclosingClass.isEnum()) {
                            enclosingClass = enclosingClass.getEnclosingClass();
                        }
                        xb0_a.d(ij0VarF, bt0.a(enclosingClass), ij0.f(((Enum) objInvoke).name()));
                    } else if (Annotation.class.isAssignableFrom(enclosingClass)) {
                        Class cls2 = (Class) ae.L0(enclosingClass.getInterfaces());
                        xb0$a xb0_aE = xb0_a.e(bt0.a(cls2), ij0VarF);
                        if (xb0_aE != null) {
                            H(xb0_aE, (Annotation) objInvoke, cls2);
                        }
                    } else {
                        if (!enclosingClass.isArray()) {
                            throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + objInvoke);
                        }
                        xb0$b xb0_bC = xb0_a.c(ij0VarF);
                        if (xb0_bC == null) {
                            continue;
                        } else {
                            Class<?> componentType = enclosingClass.getComponentType();
                            if (componentType.isEnum()) {
                                dd ddVarA = bt0.a(componentType);
                                Object[] objArr = (Object[]) objInvoke;
                                int length2 = objArr.length;
                                int i3 = 0;
                                while (i3 < length2) {
                                    Object obj = objArr[i3];
                                    i3++;
                                    if (obj == null) {
                                        str = "null cannot be cast to non-null type kotlin.Enum<*>";
                                        d.AnonymousClass0.m$1(str);
                                        return;
                                    }
                                    xb0_bC.d(ddVarA, ij0.f(((Enum) obj).name()));
                                }
                                xb0_bC.a();
                            } else if (componentType.equals(Class.class)) {
                                Object[] objArr2 = (Object[]) objInvoke;
                                int length3 = objArr2.length;
                                int i4 = 0;
                                while (i4 < length3) {
                                    Object obj2 = objArr2[i4];
                                    i4++;
                                    if (obj2 == null) {
                                        str = "null cannot be cast to non-null type java.lang.Class<*>";
                                        d.AnonymousClass0.m$1(str);
                                        return;
                                    }
                                    xb0_bC.e(l((Class) obj2));
                                }
                                xb0_bC.a();
                            } else {
                                Object[] objArr3 = (Object[]) objInvoke;
                                if (Annotation.class.isAssignableFrom(componentType)) {
                                    int length4 = objArr3.length;
                                    int i5 = 0;
                                    while (i5 < length4) {
                                        Object obj3 = objArr3[i5];
                                        i5++;
                                        xb0$a xb0_aB = xb0_bC.b(bt0.a(componentType));
                                        if (xb0_aB != null) {
                                            if (obj3 == null) {
                                                str = "null cannot be cast to non-null type kotlin.Annotation";
                                                d.AnonymousClass0.m$1(str);
                                                return;
                                            }
                                            H(xb0_aB, (Annotation) obj3, componentType);
                                        }
                                    }
                                } else {
                                    int length5 = objArr3.length;
                                    int i6 = 0;
                                    while (i6 < length5) {
                                        Object obj4 = objArr3[i6];
                                        i6++;
                                        xb0_bC.c(obj4);
                                    }
                                }
                                xb0_bC.a();
                            }
                        }
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        xb0_a.mo57a();
    }

    public static final Collection H0(Collection collection, Collection collection2) {
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e8, code lost:
    
        if (defpackage.ij0.g(r6) == false) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.ij0 I(defpackage.ij0 r6, java.lang.String r7, java.lang.String r8, int r9) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e.I(ij0, java.lang.String, java.lang.String, int):ij0");
    }

    public static v91 I(ld ldVar, jc0 jc0Var, w01 w01Var) {
        int iO = ldVar.O(jc0Var);
        int i2 = 0;
        while (true) {
            if (i2 >= iO) {
                return null;
            }
            int i3 = i2 + 1;
            ca1 ca1VarJ = ldVar.J(jc0Var, i2);
            ca1 ca1Var = ldVar.P(ca1VarJ) ? null : ca1VarJ;
            if (ca1Var != null) {
                cc1 cc1VarK = ldVar.k(ca1Var);
                boolean z = ldVar.c0(ldVar.V(cc1VarK)) && ldVar.c0(ldVar.V(w01Var));
                if (e4.a(cc1VarK, w01Var) || (z && e4.a((Object) ldVar.f0(cc1VarK), (Object) ldVar.f0(w01Var)))) {
                    return ldVar.D(ldVar.f0(jc0Var), i2);
                }
                v91 v91VarI = I(ldVar, cc1VarK, w01Var);
                if (v91VarI != null) {
                    return v91VarI;
                }
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean I(la laVar) {
        if (!ca.d.contains(((pk) laVar).getName())) {
            return false;
        }
        if (ca.c.contains(ym.c(laVar)) && laVar.f().isEmpty()) {
            return true;
        }
        if (!ub0.A(laVar)) {
            return false;
        }
        Collection collectionD = laVar.d();
        if (collectionD.isEmpty()) {
            return false;
        }
        Iterator it = collectionD.iterator();
        while (it.hasNext()) {
            if (I((la) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static final ArrayList I0(ArrayList arrayList, List list, ox oxVar) {
        fc0 fc0VarG;
        arrayList.size();
        list.size();
        ArrayList<jo0> arrayListK1 = he.k1(arrayList, list);
        ArrayList arrayList2 = new ArrayList(ae.y0(arrayListK1));
        for (jo0 jo0Var : arrayListK1) {
            tc1 tc1Var = (tc1) jo0Var.b;
            wc1 wc1Var = (wc1) jo0Var.c;
            int i2 = wc1Var.i;
            s4 annotations = wc1Var.getAnnotations();
            ij0 name = wc1Var.getName();
            fc0 fc0Var = tc1Var.a;
            boolean z = tc1Var.b;
            boolean z2 = wc1Var.n;
            boolean z3 = wc1Var.o;
            if (wc1Var.p != null) {
                int i3 = ym.$r8$clinit;
                fc0VarG = xm.d(oxVar).k().g(tc1Var.a);
            } else {
                fc0VarG = null;
            }
            arrayList2.add(new wc1(oxVar, null, i2, annotations, name, fc0Var, z, z2, z3, fc0VarG, wc1Var.g()));
        }
        return arrayList2;
    }

    public static final List J(fc0 fc0Var) {
        L(fc0Var);
        List listK0 = fc0Var.K0();
        return listK0.subList((!L(fc0Var) || fc0Var.getAnnotations().c(m21.a.p) == null) ? 0 : 1, listK0.size() - 1);
    }

    public static final boolean J(v91 v91Var, a91 a91Var, Set set) {
        List<fc0> upperBounds = v91Var.getUpperBounds();
        if (upperBounds != null && upperBounds.isEmpty()) {
            return false;
        }
        for (fc0 fc0Var : upperBounds) {
            if (m(fc0Var, v91Var.n().L0(), set) && (a91Var == null || e4.a((Object) fc0Var.L0(), (Object) a91Var))) {
                return true;
            }
        }
        return false;
    }

    public static final void K(li liVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = qi.a.iterator();
        while (it.hasNext()) {
            try {
                ((p3) it.next()).v(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    e(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            e(th, new ho(liVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final Object L(Set set, Enum r2, Enum r3, Enum r4, boolean z) {
        Enum r1;
        if (!z) {
            if (r4 != null) {
                set = he.i1(nz0.y1(set, r4));
            }
            return he.b1(set);
        }
        if (set.contains(r2)) {
            r1 = r2;
        } else {
            r1 = set.contains(r3) ? r3 : null;
        }
        if (e4.a(r1, r2) && e4.a(r4, r3)) {
            return null;
        }
        return r4 == null ? r1 : r4;
    }

    public static LinkedHashSet L(String[] strArr, String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str2 = strArr[i2];
            i2++;
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    public static final boolean L(fc0 fc0Var) {
        od odVarB = fc0Var.L0().b();
        if (odVarB == null) {
            return false;
        }
        mx mxVarC = C(odVarB);
        return mxVarC == mx.f || mxVarC == mx.g;
    }

    public static final c91 L0(ai0 ai0Var, k kVar) {
        ai0Var.o().size();
        kVar.o().size();
        List listO = ai0Var.o();
        ArrayList arrayList = new ArrayList(ae.y0(listO));
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            arrayList.add(((v91) it.next()).h());
        }
        List listO2 = kVar.o();
        ArrayList arrayList2 = new ArrayList(ae.y0(listO2));
        Iterator it2 = listO2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new da1(((v91) it2.next()).n()));
        }
        return new c91(0, ye1.j(he.k1(arrayList, arrayList2)));
    }

    public static LinkedHashSet M(String[] strArr, String str) {
        return L((String[]) Arrays.copyOf(strArr, strArr.length), e4.j("java/lang/", str));
    }

    public static t11 M(ja jaVar) {
        while (jaVar instanceof la) {
            la laVar = (la) jaVar;
            if (laVar.getKind() != la.a.c) {
                break;
            }
            jaVar = (la) he.b1(laVar.d());
            if (jaVar == null) {
                return null;
            }
        }
        return jaVar.g();
    }

    public static boolean M(ld ldVar, jc0 jc0Var) {
        return ldVar.X(ldVar.f0(jc0Var)) && !ldVar.j(jc0Var) && !ldVar.t(jc0Var) && e4.a((Object) ldVar.c(ldVar.V(jc0Var)), (Object) ldVar.c(ldVar.z(jc0Var)));
    }

    public static LinkedHashSet N(String[] strArr, String str) {
        return L((String[]) Arrays.copyOf(strArr, strArr.length), e4.j("java/util/", str));
    }

    public static final boolean N(ao0 ao0Var, cv cvVar) {
        if (ao0Var != null) {
            return ao0Var.a(cvVar);
        }
        ArrayList arrayList = new ArrayList();
        k(ao0Var, cvVar, arrayList);
        return arrayList.isEmpty();
    }

    public static boolean N(ld ldVar, u01 u01Var, u01 u01Var2) {
        if (ldVar.O(u01Var) == ldVar.O(u01Var2) && ldVar.F(u01Var) == ldVar.F(u01Var2)) {
            if ((ldVar.n0(u01Var) == null) == (ldVar.n0(u01Var2) == null) && ldVar.d0(ldVar.c(u01Var), ldVar.c(u01Var2))) {
                if (!ldVar.E(u01Var, u01Var2)) {
                    int iO = ldVar.O(u01Var);
                    int i2 = 0;
                    while (i2 < iO) {
                        int i3 = i2 + 1;
                        ca1 ca1VarJ = ldVar.J(u01Var, i2);
                        ca1 ca1VarJ2 = ldVar.J(u01Var2, i2);
                        if (ldVar.P(ca1VarJ) == ldVar.P(ca1VarJ2) && (ldVar.P(ca1VarJ) || (ldVar.l0(ca1VarJ) == ldVar.l0(ca1VarJ2) && O(ldVar, ldVar.k(ca1VarJ), ldVar.k(ca1VarJ2))))) {
                            i2 = i3;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    public static final ct0 N0(Annotation[] annotationArr, cv cvVar) {
        Annotation annotation;
        int length = annotationArr.length;
        int i2 = 0;
        while (i2 < length) {
            annotation = annotationArr[i2];
            i2++;
            if (bt0.a(((sc) v(annotation)).d()).b().equals(cvVar)) {
                if (annotation == null) {
                    return null;
                }
                return new ct0(annotation);
            }
        }
        annotation = null;
        if (annotation == null) {
            return null;
        }
        return new ct0(annotation);
    }

    public static final boolean O(fc0 fc0Var) {
        cc1 cc1VarO0 = fc0Var.O0();
        if (cc1VarO0 instanceof or) {
            return true;
        }
        return (cc1VarO0 instanceof zt) && (((zt) cc1VarO0).S0() instanceof or);
    }

    public static boolean O(ld ldVar, cc1 cc1Var, cc1 cc1Var2) {
        if (cc1Var == cc1Var2) {
            return true;
        }
        u01 u01VarA = ldVar.a(cc1Var);
        u01 u01VarA2 = ldVar.a(cc1Var2);
        if (u01VarA != null && u01VarA2 != null) {
            return N(ldVar, u01VarA, u01VarA2);
        }
        zt ztVarE0 = ldVar.e0(cc1Var);
        zt ztVarE1 = ldVar.e0(cc1Var2);
        return ztVarE0 != null && ztVarE1 != null && N(ldVar, ldVar.d(ztVarE0), ldVar.d(ztVarE1)) && N(ldVar, ldVar.f(ztVarE0), ldVar.f(ztVarE1));
    }

    public static wc1 O0(ij0 ij0Var, ai0 ai0Var) {
        if (ij0Var == null) {
            o0(19);
            throw null;
        }
        if (ai0Var == null) {
            o0(20);
            throw null;
        }
        Collection collectionI = ai0Var.i();
        if (collectionI.size() == 1) {
            for (wc1 wc1Var : ((uc) collectionI.iterator().next()).f()) {
                if (wc1Var.getName().equals(ij0Var)) {
                    return wc1Var;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0028  */
    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:19:0x0038  */
    public static final cv P(cv cvVar, cv cvVar2) {
        if (!e4.a(cvVar, cvVar2) && !cvVar2.d()) {
            String strB = cvVar.b();
            String strB2 = cvVar2.b();
            if (strB.startsWith(strB2) && strB.charAt(strB2.length()) == '.') {
                if (!cvVar2.d()) {
                    return e4.a(cvVar, cvVar2) ? cv.c : new cv(cvVar.b().substring(cvVar2.b().length() + 1));
                }
            }
        } else if (!cvVar2.d()) {
            if (e4.a(cvVar, cvVar2)) {
            }
        }
        return cvVar;
    }

    public static boolean P(z81 z81Var, w81 w81Var, w01 w01Var) {
        boolean zQ;
        ld ldVar = z81Var.c;
        a91 a91VarC = ldVar.c(w01Var);
        int i2 = ldVar.i(w81Var);
        int iY = ldVar.y(a91VarC);
        if (i2 == iY && i2 == ldVar.O(w01Var)) {
            int i3 = 0;
            while (i3 < iY) {
                int i4 = i3 + 1;
                ca1 ca1VarJ = ldVar.J(w01Var, i3);
                if (!ldVar.P(ca1VarJ)) {
                    cc1 cc1VarK = ldVar.k(ca1VarJ);
                    ca1 ca1VarK0 = ldVar.k0(w81Var, i3);
                    ldVar.l0(ca1VarK0);
                    cc1 cc1VarK2 = ldVar.k(ca1VarK0);
                    int iA0 = ldVar.a0(ldVar.D(a91VarC, i3));
                    int iL0 = ldVar.l0(ca1VarJ);
                    ak.r(iA0, "declared");
                    ak.r(iL0, "useSite");
                    if (iA0 == 3) {
                        iA0 = iL0;
                    } else if (iL0 != 3 && iA0 != iL0) {
                        iA0 = 0;
                    }
                    if (iA0 == 0) {
                        return z81Var.a;
                    }
                    if (iA0 == 3) {
                        S(ldVar, cc1VarK2, cc1VarK);
                        S(ldVar, cc1VarK, cc1VarK2);
                    }
                    int i5 = z81Var.f;
                    if (i5 > 100) {
                        throw new IllegalStateException(e4.j("Arguments depth is too high. Some related argument: ", cc1VarK2).toString());
                    }
                    z81Var.f = i5 + 1;
                    int iU = ak.u(iA0);
                    if (iU == 0) {
                        zQ = Q(z81Var, cc1VarK, cc1VarK2);
                    } else if (iU == 1) {
                        zQ = Q(z81Var, cc1VarK2, cc1VarK);
                    } else {
                        if (iU != 2) {
                            d.AnonymousClass0.m();
                            return false;
                        }
                        zQ = y(z81Var, cc1VarK2, cc1VarK);
                    }
                    z81Var.f--;
                    if (!zQ) {
                    }
                }
                i3 = i4;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:162:0x0250  */
    /* JADX WARN: Code duplicated, block: B:213:0x0354  */
    /* JADX WARN: Code duplicated, block: B:216:0x0365  */
    /* JADX WARN: Code duplicated, block: B:220:0x0370  */
    /* JADX WARN: Code duplicated, block: B:222:0x0373  */
    /* JADX WARN: Code duplicated, block: B:224:0x0385  */
    /* JADX WARN: Code duplicated, block: B:230:0x0398  */
    /* JADX WARN: Code duplicated, block: B:232:0x039b  */
    /* JADX WARN: Code duplicated, block: B:233:0x039e  */
    /* JADX WARN: Code duplicated, block: B:236:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:238:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:239:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:244:0x03cd A[LOOP:4: B:234:0x03ab->B:244:0x03cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:256:0x0422  */
    /* JADX WARN: Code duplicated, block: B:259:0x042c  */
    /* JADX WARN: Code duplicated, block: B:263:0x043f  */
    /* JADX WARN: Code duplicated, block: B:265:0x044e  */
    /* JADX WARN: Code duplicated, block: B:267:0x0458  */
    /* JADX WARN: Code duplicated, block: B:269:0x045d  */
    /* JADX WARN: Code duplicated, block: B:273:0x046a  */
    /* JADX WARN: Code duplicated, block: B:276:0x047a  */
    /* JADX WARN: Code duplicated, block: B:278:0x0480  */
    /* JADX WARN: Code duplicated, block: B:283:0x0493  */
    /* JADX WARN: Code duplicated, block: B:284:0x0495  */
    /* JADX WARN: Code duplicated, block: B:288:0x049d  */
    /* JADX WARN: Code duplicated, block: B:294:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:298:0x04cd A[LOOP:7: B:292:0x04ad->B:298:0x04cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0080  */
    /* JADX WARN: Code duplicated, block: B:324:0x0366 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:325:0x03d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x008a  */
    /* JADX WARN: Code duplicated, block: B:331:0x000c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:332:? A[LOOP:5: B:257:0x0426->B:332:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:334:0x04d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:335:0x048d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:336:0x04a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:337:0x04c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:339:0x0474 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:340:0x0474 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0093  */
    /* JADX WARN: Code duplicated, block: B:358:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:359:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:360:? A[LOOP:12: B:38:0x009e->B:360:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:361:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:362:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:363:? A[LOOP:13: B:54:0x00d4->B:363:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:364:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:369:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x009a  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00da  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fc  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [ld] */
    /* JADX WARN: Type inference failed for: r7v10, types: [int] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static boolean Q(z81 z81Var, jc0 jc0Var, jc0 jc0Var2) {
        boolean zO;
        Boolean boolValueOf;
        Collection collectionW;
        Boolean bool;
        boolean z;
        List<w01> listI;
        z81.b bVar;
        ArrayList<w01> arrayList;
        int size;
        a91 a91VarC;
        ArrayDeque arrayDeque;
        o11 o11Var;
        w01 w01Var;
        z81.b bVar2;
        Iterator it;
        w01 w01VarA;
        x6 x6Var;
        int iY;
        boolean z2;
        boolean z3;
        ?? r7;
        Iterator it2;
        ArrayList arrayList2;
        int i2;
        ca1 ca1VarG;
        int i3;
        u01 u01VarA;
        a91 a91VarC2;
        a91 a91VarC3;
        v91 v91VarI;
        Collection collectionW2;
        Iterator it3;
        Collection collectionW3;
        Iterator it4;
        cc1 cc1VarB0;
        z81.b bVar3 = z81.b.a;
        z81.b bVar4 = z81.b.a$1;
        if (jc0Var == jc0Var2) {
            return true;
        }
        lc0$a lc0_a = z81Var.e;
        kc0$a kc0_a = z81Var.d;
        lc0_a.getClass();
        cc1 cc1VarB = kc0_a.b((fc0) jc0Var);
        cc1 cc1VarB2 = kc0_a.b((fc0) jc0Var2);
        ?? r6 = z81Var.c;
        u01 u01VarV = r6.V(cc1VarB);
        u01 u01VarZ = r6.z(cc1VarB2);
        boolean z4 = false;
        if (!r6.q(u01VarV) && !r6.q(u01VarZ)) {
            r6.S(u01VarV);
            r6.Y(u01VarV);
            r6.Y(u01VarZ);
            ml mlVarN0 = r6.n0(u01VarZ);
            rb rbVarE = r6.e(mlVarN0 == null ? u01VarZ : r6.h0(mlVarN0));
            cc1 cc1VarO = rbVarE == null ? null : r6.o(rbVarE);
            if (rbVarE == null || cc1VarO == null) {
                a91VarC2 = r6.c(u01VarZ);
                if (r6.l(a91VarC2)) {
                    r6.F(u01VarZ);
                    collectionW3 = r6.W(a91VarC2);
                    if (collectionW3 != null || !collectionW3.isEmpty()) {
                        it4 = collectionW3.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                zO = true;
                                break;
                            }
                            if (!Q(z81Var, u01VarV, (jc0) it4.next())) {
                                zO = false;
                                break;
                            }
                        }
                    } else {
                        zO = true;
                        break;
                    }
                    boolValueOf = Boolean.valueOf(zO);
                } else {
                    a91VarC3 = r6.c(u01VarV);
                    if (u01VarV instanceof rb) {
                        v91VarI = I(r6, u01VarZ, u01VarV);
                        if (v91VarI == null && r6.N(v91VarI, r6.c(u01VarZ))) {
                            boolValueOf = Boolean.TRUE;
                        }
                    } else if (r6.l(a91VarC3)) {
                        collectionW2 = r6.W(a91VarC3);
                        if (collectionW2 == null && collectionW2.isEmpty()) {
                            v91VarI = I(r6, u01VarZ, u01VarV);
                            if (v91VarI == null) {
                            }
                        } else {
                            it3 = collectionW2.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    v91VarI = I(r6, u01VarZ, u01VarV);
                                    if (v91VarI == null) {
                                    }
                                } else if (!(((jc0) it3.next()) instanceof rb)) {
                                }
                            }
                        }
                    }
                    boolValueOf = null;
                }
            } else {
                if (r6.F(u01VarZ)) {
                    cc1VarB0 = r6.M(cc1VarO);
                } else {
                    if (r6.t(u01VarZ)) {
                        cc1VarB0 = r6.b0(cc1VarO);
                    } else if (Q(z81Var, u01VarV, cc1VarO)) {
                        a91VarC2 = r6.c(u01VarZ);
                        if (r6.l(a91VarC2)) {
                            r6.F(u01VarZ);
                            collectionW3 = r6.W(a91VarC2);
                            if (collectionW3 != null) {
                                it4 = collectionW3.iterator();
                                while (true) {
                                    if (!it4.hasNext()) {
                                        zO = true;
                                        break;
                                    }
                                    if (!Q(z81Var, u01VarV, (jc0) it4.next())) {
                                        zO = false;
                                        break;
                                    }
                                }
                            } else {
                                it4 = collectionW3.iterator();
                                while (true) {
                                    if (!it4.hasNext()) {
                                        zO = true;
                                        break;
                                    }
                                    if (!Q(z81Var, u01VarV, (jc0) it4.next())) {
                                        zO = false;
                                        break;
                                    }
                                }
                            }
                            boolValueOf = Boolean.valueOf(zO);
                        } else {
                            a91VarC3 = r6.c(u01VarV);
                            if (u01VarV instanceof rb) {
                                v91VarI = I(r6, u01VarZ, u01VarV);
                                if (v91VarI == null) {
                                }
                            } else if (r6.l(a91VarC3)) {
                                collectionW2 = r6.W(a91VarC3);
                                if (collectionW2 == null) {
                                    it3 = collectionW2.iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            v91VarI = I(r6, u01VarZ, u01VarV);
                                            if (v91VarI == null) {
                                            }
                                        } else if (!(((jc0) it3.next()) instanceof rb)) {
                                        }
                                    }
                                } else {
                                    it3 = collectionW2.iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            v91VarI = I(r6, u01VarZ, u01VarV);
                                            if (v91VarI == null) {
                                            }
                                        } else if (!(((jc0) it3.next()) instanceof rb)) {
                                        }
                                    }
                                }
                            }
                            boolValueOf = null;
                        }
                    }
                    boolValueOf = Boolean.TRUE;
                }
                cc1VarO = cc1VarB0;
                if (Q(z81Var, u01VarV, cc1VarO)) {
                    a91VarC2 = r6.c(u01VarZ);
                    if (r6.l(a91VarC2)) {
                        r6.F(u01VarZ);
                        collectionW3 = r6.W(a91VarC2);
                        if (collectionW3 != null) {
                            it4 = collectionW3.iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    zO = true;
                                    break;
                                }
                                if (!Q(z81Var, u01VarV, (jc0) it4.next())) {
                                    zO = false;
                                    break;
                                }
                            }
                        } else {
                            it4 = collectionW3.iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    zO = true;
                                    break;
                                }
                                if (!Q(z81Var, u01VarV, (jc0) it4.next())) {
                                    zO = false;
                                    break;
                                }
                            }
                        }
                        boolValueOf = Boolean.valueOf(zO);
                    } else {
                        a91VarC3 = r6.c(u01VarV);
                        if (u01VarV instanceof rb) {
                            v91VarI = I(r6, u01VarZ, u01VarV);
                            if (v91VarI == null) {
                            }
                        } else if (r6.l(a91VarC3)) {
                            collectionW2 = r6.W(a91VarC3);
                            if (collectionW2 == null) {
                                it3 = collectionW2.iterator();
                                while (true) {
                                    if (!it3.hasNext()) {
                                        v91VarI = I(r6, u01VarZ, u01VarV);
                                        if (v91VarI == null) {
                                        }
                                    } else if (!(((jc0) it3.next()) instanceof rb)) {
                                    }
                                }
                            } else {
                                it3 = collectionW2.iterator();
                                while (true) {
                                    if (!it3.hasNext()) {
                                        v91VarI = I(r6, u01VarZ, u01VarV);
                                        if (v91VarI == null) {
                                        }
                                    } else if (!(((jc0) it3.next()) instanceof rb)) {
                                    }
                                }
                            }
                        }
                        boolValueOf = null;
                    }
                } else {
                    boolValueOf = Boolean.TRUE;
                }
            }
        } else if (z81Var.a) {
            boolValueOf = Boolean.TRUE;
        } else if (!r6.F(u01VarV) || r6.F(u01VarZ)) {
            zO = O(r6, r6.b(u01VarV, false), r6.b(u01VarZ, false));
            boolValueOf = Boolean.valueOf(zO);
        } else {
            boolValueOf = Boolean.FALSE;
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        w01 w01VarV = r6.V(cc1VarB);
        u01 u01VarZ2 = r6.z(cc1VarB2);
        boolean zF = r6.F(u01VarZ2);
        int i4 = InternalZipConstants.AES_HASH_ITERATIONS;
        if (!zF && !r6.t(w01VarV) && ((!(w01VarV instanceof rb) || !r6.j0((rb) w01VarV)) && !x(z81Var, w01VarV, bVar3))) {
            if (r6.t(u01VarZ2) || x(z81Var, u01VarZ2, z81.b.a$2) || r6.U(w01VarV)) {
                return false;
            }
            a91 a91VarC4 = r6.c(u01VarZ2);
            if (!z(z81Var, w01VarV, a91VarC4)) {
                z81Var.b();
                ArrayDeque arrayDeque2 = z81Var.g;
                o11 o11Var2 = z81Var.h;
                arrayDeque2.push(w01VarV);
                loop0: while (true) {
                    if (arrayDeque2.isEmpty()) {
                        boolean z5 = z4;
                        z81Var.a();
                        return z5;
                    }
                    if (o11Var2.c > i4) {
                        StringBuilder sbM = m("Too many supertypes for type: ", w01VarV, ". Supertypes = ");
                        sbM.append(he.R0(o11Var2, null, null, null, null, 63));
                        throw new IllegalStateException(sbM.toString().toString());
                    }
                    w01 w01Var2 = (w01) arrayDeque2.pop();
                    if (o11Var2.add(w01Var2)) {
                        z81.b bVar5 = r6.F(w01Var2) ? bVar4 : bVar3;
                        if (bVar5.equals(bVar4)) {
                            bVar5 = null;
                        }
                        if (bVar5 != null) {
                            Iterator it5 = r6.W(r6.c(w01Var2)).iterator();
                            while (it5.hasNext()) {
                                w01 w01VarA2 = bVar5.a(z81Var, (jc0) it5.next());
                                if (z(z81Var, w01VarA2, a91VarC4)) {
                                    z81Var.a();
                                    break loop0;
                                }
                                arrayDeque2.add(w01VarA2);
                                z4 = z4;
                            }
                        }
                        i4 = 1000;
                        z4 = z4;
                    }
                }
            }
        }
        u01 u01VarV2 = r6.V(w01VarV);
        u01 u01VarZ3 = r6.z(u01VarZ2);
        if (r6.w(u01VarV2) || r6.w(u01VarZ3)) {
            if (!r6.w(u01VarV2) || !r6.w(u01VarZ3)) {
                if (!r6.w(u01VarV2)) {
                    if (r6.w(u01VarZ3)) {
                        a91 a91VarC5 = r6.c(u01VarV2);
                        if ((a91VarC5 instanceof j30) && ((collectionW = r6.W(a91VarC5)) == null || !collectionW.isEmpty())) {
                            Iterator it6 = collectionW.iterator();
                            while (true) {
                                if (it6.hasNext()) {
                                    u01 u01VarA2 = r6.a((jc0) it6.next());
                                    if (u01VarA2 != null && r6.w(u01VarA2)) {
                                    }
                                } else if (h(r6, z81Var, u01VarZ3, u01VarV2, true)) {
                                }
                            }
                        } else if (h(r6, z81Var, u01VarZ3, u01VarV2, true)) {
                        }
                    }
                    bool = null;
                } else if (!h(r6, z81Var, u01VarV2, u01VarZ3, z4)) {
                    bool = null;
                }
            }
            bool = Boolean.TRUE;
        } else {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        a91 a91VarC6 = r6.c(u01VarZ2);
        if ((r6.d0(r6.c(w01VarV), a91VarC6) && r6.y(a91VarC6) == 0) || r6.i0(r6.c(u01VarZ2))) {
            return true;
        }
        if (!r6.U(w01VarV)) {
            if (r6.m(a91VarC6) || r6.g0(a91VarC6)) {
                n11 n11Var = new n11();
                z81Var.b();
                ArrayDeque arrayDeque3 = z81Var.g;
                o11 o11Var3 = z81Var.h;
                arrayDeque3.push(w01VarV);
                while (!arrayDeque3.isEmpty()) {
                    if (o11Var3.c > 1000) {
                        StringBuilder sbM2 = m("Too many supertypes for type: ", w01VarV, ". Supertypes = ");
                        sbM2.append(he.R0(o11Var3, null, null, null, null, 63));
                        throw new IllegalStateException(sbM2.toString().toString());
                    }
                    w01 w01Var3 = (w01) arrayDeque3.pop();
                    if (o11Var3.add(w01Var3)) {
                        if (r6.U(w01Var3)) {
                            n11Var.add(w01Var3);
                            bVar = bVar4;
                        } else {
                            bVar = bVar3;
                        }
                        if (bVar.equals(bVar4)) {
                            bVar = null;
                        }
                        if (bVar != null) {
                            Iterator it7 = r6.W(r6.c(w01Var3)).iterator();
                            while (it7.hasNext()) {
                                arrayDeque3.add(bVar.a(z81Var, (jc0) it7.next()));
                                z4 = z4;
                            }
                        }
                    }
                }
                z = z4;
                z81Var.a();
                ArrayList arrayList3 = new ArrayList();
                Iterator it8 = n11Var.iterator();
                while (it8.hasNext()) {
                    he.C0(j(z81Var, (w01) it8.next(), a91VarC6), arrayList3);
                }
                listI = arrayList3;
            } else {
                listI = i(z81Var, w01VarV, a91VarC6);
            }
            arrayList = new ArrayList(ae.y0(listI));
            for (w01 w01Var4 : listI) {
                u01VarA = r6.a(kc0_a.b(w01Var4));
                if (u01VarA == null) {
                    w01Var4 = u01VarA;
                }
                arrayList.add(w01Var4);
            }
            size = arrayList.size();
            if (size != 0) {
                a91VarC = r6.c(w01VarV);
                if (r6.m(a91VarC)) {
                    return r6.H(a91VarC);
                }
                if (r6.H(r6.c(w01VarV))) {
                    return true;
                }
                z81Var.b();
                arrayDeque = z81Var.g;
                o11Var = z81Var.h;
                arrayDeque.push(w01VarV);
                while (!arrayDeque.isEmpty()) {
                    if (o11Var.c <= 1000) {
                        StringBuilder sbM3 = m("Too many supertypes for type: ", w01VarV, ". Supertypes = ");
                        sbM3.append(he.R0(o11Var, null, null, null, null, 63));
                        throw new IllegalStateException(sbM3.toString().toString());
                    }
                    w01Var = (w01) arrayDeque.pop();
                    if (o11Var.add(w01Var)) {
                        if (r6.U(w01Var)) {
                            bVar2 = bVar4;
                        } else {
                            bVar2 = bVar3;
                        }
                        if (bVar2.equals(bVar4)) {
                            bVar2 = null;
                        }
                        if (bVar2 == null) {
                            continue;
                        } else {
                            it = r6.W(r6.c(w01Var)).iterator();
                            while (it.hasNext()) {
                                w01VarA = bVar2.a(z81Var, (jc0) it.next());
                                if (r6.H(r6.c(w01VarA))) {
                                    z81Var.a();
                                    return true;
                                }
                                arrayDeque.add(w01VarA);
                            }
                        }
                    }
                }
                z81Var.a();
                return z;
            }
            if (size != 1) {
                return P(z81Var, r6.R((w01) he.K0(arrayList)), u01VarZ2);
            }
            x6Var = new x6(r6.y(a91VarC6));
            iY = r6.y(a91VarC6);
            z2 = z;
            z3 = z2 ? 1 : 0;
            while (r7 < iY) {
                int i5 = r7 + 1;
                if (z3 && r6.a0(r6.D(a91VarC6, r7)) == 2) {
                    z3 = z;
                } else {
                    r7 = z2;
                    r7 = z2;
                    z3 = true;
                }
                if (z3) {
                    r7 = z2;
                    i2 = iY;
                } else {
                    r7 = z2;
                    arrayList2 = new ArrayList(ae.y0(arrayList));
                    for (w01 w01Var5 : arrayList) {
                        ca1VarG = r6.G(w01Var5, r7);
                        if (ca1VarG == null) {
                            i3 = iY;
                        } else {
                            i3 = iY;
                            if (r6.l0(ca1VarG) != 3) {
                            }
                            if (ca1VarG != null) {
                                throw new IllegalStateException(("Incorrect type: " + w01Var5 + ", subType: " + w01VarV + ", superType: " + u01VarZ2).toString());
                            }
                            arrayList2.add(r6.k(ca1VarG));
                            iY = i3;
                        }
                        ca1VarG = null;
                        if (ca1VarG != null) {
                            throw new IllegalStateException(("Incorrect type: " + w01Var5 + ", subType: " + w01VarV + ", superType: " + u01VarZ2).toString());
                        }
                        arrayList2.add(r6.k(ca1VarG));
                        iY = i3;
                    }
                    i2 = iY;
                    x6Var.add(r6.B(r6.A(arrayList2)));
                }
                iY = i2;
                r7 = i5;
            }
            if (z3 && P(z81Var, x6Var, u01VarZ2)) {
                r7 = z2;
                return true;
            }
            r7 = z2;
            r7 = z2;
            if (arrayList.isEmpty()) {
                return z;
            }
            it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (P(z81Var, r6.R((w01) it2.next()), u01VarZ2)) {
                    return true;
                }
            }
            return z;
        }
        listI = j(z81Var, w01VarV, a91VarC6);
        z = z4;
        arrayList = new ArrayList(ae.y0(listI));
        while (r8.hasNext()) {
            u01VarA = r6.a(kc0_a.b(w01Var4));
            if (u01VarA == null) {
                w01Var4 = u01VarA;
            }
            arrayList.add(w01Var4);
        }
        size = arrayList.size();
        if (size != 0) {
            a91VarC = r6.c(w01VarV);
            if (r6.m(a91VarC)) {
                return r6.H(a91VarC);
            }
            if (r6.H(r6.c(w01VarV))) {
                return true;
            }
            z81Var.b();
            arrayDeque = z81Var.g;
            o11Var = z81Var.h;
            arrayDeque.push(w01VarV);
            while (!arrayDeque.isEmpty()) {
                if (o11Var.c <= 1000) {
                    StringBuilder sbM4 = m("Too many supertypes for type: ", w01VarV, ". Supertypes = ");
                    sbM4.append(he.R0(o11Var, null, null, null, null, 63));
                    throw new IllegalStateException(sbM4.toString().toString());
                }
                w01Var = (w01) arrayDeque.pop();
                if (o11Var.add(w01Var)) {
                    if (r6.U(w01Var)) {
                        bVar2 = bVar4;
                    } else {
                        bVar2 = bVar3;
                    }
                    if (bVar2.equals(bVar4)) {
                        bVar2 = null;
                    }
                    if (bVar2 == null) {
                        continue;
                    } else {
                        it = r6.W(r6.c(w01Var)).iterator();
                        while (it.hasNext()) {
                            w01VarA = bVar2.a(z81Var, (jc0) it.next());
                            if (r6.H(r6.c(w01VarA))) {
                                z81Var.a();
                                return true;
                            }
                            arrayDeque.add(w01VarA);
                        }
                    }
                }
            }
            z81Var.a();
            return z;
        }
        if (size != 1) {
            return P(z81Var, r6.R((w01) he.K0(arrayList)), u01VarZ2);
        }
        x6Var = new x6(r6.y(a91VarC6));
        iY = r6.y(a91VarC6);
        z2 = z;
        z3 = z2 ? 1 : 0;
        while (r7 < iY) {
            int i6 = r7 + 1;
            if (z3) {
                r7 = z2;
                r7 = z2;
                z3 = true;
            } else {
                r7 = z2;
                r7 = z2;
                z3 = true;
            }
            if (z3) {
                r7 = z2;
                i2 = iY;
            } else {
                r7 = z2;
                arrayList2 = new ArrayList(ae.y0(arrayList));
                while (r12.hasNext()) {
                    ca1VarG = r6.G(w01Var5, r7);
                    if (ca1VarG == null) {
                        i3 = iY;
                    } else {
                        i3 = iY;
                        if (r6.l0(ca1VarG) != 3) {
                        }
                        if (ca1VarG != null) {
                            throw new IllegalStateException(("Incorrect type: " + w01Var5 + ", subType: " + w01VarV + ", superType: " + u01VarZ2).toString());
                        }
                        arrayList2.add(r6.k(ca1VarG));
                        iY = i3;
                    }
                    ca1VarG = null;
                    if (ca1VarG != null) {
                        throw new IllegalStateException(("Incorrect type: " + w01Var5 + ", subType: " + w01VarV + ", superType: " + u01VarZ2).toString());
                    }
                    arrayList2.add(r6.k(ca1VarG));
                    iY = i3;
                }
                i2 = iY;
                x6Var.add(r6.B(r6.A(arrayList2)));
            }
            iY = i2;
            r7 = i6;
        }
        if (z3) {
        }
        r7 = z2;
        r7 = z2;
        if (arrayList.isEmpty()) {
            return z;
        }
        it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (P(z81Var, r6.R((w01) it2.next()), u01VarZ2)) {
                return true;
            }
        }
        return z;
    }

    public static final Object[] Q(Collection collection) {
        int size = collection.size();
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArrCopyOf = new Object[size];
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    objArrCopyOf[i2] = it.next();
                    if (i3 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            i4 = 2147483645;
                            if (i3 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                    } else if (!it.hasNext()) {
                        return Arrays.copyOf(objArrCopyOf, i3);
                    }
                    i2 = i3;
                }
            }
        }
        return f26b;
    }

    public static final boolean R(fc0 fc0Var) {
        od odVarB = fc0Var.L0().b();
        return (odVarB == null ? null : C(odVarB)) == mx.g;
    }

    public static final Object[] R(Collection collection, Object[] objArr) {
        objArr.getClass();
        int size = collection.size();
        int i2 = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArrCopyOf = size <= objArr.length ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
                while (true) {
                    int i3 = i2 + 1;
                    objArrCopyOf[i2] = it.next();
                    if (i3 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            i4 = 2147483645;
                            if (i3 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                    } else if (!it.hasNext()) {
                        if (objArrCopyOf != objArr) {
                            return Arrays.copyOf(objArrCopyOf, i3);
                        }
                        objArr[i3] = null;
                        return objArr;
                    }
                    i2 = i3;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }

    public static final rd0 R0(ai0 ai0Var) {
        ai0 ai0Var2;
        int i2 = ym.$r8$clinit;
        Iterator it = ai0Var.n().L0().d().iterator();
        while (true) {
            if (!it.hasNext()) {
                ai0Var2 = null;
                break;
            }
            fc0 fc0Var = (fc0) it.next();
            if (!ub0.y(fc0Var)) {
                od odVarB = fc0Var.L0().b();
                if (xm.n(odVarB, 1) || xm.n(odVarB, 3)) {
                    if (odVarB != null) {
                        ai0Var2 = (ai0) odVarB;
                        break;
                    }
                    d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return null;
                }
            }
        }
        if (ai0Var2 == null) {
            return null;
        }
        vg0 vg0VarO0 = ai0Var2.o0();
        rd0 rd0Var = vg0VarO0 instanceof rd0 ? (rd0) vg0VarO0 : null;
        return rd0Var == null ? R0(ai0Var2) : rd0Var;
    }

    public static final String S(BufferedReader bufferedReader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
        while (true) {
            int i2 = bufferedReader.read(cArr);
            if (i2 < 0) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, i2);
        }
    }

    public static void S(ld ldVar, cc1 cc1Var, cc1 cc1Var2) {
        w81 w81VarA = ldVar.a(cc1Var);
        if (w81VarA instanceof rb) {
            rb rbVar = (rb) w81VarA;
            if (!ldVar.h(rbVar) && ldVar.P(ldVar.C(ldVar.T(rbVar))) && ldVar.r(rbVar) == ib.b) {
                ldVar.f0(cc1Var2);
            }
        }
    }

    public static final Object T(Object obj) {
        return obj instanceof te ? new bw0.a(((te) obj).a) : obj;
    }

    public static final void T(FileOutputStream fileOutputStream, String str, Charset charset) throws IOException {
        if (str.length() < 16384) {
            fileOutputStream.write(str.getBytes(charset));
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder charsetEncoderOnUnmappableCharacter = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer charBufferAllocate = CharBuffer.allocate(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.ceil(charsetEncoderOnUnmappableCharacter.maxBytesPerChar())) * AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int iMin = Math.min(8192 - i3, str.length() - i2);
            int i4 = i2 + iMin;
            str.getChars(i2, i4, charBufferAllocate.array(), i3);
            charBufferAllocate.limit(iMin + i3);
            i3 = 1;
            if (!charsetEncoderOnUnmappableCharacter.encode(charBufferAllocate, byteBufferAllocate, i4 == str.length()).isUnderflow()) {
                d.AnonymousClass0.m("Check failed.");
                return;
            }
            fileOutputStream.write(byteBufferAllocate.array(), 0, byteBufferAllocate.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i3 = 0;
            }
            charBufferAllocate.clear();
            byteBufferAllocate.clear();
            i2 = i4;
        }
    }

    public static final u01 U(u01 u01Var, List list, s4 s4Var) {
        if (list.isEmpty() && s4Var == u01Var.getAnnotations()) {
            return u01Var;
        }
        return list.isEmpty() ? u01Var.R0(s4Var) : e4.f(s4Var, u01Var.L0(), list, u01Var.M0());
    }

    public static final ai U0(ai aiVar) {
        ai aiVarIntercepted;
        bi biVar = aiVar instanceof bi ? (bi) aiVar : null;
        return (biVar == null || (aiVarIntercepted = biVar.intercepted()) == null) ? aiVar : aiVarIntercepted;
    }

    public static fc0 V(fc0 fc0Var, List list, s4 s4Var, int i2) {
        if ((i2 & 2) != 0) {
            s4Var = fc0Var.getAnnotations();
        }
        if ((list.isEmpty() || list == fc0Var.K0()) && s4Var == fc0Var.getAnnotations()) {
            return fc0Var;
        }
        cc1 cc1VarO0 = fc0Var.O0();
        if (cc1VarO0 instanceof zt) {
            zt ztVar = (zt) cc1VarO0;
            return e4.c(U(ztVar.c, list, s4Var), U(ztVar.d, list, s4Var));
        }
        if (cc1VarO0 instanceof u01) {
            return U((u01) cc1VarO0, list, s4Var);
        }
        d.AnonymousClass0.m();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final rc0 V(be0 be0Var, lw lwVar) {
        e eVar = f33d$1;
        int iOrdinal = be0Var.ordinal();
        if (iOrdinal == 0) {
            return new v41(lwVar);
        }
        if (iOrdinal == 1) {
            kx0 kx0Var = new kx0();
            kx0Var.b = (oc0) lwVar;
            kx0Var.c = eVar;
            return kx0Var;
        }
        if (iOrdinal != 2) {
            d.AnonymousClass0.m();
            return null;
        }
        xb1 xb1Var = new xb1();
        xb1Var.b = (oc0) lwVar;
        xb1Var.c = eVar;
        return xb1Var;
    }

    public static /* synthetic */ u01 W(u01 u01Var, List list, s4 s4Var, int i2) {
        if ((i2 & 1) != 0) {
            list = u01Var.K0();
        }
        if ((i2 & 2) != 0) {
            s4Var = u01Var.getAnnotations();
        }
        return U(u01Var, list, s4Var);
    }

    public static final boolean X0(Throwable th) {
        Class<?> superclass = th.getClass();
        while (!e4.a(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }

    public static final cc1 Y(fc0 fc0Var) {
        u01 u01Var;
        cc1 cc1VarW;
        jc0 jc0VarO0 = fc0Var.O0();
        if (jc0VarO0 instanceof zt) {
            zt ztVar = (zt) jc0VarO0;
            u01 u01VarW = ztVar.c;
            if (!u01VarW.L0().getParameters().isEmpty() && u01VarW.L0().b() != null) {
                List parameters = u01VarW.L0().getParameters();
                ArrayList arrayList = new ArrayList(ae.y0(parameters));
                Iterator it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new da1((v91) it.next()));
                }
                u01VarW = W(u01VarW, arrayList, null, 2);
            }
            u01 u01VarW2 = ztVar.d;
            if (!u01VarW2.L0().getParameters().isEmpty() && u01VarW2.L0().b() != null) {
                List parameters2 = u01VarW2.L0().getParameters();
                ArrayList arrayList2 = new ArrayList(ae.y0(parameters2));
                Iterator it2 = parameters2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new da1((v91) it2.next()));
                }
                u01VarW2 = W(u01VarW2, arrayList2, null, 2);
            }
            cc1VarW = e4.c(u01VarW, u01VarW2);
        } else {
            if (!(jc0VarO0 instanceof u01)) {
                d.AnonymousClass0.m();
                return null;
            }
            u01Var = (u01) jc0VarO0;
            if (!u01Var.L0().getParameters().isEmpty() && u01Var.L0().b() != null) {
                cc1VarW = u01Var;
                cc1VarW = u01Var;
                List parameters3 = u01Var.L0().getParameters();
                ArrayList arrayList3 = new ArrayList(ae.y0(parameters3));
                Iterator it3 = parameters3.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new da1((v91) it3.next()));
                }
                cc1VarW = W(u01Var, arrayList3, null, 2);
            }
        }
        cc1VarW = u01Var;
        cc1VarW = u01Var;
        cc1VarW = u01Var;
        return v1(cc1VarW, jc0VarO0 instanceof ra1 ? ((ra1) jc0VarO0).i0() : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void Y0(ti tiVar, oi oiVar, bx bxVar, int i2) {
        Object aVar;
        li liVar = oiVar;
        if ((i2 & 1) != 0) {
            liVar = rq.b;
        }
        xi xiVar = xi.b;
        li liVarA = ak.a(tiVar.x(), liVar, true);
        hl hlVar = uo.a;
        if (liVarA != hlVar && liVarA.a(b$2) == null) {
            liVarA = liVarA.y(hlVar);
        }
        l21 l21Var = new l21(liVarA, true);
        int iOrdinal = xiVar.ordinal();
        tb1 tb1Var = tb1.a;
        if (iOrdinal == 0) {
            try {
                o1(tb1Var, U0(((i8) bxVar).create(l21Var, l21Var)));
                return;
            } catch (Throwable th) {
                l21Var.resumeWith(new bw0.a(th));
                throw th;
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                U0(((i8) bxVar).create(l21Var, l21Var)).resumeWith(tb1Var);
                return;
            }
            if (iOrdinal != 3) {
                d.AnonymousClass0.m();
                return;
            }
            try {
                li liVar2 = l21Var.d;
                Object objB = b2.b(liVar2, (Object) null);
                try {
                    e4.b((i8) bxVar);
                    aVar = bxVar.invoke(l21Var, l21Var);
                    b2.a(liVar2, objB);
                    if (aVar == vi.b) {
                        return;
                    }
                } catch (Throwable th2) {
                    b2.a(liVar2, objB);
                    throw th2;
                }
            } catch (Throwable th3) {
                aVar = new bw0.a(th3);
            }
            l21Var.resumeWith(aVar);
        }
    }

    public static final List Z(Object obj) {
        return obj != null ? Collections.singletonList(obj) : uq.b;
    }

    public static final wc0 Z(v8 v8Var, o40 o40Var) {
        return new wc0(v8Var, o40Var, false);
    }

    public static float Z0(int i2) {
        float f2 = i2 / 255.0f;
        return (f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static float a(float f2, float f3, float f4, float f5) {
        return ((f2 - f3) * f4) + f5;
    }

    public static final c21$a$a a(String str, String str2, String str3, String str4) {
        ArrayList arrayList = c21.b;
        return new c21$a$a(ij0.f(str2), str + '.' + (str2 + '(' + str3 + ')' + str4));
    }

    public static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
            case 4:
                objArr[0] = "b";
                break;
            case 2:
            case 7:
                objArr[0] = "typeCheckingProcedure";
                break;
            case 3:
            default:
                objArr[0] = "a";
                break;
            case 5:
            case 10:
                objArr[0] = "subtype";
                break;
            case 6:
            case 11:
                objArr[0] = "supertype";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 9:
                objArr[0] = "typeProjection";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch (i2) {
            case 3:
            case 4:
                objArr[2] = "assertEqualTypeConstructors";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "assertSubtype";
                break;
            case 8:
            case 9:
                objArr[2] = "capture";
                break;
            case 10:
            case 11:
                objArr[2] = "noCorrespondingSupertype";
                break;
            default:
                objArr[2] = "assertEqualTypes";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean a(gq gqVar, Editable editable, int i2, int i3, boolean z) {
        int iMin;
        if (editable != null && i2 >= 0 && i3 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd) {
                if (z) {
                    int iMax = Math.max(i2, 0);
                    int length = editable.length();
                    if (selectionStart >= 0 && length >= selectionStart && iMax >= 0) {
                        loop0: while (true) {
                            boolean z2 = false;
                            while (true) {
                                if (iMax == 0) {
                                    break loop0;
                                }
                                selectionStart--;
                                if (selectionStart < 0) {
                                    if (!z2) {
                                        selectionStart = 0;
                                        break loop0;
                                    }
                                    break loop0;
                                }
                                char cCharAt = editable.charAt(selectionStart);
                                if (z2) {
                                    if (Character.isHighSurrogate(cCharAt)) {
                                        iMax--;
                                    }
                                } else if (!Character.isSurrogate(cCharAt)) {
                                    iMax--;
                                } else if (!Character.isHighSurrogate(cCharAt)) {
                                    z2 = true;
                                }
                                selectionStart = -1;
                                break loop0;
                            }
                        }
                    }
                    selectionStart = -1;
                    break loop0;
                    int iMax2 = Math.max(i3, 0);
                    iMin = editable.length();
                    if (selectionEnd >= 0 && iMin >= selectionEnd && iMax2 >= 0) {
                        loop2: while (true) {
                            boolean z3 = false;
                            while (true) {
                                if (iMax2 != 0) {
                                    if (selectionEnd >= iMin) {
                                        if (!z3) {
                                            break loop2;
                                        }
                                        break loop2;
                                    }
                                    char cCharAt2 = editable.charAt(selectionEnd);
                                    if (z3) {
                                        if (Character.isLowSurrogate(cCharAt2)) {
                                            iMax2--;
                                            selectionEnd++;
                                        }
                                    } else if (!Character.isSurrogate(cCharAt2)) {
                                        iMax2--;
                                        selectionEnd++;
                                    } else if (!Character.isLowSurrogate(cCharAt2)) {
                                        selectionEnd++;
                                        z3 = true;
                                    }
                                    iMin = -1;
                                    break loop2;
                                }
                                iMin = selectionEnd;
                                break loop2;
                            }
                        }
                    }
                    iMin = -1;
                    break loop2;
                    if (selectionStart != -1 && iMin != -1) {
                    }
                } else {
                    selectionStart = Math.max(selectionStart - i2, 0);
                    iMin = Math.min(selectionEnd + i3, editable.length());
                }
                cb1[] cb1VarArr = (cb1[]) editable.getSpans(selectionStart, iMin, cb1.class);
                if (cb1VarArr != null && cb1VarArr.length > 0) {
                    for (cb1 cb1Var : cb1VarArr) {
                        int spanStart = editable.getSpanStart(cb1Var);
                        int spanEnd = editable.getSpanEnd(cb1Var);
                        selectionStart = Math.min(spanStart, selectionStart);
                        iMin = Math.max(spanEnd, iMin);
                    }
                    int iMax3 = Math.max(selectionStart, 0);
                    int iMin2 = Math.min(iMin, editable.length());
                    gqVar.beginBatchEdit();
                    editable.delete(iMax3, iMin2);
                    gqVar.endBatchEdit();
                    return true;
                }
            }
        }
        return false;
    }

    public static ai0 a0(cv cvVar, ub0 ub0Var) {
        dd ddVar = (dd) l60.h.get(cvVar.i());
        if (ddVar != null) {
            return ub0Var.j(ddVar.b());
        }
        return null;
    }

    public static final LinkedHashSet a1(Object... objArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(ye1.e(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004a  */
    /* JADX WARN: Code duplicated, block: B:61:0x017e  */
    /* JADX WARN: Code duplicated, block: B:70:0x019e  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:75:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:76:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:79:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:80:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:81:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:83:0x01f6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:86:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:87:0x0205  */
    /* JADX WARN: Code duplicated, block: B:88:0x020c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0212  */
    /* JADX WARN: Code duplicated, block: B:91:0x021d  */
    /* JADX WARN: Code duplicated, block: B:92:0x0228 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x022a  */
    /* JADX WARN: Code duplicated, block: B:94:0x0231  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ta b(ra0.a aVar, boolean z) {
        o80$e o80_e;
        ta ua_g_a;
        Field field;
        ta cVar;
        ok okVarB;
        ok okVarB2;
        w80.b bVar;
        vu0 vu0Var = p90.b;
        String str = aVar.p().j;
        vu0Var.getClass();
        if (((Pattern) vu0Var.b).matcher(str).matches()) {
            return t61.a;
        }
        dd ddVar = uw0.a;
        uh uhVarB = uw0.b(aVar.p().l());
        Method methodI = null;
        int i2 = 2;
        int i3 = 6;
        boolean z2 = true;
        char c2 = 1;
        char c3 = 1;
        char c4 = 1;
        char c5 = 1;
        char c6 = 1;
        char c7 = 1;
        char c8 = 1;
        int i4 = 0;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        if (uhVarB instanceof v80$c) {
            v80$c v80_c = (v80$c) uhVarB;
            w80.c cVar2 = v80_c.c;
            int i5 = cVar2.c;
            int i6 = 4;
            if (z) {
                if ((i5 & 4) == 4) {
                    bVar = cVar2.g;
                } else {
                    bVar = null;
                }
            } else if ((i5 & 8) == 8) {
                bVar = cVar2.i;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                p90 p90Var = aVar.p().g;
                int i7 = bVar.d;
                jj0 jj0Var = v80_c.d;
                methodI = p90Var.i(jj0Var.getString(i7), jj0Var.getString(bVar.f));
            }
            if (methodI != null) {
                if (!Modifier.isStatic(methodI.getModifiers())) {
                    cVar = aVar.n() ? new ua$g$a(methodI, B(aVar)) : new ua$g$d(methodI, objArr8 == true ? 1 : 0, i3, objArr7 == true ? 1 : 0);
                } else if (aVar.p().l().getAnnotations().f(lc1.a)) {
                    cVar = aVar.n() ? new ua$g$b(methodI, objArr6 == true ? 1 : 0, i6) : new ua$g$d(methodI, c3 == true ? 1 : 0, i6, c2 == true ? 1 : 0);
                } else {
                    cVar = aVar.n() ? new ua$g$c(methodI, B(aVar)) : new ua$g$d(methodI, objArr5 == true ? 1 : 0, i3, i2);
                }
                ua_g_a = cVar;
            } else if (j20.d(aVar.p().l()) && aVar.p().l().getVisibility().equals(cn.d)) {
                Class clsG0 = g0(aVar.p().l().b());
                if (clsG0 == null) {
                    throw new yi("Underlying property of inline class " + aVar.p() + " should have a field");
                }
                Method methodH = H(clsG0, aVar.p().l());
                ua_g_a = aVar.n() ? new i30.a(methodH, B(aVar)) : new i30.b(methodH, Collections.singletonList(methodH.getDeclaringClass()));
            } else {
                field = (Field) aVar.p().o.invoke();
                if (field == null) {
                    throw new yi(e4.j("No accessors or field is found for property ", aVar.p()));
                }
                nq0 nq0VarQ = aVar.p().l();
                okVarB = nq0VarQ.b();
                if (!xm.l(okVarB)) {
                    okVarB2 = okVarB.b();
                    if ((!xm.n(okVarB2, 2) || xm.n(okVarB2, 5)) && !((nq0VarQ instanceof ao) && x80.d(((ao) nq0VarQ).F))) {
                        if (Modifier.isStatic(field.getModifiers())) {
                            if (aVar.p().l().getAnnotations().f(lc1.a)) {
                                if (z) {
                                    if (aVar.n()) {
                                        cVar = new ua.e.b(field, false);
                                    } else {
                                        cVar = new ua.e.c(field, c7 == true ? 1 : 0, c6 == true ? 1 : 0);
                                    }
                                } else if (aVar.n()) {
                                    cVar = new ua.f.b(field, m(aVar), false);
                                } else {
                                    cVar = new ua.f.c(field, m(aVar), c5 == true ? 1 : 0, c4 == true ? 1 : 0);
                                }
                            } else if (z) {
                                cVar = new ua.e.c(field, objArr10 == true ? 1 : 0, i2);
                            } else {
                                cVar = new ua.f.c(field, m(aVar), objArr9 == true ? 1 : 0, i2);
                            }
                        } else if (z) {
                            if (aVar.n()) {
                                cVar = new ua.e.a(field, B(aVar));
                            } else {
                                cVar = new ua.e.c(field, z2, i4);
                            }
                        } else if (aVar.n()) {
                            cVar = new ua.f.a(field, m(aVar), B(aVar));
                        } else {
                            cVar = new ua.f.c(field, m(aVar), c8 == true ? 1 : 0, objArr11 == true ? 1 : 0);
                        }
                    } else if (z) {
                        if (aVar.n()) {
                            cVar = new ua.e.a(field, B(aVar));
                        } else {
                            cVar = new ua.e.c(field, z2, i4);
                        }
                    } else if (aVar.n()) {
                        cVar = new ua.f.a(field, m(aVar), B(aVar));
                    } else {
                        cVar = new ua.f.c(field, m(aVar), c8 == true ? 1 : 0, objArr11 == true ? 1 : 0);
                    }
                } else if (Modifier.isStatic(field.getModifiers())) {
                    if (z) {
                        if (aVar.n()) {
                            cVar = new ua.e.a(field, B(aVar));
                        } else {
                            cVar = new ua.e.c(field, z2, i4);
                        }
                    } else if (aVar.n()) {
                        cVar = new ua.f.a(field, m(aVar), B(aVar));
                    } else {
                        cVar = new ua.f.c(field, m(aVar), c8 == true ? 1 : 0, objArr11 == true ? 1 : 0);
                    }
                } else if (aVar.p().l().getAnnotations().f(lc1.a)) {
                    if (z) {
                        if (aVar.n()) {
                            cVar = new ua.e.b(field, false);
                        } else {
                            cVar = new ua.e.c(field, c7 == true ? 1 : 0, c6 == true ? 1 : 0);
                        }
                    } else if (aVar.n()) {
                        cVar = new ua.f.b(field, m(aVar), false);
                    } else {
                        cVar = new ua.f.c(field, m(aVar), c5 == true ? 1 : 0, c4 == true ? 1 : 0);
                    }
                } else if (z) {
                    cVar = new ua.e.c(field, objArr10 == true ? 1 : 0, i2);
                } else {
                    cVar = new ua.f.c(field, m(aVar), objArr9 == true ? 1 : 0, i2);
                }
                ua_g_a = cVar;
            }
        } else if (uhVarB instanceof v80$a) {
            field = ((v80$a) uhVarB).a;
            nq0 nq0VarQ2 = aVar.p().l();
            okVarB = nq0VarQ2.b();
            if (!xm.l(okVarB)) {
                okVarB2 = okVarB.b();
                if (xm.n(okVarB2, 2)) {
                    if (Modifier.isStatic(field.getModifiers())) {
                        if (aVar.p().l().getAnnotations().f(lc1.a)) {
                            if (z) {
                                if (aVar.n()) {
                                    cVar = new ua.e.b(field, false);
                                } else {
                                    cVar = new ua.e.c(field, c7 == true ? 1 : 0, c6 == true ? 1 : 0);
                                }
                            } else if (aVar.n()) {
                                cVar = new ua.f.b(field, m(aVar), false);
                            } else {
                                cVar = new ua.f.c(field, m(aVar), c5 == true ? 1 : 0, c4 == true ? 1 : 0);
                            }
                        } else if (z) {
                            cVar = new ua.e.c(field, objArr10 == true ? 1 : 0, i2);
                        } else {
                            cVar = new ua.f.c(field, m(aVar), objArr9 == true ? 1 : 0, i2);
                        }
                    }
                } else if (Modifier.isStatic(field.getModifiers())) {
                    if (aVar.p().l().getAnnotations().f(lc1.a)) {
                        if (z) {
                            if (aVar.n()) {
                                cVar = new ua.e.b(field, false);
                            } else {
                                cVar = new ua.e.c(field, c7 == true ? 1 : 0, c6 == true ? 1 : 0);
                            }
                        } else if (aVar.n()) {
                            cVar = new ua.f.b(field, m(aVar), false);
                        } else {
                            cVar = new ua.f.c(field, m(aVar), c5 == true ? 1 : 0, c4 == true ? 1 : 0);
                        }
                    } else if (z) {
                        cVar = new ua.e.c(field, objArr10 == true ? 1 : 0, i2);
                    } else {
                        cVar = new ua.f.c(field, m(aVar), objArr9 == true ? 1 : 0, i2);
                    }
                }
                if (z) {
                    if (aVar.n()) {
                        cVar = new ua.e.a(field, B(aVar));
                    } else {
                        cVar = new ua.e.c(field, z2, i4);
                    }
                } else if (aVar.n()) {
                    cVar = new ua.f.a(field, m(aVar), B(aVar));
                } else {
                    cVar = new ua.f.c(field, m(aVar), c8 == true ? 1 : 0, objArr11 == true ? 1 : 0);
                }
            } else if (Modifier.isStatic(field.getModifiers())) {
                if (z) {
                    if (aVar.n()) {
                        cVar = new ua.e.a(field, B(aVar));
                    } else {
                        cVar = new ua.e.c(field, z2, i4);
                    }
                } else if (aVar.n()) {
                    cVar = new ua.f.a(field, m(aVar), B(aVar));
                } else {
                    cVar = new ua.f.c(field, m(aVar), c8 == true ? 1 : 0, objArr11 == true ? 1 : 0);
                }
            } else if (aVar.p().l().getAnnotations().f(lc1.a)) {
                if (z) {
                    if (aVar.n()) {
                        cVar = new ua.e.b(field, false);
                    } else {
                        cVar = new ua.e.c(field, c7 == true ? 1 : 0, c6 == true ? 1 : 0);
                    }
                } else if (aVar.n()) {
                    cVar = new ua.f.b(field, m(aVar), false);
                } else {
                    cVar = new ua.f.c(field, m(aVar), c5 == true ? 1 : 0, c4 == true ? 1 : 0);
                }
            } else if (z) {
                cVar = new ua.e.c(field, objArr10 == true ? 1 : 0, i2);
            } else {
                cVar = new ua.f.c(field, m(aVar), objArr9 == true ? 1 : 0, i2);
            }
            ua_g_a = cVar;
        } else {
            if (!(uhVarB instanceof v80$b)) {
                if (!(uhVarB instanceof v80$d)) {
                    d.AnonymousClass0.m();
                    return null;
                }
                v80$d v80_d = (v80$d) uhVarB;
                if (z) {
                    o80_e = v80_d.a;
                } else {
                    o80_e = v80_d.b;
                    if (o80_e == null) {
                        throw new yi(e4.j("No setter found for property ", aVar.p()));
                    }
                }
                p90 p90Var2 = aVar.p().g;
                p80$b p80_b = o80_e.a;
                Method methodI2 = p90Var2.i(p80_b.a, p80_b.b);
                if (methodI2 == null) {
                    throw new yi(e4.j("No accessor found for property ", aVar.p()));
                }
                Modifier.isStatic(methodI2.getModifiers());
                return aVar.n() ? new ua$g$a(methodI2, B(aVar)) : new ua$g$d(methodI2, objArr2 == true ? 1 : 0, i3, objArr == true ? 1 : 0);
            }
            v80$b v80_b = (v80$b) uhVarB;
            Method method = v80_b.a;
            if (!z) {
                Method method2 = v80_b.b;
                if (method2 == null) {
                    throw new yi(e4.j("No source found for setter of Java method property: ", method));
                }
                method = method2;
            }
            ua_g_a = aVar.n() ? new ua$g$a(method, B(aVar)) : new ua$g$d(method, objArr4 == true ? 1 : 0, i3, objArr3 == true ? 1 : 0);
        }
        return n(ua_g_a, aVar.o());
    }

    public static final y80 b0(fc0 fc0Var) {
        return (y80) c0(fc0Var, u91.k);
    }

    public static final n11 b1(ArrayList arrayList) {
        n11 n11Var = new n11();
        for (Object obj : arrayList) {
            vg0 vg0Var = (vg0) obj;
            if (vg0Var != null && vg0Var != vg0.b.b) {
                n11Var.add(obj);
            }
        }
        return n11Var;
    }

    public static String c(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static final ArrayList c(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new y6(objArr, true));
    }

    public static final void c(int i2) {
        if (2 > i2 || i2 >= 37) {
            StringBuilder sbN = ak.n(i2, "radix ", " was not in valid range ");
            sbN.append(new y20(2, 36, 1));
            throw new IllegalArgumentException(sbN.toString());
        }
    }

    public static final Object c0(fc0 fc0Var, u91 u91Var) {
        Object objT;
        u80 u80Var;
        fc0 fc0Var2;
        u91 u91Var2;
        Object objC0;
        int iOrdinal;
        y80.b bVar;
        List list;
        y80.c cVar;
        if (R(fc0Var)) {
            wi0 wi0Var = s41.a;
            R(fc0Var);
            ub0 ub0VarK = fc0Var.L0().k();
            s4 annotations = fc0Var.getAnnotations();
            fc0 fc0VarG = G(fc0Var);
            List listJ = J(fc0Var);
            ArrayList arrayList = new ArrayList(ae.y0(listJ));
            Iterator it = listJ.iterator();
            while (it.hasNext()) {
                arrayList.add(((ca1) it.next()).getType());
            }
            s4$a$a s4_a_a = e4.f47a;
            a91 a91VarH = s41.a.h();
            L(fc0Var);
            return c0(u(ub0VarK, annotations, fc0VarG, he.Y0(arrayList, e4.f(s4_a_a, a91VarH, Collections.singletonList(new da1(((ca1) he.T0(fc0Var.K0())).getType())), false)), fc0Var.L0().k().p(), false).P0(fc0Var.M0()), u91Var);
        }
        a91 a91VarF0 = f37g.f0(fc0Var);
        if (e4.G(a91VarF0)) {
            od odVarB = a91VarF0.b();
            if (odVarB == null) {
                d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return null;
            }
            wp0 wp0VarU = ub0.u((ai0) odVarB);
            if (wp0VarU != null) {
                switch (wp0VarU.ordinal()) {
                    case 0:
                        cVar = y80.a;
                        break;
                    case 1:
                        cVar = y80.b;
                        break;
                    case 2:
                        cVar = y80.c;
                        break;
                    case 3:
                        cVar = y80.d;
                        break;
                    case 4:
                        cVar = y80.e;
                        break;
                    case 5:
                        cVar = y80.f;
                        break;
                    case 6:
                        cVar = y80.g;
                        break;
                    case 7:
                        cVar = y80.h;
                        break;
                    default:
                        d.AnonymousClass0.m();
                        return null;
                }
                if (e4.Q(fc0Var) || e4.A(fc0Var, r70.o)) {
                    objT = cVar;
                    u80 u80Var2 = cVar.i;
                    objT = cVar;
                    if (u80Var2 != null) {
                        String strReplace = u80Var2.f().b().replace('.', '/');
                        if (strReplace == null) {
                            m80.a(5);
                            throw null;
                        }
                        bVar = new y80.b(strReplace);
                        objT = bVar;
                    }
                }
            } else {
                od odVarB2 = a91VarF0.b();
                if (odVarB2 == null) {
                    d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return null;
                }
                wp0 wp0VarS = ub0.s((ai0) odVarB2);
                if (wp0VarS != null) {
                    u80 u80Var3 = (u80) u80.u.get(wp0VarS);
                    if (u80Var3 == null) {
                        u80.a(4);
                        throw null;
                    }
                    objT = t(e4.j("[", u80Var3.d));
                } else {
                    od odVarB3 = a91VarF0.b();
                    if (odVarB3 != null && ub0.K(odVarB3)) {
                        od odVarB4 = a91VarF0.b();
                        if (odVarB4 == null) {
                            d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                            return null;
                        }
                        int i2 = ym.$r8$clinit;
                        dd ddVarG = l60.g(xm.g((ai0) odVarB4));
                        if (ddVarG != null) {
                            if (!u91Var.g && ((list = l60.l) == null || !list.isEmpty())) {
                                Iterator it2 = list.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        if (((l60.a) it2.next()).a.equals(ddVarG)) {
                                        }
                                    }
                                }
                            }
                            bVar = new y80.b(m80.b(ddVarG).d());
                            objT = bVar;
                        }
                    }
                    objT = null;
                }
            }
        } else {
            objT = null;
        }
        if (objT != null) {
            if (!u91Var.a || !(objT instanceof y80.c) || (u80Var = ((y80.c) objT).i) == null) {
                return objT;
            }
            String strReplace2 = u80Var.f().b().replace('.', '/');
            if (strReplace2 != null) {
                return new y80.b(strReplace2);
            }
            m80.a(5);
            throw null;
        }
        a91 a91VarL0 = fc0Var.L0();
        if (a91VarL0 instanceof j30) {
            j30 j30Var = (j30) a91VarL0;
            fc0 fc0Var3 = j30Var.a;
            if (fc0Var3 != null) {
                return c0(Y(fc0Var3), u91Var);
            }
            throw new AssertionError(e4.j("There should be no intersection type in existing descriptors, but found: ", he.R0(j30Var.b, null, null, null, null, 63)));
        }
        od odVarB5 = a91VarL0.b();
        if (odVarB5 == null) {
            throw new UnsupportedOperationException(e4.j("no descriptor for type constructor of ", fc0Var));
        }
        if (pr.h(odVarB5)) {
            return new y80.b("error/NonExistentClass");
        }
        boolean z = odVarB5 instanceof ai0;
        boolean z2 = u91Var.c;
        if (z && ub0.z(fc0Var)) {
            if (fc0Var.K0().size() != 1) {
                d.AnonymousClass0.m$3("arrays must have one type argument");
                return null;
            }
            ca1 ca1Var = (ca1) fc0Var.K0().get(0);
            fc0 type = ca1Var.getType();
            if (ca1Var.c() == ad1.IN_VARIANCE) {
                objC0 = new y80.b("java/lang/Object");
            } else {
                ad1 ad1VarC = ca1Var.c();
                if (z2 || ((iOrdinal = ad1VarC.ordinal()) == 0 ? (u91Var2 = u91Var.i) == null : !(iOrdinal == 1 ? (u91Var2 = u91Var.h) != null : (u91Var2 = u91Var.f) != null))) {
                    u91Var2 = u91Var;
                }
                objC0 = c0(type, u91Var2);
            }
            return t(e4.j("[", t0((y80) objC0)));
        }
        if (!z) {
            if (odVarB5 instanceof v91) {
                return c0(G((v91) odVarB5), u91Var);
            }
            throw new UnsupportedOperationException(e4.j("Unknown type ", fc0Var));
        }
        if (j20.b(odVarB5) && !u91Var.b && (fc0Var2 = (fc0) k(fc0Var, new HashSet())) != null) {
            return c0(fc0Var2, new u91(u91Var.a, true, u91Var.c, u91Var.d, u91Var.e, u91Var.f, u91Var.g, u91Var.h, u91Var.i, 512));
        }
        if (z2) {
            ij0 ij0Var = ub0.e;
            if (ub0.c((ai0) odVarB5, m21.a.O)) {
                return new y80.b("java/lang/Class");
            }
        }
        ai0 ai0Var = (ai0) odVarB5;
        ai0Var.a();
        if (ai0Var.v() == 4) {
            ai0Var = (ai0) ai0Var.b();
        }
        return new y80.b(n(ai0Var.a()));
    }

    public static final u01 c1(fc0 fc0Var) {
        cc1 cc1VarO0 = fc0Var.O0();
        if (cc1VarO0 instanceof zt) {
            return ((zt) cc1VarO0).c;
        }
        if (cc1VarO0 instanceof u01) {
            return (u01) cc1VarO0;
        }
        d.AnonymousClass0.m();
        return null;
    }

    public static int d(int i2, int i3, int i4) {
        if (i2 < i3) {
            return i3;
        }
        return i2 > i4 ? i4 : i2;
    }

    public static int d(int i2, int i3, int[] iArr) {
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else {
                if (i7 <= i3) {
                    return i6;
                }
                i4 = i6 - 1;
            }
        }
        return ~i5;
    }

    public static int d(int i2, String str) {
        return (str.hashCode() + i2) * 31;
    }

    public static StringBuilder d(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static /* synthetic */ void d(int i2) {
        String str = i2 != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 4 ? 3 : 2];
        switch (i2) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i2 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i2 != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String str2 = String.format(str, objArr);
        if (i2 == 4) {
            throw new IllegalStateException(str2);
        }
    }

    public static ha1 d0(List list, ea1 ea1Var, ok okVar, ArrayList arrayList) {
        if (ea1Var == null) {
            d(1);
            throw null;
        }
        if (okVar == null) {
            d(2);
            throw null;
        }
        if (arrayList == null) {
            d(3);
            throw null;
        }
        ha1 ha1VarE0 = e0(list, ea1Var, okVar, arrayList, null);
        if (ha1VarE0 != null) {
            return ha1VarE0;
        }
        throw new AssertionError("Substitution failed");
    }

    public static final ArrayList d0(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new y6(objArr, true));
    }

    public static final cc1 d1(cc1 cc1Var) {
        cc1 cc1VarA = b2.a(cc1Var);
        return (cc1VarA == null && (cc1VarA = e1(cc1Var)) == null) ? cc1Var.P0(false) : cc1VarA;
    }

    public static int e(long[] jArr, int i2, long j2) {
        int i3 = i2 - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            long j3 = jArr[i5];
            if (j3 < j2) {
                i4 = i5 + 1;
            } else {
                if (j3 <= j2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    public static final void e(Throwable th, Throwable th2) {
        if (th != th2) {
            Integer num = d40$a.a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = bp0$a.a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static byte[] e(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    deflaterOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            deflater.end();
            throw th3;
        }
    }

    public static ha1 e0(List list, ea1 ea1Var, ok okVar, List list2, boolean[] zArr) {
        if (ea1Var == null) {
            d(6);
            throw null;
        }
        if (okVar == null) {
            d(7);
            throw null;
        }
        if (list2 == null) {
            d(8);
            throw null;
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        Iterator it = list.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            v91 v91Var = (v91) it.next();
            w91 w91VarN0 = w91.N0(okVar, v91Var.getAnnotations(), v91Var.x(), v91Var.j(), v91Var.getName(), i3, v91Var.O());
            map.put(v91Var.h(), new da1(w91VarN0.n()));
            map2.put(v91Var, w91VarN0);
            list2.add(w91VarN0);
            i3++;
        }
        c91 c91Var = new c91(i2, map);
        ha1 ha1VarF = ha1.f(ea1Var, c91Var);
        ha1 ha1VarF2 = ha1.f(new pb(ea1Var, 1), c91Var);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            v91 v91Var2 = (v91) it2.next();
            w91 w91Var = (w91) map2.get(v91Var2);
            for (fc0 fc0Var : v91Var2.getUpperBounds()) {
                od odVarB = fc0Var.L0().b();
                fc0 fc0VarK = (((odVarB instanceof v91) && J((v91) odVarB, null, null)) ? ha1VarF : ha1VarF2).k(fc0Var, ad1.OUT_VARIANCE);
                if (fc0VarK == null) {
                    return null;
                }
                if (fc0VarK != fc0Var && zArr != null) {
                    zArr[0] = true;
                }
                w91Var.M0();
                if (!O(fc0VarK)) {
                    w91Var.r.add(fc0VarK);
                }
            }
            w91Var.M0();
            w91Var.s = true;
        }
        return ha1VarF;
    }

    public static final List e0(ArrayList arrayList) {
        int size = arrayList.size();
        if (size != 0) {
            return size != 1 ? arrayList : Collections.singletonList(arrayList.get(0));
        }
        return uq.b;
    }

    public static final u01 e1(cc1 cc1Var) {
        j30 j30Var;
        a91 a91VarL0 = cc1Var.L0();
        j30 j30Var2 = a91VarL0 instanceof j30 ? (j30) a91VarL0 : null;
        if (j30Var2 != null) {
            LinkedHashSet<fc0> linkedHashSet = j30Var2.b;
            ArrayList arrayList = new ArrayList(ae.y0(linkedHashSet));
            boolean z = false;
            for (fc0 fc0VarD1 : linkedHashSet) {
                if (ma1.g(fc0VarD1)) {
                    fc0VarD1 = d1(fc0VarD1.O0());
                    z = true;
                }
                arrayList.add(fc0VarD1);
            }
            if (z) {
                fc0 fc0VarD2 = j30Var2.a;
                if (fc0VarD2 == null) {
                    fc0VarD2 = null;
                } else if (ma1.g(fc0VarD2)) {
                    fc0VarD2 = d1(fc0VarD2.O0());
                }
                arrayList.isEmpty();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(arrayList);
                linkedHashSet2.hashCode();
                j30Var = new j30(linkedHashSet2, fc0VarD2);
            } else {
                j30Var = null;
            }
            if (j30Var != null) {
                return j30Var.e();
            }
        }
        return null;
    }

    public static final String f(a91 a91Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(e4.j("type: ", a91Var));
        sb.append('\n');
        sb.append(e4.j("hashCode: ", Integer.valueOf(a91Var.hashCode())));
        sb.append('\n');
        sb.append(e4.j("javaClass: ", a91Var.getClass().getCanonicalName()));
        sb.append('\n');
        for (ok okVarB = a91Var.b(); okVarB != null; okVarB = okVarB.b()) {
            sb.append(e4.j("fqName: ", mm.a.E(okVarB)));
            sb.append('\n');
            sb.append(e4.j("javaClass: ", okVarB.getClass().getCanonicalName()));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static final String f(String str) {
        char cCharAt;
        if (str.length() == 0 || 'a' > (cCharAt = str.charAt(0)) || cCharAt >= '{') {
            return str;
        }
        return Character.toUpperCase(cCharAt) + str.substring(1);
    }

    public static final cn.d f0(a70 a70Var) {
        cn.d dVar = (cn.d) h50.d.get(a70Var);
        return dVar == null ? cn.g(a70Var) : dVar;
    }

    public static final u01 g(fc0 fc0Var) {
        cc1 cc1VarO0 = fc0Var.O0();
        u01 u01Var = cc1VarO0 instanceof u01 ? (u01) cc1VarO0 : null;
        if (u01Var != null) {
            return u01Var;
        }
        throw new IllegalStateException(e4.j("This is should be simple type: ", fc0Var).toString());
    }

    public static void g(dh dhVar, oe0 oe0Var, ch chVar) {
        chVar.p = -1;
        chVar.q = -1;
        int[] iArr = dhVar.V;
        int i2 = iArr[0];
        int[] iArr2 = chVar.V;
        if (i2 != 2 && iArr2[0] == 4) {
            vg vgVar = chVar.K;
            int i3 = vgVar.g;
            int iN = dhVar.n();
            vg vgVar2 = chVar.M;
            int i4 = iN - vgVar2.g;
            vgVar.i = oe0Var.l(vgVar);
            vgVar2.i = oe0Var.l(vgVar2);
            oe0Var.d(vgVar.i, i3);
            oe0Var.d(vgVar2.i, i4);
            chVar.p = 2;
            chVar.b0 = i3;
            int i5 = i4 - i3;
            chVar.X = i5;
            int i6 = chVar.e0;
            if (i5 < i6) {
                chVar.X = i6;
            }
        }
        if (iArr[1] == 2 || iArr2[1] != 4) {
            return;
        }
        vg vgVar3 = chVar.L;
        int i7 = vgVar3.g;
        int i8 = dhVar.i();
        vg vgVar4 = chVar.N;
        int i9 = i8 - vgVar4.g;
        vgVar3.i = oe0Var.l(vgVar3);
        vgVar4.i = oe0Var.l(vgVar4);
        oe0Var.d(vgVar3.i, i7);
        oe0Var.d(vgVar4.i, i9);
        if (chVar.d0 > 0 || chVar.j0 == 8) {
            vg vgVar5 = chVar.O;
            q11 q11VarL = oe0Var.l(vgVar5);
            vgVar5.i = q11VarL;
            oe0Var.d(q11VarL, chVar.d0 + i7);
        }
        chVar.q = 2;
        chVar.c0 = i7;
        int i10 = i9 - i7;
        chVar.Y = i10;
        int i11 = chVar.f0;
        if (i10 < i11) {
            chVar.Y = i11;
        }
    }

    public static final void g(StringBuilder sb, Object obj, nw nwVar) {
        CharSequence string;
        if (nwVar == null) {
            if (!(obj == null ? true : obj instanceof CharSequence)) {
                if (obj instanceof Character) {
                    sb.append(((Character) obj).charValue());
                    return;
                }
                string = obj.toString();
            }
            sb.append(string);
        }
        obj = nwVar.invoke(obj);
        string = (CharSequence) obj;
        sb.append(string);
    }

    public static final Class g0(ok okVar) {
        if (!(okVar instanceof ai0) || !j20.b(okVar)) {
            return null;
        }
        ai0 ai0Var = (ai0) okVar;
        Class clsH = lc1.h(ai0Var);
        if (clsH != null) {
            return clsH;
        }
        StringBuilder sb = new StringBuilder("Class object for the class ");
        sb.append(ai0Var.getName());
        dd ddVarF = ym.f((od) okVar);
        sb.append(" cannot be found (classId=");
        sb.append(ddVarF);
        sb.append(')');
        throw new yi(sb.toString());
    }

    public static void g1(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static String h(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:120:0x01a5 A[PHI: r18 r19 r21
      0x01a5: PHI (r18v1 vg[]) = (r18v0 vg[]), (r18v4 vg[]) binds: [B:119:0x01a3, B:108:0x0189] A[DONT_GENERATE, DONT_INLINE]
      0x01a5: PHI (r19v3 boolean) = (r19v1 boolean), (r19v7 boolean) binds: [B:119:0x01a3, B:108:0x0189] A[DONT_GENERATE, DONT_INLINE]
      0x01a5: PHI (r21v3 boolean) = (r21v1 boolean), (r21v6 boolean) binds: [B:119:0x01a3, B:108:0x0189] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:121:0x01a7 A[PHI: r18 r19 r21
      0x01a7: PHI (r18v3 vg[]) = (r18v0 vg[]), (r18v4 vg[]) binds: [B:119:0x01a3, B:108:0x0189] A[DONT_GENERATE, DONT_INLINE]
      0x01a7: PHI (r19v5 boolean) = (r19v1 boolean), (r19v7 boolean) binds: [B:119:0x01a3, B:108:0x0189] A[DONT_GENERATE, DONT_INLINE]
      0x01a7: PHI (r21v5 boolean) = (r21v1 boolean), (r21v6 boolean) binds: [B:119:0x01a3, B:108:0x0189] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:174:0x0262  */
    /* JADX WARN: Code duplicated, block: B:191:0x02a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:192:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:194:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:26:0x007e  */
    /* JADX WARN: Code duplicated, block: B:288:0x048f  */
    /* JADX WARN: Code duplicated, block: B:302:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:303:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:306:0x04d7  */
    /* JADX WARN: Code duplicated, block: B:309:0x04df  */
    /* JADX WARN: Code duplicated, block: B:312:0x04ef A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:396:0x063f  */
    /* JADX WARN: Code duplicated, block: B:399:0x064a  */
    /* JADX WARN: Code duplicated, block: B:400:0x064d  */
    /* JADX WARN: Code duplicated, block: B:403:0x0653  */
    /* JADX WARN: Code duplicated, block: B:404:0x0656  */
    /* JADX WARN: Code duplicated, block: B:406:0x065a  */
    /* JADX WARN: Code duplicated, block: B:408:0x0662  */
    /* JADX WARN: Code duplicated, block: B:411:0x066a  */
    /* JADX WARN: Code duplicated, block: B:413:0x066e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:423:0x068a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x00f5  */
    public static void h(dh dhVar, oe0 oe0Var, ArrayList arrayList, int i2) {
        int i3;
        wb[] wbVarArr;
        int i4;
        int i5;
        float f2;
        vg[] vgVarArr;
        boolean z;
        boolean z2;
        boolean z3;
        vg[] vgVarArr2;
        int i6;
        wb[] wbVarArr2;
        ch chVar;
        oe0 oe0Var2;
        int i7;
        q11 q11Var;
        vg vgVar;
        q11 q11Var2;
        int i8;
        vg vgVar2;
        int i9;
        int iD;
        vg vgVar3;
        q11 q11Var3;
        int i10;
        vg[] vgVarArr3;
        int i11;
        vg vgVar4;
        vg vgVar5;
        q11 q11Var4;
        vg vgVar6;
        q11 q11Var5;
        int size;
        float f3;
        float f4;
        float f5;
        int i12;
        q11 q11Var6;
        q11 q11Var7;
        int i13;
        vg vgVar7;
        q11 q11Var8;
        int i14;
        ch chVar2;
        int i15;
        int i16;
        ch chVar3;
        int i17;
        dh dhVar2 = dhVar;
        if (i2 == 0) {
            i3 = dhVar2.B0;
            wbVarArr = dhVar2.E0;
            i4 = 0;
        } else {
            i3 = dhVar2.C0;
            wbVarArr = dhVar2.D0;
            i4 = 2;
        }
        int i18 = i3;
        wb[] wbVarArr3 = wbVarArr;
        int i19 = 0;
        while (i19 < i18) {
            wb wbVar = wbVarArr3[i19];
            boolean z4 = wbVar.q;
            ch chVar4 = wbVar.a;
            vg[] vgVarArr4 = chVar4.S;
            int i20 = 3;
            int i21 = 8;
            if (z4) {
                i5 = i19;
                f2 = 0.0f;
            } else {
                int i22 = wbVar.l;
                int i23 = i22 * 2;
                ch chVar5 = chVar4;
                ch chVar6 = chVar5;
                boolean z5 = false;
                f2 = 0.0f;
                while (!z5) {
                    wbVar.i++;
                    chVar5.p0[i22] = null;
                    chVar5.o0[i22] = null;
                    int i24 = chVar5.j0;
                    vg[] vgVarArr5 = chVar5.S;
                    if (i24 != i21) {
                        chVar5.h(i22);
                        vgVarArr5[i23].getClass();
                        int i25 = i23 + 1;
                        vgVarArr5[i25].getClass();
                        vgVarArr5[i23].getClass();
                        vgVarArr5[i25].getClass();
                        if (wbVar.b == null) {
                            wbVar.b = chVar5;
                        }
                        wbVar.d = chVar5;
                        int i26 = chVar5.V[i22];
                        if (i26 == i20 && ((i17 = chVar5.u[i22]) == 0 || i17 == i20 || i17 == 2)) {
                            wbVar.j++;
                            float f6 = chVar5.n0[i22];
                            if (f6 > 0.0f) {
                                wbVar.k += f6;
                            }
                            i16 = i22;
                            if (chVar5.j0 != 8 && i26 == 3 && (i17 == 0 || i17 == 3)) {
                                if (f6 < 0.0f) {
                                    wbVar.n = true;
                                } else {
                                    wbVar.o = true;
                                }
                                if (wbVar.h == null) {
                                    wbVar.h = new ArrayList();
                                }
                                wbVar.h.add(chVar5);
                            }
                            if (wbVar.f == null) {
                                wbVar.f = chVar5;
                            }
                            ch chVar7 = wbVar.g;
                            if (chVar7 != null) {
                                chVar7.o0[i16] = chVar5;
                            }
                            wbVar.g = chVar5;
                        } else {
                            i19 = i19;
                            i16 = i22;
                        }
                    } else {
                        i19 = i19;
                        i16 = i22;
                    }
                    ch chVar8 = chVar6;
                    if (chVar8 != chVar5) {
                        chVar8.p0[i16] = chVar5;
                    }
                    vg vgVar8 = vgVarArr5[i23 + 1].f;
                    if (vgVar8 != null) {
                        chVar3 = vgVar8.d;
                        vg vgVar9 = chVar3.S[i23].f;
                        if (vgVar9 == null || vgVar9.d != chVar5) {
                            chVar3 = null;
                        }
                    } else {
                        chVar3 = null;
                    }
                    if (chVar3 == null) {
                        chVar3 = chVar5;
                        z5 = true;
                    }
                    chVar6 = chVar5;
                    i22 = i16;
                    i20 = 3;
                    i21 = 8;
                    chVar5 = chVar3;
                    i19 = i19;
                }
                i5 = i19;
                int i27 = i22;
                ch chVar9 = wbVar.b;
                if (chVar9 != null) {
                    chVar9.S[i23].getClass();
                }
                ch chVar10 = wbVar.d;
                if (chVar10 != null) {
                    chVar10.S[i23 + 1].getClass();
                }
                wbVar.c = chVar5;
                if (i27 == 0 && wbVar.m) {
                    wbVar.e = chVar5;
                } else {
                    wbVar.e = chVar4;
                }
                wbVar.p = wbVar.o && wbVar.n;
            }
            wbVar.q = true;
            if (arrayList == 0 || arrayList.contains(chVar4)) {
                ch chVar11 = wbVar.c;
                ch chVar12 = wbVar.b;
                ch chVar13 = wbVar.d;
                ch chVar14 = wbVar.e;
                float f7 = wbVar.k;
                boolean z6 = dhVar2.V[i2] == 2;
                if (i2 == 0) {
                    int i28 = chVar14.l0;
                    boolean z7 = i28 == 0;
                    vgVarArr = vgVarArr4;
                    z2 = i28 == 1;
                    z = z7;
                    if (i28 == 2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                } else {
                    vgVarArr = vgVarArr4;
                    int i29 = chVar14.m0;
                    z = i29 == 0;
                    z2 = i29 == 1;
                    if (i29 == 2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                ch chVar15 = chVar4;
                float f8 = f7;
                boolean z8 = false;
                while (true) {
                    vg[] vgVarArr6 = chVar15.S;
                    vgVarArr2 = dhVar2.S;
                    if (z8) {
                        break;
                    }
                    vg vgVar10 = vgVarArr6[i4];
                    int i30 = z3 ? 1 : 4;
                    int iD2 = vgVar10.d();
                    boolean z9 = z6;
                    int[] iArr = chVar15.V;
                    boolean z10 = z3;
                    boolean z11 = iArr[i2] == 3 && chVar15.u[i2] == 0;
                    vg vgVar11 = vgVar10.f;
                    if (vgVar11 != null && chVar15 != chVar4) {
                        iD2 = vgVar11.d() + iD2;
                    }
                    int i31 = iD2;
                    if (z10 && chVar15 != chVar4 && chVar15 != chVar12) {
                        i30 = 8;
                    }
                    ch chVar16 = chVar4;
                    vg vgVar12 = vgVar10.f;
                    if (vgVar12 != null) {
                        boolean z12 = z11;
                        oe0Var.f(vgVar10.i, vgVar12.i, i31, chVar15 == chVar12 ? 6 : 8);
                        if (z12 && !z10) {
                            i30 = 5;
                        }
                        oe0Var.e(vgVar10.i, vgVar10.f.i, i31, (chVar15 == chVar12 && z10 && chVar15.U[i2]) ? 5 : i30);
                    }
                    if (z9) {
                        if (chVar15.j0 == 8 || iArr[i2] != 3) {
                            i15 = 0;
                        } else {
                            i15 = 0;
                            oe0Var.f(vgVarArr6[i4 + 1].i, vgVarArr6[i4].i, 0, 5);
                        }
                        oe0Var.f(vgVarArr6[i4].i, vgVarArr2[i4].i, i15, 8);
                    }
                    vg vgVar13 = vgVarArr6[i4 + 1].f;
                    if (vgVar13 != null) {
                        chVar2 = vgVar13.d;
                        vg vgVar14 = chVar2.S[i4].f;
                        if (vgVar14 == null || vgVar14.d != chVar15) {
                            chVar2 = null;
                        }
                    } else {
                        chVar2 = null;
                    }
                    if (chVar2 != null) {
                        chVar15 = chVar2;
                    } else {
                        z8 = true;
                    }
                    chVar4 = chVar16;
                    z6 = z9;
                    z3 = z10;
                }
                boolean z13 = z6;
                boolean z14 = z3;
                int i32 = 5;
                if (chVar13 != null) {
                    int i33 = i4 + 1;
                    if (chVar11.S[i33].f != null) {
                        vg vgVar15 = chVar13.S[i33];
                        if (chVar13.V[i2] == 3 && chVar13.u[i2] == 0 && !z14) {
                            vgVar7 = vgVar15.f;
                            if (vgVar7.d == dhVar2) {
                                q11Var8 = vgVar15.i;
                                i14 = -vgVar15.d();
                            } else if (z14) {
                                vgVar7 = vgVar15.f;
                                if (vgVar7.d == dhVar2) {
                                    q11Var8 = vgVar15.i;
                                    i14 = -vgVar15.d();
                                    i32 = 4;
                                }
                            }
                            oe0Var.e(q11Var8, vgVar7.i, i14, i32);
                        } else if (z14) {
                            vgVar7 = vgVar15.f;
                            if (vgVar7.d == dhVar2) {
                                q11Var8 = vgVar15.i;
                                i14 = -vgVar15.d();
                                i32 = 4;
                                oe0Var.e(q11Var8, vgVar7.i, i14, i32);
                            }
                        }
                        oe0Var.g(vgVar15.i, chVar11.S[i33].f.i, -vgVar15.d(), 6);
                    }
                }
                if (z13) {
                    int i34 = i4 + 1;
                    q11 q11Var9 = vgVarArr2[i34].i;
                    vg vgVar16 = chVar11.S[i34];
                    oe0Var.f(q11Var9, vgVar16.i, vgVar16.d(), 8);
                }
                ArrayList arrayList2 = wbVar.h;
                if (arrayList2 != null && (size = arrayList2.size()) > 1) {
                    if (wbVar.n && !wbVar.p) {
                        f8 = wbVar.j;
                    }
                    ch chVar17 = null;
                    float f9 = f2;
                    int i35 = 0;
                    while (i35 < size) {
                        ch chVar18 = (ch) arrayList2.get(i35);
                        float f10 = chVar18.n0[i2];
                        vg[] vgVarArr7 = chVar18.S;
                        if (f10 < f2) {
                            if (wbVar.p) {
                                q11Var6 = vgVarArr7[i4 + 1].i;
                                q11Var7 = vgVarArr7[i4].i;
                                i13 = 4;
                            } else {
                                f3 = 1.0f;
                            }
                            oe0Var.e(q11Var6, q11Var7, 0, i13);
                            size = size;
                            wbVarArr3 = wbVarArr3;
                            f5 = f2;
                            i12 = i18;
                            i35++;
                            arrayList2 = arrayList2;
                            i18 = i12;
                            size = size;
                            wbVarArr3 = wbVarArr3;
                            f2 = f5;
                        } else {
                            f3 = f10;
                        }
                        if (f3 == f2) {
                            q11Var6 = vgVarArr7[i4 + 1].i;
                            q11Var7 = vgVarArr7[i4].i;
                            i13 = 8;
                            oe0Var.e(q11Var6, q11Var7, 0, i13);
                            size = size;
                            wbVarArr3 = wbVarArr3;
                            f5 = f2;
                            i12 = i18;
                        } else {
                            arrayList2 = arrayList2;
                            if (chVar17 != null) {
                                vg[] vgVarArr8 = chVar17.S;
                                q11 q11Var10 = vgVarArr8[i4].i;
                                int i36 = i4 + 1;
                                q11 q11Var11 = vgVarArr8[i36].i;
                                q11 q11Var12 = vgVarArr7[i4].i;
                                f4 = f3;
                                q11 q11Var13 = vgVarArr7[i36].i;
                                e7 e7VarM = oe0Var.m();
                                b7 b7Var = e7VarM.d;
                                float f11 = f9;
                                float f12 = f2;
                                e7VarM.b = f12;
                                f5 = f12;
                                float f13 = -1.0f;
                                if (f8 == f12 || f11 == f4) {
                                    i12 = i18;
                                    b7Var.k(q11Var10, 1.0f);
                                    b7Var.k(q11Var11, -1.0f);
                                    b7Var.k(q11Var13, 1.0f);
                                } else {
                                    if (f11 == f5) {
                                        i12 = i18;
                                        b7Var.k(q11Var10, 1.0f);
                                        b7Var.k(q11Var11, -1.0f);
                                    } else {
                                        i12 = i18;
                                        if (f3 == f2) {
                                            b7Var.k(q11Var12, 1.0f);
                                            b7Var.k(q11Var13, -1.0f);
                                        } else {
                                            float f14 = (f11 / f8) / (f4 / f8);
                                            b7Var.k(q11Var10, 1.0f);
                                            b7Var.k(q11Var11, -1.0f);
                                            b7Var.k(q11Var13, f14);
                                            f13 = -f14;
                                        }
                                    }
                                    wbVarArr3 = wbVarArr3;
                                    oe0Var.c(e7VarM);
                                }
                                b7Var.k(q11Var12, f13);
                                oe0Var.c(e7VarM);
                            } else {
                                f4 = f3;
                                wbVarArr3 = wbVarArr3;
                                f5 = f2;
                                i12 = i18;
                            }
                            chVar17 = chVar18;
                            f9 = f4;
                        }
                        i35++;
                        arrayList2 = arrayList2;
                        i18 = i12;
                        size = size;
                        wbVarArr3 = wbVarArr3;
                        f2 = f5;
                    }
                }
                i6 = i18;
                wbVarArr2 = wbVarArr3;
                if (chVar12 == null || !(chVar12 == chVar13 || z14)) {
                    chVar = chVar13;
                    if (!z || chVar12 == null) {
                        if (z2 && chVar12 != null) {
                            int i37 = wbVar.j;
                            boolean z15 = i37 > 0 && wbVar.i == i37;
                            ch chVar19 = chVar12;
                            ch chVar20 = chVar19;
                            while (chVar19 != null) {
                                ch chVar21 = chVar19.p0[i2];
                                while (chVar21 != null && chVar21.j0 == 8) {
                                    chVar21 = chVar21.p0[i2];
                                }
                                if (chVar19 != chVar12 && chVar19 != chVar && chVar21 != null) {
                                    if (chVar21 == chVar) {
                                        chVar21 = null;
                                    }
                                    vg[] vgVarArr9 = chVar19.S;
                                    vg vgVar17 = vgVarArr9[i4];
                                    q11 q11Var14 = vgVar17.i;
                                    int i38 = i4 + 1;
                                    q11 q11Var15 = chVar20.S[i38].i;
                                    int iD3 = vgVar17.d();
                                    int iD4 = vgVarArr9[i38].d();
                                    if (chVar21 != null) {
                                        vgVar = chVar21.S[i4];
                                        q11Var2 = vgVar.i;
                                        vg vgVar18 = vgVar.f;
                                        q11Var = vgVar18 != null ? vgVar18.i : null;
                                    } else {
                                        vg vgVar19 = chVar.S[i4];
                                        q11 q11Var16 = vgVar19 != null ? vgVar19.i : null;
                                        q11Var = vgVarArr9[i38].i;
                                        vgVar = vgVar19;
                                        q11Var2 = q11Var16;
                                    }
                                    if (vgVar != null) {
                                        iD4 += vgVar.d();
                                    }
                                    int iD5 = chVar20.S[i38].d() + iD3;
                                    q11 q11Var17 = q11Var2;
                                    int i39 = iD4;
                                    q11 q11Var18 = q11Var;
                                    int i40 = z15 ? 8 : 4;
                                    if (q11Var14 != null && q11Var15 != null && q11Var17 != null && q11Var18 != null) {
                                        oe0Var.b(q11Var14, q11Var15, iD5, 0.5f, q11Var17, q11Var18, i39, i40);
                                    }
                                    chVar21 = chVar21;
                                }
                                if (chVar19.j0 != 8) {
                                    chVar20 = chVar19;
                                }
                                chVar19 = chVar21;
                            }
                            vg vgVar20 = chVar12.S[i4];
                            vg vgVar21 = vgVarArr[i4].f;
                            int i41 = i4 + 1;
                            vg vgVar22 = chVar.S[i41];
                            vg vgVar23 = chVar11.S[i41].f;
                            if (vgVar21 != null) {
                                if (chVar12 != chVar) {
                                    i7 = 5;
                                    oe0Var.e(vgVar20.i, vgVar21.i, vgVar20.d(), 5);
                                } else {
                                    i7 = 5;
                                    if (vgVar23 != null) {
                                        oe0Var2 = oe0Var;
                                        oe0Var2.b(vgVar20.i, vgVar21.i, vgVar20.d(), 0.5f, vgVar22.i, vgVar23.i, vgVar22.d(), 5);
                                    }
                                }
                                oe0Var2 = oe0Var;
                            } else {
                                oe0Var2 = oe0Var;
                                i7 = 5;
                            }
                            if (vgVar23 != null && chVar12 != chVar) {
                                oe0Var2.e(vgVar22.i, vgVar23.i, -vgVar22.d(), i7);
                            }
                        }
                        if ((z || z2) && chVar12 != null && chVar12 != chVar) {
                            vgVarArr3 = chVar12.S;
                            vg vgVar24 = vgVarArr3[i4];
                            if (chVar == null) {
                                chVar = chVar12;
                            }
                            vg[] vgVarArr10 = chVar.S;
                            i11 = i4 + 1;
                            vgVar4 = vgVarArr10[i11];
                            vgVar5 = vgVar24.f;
                            if (vgVar5 != null) {
                                q11Var4 = vgVar5.i;
                            } else {
                                q11Var4 = null;
                            }
                            vgVar6 = vgVar4.f;
                            if (vgVar6 != null) {
                                q11Var5 = vgVar6.i;
                            } else {
                                q11Var5 = null;
                            }
                            if (chVar11 != chVar) {
                                vg vgVar25 = chVar11.S[i11].f;
                                q11Var5 = vgVar25 != null ? vgVar25.i : null;
                            }
                            if (chVar12 == chVar) {
                                vgVar4 = vgVarArr3[i11];
                            }
                            if (q11Var4 == null && q11Var5 != null) {
                                oe0Var2.b(vgVar24.i, q11Var4, vgVar24.d(), 0.5f, q11Var5, vgVar4.i, vgVarArr10[i11].d(), 5);
                            }
                        }
                    } else {
                        int i42 = wbVar.j;
                        boolean z16 = i42 > 0 && wbVar.i == i42;
                        ch chVar22 = chVar12;
                        ch chVar23 = chVar22;
                        while (chVar22 != null) {
                            ch chVar24 = chVar22.p0[i2];
                            while (true) {
                                if (chVar24 == null) {
                                    i8 = 8;
                                    break;
                                }
                                i8 = 8;
                                if (chVar24.j0 != 8) {
                                    break;
                                } else {
                                    chVar24 = chVar24.p0[i2];
                                }
                            }
                            if (chVar24 != null || chVar22 == chVar) {
                                vg[] vgVarArr11 = chVar22.S;
                                vg vgVar26 = vgVarArr11[i4];
                                q11 q11Var19 = vgVar26.i;
                                vg vgVar27 = vgVar26.f;
                                q11 q11Var20 = vgVar27 != null ? vgVar27.i : null;
                                if (chVar23 != chVar22) {
                                    vgVar2 = chVar23.S[i4 + 1];
                                } else {
                                    if (chVar22 == chVar12) {
                                        vgVar2 = vgVarArr[i4].f;
                                        if (vgVar2 == null) {
                                            q11Var20 = null;
                                        }
                                    }
                                    int iD6 = vgVar26.d();
                                    i9 = i4 + 1;
                                    iD = vgVarArr11[i9].d();
                                    if (chVar24 != null) {
                                        vgVar3 = chVar24.S[i4];
                                    } else {
                                        vgVar3 = chVar11.S[i9].f;
                                        if (vgVar3 != null) {
                                            q11Var3 = null;
                                        }
                                        q11 q11Var21 = vgVarArr11[i9].i;
                                        if (vgVar3 != null) {
                                            iD += vgVar3.d();
                                        }
                                        int iD7 = chVar23.S[i9].d() + iD6;
                                        if (q11Var19 != null || q11Var20 == null || q11Var3 == null || q11Var21 == null) {
                                            i10 = i8;
                                        } else {
                                            if (chVar22 == chVar12) {
                                                iD7 = chVar12.S[i4].d();
                                            }
                                            if (chVar22 == chVar) {
                                                iD = chVar.S[i9].d();
                                            }
                                            int i43 = i8;
                                            i10 = i43;
                                            oe0Var.b(q11Var19, q11Var20, iD7, 0.5f, q11Var3, q11Var21, iD, z16 ? i43 : 5);
                                        }
                                    }
                                    q11Var3 = vgVar3.i;
                                    q11 q11Var22 = vgVarArr11[i9].i;
                                    if (vgVar3 != null) {
                                        iD += vgVar3.d();
                                    }
                                    int iD8 = chVar23.S[i9].d() + iD6;
                                    if (q11Var19 != null) {
                                        i10 = i8;
                                    } else {
                                        i10 = i8;
                                    }
                                }
                                q11Var20 = vgVar2.i;
                                int iD9 = vgVar26.d();
                                i9 = i4 + 1;
                                iD = vgVarArr11[i9].d();
                                if (chVar24 != null) {
                                    vgVar3 = chVar24.S[i4];
                                } else {
                                    vgVar3 = chVar11.S[i9].f;
                                    if (vgVar3 != null) {
                                        q11Var3 = null;
                                    }
                                    q11 q11Var23 = vgVarArr11[i9].i;
                                    if (vgVar3 != null) {
                                        iD += vgVar3.d();
                                    }
                                    int iD10 = chVar23.S[i9].d() + iD9;
                                    if (q11Var19 != null) {
                                        i10 = i8;
                                    } else {
                                        i10 = i8;
                                    }
                                }
                                q11Var3 = vgVar3.i;
                                q11 q11Var24 = vgVarArr11[i9].i;
                                if (vgVar3 != null) {
                                    iD += vgVar3.d();
                                }
                                int iD11 = chVar23.S[i9].d() + iD9;
                                if (q11Var19 != null) {
                                    i10 = i8;
                                } else {
                                    i10 = i8;
                                }
                            } else {
                                i10 = i8;
                            }
                            if (chVar22.j0 != i10) {
                                chVar23 = chVar22;
                            }
                            chVar22 = chVar24;
                            chVar23 = chVar23;
                        }
                    }
                } else {
                    vg vgVar28 = vgVarArr[i4];
                    int i44 = i4 + 1;
                    vg vgVar29 = chVar11.S[i44];
                    vg vgVar30 = vgVar28.f;
                    q11 q11Var25 = vgVar30 != null ? vgVar30.i : null;
                    vg vgVar31 = vgVar29.f;
                    q11 q11Var26 = vgVar31 != null ? vgVar31.i : null;
                    vg vgVar32 = chVar12.S[i4];
                    if (chVar13 != null) {
                        vgVar29 = chVar13.S[i44];
                    }
                    if (q11Var25 == null || q11Var26 == null) {
                        chVar = chVar13;
                    } else {
                        float f15 = i2 == 0 ? chVar14.g0 : chVar14.h0;
                        int iD12 = vgVar32.d();
                        int iD13 = vgVar29.d();
                        q11 q11Var27 = vgVar32.i;
                        q11 q11Var28 = vgVar29.i;
                        q11 q11Var29 = q11Var25;
                        chVar = chVar13;
                        oe0Var.b(q11Var27, q11Var29, iD12, f15, q11Var26, q11Var28, iD13, 7);
                    }
                }
                oe0Var2 = oe0Var;
                if (z) {
                    vgVarArr3 = chVar12.S;
                    vg vgVar210 = vgVarArr3[i4];
                    if (chVar == null) {
                        chVar = chVar12;
                    }
                    vg[] vgVarArr12 = chVar.S;
                    i11 = i4 + 1;
                    vgVar4 = vgVarArr12[i11];
                    vgVar5 = vgVar210.f;
                    if (vgVar5 != null) {
                        q11Var4 = vgVar5.i;
                    } else {
                        q11Var4 = null;
                    }
                    vgVar6 = vgVar4.f;
                    if (vgVar6 != null) {
                        q11Var5 = vgVar6.i;
                    } else {
                        q11Var5 = null;
                    }
                    if (chVar11 != chVar) {
                        vg vgVar211 = chVar11.S[i11].f;
                        q11Var5 = vgVar211 != null ? vgVar211.i : null;
                    }
                    if (chVar12 == chVar) {
                        vgVar4 = vgVarArr3[i11];
                    }
                    if (q11Var4 == null) {
                    }
                } else {
                    vgVarArr3 = chVar12.S;
                    vg vgVar212 = vgVarArr3[i4];
                    if (chVar == null) {
                        chVar = chVar12;
                    }
                    vg[] vgVarArr13 = chVar.S;
                    i11 = i4 + 1;
                    vgVar4 = vgVarArr13[i11];
                    vgVar5 = vgVar212.f;
                    if (vgVar5 != null) {
                        q11Var4 = vgVar5.i;
                    } else {
                        q11Var4 = null;
                    }
                    vgVar6 = vgVar4.f;
                    if (vgVar6 != null) {
                        q11Var5 = vgVar6.i;
                    } else {
                        q11Var5 = null;
                    }
                    if (chVar11 != chVar) {
                        vg vgVar213 = chVar11.S[i11].f;
                        q11Var5 = vgVar213 != null ? vgVar213.i : null;
                    }
                    if (chVar12 == chVar) {
                        vgVar4 = vgVarArr3[i11];
                    }
                    if (q11Var4 == null) {
                    }
                }
            } else {
                i6 = i18;
                wbVarArr2 = wbVarArr3;
            }
            i19 = i5 + 1;
            dhVar2 = dhVar;
            i18 = i6;
            wbVarArr3 = wbVarArr2;
        }
    }

    public static final boolean h(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static final boolean h(ld ldVar, z81 z81Var, w01 w01Var, w01 w01Var2, boolean z) {
        Set<jc0> setP = ldVar.p(w01Var);
        if (setP != null && setP.isEmpty()) {
            return false;
        }
        for (jc0 jc0Var : setP) {
            if (e4.a((Object) ldVar.f0(jc0Var), (Object) ldVar.c(w01Var2))) {
                return true;
            }
            if (z && Q(z81Var, w01Var2, jc0Var)) {
                return true;
            }
        }
        return false;
    }

    public static final String h1(ij0 ij0Var) {
        boolean z = false;
        if (!ij0Var.c) {
            String strB = ij0Var.b();
            if (!pb0.a.contains(strB)) {
                int i2 = 0;
                while (i2 < strB.length()) {
                    char cCharAt = strB.charAt(i2);
                    i2++;
                    if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_') {
                        z = true;
                        break;
                    }
                }
            } else {
                z = true;
                break;
            }
        }
        String strB2 = ij0Var.b();
        return z ? e4.j("`".concat(strB2), "`") : strB2;
    }

    public static final int i(int i2, int i3, int i4) {
        if (i4 > 0) {
            if (i2 < i3) {
                int i5 = i3 % i4;
                if (i5 < 0) {
                    i5 += i4;
                }
                int i6 = i2 % i4;
                if (i6 < 0) {
                    i6 += i4;
                }
                int i7 = (i5 - i6) % i4;
                if (i7 < 0) {
                    i7 += i4;
                }
                return i3 - i7;
            }
        } else {
            if (i4 >= 0) {
                d.AnonymousClass0.m$2("Step is zero.");
                return 0;
            }
            if (i2 > i3) {
                int i8 = -i4;
                int i9 = i2 % i8;
                if (i9 < 0) {
                    i9 += i8;
                }
                int i10 = i3 % i8;
                if (i10 < 0) {
                    i10 += i8;
                }
                int i11 = (i9 - i10) % i8;
                if (i11 < 0) {
                    i11 += i8;
                }
                return i3 + i11;
            }
        }
        return i3;
    }

    public static String i(int i2, String str, String str2) {
        return str + i2 + str2;
    }

    public static List i(z81 z81Var, w01 w01Var, b91 b91Var) {
        v3 v3VarU;
        z81.b bVar = z81.b.a$1;
        ld ldVar = z81Var.c;
        ldVar.getClass();
        if (ldVar.m(b91Var) || !ldVar.U(w01Var)) {
            if (!ldVar.I(b91Var)) {
                n11 n11Var = new n11();
                z81Var.b();
                ArrayDeque arrayDeque = z81Var.g;
                o11 o11Var = z81Var.h;
                arrayDeque.push(w01Var);
                while (!arrayDeque.isEmpty()) {
                    if (o11Var.c > 1000) {
                        StringBuilder sbM = m("Too many supertypes for type: ", w01Var, ". Supertypes = ");
                        sbM.append(he.R0(o11Var, null, null, null, null, 63));
                        throw new IllegalStateException(sbM.toString().toString());
                    }
                    w01 w01Var2 = (w01) arrayDeque.pop();
                    if (o11Var.add(w01Var2)) {
                        w01 w01VarX = ldVar.x(w01Var2);
                        if (w01VarX == null) {
                            w01VarX = w01Var2;
                        }
                        boolean zD0 = ldVar.d0(ldVar.c(w01VarX), b91Var);
                        ld ldVar2 = z81Var.c;
                        if (zD0) {
                            n11Var.add(w01VarX);
                            v3VarU = bVar;
                        } else {
                            v3VarU = ldVar.O(w01VarX) == 0 ? z81.b.a : ldVar2.u(w01VarX);
                        }
                        if (v3VarU.equals(bVar)) {
                            v3VarU = null;
                        }
                        if (v3VarU != null) {
                            Iterator it = ldVar2.W(ldVar2.c(w01Var2)).iterator();
                            while (it.hasNext()) {
                                arrayDeque.add(v3VarU.a(z81Var, (jc0) it.next()));
                            }
                        }
                    }
                }
                z81Var.a();
                return n11Var;
            }
            if (ldVar.d0(ldVar.c(w01Var), b91Var)) {
                u01 u01VarX = ldVar.x(w01Var);
                if (u01VarX != null) {
                    w01Var = u01VarX;
                }
                return Collections.singletonList(w01Var);
            }
        }
        return uq.b;
    }

    public static boolean i(xt.a aVar, int i2) {
        return aVar.c(i2).booleanValue();
    }

    public static final boolean i0(fc0 fc0Var) {
        od odVarB = fc0Var.L0().b();
        if (odVarB != null && j20.b(odVarB) && !ym.g((ai0) odVarB).equals(m21.e)) {
            return true;
        }
        od odVarB2 = fc0Var.L0().b();
        v91 v91Var = odVarB2 instanceof v91 ? (v91) odVarB2 : null;
        return v91Var == null ? false : i0(G(v91Var));
    }

    public static final String i1(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ij0 ij0Var = (ij0) it.next();
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(h1(ij0Var));
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object j(Object obj, la laVar) {
        if (!(laVar instanceof nq0) || !j20.d((yc1) laVar)) {
            fc0 fc0VarY = y(laVar);
            Class clsG0 = fc0VarY == null ? null : g0(fc0VarY.L0().b());
            if (clsG0 != null) {
                return H(clsG0, laVar).invoke(obj, null);
            }
        }
        return obj;
    }

    public static String j(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static List j(z81 z81Var, w01 w01Var, a91 a91Var) {
        List listI = i(z81Var, w01Var, a91Var);
        if (listI.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listI) {
                ld ldVar = z81Var.c;
                w81 w81VarR = ldVar.R((w01) obj);
                int i2 = ldVar.i(w81VarR);
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        arrayList.add(obj);
                        break;
                    }
                    int i4 = i3 + 1;
                    if (ldVar.e0(ldVar.k(ldVar.k0(w81VarR, i3))) != null) {
                        break;
                    }
                    i3 = i4;
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return listI;
    }

    public static boolean j(String str) {
        try {
            return new Date().after(new SimpleDateFormat(uh.a(-140519176043806L)).parse(str));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static final ai0 j0(gi0 gi0Var, cv cvVar) {
        dl0 dl0Var = dl0.b;
        boolean zD = cvVar.d();
        dv dvVar = cvVar.a;
        if (!zD) {
            od odVarE = gi0Var.U(cvVar.e()).j.e(dvVar.g(), dl0Var);
            ai0 ai0Var = odVarE instanceof ai0 ? (ai0) odVarE : null;
            if (ai0Var != null) {
                return ai0Var;
            }
            ai0 ai0VarJ0 = j0(gi0Var, cvVar.e());
            od odVarE2 = ai0VarJ0 == null ? null : ai0VarJ0.V().e(dvVar.g(), dl0Var);
            if (odVarE2 instanceof ai0) {
                return (ai0) odVarE2;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0084  */
    public static final fc0 j1(ArrayList arrayList, fc0 fc0Var) {
        da1 da1Var;
        fc0Var.K0().size();
        arrayList.size();
        ArrayList arrayList2 = new ArrayList(ae.y0(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            v81 v81Var = (v81) it.next();
            v81Var.getClass();
            fc0 fc0Var2 = v81Var.b;
            fc0 fc0Var3 = v81Var.c;
            gc0.a.e(fc0Var2, fc0Var3);
            if (fc0Var2.equals(fc0Var3)) {
                da1Var = new da1(fc0Var2);
            } else {
                v91 v91Var = v81Var.a;
                ad1 ad1VarJ = v91Var.j();
                ad1 ad1Var = ad1.IN_VARIANCE;
                if (ad1VarJ == ad1Var) {
                    da1Var = new da1(fc0Var2);
                } else {
                    boolean zF = ub0.F(fc0Var2);
                    ad1 ad1Var2 = ad1.OUT_VARIANCE;
                    ad1 ad1Var3 = ad1.INVARIANT;
                    if (zF && v91Var.j() != ad1Var) {
                        if (ad1Var2 == v91Var.j()) {
                            ad1Var2 = ad1Var3;
                        }
                        da1Var = new da1(fc0Var3, ad1Var2);
                    } else if (ub0.y(fc0Var3) && fc0Var3.M0()) {
                        if (ad1Var == v91Var.j()) {
                            ad1Var = ad1Var3;
                        }
                        da1Var = new da1(fc0Var2, ad1Var);
                    } else {
                        if (ad1Var2 == v91Var.j()) {
                            ad1Var2 = ad1Var3;
                        }
                        da1Var = new da1(fc0Var3, ad1Var2);
                    }
                }
            }
            arrayList2.add(da1Var);
        }
        return V(fc0Var, arrayList2, null, 6);
    }

    /* JADX WARN: Code duplicated, block: B:66:0x00bc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bd  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final jc0 k(fc0 fc0Var, HashSet hashSet) {
        StringBuilder sb;
        Object obj;
        jc0 jc0VarK;
        i20 i20VarT;
        u01 u01VarH;
        a91 a91VarF0 = f37g.f0(fc0Var);
        if (hashSet.add(a91VarF0)) {
            if (a91VarF0 != null) {
                od odVarB = a91VarF0.b();
                v91 v91Var = odVarB instanceof v91 ? (v91) odVarB : null;
                if (v91Var != null) {
                    jc0VarK = k(G(v91Var), hashSet);
                    if (jc0VarK != null) {
                        if (e4.Q(jc0VarK) || !(fc0Var instanceof w01) || !e4.N((w01) fc0Var)) {
                            return jc0VarK;
                        }
                        u01VarH = e4.h(jc0VarK);
                        if (u01VarH == null) {
                            return jc0VarK;
                        }
                        return e4.n0(u01VarH, true);
                    }
                } else {
                    od odVarB2 = a91VarF0.b();
                    ai0 ai0Var = odVarB2 instanceof ai0 ? (ai0) odVarB2 : null;
                    if (ai0Var == null || !j20.b(ai0Var)) {
                        return fc0Var;
                    }
                    od odVarB3 = fc0Var.L0().b();
                    if (!(odVarB3 instanceof ai0)) {
                        odVarB3 = null;
                    }
                    ai0 ai0Var2 = (ai0) odVarB3;
                    u01 u01Var = (ai0Var2 == null || (i20VarT = ai0Var2.t()) == null) ? null : i20VarT.b;
                    fc0 fc0VarK = u01Var == null ? null : ha1.d(fc0Var).k(u01Var, ad1.INVARIANT);
                    if (fc0VarK != null && (jc0VarK = k(fc0VarK, hashSet)) != null) {
                        if (!e4.Q(fc0Var)) {
                            return jc0VarK;
                        }
                        if (e4.Q(jc0VarK)) {
                            return fc0Var;
                        }
                        if (jc0VarK instanceof w01) {
                            w01 w01Var = (w01) jc0VarK;
                            if (!(w01Var instanceof fc0)) {
                                StringBuilder sbM = m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ");
                                obj = w01Var;
                                sb = sbM;
                            } else if (ub0.G((fc0) w01Var)) {
                                return fc0Var;
                            }
                        }
                        u01VarH = e4.h(jc0VarK);
                        if (u01VarH == null) {
                            return jc0VarK;
                        }
                        return e4.n0(u01VarH, true);
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb2.append(a91VarF0);
                sb2.append(", ");
                obj = a91VarF0;
                sb = sb2;
            }
            d.AnonymousClass0.m((Object) fb$1.m(ou0.a, obj.getClass(), sb));
            return null;
        }
        return null;
    }

    public static final void k(ao0 ao0Var, cv cvVar, ArrayList arrayList) {
        if (ao0Var != null) {
            ao0Var.c(cvVar, arrayList);
        } else {
            arrayList.addAll(ao0Var.b(cvVar));
        }
    }

    public static final nr0 k0(fr0 fr0Var, fi0 fi0Var) {
        int i2 = fr0Var.d;
        if ((i2 & 8) == 8) {
            return fr0Var.j;
        }
        if ((i2 & 16) == 16) {
            return fi0Var.a(fr0Var.n);
        }
        d.AnonymousClass0.m("No returnType in ProtoBuf.Function");
        return null;
    }

    public static final void k1(int i2, int i3, Object[] objArr) {
        while (i2 < i3) {
            objArr[i2] = null;
            i2++;
        }
    }

    public static final int l(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object, rc0] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object, rc0] */
    public static ed l(Class cls) {
        int i2 = 0;
        while (cls.isArray()) {
            i2++;
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            if (cls.equals(Void.TYPE)) {
                return new ed(dd.l(m21.a.d.h()), i2);
            }
            wp0 wp0VarD = u80.b(cls.getName()).d();
            return i2 > 0 ? new ed(dd.l((cv) wp0VarD.f.getValue()), i2 - 1) : new ed(dd.l((cv) wp0VarD.d.getValue()), i2);
        }
        dd ddVarA = bt0.a(cls);
        String str = l60.a;
        dd ddVar = (dd) l60.h.get(ddVarA.b().i());
        if (ddVar != null) {
            ddVarA = ddVar;
        }
        return new ed(ddVarA, i2);
    }

    public static final boolean l(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    public static String[] l(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        d.AnonymousClass0.m$1("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return null;
    }

    public static final nr0 l0(kr0 kr0Var, fi0 fi0Var) {
        int i2 = kr0Var.d;
        if ((i2 & 8) == 8) {
            return kr0Var.j;
        }
        if ((i2 & 16) == 16) {
            return fi0Var.a(kr0Var.n);
        }
        d.AnonymousClass0.m("No returnType in ProtoBuf.Property");
        return null;
    }

    public static LinkedHashSet l1(ij0 ij0Var, Collection collection, Collection collection2, ai0 ai0Var, mr mrVar, pn0 pn0Var, boolean z) {
        if (ij0Var == null) {
            o0(12);
            throw null;
        }
        if (collection == null) {
            o0(13);
            throw null;
        }
        if (ai0Var == null) {
            o0(15);
            throw null;
        }
        if (mrVar == null) {
            o0(16);
            throw null;
        }
        if (pn0Var == null) {
            o0(17);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        pn0Var.h(ij0Var, collection, collection2, ai0Var, new wm(mrVar, linkedHashSet, z));
        return linkedHashSet;
    }

    public static long m(long j2) {
        short s = (short) (j2 & 65535);
        short s2 = (short) ((j2 >>> 16) & 65535);
        short s3 = (short) (s + s2);
        short s4 = (short) (s2 ^ s);
        return ((((long) ((short) ((s4 >>> 22) | (s4 << 10)))) | (((long) ((short) (((short) ((s3 >>> 23) | (s3 << 9))) + s))) << 16)) << 16) | ((long) ((short) (((short) (((short) ((s << 13) | (s >>> 19))) ^ s4)) ^ (s4 << 5))));
    }

    public static StringBuilder m(String str, w01 w01Var, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(w01Var);
        sb.append(str2);
        return sb;
    }

    public static final boolean m(fc0 fc0Var, a91 a91Var, Set set) {
        ca1 ca1Var;
        v91 v91Var;
        if (e4.a((Object) fc0Var.L0(), (Object) a91Var)) {
            return true;
        }
        od odVarB = fc0Var.L0().b();
        pd pdVar = odVarB instanceof pd ? (pd) odVarB : null;
        List listO = pdVar == null ? null : pdVar.o();
        Iterable iterableJ1 = he.j1(fc0Var.K0());
        if (!(iterableJ1 instanceof Collection) || !((Collection) iterableJ1).isEmpty()) {
            Iterator it = iterableJ1.iterator();
            do {
                c20 c20Var = (c20) it;
                if (c20Var.b.hasNext()) {
                    a20 a20Var = (a20) c20Var.next();
                    int i2 = a20Var.a;
                    ca1Var = (ca1) a20Var.b;
                    v91Var = listO == null ? null : (v91) he.N0(listO, i2);
                }
            } while (!(((v91Var == null || set == null || !set.contains(v91Var)) && !ca1Var.b()) ? m(ca1Var.getType(), a91Var, set) : false));
            return true;
        }
        return false;
    }

    public static final boolean m(ra0.a aVar) {
        return !ma1.g(aVar.p().l().getType());
    }

    public static LinkedHashSet m1(ij0 ij0Var, AbstractCollection abstractCollection, Collection collection, ai0 ai0Var, mr mrVar, pn0 pn0Var) {
        if (ij0Var == null) {
            o0(0);
            throw null;
        }
        if (ai0Var == null) {
            o0(3);
            throw null;
        }
        if (mrVar == null) {
            o0(4);
            throw null;
        }
        if (pn0Var != null) {
            return l1(ij0Var, abstractCollection, collection, ai0Var, mrVar, pn0Var, false);
        }
        o0(5);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0011  */
    public static final String n(ai0 ai0Var) {
        StringBuilder sb;
        ok okVarB = ai0Var.b();
        ij0 name = ai0Var.getName();
        if (name != null) {
            ij0 ij0Var = f21.a;
            if (name.c) {
                name = f21.c;
            }
        } else {
            name = f21.c;
        }
        String strC = name.c();
        if (okVarB instanceof wn0) {
            cv cvVar = ((xn0) ((wn0) okVarB)).g;
            if (cvVar.d()) {
                return strC;
            }
            sb = new StringBuilder();
            sb.append(cvVar.b().replace('.', '/'));
            sb.append('/');
        } else {
            ai0 ai0Var2 = okVarB instanceof ai0 ? (ai0) okVarB : null;
            if (ai0Var2 == null) {
                d.AnonymousClass0.m$1("Unexpected container: ", okVarB, " for ", ai0Var);
                return null;
            }
            String strN = n(ai0Var2);
            sb = new StringBuilder();
            sb.append(strN);
            sb.append('$');
        }
        sb.append(strC);
        return sb.toString();
    }

    public static String n(String str, String str2, String str3) {
        return ak.AnonymousClass0.m(str, str2, str3);
    }

    public static final s4 n(s4 s4Var, s4 s4Var2) {
        if (s4Var.isEmpty()) {
            return s4Var2;
        }
        return s4Var2.isEmpty() ? s4Var : new t4(new s4[]{s4Var, s4Var2});
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0050  */
    /* JADX WARN: Code duplicated, block: B:24:0x005a  */
    /* JADX WARN: Code duplicated, block: B:25:0x005c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    /* JADX WARN: Code duplicated, block: B:30:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x0079  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
    
        if ((r0 != null ? defpackage.j20.b(r0) : false) == true) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final defpackage.ta n(defpackage.ta r3, defpackage.ox r4) {
        /*
            int r0 = defpackage.j20.$r8$clinit
            boolean r0 = r4 instanceof defpackage.pq0
            if (r0 == 0) goto L15
            r0 = r4
            pq0 r0 = (defpackage.pq0) r0
            nq0 r0 = r0.X()
            boolean r0 = defpackage.j20.d(r0)
            if (r0 == 0) goto L15
            goto L7f
        L15:
            java.util.List r0 = r4.f()
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 == 0) goto L21
            goto L48
        L21:
            java.util.Iterator r0 = r0.iterator()
        L25:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L48
            java.lang.Object r1 = r0.next()
            wc1 r1 = (defpackage.wc1) r1
            fc0 r1 = r1.getType()
            a91 r1 = r1.L0()
            od r1 = r1.b()
            if (r1 != 0) goto L41
            r1 = r2
            goto L45
        L41:
            boolean r1 = defpackage.j20.b(r1)
        L45:
            if (r1 == 0) goto L25
            goto L7f
        L48:
            fc0 r0 = r4.getReturnType()
            r1 = 1
            if (r0 != 0) goto L50
            goto L63
        L50:
            a91 r0 = r0.L0()
            od r0 = r0.b()
            if (r0 != 0) goto L5c
            r0 = r2
            goto L60
        L5c:
            boolean r0 = defpackage.j20.b(r0)
        L60:
            if (r0 != r1) goto L63
            goto L7f
        L63:
            boolean r0 = r3 instanceof defpackage.g9
            if (r0 != 0) goto L85
            fc0 r0 = y(r4)
            if (r0 != 0) goto L6e
            goto L85
        L6e:
            a91 r0 = r0.L0()
            od r0 = r0.b()
            if (r0 != 0) goto L79
            goto L7d
        L79:
            boolean r2 = defpackage.j20.b(r0)
        L7d:
            if (r2 != r1) goto L85
        L7f:
            h20 r0 = new h20
            r0.<init>(r3, r4)
            return r0
        L85:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e.n(ta, ox):ta");
    }

    public static byte[] n(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i3, i2 - i3);
            if (i4 < 0) {
                d.AnonymousClass0.m(ak.h(i2, "Not enough bytes to read: "));
                return null;
            }
            i3 += i4;
        }
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object n0(fy0 fy0Var, fy0 fy0Var2, bx bxVar) throws Throwable {
        Object teVar;
        Object objS;
        x10 x10Var;
        try {
            e4.b((i8) bxVar);
            teVar = bxVar.invoke(fy0Var2, fy0Var);
        } catch (Throwable th) {
            teVar = new te(th);
        }
        vi viVar = vi.b;
        if (teVar == viVar || (objS = fy0Var.S(teVar)) == d) {
            return viVar;
        }
        if (objS instanceof te) {
            throw ((te) objS).a;
        }
        y10 y10Var = objS instanceof y10 ? (y10) objS : null;
        return (y10Var == null || (x10Var = y10Var.a) == null) ? objS : x10Var;
    }

    public static LinkedHashSet n1(ij0 ij0Var, Collection collection, AbstractCollection abstractCollection, xc0 xc0Var, mr mrVar, pn0 pn0Var) {
        if (ij0Var == null) {
            o0(6);
            throw null;
        }
        if (collection == null) {
            o0(7);
            throw null;
        }
        if (xc0Var == null) {
            o0(9);
            throw null;
        }
        if (mrVar == null) {
            o0(10);
            throw null;
        }
        if (pn0Var != null) {
            return l1(ij0Var, collection, abstractCollection, xc0Var, mrVar, pn0Var, true);
        }
        o0(11);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x008a  */
    /* JADX WARN: Multi-variable type inference failed */
    public static String o(ox oxVar, int i2) {
        boolean z = (i2 & 1) != 0;
        boolean z2 = (i2 & 2) != 0;
        StringBuilder sb = new StringBuilder();
        if (z2) {
            sb.append(oxVar instanceof gh ? "<init>" : ((pk) oxVar).getName().b());
        }
        sb.append("(");
        sc0 sc0VarQ = oxVar.Q();
        if (sc0VarQ != null) {
            sb.append(b0(sc0VarQ.getType()));
        }
        Iterator it = oxVar.f().iterator();
        while (it.hasNext()) {
            sb.append(b0(((wc1) it.next()).getType()));
        }
        sb.append(")");
        if (z) {
            if (oxVar instanceof gh) {
                sb.append("V");
            } else {
                fc0 returnType = oxVar.getReturnType();
                ij0 ij0Var = ub0.e;
                if (!ub0.E(returnType, m21.a.d) || ma1.g(oxVar.getReturnType()) || (oxVar instanceof pq0)) {
                    sb.append(b0(oxVar.getReturnType()));
                } else {
                    sb.append("V");
                }
            }
        }
        return sb.toString();
    }

    public static byte[] o(FileInputStream fileInputStream, int i2, int i3) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i3];
            byte[] bArr2 = new byte[2048];
            int i4 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i4 < i2) {
                int i5 = fileInputStream.read(bArr2);
                if (i5 < 0) {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i2 + " bytes");
                }
                inflater.setInput(bArr2, 0, i5);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i3 - iInflate);
                    i4 += i5;
                } catch (DataFormatException e2) {
                    throw new IllegalStateException(e2.getMessage());
                }
            }
            if (i4 == i2) {
                if (!inflater.finished()) {
                    throw new IllegalStateException("Inflater did not finish");
                }
                inflater.end();
                return bArr;
            }
            throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i2 + " actual=" + i4);
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public static final long o0(long j2, long j3, long j4, String str) {
        String property;
        int i2 = i51.a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j2;
        }
        Long lV = q31.V(property);
        if (lV == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lV.longValue();
        if (j3 <= jLongValue && jLongValue <= j4) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4 + ", but is '" + jLongValue + '\'').toString());
    }

    public static /* synthetic */ void o0(int i2) {
        String str = i2 != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 18 ? 3 : 2];
        switch (i2) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i2 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 == 18) {
            throw new IllegalStateException(str2);
        }
    }

    public static final void o1(Object obj, ai aiVar) {
        if (!(aiVar instanceof qo)) {
            aiVar.resumeWith(obj);
            return;
        }
        qo qoVar = (qo) aiVar;
        bi biVar = qoVar.g;
        Throwable thA = bw0.a(obj);
        Object teVar = thA == null ? obj : new te(thA);
        qoVar.getContext();
        oi oiVar = qoVar.f;
        if (oiVar.A()) {
            qoVar.i = teVar;
            qoVar.d = 1;
            oiVar.x(biVar.getContext(), qoVar);
            return;
        }
        ThreadLocal threadLocal = p61.a;
        ur e9Var = (ur) threadLocal.get();
        if (e9Var == null) {
            e9Var = new e9(Thread.currentThread());
            threadLocal.set(e9Var);
        }
        if (e9Var.d >= 4294967296L) {
            qoVar.i = teVar;
            qoVar.d = 1;
            z6 z6Var = e9Var.g;
            if (z6Var == null) {
                z6Var = new z6();
                e9Var.g = z6Var;
            }
            z6Var.addLast(qoVar);
            return;
        }
        e9Var.C(true);
        try {
            h70 h70Var = (h70) biVar.getContext().a(b$1);
            if (h70Var == null || h70Var.isActive()) {
                Object obj2 = qoVar.j;
                li context = biVar.getContext();
                Object objB = b2.b(context, obj2);
                qb1 qb1VarB = objB != b2.a ? ak.b(biVar, context, objB) : null;
                try {
                    biVar.resumeWith(obj);
                    if (qb1VarB == null || qb1VarB.f0()) {
                        b2.a(context, objB);
                    }
                } catch (Throwable th) {
                    if (qb1VarB == null || qb1VarB.f0()) {
                        b2.a(context, objB);
                    }
                    throw th;
                }
            } else {
                CancellationException cancellationExceptionE = h70Var.e();
                if (teVar instanceof ue) {
                    throw null;
                }
                qoVar.resumeWith(new bw0.a(cancellationExceptionE));
            }
            while (e9Var.D()) {
            }
        } catch (Throwable th2) {
            try {
                qoVar.f(th2, null);
            } finally {
                e9Var.B();
            }
        }
    }

    public static long p(InputStream inputStream, int i2) throws IOException {
        byte[] bArrN = n(inputStream, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 += ((long) (bArrN[i3] & GZIPHeader.OS_UNKNOWN)) << (i3 * 8);
        }
        return j2;
    }

    public static View p(View view, int i2) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View viewFindViewById = viewGroup.getChildAt(i3).findViewById(i2);
            if (viewFindViewById != null) {
                return viewFindViewById;
            }
        }
        return null;
    }

    public static final String p(ja jaVar) {
        if (!xm.o(jaVar)) {
            ok okVarB = jaVar.b();
            ai0 ai0Var = okVarB instanceof ai0 ? (ai0) okVarB : null;
            if (ai0Var != null && !ai0Var.getName().c) {
                ja jaVarA = jaVar.a();
                q01 q01Var = jaVarA instanceof q01 ? (q01) jaVarA : null;
                if (q01Var != null) {
                    return q1(ai0Var, o(q01Var, 3));
                }
            }
        }
        return null;
    }

    public static int p0(int i2, int i3, String str) {
        return (int) o0(i2, 1, (i3 & 8) != 0 ? Integer.MAX_VALUE : 2097150, str);
    }

    public static ai0 q(ai0 ai0Var) {
        cv cvVar = (cv) l60.k.get(xm.g(ai0Var));
        if (cvVar != null) {
            return ym.e(ai0Var).j(cvVar);
        }
        d.AnonymousClass0.m$1("Given class ", ai0Var, " is not a read-only collection");
        return null;
    }

    public static final void q(fc0 fc0Var, u01 u01Var, LinkedHashSet linkedHashSet, Set set) {
        od odVarB = fc0Var.L0().b();
        if (odVarB instanceof v91) {
            if (!e4.a((Object) fc0Var.L0(), (Object) u01Var.L0())) {
                linkedHashSet.add(odVarB);
                return;
            }
            Iterator it = ((v91) odVarB).getUpperBounds().iterator();
            while (it.hasNext()) {
                q((fc0) it.next(), u01Var, linkedHashSet, set);
            }
            return;
        }
        od odVarB2 = fc0Var.L0().b();
        pd pdVar = odVarB2 instanceof pd ? (pd) odVarB2 : null;
        List listO = pdVar == null ? null : pdVar.o();
        int i2 = 0;
        for (ca1 ca1Var : fc0Var.K0()) {
            int i3 = i2 + 1;
            v91 v91Var = listO == null ? null : (v91) he.N0(listO, i2);
            if ((v91Var == null || set == null || !set.contains(v91Var)) && !ca1Var.b() && !linkedHashSet.contains(ca1Var.getType().L0().b()) && !e4.a((Object) ca1Var.getType().L0(), (Object) u01Var.L0())) {
                q(ca1Var.getType(), u01Var, linkedHashSet, set);
            }
            i2 = i3;
        }
    }

    public static final void q0() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final String q1(ai0 ai0Var, String str) {
        String str2 = l60.a;
        dd ddVarG = l60.g(ym.g(ai0Var).i());
        return (ddVarG == null ? n(ai0Var) : m80.b(ddVarG).d()) + '.' + str;
    }

    public static void r(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static final fc0 r1(v91 v91Var) {
        ArrayList arrayList;
        ok okVarB = v91Var.b();
        if (okVarB instanceof pd) {
            List parameters = ((pd) okVarB).h().getParameters();
            arrayList = new ArrayList(ae.y0(parameters));
            Iterator it = parameters.iterator();
            while (it.hasNext()) {
                arrayList.add(((v91) it.next()).h());
            }
        } else {
            if (!(okVarB instanceof ox)) {
                d.AnonymousClass0.m$2("Unsupported descriptor type to build star projection type based on type parameters of it");
                return null;
            }
            List typeParameters = ((ox) okVarB).getTypeParameters();
            arrayList = new ArrayList(ae.y0(typeParameters));
            Iterator it2 = typeParameters.iterator();
            while (it2.hasNext()) {
                arrayList.add(((v91) it2.next()).h());
            }
        }
        List upperBounds = v91Var.getUpperBounds();
        ub0 ub0VarE = ym.e(v91Var);
        fc0 fc0VarK = new ha1(new c91(1, arrayList)).k((fc0) he.K0(upperBounds), ad1.OUT_VARIANCE);
        return fc0VarK == null ? ub0VarE.p() : fc0VarK;
    }

    public static Drawable s(Context context, int i2) {
        return rv0.d().f(context, i2);
    }

    public static z81 s(boolean z, ld ldVar, int i2) {
        kc0$a kc0_a = kc0$a.a;
        if ((i2 & 4) != 0) {
            ldVar = f37g;
        }
        return new z81(z, true, ldVar, kc0_a, lc0$a.a);
    }

    public static void s(ByteArrayOutputStream byteArrayOutputStream, long j2, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((j2 >> (i3 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static final String s0(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            i2++;
            if ('A' <= cCharAt && cCharAt < '[') {
                cCharAt = Character.toLowerCase(cCharAt);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static final void s0(AbstractCollection abstractCollection, Object obj) {
        if (obj != null) {
            abstractCollection.add(obj);
        }
    }

    public static final u01 s1(fc0 fc0Var) {
        cc1 cc1VarO0 = fc0Var.O0();
        if (cc1VarO0 instanceof zt) {
            return ((zt) cc1VarO0).d;
        }
        if (cc1VarO0 instanceof u01) {
            return (u01) cc1VarO0;
        }
        d.AnonymousClass0.m();
        return null;
    }

    public static final h90 t(n90 n90Var) {
        Object obj;
        if (n90Var instanceof h90) {
            return (h90) n90Var;
        }
        if (!(n90Var instanceof ya0)) {
            throw new yi(e4.j("Cannot calculate JVM erasure for type: ", n90Var));
        }
        ja0 ja0Var = ya0.f[0];
        List list = (List) ((ya0) n90Var).c.invoke();
        Iterator it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            od odVarB = ((wa0) next).b.L0().b();
            ai0 ai0Var = odVarB instanceof ai0 ? (ai0) odVarB : null;
            if (ai0Var != null && ai0Var.v() != 2 && ai0Var.v() != 5) {
                obj = next;
                break;
            }
        }
        wa0 wa0Var = (wa0) obj;
        if (wa0Var == null) {
            wa0Var = (wa0) he.M0(list);
        }
        if (wa0Var == null) {
            return ou0.a.b(Object.class);
        }
        ja0 ja0Var2 = wa0.g[0];
        n90 n90Var2 = (n90) wa0Var.d.invoke();
        if (n90Var2 != null) {
            return t(n90Var2);
        }
        throw new yi(e4.j("Cannot calculate JVM erasure for type: ", wa0Var));
    }

    public static final HashSet t(Iterable iterable) {
        HashSet hashSet = new HashSet();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Set setG = ((vg0) it.next()).g();
            if (setG == null) {
                return null;
            }
            he.C0(setG, hashSet);
        }
        return hashSet;
    }

    public static y80 t(String str) {
        u80 u80Var;
        char cCharAt = str.charAt(0);
        u80[] u80VarArrValues = u80.values();
        int length = u80VarArrValues.length;
        int i2 = 0;
        do {
            if (i2 >= length) {
                u80Var = null;
                break;
            }
            u80Var = u80VarArrValues[i2];
            i2++;
        } while (u80Var.d.charAt(0) != cCharAt);
        if (u80Var != null) {
            return new y80.c(u80Var);
        }
        if (cCharAt == 'V') {
            return new y80.c(null);
        }
        if (cCharAt == '[') {
            return new y80.a(t(str.substring(1)));
        }
        if (cCharAt == 'L') {
            q31.f0(str, ';');
        }
        return new y80.b(str.substring(1, str.length() - 1));
    }

    public static void t(ByteArrayOutputStream byteArrayOutputStream, int i2) throws IOException {
        s(byteArrayOutputStream, i2, 2);
    }

    public static String t0(y80 y80Var) {
        if (y80Var instanceof y80.a) {
            return e4.j("[", t0(((y80.a) y80Var).i));
        }
        if (y80Var instanceof y80.c) {
            u80 u80Var = ((y80.c) y80Var).i;
            return u80Var == null ? "V" : u80Var.d;
        }
        if (y80Var instanceof y80.b) {
            return fb$1.m(new StringBuilder("L"), ((y80.b) y80Var).i, ';');
        }
        d.AnonymousClass0.m();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final r6 t0(fc0 fc0Var) {
        v81 v81Var;
        v81 v81Var2;
        if (fc0Var.O0() instanceof zt) {
            r6 r6VarT0 = t0(c1(fc0Var));
            r6 r6VarT1 = t0(s1(fc0Var));
            boolean z = fc0Var instanceof ra1;
            return new r6(v1(e4.c(c1((fc0) r6VarT0.a), s1((fc0) r6VarT1.a)), z ? ((ra1) fc0Var).i0() : null), v1(e4.c(c1((fc0) r6VarT0.b), s1((fc0) r6VarT1.b)), z ? ((ra1) fc0Var).i0() : null));
        }
        a91 a91VarL0 = fc0Var.L0();
        boolean z2 = true;
        if (fc0Var.L0() instanceof mb) {
            ca1 ca1VarA = ((mb) a91VarL0).a();
            fc0 fc0VarK = ma1.k(ca1VarA.getType(), fc0Var.M0());
            int iOrdinal = ca1VarA.c().ordinal();
            if (iOrdinal == 1) {
                return new r6(fc0VarK, fc0Var.L0().k().p());
            }
            if (iOrdinal == 2) {
                return new r6(ma1.k(fc0Var.L0().k().o(), fc0Var.M0()), fc0VarK);
            }
            throw new AssertionError(e4.j("Only nontrivial projections should have been captured, not: ", ca1VarA));
        }
        if (fc0Var.K0().isEmpty() || fc0Var.K0().size() != a91VarL0.getParameters().size()) {
            return new r6(fc0Var, fc0Var);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (jo0 jo0Var : he.k1(fc0Var.K0(), a91VarL0.getParameters())) {
            ca1 ca1Var = (ca1) jo0Var.b;
            v91 v91Var = (v91) jo0Var.c;
            ad1 ad1VarJ = v91Var.j();
            if (ad1VarJ == null) {
                ha1.a(35);
                throw null;
            }
            if (ca1Var == null) {
                ha1.a(36);
                throw null;
            }
            ha1 ha1Var = ha1.b;
            int iOrdinal2 = (ca1Var.b() ? ad1.OUT_VARIANCE : ha1.b(ad1VarJ, ca1Var.c())).ordinal();
            if (iOrdinal2 == 0) {
                v81Var2 = new v81(v91Var, ca1Var.getType(), ca1Var.getType());
            } else if (iOrdinal2 == 1) {
                v81Var2 = new v81(v91Var, ca1Var.getType(), ym.e(v91Var).p());
            } else {
                if (iOrdinal2 != 2) {
                    d.AnonymousClass0.m();
                    return null;
                }
                v81Var2 = new v81(v91Var, ym.e(v91Var).o(), ca1Var.getType());
            }
            if (ca1Var.b()) {
                arrayList.add(v81Var2);
                arrayList2.add(v81Var2);
            } else {
                r6 r6VarT2 = t0(v81Var2.b);
                fc0 fc0Var2 = (fc0) r6VarT2.a;
                fc0 fc0Var3 = (fc0) r6VarT2.b;
                r6 r6VarT3 = t0(v81Var2.c);
                fc0 fc0Var4 = (fc0) r6VarT3.a;
                fc0 fc0Var5 = (fc0) r6VarT3.b;
                v91 v91Var2 = v81Var2.a;
                v81 v81Var3 = new v81(v91Var2, fc0Var3, fc0Var4);
                v81 v81Var4 = new v81(v91Var2, fc0Var2, fc0Var5);
                arrayList.add(v81Var3);
                arrayList2.add(v81Var4);
            }
        }
        if (arrayList.isEmpty()) {
            z2 = false;
            break;
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            v81Var = (v81) it.next();
            v81Var.getClass();
        } while (gc0.a.e(v81Var.b, v81Var.c));
        return new r6(z2 ? fc0Var.L0().k().o() : j1(arrayList, fc0Var), j1(arrayList2, fc0Var));
    }

    public static final u01 t1(u01 u01Var, u01 u01Var2) {
        return O((fc0) u01Var) ? u01Var : new a(u01Var, u01Var2);
    }

    public static final u01 u(ub0 ub0Var, s4 s4Var, fc0 fc0Var, ArrayList arrayList, fc0 fc0Var2, boolean z) {
        ai0 ai0VarK;
        ArrayList arrayList2;
        int i2 = 0;
        ArrayList arrayList3 = new ArrayList(arrayList.size() + (fc0Var != null ? 1 : 0) + 1);
        s0(arrayList3, fc0Var == null ? null : new da1(fc0Var));
        Iterator it = arrayList.iterator();
        int i3 = 0;
        while (true) {
            boolean zHasNext = it.hasNext();
            s4$a$a s4_a_a = e4.f47a;
            if (!zHasNext) {
                arrayList3.add(new da1(fc0Var2));
                int size = arrayList.size();
                if (fc0Var != null) {
                    size++;
                }
                if (z) {
                    ub0Var.getClass();
                    ai0VarK = ub0Var.j(m21.c.c(ij0.f(e4.j(mx.g.c, Integer.valueOf(size)))));
                } else {
                    ij0 ij0Var = m21.a;
                    ai0VarK = ub0Var.k(e4.j("Function", Integer.valueOf(size)));
                }
                if (fc0Var != null) {
                    cv cvVar = m21.a.p;
                    if (!s4Var.f(cvVar)) {
                        o9 o9Var = new o9(ub0Var, cvVar, vq.b);
                        if (s4Var instanceof Collection) {
                            arrayList2 = he.Y0((Collection) s4Var, o9Var);
                        } else {
                            arrayList2 = new ArrayList();
                            he.C0(s4Var, arrayList2);
                            arrayList2.add(o9Var);
                        }
                        s4Var = arrayList2.isEmpty() ? s4_a_a : new t4(i2, arrayList2);
                    }
                }
                return e4.f(s4Var, ai0VarK.h(), arrayList3, false);
            }
            Object next = it.next();
            int i4 = i3 + 1;
            if (i3 < 0) {
                q0();
                throw null;
            }
            arrayList3.add(new da1((fc0) next));
            i3 = i4;
        }
    }

    public static final Object[] u0(int i2) {
        if (i2 >= 0) {
            return new Object[i2];
        }
        d.AnonymousClass0.m$2("capacity must be non-negative.");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object u1(ai aiVar, li liVar, bx bxVar) throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        Object objN;
        x10 x10Var;
        li context = aiVar.getContext();
        li liVarY = !((Boolean) liVar.i(Boolean.FALSE, gm.b$7)).booleanValue() ? context.y(liVar) : ak.a(context, liVar, false);
        h70 h70Var = (h70) liVarY.a(b$1);
        if (h70Var != null && !h70Var.isActive()) {
            throw h70Var.e();
        }
        if (liVarY == context) {
            fy0 fy0Var = new fy0(aiVar, liVarY);
            objN = n0(fy0Var, fy0Var, bxVar);
        } else {
            e eVar = b$2;
            if (e4.a(liVarY.a(eVar), context.a(eVar))) {
                qb1 qb1Var = new qb1(aiVar, liVarY);
                li liVar2 = qb1Var.d;
                Object objB = b2.b(liVar2, (Object) null);
                try {
                    Object objN0 = n0(qb1Var, qb1Var, bxVar);
                    b2.a(liVar2, objB);
                    objN = objN0;
                } catch (Throwable th) {
                    b2.a(liVar2, objB);
                    throw th;
                }
            } else {
                ro roVar = new ro(aiVar, liVarY);
                try {
                    o1(tb1.a, U0(((i8) bxVar).create(roVar, roVar)));
                    do {
                        atomicIntegerFieldUpdater = ro.g;
                        int i2 = atomicIntegerFieldUpdater.get(roVar);
                        if (i2 != 0) {
                            if (i2 != 2) {
                                d.AnonymousClass0.m("Already suspended");
                                return null;
                            }
                            objN = roVar.N();
                            y10 y10Var = objN instanceof y10 ? (y10) objN : null;
                            if (y10Var != null && (x10Var = y10Var.a) != null) {
                                objN = x10Var;
                            }
                            if (objN instanceof te) {
                                throw ((te) objN).a;
                            }
                        }
                    } while (!atomicIntegerFieldUpdater.compareAndSet(roVar, 0, 1));
                    objN = vi.b;
                } catch (Throwable th2) {
                    roVar.resumeWith(new bw0.a(th2));
                    throw th2;
                }
            }
        }
        vi viVar = vi.b;
        return objN;
    }

    public static final h90 v(Annotation annotation) {
        return ou0.a.b(annotation.annotationType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final cc1 v1(cc1 cc1Var, fc0 fc0Var) {
        if (cc1Var instanceof ra1) {
            return v1(((ra1) cc1Var).G0(), fc0Var);
        }
        if (fc0Var == null || fc0Var.equals(cc1Var)) {
            return cc1Var;
        }
        if (cc1Var instanceof u01) {
            return new x01((u01) cc1Var, fc0Var);
        }
        if (cc1Var instanceof zt) {
            return new du((zt) cc1Var, fc0Var);
        }
        d.AnonymousClass0.m();
        return null;
    }

    public static final ti w(MainViewModel mainViewModel) {
        ti tiVar = (ti) mainViewModel.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (tiVar != null) {
            return tiVar;
        }
        i41 i41Var = new i41();
        hl hlVar = uo.a;
        return (ti) mainViewModel.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new td(ak.a(i41Var, yf0.a.i)));
    }

    public static final nr0 w0(rr0 rr0Var, fi0 fi0Var) {
        int i2 = rr0Var.d;
        if ((i2 & 4) == 4) {
            return rr0Var.i;
        }
        if ((i2 & 8) == 8) {
            return fi0Var.a(rr0Var.j);
        }
        d.AnonymousClass0.m("No type in ProtoBuf.ValueParameter");
        return null;
    }

    public static final dd x(jj0 jj0Var, int i2) {
        return dd.f(jj0Var.b(i2), jj0Var.a(i2));
    }

    public static final boolean x(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    public static boolean x(z81 z81Var, w01 w01Var, v3 v3Var) {
        z81.b bVar = z81.b.a$1;
        ld ldVar = z81Var.c;
        if ((ldVar.U(w01Var) && !ldVar.F(w01Var)) || ldVar.t(w01Var)) {
            return true;
        }
        z81Var.b();
        ArrayDeque arrayDeque = z81Var.g;
        o11 o11Var = z81Var.h;
        arrayDeque.push(w01Var);
        while (!arrayDeque.isEmpty()) {
            if (o11Var.c > 1000) {
                StringBuilder sbM = m("Too many supertypes for type: ", w01Var, ". Supertypes = ");
                sbM.append(he.R0(o11Var, null, null, null, null, 63));
                throw new IllegalStateException(sbM.toString().toString());
            }
            w01 w01Var2 = (w01) arrayDeque.pop();
            if (o11Var.add(w01Var2)) {
                v3 v3Var2 = ldVar.F(w01Var2) ? bVar : v3Var;
                if (v3Var2.equals(bVar)) {
                    v3Var2 = null;
                }
                if (v3Var2 == null) {
                    continue;
                } else {
                    Iterator it = ldVar.W(ldVar.c(w01Var2)).iterator();
                    while (it.hasNext()) {
                        w01 w01VarA = v3Var2.a(z81Var, (jc0) it.next());
                        if ((ldVar.U(w01VarA) && !ldVar.F(w01VarA)) || ldVar.t(w01VarA)) {
                            z81Var.a();
                            return true;
                        }
                        arrayDeque.add(w01VarA);
                    }
                }
            }
        }
        z81Var.a();
        return false;
    }

    public static final fc0 y(la laVar) {
        sc0 sc0VarQ = laVar.Q();
        sc0 sc0VarN = laVar.N();
        if (sc0VarQ != null) {
            return sc0VarQ.getType();
        }
        if (sc0VarN != null) {
            if (laVar instanceof gh) {
                return sc0VarN.getType();
            }
            ok okVarB = laVar.b();
            ai0 ai0Var = okVarB instanceof ai0 ? (ai0) okVarB : null;
            if (ai0Var != null) {
                return ai0Var.n();
            }
        }
        return null;
    }

    public static boolean y(z81 z81Var, cc1 cc1Var, cc1 cc1Var2) {
        if (cc1Var == cc1Var2) {
            return true;
        }
        ld ldVar = z81Var.c;
        kc0$a kc0_a = z81Var.d;
        if (M(ldVar, cc1Var) && M(ldVar, cc1Var2)) {
            z81Var.e.getClass();
            cc1 cc1VarB = kc0_a.b(cc1Var);
            cc1 cc1VarB2 = kc0_a.b(cc1Var2);
            u01 u01VarV = ldVar.V(cc1VarB);
            if (!ldVar.d0(ldVar.f0(cc1VarB), ldVar.f0(cc1VarB2))) {
                return false;
            }
            if (ldVar.O(u01VarV) == 0) {
                return ldVar.s(cc1VarB) || ldVar.s(cc1VarB2) || ldVar.F(u01VarV) == ldVar.F(ldVar.V(cc1VarB2));
            }
        }
        return Q(z81Var, cc1Var, cc1Var2) && Q(z81Var, cc1Var2, cc1Var);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    public static final ij0 z(fc0 fc0Var) {
        String str;
        g4 g4VarC = fc0Var.getAnnotations().c(m21.a.q);
        if (g4VarC != null) {
            Object objB1 = he.b1(g4VarC.h().values());
            h31 h31Var = objB1 instanceof h31 ? (h31) objB1 : null;
            if (h31Var == null) {
                str = null;
            } else {
                str = (String) h31Var.a;
                if (!ij0.g(str)) {
                    str = null;
                }
            }
            if (str != null) {
                return ij0.f(str);
            }
        }
        return null;
    }

    public static final Object z(yx.c cVar, yx.e eVar) {
        if (cVar.h(eVar)) {
            return cVar.g(eVar);
        }
        return null;
    }

    public static boolean z(z81 z81Var, w01 w01Var, a91 a91Var) {
        ld ldVar = z81Var.c;
        if (ldVar.Z(w01Var)) {
            return true;
        }
        if (ldVar.F(w01Var)) {
            return false;
        }
        if (z81Var.b) {
            ldVar.Y(w01Var);
        }
        return ldVar.d0(ldVar.c(w01Var), a91Var);
    }

    public static final void z0(li liVar, CancellationException cancellationException) {
        h70 h70Var = (h70) liVar.a(b$1);
        if (h70Var != null) {
            if (cancellationException == null) {
                cancellationException = new d70(h70Var.E(), null, h70Var);
            }
            h70Var.C(cancellationException);
        }
    }

    @Override // defpackage.ld
    public cc1 A(ArrayList arrayList) {
        return e4.E(arrayList);
    }

    @Override // defpackage.ld
    public da1 B(cc1 cc1Var) {
        return e4.i(cc1Var);
    }

    @Override // defpackage.ld
    public ca1 C(vk0 vk0Var) {
        return e4.e0(vk0Var);
    }

    @Override // defpackage.ld
    public v91 D(b91 b91Var, int i2) {
        return e4.q(b91Var, i2);
    }

    public boolean D(ok okVar, ok okVar2, bx bxVar, boolean z) {
        ok okVarB = okVar.b();
        ok okVarB2 = okVar2.b();
        return ((okVarB instanceof la) || (okVarB2 instanceof la)) ? ((Boolean) bxVar.invoke(okVarB, okVarB2)).booleanValue() : i(okVarB, okVarB2, z);
    }

    @Override // defpackage.ld
    public boolean E(w01 w01Var, w01 w01Var2) {
        return e4.D(w01Var, w01Var2);
    }

    @Override // defpackage.ld
    public boolean F(w01 w01Var) {
        return e4.N(w01Var);
    }

    @Override // defpackage.ld
    public ca1 G(w01 w01Var, int i2) {
        if (i2 < 0 || i2 >= O(w01Var)) {
            return null;
        }
        return J(w01Var, i2);
    }

    @Override // defpackage.ld
    public boolean H(b91 b91Var) {
        return e4.P(b91Var);
    }

    @Override // defpackage.ld
    public boolean I(b91 b91Var) {
        return e4.H(b91Var);
    }

    @Override // defpackage.ld
    public ca1 J(jc0 jc0Var, int i2) {
        return e4.n(jc0Var, i2);
    }

    @Override // defpackage.ld
    public cc1 M(cc1 cc1Var) {
        return e4.m0(this, cc1Var);
    }

    @Override // defpackage.ld
    public boolean N(v91 v91Var, a91 a91Var) {
        return e4.C(v91Var, a91Var);
    }

    @Override // defpackage.ld
    public int O(jc0 jc0Var) {
        return e4.b(jc0Var);
    }

    @Override // defpackage.ld
    public boolean P(ca1 ca1Var) {
        return e4.T(ca1Var);
    }

    @Override // ak.c
    public Iterable Q(Object obj) {
        int i2 = 3;
        if (this.G0 == 3) {
            return ((la) obj).a().d();
        }
        return new l7(i2, new ht(new c81(new ge(0, ((ai0) obj).h().d()), p0.b$1), false, new cz0(0)));
    }

    @Override // defpackage.ld
    public w81 R(w01 w01Var) {
        return e4.c(w01Var);
    }

    @Override // defpackage.ld
    public void S(w01 w01Var) {
        e4.V(w01Var);
    }

    @Override // defpackage.ld
    public vk0 T(rb rbVar) {
        return e4.i0(rbVar);
    }

    @Override // defpackage.ld
    public boolean U(w01 w01Var) {
        return e4.G(e4.j0(w01Var));
    }

    @Override // defpackage.ld
    public u01 V(jc0 jc0Var) {
        zt ztVarE0 = e0(jc0Var);
        return ztVarE0 == null ? a(jc0Var) : d(ztVarE0);
    }

    @Override // defpackage.ld
    public Collection W(a91 a91Var) {
        return e4.h0(a91Var);
    }

    @Override // defpackage.ld
    public boolean X(b91 b91Var) {
        return e4.I(b91Var);
    }

    @Override // defpackage.ld
    public void Y(w01 w01Var) {
        e4.U(w01Var);
    }

    @Override // defpackage.ld
    public boolean Z(w01 w01Var) {
        return H(f0(w01Var)) && !e4.Q(w01Var);
    }

    @Override // defpackage.f3
    public Collection a(on onVar) {
        return uq.b;
    }

    @Override // defpackage.ld
    public u01 a(jc0 jc0Var) {
        return e4.h(jc0Var);
    }

    public void a() {
    }

    @Override // defpackage.ld
    public int a0(v91 v91Var) {
        return e4.z(v91Var);
    }

    @Override // defpackage.f3
    public Collection b(ij0 ij0Var, on onVar) {
        return uq.b;
    }

    @Override // defpackage.ld
    public u01 b(w01 w01Var, boolean z) {
        return e4.n0(w01Var, z);
    }

    @Override // defpackage.mr
    public void b(k kVar, ArrayList arrayList) {
        throw new IllegalStateException("Incomplete hierarchy for class " + kVar.getName() + ", unresolved classes " + arrayList);
    }

    public void b(boolean z) {
    }

    @Override // defpackage.ld
    public cc1 b0(cc1 cc1Var) {
        return d1(cc1Var);
    }

    @Override // defpackage.ld
    public a91 c(w01 w01Var) {
        return e4.j0(w01Var);
    }

    @Override // defpackage.f3
    public Collection c(on onVar) {
        return uq.b;
    }

    @Override // defpackage.mr
    public void c(la laVar) {
        throw new IllegalStateException(e4.j("Cannot infer visibility for ", laVar));
    }

    public void c(boolean z) {
        throw null;
    }

    @Override // defpackage.ld
    public boolean c0(w01 w01Var) {
        u01 u01VarH = e4.h(w01Var);
        return (u01VarH == null ? null : e4.d(this, u01VarH)) != null;
    }

    @Override // defpackage.ld
    public u01 d(zt ztVar) {
        return e4.X(ztVar);
    }

    @Override // defpackage.yp
    public void d(Window window) {
    }

    @Override // defpackage.ld
    public boolean d0(b91 b91Var, b91 b91Var2) {
        return e4.a(b91Var, b91Var2);
    }

    @Override // defpackage.f3
    public Collection e(on onVar) {
        return uq.b;
    }

    @Override // defpackage.ld
    public rb e(w01 w01Var) {
        return e4.d(this, w01Var);
    }

    @Override // defpackage.ld
    public zt e0(jc0 jc0Var) {
        return e4.g(jc0Var);
    }

    @Override // defpackage.ld
    public u01 f(zt ztVar) {
        return e4.k0(ztVar);
    }

    @Override // defpackage.ld
    public a91 f0(jc0 jc0Var) {
        u01 u01VarH = e4.h(jc0Var);
        if (u01VarH == null) {
            zt ztVarE0 = e0(jc0Var);
            u01VarH = ztVarE0 == null ? a(jc0Var) : d(ztVarE0);
        }
        return e4.j0(u01VarH);
    }

    @Override // defpackage.ld
    public boolean g0(a91 a91Var) {
        return e4.L(a91Var);
    }

    @Override // defpackage.ws0
    public fc0 getType() {
        int i2 = this.G0;
        if (i2 == 15) {
            throw new IllegalStateException("This method should not be called");
        }
        if (i2 != 16) {
            throw new IllegalStateException("This method should not be called");
        }
        throw new IllegalStateException("This method should not be called");
    }

    @Override // defpackage.ld
    public boolean h(rb rbVar) {
        return rbVar instanceof jb;
    }

    @Override // defpackage.ld
    public u01 h0(ml mlVar) {
        return mlVar.c;
    }

    @Override // defpackage.ld
    public int i(w81 w81Var) {
        return e4.f0(this, w81Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean i(ok okVar, ok okVar2, boolean z) {
        if ((okVar instanceof ai0) && (okVar2 instanceof ai0)) {
            return e4.a((Object) ((ai0) okVar).h(), (Object) ((ai0) okVar2).h());
        }
        if ((okVar instanceof v91) && (okVar2 instanceof v91)) {
            return j((v91) okVar, (v91) okVar2, z, gm.b$1);
        }
        if (!(okVar instanceof ja) || !(okVar2 instanceof ja)) {
            boolean z2 = okVar instanceof wn0;
            Object obj = okVar;
            Object obj2 = okVar2;
            if (z2 && (okVar2 instanceof wn0)) {
                obj = okVar;
                obj2 = okVar2;
                obj = ((xn0) ((wn0) okVar)).g;
                obj2 = ((xn0) ((wn0) okVar2)).g;
            }
            obj = okVar;
            obj2 = okVar2;
            return e4.a(obj, obj2);
        }
        ja jaVar = (ja) okVar;
        ja jaVar2 = (ja) okVar2;
        if (!jaVar.equals(jaVar2)) {
            if (!((pk) jaVar).getName().equals(((pk) jaVar2).getName())) {
                return false;
            }
            if ((jaVar instanceof qg0) && (jaVar2 instanceof qg0) && ((qg0) jaVar).l0() != ((qg0) jaVar2).l0()) {
                return false;
            }
            if ((e4.a(jaVar.b(), jaVar2.b()) && (!z || !e4.a(M(jaVar), M(jaVar2)))) || xm.o(jaVar) || xm.o(jaVar2) || !D(jaVar, jaVar2, gm.b, z)) {
                return false;
            }
            pn0 pn0Var = new pn0(new hm(jaVar, jaVar2, z));
            if (pn0Var.m(jaVar, jaVar2, null, true).c() != 1 || pn0Var.m(jaVar2, jaVar, null, true).c() != 1) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.ld
    public boolean i0(a91 a91Var) {
        return e4.F(a91Var);
    }

    @Override // defpackage.ld
    public boolean j(jc0 jc0Var) {
        zt ztVarG = e4.g(jc0Var);
        return (ztVarG == null ? null : e4.f(ztVarG)) != null;
    }

    public boolean j(v91 v91Var, v91 v91Var2, boolean z, bx bxVar) {
        if (e4.a(v91Var, v91Var2)) {
            return true;
        }
        return !e4.a(v91Var.b(), v91Var2.b()) && D(v91Var, v91Var2, bxVar, z) && v91Var.getIndex() == v91Var2.getIndex();
    }

    @Override // defpackage.ld
    public boolean j0(rb rbVar) {
        return e4.S(rbVar);
    }

    @Override // defpackage.ld
    public cc1 k(ca1 ca1Var) {
        return e4.v(ca1Var);
    }

    @Override // defpackage.ld
    public ca1 k0(w81 w81Var, int i2) {
        return e4.m(this, w81Var, i2);
    }

    @Override // defpackage.ld
    public boolean l(a91 a91Var) {
        return e4.M(a91Var);
    }

    @Override // defpackage.ld
    public int l0(ca1 ca1Var) {
        return e4.y(ca1Var);
    }

    @Override // defpackage.s01
    public void lock() {
    }

    @Override // defpackage.ld
    public boolean m(b91 b91Var) {
        return e4.G(b91Var);
    }

    @Override // defpackage.ld
    public cc1 m0(u01 u01Var, u01 u01Var2) {
        return e4.l(this, u01Var, u01Var2);
    }

    @Override // defpackage.ld
    public ml n0(w01 w01Var) {
        return e4.e(w01Var);
    }

    @Override // defpackage.ld
    public cc1 o(rb rbVar) {
        return e4.Z(rbVar);
    }

    public void onAnimationCancel() {
    }

    @Override // defpackage.lm0
    public fg1 onApplyWindowInsets(View view, fg1 fg1Var) {
        int i2 = HamoTunnelPlusMain.b1;
        t20 t20VarF = fg1Var.a.f();
        view.setPadding(t20VarF.a, t20VarF.b, t20VarF.c, t20VarF.d);
        return fg1.b;
    }

    @Override // defpackage.ld
    public Set p(w01 w01Var) {
        return e4.d0(this, w01Var);
    }

    @Override // defpackage.ld
    public boolean q(w01 w01Var) {
        return e4.J(w01Var);
    }

    @Override // defpackage.ld
    public ib r(rb rbVar) {
        return e4.k(rbVar);
    }

    @Override // defpackage.ld
    public boolean s(cc1 cc1Var) {
        return F(V(cc1Var)) != F(z((jc0) cc1Var));
    }

    @Override // defpackage.ld
    public boolean t(jc0 jc0Var) {
        u01 u01VarH = e4.h(jc0Var);
        return (u01VarH == null ? null : e4.e(u01VarH)) != null;
    }

    @Override // defpackage.ld
    public md u(w01 w01Var) {
        return e4.g0(this, w01Var);
    }

    @Override // defpackage.s01
    public void unlock() {
    }

    @Override // defpackage.ld
    public boolean w(w01 w01Var) {
        return e4.L(e4.j0(w01Var));
    }

    @Override // defpackage.ld
    public u01 x(w01 w01Var) {
        return e4.j(w01Var);
    }

    @Override // defpackage.ld
    public int y(a91 a91Var) {
        return e4.c0(a91Var);
    }

    @Override // defpackage.ld
    public u01 z(jc0 jc0Var) {
        zt ztVarE0 = e0(jc0Var);
        return ztVarE0 == null ? a(jc0Var) : f(ztVarE0);
    }
}
