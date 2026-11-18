package renz.javacodez.v2ray.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import defpackage.zk;
import java.util.Locale;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MyContextWrapper extends ContextWrapper {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(zk zkVar) {
            this();
        }

        public final ContextWrapper wrap(Context context, Locale locale) {
            Configuration configuration = context.getResources().getConfiguration();
            int i = Build.VERSION.SDK_INT;
            configuration.setLocale(locale);
            if (i >= 24) {
                LocaleList localeList = new LocaleList(locale);
                LocaleList.setDefault(localeList);
                configuration.setLocales(localeList);
            }
            return new ContextWrapper(context.createConfigurationContext(configuration));
        }
    }

    public MyContextWrapper(Context context) {
        super(context);
    }
}
