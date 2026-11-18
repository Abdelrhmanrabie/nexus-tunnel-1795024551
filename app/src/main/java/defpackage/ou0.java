package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ou0 {
    public static final pu0 a;

    static {
        pu0 pu0Var;
        try {
            pu0Var = (pu0) qu0.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            pu0Var = null;
        }
        if (pu0Var == null) {
            pu0Var = new pu0();
        }
        a = pu0Var;
    }
}
