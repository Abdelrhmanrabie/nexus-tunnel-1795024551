package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class mf0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(mf0.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(mf0.class, "_state$volatile");
    public static final ci0 g = new ci0("REMOVE_FROZEN", 1);
    public volatile /* synthetic */ Object _next$volatile;
    public volatile /* synthetic */ long _state$volatile;
    public final int a;
    public final boolean b;
    public final int c;
    public final /* synthetic */ AtomicReferenceArray d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final int a;

        public a(int i) {
            this.a = i;
        }
    }

    public mf0(int i, boolean z) {
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (!(i2 <= 1073741823)) {
            d.AnonymousClass0.m("Check failed.");
            throw null;
        }
        if ((i & i2) == 0) {
            return;
        }
        d.AnonymousClass0.m("Check failed.");
        throw null;
    }

    public final int a(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            boolean z = this.b;
            AtomicReferenceArray atomicReferenceArray = this.d;
            if (!z && atomicReferenceArray.get(i2 & i3) != null) {
                int i4 = this.a;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    return 1;
                }
            } else if (atomicLongFieldUpdater.compareAndSet(this, j, ((-1152921503533105153L) & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                atomicReferenceArray.set(i2 & i3, obj);
                mf0 mf0VarC = this;
                while ((atomicLongFieldUpdater.get(mf0VarC) & 1152921504606846976L) != 0) {
                    mf0VarC = mf0VarC.c();
                    AtomicReferenceArray atomicReferenceArray2 = mf0VarC.d;
                    int i5 = mf0VarC.c & i2;
                    Object obj2 = atomicReferenceArray2.get(i5);
                    if ((obj2 instanceof a) && ((a) obj2).a == i2) {
                        atomicReferenceArray2.set(i5, obj);
                    } else {
                        mf0VarC = null;
                    }
                    if (mf0VarC == null) {
                        return 0;
                    }
                }
                return 0;
            }
        }
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        do {
            atomicLongFieldUpdater = f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, 2305843009213693952L | j));
        return true;
    }

    public final mf0 c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        mf0 mf0Var;
        while (true) {
            atomicLongFieldUpdater = f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                mf0Var = this;
                break;
            }
            long j2 = 1152921504606846976L | j;
            mf0Var = this;
            if (atomicLongFieldUpdater.compareAndSet(mf0Var, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            mf0 mf0Var2 = (mf0) atomicReferenceFieldUpdater.get(this);
            if (mf0Var2 != null) {
                return mf0Var2;
            }
            mf0 mf0Var3 = new mf0(mf0Var.a * 2, mf0Var.b);
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = mf0Var.c;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object aVar = mf0Var.d.get(i4);
                if (aVar == null) {
                    aVar = new a(i);
                }
                mf0Var3.d.set(mf0Var3.c & i, aVar);
                i++;
            }
            atomicLongFieldUpdater.set(mf0Var3, (-1152921504606846977L) & j);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, mf0Var3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object d() {
        mf0 mf0VarC = this;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j = atomicLongFieldUpdater.get(mf0VarC);
            if ((j & 1152921504606846976L) != 0) {
                return g;
            }
            int i = (int) (j & 1073741823);
            int i2 = mf0VarC.c;
            int i3 = ((int) ((1152921503533105152L & j) >> 30)) & i2;
            int i4 = i2 & i;
            if (i3 != i4) {
                AtomicReferenceArray atomicReferenceArray = mf0VarC.d;
                Object obj = atomicReferenceArray.get(i4);
                boolean z = mf0VarC.b;
                if (obj == null) {
                    if (z) {
                    }
                } else if (!(obj instanceof a)) {
                    long j2 = (i + 1) & 1073741823;
                    if (atomicLongFieldUpdater.compareAndSet(mf0VarC, j, (j & (-1073741824)) | j2)) {
                        atomicReferenceArray.set(i4, null);
                        return obj;
                    }
                    mf0VarC = this;
                    if (z) {
                        while (true) {
                            long j3 = atomicLongFieldUpdater.get(mf0VarC);
                            int i5 = (int) (j3 & 1073741823);
                            if ((j3 & 1152921504606846976L) != 0) {
                                mf0VarC = mf0VarC.c();
                            } else if (atomicLongFieldUpdater.compareAndSet(mf0VarC, j3, (j3 & (-1073741824)) | j2)) {
                                mf0VarC.d.set(mf0VarC.c & i5, null);
                                mf0VarC = null;
                            } else {
                                continue;
                            }
                            if (mf0VarC == null) {
                                return obj;
                            }
                        }
                    }
                }
            }
            return null;
        }
    }
}
