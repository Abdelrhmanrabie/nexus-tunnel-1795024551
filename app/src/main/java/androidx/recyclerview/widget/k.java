package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class k extends z {
    public static TimeInterpolator s;
    public final ArrayList h = new ArrayList();
    public final ArrayList i = new ArrayList();
    public final ArrayList j = new ArrayList();
    public final ArrayList k = new ArrayList();
    public final ArrayList l = new ArrayList();
    public final ArrayList m = new ArrayList();
    public final ArrayList n = new ArrayList();
    public final ArrayList o = new ArrayList();
    public final ArrayList p = new ArrayList();
    public final ArrayList q = new ArrayList();
    public final ArrayList r = new ArrayList();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a {
        public RecyclerView.d0 a;
        public RecyclerView.d0 b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public a(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i, int i2, int i3, int i4) {
            this.a = d0Var;
            this.b = d0Var2;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public final String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b {
        public final RecyclerView.d0 a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public b(RecyclerView.d0 d0Var, int i, int i2, int i3, int i4) {
            this.a = d0Var;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    public static void h(ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((RecyclerView.d0) arrayList.get(size)).itemView.animate().cancel();
            }
        }
    }

    public final void d(RecyclerView.d0 d0Var) {
        View view = d0Var.itemView;
        view.animate().cancel();
        ArrayList arrayList = this.j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((b) arrayList.get(size)).a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(d0Var);
                arrayList.remove(size);
            }
        }
        j(d0Var, this.k);
        if (this.h.remove(d0Var)) {
            view.setAlpha(1.0f);
            c(d0Var);
        }
        if (this.i.remove(d0Var)) {
            view.setAlpha(1.0f);
            c(d0Var);
        }
        ArrayList arrayList2 = this.n;
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            j(d0Var, arrayList3);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.m;
        int size3 = arrayList4.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                }
                if (((b) arrayList5.get(size4)).a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(d0Var);
                    arrayList5.remove(size4);
                    if (!arrayList5.isEmpty()) {
                        break;
                    }
                    arrayList4.remove(size3);
                    break;
                }
            }
        }
        ArrayList arrayList6 = this.l;
        int size5 = arrayList6.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                this.q.remove(d0Var);
                this.o.remove(d0Var);
                this.r.remove(d0Var);
                this.p.remove(d0Var);
                i();
                return;
            }
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(d0Var)) {
                view.setAlpha(1.0f);
                c(d0Var);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
    }

    public final void e() {
        ArrayList arrayList = this.j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = (b) arrayList.get(size);
            View view = bVar.a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(bVar.a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.h;
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            c((RecyclerView.d0) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = (RecyclerView.d0) arrayList3.get(size3);
            d0Var.itemView.setAlpha(1.0f);
            c(d0Var);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.k;
        int size4 = arrayList4.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            a aVar = (a) arrayList4.get(size4);
            RecyclerView.d0 d0Var2 = aVar.a;
            if (d0Var2 != null) {
                k(aVar, d0Var2);
            }
            RecyclerView.d0 d0Var3 = aVar.b;
            if (d0Var3 != null) {
                k(aVar, d0Var3);
            }
        }
        arrayList4.clear();
        if (f()) {
            ArrayList arrayList5 = this.m;
            int size5 = arrayList5.size();
            while (true) {
                size5--;
                if (size5 < 0) {
                    break;
                }
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                int size6 = arrayList6.size();
                while (true) {
                    size6--;
                    if (size6 >= 0) {
                        b bVar2 = (b) arrayList6.get(size6);
                        View view2 = bVar2.a.itemView;
                        view2.setTranslationY(0.0f);
                        view2.setTranslationX(0.0f);
                        c(bVar2.a);
                        arrayList6.remove(size6);
                        if (arrayList6.isEmpty()) {
                            arrayList5.remove(arrayList6);
                        }
                    }
                }
            }
            ArrayList arrayList7 = this.l;
            int size7 = arrayList7.size();
            while (true) {
                size7--;
                if (size7 < 0) {
                    break;
                }
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                int size8 = arrayList8.size();
                while (true) {
                    size8--;
                    if (size8 >= 0) {
                        RecyclerView.d0 d0Var4 = (RecyclerView.d0) arrayList8.get(size8);
                        d0Var4.itemView.setAlpha(1.0f);
                        c(d0Var4);
                        arrayList8.remove(size8);
                        if (arrayList8.isEmpty()) {
                            arrayList7.remove(arrayList8);
                        }
                    }
                }
            }
            ArrayList arrayList9 = this.n;
            int size9 = arrayList9.size();
            while (true) {
                size9--;
                if (size9 < 0) {
                    break;
                }
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                int size10 = arrayList10.size();
                while (true) {
                    size10--;
                    if (size10 >= 0) {
                        a aVar2 = (a) arrayList10.get(size10);
                        RecyclerView.d0 d0Var5 = aVar2.a;
                        if (d0Var5 != null) {
                            k(aVar2, d0Var5);
                        }
                        RecyclerView.d0 d0Var6 = aVar2.b;
                        if (d0Var6 != null) {
                            k(aVar2, d0Var6);
                        }
                        if (arrayList10.isEmpty()) {
                            arrayList9.remove(arrayList10);
                        }
                    }
                }
            }
            h(this.q);
            h(this.p);
            h(this.o);
            h(this.r);
            ArrayList arrayList11 = this.b;
            int size11 = arrayList11.size();
            for (int i = 0; i < size11; i++) {
                ((RecyclerView.l.a) arrayList11.get(i)).a();
            }
            arrayList11.clear();
        }
    }

    public final boolean f() {
        return (this.i.isEmpty() && this.k.isEmpty() && this.j.isEmpty() && this.h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.z
    public final boolean g(RecyclerView.d0 d0Var, int i, int i2, int i3, int i4) {
        View view = d0Var.itemView;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) view.getTranslationY());
        l(d0Var);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            c(d0Var);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.j.add(new b(d0Var, translationX, translationY, i3, i4));
        return true;
    }

    public final void i() {
        if (f()) {
            return;
        }
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((RecyclerView.l.a) arrayList.get(i)).a();
        }
        arrayList.clear();
    }

    public final void j(RecyclerView.d0 d0Var, ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            a aVar = (a) arrayList.get(size);
            if (k(aVar, d0Var) && aVar.a == null && aVar.b == null) {
                arrayList.remove(aVar);
            }
        }
    }

    public final boolean k(a aVar, RecyclerView.d0 d0Var) {
        if (aVar.b == d0Var) {
            aVar.b = null;
        } else {
            if (aVar.a != d0Var) {
                return false;
            }
            aVar.a = null;
        }
        View view = d0Var.itemView;
        view.setAlpha(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        c(d0Var);
        return true;
    }

    public final void l(RecyclerView.d0 d0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        d0Var.itemView.animate().setInterpolator(s);
        d(d0Var);
    }
}
