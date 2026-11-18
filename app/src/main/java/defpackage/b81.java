package defpackage;

import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class b81 extends yx0 {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Runnable {
        public final /* synthetic */ int G0;
        public final Object b;
        public final Object c;
        public final long d;

        public /* synthetic */ a(Object obj, Object obj2, long j, int i) {
            this.G0 = i;
            this.b = obj;
            this.c = obj2;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.G0 != 0) {
                StringRequest stringRequest = (StringRequest) this.b;
                VolleyLog.MarkerLog markerLog = stringRequest.mEventLog;
                markerLog.add((String) this.c, this.d);
                markerLog.finish(stringRequest.toString());
                return;
            }
            if (((c) this.c).f) {
                return;
            }
            long jB = yx0.b.b(TimeUnit.MILLISECONDS);
            long j = this.d;
            if (j > jB) {
                try {
                    Thread.sleep(j - jB);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    ui.a(e);
                    return;
                }
            }
            if (((c) this.c).f) {
                return;
            }
            ((yx0.b.a) this.b).run();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements Comparable {
        public final a b;
        public final long c;
        public final int d;
        public volatile boolean f;

        public b(a aVar, Long l, int i) {
            this.b = aVar;
            this.c = l.longValue();
            this.d = i;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            b bVar = (b) obj;
            int iCompare = Long.compare(this.c, bVar.c);
            return iCompare == 0 ? Integer.compare(this.d, bVar.d) : iCompare;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends yx0.b {
        public final PriorityBlockingQueue b = new PriorityBlockingQueue();
        public final AtomicInteger c = new AtomicInteger();
        public final AtomicInteger d = new AtomicInteger();
        public volatile boolean f;

        @Override // defpackage.wo
        public final void a() {
            this.f = true;
        }

        @Override // yx0.b
        public final wo c(yx0.b.a aVar, long j, TimeUnit timeUnit) {
            long millis = timeUnit.toMillis(j) + yx0.b.b(TimeUnit.MILLISECONDS);
            a aVar2 = new a(aVar, this, millis, 0);
            boolean z = this.f;
            sq sqVar = sq.b;
            if (!z) {
                b bVar = new b(aVar2, Long.valueOf(millis), this.d.incrementAndGet());
                this.b.add(bVar);
                int iAddAndGet = 1;
                if (this.c.getAndIncrement() != 0) {
                    return new gz0(new f2(1, this, bVar));
                }
                while (true) {
                    boolean z2 = this.f;
                    PriorityBlockingQueue priorityBlockingQueue = this.b;
                    if (z2) {
                        priorityBlockingQueue.clear();
                        return sqVar;
                    }
                    b bVar2 = (b) priorityBlockingQueue.poll();
                    if (bVar2 == null) {
                        iAddAndGet = this.c.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                        }
                    } else if (!bVar2.f) {
                        bVar2.b.run();
                    }
                }
            }
            return sqVar;
        }
    }
}
