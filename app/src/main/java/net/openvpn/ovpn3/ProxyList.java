package net.openvpn.ovpn3;

import android.content.Context;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ProxyList {
    private static final String TAG = "ProxyList";
    private String backing_file = null;
    private Context context = null;
    private boolean dirty = false;
    private String enabled_name = null;
    private TreeMap<String, Item> list = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private String none_name;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class InternalError extends RuntimeException {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class Item {
        public boolean allow_cleartext_auth = false;
        public String friendly_name = null;
        public String host = AppConfig.CUSTOM;
        public String password = AppConfig.CUSTOM;
        public String port = AppConfig.CUSTOM;
        public boolean remember_creds = false;
        public String username = AppConfig.CUSTOM;

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject persist() {
            try {
                JSONObject jSONObject = new JSONObject();
                String str = this.friendly_name;
                if (str != null) {
                    jSONObject.put("friendly_name", str);
                }
                jSONObject.put("host", this.host);
                jSONObject.put("port", this.port);
                jSONObject.put("remember_creds", this.remember_creds);
                jSONObject.put("allow_cleartext_auth", this.allow_cleartext_auth);
                if (!this.remember_creds) {
                    return jSONObject;
                }
                jSONObject.put("username", this.username);
                jSONObject.put("password", this.password);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Item unpersist(JSONObject jSONObject) {
            try {
                Item item = new Item();
                if (jSONObject.isNull("friendly_name")) {
                    item.friendly_name = null;
                } else {
                    item.friendly_name = jSONObject.getString("friendly_name");
                }
                item.host = jSONObject.getString("host");
                item.port = jSONObject.getString("port");
                item.remember_creds = jSONObject.getBoolean("remember_creds");
                item.allow_cleartext_auth = jSONObject.getBoolean("allow_cleartext_auth");
                if (!jSONObject.isNull("username")) {
                    item.username = jSONObject.getString("username");
                }
                if (jSONObject.isNull("password")) {
                    return item;
                }
                item.password = jSONObject.getString("password");
                return item;
            } catch (JSONException unused) {
                return null;
            }
        }

        public boolean invalidate_creds() {
            if (!this.remember_creds) {
                return false;
            }
            this.username = AppConfig.CUSTOM;
            this.password = AppConfig.CUSTOM;
            this.remember_creds = false;
            return true;
        }

        public boolean is_valid() {
            return this.host.length() > 0 && this.port.length() > 0;
        }

        public String name() {
            String str = this.friendly_name;
            if (str != null) {
                return str;
            }
            return this.host + ":" + this.port;
        }
    }

    public ProxyList(String str) {
        this.none_name = null;
        if (str == null) {
            throw new InternalError();
        }
        this.none_name = str;
        set_enabled(null);
    }

    private void forget_creds(Item item) {
        if (item != null) {
            item.username = AppConfig.CUSTOM;
            item.password = AppConfig.CUSTOM;
            this.dirty = true;
        }
    }

    private JSONObject persist() {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = get_enabled(false);
            if (str != null) {
                jSONObject.put("enabled_name", str);
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<Item> it = this.list.values().iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectPersist = it.next().persist();
                if (jSONObjectPersist != null) {
                    jSONArray.put(jSONObjectPersist);
                }
            }
            jSONObject.put("list", jSONArray);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private static ProxyList unpersist(JSONObject jSONObject, String str) {
        try {
            ProxyList proxyList = new ProxyList(str);
            if (!jSONObject.isNull("enabled_name")) {
                proxyList.enabled_name = jSONObject.getString("enabled_name");
            }
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                proxyList.put(Item.unpersist(jSONArray.getJSONObject(i)));
            }
            proxyList.set_enabled(null);
            return proxyList;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void forget_creds() {
        Iterator<Item> it = this.list.values().iterator();
        while (it.hasNext()) {
            forget_creds(it.next());
        }
    }

    public void forget_creds(String str) {
        forget_creds(get(str));
    }

    public Item get(String str) {
        if (is_none(str)) {
            return null;
        }
        return this.list.get(str);
    }

    public String get_enabled(boolean z) {
        if (z || !is_none(this.enabled_name)) {
            return this.enabled_name;
        }
        return null;
    }

    public Item get_enabled_item() {
        return get(this.enabled_name);
    }

    public String[] get_name_list(boolean z) {
        int size = this.list.size();
        String[] strArr = (String[]) this.list.keySet().toArray(new String[(z ? 1 : 0) + size]);
        if (z) {
            strArr[size] = this.none_name;
        }
        return strArr;
    }

    public boolean has_saved_creds(String str) {
        Item item = get(str);
        return item != null && item.username.length() > 0;
    }

    public boolean is_none(String str) {
        return str == null || str.equals(this.none_name);
    }

    public void load() {
        try {
            if (this.backing_file != null) {
                ProxyList proxyListUnpersist = unpersist((JSONObject) new JSONTokener(FileUtil.readFileAppPrivate(this.context, this.backing_file)).nextValue(), this.none_name);
                this.list = proxyListUnpersist.list;
                this.enabled_name = proxyListUnpersist.enabled_name;
                this.dirty = false;
            }
        } catch (IOException | Exception unused) {
        }
    }

    public void put(Item item) {
        if (item != null) {
            String strName = item.name();
            if (is_none(strName)) {
                return;
            }
            this.list.put(strName, item);
            this.dirty = true;
        }
    }

    public void remove(String str) {
        if (is_none(str)) {
            return;
        }
        this.list.remove(str);
        set_enabled(null);
        this.dirty = true;
    }

    public void save() {
        String str;
        try {
            if (!this.dirty || (str = this.backing_file) == null) {
                return;
            }
            FileUtil.writeFileAppPrivate(this.context, str, persist().toString(4));
            this.dirty = false;
        } catch (Exception unused) {
        }
    }

    public void set_backing_file(Context context, String str) {
        this.context = context;
        this.backing_file = str;
    }

    public void set_enabled(String str) {
        String str2;
        String str3 = this.enabled_name;
        String str4 = str;
        if (str == null) {
            str4 = str3;
        }
        if (is_none(str4) || get(str4) == null) {
            str2 = str4;
            str2 = this.none_name;
        }
        str2 = str4;
        this.enabled_name = str2;
        if (str3 == null || !str3.equals(str2)) {
            this.dirty = true;
        }
    }

    public int size() {
        return this.list.size();
    }
}
