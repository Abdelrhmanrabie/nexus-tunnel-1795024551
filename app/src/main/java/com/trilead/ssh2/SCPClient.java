package com.trilead.ssh2;

import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SCPClient {
    Connection conn;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class LenNamePair {
        String filename;
        long length;

        public LenNamePair() {
        }
    }

    public SCPClient(Connection connection) {
        if (connection != null) {
            this.conn = connection;
        } else {
            d.AnonymousClass0.m$2("Cannot accept null argument!");
            throw null;
        }
    }

    private void get(String[] strArr, OutputStream[] outputStreamArr) {
        String str;
        if (strArr == null || outputStreamArr == null) {
            str = "Null argument.";
        } else {
            if (strArr.length == outputStreamArr.length) {
                if (strArr.length == 0) {
                    return;
                }
                String strJ = "scp -f";
                for (String str2 : strArr) {
                    if (str2 != null) {
                        String strTrim = str2.trim();
                        if (strTrim.length() != 0) {
                            strJ = e.j(strJ, " ", strTrim);
                        } else {
                            str = "Cannot accept empty filename.";
                        }
                    } else {
                        str = "Cannot accept null filename.";
                    }
                }
                Session sessionOpenSession = null;
                try {
                    try {
                        sessionOpenSession = this.conn.openSession();
                        sessionOpenSession.execCommand(strJ);
                        receiveFiles(sessionOpenSession, outputStreamArr);
                        sessionOpenSession.close();
                        return;
                    } catch (IOException e) {
                        throw new IOException("Error during SCP transfer.", e);
                    }
                } catch (Throwable th) {
                    if (sessionOpenSession != null) {
                        sessionOpenSession.close();
                    }
                    throw th;
                }
            }
            str = "Length of arguments does not match.";
        }
        d.AnonymousClass0.m$2(str);
    }

    private LenNamePair parseCLine(String str) throws IOException {
        String str2;
        if (str.length() < 8) {
            str2 = "Malformed C line sent by remote SCP binary, line too short.";
        } else {
            if (str.charAt(4) != ' ' || str.charAt(5) == ' ') {
                d.AnonymousClass0.m$6("Malformed C line sent by remote SCP binary.");
                return null;
            }
            int iIndexOf = str.indexOf(32, 5);
            if (iIndexOf == -1) {
                d.AnonymousClass0.m$6("Malformed C line sent by remote SCP binary.");
                return null;
            }
            String strSubstring = str.substring(5, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf + 1);
            if (strSubstring.length() <= 0 || strSubstring2.length() <= 0) {
                d.AnonymousClass0.m$6("Malformed C line sent by remote SCP binary.");
                return null;
            }
            if (strSubstring2.length() + strSubstring.length() + 6 != str.length()) {
                d.AnonymousClass0.m$6("Malformed C line sent by remote SCP binary.");
                return null;
            }
            try {
                long j = Long.parseLong(strSubstring);
                if (j >= 0) {
                    LenNamePair lenNamePair = new LenNamePair();
                    lenNamePair.length = j;
                    lenNamePair.filename = strSubstring2;
                    return lenNamePair;
                }
                str2 = "Malformed C line sent by remote SCP binary, illegal file length.";
            } catch (NumberFormatException unused) {
                str2 = "Malformed C line sent by remote SCP binary, cannot parse file length.";
            }
        }
        d.AnonymousClass0.m$6(str2);
        return null;
    }

    private void readResponse(InputStream inputStream) throws IOException {
        String str;
        int i = inputStream.read();
        if (i == 0) {
            return;
        }
        if (i == -1) {
            str = "Remote scp terminated unexpectedly.";
        } else if (i != 1 && i != 2) {
            str = "Remote scp sent illegal error code.";
        } else {
            if (i != 2) {
                throw new IOException(e.n("Remote scp terminated with error (", receiveLine(inputStream), ")."));
            }
            str = "Remote scp terminated with error.";
        }
        d.AnonymousClass0.m$6(str);
    }

    private void receiveFiles(Session session, OutputStream[] outputStreamArr) throws IOException {
        int i;
        String str;
        String strReceiveLine;
        byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(session.getStdin(), 512);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(session.getStdout(), 40000);
        bufferedOutputStream.write(0);
        bufferedOutputStream.flush();
        for (OutputStream outputStream : outputStreamArr) {
            do {
                i = bufferedInputStream.read();
                if (i >= 0) {
                    strReceiveLine = receiveLine(bufferedInputStream);
                } else {
                    str = "Remote scp terminated unexpectedly.";
                }
                d.AnonymousClass0.m$6(str);
                return;
            } while (i == 84);
            if (i == 1 || i == 2) {
                throw new IOException(ak.m("Remote SCP error: ", strReceiveLine));
            }
            if (i != 67) {
                throw new IOException("Remote SCP error: " + ((char) i) + strReceiveLine);
            }
            LenNamePair cLine = parseCLine(strReceiveLine);
            bufferedOutputStream.write(0);
            bufferedOutputStream.flush();
            long j = cLine.length;
            while (j > 0) {
                int i2 = bufferedInputStream.read(bArr, 0, j > ((long) AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) ? 8192 : (int) j);
                if (i2 < 0) {
                    str = "Remote scp terminated connection unexpectedly";
                    d.AnonymousClass0.m$6(str);
                    return;
                } else {
                    outputStream.write(bArr, 0, i2);
                    j -= (long) i2;
                }
            }
            readResponse(bufferedInputStream);
            bufferedOutputStream.write(0);
            bufferedOutputStream.flush();
        }
    }

    private void receiveFiles(Session session, String[] strArr, String str) throws Throwable {
        int i;
        String strReceiveLine;
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(session.getStdin(), 512);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(session.getStdout(), 40000);
        bufferedOutputStream.write(0);
        bufferedOutputStream.flush();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            do {
                i = bufferedInputStream.read();
                if (i < 0) {
                    d.AnonymousClass0.m$6("Remote scp terminated unexpectedly.");
                    return;
                }
                strReceiveLine = receiveLine(bufferedInputStream);
            } while (i == 84);
            if (i == 1 || i == 2) {
                throw new IOException(ak.m("Remote SCP error: ", strReceiveLine));
            }
            if (i != 67) {
                throw new IOException("Remote SCP error: " + ((char) i) + strReceiveLine);
            }
            LenNamePair cLine = parseCLine(strReceiveLine);
            bufferedOutputStream.write(0);
            bufferedOutputStream.flush();
            StringBuilder sbD = e.d(str);
            sbD.append(File.separatorChar);
            sbD.append(cLine.filename);
            try {
                fileOutputStream = new FileOutputStream(new File(sbD.toString()));
                try {
                    long j = cLine.length;
                    while (j > 0) {
                        int i3 = bufferedInputStream.read(bArr, 0, j > ((long) AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) ? 8192 : (int) j);
                        if (i3 < 0) {
                            throw new IOException("Remote scp terminated connection unexpectedly");
                        }
                        fileOutputStream.write(bArr, 0, i3);
                        j -= (long) i3;
                    }
                    fileOutputStream.close();
                    readResponse(bufferedInputStream);
                    bufferedOutputStream.write(0);
                    bufferedOutputStream.flush();
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        }
    }

    private String receiveLine(InputStream inputStream) throws IOException {
        String str;
        StringBuffer stringBuffer = new StringBuffer(30);
        while (stringBuffer.length() <= 8192) {
            int i = inputStream.read();
            if (i < 0) {
                str = "Remote scp terminated unexpectedly.";
                d.AnonymousClass0.m$6(str);
                return null;
            }
            if (i == 10) {
                return stringBuffer.toString();
            }
            stringBuffer.append((char) i);
        }
        str = "Remote scp sent a too long line";
        d.AnonymousClass0.m$6(str);
        return null;
    }

    private void sendBytes(Session session, byte[] bArr, String str, String str2) throws IOException {
        OutputStream stdin = session.getStdin();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(session.getStdout(), 512);
        readResponse(bufferedInputStream);
        StringBuilder sbQ = ak.q("C", str2, " ");
        sbQ.append(bArr.length);
        sbQ.append(" ");
        sbQ.append(str);
        sbQ.append("\n");
        String string = sbQ.toString();
        try {
            stdin.write(string.getBytes(InternalZipConstants.AES_HASH_CHARSET));
        } catch (UnsupportedEncodingException unused) {
            stdin.write(string.getBytes());
        }
        stdin.flush();
        readResponse(bufferedInputStream);
        stdin.write(bArr, 0, bArr.length);
        stdin.write(0);
        stdin.flush();
        readResponse(bufferedInputStream);
        try {
            stdin.write("E\n".getBytes(InternalZipConstants.AES_HASH_CHARSET));
        } catch (UnsupportedEncodingException unused2) {
            stdin.write("E\n".getBytes());
        }
        stdin.flush();
    }

    private void sendFiles(Session session, String[] strArr, String[] strArr2, String str) throws Throwable {
        String name;
        FileInputStream fileInputStream;
        byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(session.getStdin(), 40000);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(session.getStdout(), 512);
        readResponse(bufferedInputStream);
        for (int i = 0; i < strArr.length; i++) {
            File file = new File(strArr[i]);
            long length = file.length();
            if (strArr2 == null || strArr2.length <= i || (name = strArr2[i]) == null) {
                name = file.getName();
            }
            StringBuilder sb = new StringBuilder("C");
            sb.append(str);
            sb.append(" ");
            sb.append(length);
            String strC = e.c(sb, " ", name, "\n");
            try {
                bufferedOutputStream.write(strC.getBytes(InternalZipConstants.AES_HASH_CHARSET));
            } catch (UnsupportedEncodingException unused) {
                bufferedOutputStream.write(strC.getBytes());
            }
            bufferedOutputStream.flush();
            readResponse(bufferedInputStream);
            try {
                fileInputStream = new FileInputStream(file);
                while (length > 0) {
                    int i2 = length > ((long) AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) ? 8192 : (int) length;
                    try {
                        if (fileInputStream.read(bArr, 0, i2) != i2) {
                            throw new IOException("Cannot read enough from local file " + strArr[i]);
                        }
                        bufferedOutputStream.write(bArr, 0, i2);
                        length -= (long) i2;
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                }
                fileInputStream.close();
                bufferedOutputStream.write(0);
                bufferedOutputStream.flush();
                readResponse(bufferedInputStream);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        }
        try {
            bufferedOutputStream.write("E\n".getBytes(InternalZipConstants.AES_HASH_CHARSET));
        } catch (UnsupportedEncodingException unused2) {
            bufferedOutputStream.write("E\n".getBytes(InternalZipConstants.AES_HASH_CHARSET));
        }
        bufferedOutputStream.flush();
    }

    public void get(String str, OutputStream outputStream) {
        get(new String[]{str}, new OutputStream[]{outputStream});
    }

    public void get(String str, String str2) {
        get(new String[]{str}, str2);
    }

    public void get(String[] strArr, String str) {
        String str2;
        if (strArr != null && str != null) {
            if (strArr.length == 0) {
                return;
            }
            String strJ = "scp -f";
            for (String str3 : strArr) {
                if (str3 != null) {
                    String strTrim = str3.trim();
                    if (strTrim.length() != 0) {
                        strJ = e.j(strJ, " ", strTrim);
                    } else {
                        str2 = "Cannot accept empty filename.";
                    }
                } else {
                    str2 = "Cannot accept null filename.";
                }
            }
            Session sessionOpenSession = null;
            try {
                try {
                    sessionOpenSession = this.conn.openSession();
                    sessionOpenSession.execCommand(strJ);
                    receiveFiles(sessionOpenSession, strArr, str);
                    sessionOpenSession.close();
                    return;
                } catch (IOException e) {
                    throw new IOException("Error during SCP transfer.", e);
                }
            } catch (Throwable th) {
                if (sessionOpenSession != null) {
                    sessionOpenSession.close();
                }
                throw th;
            }
        }
        str2 = "Null argument.";
        d.AnonymousClass0.m$2(str2);
    }

    public void put(String str, String str2) {
        put(new String[]{str}, str2, "0600");
    }

    public void put(String str, String str2, String str3) {
        put(new String[]{str}, str2, str3);
    }

    public void put(String str, String str2, String str3, String str4) {
        put(new String[]{str}, new String[]{str2}, str3, str4);
    }

    public void put(byte[] bArr, String str, String str2) {
        put(bArr, str, str2, "0600");
    }

    public void put(byte[] bArr, String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            d.AnonymousClass0.m$2("Null argument.");
            return;
        }
        if (str3.length() != 4) {
            d.AnonymousClass0.m$2("Invalid mode.");
            return;
        }
        for (int i = 0; i < str3.length(); i++) {
            if (!Character.isDigit(str3.charAt(i))) {
                d.AnonymousClass0.m$2("Invalid mode.");
                return;
            }
        }
        String strTrim = str2.trim();
        if (strTrim.length() <= 0) {
            strTrim = ".";
        }
        String strConcat = "scp -t -d ".concat(strTrim);
        Session sessionOpenSession = null;
        try {
            try {
                sessionOpenSession = this.conn.openSession();
                sessionOpenSession.execCommand(strConcat);
                sendBytes(sessionOpenSession, bArr, str, str3);
                sessionOpenSession.close();
            } catch (IOException e) {
                throw new IOException("Error during SCP transfer.", e);
            }
        } catch (Throwable th) {
            if (sessionOpenSession != null) {
                sessionOpenSession.close();
            }
            throw th;
        }
    }

    public void put(String[] strArr, String str) {
        put(strArr, str, "0600");
    }

    public void put(String[] strArr, String str, String str2) {
        put(strArr, (String[]) null, str, str2);
    }

    public void put(String[] strArr, String[] strArr2, String str, String str2) {
        String str3;
        if (strArr != null && str != null && str2 != null) {
            if (str2.length() != 4) {
                d.AnonymousClass0.m$2("Invalid mode.");
                return;
            }
            for (int i = 0; i < str2.length(); i++) {
                if (!Character.isDigit(str2.charAt(i))) {
                    d.AnonymousClass0.m$2("Invalid mode.");
                    return;
                }
            }
            if (strArr.length == 0) {
                return;
            }
            String strTrim = str.trim();
            if (strTrim.length() <= 0) {
                strTrim = ".";
            }
            String strConcat = "scp -t -d ".concat(strTrim);
            for (String str4 : strArr) {
                if (str4 == null) {
                    str3 = "Cannot accept null filename.";
                }
            }
            Session sessionOpenSession = null;
            try {
                try {
                    sessionOpenSession = this.conn.openSession();
                    sessionOpenSession.execCommand(strConcat);
                    sendFiles(sessionOpenSession, strArr, strArr2, str2);
                    sessionOpenSession.close();
                    return;
                } catch (IOException e) {
                    throw new IOException("Error during SCP transfer.", e);
                }
            } catch (Throwable th) {
                if (sessionOpenSession != null) {
                    sessionOpenSession.close();
                }
                throw th;
            }
        }
        str3 = "Null argument.";
        d.AnonymousClass0.m$2(str3);
    }
}
