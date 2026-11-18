package defpackage;

import renz.javacodez.v2ray.fmtkt.FmtBase;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mu implements nw {
    public final /* synthetic */ int G0;

    public /* synthetic */ mu(int i) {
        this.G0 = i;
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [lw, oc0] */
    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        switch (this.G0) {
            case 0:
                return FmtBase.toUri$lambda$0((jo0) obj);
            case 1:
                return ij0.d((String) obj);
            case 2:
                cv cvVar = (cv) obj;
                if (cvVar != null) {
                    return Boolean.valueOf(!cvVar.equals(m21.a.x));
                }
                d.AnonymousClass0.m$4("Argument for @NotNull parameter 'name' of kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1.invoke must not be null");
                return null;
            case 3:
                return ((ff0.e) obj).b.invoke();
            case 4:
                return (la) obj;
            case 5:
                return (la) obj;
            case 6:
                return ((sy0) obj).iterator();
            default:
                return obj;
        }
    }
}
