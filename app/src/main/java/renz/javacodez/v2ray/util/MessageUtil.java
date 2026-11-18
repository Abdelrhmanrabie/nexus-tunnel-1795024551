package renz.javacodez.v2ray.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.io.Serializable;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.service.V2RayTestService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MessageUtil {
    public static final MessageUtil INSTANCE = new MessageUtil();

    private MessageUtil() {
    }

    private final void sendMsg(Context context, String str, int i, Serializable serializable) {
        try {
            Intent intent = new Intent();
            intent.setAction(str);
            intent.setPackage(AppConfig.ANG_PACKAGE);
            intent.putExtra("key", i);
            intent.putExtra("content", serializable);
            context.sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void sendMsg2Service(Context context, int i, Serializable serializable) {
        sendMsg(context, AppConfig.BROADCAST_ACTION_SERVICE, i, serializable);
    }

    public final void sendMsg2TestService(Context context, int i, Serializable serializable) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context, (Class<?>) V2RayTestService.class));
            intent.putExtra("key", i);
            intent.putExtra("content", serializable);
            context.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void sendMsg2UI(Context context, int i, Serializable serializable) {
        sendMsg(context, AppConfig.BROADCAST_ACTION_ACTIVITY, i, serializable);
    }
}
