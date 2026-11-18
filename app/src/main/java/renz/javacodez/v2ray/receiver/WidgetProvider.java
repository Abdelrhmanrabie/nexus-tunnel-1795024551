package renz.javacodez.v2ray.receiver;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.R;
import renz.javacodez.v2ray.service.V2RayServiceManager;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetProvider extends AppWidgetProvider {
    private final void updateWidgetBackground(Context context, AppWidgetManager appWidgetManager, int[] iArr, boolean z) {
        int i;
        int i2;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_switch);
        Intent intent = new Intent(context, (Class<?>) WidgetProvider.class);
        intent.setAction(AppConfig.BROADCAST_ACTION_WIDGET_CLICK);
        int i3 = R.id.layout_switch;
        remoteViews.setOnClickPendingIntent(i3, PendingIntent.getBroadcast(context, i3, intent, 201326592));
        if (z) {
            remoteViews.setInt(R.id.image_switch, "setImageResource", R.drawable.ic_stop_24dp);
            i = R.id.layout_background;
            i2 = R.drawable.ic_rounded_corner_active;
        } else {
            remoteViews.setInt(R.id.image_switch, "setImageResource", R.drawable.ic_play_24dp);
            i = R.id.layout_background;
            i2 = R.drawable.ic_rounded_corner_inactive;
        }
        remoteViews.setInt(i, "setBackgroundResource", i2);
        for (int i4 : iArr) {
            appWidgetManager.updateAppWidget(i4, remoteViews);
        }
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AppWidgetManager appWidgetManager;
        super.onReceive(context, intent);
        if (AppConfig.BROADCAST_ACTION_WIDGET_CLICK.equals(intent.getAction())) {
            if (V2RayServiceManager.INSTANCE.getV2rayPoint().getIsRunning()) {
                Utils.INSTANCE.stopVService(context);
                return;
            } else {
                Utils.INSTANCE.startVServiceFromToggle(context);
                return;
            }
        }
        if (!AppConfig.BROADCAST_ACTION_ACTIVITY.equals(intent.getAction()) || (appWidgetManager = AppWidgetManager.getInstance(context)) == null) {
            return;
        }
        int intExtra = intent.getIntExtra("key", 0);
        if (intExtra != 11) {
            if (intExtra != 12) {
                if (intExtra != 31) {
                    if (intExtra != 32 && intExtra != 41) {
                        return;
                    }
                }
            }
            updateWidgetBackground(context, appWidgetManager, appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) WidgetProvider.class)), false);
            return;
        }
        updateWidgetBackground(context, appWidgetManager, appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) WidgetProvider.class)), true);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        updateWidgetBackground(context, appWidgetManager, iArr, V2RayServiceManager.INSTANCE.getV2rayPoint().getIsRunning());
    }
}
