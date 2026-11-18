package renz.javacodez.v2ray.dto;

import android.graphics.drawable.Drawable;
import defpackage.e;
import defpackage.e4;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class AppInfo {
    private final Drawable appIcon;
    private final String appName;
    private int isSelected;
    private final boolean isSystemApp;
    private final String packageName;

    public AppInfo(String str, String str2, Drawable drawable, boolean z, int i) {
        this.appName = str;
        this.packageName = str2;
        this.appIcon = drawable;
        this.isSystemApp = z;
        this.isSelected = i;
    }

    public static /* synthetic */ AppInfo copy$default(AppInfo appInfo, String str, String str2, Drawable drawable, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = appInfo.appName;
        }
        if ((i2 & 2) != 0) {
            str2 = appInfo.packageName;
        }
        if ((i2 & 4) != 0) {
            drawable = appInfo.appIcon;
        }
        if ((i2 & 8) != 0) {
            z = appInfo.isSystemApp;
        }
        if ((i2 & 16) != 0) {
            i = appInfo.isSelected;
        }
        int i3 = i;
        Drawable drawable2 = drawable;
        return appInfo.copy(str, str2, drawable2, z, i3);
    }

    public final String component1() {
        return this.appName;
    }

    public final String component2() {
        return this.packageName;
    }

    public final Drawable component3() {
        return this.appIcon;
    }

    public final boolean component4() {
        return this.isSystemApp;
    }

    public final int component5() {
        return this.isSelected;
    }

    public final AppInfo copy(String str, String str2, Drawable drawable, boolean z, int i) {
        return new AppInfo(str, str2, drawable, z, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppInfo)) {
            return false;
        }
        AppInfo appInfo = (AppInfo) obj;
        return e4.a(this.appName, appInfo.appName) && e4.a(this.packageName, appInfo.packageName) && e4.a(this.appIcon, appInfo.appIcon) && this.isSystemApp == appInfo.isSystemApp && this.isSelected == appInfo.isSelected;
    }

    public final Drawable getAppIcon() {
        return this.appIcon;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return ((((this.appIcon.hashCode() + e.d(this.appName.hashCode() * 31, this.packageName)) * 31) + (this.isSystemApp ? 1231 : 1237)) * 31) + this.isSelected;
    }

    public final int isSelected() {
        return this.isSelected;
    }

    public final boolean isSystemApp() {
        return this.isSystemApp;
    }

    public final void setSelected(int i) {
        this.isSelected = i;
    }

    public String toString() {
        return "AppInfo(appName=" + this.appName + ", packageName=" + this.packageName + ", appIcon=" + this.appIcon + ", isSystemApp=" + this.isSystemApp + ", isSelected=" + this.isSelected + ')';
    }
}
