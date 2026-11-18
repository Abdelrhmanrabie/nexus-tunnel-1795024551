package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.vpn.utils.RenzUtils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hy0 implements SharedPreferences {
    public final Context a;
    public final SharedPreferences b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements SharedPreferences.Editor {
        public final SharedPreferences.Editor a;

        public a(hy0 hy0Var) {
            this.a = hy0Var.b.edit();
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            this.a.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.a.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            return this.a.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.a.putString(hy0.b(str), hy0.b(Boolean.toString(z)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f) {
            this.a.putString(hy0.b(str), hy0.b(Float.toString(f)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i) {
            this.a.putString(hy0.b(str), hy0.b(Integer.toString(i)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            this.a.putString(hy0.b(str), hy0.b(Long.toString(j)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            this.a.putString(hy0.b(str), hy0.b(str2));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set set) {
            HashSet hashSet = new HashSet(set.size());
            Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(hy0.b((String) it.next()));
            }
            this.a.putStringSet(hy0.b(str), hashSet);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            this.a.remove(hy0.b(str));
            return this;
        }
    }

    public hy0(Context context) {
        this.a = context;
        this.b = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static String b(String str) {
        if (str == null || str.isEmpty()) {
            return AppConfig.CUSTOM;
        }
        try {
            return new String((byte[]) RenzUtils.class.getMethod("encrypt", byte[].class, Integer.TYPE).invoke(RenzUtils.class, str.getBytes(), 0));
        } catch (Exception unused) {
            return AppConfig.CUSTOM;
        }
    }

    public final String a(String str) {
        if (str == null || str.isEmpty()) {
            return AppConfig.CUSTOM;
        }
        try {
            return new String((byte[]) RenzUtils.class.getMethod("decrypt", Context.class, byte[].class, Integer.TYPE).invoke(RenzUtils.class, this.a, str.getBytes(), 0));
        } catch (Exception unused) {
            return AppConfig.CUSTOM;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return this.b.contains(b(str));
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new a(this);
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        Map<String, ?> all = this.b.getAll();
        HashMap map = new HashMap(all.size());
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            try {
                map.put(entry.getKey(), a(entry.getValue().toString()));
            } catch (Exception unused) {
                map.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        String string = this.b.getString(b(str), null);
        if (string == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(a(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f) {
        String string = this.b.getString(b(str), null);
        if (string == null) {
            return f;
        }
        try {
            return Float.parseFloat(a(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        String string = this.b.getString(b(str), null);
        if (string == null) {
            return i;
        }
        try {
            return Integer.parseInt(a(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        String string = this.b.getString(b(str), null);
        if (string == null) {
            return j;
        }
        try {
            return Long.parseLong(a(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        String string = this.b.getString(b(str), null);
        return string != null ? a(string) : str2;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        Set<String> stringSet = this.b.getStringSet(b(str), null);
        if (stringSet == null) {
            return set;
        }
        HashSet hashSet = new HashSet(stringSet.size());
        Iterator<String> it = stringSet.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.b.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.b.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
