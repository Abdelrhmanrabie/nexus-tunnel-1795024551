package defpackage;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class jr extends rd {
    public final /* synthetic */ int G0;
    public final /* synthetic */ AbstractCollection a;

    public /* synthetic */ jr(AbstractCollection abstractCollection, int i) {
        this.G0 = i;
        this.a = abstractCollection;
    }

    private final void g$pn(la laVar, la laVar2) {
    }

    public static /* synthetic */ void h(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "fromSuper";
        } else if (i != 2) {
            objArr[0] = "fakeOverride";
        } else {
            objArr[0] = "fromCurrent";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
        if (i == 1 || i == 2) {
            objArr[2] = "conflict";
        } else {
            objArr[2] = "addFakeOverride";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // defpackage.v3
    public final void a(la laVar) {
        if (this.G0 != 0) {
            pn0.r(laVar, null);
            ((ArrayList) this.a).add(laVar);
        } else {
            if (laVar == null) {
                h(0);
                throw null;
            }
            pn0.r(laVar, null);
            ((LinkedHashSet) this.a).add(laVar);
        }
    }

    @Override // defpackage.rd
    public final void g(la laVar, la laVar2) {
        if (this.G0 != 0) {
            return;
        }
        if (laVar == null) {
            h(1);
            throw null;
        }
        if (laVar2 != null) {
            return;
        }
        h(2);
        throw null;
    }
}
