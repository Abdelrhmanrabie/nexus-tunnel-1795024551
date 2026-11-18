package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class v extends q {
    public final /* synthetic */ w a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(w wVar, Context context) {
        super(context);
        this.a = wVar;
    }

    @Override // androidx.recyclerview.widget.q
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.q
    public final int calculateTimeForScrolling(int i) {
        return Math.min(100, super.calculateTimeForScrolling(i));
    }

    @Override // androidx.recyclerview.widget.q, androidx.recyclerview.widget.RecyclerView.z
    public final void onTargetFound(View view, RecyclerView.z.a aVar) {
        w wVar = this.a;
        int[] iArrA = wVar.a(wVar.a.mLayout, view);
        int i = iArrA[0];
        int i2 = iArrA[1];
        int iCeil = (int) Math.ceil(((double) calculateTimeForScrolling(Math.max(Math.abs(i), Math.abs(i2)))) / 0.3356d);
        if (iCeil > 0) {
            aVar.a = i;
            aVar.b = i2;
            aVar.c = iCeil;
            aVar.e = this.mDecelerateInterpolator;
            aVar.f = true;
        }
    }
}
