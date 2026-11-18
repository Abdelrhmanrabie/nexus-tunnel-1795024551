package defpackage;

import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class uv {
    public static final b a = b.c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public static final /* synthetic */ a[] o = {new a("PENALTY_LOG", 0), new a("PENALTY_DEATH", 1), new a("DETECT_FRAGMENT_REUSE", 2), new a("DETECT_FRAGMENT_TAG_USAGE", 3), new a("DETECT_RETAIN_INSTANCE_USAGE", 4), new a("DETECT_SET_USER_VISIBLE_HINT", 5), new a("DETECT_TARGET_FRAGMENT_USAGE", 6), new a("DETECT_WRONG_FRAGMENT_CONTAINER", 7)};

        /* JADX INFO: Fake field, exist only in values array */
        a EF5;

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) o.clone();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b {
        public static final b c;

        static {
            b bVar = new b();
            new LinkedHashMap();
            c = bVar;
        }
    }

    public static b a(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                fragment.getParentFragmentManager();
            }
            fragment = fragment.getParentFragment();
        }
        return a;
    }

    public static void c(bf1 bf1Var) {
        if (Log.isLoggable("FragmentManager", 3)) {
            bf1Var.b.getClass();
        }
    }

    public static final void d(Fragment fragment, String str) {
        c(new tv(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + str));
        a(fragment).getClass();
        a[] aVarArr = a.o;
    }
}
