package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.security.KeyChain;
import android.security.KeyChainException;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import java.util.Vector;
import net.lingala.zip4j.util.InternalZipConstants;
import org.hamotunnelplus.xyz.R;
import org.spongycastle.util.io.pem.PemObject;
import org.spongycastle.util.io.pem.PemWriter;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gf1 implements Serializable, Cloneable {
    public String A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public String F;
    public String G;
    public boolean H;
    public boolean I;
    public String J;
    public boolean K;
    public String L;
    public String M;
    public String N;
    public String O;
    public int P;
    public String Q;
    public String R;
    public int S;
    public lg[] T;
    public boolean U;
    public HashSet V;
    public String W;
    public int X;
    public int Y;
    public boolean Z;
    public String a0;
    public int b;
    public String b0;
    public String c;
    public boolean c0;
    public String d;
    public String d0;
    public int e0;
    public String f;
    public boolean f0;
    public String g;
    public String g0;
    public UUID h0;
    public String i;
    public String j;
    public boolean n;
    public String o;
    public boolean p;
    public String q;
    public String r;
    public String s;
    public boolean t;
    public String u;
    public boolean v;
    public boolean w;
    public String x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends Exception {
        public a() {
            super("No certificate returned from Keystore");
        }
    }

    public static String a(String str) {
        String[] strArrSplit = str.split(InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (strArrSplit.length == 1) {
            strArrSplit = str.concat("/32").split(InternalZipConstants.ZIP_FILE_SEPARATOR);
        }
        if (strArrSplit.length != 2) {
            return null;
        }
        try {
            int i = Integer.parseInt(strArrSplit[1]);
            if (i < 0 || i > 32) {
                return null;
            }
            long j = InternalZipConstants.ZIP_64_SIZE_LIMIT << (32 - i);
            Locale locale = Locale.ENGLISH;
            return e.c(new StringBuilder(), strArrSplit[0], "  ", ((4278190080L & j) >> 24) + "." + ((16711680 & j) >> 16) + "." + ((65280 & j) >> 8) + "." + (j & 255));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Vector d(String str) {
        Vector vector = new Vector();
        if (str != null) {
            for (String str2 : str.split("[\n \t]")) {
                if (!str2.equals(AppConfig.CUSTOM)) {
                    String strA = a(str2);
                    if (strA == null) {
                        break;
                    }
                    vector.add(strA);
                }
            }
        }
        return vector;
    }

    public static String e(String str) {
        return !str.contains("[[INLINE]]") ? str : str.substring(str.indexOf("[[INLINE]]") + 10);
    }

    public static X509Certificate[] g(Context context) throws InterruptedException, KeyChainException {
        KeyChain.getPrivateKey(context, null);
        return KeyChain.getCertificateChain(context, null);
    }

    public static String h(String str, String str2) {
        if (str2 == null) {
            return str + " file missing in config profile\n";
        }
        if (str2.startsWith("[[INLINE]]") || str2.startsWith("[[NAME]]")) {
            String strE = e(str2);
            Locale locale = Locale.ENGLISH;
            StringBuilder sb = new StringBuilder("<");
            sb.append(str);
            sb.append(">\n");
            sb.append(strE);
            sb.append("\n</");
            return fb$1.m(sb, str, ">\n");
        }
        Locale locale2 = Locale.ENGLISH;
        return str + " " + i(str2) + "\n";
    }

    public static String i(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
        if (strReplace.equals(str) && !strReplace.contains(" ") && !strReplace.contains("#") && !strReplace.contains(";") && !strReplace.equals(AppConfig.CUSTOM) && !strReplace.contains("'")) {
            return str;
        }
        return "\"" + strReplace + '\"';
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:101:0x020b  */
    /* JADX WARN: Code duplicated, block: B:102:0x0212  */
    /* JADX WARN: Code duplicated, block: B:104:0x021a  */
    /* JADX WARN: Code duplicated, block: B:109:0x023d  */
    /* JADX WARN: Code duplicated, block: B:112:0x0251 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:118:0x025a  */
    /* JADX WARN: Code duplicated, block: B:123:0x026b  */
    /* JADX WARN: Code duplicated, block: B:126:0x027a  */
    /* JADX WARN: Code duplicated, block: B:129:0x0283  */
    /* JADX WARN: Code duplicated, block: B:131:0x0297  */
    /* JADX WARN: Code duplicated, block: B:132:0x029a  */
    /* JADX WARN: Code duplicated, block: B:134:0x029d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:135:0x029f  */
    /* JADX WARN: Code duplicated, block: B:136:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:140:0x02b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:145:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:147:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:151:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:154:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:159:0x0303  */
    /* JADX WARN: Code duplicated, block: B:160:0x0308  */
    /* JADX WARN: Code duplicated, block: B:163:0x031b A[LOOP:4: B:161:0x0313->B:163:0x031b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:167:0x034f A[LOOP:5: B:165:0x0349->B:167:0x034f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:171:0x0372  */
    /* JADX WARN: Code duplicated, block: B:172:0x0378  */
    /* JADX WARN: Code duplicated, block: B:174:0x038a  */
    /* JADX WARN: Code duplicated, block: B:176:0x0392  */
    /* JADX WARN: Code duplicated, block: B:181:0x03a3 A[LOOP:3: B:179:0x039d->B:181:0x03a3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:184:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:186:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:188:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:191:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:194:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:197:0x040d  */
    /* JADX WARN: Code duplicated, block: B:199:0x0411  */
    /* JADX WARN: Code duplicated, block: B:201:0x041b  */
    /* JADX WARN: Code duplicated, block: B:202:0x0420  */
    /* JADX WARN: Code duplicated, block: B:204:0x0429  */
    /* JADX WARN: Code duplicated, block: B:208:0x0434  */
    /* JADX WARN: Code duplicated, block: B:20:0x0099  */
    /* JADX WARN: Code duplicated, block: B:213:0x0452  */
    /* JADX WARN: Code duplicated, block: B:216:0x045b  */
    /* JADX WARN: Code duplicated, block: B:218:0x045f  */
    /* JADX WARN: Code duplicated, block: B:220:0x0465  */
    /* JADX WARN: Code duplicated, block: B:237:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:242:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:245:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:248:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:251:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:254:0x052e  */
    /* JADX WARN: Code duplicated, block: B:257:0x0543  */
    /* JADX WARN: Code duplicated, block: B:260:0x0554  */
    /* JADX WARN: Code duplicated, block: B:263:0x055d  */
    /* JADX WARN: Code duplicated, block: B:266:0x0566  */
    /* JADX WARN: Code duplicated, block: B:269:0x056f  */
    /* JADX WARN: Code duplicated, block: B:272:0x0580 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:280:0x0598  */
    /* JADX WARN: Code duplicated, block: B:283:0x05a1 A[LOOP:0: B:279:0x0596->B:283:0x05a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:287:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:289:0x05bc  */
    /* JADX WARN: Code duplicated, block: B:291:0x05c8  */
    /* JADX WARN: Code duplicated, block: B:293:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:299:0x05a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x00af  */
    /* JADX WARN: Code duplicated, block: B:300:0x05a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:303:0x05df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:306:0x0395 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:315:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:49:0x0113  */
    /* JADX WARN: Code duplicated, block: B:50:0x011e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0123  */
    /* JADX WARN: Code duplicated, block: B:54:0x0127  */
    /* JADX WARN: Code duplicated, block: B:59:0x0135  */
    /* JADX WARN: Code duplicated, block: B:63:0x013d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0144  */
    /* JADX WARN: Code duplicated, block: B:67:0x014a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0150  */
    /* JADX WARN: Code duplicated, block: B:74:0x0167  */
    /* JADX WARN: Code duplicated, block: B:75:0x016b  */
    /* JADX WARN: Code duplicated, block: B:76:0x0170  */
    /* JADX WARN: Code duplicated, block: B:77:0x0175  */
    /* JADX WARN: Code duplicated, block: B:79:0x0180  */
    /* JADX WARN: Code duplicated, block: B:81:0x018b  */
    /* JADX WARN: Code duplicated, block: B:82:0x018f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x0191  */
    /* JADX WARN: Code duplicated, block: B:85:0x019c  */
    /* JADX WARN: Code duplicated, block: B:87:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:88:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:90:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:96:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:98:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:99:0x01f8  */
    /* JADX WARN: Instruction removed from duplicated block: B:163:0x031b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:167:0x034f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:181:0x03a3, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:251:0x04fa, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:50:0x011e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:65:0x0144, please report this as an issue */
    public final String c(ContextWrapper contextWrapper, boolean z) {
        boolean z2;
        String str;
        lg[] lgVarArr;
        int i;
        boolean z3;
        int i2;
        int i3;
        Iterator it;
        String str2;
        int i4;
        Iterator it2;
        String str3;
        Vector vector;
        String[] strArrSplit;
        int length;
        int i5;
        Iterator it3;
        String str4;
        int i6;
        int i7;
        int i8;
        lg[] lgVarArr2;
        int length2;
        int i9;
        lg lgVar;
        lg[] lgVarArr3;
        int length3;
        int i10;
        String str5;
        String str6;
        String str7;
        String str8;
        Object[] objArr;
        Integer numValueOf;
        String str9;
        String str10;
        boolean zEquals;
        boolean zEquals2;
        String strH;
        String strH2;
        String[] strArrF;
        String strH3;
        String strM;
        String str11;
        File cacheDir = contextWrapper.getCacheDir();
        StringBuilder sb = new StringBuilder();
        int i11 = 0;
        if (!z) {
            sb.append("# Config for OpenVPN 2.x\n# Enables connection to GUI\nmanagement ");
            sb.append(cacheDir.getAbsolutePath());
            sb.append("/mgmtsocket unix\nmanagement-client\nmanagement-query-passwords\nmanagement-hold\n\n");
            try {
                str11 = contextWrapper.getPackageManager().getPackageInfo(contextWrapper.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.getMessage();
                str11 = "unknown";
            }
            Locale locale = Locale.US;
            String strI = i(contextWrapper.getPackageName() + " " + str11);
            StringBuilder sb2 = new StringBuilder("setenv IV_GUI_VER ");
            sb2.append(strI);
            sb2.append(" \n");
            sb.append(sb2.toString());
            sb.append("setenv IV_SSO openurl,webauth,crtext\n");
            if (this.f0) {
                sb.append("providers legacy default\n");
            }
            strM = (TextUtils.isEmpty(this.g0) || this.b == 4) ? "# Config for OpenVPN 3 C++\n" : ak.AnonymousClass0.m("tls-cert-profile ", this.g0, "\n");
            if (!z) {
                sb.append("machine-readable-output\nallow-recursive-routing\nifconfig-nowarn\n");
            }
            if (this.b != 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && this.w) {
                str = "client\n";
            } else {
                if (!this.w) {
                    if (z2) {
                        str = "tls-client\n";
                    }
                    sb.append("verb 4\n");
                    if (this.L == null) {
                        this.L = "-1";
                    }
                    if (!this.L.equals("-1")) {
                        sb.append("connect-retry-max ");
                        sb.append(this.L);
                        sb.append("\n");
                    }
                    if (TextUtils.isEmpty(this.M)) {
                        this.M = "2";
                    }
                    if (TextUtils.isEmpty(this.N)) {
                        this.N = "300";
                    }
                    sb.append("connect-retry ");
                    sb.append(this.M);
                    sb.append(" ");
                    sb.append(this.N);
                    sb.append("\nresolv-retry 60\ndev tun\n");
                    lgVarArr = this.T;
                    if (lgVarArr.length == 1) {
                        sb.append(lgVarArr[0].c(z));
                        z3 = true;
                    } else {
                        z3 = true;
                        for (lg lgVar2 : lgVarArr) {
                            if (z3 || (!TextUtils.isEmpty(lgVar2.f) && lgVar2.g)) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                        }
                        if (this.U) {
                            sb.append("remote-random\n");
                        }
                        if (z3) {
                            for (lg lgVar3 : this.T) {
                                if (lgVar3.i) {
                                    sb.append(lgVar3.c(z));
                                }
                            }
                        }
                    }
                    switch (this.b) {
                        case 0:
                            if (!TextUtils.isEmpty(this.j)) {
                                sb.append(h("ca", this.j));
                            }
                            sb.append(h("key", this.i));
                            strH2 = h("cert", this.d);
                            sb.append(strH2);
                            break;
                        case 1:
                            sb.append(h("pkcs12", this.o));
                            if (!TextUtils.isEmpty(this.j)) {
                                strH2 = h("ca", this.j);
                                sb.append(strH2);
                            }
                            break;
                        case 2:
                        case 8:
                            if (!z) {
                                strArrF = f(contextWrapper, 5);
                                sb.append("### From Keystore/ext auth app ####\n");
                                if (strArrF != null) {
                                    if (!TextUtils.isEmpty(this.j)) {
                                        if (!TextUtils.isEmpty(strArrF[0]) && !this.c0) {
                                            sb.append("<ca>\n");
                                            sb.append(strArrF[0]);
                                            strH3 = "\n</ca>\n";
                                        }
                                        if (!TextUtils.isEmpty(strArrF[1])) {
                                            sb.append("<extra-certs>\n");
                                            sb.append(strArrF[1]);
                                            sb.append("\n</extra-certs>\n");
                                        }
                                        sb.append("<cert>\n");
                                        sb.append(strArrF[2]);
                                        strH2 = "\n</cert>\nmanagement-external-key nopadding pkcs1 pss digest\n";
                                        sb.append(strH2);
                                    } else {
                                        strH3 = h("ca", this.j);
                                    }
                                    sb.append(strH3);
                                    if (!TextUtils.isEmpty(strArrF[1])) {
                                        sb.append("<extra-certs>\n");
                                        sb.append(strArrF[1]);
                                        sb.append("\n</extra-certs>\n");
                                    }
                                    sb.append("<cert>\n");
                                    sb.append(strArrF[2]);
                                    strH2 = "\n</cert>\nmanagement-external-key nopadding pkcs1 pss digest\n";
                                    sb.append(strH2);
                                } else {
                                    sb.append(contextWrapper.getString(R.string.g0));
                                    sb.append("\n");
                                }
                            }
                            break;
                        case 3:
                            sb.append("auth-user-pass\n");
                            if (!TextUtils.isEmpty(this.j)) {
                                sb.append(h("ca", this.j));
                            }
                            if (z) {
                                strH2 = "client-cert-not-required\n";
                                sb.append(strH2);
                            }
                            break;
                        case 5:
                            sb.append("auth-user-pass\n");
                            if (!TextUtils.isEmpty(this.j)) {
                                sb.append(h("ca", this.j));
                            }
                            sb.append(h("key", this.i));
                            strH2 = h("cert", this.d);
                            sb.append(strH2);
                            break;
                        case 6:
                            sb.append("auth-user-pass\n");
                            sb.append(h("pkcs12", this.o));
                            if (!TextUtils.isEmpty(this.j)) {
                                strH2 = h("ca", this.j);
                                sb.append(strH2);
                            }
                            break;
                        case 7:
                            sb.append("auth-user-pass\n");
                            if (!z) {
                                strArrF = f(contextWrapper, 5);
                                sb.append("### From Keystore/ext auth app ####\n");
                                if (strArrF != null) {
                                    if (!TextUtils.isEmpty(this.j)) {
                                        if (!TextUtils.isEmpty(strArrF[0])) {
                                            sb.append("<ca>\n");
                                            sb.append(strArrF[0]);
                                            strH3 = "\n</ca>\n";
                                        }
                                        if (!TextUtils.isEmpty(strArrF[1])) {
                                            sb.append("<extra-certs>\n");
                                            sb.append(strArrF[1]);
                                            sb.append("\n</extra-certs>\n");
                                        }
                                        sb.append("<cert>\n");
                                        sb.append(strArrF[2]);
                                        strH2 = "\n</cert>\nmanagement-external-key nopadding pkcs1 pss digest\n";
                                        sb.append(strH2);
                                    } else {
                                        strH3 = h("ca", this.j);
                                    }
                                    sb.append(strH3);
                                    if (!TextUtils.isEmpty(strArrF[1])) {
                                        sb.append("<extra-certs>\n");
                                        sb.append(strArrF[1]);
                                        sb.append("\n</extra-certs>\n");
                                    }
                                    sb.append("<cert>\n");
                                    sb.append(strArrF[2]);
                                    strH2 = "\n</cert>\nmanagement-external-key nopadding pkcs1 pss digest\n";
                                    sb.append(strH2);
                                } else {
                                    sb.append(contextWrapper.getString(R.string.g0));
                                    sb.append("\n");
                                }
                            }
                            break;
                    }
                    if (this.c0) {
                        sb.append("<peer-fingerprint>\n");
                        sb.append(this.d0);
                        sb.append("\n</peer-fingerprint>\n");
                    }
                    i3 = this.b;
                    if ((i3 != 3 || i3 == 5 || i3 == 6 || i3 == 7) && this.X == 2) {
                        sb.append("auth-retry nointeract\n");
                    }
                    if (!TextUtils.isEmpty(this.W)) {
                        sb.append(h("crl-verify", this.W));
                    }
                    if (this.n) {
                        sb.append("comp-lzo\n");
                    }
                    if (this.p) {
                        str10 = "tls-crypt";
                        zEquals = this.f.equals("tls-crypt");
                        zEquals2 = this.f.equals("tls-crypt-v2");
                        if (this.b == 4) {
                            str10 = "secret";
                        } else {
                            if (!zEquals) {
                                if (zEquals2) {
                                    strH = h("tls-crypt-v2", this.g);
                                } else {
                                    str10 = "tls-auth";
                                }
                            }
                            sb.append(strH);
                            if (!TextUtils.isEmpty(this.f) && !zEquals && !zEquals2) {
                                sb.append("key-direction ");
                                sb.append(this.f);
                                sb.append("\n");
                            }
                        }
                        strH = h(str10, this.g);
                        sb.append(strH);
                        if (!TextUtils.isEmpty(this.f)) {
                            sb.append("key-direction ");
                            sb.append(this.f);
                            sb.append("\n");
                        }
                    }
                    if (!this.w) {
                        if (!TextUtils.isEmpty(this.s)) {
                            sb.append("ifconfig ");
                            sb.append(a(this.s));
                            sb.append("\n");
                        }
                        if (!TextUtils.isEmpty(null)) {
                            throw null;
                        }
                    }
                    if (this.w && this.B) {
                        sb.append("route-nopull\n");
                    }
                    if (this.v) {
                        str3 = "route 0.0.0.0 0.0.0.0 vpn_gateway\n";
                        i4 = 0;
                    } else {
                        it = d(this.x).iterator();
                        str2 = AppConfig.CUSTOM;
                        while (it.hasNext()) {
                            str2 = str2 + "route " + ((String) it.next()) + " vpn_gateway\n";
                            i11 = i11;
                        }
                        i4 = i11;
                        it2 = d(this.R).iterator();
                        while (it2.hasNext()) {
                            str2 = str2 + "route " + ((String) it2.next()) + " net_gateway\n";
                        }
                        str3 = str2;
                    }
                    if (this.I) {
                        sb.append("route-ipv6 ::/0\n");
                    } else {
                        String str12 = this.J;
                        vector = new Vector();
                        strArrSplit = str12.split("[\n \t]");
                        length = strArrSplit.length;
                        for (i5 = i4; i5 < length; i5++) {
                            str4 = strArrSplit[i5];
                            if (!str4.equals(AppConfig.CUSTOM)) {
                                vector.add(str4);
                            }
                        }
                        it3 = vector.iterator();
                        while (it3.hasNext()) {
                            str3 = str3 + "route-ipv6 " + ((String) it3.next()) + "\n";
                        }
                    }
                    sb.append(str3);
                    if (this.t || !this.w) {
                        if (!TextUtils.isEmpty(this.q)) {
                            sb.append("dhcp-option DNS ");
                            sb.append(this.q);
                            sb.append("\n");
                        }
                        if (!TextUtils.isEmpty(this.r)) {
                            sb.append("dhcp-option DNS ");
                            sb.append(this.r);
                            sb.append("\n");
                        }
                        if (!TextUtils.isEmpty(this.u)) {
                            sb.append("dhcp-option DOMAIN ");
                            sb.append(this.u);
                            sb.append("\n");
                        }
                    }
                    i6 = this.S;
                    if (i6 != 0) {
                        if (i6 != 1450) {
                            Locale locale2 = Locale.US;
                            objArr = new Object[1];
                            numValueOf = Integer.valueOf(i6);
                            if (z) {
                                objArr[i4] = numValueOf;
                                str9 = "mssfix %d mtu\n";
                            } else {
                                objArr[i4] = numValueOf;
                                str9 = "mssfix %d\n";
                            }
                            str8 = String.format(locale2, str9, objArr);
                        } else {
                            str8 = "mssfix\n";
                        }
                        sb.append(str8);
                    }
                    i7 = this.Y;
                    if (i7 >= 48 && i7 != 1500) {
                        Locale locale3 = Locale.US;
                        sb.append("tun-mtu " + i7 + "\n");
                    }
                    if (this.H) {
                        sb.append("nobind\n");
                    }
                    if (this.b != 4) {
                        if (this.y) {
                            str5 = this.A;
                            if (str5 != null || str5.equals(AppConfig.CUSTOM)) {
                                sb.append("verify-x509-name ");
                                str6 = this.T[i4].b;
                            } else {
                                int i12 = this.P;
                                if (i12 == 0) {
                                    sb.append("tls-remote ");
                                    sb.append(i(this.A));
                                    sb.append("\n");
                                } else if (i12 == 1) {
                                    sb.append("compat-names no-remapping\n");
                                    sb.append("tls-remote ");
                                    sb.append(i(this.A));
                                    sb.append("\n");
                                } else if (i12 == 2) {
                                    sb.append("verify-x509-name ");
                                    sb.append(i(this.A));
                                    sb.append("\n");
                                } else if (i12 == 3) {
                                    sb.append("verify-x509-name ");
                                    str6 = this.A;
                                } else if (i12 == 4) {
                                    sb.append("verify-x509-name ");
                                    sb.append(i(this.A));
                                    str7 = " name-prefix\n";
                                    sb.append(str7);
                                }
                                if (!TextUtils.isEmpty(this.Q)) {
                                    sb.append("x509-username-field ");
                                    sb.append(i(this.Q));
                                    sb.append("\n");
                                }
                            }
                            sb.append(i(str6));
                            str7 = " name\n";
                            sb.append(str7);
                            if (!TextUtils.isEmpty(this.Q)) {
                                sb.append("x509-username-field ");
                                sb.append(i(this.Q));
                                sb.append("\n");
                            }
                        }
                        if (this.z) {
                            sb.append("remote-cert-tls server\n");
                        }
                    }
                    if (!TextUtils.isEmpty(this.b0)) {
                        sb.append("data-ciphers ");
                        sb.append(this.b0);
                        sb.append("\n");
                    }
                    i8 = this.e0;
                    if (i8 > 0) {
                        Locale locale4 = Locale.US;
                        sb.append("compat-mode " + (i8 / 10000) + "." + ((i8 % 10000) / 100) + "." + (i8 % 100) + "\n");
                    }
                    if (!TextUtils.isEmpty(this.G)) {
                        sb.append("cipher ");
                        sb.append(this.G);
                        sb.append("\n");
                    }
                    if (!TextUtils.isEmpty(this.O)) {
                        sb.append("auth ");
                        sb.append(this.O);
                        sb.append("\n");
                    }
                    if (this.C) {
                        sb.append("#my favorite options :)\nremote-random-hostname\n");
                    }
                    if (this.D) {
                        sb.append("float\n");
                    }
                    if (this.K) {
                        sb.append("persist-tun\n# persist-tun also enables pre resolving to avoid DNS resolve problem\npreresolve\n");
                    }
                    if (this.Z) {
                        sb.append("push-peer-info\n");
                    }
                    if (PreferenceManager.getDefaultSharedPreferences(contextWrapper).getBoolean("usesystemproxy", true) && !z && (!this.E || !this.F.contains("http-proxy-option "))) {
                        lgVarArr3 = this.T;
                        length3 = lgVarArr3.length;
                        i10 = i4;
                        while (true) {
                            if (i10 >= length3) {
                                sb.append("# Use system proxy setting\nmanagement-query-proxy\n");
                            } else if (!lgVarArr3[i10].d()) {
                                i10++;
                            }
                        }
                    }
                    if (this.E) {
                        sb.append("# Custom configuration options\n# You are on your on own here :)\n");
                        sb.append(this.F);
                        sb.append("\n");
                    }
                    if (!z3) {
                        sb.append("# Connection Options are at the end to allow global options (and global custom options) to influence connection blocks\n");
                        lgVarArr2 = this.T;
                        length2 = lgVarArr2.length;
                        for (i9 = i4; i9 < length2; i9++) {
                            lgVar = lgVarArr2[i9];
                            if (lgVar.i) {
                                sb.append("<connection>\n");
                                sb.append(lgVar.c(z));
                                sb.append("</connection>\n");
                            }
                        }
                    }
                    return sb.toString();
                }
                str = "pull\n";
            }
            sb.append(str);
            sb.append("verb 4\n");
            if (this.L == null) {
                this.L = "-1";
            }
            if (!this.L.equals("-1")) {
                sb.append("connect-retry-max ");
                sb.append(this.L);
                sb.append("\n");
            }
            if (TextUtils.isEmpty(this.M)) {
                this.M = "2";
            }
            if (TextUtils.isEmpty(this.N)) {
                this.N = "300";
            }
            sb.append("connect-retry ");
            sb.append(this.M);
            sb.append(" ");
            sb.append(this.N);
            sb.append("\nresolv-retry 60\ndev tun\n");
            lgVarArr = this.T;
            if (lgVarArr.length == 1) {
                sb.append(lgVarArr[0].c(z));
                z3 = true;
            } else {
                z3 = true;
                while (i < r5) {
                    if (z3) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                }
                if (this.U) {
                    sb.append("remote-random\n");
                }
                if (z3) {
                    while (i2 < r5) {
                        if (lgVar3.i) {
                            sb.append(lgVar3.c(z));
                        }
                    }
                }
            }
            switch (this.b) {
                case 0:
                    if (!TextUtils.isEmpty(this.j)) {
                        sb.append(h("ca", this.j));
                    }
                    sb.append(h("key", this.i));
                    strH2 = h("cert", this.d);
                    sb.append(strH2);
                    break;
                case 1:
                    sb.append(h("pkcs12", this.o));
                    if (!TextUtils.isEmpty(this.j)) {
                        strH2 = h("ca", this.j);
                        sb.append(strH2);
                    }
                    break;
                case 2:
                case 8:
                    if (!z) {
                        strArrF = f(contextWrapper, 5);
                        sb.append("### From Keystore/ext auth app ####\n");
                        if (strArrF != null) {
                            if (!TextUtils.isEmpty(this.j)) {
                                if (!TextUtils.isEmpty(strArrF[0])) {
                                    sb.append("<ca>\n");
                                    sb.append(strArrF[0]);
                                    strH3 = "\n</ca>\n";
                                }
                                if (!TextUtils.isEmpty(strArrF[1])) {
                                    sb.append("<extra-certs>\n");
                                    sb.append(strArrF[1]);
                                    sb.append("\n</extra-certs>\n");
                                }
                                sb.append("<cert>\n");
                                sb.append(strArrF[2]);
                                strH2 = "\n</cert>\nmanagement-external-key nopadding pkcs1 pss digest\n";
                                sb.append(strH2);
                            } else {
                                strH3 = h("ca", this.j);
                            }
                            sb.append(strH3);
                            if (!TextUtils.isEmpty(strArrF[1])) {
                                sb.append("<extra-certs>\n");
                                sb.append(strArrF[1]);
                                sb.append("\n</extra-certs>\n");
                            }
                            sb.append("<cert>\n");
                            sb.append(strArrF[2]);
                            strH2 = "\n</cert>\nmanagement-external-key nopadding pkcs1 pss digest\n";
                            sb.append(strH2);
                        } else {
                            sb.append(contextWrapper.getString(R.string.g0));
                            sb.append("\n");
                        }
                    }
                    break;
                case 3:
                    sb.append("auth-user-pass\n");
                    if (!TextUtils.isEmpty(this.j)) {
                        sb.append(h("ca", this.j));
                    }
                    if (z) {
                        strH2 = "client-cert-not-required\n";
                        sb.append(strH2);
                    }
                    break;
                case 5:
                    sb.append("auth-user-pass\n");
                    if (!TextUtils.isEmpty(this.j)) {
                        sb.append(h("ca", this.j));
                    }
                    sb.append(h("key", this.i));
                    strH2 = h("cert", this.d);
                    sb.append(strH2);
                    break;
                case 6:
                    sb.append("auth-user-pass\n");
                    sb.append(h("pkcs12", this.o));
                    if (!TextUtils.isEmpty(this.j)) {
                        strH2 = h("ca", this.j);
                        sb.append(strH2);
                    }
                    break;
                case 7:
                    sb.append("auth-user-pass\n");
                    if (!z) {
                        strArrF = f(contextWrapper, 5);
                        sb.append("### From Keystore/ext auth app ####\n");
                        if (strArrF != null) {
                            if (!TextUtils.isEmpty(this.j)) {
                                if (!TextUtils.isEmpty(strArrF[0])) {
                                    sb.append("<ca>\n");
                                    sb.append(strArrF[0]);
                                    strH3 = "\n</ca>\n";
                                }
                                if (!TextUtils.isEmpty(strArrF[1])) {
                                    sb.append("<extra-certs>\n");
                                    sb.append(strArrF[1]);
                                    sb.append("\n</extra-certs>\n");
                                }
                                sb.append("<cert>\n");
                                sb.append(strArrF[2]);
                                strH2 = "\n</cert>\nmanagement-external-key nopadding pkcs1 pss digest\n";
                                sb.append(strH2);
                            } else {
                                strH3 = h("ca", this.j);
                            }
                            sb.append(strH3);
                            if (!TextUtils.isEmpty(strArrF[1])) {
                                sb.append("<extra-certs>\n");
                                sb.append(strArrF[1]);
                                sb.append("\n</extra-certs>\n");
                            }
                            sb.append("<cert>\n");
                            sb.append(strArrF[2]);
                            strH2 = "\n</cert>\nmanagement-external-key nopadding pkcs1 pss digest\n";
                            sb.append(strH2);
                        } else {
                            sb.append(contextWrapper.getString(R.string.g0));
                            sb.append("\n");
                        }
                    }
                    break;
            }
            if (this.c0) {
                sb.append("<peer-fingerprint>\n");
                sb.append(this.d0);
                sb.append("\n</peer-fingerprint>\n");
            }
            i3 = this.b;
            if (i3 != 3) {
                sb.append("auth-retry nointeract\n");
            } else {
                sb.append("auth-retry nointeract\n");
            }
            if (!TextUtils.isEmpty(this.W)) {
                sb.append(h("crl-verify", this.W));
            }
            if (this.n) {
                sb.append("comp-lzo\n");
            }
            if (this.p) {
                str10 = "tls-crypt";
                zEquals = this.f.equals("tls-crypt");
                zEquals2 = this.f.equals("tls-crypt-v2");
                if (this.b == 4) {
                    str10 = "secret";
                } else {
                    if (!zEquals) {
                        if (zEquals2) {
                            strH = h("tls-crypt-v2", this.g);
                        } else {
                            str10 = "tls-auth";
                        }
                    }
                    sb.append(strH);
                    if (!TextUtils.isEmpty(this.f)) {
                        sb.append("key-direction ");
                        sb.append(this.f);
                        sb.append("\n");
                    }
                }
                strH = h(str10, this.g);
                sb.append(strH);
                if (!TextUtils.isEmpty(this.f)) {
                    sb.append("key-direction ");
                    sb.append(this.f);
                    sb.append("\n");
                }
            }
            if (!this.w) {
                if (!TextUtils.isEmpty(this.s)) {
                    sb.append("ifconfig ");
                    sb.append(a(this.s));
                    sb.append("\n");
                }
                if (!TextUtils.isEmpty(null)) {
                    throw null;
                }
            }
            if (this.w) {
                sb.append("route-nopull\n");
            }
            if (this.v) {
                str3 = "route 0.0.0.0 0.0.0.0 vpn_gateway\n";
                i4 = 0;
            } else {
                it = d(this.x).iterator();
                str2 = AppConfig.CUSTOM;
                while (it.hasNext()) {
                    str2 = str2 + "route " + ((String) it.next()) + " vpn_gateway\n";
                    i11 = i11;
                }
                i4 = i11;
                it2 = d(this.R).iterator();
                while (it2.hasNext()) {
                    str2 = str2 + "route " + ((String) it2.next()) + " net_gateway\n";
                }
                str3 = str2;
            }
            if (this.I) {
                sb.append("route-ipv6 ::/0\n");
            } else {
                String str13 = this.J;
                vector = new Vector();
                strArrSplit = str13.split("[\n \t]");
                length = strArrSplit.length;
                while (i5 < length) {
                    str4 = strArrSplit[i5];
                    if (!str4.equals(AppConfig.CUSTOM)) {
                        vector.add(str4);
                    }
                }
                it3 = vector.iterator();
                while (it3.hasNext()) {
                    str3 = str3 + "route-ipv6 " + ((String) it3.next()) + "\n";
                }
            }
            sb.append(str3);
            if (this.t) {
                if (!TextUtils.isEmpty(this.q)) {
                    sb.append("dhcp-option DNS ");
                    sb.append(this.q);
                    sb.append("\n");
                }
                if (!TextUtils.isEmpty(this.r)) {
                    sb.append("dhcp-option DNS ");
                    sb.append(this.r);
                    sb.append("\n");
                }
                if (!TextUtils.isEmpty(this.u)) {
                    sb.append("dhcp-option DOMAIN ");
                    sb.append(this.u);
                    sb.append("\n");
                }
            } else {
                if (!TextUtils.isEmpty(this.q)) {
                    sb.append("dhcp-option DNS ");
                    sb.append(this.q);
                    sb.append("\n");
                }
                if (!TextUtils.isEmpty(this.r)) {
                    sb.append("dhcp-option DNS ");
                    sb.append(this.r);
                    sb.append("\n");
                }
                if (!TextUtils.isEmpty(this.u)) {
                    sb.append("dhcp-option DOMAIN ");
                    sb.append(this.u);
                    sb.append("\n");
                }
            }
            i6 = this.S;
            if (i6 != 0) {
                if (i6 != 1450) {
                    Locale locale5 = Locale.US;
                    objArr = new Object[1];
                    numValueOf = Integer.valueOf(i6);
                    if (z) {
                        objArr[i4] = numValueOf;
                        str9 = "mssfix %d mtu\n";
                    } else {
                        objArr[i4] = numValueOf;
                        str9 = "mssfix %d\n";
                    }
                    str8 = String.format(locale5, str9, objArr);
                } else {
                    str8 = "mssfix\n";
                }
                sb.append(str8);
            }
            i7 = this.Y;
            if (i7 >= 48) {
                Locale locale6 = Locale.US;
                sb.append("tun-mtu " + i7 + "\n");
            }
            if (this.H) {
                sb.append("nobind\n");
            }
            if (this.b != 4) {
                if (this.y) {
                    str5 = this.A;
                    if (str5 != null) {
                        sb.append("verify-x509-name ");
                        str6 = this.T[i4].b;
                        sb.append(i(str6));
                        str7 = " name\n";
                        sb.append(str7);
                    } else {
                        sb.append("verify-x509-name ");
                        str6 = this.T[i4].b;
                        sb.append(i(str6));
                        str7 = " name\n";
                        sb.append(str7);
                    }
                    if (!TextUtils.isEmpty(this.Q)) {
                        sb.append("x509-username-field ");
                        sb.append(i(this.Q));
                        sb.append("\n");
                    }
                }
                if (this.z) {
                    sb.append("remote-cert-tls server\n");
                }
            }
            if (!TextUtils.isEmpty(this.b0)) {
                sb.append("data-ciphers ");
                sb.append(this.b0);
                sb.append("\n");
            }
            i8 = this.e0;
            if (i8 > 0) {
                Locale locale7 = Locale.US;
                sb.append("compat-mode " + (i8 / 10000) + "." + ((i8 % 10000) / 100) + "." + (i8 % 100) + "\n");
            }
            if (!TextUtils.isEmpty(this.G)) {
                sb.append("cipher ");
                sb.append(this.G);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.O)) {
                sb.append("auth ");
                sb.append(this.O);
                sb.append("\n");
            }
            if (this.C) {
                sb.append("#my favorite options :)\nremote-random-hostname\n");
            }
            if (this.D) {
                sb.append("float\n");
            }
            if (this.K) {
                sb.append("persist-tun\n# persist-tun also enables pre resolving to avoid DNS resolve problem\npreresolve\n");
            }
            if (this.Z) {
                sb.append("push-peer-info\n");
            }
            if (PreferenceManager.getDefaultSharedPreferences(contextWrapper).getBoolean("usesystemproxy", true)) {
                lgVarArr3 = this.T;
                length3 = lgVarArr3.length;
                i10 = i4;
                while (true) {
                    if (i10 >= length3) {
                        sb.append("# Use system proxy setting\nmanagement-query-proxy\n");
                    } else if (!lgVarArr3[i10].d()) {
                        i10++;
                    }
                }
            }
            if (this.E) {
                sb.append("# Custom configuration options\n# You are on your on own here :)\n");
                sb.append(this.F);
                sb.append("\n");
            }
            if (!z3) {
                sb.append("# Connection Options are at the end to allow global options (and global custom options) to influence connection blocks\n");
                lgVarArr2 = this.T;
                length2 = lgVarArr2.length;
                while (i9 < length2) {
                    lgVar = lgVarArr2[i9];
                    if (lgVar.i) {
                        sb.append("<connection>\n");
                        sb.append(lgVar.c(z));
                        sb.append("</connection>\n");
                    }
                }
            }
            return sb.toString();
        }
        sb.append(strM);
        if (!z) {
            sb.append("machine-readable-output\nallow-recursive-routing\nifconfig-nowarn\n");
        }
        if (this.b != 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            if (!this.w) {
                str = "pull\n";
            } else if (z2) {
                str = "tls-client\n";
            }
            sb.append(str);
        } else {
            if (!this.w) {
                str = "pull\n";
            } else if (z2) {
                str = "tls-client\n";
            }
            sb.append(str);
        }
        sb.append("verb 4\n");
        if (this.L == null) {
            this.L = "-1";
        }
        if (!this.L.equals("-1")) {
            sb.append("connect-retry-max ");
            sb.append(this.L);
            sb.append("\n");
        }
        if (TextUtils.isEmpty(this.M)) {
            this.M = "2";
        }
        if (TextUtils.isEmpty(this.N)) {
            this.N = "300";
        }
        sb.append("connect-retry ");
        sb.append(this.M);
        sb.append(" ");
        sb.append(this.N);
        sb.append("\nresolv-retry 60\ndev tun\n");
        lgVarArr = this.T;
        if (lgVarArr.length == 1) {
            sb.append(lgVarArr[0].c(z));
            z3 = true;
        } else {
            z3 = true;
            while (i < r5) {
                if (z3) {
                    z3 = false;
                } else {
                    z3 = false;
                }
            }
            if (this.U) {
                sb.append("remote-random\n");
            }
            if (z3) {
                while (i2 < r5) {
                    if (lgVar3.i) {
                        sb.append(lgVar3.c(z));
                    }
                }
            }
        }
        switch (this.b) {
            case 0:
                if (!TextUtils.isEmpty(this.j)) {
                    sb.append(h("ca", this.j));
                }
                sb.append(h("key", this.i));
                strH2 = h("cert", this.d);
                sb.append(strH2);
                break;
            case 1:
                sb.append(h("pkcs12", this.o));
                if (!TextUtils.isEmpty(this.j)) {
                    strH2 = h("ca", this.j);
                    sb.append(strH2);
                }
                break;
            case 2:
            case 8:
                if (!z) {
                    strArrF = f(contextWrapper, 5);
                    sb.append("### From Keystore/ext auth app ####\n");
                    if (strArrF != null) {
                        if (!TextUtils.isEmpty(this.j)) {
                            if (!TextUtils.isEmpty(strArrF[0])) {
                                sb.append("<ca>\n");
                                sb.append(strArrF[0]);
                                strH3 = "\n</ca>\n";
                            }
                            if (!TextUtils.isEmpty(strArrF[1])) {
                                sb.append("<extra-certs>\n");
                                sb.append(strArrF[1]);
                                sb.append("\n</extra-certs>\n");
                            }
                            sb.append("<cert>\n");
                            sb.append(strArrF[2]);
                            strH2 = "\n</cert>\nmanagement-external-key nopadding pkcs1 pss digest\n";
                            sb.append(strH2);
                        } else {
                            strH3 = h("ca", this.j);
                        }
                        sb.append(strH3);
                        if (!TextUtils.isEmpty(strArrF[1])) {
                            sb.append("<extra-certs>\n");
                            sb.append(strArrF[1]);
                            sb.append("\n</extra-certs>\n");
                        }
                        sb.append("<cert>\n");
                        sb.append(strArrF[2]);
                        strH2 = "\n</cert>\nmanagement-external-key nopadding pkcs1 pss digest\n";
                        sb.append(strH2);
                    } else {
                        sb.append(contextWrapper.getString(R.string.g0));
                        sb.append("\n");
                    }
                }
                break;
            case 3:
                sb.append("auth-user-pass\n");
                if (!TextUtils.isEmpty(this.j)) {
                    sb.append(h("ca", this.j));
                }
                if (z) {
                    strH2 = "client-cert-not-required\n";
                    sb.append(strH2);
                }
                break;
            case 5:
                sb.append("auth-user-pass\n");
                if (!TextUtils.isEmpty(this.j)) {
                    sb.append(h("ca", this.j));
                }
                sb.append(h("key", this.i));
                strH2 = h("cert", this.d);
                sb.append(strH2);
                break;
            case 6:
                sb.append("auth-user-pass\n");
                sb.append(h("pkcs12", this.o));
                if (!TextUtils.isEmpty(this.j)) {
                    strH2 = h("ca", this.j);
                    sb.append(strH2);
                }
                break;
            case 7:
                sb.append("auth-user-pass\n");
                if (!z) {
                    strArrF = f(contextWrapper, 5);
                    sb.append("### From Keystore/ext auth app ####\n");
                    if (strArrF != null) {
                        if (!TextUtils.isEmpty(this.j)) {
                            if (!TextUtils.isEmpty(strArrF[0])) {
                                sb.append("<ca>\n");
                                sb.append(strArrF[0]);
                                strH3 = "\n</ca>\n";
                            }
                            if (!TextUtils.isEmpty(strArrF[1])) {
                                sb.append("<extra-certs>\n");
                                sb.append(strArrF[1]);
                                sb.append("\n</extra-certs>\n");
                            }
                            sb.append("<cert>\n");
                            sb.append(strArrF[2]);
                            strH2 = "\n</cert>\nmanagement-external-key nopadding pkcs1 pss digest\n";
                            sb.append(strH2);
                        } else {
                            strH3 = h("ca", this.j);
                        }
                        sb.append(strH3);
                        if (!TextUtils.isEmpty(strArrF[1])) {
                            sb.append("<extra-certs>\n");
                            sb.append(strArrF[1]);
                            sb.append("\n</extra-certs>\n");
                        }
                        sb.append("<cert>\n");
                        sb.append(strArrF[2]);
                        strH2 = "\n</cert>\nmanagement-external-key nopadding pkcs1 pss digest\n";
                        sb.append(strH2);
                    } else {
                        sb.append(contextWrapper.getString(R.string.g0));
                        sb.append("\n");
                    }
                }
                break;
        }
        if (this.c0) {
            sb.append("<peer-fingerprint>\n");
            sb.append(this.d0);
            sb.append("\n</peer-fingerprint>\n");
        }
        i3 = this.b;
        if (i3 != 3) {
            sb.append("auth-retry nointeract\n");
        } else {
            sb.append("auth-retry nointeract\n");
        }
        if (!TextUtils.isEmpty(this.W)) {
            sb.append(h("crl-verify", this.W));
        }
        if (this.n) {
            sb.append("comp-lzo\n");
        }
        if (this.p) {
            str10 = "tls-crypt";
            zEquals = this.f.equals("tls-crypt");
            zEquals2 = this.f.equals("tls-crypt-v2");
            if (this.b == 4) {
                str10 = "secret";
            } else {
                if (!zEquals) {
                    if (zEquals2) {
                        strH = h("tls-crypt-v2", this.g);
                    } else {
                        str10 = "tls-auth";
                    }
                }
                sb.append(strH);
                if (!TextUtils.isEmpty(this.f)) {
                    sb.append("key-direction ");
                    sb.append(this.f);
                    sb.append("\n");
                }
            }
            strH = h(str10, this.g);
            sb.append(strH);
            if (!TextUtils.isEmpty(this.f)) {
                sb.append("key-direction ");
                sb.append(this.f);
                sb.append("\n");
            }
        }
        if (!this.w) {
            if (!TextUtils.isEmpty(this.s)) {
                sb.append("ifconfig ");
                sb.append(a(this.s));
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(null)) {
                throw null;
            }
        }
        if (this.w) {
            sb.append("route-nopull\n");
        }
        if (this.v) {
            str3 = "route 0.0.0.0 0.0.0.0 vpn_gateway\n";
            i4 = 0;
        } else {
            it = d(this.x).iterator();
            str2 = AppConfig.CUSTOM;
            while (it.hasNext()) {
                str2 = str2 + "route " + ((String) it.next()) + " vpn_gateway\n";
                i11 = i11;
            }
            i4 = i11;
            it2 = d(this.R).iterator();
            while (it2.hasNext()) {
                str2 = str2 + "route " + ((String) it2.next()) + " net_gateway\n";
            }
            str3 = str2;
        }
        if (this.I) {
            sb.append("route-ipv6 ::/0\n");
        } else {
            String str14 = this.J;
            vector = new Vector();
            strArrSplit = str14.split("[\n \t]");
            length = strArrSplit.length;
            while (i5 < length) {
                str4 = strArrSplit[i5];
                if (!str4.equals(AppConfig.CUSTOM)) {
                    vector.add(str4);
                }
            }
            it3 = vector.iterator();
            while (it3.hasNext()) {
                str3 = str3 + "route-ipv6 " + ((String) it3.next()) + "\n";
            }
        }
        sb.append(str3);
        if (this.t) {
            if (!TextUtils.isEmpty(this.q)) {
                sb.append("dhcp-option DNS ");
                sb.append(this.q);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.r)) {
                sb.append("dhcp-option DNS ");
                sb.append(this.r);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.u)) {
                sb.append("dhcp-option DOMAIN ");
                sb.append(this.u);
                sb.append("\n");
            }
        } else {
            if (!TextUtils.isEmpty(this.q)) {
                sb.append("dhcp-option DNS ");
                sb.append(this.q);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.r)) {
                sb.append("dhcp-option DNS ");
                sb.append(this.r);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.u)) {
                sb.append("dhcp-option DOMAIN ");
                sb.append(this.u);
                sb.append("\n");
            }
        }
        i6 = this.S;
        if (i6 != 0) {
            if (i6 != 1450) {
                Locale locale8 = Locale.US;
                objArr = new Object[1];
                numValueOf = Integer.valueOf(i6);
                if (z) {
                    objArr[i4] = numValueOf;
                    str9 = "mssfix %d mtu\n";
                } else {
                    objArr[i4] = numValueOf;
                    str9 = "mssfix %d\n";
                }
                str8 = String.format(locale8, str9, objArr);
            } else {
                str8 = "mssfix\n";
            }
            sb.append(str8);
        }
        i7 = this.Y;
        if (i7 >= 48) {
            Locale locale9 = Locale.US;
            sb.append("tun-mtu " + i7 + "\n");
        }
        if (this.H) {
            sb.append("nobind\n");
        }
        if (this.b != 4) {
            if (this.y) {
                str5 = this.A;
                if (str5 != null) {
                    sb.append("verify-x509-name ");
                    str6 = this.T[i4].b;
                    sb.append(i(str6));
                    str7 = " name\n";
                    sb.append(str7);
                } else {
                    sb.append("verify-x509-name ");
                    str6 = this.T[i4].b;
                    sb.append(i(str6));
                    str7 = " name\n";
                    sb.append(str7);
                }
                if (!TextUtils.isEmpty(this.Q)) {
                    sb.append("x509-username-field ");
                    sb.append(i(this.Q));
                    sb.append("\n");
                }
            }
            if (this.z) {
                sb.append("remote-cert-tls server\n");
            }
        }
        if (!TextUtils.isEmpty(this.b0)) {
            sb.append("data-ciphers ");
            sb.append(this.b0);
            sb.append("\n");
        }
        i8 = this.e0;
        if (i8 > 0) {
            Locale locale10 = Locale.US;
            sb.append("compat-mode " + (i8 / 10000) + "." + ((i8 % 10000) / 100) + "." + (i8 % 100) + "\n");
        }
        if (!TextUtils.isEmpty(this.G)) {
            sb.append("cipher ");
            sb.append(this.G);
            sb.append("\n");
        }
        if (!TextUtils.isEmpty(this.O)) {
            sb.append("auth ");
            sb.append(this.O);
            sb.append("\n");
        }
        if (this.C) {
            sb.append("#my favorite options :)\nremote-random-hostname\n");
        }
        if (this.D) {
            sb.append("float\n");
        }
        if (this.K) {
            sb.append("persist-tun\n# persist-tun also enables pre resolving to avoid DNS resolve problem\npreresolve\n");
        }
        if (this.Z) {
            sb.append("push-peer-info\n");
        }
        if (PreferenceManager.getDefaultSharedPreferences(contextWrapper).getBoolean("usesystemproxy", true)) {
            lgVarArr3 = this.T;
            length3 = lgVarArr3.length;
            i10 = i4;
            while (true) {
                if (i10 >= length3) {
                    sb.append("# Use system proxy setting\nmanagement-query-proxy\n");
                } else if (!lgVarArr3[i10].d()) {
                    i10++;
                }
            }
        }
        if (this.E) {
            sb.append("# Custom configuration options\n# You are on your on own here :)\n");
            sb.append(this.F);
            sb.append("\n");
        }
        if (!z3) {
            sb.append("# Connection Options are at the end to allow global options (and global custom options) to influence connection blocks\n");
            lgVarArr2 = this.T;
            length2 = lgVarArr2.length;
            while (i9 < length2) {
                lgVar = lgVarArr2[i9];
                if (lgVar.i) {
                    sb.append("<connection>\n");
                    sb.append(lgVar.c(z));
                    sb.append("</connection>\n");
                }
            }
        }
        return sb.toString();
    }

    public final Object clone() {
        gf1 gf1Var = (gf1) super.clone();
        gf1Var.h0 = UUID.randomUUID();
        gf1Var.T = new lg[this.T.length];
        lg[] lgVarArr = this.T;
        int length = lgVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            gf1Var.T[i2] = lgVarArr[i].a();
            i++;
            i2++;
        }
        gf1Var.V = (HashSet) this.V.clone();
        return gf1Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof gf1) {
            return this.h0.equals(((gf1) obj).h0);
        }
        return false;
    }

    public final synchronized String[] f(Context context, int i) {
        String string;
        String string2;
        String str;
        try {
            Context applicationContext = context.getApplicationContext();
            try {
                try {
                    X509Certificate[] x509CertificateArrG = g(applicationContext);
                    if (x509CertificateArrG == null) {
                        throw new a();
                    }
                    if (x509CertificateArrG.length > 1 || !TextUtils.isEmpty(this.j)) {
                        StringWriter stringWriter = new StringWriter();
                        PemWriter pemWriter = new PemWriter(stringWriter);
                        for (int i2 = 1; i2 < x509CertificateArrG.length; i2++) {
                            pemWriter.writeObject(new PemObject("CERTIFICATE", x509CertificateArrG[i2].getEncoded()));
                        }
                        pemWriter.close();
                        string = stringWriter.toString();
                    } else {
                        string = null;
                    }
                    if (TextUtils.isEmpty(this.j)) {
                        string2 = null;
                    } else {
                        try {
                            Certificate[] certificateArrA = ak.a(this.j);
                            StringWriter stringWriter2 = new StringWriter();
                            PemWriter pemWriter2 = new PemWriter(stringWriter2);
                            for (Certificate certificate : certificateArrA) {
                                pemWriter2.writeObject(new PemObject("CERTIFICATE", certificate.getEncoded()));
                            }
                            pemWriter2.close();
                            string2 = stringWriter2.toString();
                        } catch (Exception unused) {
                            string2 = null;
                        }
                    }
                    StringWriter stringWriter3 = new StringWriter();
                    if (x509CertificateArrG.length >= 1) {
                        X509Certificate x509Certificate = x509CertificateArrG[0];
                        PemWriter pemWriter3 = new PemWriter(stringWriter3);
                        pemWriter3.writeObject(new PemObject("CERTIFICATE", x509Certificate.getEncoded()));
                        pemWriter3.close();
                    }
                    String string3 = stringWriter3.toString();
                    if (string2 == null) {
                        str = null;
                    } else {
                        String str2 = string2;
                        str = string;
                        string = str2;
                    }
                    return new String[]{string, str, string3};
                } catch (AssertionError unused2) {
                    if (i == 0) {
                        return null;
                    }
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException unused3) {
                    }
                    return f(applicationContext, i - 1);
                }
            } catch (KeyChainException e) {
                e = e;
                e.printStackTrace();
                return null;
            } catch (a e2) {
                e = e2;
                e.printStackTrace();
                return null;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e4) {
                e = e4;
                e.printStackTrace();
                return null;
            } catch (InterruptedException e5) {
                e = e5;
                e.printStackTrace();
                return null;
            } catch (CertificateException e6) {
                e = e6;
                e.printStackTrace();
                return null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final String toString() {
        return this.c;
    }
}
