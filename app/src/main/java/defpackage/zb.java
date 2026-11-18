package defpackage;

import android.text.TextUtils;
import com.trilead.ssh2.sftp.AttribFlags;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class zb {
    public static final Pattern o = Pattern.compile("(.*):([\\d]+)");
    public static final Pattern p = Pattern.compile("(https?)://([^:/]+)(:[\\d]+])?/.*");
    public SocketChannel a;
    public SelectionKey b;
    public ByteBuffer c;
    public int d;
    public String g;
    public final boolean i;
    public String j;
    public int k;
    public String l;
    public bc m;
    public m6 n;
    public char[] e = new char[1024];
    public final HashMap h = new HashMap();
    public int f = 0;

    public zb(boolean z) {
        this.i = z;
        e();
    }

    public final String a() {
        int i;
        if (!this.i) {
            return null;
        }
        String strJ = (String) this.n.b;
        if (strJ == null || strJ.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            strJ = ak.j((String) this.h.get("Host"), strJ);
        }
        if ("CONNECT".equals(this.j)) {
            Matcher matcher = o.matcher(strJ);
            if (matcher.matches()) {
                this.l = matcher.group(1);
                i = Integer.parseInt(matcher.group(2));
                this.k = i;
            }
        } else {
            Matcher matcher2 = p.matcher(strJ);
            if (matcher2.matches()) {
                this.l = matcher2.group(2);
                if (matcher2.group(3) != null) {
                    Integer.parseInt(matcher2.group(3).substring(1));
                } else {
                    i = "renz".equals(matcher2.group(1)) ? AppConfig.DEFAULT_PORT : 80;
                    this.k = i;
                }
            }
        }
        return this.l;
    }

    /* JADX WARN: Code duplicated, block: B:119:0x023a  */
    /* JADX WARN: Code duplicated, block: B:124:0x024c A[EDGE_INSN: B:124:0x024c->B:146:0x02e5 BREAK  A[LOOP:0: B:27:0x0067->B:185:0x0067]] */
    /* JADX WARN: Code duplicated, block: B:166:0x023e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0161 A[Catch: Exception -> 0x023a, TRY_ENTER, TryCatch #2 {Exception -> 0x023a, blocks: (B:71:0x0118, B:74:0x0120, B:76:0x012b, B:77:0x012e, B:92:0x0161, B:94:0x017e, B:96:0x0189, B:116:0x0230, B:117:0x0233, B:97:0x01a2, B:100:0x01be, B:104:0x01d1, B:106:0x01d7, B:107:0x01e3, B:111:0x01f2, B:112:0x0200, B:114:0x0206, B:115:0x021f, B:110:0x01ee, B:103:0x01c5, B:93:0x017b), top: B:162:0x0118 }] */
    public final void c() throws IOException {
        int i;
        String strCopyValueOf;
        byte b;
        bc bcVar;
        zb zbVar;
        zb zbVar2;
        ByteBuffer byteBufferWrap;
        zb zbVar3;
        SocketChannel socketChannelOpen;
        int iIndexOf;
        if (this.c == null) {
            this.c = ByteBuffer.allocate(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
        }
        this.c.clear();
        try {
            i = this.a.read(this.c);
        } catch (IOException unused) {
            i = 0;
        }
        this.c.flip();
        int iLimit = this.c.limit() - this.c.position();
        if (i == -1) {
            bc bcVar2 = this.m;
            if (bcVar2 != null) {
                Objects.toString(this);
                zb zbVar4 = bcVar2.a;
                if (zbVar4 != null) {
                    try {
                        zbVar4.b.cancel();
                        zbVar4.a.close();
                    } catch (Exception unused2) {
                    }
                }
                zb zbVar5 = bcVar2.b;
                if (zbVar5 != null) {
                    try {
                        zbVar5.b.cancel();
                        zbVar5.a.close();
                        return;
                    } catch (Exception unused3) {
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (iLimit == 0) {
            return;
        }
        if (this.d == 3) {
            bcVar = this.m;
            if (bcVar == null) {
                return;
            }
        } else {
            while (true) {
                String str = null;
                if (this.c.remaining() <= 0) {
                    strCopyValueOf = null;
                } else {
                    while (this.c.remaining() > 0 && (b = this.c.get()) != -1 && b != 10) {
                        if (b != 13) {
                            int i2 = this.f;
                            char[] cArr = this.e;
                            if (i2 == cArr.length) {
                                char[] cArr2 = new char[cArr.length * 2];
                                this.e = cArr2;
                                System.arraycopy(cArr, 0, cArr2, 0, i2);
                            }
                            char[] cArr3 = this.e;
                            int i3 = this.f;
                            this.f = i3 + 1;
                            cArr3[i3] = (char) b;
                        }
                    }
                    strCopyValueOf = String.copyValueOf(this.e, 0, this.f);
                    this.f = 0;
                }
                if (strCopyValueOf == null) {
                    break;
                }
                int i4 = this.d;
                boolean z = this.i;
                if (i4 == 1) {
                    this.g = strCopyValueOf;
                    if (z) {
                        m6 m6Var = new m6(strCopyValueOf);
                        this.n = m6Var;
                        this.j = (String) m6Var.a;
                    } else if (!TextUtils.isEmpty(strCopyValueOf)) {
                        try {
                            int iIndexOf2 = strCopyValueOf.indexOf(" ");
                            if (iIndexOf2 != -1) {
                                strCopyValueOf.substring(0, iIndexOf2);
                                String strSubstring = strCopyValueOf.substring(iIndexOf2 + 1);
                                int iIndexOf3 = strSubstring.indexOf(" ");
                                if (iIndexOf3 != -1) {
                                    Integer.parseInt(strSubstring.substring(0, iIndexOf3));
                                    strSubstring.substring(iIndexOf3 + 1);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    this.d = 2;
                } else if (i4 == 2) {
                    boolean zIsEmpty = TextUtils.isEmpty(strCopyValueOf);
                    HashMap map = this.h;
                    if (zIsEmpty) {
                        this.d = 3;
                        bc bcVar3 = this.m;
                        if (bcVar3 == null) {
                            break;
                        }
                        try {
                            if (z) {
                                try {
                                    String str2 = this.j;
                                    zb zbVar6 = bcVar3.b;
                                    if (zbVar6 == null) {
                                        "CONNECT".equals(str2);
                                        String strA = a();
                                        if (this.k == 0) {
                                            a();
                                        }
                                        int i5 = this.k;
                                        try {
                                            socketChannelOpen = SocketChannel.open();
                                            socketChannelOpen.configureBlocking(false);
                                            if (!socketChannelOpen.connect(new InetSocketAddress(InetAddress.getByName(strA), i5))) {
                                                int i6 = 0;
                                                while (true) {
                                                    if (i6 < 200) {
                                                        Thread.sleep(50L);
                                                        if (socketChannelOpen.finishConnect()) {
                                                            break;
                                                        } else {
                                                            i6++;
                                                        }
                                                    }
                                                }
                                                if (socketChannelOpen == null) {
                                                    zbVar = bcVar3.a;
                                                    if (zbVar != null) {
                                                        try {
                                                            zbVar.b.cancel();
                                                            zbVar.a.close();
                                                        } catch (Exception unused4) {
                                                        }
                                                    }
                                                    zbVar2 = bcVar3.b;
                                                    if (zbVar2 != null) {
                                                        break;
                                                    }
                                                    zbVar2.b.cancel();
                                                    zbVar2.a.close();
                                                    break;
                                                }
                                                zb zbVar7 = new zb(false);
                                                bcVar3.b = zbVar7;
                                                zbVar7.m = bcVar3;
                                                zbVar7.a = socketChannelOpen;
                                                bcVar3.b.b = socketChannelOpen.register(bs0.a().c, 1, bcVar3);
                                            }
                                        } catch (Exception unused5) {
                                        }
                                        socketChannelOpen = null;
                                        if (socketChannelOpen == null) {
                                            zbVar = bcVar3.a;
                                            if (zbVar != null) {
                                                zbVar.b.cancel();
                                                zbVar.a.close();
                                            }
                                            zbVar2 = bcVar3.b;
                                            if (zbVar2 != null) {
                                                break;
                                            }
                                            zbVar2.b.cancel();
                                            zbVar2.a.close();
                                            break;
                                        }
                                        zb zbVar8 = new zb(false);
                                        bcVar3.b = zbVar8;
                                        zbVar8.m = bcVar3;
                                        zbVar8.a = socketChannelOpen;
                                        bcVar3.b.b = socketChannelOpen.register(bs0.a().c, 1, bcVar3);
                                    } else {
                                        zbVar6.e();
                                    }
                                    StringBuffer stringBuffer = new StringBuffer();
                                    if ("CONNECT".equals(str2)) {
                                        stringBuffer.append("HTTP/1.0 200 Connection Established\r\nProxy-agent: KissProxy\r\n\r\n");
                                        bcVar3.b.d = 3;
                                        byteBufferWrap = ByteBuffer.wrap(stringBuffer.toString().getBytes());
                                        zbVar3 = bcVar3.a;
                                    } else {
                                        stringBuffer.append(str2 + " ");
                                        String strJ = (String) this.n.b;
                                        if (strJ == null || strJ.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                                            strJ = ak.j((String) map.get("Host"), strJ);
                                        }
                                        if (!strJ.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                                            strJ = strJ.substring(strJ.indexOf(47, 8));
                                        }
                                        stringBuffer.append(strJ);
                                        stringBuffer.append(" ");
                                        m6 m6Var2 = this.n;
                                        if (m6Var2 != null) {
                                            str = (String) m6Var2.c;
                                        }
                                        stringBuffer.append(str);
                                        stringBuffer.append("\r\n");
                                        for (String str3 : map.keySet()) {
                                            stringBuffer.append(str3);
                                            stringBuffer.append(": ");
                                            stringBuffer.append((String) map.get(str3));
                                            stringBuffer.append("\r\n");
                                        }
                                        stringBuffer.append("\r\n");
                                        byteBufferWrap = ByteBuffer.wrap(stringBuffer.toString().getBytes());
                                        zbVar3 = bcVar3.b;
                                    }
                                    zbVar3.getClass();
                                    zbVar3.a.write(byteBufferWrap);
                                } catch (Exception unused6) {
                                }
                            } else {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append(this.g);
                                stringBuffer2.append("\r\n");
                                for (Map.Entry entry : map.entrySet()) {
                                    stringBuffer2.append((String) entry.getKey());
                                    stringBuffer2.append(": ");
                                    stringBuffer2.append((String) entry.getValue());
                                    stringBuffer2.append("\r\n");
                                }
                                stringBuffer2.append("\r\n");
                                ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(stringBuffer2.toString().getBytes());
                                zb zbVar9 = bcVar3.a;
                                zbVar9.getClass();
                                zbVar9.a.write(byteBufferWrap2);
                            }
                            break;
                        } catch (IOException | Exception unused7) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(strCopyValueOf) && (iIndexOf = strCopyValueOf.indexOf(":")) > 0 && iIndexOf < strCopyValueOf.length()) {
                        String strSubstring2 = strCopyValueOf.substring(0, iIndexOf);
                        String strTrim = strCopyValueOf.substring(iIndexOf + 1).trim();
                        if (!TextUtils.isEmpty(strSubstring2) && !TextUtils.isEmpty(strTrim)) {
                            map.put(strSubstring2, strTrim);
                        }
                    }
                } else {
                    continue;
                }
            }
            if (this.d != 3 || (bcVar = this.m) == null) {
                return;
            }
        }
        bcVar.b(this);
    }

    public final void e() {
        System.currentTimeMillis();
        this.d = "CONNECT".equals(this.j) ? 3 : 1;
        this.h.clear();
    }
}
