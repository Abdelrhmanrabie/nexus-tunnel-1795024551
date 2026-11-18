package net.openvpn.ovpn3;

import android.content.SharedPreferences;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PrefUtil {
    private static final String TAG = "PrefUtil";
    private SharedPreferences mSettings;

    public PrefUtil(SharedPreferences sharedPreferences) {
        this.mSettings = sharedPreferences;
    }

    private String key_by_profile(String str, String str2) {
        return str2 + "." + str;
    }

    public boolean contains_key(String str) {
        return this.mSettings.contains(str);
    }

    public void delete_key(String str) {
        SharedPreferences.Editor editorEdit = this.mSettings.edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public void delete_key_by_profile(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.mSettings.edit();
        editorEdit.remove(key_by_profile(str, str2));
        editorEdit.apply();
    }

    public boolean get_boolean(String str, boolean z) {
        try {
            return this.mSettings.getBoolean(str, z);
        } catch (ClassCastException unused) {
            return z;
        }
    }

    public boolean get_boolean_by_profile(String str, String str2, boolean z) {
        try {
            return this.mSettings.getBoolean(key_by_profile(str, str2), z);
        } catch (ClassCastException unused) {
            return z;
        }
    }

    public String get_string(String str) {
        try {
            return this.mSettings.getString(str, null);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public String get_string_by_profile(String str, String str2) {
        try {
            return this.mSettings.getString(key_by_profile(str, str2), null);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public Set<String> get_string_set(String str) {
        try {
            Set<String> stringSet = this.mSettings.getStringSet(str, null);
            String.format("get_string_set: %s='%s'", str, stringSet);
            return stringSet;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public void set_boolean(String str, boolean z) {
        SharedPreferences.Editor editorEdit = this.mSettings.edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    public void set_boolean_by_profile(String str, String str2, boolean z) {
        SharedPreferences.Editor editorEdit = this.mSettings.edit();
        editorEdit.putBoolean(key_by_profile(str, str2), z);
        editorEdit.apply();
    }

    public void set_string(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.mSettings.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public void set_string_by_profile(String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = this.mSettings.edit();
        editorEdit.putString(key_by_profile(str, str2), str3);
        editorEdit.apply();
    }

    public void set_string_set(String str, Set<String> set) {
        SharedPreferences.Editor editorEdit = this.mSettings.edit();
        editorEdit.putStringSet(str, set);
        String.format("set_string: %s='%s'", str, set);
        editorEdit.apply();
    }
}
