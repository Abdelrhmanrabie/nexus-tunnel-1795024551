package defpackage;

import java.util.Collection;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface la extends ja, qg0 {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a f;
        public static final /* synthetic */ a[] g;

        static {
            a aVar = new a("DECLARATION", 0);
            b = aVar;
            a aVar2 = new a("FAKE_OVERRIDE", 1);
            c = aVar2;
            a aVar3 = new a("DELEGATION", 2);
            d = aVar3;
            a aVar4 = new a("SYNTHESIZED", 3);
            f = aVar4;
            g = new a[]{aVar, aVar2, aVar3, aVar4};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) g.clone();
        }
    }

    void E0(Collection collection);

    @Override // defpackage.ja, defpackage.ok, defpackage.od
    la a();

    @Override // defpackage.ja
    Collection d();

    a getKind();

    la w(ai0 ai0Var, zh0 zh0Var, cn.d dVar);
}
