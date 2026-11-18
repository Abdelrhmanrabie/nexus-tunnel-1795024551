package renz.javacodez.v2ray.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.LocaleList;
import android.text.Editable;
import android.util.Base64;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.d;
import defpackage.e;
import defpackage.e4;
import defpackage.e5;
import defpackage.fc;
import defpackage.q31;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.IDN;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.Language;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.service.V2RayServiceManager;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Language.values().length];
            try {
                iArr[Language.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Language.ENGLISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Language.CHINA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Language.TRADITIONAL_CHINESE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Language.VIETNAMESE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Language.RUSSIAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Language.PERSIAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Language.BANGLA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Language.BAKHTIARI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Utils() {
    }

    public static /* synthetic */ String getDelayTestUrl$default(Utils utils, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return utils.getDelayTestUrl(z);
    }

    private final Locale getSysLocale() {
        return Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
    }

    public static /* synthetic */ String getUrlContentWithCustomUserAgent$default(Utils utils, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 30000;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return utils.getUrlContentWithCustomUserAgent(str, i, i2);
    }

    private final boolean isCoreDNSAddress(String str) {
        return str.startsWith("https") || str.startsWith(AppConfig.DEFAULT_NETWORK) || str.startsWith("quic") || str.equals("localhost");
    }

    public final int arrayFind(String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (e4.a(strArr[i], str)) {
                return i;
            }
        }
        return -1;
    }

    public final String backupPath(Context context) {
        if (context == null) {
            return AppConfig.CUSTOM;
        }
        File externalFilesDir = context.getExternalFilesDir(AppConfig.DIR_BACKUPS);
        return externalFilesDir == null ? context.getDir(AppConfig.DIR_BACKUPS, 0).getAbsolutePath() : externalFilesDir.getAbsolutePath();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    public final String decode(String str) {
        String strTryDecodeBase64;
        CharSequence charSequenceSubSequence;
        String strTryDecodeBase65 = tryDecodeBase64(str);
        if (strTryDecodeBase65 != null) {
            return strTryDecodeBase65;
        }
        if (str != null) {
            char[] cArr = {'='};
            int length = str.length() - 1;
            if (length < 0) {
                charSequenceSubSequence = AppConfig.CUSTOM;
                break;
            }
            while (true) {
                int i = length - 1;
                char cCharAt = str.charAt(length);
                int i2 = 0;
                while (true) {
                    if (i2 >= 1) {
                        i2 = -1;
                        break;
                    }
                    if (cCharAt == cArr[i2]) {
                        break;
                    }
                    i2++;
                }
                if (!(i2 >= 0)) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    charSequenceSubSequence = AppConfig.CUSTOM;
                    break;
                }
                length = i;
            }
            String string = charSequenceSubSequence.toString();
            if (string != null) {
                strTryDecodeBase64 = INSTANCE.tryDecodeBase64(string);
            } else {
                strTryDecodeBase64 = null;
            }
        } else {
            strTryDecodeBase64 = null;
        }
        return strTryDecodeBase64 == null ? AppConfig.CUSTOM : strTryDecodeBase64;
    }

    public final String encode(String str) {
        try {
            return Base64.encodeToString(str.getBytes(fc.a), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return AppConfig.CUSTOM;
        }
    }

    public final int findFreePort(List<Integer> list) throws IOException {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            try {
                ServerSocket serverSocket = new ServerSocket(it.next().intValue());
                try {
                    continue;
                    int localPort = serverSocket.getLocalPort();
                    serverSocket.close();
                    return localPort;
                } catch (Throwable th) {
                    try {
                        continue;
                        throw th;
                    } catch (Throwable th2) {
                        e.F0(serverSocket, th);
                        throw th2;
                    }
                }
            } catch (IOException unused) {
            }
        }
        d.AnonymousClass0.m$6("no free port found");
        return 0;
    }

    public final String fixIllegalUrl(String str) {
        return q31.b0(q31.b0(str, " ", "%20"), "|", "%7C");
    }

    public final String getClipboard(Context context) {
        ClipData.Item itemAt;
        try {
            ClipData primaryClip = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip();
            return String.valueOf((primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null) ? null : itemAt.getText());
        } catch (Exception e) {
            e.printStackTrace();
            return AppConfig.CUSTOM;
        }
    }

    public final boolean getDarkModeStatus(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) != 16;
    }

    public final String getDelayTestUrl(boolean z) {
        if (z) {
            return AppConfig.DelayTestUrl2;
        }
        String strDecodeSettingsString = MmkvManager.INSTANCE.decodeSettingsString(AppConfig.PREF_DELAY_TEST_URL);
        return strDecodeSettingsString == null ? AppConfig.DelayTestUrl : strDecodeSettingsString;
    }

    public final String getDeviceIdForXUDPBaseKey() {
        return Base64.encodeToString(Arrays.copyOf("android_id".getBytes(fc.a), 32), 9);
    }

    public final List<String> getDomesticDnsServers() {
        String strDecodeSettingsString = MmkvManager.INSTANCE.decodeSettingsString(AppConfig.PREF_DOMESTIC_DNS);
        if (strDecodeSettingsString == null) {
            strDecodeSettingsString = AppConfig.DNS_DIRECT;
        }
        List listS0 = q31.s0(strDecodeSettingsString, new String[]{","}, 6);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listS0) {
            String str = (String) obj;
            Utils utils = INSTANCE;
            if (utils.isPureIpAddress(str) || utils.isCoreDNSAddress(str)) {
                arrayList.add(obj);
            }
        }
        return arrayList.isEmpty() ? Collections.singletonList(AppConfig.DNS_DIRECT) : arrayList;
    }

    public final Editable getEditable(String str) {
        Editable.Factory factory = Editable.Factory.getInstance();
        if (str == null) {
            str = AppConfig.CUSTOM;
        }
        return factory.newEditable(str);
    }

    public final String getIpv6Address(String str) {
        if (str == null) {
            return AppConfig.CUSTOM;
        }
        return (!isIpv6Address(str) || q31.d0(str, '[') || q31.d0(str, ']')) ? str : String.format("[%s]", Arrays.copyOf(new Object[]{str}, 1));
    }

    public final Locale getLocale() {
        String strDecodeSettingsString = MmkvManager.INSTANCE.decodeSettingsString(AppConfig.PREF_LANGUAGE);
        if (strDecodeSettingsString == null) {
            strDecodeSettingsString = Language.AUTO.getCode();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[Language.Companion.fromCode(strDecodeSettingsString).ordinal()]) {
            case 1:
                return getSysLocale();
            case 2:
                return Locale.ENGLISH;
            case 3:
                return Locale.CHINA;
            case 4:
                return Locale.TRADITIONAL_CHINESE;
            case 5:
                return new Locale("vi");
            case 6:
                return new Locale("ru");
            case 7:
                return new Locale("fa");
            case 8:
                return new Locale("bn");
            case 9:
                return new Locale("bqi", "IR");
            default:
                d.AnonymousClass0.m();
                return null;
        }
    }

    public final List<String> getRemoteDnsServers() {
        String strDecodeSettingsString = MmkvManager.INSTANCE.decodeSettingsString(AppConfig.PREF_REMOTE_DNS);
        if (strDecodeSettingsString == null) {
            strDecodeSettingsString = "1.1.1.1";
        }
        List listS0 = q31.s0(strDecodeSettingsString, new String[]{","}, 6);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listS0) {
            String str = (String) obj;
            Utils utils = INSTANCE;
            if (utils.isPureIpAddress(str) || utils.isCoreDNSAddress(str)) {
                arrayList.add(obj);
            }
        }
        return arrayList.isEmpty() ? Collections.singletonList("1.1.1.1") : arrayList;
    }

    public final String getUrlContentWithCustomUserAgent(String str, int i, int i2) throws IOException {
        URL url = new URL(str);
        URLConnection uRLConnectionOpenConnection = i2 == 0 ? url.openConnection() : url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(AppConfig.LOOPBACK, i2)));
        uRLConnectionOpenConnection.setConnectTimeout(i);
        uRLConnectionOpenConnection.setReadTimeout(i);
        uRLConnectionOpenConnection.setRequestProperty("Connection", "close");
        uRLConnectionOpenConnection.setRequestProperty("User-agent", "v2rayNG/1.9.24");
        String userInfo = url.getUserInfo();
        if (userInfo != null) {
            StringBuilder sb = new StringBuilder("Basic ");
            Utils utils = INSTANCE;
            sb.append(utils.encode(utils.urlDecode(userInfo)));
            uRLConnectionOpenConnection.setRequestProperty("Authorization", sb.toString());
        }
        uRLConnectionOpenConnection.setUseCaches(false);
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            String strS = e.S(new BufferedReader(new InputStreamReader(inputStream, fc.a), AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT));
            e.F0(inputStream, null);
            return strS;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                e.F0(inputStream, th);
                throw th2;
            }
        }
    }

    public final String getUrlContext(String str, int i) throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
                httpURLConnection.setRequestProperty("Connection", "close");
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setUseCaches(false);
                String strS = e.S(new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), fc.a), AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT));
                httpURLConnection.disconnect();
                return strS;
            } catch (Exception unused) {
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return AppConfig.CUSTOM;
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }

    public final String getUuid() {
        try {
            return q31.b0(UUID.randomUUID().toString(), "-", AppConfig.CUSTOM);
        } catch (Exception e) {
            e.printStackTrace();
            return AppConfig.CUSTOM;
        }
    }

    public final List<String> getVpnDnsServers() {
        String strDecodeSettingsString = MmkvManager.INSTANCE.decodeSettingsString(AppConfig.PREF_VPN_DNS);
        if (strDecodeSettingsString == null) {
            strDecodeSettingsString = "1.1.1.1";
        }
        List listS0 = q31.s0(strDecodeSettingsString, new String[]{","}, 6);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listS0) {
            if (INSTANCE.isPureIpAddress((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final String idnToASCII(String str) {
        URL url = new URL(str);
        return new URL(url.getProtocol(), IDN.toASCII(url.getHost(), 1), url.getPort(), url.getFile()).toExternalForm();
    }

    public final boolean isIpAddress(String str) {
        if (str != null) {
            try {
                if (str.length() != 0 && str.length() != 0 && !q31.m0(str)) {
                    if (q31.k0(str, InternalZipConstants.ZIP_FILE_SEPARATOR, 0, 6) > 0) {
                        List listS0 = q31.s0(str, new String[]{InternalZipConstants.ZIP_FILE_SEPARATOR}, 6);
                        if (listS0.size() == 2 && Integer.parseInt((String) listS0.get(1)) > -1) {
                            str = (String) listS0.get(0);
                        }
                    }
                    if (str.startsWith("::ffff:") && q31.d0(str, '.')) {
                        str = q31.D0(7, str);
                    } else if (str.startsWith("[::ffff:") && q31.d0(str, '.')) {
                        str = q31.b0(q31.D0(8, str), "]", AppConfig.CUSTOM);
                    }
                    String[] strArr = (String[]) q31.t0(str, new char[]{'.'}).toArray(new String[0]);
                    if (strArr.length != 4) {
                        return isIpv6Address(str);
                    }
                    if (q31.k0(strArr[3], ":", 0, 6) > 0) {
                        str = str.substring(0, q31.k0(str, ":", 0, 6));
                    }
                    return isIpv4Address(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final boolean isIpv4Address(String str) {
        return Pattern.compile("^([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\.([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\.([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\.([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])$").matcher(str).matches();
    }

    public final boolean isIpv6Address(String str) {
        String strI;
        if (q31.k0(str, "[", 0, 6) == 0 && q31.n0(str, "]") > 0) {
            String strD0 = q31.D0(1, str);
            int length = strD0.length() - q31.n0(strD0, "]");
            if (length >= 0) {
                int length2 = strD0.length() - length;
                if (length2 < 0) {
                    length2 = 0;
                }
                if (length2 >= 0) {
                    int length3 = strD0.length();
                    if (length2 > length3) {
                        length2 = length3;
                    }
                    str = strD0.substring(0, length2);
                } else {
                    strI = e.i(length2, "Requested character count ", " is less than zero.");
                }
            } else {
                strI = e.i(length, "Requested character count ", " is less than zero.");
            }
            d.AnonymousClass0.m((Object) strI);
            return false;
        }
        return Pattern.compile("^((?:[0-9A-Fa-f]{1,4}))?((?::[0-9A-Fa-f]{1,4}))*::((?:[0-9A-Fa-f]{1,4}))?((?::[0-9A-Fa-f]{1,4}))*|((?:[0-9A-Fa-f]{1,4}))((?::[0-9A-Fa-f]{1,4})){7}$").matcher(str).matches();
    }

    public final boolean isPureIpAddress(String str) {
        return isIpv4Address(str) || isIpv6Address(str);
    }

    public final boolean isTv(Context context) {
        return context.getPackageManager().hasSystemFeature("android.software.leanback");
    }

    public final boolean isValidSubUrl(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (URLUtil.isHttpsUrl(str)) {
                        return true;
                    }
                    if (URLUtil.isHttpUrl(str) && q31.e0(str, AppConfig.LOOPBACK)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final boolean isValidUrl(String str) {
        if (str != null) {
            try {
                if (str.length() != 0 && (Patterns.WEB_URL.matcher(str).matches() || Patterns.DOMAIN_NAME.matcher(str).matches() || URLUtil.isValidUrl(str))) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final boolean isXray() {
        return false;
    }

    public final void openUri(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public final int parseInt(String str) {
        return parseInt(str, 0);
    }

    public final int parseInt(String str, int i) {
        Integer numU;
        return (str == null || (numU = q31.U(str)) == null) ? i : numU.intValue();
    }

    public final String readTextFromAssets(Context context, String str) {
        if (context == null) {
            return AppConfig.CUSTOM;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str), fc.a), AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
        try {
            String strS = e.S(bufferedReader);
            bufferedReader.close();
            return strS;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                e.F0(bufferedReader, th);
                throw th2;
            }
        }
    }

    public final int receiverFlags() {
        return Build.VERSION.SDK_INT >= 33 ? 2 : 4;
    }

    public final String removeWhiteSpace(String str) {
        if (str != null) {
            return q31.b0(str, " ", AppConfig.CUSTOM);
        }
        return null;
    }

    public final void setClipboard(Context context, String str) {
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setNightMode() {
        int i;
        String strDecodeSettingsString = MmkvManager.INSTANCE.decodeSettingsString(AppConfig.PREF_UI_MODE_NIGHT, "0");
        if (strDecodeSettingsString != null) {
            switch (strDecodeSettingsString) {
                case "0":
                    i = -1;
                    break;
                case "1":
                    i = 1;
                    break;
                case "2":
                    i = 2;
                    break;
                default:
                    return;
            }
            e5.x(i);
        }
    }

    public final boolean startVServiceFromToggle(Context context) {
        String selectServer = MmkvManager.INSTANCE.getSelectServer();
        if (selectServer == null || selectServer.length() == 0) {
            return false;
        }
        V2RayServiceManager.INSTANCE.startV2Ray(context);
        return true;
    }

    public final void stopVService(Context context) {
        MessageUtil.INSTANCE.sendMsg2Service(context, 4, AppConfig.CUSTOM);
    }

    public final String tryDecodeBase64(String str) {
        try {
            return new String(Base64.decode(str, 2), fc.a);
        } catch (Exception e) {
            e.toString();
            try {
                return new String(Base64.decode(str, 10), fc.a);
            } catch (Exception e2) {
                e2.toString();
                return null;
            }
        }
    }

    public final String urlDecode(String str) {
        try {
            return URLDecoder.decode(str, fc.a.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public final String urlEncode(String str) {
        try {
            return q31.b0(URLEncoder.encode(str, fc.a.toString()), "+", "%20");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public final String userAssetPath(Context context) {
        if (context == null) {
            return AppConfig.CUSTOM;
        }
        File externalFilesDir = context.getExternalFilesDir(AppConfig.DIR_ASSETS);
        return externalFilesDir == null ? context.getDir(AppConfig.DIR_ASSETS, 0).getAbsolutePath() : externalFilesDir.getAbsolutePath();
    }
}
