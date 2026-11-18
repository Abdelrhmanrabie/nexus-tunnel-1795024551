package defpackage;

import android.view.View;
import android.view.Window;
import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ig1 extends hg1 {
    @Override // defpackage.e
    public final void b(boolean z) {
        View decorView;
        int systemUiVisibility;
        Window window = this.j;
        if (z) {
            window.clearFlags(134217728);
            window.addFlags(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
            decorView = window.getDecorView();
            systemUiVisibility = decorView.getSystemUiVisibility() | 16;
        } else {
            decorView = window.getDecorView();
            systemUiVisibility = decorView.getSystemUiVisibility() & (-17);
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
    }
}
