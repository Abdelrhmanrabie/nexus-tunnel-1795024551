package com.trilead.ssh2.transport;

import defpackage.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ClientServerHello {
    String client_line = "SSH-2.0-TrileadSSH2Java_213";
    String server_line;
    String server_versioncomment;

    public ClientServerHello(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i;
        try {
            outputStream.write((this.client_line + "\r\n").getBytes(InternalZipConstants.AES_HASH_CHARSET));
        } catch (UnsupportedEncodingException unused) {
            outputStream.write((this.client_line + "\r\n").getBytes());
        }
        outputStream.flush();
        byte[] bArr = new byte[512];
        for (int i2 = 0; i2 < 50; i2++) {
            int lineRN = readLineRN(inputStream, bArr);
            try {
                this.server_line = new String(bArr, 0, lineRN, InternalZipConstants.AES_HASH_CHARSET);
            } catch (UnsupportedEncodingException unused2) {
                this.server_line = new String(bArr, 0, lineRN);
            }
            if (this.server_line.startsWith("SSH-")) {
                break;
            }
        }
        if (!this.server_line.startsWith("SSH-")) {
            d.AnonymousClass0.m$6("Malformed server identification string. There was no line starting with 'SSH-' amongst the first 50 lines.");
            throw null;
        }
        boolean zStartsWith = this.server_line.startsWith("SSH-1.99-");
        String str = this.server_line;
        if (zStartsWith) {
            i = 9;
        } else {
            if (!str.startsWith("SSH-2.0-")) {
                d.AnonymousClass0.m$6("Server uses incompatible protocol, it is not SSH-2 compatible.");
                throw null;
            }
            str = this.server_line;
            i = 8;
        }
        this.server_versioncomment = str.substring(i);
    }

    public static final int readLineRN(InputStream inputStream, byte[] bArr) throws IOException {
        String str;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = inputStream.read();
            if (i3 == -1) {
                str = "Premature connection close";
                break;
            }
            int i4 = i + 1;
            bArr[i] = (byte) i3;
            if (i3 != 13) {
                if (i3 != 10) {
                    if (!z) {
                        i2++;
                        if (i4 >= bArr.length) {
                            str = "The server sent a too long line.";
                            break;
                        }
                    } else {
                        str = "Malformed line sent by the server, the line does not end correctly.";
                        break;
                    }
                } else {
                    return i2;
                }
            } else {
                z = true;
            }
            i = i4;
        }
        d.AnonymousClass0.m$6(str);
        return 0;
    }

    public byte[] getClientString() {
        try {
            return this.client_line.getBytes(InternalZipConstants.AES_HASH_CHARSET);
        } catch (UnsupportedEncodingException unused) {
            return this.client_line.getBytes();
        }
    }

    public byte[] getServerString() {
        try {
            return this.server_line.getBytes(InternalZipConstants.AES_HASH_CHARSET);
        } catch (UnsupportedEncodingException unused) {
            return this.server_line.getBytes();
        }
    }
}
