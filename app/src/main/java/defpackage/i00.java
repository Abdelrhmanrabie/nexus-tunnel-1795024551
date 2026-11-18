package defpackage;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class i00 implements DrawerLayout.d {
    public final w1$a a;
    public final DrawerLayout b;
    public final hp c;
    public final int f;
    public final int g;
    public boolean h = false;
    public final /* synthetic */ HamoTunnelPlusMain i;

    public i00(HamoTunnelPlusMain hamoTunnelPlusMain, HamoTunnelPlusMain hamoTunnelPlusMain2, DrawerLayout drawerLayout, Toolbar toolbar) {
        this.i = hamoTunnelPlusMain;
        if (toolbar != null) {
            this.a = new m6(toolbar);
            kz kzVar = new kz(1, this);
            toolbar.ensureNavButtonView();
            toolbar.mNavButtonView.setOnClickListener(kzVar);
        } else {
            this.a = hamoTunnelPlusMain2.getDrawerToggleDelegate();
        }
        this.b = drawerLayout;
        this.f = R.string.app;
        this.g = R.string.app;
        this.c = new hp(this.a.a());
        this.a.d();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.d
    public final void b() {
        e(0.0f);
        this.a.mo16e(this.f);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.d
    public final void c() {
        e(1.0f);
        this.a.mo16e(this.g);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.d
    public final void d(View view, float f) {
        float f2 = 0.3f * f;
        float f3 = 1.0f - f2;
        HamoTunnelPlusMain hamoTunnelPlusMain = this.i;
        hamoTunnelPlusMain.I0.setScaleX(f3);
        hamoTunnelPlusMain.I0.setScaleY(f3);
        hamoTunnelPlusMain.I0.setTranslationX((view.getWidth() * f) - ((hamoTunnelPlusMain.I0.getWidth() * f2) / 2.0f));
        e(Math.min(1.0f, Math.max(0.0f, f)));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001f  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    public final void e(float f) {
        boolean z;
        hp hpVar = this.c;
        if (f != 1.0f) {
            z = f != 0.0f;
            if (hpVar.j != f) {
                hpVar.j = f;
                hpVar.invalidateSelf();
            }
        }
        if (hpVar.i != z) {
            hpVar.i = z;
            hpVar.invalidateSelf();
        }
        if (hpVar.j != f) {
            hpVar.j = f;
            hpVar.invalidateSelf();
        }
    }
}
