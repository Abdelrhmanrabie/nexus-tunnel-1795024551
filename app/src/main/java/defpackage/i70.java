package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class i70 extends i8 implements bx, kx {
    public final int b;
    public fl0 c;
    public oc d;
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ h70 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i70(ai aiVar, h70 h70Var) {
        super(aiVar);
        this.i = h70Var;
        if (aiVar == null || aiVar.getContext() == rq.b) {
            this.b = 2;
        } else {
            d.AnonymousClass0.m$2("Coroutines with restricted suspension must have EmptyCoroutineContext");
            throw null;
        }
    }

    @Override // defpackage.i8
    public final ai create(Object obj, ai aiVar) {
        i70 i70Var = new i70(aiVar, this.i);
        i70Var.g = obj;
        return i70Var;
    }

    @Override // defpackage.kx
    public final int getArity() {
        return this.b;
    }

    @Override // defpackage.ai
    public final li getContext() {
        return rq.b;
    }

    @Override // defpackage.bx
    public final Object invoke(Object obj, Object obj2) {
        return ((i70) create((ty0) obj, (ai) obj2)).invokeSuspend(tb1.a);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0062  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0060 -> B:25:0x0077). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.i8
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            vi r0 = defpackage.vi.b
            int r1 = r6.f
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L24
            if (r1 == r4) goto L20
            if (r1 != r3) goto L19
            oc r1 = r6.d
            fl0 r4 = r6.c
            java.lang.Object r5 = r6.g
            ty0 r5 = (defpackage.ty0) r5
            defpackage.e4.b(r7)
            goto L77
        L19:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.d.AnonymousClass0.m(r7)
            r7 = 0
            return r7
        L20:
            defpackage.e4.b(r7)
            goto L7c
        L24:
            defpackage.e4.b(r7)
            java.lang.Object r7 = r6.g
            ty0 r7 = (defpackage.ty0) r7
            h70 r1 = r6.i
            java.lang.Object r1 = r1.N()
            boolean r5 = r1 instanceof defpackage.oc
            if (r5 == 0) goto L42
            oc r1 = (defpackage.oc) r1
            h70 r1 = r1.g
            r6.f = r4
            r7.c = r1
            r7.b = r2
            r7.d = r6
            return r0
        L42:
            boolean r4 = r1 instanceof defpackage.x10
            if (r4 == 0) goto L7c
            x10 r1 = (defpackage.x10) r1
            fl0 r1 = r1.c()
            if (r1 == 0) goto L7c
            java.lang.Object r4 = r1.g()
            kf0 r4 = (defpackage.kf0) r4
            r5 = r4
            r4 = r1
            r1 = r5
            r5 = r7
        L58:
            boolean r7 = defpackage.e4.a(r1, r4)
            if (r7 != 0) goto L7c
            boolean r7 = r1 instanceof defpackage.oc
            if (r7 == 0) goto L77
            oc r1 = (defpackage.oc) r1
            r6.g = r5
            r6.c = r4
            r6.d = r1
            r6.f = r3
            h70 r7 = r1.g
            r5.c = r7
            r5.b = r2
            r5.d = r6
            vi r7 = defpackage.vi.b
            return r0
        L77:
            kf0 r1 = r1.h()
            goto L58
        L7c:
            tb1 r7 = defpackage.tb1.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i70.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // defpackage.i8
    public final String toString() {
        return getCompletion() == null ? ou0.a.g(this) : super.toString();
    }
}
