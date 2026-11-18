package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d extends c.h {
    public final /* synthetic */ c.h a;
    public final /* synthetic */ ThreadPoolExecutor b;

    public d(c.h hVar, ThreadPoolExecutor threadPoolExecutor) {
        this.a = hVar;
        this.b = threadPoolExecutor;
    }

    @Override // androidx.emoji2.text.c.h
    public final void a(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.b;
        try {
            this.a.a(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // androidx.emoji2.text.c.h
    public final void b(g gVar) {
        ThreadPoolExecutor threadPoolExecutor = this.b;
        try {
            this.a.b(gVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
