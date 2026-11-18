package defpackage;

import com.blacksquircle.ui.editorkit.widget.TextProcessor;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f61 implements Runnable {
    public final /* synthetic */ int G0 = 0;
    public final /* synthetic */ TextProcessor b;

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.G0;
        TextProcessor textProcessor = this.b;
        if (i != 0) {
            Iterator it = textProcessor.plugins.iterator();
            if (it.hasNext()) {
                throw fb$1.m(it);
            }
        } else {
            Iterator it2 = textProcessor.plugins.iterator();
            if (it2.hasNext()) {
                throw fb$1.m(it2);
            }
        }
    }
}
