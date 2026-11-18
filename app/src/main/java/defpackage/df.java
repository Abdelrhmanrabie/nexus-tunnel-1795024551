package defpackage;

import android.content.Context;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class df implements Runnable {
    public final /* synthetic */ int G0;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ df(Object obj, int i, int i2) {
        this.G0 = i2;
        this.b = i;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.G0;
        int i2 = this.b;
        Object obj = this.c;
        int i3 = 0;
        if (i == 0) {
            Context context = (Context) obj;
            if (i2 == 0) {
                ComponentActivity.k((ComponentActivity) context);
                return;
            }
            if (i2 != 1) {
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new jf(context, 3, i3));
                return;
            }
            try {
                super/*android.app.Activity*/.onBackPressed();
                return;
            } catch (IllegalStateException e) {
                if (!e4.a(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
                return;
            } catch (NullPointerException e2) {
                if (!e4.a(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e2;
                }
                return;
            }
        }
        if (i == 1) {
            ak akVar = ((ta1.a) obj).m;
            if (akVar != null) {
                akVar.onFontRetrievalFailed(i2);
                return;
            }
            return;
        }
        if (i != 2) {
            ((ak) obj).onFontRetrievalFailed(i2);
            return;
        }
        int i4 = HamoTunnelPlusMain.b1;
        RecyclerView recyclerView = (RecyclerView) obj;
        View viewFindViewByPosition = recyclerView.mLayout.findViewByPosition(i2);
        if (viewFindViewByPosition != null) {
            int[] iArr = new int[2];
            viewFindViewByPosition.getLocationOnScreen(iArr);
            recyclerView.scrollBy(((viewFindViewByPosition.getWidth() / 2) + iArr[0]) - (recyclerView.getWidth() / 2), 0);
        }
    }
}
