package defpackage;

import android.view.View;
import android.view.Window;
import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class hg1 extends e {
    public final Window j;

    public hg1(Window window) {
        super(3);
        this.j = window;
    }

    @Override // defpackage.e
    public final void c(boolean z) {
        View decorView;
        int systemUiVisibility;
        Window window = this.j;
        if (z) {
            window.clearFlags(67108864);
            window.addFlags(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
            decorView = window.getDecorView();
            systemUiVisibility = decorView.getSystemUiVisibility() | AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT;
        } else {
            decorView = window.getDecorView();
            systemUiVisibility = decorView.getSystemUiVisibility() & (-8193);
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
    }
}
