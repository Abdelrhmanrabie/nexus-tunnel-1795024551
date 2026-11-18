package defpackage;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Locale;
import org.hamotunnelplus.xyz.R;
import org.json.JSONObject;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;
import renz.javacodez.vpn.service.RenzOpenVPNservice;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class lb1 extends Thread {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final ig b;
    public final bv0 c;
    public String d;
    public final RenzOpenVPNservice f;
    public final String g;
    public gb1 i;
    public File j;
    public File n;
    public String o;
    public gb1 p;
    public String q;
    public String r;
    public String s;
    public Process t;

    static {
        uh.a(-75708119547166L);
    }

    public lb1(RenzOpenVPNservice renzOpenVPNservice, bv0 bv0Var) {
        this.c = bv0Var;
        this.f = renzOpenVPNservice;
        this.b = ig.h(renzOpenVPNservice);
        this.g = renzOpenVPNservice.getFilesDir().getAbsolutePath();
    }

    /* JADX WARN: Code duplicated, block: B:40:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:43:0x0211  */
    /* JADX WARN: Code duplicated, block: B:45:0x0214  */
    public final void a(String str) {
        long j;
        int i;
        String string;
        String strA = str;
        if (strA == null || strA.isEmpty()) {
            return;
        }
        bv0 bv0Var = this.c;
        bv0Var.getClass();
        boolean zContains = strA.contains(uh.a(-83447650614558L));
        RenzOpenVPNservice renzOpenVPNservice = bv0Var.a;
        int i2 = 1;
        if (!zContains) {
            if (strA.contains(uh.a(-84160615185694L))) {
                renzOpenVPNservice.m(uh.a(-84276579302686L));
            } else {
                if (!strA.contains(uh.a(-84542867275038L)) && !strA.contains(uh.a(-84654536424734L))) {
                    if (strA.contains(uh.a(-85109802958110L))) {
                        j = -85268716748062L;
                    } else if (strA.contains(uh.a(-85535004720414L))) {
                        String strA2 = uh.a(-85582249360670L);
                        String strA3 = uh.a(-85633788968222L);
                        boolean z = RenzOpenVPNservice.M;
                        renzOpenVPNservice.g(1, strA2, strA3);
                        j = -85638083935518L;
                    } else if (!strA.contains(uh.a(-86162069945630L))) {
                        return;
                    } else {
                        j = -86252264258846L;
                    }
                    renzOpenVPNservice.m(uh.a(j));
                    renzOpenVPNservice.v();
                    return;
                }
                strA = uh.a(-84804860280094L);
            }
            renzOpenVPNservice.m(strA);
            return;
        }
        renzOpenVPNservice.m(uh.a(-83524960025886L));
        renzOpenVPNservice.m(uh.a(-83829902703902L));
        renzOpenVPNservice.B = ig.h(renzOpenVPNservice);
        int iG = mc1.g(8091, 10);
        o6 o6Var = new o6();
        String str2 = (String) o6Var.a;
        int iC = o6Var.c();
        String strD = o6Var.d();
        Locale.setDefault(new Locale(uh.a(-97066991910174L)));
        VpnService.Builder builder = new VpnService.Builder(renzOpenVPNservice);
        builder.setSession(renzOpenVPNservice.getString(R.string.app));
        builder.addAddress(str2, iC);
        builder.setMtu(1500);
        Intent intent = new Intent(renzOpenVPNservice, (Class<?>) HamoTunnelPlusMain.class);
        intent.addFlags(67108864);
        intent.addFlags(65536);
        char c = 0;
        builder.setConfigureIntent(PendingIntent.getActivity(renzOpenVPNservice, 0, intent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0));
        qz qzVar = new qz(3);
        qzVar.a(new ha(uh.a(-97079876812062L), 0, 0), true);
        try {
            String str3 = ig.c;
            if (str3 != null) {
                qzVar.a(new ha(str3, 32, 0), false);
            }
        } catch (Exception unused) {
        }
        String strD2 = renzOpenVPNservice.B.d();
        String strF = renzOpenVPNservice.B.f();
        if (renzOpenVPNservice.B.v()) {
            renzOpenVPNservice.m(uh.a(-97114236550430L));
            builder.addDnsServer(strD2);
            builder.addDnsServer(strF);
            qzVar.a(new ha(strD2, 32, 0), true);
            qzVar.a(new ha(strF, 32, 0), true);
        } else {
            renzOpenVPNservice.m(uh.a(-97200135896350L));
        }
        ArrayList arrayList = new ArrayList();
        try {
            ok0$a ok0_a = new ok0$a(new ha(uh.a(-97290330209566L), 3, 0), true);
            for (ok0$a ok0_a2 : qzVar.c()) {
                boolean zA = ok0_a.a(ok0_a2);
                int i3 = ok0_a2.c;
                if (!zA) {
                    String strA4 = uh.a(-97333279882526L);
                    String strC = ok0_a2.c();
                    String strValueOf = String.valueOf(i3);
                    i = i2;
                    char c2 = c;
                    try {
                        Object[] objArr = new Object[2];
                        objArr[c2] = strC;
                        objArr[i] = strValueOf;
                        arrayList.add(String.format(strA4, objArr));
                        builder.addRoute(ok0_a2.c(), i3);
                        c = c2;
                        i2 = i;
                    } catch (Exception e) {
                        e = e;
                        renzOpenVPNservice.m(uh.a(-97359049686302L) + e.getMessage());
                        renzOpenVPNservice.G = builder.establish();
                        uo0 uo0Var = new uo0(renzOpenVPNservice, new String[]{strD2, strF}, str2, iG);
                        renzOpenVPNservice.J = uo0Var;
                        uo0Var.b = new bv0(renzOpenVPNservice, i);
                        if (renzOpenVPNservice.B.v()) {
                            renzOpenVPNservice.J.start();
                        }
                        ParcelFileDescriptor parcelFileDescriptor = renzOpenVPNservice.G;
                        String str4 = uh.a(-97646812495134L) + Integer.toString(1080);
                        String str5 = uh.a(-97694057135390L) + Integer.toString(7300);
                        String strA5 = uh.a(-97741301775646L);
                        if (renzOpenVPNservice.B.v()) {
                            StringBuilder sbD = e.d(str2);
                            sbD.append(uh.a(-97801431317790L));
                            sbD.append(iG);
                            string = sbD.toString();
                        } else {
                            string = null;
                        }
                        l81 l81Var = new l81(renzOpenVPNservice, parcelFileDescriptor, strD, strA5, str4, str5, string);
                        renzOpenVPNservice.H = l81Var;
                        l81Var.q = new bv0(renzOpenVPNservice, 2);
                        l81Var.start();
                        renzOpenVPNservice.m(uh.a(-97453538966814L));
                        renzOpenVPNservice.g(1, uh.a(-84113370545438L), uh.a(-84156320218398L));
                    }
                }
            }
            i = i2;
        } catch (Exception e2) {
            e = e2;
            i = i2;
        }
        renzOpenVPNservice.G = builder.establish();
        uo0 uo0Var2 = new uo0(renzOpenVPNservice, new String[]{strD2, strF}, str2, iG);
        renzOpenVPNservice.J = uo0Var2;
        uo0Var2.b = new bv0(renzOpenVPNservice, i);
        if (renzOpenVPNservice.B.v()) {
            renzOpenVPNservice.J.start();
        }
        ParcelFileDescriptor parcelFileDescriptor2 = renzOpenVPNservice.G;
        String str6 = uh.a(-97646812495134L) + Integer.toString(1080);
        String str7 = uh.a(-97694057135390L) + Integer.toString(7300);
        String strA6 = uh.a(-97741301775646L);
        if (renzOpenVPNservice.B.v()) {
            string = null;
        } else {
            StringBuilder sbD2 = e.d(str2);
            sbD2.append(uh.a(-97801431317790L));
            sbD2.append(iG);
            string = sbD2.toString();
        }
        l81 l81Var2 = new l81(renzOpenVPNservice, parcelFileDescriptor2, strD, strA6, str6, str7, string);
        renzOpenVPNservice.H = l81Var2;
        l81Var2.q = new bv0(renzOpenVPNservice, 2);
        l81Var2.start();
        renzOpenVPNservice.m(uh.a(-97453538966814L));
        renzOpenVPNservice.g(1, uh.a(-84113370545438L), uh.a(-84156320218398L));
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        try {
            gb1 gb1Var = this.p;
            if (gb1Var != null) {
                gb1Var.b = true;
                gb1Var.interrupt();
                this.p = null;
            }
        } catch (Exception unused) {
        }
        try {
            gb1 gb1Var2 = this.i;
            if (gb1Var2 != null) {
                gb1Var2.b = true;
                gb1Var2.interrupt();
                this.i = null;
            }
        } catch (Exception unused2) {
        }
        try {
            Process process = this.t;
            if (process != null) {
                process.destroy();
                this.t = null;
            }
        } catch (Exception unused3) {
        }
        File file = this.j;
        if (file != null && file.exists()) {
            this.j.delete();
        }
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String strA;
        String strJ;
        int length;
        int i;
        Inet4Address inet4Address;
        String strA2 = uh.a(-69055215205662L);
        String str = this.g;
        this.n = new File(str, strA2);
        ig igVar = this.b;
        String strM = igVar.m();
        hy0 hy0Var = igVar.a;
        InetAddress[] allByName = new InetAddress[0];
        try {
            try {
                allByName = InetAddress.getAllByName(strM);
                while (true) {
                    if (i >= length) {
                        inet4Address = null;
                        break;
                    }
                    InetAddress inetAddress = allByName[i];
                    if (inetAddress instanceof Inet4Address) {
                        inet4Address = (Inet4Address) inetAddress;
                        break;
                    }
                    i++;
                }
            } catch (UnknownHostException e) {
                a(e.getMessage());
                e.printStackTrace();
            }
            length = allByName.length;
            i = 0;
            this.d = inet4Address.getHostAddress();
        } catch (Exception e2) {
            a(e2.getMessage());
        }
        String string = null;
        ig.c = this.d;
        this.s = this.d + uh.a(-69098164878622L) + igVar.n();
        this.r = uh.a(-69106754813214L);
        this.o = uh.a(-69119639715102L);
        uh.a(-69184064224542L);
        try {
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(uh.a(-69231308864798L), this.s);
                    int i2 = hy0Var.getInt(uh.a(-133204846738718L), 0);
                    try {
                        if (i2 != 0) {
                            if (i2 == 1) {
                                jSONObject.put(uh.a(-69368747818270L), igVar.r());
                                strA = igVar.r().trim().contains(uh.a(-69390222654750L)) ? uh.a(-69398812589342L) : uh.a(-69437467295006L);
                                strJ = igVar.j();
                            }
                            jSONObject.put(uh.a(-69458942131486L), Integer.parseInt(hy0Var.getString(uh.a(-133677293141278L), uh.a(-133720242814238L))));
                            jSONObject.put(uh.a(-69493301869854L), Integer.parseInt(hy0Var.getString(uh.a(-133767487454494L), uh.a(-133810437127454L))));
                            jSONObject.put(uh.a(-69536251542814L), Integer.parseInt(this.r));
                            jSONObject.put(uh.a(-69562021346590L), 1);
                            jSONObject.put(uh.a(-69626445856030L), true);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(uh.a(-69665100561694L), this.o);
                            jSONObject.put(uh.a(-69695165332766L), jSONObject2);
                            String string2 = hy0Var.getString(uh.a(-133917811309854L), uh.a(-134020890524958L));
                            this.q = String.valueOf((Integer.parseInt(string2) * 5) / 2);
                            jSONObject.put(uh.a(-69725230103838L), Integer.parseInt(string2));
                            jSONObject.put(uh.a(-69798244547870L), Integer.parseInt(this.q));
                            string = jSONObject.toString(2);
                            this.j = new File(str, uh.a(-69849784155422L));
                            File file = this.n;
                            String strA3 = uh.a(-69901323762974L);
                            PrintWriter printWriter = new PrintWriter(file);
                            printWriter.println(strA3);
                            printWriter.flush();
                            printWriter.close();
                            String strA4 = uh.a(-75437536607518L);
                            RenzOpenVPNservice renzOpenVPNservice = this.f;
                            String[] strArr = {b2.b(renzOpenVPNservice, strA4, new File(renzOpenVPNservice.getFilesDir(), uh.a(-75489076215070L))).getAbsolutePath(), uh.a(-75540615822622L), uh.a(-75553500724510L), uh.a(-75596450397470L), string};
                            o6 o6Var = new o6(this);
                            Process processStart = new ProcessBuilder(new String[0]).command(strArr).redirectErrorStream(true).start();
                            this.t = processStart;
                            this.p = new gb1(processStart.getInputStream(), o6Var);
                            this.i = new gb1(this.t.getErrorStream(), o6Var);
                            gb1 gb1Var = this.p;
                            gb1Var.b = false;
                            gb1Var.start();
                            gb1 gb1Var2 = this.i;
                            gb1Var2.b = false;
                            gb1Var2.start();
                            this.t.waitFor();
                            super.run();
                            return;
                        }
                        jSONObject.put(uh.a(-69261373635870L), !hy0Var.getString(uh.a(-131388075572510L), uh.a(-131435320212766L)).isEmpty() ? hy0Var.getString(uh.a(-131388075572510L), uh.a(-131435320212766L)) : uh.a(-69282848472350L));
                        strA = uh.a(-69304323308830L);
                        strJ = String.format(uh.a(-69342978014494L), igVar.r(), igVar.j());
                        this.q = String.valueOf((Integer.parseInt(string2) * 5) / 2);
                    } catch (NumberFormatException e3) {
                        e3.printStackTrace();
                    }
                    jSONObject.put(strA, strJ);
                    jSONObject.put(uh.a(-69458942131486L), Integer.parseInt(hy0Var.getString(uh.a(-133677293141278L), uh.a(-133720242814238L))));
                    jSONObject.put(uh.a(-69493301869854L), Integer.parseInt(hy0Var.getString(uh.a(-133767487454494L), uh.a(-133810437127454L))));
                    jSONObject.put(uh.a(-69536251542814L), Integer.parseInt(this.r));
                    jSONObject.put(uh.a(-69562021346590L), 1);
                    jSONObject.put(uh.a(-69626445856030L), true);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(uh.a(-69665100561694L), this.o);
                    jSONObject.put(uh.a(-69695165332766L), jSONObject3);
                    String string3 = hy0Var.getString(uh.a(-133917811309854L), uh.a(-134020890524958L));
                    jSONObject.put(uh.a(-69725230103838L), Integer.parseInt(string3));
                    jSONObject.put(uh.a(-69798244547870L), Integer.parseInt(this.q));
                    string = jSONObject.toString(2);
                } catch (Exception unused) {
                }
                Process processStart2 = new ProcessBuilder(new String[0]).command(strArr).redirectErrorStream(true).start();
                this.t = processStart2;
                this.p = new gb1(processStart2.getInputStream(), o6Var);
                this.i = new gb1(this.t.getErrorStream(), o6Var);
                gb1 gb1Var3 = this.p;
                gb1Var3.b = false;
                gb1Var3.start();
                gb1 gb1Var4 = this.i;
                gb1Var4.b = false;
                gb1Var4.start();
                this.t.waitFor();
            } catch (Exception unused2) {
            }
            PrintWriter printWriter2 = new PrintWriter(file);
            printWriter2.println(strA3);
            printWriter2.flush();
            printWriter2.close();
            String strA5 = uh.a(-75437536607518L);
            RenzOpenVPNservice renzOpenVPNservice2 = this.f;
            String[] strArr2 = {b2.b(renzOpenVPNservice2, strA5, new File(renzOpenVPNservice2.getFilesDir(), uh.a(-75489076215070L))).getAbsolutePath(), uh.a(-75540615822622L), uh.a(-75553500724510L), uh.a(-75596450397470L), string};
            o6 o6Var2 = new o6(this);
            super.run();
            return;
        } catch (Exception e4) {
            e4.printStackTrace();
            interrupt();
            return;
        }
        this.j = new File(str, uh.a(-69849784155422L));
        File file2 = this.n;
        String strA6 = uh.a(-69901323762974L);
    }
}
