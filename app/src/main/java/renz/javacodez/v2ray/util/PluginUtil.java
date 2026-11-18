package renz.javacodez.v2ray.util;

import android.content.Context;
import android.os.SystemClock;
import defpackage.ak;
import defpackage.e;
import defpackage.fc;
import defpackage.he;
import defpackage.jo0;
import defpackage.q31;
import defpackage.rc0;
import defpackage.uh0;
import defpackage.v41;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.Hysteria2Bean;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.fmtkt.Hysteria2Fmt;
import renz.javacodez.v2ray.service.ProcessService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class PluginUtil {
    private static final String HYSTERIA2 = "libhysteria2.so";
    public static final PluginUtil INSTANCE = new PluginUtil();
    private static final String TAG = "org.hamotunnelplus.xyz";
    private static final rc0 procService$delegate;

    static {
        int i = 2;
        procService$delegate = new v41(new uh0(i, i));
    }

    private PluginUtil() {
    }

    private final List<String> genCmdHy2(Context context, File file) {
        return e.d0(new File(context.getApplicationInfo().nativeLibraryDir, HYSTERIA2).getAbsolutePath(), "--disable-update-check", "--config", file.getAbsolutePath(), "--log-level", "warn", "client");
    }

    private final File genConfigHy2(Context context, ProfileItem profileItem, String str) throws IOException {
        String str2 = str != null ? (String) he.T0(q31.s0(str, new String[]{":"}, 6)) : null;
        if (str2 != null && str2.length() != 0) {
            Hysteria2Bean nativeConfig = Hysteria2Fmt.INSTANCE.toNativeConfig(profileItem, Integer.parseInt(str2));
            if (nativeConfig != null) {
                File file = new File(context.getNoBackupFilesDir(), "hy2_" + SystemClock.elapsedRealtime() + ".json");
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                String json = JsonUtil.INSTANCE.toJson(nativeConfig);
                Charset charset = fc.a;
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    e.T(fileOutputStream, json, charset);
                    fileOutputStream.close();
                    return file;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        e.F0(fileOutputStream, th);
                        throw th2;
                    }
                }
            }
        }
        return null;
    }

    private final ProcessService getProcService() {
        return (ProcessService) procService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProcessService procService_delegate$lambda$0() {
        return new ProcessService();
    }

    private final void stopHy2() {
        try {
            getProcService().stopProcess();
        } catch (Exception e) {
            e.toString();
        }
    }

    public final long realPingHy2(Context context, ProfileItem profileItem) throws InterruptedException, IOException {
        EConfigType configType;
        if (profileItem == null || (configType = profileItem.getConfigType()) == null || !configType.equals(EConfigType.HYSTERIA2)) {
            return -1L;
        }
        int iFindFreePort = Utils.INSTANCE.findFreePort(Collections.singletonList(0));
        File fileGenConfigHy2 = genConfigHy2(context, profileItem, ak.h(iFindFreePort, "0:"));
        if (fileGenConfigHy2 == null) {
            return -1L;
        }
        List<String> listGenCmdHy2 = genCmdHy2(context, fileGenConfigHy2);
        ProcessService processService = new ProcessService();
        processService.runProcess(context, listGenCmdHy2);
        Thread.sleep(1000L);
        jo0 jo0VarTestConnection = SpeedtestUtil.INSTANCE.testConnection(context, iFindFreePort);
        processService.stopProcess();
        return ((Number) jo0VarTestConnection.b).longValue();
    }

    public final void runPlugin(Context context, ProfileItem profileItem, String str) {
        EConfigType configType;
        File fileGenConfigHy2;
        if (profileItem == null || (configType = profileItem.getConfigType()) == null || !configType.equals(EConfigType.HYSTERIA2) || (fileGenConfigHy2 = genConfigHy2(context, profileItem, str)) == null) {
            return;
        }
        getProcService().runProcess(context, genCmdHy2(context, fileGenConfigHy2));
    }

    public final void stopPlugin() {
        stopHy2();
    }
}
