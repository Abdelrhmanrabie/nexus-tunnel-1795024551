package renz.javacodez.v2ray.handler;

import android.content.Context;
import com.tencent.mmkv.MMKV;
import defpackage.ae;
import defpackage.e;
import defpackage.e4;
import defpackage.fc;
import defpackage.he;
import defpackage.jo0;
import defpackage.q31;
import defpackage.rc0;
import defpackage.uh0;
import defpackage.v41;
import defpackage.yi;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.AssetUrlItem;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.RulesetItem;
import renz.javacodez.v2ray.dto.ServerAffiliationInfo;
import renz.javacodez.v2ray.dto.SubscriptionItem;
import renz.javacodez.v2ray.util.JsonUtil;
import renz.javacodez.v2ray.util.Utils;
import renz.javacodez.vpn.utils.RenzUtils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MmkvManager {
    private static final String ID_ASSET = "ASSET";
    private static final String ID_MAIN = "MAIN";
    private static final String ID_PROFILE_FULL_CONFIG = "PROFILE_FULL_CONFIG";
    private static final String ID_SERVER_AFF = "SERVER_AFF";
    private static final String ID_SERVER_RAW = "SERVER_RAW";
    private static final String ID_SETTING = "SETTING";
    private static final String ID_SUB = "SUB";
    public static final MmkvManager INSTANCE = new MmkvManager();
    private static final String KEY_ANG_CONFIGS = "ANG_CONFIGS";
    private static final String KEY_SELECTED_SERVER = "SELECTED_SERVER";
    private static final String KEY_SUB_IDS = "SUB_IDS";
    private static final rc0 assetStorage$delegate;
    private static final rc0 mainStorage$delegate;
    private static final rc0 profileFullStorage$delegate;
    private static final rc0 serverAffStorage$delegate;
    private static final rc0 serverRawStorage$delegate;
    private static final rc0 settingsStorage$delegate;
    private static final rc0 subStorage$delegate;

    static {
        int i = 0;
        int i2 = 1;
        mainStorage$delegate = new v41(new uh0(i, i2));
        int i3 = 2;
        profileFullStorage$delegate = new v41(new uh0(i, i3));
        int i4 = 3;
        serverRawStorage$delegate = new v41(new uh0(i, i4));
        serverAffStorage$delegate = new v41(new uh0(i2, i));
        subStorage$delegate = new v41(new uh0(i2, i2));
        assetStorage$delegate = new v41(new uh0(i2, i3));
        settingsStorage$delegate = new v41(new uh0(i2, i4));
    }

    private MmkvManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV assetStorage_delegate$lambda$5() {
        return MMKV.mmkvWithID(ID_ASSET, 2);
    }

    private final String decryptString(Context context, String str) {
        try {
            Method method = RenzUtils.class.getMethod("decrypt", Context.class, byte[].class, Integer.TYPE);
            Charset charset = fc.a;
            return new String((byte[]) method.invoke(RenzUtils.class, context, str.getBytes(charset), 1), charset);
        } catch (Exception unused) {
            throw new yi("An operation is not implemented: Not yet implemented");
        }
    }

    private final String encryptString(String str) {
        try {
            Method method = RenzUtils.class.getMethod("encrypt", byte[].class, Integer.TYPE);
            Charset charset = fc.a;
            return new String((byte[]) method.invoke(RenzUtils.class, str.getBytes(charset), 1), charset);
        } catch (Exception unused) {
            throw new yi("An operation is not implemented: Not yet implemented");
        }
    }

    private final MMKV getAssetStorage() {
        return (MMKV) assetStorage$delegate.getValue();
    }

    private final MMKV getMainStorage() {
        return (MMKV) mainStorage$delegate.getValue();
    }

    private final MMKV getProfileFullStorage() {
        return (MMKV) profileFullStorage$delegate.getValue();
    }

    private final MMKV getServerAffStorage() {
        return (MMKV) serverAffStorage$delegate.getValue();
    }

    private final MMKV getServerRawStorage() {
        return (MMKV) serverRawStorage$delegate.getValue();
    }

    private final MMKV getSettingsStorage() {
        return (MMKV) settingsStorage$delegate.getValue();
    }

    private final MMKV getSubStorage() {
        return (MMKV) subStorage$delegate.getValue();
    }

    private final void initSubsList() {
        List<String> listDecodeSubsList = decodeSubsList();
        if (listDecodeSubsList.isEmpty()) {
            String[] strArrAllKeys = getSubStorage().allKeys();
            if (strArrAllKeys != null) {
                for (String str : strArrAllKeys) {
                    listDecodeSubsList.add(str);
                }
            }
            encodeSubsList(listDecodeSubsList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV mainStorage_delegate$lambda$0() {
        return MMKV.mmkvWithID(ID_MAIN, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV profileFullStorage_delegate$lambda$1() {
        return MMKV.mmkvWithID(ID_PROFILE_FULL_CONFIG, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV serverAffStorage_delegate$lambda$3() {
        return MMKV.mmkvWithID(ID_SERVER_AFF, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV serverRawStorage_delegate$lambda$2() {
        return MMKV.mmkvWithID(ID_SERVER_RAW, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV settingsStorage_delegate$lambda$6() {
        return MMKV.mmkvWithID(ID_SETTING, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV subStorage_delegate$lambda$4() {
        return MMKV.mmkvWithID(ID_SUB, 2);
    }

    public final void clearAllTestDelayResults(List<String> list) {
        if (list != null) {
            for (String str : list) {
                MmkvManager mmkvManager = INSTANCE;
                ServerAffiliationInfo serverAffiliationInfoDecodeServerAffiliationInfo = mmkvManager.decodeServerAffiliationInfo(str);
                if (serverAffiliationInfoDecodeServerAffiliationInfo != null) {
                    serverAffiliationInfoDecodeServerAffiliationInfo.setTestDelayMillis(0L);
                    mmkvManager.getServerAffStorage().encode(str, JsonUtil.INSTANCE.toJson(serverAffiliationInfoDecodeServerAffiliationInfo));
                }
            }
        }
    }

    public final AssetUrlItem decodeAsset(String str) {
        String strDecodeString = getAssetStorage().decodeString(str);
        if (strDecodeString == null) {
            return null;
        }
        return (AssetUrlItem) JsonUtil.INSTANCE.fromJson(strDecodeString, AssetUrlItem.class);
    }

    public final List<jo0> decodeAssetUrls() {
        ArrayList arrayList = new ArrayList();
        String[] strArrAllKeys = getAssetStorage().allKeys();
        if (strArrAllKeys != null) {
            for (String str : strArrAllKeys) {
                String strDecodeString = INSTANCE.getAssetStorage().decodeString(str);
                if (strDecodeString != null && !q31.m0(strDecodeString)) {
                    arrayList.add(new jo0(str, JsonUtil.INSTANCE.fromJson(strDecodeString, AssetUrlItem.class)));
                }
            }
        }
        Comparator comparator = new Comparator() { // from class: renz.javacodez.v2ray.handler.MmkvManager$decodeAssetUrls$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return e.l(Long.valueOf(((AssetUrlItem) ((jo0) t).c).getAddedTime()), Long.valueOf(((AssetUrlItem) ((jo0) t2).c).getAddedTime()));
            }
        };
        if (arrayList.size() <= 1) {
            return he.g1(arrayList);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        return Arrays.asList(array);
    }

    public final List<RulesetItem> decodeRoutingRulesets() {
        String strDecodeString = getSettingsStorage().decodeString(AppConfig.PREF_ROUTING_RULESET);
        if (strDecodeString == null || strDecodeString.length() == 0) {
            return null;
        }
        return ae.N0((Object[]) JsonUtil.INSTANCE.fromJson(strDecodeString, RulesetItem[].class));
    }

    public final ServerAffiliationInfo decodeServerAffiliationInfo(String str) {
        String strDecodeString;
        if (q31.m0(str) || (strDecodeString = getServerAffStorage().decodeString(str)) == null || q31.m0(strDecodeString)) {
            return null;
        }
        return (ServerAffiliationInfo) JsonUtil.INSTANCE.fromJson(strDecodeString, ServerAffiliationInfo.class);
    }

    public final ProfileItem decodeServerConfig(Context context, String str) {
        String strDecodeString;
        if (q31.m0(str) || (strDecodeString = getProfileFullStorage().decodeString(str)) == null || q31.m0(strDecodeString)) {
            return null;
        }
        return (ProfileItem) JsonUtil.INSTANCE.fromJson(decryptString(context, strDecodeString), ProfileItem.class);
    }

    public final List<String> decodeServerList() {
        String strDecodeString = getMainStorage().decodeString(KEY_ANG_CONFIGS);
        return (strDecodeString == null || q31.m0(strDecodeString)) ? new ArrayList() : ae.N0((Object[]) JsonUtil.INSTANCE.fromJson(strDecodeString, String[].class));
    }

    public final String decodeServerRaw(Context context, String str) {
        String strDecodeString = getServerRawStorage().decodeString(str);
        if (strDecodeString == null) {
            strDecodeString = AppConfig.CUSTOM;
        }
        return decryptString(context, strDecodeString);
    }

    public final boolean decodeSettingsBool(String str) {
        return getSettingsStorage().decodeBool(str, false);
    }

    public final boolean decodeSettingsBool(String str, boolean z) {
        return getSettingsStorage().decodeBool(str, z);
    }

    public final int decodeSettingsInt(String str, int i) {
        return getSettingsStorage().decodeInt(str, i);
    }

    public final String decodeSettingsString(String str) {
        return getSettingsStorage().decodeString(str);
    }

    public final String decodeSettingsString(String str, String str2) {
        return getSettingsStorage().decodeString(str, str2);
    }

    public final Set<String> decodeSettingsStringSet(String str) {
        return getSettingsStorage().decodeStringSet(str);
    }

    public final boolean decodeStartOnBoot() {
        return decodeSettingsBool(AppConfig.PREF_IS_BOOTED, false);
    }

    public final List<String> decodeSubsList() {
        String strDecodeString = getMainStorage().decodeString(KEY_SUB_IDS);
        return (strDecodeString == null || q31.m0(strDecodeString)) ? new ArrayList() : ae.N0((Object[]) JsonUtil.INSTANCE.fromJson(strDecodeString, String[].class));
    }

    public final SubscriptionItem decodeSubscription(String str) {
        String strDecodeString = getSubStorage().decodeString(str);
        if (strDecodeString == null) {
            return null;
        }
        return (SubscriptionItem) JsonUtil.INSTANCE.fromJson(strDecodeString, SubscriptionItem.class);
    }

    public final List<jo0> decodeSubscriptions() {
        initSubsList();
        ArrayList arrayList = new ArrayList();
        for (String str : decodeSubsList()) {
            String strDecodeString = INSTANCE.getSubStorage().decodeString(str);
            if (strDecodeString != null && !q31.m0(strDecodeString)) {
                arrayList.add(new jo0(str, JsonUtil.INSTANCE.fromJson(strDecodeString, SubscriptionItem.class)));
            }
        }
        return arrayList;
    }

    public final void encodeAsset(String str, AssetUrlItem assetUrlItem) {
        if (q31.m0(str)) {
            str = Utils.INSTANCE.getUuid();
        }
        getAssetStorage().encode(str, JsonUtil.INSTANCE.toJson(assetUrlItem));
    }

    public final void encodeRoutingRulesets(List<RulesetItem> list) {
        encodeSettings(AppConfig.PREF_ROUTING_RULESET, (list == null || list.isEmpty()) ? AppConfig.CUSTOM : JsonUtil.INSTANCE.toJson(list));
    }

    public final String encodeServerConfig(String str, ProfileItem profileItem) {
        if (q31.m0(str)) {
            str = Utils.INSTANCE.getUuid();
        }
        getProfileFullStorage().encode(str, encryptString(JsonUtil.INSTANCE.toJson(profileItem)));
        List<String> listDecodeServerList = decodeServerList();
        if (!listDecodeServerList.contains(str)) {
            listDecodeServerList.add(0, str);
            encodeServerList(listDecodeServerList);
            String selectServer = getSelectServer();
            if (selectServer == null || q31.m0(selectServer)) {
                getMainStorage().encode(KEY_SELECTED_SERVER, str);
            }
        }
        return str;
    }

    public final void encodeServerList(List<String> list) {
        getMainStorage().encode(KEY_ANG_CONFIGS, JsonUtil.INSTANCE.toJson(list));
    }

    public final void encodeServerRaw(String str, String str2) {
        getServerRawStorage().encode(str, encryptString(str2));
    }

    public final void encodeServerTestDelayMillis(String str, long j) {
        if (q31.m0(str)) {
            return;
        }
        ServerAffiliationInfo serverAffiliationInfoDecodeServerAffiliationInfo = decodeServerAffiliationInfo(str);
        if (serverAffiliationInfoDecodeServerAffiliationInfo == null) {
            serverAffiliationInfoDecodeServerAffiliationInfo = new ServerAffiliationInfo(0L, 1, null);
        }
        serverAffiliationInfoDecodeServerAffiliationInfo.setTestDelayMillis(j);
        getServerAffStorage().encode(str, JsonUtil.INSTANCE.toJson(serverAffiliationInfoDecodeServerAffiliationInfo));
    }

    public final boolean encodeSettings(String str, int i) {
        return getSettingsStorage().encode(str, i);
    }

    public final boolean encodeSettings(String str, String str2) {
        return getSettingsStorage().encode(str, str2);
    }

    public final boolean encodeSettings(String str, Set<String> set) {
        return getSettingsStorage().encode(str, set);
    }

    public final boolean encodeSettings(String str, boolean z) {
        return getSettingsStorage().encode(str, z);
    }

    public final void encodeStartOnBoot(boolean z) {
        encodeSettings(AppConfig.PREF_IS_BOOTED, z);
    }

    public final void encodeSubsList(List<String> list) {
        getMainStorage().encode(KEY_SUB_IDS, JsonUtil.INSTANCE.toJson(list));
    }

    public final String getSelectServer() {
        return getMainStorage().decodeString(KEY_SELECTED_SERVER);
    }

    public final int removeAllServer() {
        String[] strArrAllKeys = getProfileFullStorage().allKeys();
        int length = strArrAllKeys != null ? strArrAllKeys.length : 0;
        getMainStorage().clearAll();
        getProfileFullStorage().clearAll();
        getServerAffStorage().clearAll();
        return length;
    }

    public final void removeAssetUrl(String str) {
        getAssetStorage().remove(str);
    }

    public final int removeInvalidServer(String str) {
        if (str.length() > 0) {
            ServerAffiliationInfo serverAffiliationInfoDecodeServerAffiliationInfo = decodeServerAffiliationInfo(str);
            if (serverAffiliationInfoDecodeServerAffiliationInfo != null && serverAffiliationInfoDecodeServerAffiliationInfo.getTestDelayMillis() < 0) {
                INSTANCE.removeServer(str);
                return 1;
            }
        } else {
            String[] strArrAllKeys = getServerAffStorage().allKeys();
            if (strArrAllKeys != null) {
                int i = 0;
                for (String str2 : strArrAllKeys) {
                    MmkvManager mmkvManager = INSTANCE;
                    ServerAffiliationInfo serverAffiliationInfoDecodeServerAffiliationInfo2 = mmkvManager.decodeServerAffiliationInfo(str2);
                    if (serverAffiliationInfoDecodeServerAffiliationInfo2 != null && serverAffiliationInfoDecodeServerAffiliationInfo2.getTestDelayMillis() < 0) {
                        mmkvManager.removeServer(str2);
                        i++;
                    }
                }
                return i;
            }
        }
        return 0;
    }

    public final void removeServer(String str) {
        if (q31.m0(str)) {
            return;
        }
        if (e4.a(getSelectServer(), str)) {
            getMainStorage().remove(KEY_SELECTED_SERVER);
        }
        List<String> listDecodeServerList = decodeServerList();
        listDecodeServerList.remove(str);
        encodeServerList(listDecodeServerList);
        getProfileFullStorage().remove(str);
        getServerAffStorage().remove(str);
    }

    public final void setSelectServer(String str) {
        getMainStorage().encode(KEY_SELECTED_SERVER, str);
    }
}
