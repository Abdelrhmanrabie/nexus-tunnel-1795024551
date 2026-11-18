package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputContentInfo;
import android.widget.EditText;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class qz implements q20$c, kk0.a, t11 {
    public final /* synthetic */ int G0;
    public Object a;

    public qz(int i) {
        this.G0 = i;
        if (i != 6) {
            this.a = new TreeSet();
        } else {
            this.a = Build.VERSION.SDK_INT >= 26 ? new r1$b(this) : new r1$a(this);
        }
    }

    public /* synthetic */ qz(int i, Object obj) {
        this.G0 = i;
        this.a = obj;
    }

    public /* synthetic */ qz(int i, boolean z) {
        this.G0 = i;
    }

    public qz(Uri uri, ClipDescription clipDescription, Uri uri2, int i) {
        this.G0 = i;
        if (i != 5) {
            this.a = new InputContentInfo(uri, clipDescription, uri2);
        } else {
            this.a = Build.VERSION.SDK_INT >= 25 ? new qz(uri, clipDescription, uri2, 4) : new m6(uri, clipDescription, uri2);
        }
    }

    public qz(ByteBuffer byteBuffer) {
        this.G0 = 7;
        this.a = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public static qz a(int i, int i2, int i3) {
        return new qz(1, AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, false, i3));
    }

    public static qz a(boolean z, int i, int i2, int i3, int i4) {
        return new qz(2, AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, false, z));
    }

    @Override // defpackage.q20$c, defpackage.w1$a
    public Object a() {
        return (InputContentInfo) this.a;
    }

    public o1 a(int i) {
        return null;
    }

    public void a(ha haVar, boolean z) {
        ((TreeSet) this.a).add(new ok0$a(haVar, z));
    }

    @Override // kk0.a
    public void a(String str) {
        ((EditText) this.a).setText(str);
    }

    @Override // defpackage.q20$c
    public Uri b() {
        return ((InputContentInfo) this.a).getContentUri();
    }

    public Vector b(boolean z) {
        Vector vector = new Vector();
        for (ok0$a ok0_a : (TreeSet) this.a) {
            if (ok0_a.d == z) {
                vector.add(ok0_a);
            }
        }
        return vector;
    }

    public o1 b(int i) {
        return null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m19b(int i) {
        ByteBuffer byteBuffer = (ByteBuffer) this.a;
        byteBuffer.position(byteBuffer.position() + i);
    }

    public Vector c() {
        PriorityQueue priorityQueue = new PriorityQueue((SortedSet) this.a);
        TreeSet<ok0$a> treeSet = new TreeSet();
        ok0$a ok0_a = (ok0$a) priorityQueue.poll();
        if (ok0_a != null) {
            while (ok0_a != null) {
                ok0$a ok0_a2 = (ok0$a) priorityQueue.poll();
                if (ok0_a2 == null || ok0_a.d().compareTo(ok0_a2.b()) == -1) {
                    treeSet.add(ok0_a);
                    ok0_a = ok0_a2;
                } else {
                    boolean zEquals = ok0_a.b().equals(ok0_a2.b());
                    boolean z = ok0_a.d;
                    int i = ok0_a2.c;
                    boolean z2 = ok0_a2.d;
                    if (!zEquals || ok0_a.c < i) {
                        if (z != z2) {
                            ok0$a[] ok0_aArrG = ok0_a.g();
                            ok0$a ok0_a3 = ok0_aArrG[1];
                            if (ok0_a3.c != i) {
                                priorityQueue.add(ok0_a3);
                            }
                            priorityQueue.add(ok0_a2);
                            ok0_a = ok0_aArrG[0];
                        }
                    } else if (z == z2) {
                        ok0_a = ok0_a2;
                    } else {
                        ok0$a[] ok0_aArrG2 = ok0_a2.g();
                        if (!priorityQueue.contains(ok0_aArrG2[1])) {
                            priorityQueue.add(ok0_aArrG2[1]);
                        }
                        if (!ok0_aArrG2[0].d().equals(ok0_a.d()) && !priorityQueue.contains(ok0_aArrG2[0])) {
                            priorityQueue.add(ok0_aArrG2[0]);
                        }
                    }
                }
            }
        }
        Vector vector = new Vector();
        for (ok0$a ok0_a4 : treeSet) {
            if (ok0_a4.d) {
                vector.add(ok0_a4);
            }
        }
        return vector;
    }

    @Override // defpackage.q20$c
    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void mo20c() {
        ((InputContentInfo) this.a).requestPermission();
    }

    public boolean c(int i, int i2, Bundle bundle) {
        return false;
    }

    @Override // defpackage.q20$c
    /* JADX INFO: renamed from: d */
    public Uri mo15d() {
        return ((InputContentInfo) this.a).getLinkUri();
    }

    public void f() {
        ((zx$a) this.a).onCancel();
    }

    @Override // defpackage.q20$c
    public ClipDescription getDescription() {
        return ((InputContentInfo) this.a).getDescription();
    }

    public String toString() {
        if (this.G0 != 11) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        fd0 fd0Var = (fd0) this.a;
        sb.append(fd0Var);
        sb.append(": ");
        ja0 ja0Var = fd0.s[0];
        sb.append(((Map) fd0Var.o.invoke()).keySet());
        return sb.toString();
    }
}
