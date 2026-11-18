package defpackage;

import android.view.View;
import androidx.transition.e;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class wv {
    public static final yv a = new yv();
    public static final cw b;

    static {
        cw cwVar = null;
        try {
            cwVar = (cw) e.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = cwVar;
    }

    public static void a(ArrayList arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }
}
