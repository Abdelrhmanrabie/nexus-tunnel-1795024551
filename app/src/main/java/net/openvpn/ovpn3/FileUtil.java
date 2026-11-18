package net.openvpn.ovpn3;

import android.content.Context;
import android.net.Uri;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.vpn.activities.HamoTunnelPlusApplication;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class FileUtil {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class FileTooLarge extends IOException {
        public FileTooLarge(String str, long j) {
            super(String.format(HamoTunnelPlusApplication.d.getString(R.string.er), str, Long.valueOf(j)));
        }
    }

    public static String basename(String str) {
        if (str != null) {
            return new File(str).getName();
        }
        return null;
    }

    public static boolean deleteFile(String str) {
        if (str != null) {
            return new File(str).delete();
        }
        return false;
    }

    public static String dirname(String str) {
        if (str != null) {
            return new File(str).getParent();
        }
        return null;
    }

    public static String readAsset(Context context, String str) {
        return readStream(context.getResources().getAssets().open(str), 0L, str);
    }

    public static String readFile(String str, long j) {
        return readStream(new FileInputStream(str), j, str);
    }

    public static String readFileAppPrivate(Context context, String str) {
        return readStream(context.openFileInput(str), 0L, str);
    }

    public static byte[] readFileByteArray(String str, long j) throws IOException {
        File file = new File(str);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if ((j > 0 && length > j) || length > 2147483647L) {
                throw new FileTooLarge(str, j);
            }
            int i = (int) length;
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = fileInputStream.read(bArr, i2, i - i2);
                if (i3 < 0) {
                    break;
                }
                i2 += i3;
            }
            if (i2 >= i) {
                fileInputStream.close();
                return bArr;
            }
            throw new IOException("Could not completely read file: " + str);
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    public static String readStream(InputStream inputStream, long j, String str) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[4096];
            while (true) {
                int i = bufferedReader.read(cArr, 0, 4096);
                if (i <= 0) {
                    String string = sb.toString();
                    inputStream.close();
                    return string;
                }
                sb.append(cArr, 0, i);
                if (j > 0 && sb.length() > j) {
                    throw new FileTooLarge(str, j);
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    public static String readUri(Context context, Uri uri, long j) {
        return readStream(context.getContentResolver().openInputStream(uri), j, uriBasename(uri));
    }

    public static boolean renameFile(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }

    public static String uriBasename(Uri uri) {
        if (uri != null) {
            return uri.getLastPathSegment();
        }
        return null;
    }

    public static void writeFileAppPrivate(Context context, String str, String str2) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
        try {
            fileOutputStreamOpenFileOutput.write(str2.getBytes());
        } finally {
            fileOutputStreamOpenFileOutput.close();
        }
    }
}
