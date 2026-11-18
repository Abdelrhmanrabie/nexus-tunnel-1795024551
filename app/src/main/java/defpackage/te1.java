package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class te1 {
    public static final ye1 a;
    public static final a b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends Property {
        public final /* synthetic */ int G0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(Class cls, String str, int i) {
            super(cls, str);
            this.G0 = i;
        }

        @Override // android.util.Property
        public final Object get(Object obj) {
            View view = (View) obj;
            if (this.G0 == 0) {
                return Float.valueOf(te1.a.e(view));
            }
            WeakHashMap weakHashMap = qd1.a;
            return view.getClipBounds();
        }

        @Override // android.util.Property
        public final void set(Object obj, Object obj2) {
            View view = (View) obj;
            if (this.G0 != 0) {
                WeakHashMap weakHashMap = qd1.a;
                view.setClipBounds((Rect) obj2);
            } else {
                te1.a.f(view, ((Float) obj2).floatValue());
            }
        }
    }

    static {
        int i = 3;
        a = Build.VERSION.SDK_INT >= 29 ? new ze1(i) : new ye1(i);
        b = new a(Float.class, "translationAlpha", 0);
        new a(Rect.class, "clipBounds", 1);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        a.i(view, i, i2, i3, i4);
    }
}
