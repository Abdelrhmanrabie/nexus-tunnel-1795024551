package androidx.navigation;

import android.os.Bundle;
import defpackage.bk0;
import defpackage.ck0;
import java.util.HashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: androidx.navigation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class C0016a implements Comparable<C0016a> {
        public final Bundle c;
        public final boolean d;
        public final boolean f;
        public final int g;

        public C0016a(a aVar, Bundle bundle, boolean z, boolean z2, int i) {
            this.c = bundle;
            this.d = z;
            this.f = z2;
            this.g = i;
        }

        @Override // java.lang.Comparable
        public final int compareTo(C0016a c0016a) {
            C0016a c0016a2 = c0016a;
            boolean z = this.d;
            if (z && !c0016a2.d) {
                return 1;
            }
            if (!z && c0016a2.d) {
                return -1;
            }
            Bundle bundle = this.c;
            if (bundle != null && c0016a2.c == null) {
                return 1;
            }
            if (bundle == null && c0016a2.c != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size() - c0016a2.c.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z2 = this.f;
            if (z2 && !c0016a2.f) {
                return 1;
            }
            if (z2 || !c0016a2.f) {
                return this.g - c0016a2.g;
            }
            return -1;
        }
    }

    static {
        new HashMap();
    }

    public a(bk0 bk0Var) {
        ck0.b(bk0Var.getClass());
    }

    public String toString() {
        return getClass().getSimpleName() + "(0x" + Integer.toHexString(0) + ")";
    }
}
