package defpackage;

import android.view.View;
import androidx.appcompat.app.e;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class kz implements View.OnClickListener {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;

    public /* synthetic */ kz(int i, Object obj) {
        this.G0 = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.G0;
        Object obj = this.b;
        if (i == 0) {
            ((e) obj).dismiss();
            return;
        }
        DrawerLayout drawerLayout = ((i00) obj).b;
        int iG = drawerLayout.g(8388611);
        View viewD = drawerLayout.d(8388611);
        if (!(viewD != null ? DrawerLayout.o(viewD) : false) || iG == 2) {
            if (iG != 1) {
                drawerLayout.q();
            }
        } else {
            View viewD2 = drawerLayout.d(8388611);
            if (viewD2 == null) {
                throw new IllegalArgumentException(ak.AnonymousClass0.m("No drawer view found with gravity ", DrawerLayout.j(8388611)));
            }
            drawerLayout.b(viewD2);
        }
    }
}
