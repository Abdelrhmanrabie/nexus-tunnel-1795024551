package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.Vector;
import net.lingala.zip4j.util.InternalZipConstants;
import net.openvpn.ovpn3.XMLRPC;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.plugin.PluginContract;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hg implements xb0$a {
    public final Object a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends Exception {
    }

    public hg(int i) {
        Object map;
        if (i != 1) {
            this.a = new String[]{"config", "tls-server"};
            this.b = new String[]{"tls-client", "allow-recursive-routing", "askpass", "auth-nocache", "up", "down", "route-up", "ipchange", "route-pre-down", "auth-user-pass-verify", "block-outside-dns", "client-cert-not-required", "dhcp-release", "dhcp-renew", "dh", "group", "ip-win32", "ifconfig-nowarn", "management-hold", "management", "management-client", "management-query-remote", "management-query-passwords", "management-query-proxy", "management-external-key", "management-forget-disconnect", "management-signal", "management-log-cache", "management-up-down", "management-client-user", "management-client-group", "pause-exit", "preresolve", PluginContract.SCHEME, "machine-readable-output", "persist-key", "push", "register-dns", "route-delay", "route-gateway", "route-metric", "route-method", "status", "script-security", "show-net-up", "suppress-timestamps", "tap-sleep", "tmp-dir", "tun-ipv6", "topology", "user", "win-sys"};
            this.c = new String[][]{new String[]{"setenv", "IV_GUI_VER"}, new String[]{"setenv", "IV_SSO"}, new String[]{"setenv", "IV_PLAT_VER"}, new String[]{"setenv", "IV_OPENVPN_GUI_VERSION"}, new String[]{"engine", "dynamic"}, new String[]{"setenv", "CLIENT_CERT"}, new String[]{"resolv-retry", "60"}};
            this.d = new HashSet(Arrays.asList("local", "remote", "float", "port", "connect-retry", "connect-timeout", "connect-retry-max", "link-mtu", "tun-mtu", "tun-mtu-extra", AppConfig.TAG_FRAGMENT, "mtu-disc", "local-port", "remote-port", "bind", "nobind", "proto", "http-proxy", "http-proxy-retry", "http-proxy-timeout", "http-proxy-option", "socks-proxy", "socks-proxy-retry", "http-proxy-user-pass", "explicit-exit-notify"));
            this.e = new HashMap();
            map = new HashMap();
        } else {
            this.a = new int[]{R.drawable.be, R.drawable.bc, R.drawable.c};
            this.b = new int[]{R.drawable.a0, R.drawable.ay, R.drawable.a7, R.drawable.a2, R.drawable.a3, R.drawable.a6, R.drawable.a5};
            this.c = new int[]{R.drawable.bb, R.drawable.bd, R.drawable.t, R.drawable.b8, R.drawable.b9, R.drawable.b_, R.drawable.ba};
            this.d = new int[]{R.drawable.ao, R.drawable.r, R.drawable.an};
            this.e = new int[]{R.drawable.b6, R.drawable.bf};
            map = new int[]{R.drawable.f, R.drawable.l, R.drawable.g, R.drawable.m};
        }
        this.f = map;
    }

    public hg(v8 v8Var, ai0 ai0Var, dd ddVar, List list, t11 t11Var) {
        this.a = v8Var;
        this.b = ai0Var;
        this.c = ddVar;
        this.d = list;
        this.f = t11Var;
        this.e = new HashMap();
    }

    public static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList b(Context context, int i) {
        int iC = j61.c(context, R.style.g5);
        return new ColorStateList(new int[][]{j61.b, j61.d, j61.c, j61.f}, new int[]{j61.b(context, R.style.g2), je.b(iC, i), je.b(iC, i), i});
    }

    public static void b(Vector vector, BufferedReader bufferedReader) throws IOException, a {
        String strTrim = ((String) vector.get(0)).trim();
        if (!strTrim.startsWith("<") || !strTrim.endsWith(">")) {
            return;
        }
        String strSubstring = strTrim.substring(1, strTrim.length() - 1);
        String strM = ak.AnonymousClass0.m("</", strSubstring, ">");
        String strSubstring2 = "[[INLINE]]";
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                throw new a("No endtag </" + strSubstring + "> for starttag <" + strSubstring + "> found");
            }
            if (line.trim().equals(strM)) {
                if (strSubstring2.endsWith("\n")) {
                    strSubstring2 = strSubstring2.substring(0, strSubstring2.length() - 1);
                }
                vector.clear();
                vector.add(strSubstring);
                vector.add(strSubstring2);
                return;
            }
            strSubstring2 = ak.j(ak.j(strSubstring2, line), "\n");
        }
    }

    public static void d(Drawable drawable, int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterH;
        if (fp.a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = o5.b;
        }
        PorterDuff.Mode mode2 = o5.b;
        synchronized (o5.class) {
            porterDuffColorFilterH = rv0.h(i, mode);
        }
        drawable.setColorFilter(porterDuffColorFilterH);
    }

    public static boolean h(String str) throws a {
        if (str.equals("udp") || str.equals("udp4") || str.equals("udp6")) {
            return true;
        }
        if (str.equals("tcp-client") || str.equals(AppConfig.DEFAULT_NETWORK) || str.equals("tcp4") || str.endsWith("tcp4-client") || str.equals("tcp6") || str.endsWith("tcp6-client")) {
            return false;
        }
        throw new a("Unsupported option to --proto ".concat(str));
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0073  */
    /* JADX WARN: Code duplicated, block: B:46:0x0075 A[PHI: r6
      0x0075: PHI (r6v6 char) = (r6v1 char), (r6v1 char), (r6v1 char), (r6v1 char), (r6v1 char), (r6v9 char) binds: [B:44:0x0071, B:40:0x006a, B:41:0x006c, B:34:0x005d, B:37:0x0065, B:32:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x0078  */
    public static Vector k(String str) throws a {
        String str2;
        char cCharAt;
        Vector vector = new Vector();
        if (str.length() != 0) {
            char c = 1;
            String str3 = AppConfig.CUSTOM;
            int i = 0;
            boolean z = false;
            char c2 = 0;
            while (true) {
                if (i < str.length()) {
                    str2 = str;
                    cCharAt = str2.charAt(i);
                } else {
                    str2 = str;
                    cCharAt = 0;
                }
                if (!z && cCharAt == '\\' && c != 2) {
                    z = true;
                } else if (c == 1) {
                    if (!Character.isWhitespace(cCharAt) && cCharAt != 0) {
                        if (cCharAt == ';' || cCharAt == '#') {
                            break;
                        }
                        if (!z && cCharAt == '\"') {
                            c = 3;
                        } else if (z || cCharAt != '\'') {
                            c = 4;
                            c2 = cCharAt;
                        } else {
                            c = 2;
                        }
                    }
                    if (c == 5) {
                        vector.add(str3);
                        c = 1;
                        str3 = AppConfig.CUSTOM;
                        c2 = 0;
                    }
                    if (!z && c2 != 0 && c2 != '\\' && c2 != '\"' && !Character.isWhitespace(c2) && c2 != 0) {
                        throw new a("Options warning: Bad backslash ('\\') usage");
                    }
                    z = false;
                } else {
                    if (c == 4) {
                        if (z || !(Character.isWhitespace(cCharAt) || cCharAt == 0)) {
                            c2 = cCharAt;
                        } else {
                            c = 5;
                        }
                    } else if (c == 3) {
                        if (z || cCharAt != '\"') {
                            c2 = cCharAt;
                        } else {
                            c = 5;
                        }
                    } else if (c == 2) {
                        if (cCharAt == '\'') {
                            c = 5;
                        } else {
                            c2 = cCharAt;
                        }
                    }
                    if (c == 5) {
                        vector.add(str3);
                        c = 1;
                        str3 = AppConfig.CUSTOM;
                        c2 = 0;
                    }
                    if (!z) {
                    }
                    z = false;
                }
                if (c2 != 0) {
                    str3 = str3 + c2;
                }
                int i2 = i + 1;
                if (i >= str2.length()) {
                    break;
                }
                i = i2;
            }
        }
        return vector;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0036  */
    @Override // defpackage.xb0$a
    /* JADX INFO: renamed from: a */
    public void mo57a() {
        boolean zR;
        HashMap map = (HashMap) this.e;
        v8 v8Var = (v8) this.a;
        dd ddVar = (dd) this.c;
        if (ddVar.equals(e21.b)) {
            Object obj = map.get(ij0.f(XMLRPC.TAG_VALUE));
            m90 m90Var = obj instanceof m90 ? (m90) obj : null;
            if (m90Var == null) {
                zR = false;
            } else {
                Object obj2 = m90Var.a;
                m90.a.b bVar = obj2 instanceof m90.a.b ? (m90.a.b) obj2 : null;
                if (bVar == null) {
                    zR = false;
                } else {
                    zR = v8Var.r(bVar.a.a);
                }
            }
        } else {
            zR = false;
        }
        if (zR || v8Var.r(ddVar)) {
            return;
        }
        ((List) this.d).add(new h4(((ai0) this.b).n(), map, (t11) this.f));
    }

    @Override // defpackage.xb0$a
    public void b(ij0 ij0Var, ed edVar) {
        ((HashMap) this.e).put(ij0Var, new m90(edVar));
    }

    public ColorStateList c(Context context, int i) {
        if (i == R.drawable.w) {
            return b2.getColorStateList(context, R.color.v);
        }
        if (i == R.drawable.b5) {
            return b2.getColorStateList(context, R.color.y);
        }
        if (i != R.drawable.b4) {
            if (i == R.drawable.k) {
                return b(context, j61.c(context, R.style.g2));
            }
            if (i == R.drawable.e) {
                return b(context, 0);
            }
            if (i == R.drawable.j) {
                return b(context, j61.c(context, R.style.g0));
            }
            if (i == R.drawable.b0 || i == R.drawable.b1) {
                return b2.getColorStateList(context, R.color.x);
            }
            if (a((int[]) this.b, i)) {
                return j61.d(context, R.style.g6);
            }
            if (a((int[]) this.e, i)) {
                return b2.getColorStateList(context, R.color.u);
            }
            if (a((int[]) this.f, i)) {
                return b2.getColorStateList(context, R.color.t);
            }
            if (i == R.drawable.ax) {
                return b2.getColorStateList(context, R.color.w);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListD = j61.d(context, R.style.h0);
        if (colorStateListD == null || !colorStateListD.isStateful()) {
            iArr[0] = j61.b;
            iArr2[0] = j61.b(context, R.style.h0);
            iArr[1] = j61.e;
            iArr2[1] = j61.c(context, R.style.g4);
            iArr[2] = j61.f;
            iArr2[2] = j61.c(context, R.style.h0);
        } else {
            int[] iArr3 = j61.b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
            iArr[1] = j61.e;
            iArr2[1] = j61.c(context, R.style.g4);
            iArr[2] = j61.f;
            iArr2[2] = colorStateListD.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* JADX WARN: Code duplicated, block: B:198:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:200:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:203:0x04e3 A[LOOP:9: B:199:0x04d6->B:203:0x04e3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:207:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:209:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:212:0x0509  */
    /* JADX WARN: Code duplicated, block: B:216:0x0525  */
    /* JADX WARN: Code duplicated, block: B:220:0x0532  */
    /* JADX WARN: Code duplicated, block: B:226:0x0551  */
    /* JADX WARN: Code duplicated, block: B:229:0x057e  */
    /* JADX WARN: Code duplicated, block: B:232:0x058e  */
    /* JADX WARN: Code duplicated, block: B:235:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:238:0x05b0  */
    /* JADX WARN: Code duplicated, block: B:244:0x0606  */
    /* JADX WARN: Code duplicated, block: B:247:0x061b  */
    /* JADX WARN: Code duplicated, block: B:250:0x062b  */
    /* JADX WARN: Code duplicated, block: B:251:0x0639  */
    /* JADX WARN: Code duplicated, block: B:254:0x0642  */
    /* JADX WARN: Code duplicated, block: B:257:0x065a  */
    /* JADX WARN: Code duplicated, block: B:259:0x0669  */
    /* JADX WARN: Code duplicated, block: B:262:0x0671  */
    /* JADX WARN: Code duplicated, block: B:264:0x0674 A[PHI: r12
      0x0674: PHI (r12v24 int) = (r12v23 int), (r12v25 int) binds: [B:263:0x0672, B:260:0x066e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:265:0x0677  */
    /* JADX WARN: Code duplicated, block: B:268:0x0680  */
    /* JADX WARN: Code duplicated, block: B:270:0x0690  */
    /* JADX WARN: Code duplicated, block: B:272:0x069e  */
    /* JADX WARN: Code duplicated, block: B:273:0x06a0  */
    /* JADX WARN: Code duplicated, block: B:276:0x06af  */
    /* JADX WARN: Code duplicated, block: B:279:0x06c0  */
    /* JADX WARN: Code duplicated, block: B:281:0x06d2  */
    /* JADX WARN: Code duplicated, block: B:284:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:287:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:290:0x06fc  */
    /* JADX WARN: Code duplicated, block: B:293:0x0706  */
    /* JADX WARN: Code duplicated, block: B:296:0x0710  */
    /* JADX WARN: Code duplicated, block: B:299:0x071b  */
    /* JADX WARN: Code duplicated, block: B:301:0x0729  */
    /* JADX WARN: Code duplicated, block: B:304:0x073a  */
    /* JADX WARN: Code duplicated, block: B:307:0x074a  */
    /* JADX WARN: Code duplicated, block: B:309:0x075f  */
    /* JADX WARN: Code duplicated, block: B:310:0x0762  */
    /* JADX WARN: Code duplicated, block: B:313:0x0770 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:314:0x0772  */
    /* JADX WARN: Code duplicated, block: B:315:0x0774  */
    /* JADX WARN: Code duplicated, block: B:317:0x0778  */
    /* JADX WARN: Code duplicated, block: B:318:0x077b  */
    /* JADX WARN: Code duplicated, block: B:323:0x0787  */
    /* JADX WARN: Code duplicated, block: B:325:0x0793  */
    /* JADX WARN: Code duplicated, block: B:328:0x07ab  */
    /* JADX WARN: Code duplicated, block: B:329:0x07b2  */
    /* JADX WARN: Code duplicated, block: B:332:0x07bb  */
    /* JADX WARN: Code duplicated, block: B:334:0x07c9  */
    /* JADX WARN: Code duplicated, block: B:335:0x07cc  */
    /* JADX WARN: Code duplicated, block: B:336:0x07ce  */
    /* JADX WARN: Code duplicated, block: B:347:0x080c  */
    /* JADX WARN: Code duplicated, block: B:361:0x0862  */
    /* JADX WARN: Code duplicated, block: B:370:0x0890  */
    /* JADX WARN: Code duplicated, block: B:373:0x08a3  */
    /* JADX WARN: Code duplicated, block: B:375:0x08d2 A[LOOP:13: B:371:0x089d->B:375:0x08d2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:380:0x08ec  */
    /* JADX WARN: Code duplicated, block: B:383:0x08f6  */
    /* JADX WARN: Code duplicated, block: B:385:0x0904  */
    /* JADX WARN: Code duplicated, block: B:386:0x0906  */
    /* JADX WARN: Code duplicated, block: B:388:0x090e  */
    /* JADX WARN: Code duplicated, block: B:391:0x0915  */
    /* JADX WARN: Code duplicated, block: B:393:0x091b  */
    /* JADX WARN: Code duplicated, block: B:394:0x091f  */
    /* JADX WARN: Code duplicated, block: B:397:0x0925  */
    /* JADX WARN: Code duplicated, block: B:402:0x0943  */
    /* JADX WARN: Code duplicated, block: B:415:0x097e  */
    /* JADX WARN: Code duplicated, block: B:417:0x0986 A[LOOP:16: B:414:0x097c->B:417:0x0986, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:422:0x099f A[LOOP:17: B:421:0x099d->B:422:0x099f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:426:0x09b6  */
    /* JADX WARN: Code duplicated, block: B:429:0x09c6  */
    /* JADX WARN: Code duplicated, block: B:433:0x09d6  */
    /* JADX WARN: Code duplicated, block: B:436:0x09f0 A[LOOP:20: B:434:0x09ea->B:436:0x09f0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:440:0x0a12  */
    /* JADX WARN: Code duplicated, block: B:475:0x04e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:477:0x0544 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:479:0x052c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:482:0x05e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:483:0x05c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:489:0x08da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:493:0x095f A[EDGE_INSN: B:493:0x095f->B:408:0x095f BREAK  A[LOOP:15: B:400:0x093c->B:407:0x095c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:497:0x0989 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:502:0x09d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:504:0x09c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x02be  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v175 */
    /* JADX WARN: Type inference failed for: r3v176, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v177 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean, int] */
    public gf1 c() {
        boolean z;
        boolean z2;
        int i;
        Object obj;
        Vector vectorE;
        int i2;
        int i3;
        Vector vectorE2;
        Vector vectorE3;
        int i4;
        Vector vectorE4;
        Vector vectorE5;
        Vector<Vector> vectorD;
        boolean z3;
        Vector vectorE6;
        Vector vectorE7;
        Vector vectorE8;
        int i5;
        Vector vectorE9;
        Vector vectorE10;
        Vector vectorE11;
        int i6;
        Vector vectorE12;
        Vector vectorE13;
        Vector vectorE14;
        Vector vectorE15;
        Vector vectorE16;
        Vector vectorD2;
        Vector vectorE17;
        int i7;
        Vector vectorE18;
        int i8;
        Vector vectorE19;
        int i9;
        ko0 ko0VarJ;
        Vector vectorD3;
        Vector vectorE20;
        String[] strArr;
        int i10;
        HashMap map;
        Vector vector;
        int i11;
        int i12;
        Iterator it;
        boolean z4;
        Iterator it2;
        Iterator it3;
        Vector vector2;
        String str;
        boolean z5;
        int i13;
        Iterator it4;
        int i14;
        lg[] lgVarArr;
        String strJoin;
        int i15;
        String[] strArrSplit;
        String lowerCase;
        Iterator it5;
        String str2;
        String[] strArr2;
        int i16;
        boolean z6;
        gf1 gf1Var = new gf1();
        int i17 = 2;
        gf1Var.b = 2;
        gf1Var.f = AppConfig.CUSTOM;
        gf1Var.n = false;
        gf1Var.p = false;
        gf1Var.q = "9.9.9.9";
        gf1Var.r = "2620:fe::fe";
        gf1Var.t = false;
        gf1Var.u = "blinkt.de";
        gf1Var.v = true;
        gf1Var.w = true;
        gf1Var.y = true;
        gf1Var.z = false;
        gf1Var.A = AppConfig.CUSTOM;
        gf1Var.B = false;
        gf1Var.C = false;
        gf1Var.D = false;
        gf1Var.E = false;
        gf1Var.F = AppConfig.CUSTOM;
        gf1Var.G = AppConfig.CUSTOM;
        gf1Var.H = true;
        gf1Var.I = true;
        gf1Var.J = AppConfig.CUSTOM;
        gf1Var.K = false;
        gf1Var.L = "-1";
        gf1Var.M = "2";
        gf1Var.N = "300";
        gf1Var.O = AppConfig.CUSTOM;
        int i18 = 3;
        gf1Var.P = 3;
        gf1Var.Q = null;
        gf1Var.S = 0;
        gf1Var.T = new lg[0];
        gf1Var.U = false;
        gf1Var.V = new HashSet();
        gf1Var.X = 0;
        gf1Var.Z = false;
        gf1Var.a0 = "openvpn.example.com";
        gf1Var.b0 = AppConfig.CUSTOM;
        gf1Var.c0 = false;
        gf1Var.d0 = AppConfig.CUSTOM;
        gf1Var.e0 = 0;
        gf1Var.f0 = false;
        gf1Var.g0 = AppConfig.CUSTOM;
        gf1Var.h0 = UUID.randomUUID();
        gf1Var.c = "converted Profile";
        gf1Var.T = new lg[]{new lg()};
        System.currentTimeMillis();
        gf1Var.a0 = "unknown";
        gf1Var.w = false;
        gf1Var.n = false;
        gf1Var.v = false;
        gf1Var.I = false;
        gf1Var.z = false;
        gf1Var.y = false;
        gf1Var.K = false;
        gf1Var.Z = false;
        gf1Var.S = 0;
        gf1Var.H = false;
        HashMap map2 = (HashMap) this.e;
        if (map2.containsKey("client") || map2.containsKey("pull")) {
            gf1Var.w = true;
            map2.remove("pull");
            map2.remove("client");
        }
        Vector vectorE21 = e(1, 2, "secret");
        if (vectorE21 != null) {
            gf1Var.b = 4;
            gf1Var.p = true;
            gf1Var.g = (String) vectorE21.get(1);
            if (vectorE21.size() == 3) {
                gf1Var.f = (String) vectorE21.get(2);
            }
            z = false;
        } else {
            z = true;
        }
        Vector<Vector> vectorD4 = d(1, 4, "route");
        if (vectorD4 != null) {
            String string = AppConfig.CUSTOM;
            String string2 = string;
            for (Vector vector3 : vectorD4) {
                String str3 = vector3.size() >= i18 ? (String) vector3.get(i17) : "255.255.255.255";
                boolean z7 = z;
                String str4 = vector3.size() >= 4 ? (String) vector3.get(i18) : "vpn_gateway";
                String str5 = (String) vector3.get(1);
                try {
                    long jA = ha.a(str3) + 4294967296L;
                    int i19 = 0;
                    while ((jA & 1) == 0) {
                        i19++;
                        jA >>= 1;
                    }
                    int i20 = jA != (8589934591 >> i19) ? 32 : 32 - i19;
                    if (str4.equals("net_gateway")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(string);
                        Locale locale = Locale.ENGLISH;
                        sb.append(str5 + InternalZipConstants.ZIP_FILE_SEPARATOR + i20);
                        sb.append(" ");
                        string = sb.toString();
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(string2);
                        Locale locale2 = Locale.ENGLISH;
                        sb2.append(str5 + InternalZipConstants.ZIP_FILE_SEPARATOR + i20);
                        sb2.append(" ");
                        string2 = sb2.toString();
                    }
                    z = z7;
                    i17 = 2;
                    i18 = 3;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new a(ak.m("Could not parse netmask of route ", str3));
                } catch (NumberFormatException unused2) {
                    throw new a(ak.m("Could not parse netmask of route ", str3));
                }
            }
            z2 = z;
            gf1Var.x = string2;
            gf1Var.R = string;
        } else {
            z2 = z;
        }
        ?? r3 = 1;
        Vector vectorD5 = d(1, 4, "route-ipv6");
        if (vectorD5 != null) {
            Iterator it6 = vectorD5.iterator();
            String strM = AppConfig.CUSTOM;
            while (it6.hasNext()) {
                strM = fb$1.m(e.d(strM), (String) ((Vector) it6.next()).get(1), " ");
            }
            gf1Var.J = strM;
        }
        if (e(0, 0, "route-nopull") != null) {
            gf1Var.B = true;
        }
        Vector<Vector> vectorD6 = d(1, 2, "tls-auth");
        if (vectorD6 != null) {
            for (Vector vector4 : vectorD6) {
                if (vector4 != 0) {
                    if (!((String) vector4.get(r3)).equals("[inline]")) {
                        gf1Var.g = (String) vector4.get(r3);
                        gf1Var.p = r3;
                    }
                    if (vector4.size() == 3) {
                        gf1Var.f = (String) vector4.get(2);
                    }
                }
                r3 = 1;
            }
        }
        ?? r4 = 1;
        Vector vectorE22 = e(1, 1, "key-direction");
        if (vectorE22 != null) {
            gf1Var.f = (String) vectorE22.get(1);
        }
        String[] strArr3 = {"tls-crypt", "tls-crypt-v2"};
        int i21 = 0;
        while (i21 < 2) {
            String str6 = strArr3[i21];
            Vector vectorE23 = e(r4, r4, str6);
            if (vectorE23 != 0) {
                gf1Var.p = r4;
                gf1Var.g = (String) vectorE23.get(r4);
                gf1Var.f = str6;
            }
            i21++;
            r4 = 1;
        }
        int i22 = 7;
        Vector<Vector> vectorD7 = d(0, 7, "redirect-gateway");
        if (vectorD7 != null) {
            boolean z8 = false;
            for (Vector vector5 : vectorD7) {
                for (int i23 = 1; i23 < vector5.size(); i23++) {
                    if (((String) vector5.get(i23)).equals("block-local") || ((String) vector5.get(i23)).equals("unblock-local")) {
                        z6 = z8;
                        z8 = z6;
                    } else if (((String) vector5.get(i23)).equals("!ipv4")) {
                        z6 = true;
                        z8 = z6;
                    } else if (((String) vector5.get(i23)).equals("ipv6")) {
                        gf1Var.I = true;
                    } else {
                        z6 = z8;
                        z8 = z6;
                    }
                }
            }
            i = 1;
            if (!z8) {
                gf1Var.v = true;
            }
        } else {
            i = 1;
        }
        d(0, 5, "redirect-private");
        Vector vectorE24 = e(i, i, "dev");
        Vector vectorE25 = e(i, i, "dev-type");
        if ((vectorE25 == null || !((String) vectorE25.get(i)).equals("tun")) && ((vectorE24 == null || !((String) vectorE24.get(i)).startsWith("tun")) && !(vectorE25 == null && vectorE24 == null))) {
            throw new a("Sorry. Only tun mode is supported. See the FAQ for more detail");
        }
        Vector vectorE26 = e(0, 2, "mssfix");
        if (vectorE26 != null) {
            if (vectorE26.size() >= 2) {
                try {
                    gf1Var.S = Integer.parseInt((String) vectorE26.get(1));
                } catch (NumberFormatException unused3) {
                    throw new a("Argument to --mssfix has to be an integer");
                }
            } else {
                gf1Var.S = 1450;
            }
            if (vectorE26.size() >= 3 && !((String) vectorE26.get(2)).equals("mtu")) {
                throw new a("Second argument to --mssfix unkonwn");
            }
        }
        Vector vectorE27 = e(1, 1, "tun-mtu");
        if (vectorE27 != null) {
            try {
                gf1Var.Y = Integer.parseInt((String) vectorE27.get(1));
            } catch (NumberFormatException unused4) {
                throw new a("Argument to --tun-mtu has to be an integer");
            }
        }
        Vector vectorE28 = e(1, 1, PluginContract.COLUMN_MODE);
        if (vectorE28 != null && !((String) vectorE28.get(1)).equals("p2p")) {
            throw new a("Invalid mode for --mode specified, need p2p");
        }
        int i24 = 2;
        Vector<Vector> vectorD8 = d(2, 2, "dhcp-option");
        if (vectorD8 != null) {
            for (Vector vector6 : vectorD8) {
                String str7 = (String) vector6.get(1);
                String str8 = (String) vector6.get(i24);
                if (str7.equals("DOMAIN")) {
                    gf1Var.u = (String) vector6.get(i24);
                } else if (str7.equals("DNS")) {
                    gf1Var.t = true;
                    if (gf1Var.q.equals("9.9.9.9")) {
                        gf1Var.q = str8;
                        gf1Var.r = AppConfig.CUSTOM;
                    } else {
                        gf1Var.r = str8;
                    }
                }
                i24 = 2;
            }
        }
        Vector vectorE29 = e(2, 2, "ifconfig");
        if (vectorE29 != null) {
            try {
                String str9 = (String) vectorE29.get(1);
                long jA2 = ha.a((String) vectorE29.get(2)) + 4294967296L;
                int i25 = 0;
                while ((jA2 & 1) == 0) {
                    i25++;
                    jA2 >>= 1;
                }
                int i26 = jA2 != (8589934591 >> i25) ? 32 : 32 - i25;
                Locale locale3 = Locale.ENGLISH;
                gf1Var.s = str9 + InternalZipConstants.ZIP_FILE_SEPARATOR + i26;
            } catch (NumberFormatException e) {
                throw new a(ak.AnonymousClass0.m("Could not pase ifconfig IP address: ", e.getLocalizedMessage()));
            }
        }
        if (e(0, 0, "remote-random-hostname") != null) {
            gf1Var.C = true;
        }
        if (e(0, 0, "float") != null) {
            gf1Var.D = true;
        }
        if (e(0, 1, "comp-lzo") != null) {
            gf1Var.n = true;
        }
        Vector vectorE30 = e(1, 1, "ncp-ciphers");
        Vector vectorE31 = e(1, 1, "data-ciphers");
        Vector vectorE32 = e(1, 1, "cipher");
        if (vectorE32 != null) {
            gf1Var.G = (String) vectorE32.get(1);
        }
        if (vectorE31 == null) {
            if (vectorE30 != null) {
                obj = vectorE30.get(1);
            }
            vectorE = e(1, 1, "tls-cert-profile");
            if (vectorE != null) {
                str2 = (String) vectorE.get(1);
                strArr2 = new String[]{"insecure", "preferred", "legacy", "suiteb"};
                i2 = 4;
                for (i16 = 0; i16 < 4; i16++) {
                    if (strArr2[i16].equals(str2)) {
                        gf1Var.g0 = str2;
                        break;
                    }
                }
                if (!str2.equals(gf1Var.g0)) {
                    throw new a(e.n("Invalid tls-cert-profile '", str2, "'"));
                }
            } else {
                i2 = 4;
            }
            i3 = 1;
            vectorE2 = e(1, 9, "provider");
            if (vectorE2 != null) {
                lowerCase = ((String) vectorE2.get(1)).toLowerCase(Locale.ROOT);
                if (lowerCase.equals("legacy:default") || lowerCase.equals("default:legacy")) {
                    gf1Var.f0 = true;
                }
                it5 = vectorE2.iterator();
                while (it5.hasNext()) {
                    if ("legacy".equals(((String) it5.next()).toLowerCase(Locale.ROOT))) {
                        gf1Var.f0 = true;
                    }
                }
                i3 = 1;
            }
            vectorE3 = e(i3, i3, "compat-mode");
            if (vectorE3 != null) {
                Scanner scanner = new Scanner((String) vectorE3.get(i3));
                scanner.useDelimiter("\\.");
                gf1Var.e0 = (scanner.nextInt() * 100) + (scanner.nextInt() * 10000) + scanner.nextInt();
            }
            i4 = 1;
            vectorE4 = e(1, 1, "auth");
            if (vectorE4 != null) {
                gf1Var.O = (String) vectorE4.get(1);
            }
            vectorE5 = e(1, 1, "ca");
            if (vectorE5 != null) {
                gf1Var.j = (String) vectorE5.get(1);
            }
            vectorD = d(1, 1, "peer-fingerprint");
            if (vectorD != null) {
                gf1Var.c0 = true;
                for (Vector vector7 : vectorD) {
                    if (((String) vector7.get(i4)).startsWith("[[INLINE]]")) {
                        gf1Var.d0 += ((String) vector7.get(i4)).substring(10) + "\n";
                        i4 = 1;
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(gf1Var.d0);
                        gf1Var.d0 = fb$1.m(sb3, (String) vector7.get(1), "\n");
                        i4 = 1;
                    }
                }
            }
            z3 = i4;
            vectorE6 = e(z3 ? 1 : 0, z3 ? 1 : 0, "cert");
            if (vectorE6 != null) {
                gf1Var.d = (String) vectorE6.get(z3 ? 1 : 0);
                gf1Var.b = 0;
                z2 = false;
            }
            vectorE7 = e(z3 ? 1 : 0, z3 ? 1 : 0, "key");
            if (vectorE7 != null) {
                gf1Var.i = (String) vectorE7.get(z3 ? 1 : 0);
            }
            vectorE8 = e(z3 ? 1 : 0, z3 ? 1 : 0, "pkcs12");
            if (vectorE8 != null) {
                gf1Var.o = (String) vectorE8.get(z3 ? 1 : 0);
                i5 = 2;
                gf1Var.b = 2;
                z2 = false;
            } else {
                i5 = 2;
            }
            if (e(z3 ? 1 : 0, z3 ? 1 : 0, "cryptoapicert") != null) {
                gf1Var.b = i5;
                z2 = false;
            }
            vectorE9 = e(z3 ? 1 : 0, i5, "compat-names");
            vectorE10 = e(z3 ? 1 : 0, z3 ? 1 : 0, "no-name-remapping");
            vectorE11 = e(z3 ? 1 : 0, z3 ? 1 : 0, "tls-remote");
            if (vectorE11 != null) {
                gf1Var.A = (String) vectorE11.get(z3 ? 1 : 0);
                gf1Var.y = z3;
                gf1Var.P = 0;
                if (vectorE9 != null) {
                    i6 = 2;
                    if (vectorE9.size() <= 2) {
                        gf1Var.P = z3 ? 1 : 0;
                    }
                } else {
                    i6 = 2;
                }
                if (vectorE10 != null) {
                    gf1Var.P = z3 ? 1 : 0;
                }
            } else {
                i6 = 2;
            }
            vectorE12 = e(z3 ? 1 : 0, i6, "verify-x509-name");
            if (vectorE12 != null) {
                gf1Var.A = (String) vectorE12.get(z3 ? 1 : 0);
                gf1Var.y = z3;
                if (vectorE12.size() <= i6) {
                    gf1Var.P = i6;
                } else {
                    if (((String) vectorE12.get(i6)).equals(XMLRPC.TAG_NAME)) {
                        i2 = 3;
                    } else if (((String) vectorE12.get(i6)).equals("subject")) {
                        gf1Var.P = i6;
                    } else if (!((String) vectorE12.get(i6)).equals("name-prefix")) {
                        throw new a(ak.AnonymousClass0.m("Unknown parameter to verify-x509-name: ", (String) vectorE12.get(i6)));
                    }
                    gf1Var.P = i2;
                }
            }
            vectorE13 = e(1, 1, "x509-username-field");
            if (vectorE13 != null) {
                gf1Var.Q = (String) vectorE13.get(1);
            }
            vectorE14 = e(1, 1, "verb");
            if (vectorE14 != null) {
            }
            if (e(0, 0, "nobind") != null) {
                gf1Var.H = true;
            }
            if (e(0, 0, "persist-tun") != null) {
                gf1Var.K = true;
            }
            if (e(0, 0, "push-peer-info") != null) {
                gf1Var.Z = true;
            }
            vectorE15 = e(1, 2, "connect-retry");
            if (vectorE15 != null) {
                gf1Var.M = (String) vectorE15.get(1);
                if (vectorE15.size() > 2) {
                    gf1Var.N = (String) vectorE15.get(2);
                }
            }
            vectorE16 = e(1, 1, "connect-retry-max");
            if (vectorE16 != null) {
                gf1Var.L = (String) vectorE16.get(1);
            }
            vectorD2 = d(1, 1, "remote-cert-tls");
            if (vectorD2 != null) {
                if (((String) ((Vector) vectorD2.get(0)).get(1)).equals("server")) {
                    gf1Var.z = true;
                } else {
                    map2.put("remotetls", vectorD2);
                }
            }
            vectorE17 = e(0, 1, "auth-user-pass");
            if (vectorE17 != null) {
                if (z2) {
                    i22 = 3;
                } else {
                    i15 = gf1Var.b;
                    if (i15 == 0) {
                        gf1Var.b = 5;
                    } else if (i15 == 2) {
                    }
                    i7 = 1;
                    if (vectorE17.size() > 1) {
                        if (!((String) vectorE17.get(1)).startsWith("[[INLINE]]")) {
                        }
                        strArrSplit = gf1.e((String) vectorE17.get(1)).split("\n");
                        if (strArrSplit.length >= 2) {
                            String str10 = strArrSplit[0];
                            String str11 = strArrSplit[1];
                        }
                    }
                }
                gf1Var.b = i22;
                i7 = 1;
                if (vectorE17.size() > 1) {
                    if (!((String) vectorE17.get(1)).startsWith("[[INLINE]]")) {
                    }
                    strArrSplit = gf1.e((String) vectorE17.get(1)).split("\n");
                    if (strArrSplit.length >= 2) {
                        String str12 = strArrSplit[0];
                        String str13 = strArrSplit[1];
                    }
                }
            } else {
                i7 = 1;
            }
            vectorE18 = e(i7, i7, "auth-retry");
            if (vectorE18 == null) {
                i8 = 2;
            } else if (((String) vectorE18.get(i7)).equals("none")) {
                gf1Var.X = 0;
                i8 = 2;
            } else {
                if (!((String) vectorE18.get(i7)).equals("nointeract") && !((String) vectorE18.get(i7)).equals("interact")) {
                    throw new a(ak.AnonymousClass0.m("Unknown parameter to auth-retry: ", (String) vectorE18.get(2)));
                }
                i8 = 2;
                gf1Var.X = 2;
            }
            vectorE19 = e(1, i8, "crl-verify");
            if (vectorE19 == null) {
                i9 = 1;
            } else if (vectorE19.size() == 3 || !((String) vectorE19.get(i8)).equals("dir")) {
                i9 = 1;
                gf1Var.W = (String) vectorE19.get(1);
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(gf1Var.F);
                if (Build.VERSION.SDK_INT > 26) {
                    StringBuilder sb5 = new StringBuilder();
                    Iterator it7 = vectorE19.iterator();
                    if (it7.hasNext()) {
                        while (true) {
                            sb5.append((CharSequence) it7.next());
                            if (!it7.hasNext()) {
                                break;
                            }
                            sb5.append((CharSequence) " ");
                        }
                    }
                    strJoin = sb5.toString();
                } else {
                    strJoin = TextUtils.join(" ", vectorE19);
                }
                gf1Var.F = fb$1.m(sb4, strJoin, "\n");
                i9 = 1;
            }
            ko0VarJ = j(null);
            gf1Var.T = (lg[]) ko0VarJ.b;
            vectorD3 = d(i9, i9, "connection");
            if (gf1Var.T.length <= 0 && vectorD3 != null) {
                throw new a("Using a <connection> block and --remote is not allowed.");
            }
            if (vectorD3 != null) {
                gf1Var.T = new lg[vectorD3.size()];
                it4 = vectorD3.iterator();
                i14 = 0;
                while (it4.hasNext()) {
                    String str14 = (String) ((Vector) it4.next()).get(1);
                    lg lgVar = (lg) ko0VarJ.a;
                    hg hgVar = new hg(0);
                    hgVar.i(new StringReader(str14.substring(10)));
                    lgVarArr = (lg[]) hgVar.j(lgVar).b;
                    if (lgVarArr.length == 1) {
                        throw new a("A <connection> block must have exactly one remote");
                    }
                    gf1Var.T[i14] = lgVarArr[0];
                    i14++;
                }
            }
            if (e(0, 0, "remote-random") != null) {
                gf1Var.U = true;
            }
            vectorE20 = e(1, 1, "proto-force");
            if (vectorE20 != null) {
                str = (String) vectorE20.get(1);
                if (str.equals("udp")) {
                    z5 = true;
                } else {
                    if (str.equals(AppConfig.DEFAULT_NETWORK)) {
                        throw new a(ak.AnonymousClass0.m("Unknown protocol ", str, " in proto-force"));
                    }
                    z5 = false;
                }
                for (lg lgVar2 : gf1Var.T) {
                    if (lgVar2.d == z5) {
                        lgVar2.i = false;
                    }
                }
            }
            strArr = new String[]{"PROFILE", "FRIENDLY_NAME"};
            i10 = 0;
            while (true) {
                map = (HashMap) this.f;
                if (i10 < 2) {
                    break;
                }
                vector2 = (Vector) map.get(strArr[i10]);
                if (vector2 == null && vector2.size() > 1) {
                    gf1Var.c = (String) vector2.get(1);
                }
                i10++;
            }
            vector = (Vector) map.get("USERNAME");
            if (vector != null && vector.size() > 1) {
            }
            for (String str15 : (String[]) this.a) {
                if (!map2.containsKey(str15)) {
                    throw new a(ak.AnonymousClass0.m("Unsupported Option ", str15, " encountered in config file. Aborting"));
                }
            }
            for (Object obj2 : (String[]) this.b) {
                map2.remove(obj2);
            }
            it = map2.values().iterator();
            z4 = false;
            while (it.hasNext()) {
                it3 = ((Vector) it.next()).iterator();
                while (it3.hasNext()) {
                    if (!g((Vector) it3.next())) {
                        z4 = true;
                    }
                }
            }
            if (z4) {
                gf1Var.F = "# These options found in the config file do not map to config settings:\n".concat(gf1Var.F);
                it2 = map2.values().iterator();
                while (it2.hasNext()) {
                    gf1Var.F = gf1Var.F.concat(f((Vector) it2.next()));
                }
                gf1Var.E = true;
            }
            if (gf1Var.A.equals(gf1Var.a0)) {
                gf1Var.A = AppConfig.CUSTOM;
            }
            return gf1Var;
        }
        obj = vectorE31.get(1);
        gf1Var.b0 = (String) obj;
        vectorE = e(1, 1, "tls-cert-profile");
        if (vectorE != null) {
            str2 = (String) vectorE.get(1);
            strArr2 = new String[]{"insecure", "preferred", "legacy", "suiteb"};
            i2 = 4;
            while (i16 < 4) {
                if (strArr2[i16].equals(str2)) {
                    gf1Var.g0 = str2;
                    break;
                }
            }
            if (!str2.equals(gf1Var.g0)) {
                throw new a(e.n("Invalid tls-cert-profile '", str2, "'"));
            }
        } else {
            i2 = 4;
        }
        i3 = 1;
        vectorE2 = e(1, 9, "provider");
        if (vectorE2 != null) {
            lowerCase = ((String) vectorE2.get(1)).toLowerCase(Locale.ROOT);
            if (lowerCase.equals("legacy:default")) {
                gf1Var.f0 = true;
            } else {
                gf1Var.f0 = true;
            }
            it5 = vectorE2.iterator();
            while (it5.hasNext()) {
                if ("legacy".equals(((String) it5.next()).toLowerCase(Locale.ROOT))) {
                    gf1Var.f0 = true;
                }
            }
            i3 = 1;
        }
        vectorE3 = e(i3, i3, "compat-mode");
        if (vectorE3 != null) {
            Scanner scanner2 = new Scanner((String) vectorE3.get(i3));
            scanner2.useDelimiter("\\.");
            gf1Var.e0 = (scanner2.nextInt() * 100) + (scanner2.nextInt() * 10000) + scanner2.nextInt();
        }
        i4 = 1;
        vectorE4 = e(1, 1, "auth");
        if (vectorE4 != null) {
            gf1Var.O = (String) vectorE4.get(1);
        }
        vectorE5 = e(1, 1, "ca");
        if (vectorE5 != null) {
            gf1Var.j = (String) vectorE5.get(1);
        }
        vectorD = d(1, 1, "peer-fingerprint");
        if (vectorD != null) {
            gf1Var.c0 = true;
            while (r3.hasNext()) {
                if (((String) vector7.get(i4)).startsWith("[[INLINE]]")) {
                    gf1Var.d0 += ((String) vector7.get(i4)).substring(10) + "\n";
                    i4 = 1;
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(gf1Var.d0);
                    gf1Var.d0 = fb$1.m(sb6, (String) vector7.get(1), "\n");
                    i4 = 1;
                }
            }
        }
        z3 = i4;
        vectorE6 = e(z3 ? 1 : 0, z3 ? 1 : 0, "cert");
        if (vectorE6 != null) {
            gf1Var.d = (String) vectorE6.get(z3 ? 1 : 0);
            gf1Var.b = 0;
            z2 = false;
        }
        vectorE7 = e(z3 ? 1 : 0, z3 ? 1 : 0, "key");
        if (vectorE7 != null) {
            gf1Var.i = (String) vectorE7.get(z3 ? 1 : 0);
        }
        vectorE8 = e(z3 ? 1 : 0, z3 ? 1 : 0, "pkcs12");
        if (vectorE8 != null) {
            gf1Var.o = (String) vectorE8.get(z3 ? 1 : 0);
            i5 = 2;
            gf1Var.b = 2;
            z2 = false;
        } else {
            i5 = 2;
        }
        if (e(z3 ? 1 : 0, z3 ? 1 : 0, "cryptoapicert") != null) {
            gf1Var.b = i5;
            z2 = false;
        }
        vectorE9 = e(z3 ? 1 : 0, i5, "compat-names");
        vectorE10 = e(z3 ? 1 : 0, z3 ? 1 : 0, "no-name-remapping");
        vectorE11 = e(z3 ? 1 : 0, z3 ? 1 : 0, "tls-remote");
        if (vectorE11 != null) {
            gf1Var.A = (String) vectorE11.get(z3 ? 1 : 0);
            gf1Var.y = z3;
            gf1Var.P = 0;
            if (vectorE9 != null) {
                i6 = 2;
                if (vectorE9.size() <= 2) {
                    gf1Var.P = z3 ? 1 : 0;
                }
            } else {
                i6 = 2;
            }
            if (vectorE10 != null) {
                gf1Var.P = z3 ? 1 : 0;
            }
        } else {
            i6 = 2;
        }
        vectorE12 = e(z3 ? 1 : 0, i6, "verify-x509-name");
        if (vectorE12 != null) {
            gf1Var.A = (String) vectorE12.get(z3 ? 1 : 0);
            gf1Var.y = z3;
            if (vectorE12.size() <= i6) {
                gf1Var.P = i6;
            } else {
                if (((String) vectorE12.get(i6)).equals(XMLRPC.TAG_NAME)) {
                    i2 = 3;
                } else if (((String) vectorE12.get(i6)).equals("subject")) {
                    gf1Var.P = i6;
                } else if (!((String) vectorE12.get(i6)).equals("name-prefix")) {
                    throw new a(ak.AnonymousClass0.m("Unknown parameter to verify-x509-name: ", (String) vectorE12.get(i6)));
                }
                gf1Var.P = i2;
            }
        }
        vectorE13 = e(1, 1, "x509-username-field");
        if (vectorE13 != null) {
            gf1Var.Q = (String) vectorE13.get(1);
        }
        vectorE14 = e(1, 1, "verb");
        if (vectorE14 != null) {
        }
        if (e(0, 0, "nobind") != null) {
            gf1Var.H = true;
        }
        if (e(0, 0, "persist-tun") != null) {
            gf1Var.K = true;
        }
        if (e(0, 0, "push-peer-info") != null) {
            gf1Var.Z = true;
        }
        vectorE15 = e(1, 2, "connect-retry");
        if (vectorE15 != null) {
            gf1Var.M = (String) vectorE15.get(1);
            if (vectorE15.size() > 2) {
                gf1Var.N = (String) vectorE15.get(2);
            }
        }
        vectorE16 = e(1, 1, "connect-retry-max");
        if (vectorE16 != null) {
            gf1Var.L = (String) vectorE16.get(1);
        }
        vectorD2 = d(1, 1, "remote-cert-tls");
        if (vectorD2 != null) {
            if (((String) ((Vector) vectorD2.get(0)).get(1)).equals("server")) {
                gf1Var.z = true;
            } else {
                map2.put("remotetls", vectorD2);
            }
        }
        vectorE17 = e(0, 1, "auth-user-pass");
        if (vectorE17 != null) {
            if (z2) {
                i22 = 3;
            } else {
                i15 = gf1Var.b;
                if (i15 == 0) {
                    gf1Var.b = 5;
                } else if (i15 == 2) {
                }
                i7 = 1;
                if (vectorE17.size() > 1) {
                    if (!((String) vectorE17.get(1)).startsWith("[[INLINE]]")) {
                    }
                    strArrSplit = gf1.e((String) vectorE17.get(1)).split("\n");
                    if (strArrSplit.length >= 2) {
                        String str16 = strArrSplit[0];
                        String str17 = strArrSplit[1];
                    }
                }
            }
            gf1Var.b = i22;
            i7 = 1;
            if (vectorE17.size() > 1) {
                if (!((String) vectorE17.get(1)).startsWith("[[INLINE]]")) {
                }
                strArrSplit = gf1.e((String) vectorE17.get(1)).split("\n");
                if (strArrSplit.length >= 2) {
                    String str18 = strArrSplit[0];
                    String str19 = strArrSplit[1];
                }
            }
        } else {
            i7 = 1;
        }
        vectorE18 = e(i7, i7, "auth-retry");
        if (vectorE18 == null) {
            i8 = 2;
        } else if (((String) vectorE18.get(i7)).equals("none")) {
            gf1Var.X = 0;
            i8 = 2;
        } else {
            if (!((String) vectorE18.get(i7)).equals("nointeract")) {
                throw new a(ak.AnonymousClass0.m("Unknown parameter to auth-retry: ", (String) vectorE18.get(2)));
            }
            i8 = 2;
            gf1Var.X = 2;
        }
        vectorE19 = e(1, i8, "crl-verify");
        if (vectorE19 == null) {
            i9 = 1;
        } else {
            if (vectorE19.size() == 3) {
            }
            i9 = 1;
            gf1Var.W = (String) vectorE19.get(1);
        }
        ko0VarJ = j(null);
        gf1Var.T = (lg[]) ko0VarJ.b;
        vectorD3 = d(i9, i9, "connection");
        if (gf1Var.T.length <= 0) {
        }
        if (vectorD3 != null) {
            gf1Var.T = new lg[vectorD3.size()];
            it4 = vectorD3.iterator();
            i14 = 0;
            while (it4.hasNext()) {
                String str110 = (String) ((Vector) it4.next()).get(1);
                lg lgVar3 = (lg) ko0VarJ.a;
                hg hgVar2 = new hg(0);
                hgVar2.i(new StringReader(str110.substring(10)));
                lgVarArr = (lg[]) hgVar2.j(lgVar3).b;
                if (lgVarArr.length == 1) {
                    throw new a("A <connection> block must have exactly one remote");
                }
                gf1Var.T[i14] = lgVarArr[0];
                i14++;
            }
        }
        if (e(0, 0, "remote-random") != null) {
            gf1Var.U = true;
        }
        vectorE20 = e(1, 1, "proto-force");
        if (vectorE20 != null) {
            str = (String) vectorE20.get(1);
            if (str.equals("udp")) {
                z5 = true;
            } else {
                if (str.equals(AppConfig.DEFAULT_NETWORK)) {
                    throw new a(ak.AnonymousClass0.m("Unknown protocol ", str, " in proto-force"));
                }
                z5 = false;
            }
            while (i13 < r5) {
                if (lgVar2.d == z5) {
                    lgVar2.i = false;
                }
            }
        }
        strArr = new String[]{"PROFILE", "FRIENDLY_NAME"};
        i10 = 0;
        while (true) {
            map = (HashMap) this.f;
            if (i10 < 2) {
                break;
                break;
            }
            vector2 = (Vector) map.get(strArr[i10]);
            if (vector2 == null) {
            }
            i10++;
        }
        vector = (Vector) map.get("USERNAME");
        if (vector != null) {
        }
        while (i11 < r3) {
            if (!map2.containsKey(str15)) {
                throw new a(ak.AnonymousClass0.m("Unsupported Option ", str15, " encountered in config file. Aborting"));
            }
        }
        while (i12 < r3) {
            map2.remove(obj2);
        }
        it = map2.values().iterator();
        z4 = false;
        while (it.hasNext()) {
            it3 = ((Vector) it.next()).iterator();
            while (it3.hasNext()) {
                if (!g((Vector) it3.next())) {
                    z4 = true;
                }
            }
        }
        if (z4) {
            gf1Var.F = "# These options found in the config file do not map to config settings:\n".concat(gf1Var.F);
            it2 = map2.values().iterator();
            while (it2.hasNext()) {
                gf1Var.F = gf1Var.F.concat(f((Vector) it2.next()));
            }
            gf1Var.E = true;
        }
        if (gf1Var.A.equals(gf1Var.a0)) {
            gf1Var.A = AppConfig.CUSTOM;
        }
        return gf1Var;
    }

    @Override // defpackage.xb0$a
    public xb0$b c(ij0 ij0Var) {
        return new e91(this, ij0Var, (v8) this.a, (ai0) this.b, (dd) this.c, (List) this.d);
    }

    public Vector d(int i, int i2, String str) throws a {
        HashMap map = (HashMap) this.e;
        Vector<Vector> vector = (Vector) map.get(str);
        if (vector == null) {
            return null;
        }
        for (Vector vector2 : vector) {
            if (vector2.size() < i + 1 || vector2.size() > i2 + 1) {
                throw new a(String.format(Locale.getDefault(), "Option %s has %d parameters, expected between %d and %d", str, Integer.valueOf(vector2.size() - 1), Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }
        map.remove(str);
        return vector;
    }

    @Override // defpackage.xb0$a
    public void d(ij0 ij0Var, dd ddVar, ij0 ij0Var2) {
        ((HashMap) this.e).put(ij0Var, new kr(ddVar, ij0Var2));
    }

    public Vector e(int i, int i2, String str) throws a {
        Vector vectorD = d(i, i2, str);
        if (vectorD == null) {
            return null;
        }
        return (Vector) vectorD.lastElement();
    }

    @Override // defpackage.xb0$a
    public xb0$a e(dd ddVar, ij0 ij0Var) {
        ArrayList arrayList = new ArrayList();
        v8 v8Var = (v8) this.a;
        return new v8(new hg(v8Var, e4.c((ji0) v8Var.c, ddVar, (oo) v8Var.d), ddVar, arrayList, t11.a), this, ij0Var, arrayList);
    }

    public String f(Vector vector) {
        Iterator it = vector.iterator();
        String strJ = AppConfig.CUSTOM;
        while (it.hasNext()) {
            Vector<String> vector2 = (Vector) it.next();
            if (!g(vector2)) {
                if (vector2.size() == 2 && "extra-certs".equals(vector2.get(0))) {
                    StringBuilder sbD = e.d(strJ);
                    sbD.append(gf1.h((String) vector2.get(0), (String) vector2.get(1)));
                    strJ = sbD.toString();
                } else {
                    for (String str : vector2) {
                        StringBuilder sbD2 = e.d(strJ);
                        sbD2.append(gf1.i(str));
                        sbD2.append(" ");
                        strJ = sbD2.toString();
                    }
                    strJ = ak.j(strJ, "\n");
                }
            }
        }
        return strJ;
    }

    @Override // defpackage.xb0$a
    public void f(Object obj, ij0 ij0Var) {
        HashMap map = (HashMap) this.e;
        qg qgVarB = b2.b(obj);
        if (qgVarB == null) {
            qgVarB = new rr$a(e4.j("Unsupported annotation argument: ", ij0Var));
        }
        map.put(ij0Var, qgVarB);
    }

    public boolean g(Vector vector) {
        for (String[] strArr : (String[][]) this.c) {
            if (vector.size() >= strArr.length) {
                boolean z = true;
                for (int i = 0; i < strArr.length; i++) {
                    if (!strArr[i].equals(vector.get(i))) {
                        z = false;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public void i(Reader reader) {
        HashMap map = new HashMap();
        map.put("server-poll-timeout", "timeout-connect");
        BufferedReader bufferedReader = new BufferedReader(reader);
        int i = 0;
        while (true) {
            try {
                String line = bufferedReader.readLine();
                i++;
                if (line == null) {
                    return;
                }
                if (i == 1) {
                    if (line.startsWith("PK\u0003\u0004") || line.startsWith("PK\u0007\u00008")) {
                        throw new a("Input looks like a ZIP Archive. Import is only possible for OpenVPN config files (.ovpn/.conf)");
                    }
                    if (line.startsWith("\ufeff")) {
                        line = line.substring(1);
                    }
                }
                if (line.startsWith("# OVPN_ACCESS_SERVER_")) {
                    String[] strArrSplit = line.split("#\\sOVPN_ACCESS_SERVER_", 2)[1].split("=", 2);
                    Vector vector = new Vector();
                    Collections.addAll(vector, strArrSplit);
                    ((HashMap) this.f).put((String) vector.get(0), vector);
                } else {
                    Vector vectorK = k(line);
                    if (vectorK.size() != 0) {
                        if (((String) vectorK.get(0)).startsWith("--")) {
                            vectorK.set(0, ((String) vectorK.get(0)).substring(2));
                        }
                        b(vectorK, bufferedReader);
                        String str = (String) vectorK.get(0);
                        if (map.get(str) != null) {
                            str = (String) map.get(str);
                        }
                        HashMap map2 = (HashMap) this.e;
                        if (!map2.containsKey(str)) {
                            map2.put(str, new Vector());
                        }
                        ((Vector) map2.get(str)).add(vectorK);
                    }
                }
            } catch (OutOfMemoryError e) {
                throw new a(ak.AnonymousClass0.m("File too large to parse: ", e.getLocalizedMessage()));
            }
        }
    }

    public ko0 j(lg lgVar) throws a {
        lg lgVarA;
        if (lgVar != null) {
            try {
                lgVarA = lgVar.a();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            lgVarA = new lg();
        }
        Vector vectorE = e(1, 1, "port");
        if (vectorE != null) {
            lgVarA.c = (String) vectorE.get(1);
        }
        Vector vectorE2 = e(1, 1, "rport");
        if (vectorE2 != null) {
            lgVarA.c = (String) vectorE2.get(1);
        }
        Vector vectorE3 = e(1, 1, "proto");
        if (vectorE3 != null) {
            lgVarA.d = h((String) vectorE3.get(1));
        }
        Vector vectorE4 = e(1, 1, "connect-timeout");
        int i = 0;
        if (vectorE4 != null) {
            try {
                lgVarA.j = Integer.parseInt((String) vectorE4.get(1));
            } catch (NumberFormatException e2) {
                throw new a(String.format("Argument to connect-timeout (%s) must to be an integer: %s", vectorE4.get(1), e2.getLocalizedMessage()));
            }
        }
        Vector vectorE5 = e(1, 2, "socks-proxy");
        if (vectorE5 == null) {
            vectorE5 = e(2, 2, "http-proxy");
        }
        if (vectorE5 != null) {
            if (((String) vectorE5.get(0)).equals("socks-proxy")) {
                lgVarA.n = 3;
                lgVarA.p = "1080";
            } else {
                lgVarA.n = 2;
            }
            lgVarA.o = (String) vectorE5.get(1);
            if (vectorE5.size() >= 3) {
                lgVarA.p = (String) vectorE5.get(2);
            }
        }
        Vector vectorE6 = e(1, 1, "http-proxy-user-pass");
        if (vectorE6 != null) {
            String[] strArrSplit = gf1.e((String) vectorE6.get(1)).split("\n");
            if (strArrSplit.length >= 2) {
                lgVarA.r = strArrSplit[0];
                lgVarA.s = strArrSplit[1];
                lgVarA.q = true;
            }
        }
        Vector<Vector> vectorD = d(1, 3, "remote");
        Vector vector = new Vector();
        HashMap map = (HashMap) this.e;
        for (Map.Entry entry : map.entrySet()) {
            if (lgVar != null || ((HashSet) this.d).contains(entry.getKey())) {
                lgVarA.f = lgVarA.f.concat(f((Vector) entry.getValue()));
                vector.add((String) entry.getKey());
            }
        }
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            map.remove((String) it.next());
        }
        if (!AppConfig.CUSTOM.equals(lgVarA.f.trim())) {
            lgVarA.g = true;
        }
        if (vectorD == null) {
            vectorD = new Vector();
        }
        lg[] lgVarArr = new lg[vectorD.size()];
        for (Vector vector2 : vectorD) {
            try {
                lgVarArr[i] = lgVarA.a();
            } catch (CloneNotSupportedException e3) {
                e3.printStackTrace();
            }
            int size = vector2.size();
            if (size == 2) {
                lgVarArr[i].b = (String) vector2.get(1);
            } else {
                if (size != 3) {
                    if (size == 4) {
                        lgVarArr[i].d = h((String) vector2.get(3));
                    }
                }
                lgVarArr[i].c = (String) vector2.get(2);
                lgVarArr[i].b = (String) vector2.get(1);
            }
            i++;
        }
        return new ko0(lgVarA, lgVarArr);
    }
}
