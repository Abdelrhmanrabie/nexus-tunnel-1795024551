package renz.javacodez.v2ray.extension;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import defpackage.e71;
import defpackage.jo0;
import defpackage.lw;
import defpackage.lx0;
import defpackage.q31;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.V2RAYApp;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class _ExtKt {
    public static final double DIVISOR = 1024.0d;
    public static final long THRESHOLD = 1000;

    public static final String getIdnHost(URI uri) {
        String host = uri.getHost();
        String strB0 = host != null ? q31.b0(q31.b0(host, "[", AppConfig.CUSTOM), "]", AppConfig.CUSTOM) : null;
        return strB0 == null ? AppConfig.CUSTOM : strB0;
    }

    public static final long getResponseLength(URLConnection uRLConnection) {
        return Build.VERSION.SDK_INT >= 24 ? uRLConnection.getContentLengthLong() : uRLConnection.getContentLength();
    }

    public static final V2RAYApp getV2RayApplication(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof V2RAYApp) {
            return (V2RAYApp) applicationContext;
        }
        return null;
    }

    public static final boolean isNotNullEmpty(CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0;
    }

    public static final BroadcastReceiver listenForPackageChanges(Context context, final boolean z, final lw lwVar) {
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: renz.javacodez.v2ray.extension._ExtKt.listenForPackageChanges.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                lwVar.invoke();
                if (z) {
                    context2.unregisterReceiver(this);
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 33) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            context.registerReceiver(broadcastReceiver, intentFilter, 2);
            return broadcastReceiver;
        }
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter2.addDataScheme("package");
        context.registerReceiver(broadcastReceiver, intentFilter2);
        return broadcastReceiver;
    }

    public static /* synthetic */ BroadcastReceiver listenForPackageChanges$default(Context context, boolean z, lw lwVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return listenForPackageChanges(context, z, lwVar);
    }

    public static final void putOpt(JSONObject jSONObject, Map<String, ? extends Object> map) throws JSONException {
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
    }

    public static final void putOpt(JSONObject jSONObject, jo0 jo0Var) throws JSONException {
        jSONObject.put((String) jo0Var.b, jo0Var.c);
    }

    public static final String removeWhiteSpace(String str) {
        return Pattern.compile("\\s+").matcher(str).replaceAll(AppConfig.CUSTOM);
    }

    public static final /* synthetic */ <T extends Serializable> T serializable(Intent intent, String str) {
        if (Build.VERSION.SDK_INT >= 33) {
            throw null;
        }
        intent.getSerializableExtra(str);
        throw null;
    }

    public static final /* synthetic */ <T extends Serializable> T serializable(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 33) {
            throw null;
        }
        bundle.getSerializable(str);
        throw null;
    }

    public static final long toLongEx(String str) {
        Long lV = q31.V(str);
        if (lV != null) {
            return lV.longValue();
        }
        return 0L;
    }

    public static final String toSpeedString(long j) {
        return toTrafficString(j) + "/s";
    }

    public static final String toTrafficString(long j) {
        String[] strArr = {"B", "KB", "MB", "GB", "TB", "PB"};
        double d = j;
        int i = 0;
        while (d >= 1000.0d && i < 5) {
            d /= 1024.0d;
            i++;
        }
        return String.format("%.1f %s", Arrays.copyOf(new Object[]{Double.valueOf(d), strArr[i]}, 2));
    }

    public static final void toast(Context context, int i) {
        int i2 = e71.$r8$clinit;
        Toast toastMakeText = Toast.makeText(context, context.getResources().getText(i), 0);
        View view = toastMakeText.getView();
        lx0 lx0Var = new lx0(context);
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(view, lx0Var);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        new e71(context, toastMakeText).show();
    }

    public static final void toast(Context context, CharSequence charSequence) {
        int i = e71.$r8$clinit;
        Toast toastMakeText = Toast.makeText(context, charSequence, 0);
        View view = toastMakeText.getView();
        lx0 lx0Var = new lx0(context);
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(view, lx0Var);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        new e71(context, toastMakeText).show();
    }
}
