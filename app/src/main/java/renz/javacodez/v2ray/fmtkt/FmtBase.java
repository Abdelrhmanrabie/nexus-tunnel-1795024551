package renz.javacodez.v2ray.fmtkt;

import defpackage.ae;
import defpackage.e4;
import defpackage.he;
import defpackage.jo0;
import defpackage.mu;
import defpackage.q31;
import defpackage.uq;
import defpackage.ye1;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.NetworkType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.plugin.PluginContract;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class FmtBase {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkType.values().length];
            try {
                iArr[NetworkType.TCP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkType.KCP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetworkType.WS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NetworkType.HTTP_UPGRADE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NetworkType.SPLIT_HTTP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[NetworkType.XHTTP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[NetworkType.HTTP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[NetworkType.H2.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[NetworkType.GRPC.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toUri$lambda$0(jo0 jo0Var) {
        return ((String) jo0Var.b) + '=' + Utils.INSTANCE.urlEncode((String) jo0Var.c);
    }

    public final void getItemFormQuery(ProfileItem profileItem, Map<String, String> map, boolean z) {
        String type = map.get("type");
        if (type == null) {
            type = NetworkType.TCP.getType();
        }
        profileItem.setNetwork(type);
        profileItem.setHeaderType(map.get("headerType"));
        profileItem.setHost(map.get("host"));
        profileItem.setPath(map.get(PluginContract.COLUMN_PATH));
        profileItem.setSeed(map.get("seed"));
        profileItem.setQuicSecurity(map.get("quicSecurity"));
        profileItem.setQuicKey(map.get("key"));
        profileItem.setMode(map.get(PluginContract.COLUMN_MODE));
        profileItem.setServiceName(map.get("serviceName"));
        profileItem.setAuthority(map.get("authority"));
        profileItem.setXhttpMode(map.get(PluginContract.COLUMN_MODE));
        profileItem.setXhttpExtra(map.get("extra"));
        profileItem.setSecurity(map.get("security"));
        if (!e4.a(profileItem.getSecurity(), AppConfig.TLS) && !e4.a(profileItem.getSecurity(), AppConfig.REALITY)) {
            profileItem.setSecurity(null);
        }
        String str = map.get("allowInsecure");
        if (str != null && str.length() != 0) {
            String str2 = map.get("allowInsecure");
            if (str2 == null) {
                str2 = AppConfig.CUSTOM;
            }
            z = str2.equals("1");
        }
        profileItem.setInsecure(Boolean.valueOf(z));
        profileItem.setSni(map.get("sni"));
        profileItem.setFingerPrint(map.get("fp"));
        profileItem.setAlpn(map.get("alpn"));
        profileItem.setPublicKey(map.get("pbk"));
        profileItem.setShortId(map.get("sid"));
        profileItem.setSpiderX(map.get("spx"));
        profileItem.setFlow(map.get("flow"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0168, code lost:
    
        if (r11.length() > 0) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x016a, code lost:
    
        r0.put(renz.javacodez.v2ray.plugin.PluginContract.COLUMN_PATH, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x016d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0110, code lost:
    
        if (r11.length() > 0) goto L104;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.HashMap<java.lang.String, java.lang.String> getQueryDic(renz.javacodez.v2ray.dto.ProfileItem r11) {
        /*
            Method dump skipped, instruction units count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: renz.javacodez.v2ray.fmtkt.FmtBase.getQueryDic(renz.javacodez.v2ray.dto.ProfileItem):java.util.HashMap");
    }

    public final Map<String, String> getQueryParam(URI uri) {
        List listS0 = q31.s0(uri.getRawQuery(), new String[]{"&"}, 6);
        int iE = ye1.e(ae.y0(listS0));
        if (iE < 16) {
            iE = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iE);
        Iterator it = listS0.iterator();
        while (it.hasNext()) {
            List listS1 = q31.s0((String) it.next(), new String[]{"="}, 6);
            linkedHashMap.put((String) listS1.get(0), Utils.INSTANCE.urlDecode((String) listS1.get(1)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    public final String toUri(ProfileItem profileItem, String str, HashMap<String, String> map) {
        String string;
        Iterable iterableSingletonList;
        Iterable iterable;
        int i = 0;
        if (map != null) {
            StringBuilder sb = new StringBuilder("?");
            if (map.size() == 0) {
                iterableSingletonList = uq.b;
                iterable = iterableSingletonList;
            } else {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    if (it.hasNext()) {
                        ArrayList arrayList = new ArrayList(map.size());
                        arrayList.add(new jo0(next.getKey(), next.getValue()));
                        do {
                            Map.Entry<String, String> next2 = it.next();
                            arrayList.add(new jo0(next2.getKey(), next2.getValue()));
                        } while (it.hasNext());
                        iterable = arrayList;
                    } else {
                        iterableSingletonList = Collections.singletonList(new jo0(next.getKey(), next.getValue()));
                    }
                } else {
                    iterableSingletonList = uq.b;
                }
                iterable = iterableSingletonList;
            }
            sb.append(he.R0(iterable, "&", null, null, new mu(i), 30));
            string = sb.toString();
        } else {
            string = AppConfig.CUSTOM;
        }
        Utils utils = Utils.INSTANCE;
        if (str == null) {
            str = AppConfig.CUSTOM;
        }
        return String.format("%s@%s:%s", Arrays.copyOf(new Object[]{utils.urlEncode(str), utils.getIpv6Address(profileItem.getServer()), profileItem.getServerPort()}, 3)) + string + '#' + utils.urlEncode(profileItem.getRemarks());
    }
}
