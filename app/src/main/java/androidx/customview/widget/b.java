package androidx.customview.widget;

import android.graphics.Rect;
import defpackage.o1;
import java.util.Comparator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface a<T> {
    }

    /* JADX INFO: renamed from: androidx.customview.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface InterfaceC0010b<T, V> {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c<T> implements Comparator<T> {
        public final Rect b = new Rect();
        public final Rect c = new Rect();
        public final boolean d;
        public final a f;

        public c(boolean z, a<T> aVar) {
            this.d = z;
            this.f = aVar;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            ((androidx.customview.widget.a.C0009a) this.f).getClass();
            Rect rect = this.b;
            ((o1) obj).f(rect);
            Rect rect2 = this.c;
            ((o1) obj2).f(rect2);
            int i = rect.top;
            int i2 = rect2.top;
            if (i < i2) {
                return -1;
            }
            if (i > i2) {
                return 1;
            }
            int i3 = rect.left;
            int i4 = rect2.left;
            boolean z = this.d;
            if (i3 < i4) {
                return z ? 1 : -1;
            }
            if (i3 > i4) {
                return z ? -1 : 1;
            }
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            if (i5 < i6) {
                return -1;
            }
            if (i5 > i6) {
                return 1;
            }
            int i7 = rect.right;
            int i8 = rect2.right;
            if (i7 < i8) {
                return z ? 1 : -1;
            }
            if (i7 > i8) {
                return z ? -1 : 1;
            }
            return 0;
        }
    }
}
