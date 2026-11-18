package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.ak;
import defpackage.e4;
import defpackage.fb$1;
import defpackage.h8;
import defpackage.wg;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import net.lingala.zip4j.util.InternalZipConstants;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final int[] f = {0, 4, 8};
    public static final SparseIntArray g;
    public static final SparseIntArray h;
    public final HashMap c = new HashMap();
    public final boolean d = true;
    public final HashMap e = new HashMap();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a {
        public int a;
        public final d c = new d();
        public final c d = new c();
        public final C0008b e = new C0008b();
        public final e f = new e();
        public HashMap g = new HashMap();

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static class C0007a {
            public int[] a = new int[10];
            public int[] b = new int[10];
            public int c = 0;
            public int[] d = new int[10];
            public float[] e = new float[10];
            public int f = 0;
            public int[] g = new int[5];
            public String[] h = new String[5];
            public int i = 0;
            public int[] j = new int[4];
            public boolean[] k = new boolean[4];
            public int l = 0;

            public final void a(int i, float f) {
                int i2 = this.f;
                int[] iArr = this.d;
                if (i2 >= iArr.length) {
                    this.d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.e;
                    this.e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.d;
                int i3 = this.f;
                iArr2[i3] = i;
                float[] fArr2 = this.e;
                this.f = i3 + 1;
                fArr2[i3] = f;
            }

            public final void b(int i, int i2) {
                int i3 = this.c;
                int[] iArr = this.a;
                if (i3 >= iArr.length) {
                    this.a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.b;
                    this.b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.a;
                int i4 = this.c;
                iArr3[i4] = i;
                int[] iArr4 = this.b;
                this.c = i4 + 1;
                iArr4[i4] = i2;
            }

            public final void c(int i, String str) {
                int i2 = this.i;
                int[] iArr = this.g;
                if (i2 >= iArr.length) {
                    this.g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.h;
                    this.h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.g;
                int i3 = this.i;
                iArr2[i3] = i;
                String[] strArr2 = this.h;
                this.i = i3 + 1;
                strArr2[i3] = str;
            }

            public final void d(int i, boolean z) {
                int i2 = this.l;
                int[] iArr = this.j;
                if (i2 >= iArr.length) {
                    this.j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.k;
                    this.k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.j;
                int i3 = this.l;
                iArr2[i3] = i;
                boolean[] zArr2 = this.k;
                this.l = i3 + 1;
                zArr2[i3] = z;
            }
        }

        public final void a(ConstraintLayout.a aVar) {
            C0008b c0008b = this.e;
            aVar.e = c0008b.i;
            aVar.f = c0008b.j;
            aVar.g = c0008b.k;
            aVar.h = c0008b.l;
            aVar.i = c0008b.m;
            aVar.j = c0008b.n;
            aVar.k = c0008b.o;
            aVar.l = c0008b.p;
            aVar.m = c0008b.q;
            aVar.n = c0008b.r;
            aVar.o = c0008b.s;
            aVar.s = c0008b.t;
            aVar.t = c0008b.u;
            aVar.u = c0008b.v;
            aVar.v = c0008b.w;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = c0008b.G;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = c0008b.H;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = c0008b.I;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = c0008b.J;
            aVar.A = c0008b.S;
            aVar.B = c0008b.R;
            aVar.x = c0008b.O;
            aVar.z = c0008b.Q;
            aVar.E = c0008b.x;
            aVar.F = c0008b.y;
            aVar.p = c0008b.A;
            aVar.q = c0008b.B;
            aVar.r = c0008b.C;
            aVar.G = c0008b.z;
            aVar.T = c0008b.D;
            aVar.U = c0008b.E;
            aVar.I = c0008b.U;
            aVar.H = c0008b.V;
            aVar.K = c0008b.X;
            aVar.J = c0008b.W;
            aVar.W = c0008b.m0;
            aVar.X = c0008b.n0;
            aVar.L = c0008b.Y;
            aVar.M = c0008b.Z;
            aVar.P = c0008b.a0;
            aVar.Q = c0008b.b0;
            aVar.N = c0008b.c0;
            aVar.O = c0008b.d0;
            aVar.R = c0008b.e0;
            aVar.S = c0008b.f0;
            aVar.V = c0008b.F;
            aVar.c = c0008b.g;
            aVar.a = c0008b.e;
            aVar.b = c0008b.f;
            ((ViewGroup.MarginLayoutParams) aVar).width = c0008b.c;
            ((ViewGroup.MarginLayoutParams) aVar).height = c0008b.d;
            String str = c0008b.l0;
            if (str != null) {
                aVar.Y = str;
            }
            aVar.Z = c0008b.p0;
            aVar.setMarginStart(c0008b.L);
            aVar.setMarginEnd(c0008b.K);
            aVar.a();
        }

        public final void c(int i, ConstraintLayout.a aVar) {
            this.a = i;
            int i2 = aVar.e;
            C0008b c0008b = this.e;
            c0008b.i = i2;
            c0008b.j = aVar.f;
            c0008b.k = aVar.g;
            c0008b.l = aVar.h;
            c0008b.m = aVar.i;
            c0008b.n = aVar.j;
            c0008b.o = aVar.k;
            c0008b.p = aVar.l;
            c0008b.q = aVar.m;
            c0008b.r = aVar.n;
            c0008b.s = aVar.o;
            c0008b.t = aVar.s;
            c0008b.u = aVar.t;
            c0008b.v = aVar.u;
            c0008b.w = aVar.v;
            c0008b.x = aVar.E;
            c0008b.y = aVar.F;
            c0008b.z = aVar.G;
            c0008b.A = aVar.p;
            c0008b.B = aVar.q;
            c0008b.C = aVar.r;
            c0008b.D = aVar.T;
            c0008b.E = aVar.U;
            c0008b.F = aVar.V;
            c0008b.g = aVar.c;
            c0008b.e = aVar.a;
            c0008b.f = aVar.b;
            c0008b.c = ((ViewGroup.MarginLayoutParams) aVar).width;
            c0008b.d = ((ViewGroup.MarginLayoutParams) aVar).height;
            c0008b.G = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            c0008b.H = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            c0008b.I = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            c0008b.J = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            c0008b.M = aVar.D;
            c0008b.U = aVar.I;
            c0008b.V = aVar.H;
            c0008b.X = aVar.K;
            c0008b.W = aVar.J;
            c0008b.m0 = aVar.W;
            c0008b.n0 = aVar.X;
            c0008b.Y = aVar.L;
            c0008b.Z = aVar.M;
            c0008b.a0 = aVar.P;
            c0008b.b0 = aVar.Q;
            c0008b.c0 = aVar.N;
            c0008b.d0 = aVar.O;
            c0008b.e0 = aVar.R;
            c0008b.f0 = aVar.S;
            c0008b.l0 = aVar.Y;
            c0008b.O = aVar.x;
            c0008b.Q = aVar.z;
            c0008b.N = aVar.w;
            c0008b.P = aVar.y;
            c0008b.S = aVar.A;
            c0008b.R = aVar.B;
            c0008b.T = aVar.C;
            c0008b.p0 = aVar.Z;
            c0008b.K = aVar.getMarginEnd();
            c0008b.L = aVar.getMarginStart();
        }

        public final Object clone() {
            a aVar = new a();
            C0008b c0008b = aVar.e;
            c0008b.getClass();
            C0008b c0008b2 = this.e;
            c0008b.a = c0008b2.a;
            c0008b.c = c0008b2.c;
            c0008b.d = c0008b2.d;
            c0008b.e = c0008b2.e;
            c0008b.f = c0008b2.f;
            c0008b.g = c0008b2.g;
            c0008b.h = c0008b2.h;
            c0008b.i = c0008b2.i;
            c0008b.j = c0008b2.j;
            c0008b.k = c0008b2.k;
            c0008b.l = c0008b2.l;
            c0008b.m = c0008b2.m;
            c0008b.n = c0008b2.n;
            c0008b.o = c0008b2.o;
            c0008b.p = c0008b2.p;
            c0008b.q = c0008b2.q;
            c0008b.r = c0008b2.r;
            c0008b.s = c0008b2.s;
            c0008b.t = c0008b2.t;
            c0008b.u = c0008b2.u;
            c0008b.v = c0008b2.v;
            c0008b.w = c0008b2.w;
            c0008b.x = c0008b2.x;
            c0008b.y = c0008b2.y;
            c0008b.z = c0008b2.z;
            c0008b.A = c0008b2.A;
            c0008b.B = c0008b2.B;
            c0008b.C = c0008b2.C;
            c0008b.D = c0008b2.D;
            c0008b.E = c0008b2.E;
            c0008b.F = c0008b2.F;
            c0008b.G = c0008b2.G;
            c0008b.H = c0008b2.H;
            c0008b.I = c0008b2.I;
            c0008b.J = c0008b2.J;
            c0008b.K = c0008b2.K;
            c0008b.L = c0008b2.L;
            c0008b.M = c0008b2.M;
            c0008b.N = c0008b2.N;
            c0008b.O = c0008b2.O;
            c0008b.P = c0008b2.P;
            c0008b.Q = c0008b2.Q;
            c0008b.R = c0008b2.R;
            c0008b.S = c0008b2.S;
            c0008b.T = c0008b2.T;
            c0008b.U = c0008b2.U;
            c0008b.V = c0008b2.V;
            c0008b.W = c0008b2.W;
            c0008b.X = c0008b2.X;
            c0008b.Y = c0008b2.Y;
            c0008b.Z = c0008b2.Z;
            c0008b.a0 = c0008b2.a0;
            c0008b.b0 = c0008b2.b0;
            c0008b.c0 = c0008b2.c0;
            c0008b.d0 = c0008b2.d0;
            c0008b.e0 = c0008b2.e0;
            c0008b.f0 = c0008b2.f0;
            c0008b.g0 = c0008b2.g0;
            c0008b.h0 = c0008b2.h0;
            c0008b.i0 = c0008b2.i0;
            c0008b.l0 = c0008b2.l0;
            int[] iArr = c0008b2.j0;
            if (iArr == null || c0008b2.k0 != null) {
                c0008b.j0 = null;
            } else {
                c0008b.j0 = Arrays.copyOf(iArr, iArr.length);
            }
            c0008b.k0 = c0008b2.k0;
            c0008b.m0 = c0008b2.m0;
            c0008b.n0 = c0008b2.n0;
            c0008b.o0 = c0008b2.o0;
            c0008b.p0 = c0008b2.p0;
            c cVar = aVar.d;
            cVar.getClass();
            c cVar2 = this.d;
            cVar2.getClass();
            cVar.b = cVar2.b;
            cVar.d = cVar2.d;
            cVar.f = cVar2.f;
            cVar.e = cVar2.e;
            d dVar = aVar.c;
            dVar.getClass();
            d dVar2 = this.c;
            dVar2.getClass();
            dVar.b = dVar2.b;
            dVar.d = dVar2.d;
            dVar.e = dVar2.e;
            dVar.c = dVar2.c;
            e eVar = aVar.f;
            eVar.getClass();
            e eVar2 = this.f;
            eVar2.getClass();
            eVar.b = eVar2.b;
            eVar.c = eVar2.c;
            eVar.d = eVar2.d;
            eVar.e = eVar2.e;
            eVar.f = eVar2.f;
            eVar.g = eVar2.g;
            eVar.h = eVar2.h;
            eVar.i = eVar2.i;
            eVar.j = eVar2.j;
            eVar.k = eVar2.k;
            eVar.l = eVar2.l;
            eVar.m = eVar2.m;
            eVar.n = eVar2.n;
            aVar.a = this.a;
            return aVar;
        }

        public final void d(int i, androidx.constraintlayout.widget.c.a aVar) {
            c(i, aVar);
            this.c.d = aVar.r0;
            float f = aVar.u0;
            e eVar = this.f;
            eVar.b = f;
            eVar.c = aVar.v0;
            eVar.d = aVar.w0;
            eVar.e = aVar.x0;
            eVar.f = aVar.y0;
            eVar.g = aVar.z0;
            eVar.h = aVar.A0;
            eVar.j = aVar.B0;
            eVar.k = aVar.C0;
            eVar.l = aVar.D0;
            eVar.n = aVar.t0;
            eVar.m = aVar.s0;
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class C0008b {
        public static final SparseIntArray q0;
        public int c;
        public int d;
        public int[] j0;
        public String k0;
        public String l0;
        public boolean a = false;
        public int e = -1;
        public int f = -1;
        public float g = -1.0f;
        public boolean h = true;
        public int i = -1;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public float x = 0.5f;
        public float y = 0.5f;
        public String z = null;
        public int A = -1;
        public int B = 0;
        public float C = 0.0f;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        public int O = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        public int P = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        public int Q = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        public int R = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        public int S = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        public int T = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        public float U = -1.0f;
        public float V = -1.0f;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;
        public int a0 = 0;
        public int b0 = 0;
        public int c0 = 0;
        public int d0 = 0;
        public float e0 = 1.0f;
        public float f0 = 1.0f;
        public int g0 = -1;
        public int h0 = 0;
        public int i0 = -1;
        public boolean m0 = false;
        public boolean n0 = false;
        public boolean o0 = true;
        public int p0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            q0 = sparseIntArray;
            sparseIntArray.append(43, 24);
            sparseIntArray.append(44, 25);
            sparseIntArray.append(46, 28);
            sparseIntArray.append(47, 29);
            sparseIntArray.append(52, 35);
            sparseIntArray.append(51, 34);
            sparseIntArray.append(24, 4);
            sparseIntArray.append(23, 3);
            sparseIntArray.append(19, 1);
            sparseIntArray.append(61, 6);
            sparseIntArray.append(62, 7);
            sparseIntArray.append(31, 17);
            sparseIntArray.append(32, 18);
            sparseIntArray.append(33, 19);
            sparseIntArray.append(15, 90);
            sparseIntArray.append(0, 26);
            sparseIntArray.append(48, 31);
            sparseIntArray.append(49, 32);
            sparseIntArray.append(30, 10);
            sparseIntArray.append(29, 9);
            sparseIntArray.append(66, 13);
            sparseIntArray.append(69, 16);
            sparseIntArray.append(67, 14);
            sparseIntArray.append(64, 11);
            sparseIntArray.append(68, 15);
            sparseIntArray.append(65, 12);
            sparseIntArray.append(55, 38);
            sparseIntArray.append(41, 37);
            sparseIntArray.append(40, 39);
            sparseIntArray.append(54, 40);
            sparseIntArray.append(39, 20);
            sparseIntArray.append(53, 36);
            sparseIntArray.append(28, 5);
            sparseIntArray.append(42, 91);
            sparseIntArray.append(50, 91);
            sparseIntArray.append(45, 91);
            sparseIntArray.append(22, 91);
            sparseIntArray.append(18, 91);
            sparseIntArray.append(3, 23);
            sparseIntArray.append(5, 27);
            sparseIntArray.append(7, 30);
            sparseIntArray.append(8, 8);
            sparseIntArray.append(4, 33);
            sparseIntArray.append(6, 2);
            sparseIntArray.append(1, 22);
            sparseIntArray.append(2, 21);
            sparseIntArray.append(56, 41);
            sparseIntArray.append(34, 42);
            sparseIntArray.append(17, 41);
            sparseIntArray.append(16, 42);
            sparseIntArray.append(71, 76);
            sparseIntArray.append(25, 61);
            sparseIntArray.append(27, 62);
            sparseIntArray.append(26, 63);
            sparseIntArray.append(60, 69);
            sparseIntArray.append(38, 70);
            sparseIntArray.append(12, 71);
            sparseIntArray.append(10, 72);
            sparseIntArray.append(11, 73);
            sparseIntArray.append(13, 74);
            sparseIntArray.append(9, 75);
        }

        public final void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.x);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                SparseIntArray sparseIntArray = q0;
                int i2 = sparseIntArray.get(index);
                switch (i2) {
                    case 1:
                        this.q = b.k(typedArrayObtainStyledAttributes, index, this.q);
                        break;
                    case 2:
                        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 3:
                        this.p = b.k(typedArrayObtainStyledAttributes, index, this.p);
                        break;
                    case 4:
                        this.o = b.k(typedArrayObtainStyledAttributes, index, this.o);
                        break;
                    case 5:
                        this.z = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                        break;
                    case 7:
                        this.E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 8:
                        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 9:
                        this.w = b.k(typedArrayObtainStyledAttributes, index, this.w);
                        break;
                    case 10:
                        this.v = b.k(typedArrayObtainStyledAttributes, index, this.v);
                        break;
                    case 11:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 12:
                        this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 13:
                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    case 14:
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 15:
                        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 16:
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 17:
                        this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                        break;
                    case 18:
                        this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                        break;
                    case 19:
                        this.g = typedArrayObtainStyledAttributes.getFloat(index, this.g);
                        break;
                    case 20:
                        this.x = typedArrayObtainStyledAttributes.getFloat(index, this.x);
                        break;
                    case 21:
                        this.d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.d);
                        break;
                    case 22:
                        this.c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.c);
                        break;
                    case 23:
                        this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.G);
                        break;
                    case 24:
                        this.i = b.k(typedArrayObtainStyledAttributes, index, this.i);
                        break;
                    case 25:
                        this.j = b.k(typedArrayObtainStyledAttributes, index, this.j);
                        break;
                    case 26:
                        this.F = typedArrayObtainStyledAttributes.getInt(index, this.F);
                        break;
                    case 27:
                        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 28:
                        this.k = b.k(typedArrayObtainStyledAttributes, index, this.k);
                        break;
                    case 29:
                        this.l = b.k(typedArrayObtainStyledAttributes, index, this.l);
                        break;
                    case 30:
                        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 31:
                        this.t = b.k(typedArrayObtainStyledAttributes, index, this.t);
                        break;
                    case 32:
                        this.u = b.k(typedArrayObtainStyledAttributes, index, this.u);
                        break;
                    case 33:
                        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 34:
                        this.n = b.k(typedArrayObtainStyledAttributes, index, this.n);
                        break;
                    case 35:
                        this.m = b.k(typedArrayObtainStyledAttributes, index, this.m);
                        break;
                    case 36:
                        this.y = typedArrayObtainStyledAttributes.getFloat(index, this.y);
                        break;
                    case 37:
                        this.V = typedArrayObtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 38:
                        this.U = typedArrayObtainStyledAttributes.getFloat(index, this.U);
                        break;
                    case 39:
                        this.W = typedArrayObtainStyledAttributes.getInt(index, this.W);
                        break;
                    case 40:
                        this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 41:
                        b.l(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        b.l(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i2) {
                            case 61:
                                this.A = b.k(typedArrayObtainStyledAttributes, index, this.A);
                                break;
                            case 62:
                                this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.B);
                                break;
                            case 63:
                                this.C = typedArrayObtainStyledAttributes.getFloat(index, this.C);
                                break;
                            default:
                                switch (i2) {
                                    case 69:
                                        this.e0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        break;
                                    case 72:
                                        this.g0 = typedArrayObtainStyledAttributes.getInt(index, this.g0);
                                        break;
                                    case 73:
                                        this.h0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.h0);
                                        break;
                                    case 74:
                                        this.k0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.o0);
                                        break;
                                    case 76:
                                        this.p0 = typedArrayObtainStyledAttributes.getInt(index, this.p0);
                                        break;
                                    case 77:
                                        this.r = b.k(typedArrayObtainStyledAttributes, index, this.r);
                                        break;
                                    case 78:
                                        this.s = b.k(typedArrayObtainStyledAttributes, index, this.s);
                                        break;
                                    case 79:
                                        this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                                        break;
                                    case 80:
                                        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                                        break;
                                    case 81:
                                        this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                                        break;
                                    case 82:
                                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 83:
                                        this.b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.b0);
                                        break;
                                    case 84:
                                        this.a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.a0);
                                        break;
                                    case 85:
                                        this.d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.d0);
                                        break;
                                    case 86:
                                        this.c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                        break;
                                    case 87:
                                        this.m0 = typedArrayObtainStyledAttributes.getBoolean(index, this.m0);
                                        break;
                                    case 88:
                                        this.n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.n0);
                                        break;
                                    case 89:
                                        this.l0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.h = typedArrayObtainStyledAttributes.getBoolean(index, this.h);
                                        break;
                                    default:
                                        Integer.toHexString(index);
                                        sparseIntArray.get(index);
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c {
        public static final SparseIntArray k;
        public int b = -1;
        public int c = 0;
        public int d = -1;
        public float e = Float.NaN;
        public float f = Float.NaN;
        public float g = Float.NaN;
        public int h = -1;
        public String i = null;
        public int j = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            k = sparseIntArray;
            sparseIntArray.append(3, 1);
            sparseIntArray.append(5, 2);
            sparseIntArray.append(9, 3);
            sparseIntArray.append(2, 4);
            sparseIntArray.append(1, 5);
            sparseIntArray.append(0, 6);
            sparseIntArray.append(4, 7);
            sparseIntArray.append(8, 8);
            sparseIntArray.append(7, 9);
            sparseIntArray.append(6, 10);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0038  */
        public final void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.y);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                switch (k.get(index)) {
                    case 1:
                        this.f = typedArrayObtainStyledAttributes.getFloat(index, this.f);
                        break;
                    case 2:
                        this.d = typedArrayObtainStyledAttributes.getInt(index, this.d);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            String str = e4.f51c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.b = b.k(typedArrayObtainStyledAttributes, index, this.b);
                        break;
                    case 6:
                        this.c = typedArrayObtainStyledAttributes.getInteger(index, this.c);
                        break;
                    case 7:
                        this.e = typedArrayObtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 8:
                        this.h = typedArrayObtainStyledAttributes.getInteger(index, this.h);
                        break;
                    case 9:
                        this.g = typedArrayObtainStyledAttributes.getFloat(index, this.g);
                        break;
                    case 10:
                        int i2 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i2 == 1) {
                            this.j = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        } else if (i2 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.i = string;
                            if (string.indexOf(InternalZipConstants.ZIP_FILE_SEPARATOR) > 0) {
                                this.j = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index, this.j);
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class d {
        public int b = 0;
        public int c = 0;
        public float d = 1.0f;
        public float e = Float.NaN;

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.D);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 1) {
                    this.d = typedArrayObtainStyledAttributes.getFloat(index, this.d);
                } else if (index == 0) {
                    int i2 = typedArrayObtainStyledAttributes.getInt(index, this.b);
                    this.b = i2;
                    this.b = b.f[i2];
                } else if (index == 4) {
                    this.c = typedArrayObtainStyledAttributes.getInt(index, this.c);
                } else if (index == 3) {
                    this.e = typedArrayObtainStyledAttributes.getFloat(index, this.e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class e {
        public static final SparseIntArray o;
        public float b = 0.0f;
        public float c = 0.0f;
        public float d = 0.0f;
        public float e = 1.0f;
        public float f = 1.0f;
        public float g = Float.NaN;
        public float h = Float.NaN;
        public int i = -1;
        public float j = 0.0f;
        public float k = 0.0f;
        public float l = 0.0f;
        public boolean m = false;
        public float n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            o = sparseIntArray;
            sparseIntArray.append(6, 1);
            sparseIntArray.append(7, 2);
            sparseIntArray.append(8, 3);
            sparseIntArray.append(4, 4);
            sparseIntArray.append(5, 5);
            sparseIntArray.append(0, 6);
            sparseIntArray.append(1, 7);
            sparseIntArray.append(2, 8);
            sparseIntArray.append(3, 9);
            sparseIntArray.append(9, 10);
            sparseIntArray.append(10, 11);
            sparseIntArray.append(11, 12);
        }

        public final void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.G);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                switch (o.get(index)) {
                    case 1:
                        this.b = typedArrayObtainStyledAttributes.getFloat(index, this.b);
                        break;
                    case 2:
                        this.c = typedArrayObtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 3:
                        this.d = typedArrayObtainStyledAttributes.getFloat(index, this.d);
                        break;
                    case 4:
                        this.e = typedArrayObtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 5:
                        this.f = typedArrayObtainStyledAttributes.getFloat(index, this.f);
                        break;
                    case 6:
                        this.g = typedArrayObtainStyledAttributes.getDimension(index, this.g);
                        break;
                    case 7:
                        this.h = typedArrayObtainStyledAttributes.getDimension(index, this.h);
                        break;
                    case 8:
                        this.j = typedArrayObtainStyledAttributes.getDimension(index, this.j);
                        break;
                    case 9:
                        this.k = typedArrayObtainStyledAttributes.getDimension(index, this.k);
                        break;
                    case 10:
                        this.l = typedArrayObtainStyledAttributes.getDimension(index, this.l);
                        break;
                    case 11:
                        this.m = true;
                        this.n = typedArrayObtainStyledAttributes.getDimension(index, this.n);
                        break;
                    case 12:
                        this.i = b.k(typedArrayObtainStyledAttributes, index, this.i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        g = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        h = sparseIntArray2;
        sparseIntArray.append(82, 25);
        sparseIntArray.append(83, 26);
        sparseIntArray.append(85, 29);
        sparseIntArray.append(86, 30);
        sparseIntArray.append(92, 36);
        sparseIntArray.append(91, 35);
        sparseIntArray.append(63, 4);
        sparseIntArray.append(62, 3);
        sparseIntArray.append(58, 1);
        sparseIntArray.append(60, 91);
        sparseIntArray.append(59, 92);
        sparseIntArray.append(101, 6);
        sparseIntArray.append(102, 7);
        sparseIntArray.append(70, 17);
        sparseIntArray.append(71, 18);
        sparseIntArray.append(72, 19);
        sparseIntArray.append(54, 99);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(87, 32);
        sparseIntArray.append(88, 33);
        sparseIntArray.append(69, 10);
        sparseIntArray.append(68, 9);
        sparseIntArray.append(106, 13);
        sparseIntArray.append(109, 16);
        sparseIntArray.append(107, 14);
        sparseIntArray.append(104, 11);
        sparseIntArray.append(108, 15);
        sparseIntArray.append(105, 12);
        sparseIntArray.append(95, 40);
        sparseIntArray.append(80, 39);
        sparseIntArray.append(79, 41);
        sparseIntArray.append(94, 42);
        sparseIntArray.append(78, 20);
        sparseIntArray.append(93, 37);
        sparseIntArray.append(67, 5);
        sparseIntArray.append(81, 87);
        sparseIntArray.append(90, 87);
        sparseIntArray.append(84, 87);
        sparseIntArray.append(61, 87);
        sparseIntArray.append(57, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(96, 95);
        sparseIntArray.append(73, 96);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(97, 54);
        sparseIntArray.append(74, 55);
        sparseIntArray.append(98, 56);
        sparseIntArray.append(75, 57);
        sparseIntArray.append(99, 58);
        sparseIntArray.append(76, 59);
        sparseIntArray.append(64, 61);
        sparseIntArray.append(66, 62);
        sparseIntArray.append(65, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(121, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(122, 67);
        sparseIntArray.append(113, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(112, 68);
        sparseIntArray.append(100, 69);
        sparseIntArray.append(77, 70);
        sparseIntArray.append(111, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(114, 76);
        sparseIntArray.append(89, 77);
        sparseIntArray.append(123, 78);
        sparseIntArray.append(56, 80);
        sparseIntArray.append(55, 81);
        sparseIntArray.append(116, 82);
        sparseIntArray.append(120, 83);
        sparseIntArray.append(119, 84);
        sparseIntArray.append(118, 85);
        sparseIntArray.append(117, 86);
        sparseIntArray2.append(85, 6);
        sparseIntArray2.append(85, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(89, 13);
        sparseIntArray2.append(92, 16);
        sparseIntArray2.append(90, 14);
        sparseIntArray2.append(87, 11);
        sparseIntArray2.append(91, 15);
        sparseIntArray2.append(88, 12);
        sparseIntArray2.append(78, 40);
        sparseIntArray2.append(71, 39);
        sparseIntArray2.append(70, 41);
        sparseIntArray2.append(77, 42);
        sparseIntArray2.append(69, 20);
        sparseIntArray2.append(76, 37);
        sparseIntArray2.append(60, 5);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(75, 87);
        sparseIntArray2.append(73, 87);
        sparseIntArray2.append(57, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(79, 95);
        sparseIntArray2.append(64, 96);
        sparseIntArray2.append(2, 22);
        sparseIntArray2.append(13, 43);
        sparseIntArray2.append(26, 44);
        sparseIntArray2.append(21, 45);
        sparseIntArray2.append(22, 46);
        sparseIntArray2.append(20, 60);
        sparseIntArray2.append(18, 47);
        sparseIntArray2.append(19, 48);
        sparseIntArray2.append(14, 49);
        sparseIntArray2.append(15, 50);
        sparseIntArray2.append(16, 51);
        sparseIntArray2.append(17, 52);
        sparseIntArray2.append(25, 53);
        sparseIntArray2.append(80, 54);
        sparseIntArray2.append(65, 55);
        sparseIntArray2.append(81, 56);
        sparseIntArray2.append(66, 57);
        sparseIntArray2.append(82, 58);
        sparseIntArray2.append(67, 59);
        sparseIntArray2.append(59, 62);
        sparseIntArray2.append(58, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(105, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(106, 67);
        sparseIntArray2.append(96, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(97, 98);
        sparseIntArray2.append(95, 68);
        sparseIntArray2.append(83, 69);
        sparseIntArray2.append(68, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(98, 76);
        sparseIntArray2.append(74, 77);
        sparseIntArray2.append(107, 78);
        sparseIntArray2.append(55, 80);
        sparseIntArray2.append(54, 81);
        sparseIntArray2.append(100, 82);
        sparseIntArray2.append(104, 83);
        sparseIntArray2.append(103, 84);
        sparseIntArray2.append(102, 85);
        sparseIntArray2.append(101, 86);
        sparseIntArray2.append(94, 97);
    }

    public static int[] f(Barrier barrier, String str) {
        int iIntValue;
        String[] strArrSplit = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            Object obj = null;
            try {
                iIntValue = ak.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                if (fb$1.m(strTrim)) {
                    HashMap map = constraintLayout.mDesignIds;
                    if (map != null && map.containsKey(strTrim)) {
                        obj = constraintLayout.mDesignIds.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i2] = iIntValue;
            i++;
            i2++;
        }
        return i2 != strArrSplit.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0422, code lost:
    
        if (r12 != (-1)) goto L176;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.constraintlayout.widget.b.a g(android.content.Context r17, android.util.AttributeSet r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 2446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.b.g(android.content.Context, android.util.AttributeSet, boolean):androidx.constraintlayout.widget.b$a");
    }

    public static int k(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* JADX WARN: Code duplicated, block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x0034  */
    /* JADX WARN: Code duplicated, block: B:21:0x0038  */
    /* JADX WARN: Code duplicated, block: B:23:0x003d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0042  */
    /* JADX WARN: Code duplicated, block: B:27:0x0046  */
    /* JADX WARN: Code duplicated, block: B:29:0x004a  */
    /* JADX WARN: Code duplicated, block: B:31:0x004f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0054  */
    /* JADX WARN: Code duplicated, block: B:35:0x0058  */
    /* JADX WARN: Code duplicated, block: B:37:0x005c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0062  */
    public static void l(Object obj, TypedArray typedArray, int i, int i2) {
        int i3;
        int i4;
        int dimensionPixelSize;
        a.C0007a c0007a;
        int i5;
        C0008b c0008b;
        ConstraintLayout.a aVar;
        if (obj == null) {
            return;
        }
        int i6 = typedArray.peekValue(i).type;
        boolean z = true;
        int i7 = 0;
        if (i6 != 3) {
            if (i6 != 5) {
                dimensionPixelSize = typedArray.getInt(i, 0);
                if (dimensionPixelSize == -4) {
                    i7 = -2;
                } else if (dimensionPixelSize == -3 || (dimensionPixelSize != -2 && dimensionPixelSize != -1)) {
                    z = false;
                }
                if (obj instanceof ConstraintLayout.a) {
                    aVar = (ConstraintLayout.a) obj;
                    if (i2 == 0) {
                        ((ViewGroup.MarginLayoutParams) aVar).width = i7;
                        aVar.W = z;
                        return;
                    } else {
                        ((ViewGroup.MarginLayoutParams) aVar).height = i7;
                        aVar.X = z;
                        return;
                    }
                }
                if (obj instanceof C0008b) {
                    c0008b = (C0008b) obj;
                    if (i2 == 0) {
                        c0008b.c = i7;
                        c0008b.m0 = z;
                        return;
                    } else {
                        c0008b.d = i7;
                        c0008b.n0 = z;
                        return;
                    }
                }
                if (obj instanceof a.C0007a) {
                    c0007a = (a.C0007a) obj;
                    if (i2 == 0) {
                        c0007a.b(23, i7);
                        i5 = 80;
                    } else {
                        c0007a.b(21, i7);
                        i5 = 81;
                    }
                    c0007a.d(i5, z);
                    return;
                }
                return;
            }
            dimensionPixelSize = typedArray.getDimensionPixelSize(i, 0);
            z = false;
            i7 = dimensionPixelSize;
            if (obj instanceof ConstraintLayout.a) {
                aVar = (ConstraintLayout.a) obj;
                if (i2 == 0) {
                    ((ViewGroup.MarginLayoutParams) aVar).width = i7;
                    aVar.W = z;
                    return;
                } else {
                    ((ViewGroup.MarginLayoutParams) aVar).height = i7;
                    aVar.X = z;
                    return;
                }
            }
            if (obj instanceof C0008b) {
                c0008b = (C0008b) obj;
                if (i2 == 0) {
                    c0008b.c = i7;
                    c0008b.m0 = z;
                    return;
                } else {
                    c0008b.d = i7;
                    c0008b.n0 = z;
                    return;
                }
            }
            if (obj instanceof a.C0007a) {
                c0007a = (a.C0007a) obj;
                if (i2 == 0) {
                    c0007a.b(23, i7);
                    i5 = 80;
                } else {
                    c0007a.b(21, i7);
                    i5 = 81;
                }
                c0007a.d(i5, z);
                return;
            }
            return;
        }
        String string = typedArray.getString(i);
        if (string == null) {
            return;
        }
        int iIndexOf = string.indexOf(61);
        int length = string.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = string.substring(0, iIndexOf);
        String strSubstring2 = string.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if ("ratio".equalsIgnoreCase(strTrim)) {
                if (obj instanceof ConstraintLayout.a) {
                    ConstraintLayout.a aVar2 = (ConstraintLayout.a) obj;
                    if (i2 == 0) {
                        ((ViewGroup.MarginLayoutParams) aVar2).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) aVar2).height = 0;
                    }
                    m(aVar2, strTrim2);
                    return;
                }
                if (obj instanceof C0008b) {
                    ((C0008b) obj).z = strTrim2;
                    return;
                } else {
                    if (obj instanceof a.C0007a) {
                        ((a.C0007a) obj).c(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f2 = Float.parseFloat(strTrim2);
                    if (obj instanceof ConstraintLayout.a) {
                        ConstraintLayout.a aVar3 = (ConstraintLayout.a) obj;
                        if (i2 == 0) {
                            ((ViewGroup.MarginLayoutParams) aVar3).width = 0;
                            aVar3.H = f2;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) aVar3).height = 0;
                            aVar3.I = f2;
                            return;
                        }
                    }
                    if (obj instanceof C0008b) {
                        C0008b c0008b2 = (C0008b) obj;
                        if (i2 == 0) {
                            c0008b2.c = 0;
                            c0008b2.V = f2;
                            return;
                        } else {
                            c0008b2.d = 0;
                            c0008b2.U = f2;
                            return;
                        }
                    }
                    if (obj instanceof a.C0007a) {
                        a.C0007a c0007a2 = (a.C0007a) obj;
                        if (i2 == 0) {
                            c0007a2.b(23, 0);
                            i4 = 39;
                        } else {
                            c0007a2.b(21, 0);
                            i4 = 40;
                        }
                        c0007a2.a(i4, f2);
                        return;
                    }
                    return;
                }
                if ("parent".equalsIgnoreCase(strTrim)) {
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (obj instanceof ConstraintLayout.a) {
                        ConstraintLayout.a aVar4 = (ConstraintLayout.a) obj;
                        if (i2 == 0) {
                            ((ViewGroup.MarginLayoutParams) aVar4).width = 0;
                            aVar4.R = fMax;
                            aVar4.L = 2;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) aVar4).height = 0;
                            aVar4.S = fMax;
                            aVar4.M = 2;
                            return;
                        }
                    }
                    if (obj instanceof C0008b) {
                        C0008b c0008b3 = (C0008b) obj;
                        if (i2 == 0) {
                            c0008b3.c = 0;
                            c0008b3.e0 = fMax;
                            c0008b3.Y = 2;
                            return;
                        } else {
                            c0008b3.d = 0;
                            c0008b3.f0 = fMax;
                            c0008b3.Z = 2;
                            return;
                        }
                    }
                    if (obj instanceof a.C0007a) {
                        a.C0007a c0007a3 = (a.C0007a) obj;
                        if (i2 == 0) {
                            c0007a3.b(23, 0);
                            i3 = 54;
                        } else {
                            c0007a3.b(21, 0);
                            i3 = 55;
                        }
                        c0007a3.b(i3, 2);
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static void m(ConstraintLayout.a aVar, String str) {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            byte b = -1;
            int i = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    b = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    b = 1;
                }
                i = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i);
                    if (strSubstring2.length() > 0) {
                        Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f2 = Float.parseFloat(strSubstring3);
                        float f3 = Float.parseFloat(strSubstring4);
                        if (f2 > 0.0f && f3 > 0.0f) {
                            if (b == 1) {
                                Math.abs(f3 / f2);
                            } else {
                                Math.abs(f2 / f3);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        aVar.G = str;
    }

    public final void c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashMap map = this.e;
        HashSet<Integer> hashSet = new HashSet(map.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!map.containsKey(Integer.valueOf(id))) {
                try {
                    childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                }
            } else {
                if (this.d && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1 && map.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    a aVar = (a) map.get(Integer.valueOf(id));
                    if (aVar != null) {
                        if (childAt instanceof Barrier) {
                            C0008b c0008b = aVar.e;
                            c0008b.i0 = 1;
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.o = c0008b.g0;
                            int i2 = c0008b.h0;
                            h8 h8Var = barrier.q;
                            h8Var.w0 = i2;
                            h8Var.v0 = c0008b.o0;
                            int[] iArr = c0008b.j0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = c0008b.k0;
                                if (str != null) {
                                    int[] iArrF = f(barrier, str);
                                    c0008b.j0 = iArrF;
                                    barrier.setReferencedIds(iArrF);
                                }
                            }
                        }
                        ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                        aVar2.a();
                        aVar.a(aVar2);
                        HashMap map2 = aVar.g;
                        Class<?> cls = childAt.getClass();
                        for (String strM : map2.keySet()) {
                            wg wgVar = (wg) map2.get(strM);
                            if (!wgVar.a) {
                                strM = ak.m("set", strM);
                            }
                            try {
                                switch (ak.u(wgVar.c)) {
                                    case 0:
                                        cls.getMethod(strM, Integer.TYPE).invoke(childAt, Integer.valueOf(wgVar.d));
                                        break;
                                    case 1:
                                        cls.getMethod(strM, Float.TYPE).invoke(childAt, Float.valueOf(wgVar.e));
                                        break;
                                    case 2:
                                        cls.getMethod(strM, Integer.TYPE).invoke(childAt, Integer.valueOf(wgVar.h));
                                        break;
                                    case 3:
                                        Method method = cls.getMethod(strM, Drawable.class);
                                        ColorDrawable colorDrawable = new ColorDrawable();
                                        colorDrawable.setColor(wgVar.h);
                                        method.invoke(childAt, colorDrawable);
                                        break;
                                    case 4:
                                        cls.getMethod(strM, CharSequence.class).invoke(childAt, wgVar.f);
                                        break;
                                    case 5:
                                        cls.getMethod(strM, Boolean.TYPE).invoke(childAt, Boolean.valueOf(wgVar.g));
                                        break;
                                    case 6:
                                        cls.getMethod(strM, Float.TYPE).invoke(childAt, Float.valueOf(wgVar.e));
                                        break;
                                    case 7:
                                        cls.getMethod(strM, Integer.TYPE).invoke(childAt, Integer.valueOf(wgVar.d));
                                        break;
                                }
                            } catch (IllegalAccessException e2) {
                                e = e2;
                                e.printStackTrace();
                            } catch (NoSuchMethodException e3) {
                                e3.getMessage();
                            } catch (InvocationTargetException e4) {
                                e = e4;
                                e.printStackTrace();
                            }
                        }
                        childAt.setLayoutParams(aVar2);
                        d dVar = aVar.c;
                        if (dVar.c == 0) {
                            childAt.setVisibility(dVar.b);
                        }
                        childAt.setAlpha(dVar.d);
                        e eVar = aVar.f;
                        childAt.setRotation(eVar.b);
                        childAt.setRotationX(eVar.c);
                        childAt.setRotationY(eVar.d);
                        childAt.setScaleX(eVar.e);
                        childAt.setScaleY(eVar.f);
                        if (eVar.i != -1) {
                            View viewFindViewById = ((View) childAt.getParent()).findViewById(eVar.i);
                            if (viewFindViewById != null) {
                                float bottom = (viewFindViewById.getBottom() + viewFindViewById.getTop()) / 2.0f;
                                float right = (viewFindViewById.getRight() + viewFindViewById.getLeft()) / 2.0f;
                                if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                    float left = right - childAt.getLeft();
                                    float top = bottom - childAt.getTop();
                                    childAt.setPivotX(left);
                                    childAt.setPivotY(top);
                                }
                            }
                        } else {
                            if (!Float.isNaN(eVar.g)) {
                                childAt.setPivotX(eVar.g);
                            }
                            if (!Float.isNaN(eVar.h)) {
                                childAt.setPivotY(eVar.h);
                            }
                        }
                        childAt.setTranslationX(eVar.j);
                        childAt.setTranslationY(eVar.k);
                        childAt.setTranslationZ(eVar.l);
                        if (eVar.m) {
                            childAt.setElevation(eVar.n);
                        }
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            a aVar3 = (a) map.get(num);
            if (aVar3 != null) {
                C0008b c0008b2 = aVar3.e;
                if (c0008b2.i0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    int[] iArr2 = c0008b2.j0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = c0008b2.k0;
                        if (str2 != null) {
                            int[] iArrF2 = f(barrier2, str2);
                            c0008b2.j0 = iArrF2;
                            barrier2.setReferencedIds(iArrF2);
                        }
                    }
                    barrier2.o = c0008b2.g0;
                    barrier2.q.w0 = c0008b2.h0;
                    ConstraintLayout.a aVar4 = new ConstraintLayout.a();
                    barrier2.l();
                    aVar3.a(aVar4);
                    constraintLayout.addView(barrier2, aVar4);
                }
                if (c0008b2.a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.a aVar5 = new ConstraintLayout.a();
                    aVar3.a(aVar5);
                    constraintLayout.addView(guideline, aVar5);
                }
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            constraintLayout.getChildAt(i3);
        }
    }

    public final void e(ConstraintLayout constraintLayout) {
        b bVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map = bVar.e;
        map.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.a aVar = (ConstraintLayout.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (bVar.d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map.containsKey(Integer.valueOf(id))) {
                map.put(Integer.valueOf(id), new a());
            }
            a aVar2 = (a) map.get(Integer.valueOf(id));
            if (aVar2 != null) {
                HashMap map2 = new HashMap();
                Class<?> cls = childAt.getClass();
                HashMap map3 = bVar.c;
                for (String str : map3.keySet()) {
                    wg wgVar = (wg) map3.get(str);
                    try {
                        map2.put(str, str.equals("BackgroundColor") ? new wg(wgVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())) : new wg(wgVar, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                    } catch (IllegalAccessException e2) {
                        e = e2;
                        e.printStackTrace();
                    } catch (NoSuchMethodException e3) {
                        e = e3;
                        e.printStackTrace();
                    } catch (InvocationTargetException e4) {
                        e = e4;
                        e.printStackTrace();
                    }
                }
                aVar2.g = map2;
                aVar2.c(id, aVar);
                int visibility = childAt.getVisibility();
                d dVar = aVar2.c;
                dVar.b = visibility;
                dVar.d = childAt.getAlpha();
                float rotation = childAt.getRotation();
                e eVar = aVar2.f;
                eVar.b = rotation;
                eVar.c = childAt.getRotationX();
                eVar.d = childAt.getRotationY();
                eVar.e = childAt.getScaleX();
                eVar.f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    eVar.g = pivotX;
                    eVar.h = pivotY;
                }
                eVar.j = childAt.getTranslationX();
                eVar.k = childAt.getTranslationY();
                eVar.l = childAt.getTranslationZ();
                if (eVar.m) {
                    eVar.n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    boolean z = barrier.q.v0;
                    C0008b c0008b = aVar2.e;
                    c0008b.o0 = z;
                    c0008b.j0 = Arrays.copyOf(barrier.b, barrier.c);
                    c0008b.g0 = barrier.o;
                    c0008b.h0 = barrier.q.w0;
                }
            }
            i++;
            bVar = this;
        }
    }

    public final void i(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarG = g(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarG.e.a = true;
                    }
                    this.e.put(Integer.valueOf(aVarG.a), aVarG);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }
}
