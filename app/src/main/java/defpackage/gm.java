package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gm extends oc0 implements bx {
    public static final gm b;
    public static final gm b$1;
    public static final gm b$2;
    public static final gm b$3;
    public static final gm b$4;
    public static final gm b$5;
    public static final gm b$6;
    public static final gm b$7;
    public final /* synthetic */ int G0;

    static {
        int i = 2;
        b = new gm(i, 0);
        b$1 = new gm(i, 1);
        b$2 = new gm(i, i);
        b$3 = new gm(i, 3);
        b$4 = new gm(i, 5);
        b$5 = new gm(i, 6);
        b$6 = new gm(i, 7);
        b$7 = new gm(i, 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gm(int i, int i2) {
        super(i);
        this.G0 = i2;
    }

    @Override // defpackage.bx
    public final Object invoke(Object obj, Object obj2) {
        switch (this.G0) {
            case 0:
                return Boolean.FALSE;
            case 1:
                return Boolean.FALSE;
            case 2:
                return Boolean.valueOf(((kr) obj).c.c().equals(((j4) obj2).b));
            case 3:
                return ((li) obj).y((li.b) obj2);
            case 4:
                return ((li) obj).y((li.b) obj2);
            case 5:
                return obj;
            case 6:
                if (obj == null) {
                    return null;
                }
                d.AnonymousClass0.m$1();
                return null;
            case 7:
                return (s61) obj;
            default:
                Boolean bool = (Boolean) obj;
                bool.getClass();
                return bool;
        }
    }
}
