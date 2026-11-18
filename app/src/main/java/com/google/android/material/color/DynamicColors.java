package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class DynamicColors {
    public static final Map DYNAMIC_COLOR_SUPPORTED_BRANDS;
    public static final Map DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS;
    public static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = {R.style.k7};

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface DeviceSupportCondition {
        boolean isSupported();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public final int dynamicColorThemeOverlay;
        public final Precondition precondition;

        public DynamicColorsActivityLifecycleCallbacks(int i, Precondition precondition) {
            this.dynamicColorThemeOverlay = i;
            this.precondition = precondition;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPreCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 31) {
                Map map = DynamicColors.DYNAMIC_COLOR_SUPPORTED_BRANDS;
                return;
            }
            DeviceSupportCondition deviceSupportCondition = (DeviceSupportCondition) DynamicColors.DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS.get(Build.MANUFACTURER.toLowerCase());
            if (deviceSupportCondition == null) {
                deviceSupportCondition = (DeviceSupportCondition) DynamicColors.DYNAMIC_COLOR_SUPPORTED_BRANDS.get(Build.BRAND.toLowerCase());
            }
            if (deviceSupportCondition == null || !deviceSupportCondition.isSupported()) {
                return;
            }
            int i = this.dynamicColorThemeOverlay;
            if (i == 0) {
                TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes(DynamicColors.DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                typedArrayObtainStyledAttributes.recycle();
                i = resourceId;
            }
            if (i != 0) {
                this.precondition.getClass();
                activity.setTheme(i);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface Precondition {
    }

    static {
        DeviceSupportCondition deviceSupportCondition = new DeviceSupportCondition() { // from class: com.google.android.material.color.DynamicColors.1
            @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
            public final boolean isSupported() {
                return true;
            }
        };
        DeviceSupportCondition deviceSupportCondition2 = new DeviceSupportCondition() { // from class: com.google.android.material.color.DynamicColors.2
            public Long version;

            @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
            public final boolean isSupported() {
                if (this.version == null) {
                    try {
                        Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                        declaredMethod.setAccessible(true);
                        Long l = (Long) declaredMethod.invoke(null, "ro.build.version.oneui");
                        l.getClass();
                        this.version = l;
                    } catch (Exception unused) {
                        this.version = -1L;
                    }
                }
                return this.version.longValue() >= 40100;
            }
        };
        HashMap map = new HashMap();
        map.put("oppo", deviceSupportCondition);
        map.put("realme", deviceSupportCondition);
        map.put("oneplus", deviceSupportCondition);
        map.put("vivo", deviceSupportCondition);
        map.put("xiaomi", deviceSupportCondition);
        map.put("motorola", deviceSupportCondition);
        map.put("itel", deviceSupportCondition);
        map.put("tecno mobile limited", deviceSupportCondition);
        map.put("infinix mobility limited", deviceSupportCondition);
        map.put("hmd global", deviceSupportCondition);
        map.put("sharp", deviceSupportCondition);
        map.put("sony", deviceSupportCondition);
        map.put("tcl", deviceSupportCondition);
        map.put("lenovo", deviceSupportCondition);
        map.put("lge", deviceSupportCondition);
        map.put("google", deviceSupportCondition);
        map.put("robolectric", deviceSupportCondition);
        map.put("samsung", deviceSupportCondition2);
        DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("asus", deviceSupportCondition);
        map2.put("jio", deviceSupportCondition);
        DYNAMIC_COLOR_SUPPORTED_BRANDS = Collections.unmodifiableMap(map2);
        new Precondition() { // from class: com.google.android.material.color.DynamicColors.3
        };
    }

    private DynamicColors() {
    }
}
