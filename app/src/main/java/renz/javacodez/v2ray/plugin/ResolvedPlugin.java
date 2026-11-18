package renz.javacodez.v2ray.plugin;

import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import defpackage.k7;
import defpackage.rc0;
import defpackage.v41;
import renz.javacodez.v2ray.V2RAYApp;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResolvedPlugin extends Plugin {
    private final rc0 id$delegate;
    private final ResolveInfo resolveInfo;
    private final rc0 version$delegate;
    private final rc0 versionName$delegate;

    public ResolvedPlugin(ResolveInfo resolveInfo) {
        this.resolveInfo = resolveInfo;
        int i = 0;
        this.id$delegate = new v41(new k7(this, 2, i));
        int i2 = 1;
        this.version$delegate = new v41(new k7(this, i, i2));
        this.versionName$delegate = new v41(new k7(this, i2, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String id_delegate$lambda$0(ResolvedPlugin resolvedPlugin) {
        return PluginManager.INSTANCE.loadString(resolvedPlugin.getComponentInfo(), PluginContract.METADATA_KEY_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String versionName_delegate$lambda$2(ResolvedPlugin resolvedPlugin) {
        return V2RAYApp.Companion.getApplication().getPackageInfo(resolvedPlugin.getComponentInfo().packageName).versionName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int version_delegate$lambda$1(ResolvedPlugin resolvedPlugin) {
        return V2RAYApp.Companion.getApplication().getPackageInfo(resolvedPlugin.getComponentInfo().packageName).versionCode;
    }

    public abstract ComponentInfo getComponentInfo();

    @Override // renz.javacodez.v2ray.plugin.Plugin
    public boolean getDirectBootAware() {
        return Build.VERSION.SDK_INT < 24 || getComponentInfo().directBootAware;
    }

    @Override // renz.javacodez.v2ray.plugin.Plugin
    public Drawable getIcon() {
        return this.resolveInfo.loadIcon(V2RAYApp.Companion.getApplication().getPackageManager());
    }

    @Override // renz.javacodez.v2ray.plugin.Plugin
    public String getId() {
        return (String) this.id$delegate.getValue();
    }

    @Override // renz.javacodez.v2ray.plugin.Plugin
    public CharSequence getLabel() {
        return this.resolveInfo.loadLabel(V2RAYApp.Companion.getApplication().getPackageManager());
    }

    @Override // renz.javacodez.v2ray.plugin.Plugin
    public String getPackageName() {
        return getComponentInfo().packageName;
    }

    public final ResolveInfo getResolveInfo() {
        return this.resolveInfo;
    }

    @Override // renz.javacodez.v2ray.plugin.Plugin
    public int getVersion() {
        return ((Number) this.version$delegate.getValue()).intValue();
    }

    @Override // renz.javacodez.v2ray.plugin.Plugin
    public String getVersionName() {
        return (String) this.versionName$delegate.getValue();
    }
}
