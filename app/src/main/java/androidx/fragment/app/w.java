package androidx.fragment.app;

import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class w {
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public String i;
    public int j;
    public CharSequence k;
    public int l;
    public CharSequence m;
    public ArrayList n;
    public ArrayList o;
    public final ArrayList a = new ArrayList();
    public boolean h = true;
    public boolean p = false;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class a {
        public int a;
        public Fragment b;
        public boolean c;
        public int d;
        public int e;
        public int f;
        public int g;
        public androidx.lifecycle.e.b h;
        public androidx.lifecycle.e.b i;

        public a() {
        }

        public a(int i, Fragment fragment) {
            this.a = i;
            this.b = fragment;
            this.c = true;
            androidx.lifecycle.e.b bVar = androidx.lifecycle.e.b.RESUMED;
            this.h = bVar;
            this.i = bVar;
        }

        public a(Fragment fragment, int i) {
            this.a = i;
            this.b = fragment;
            this.c = false;
            androidx.lifecycle.e.b bVar = androidx.lifecycle.e.b.RESUMED;
            this.h = bVar;
            this.i = bVar;
        }
    }

    public final void b(a aVar) {
        this.a.add(aVar);
        aVar.d = this.b;
        aVar.e = this.c;
        aVar.f = this.d;
        aVar.g = this.e;
    }
}
