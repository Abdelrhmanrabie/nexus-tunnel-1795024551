package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.PathInterpolator;
import com.google.android.material.resources.MaterialAttributes;
import defpackage.d;
import defpackage.e4;
import renz.javacodez.v2ray.plugin.PluginContract;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MotionUtils {
    private MotionUtils() {
    }

    public static float getControlPoint(String[] strArr, int i) {
        float f = Float.parseFloat(strArr[i]);
        if (f >= 0.0f && f <= 1.0f) {
            return f;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f);
    }

    public static boolean isEasingType(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static int resolveThemeDuration(Context context, int i, int i2) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i);
        return (typedValueResolve == null || typedValueResolve.type != 16) ? i2 : typedValueResolve.data;
    }

    public static TimeInterpolator resolveThemeInterpolator(Context context, int i, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            d.AnonymousClass0.m$2("Motion easing theme attribute must be a string");
            return null;
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!isEasingType(strValueOf, "cubic-bezier")) {
            if (isEasingType(strValueOf, PluginContract.COLUMN_PATH)) {
                return new PathInterpolator(e4.d(strValueOf.substring(5, strValueOf.length() - 1)));
            }
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
        if (strArrSplit.length == 4) {
            return new PathInterpolator(getControlPoint(strArrSplit, 0), getControlPoint(strArrSplit, 1), getControlPoint(strArrSplit, 2), getControlPoint(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }
}
