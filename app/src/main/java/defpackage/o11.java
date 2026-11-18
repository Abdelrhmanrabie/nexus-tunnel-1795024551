package defpackage;

import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class o11 extends AbstractSet {
    public static final /* synthetic */ int $r8$clinit = 0;
    public Object b;
    public int c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements Iterator, w90 {
        public final Object b;
        public boolean c = true;

        public b(Object obj) {
            this.b = obj;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.c;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!this.c) {
                throw new NoSuchElementException();
            }
            this.c = false;
            return this.b;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if (((java.util.Set) r2).add(r6) == false) goto L33;
     */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean add(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = r5.c
            r1 = 1
            if (r0 != 0) goto L8
            r5.b = r6
            goto L6a
        L8:
            java.lang.Object r2 = r5.b
            r3 = 0
            if (r0 != r1) goto L20
            boolean r0 = defpackage.e4.a(r2, r6)
            if (r0 == 0) goto L14
            goto L69
        L14:
            java.lang.Object r0 = r5.b
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r0
            r2[r1] = r6
            r5.b = r2
            goto L6a
        L20:
            r4 = 5
            if (r0 >= r4) goto L4f
            if (r2 == 0) goto L4c
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            int r0 = defpackage.ae.H0(r2, r6)
            if (r0 < 0) goto L2e
            goto L69
        L2e:
            int r0 = r5.c
            r3 = 4
            if (r0 != r3) goto L40
            int r0 = r2.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r2, r0)
            java.util.LinkedHashSet r0 = defpackage.e.a1(r0)
            r0.add(r6)
            goto L49
        L40:
            int r0 = r0 + r1
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r2, r0)
            int r2 = r0.length
            int r2 = r2 - r1
            r0[r2] = r6
        L49:
            r5.b = r0
            goto L6a
        L4c:
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>"
            goto L72
        L4f:
            if (r2 == 0) goto L70
            boolean r0 = r2 instanceof defpackage.w90
            if (r0 == 0) goto L61
            boolean r0 = r2 instanceof defpackage.ag0
            if (r0 == 0) goto L5a
            goto L61
        L5a:
            java.lang.String r6 = "kotlin.collections.MutableSet"
            defpackage.e4.c(r6, r2)
            r6 = 0
            throw r6
        L61:
            java.util.Set r2 = (java.util.Set) r2
            boolean r6 = r2.add(r6)
            if (r6 != 0) goto L6a
        L69:
            return r3
        L6a:
            int r6 = r5.c
            int r6 = r6 + r1
            r5.c = r6
            return r1
        L70:
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>"
        L72:
            defpackage.d.AnonymousClass0.m$1(r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o11.add(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.b = null;
        this.c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        String str;
        int i = this.c;
        if (i != 0) {
            Object obj2 = this.b;
            if (i == 1) {
                return e4.a(obj2, obj);
            }
            if (i < 5) {
                if (obj2 == null) {
                    str = "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>";
                } else if (ae.H0((Object[]) obj2, obj) >= 0) {
                    return true;
                }
            } else {
                if (obj2 != null) {
                    return ((Set) obj2).contains(obj);
                }
                str = "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>";
            }
            d.AnonymousClass0.m$1(str);
            return false;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        String str;
        Set set;
        int i = this.c;
        if (i != 0) {
            Object obj = this.b;
            if (i == 1) {
                return new b(obj);
            }
            if (i < 5) {
                if (obj != null) {
                    return new be((Object[]) obj);
                }
                str = "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>";
            } else if (obj == null) {
                str = "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>";
            } else {
                if ((obj instanceof w90) && !(obj instanceof ag0)) {
                    e4.c("kotlin.collections.MutableSet", obj);
                    throw null;
                }
                set = (Set) obj;
            }
            d.AnonymousClass0.m$1(str);
            return null;
        }
        set = Collections.EMPTY_SET;
        return set.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.c;
    }
}
