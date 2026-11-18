package renz.javacodez.v2ray.dto;

import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.e;
import defpackage.e4;
import defpackage.fb$1;
import defpackage.zk;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class VmessQRCode {
    private String add;
    private String aid;
    private String alpn;
    private String fp;
    private String host;
    private String id;

    /* JADX INFO: renamed from: net, reason: collision with root package name */
    private String f74net;
    private String path;
    private String port;
    private String ps;
    private String scy;
    private String sni;
    private String tls;
    private String type;
    private String v;

    public VmessQRCode() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public VmessQRCode(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        this.v = str;
        this.ps = str2;
        this.add = str3;
        this.port = str4;
        this.id = str5;
        this.aid = str6;
        this.scy = str7;
        this.f74net = str8;
        this.type = str9;
        this.host = str10;
        this.path = str11;
        this.tls = str12;
        this.sni = str13;
        this.alpn = str14;
        this.fp = str15;
    }

    public /* synthetic */ VmessQRCode(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, zk zkVar) {
        this((i & 1) != 0 ? AppConfig.CUSTOM : str, (i & 2) != 0 ? AppConfig.CUSTOM : str2, (i & 4) != 0 ? AppConfig.CUSTOM : str3, (i & 8) != 0 ? AppConfig.CUSTOM : str4, (i & 16) != 0 ? AppConfig.CUSTOM : str5, (i & 32) != 0 ? "0" : str6, (i & 64) != 0 ? AppConfig.CUSTOM : str7, (i & 128) != 0 ? AppConfig.CUSTOM : str8, (i & 256) != 0 ? AppConfig.CUSTOM : str9, (i & 512) != 0 ? AppConfig.CUSTOM : str10, (i & 1024) != 0 ? AppConfig.CUSTOM : str11, (i & 2048) != 0 ? AppConfig.CUSTOM : str12, (i & 4096) != 0 ? AppConfig.CUSTOM : str13, (i & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0 ? AppConfig.CUSTOM : str14, (i & AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME) != 0 ? AppConfig.CUSTOM : str15);
    }

    public final String component1() {
        return this.v;
    }

    public final String component10() {
        return this.host;
    }

    public final String component11() {
        return this.path;
    }

    public final String component12() {
        return this.tls;
    }

    public final String component13() {
        return this.sni;
    }

    public final String component14() {
        return this.alpn;
    }

    public final String component15() {
        return this.fp;
    }

    public final String component2() {
        return this.ps;
    }

    public final String component3() {
        return this.add;
    }

    public final String component4() {
        return this.port;
    }

    public final String component5() {
        return this.id;
    }

    public final String component6() {
        return this.aid;
    }

    public final String component7() {
        return this.scy;
    }

    public final String component8() {
        return this.f74net;
    }

    public final String component9() {
        return this.type;
    }

    public final VmessQRCode copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        return new VmessQRCode(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VmessQRCode)) {
            return false;
        }
        VmessQRCode vmessQRCode = (VmessQRCode) obj;
        return e4.a(this.v, vmessQRCode.v) && e4.a(this.ps, vmessQRCode.ps) && e4.a(this.add, vmessQRCode.add) && e4.a(this.port, vmessQRCode.port) && e4.a(this.id, vmessQRCode.id) && e4.a(this.aid, vmessQRCode.aid) && e4.a(this.scy, vmessQRCode.scy) && e4.a(this.f74net, vmessQRCode.f74net) && e4.a(this.type, vmessQRCode.type) && e4.a(this.host, vmessQRCode.host) && e4.a(this.path, vmessQRCode.path) && e4.a(this.tls, vmessQRCode.tls) && e4.a(this.sni, vmessQRCode.sni) && e4.a(this.alpn, vmessQRCode.alpn) && e4.a(this.fp, vmessQRCode.fp);
    }

    public final String getAdd() {
        return this.add;
    }

    public final String getAid() {
        return this.aid;
    }

    public final String getAlpn() {
        return this.alpn;
    }

    public final String getFp() {
        return this.fp;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getId() {
        return this.id;
    }

    public final String getNet() {
        return this.f74net;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getPort() {
        return this.port;
    }

    public final String getPs() {
        return this.ps;
    }

    public final String getScy() {
        return this.scy;
    }

    public final String getSni() {
        return this.sni;
    }

    public final String getTls() {
        return this.tls;
    }

    public final String getType() {
        return this.type;
    }

    public final String getV() {
        return this.v;
    }

    public int hashCode() {
        return this.fp.hashCode() + e.d(e.d(e.d(e.d(e.d(e.d(e.d(e.d(e.d(e.d(e.d(e.d(e.d(this.v.hashCode() * 31, this.ps), this.add), this.port), this.id), this.aid), this.scy), this.f74net), this.type), this.host), this.path), this.tls), this.sni), this.alpn);
    }

    public final void setAdd(String str) {
        this.add = str;
    }

    public final void setAid(String str) {
        this.aid = str;
    }

    public final void setAlpn(String str) {
        this.alpn = str;
    }

    public final void setFp(String str) {
        this.fp = str;
    }

    public final void setHost(String str) {
        this.host = str;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setNet(String str) {
        this.f74net = str;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void setPort(String str) {
        this.port = str;
    }

    public final void setPs(String str) {
        this.ps = str;
    }

    public final void setScy(String str) {
        this.scy = str;
    }

    public final void setSni(String str) {
        this.sni = str;
    }

    public final void setTls(String str) {
        this.tls = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setV(String str) {
        this.v = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VmessQRCode(v=");
        sb.append(this.v);
        sb.append(", ps=");
        sb.append(this.ps);
        sb.append(", add=");
        sb.append(this.add);
        sb.append(", port=");
        sb.append(this.port);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", aid=");
        sb.append(this.aid);
        sb.append(", scy=");
        sb.append(this.scy);
        sb.append(", net=");
        sb.append(this.f74net);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", host=");
        sb.append(this.host);
        sb.append(", path=");
        sb.append(this.path);
        sb.append(", tls=");
        sb.append(this.tls);
        sb.append(", sni=");
        sb.append(this.sni);
        sb.append(", alpn=");
        sb.append(this.alpn);
        sb.append(", fp=");
        return fb$1.m(sb, this.fp, ')');
    }
}
