package defpackage;

import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.blacksquircle.ui.editorkit.widget.TextProcessor;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class h6 implements Runnable {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ int d;

    public /* synthetic */ h6(int i, Object obj, Object obj2) {
        this.G0 = 3;
        this.d = i;
        this.b = obj;
        this.c = obj2;
    }

    public h6(TextView textView, Typeface typeface, int i) {
        this.G0 = 0;
        this.b = textView;
        this.c = typeface;
        this.d = i;
    }

    public /* synthetic */ h6(Object obj, int i, Object obj2, int i2) {
        this.G0 = i2;
        this.b = obj;
        this.d = i;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.G0;
        Object obj = this.c;
        Object obj2 = this.b;
        int i2 = this.d;
        if (i == 0) {
            ((TextView) obj2).setTypeface((Typeface) obj, i2);
            return;
        }
        if (i == 1) {
            ((ProfileInstallReceiver.a) obj2).b(i2, (PackageManager.NameNotFoundException) obj);
            return;
        }
        if (i == 2) {
            Object obj3 = ((o6) obj).a;
            ComponentActivity.f fVar = (ComponentActivity.f) obj2;
            String str = (String) fVar.a.get(Integer.valueOf(i2));
            if (str == null) {
                return;
            }
            q2.a aVar = (q2.a) fVar.e.get(str);
            if ((aVar != null ? aVar.a : null) == null) {
                fVar.g.remove(str);
                fVar.f.put(str, obj3);
                return;
            } else {
                k2 k2Var = aVar.a;
                if (fVar.d.remove(str)) {
                    k2Var.a(obj3);
                    return;
                }
                return;
            }
        }
        if (i2 == 1) {
            bf1 bf1Var = (bf1) obj;
            uv.b bVar = uv.a;
            throw bf1Var;
        }
        if (i2 == 2) {
            throw null;
        }
        if (i2 != 3) {
            d.AnonymousClass0.m$1();
            return;
        }
        Iterator it = ((TextProcessor) obj2).plugins.iterator();
        if (it.hasNext()) {
            throw fb$1.m(it);
        }
    }
}
