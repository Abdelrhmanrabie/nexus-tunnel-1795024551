package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import defpackage.sp0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final Context a;
    public long b = 0;
    public SharedPreferences c = null;
    public SharedPreferences.Editor d;
    public boolean e;
    public final String f;
    public PreferenceScreen g;
    public androidx.preference.b h;
    public androidx.preference.b i;
    public androidx.preference.b j;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface a {
        void onDisplayPreferenceDialog(Preference preference);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface b {
        void onNavigateToScreen(PreferenceScreen preferenceScreen);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface c {
        boolean onPreferenceTreeClick(Preference preference);
    }

    public e(Context context) {
        this.a = context;
        this.f = a(context);
    }

    public static String a(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public final SharedPreferences.Editor b() {
        if (!this.e) {
            return d().edit();
        }
        if (this.d == null) {
            this.d = d().edit();
        }
        return this.d;
    }

    public final long c() {
        long j;
        synchronized (this) {
            j = this.b;
            this.b = 1 + j;
        }
        return j;
    }

    public final SharedPreferences d() {
        if (this.c == null) {
            this.c = this.a.getSharedPreferences(this.f, 0);
        }
        return this.c;
    }

    public final PreferenceScreen e(Context context, int i, PreferenceScreen preferenceScreen) {
        this.e = true;
        sp0 sp0Var = new sp0(context, this);
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            PreferenceGroup preferenceGroupC = sp0Var.c(xml, preferenceScreen);
            xml.close();
            PreferenceScreen preferenceScreen2 = (PreferenceScreen) preferenceGroupC;
            preferenceScreen2.l(this);
            SharedPreferences.Editor editor = this.d;
            if (editor != null) {
                editor.apply();
            }
            this.e = false;
            return preferenceScreen2;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}
