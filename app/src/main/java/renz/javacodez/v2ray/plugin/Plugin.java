package renz.javacodez.v2ray.plugin;

import android.graphics.drawable.Drawable;
import defpackage.e4;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class Plugin {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass().equals(obj != null ? obj.getClass() : null)) {
            return e4.a(getId(), ((Plugin) obj).getId());
        }
        return false;
    }

    public String getDefaultConfig() {
        return null;
    }

    public boolean getDirectBootAware() {
        return true;
    }

    public Drawable getIcon() {
        return null;
    }

    public abstract String getId();

    public abstract CharSequence getLabel();

    public String getPackageName() {
        return AppConfig.CUSTOM;
    }

    public abstract int getVersion();

    public abstract String getVersionName();

    public int hashCode() {
        return getId().hashCode();
    }
}
