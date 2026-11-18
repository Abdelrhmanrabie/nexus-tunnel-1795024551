package defpackage;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class w4 extends n implements a5 {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private e5 mDelegate;
    private Resources mResources;

    public w4() {
        getSavedStateRegistry().c(DELEGATE_TAG, new gf(2, this));
        addOnContextAvailableListener(new hf(this, 2));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        f5 f5Var = (f5) getDelegate();
        f5Var.K();
        ((ViewGroup) f5Var.B.findViewById(R.id.content)).addView(view, layoutParams);
        f5Var.j.b.onContentChanged();
    }

    /* JADX WARN: Code duplicated, block: B:103:0x019c  */
    /* JADX WARN: Code duplicated, block: B:105:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:106:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:131:0x01af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    /* JADX WARN: Code duplicated, block: B:18:0x003b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0041  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:26:0x007b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0083  */
    /* JADX WARN: Code duplicated, block: B:31:0x008b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0093  */
    /* JADX WARN: Code duplicated, block: B:37:0x0099  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:57:0x00df  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:66:0x0102  */
    /* JADX WARN: Code duplicated, block: B:69:0x0111  */
    /* JADX WARN: Code duplicated, block: B:72:0x0120  */
    /* JADX WARN: Code duplicated, block: B:75:0x0129  */
    /* JADX WARN: Code duplicated, block: B:77:0x0133  */
    /* JADX WARN: Code duplicated, block: B:80:0x0142  */
    /* JADX WARN: Code duplicated, block: B:83:0x0151  */
    /* JADX WARN: Code duplicated, block: B:86:0x0160  */
    /* JADX WARN: Code duplicated, block: B:89:0x016b  */
    /* JADX WARN: Code duplicated, block: B:92:0x0173  */
    /* JADX WARN: Code duplicated, block: B:95:0x017b  */
    /* JADX WARN: Code duplicated, block: B:98:0x0183  */
    /* JADX WARN: Code duplicated, block: B:99:0x0186  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        int i;
        Configuration configuration;
        Configuration configuration2;
        Configuration configuration3;
        yh yhVar;
        Resources.Theme theme;
        Method method;
        float f;
        float f2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        int i41;
        LocaleList locales;
        LocaleList locales2;
        f5 f5Var = (f5) getDelegate();
        f5Var.P = true;
        int i42 = f5Var.T;
        if (i42 == -100) {
            i42 = e5.b;
        }
        int iR = f5Var.R(context, i42);
        if (f5.j0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(f5.H(context, iR, null));
            } catch (IllegalStateException unused) {
                if (context instanceof yh) {
                    ((yh) context).a(f5.H(context, iR, null));
                } else if (f5.i0) {
                    i = Build.VERSION.SDK_INT;
                    Configuration configuration4 = new Configuration();
                    configuration4.uiMode = -1;
                    configuration4.fontScale = 0.0f;
                    configuration = context.createConfigurationContext(configuration4).getResources().getConfiguration();
                    configuration2 = context.getResources().getConfiguration();
                    configuration.uiMode = configuration2.uiMode;
                    if (configuration.equals(configuration2)) {
                        configuration3 = null;
                    } else {
                        configuration3 = new Configuration();
                        configuration3.fontScale = 0.0f;
                        if (configuration.diff(configuration2) != 0) {
                            f = configuration.fontScale;
                            f2 = configuration2.fontScale;
                            if (f != f2) {
                                configuration3.fontScale = f2;
                            }
                            i2 = configuration.mcc;
                            i3 = configuration2.mcc;
                            if (i2 != i3) {
                                configuration3.mcc = i3;
                            }
                            i4 = configuration.mnc;
                            i5 = configuration2.mnc;
                            if (i4 != i5) {
                                configuration3.mnc = i5;
                            }
                            if (i >= 24) {
                                locales = configuration.getLocales();
                                locales2 = configuration2.getLocales();
                                if (!locales.equals(locales2)) {
                                    configuration3.setLocales(locales2);
                                    configuration3.locale = configuration2.locale;
                                }
                            } else if (!Objects.equals(configuration.locale, configuration2.locale)) {
                                configuration3.locale = configuration2.locale;
                            }
                            i6 = configuration.touchscreen;
                            i7 = configuration2.touchscreen;
                            if (i6 != i7) {
                                configuration3.touchscreen = i7;
                            }
                            i8 = configuration.keyboard;
                            i9 = configuration2.keyboard;
                            if (i8 != i9) {
                                configuration3.keyboard = i9;
                            }
                            i10 = configuration.keyboardHidden;
                            i11 = configuration2.keyboardHidden;
                            if (i10 != i11) {
                                configuration3.keyboardHidden = i11;
                            }
                            i12 = configuration.navigation;
                            i13 = configuration2.navigation;
                            if (i12 != i13) {
                                configuration3.navigation = i13;
                            }
                            i14 = configuration.navigationHidden;
                            i15 = configuration2.navigationHidden;
                            if (i14 != i15) {
                                configuration3.navigationHidden = i15;
                            }
                            i16 = configuration.orientation;
                            i17 = configuration2.orientation;
                            if (i16 != i17) {
                                configuration3.orientation = i17;
                            }
                            i18 = configuration.screenLayout & 15;
                            i19 = configuration2.screenLayout & 15;
                            if (i18 != i19) {
                                configuration3.screenLayout |= i19;
                            }
                            i20 = configuration.screenLayout & 192;
                            i21 = configuration2.screenLayout & 192;
                            if (i20 != i21) {
                                configuration3.screenLayout |= i21;
                            }
                            i22 = configuration.screenLayout & 48;
                            i23 = configuration2.screenLayout & 48;
                            if (i22 != i23) {
                                configuration3.screenLayout |= i23;
                            }
                            i24 = configuration.screenLayout & 768;
                            i25 = configuration2.screenLayout & 768;
                            if (i24 != i25) {
                                configuration3.screenLayout |= i25;
                            }
                            if (i >= 26) {
                                i38 = configuration.colorMode & 3;
                                i39 = configuration2.colorMode & 3;
                                if (i38 != i39) {
                                    configuration3.colorMode |= i39;
                                }
                                i40 = configuration.colorMode & 12;
                                i41 = configuration2.colorMode & 12;
                                if (i40 != i41) {
                                    configuration3.colorMode |= i41;
                                }
                            }
                            i26 = configuration.uiMode & 15;
                            i27 = configuration2.uiMode & 15;
                            if (i26 != i27) {
                                configuration3.uiMode |= i27;
                            }
                            i28 = configuration.uiMode & 48;
                            i29 = configuration2.uiMode & 48;
                            if (i28 != i29) {
                                configuration3.uiMode |= i29;
                            }
                            i30 = configuration.screenWidthDp;
                            i31 = configuration2.screenWidthDp;
                            if (i30 != i31) {
                                configuration3.screenWidthDp = i31;
                            }
                            i32 = configuration.screenHeightDp;
                            i33 = configuration2.screenHeightDp;
                            if (i32 != i33) {
                                configuration3.screenHeightDp = i33;
                            }
                            i34 = configuration.smallestScreenWidthDp;
                            i35 = configuration2.smallestScreenWidthDp;
                            if (i34 != i35) {
                                configuration3.smallestScreenWidthDp = i35;
                            }
                            i36 = configuration.densityDpi;
                            i37 = configuration2.densityDpi;
                            if (i36 != i37) {
                                configuration3.densityDpi = i37;
                            }
                        }
                    }
                    Configuration configurationH = f5.H(context, iR, configuration3);
                    yhVar = new yh(context, org.hamotunnelplus.xyz.R.plurals.pa);
                    yhVar.a(configurationH);
                    if (context.getTheme() != null) {
                        theme = yhVar.getTheme();
                        if (i >= 29) {
                            theme.rebase();
                        } else {
                            synchronized (uh.a) {
                                if (!uh.c) {
                                    Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                                    uh.b = declaredMethod;
                                    declaredMethod.setAccessible(true);
                                    uh.c = true;
                                }
                                method = uh.b;
                                if (method != null) {
                                    method.invoke(theme, null);
                                }
                            }
                        }
                    }
                    context = yhVar;
                }
            }
        } else if (context instanceof yh) {
            try {
                ((yh) context).a(f5.H(context, iR, null));
            } catch (IllegalStateException unused2) {
                if (f5.i0) {
                    i = Build.VERSION.SDK_INT;
                    Configuration configuration5 = new Configuration();
                    configuration5.uiMode = -1;
                    configuration5.fontScale = 0.0f;
                    configuration = context.createConfigurationContext(configuration5).getResources().getConfiguration();
                    configuration2 = context.getResources().getConfiguration();
                    configuration.uiMode = configuration2.uiMode;
                    if (configuration.equals(configuration2)) {
                        configuration3 = new Configuration();
                        configuration3.fontScale = 0.0f;
                        if (configuration.diff(configuration2) != 0) {
                            f = configuration.fontScale;
                            f2 = configuration2.fontScale;
                            if (f != f2) {
                                configuration3.fontScale = f2;
                            }
                            i2 = configuration.mcc;
                            i3 = configuration2.mcc;
                            if (i2 != i3) {
                                configuration3.mcc = i3;
                            }
                            i4 = configuration.mnc;
                            i5 = configuration2.mnc;
                            if (i4 != i5) {
                                configuration3.mnc = i5;
                            }
                            if (i >= 24) {
                                locales = configuration.getLocales();
                                locales2 = configuration2.getLocales();
                                if (!locales.equals(locales2)) {
                                    configuration3.setLocales(locales2);
                                    configuration3.locale = configuration2.locale;
                                }
                            } else if (!Objects.equals(configuration.locale, configuration2.locale)) {
                                configuration3.locale = configuration2.locale;
                            }
                            i6 = configuration.touchscreen;
                            i7 = configuration2.touchscreen;
                            if (i6 != i7) {
                                configuration3.touchscreen = i7;
                            }
                            i8 = configuration.keyboard;
                            i9 = configuration2.keyboard;
                            if (i8 != i9) {
                                configuration3.keyboard = i9;
                            }
                            i10 = configuration.keyboardHidden;
                            i11 = configuration2.keyboardHidden;
                            if (i10 != i11) {
                                configuration3.keyboardHidden = i11;
                            }
                            i12 = configuration.navigation;
                            i13 = configuration2.navigation;
                            if (i12 != i13) {
                                configuration3.navigation = i13;
                            }
                            i14 = configuration.navigationHidden;
                            i15 = configuration2.navigationHidden;
                            if (i14 != i15) {
                                configuration3.navigationHidden = i15;
                            }
                            i16 = configuration.orientation;
                            i17 = configuration2.orientation;
                            if (i16 != i17) {
                                configuration3.orientation = i17;
                            }
                            i18 = configuration.screenLayout & 15;
                            i19 = configuration2.screenLayout & 15;
                            if (i18 != i19) {
                                configuration3.screenLayout |= i19;
                            }
                            i20 = configuration.screenLayout & 192;
                            i21 = configuration2.screenLayout & 192;
                            if (i20 != i21) {
                                configuration3.screenLayout |= i21;
                            }
                            i22 = configuration.screenLayout & 48;
                            i23 = configuration2.screenLayout & 48;
                            if (i22 != i23) {
                                configuration3.screenLayout |= i23;
                            }
                            i24 = configuration.screenLayout & 768;
                            i25 = configuration2.screenLayout & 768;
                            if (i24 != i25) {
                                configuration3.screenLayout |= i25;
                            }
                            if (i >= 26) {
                                i38 = configuration.colorMode & 3;
                                i39 = configuration2.colorMode & 3;
                                if (i38 != i39) {
                                    configuration3.colorMode |= i39;
                                }
                                i40 = configuration.colorMode & 12;
                                i41 = configuration2.colorMode & 12;
                                if (i40 != i41) {
                                    configuration3.colorMode |= i41;
                                }
                            }
                            i26 = configuration.uiMode & 15;
                            i27 = configuration2.uiMode & 15;
                            if (i26 != i27) {
                                configuration3.uiMode |= i27;
                            }
                            i28 = configuration.uiMode & 48;
                            i29 = configuration2.uiMode & 48;
                            if (i28 != i29) {
                                configuration3.uiMode |= i29;
                            }
                            i30 = configuration.screenWidthDp;
                            i31 = configuration2.screenWidthDp;
                            if (i30 != i31) {
                                configuration3.screenWidthDp = i31;
                            }
                            i32 = configuration.screenHeightDp;
                            i33 = configuration2.screenHeightDp;
                            if (i32 != i33) {
                                configuration3.screenHeightDp = i33;
                            }
                            i34 = configuration.smallestScreenWidthDp;
                            i35 = configuration2.smallestScreenWidthDp;
                            if (i34 != i35) {
                                configuration3.smallestScreenWidthDp = i35;
                            }
                            i36 = configuration.densityDpi;
                            i37 = configuration2.densityDpi;
                            if (i36 != i37) {
                                configuration3.densityDpi = i37;
                            }
                        }
                    } else {
                        configuration3 = null;
                    }
                    Configuration configurationH2 = f5.H(context, iR, configuration3);
                    yhVar = new yh(context, org.hamotunnelplus.xyz.R.plurals.pa);
                    yhVar.a(configurationH2);
                    try {
                        if (context.getTheme() != null) {
                            theme = yhVar.getTheme();
                            if (i >= 29) {
                                theme.rebase();
                            } else {
                                synchronized (uh.a) {
                                    if (!uh.c) {
                                        try {
                                            Method declaredMethod2 = Resources.Theme.class.getDeclaredMethod("rebase", null);
                                            uh.b = declaredMethod2;
                                            declaredMethod2.setAccessible(true);
                                        } catch (NoSuchMethodException unused3) {
                                        }
                                        uh.c = true;
                                    }
                                    method = uh.b;
                                    if (method != null) {
                                        try {
                                            method.invoke(theme, null);
                                        } catch (IllegalAccessException | InvocationTargetException unused4) {
                                            uh.b = null;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (NullPointerException unused5) {
                    }
                    context = yhVar;
                }
            }
        } else if (f5.i0) {
            i = Build.VERSION.SDK_INT;
            Configuration configuration6 = new Configuration();
            configuration6.uiMode = -1;
            configuration6.fontScale = 0.0f;
            configuration = context.createConfigurationContext(configuration6).getResources().getConfiguration();
            configuration2 = context.getResources().getConfiguration();
            configuration.uiMode = configuration2.uiMode;
            if (configuration.equals(configuration2)) {
                configuration3 = new Configuration();
                configuration3.fontScale = 0.0f;
                if (configuration.diff(configuration2) != 0) {
                    f = configuration.fontScale;
                    f2 = configuration2.fontScale;
                    if (f != f2) {
                        configuration3.fontScale = f2;
                    }
                    i2 = configuration.mcc;
                    i3 = configuration2.mcc;
                    if (i2 != i3) {
                        configuration3.mcc = i3;
                    }
                    i4 = configuration.mnc;
                    i5 = configuration2.mnc;
                    if (i4 != i5) {
                        configuration3.mnc = i5;
                    }
                    if (i >= 24) {
                        locales = configuration.getLocales();
                        locales2 = configuration2.getLocales();
                        if (!locales.equals(locales2)) {
                            configuration3.setLocales(locales2);
                            configuration3.locale = configuration2.locale;
                        }
                    } else if (!Objects.equals(configuration.locale, configuration2.locale)) {
                        configuration3.locale = configuration2.locale;
                    }
                    i6 = configuration.touchscreen;
                    i7 = configuration2.touchscreen;
                    if (i6 != i7) {
                        configuration3.touchscreen = i7;
                    }
                    i8 = configuration.keyboard;
                    i9 = configuration2.keyboard;
                    if (i8 != i9) {
                        configuration3.keyboard = i9;
                    }
                    i10 = configuration.keyboardHidden;
                    i11 = configuration2.keyboardHidden;
                    if (i10 != i11) {
                        configuration3.keyboardHidden = i11;
                    }
                    i12 = configuration.navigation;
                    i13 = configuration2.navigation;
                    if (i12 != i13) {
                        configuration3.navigation = i13;
                    }
                    i14 = configuration.navigationHidden;
                    i15 = configuration2.navigationHidden;
                    if (i14 != i15) {
                        configuration3.navigationHidden = i15;
                    }
                    i16 = configuration.orientation;
                    i17 = configuration2.orientation;
                    if (i16 != i17) {
                        configuration3.orientation = i17;
                    }
                    i18 = configuration.screenLayout & 15;
                    i19 = configuration2.screenLayout & 15;
                    if (i18 != i19) {
                        configuration3.screenLayout |= i19;
                    }
                    i20 = configuration.screenLayout & 192;
                    i21 = configuration2.screenLayout & 192;
                    if (i20 != i21) {
                        configuration3.screenLayout |= i21;
                    }
                    i22 = configuration.screenLayout & 48;
                    i23 = configuration2.screenLayout & 48;
                    if (i22 != i23) {
                        configuration3.screenLayout |= i23;
                    }
                    i24 = configuration.screenLayout & 768;
                    i25 = configuration2.screenLayout & 768;
                    if (i24 != i25) {
                        configuration3.screenLayout |= i25;
                    }
                    if (i >= 26) {
                        i38 = configuration.colorMode & 3;
                        i39 = configuration2.colorMode & 3;
                        if (i38 != i39) {
                            configuration3.colorMode |= i39;
                        }
                        i40 = configuration.colorMode & 12;
                        i41 = configuration2.colorMode & 12;
                        if (i40 != i41) {
                            configuration3.colorMode |= i41;
                        }
                    }
                    i26 = configuration.uiMode & 15;
                    i27 = configuration2.uiMode & 15;
                    if (i26 != i27) {
                        configuration3.uiMode |= i27;
                    }
                    i28 = configuration.uiMode & 48;
                    i29 = configuration2.uiMode & 48;
                    if (i28 != i29) {
                        configuration3.uiMode |= i29;
                    }
                    i30 = configuration.screenWidthDp;
                    i31 = configuration2.screenWidthDp;
                    if (i30 != i31) {
                        configuration3.screenWidthDp = i31;
                    }
                    i32 = configuration.screenHeightDp;
                    i33 = configuration2.screenHeightDp;
                    if (i32 != i33) {
                        configuration3.screenHeightDp = i33;
                    }
                    i34 = configuration.smallestScreenWidthDp;
                    i35 = configuration2.smallestScreenWidthDp;
                    if (i34 != i35) {
                        configuration3.smallestScreenWidthDp = i35;
                    }
                    i36 = configuration.densityDpi;
                    i37 = configuration2.densityDpi;
                    if (i36 != i37) {
                        configuration3.densityDpi = i37;
                    }
                }
            } else {
                configuration3 = null;
            }
            Configuration configurationH3 = f5.H(context, iR, configuration3);
            yhVar = new yh(context, org.hamotunnelplus.xyz.R.plurals.pa);
            yhVar.a(configurationH3);
            if (context.getTheme() != null) {
                theme = yhVar.getTheme();
                if (i >= 29) {
                    theme.rebase();
                } else {
                    synchronized (uh.a) {
                        if (!uh.c) {
                            Method declaredMethod3 = Resources.Theme.class.getDeclaredMethod("rebase", null);
                            uh.b = declaredMethod3;
                            declaredMethod3.setAccessible(true);
                            uh.c = true;
                        }
                        method = uh.b;
                        if (method != null) {
                            method.invoke(theme, null);
                        }
                    }
                }
            }
            context = yhVar;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        t1 supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // defpackage.Cif, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        t1 supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.j(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        f5 f5Var = (f5) getDelegate();
        f5Var.K();
        return (T) f5Var.i.findViewById(i);
    }

    public e5 getDelegate() {
        if (this.mDelegate == null) {
            int i = e5.b;
            this.mDelegate = new f5(this, null, this, this);
        }
        return this.mDelegate;
    }

    public w1$a getDrawerToggleDelegate() {
        f5 f5Var = (f5) getDelegate();
        f5Var.getClass();
        return new g5(f5Var, 1);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        f5 f5Var = (f5) getDelegate();
        if (f5Var.p == null) {
            f5Var.Q();
            t1 t1Var = f5Var.o;
            f5Var.p = new l41(t1Var != null ? t1Var.e() : f5Var.g);
        }
        return f5Var.p;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i = dd1.$r8$clinit;
        }
        return resources == null ? super.getResources() : resources;
    }

    public t1 getSupportActionBar() {
        f5 f5Var = (f5) getDelegate();
        f5Var.Q();
        return f5Var.o;
    }

    public Intent getSupportParentActivityIntent() {
        return ui.a(this);
    }

    public final void initViewTreeOwners() {
        getWindow().getDecorView().setTag(org.hamotunnelplus.xyz.R.attr.a37, this);
        getWindow().getDecorView().setTag(org.hamotunnelplus.xyz.R.attr.a3_, this);
        getWindow().getDecorView().setTag(org.hamotunnelplus.xyz.R.attr.a39, this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().j();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        f5 f5Var = (f5) getDelegate();
        if (f5Var.G && f5Var.A) {
            f5Var.Q();
            t1 t1Var = f5Var.o;
            if (t1Var != null) {
                t1Var.g();
            }
        }
        o5 o5VarA = o5.a();
        Context context = f5Var.g;
        synchronized (o5VarA) {
            o5VarA.a.k(context);
        }
        f5Var.S = new Configuration(f5Var.g.getResources().getConfiguration());
        f5Var.C(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(s51 s51Var) {
        Intent intentMakeMainActivity;
        s51Var.getClass();
        ArrayList arrayList = s51Var.b;
        w4 w4Var = s51Var.c;
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = ui.a(this);
        }
        if (supportParentActivityIntent == null) {
            return;
        }
        ComponentName component = supportParentActivityIntent.getComponent();
        if (component == null) {
            component = supportParentActivityIntent.resolveActivity(w4Var.getPackageManager());
        }
        int size = arrayList.size();
        while (true) {
            try {
                String strC = ui.c(w4Var, component);
                if (strC == null) {
                    intentMakeMainActivity = null;
                } else {
                    ComponentName componentName = new ComponentName(component.getPackageName(), strC);
                    intentMakeMainActivity = ui.c(w4Var, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
                }
                if (intentMakeMainActivity == null) {
                    arrayList.add(supportParentActivityIntent);
                    return;
                } else {
                    arrayList.add(size, intentMakeMainActivity);
                    component = intentMakeMainActivity.getComponent();
                }
            } catch (PackageManager.NameNotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    @Override // androidx.fragment.app.n, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().m();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // androidx.fragment.app.n, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        t1 supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.d() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onNightModeChanged(int i) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((f5) getDelegate()).K();
    }

    @Override // androidx.fragment.app.n, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        f5 f5Var = (f5) getDelegate();
        f5Var.Q();
        t1 t1Var = f5Var.o;
        if (t1Var != null) {
            t1Var.q(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(s51 s51Var) {
    }

    @Override // androidx.fragment.app.n, android.app.Activity
    public void onStart() {
        super.onStart();
        ((f5) getDelegate()).C(true);
    }

    @Override // androidx.fragment.app.n, android.app.Activity
    public void onStop() {
        super.onStop();
        f5 f5Var = (f5) getDelegate();
        f5Var.Q();
        t1 t1Var = f5Var.o;
        if (t1Var != null) {
            t1Var.q(false);
        }
    }

    @Override // defpackage.a5
    public void onSupportActionModeFinished(y1 y1Var) {
    }

    @Override // defpackage.a5
    public void onSupportActionModeStarted(y1 y1Var) {
    }

    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        s51 s51Var = new s51(this);
        onCreateSupportNavigateUpTaskStack(s51Var);
        onPrepareSupportNavigateUpTaskStack(s51Var);
        ArrayList arrayList = s51Var.b;
        if (arrayList.isEmpty()) {
            d.AnonymousClass0.m("No intents added to TaskStackBuilder; cannot startActivities");
            return false;
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        s51Var.c.startActivities(intentArr, null);
        try {
            finishAffinity();
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().A(charSequence);
    }

    @Override // defpackage.a5
    public y1 onWindowStartingSupportActionMode(y1.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        t1 supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.k()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        initViewTreeOwners();
        getDelegate().u(i);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        initViewTreeOwners();
        f5 f5Var = (f5) getDelegate();
        f5Var.K();
        ViewGroup viewGroup = (ViewGroup) f5Var.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        f5Var.j.b.onContentChanged();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        f5 f5Var = (f5) getDelegate();
        f5Var.K();
        ViewGroup viewGroup = (ViewGroup) f5Var.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        f5Var.j.b.onContentChanged();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        f5 f5Var = (f5) getDelegate();
        Object obj = f5Var.f;
        if (obj instanceof Activity) {
            f5Var.Q();
            t1 t1Var = f5Var.o;
            if (t1Var instanceof cg1) {
                d.AnonymousClass0.m("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
                return;
            }
            f5Var.p = null;
            if (t1Var != null) {
                t1Var.h();
            }
            f5Var.o = null;
            if (toolbar != null) {
                f71 f71Var = new f71(toolbar, ((Activity) obj).getTitle(), f5Var.j);
                f5Var.o = f71Var;
                f5Var.j.c = f71Var.c;
            } else {
                f5Var.j.c = null;
            }
            f5Var.j();
        }
    }

    public void setSupportProgress(int i) {
    }

    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        ((f5) getDelegate()).U = i;
    }

    public y1 startSupportActionMode(y1.a aVar) {
        return getDelegate().B(aVar);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().j();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().t(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }
}
