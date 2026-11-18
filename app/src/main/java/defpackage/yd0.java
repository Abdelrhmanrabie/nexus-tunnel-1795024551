package defpackage;

import java.io.UnsupportedEncodingException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class yd0 extends AbstractList implements RandomAccess, zd0 {
    public static final vb1 c = new vb1(new yd0());
    public final ArrayList b;

    public yd0() {
        this.b = new ArrayList();
    }

    public yd0(zd0 zd0Var) {
        this.b = new ArrayList(zd0Var.size());
        addAll(zd0Var);
    }

    @Override // defpackage.zd0
    public final void a(we0 we0Var) {
        this.b.add(we0Var);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        this.b.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection instanceof zd0) {
            collection = ((zd0) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.b.size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        String str;
        ArrayList arrayList = this.b;
        Object obj = arrayList.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof fa)) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = h30.a;
            try {
                str = new String(bArr, "UTF-8");
                if (e.E(bArr, 0, bArr.length) == 0) {
                }
                return str;
            } catch (UnsupportedEncodingException e) {
                d.AnonymousClass0.m$1("UTF-8 not supported?", (Throwable) e);
                return null;
            }
        }
        fa faVar = (fa) obj;
        try {
            str = faVar.p();
            if (!faVar.j()) {
                return str;
            }
        } catch (UnsupportedEncodingException e2) {
            d.AnonymousClass0.m$1("UTF-8 not supported?", (Throwable) e2);
            return null;
        }
        arrayList.set(i, str);
        return str;
    }

    @Override // defpackage.zd0
    public final fa getByteString(int i) {
        fa we0Var;
        ArrayList arrayList = this.b;
        Object obj = arrayList.get(i);
        if (obj instanceof fa) {
            we0Var = (fa) obj;
        } else if (obj instanceof String) {
            try {
                we0Var = new we0(((String) obj).getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                d.AnonymousClass0.m$1("UTF-8 not supported?", (Throwable) e);
                return null;
            }
        } else {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            we0Var = new we0(bArr2);
        }
        if (we0Var != obj) {
            arrayList.set(i, we0Var);
        }
        return we0Var;
    }

    @Override // defpackage.zd0
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // defpackage.zd0
    public final vb1 getUnmodifiableView() {
        return new vb1(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        Object objRemove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (objRemove instanceof fa) {
            try {
                return ((fa) objRemove).p();
            } catch (UnsupportedEncodingException e) {
                d.AnonymousClass0.m$1("UTF-8 not supported?", (Throwable) e);
                return null;
            }
        }
        byte[] bArr = (byte[]) objRemove;
        byte[] bArr2 = h30.a;
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            d.AnonymousClass0.m$1("UTF-8 not supported?", (Throwable) e2);
            return null;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        Object obj2 = this.b.set(i, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (obj2 instanceof fa) {
            try {
                return ((fa) obj2).p();
            } catch (UnsupportedEncodingException e) {
                d.AnonymousClass0.m$1("UTF-8 not supported?", (Throwable) e);
                return null;
            }
        }
        byte[] bArr = (byte[]) obj2;
        byte[] bArr2 = h30.a;
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            d.AnonymousClass0.m$1("UTF-8 not supported?", (Throwable) e2);
            return null;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b.size();
    }
}
