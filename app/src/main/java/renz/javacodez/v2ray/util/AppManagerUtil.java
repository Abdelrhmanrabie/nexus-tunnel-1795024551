package renz.javacodez.v2ray.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import defpackage.em0;
import defpackage.fm0;
import defpackage.jm0;
import defpackage.o6;
import defpackage.pc0;
import java.util.ArrayList;
import java.util.List;
import renz.javacodez.v2ray.dto.AppInfo;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class AppManagerUtil {
    public static final AppManagerUtil INSTANCE = new AppManagerUtil();

    private AppManagerUtil() {
    }

    private final ArrayList<AppInfo> loadNetworkAppList(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(4096);
        ArrayList<AppInfo> arrayList = new ArrayList<>();
        for (PackageInfo packageInfo : installedPackages) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                String string = applicationInfo.loadLabel(packageManager).toString();
                Drawable drawableLoadIcon = applicationInfo.loadIcon(packageManager);
                if (drawableLoadIcon != null) {
                    arrayList.add(new AppInfo(string, packageInfo.packageName, drawableLoadIcon, (applicationInfo.flags & 1) > 0, 0));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rxLoadNetworkAppList$lambda$0(Context context, jm0 jm0Var) {
        ((pc0) jm0Var).b(INSTANCE.loadNetworkAppList(context));
    }

    public final em0 rxLoadNetworkAppList(Context context) {
        new o6(context);
        return new fm0();
    }
}
