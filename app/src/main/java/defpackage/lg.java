package defpackage;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Locale;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class lg implements Serializable, Cloneable {
    public boolean q;
    public String b = "openvpn.example.com";
    public String c = "1194";
    public boolean d = true;
    public String f = AppConfig.CUSTOM;
    public boolean g = false;
    public boolean i = true;
    public int j = 0;
    public int n = 1;
    public String o = "proxy.example.com";
    public String p = "8080";
    public String r = null;
    public String s = null;

    public final lg a() {
        return (lg) super.clone();
    }

    public final String c(boolean z) {
        StringBuilder sbD = e.d(ak.j("remote " + this.b, " "));
        sbD.append(this.c);
        String string = sbD.toString();
        boolean z2 = this.d;
        StringBuilder sbD2 = e.d(string);
        sbD2.append(z2 ? " udp\n" : " tcp-client\n");
        String string2 = sbD2.toString();
        if (this.j != 0) {
            StringBuilder sbD3 = e.d(string2);
            Locale locale = Locale.US;
            sbD3.append(" connect-timeout  " + this.j + "\n");
            string2 = sbD3.toString();
        }
        if ((z || d()) && this.n == 2) {
            StringBuilder sbD4 = e.d(string2);
            Locale locale2 = Locale.US;
            sbD4.append("http-proxy " + this.o + " " + this.p + "\n");
            string2 = sbD4.toString();
            if (this.q) {
                StringBuilder sbD5 = e.d(string2);
                sbD5.append("<http-proxy-user-pass>\n" + this.r + "\n" + this.s + "\n</http-proxy-user-pass>\n");
                string2 = sbD5.toString();
            }
        }
        if (d() && this.n == 3) {
            StringBuilder sbD6 = e.d(string2);
            Locale locale3 = Locale.US;
            sbD6.append("socks-proxy " + this.o + " " + this.p + "\n");
            string2 = sbD6.toString();
        }
        if (TextUtils.isEmpty(this.f) || !this.g) {
            return string2;
        }
        StringBuilder sbD7 = e.d(string2);
        sbD7.append(this.f);
        return ak.j(sbD7.toString(), "\n");
    }

    public final Object clone() {
        return (lg) super.clone();
    }

    public final boolean d() {
        return this.g && this.f.contains("http-proxy-option ");
    }
}
