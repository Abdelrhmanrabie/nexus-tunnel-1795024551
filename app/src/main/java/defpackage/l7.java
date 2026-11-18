package defpackage;

import defpackage.e;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class l7 implements Iterable, w90 {
    public final /* synthetic */ int G0;
    public final Object b;

    /* JADX WARN: Multi-variable type inference failed */
    public l7() {
        this.G0 = 2;
        final int i = 0;
        this.b = e.d0(new Comparable(i) { // from class: com.blacksquircle.ui.editorkit.model.LinesCollection$Line
            public final int start;

            {
                this.start = i;
            }

            @Override // java.lang.Comparable
            public final int compareTo(Object obj) {
                return this.start - ((LinesCollection$Line) obj).start;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof LinesCollection$Line) && this.start == ((LinesCollection$Line) obj).start;
            }

            public final int hashCode() {
                return this.start;
            }

            public final String toString() {
                return e.i(this.start, "Line(start=", ")");
            }
        });
    }

    public /* synthetic */ l7(int i, Object obj) {
        this.G0 = i;
        this.b = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int i = this.G0;
        Object obj = this.b;
        if (i == 0) {
            return new a7(0, (Object[]) obj);
        }
        if (i != 1) {
            return i != 2 ? ((sy0) obj).iterator() : ((ArrayList) obj).iterator();
        }
        return new c20((Iterator) ((k7) obj).invoke());
    }
}
