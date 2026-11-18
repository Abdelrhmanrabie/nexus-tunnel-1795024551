package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class zo implements wo {
    public static final zo b;
    public static final /* synthetic */ zo[] c;

    static {
        zo zoVar = new zo("DISPOSED", 0);
        b = zoVar;
        c = new zo[]{zoVar};
    }

    public static void b(AtomicReference atomicReference) {
        wo woVar;
        wo woVar2 = (wo) atomicReference.get();
        zo zoVar = b;
        if (woVar2 == zoVar || (woVar = (wo) atomicReference.getAndSet(zoVar)) == zoVar || woVar == null) {
            return;
        }
        woVar.a();
    }

    public static boolean c(AtomicReference atomicReference, wo woVar) {
        while (!atomicReference.compareAndSet(null, woVar)) {
            if (atomicReference.get() != null) {
                woVar.a();
                if (atomicReference.get() != b) {
                    ui.a(new ob1("Disposable already set!"));
                }
                return false;
            }
        }
        return true;
    }

    public static zo valueOf(String str) {
        return (zo) Enum.valueOf(zo.class, str);
    }

    public static zo[] values() {
        return (zo[]) c.clone();
    }

    @Override // defpackage.wo
    public final void a() {
    }
}
