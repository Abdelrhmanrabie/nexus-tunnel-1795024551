package renz.javacodez.v2ray.handler;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.ae;
import defpackage.e;
import defpackage.e4;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.RoutingType;
import renz.javacodez.v2ray.dto.RulesetItem;
import renz.javacodez.v2ray.util.JsonUtil;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SettingsManager {
    public static final SettingsManager INSTANCE = new SettingsManager();

    private SettingsManager() {
    }

    private final List<RulesetItem> getPresetRoutingRulesets(Context context, int i) {
        String textFromAssets = Utils.INSTANCE.readTextFromAssets(context, RoutingType.Companion.fromIndex(i).getFileName());
        if (TextUtils.isEmpty(textFromAssets)) {
            return null;
        }
        return ae.N0((Object[]) JsonUtil.INSTANCE.fromJson(textFromAssets, RulesetItem[].class));
    }

    public static /* synthetic */ List getPresetRoutingRulesets$default(SettingsManager settingsManager, Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return settingsManager.getPresetRoutingRulesets(context, i);
    }

    private final void resetRoutingRulesetsCommon(List<RulesetItem> list) {
        ArrayList arrayList = new ArrayList();
        List<RulesetItem> listDecodeRoutingRulesets = MmkvManager.INSTANCE.decodeRoutingRulesets();
        if (listDecodeRoutingRulesets != null) {
            for (RulesetItem rulesetItem : listDecodeRoutingRulesets) {
                if (e4.a(rulesetItem.getLocked(), Boolean.TRUE)) {
                    arrayList.add(rulesetItem);
                }
            }
        }
        arrayList.addAll(list);
        MmkvManager.INSTANCE.encodeRoutingRulesets(arrayList);
    }

    public final int getHttpPort() {
        return Integer.parseInt(AppConfig.PORT_HTTP);
    }

    public final RulesetItem getRoutingRuleset(int i) {
        List<RulesetItem> listDecodeRoutingRulesets;
        if (i < 0 || (listDecodeRoutingRulesets = MmkvManager.INSTANCE.decodeRoutingRulesets()) == null || listDecodeRoutingRulesets.isEmpty()) {
            return null;
        }
        return listDecodeRoutingRulesets.get(i);
    }

    public final ProfileItem getServerViaRemarks(Context context, String str) {
        if (str == null) {
            return null;
        }
        Iterator<String> it = MmkvManager.INSTANCE.decodeServerList().iterator();
        while (it.hasNext()) {
            ProfileItem profileItemDecodeServerConfig = MmkvManager.INSTANCE.decodeServerConfig(context, it.next());
            if (profileItemDecodeServerConfig != null && e4.a(profileItemDecodeServerConfig.getRemarks(), str)) {
                return profileItemDecodeServerConfig;
            }
        }
        return null;
    }

    public final int getSocksPort() {
        return Utils.INSTANCE.parseInt(MmkvManager.INSTANCE.decodeSettingsString(AppConfig.PREF_SOCKS_PORT), Integer.parseInt(AppConfig.PORT_SOCKS));
    }

    public final void initAssets(Context context, AssetManager assetManager) {
        String strUserAssetPath = Utils.INSTANCE.userAssetPath(context);
        try {
            String[] strArr = {"geosite.dat", "geoip.dat"};
            String[] list = assetManager.list(AppConfig.CUSTOM);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    if (ae.H0(strArr, str) >= 0) {
                        arrayList.add(str);
                    }
                }
                ArrayList<String> arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (!new File(strUserAssetPath, (String) obj).exists()) {
                        arrayList2.add(obj);
                    }
                }
                for (String str2 : arrayList2) {
                    File file = new File(strUserAssetPath, str2);
                    InputStream inputStreamOpen = assetManager.open(str2);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
                            while (true) {
                                int i = inputStreamOpen.read(bArr);
                                if (i < 0) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                try {
                                    throw th;
                                } catch (Throwable th) {
                                    e.F0(inputStreamOpen, th);
                                    throw th;
                                }
                            }
                            fileOutputStream.close();
                            inputStreamOpen.close();
                            file.getAbsolutePath();
                        } catch (Throwable th2) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                e.F0(fileOutputStream, th2);
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void initRoutingRulesets(Context context) {
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        List<RulesetItem> listDecodeRoutingRulesets = mmkvManager.decodeRoutingRulesets();
        if (listDecodeRoutingRulesets == null || listDecodeRoutingRulesets.isEmpty()) {
            mmkvManager.encodeRoutingRulesets(getPresetRoutingRulesets$default(this, context, 0, 2, null));
        }
    }

    public final void removeRoutingRuleset(int i) {
        MmkvManager mmkvManager;
        List<RulesetItem> listDecodeRoutingRulesets;
        if (i < 0 || (listDecodeRoutingRulesets = (mmkvManager = MmkvManager.INSTANCE).decodeRoutingRulesets()) == null || listDecodeRoutingRulesets.isEmpty()) {
            return;
        }
        listDecodeRoutingRulesets.remove(i);
        mmkvManager.encodeRoutingRulesets(listDecodeRoutingRulesets);
    }

    public final boolean resetRoutingRulesets(String str) {
        if (str != null && str.length() != 0) {
            try {
                ArrayList arrayListN0 = ae.N0((Object[]) JsonUtil.INSTANCE.fromJson(str, RulesetItem[].class));
                if (!arrayListN0.isEmpty()) {
                    resetRoutingRulesetsCommon(arrayListN0);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final void resetRoutingRulesetsFromPresets(Context context, int i) {
        List<RulesetItem> presetRoutingRulesets = getPresetRoutingRulesets(context, i);
        if (presetRoutingRulesets == null) {
            return;
        }
        resetRoutingRulesetsCommon(presetRoutingRulesets);
    }

    public final boolean routingRulesetsBypassLan() {
        Boolean boolValueOf;
        boolean z;
        List<String> ip;
        List<RulesetItem> listDecodeRoutingRulesets = MmkvManager.INSTANCE.decodeRoutingRulesets();
        if (listDecodeRoutingRulesets != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listDecodeRoutingRulesets) {
                RulesetItem rulesetItem = (RulesetItem) obj;
                if (rulesetItem.getEnabled() && e4.a(rulesetItem.getOutboundTag(), AppConfig.TAG_DIRECT)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                z = false;
                break;
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                RulesetItem rulesetItem2 = (RulesetItem) it.next();
                List<String> domain = rulesetItem2.getDomain();
                z = true;
                if ((domain != null && domain.contains(AppConfig.GEOSITE_PRIVATE)) || ((ip = rulesetItem2.getIp()) != null && ip.contains(AppConfig.GEOIP_PRIVATE))) {
                    break;
                }
            }
            boolValueOf = Boolean.valueOf(z);
        } else {
            boolValueOf = null;
        }
        return e4.a(boolValueOf, Boolean.TRUE);
    }

    public final void saveRoutingRuleset(int i, RulesetItem rulesetItem) {
        MmkvManager mmkvManager;
        List<RulesetItem> listDecodeRoutingRulesets;
        if (rulesetItem == null || (listDecodeRoutingRulesets = (mmkvManager = MmkvManager.INSTANCE).decodeRoutingRulesets()) == null || listDecodeRoutingRulesets.isEmpty()) {
            return;
        }
        if (i < 0 || i >= listDecodeRoutingRulesets.size()) {
            listDecodeRoutingRulesets.add(0, rulesetItem);
        } else {
            listDecodeRoutingRulesets.set(i, rulesetItem);
        }
        mmkvManager.encodeRoutingRulesets(listDecodeRoutingRulesets);
    }

    public final void swapRoutingRuleset(int i, int i2) {
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        List<RulesetItem> listDecodeRoutingRulesets = mmkvManager.decodeRoutingRulesets();
        if (listDecodeRoutingRulesets == null || listDecodeRoutingRulesets.isEmpty()) {
            return;
        }
        Collections.swap(listDecodeRoutingRulesets, i, i2);
        mmkvManager.encodeRoutingRulesets(listDecodeRoutingRulesets);
    }

    public final void swapSubscriptions(int i, int i2) {
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        List<String> listDecodeSubsList = mmkvManager.decodeSubsList();
        if (listDecodeSubsList == null || listDecodeSubsList.isEmpty()) {
            return;
        }
        Collections.swap(listDecodeSubsList, i, i2);
        mmkvManager.encodeSubsList(listDecodeSubsList);
    }
}
