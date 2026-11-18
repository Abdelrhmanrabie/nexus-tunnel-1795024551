package defpackage;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class jg1 extends e {
    public final WindowInsetsController j;
    public final Window k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jg1(Window window) {
        super(3);
        WindowInsetsController insetsController = window.getInsetsController();
        this.j = insetsController;
        this.k = window;
    }

    @Override // defpackage.e
    public final void b(boolean z) {
        WindowInsetsController windowInsetsController = this.j;
        Window window = this.k;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            windowInsetsController.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        windowInsetsController.setSystemBarsAppearance(0, 16);
    }

    @Override // defpackage.e
    public final void c(boolean z) {
        WindowInsetsController windowInsetsController = this.j;
        Window window = this.k;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
            }
            windowInsetsController.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        windowInsetsController.setSystemBarsAppearance(0, 8);
    }
}
