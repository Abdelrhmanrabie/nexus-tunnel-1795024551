package com.erlite.themelite;

import android.content.SharedPreferences;
import renz.javacodez.vpn.activities.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ThemeLite {
    public SharedPreferences.Editor editor;
    public int getTheme;
    public final int isDark = 2;

    public ThemeLite(d dVar) {
        this.getTheme = dVar.getSharedPreferences("darkLite", 0).getInt("ThemeValue", 1);
    }
}
