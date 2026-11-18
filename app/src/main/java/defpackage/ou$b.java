package defpackage;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ou$b {
    public final /* synthetic */ int G0;
    public final ContentProviderClient a;

    public ou$b(Context context, Uri uri, int i) {
        this.G0 = i;
        this.a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
    }

    public final void close() {
        int i = this.G0;
        ContentProviderClient contentProviderClient = this.a;
        if (i != 0) {
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        } else if (contentProviderClient != null) {
            contentProviderClient.release();
        }
    }
}
