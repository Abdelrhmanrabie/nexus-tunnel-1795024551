package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vm {
    public Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ um c;

    public vm(Object obj, um umVar) {
        this.b = obj;
        this.c = umVar;
        this.a = obj;
    }

    public final void c(Object obj) {
        if (this.c.a) {
            d.AnonymousClass0.m("Cannot modify readonly DescriptorRendererOptions");
        } else {
            this.a = obj;
        }
    }

    public final String toString() {
        return "ObservableProperty(value=" + this.a + ')';
    }
}
