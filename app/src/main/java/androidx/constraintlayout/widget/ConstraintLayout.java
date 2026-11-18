package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.ak;
import defpackage.ch;
import defpackage.cm;
import defpackage.dh;
import defpackage.e;
import defpackage.g;
import defpackage.g10;
import defpackage.h8;
import defpackage.kd1;
import defpackage.m6;
import defpackage.n8$a;
import defpackage.n8$b;
import defpackage.oe0;
import defpackage.py;
import defpackage.qy;
import defpackage.vg;
import defpackage.xb;
import defpackage.yf1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public final SparseArray mChildrenByIds;
    public final ArrayList mConstraintHelpers;
    public androidx.constraintlayout.widget.b mConstraintSet;
    public int mConstraintSetId;
    public HashMap mDesignIds;
    public boolean mDirtyHierarchy;
    public final dh mLayoutWidget;
    public int mMaxHeight;
    public int mMaxWidth;
    public final b mMeasurer;
    public int mMinHeight;
    public int mMinWidth;
    public int mOptimizationLevel;
    public final SparseArray mTempMapIdToWidget;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public final int C;
        public final int D;
        public float E;
        public float F;
        public String G;
        public float H;
        public float I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public float R;
        public float S;
        public int T;
        public int U;
        public int V;
        public boolean W;
        public boolean X;
        public String Y;
        public int Z;
        public int a;
        public boolean a0;
        public int b;
        public boolean b0;
        public float c;
        public boolean c0;
        public final boolean d;
        public boolean d0;
        public int e;
        public boolean e0;
        public int f;
        public boolean f0;
        public int g;
        public int g0;
        public int h;
        public int h0;
        public int i;
        public int i0;
        public int j;
        public int j0;
        public int k;
        public int k0;
        public int l;
        public int l0;
        public int m;
        public float m0;
        public int n;
        public int n0;
        public int o;
        public int o0;
        public int p;
        public float p0;
        public int q;
        public ch q0;
        public float r;
        public int s;
        public int t;
        public int u;
        public int v;
        public final int w;
        public int x;
        public final int y;
        public int z;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static class C0006a {
            public static final SparseIntArray a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                a = sparseIntArray;
                sparseIntArray.append(98, 64);
                sparseIntArray.append(75, 65);
                sparseIntArray.append(84, 8);
                sparseIntArray.append(85, 9);
                sparseIntArray.append(87, 10);
                sparseIntArray.append(88, 11);
                sparseIntArray.append(94, 12);
                sparseIntArray.append(93, 13);
                sparseIntArray.append(65, 14);
                sparseIntArray.append(64, 15);
                sparseIntArray.append(60, 16);
                sparseIntArray.append(62, 52);
                sparseIntArray.append(61, 53);
                sparseIntArray.append(66, 2);
                sparseIntArray.append(68, 3);
                sparseIntArray.append(67, 4);
                sparseIntArray.append(103, 49);
                sparseIntArray.append(104, 50);
                sparseIntArray.append(72, 5);
                sparseIntArray.append(73, 6);
                sparseIntArray.append(74, 7);
                sparseIntArray.append(55, 67);
                sparseIntArray.append(0, 1);
                sparseIntArray.append(89, 17);
                sparseIntArray.append(90, 18);
                sparseIntArray.append(71, 19);
                sparseIntArray.append(70, 20);
                sparseIntArray.append(108, 21);
                sparseIntArray.append(111, 22);
                sparseIntArray.append(109, 23);
                sparseIntArray.append(106, 24);
                sparseIntArray.append(110, 25);
                sparseIntArray.append(107, 26);
                sparseIntArray.append(105, 55);
                sparseIntArray.append(112, 54);
                sparseIntArray.append(80, 29);
                sparseIntArray.append(95, 30);
                sparseIntArray.append(69, 44);
                sparseIntArray.append(82, 45);
                sparseIntArray.append(97, 46);
                sparseIntArray.append(81, 47);
                sparseIntArray.append(96, 48);
                sparseIntArray.append(58, 27);
                sparseIntArray.append(57, 28);
                sparseIntArray.append(99, 31);
                sparseIntArray.append(76, 32);
                sparseIntArray.append(101, 33);
                sparseIntArray.append(100, 34);
                sparseIntArray.append(102, 35);
                sparseIntArray.append(78, 36);
                sparseIntArray.append(77, 37);
                sparseIntArray.append(79, 38);
                sparseIntArray.append(83, 39);
                sparseIntArray.append(92, 40);
                sparseIntArray.append(86, 41);
                sparseIntArray.append(63, 42);
                sparseIntArray.append(59, 43);
                sparseIntArray.append(91, 51);
                sparseIntArray.append(114, 66);
            }
        }

        public a() {
            super(-2, -2);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.x = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.y = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.z = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.A = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.B = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.C = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.a0 = true;
            this.b0 = true;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = false;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = -1;
            this.k0 = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.l0 = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.m0 = 0.5f;
            this.q0 = new ch();
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.x = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.y = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.z = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.A = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.B = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.C = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.a0 = true;
            this.b0 = true;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = false;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = -1;
            this.k0 = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.l0 = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.m0 = 0.5f;
            this.q0 = new ch();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.o);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                int i2 = C0006a.a.get(index);
                switch (i2) {
                    case 1:
                        this.V = typedArrayObtainStyledAttributes.getInt(index, this.V);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId;
                        if (resourceId == -1) {
                            this.p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.q);
                        break;
                    case 4:
                        float f = typedArrayObtainStyledAttributes.getFloat(index, this.r) % 360.0f;
                        this.r = f;
                        if (f < 0.0f) {
                            this.r = (360.0f - f) % 360.0f;
                        }
                        break;
                    case 5:
                        this.a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.a);
                        break;
                    case 6:
                        this.b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.b);
                        break;
                    case 7:
                        this.c = typedArrayObtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.e);
                        this.e = resourceId2;
                        if (resourceId2 == -1) {
                            this.e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f);
                        this.f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.g);
                        this.g = resourceId4;
                        if (resourceId4 == -1) {
                            this.g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.h);
                        this.h = resourceId5;
                        if (resourceId5 == -1) {
                            this.h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.i);
                        this.i = resourceId6;
                        if (resourceId6 == -1) {
                            this.i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.j);
                        this.j = resourceId7;
                        if (resourceId7 == -1) {
                            this.j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.k);
                        this.k = resourceId8;
                        if (resourceId8 == -1) {
                            this.k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.l);
                        this.l = resourceId9;
                        if (resourceId9 == -1) {
                            this.l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.m);
                        this.m = resourceId10;
                        if (resourceId10 == -1) {
                            this.m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId11;
                        if (resourceId11 == -1) {
                            this.s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.t);
                        this.t = resourceId12;
                        if (resourceId12 == -1) {
                            this.t = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.u);
                        this.u = resourceId13;
                        if (resourceId13 == -1) {
                            this.u = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.v);
                        this.v = resourceId14;
                        if (resourceId14 == -1) {
                            this.v = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 22:
                        this.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 23:
                        this.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 24:
                        this.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.z);
                        break;
                    case 25:
                        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 26:
                        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case 27:
                        this.W = typedArrayObtainStyledAttributes.getBoolean(index, this.W);
                        break;
                    case 28:
                        this.X = typedArrayObtainStyledAttributes.getBoolean(index, this.X);
                        break;
                    case 29:
                        this.E = typedArrayObtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 30:
                        this.F = typedArrayObtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 31:
                        this.L = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 32:
                        this.M = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 33:
                        try {
                            this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.P) == -2) {
                                this.P = -2;
                            }
                        }
                        break;
                    case 35:
                        this.R = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.R));
                        this.L = 2;
                        break;
                    case 36:
                        try {
                            this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.O) == -2) {
                                this.O = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.Q) == -2) {
                                this.Q = -2;
                            }
                        }
                        break;
                    case 38:
                        this.S = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.S));
                        this.M = 2;
                        break;
                    default:
                        switch (i2) {
                            case 44:
                                androidx.constraintlayout.widget.b.m(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.H = typedArrayObtainStyledAttributes.getFloat(index, this.H);
                                break;
                            case 46:
                                this.I = typedArrayObtainStyledAttributes.getFloat(index, this.I);
                                break;
                            case 47:
                                this.J = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.K = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.T);
                                break;
                            case 50:
                                this.U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.U);
                                break;
                            case 51:
                                this.Y = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.n);
                                this.n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 53:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.o);
                                this.o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 54:
                                this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                break;
                            case 55:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            default:
                                switch (i2) {
                                    case 64:
                                        androidx.constraintlayout.widget.b.l(this, typedArrayObtainStyledAttributes, index, 0);
                                        break;
                                    case 65:
                                        androidx.constraintlayout.widget.b.l(this, typedArrayObtainStyledAttributes, index, 1);
                                        break;
                                    case 66:
                                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 67:
                                        this.d = typedArrayObtainStyledAttributes.getBoolean(index, this.d);
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.x = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.y = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.z = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.A = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.B = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.C = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.a0 = true;
            this.b0 = true;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = false;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = -1;
            this.k0 = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.l0 = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.m0 = 0.5f;
            this.q0 = new ch();
        }

        public final void a() {
            this.d0 = false;
            this.a0 = true;
            this.b0 = true;
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == -2 && this.W) {
                this.a0 = false;
                if (this.L == 0) {
                    this.L = 1;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == -2 && this.X) {
                this.b0 = false;
                if (this.M == 0) {
                    this.M = 1;
                }
            }
            if (i == 0 || i == -1) {
                this.a0 = false;
                if (i == 0 && this.L == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.W = true;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.b0 = false;
                if (i2 == 0 && this.M == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.X = true;
                }
            }
            if (this.c == -1.0f && this.a == -1 && this.b == -1) {
                return;
            }
            this.d0 = true;
            this.a0 = true;
            this.b0 = true;
            if (!(this.q0 instanceof py)) {
                this.q0 = new py();
            }
            ((py) this.q0).M(this.V);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0049  */
        /* JADX WARN: Code duplicated, block: B:19:0x0050  */
        /* JADX WARN: Code duplicated, block: B:22:0x0057  */
        /* JADX WARN: Code duplicated, block: B:25:0x005d  */
        /* JADX WARN: Code duplicated, block: B:28:0x0063  */
        /* JADX WARN: Code duplicated, block: B:37:0x0079  */
        /* JADX WARN: Code duplicated, block: B:38:0x0081 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:39:0x0083  */
        /* JADX WARN: Code duplicated, block: B:40:0x0088 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:41:0x008a  */
        /* JADX WARN: Code duplicated, block: B:78:0x00da  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public final void resolveLayoutDirection(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i7 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i);
            boolean z = false;
            boolean z2 = 1 == getLayoutDirection();
            this.i0 = -1;
            this.j0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.k0 = this.w;
            this.l0 = this.y;
            float f = this.E;
            this.m0 = f;
            int i8 = this.a;
            this.n0 = i8;
            int i9 = this.b;
            this.o0 = i9;
            float f2 = this.c;
            this.p0 = f2;
            int i10 = this.s;
            if (z2) {
                if (i10 != -1) {
                    this.i0 = i10;
                } else {
                    int i11 = this.t;
                    if (i11 != -1) {
                        this.j0 = i11;
                    } else {
                        i2 = this.u;
                        if (i2 != -1) {
                            this.h0 = i2;
                            z = true;
                        }
                        i3 = this.v;
                        if (i3 != -1) {
                            this.g0 = i3;
                            z = true;
                        }
                        i4 = this.A;
                        if (i4 != Integer.MIN_VALUE) {
                            this.l0 = i4;
                        }
                        i5 = this.B;
                        if (i5 != Integer.MIN_VALUE) {
                            this.k0 = i5;
                        }
                        if (z) {
                            this.m0 = 1.0f - f;
                        }
                        if (this.d0 && this.V == 1 && this.d) {
                            if (f2 != -1.0f) {
                                this.p0 = 1.0f - f2;
                                this.n0 = -1;
                                this.o0 = -1;
                            } else {
                                if (i8 != -1) {
                                    this.o0 = i8;
                                    this.n0 = -1;
                                } else if (i9 != -1) {
                                    this.n0 = i9;
                                    this.o0 = -1;
                                }
                                this.p0 = -1.0f;
                            }
                        }
                    }
                }
                z = true;
                i2 = this.u;
                if (i2 != -1) {
                    this.h0 = i2;
                    z = true;
                }
                i3 = this.v;
                if (i3 != -1) {
                    this.g0 = i3;
                    z = true;
                }
                i4 = this.A;
                if (i4 != Integer.MIN_VALUE) {
                    this.l0 = i4;
                }
                i5 = this.B;
                if (i5 != Integer.MIN_VALUE) {
                    this.k0 = i5;
                }
                if (z) {
                    this.m0 = 1.0f - f;
                }
                if (this.d0) {
                    if (f2 != -1.0f) {
                        this.p0 = 1.0f - f2;
                        this.n0 = -1;
                        this.o0 = -1;
                    } else {
                        if (i8 != -1) {
                            this.o0 = i8;
                            this.n0 = -1;
                        } else if (i9 != -1) {
                            this.n0 = i9;
                            this.o0 = -1;
                        }
                        this.p0 = -1.0f;
                    }
                }
            } else {
                if (i10 != -1) {
                    this.h0 = i10;
                }
                int i12 = this.t;
                if (i12 != -1) {
                    this.g0 = i12;
                }
                int i13 = this.u;
                if (i13 != -1) {
                    this.i0 = i13;
                }
                int i14 = this.v;
                if (i14 != -1) {
                    this.j0 = i14;
                }
                int i15 = this.A;
                if (i15 != Integer.MIN_VALUE) {
                    this.k0 = i15;
                }
                int i16 = this.B;
                if (i16 != Integer.MIN_VALUE) {
                    this.l0 = i16;
                }
            }
            if (this.u == -1 && this.v == -1 && this.t == -1 && i10 == -1) {
                int i17 = this.g;
                if (i17 != -1) {
                    this.i0 = i17;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                    }
                } else {
                    int i18 = this.h;
                    if (i18 != -1) {
                        this.j0 = i18;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                        }
                    }
                }
                int i19 = this.e;
                if (i19 != -1) {
                    this.g0 = i19;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i6 <= 0) {
                        return;
                    }
                } else {
                    int i20 = this.f;
                    if (i20 == -1) {
                        return;
                    }
                    this.h0 = i20;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i6 <= 0) {
                        return;
                    }
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements n8$b {
        public final ConstraintLayout a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public b(ConstraintLayout constraintLayout) {
            this.a = constraintLayout;
        }

        public static boolean a(int i, int i2, int i3) {
            if (i == i2) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i);
            View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i3 == size;
            }
            return false;
        }

        public final void b(ch chVar, n8$a n8_a) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int iMax;
            boolean z;
            int measuredWidth;
            int baseline;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            if (chVar.j0 == 8 && !chVar.G) {
                n8_a.e = 0;
                n8_a.f = 0;
                n8_a.g = 0;
                return;
            }
            if (chVar.W == null) {
                return;
            }
            int i6 = n8_a.a;
            int i7 = n8_a.b;
            int iN = n8_a.c;
            int i8 = n8_a.d;
            int i9 = this.b + this.c;
            int i10 = this.d;
            View view = chVar.i0;
            int iU = ak.u(i6);
            vg vgVar = chVar.M;
            vg vgVar2 = chVar.K;
            if (iU == 0) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iN, 1073741824);
            } else {
                if (iU == 1) {
                    i4 = this.f;
                    i5 = -2;
                } else if (iU == 2) {
                    iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i10, -2);
                    boolean z2 = chVar.s == 1;
                    int i11 = n8_a.j;
                    if (i11 == 1 || i11 == 2) {
                        boolean z3 = view.getMeasuredHeight() == chVar.i();
                        if (n8_a.j == 2 || !z2 || ((z2 && z3) || (view instanceof d) || chVar.x())) {
                            iN = chVar.n();
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iN, 1073741824);
                        }
                    }
                } else if (iU != 3) {
                    iMakeMeasureSpec = 0;
                } else {
                    i4 = this.f;
                    int i12 = vgVar2 != null ? vgVar2.g : 0;
                    if (vgVar != null) {
                        i12 += vgVar.g;
                    }
                    i10 += i12;
                    i5 = -1;
                }
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i4, i10, i5);
            }
            int iU2 = ak.u(i7);
            if (iU2 == 0) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
            } else {
                if (iU2 == 1) {
                    i2 = -2;
                    i3 = this.g;
                } else if (iU2 == 2) {
                    iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i9, -2);
                    boolean z4 = chVar.t == 1;
                    int i13 = n8_a.j;
                    if (i13 == 1 || i13 == 2) {
                        boolean z5 = view.getMeasuredWidth() == chVar.n();
                        if (n8_a.j == 2 || !z4 || ((z4 && z5) || (view instanceof d) || chVar.y())) {
                            i8 = chVar.i();
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                        }
                    }
                } else if (iU2 != 3) {
                    iMakeMeasureSpec2 = 0;
                } else {
                    i3 = this.g;
                    int i14 = vgVar2 != null ? chVar.L.g : 0;
                    if (vgVar != null) {
                        i14 += chVar.N.g;
                    }
                    i9 += i14;
                    i2 = -1;
                }
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, i9, i2);
            }
            dh dhVar = chVar.W;
            ConstraintLayout constraintLayout = ConstraintLayout.this;
            if (dhVar != null && e.x(constraintLayout.mOptimizationLevel, 256) && view.getMeasuredWidth() == chVar.n() && view.getMeasuredWidth() < dhVar.n() && view.getMeasuredHeight() == chVar.i() && view.getMeasuredHeight() < dhVar.i() && view.getBaseline() == chVar.d0 && !chVar.w() && a(chVar.I, iMakeMeasureSpec, chVar.n()) && a(chVar.J, iMakeMeasureSpec2, chVar.i())) {
                n8_a.e = chVar.n();
                n8_a.f = chVar.i();
                n8_a.g = chVar.d0;
                return;
            }
            boolean z6 = i6 == 3;
            boolean z7 = i7 == 3;
            boolean z8 = i7 == 4 || i7 == 1;
            boolean z9 = i6 == 4 || i6 == 1;
            boolean z10 = z6 && chVar.Z > 0.0f;
            boolean z11 = z7 && chVar.Z > 0.0f;
            if (view == null) {
                return;
            }
            a aVar = (a) view.getLayoutParams();
            int i15 = n8_a.j;
            if (i15 != 1 && i15 != 2 && z6 && chVar.s == 0 && z7 && chVar.t == 0) {
                z = false;
                measuredWidth = 0;
                i = -1;
                baseline = 0;
                iMax = 0;
            } else {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                chVar.I = iMakeMeasureSpec;
                chVar.J = iMakeMeasureSpec2;
                chVar.g = false;
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                int baseline2 = view.getBaseline();
                int i16 = chVar.v;
                int iMax2 = i16 > 0 ? Math.max(i16, measuredWidth2) : measuredWidth2;
                int i17 = chVar.w;
                if (i17 > 0) {
                    iMax2 = Math.min(i17, iMax2);
                }
                int i18 = chVar.y;
                iMax = i18 > 0 ? Math.max(i18, measuredHeight) : measuredHeight;
                boolean z12 = z9;
                int i19 = chVar.z;
                if (i19 > 0) {
                    iMax = Math.min(i19, iMax);
                }
                if (!e.x(constraintLayout.mOptimizationLevel, 1)) {
                    if (z10 && z8) {
                        iMax2 = (int) ((iMax * chVar.Z) + 0.5f);
                    } else if (z11 && z12) {
                        iMax = (int) ((iMax2 / chVar.Z) + 0.5f);
                    }
                }
                if (measuredWidth2 == iMax2 && measuredHeight == iMax) {
                    baseline = baseline2;
                    measuredWidth = iMax2;
                    z = false;
                } else {
                    if (measuredWidth2 != iMax2) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                    }
                    if (measuredHeight != iMax) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    chVar.I = iMakeMeasureSpec;
                    chVar.J = iMakeMeasureSpec2;
                    z = false;
                    chVar.g = false;
                    measuredWidth = view.getMeasuredWidth();
                    int measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    iMax = measuredHeight2;
                }
                i = -1;
            }
            boolean z13 = baseline != i ? true : z;
            if (measuredWidth != n8_a.c || iMax != n8_a.d) {
                z = true;
            }
            n8_a.i = z;
            boolean z14 = aVar.c0 ? true : z13;
            if (z14 && baseline != -1 && chVar.d0 != baseline) {
                n8_a.i = true;
            }
            n8_a.e = measuredWidth;
            n8_a.f = iMax;
            n8_a.h = z14;
            n8_a.g = baseline;
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new dh();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new b(this);
        init(null, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new dh();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new b(this);
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new dh();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new b(this);
        init(attributeSet, i, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new dh();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new b(this);
        init(attributeSet, i, i2);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((androidx.constraintlayout.widget.a) arrayList.get(i)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        int i5 = Integer.parseInt(strArrSplit[2]);
                        int i6 = (int) ((i3 / 1080.0f) * width);
                        int i7 = (int) ((i4 / 1920.0f) * height);
                        int i8 = (int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i6;
                        float f2 = i7;
                        float f3 = i6 + ((int) ((i5 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float f4 = i7 + i8;
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, f, f4, paint);
                        canvas.drawLine(f, f4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, f4, paint);
                        canvas.drawLine(f, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.mDirtyHierarchy = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public final ch getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (!(view.getLayoutParams() instanceof a)) {
            view.setLayoutParams(new a(view.getLayoutParams()));
            if (!(view.getLayoutParams() instanceof a)) {
                return null;
            }
        }
        return ((a) view.getLayoutParams()).q0;
    }

    public final void init(AttributeSet attributeSet, int i, int i2) {
        dh dhVar = this.mLayoutWidget;
        dhVar.i0 = this;
        b bVar = this.mMeasurer;
        dhVar.w0 = bVar;
        dhVar.u0.f = bVar;
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, ak.o, i, i2);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == 16) {
                    this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == 17) {
                    this.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == 14) {
                    this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == 15) {
                    this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == 113) {
                    this.mOptimizationLevel = typedArrayObtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == 56) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            new g(getContext(), resourceId);
                        } catch (Resources.NotFoundException unused) {
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        androidx.constraintlayout.widget.b bVar2 = new androidx.constraintlayout.widget.b();
                        this.mConstraintSet = bVar2;
                        bVar2.i(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        dhVar.F0 = this.mOptimizationLevel;
        oe0.p = dhVar.R(512);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) childAt.getLayoutParams();
            ch chVar = aVar.q0;
            if ((childAt.getVisibility() != 8 || aVar.d0 || aVar.e0 || zIsInEditMode) && !aVar.f0) {
                int iO = chVar.o();
                int iP = chVar.p();
                int iN = chVar.n() + iO;
                int i6 = chVar.i() + iP;
                childAt.layout(iO, iP, iN, i6);
                if ((childAt instanceof d) && (view = ((d) childAt).c) != null) {
                    view.setVisibility(0);
                    view.layout(iO, iP, iN, i6);
                }
            }
        }
        ArrayList arrayList = this.mConstraintHelpers;
        int size = arrayList.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                ((androidx.constraintlayout.widget.a) arrayList.get(i7)).getClass();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:229:0x041a  */
    /* JADX WARN: Code duplicated, block: B:232:0x0424  */
    /* JADX WARN: Code duplicated, block: B:304:0x0545  */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        dh dhVar;
        boolean z;
        boolean z2;
        int i3;
        dh dhVar2;
        boolean z3;
        int i4;
        int i5;
        ch chVar;
        vg.a aVar;
        ch chVar2;
        vg.a aVar2;
        ch chVar3;
        vg.a aVar3;
        ch chVar4;
        vg.a aVar4;
        vg.a aVar5;
        float f;
        int i6;
        int i7;
        int i8;
        float fAbs;
        int i9;
        int i10;
        boolean z4;
        boolean z5;
        ch chVar5;
        ch chVar6;
        ConstraintLayout constraintLayout = this;
        boolean z6 = true;
        int i11 = 0;
        if (!constraintLayout.mDirtyHierarchy) {
            int childCount = constraintLayout.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                if (constraintLayout.getChildAt(i12).isLayoutRequested()) {
                    constraintLayout.mDirtyHierarchy = true;
                    break;
                }
            }
        }
        boolean z7 = (constraintLayout.getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == constraintLayout.getLayoutDirection();
        dh dhVar3 = constraintLayout.mLayoutWidget;
        dhVar3.x0 = z7;
        if (constraintLayout.mDirtyHierarchy) {
            constraintLayout.mDirtyHierarchy = false;
            int childCount2 = constraintLayout.getChildCount();
            int i13 = 0;
            while (true) {
                if (i13 >= childCount2) {
                    z = false;
                    break;
                } else {
                    if (constraintLayout.getChildAt(i13).isLayoutRequested()) {
                        z = true;
                        break;
                    }
                    i13++;
                }
            }
            if (z) {
                boolean zIsInEditMode = constraintLayout.isInEditMode();
                int childCount3 = constraintLayout.getChildCount();
                for (int i14 = 0; i14 < childCount3; i14++) {
                    ch viewWidget = constraintLayout.getViewWidget(constraintLayout.getChildAt(i14));
                    if (viewWidget != null) {
                        viewWidget.z();
                    }
                }
                SparseArray sparseArray = constraintLayout.mChildrenByIds;
                if (zIsInEditMode) {
                    int i15 = 0;
                    while (i15 < childCount3) {
                        View childAt = constraintLayout.getChildAt(i15);
                        try {
                            String resourceName = constraintLayout.getResources().getResourceName(childAt.getId());
                            Integer numValueOf = Integer.valueOf(childAt.getId());
                            if (resourceName != null) {
                                z5 = z6;
                                try {
                                    if (constraintLayout.mDesignIds == null) {
                                        constraintLayout.mDesignIds = new HashMap();
                                    }
                                    int iIndexOf = resourceName.indexOf(InternalZipConstants.ZIP_FILE_SEPARATOR);
                                    chVar5 = null;
                                    try {
                                        constraintLayout.mDesignIds.put(iIndexOf != -1 ? resourceName.substring(iIndexOf + 1) : resourceName, numValueOf);
                                    } catch (Resources.NotFoundException unused) {
                                    }
                                } catch (Resources.NotFoundException unused2) {
                                }
                            } else {
                                z5 = z6;
                                chVar5 = null;
                            }
                            int iIndexOf2 = resourceName.indexOf(47);
                            if (iIndexOf2 != -1) {
                                resourceName = resourceName.substring(iIndexOf2 + 1);
                            }
                            int id = childAt.getId();
                            if (id != 0) {
                                View viewFindViewById = (View) sparseArray.get(id);
                                if (viewFindViewById == null && (viewFindViewById = constraintLayout.findViewById(id)) != null && viewFindViewById != constraintLayout && viewFindViewById.getParent() == constraintLayout) {
                                    constraintLayout.onViewAdded(viewFindViewById);
                                }
                                if (viewFindViewById != constraintLayout) {
                                    chVar6 = viewFindViewById == null ? chVar5 : ((a) viewFindViewById.getLayoutParams()).q0;
                                }
                                chVar6.k0 = resourceName;
                                i15++;
                                z6 = z5;
                            }
                            chVar6 = dhVar3;
                            chVar6.k0 = resourceName;
                        } catch (Resources.NotFoundException unused3) {
                            z5 = z6;
                        }
                        i15++;
                        z6 = z5;
                    }
                }
                boolean z8 = z6;
                Object obj = null;
                if (constraintLayout.mConstraintSetId != -1) {
                    for (int i16 = 0; i16 < childCount3; i16++) {
                        View childAt2 = constraintLayout.getChildAt(i16);
                        if (childAt2.getId() == constraintLayout.mConstraintSetId && (childAt2 instanceof c)) {
                            ((c) childAt2).getChildCount();
                            throw null;
                        }
                    }
                }
                androidx.constraintlayout.widget.b bVar = constraintLayout.mConstraintSet;
                if (bVar != null) {
                    bVar.c(constraintLayout);
                }
                dhVar3.s0.clear();
                ArrayList arrayList = constraintLayout.mConstraintHelpers;
                int size = arrayList.size();
                if (size > 0) {
                    int i17 = 0;
                    while (i17 < size) {
                        androidx.constraintlayout.widget.a aVar6 = (androidx.constraintlayout.widget.a) arrayList.get(i17);
                        if (aVar6.isInEditMode()) {
                            aVar6.setIds(aVar6.g);
                        }
                        h8 h8Var = aVar6.f;
                        if (h8Var == null) {
                            z4 = z;
                        } else {
                            h8Var.t0 = i11;
                            Arrays.fill(h8Var.s0, obj);
                            int i18 = i11;
                            while (i18 < aVar6.c) {
                                int i19 = aVar6.b[i18];
                                View view = (View) sparseArray.get(i19);
                                if (view == null) {
                                    Integer numValueOf2 = Integer.valueOf(i19);
                                    HashMap map = aVar6.n;
                                    String str = (String) map.get(numValueOf2);
                                    int i20 = aVar6.i(constraintLayout, str);
                                    if (i20 != 0) {
                                        aVar6.b[i18] = i20;
                                        map.put(Integer.valueOf(i20), str);
                                        view = (View) sparseArray.get(i20);
                                    }
                                }
                                View view2 = view;
                                if (view2 != null) {
                                    h8 h8Var2 = aVar6.f;
                                    ch viewWidget2 = constraintLayout.getViewWidget(view2);
                                    h8Var2.getClass();
                                    if (viewWidget2 != h8Var2 && viewWidget2 != null) {
                                        int i21 = h8Var2.t0 + 1;
                                        ch[] chVarArr = h8Var2.s0;
                                        if (i21 > chVarArr.length) {
                                            h8Var2.s0 = (ch[]) Arrays.copyOf(chVarArr, chVarArr.length * 2);
                                        }
                                        ch[] chVarArr2 = h8Var2.s0;
                                        int i22 = h8Var2.t0;
                                        chVarArr2[i22] = viewWidget2;
                                        h8Var2.t0 = i22 + 1;
                                    }
                                }
                                i18++;
                                z = z;
                            }
                            z4 = z;
                            aVar6.f.getClass();
                        }
                        i17++;
                        z = z4;
                        i11 = 0;
                        obj = null;
                    }
                }
                z2 = z;
                int i23 = 2;
                int i24 = 0;
                while (i24 < childCount3) {
                    View childAt3 = constraintLayout.getChildAt(i24);
                    if (childAt3 instanceof d) {
                        d dVar = (d) childAt3;
                        View viewFindViewById2 = constraintLayout.findViewById(0);
                        dVar.c = viewFindViewById2;
                        if (viewFindViewById2 != null) {
                            ((a) viewFindViewById2.getLayoutParams()).f0 = z8;
                            dVar.c.setVisibility(0);
                            dVar.setVisibility(0);
                        }
                    }
                    i24++;
                    z8 = true;
                }
                SparseArray sparseArray2 = constraintLayout.mTempMapIdToWidget;
                sparseArray2.clear();
                sparseArray2.put(0, dhVar3);
                sparseArray2.put(constraintLayout.getId(), dhVar3);
                for (int i25 = 0; i25 < childCount3; i25++) {
                    View childAt4 = constraintLayout.getChildAt(i25);
                    sparseArray2.put(childAt4.getId(), constraintLayout.getViewWidget(childAt4));
                }
                int i26 = 0;
                while (i26 < childCount3) {
                    View childAt5 = constraintLayout.getChildAt(i26);
                    ch viewWidget3 = constraintLayout.getViewWidget(childAt5);
                    if (viewWidget3 == null) {
                        i3 = i26;
                        dhVar2 = dhVar3;
                        z3 = zIsInEditMode;
                        i4 = childCount3;
                        i5 = i23;
                    } else {
                        a aVar7 = (a) childAt5.getLayoutParams();
                        dhVar3.s0.add(viewWidget3);
                        dh dhVar4 = viewWidget3.W;
                        if (dhVar4 != null) {
                            dhVar4.s0.remove(viewWidget3);
                            viewWidget3.z();
                        }
                        viewWidget3.W = dhVar3;
                        aVar7.a();
                        viewWidget3.j0 = childAt5.getVisibility();
                        if (aVar7.f0) {
                            viewWidget3.G = true;
                            viewWidget3.j0 = 8;
                        }
                        viewWidget3.i0 = childAt5;
                        if (childAt5 instanceof androidx.constraintlayout.widget.a) {
                            ((androidx.constraintlayout.widget.a) childAt5).k(viewWidget3, dhVar3.x0);
                        }
                        if (aVar7.d0) {
                            py pyVar = (py) viewWidget3;
                            int i27 = aVar7.n0;
                            int i28 = aVar7.o0;
                            float f2 = aVar7.p0;
                            if (f2 == -1.0f) {
                                i10 = -1;
                                if (i27 != -1) {
                                    if (i27 > -1) {
                                        pyVar.s0 = -1.0f;
                                        pyVar.t0 = i27;
                                        pyVar.u0 = i10;
                                    }
                                } else if (i28 != -1 && i28 > -1) {
                                    pyVar.s0 = -1.0f;
                                    pyVar.t0 = -1;
                                    pyVar.u0 = i28;
                                }
                            } else if (f2 > -1.0f) {
                                pyVar.s0 = f2;
                                i10 = -1;
                                pyVar.t0 = -1;
                                pyVar.u0 = i10;
                            }
                            i3 = i26;
                            dhVar2 = dhVar3;
                            z3 = zIsInEditMode;
                            i4 = childCount3;
                            i5 = i23;
                        } else {
                            int i29 = aVar7.g0;
                            int i30 = aVar7.h0;
                            int i31 = aVar7.i0;
                            int i32 = aVar7.j0;
                            int i33 = aVar7.k0;
                            i3 = i26;
                            int i34 = aVar7.l0;
                            z3 = zIsInEditMode;
                            float f3 = aVar7.m0;
                            i4 = childCount3;
                            int i35 = aVar7.p;
                            vg.a aVar8 = vg.a.d;
                            vg.a aVar9 = vg.a.b;
                            vg.a aVar10 = vg.a.f;
                            dhVar2 = dhVar3;
                            vg.a aVar11 = vg.a.c;
                            int i36 = -1;
                            if (i35 != -1) {
                                ch chVar7 = (ch) sparseArray2.get(i35);
                                if (chVar7 != null) {
                                    float f4 = aVar7.r;
                                    int i37 = aVar7.q;
                                    vg.a aVar12 = vg.a.i;
                                    viewWidget3.g(aVar12).a(chVar7.g(aVar12), i37, 0);
                                    viewWidget3.E = f4;
                                }
                            } else {
                                if (i29 != -1) {
                                    chVar = (ch) sparseArray2.get(i29);
                                    if (chVar != null) {
                                        aVar = aVar9;
                                        viewWidget3.g(aVar9).a(chVar.g(aVar), ((ViewGroup.MarginLayoutParams) aVar7).leftMargin, i33);
                                        i36 = -1;
                                    }
                                } else if (i30 != -1) {
                                    chVar = (ch) sparseArray2.get(i30);
                                    if (chVar != null) {
                                        aVar = aVar8;
                                        viewWidget3.g(aVar9).a(chVar.g(aVar), ((ViewGroup.MarginLayoutParams) aVar7).leftMargin, i33);
                                    }
                                    i36 = -1;
                                }
                                if (i31 != i36) {
                                    chVar2 = (ch) sparseArray2.get(i31);
                                    if (chVar2 != null) {
                                        aVar2 = aVar9;
                                        viewWidget3.g(aVar8).a(chVar2.g(aVar2), ((ViewGroup.MarginLayoutParams) aVar7).rightMargin, i34);
                                    }
                                } else if (i32 != i36 && (chVar2 = (ch) sparseArray2.get(i32)) != null) {
                                    aVar2 = aVar8;
                                    viewWidget3.g(aVar8).a(chVar2.g(aVar2), ((ViewGroup.MarginLayoutParams) aVar7).rightMargin, i34);
                                }
                                int i38 = aVar7.i;
                                if (i38 != -1) {
                                    chVar3 = (ch) sparseArray2.get(i38);
                                    if (chVar3 != null) {
                                        aVar3 = aVar11;
                                        viewWidget3.g(aVar11).a(chVar3.g(aVar3), ((ViewGroup.MarginLayoutParams) aVar7).topMargin, aVar7.x);
                                    }
                                } else {
                                    int i39 = aVar7.j;
                                    if (i39 != -1 && (chVar3 = (ch) sparseArray2.get(i39)) != null) {
                                        aVar3 = aVar10;
                                        viewWidget3.g(aVar11).a(chVar3.g(aVar3), ((ViewGroup.MarginLayoutParams) aVar7).topMargin, aVar7.x);
                                    }
                                }
                                int i40 = aVar7.k;
                                if (i40 != -1) {
                                    chVar4 = (ch) sparseArray2.get(i40);
                                    if (chVar4 != null) {
                                        aVar4 = aVar11;
                                        viewWidget3.g(aVar10).a(chVar4.g(aVar4), ((ViewGroup.MarginLayoutParams) aVar7).bottomMargin, aVar7.z);
                                    }
                                } else {
                                    int i41 = aVar7.l;
                                    if (i41 != -1 && (chVar4 = (ch) sparseArray2.get(i41)) != null) {
                                        aVar4 = aVar10;
                                        viewWidget3.g(aVar10).a(chVar4.g(aVar4), ((ViewGroup.MarginLayoutParams) aVar7).bottomMargin, aVar7.z);
                                    }
                                }
                                int i42 = aVar7.m;
                                if (i42 != -1) {
                                    aVar5 = vg.a.g;
                                } else {
                                    i42 = aVar7.n;
                                    if (i42 != -1) {
                                        aVar5 = aVar11;
                                    } else {
                                        i42 = aVar7.o;
                                        if (i42 != -1) {
                                            aVar5 = aVar10;
                                        } else {
                                            if (f3 >= 0.0f) {
                                                viewWidget3.g0 = f3;
                                            }
                                            f = aVar7.F;
                                            if (f >= 0.0f) {
                                                viewWidget3.h0 = f;
                                            }
                                        }
                                    }
                                }
                                View view3 = (View) sparseArray.get(i42);
                                ch chVar8 = (ch) sparseArray2.get(i42);
                                if (chVar8 != null && view3 != null && (view3.getLayoutParams() instanceof a)) {
                                    aVar7.c0 = true;
                                    vg.a aVar13 = vg.a.g;
                                    if (aVar5 == aVar13) {
                                        a aVar14 = (a) view3.getLayoutParams();
                                        aVar14.c0 = true;
                                        aVar14.q0.F = true;
                                    }
                                    viewWidget3.g(aVar13).a(chVar8.g(aVar5), aVar7.D, aVar7.C);
                                    viewWidget3.F = true;
                                    viewWidget3.g(aVar11).g();
                                    viewWidget3.g(aVar10).g();
                                }
                                if (f3 >= 0.0f) {
                                    viewWidget3.g0 = f3;
                                }
                                f = aVar7.F;
                                if (f >= 0.0f) {
                                    viewWidget3.h0 = f;
                                }
                            }
                            if (z3 && ((i9 = aVar7.T) != -1 || aVar7.U != -1)) {
                                int i43 = aVar7.U;
                                viewWidget3.b0 = i9;
                                viewWidget3.c0 = i43;
                            }
                            if (aVar7.a0) {
                                viewWidget3.H(1);
                                viewWidget3.J(((ViewGroup.MarginLayoutParams) aVar7).width);
                                if (((ViewGroup.MarginLayoutParams) aVar7).width == -2) {
                                    viewWidget3.H(i23);
                                }
                            } else if (((ViewGroup.MarginLayoutParams) aVar7).width == -1) {
                                if (aVar7.W) {
                                    viewWidget3.H(3);
                                } else {
                                    viewWidget3.H(4);
                                }
                                viewWidget3.g(aVar9).g = ((ViewGroup.MarginLayoutParams) aVar7).leftMargin;
                                viewWidget3.g(aVar8).g = ((ViewGroup.MarginLayoutParams) aVar7).rightMargin;
                            } else {
                                viewWidget3.H(3);
                                viewWidget3.J(0);
                            }
                            if (aVar7.b0) {
                                i6 = -1;
                                viewWidget3.I(1);
                                viewWidget3.G(((ViewGroup.MarginLayoutParams) aVar7).height);
                                if (((ViewGroup.MarginLayoutParams) aVar7).height == -2) {
                                    viewWidget3.I(2);
                                }
                            } else {
                                i6 = -1;
                                if (((ViewGroup.MarginLayoutParams) aVar7).height == -1) {
                                    if (aVar7.X) {
                                        viewWidget3.I(3);
                                    } else {
                                        viewWidget3.I(4);
                                    }
                                    viewWidget3.g(aVar11).g = ((ViewGroup.MarginLayoutParams) aVar7).topMargin;
                                    viewWidget3.g(aVar10).g = ((ViewGroup.MarginLayoutParams) aVar7).bottomMargin;
                                } else {
                                    viewWidget3.I(3);
                                    viewWidget3.G(0);
                                }
                            }
                            String str2 = aVar7.G;
                            if (str2 == null || str2.length() == 0) {
                                viewWidget3.Z = 0.0f;
                            } else {
                                int length = str2.length();
                                int iIndexOf3 = str2.indexOf(44);
                                if (iIndexOf3 <= 0 || iIndexOf3 >= length - 1) {
                                    i7 = i6;
                                    i8 = 0;
                                } else {
                                    String strSubstring = str2.substring(0, iIndexOf3);
                                    i7 = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : i6;
                                    i8 = iIndexOf3 + 1;
                                }
                                int iIndexOf4 = str2.indexOf(58);
                                if (iIndexOf4 < 0 || iIndexOf4 >= length - 1) {
                                    String strSubstring2 = str2.substring(i8);
                                    if (strSubstring2.length() > 0) {
                                        fAbs = Float.parseFloat(strSubstring2);
                                    } else {
                                        fAbs = 0.0f;
                                    }
                                } else {
                                    String strSubstring3 = str2.substring(i8, iIndexOf4);
                                    String strSubstring4 = str2.substring(iIndexOf4 + 1);
                                    if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                                        fAbs = 0.0f;
                                    } else {
                                        try {
                                            float f5 = Float.parseFloat(strSubstring3);
                                            float f6 = Float.parseFloat(strSubstring4);
                                            if (f5 <= 0.0f || f6 <= 0.0f) {
                                                fAbs = 0.0f;
                                            } else {
                                                fAbs = i7 == 1 ? Math.abs(f6 / f5) : Math.abs(f5 / f6);
                                            }
                                        } catch (NumberFormatException unused4) {
                                        }
                                    }
                                }
                                if (fAbs > 0.0f) {
                                    viewWidget3.Z = fAbs;
                                    viewWidget3.a0 = i7;
                                }
                            }
                            float f7 = aVar7.H;
                            float[] fArr = viewWidget3.n0;
                            fArr[0] = f7;
                            fArr[1] = aVar7.I;
                            viewWidget3.l0 = aVar7.J;
                            viewWidget3.m0 = aVar7.K;
                            int i44 = aVar7.Z;
                            if (i44 >= 0 && i44 <= 3) {
                                viewWidget3.r = i44;
                            }
                            int i45 = aVar7.L;
                            int i46 = aVar7.N;
                            int i47 = aVar7.P;
                            float f8 = aVar7.R;
                            viewWidget3.s = i45;
                            viewWidget3.v = i46;
                            if (i47 == Integer.MAX_VALUE) {
                                i47 = 0;
                            }
                            viewWidget3.w = i47;
                            viewWidget3.x = f8;
                            if (f8 > 0.0f && f8 < 1.0f && i45 == 0) {
                                viewWidget3.s = 2;
                            }
                            int i48 = aVar7.M;
                            int i49 = aVar7.O;
                            int i50 = aVar7.Q;
                            float f9 = aVar7.S;
                            viewWidget3.t = i48;
                            viewWidget3.y = i49;
                            if (i50 == Integer.MAX_VALUE) {
                                i50 = 0;
                            }
                            viewWidget3.z = i50;
                            viewWidget3.A = f9;
                            if (f9 <= 0.0f || f9 >= 1.0f || i48 != 0) {
                                i5 = 2;
                            } else {
                                i5 = 2;
                                viewWidget3.t = 2;
                            }
                        }
                    }
                    i26 = i3 + 1;
                    constraintLayout = this;
                    i23 = i5;
                    zIsInEditMode = z3;
                    childCount3 = i4;
                    dhVar3 = dhVar2;
                }
            } else {
                z2 = z;
            }
            dhVar = dhVar3;
            if (z2) {
                dhVar.t0.c(dhVar);
            }
        } else {
            dhVar = dhVar3;
        }
        resolveSystem(dhVar, this.mOptimizationLevel, i, i2);
        int iN = dhVar.n();
        int i51 = dhVar.i();
        boolean z9 = dhVar.G0;
        boolean z10 = dhVar.H0;
        b bVar2 = this.mMeasurer;
        int i52 = bVar2.e;
        int iResolveSizeAndState = View.resolveSizeAndState(iN + bVar2.d, i, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i51 + i52, i2, 0) & 16777215;
        int iMin = Math.min(this.mMaxWidth, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState2);
        if (z9) {
            iMin |= 16777216;
        }
        if (z10) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        ch viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof py)) {
            a aVar = (a) view.getLayoutParams();
            py pyVar = new py();
            aVar.q0 = pyVar;
            aVar.d0 = true;
            pyVar.M(aVar.V);
        }
        if (view instanceof androidx.constraintlayout.widget.a) {
            androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) view;
            aVar2.l();
            ((a) view.getLayoutParams()).e0 = true;
            ArrayList arrayList = this.mConstraintHelpers;
            if (!arrayList.contains(aVar2)) {
                arrayList.add(aVar2);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        ch viewWidget = getViewWidget(view);
        this.mLayoutWidget.s0.remove(viewWidget);
        viewWidget.z();
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.mDirtyHierarchy = true;
        super.requestLayout();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:102:0x01db A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:107:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:113:0x0204  */
    /* JADX WARN: Code duplicated, block: B:117:0x0211 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:18:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:197:0x0397  */
    /* JADX WARN: Code duplicated, block: B:199:0x039f  */
    /* JADX WARN: Code duplicated, block: B:19:0x00a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:202:0x03ab A[LOOP:11: B:200:0x03a5->B:202:0x03ab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:204:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:207:0x040a  */
    /* JADX WARN: Code duplicated, block: B:208:0x0411  */
    /* JADX WARN: Code duplicated, block: B:210:0x0415  */
    /* JADX WARN: Code duplicated, block: B:212:0x041f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:213:0x0421  */
    /* JADX WARN: Code duplicated, block: B:214:0x0423  */
    /* JADX WARN: Code duplicated, block: B:216:0x0426  */
    /* JADX WARN: Code duplicated, block: B:217:0x0428  */
    /* JADX WARN: Code duplicated, block: B:219:0x042d  */
    /* JADX WARN: Code duplicated, block: B:21:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:221:0x0433  */
    /* JADX WARN: Code duplicated, block: B:227:0x043c  */
    /* JADX WARN: Code duplicated, block: B:229:0x044d  */
    /* JADX WARN: Code duplicated, block: B:22:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:232:0x045a  */
    /* JADX WARN: Code duplicated, block: B:237:0x0464  */
    /* JADX WARN: Code duplicated, block: B:245:0x0478  */
    /* JADX WARN: Code duplicated, block: B:248:0x048b  */
    /* JADX WARN: Code duplicated, block: B:24:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:254:0x0497  */
    /* JADX WARN: Code duplicated, block: B:256:0x049a  */
    /* JADX WARN: Code duplicated, block: B:26:0x00be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:278:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:281:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:285:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:287:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:289:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:28:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:290:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:292:0x0515  */
    /* JADX WARN: Code duplicated, block: B:295:0x0524  */
    /* JADX WARN: Code duplicated, block: B:300:0x053e  */
    /* JADX WARN: Code duplicated, block: B:302:0x0541 A[LOOP:5: B:301:0x053f->B:302:0x0541, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:305:0x055b  */
    /* JADX WARN: Code duplicated, block: B:307:0x0560  */
    /* JADX WARN: Code duplicated, block: B:309:0x0567  */
    /* JADX WARN: Code duplicated, block: B:311:0x056b  */
    /* JADX WARN: Code duplicated, block: B:314:0x0571  */
    /* JADX WARN: Code duplicated, block: B:315:0x0573  */
    /* JADX WARN: Code duplicated, block: B:319:0x0593 A[LOOP:6: B:317:0x058d->B:319:0x0593, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x00cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:323:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:325:0x05a5  */
    /* JADX WARN: Code duplicated, block: B:328:0x05b6  */
    /* JADX WARN: Code duplicated, block: B:32:0x00cf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:330:0x05ba  */
    /* JADX WARN: Code duplicated, block: B:334:0x05c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:339:0x05da A[PHI: r21
      0x05da: PHI (r21v2 boolean) = (r21v1 boolean), (r21v4 boolean), (r21v4 boolean) binds: [B:330:0x05ba, B:332:0x05c5, B:338:0x05d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:342:0x05f5  */
    /* JADX WARN: Code duplicated, block: B:345:0x060a  */
    /* JADX WARN: Code duplicated, block: B:347:0x060f  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:352:0x062f  */
    /* JADX WARN: Code duplicated, block: B:354:0x0634  */
    /* JADX WARN: Code duplicated, block: B:35:0x00dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:360:0x0656  */
    /* JADX WARN: Code duplicated, block: B:363:0x065d  */
    /* JADX WARN: Code duplicated, block: B:367:0x067d A[LOOP:7: B:321:0x059d->B:367:0x067d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:370:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:397:0x04d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:402:0x059c A[EDGE_INSN: B:402:0x059c->B:320:0x059c BREAK  A[LOOP:6: B:317:0x058d->B:319:0x0593], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:404:0x068e A[EDGE_INSN: B:404:0x068e->B:368:0x068e BREAK  A[LOOP:7: B:321:0x059d->B:367:0x067d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:47:0x0105  */
    /* JADX WARN: Code duplicated, block: B:53:0x0138  */
    /* JADX WARN: Code duplicated, block: B:56:0x0141  */
    /* JADX WARN: Code duplicated, block: B:59:0x0167  */
    /* JADX WARN: Code duplicated, block: B:63:0x0170  */
    /* JADX WARN: Code duplicated, block: B:66:0x0175  */
    /* JADX WARN: Code duplicated, block: B:68:0x0178  */
    /* JADX WARN: Code duplicated, block: B:70:0x018d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0192  */
    /* JADX WARN: Code duplicated, block: B:75:0x0199  */
    /* JADX WARN: Code duplicated, block: B:76:0x019b  */
    /* JADX WARN: Code duplicated, block: B:78:0x019e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:82:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:85:0x01af A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:87:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d4 A[PHI: r2
      0x01d4: PHI (r2v3 boolean) = (r2v2 boolean), (r2v53 boolean) binds: [B:65:0x0173, B:370:0x01d4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x00d1, please report this as an issue */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void resolveSystem(dh dhVar, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int childCount;
        int iMax;
        int iMin;
        int i8;
        int iMax2;
        int iMin2;
        int i9;
        int iN;
        int[] iArr;
        cm cmVar;
        int i10;
        char c;
        int i11;
        int i12;
        m6 m6Var;
        b bVar;
        int size;
        int iN2;
        int i13;
        boolean zX;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i14;
        boolean zP;
        ArrayList arrayList;
        int size2;
        int[] iArr2;
        boolean z5;
        boolean z6;
        int iMax3;
        int iMax4;
        int i15;
        vg.a aVar;
        vg.a aVar2;
        int i16;
        int i17;
        boolean z7;
        ArrayList arrayList2;
        int i18;
        boolean z8;
        boolean z9;
        b bVar2;
        int i19;
        ch chVar;
        boolean z10;
        boolean z11;
        b bVar3;
        int i20;
        int i21;
        int iN3;
        int i22;
        boolean zA;
        int iN4;
        int i23;
        int size3;
        boolean zR;
        b bVar4;
        int i24;
        ConstraintLayout constraintLayout;
        int childCount2;
        ArrayList arrayList3;
        int i25;
        int size4;
        int i26;
        View childAt;
        d dVar;
        a aVar3;
        ch chVar2;
        ch chVar3;
        ch chVar4;
        ch chVar5;
        int i27;
        int iH;
        boolean z12;
        g10 g10Var;
        kd1 kd1Var;
        int iMin3;
        int iMin4;
        boolean z13;
        dh dhVar2;
        int i28;
        int i29;
        boolean z14;
        boolean z15;
        int i30;
        boolean z16;
        boolean z17;
        int i31;
        ch chVar6;
        int[] iArr3;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        int mode = View.MeasureSpec.getMode(i2);
        int size5 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size6 = View.MeasureSpec.getSize(i3);
        int iMax5 = Math.max(0, getPaddingTop());
        int iMax6 = Math.max(0, getPaddingBottom());
        int i32 = iMax5 + iMax6;
        int iMax7 = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax8 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        if (iMax8 > 0) {
            iMax7 = iMax8;
        }
        b bVar5 = this.mMeasurer;
        bVar5.b = iMax5;
        bVar5.c = iMax6;
        bVar5.d = iMax7;
        bVar5.e = i32;
        bVar5.f = i2;
        bVar5.g = i3;
        int iMax9 = Math.max(0, getPaddingStart());
        int iMax10 = Math.max(0, getPaddingEnd());
        if (iMax9 > 0 || iMax10 > 0) {
            if ((getContext().getApplicationInfo().flags & 4194304) == 0 || 1 != getLayoutDirection()) {
            }
            i4 = size5 - iMax7;
            i5 = size6 - i32;
            i6 = bVar5.e;
            i7 = bVar5.d;
            childCount = getChildCount();
            if (mode != Integer.MIN_VALUE) {
                if (childCount == 0) {
                    iMax = i4;
                }
                iMin = iMax;
                i8 = 2;
                if (mode2 != Integer.MIN_VALUE) {
                    if (childCount == 0) {
                        iMax2 = i5;
                    }
                    iMin2 = iMax2;
                    i9 = 2;
                    iN = dhVar.n();
                    iArr = dhVar.D;
                    cmVar = dhVar.u0;
                    i10 = iMin;
                    if (i10 == iN) {
                        cmVar.c = true;
                        c = 1;
                    } else {
                        cmVar.c = true;
                        c = 1;
                    }
                    dhVar.b0 = 0;
                    dhVar.c0 = 0;
                    iArr[0] = this.mMaxWidth - i7;
                    iArr[c] = this.mMaxHeight - i6;
                    dhVar.e0 = 0;
                    dhVar.f0 = 0;
                    dhVar.H(i8);
                    dhVar.J(i10);
                    dhVar.I(i9);
                    dhVar.G(iMin2);
                    i11 = this.mMinWidth - i7;
                    if (i11 < 0) {
                        i11 = 0;
                    }
                    dhVar.e0 = i11;
                    i12 = this.mMinHeight - i6;
                    if (i12 < 0) {
                        i12 = 0;
                    }
                    dhVar.f0 = i12;
                    dhVar.z0 = iMax10;
                    dhVar.A0 = iMax5;
                    m6Var = dhVar.t0;
                    m6Var.getClass();
                    bVar = dhVar.w0;
                    size = dhVar.s0.size();
                    iN2 = dhVar.n();
                    i13 = dhVar.i();
                    zX = e.x(i, 128);
                    if (zX) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        i31 = 0;
                        while (true) {
                            if (i31 < size) {
                                chVar6 = (ch) dhVar.s0.get(i31);
                                iArr3 = chVar6.V;
                                z18 = z;
                                if (iArr3[0] == 3) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (iArr3[1] == 3) {
                                    z20 = true;
                                } else {
                                    z20 = false;
                                }
                                if (z19) {
                                    z21 = false;
                                } else {
                                    z21 = false;
                                }
                                if (chVar6.u()) {
                                    i31++;
                                    z = z18;
                                } else {
                                    i31++;
                                    z = z18;
                                }
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                        }
                    } else {
                        z2 = z;
                    }
                    z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                    if (z3) {
                        iMin3 = Math.min(iArr[0], i4);
                        iMin4 = Math.min(iArr[1], i5);
                        if (mode == 1073741824) {
                            dhVar.J(iMin3);
                            cmVar.b = true;
                        }
                        if (mode2 == 1073741824) {
                            dhVar.G(iMin4);
                            cmVar.b = true;
                        }
                        if (mode == 1073741824) {
                            z4 = z3;
                            z13 = cmVar.b;
                            dhVar2 = cmVar.a;
                            if (z13) {
                                for (ch chVar7 : dhVar2.s0) {
                                    chVar7.f();
                                    chVar7.a = false;
                                    g10 g10Var2 = chVar7.d;
                                    g10Var2.e.j = false;
                                    g10Var2.g = false;
                                    g10Var2.n();
                                    kd1 kd1Var2 = chVar7.e;
                                    kd1Var2.e.j = false;
                                    kd1Var2.g = false;
                                    kd1Var2.m();
                                }
                                i28 = 0;
                                dhVar2.f();
                                dhVar2.a = false;
                                g10 g10Var3 = dhVar2.d;
                                g10Var3.e.j = false;
                                g10Var3.g = false;
                                g10Var3.n();
                                kd1 kd1Var3 = dhVar2.e;
                                kd1Var3.e.j = false;
                                kd1Var3.g = false;
                                kd1Var3.m();
                                cmVar.c();
                            } else {
                                i28 = 0;
                            }
                            cmVar.b(cmVar.d);
                            dhVar2.b0 = i28;
                            dhVar2.c0 = i28;
                            dhVar2.d.h.d(i28);
                            dhVar2.e.h.d(i28);
                            i29 = 1073741824;
                            if (mode == 1073741824) {
                                zP = dhVar.P(i28, zX);
                                i14 = 1;
                            } else {
                                i14 = 0;
                                zP = true;
                            }
                            if (mode2 == 1073741824) {
                                zP &= dhVar.P(1, zX);
                                i14++;
                            }
                        } else {
                            z4 = z3;
                            z13 = cmVar.b;
                            dhVar2 = cmVar.a;
                            if (z13) {
                                while (r0.hasNext()) {
                                    chVar7.f();
                                    chVar7.a = false;
                                    g10 g10Var4 = chVar7.d;
                                    g10Var4.e.j = false;
                                    g10Var4.g = false;
                                    g10Var4.n();
                                    kd1 kd1Var4 = chVar7.e;
                                    kd1Var4.e.j = false;
                                    kd1Var4.g = false;
                                    kd1Var4.m();
                                }
                                i28 = 0;
                                dhVar2.f();
                                dhVar2.a = false;
                                g10 g10Var5 = dhVar2.d;
                                g10Var5.e.j = false;
                                g10Var5.g = false;
                                g10Var5.n();
                                kd1 kd1Var5 = dhVar2.e;
                                kd1Var5.e.j = false;
                                kd1Var5.g = false;
                                kd1Var5.m();
                                cmVar.c();
                            } else {
                                i28 = 0;
                            }
                            cmVar.b(cmVar.d);
                            dhVar2.b0 = i28;
                            dhVar2.c0 = i28;
                            dhVar2.d.h.d(i28);
                            dhVar2.e.h.d(i28);
                            i29 = 1073741824;
                            if (mode == 1073741824) {
                                zP = dhVar.P(i28, zX);
                                i14 = 1;
                            } else {
                                i14 = 0;
                                zP = true;
                            }
                            if (mode2 == 1073741824) {
                                zP &= dhVar.P(1, zX);
                                i14++;
                            }
                        }
                        if (zP) {
                            if (mode == i29) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            if (mode2 == i29) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            dhVar.K(z14, z15);
                        }
                    } else {
                        z4 = z3;
                        i14 = 0;
                        zP = false;
                    }
                    if (zP) {
                    }
                    int i33 = dhVar.F0;
                    if (size > 0) {
                        size3 = dhVar.s0.size();
                        zR = dhVar.R(64);
                        bVar4 = dhVar.w0;
                        i24 = 0;
                        while (i24 < size3) {
                            chVar5 = (ch) dhVar.s0.get(i24);
                            if (chVar5 instanceof py) {
                                i27 = size3;
                            } else {
                                chVar5.getClass();
                                if (zR) {
                                }
                                iH = chVar5.h(0);
                                int iH2 = chVar5.h(1);
                                i27 = size3;
                                if (iH == 3) {
                                    z12 = false;
                                } else {
                                    z12 = false;
                                }
                                if (z12) {
                                }
                                if (z12) {
                                    m6Var.a(0, chVar5, bVar4);
                                }
                            }
                            i24++;
                            size3 = i27;
                        }
                        constraintLayout = bVar4.a;
                        childCount2 = constraintLayout.getChildCount();
                        arrayList3 = constraintLayout.mConstraintHelpers;
                        i25 = 0;
                        while (i25 < childCount2) {
                            childAt = constraintLayout.getChildAt(i25);
                            if (childAt instanceof d) {
                                dVar = (d) childAt;
                                if (dVar.c == null) {
                                    a aVar4 = (a) dVar.getLayoutParams();
                                    aVar3 = (a) dVar.c.getLayoutParams();
                                    chVar2 = aVar3.q0;
                                    chVar2.j0 = 0;
                                    chVar3 = aVar4.q0;
                                    if (chVar3.V[0] != 1) {
                                        chVar3.J(chVar2.n());
                                    }
                                    chVar4 = aVar4.q0;
                                    if (chVar4.V[1] != 1) {
                                        chVar4.G(aVar3.q0.i());
                                    }
                                    aVar3.q0.j0 = 8;
                                }
                            }
                            i25++;
                            constraintLayout = constraintLayout;
                        }
                        size4 = arrayList3.size();
                        if (size4 > 0) {
                            for (i26 = 0; i26 < size4; i26++) {
                                ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                            }
                        }
                    }
                    m6Var.c(dhVar);
                    arrayList = (ArrayList) m6Var.a;
                    size2 = arrayList.size();
                    if (size > 0) {
                        m6Var.b(dhVar, 0, iN2, i13);
                    }
                    if (size2 > 0) {
                        iArr2 = dhVar.V;
                        if (iArr2[0] == 2) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (iArr2[1] == 2) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        int iN5 = dhVar.n();
                        dh dhVar3 = (dh) m6Var.c;
                        iMax3 = Math.max(iN5, dhVar3.e0);
                        iMax4 = Math.max(dhVar.i(), dhVar3.f0);
                        i15 = 0;
                        while (true) {
                            aVar = vg.a.f;
                            aVar2 = vg.a.d;
                            if (i15 < size2) {
                                break;
                                break;
                            } else {
                                i15++;
                            }
                        }
                        i16 = 0;
                        while (i16 < 2) {
                            i17 = 0;
                            z7 = false;
                            while (i17 < size2) {
                                ArrayList arrayList4 = arrayList;
                                chVar = (ch) arrayList.get(i17);
                                int i34 = size2;
                                if (chVar instanceof h8) {
                                    z10 = z6;
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    z10 = z6;
                                    if (chVar.j0 == 8) {
                                        z11 = z5;
                                        bVar3 = bVar;
                                        i20 = i16;
                                        i21 = i17;
                                    } else {
                                        iN3 = chVar.n();
                                        i22 = chVar.i();
                                        z11 = z5;
                                        int i35 = chVar.d0;
                                        i21 = i17;
                                        zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                        bVar3 = bVar;
                                        iN4 = chVar.n();
                                        i20 = i16;
                                        i23 = chVar.i();
                                        if (iN4 != iN3) {
                                            chVar.J(iN4);
                                            if (z11) {
                                                iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                            }
                                            zA = true;
                                        }
                                        if (i23 != i22) {
                                            chVar.G(i23);
                                            if (z10) {
                                                iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                            }
                                            zA = true;
                                        }
                                        if (chVar.F) {
                                            z7 = zA;
                                        } else {
                                            z7 = zA;
                                        }
                                    }
                                }
                                i17 = i21 + 1;
                                arrayList = arrayList4;
                                size2 = i34;
                                z6 = z10;
                                z5 = z11;
                                bVar = bVar3;
                                i16 = i20;
                            }
                            arrayList2 = arrayList;
                            i18 = size2;
                            z8 = z6;
                            z9 = z5;
                            bVar2 = bVar;
                            i19 = i16;
                            if (z7) {
                                break;
                                break;
                            }
                            i16 = i19 + 1;
                            m6Var.b(dhVar, i16, iN2, i13);
                            arrayList = arrayList2;
                            size2 = i18;
                            z6 = z8;
                            z5 = z9;
                            bVar = bVar2;
                        }
                    }
                    dhVar.F0 = i33;
                    oe0.p = dhVar.R(512);
                }
                if (mode2 != 0) {
                    if (mode2 != 1073741824) {
                        iMin2 = Math.min(this.mMaxHeight - i6, i5);
                        i9 = 1;
                    }
                    iN = dhVar.n();
                    iArr = dhVar.D;
                    cmVar = dhVar.u0;
                    i10 = iMin;
                    if (i10 == iN) {
                        cmVar.c = true;
                        c = 1;
                    } else {
                        cmVar.c = true;
                        c = 1;
                    }
                    dhVar.b0 = 0;
                    dhVar.c0 = 0;
                    iArr[0] = this.mMaxWidth - i7;
                    iArr[c] = this.mMaxHeight - i6;
                    dhVar.e0 = 0;
                    dhVar.f0 = 0;
                    dhVar.H(i8);
                    dhVar.J(i10);
                    dhVar.I(i9);
                    dhVar.G(iMin2);
                    i11 = this.mMinWidth - i7;
                    if (i11 < 0) {
                        i11 = 0;
                    }
                    dhVar.e0 = i11;
                    i12 = this.mMinHeight - i6;
                    if (i12 < 0) {
                        i12 = 0;
                    }
                    dhVar.f0 = i12;
                    dhVar.z0 = iMax10;
                    dhVar.A0 = iMax5;
                    m6Var = dhVar.t0;
                    m6Var.getClass();
                    bVar = dhVar.w0;
                    size = dhVar.s0.size();
                    iN2 = dhVar.n();
                    i13 = dhVar.i();
                    zX = e.x(i, 128);
                    if (zX) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        i31 = 0;
                        while (true) {
                            if (i31 < size) {
                                chVar6 = (ch) dhVar.s0.get(i31);
                                iArr3 = chVar6.V;
                                z18 = z;
                                if (iArr3[0] == 3) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (iArr3[1] == 3) {
                                    z20 = true;
                                } else {
                                    z20 = false;
                                }
                                if (z19) {
                                    z21 = false;
                                } else {
                                    z21 = false;
                                }
                                if (chVar6.u()) {
                                    i31++;
                                    z = z18;
                                } else {
                                    i31++;
                                    z = z18;
                                }
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                        }
                    } else {
                        z2 = z;
                    }
                    z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                    if (z3) {
                        iMin3 = Math.min(iArr[0], i4);
                        iMin4 = Math.min(iArr[1], i5);
                        if (mode == 1073741824) {
                            dhVar.J(iMin3);
                            cmVar.b = true;
                        }
                        if (mode2 == 1073741824) {
                            dhVar.G(iMin4);
                            cmVar.b = true;
                        }
                        if (mode == 1073741824) {
                            z4 = z3;
                            z13 = cmVar.b;
                            dhVar2 = cmVar.a;
                            if (z13) {
                                while (r0.hasNext()) {
                                    chVar7.f();
                                    chVar7.a = false;
                                    g10 g10Var6 = chVar7.d;
                                    g10Var6.e.j = false;
                                    g10Var6.g = false;
                                    g10Var6.n();
                                    kd1 kd1Var6 = chVar7.e;
                                    kd1Var6.e.j = false;
                                    kd1Var6.g = false;
                                    kd1Var6.m();
                                }
                                i28 = 0;
                                dhVar2.f();
                                dhVar2.a = false;
                                g10 g10Var7 = dhVar2.d;
                                g10Var7.e.j = false;
                                g10Var7.g = false;
                                g10Var7.n();
                                kd1 kd1Var7 = dhVar2.e;
                                kd1Var7.e.j = false;
                                kd1Var7.g = false;
                                kd1Var7.m();
                                cmVar.c();
                            } else {
                                i28 = 0;
                            }
                            cmVar.b(cmVar.d);
                            dhVar2.b0 = i28;
                            dhVar2.c0 = i28;
                            dhVar2.d.h.d(i28);
                            dhVar2.e.h.d(i28);
                            i29 = 1073741824;
                            if (mode == 1073741824) {
                                zP = dhVar.P(i28, zX);
                                i14 = 1;
                            } else {
                                i14 = 0;
                                zP = true;
                            }
                            if (mode2 == 1073741824) {
                                zP &= dhVar.P(1, zX);
                                i14++;
                            }
                        } else {
                            z4 = z3;
                            z13 = cmVar.b;
                            dhVar2 = cmVar.a;
                            if (z13) {
                                while (r0.hasNext()) {
                                    chVar7.f();
                                    chVar7.a = false;
                                    g10 g10Var8 = chVar7.d;
                                    g10Var8.e.j = false;
                                    g10Var8.g = false;
                                    g10Var8.n();
                                    kd1 kd1Var8 = chVar7.e;
                                    kd1Var8.e.j = false;
                                    kd1Var8.g = false;
                                    kd1Var8.m();
                                }
                                i28 = 0;
                                dhVar2.f();
                                dhVar2.a = false;
                                g10 g10Var9 = dhVar2.d;
                                g10Var9.e.j = false;
                                g10Var9.g = false;
                                g10Var9.n();
                                kd1 kd1Var9 = dhVar2.e;
                                kd1Var9.e.j = false;
                                kd1Var9.g = false;
                                kd1Var9.m();
                                cmVar.c();
                            } else {
                                i28 = 0;
                            }
                            cmVar.b(cmVar.d);
                            dhVar2.b0 = i28;
                            dhVar2.c0 = i28;
                            dhVar2.d.h.d(i28);
                            dhVar2.e.h.d(i28);
                            i29 = 1073741824;
                            if (mode == 1073741824) {
                                zP = dhVar.P(i28, zX);
                                i14 = 1;
                            } else {
                                i14 = 0;
                                zP = true;
                            }
                            if (mode2 == 1073741824) {
                                zP &= dhVar.P(1, zX);
                                i14++;
                            }
                        }
                        if (zP) {
                            if (mode == i29) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            if (mode2 == i29) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            dhVar.K(z14, z15);
                        }
                    } else {
                        z4 = z3;
                        i14 = 0;
                        zP = false;
                    }
                    if (zP) {
                    }
                    int i36 = dhVar.F0;
                    if (size > 0) {
                        size3 = dhVar.s0.size();
                        zR = dhVar.R(64);
                        bVar4 = dhVar.w0;
                        i24 = 0;
                        while (i24 < size3) {
                            chVar5 = (ch) dhVar.s0.get(i24);
                            if (chVar5 instanceof py) {
                                i27 = size3;
                            } else {
                                chVar5.getClass();
                                if (zR) {
                                }
                                iH = chVar5.h(0);
                                int iH3 = chVar5.h(1);
                                i27 = size3;
                                if (iH == 3) {
                                    z12 = false;
                                } else {
                                    z12 = false;
                                }
                                if (z12) {
                                }
                                if (z12) {
                                    m6Var.a(0, chVar5, bVar4);
                                }
                            }
                            i24++;
                            size3 = i27;
                        }
                        constraintLayout = bVar4.a;
                        childCount2 = constraintLayout.getChildCount();
                        arrayList3 = constraintLayout.mConstraintHelpers;
                        i25 = 0;
                        while (i25 < childCount2) {
                            childAt = constraintLayout.getChildAt(i25);
                            if (childAt instanceof d) {
                                dVar = (d) childAt;
                                if (dVar.c == null) {
                                    a aVar5 = (a) dVar.getLayoutParams();
                                    aVar3 = (a) dVar.c.getLayoutParams();
                                    chVar2 = aVar3.q0;
                                    chVar2.j0 = 0;
                                    chVar3 = aVar5.q0;
                                    if (chVar3.V[0] != 1) {
                                        chVar3.J(chVar2.n());
                                    }
                                    chVar4 = aVar5.q0;
                                    if (chVar4.V[1] != 1) {
                                        chVar4.G(aVar3.q0.i());
                                    }
                                    aVar3.q0.j0 = 8;
                                }
                            }
                            i25++;
                            constraintLayout = constraintLayout;
                        }
                        size4 = arrayList3.size();
                        if (size4 > 0) {
                            while (i26 < size4) {
                                ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                            }
                        }
                    }
                    m6Var.c(dhVar);
                    arrayList = (ArrayList) m6Var.a;
                    size2 = arrayList.size();
                    if (size > 0) {
                        m6Var.b(dhVar, 0, iN2, i13);
                    }
                    if (size2 > 0) {
                        iArr2 = dhVar.V;
                        if (iArr2[0] == 2) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (iArr2[1] == 2) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        int iN6 = dhVar.n();
                        dh dhVar4 = (dh) m6Var.c;
                        iMax3 = Math.max(iN6, dhVar4.e0);
                        iMax4 = Math.max(dhVar.i(), dhVar4.f0);
                        i15 = 0;
                        while (true) {
                            aVar = vg.a.f;
                            aVar2 = vg.a.d;
                            if (i15 < size2) {
                                break;
                                break;
                            } else {
                                i15++;
                            }
                        }
                        i16 = 0;
                        while (i16 < 2) {
                            i17 = 0;
                            z7 = false;
                            while (i17 < size2) {
                                ArrayList arrayList5 = arrayList;
                                chVar = (ch) arrayList.get(i17);
                                int i37 = size2;
                                if (chVar instanceof h8) {
                                    z10 = z6;
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    z10 = z6;
                                    if (chVar.j0 == 8) {
                                        z11 = z5;
                                        bVar3 = bVar;
                                        i20 = i16;
                                        i21 = i17;
                                    } else {
                                        iN3 = chVar.n();
                                        i22 = chVar.i();
                                        z11 = z5;
                                        int i38 = chVar.d0;
                                        i21 = i17;
                                        zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                        bVar3 = bVar;
                                        iN4 = chVar.n();
                                        i20 = i16;
                                        i23 = chVar.i();
                                        if (iN4 != iN3) {
                                            chVar.J(iN4);
                                            if (z11) {
                                                iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                            }
                                            zA = true;
                                        }
                                        if (i23 != i22) {
                                            chVar.G(i23);
                                            if (z10) {
                                                iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                            }
                                            zA = true;
                                        }
                                        if (chVar.F) {
                                            z7 = zA;
                                        } else {
                                            z7 = zA;
                                        }
                                    }
                                }
                                i17 = i21 + 1;
                                arrayList = arrayList5;
                                size2 = i37;
                                z6 = z10;
                                z5 = z11;
                                bVar = bVar3;
                                i16 = i20;
                            }
                            arrayList2 = arrayList;
                            i18 = size2;
                            z8 = z6;
                            z9 = z5;
                            bVar2 = bVar;
                            i19 = i16;
                            if (z7) {
                                break;
                                break;
                            }
                            i16 = i19 + 1;
                            m6Var.b(dhVar, i16, iN2, i13);
                            arrayList = arrayList2;
                            size2 = i18;
                            z6 = z8;
                            z5 = z9;
                            bVar = bVar2;
                        }
                    }
                    dhVar.F0 = i36;
                    oe0.p = dhVar.R(512);
                }
                if (childCount != 0) {
                }
                iMin2 = 0;
                iN = dhVar.n();
                iArr = dhVar.D;
                cmVar = dhVar.u0;
                i10 = iMin;
                if (i10 == iN) {
                    cmVar.c = true;
                    c = 1;
                } else {
                    cmVar.c = true;
                    c = 1;
                }
                dhVar.b0 = 0;
                dhVar.c0 = 0;
                iArr[0] = this.mMaxWidth - i7;
                iArr[c] = this.mMaxHeight - i6;
                dhVar.e0 = 0;
                dhVar.f0 = 0;
                dhVar.H(i8);
                dhVar.J(i10);
                dhVar.I(i9);
                dhVar.G(iMin2);
                i11 = this.mMinWidth - i7;
                if (i11 < 0) {
                    i11 = 0;
                }
                dhVar.e0 = i11;
                i12 = this.mMinHeight - i6;
                if (i12 < 0) {
                    i12 = 0;
                }
                dhVar.f0 = i12;
                dhVar.z0 = iMax10;
                dhVar.A0 = iMax5;
                m6Var = dhVar.t0;
                m6Var.getClass();
                bVar = dhVar.w0;
                size = dhVar.s0.size();
                iN2 = dhVar.n();
                i13 = dhVar.i();
                zX = e.x(i, 128);
                if (zX) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            chVar6 = (ch) dhVar.s0.get(i31);
                            iArr3 = chVar6.V;
                            z18 = z;
                            if (iArr3[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr3[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z19) {
                                z21 = false;
                            } else {
                                z21 = false;
                            }
                            if (chVar6.u()) {
                                i31++;
                                z = z18;
                            } else {
                                i31++;
                                z = z18;
                            }
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                    }
                } else {
                    z2 = z;
                }
                z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                if (z3) {
                    iMin3 = Math.min(iArr[0], i4);
                    iMin4 = Math.min(iArr[1], i5);
                    if (mode == 1073741824) {
                        dhVar.J(iMin3);
                        cmVar.b = true;
                    }
                    if (mode2 == 1073741824) {
                        dhVar.G(iMin4);
                        cmVar.b = true;
                    }
                    if (mode == 1073741824) {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var10 = chVar7.d;
                                g10Var10.e.j = false;
                                g10Var10.g = false;
                                g10Var10.n();
                                kd1 kd1Var10 = chVar7.e;
                                kd1Var10.e.j = false;
                                kd1Var10.g = false;
                                kd1Var10.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var11 = dhVar2.d;
                            g10Var11.e.j = false;
                            g10Var11.g = false;
                            g10Var11.n();
                            kd1 kd1Var11 = dhVar2.e;
                            kd1Var11.e.j = false;
                            kd1Var11.g = false;
                            kd1Var11.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    } else {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var12 = chVar7.d;
                                g10Var12.e.j = false;
                                g10Var12.g = false;
                                g10Var12.n();
                                kd1 kd1Var12 = chVar7.e;
                                kd1Var12.e.j = false;
                                kd1Var12.g = false;
                                kd1Var12.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var13 = dhVar2.d;
                            g10Var13.e.j = false;
                            g10Var13.g = false;
                            g10Var13.n();
                            kd1 kd1Var13 = dhVar2.e;
                            kd1Var13.e.j = false;
                            kd1Var13.g = false;
                            kd1Var13.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    }
                    if (zP) {
                        if (mode == i29) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i29) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        dhVar.K(z14, z15);
                    }
                } else {
                    z4 = z3;
                    i14 = 0;
                    zP = false;
                }
                if (zP) {
                }
                int i39 = dhVar.F0;
                if (size > 0) {
                    size3 = dhVar.s0.size();
                    zR = dhVar.R(64);
                    bVar4 = dhVar.w0;
                    i24 = 0;
                    while (i24 < size3) {
                        chVar5 = (ch) dhVar.s0.get(i24);
                        if (chVar5 instanceof py) {
                            i27 = size3;
                        } else {
                            chVar5.getClass();
                            if (zR) {
                            }
                            iH = chVar5.h(0);
                            int iH4 = chVar5.h(1);
                            i27 = size3;
                            if (iH == 3) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                            }
                            if (z12) {
                                m6Var.a(0, chVar5, bVar4);
                            }
                        }
                        i24++;
                        size3 = i27;
                    }
                    constraintLayout = bVar4.a;
                    childCount2 = constraintLayout.getChildCount();
                    arrayList3 = constraintLayout.mConstraintHelpers;
                    i25 = 0;
                    while (i25 < childCount2) {
                        childAt = constraintLayout.getChildAt(i25);
                        if (childAt instanceof d) {
                            dVar = (d) childAt;
                            if (dVar.c == null) {
                                a aVar6 = (a) dVar.getLayoutParams();
                                aVar3 = (a) dVar.c.getLayoutParams();
                                chVar2 = aVar3.q0;
                                chVar2.j0 = 0;
                                chVar3 = aVar6.q0;
                                if (chVar3.V[0] != 1) {
                                    chVar3.J(chVar2.n());
                                }
                                chVar4 = aVar6.q0;
                                if (chVar4.V[1] != 1) {
                                    chVar4.G(aVar3.q0.i());
                                }
                                aVar3.q0.j0 = 8;
                            }
                        }
                        i25++;
                        constraintLayout = constraintLayout;
                    }
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i26 < size4) {
                            ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                        }
                    }
                }
                m6Var.c(dhVar);
                arrayList = (ArrayList) m6Var.a;
                size2 = arrayList.size();
                if (size > 0) {
                    m6Var.b(dhVar, 0, iN2, i13);
                }
                if (size2 > 0) {
                    iArr2 = dhVar.V;
                    if (iArr2[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr2[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int iN7 = dhVar.n();
                    dh dhVar5 = (dh) m6Var.c;
                    iMax3 = Math.max(iN7, dhVar5.e0);
                    iMax4 = Math.max(dhVar.i(), dhVar5.f0);
                    i15 = 0;
                    while (true) {
                        aVar = vg.a.f;
                        aVar2 = vg.a.d;
                        if (i15 < size2) {
                            break;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    i16 = 0;
                    while (i16 < 2) {
                        i17 = 0;
                        z7 = false;
                        while (i17 < size2) {
                            ArrayList arrayList6 = arrayList;
                            chVar = (ch) arrayList.get(i17);
                            int i310 = size2;
                            if (chVar instanceof h8) {
                                z10 = z6;
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                z10 = z6;
                                if (chVar.j0 == 8) {
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    iN3 = chVar.n();
                                    i22 = chVar.i();
                                    z11 = z5;
                                    int i311 = chVar.d0;
                                    i21 = i17;
                                    zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                    bVar3 = bVar;
                                    iN4 = chVar.n();
                                    i20 = i16;
                                    i23 = chVar.i();
                                    if (iN4 != iN3) {
                                        chVar.J(iN4);
                                        if (z11) {
                                            iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                        }
                                        zA = true;
                                    }
                                    if (i23 != i22) {
                                        chVar.G(i23);
                                        if (z10) {
                                            iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                        }
                                        zA = true;
                                    }
                                    if (chVar.F) {
                                        z7 = zA;
                                    } else {
                                        z7 = zA;
                                    }
                                }
                            }
                            i17 = i21 + 1;
                            arrayList = arrayList6;
                            size2 = i310;
                            z6 = z10;
                            z5 = z11;
                            bVar = bVar3;
                            i16 = i20;
                        }
                        arrayList2 = arrayList;
                        i18 = size2;
                        z8 = z6;
                        z9 = z5;
                        bVar2 = bVar;
                        i19 = i16;
                        if (z7) {
                            break;
                            break;
                        }
                        i16 = i19 + 1;
                        m6Var.b(dhVar, i16, iN2, i13);
                        arrayList = arrayList2;
                        size2 = i18;
                        z6 = z8;
                        z5 = z9;
                        bVar = bVar2;
                    }
                }
                dhVar.F0 = i39;
                oe0.p = dhVar.R(512);
                iMax2 = Math.max(0, this.mMinHeight);
                iMin2 = iMax2;
                i9 = 2;
                iN = dhVar.n();
                iArr = dhVar.D;
                cmVar = dhVar.u0;
                i10 = iMin;
                if (i10 == iN) {
                    cmVar.c = true;
                    c = 1;
                } else {
                    cmVar.c = true;
                    c = 1;
                }
                dhVar.b0 = 0;
                dhVar.c0 = 0;
                iArr[0] = this.mMaxWidth - i7;
                iArr[c] = this.mMaxHeight - i6;
                dhVar.e0 = 0;
                dhVar.f0 = 0;
                dhVar.H(i8);
                dhVar.J(i10);
                dhVar.I(i9);
                dhVar.G(iMin2);
                i11 = this.mMinWidth - i7;
                if (i11 < 0) {
                    i11 = 0;
                }
                dhVar.e0 = i11;
                i12 = this.mMinHeight - i6;
                if (i12 < 0) {
                    i12 = 0;
                }
                dhVar.f0 = i12;
                dhVar.z0 = iMax10;
                dhVar.A0 = iMax5;
                m6Var = dhVar.t0;
                m6Var.getClass();
                bVar = dhVar.w0;
                size = dhVar.s0.size();
                iN2 = dhVar.n();
                i13 = dhVar.i();
                zX = e.x(i, 128);
                if (zX) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            chVar6 = (ch) dhVar.s0.get(i31);
                            iArr3 = chVar6.V;
                            z18 = z;
                            if (iArr3[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr3[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z19) {
                                z21 = false;
                            } else {
                                z21 = false;
                            }
                            if (chVar6.u()) {
                                i31++;
                                z = z18;
                            } else {
                                i31++;
                                z = z18;
                            }
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                    }
                } else {
                    z2 = z;
                }
                z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                if (z3) {
                    iMin3 = Math.min(iArr[0], i4);
                    iMin4 = Math.min(iArr[1], i5);
                    if (mode == 1073741824) {
                        dhVar.J(iMin3);
                        cmVar.b = true;
                    }
                    if (mode2 == 1073741824) {
                        dhVar.G(iMin4);
                        cmVar.b = true;
                    }
                    if (mode == 1073741824) {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var14 = chVar7.d;
                                g10Var14.e.j = false;
                                g10Var14.g = false;
                                g10Var14.n();
                                kd1 kd1Var14 = chVar7.e;
                                kd1Var14.e.j = false;
                                kd1Var14.g = false;
                                kd1Var14.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var15 = dhVar2.d;
                            g10Var15.e.j = false;
                            g10Var15.g = false;
                            g10Var15.n();
                            kd1 kd1Var15 = dhVar2.e;
                            kd1Var15.e.j = false;
                            kd1Var15.g = false;
                            kd1Var15.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    } else {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var16 = chVar7.d;
                                g10Var16.e.j = false;
                                g10Var16.g = false;
                                g10Var16.n();
                                kd1 kd1Var16 = chVar7.e;
                                kd1Var16.e.j = false;
                                kd1Var16.g = false;
                                kd1Var16.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var17 = dhVar2.d;
                            g10Var17.e.j = false;
                            g10Var17.g = false;
                            g10Var17.n();
                            kd1 kd1Var17 = dhVar2.e;
                            kd1Var17.e.j = false;
                            kd1Var17.g = false;
                            kd1Var17.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    }
                    if (zP) {
                        if (mode == i29) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i29) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        dhVar.K(z14, z15);
                    }
                } else {
                    z4 = z3;
                    i14 = 0;
                    zP = false;
                }
                if (zP) {
                }
                int i312 = dhVar.F0;
                if (size > 0) {
                    size3 = dhVar.s0.size();
                    zR = dhVar.R(64);
                    bVar4 = dhVar.w0;
                    i24 = 0;
                    while (i24 < size3) {
                        chVar5 = (ch) dhVar.s0.get(i24);
                        if (chVar5 instanceof py) {
                            i27 = size3;
                        } else {
                            chVar5.getClass();
                            if (zR) {
                            }
                            iH = chVar5.h(0);
                            int iH5 = chVar5.h(1);
                            i27 = size3;
                            if (iH == 3) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                            }
                            if (z12) {
                                m6Var.a(0, chVar5, bVar4);
                            }
                        }
                        i24++;
                        size3 = i27;
                    }
                    constraintLayout = bVar4.a;
                    childCount2 = constraintLayout.getChildCount();
                    arrayList3 = constraintLayout.mConstraintHelpers;
                    i25 = 0;
                    while (i25 < childCount2) {
                        childAt = constraintLayout.getChildAt(i25);
                        if (childAt instanceof d) {
                            dVar = (d) childAt;
                            if (dVar.c == null) {
                                a aVar7 = (a) dVar.getLayoutParams();
                                aVar3 = (a) dVar.c.getLayoutParams();
                                chVar2 = aVar3.q0;
                                chVar2.j0 = 0;
                                chVar3 = aVar7.q0;
                                if (chVar3.V[0] != 1) {
                                    chVar3.J(chVar2.n());
                                }
                                chVar4 = aVar7.q0;
                                if (chVar4.V[1] != 1) {
                                    chVar4.G(aVar3.q0.i());
                                }
                                aVar3.q0.j0 = 8;
                            }
                        }
                        i25++;
                        constraintLayout = constraintLayout;
                    }
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i26 < size4) {
                            ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                        }
                    }
                }
                m6Var.c(dhVar);
                arrayList = (ArrayList) m6Var.a;
                size2 = arrayList.size();
                if (size > 0) {
                    m6Var.b(dhVar, 0, iN2, i13);
                }
                if (size2 > 0) {
                    iArr2 = dhVar.V;
                    if (iArr2[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr2[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int iN8 = dhVar.n();
                    dh dhVar6 = (dh) m6Var.c;
                    iMax3 = Math.max(iN8, dhVar6.e0);
                    iMax4 = Math.max(dhVar.i(), dhVar6.f0);
                    i15 = 0;
                    while (true) {
                        aVar = vg.a.f;
                        aVar2 = vg.a.d;
                        if (i15 < size2) {
                            break;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    i16 = 0;
                    while (i16 < 2) {
                        i17 = 0;
                        z7 = false;
                        while (i17 < size2) {
                            ArrayList arrayList7 = arrayList;
                            chVar = (ch) arrayList.get(i17);
                            int i313 = size2;
                            if (chVar instanceof h8) {
                                z10 = z6;
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                z10 = z6;
                                if (chVar.j0 == 8) {
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    iN3 = chVar.n();
                                    i22 = chVar.i();
                                    z11 = z5;
                                    int i314 = chVar.d0;
                                    i21 = i17;
                                    zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                    bVar3 = bVar;
                                    iN4 = chVar.n();
                                    i20 = i16;
                                    i23 = chVar.i();
                                    if (iN4 != iN3) {
                                        chVar.J(iN4);
                                        if (z11) {
                                            iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                        }
                                        zA = true;
                                    }
                                    if (i23 != i22) {
                                        chVar.G(i23);
                                        if (z10) {
                                            iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                        }
                                        zA = true;
                                    }
                                    if (chVar.F) {
                                        z7 = zA;
                                    } else {
                                        z7 = zA;
                                    }
                                }
                            }
                            i17 = i21 + 1;
                            arrayList = arrayList7;
                            size2 = i313;
                            z6 = z10;
                            z5 = z11;
                            bVar = bVar3;
                            i16 = i20;
                        }
                        arrayList2 = arrayList;
                        i18 = size2;
                        z8 = z6;
                        z9 = z5;
                        bVar2 = bVar;
                        i19 = i16;
                        if (z7) {
                            break;
                            break;
                        }
                        i16 = i19 + 1;
                        m6Var.b(dhVar, i16, iN2, i13);
                        arrayList = arrayList2;
                        size2 = i18;
                        z6 = z8;
                        z5 = z9;
                        bVar = bVar2;
                    }
                }
                dhVar.F0 = i312;
                oe0.p = dhVar.R(512);
            }
            if (mode != 0) {
                if (mode != 1073741824) {
                    iMin = Math.min(this.mMaxWidth - i7, i4);
                    i8 = 1;
                }
                if (mode2 != Integer.MIN_VALUE) {
                    if (childCount == 0) {
                        iMax2 = i5;
                    }
                    iMin2 = iMax2;
                    i9 = 2;
                    iN = dhVar.n();
                    iArr = dhVar.D;
                    cmVar = dhVar.u0;
                    i10 = iMin;
                    if (i10 == iN) {
                        cmVar.c = true;
                        c = 1;
                    } else {
                        cmVar.c = true;
                        c = 1;
                    }
                    dhVar.b0 = 0;
                    dhVar.c0 = 0;
                    iArr[0] = this.mMaxWidth - i7;
                    iArr[c] = this.mMaxHeight - i6;
                    dhVar.e0 = 0;
                    dhVar.f0 = 0;
                    dhVar.H(i8);
                    dhVar.J(i10);
                    dhVar.I(i9);
                    dhVar.G(iMin2);
                    i11 = this.mMinWidth - i7;
                    if (i11 < 0) {
                        i11 = 0;
                    }
                    dhVar.e0 = i11;
                    i12 = this.mMinHeight - i6;
                    if (i12 < 0) {
                        i12 = 0;
                    }
                    dhVar.f0 = i12;
                    dhVar.z0 = iMax10;
                    dhVar.A0 = iMax5;
                    m6Var = dhVar.t0;
                    m6Var.getClass();
                    bVar = dhVar.w0;
                    size = dhVar.s0.size();
                    iN2 = dhVar.n();
                    i13 = dhVar.i();
                    zX = e.x(i, 128);
                    if (zX) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        i31 = 0;
                        while (true) {
                            if (i31 < size) {
                                chVar6 = (ch) dhVar.s0.get(i31);
                                iArr3 = chVar6.V;
                                z18 = z;
                                if (iArr3[0] == 3) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (iArr3[1] == 3) {
                                    z20 = true;
                                } else {
                                    z20 = false;
                                }
                                if (z19) {
                                    z21 = false;
                                } else {
                                    z21 = false;
                                }
                                if (chVar6.u()) {
                                    i31++;
                                    z = z18;
                                } else {
                                    i31++;
                                    z = z18;
                                }
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                        }
                    } else {
                        z2 = z;
                    }
                    z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                    if (z3) {
                        iMin3 = Math.min(iArr[0], i4);
                        iMin4 = Math.min(iArr[1], i5);
                        if (mode == 1073741824) {
                            dhVar.J(iMin3);
                            cmVar.b = true;
                        }
                        if (mode2 == 1073741824) {
                            dhVar.G(iMin4);
                            cmVar.b = true;
                        }
                        if (mode == 1073741824) {
                            z4 = z3;
                            z13 = cmVar.b;
                            dhVar2 = cmVar.a;
                            if (z13) {
                                while (r0.hasNext()) {
                                    chVar7.f();
                                    chVar7.a = false;
                                    g10 g10Var18 = chVar7.d;
                                    g10Var18.e.j = false;
                                    g10Var18.g = false;
                                    g10Var18.n();
                                    kd1 kd1Var18 = chVar7.e;
                                    kd1Var18.e.j = false;
                                    kd1Var18.g = false;
                                    kd1Var18.m();
                                }
                                i28 = 0;
                                dhVar2.f();
                                dhVar2.a = false;
                                g10 g10Var19 = dhVar2.d;
                                g10Var19.e.j = false;
                                g10Var19.g = false;
                                g10Var19.n();
                                kd1 kd1Var19 = dhVar2.e;
                                kd1Var19.e.j = false;
                                kd1Var19.g = false;
                                kd1Var19.m();
                                cmVar.c();
                            } else {
                                i28 = 0;
                            }
                            cmVar.b(cmVar.d);
                            dhVar2.b0 = i28;
                            dhVar2.c0 = i28;
                            dhVar2.d.h.d(i28);
                            dhVar2.e.h.d(i28);
                            i29 = 1073741824;
                            if (mode == 1073741824) {
                                zP = dhVar.P(i28, zX);
                                i14 = 1;
                            } else {
                                i14 = 0;
                                zP = true;
                            }
                            if (mode2 == 1073741824) {
                                zP &= dhVar.P(1, zX);
                                i14++;
                            }
                        } else {
                            z4 = z3;
                            z13 = cmVar.b;
                            dhVar2 = cmVar.a;
                            if (z13) {
                                while (r0.hasNext()) {
                                    chVar7.f();
                                    chVar7.a = false;
                                    g10 g10Var110 = chVar7.d;
                                    g10Var110.e.j = false;
                                    g10Var110.g = false;
                                    g10Var110.n();
                                    kd1 kd1Var110 = chVar7.e;
                                    kd1Var110.e.j = false;
                                    kd1Var110.g = false;
                                    kd1Var110.m();
                                }
                                i28 = 0;
                                dhVar2.f();
                                dhVar2.a = false;
                                g10 g10Var111 = dhVar2.d;
                                g10Var111.e.j = false;
                                g10Var111.g = false;
                                g10Var111.n();
                                kd1 kd1Var111 = dhVar2.e;
                                kd1Var111.e.j = false;
                                kd1Var111.g = false;
                                kd1Var111.m();
                                cmVar.c();
                            } else {
                                i28 = 0;
                            }
                            cmVar.b(cmVar.d);
                            dhVar2.b0 = i28;
                            dhVar2.c0 = i28;
                            dhVar2.d.h.d(i28);
                            dhVar2.e.h.d(i28);
                            i29 = 1073741824;
                            if (mode == 1073741824) {
                                zP = dhVar.P(i28, zX);
                                i14 = 1;
                            } else {
                                i14 = 0;
                                zP = true;
                            }
                            if (mode2 == 1073741824) {
                                zP &= dhVar.P(1, zX);
                                i14++;
                            }
                        }
                        if (zP) {
                            if (mode == i29) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            if (mode2 == i29) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            dhVar.K(z14, z15);
                        }
                    } else {
                        z4 = z3;
                        i14 = 0;
                        zP = false;
                    }
                    if (zP) {
                    }
                    int i315 = dhVar.F0;
                    if (size > 0) {
                        size3 = dhVar.s0.size();
                        zR = dhVar.R(64);
                        bVar4 = dhVar.w0;
                        i24 = 0;
                        while (i24 < size3) {
                            chVar5 = (ch) dhVar.s0.get(i24);
                            if (chVar5 instanceof py) {
                                i27 = size3;
                            } else {
                                chVar5.getClass();
                                if (zR) {
                                }
                                iH = chVar5.h(0);
                                int iH6 = chVar5.h(1);
                                i27 = size3;
                                if (iH == 3) {
                                    z12 = false;
                                } else {
                                    z12 = false;
                                }
                                if (z12) {
                                }
                                if (z12) {
                                    m6Var.a(0, chVar5, bVar4);
                                }
                            }
                            i24++;
                            size3 = i27;
                        }
                        constraintLayout = bVar4.a;
                        childCount2 = constraintLayout.getChildCount();
                        arrayList3 = constraintLayout.mConstraintHelpers;
                        i25 = 0;
                        while (i25 < childCount2) {
                            childAt = constraintLayout.getChildAt(i25);
                            if (childAt instanceof d) {
                                dVar = (d) childAt;
                                if (dVar.c == null) {
                                    a aVar8 = (a) dVar.getLayoutParams();
                                    aVar3 = (a) dVar.c.getLayoutParams();
                                    chVar2 = aVar3.q0;
                                    chVar2.j0 = 0;
                                    chVar3 = aVar8.q0;
                                    if (chVar3.V[0] != 1) {
                                        chVar3.J(chVar2.n());
                                    }
                                    chVar4 = aVar8.q0;
                                    if (chVar4.V[1] != 1) {
                                        chVar4.G(aVar3.q0.i());
                                    }
                                    aVar3.q0.j0 = 8;
                                }
                            }
                            i25++;
                            constraintLayout = constraintLayout;
                        }
                        size4 = arrayList3.size();
                        if (size4 > 0) {
                            while (i26 < size4) {
                                ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                            }
                        }
                    }
                    m6Var.c(dhVar);
                    arrayList = (ArrayList) m6Var.a;
                    size2 = arrayList.size();
                    if (size > 0) {
                        m6Var.b(dhVar, 0, iN2, i13);
                    }
                    if (size2 > 0) {
                        iArr2 = dhVar.V;
                        if (iArr2[0] == 2) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (iArr2[1] == 2) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        int iN9 = dhVar.n();
                        dh dhVar7 = (dh) m6Var.c;
                        iMax3 = Math.max(iN9, dhVar7.e0);
                        iMax4 = Math.max(dhVar.i(), dhVar7.f0);
                        i15 = 0;
                        while (true) {
                            aVar = vg.a.f;
                            aVar2 = vg.a.d;
                            if (i15 < size2) {
                                break;
                                break;
                            } else {
                                i15++;
                            }
                        }
                        i16 = 0;
                        while (i16 < 2) {
                            i17 = 0;
                            z7 = false;
                            while (i17 < size2) {
                                ArrayList arrayList8 = arrayList;
                                chVar = (ch) arrayList.get(i17);
                                int i316 = size2;
                                if (chVar instanceof h8) {
                                    z10 = z6;
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    z10 = z6;
                                    if (chVar.j0 == 8) {
                                        z11 = z5;
                                        bVar3 = bVar;
                                        i20 = i16;
                                        i21 = i17;
                                    } else {
                                        iN3 = chVar.n();
                                        i22 = chVar.i();
                                        z11 = z5;
                                        int i317 = chVar.d0;
                                        i21 = i17;
                                        zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                        bVar3 = bVar;
                                        iN4 = chVar.n();
                                        i20 = i16;
                                        i23 = chVar.i();
                                        if (iN4 != iN3) {
                                            chVar.J(iN4);
                                            if (z11) {
                                                iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                            }
                                            zA = true;
                                        }
                                        if (i23 != i22) {
                                            chVar.G(i23);
                                            if (z10) {
                                                iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                            }
                                            zA = true;
                                        }
                                        if (chVar.F) {
                                            z7 = zA;
                                        } else {
                                            z7 = zA;
                                        }
                                    }
                                }
                                i17 = i21 + 1;
                                arrayList = arrayList8;
                                size2 = i316;
                                z6 = z10;
                                z5 = z11;
                                bVar = bVar3;
                                i16 = i20;
                            }
                            arrayList2 = arrayList;
                            i18 = size2;
                            z8 = z6;
                            z9 = z5;
                            bVar2 = bVar;
                            i19 = i16;
                            if (z7) {
                                break;
                                break;
                            }
                            i16 = i19 + 1;
                            m6Var.b(dhVar, i16, iN2, i13);
                            arrayList = arrayList2;
                            size2 = i18;
                            z6 = z8;
                            z5 = z9;
                            bVar = bVar2;
                        }
                    }
                    dhVar.F0 = i315;
                    oe0.p = dhVar.R(512);
                }
                if (mode2 != 0) {
                    if (mode2 != 1073741824) {
                        iMin2 = Math.min(this.mMaxHeight - i6, i5);
                        i9 = 1;
                    }
                    iN = dhVar.n();
                    iArr = dhVar.D;
                    cmVar = dhVar.u0;
                    i10 = iMin;
                    if (i10 == iN || iMin2 != dhVar.i()) {
                        cmVar.c = true;
                        c = 1;
                    } else {
                        c = 1;
                    }
                    dhVar.b0 = 0;
                    dhVar.c0 = 0;
                    iArr[0] = this.mMaxWidth - i7;
                    iArr[c] = this.mMaxHeight - i6;
                    dhVar.e0 = 0;
                    dhVar.f0 = 0;
                    dhVar.H(i8);
                    dhVar.J(i10);
                    dhVar.I(i9);
                    dhVar.G(iMin2);
                    i11 = this.mMinWidth - i7;
                    if (i11 < 0) {
                        i11 = 0;
                    }
                    dhVar.e0 = i11;
                    i12 = this.mMinHeight - i6;
                    if (i12 < 0) {
                        i12 = 0;
                    }
                    dhVar.f0 = i12;
                    dhVar.z0 = iMax10;
                    dhVar.A0 = iMax5;
                    m6Var = dhVar.t0;
                    m6Var.getClass();
                    bVar = dhVar.w0;
                    size = dhVar.s0.size();
                    iN2 = dhVar.n();
                    i13 = dhVar.i();
                    zX = e.x(i, 128);
                    if (zX || e.x(i, 64)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        i31 = 0;
                        while (true) {
                            if (i31 < size) {
                                chVar6 = (ch) dhVar.s0.get(i31);
                                iArr3 = chVar6.V;
                                z18 = z;
                                if (iArr3[0] == 3) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (iArr3[1] == 3) {
                                    z20 = true;
                                } else {
                                    z20 = false;
                                }
                                if (z19 || !z20 || chVar6.Z <= 0.0f) {
                                    z21 = false;
                                } else {
                                    z21 = true;
                                }
                                if ((chVar6.u() || !z21) && !((chVar6.v() && z21) || chVar6.u() || chVar6.v())) {
                                    i31++;
                                    z = z18;
                                } else {
                                    z2 = false;
                                }
                            } else {
                                z2 = z;
                            }
                        }
                    } else {
                        z2 = z;
                    }
                    z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                    if (z3) {
                        iMin3 = Math.min(iArr[0], i4);
                        iMin4 = Math.min(iArr[1], i5);
                        if (mode == 1073741824 && dhVar.n() != iMin3) {
                            dhVar.J(iMin3);
                            cmVar.b = true;
                        }
                        if (mode2 == 1073741824 && dhVar.i() != iMin4) {
                            dhVar.G(iMin4);
                            cmVar.b = true;
                        }
                        if (mode == 1073741824 || mode2 != 1073741824) {
                            z4 = z3;
                            z13 = cmVar.b;
                            dhVar2 = cmVar.a;
                            if (z13) {
                                while (r0.hasNext()) {
                                    chVar7.f();
                                    chVar7.a = false;
                                    g10 g10Var112 = chVar7.d;
                                    g10Var112.e.j = false;
                                    g10Var112.g = false;
                                    g10Var112.n();
                                    kd1 kd1Var112 = chVar7.e;
                                    kd1Var112.e.j = false;
                                    kd1Var112.g = false;
                                    kd1Var112.m();
                                }
                                i28 = 0;
                                dhVar2.f();
                                dhVar2.a = false;
                                g10 g10Var113 = dhVar2.d;
                                g10Var113.e.j = false;
                                g10Var113.g = false;
                                g10Var113.n();
                                kd1 kd1Var113 = dhVar2.e;
                                kd1Var113.e.j = false;
                                kd1Var113.g = false;
                                kd1Var113.m();
                                cmVar.c();
                            } else {
                                i28 = 0;
                            }
                            cmVar.b(cmVar.d);
                            dhVar2.b0 = i28;
                            dhVar2.c0 = i28;
                            dhVar2.d.h.d(i28);
                            dhVar2.e.h.d(i28);
                            i29 = 1073741824;
                            if (mode == 1073741824) {
                                zP = dhVar.P(i28, zX);
                                i14 = 1;
                            } else {
                                i14 = 0;
                                zP = true;
                            }
                            if (mode2 == 1073741824) {
                                zP &= dhVar.P(1, zX);
                                i14++;
                            }
                        } else {
                            boolean z22 = cmVar.b;
                            dh dhVar8 = cmVar.a;
                            if (z22 || cmVar.c) {
                                for (ch chVar8 : dhVar8.s0) {
                                    chVar8.f();
                                    chVar8.a = false;
                                    chVar8.d.n();
                                    chVar8.e.m();
                                }
                                i30 = 0;
                                dhVar8.f();
                                dhVar8.a = false;
                                dhVar8.d.n();
                                dhVar8.e.m();
                                cmVar.c = false;
                            } else {
                                i30 = 0;
                            }
                            cmVar.b(cmVar.d);
                            dhVar8.b0 = i30;
                            dhVar8.c0 = i30;
                            int iH7 = dhVar8.h(i30);
                            int iH8 = dhVar8.h(1);
                            if (cmVar.b) {
                                cmVar.c();
                            }
                            int iO = dhVar8.o();
                            int iP = dhVar8.p();
                            z4 = z3;
                            dhVar8.d.h.d(iO);
                            dhVar8.e.h.d(iP);
                            cmVar.g();
                            ArrayList<yf1> arrayList9 = cmVar.e;
                            if (iH7 == 2 || iH8 == 2) {
                                if (zX) {
                                    Iterator it = arrayList9.iterator();
                                    while (it.hasNext()) {
                                        if (!((yf1) it.next()).k()) {
                                            zX = false;
                                            break;
                                        }
                                    }
                                }
                                if (zX && iH7 == 2) {
                                    dhVar8.H(1);
                                    dhVar8.J(cmVar.d(dhVar8, 0));
                                    dhVar8.d.e.d(dhVar8.n());
                                }
                                if (zX && iH8 == 2) {
                                    dhVar8.I(1);
                                    dhVar8.G(cmVar.d(dhVar8, 1));
                                    dhVar8.e.e.d(dhVar8.i());
                                }
                            } else {
                                iO = iO;
                            }
                            int[] iArr4 = dhVar8.V;
                            int i40 = iArr4[0];
                            if (i40 == 1 || i40 == 4) {
                                int iN10 = dhVar8.n() + iO;
                                dhVar8.d.i.d(iN10);
                                dhVar8.d.e.d(iN10 - iO);
                                cmVar.g();
                                int i41 = iArr4[1];
                                if (i41 == 1 || i41 == 4) {
                                    int i42 = dhVar8.i() + iP;
                                    dhVar8.e.i.d(i42);
                                    dhVar8.e.e.d(i42 - iP);
                                }
                                cmVar.g();
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            for (yf1 yf1Var : arrayList9) {
                                if (yf1Var.b != dhVar8 || yf1Var.g) {
                                    yf1Var.e();
                                }
                            }
                            Iterator it2 = arrayList9.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z17 = true;
                                    break;
                                }
                                yf1 yf1Var2 = (yf1) it2.next();
                                if (z16 || yf1Var2.b != dhVar8) {
                                    if (!yf1Var2.h.j || ((!yf1Var2.i.j && !(yf1Var2 instanceof qy)) || (!yf1Var2.e.j && !(yf1Var2 instanceof xb) && !(yf1Var2 instanceof qy)))) {
                                        z17 = false;
                                        break;
                                    }
                                }
                            }
                            dhVar8.H(iH7);
                            dhVar8.I(iH8);
                            zP = z17;
                            i29 = 1073741824;
                            i14 = 2;
                        }
                        if (zP) {
                            if (mode == i29) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            if (mode2 == i29) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            dhVar.K(z14, z15);
                        }
                    } else {
                        z4 = z3;
                        i14 = 0;
                        zP = false;
                    }
                    if (zP || i14 != 2) {
                        int i318 = dhVar.F0;
                        if (size > 0) {
                            size3 = dhVar.s0.size();
                            zR = dhVar.R(64);
                            bVar4 = dhVar.w0;
                            i24 = 0;
                            while (i24 < size3) {
                                chVar5 = (ch) dhVar.s0.get(i24);
                                if ((chVar5 instanceof py) && !(chVar5 instanceof h8)) {
                                    chVar5.getClass();
                                    if (zR || (g10Var = chVar5.d) == null || (kd1Var = chVar5.e) == null || !g10Var.e.j || !kd1Var.e.j) {
                                        iH = chVar5.h(0);
                                        int iH9 = chVar5.h(1);
                                        i27 = size3;
                                        if (iH == 3 || chVar5.s == 1 || iH9 != 3 || chVar5.t == 1) {
                                            z12 = false;
                                        } else {
                                            z12 = true;
                                        }
                                        if (z12 && dhVar.R(1)) {
                                            if (iH == 3 && chVar5.s == 0 && iH9 != 3 && !chVar5.u()) {
                                                z12 = true;
                                            }
                                            if (iH9 == 3 && chVar5.t == 0 && iH != 3 && !chVar5.u()) {
                                                z12 = true;
                                            }
                                            if ((iH == 3 || iH9 == 3) && chVar5.Z > 0.0f) {
                                                z12 = true;
                                            }
                                        }
                                        if (z12) {
                                            m6Var.a(0, chVar5, bVar4);
                                        }
                                    } else {
                                        i27 = size3;
                                    }
                                } else {
                                    i27 = size3;
                                }
                                i24++;
                                size3 = i27;
                            }
                            constraintLayout = bVar4.a;
                            childCount2 = constraintLayout.getChildCount();
                            arrayList3 = constraintLayout.mConstraintHelpers;
                            i25 = 0;
                            while (i25 < childCount2) {
                                childAt = constraintLayout.getChildAt(i25);
                                if (childAt instanceof d) {
                                    dVar = (d) childAt;
                                    if (dVar.c == null) {
                                        a aVar9 = (a) dVar.getLayoutParams();
                                        aVar3 = (a) dVar.c.getLayoutParams();
                                        chVar2 = aVar3.q0;
                                        chVar2.j0 = 0;
                                        chVar3 = aVar9.q0;
                                        if (chVar3.V[0] != 1) {
                                            chVar3.J(chVar2.n());
                                        }
                                        chVar4 = aVar9.q0;
                                        if (chVar4.V[1] != 1) {
                                            chVar4.G(aVar3.q0.i());
                                        }
                                        aVar3.q0.j0 = 8;
                                    }
                                }
                                i25++;
                                constraintLayout = constraintLayout;
                            }
                            size4 = arrayList3.size();
                            if (size4 > 0) {
                                while (i26 < size4) {
                                    ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                                }
                            }
                        }
                        m6Var.c(dhVar);
                        arrayList = (ArrayList) m6Var.a;
                        size2 = arrayList.size();
                        if (size > 0) {
                            m6Var.b(dhVar, 0, iN2, i13);
                        }
                        if (size2 > 0) {
                            iArr2 = dhVar.V;
                            if (iArr2[0] == 2) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (iArr2[1] == 2) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            int iN11 = dhVar.n();
                            dh dhVar9 = (dh) m6Var.c;
                            iMax3 = Math.max(iN11, dhVar9.e0);
                            iMax4 = Math.max(dhVar.i(), dhVar9.f0);
                            i15 = 0;
                            while (true) {
                                aVar = vg.a.f;
                                aVar2 = vg.a.d;
                                if (i15 < size2) {
                                    break;
                                }
                                i15++;
                            }
                            i16 = 0;
                            while (i16 < 2) {
                                i17 = 0;
                                z7 = false;
                                while (i17 < size2) {
                                    ArrayList arrayList10 = arrayList;
                                    chVar = (ch) arrayList.get(i17);
                                    int i319 = size2;
                                    if ((chVar instanceof h8) && !(chVar instanceof py)) {
                                        z10 = z6;
                                        if (chVar.j0 == 8 && (!z4 || !chVar.d.e.j || !chVar.e.e.j)) {
                                            iN3 = chVar.n();
                                            i22 = chVar.i();
                                            z11 = z5;
                                            int i3110 = chVar.d0;
                                            i21 = i17;
                                            zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                            bVar3 = bVar;
                                            iN4 = chVar.n();
                                            i20 = i16;
                                            i23 = chVar.i();
                                            if (iN4 != iN3) {
                                                chVar.J(iN4);
                                                if (z11 && chVar.o() + chVar.X > iMax3) {
                                                    iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                                }
                                                zA = true;
                                            }
                                            if (i23 != i22) {
                                                chVar.G(i23);
                                                if (z10 && chVar.p() + chVar.Y > iMax4) {
                                                    iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                                }
                                                zA = true;
                                            }
                                            if (chVar.F || i3110 == chVar.d0) {
                                                z7 = zA;
                                            } else {
                                                z7 = true;
                                            }
                                        }
                                        i17 = i21 + 1;
                                        arrayList = arrayList10;
                                        size2 = i319;
                                        z6 = z10;
                                        z5 = z11;
                                        bVar = bVar3;
                                        i16 = i20;
                                    } else {
                                        z10 = z6;
                                    }
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                    i17 = i21 + 1;
                                    arrayList = arrayList10;
                                    size2 = i319;
                                    z6 = z10;
                                    z5 = z11;
                                    bVar = bVar3;
                                    i16 = i20;
                                }
                                arrayList2 = arrayList;
                                i18 = size2;
                                z8 = z6;
                                z9 = z5;
                                bVar2 = bVar;
                                i19 = i16;
                                if (z7) {
                                    break;
                                }
                                i16 = i19 + 1;
                                m6Var.b(dhVar, i16, iN2, i13);
                                arrayList = arrayList2;
                                size2 = i18;
                                z6 = z8;
                                z5 = z9;
                                bVar = bVar2;
                            }
                        }
                        dhVar.F0 = i318;
                        oe0.p = dhVar.R(512);
                    }
                    return;
                }
                i9 = childCount != 0 ? 2 : 1;
                iMin2 = 0;
                iN = dhVar.n();
                iArr = dhVar.D;
                cmVar = dhVar.u0;
                i10 = iMin;
                if (i10 == iN) {
                    cmVar.c = true;
                    c = 1;
                } else {
                    cmVar.c = true;
                    c = 1;
                }
                dhVar.b0 = 0;
                dhVar.c0 = 0;
                iArr[0] = this.mMaxWidth - i7;
                iArr[c] = this.mMaxHeight - i6;
                dhVar.e0 = 0;
                dhVar.f0 = 0;
                dhVar.H(i8);
                dhVar.J(i10);
                dhVar.I(i9);
                dhVar.G(iMin2);
                i11 = this.mMinWidth - i7;
                if (i11 < 0) {
                    i11 = 0;
                }
                dhVar.e0 = i11;
                i12 = this.mMinHeight - i6;
                if (i12 < 0) {
                    i12 = 0;
                }
                dhVar.f0 = i12;
                dhVar.z0 = iMax10;
                dhVar.A0 = iMax5;
                m6Var = dhVar.t0;
                m6Var.getClass();
                bVar = dhVar.w0;
                size = dhVar.s0.size();
                iN2 = dhVar.n();
                i13 = dhVar.i();
                zX = e.x(i, 128);
                if (zX) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            chVar6 = (ch) dhVar.s0.get(i31);
                            iArr3 = chVar6.V;
                            z18 = z;
                            if (iArr3[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr3[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z19) {
                                z21 = false;
                            } else {
                                z21 = false;
                            }
                            if (chVar6.u()) {
                                i31++;
                                z = z18;
                            } else {
                                i31++;
                                z = z18;
                            }
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                    }
                } else {
                    z2 = z;
                }
                z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                if (z3) {
                    iMin3 = Math.min(iArr[0], i4);
                    iMin4 = Math.min(iArr[1], i5);
                    if (mode == 1073741824) {
                        dhVar.J(iMin3);
                        cmVar.b = true;
                    }
                    if (mode2 == 1073741824) {
                        dhVar.G(iMin4);
                        cmVar.b = true;
                    }
                    if (mode == 1073741824) {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var114 = chVar7.d;
                                g10Var114.e.j = false;
                                g10Var114.g = false;
                                g10Var114.n();
                                kd1 kd1Var114 = chVar7.e;
                                kd1Var114.e.j = false;
                                kd1Var114.g = false;
                                kd1Var114.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var115 = dhVar2.d;
                            g10Var115.e.j = false;
                            g10Var115.g = false;
                            g10Var115.n();
                            kd1 kd1Var115 = dhVar2.e;
                            kd1Var115.e.j = false;
                            kd1Var115.g = false;
                            kd1Var115.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    } else {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var116 = chVar7.d;
                                g10Var116.e.j = false;
                                g10Var116.g = false;
                                g10Var116.n();
                                kd1 kd1Var116 = chVar7.e;
                                kd1Var116.e.j = false;
                                kd1Var116.g = false;
                                kd1Var116.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var117 = dhVar2.d;
                            g10Var117.e.j = false;
                            g10Var117.g = false;
                            g10Var117.n();
                            kd1 kd1Var117 = dhVar2.e;
                            kd1Var117.e.j = false;
                            kd1Var117.g = false;
                            kd1Var117.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    }
                    if (zP) {
                        if (mode == i29) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i29) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        dhVar.K(z14, z15);
                    }
                } else {
                    z4 = z3;
                    i14 = 0;
                    zP = false;
                }
                if (zP) {
                }
                int i3111 = dhVar.F0;
                if (size > 0) {
                    size3 = dhVar.s0.size();
                    zR = dhVar.R(64);
                    bVar4 = dhVar.w0;
                    i24 = 0;
                    while (i24 < size3) {
                        chVar5 = (ch) dhVar.s0.get(i24);
                        if (chVar5 instanceof py) {
                            i27 = size3;
                        } else {
                            chVar5.getClass();
                            if (zR) {
                            }
                            iH = chVar5.h(0);
                            int iH10 = chVar5.h(1);
                            i27 = size3;
                            if (iH == 3) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                            }
                            if (z12) {
                                m6Var.a(0, chVar5, bVar4);
                            }
                        }
                        i24++;
                        size3 = i27;
                    }
                    constraintLayout = bVar4.a;
                    childCount2 = constraintLayout.getChildCount();
                    arrayList3 = constraintLayout.mConstraintHelpers;
                    i25 = 0;
                    while (i25 < childCount2) {
                        childAt = constraintLayout.getChildAt(i25);
                        if (childAt instanceof d) {
                            dVar = (d) childAt;
                            if (dVar.c == null) {
                                a aVar10 = (a) dVar.getLayoutParams();
                                aVar3 = (a) dVar.c.getLayoutParams();
                                chVar2 = aVar3.q0;
                                chVar2.j0 = 0;
                                chVar3 = aVar10.q0;
                                if (chVar3.V[0] != 1) {
                                    chVar3.J(chVar2.n());
                                }
                                chVar4 = aVar10.q0;
                                if (chVar4.V[1] != 1) {
                                    chVar4.G(aVar3.q0.i());
                                }
                                aVar3.q0.j0 = 8;
                            }
                        }
                        i25++;
                        constraintLayout = constraintLayout;
                    }
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i26 < size4) {
                            ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                        }
                    }
                }
                m6Var.c(dhVar);
                arrayList = (ArrayList) m6Var.a;
                size2 = arrayList.size();
                if (size > 0) {
                    m6Var.b(dhVar, 0, iN2, i13);
                }
                if (size2 > 0) {
                    iArr2 = dhVar.V;
                    if (iArr2[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr2[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int iN12 = dhVar.n();
                    dh dhVar10 = (dh) m6Var.c;
                    iMax3 = Math.max(iN12, dhVar10.e0);
                    iMax4 = Math.max(dhVar.i(), dhVar10.f0);
                    i15 = 0;
                    while (true) {
                        aVar = vg.a.f;
                        aVar2 = vg.a.d;
                        if (i15 < size2) {
                            break;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    i16 = 0;
                    while (i16 < 2) {
                        i17 = 0;
                        z7 = false;
                        while (i17 < size2) {
                            ArrayList arrayList11 = arrayList;
                            chVar = (ch) arrayList.get(i17);
                            int i3112 = size2;
                            if (chVar instanceof h8) {
                                z10 = z6;
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                z10 = z6;
                                if (chVar.j0 == 8) {
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    iN3 = chVar.n();
                                    i22 = chVar.i();
                                    z11 = z5;
                                    int i3113 = chVar.d0;
                                    i21 = i17;
                                    zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                    bVar3 = bVar;
                                    iN4 = chVar.n();
                                    i20 = i16;
                                    i23 = chVar.i();
                                    if (iN4 != iN3) {
                                        chVar.J(iN4);
                                        if (z11) {
                                            iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                        }
                                        zA = true;
                                    }
                                    if (i23 != i22) {
                                        chVar.G(i23);
                                        if (z10) {
                                            iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                        }
                                        zA = true;
                                    }
                                    if (chVar.F) {
                                        z7 = zA;
                                    } else {
                                        z7 = zA;
                                    }
                                }
                            }
                            i17 = i21 + 1;
                            arrayList = arrayList11;
                            size2 = i3112;
                            z6 = z10;
                            z5 = z11;
                            bVar = bVar3;
                            i16 = i20;
                        }
                        arrayList2 = arrayList;
                        i18 = size2;
                        z8 = z6;
                        z9 = z5;
                        bVar2 = bVar;
                        i19 = i16;
                        if (z7) {
                            break;
                            break;
                        }
                        i16 = i19 + 1;
                        m6Var.b(dhVar, i16, iN2, i13);
                        arrayList = arrayList2;
                        size2 = i18;
                        z6 = z8;
                        z5 = z9;
                        bVar = bVar2;
                    }
                }
                dhVar.F0 = i3111;
                oe0.p = dhVar.R(512);
                iMax2 = Math.max(0, this.mMinHeight);
                iMin2 = iMax2;
                i9 = 2;
                iN = dhVar.n();
                iArr = dhVar.D;
                cmVar = dhVar.u0;
                i10 = iMin;
                if (i10 == iN) {
                    cmVar.c = true;
                    c = 1;
                } else {
                    cmVar.c = true;
                    c = 1;
                }
                dhVar.b0 = 0;
                dhVar.c0 = 0;
                iArr[0] = this.mMaxWidth - i7;
                iArr[c] = this.mMaxHeight - i6;
                dhVar.e0 = 0;
                dhVar.f0 = 0;
                dhVar.H(i8);
                dhVar.J(i10);
                dhVar.I(i9);
                dhVar.G(iMin2);
                i11 = this.mMinWidth - i7;
                if (i11 < 0) {
                    i11 = 0;
                }
                dhVar.e0 = i11;
                i12 = this.mMinHeight - i6;
                if (i12 < 0) {
                    i12 = 0;
                }
                dhVar.f0 = i12;
                dhVar.z0 = iMax10;
                dhVar.A0 = iMax5;
                m6Var = dhVar.t0;
                m6Var.getClass();
                bVar = dhVar.w0;
                size = dhVar.s0.size();
                iN2 = dhVar.n();
                i13 = dhVar.i();
                zX = e.x(i, 128);
                if (zX) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            chVar6 = (ch) dhVar.s0.get(i31);
                            iArr3 = chVar6.V;
                            z18 = z;
                            if (iArr3[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr3[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z19) {
                                z21 = false;
                            } else {
                                z21 = false;
                            }
                            if (chVar6.u()) {
                                i31++;
                                z = z18;
                            } else {
                                i31++;
                                z = z18;
                            }
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                    }
                } else {
                    z2 = z;
                }
                z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                if (z3) {
                    iMin3 = Math.min(iArr[0], i4);
                    iMin4 = Math.min(iArr[1], i5);
                    if (mode == 1073741824) {
                        dhVar.J(iMin3);
                        cmVar.b = true;
                    }
                    if (mode2 == 1073741824) {
                        dhVar.G(iMin4);
                        cmVar.b = true;
                    }
                    if (mode == 1073741824) {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var118 = chVar7.d;
                                g10Var118.e.j = false;
                                g10Var118.g = false;
                                g10Var118.n();
                                kd1 kd1Var118 = chVar7.e;
                                kd1Var118.e.j = false;
                                kd1Var118.g = false;
                                kd1Var118.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var119 = dhVar2.d;
                            g10Var119.e.j = false;
                            g10Var119.g = false;
                            g10Var119.n();
                            kd1 kd1Var119 = dhVar2.e;
                            kd1Var119.e.j = false;
                            kd1Var119.g = false;
                            kd1Var119.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    } else {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var1110 = chVar7.d;
                                g10Var1110.e.j = false;
                                g10Var1110.g = false;
                                g10Var1110.n();
                                kd1 kd1Var1110 = chVar7.e;
                                kd1Var1110.e.j = false;
                                kd1Var1110.g = false;
                                kd1Var1110.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var1111 = dhVar2.d;
                            g10Var1111.e.j = false;
                            g10Var1111.g = false;
                            g10Var1111.n();
                            kd1 kd1Var1111 = dhVar2.e;
                            kd1Var1111.e.j = false;
                            kd1Var1111.g = false;
                            kd1Var1111.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    }
                    if (zP) {
                        if (mode == i29) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i29) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        dhVar.K(z14, z15);
                    }
                } else {
                    z4 = z3;
                    i14 = 0;
                    zP = false;
                }
                if (zP) {
                }
                int i3114 = dhVar.F0;
                if (size > 0) {
                    size3 = dhVar.s0.size();
                    zR = dhVar.R(64);
                    bVar4 = dhVar.w0;
                    i24 = 0;
                    while (i24 < size3) {
                        chVar5 = (ch) dhVar.s0.get(i24);
                        if (chVar5 instanceof py) {
                            i27 = size3;
                        } else {
                            chVar5.getClass();
                            if (zR) {
                            }
                            iH = chVar5.h(0);
                            int iH11 = chVar5.h(1);
                            i27 = size3;
                            if (iH == 3) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                            }
                            if (z12) {
                                m6Var.a(0, chVar5, bVar4);
                            }
                        }
                        i24++;
                        size3 = i27;
                    }
                    constraintLayout = bVar4.a;
                    childCount2 = constraintLayout.getChildCount();
                    arrayList3 = constraintLayout.mConstraintHelpers;
                    i25 = 0;
                    while (i25 < childCount2) {
                        childAt = constraintLayout.getChildAt(i25);
                        if (childAt instanceof d) {
                            dVar = (d) childAt;
                            if (dVar.c == null) {
                                a aVar11 = (a) dVar.getLayoutParams();
                                aVar3 = (a) dVar.c.getLayoutParams();
                                chVar2 = aVar3.q0;
                                chVar2.j0 = 0;
                                chVar3 = aVar11.q0;
                                if (chVar3.V[0] != 1) {
                                    chVar3.J(chVar2.n());
                                }
                                chVar4 = aVar11.q0;
                                if (chVar4.V[1] != 1) {
                                    chVar4.G(aVar3.q0.i());
                                }
                                aVar3.q0.j0 = 8;
                            }
                        }
                        i25++;
                        constraintLayout = constraintLayout;
                    }
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i26 < size4) {
                            ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                        }
                    }
                }
                m6Var.c(dhVar);
                arrayList = (ArrayList) m6Var.a;
                size2 = arrayList.size();
                if (size > 0) {
                    m6Var.b(dhVar, 0, iN2, i13);
                }
                if (size2 > 0) {
                    iArr2 = dhVar.V;
                    if (iArr2[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr2[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int iN13 = dhVar.n();
                    dh dhVar11 = (dh) m6Var.c;
                    iMax3 = Math.max(iN13, dhVar11.e0);
                    iMax4 = Math.max(dhVar.i(), dhVar11.f0);
                    i15 = 0;
                    while (true) {
                        aVar = vg.a.f;
                        aVar2 = vg.a.d;
                        if (i15 < size2) {
                            break;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    i16 = 0;
                    while (i16 < 2) {
                        i17 = 0;
                        z7 = false;
                        while (i17 < size2) {
                            ArrayList arrayList12 = arrayList;
                            chVar = (ch) arrayList.get(i17);
                            int i3115 = size2;
                            if (chVar instanceof h8) {
                                z10 = z6;
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                z10 = z6;
                                if (chVar.j0 == 8) {
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    iN3 = chVar.n();
                                    i22 = chVar.i();
                                    z11 = z5;
                                    int i3116 = chVar.d0;
                                    i21 = i17;
                                    zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                    bVar3 = bVar;
                                    iN4 = chVar.n();
                                    i20 = i16;
                                    i23 = chVar.i();
                                    if (iN4 != iN3) {
                                        chVar.J(iN4);
                                        if (z11) {
                                            iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                        }
                                        zA = true;
                                    }
                                    if (i23 != i22) {
                                        chVar.G(i23);
                                        if (z10) {
                                            iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                        }
                                        zA = true;
                                    }
                                    if (chVar.F) {
                                        z7 = zA;
                                    } else {
                                        z7 = zA;
                                    }
                                }
                            }
                            i17 = i21 + 1;
                            arrayList = arrayList12;
                            size2 = i3115;
                            z6 = z10;
                            z5 = z11;
                            bVar = bVar3;
                            i16 = i20;
                        }
                        arrayList2 = arrayList;
                        i18 = size2;
                        z8 = z6;
                        z9 = z5;
                        bVar2 = bVar;
                        i19 = i16;
                        if (z7) {
                            break;
                            break;
                        }
                        i16 = i19 + 1;
                        m6Var.b(dhVar, i16, iN2, i13);
                        arrayList = arrayList2;
                        size2 = i18;
                        z6 = z8;
                        z5 = z9;
                        bVar = bVar2;
                    }
                }
                dhVar.F0 = i3114;
                oe0.p = dhVar.R(512);
            }
            i8 = childCount != 0 ? 2 : 1;
            iMin = 0;
            if (mode2 != Integer.MIN_VALUE) {
                if (childCount == 0) {
                    iMax2 = i5;
                }
                iMin2 = iMax2;
                i9 = 2;
                iN = dhVar.n();
                iArr = dhVar.D;
                cmVar = dhVar.u0;
                i10 = iMin;
                if (i10 == iN) {
                    cmVar.c = true;
                    c = 1;
                } else {
                    cmVar.c = true;
                    c = 1;
                }
                dhVar.b0 = 0;
                dhVar.c0 = 0;
                iArr[0] = this.mMaxWidth - i7;
                iArr[c] = this.mMaxHeight - i6;
                dhVar.e0 = 0;
                dhVar.f0 = 0;
                dhVar.H(i8);
                dhVar.J(i10);
                dhVar.I(i9);
                dhVar.G(iMin2);
                i11 = this.mMinWidth - i7;
                if (i11 < 0) {
                    i11 = 0;
                }
                dhVar.e0 = i11;
                i12 = this.mMinHeight - i6;
                if (i12 < 0) {
                    i12 = 0;
                }
                dhVar.f0 = i12;
                dhVar.z0 = iMax10;
                dhVar.A0 = iMax5;
                m6Var = dhVar.t0;
                m6Var.getClass();
                bVar = dhVar.w0;
                size = dhVar.s0.size();
                iN2 = dhVar.n();
                i13 = dhVar.i();
                zX = e.x(i, 128);
                if (zX) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            chVar6 = (ch) dhVar.s0.get(i31);
                            iArr3 = chVar6.V;
                            z18 = z;
                            if (iArr3[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr3[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z19) {
                                z21 = false;
                            } else {
                                z21 = false;
                            }
                            if (chVar6.u()) {
                                i31++;
                                z = z18;
                            } else {
                                i31++;
                                z = z18;
                            }
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                    }
                } else {
                    z2 = z;
                }
                z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                if (z3) {
                    iMin3 = Math.min(iArr[0], i4);
                    iMin4 = Math.min(iArr[1], i5);
                    if (mode == 1073741824) {
                        dhVar.J(iMin3);
                        cmVar.b = true;
                    }
                    if (mode2 == 1073741824) {
                        dhVar.G(iMin4);
                        cmVar.b = true;
                    }
                    if (mode == 1073741824) {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var1112 = chVar7.d;
                                g10Var1112.e.j = false;
                                g10Var1112.g = false;
                                g10Var1112.n();
                                kd1 kd1Var1112 = chVar7.e;
                                kd1Var1112.e.j = false;
                                kd1Var1112.g = false;
                                kd1Var1112.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var1113 = dhVar2.d;
                            g10Var1113.e.j = false;
                            g10Var1113.g = false;
                            g10Var1113.n();
                            kd1 kd1Var1113 = dhVar2.e;
                            kd1Var1113.e.j = false;
                            kd1Var1113.g = false;
                            kd1Var1113.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    } else {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var1114 = chVar7.d;
                                g10Var1114.e.j = false;
                                g10Var1114.g = false;
                                g10Var1114.n();
                                kd1 kd1Var1114 = chVar7.e;
                                kd1Var1114.e.j = false;
                                kd1Var1114.g = false;
                                kd1Var1114.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var1115 = dhVar2.d;
                            g10Var1115.e.j = false;
                            g10Var1115.g = false;
                            g10Var1115.n();
                            kd1 kd1Var1115 = dhVar2.e;
                            kd1Var1115.e.j = false;
                            kd1Var1115.g = false;
                            kd1Var1115.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    }
                    if (zP) {
                        if (mode == i29) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i29) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        dhVar.K(z14, z15);
                    }
                } else {
                    z4 = z3;
                    i14 = 0;
                    zP = false;
                }
                if (zP) {
                }
                int i3117 = dhVar.F0;
                if (size > 0) {
                    size3 = dhVar.s0.size();
                    zR = dhVar.R(64);
                    bVar4 = dhVar.w0;
                    i24 = 0;
                    while (i24 < size3) {
                        chVar5 = (ch) dhVar.s0.get(i24);
                        if (chVar5 instanceof py) {
                            i27 = size3;
                        } else {
                            chVar5.getClass();
                            if (zR) {
                            }
                            iH = chVar5.h(0);
                            int iH12 = chVar5.h(1);
                            i27 = size3;
                            if (iH == 3) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                            }
                            if (z12) {
                                m6Var.a(0, chVar5, bVar4);
                            }
                        }
                        i24++;
                        size3 = i27;
                    }
                    constraintLayout = bVar4.a;
                    childCount2 = constraintLayout.getChildCount();
                    arrayList3 = constraintLayout.mConstraintHelpers;
                    i25 = 0;
                    while (i25 < childCount2) {
                        childAt = constraintLayout.getChildAt(i25);
                        if (childAt instanceof d) {
                            dVar = (d) childAt;
                            if (dVar.c == null) {
                                a aVar12 = (a) dVar.getLayoutParams();
                                aVar3 = (a) dVar.c.getLayoutParams();
                                chVar2 = aVar3.q0;
                                chVar2.j0 = 0;
                                chVar3 = aVar12.q0;
                                if (chVar3.V[0] != 1) {
                                    chVar3.J(chVar2.n());
                                }
                                chVar4 = aVar12.q0;
                                if (chVar4.V[1] != 1) {
                                    chVar4.G(aVar3.q0.i());
                                }
                                aVar3.q0.j0 = 8;
                            }
                        }
                        i25++;
                        constraintLayout = constraintLayout;
                    }
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i26 < size4) {
                            ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                        }
                    }
                }
                m6Var.c(dhVar);
                arrayList = (ArrayList) m6Var.a;
                size2 = arrayList.size();
                if (size > 0) {
                    m6Var.b(dhVar, 0, iN2, i13);
                }
                if (size2 > 0) {
                    iArr2 = dhVar.V;
                    if (iArr2[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr2[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int iN14 = dhVar.n();
                    dh dhVar12 = (dh) m6Var.c;
                    iMax3 = Math.max(iN14, dhVar12.e0);
                    iMax4 = Math.max(dhVar.i(), dhVar12.f0);
                    i15 = 0;
                    while (true) {
                        aVar = vg.a.f;
                        aVar2 = vg.a.d;
                        if (i15 < size2) {
                            break;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    i16 = 0;
                    while (i16 < 2) {
                        i17 = 0;
                        z7 = false;
                        while (i17 < size2) {
                            ArrayList arrayList13 = arrayList;
                            chVar = (ch) arrayList.get(i17);
                            int i3118 = size2;
                            if (chVar instanceof h8) {
                                z10 = z6;
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                z10 = z6;
                                if (chVar.j0 == 8) {
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    iN3 = chVar.n();
                                    i22 = chVar.i();
                                    z11 = z5;
                                    int i3119 = chVar.d0;
                                    i21 = i17;
                                    zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                    bVar3 = bVar;
                                    iN4 = chVar.n();
                                    i20 = i16;
                                    i23 = chVar.i();
                                    if (iN4 != iN3) {
                                        chVar.J(iN4);
                                        if (z11) {
                                            iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                        }
                                        zA = true;
                                    }
                                    if (i23 != i22) {
                                        chVar.G(i23);
                                        if (z10) {
                                            iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                        }
                                        zA = true;
                                    }
                                    if (chVar.F) {
                                        z7 = zA;
                                    } else {
                                        z7 = zA;
                                    }
                                }
                            }
                            i17 = i21 + 1;
                            arrayList = arrayList13;
                            size2 = i3118;
                            z6 = z10;
                            z5 = z11;
                            bVar = bVar3;
                            i16 = i20;
                        }
                        arrayList2 = arrayList;
                        i18 = size2;
                        z8 = z6;
                        z9 = z5;
                        bVar2 = bVar;
                        i19 = i16;
                        if (z7) {
                            break;
                            break;
                        }
                        i16 = i19 + 1;
                        m6Var.b(dhVar, i16, iN2, i13);
                        arrayList = arrayList2;
                        size2 = i18;
                        z6 = z8;
                        z5 = z9;
                        bVar = bVar2;
                    }
                }
                dhVar.F0 = i3117;
                oe0.p = dhVar.R(512);
            }
            if (mode2 != 0) {
                if (mode2 != 1073741824) {
                    iMin2 = Math.min(this.mMaxHeight - i6, i5);
                    i9 = 1;
                }
                iN = dhVar.n();
                iArr = dhVar.D;
                cmVar = dhVar.u0;
                i10 = iMin;
                if (i10 == iN) {
                    cmVar.c = true;
                    c = 1;
                } else {
                    cmVar.c = true;
                    c = 1;
                }
                dhVar.b0 = 0;
                dhVar.c0 = 0;
                iArr[0] = this.mMaxWidth - i7;
                iArr[c] = this.mMaxHeight - i6;
                dhVar.e0 = 0;
                dhVar.f0 = 0;
                dhVar.H(i8);
                dhVar.J(i10);
                dhVar.I(i9);
                dhVar.G(iMin2);
                i11 = this.mMinWidth - i7;
                if (i11 < 0) {
                    i11 = 0;
                }
                dhVar.e0 = i11;
                i12 = this.mMinHeight - i6;
                if (i12 < 0) {
                    i12 = 0;
                }
                dhVar.f0 = i12;
                dhVar.z0 = iMax10;
                dhVar.A0 = iMax5;
                m6Var = dhVar.t0;
                m6Var.getClass();
                bVar = dhVar.w0;
                size = dhVar.s0.size();
                iN2 = dhVar.n();
                i13 = dhVar.i();
                zX = e.x(i, 128);
                if (zX) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            chVar6 = (ch) dhVar.s0.get(i31);
                            iArr3 = chVar6.V;
                            z18 = z;
                            if (iArr3[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr3[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z19) {
                                z21 = false;
                            } else {
                                z21 = false;
                            }
                            if (chVar6.u()) {
                                i31++;
                                z = z18;
                            } else {
                                i31++;
                                z = z18;
                            }
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                    }
                } else {
                    z2 = z;
                }
                z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                if (z3) {
                    iMin3 = Math.min(iArr[0], i4);
                    iMin4 = Math.min(iArr[1], i5);
                    if (mode == 1073741824) {
                        dhVar.J(iMin3);
                        cmVar.b = true;
                    }
                    if (mode2 == 1073741824) {
                        dhVar.G(iMin4);
                        cmVar.b = true;
                    }
                    if (mode == 1073741824) {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var1116 = chVar7.d;
                                g10Var1116.e.j = false;
                                g10Var1116.g = false;
                                g10Var1116.n();
                                kd1 kd1Var1116 = chVar7.e;
                                kd1Var1116.e.j = false;
                                kd1Var1116.g = false;
                                kd1Var1116.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var1117 = dhVar2.d;
                            g10Var1117.e.j = false;
                            g10Var1117.g = false;
                            g10Var1117.n();
                            kd1 kd1Var1117 = dhVar2.e;
                            kd1Var1117.e.j = false;
                            kd1Var1117.g = false;
                            kd1Var1117.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    } else {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var1118 = chVar7.d;
                                g10Var1118.e.j = false;
                                g10Var1118.g = false;
                                g10Var1118.n();
                                kd1 kd1Var1118 = chVar7.e;
                                kd1Var1118.e.j = false;
                                kd1Var1118.g = false;
                                kd1Var1118.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var1119 = dhVar2.d;
                            g10Var1119.e.j = false;
                            g10Var1119.g = false;
                            g10Var1119.n();
                            kd1 kd1Var1119 = dhVar2.e;
                            kd1Var1119.e.j = false;
                            kd1Var1119.g = false;
                            kd1Var1119.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    }
                    if (zP) {
                        if (mode == i29) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i29) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        dhVar.K(z14, z15);
                    }
                } else {
                    z4 = z3;
                    i14 = 0;
                    zP = false;
                }
                if (zP) {
                }
                int i31110 = dhVar.F0;
                if (size > 0) {
                    size3 = dhVar.s0.size();
                    zR = dhVar.R(64);
                    bVar4 = dhVar.w0;
                    i24 = 0;
                    while (i24 < size3) {
                        chVar5 = (ch) dhVar.s0.get(i24);
                        if (chVar5 instanceof py) {
                            i27 = size3;
                        } else {
                            chVar5.getClass();
                            if (zR) {
                            }
                            iH = chVar5.h(0);
                            int iH13 = chVar5.h(1);
                            i27 = size3;
                            if (iH == 3) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                            }
                            if (z12) {
                                m6Var.a(0, chVar5, bVar4);
                            }
                        }
                        i24++;
                        size3 = i27;
                    }
                    constraintLayout = bVar4.a;
                    childCount2 = constraintLayout.getChildCount();
                    arrayList3 = constraintLayout.mConstraintHelpers;
                    i25 = 0;
                    while (i25 < childCount2) {
                        childAt = constraintLayout.getChildAt(i25);
                        if (childAt instanceof d) {
                            dVar = (d) childAt;
                            if (dVar.c == null) {
                                a aVar13 = (a) dVar.getLayoutParams();
                                aVar3 = (a) dVar.c.getLayoutParams();
                                chVar2 = aVar3.q0;
                                chVar2.j0 = 0;
                                chVar3 = aVar13.q0;
                                if (chVar3.V[0] != 1) {
                                    chVar3.J(chVar2.n());
                                }
                                chVar4 = aVar13.q0;
                                if (chVar4.V[1] != 1) {
                                    chVar4.G(aVar3.q0.i());
                                }
                                aVar3.q0.j0 = 8;
                            }
                        }
                        i25++;
                        constraintLayout = constraintLayout;
                    }
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i26 < size4) {
                            ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                        }
                    }
                }
                m6Var.c(dhVar);
                arrayList = (ArrayList) m6Var.a;
                size2 = arrayList.size();
                if (size > 0) {
                    m6Var.b(dhVar, 0, iN2, i13);
                }
                if (size2 > 0) {
                    iArr2 = dhVar.V;
                    if (iArr2[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr2[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int iN15 = dhVar.n();
                    dh dhVar13 = (dh) m6Var.c;
                    iMax3 = Math.max(iN15, dhVar13.e0);
                    iMax4 = Math.max(dhVar.i(), dhVar13.f0);
                    i15 = 0;
                    while (true) {
                        aVar = vg.a.f;
                        aVar2 = vg.a.d;
                        if (i15 < size2) {
                            break;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    i16 = 0;
                    while (i16 < 2) {
                        i17 = 0;
                        z7 = false;
                        while (i17 < size2) {
                            ArrayList arrayList14 = arrayList;
                            chVar = (ch) arrayList.get(i17);
                            int i31111 = size2;
                            if (chVar instanceof h8) {
                                z10 = z6;
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                z10 = z6;
                                if (chVar.j0 == 8) {
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    iN3 = chVar.n();
                                    i22 = chVar.i();
                                    z11 = z5;
                                    int i31112 = chVar.d0;
                                    i21 = i17;
                                    zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                    bVar3 = bVar;
                                    iN4 = chVar.n();
                                    i20 = i16;
                                    i23 = chVar.i();
                                    if (iN4 != iN3) {
                                        chVar.J(iN4);
                                        if (z11) {
                                            iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                        }
                                        zA = true;
                                    }
                                    if (i23 != i22) {
                                        chVar.G(i23);
                                        if (z10) {
                                            iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                        }
                                        zA = true;
                                    }
                                    if (chVar.F) {
                                        z7 = zA;
                                    } else {
                                        z7 = zA;
                                    }
                                }
                            }
                            i17 = i21 + 1;
                            arrayList = arrayList14;
                            size2 = i31111;
                            z6 = z10;
                            z5 = z11;
                            bVar = bVar3;
                            i16 = i20;
                        }
                        arrayList2 = arrayList;
                        i18 = size2;
                        z8 = z6;
                        z9 = z5;
                        bVar2 = bVar;
                        i19 = i16;
                        if (z7) {
                            break;
                            break;
                        }
                        i16 = i19 + 1;
                        m6Var.b(dhVar, i16, iN2, i13);
                        arrayList = arrayList2;
                        size2 = i18;
                        z6 = z8;
                        z5 = z9;
                        bVar = bVar2;
                    }
                }
                dhVar.F0 = i31110;
                oe0.p = dhVar.R(512);
            }
            if (childCount != 0) {
            }
            iMin2 = 0;
            iN = dhVar.n();
            iArr = dhVar.D;
            cmVar = dhVar.u0;
            i10 = iMin;
            if (i10 == iN) {
                cmVar.c = true;
                c = 1;
            } else {
                cmVar.c = true;
                c = 1;
            }
            dhVar.b0 = 0;
            dhVar.c0 = 0;
            iArr[0] = this.mMaxWidth - i7;
            iArr[c] = this.mMaxHeight - i6;
            dhVar.e0 = 0;
            dhVar.f0 = 0;
            dhVar.H(i8);
            dhVar.J(i10);
            dhVar.I(i9);
            dhVar.G(iMin2);
            i11 = this.mMinWidth - i7;
            if (i11 < 0) {
                i11 = 0;
            }
            dhVar.e0 = i11;
            i12 = this.mMinHeight - i6;
            if (i12 < 0) {
                i12 = 0;
            }
            dhVar.f0 = i12;
            dhVar.z0 = iMax10;
            dhVar.A0 = iMax5;
            m6Var = dhVar.t0;
            m6Var.getClass();
            bVar = dhVar.w0;
            size = dhVar.s0.size();
            iN2 = dhVar.n();
            i13 = dhVar.i();
            zX = e.x(i, 128);
            if (zX) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        chVar6 = (ch) dhVar.s0.get(i31);
                        iArr3 = chVar6.V;
                        z18 = z;
                        if (iArr3[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr3[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z19) {
                            z21 = false;
                        } else {
                            z21 = false;
                        }
                        if (chVar6.u()) {
                            i31++;
                            z = z18;
                        } else {
                            i31++;
                            z = z18;
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
            }
            z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
            if (z3) {
                iMin3 = Math.min(iArr[0], i4);
                iMin4 = Math.min(iArr[1], i5);
                if (mode == 1073741824) {
                    dhVar.J(iMin3);
                    cmVar.b = true;
                }
                if (mode2 == 1073741824) {
                    dhVar.G(iMin4);
                    cmVar.b = true;
                }
                if (mode == 1073741824) {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var11110 = chVar7.d;
                            g10Var11110.e.j = false;
                            g10Var11110.g = false;
                            g10Var11110.n();
                            kd1 kd1Var11110 = chVar7.e;
                            kd1Var11110.e.j = false;
                            kd1Var11110.g = false;
                            kd1Var11110.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var11111 = dhVar2.d;
                        g10Var11111.e.j = false;
                        g10Var11111.g = false;
                        g10Var11111.n();
                        kd1 kd1Var11111 = dhVar2.e;
                        kd1Var11111.e.j = false;
                        kd1Var11111.g = false;
                        kd1Var11111.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                } else {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var11112 = chVar7.d;
                            g10Var11112.e.j = false;
                            g10Var11112.g = false;
                            g10Var11112.n();
                            kd1 kd1Var11112 = chVar7.e;
                            kd1Var11112.e.j = false;
                            kd1Var11112.g = false;
                            kd1Var11112.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var11113 = dhVar2.d;
                        g10Var11113.e.j = false;
                        g10Var11113.g = false;
                        g10Var11113.n();
                        kd1 kd1Var11113 = dhVar2.e;
                        kd1Var11113.e.j = false;
                        kd1Var11113.g = false;
                        kd1Var11113.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                }
                if (zP) {
                    if (mode == i29) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i29) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    dhVar.K(z14, z15);
                }
            } else {
                z4 = z3;
                i14 = 0;
                zP = false;
            }
            if (zP) {
            }
            int i31113 = dhVar.F0;
            if (size > 0) {
                size3 = dhVar.s0.size();
                zR = dhVar.R(64);
                bVar4 = dhVar.w0;
                i24 = 0;
                while (i24 < size3) {
                    chVar5 = (ch) dhVar.s0.get(i24);
                    if (chVar5 instanceof py) {
                        i27 = size3;
                    } else {
                        chVar5.getClass();
                        if (zR) {
                        }
                        iH = chVar5.h(0);
                        int iH14 = chVar5.h(1);
                        i27 = size3;
                        if (iH == 3) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                        }
                        if (z12) {
                            m6Var.a(0, chVar5, bVar4);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = bVar4.a;
                childCount2 = constraintLayout.getChildCount();
                arrayList3 = constraintLayout.mConstraintHelpers;
                i25 = 0;
                while (i25 < childCount2) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof d) {
                        dVar = (d) childAt;
                        if (dVar.c == null) {
                            a aVar14 = (a) dVar.getLayoutParams();
                            aVar3 = (a) dVar.c.getLayoutParams();
                            chVar2 = aVar3.q0;
                            chVar2.j0 = 0;
                            chVar3 = aVar14.q0;
                            if (chVar3.V[0] != 1) {
                                chVar3.J(chVar2.n());
                            }
                            chVar4 = aVar14.q0;
                            if (chVar4.V[1] != 1) {
                                chVar4.G(aVar3.q0.i());
                            }
                            aVar3.q0.j0 = 8;
                        }
                    }
                    i25++;
                    constraintLayout = constraintLayout;
                }
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                    }
                }
            }
            m6Var.c(dhVar);
            arrayList = (ArrayList) m6Var.a;
            size2 = arrayList.size();
            if (size > 0) {
                m6Var.b(dhVar, 0, iN2, i13);
            }
            if (size2 > 0) {
                iArr2 = dhVar.V;
                if (iArr2[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr2[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int iN16 = dhVar.n();
                dh dhVar14 = (dh) m6Var.c;
                iMax3 = Math.max(iN16, dhVar14.e0);
                iMax4 = Math.max(dhVar.i(), dhVar14.f0);
                i15 = 0;
                while (true) {
                    aVar = vg.a.f;
                    aVar2 = vg.a.d;
                    if (i15 < size2) {
                        break;
                        break;
                    } else {
                        i15++;
                    }
                }
                i16 = 0;
                while (i16 < 2) {
                    i17 = 0;
                    z7 = false;
                    while (i17 < size2) {
                        ArrayList arrayList15 = arrayList;
                        chVar = (ch) arrayList.get(i17);
                        int i31114 = size2;
                        if (chVar instanceof h8) {
                            z10 = z6;
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            z10 = z6;
                            if (chVar.j0 == 8) {
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                iN3 = chVar.n();
                                i22 = chVar.i();
                                z11 = z5;
                                int i31115 = chVar.d0;
                                i21 = i17;
                                zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                bVar3 = bVar;
                                iN4 = chVar.n();
                                i20 = i16;
                                i23 = chVar.i();
                                if (iN4 != iN3) {
                                    chVar.J(iN4);
                                    if (z11) {
                                        iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                    }
                                    zA = true;
                                }
                                if (i23 != i22) {
                                    chVar.G(i23);
                                    if (z10) {
                                        iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                    }
                                    zA = true;
                                }
                                if (chVar.F) {
                                    z7 = zA;
                                } else {
                                    z7 = zA;
                                }
                            }
                        }
                        i17 = i21 + 1;
                        arrayList = arrayList15;
                        size2 = i31114;
                        z6 = z10;
                        z5 = z11;
                        bVar = bVar3;
                        i16 = i20;
                    }
                    arrayList2 = arrayList;
                    i18 = size2;
                    z8 = z6;
                    z9 = z5;
                    bVar2 = bVar;
                    i19 = i16;
                    if (z7) {
                        break;
                        break;
                    }
                    i16 = i19 + 1;
                    m6Var.b(dhVar, i16, iN2, i13);
                    arrayList = arrayList2;
                    size2 = i18;
                    z6 = z8;
                    z5 = z9;
                    bVar = bVar2;
                }
            }
            dhVar.F0 = i31113;
            oe0.p = dhVar.R(512);
            iMax2 = Math.max(0, this.mMinHeight);
            iMin2 = iMax2;
            i9 = 2;
            iN = dhVar.n();
            iArr = dhVar.D;
            cmVar = dhVar.u0;
            i10 = iMin;
            if (i10 == iN) {
                cmVar.c = true;
                c = 1;
            } else {
                cmVar.c = true;
                c = 1;
            }
            dhVar.b0 = 0;
            dhVar.c0 = 0;
            iArr[0] = this.mMaxWidth - i7;
            iArr[c] = this.mMaxHeight - i6;
            dhVar.e0 = 0;
            dhVar.f0 = 0;
            dhVar.H(i8);
            dhVar.J(i10);
            dhVar.I(i9);
            dhVar.G(iMin2);
            i11 = this.mMinWidth - i7;
            if (i11 < 0) {
                i11 = 0;
            }
            dhVar.e0 = i11;
            i12 = this.mMinHeight - i6;
            if (i12 < 0) {
                i12 = 0;
            }
            dhVar.f0 = i12;
            dhVar.z0 = iMax10;
            dhVar.A0 = iMax5;
            m6Var = dhVar.t0;
            m6Var.getClass();
            bVar = dhVar.w0;
            size = dhVar.s0.size();
            iN2 = dhVar.n();
            i13 = dhVar.i();
            zX = e.x(i, 128);
            if (zX) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        chVar6 = (ch) dhVar.s0.get(i31);
                        iArr3 = chVar6.V;
                        z18 = z;
                        if (iArr3[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr3[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z19) {
                            z21 = false;
                        } else {
                            z21 = false;
                        }
                        if (chVar6.u()) {
                            i31++;
                            z = z18;
                        } else {
                            i31++;
                            z = z18;
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
            }
            z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
            if (z3) {
                iMin3 = Math.min(iArr[0], i4);
                iMin4 = Math.min(iArr[1], i5);
                if (mode == 1073741824) {
                    dhVar.J(iMin3);
                    cmVar.b = true;
                }
                if (mode2 == 1073741824) {
                    dhVar.G(iMin4);
                    cmVar.b = true;
                }
                if (mode == 1073741824) {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var11114 = chVar7.d;
                            g10Var11114.e.j = false;
                            g10Var11114.g = false;
                            g10Var11114.n();
                            kd1 kd1Var11114 = chVar7.e;
                            kd1Var11114.e.j = false;
                            kd1Var11114.g = false;
                            kd1Var11114.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var11115 = dhVar2.d;
                        g10Var11115.e.j = false;
                        g10Var11115.g = false;
                        g10Var11115.n();
                        kd1 kd1Var11115 = dhVar2.e;
                        kd1Var11115.e.j = false;
                        kd1Var11115.g = false;
                        kd1Var11115.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                } else {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var11116 = chVar7.d;
                            g10Var11116.e.j = false;
                            g10Var11116.g = false;
                            g10Var11116.n();
                            kd1 kd1Var11116 = chVar7.e;
                            kd1Var11116.e.j = false;
                            kd1Var11116.g = false;
                            kd1Var11116.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var11117 = dhVar2.d;
                        g10Var11117.e.j = false;
                        g10Var11117.g = false;
                        g10Var11117.n();
                        kd1 kd1Var11117 = dhVar2.e;
                        kd1Var11117.e.j = false;
                        kd1Var11117.g = false;
                        kd1Var11117.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                }
                if (zP) {
                    if (mode == i29) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i29) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    dhVar.K(z14, z15);
                }
            } else {
                z4 = z3;
                i14 = 0;
                zP = false;
            }
            if (zP) {
            }
            int i31116 = dhVar.F0;
            if (size > 0) {
                size3 = dhVar.s0.size();
                zR = dhVar.R(64);
                bVar4 = dhVar.w0;
                i24 = 0;
                while (i24 < size3) {
                    chVar5 = (ch) dhVar.s0.get(i24);
                    if (chVar5 instanceof py) {
                        i27 = size3;
                    } else {
                        chVar5.getClass();
                        if (zR) {
                        }
                        iH = chVar5.h(0);
                        int iH15 = chVar5.h(1);
                        i27 = size3;
                        if (iH == 3) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                        }
                        if (z12) {
                            m6Var.a(0, chVar5, bVar4);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = bVar4.a;
                childCount2 = constraintLayout.getChildCount();
                arrayList3 = constraintLayout.mConstraintHelpers;
                i25 = 0;
                while (i25 < childCount2) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof d) {
                        dVar = (d) childAt;
                        if (dVar.c == null) {
                            a aVar15 = (a) dVar.getLayoutParams();
                            aVar3 = (a) dVar.c.getLayoutParams();
                            chVar2 = aVar3.q0;
                            chVar2.j0 = 0;
                            chVar3 = aVar15.q0;
                            if (chVar3.V[0] != 1) {
                                chVar3.J(chVar2.n());
                            }
                            chVar4 = aVar15.q0;
                            if (chVar4.V[1] != 1) {
                                chVar4.G(aVar3.q0.i());
                            }
                            aVar3.q0.j0 = 8;
                        }
                    }
                    i25++;
                    constraintLayout = constraintLayout;
                }
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                    }
                }
            }
            m6Var.c(dhVar);
            arrayList = (ArrayList) m6Var.a;
            size2 = arrayList.size();
            if (size > 0) {
                m6Var.b(dhVar, 0, iN2, i13);
            }
            if (size2 > 0) {
                iArr2 = dhVar.V;
                if (iArr2[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr2[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int iN17 = dhVar.n();
                dh dhVar15 = (dh) m6Var.c;
                iMax3 = Math.max(iN17, dhVar15.e0);
                iMax4 = Math.max(dhVar.i(), dhVar15.f0);
                i15 = 0;
                while (true) {
                    aVar = vg.a.f;
                    aVar2 = vg.a.d;
                    if (i15 < size2) {
                        break;
                        break;
                    } else {
                        i15++;
                    }
                }
                i16 = 0;
                while (i16 < 2) {
                    i17 = 0;
                    z7 = false;
                    while (i17 < size2) {
                        ArrayList arrayList16 = arrayList;
                        chVar = (ch) arrayList.get(i17);
                        int i31117 = size2;
                        if (chVar instanceof h8) {
                            z10 = z6;
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            z10 = z6;
                            if (chVar.j0 == 8) {
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                iN3 = chVar.n();
                                i22 = chVar.i();
                                z11 = z5;
                                int i31118 = chVar.d0;
                                i21 = i17;
                                zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                bVar3 = bVar;
                                iN4 = chVar.n();
                                i20 = i16;
                                i23 = chVar.i();
                                if (iN4 != iN3) {
                                    chVar.J(iN4);
                                    if (z11) {
                                        iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                    }
                                    zA = true;
                                }
                                if (i23 != i22) {
                                    chVar.G(i23);
                                    if (z10) {
                                        iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                    }
                                    zA = true;
                                }
                                if (chVar.F) {
                                    z7 = zA;
                                } else {
                                    z7 = zA;
                                }
                            }
                        }
                        i17 = i21 + 1;
                        arrayList = arrayList16;
                        size2 = i31117;
                        z6 = z10;
                        z5 = z11;
                        bVar = bVar3;
                        i16 = i20;
                    }
                    arrayList2 = arrayList;
                    i18 = size2;
                    z8 = z6;
                    z9 = z5;
                    bVar2 = bVar;
                    i19 = i16;
                    if (z7) {
                        break;
                        break;
                    }
                    i16 = i19 + 1;
                    m6Var.b(dhVar, i16, iN2, i13);
                    arrayList = arrayList2;
                    size2 = i18;
                    z6 = z8;
                    z5 = z9;
                    bVar = bVar2;
                }
            }
            dhVar.F0 = i31116;
            oe0.p = dhVar.R(512);
            iMax = Math.max(0, this.mMinWidth);
            iMin = iMax;
            i8 = 2;
            if (mode2 != Integer.MIN_VALUE) {
                if (childCount == 0) {
                    iMax2 = i5;
                }
                iMin2 = iMax2;
                i9 = 2;
                iN = dhVar.n();
                iArr = dhVar.D;
                cmVar = dhVar.u0;
                i10 = iMin;
                if (i10 == iN) {
                    cmVar.c = true;
                    c = 1;
                } else {
                    cmVar.c = true;
                    c = 1;
                }
                dhVar.b0 = 0;
                dhVar.c0 = 0;
                iArr[0] = this.mMaxWidth - i7;
                iArr[c] = this.mMaxHeight - i6;
                dhVar.e0 = 0;
                dhVar.f0 = 0;
                dhVar.H(i8);
                dhVar.J(i10);
                dhVar.I(i9);
                dhVar.G(iMin2);
                i11 = this.mMinWidth - i7;
                if (i11 < 0) {
                    i11 = 0;
                }
                dhVar.e0 = i11;
                i12 = this.mMinHeight - i6;
                if (i12 < 0) {
                    i12 = 0;
                }
                dhVar.f0 = i12;
                dhVar.z0 = iMax10;
                dhVar.A0 = iMax5;
                m6Var = dhVar.t0;
                m6Var.getClass();
                bVar = dhVar.w0;
                size = dhVar.s0.size();
                iN2 = dhVar.n();
                i13 = dhVar.i();
                zX = e.x(i, 128);
                if (zX) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            chVar6 = (ch) dhVar.s0.get(i31);
                            iArr3 = chVar6.V;
                            z18 = z;
                            if (iArr3[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr3[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z19) {
                                z21 = false;
                            } else {
                                z21 = false;
                            }
                            if (chVar6.u()) {
                                i31++;
                                z = z18;
                            } else {
                                i31++;
                                z = z18;
                            }
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                    }
                } else {
                    z2 = z;
                }
                z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                if (z3) {
                    iMin3 = Math.min(iArr[0], i4);
                    iMin4 = Math.min(iArr[1], i5);
                    if (mode == 1073741824) {
                        dhVar.J(iMin3);
                        cmVar.b = true;
                    }
                    if (mode2 == 1073741824) {
                        dhVar.G(iMin4);
                        cmVar.b = true;
                    }
                    if (mode == 1073741824) {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var11118 = chVar7.d;
                                g10Var11118.e.j = false;
                                g10Var11118.g = false;
                                g10Var11118.n();
                                kd1 kd1Var11118 = chVar7.e;
                                kd1Var11118.e.j = false;
                                kd1Var11118.g = false;
                                kd1Var11118.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var11119 = dhVar2.d;
                            g10Var11119.e.j = false;
                            g10Var11119.g = false;
                            g10Var11119.n();
                            kd1 kd1Var11119 = dhVar2.e;
                            kd1Var11119.e.j = false;
                            kd1Var11119.g = false;
                            kd1Var11119.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    } else {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var111110 = chVar7.d;
                                g10Var111110.e.j = false;
                                g10Var111110.g = false;
                                g10Var111110.n();
                                kd1 kd1Var111110 = chVar7.e;
                                kd1Var111110.e.j = false;
                                kd1Var111110.g = false;
                                kd1Var111110.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var111111 = dhVar2.d;
                            g10Var111111.e.j = false;
                            g10Var111111.g = false;
                            g10Var111111.n();
                            kd1 kd1Var111111 = dhVar2.e;
                            kd1Var111111.e.j = false;
                            kd1Var111111.g = false;
                            kd1Var111111.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    }
                    if (zP) {
                        if (mode == i29) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i29) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        dhVar.K(z14, z15);
                    }
                } else {
                    z4 = z3;
                    i14 = 0;
                    zP = false;
                }
                if (zP) {
                }
                int i31119 = dhVar.F0;
                if (size > 0) {
                    size3 = dhVar.s0.size();
                    zR = dhVar.R(64);
                    bVar4 = dhVar.w0;
                    i24 = 0;
                    while (i24 < size3) {
                        chVar5 = (ch) dhVar.s0.get(i24);
                        if (chVar5 instanceof py) {
                            i27 = size3;
                        } else {
                            chVar5.getClass();
                            if (zR) {
                            }
                            iH = chVar5.h(0);
                            int iH16 = chVar5.h(1);
                            i27 = size3;
                            if (iH == 3) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                            }
                            if (z12) {
                                m6Var.a(0, chVar5, bVar4);
                            }
                        }
                        i24++;
                        size3 = i27;
                    }
                    constraintLayout = bVar4.a;
                    childCount2 = constraintLayout.getChildCount();
                    arrayList3 = constraintLayout.mConstraintHelpers;
                    i25 = 0;
                    while (i25 < childCount2) {
                        childAt = constraintLayout.getChildAt(i25);
                        if (childAt instanceof d) {
                            dVar = (d) childAt;
                            if (dVar.c == null) {
                                a aVar16 = (a) dVar.getLayoutParams();
                                aVar3 = (a) dVar.c.getLayoutParams();
                                chVar2 = aVar3.q0;
                                chVar2.j0 = 0;
                                chVar3 = aVar16.q0;
                                if (chVar3.V[0] != 1) {
                                    chVar3.J(chVar2.n());
                                }
                                chVar4 = aVar16.q0;
                                if (chVar4.V[1] != 1) {
                                    chVar4.G(aVar3.q0.i());
                                }
                                aVar3.q0.j0 = 8;
                            }
                        }
                        i25++;
                        constraintLayout = constraintLayout;
                    }
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i26 < size4) {
                            ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                        }
                    }
                }
                m6Var.c(dhVar);
                arrayList = (ArrayList) m6Var.a;
                size2 = arrayList.size();
                if (size > 0) {
                    m6Var.b(dhVar, 0, iN2, i13);
                }
                if (size2 > 0) {
                    iArr2 = dhVar.V;
                    if (iArr2[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr2[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int iN18 = dhVar.n();
                    dh dhVar16 = (dh) m6Var.c;
                    iMax3 = Math.max(iN18, dhVar16.e0);
                    iMax4 = Math.max(dhVar.i(), dhVar16.f0);
                    i15 = 0;
                    while (true) {
                        aVar = vg.a.f;
                        aVar2 = vg.a.d;
                        if (i15 < size2) {
                            break;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    i16 = 0;
                    while (i16 < 2) {
                        i17 = 0;
                        z7 = false;
                        while (i17 < size2) {
                            ArrayList arrayList17 = arrayList;
                            chVar = (ch) arrayList.get(i17);
                            int i311110 = size2;
                            if (chVar instanceof h8) {
                                z10 = z6;
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                z10 = z6;
                                if (chVar.j0 == 8) {
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    iN3 = chVar.n();
                                    i22 = chVar.i();
                                    z11 = z5;
                                    int i311111 = chVar.d0;
                                    i21 = i17;
                                    zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                    bVar3 = bVar;
                                    iN4 = chVar.n();
                                    i20 = i16;
                                    i23 = chVar.i();
                                    if (iN4 != iN3) {
                                        chVar.J(iN4);
                                        if (z11) {
                                            iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                        }
                                        zA = true;
                                    }
                                    if (i23 != i22) {
                                        chVar.G(i23);
                                        if (z10) {
                                            iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                        }
                                        zA = true;
                                    }
                                    if (chVar.F) {
                                        z7 = zA;
                                    } else {
                                        z7 = zA;
                                    }
                                }
                            }
                            i17 = i21 + 1;
                            arrayList = arrayList17;
                            size2 = i311110;
                            z6 = z10;
                            z5 = z11;
                            bVar = bVar3;
                            i16 = i20;
                        }
                        arrayList2 = arrayList;
                        i18 = size2;
                        z8 = z6;
                        z9 = z5;
                        bVar2 = bVar;
                        i19 = i16;
                        if (z7) {
                            break;
                            break;
                        }
                        i16 = i19 + 1;
                        m6Var.b(dhVar, i16, iN2, i13);
                        arrayList = arrayList2;
                        size2 = i18;
                        z6 = z8;
                        z5 = z9;
                        bVar = bVar2;
                    }
                }
                dhVar.F0 = i31119;
                oe0.p = dhVar.R(512);
            }
            if (mode2 != 0) {
                if (mode2 != 1073741824) {
                    iMin2 = Math.min(this.mMaxHeight - i6, i5);
                    i9 = 1;
                }
                iN = dhVar.n();
                iArr = dhVar.D;
                cmVar = dhVar.u0;
                i10 = iMin;
                if (i10 == iN) {
                    cmVar.c = true;
                    c = 1;
                } else {
                    cmVar.c = true;
                    c = 1;
                }
                dhVar.b0 = 0;
                dhVar.c0 = 0;
                iArr[0] = this.mMaxWidth - i7;
                iArr[c] = this.mMaxHeight - i6;
                dhVar.e0 = 0;
                dhVar.f0 = 0;
                dhVar.H(i8);
                dhVar.J(i10);
                dhVar.I(i9);
                dhVar.G(iMin2);
                i11 = this.mMinWidth - i7;
                if (i11 < 0) {
                    i11 = 0;
                }
                dhVar.e0 = i11;
                i12 = this.mMinHeight - i6;
                if (i12 < 0) {
                    i12 = 0;
                }
                dhVar.f0 = i12;
                dhVar.z0 = iMax10;
                dhVar.A0 = iMax5;
                m6Var = dhVar.t0;
                m6Var.getClass();
                bVar = dhVar.w0;
                size = dhVar.s0.size();
                iN2 = dhVar.n();
                i13 = dhVar.i();
                zX = e.x(i, 128);
                if (zX) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            chVar6 = (ch) dhVar.s0.get(i31);
                            iArr3 = chVar6.V;
                            z18 = z;
                            if (iArr3[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr3[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z19) {
                                z21 = false;
                            } else {
                                z21 = false;
                            }
                            if (chVar6.u()) {
                                i31++;
                                z = z18;
                            } else {
                                i31++;
                                z = z18;
                            }
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                    }
                } else {
                    z2 = z;
                }
                z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                if (z3) {
                    iMin3 = Math.min(iArr[0], i4);
                    iMin4 = Math.min(iArr[1], i5);
                    if (mode == 1073741824) {
                        dhVar.J(iMin3);
                        cmVar.b = true;
                    }
                    if (mode2 == 1073741824) {
                        dhVar.G(iMin4);
                        cmVar.b = true;
                    }
                    if (mode == 1073741824) {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var111112 = chVar7.d;
                                g10Var111112.e.j = false;
                                g10Var111112.g = false;
                                g10Var111112.n();
                                kd1 kd1Var111112 = chVar7.e;
                                kd1Var111112.e.j = false;
                                kd1Var111112.g = false;
                                kd1Var111112.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var111113 = dhVar2.d;
                            g10Var111113.e.j = false;
                            g10Var111113.g = false;
                            g10Var111113.n();
                            kd1 kd1Var111113 = dhVar2.e;
                            kd1Var111113.e.j = false;
                            kd1Var111113.g = false;
                            kd1Var111113.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    } else {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var111114 = chVar7.d;
                                g10Var111114.e.j = false;
                                g10Var111114.g = false;
                                g10Var111114.n();
                                kd1 kd1Var111114 = chVar7.e;
                                kd1Var111114.e.j = false;
                                kd1Var111114.g = false;
                                kd1Var111114.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var111115 = dhVar2.d;
                            g10Var111115.e.j = false;
                            g10Var111115.g = false;
                            g10Var111115.n();
                            kd1 kd1Var111115 = dhVar2.e;
                            kd1Var111115.e.j = false;
                            kd1Var111115.g = false;
                            kd1Var111115.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    }
                    if (zP) {
                        if (mode == i29) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i29) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        dhVar.K(z14, z15);
                    }
                } else {
                    z4 = z3;
                    i14 = 0;
                    zP = false;
                }
                if (zP) {
                }
                int i311112 = dhVar.F0;
                if (size > 0) {
                    size3 = dhVar.s0.size();
                    zR = dhVar.R(64);
                    bVar4 = dhVar.w0;
                    i24 = 0;
                    while (i24 < size3) {
                        chVar5 = (ch) dhVar.s0.get(i24);
                        if (chVar5 instanceof py) {
                            i27 = size3;
                        } else {
                            chVar5.getClass();
                            if (zR) {
                            }
                            iH = chVar5.h(0);
                            int iH17 = chVar5.h(1);
                            i27 = size3;
                            if (iH == 3) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                            }
                            if (z12) {
                                m6Var.a(0, chVar5, bVar4);
                            }
                        }
                        i24++;
                        size3 = i27;
                    }
                    constraintLayout = bVar4.a;
                    childCount2 = constraintLayout.getChildCount();
                    arrayList3 = constraintLayout.mConstraintHelpers;
                    i25 = 0;
                    while (i25 < childCount2) {
                        childAt = constraintLayout.getChildAt(i25);
                        if (childAt instanceof d) {
                            dVar = (d) childAt;
                            if (dVar.c == null) {
                                a aVar17 = (a) dVar.getLayoutParams();
                                aVar3 = (a) dVar.c.getLayoutParams();
                                chVar2 = aVar3.q0;
                                chVar2.j0 = 0;
                                chVar3 = aVar17.q0;
                                if (chVar3.V[0] != 1) {
                                    chVar3.J(chVar2.n());
                                }
                                chVar4 = aVar17.q0;
                                if (chVar4.V[1] != 1) {
                                    chVar4.G(aVar3.q0.i());
                                }
                                aVar3.q0.j0 = 8;
                            }
                        }
                        i25++;
                        constraintLayout = constraintLayout;
                    }
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i26 < size4) {
                            ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                        }
                    }
                }
                m6Var.c(dhVar);
                arrayList = (ArrayList) m6Var.a;
                size2 = arrayList.size();
                if (size > 0) {
                    m6Var.b(dhVar, 0, iN2, i13);
                }
                if (size2 > 0) {
                    iArr2 = dhVar.V;
                    if (iArr2[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr2[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int iN19 = dhVar.n();
                    dh dhVar17 = (dh) m6Var.c;
                    iMax3 = Math.max(iN19, dhVar17.e0);
                    iMax4 = Math.max(dhVar.i(), dhVar17.f0);
                    i15 = 0;
                    while (true) {
                        aVar = vg.a.f;
                        aVar2 = vg.a.d;
                        if (i15 < size2) {
                            break;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    i16 = 0;
                    while (i16 < 2) {
                        i17 = 0;
                        z7 = false;
                        while (i17 < size2) {
                            ArrayList arrayList18 = arrayList;
                            chVar = (ch) arrayList.get(i17);
                            int i311113 = size2;
                            if (chVar instanceof h8) {
                                z10 = z6;
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                z10 = z6;
                                if (chVar.j0 == 8) {
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    iN3 = chVar.n();
                                    i22 = chVar.i();
                                    z11 = z5;
                                    int i311114 = chVar.d0;
                                    i21 = i17;
                                    zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                    bVar3 = bVar;
                                    iN4 = chVar.n();
                                    i20 = i16;
                                    i23 = chVar.i();
                                    if (iN4 != iN3) {
                                        chVar.J(iN4);
                                        if (z11) {
                                            iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                        }
                                        zA = true;
                                    }
                                    if (i23 != i22) {
                                        chVar.G(i23);
                                        if (z10) {
                                            iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                        }
                                        zA = true;
                                    }
                                    if (chVar.F) {
                                        z7 = zA;
                                    } else {
                                        z7 = zA;
                                    }
                                }
                            }
                            i17 = i21 + 1;
                            arrayList = arrayList18;
                            size2 = i311113;
                            z6 = z10;
                            z5 = z11;
                            bVar = bVar3;
                            i16 = i20;
                        }
                        arrayList2 = arrayList;
                        i18 = size2;
                        z8 = z6;
                        z9 = z5;
                        bVar2 = bVar;
                        i19 = i16;
                        if (z7) {
                            break;
                            break;
                        }
                        i16 = i19 + 1;
                        m6Var.b(dhVar, i16, iN2, i13);
                        arrayList = arrayList2;
                        size2 = i18;
                        z6 = z8;
                        z5 = z9;
                        bVar = bVar2;
                    }
                }
                dhVar.F0 = i311112;
                oe0.p = dhVar.R(512);
            }
            if (childCount != 0) {
            }
            iMin2 = 0;
            iN = dhVar.n();
            iArr = dhVar.D;
            cmVar = dhVar.u0;
            i10 = iMin;
            if (i10 == iN) {
                cmVar.c = true;
                c = 1;
            } else {
                cmVar.c = true;
                c = 1;
            }
            dhVar.b0 = 0;
            dhVar.c0 = 0;
            iArr[0] = this.mMaxWidth - i7;
            iArr[c] = this.mMaxHeight - i6;
            dhVar.e0 = 0;
            dhVar.f0 = 0;
            dhVar.H(i8);
            dhVar.J(i10);
            dhVar.I(i9);
            dhVar.G(iMin2);
            i11 = this.mMinWidth - i7;
            if (i11 < 0) {
                i11 = 0;
            }
            dhVar.e0 = i11;
            i12 = this.mMinHeight - i6;
            if (i12 < 0) {
                i12 = 0;
            }
            dhVar.f0 = i12;
            dhVar.z0 = iMax10;
            dhVar.A0 = iMax5;
            m6Var = dhVar.t0;
            m6Var.getClass();
            bVar = dhVar.w0;
            size = dhVar.s0.size();
            iN2 = dhVar.n();
            i13 = dhVar.i();
            zX = e.x(i, 128);
            if (zX) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        chVar6 = (ch) dhVar.s0.get(i31);
                        iArr3 = chVar6.V;
                        z18 = z;
                        if (iArr3[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr3[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z19) {
                            z21 = false;
                        } else {
                            z21 = false;
                        }
                        if (chVar6.u()) {
                            i31++;
                            z = z18;
                        } else {
                            i31++;
                            z = z18;
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
            }
            z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
            if (z3) {
                iMin3 = Math.min(iArr[0], i4);
                iMin4 = Math.min(iArr[1], i5);
                if (mode == 1073741824) {
                    dhVar.J(iMin3);
                    cmVar.b = true;
                }
                if (mode2 == 1073741824) {
                    dhVar.G(iMin4);
                    cmVar.b = true;
                }
                if (mode == 1073741824) {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var111116 = chVar7.d;
                            g10Var111116.e.j = false;
                            g10Var111116.g = false;
                            g10Var111116.n();
                            kd1 kd1Var111116 = chVar7.e;
                            kd1Var111116.e.j = false;
                            kd1Var111116.g = false;
                            kd1Var111116.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var111117 = dhVar2.d;
                        g10Var111117.e.j = false;
                        g10Var111117.g = false;
                        g10Var111117.n();
                        kd1 kd1Var111117 = dhVar2.e;
                        kd1Var111117.e.j = false;
                        kd1Var111117.g = false;
                        kd1Var111117.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                } else {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var111118 = chVar7.d;
                            g10Var111118.e.j = false;
                            g10Var111118.g = false;
                            g10Var111118.n();
                            kd1 kd1Var111118 = chVar7.e;
                            kd1Var111118.e.j = false;
                            kd1Var111118.g = false;
                            kd1Var111118.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var111119 = dhVar2.d;
                        g10Var111119.e.j = false;
                        g10Var111119.g = false;
                        g10Var111119.n();
                        kd1 kd1Var111119 = dhVar2.e;
                        kd1Var111119.e.j = false;
                        kd1Var111119.g = false;
                        kd1Var111119.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                }
                if (zP) {
                    if (mode == i29) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i29) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    dhVar.K(z14, z15);
                }
            } else {
                z4 = z3;
                i14 = 0;
                zP = false;
            }
            if (zP) {
            }
            int i311115 = dhVar.F0;
            if (size > 0) {
                size3 = dhVar.s0.size();
                zR = dhVar.R(64);
                bVar4 = dhVar.w0;
                i24 = 0;
                while (i24 < size3) {
                    chVar5 = (ch) dhVar.s0.get(i24);
                    if (chVar5 instanceof py) {
                        i27 = size3;
                    } else {
                        chVar5.getClass();
                        if (zR) {
                        }
                        iH = chVar5.h(0);
                        int iH18 = chVar5.h(1);
                        i27 = size3;
                        if (iH == 3) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                        }
                        if (z12) {
                            m6Var.a(0, chVar5, bVar4);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = bVar4.a;
                childCount2 = constraintLayout.getChildCount();
                arrayList3 = constraintLayout.mConstraintHelpers;
                i25 = 0;
                while (i25 < childCount2) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof d) {
                        dVar = (d) childAt;
                        if (dVar.c == null) {
                            a aVar18 = (a) dVar.getLayoutParams();
                            aVar3 = (a) dVar.c.getLayoutParams();
                            chVar2 = aVar3.q0;
                            chVar2.j0 = 0;
                            chVar3 = aVar18.q0;
                            if (chVar3.V[0] != 1) {
                                chVar3.J(chVar2.n());
                            }
                            chVar4 = aVar18.q0;
                            if (chVar4.V[1] != 1) {
                                chVar4.G(aVar3.q0.i());
                            }
                            aVar3.q0.j0 = 8;
                        }
                    }
                    i25++;
                    constraintLayout = constraintLayout;
                }
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                    }
                }
            }
            m6Var.c(dhVar);
            arrayList = (ArrayList) m6Var.a;
            size2 = arrayList.size();
            if (size > 0) {
                m6Var.b(dhVar, 0, iN2, i13);
            }
            if (size2 > 0) {
                iArr2 = dhVar.V;
                if (iArr2[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr2[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int iN110 = dhVar.n();
                dh dhVar18 = (dh) m6Var.c;
                iMax3 = Math.max(iN110, dhVar18.e0);
                iMax4 = Math.max(dhVar.i(), dhVar18.f0);
                i15 = 0;
                while (true) {
                    aVar = vg.a.f;
                    aVar2 = vg.a.d;
                    if (i15 < size2) {
                        break;
                        break;
                    } else {
                        i15++;
                    }
                }
                i16 = 0;
                while (i16 < 2) {
                    i17 = 0;
                    z7 = false;
                    while (i17 < size2) {
                        ArrayList arrayList19 = arrayList;
                        chVar = (ch) arrayList.get(i17);
                        int i311116 = size2;
                        if (chVar instanceof h8) {
                            z10 = z6;
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            z10 = z6;
                            if (chVar.j0 == 8) {
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                iN3 = chVar.n();
                                i22 = chVar.i();
                                z11 = z5;
                                int i311117 = chVar.d0;
                                i21 = i17;
                                zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                bVar3 = bVar;
                                iN4 = chVar.n();
                                i20 = i16;
                                i23 = chVar.i();
                                if (iN4 != iN3) {
                                    chVar.J(iN4);
                                    if (z11) {
                                        iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                    }
                                    zA = true;
                                }
                                if (i23 != i22) {
                                    chVar.G(i23);
                                    if (z10) {
                                        iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                    }
                                    zA = true;
                                }
                                if (chVar.F) {
                                    z7 = zA;
                                } else {
                                    z7 = zA;
                                }
                            }
                        }
                        i17 = i21 + 1;
                        arrayList = arrayList19;
                        size2 = i311116;
                        z6 = z10;
                        z5 = z11;
                        bVar = bVar3;
                        i16 = i20;
                    }
                    arrayList2 = arrayList;
                    i18 = size2;
                    z8 = z6;
                    z9 = z5;
                    bVar2 = bVar;
                    i19 = i16;
                    if (z7) {
                        break;
                        break;
                    }
                    i16 = i19 + 1;
                    m6Var.b(dhVar, i16, iN2, i13);
                    arrayList = arrayList2;
                    size2 = i18;
                    z6 = z8;
                    z5 = z9;
                    bVar = bVar2;
                }
            }
            dhVar.F0 = i311115;
            oe0.p = dhVar.R(512);
            iMax2 = Math.max(0, this.mMinHeight);
            iMin2 = iMax2;
            i9 = 2;
            iN = dhVar.n();
            iArr = dhVar.D;
            cmVar = dhVar.u0;
            i10 = iMin;
            if (i10 == iN) {
                cmVar.c = true;
                c = 1;
            } else {
                cmVar.c = true;
                c = 1;
            }
            dhVar.b0 = 0;
            dhVar.c0 = 0;
            iArr[0] = this.mMaxWidth - i7;
            iArr[c] = this.mMaxHeight - i6;
            dhVar.e0 = 0;
            dhVar.f0 = 0;
            dhVar.H(i8);
            dhVar.J(i10);
            dhVar.I(i9);
            dhVar.G(iMin2);
            i11 = this.mMinWidth - i7;
            if (i11 < 0) {
                i11 = 0;
            }
            dhVar.e0 = i11;
            i12 = this.mMinHeight - i6;
            if (i12 < 0) {
                i12 = 0;
            }
            dhVar.f0 = i12;
            dhVar.z0 = iMax10;
            dhVar.A0 = iMax5;
            m6Var = dhVar.t0;
            m6Var.getClass();
            bVar = dhVar.w0;
            size = dhVar.s0.size();
            iN2 = dhVar.n();
            i13 = dhVar.i();
            zX = e.x(i, 128);
            if (zX) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        chVar6 = (ch) dhVar.s0.get(i31);
                        iArr3 = chVar6.V;
                        z18 = z;
                        if (iArr3[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr3[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z19) {
                            z21 = false;
                        } else {
                            z21 = false;
                        }
                        if (chVar6.u()) {
                            i31++;
                            z = z18;
                        } else {
                            i31++;
                            z = z18;
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
            }
            z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
            if (z3) {
                iMin3 = Math.min(iArr[0], i4);
                iMin4 = Math.min(iArr[1], i5);
                if (mode == 1073741824) {
                    dhVar.J(iMin3);
                    cmVar.b = true;
                }
                if (mode2 == 1073741824) {
                    dhVar.G(iMin4);
                    cmVar.b = true;
                }
                if (mode == 1073741824) {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var1111110 = chVar7.d;
                            g10Var1111110.e.j = false;
                            g10Var1111110.g = false;
                            g10Var1111110.n();
                            kd1 kd1Var1111110 = chVar7.e;
                            kd1Var1111110.e.j = false;
                            kd1Var1111110.g = false;
                            kd1Var1111110.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var1111111 = dhVar2.d;
                        g10Var1111111.e.j = false;
                        g10Var1111111.g = false;
                        g10Var1111111.n();
                        kd1 kd1Var1111111 = dhVar2.e;
                        kd1Var1111111.e.j = false;
                        kd1Var1111111.g = false;
                        kd1Var1111111.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                } else {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var1111112 = chVar7.d;
                            g10Var1111112.e.j = false;
                            g10Var1111112.g = false;
                            g10Var1111112.n();
                            kd1 kd1Var1111112 = chVar7.e;
                            kd1Var1111112.e.j = false;
                            kd1Var1111112.g = false;
                            kd1Var1111112.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var1111113 = dhVar2.d;
                        g10Var1111113.e.j = false;
                        g10Var1111113.g = false;
                        g10Var1111113.n();
                        kd1 kd1Var1111113 = dhVar2.e;
                        kd1Var1111113.e.j = false;
                        kd1Var1111113.g = false;
                        kd1Var1111113.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                }
                if (zP) {
                    if (mode == i29) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i29) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    dhVar.K(z14, z15);
                }
            } else {
                z4 = z3;
                i14 = 0;
                zP = false;
            }
            if (zP) {
            }
            int i311118 = dhVar.F0;
            if (size > 0) {
                size3 = dhVar.s0.size();
                zR = dhVar.R(64);
                bVar4 = dhVar.w0;
                i24 = 0;
                while (i24 < size3) {
                    chVar5 = (ch) dhVar.s0.get(i24);
                    if (chVar5 instanceof py) {
                        i27 = size3;
                    } else {
                        chVar5.getClass();
                        if (zR) {
                        }
                        iH = chVar5.h(0);
                        int iH19 = chVar5.h(1);
                        i27 = size3;
                        if (iH == 3) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                        }
                        if (z12) {
                            m6Var.a(0, chVar5, bVar4);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = bVar4.a;
                childCount2 = constraintLayout.getChildCount();
                arrayList3 = constraintLayout.mConstraintHelpers;
                i25 = 0;
                while (i25 < childCount2) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof d) {
                        dVar = (d) childAt;
                        if (dVar.c == null) {
                            a aVar19 = (a) dVar.getLayoutParams();
                            aVar3 = (a) dVar.c.getLayoutParams();
                            chVar2 = aVar3.q0;
                            chVar2.j0 = 0;
                            chVar3 = aVar19.q0;
                            if (chVar3.V[0] != 1) {
                                chVar3.J(chVar2.n());
                            }
                            chVar4 = aVar19.q0;
                            if (chVar4.V[1] != 1) {
                                chVar4.G(aVar3.q0.i());
                            }
                            aVar3.q0.j0 = 8;
                        }
                    }
                    i25++;
                    constraintLayout = constraintLayout;
                }
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                    }
                }
            }
            m6Var.c(dhVar);
            arrayList = (ArrayList) m6Var.a;
            size2 = arrayList.size();
            if (size > 0) {
                m6Var.b(dhVar, 0, iN2, i13);
            }
            if (size2 > 0) {
                iArr2 = dhVar.V;
                if (iArr2[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr2[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int iN111 = dhVar.n();
                dh dhVar19 = (dh) m6Var.c;
                iMax3 = Math.max(iN111, dhVar19.e0);
                iMax4 = Math.max(dhVar.i(), dhVar19.f0);
                i15 = 0;
                while (true) {
                    aVar = vg.a.f;
                    aVar2 = vg.a.d;
                    if (i15 < size2) {
                        break;
                        break;
                    } else {
                        i15++;
                    }
                }
                i16 = 0;
                while (i16 < 2) {
                    i17 = 0;
                    z7 = false;
                    while (i17 < size2) {
                        ArrayList arrayList110 = arrayList;
                        chVar = (ch) arrayList.get(i17);
                        int i311119 = size2;
                        if (chVar instanceof h8) {
                            z10 = z6;
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            z10 = z6;
                            if (chVar.j0 == 8) {
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                iN3 = chVar.n();
                                i22 = chVar.i();
                                z11 = z5;
                                int i3111110 = chVar.d0;
                                i21 = i17;
                                zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                bVar3 = bVar;
                                iN4 = chVar.n();
                                i20 = i16;
                                i23 = chVar.i();
                                if (iN4 != iN3) {
                                    chVar.J(iN4);
                                    if (z11) {
                                        iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                    }
                                    zA = true;
                                }
                                if (i23 != i22) {
                                    chVar.G(i23);
                                    if (z10) {
                                        iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                    }
                                    zA = true;
                                }
                                if (chVar.F) {
                                    z7 = zA;
                                } else {
                                    z7 = zA;
                                }
                            }
                        }
                        i17 = i21 + 1;
                        arrayList = arrayList110;
                        size2 = i311119;
                        z6 = z10;
                        z5 = z11;
                        bVar = bVar3;
                        i16 = i20;
                    }
                    arrayList2 = arrayList;
                    i18 = size2;
                    z8 = z6;
                    z9 = z5;
                    bVar2 = bVar;
                    i19 = i16;
                    if (z7) {
                        break;
                        break;
                    }
                    i16 = i19 + 1;
                    m6Var.b(dhVar, i16, iN2, i13);
                    arrayList = arrayList2;
                    size2 = i18;
                    z6 = z8;
                    z5 = z9;
                    bVar = bVar2;
                }
            }
            dhVar.F0 = i311118;
            oe0.p = dhVar.R(512);
        }
        iMax9 = Math.max(0, getPaddingLeft());
        iMax10 = iMax9;
        i4 = size5 - iMax7;
        i5 = size6 - i32;
        i6 = bVar5.e;
        i7 = bVar5.d;
        childCount = getChildCount();
        if (mode != Integer.MIN_VALUE) {
            if (childCount == 0) {
                iMax = i4;
            }
            iMin = iMax;
            i8 = 2;
            if (mode2 != Integer.MIN_VALUE) {
                if (childCount == 0) {
                    iMax2 = i5;
                }
                iMin2 = iMax2;
                i9 = 2;
                iN = dhVar.n();
                iArr = dhVar.D;
                cmVar = dhVar.u0;
                i10 = iMin;
                if (i10 == iN) {
                    cmVar.c = true;
                    c = 1;
                } else {
                    cmVar.c = true;
                    c = 1;
                }
                dhVar.b0 = 0;
                dhVar.c0 = 0;
                iArr[0] = this.mMaxWidth - i7;
                iArr[c] = this.mMaxHeight - i6;
                dhVar.e0 = 0;
                dhVar.f0 = 0;
                dhVar.H(i8);
                dhVar.J(i10);
                dhVar.I(i9);
                dhVar.G(iMin2);
                i11 = this.mMinWidth - i7;
                if (i11 < 0) {
                    i11 = 0;
                }
                dhVar.e0 = i11;
                i12 = this.mMinHeight - i6;
                if (i12 < 0) {
                    i12 = 0;
                }
                dhVar.f0 = i12;
                dhVar.z0 = iMax10;
                dhVar.A0 = iMax5;
                m6Var = dhVar.t0;
                m6Var.getClass();
                bVar = dhVar.w0;
                size = dhVar.s0.size();
                iN2 = dhVar.n();
                i13 = dhVar.i();
                zX = e.x(i, 128);
                if (zX) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            chVar6 = (ch) dhVar.s0.get(i31);
                            iArr3 = chVar6.V;
                            z18 = z;
                            if (iArr3[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr3[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z19) {
                                z21 = false;
                            } else {
                                z21 = false;
                            }
                            if (chVar6.u()) {
                                i31++;
                                z = z18;
                            } else {
                                i31++;
                                z = z18;
                            }
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                    }
                } else {
                    z2 = z;
                }
                z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                if (z3) {
                    iMin3 = Math.min(iArr[0], i4);
                    iMin4 = Math.min(iArr[1], i5);
                    if (mode == 1073741824) {
                        dhVar.J(iMin3);
                        cmVar.b = true;
                    }
                    if (mode2 == 1073741824) {
                        dhVar.G(iMin4);
                        cmVar.b = true;
                    }
                    if (mode == 1073741824) {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var1111114 = chVar7.d;
                                g10Var1111114.e.j = false;
                                g10Var1111114.g = false;
                                g10Var1111114.n();
                                kd1 kd1Var1111114 = chVar7.e;
                                kd1Var1111114.e.j = false;
                                kd1Var1111114.g = false;
                                kd1Var1111114.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var1111115 = dhVar2.d;
                            g10Var1111115.e.j = false;
                            g10Var1111115.g = false;
                            g10Var1111115.n();
                            kd1 kd1Var1111115 = dhVar2.e;
                            kd1Var1111115.e.j = false;
                            kd1Var1111115.g = false;
                            kd1Var1111115.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    } else {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var1111116 = chVar7.d;
                                g10Var1111116.e.j = false;
                                g10Var1111116.g = false;
                                g10Var1111116.n();
                                kd1 kd1Var1111116 = chVar7.e;
                                kd1Var1111116.e.j = false;
                                kd1Var1111116.g = false;
                                kd1Var1111116.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var1111117 = dhVar2.d;
                            g10Var1111117.e.j = false;
                            g10Var1111117.g = false;
                            g10Var1111117.n();
                            kd1 kd1Var1111117 = dhVar2.e;
                            kd1Var1111117.e.j = false;
                            kd1Var1111117.g = false;
                            kd1Var1111117.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    }
                    if (zP) {
                        if (mode == i29) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i29) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        dhVar.K(z14, z15);
                    }
                } else {
                    z4 = z3;
                    i14 = 0;
                    zP = false;
                }
                if (zP) {
                }
                int i3111111 = dhVar.F0;
                if (size > 0) {
                    size3 = dhVar.s0.size();
                    zR = dhVar.R(64);
                    bVar4 = dhVar.w0;
                    i24 = 0;
                    while (i24 < size3) {
                        chVar5 = (ch) dhVar.s0.get(i24);
                        if (chVar5 instanceof py) {
                            i27 = size3;
                        } else {
                            chVar5.getClass();
                            if (zR) {
                            }
                            iH = chVar5.h(0);
                            int iH110 = chVar5.h(1);
                            i27 = size3;
                            if (iH == 3) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                            }
                            if (z12) {
                                m6Var.a(0, chVar5, bVar4);
                            }
                        }
                        i24++;
                        size3 = i27;
                    }
                    constraintLayout = bVar4.a;
                    childCount2 = constraintLayout.getChildCount();
                    arrayList3 = constraintLayout.mConstraintHelpers;
                    i25 = 0;
                    while (i25 < childCount2) {
                        childAt = constraintLayout.getChildAt(i25);
                        if (childAt instanceof d) {
                            dVar = (d) childAt;
                            if (dVar.c == null) {
                                a aVar110 = (a) dVar.getLayoutParams();
                                aVar3 = (a) dVar.c.getLayoutParams();
                                chVar2 = aVar3.q0;
                                chVar2.j0 = 0;
                                chVar3 = aVar110.q0;
                                if (chVar3.V[0] != 1) {
                                    chVar3.J(chVar2.n());
                                }
                                chVar4 = aVar110.q0;
                                if (chVar4.V[1] != 1) {
                                    chVar4.G(aVar3.q0.i());
                                }
                                aVar3.q0.j0 = 8;
                            }
                        }
                        i25++;
                        constraintLayout = constraintLayout;
                    }
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i26 < size4) {
                            ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                        }
                    }
                }
                m6Var.c(dhVar);
                arrayList = (ArrayList) m6Var.a;
                size2 = arrayList.size();
                if (size > 0) {
                    m6Var.b(dhVar, 0, iN2, i13);
                }
                if (size2 > 0) {
                    iArr2 = dhVar.V;
                    if (iArr2[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr2[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int iN112 = dhVar.n();
                    dh dhVar110 = (dh) m6Var.c;
                    iMax3 = Math.max(iN112, dhVar110.e0);
                    iMax4 = Math.max(dhVar.i(), dhVar110.f0);
                    i15 = 0;
                    while (true) {
                        aVar = vg.a.f;
                        aVar2 = vg.a.d;
                        if (i15 < size2) {
                            break;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    i16 = 0;
                    while (i16 < 2) {
                        i17 = 0;
                        z7 = false;
                        while (i17 < size2) {
                            ArrayList arrayList111 = arrayList;
                            chVar = (ch) arrayList.get(i17);
                            int i3111112 = size2;
                            if (chVar instanceof h8) {
                                z10 = z6;
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                z10 = z6;
                                if (chVar.j0 == 8) {
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    iN3 = chVar.n();
                                    i22 = chVar.i();
                                    z11 = z5;
                                    int i3111113 = chVar.d0;
                                    i21 = i17;
                                    zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                    bVar3 = bVar;
                                    iN4 = chVar.n();
                                    i20 = i16;
                                    i23 = chVar.i();
                                    if (iN4 != iN3) {
                                        chVar.J(iN4);
                                        if (z11) {
                                            iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                        }
                                        zA = true;
                                    }
                                    if (i23 != i22) {
                                        chVar.G(i23);
                                        if (z10) {
                                            iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                        }
                                        zA = true;
                                    }
                                    if (chVar.F) {
                                        z7 = zA;
                                    } else {
                                        z7 = zA;
                                    }
                                }
                            }
                            i17 = i21 + 1;
                            arrayList = arrayList111;
                            size2 = i3111112;
                            z6 = z10;
                            z5 = z11;
                            bVar = bVar3;
                            i16 = i20;
                        }
                        arrayList2 = arrayList;
                        i18 = size2;
                        z8 = z6;
                        z9 = z5;
                        bVar2 = bVar;
                        i19 = i16;
                        if (z7) {
                            break;
                            break;
                        }
                        i16 = i19 + 1;
                        m6Var.b(dhVar, i16, iN2, i13);
                        arrayList = arrayList2;
                        size2 = i18;
                        z6 = z8;
                        z5 = z9;
                        bVar = bVar2;
                    }
                }
                dhVar.F0 = i3111111;
                oe0.p = dhVar.R(512);
            }
            if (mode2 != 0) {
                if (mode2 != 1073741824) {
                    iMin2 = Math.min(this.mMaxHeight - i6, i5);
                    i9 = 1;
                }
                iN = dhVar.n();
                iArr = dhVar.D;
                cmVar = dhVar.u0;
                i10 = iMin;
                if (i10 == iN) {
                    cmVar.c = true;
                    c = 1;
                } else {
                    cmVar.c = true;
                    c = 1;
                }
                dhVar.b0 = 0;
                dhVar.c0 = 0;
                iArr[0] = this.mMaxWidth - i7;
                iArr[c] = this.mMaxHeight - i6;
                dhVar.e0 = 0;
                dhVar.f0 = 0;
                dhVar.H(i8);
                dhVar.J(i10);
                dhVar.I(i9);
                dhVar.G(iMin2);
                i11 = this.mMinWidth - i7;
                if (i11 < 0) {
                    i11 = 0;
                }
                dhVar.e0 = i11;
                i12 = this.mMinHeight - i6;
                if (i12 < 0) {
                    i12 = 0;
                }
                dhVar.f0 = i12;
                dhVar.z0 = iMax10;
                dhVar.A0 = iMax5;
                m6Var = dhVar.t0;
                m6Var.getClass();
                bVar = dhVar.w0;
                size = dhVar.s0.size();
                iN2 = dhVar.n();
                i13 = dhVar.i();
                zX = e.x(i, 128);
                if (zX) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            chVar6 = (ch) dhVar.s0.get(i31);
                            iArr3 = chVar6.V;
                            z18 = z;
                            if (iArr3[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr3[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z19) {
                                z21 = false;
                            } else {
                                z21 = false;
                            }
                            if (chVar6.u()) {
                                i31++;
                                z = z18;
                            } else {
                                i31++;
                                z = z18;
                            }
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                    }
                } else {
                    z2 = z;
                }
                z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                if (z3) {
                    iMin3 = Math.min(iArr[0], i4);
                    iMin4 = Math.min(iArr[1], i5);
                    if (mode == 1073741824) {
                        dhVar.J(iMin3);
                        cmVar.b = true;
                    }
                    if (mode2 == 1073741824) {
                        dhVar.G(iMin4);
                        cmVar.b = true;
                    }
                    if (mode == 1073741824) {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var1111118 = chVar7.d;
                                g10Var1111118.e.j = false;
                                g10Var1111118.g = false;
                                g10Var1111118.n();
                                kd1 kd1Var1111118 = chVar7.e;
                                kd1Var1111118.e.j = false;
                                kd1Var1111118.g = false;
                                kd1Var1111118.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var1111119 = dhVar2.d;
                            g10Var1111119.e.j = false;
                            g10Var1111119.g = false;
                            g10Var1111119.n();
                            kd1 kd1Var1111119 = dhVar2.e;
                            kd1Var1111119.e.j = false;
                            kd1Var1111119.g = false;
                            kd1Var1111119.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    } else {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var11111110 = chVar7.d;
                                g10Var11111110.e.j = false;
                                g10Var11111110.g = false;
                                g10Var11111110.n();
                                kd1 kd1Var11111110 = chVar7.e;
                                kd1Var11111110.e.j = false;
                                kd1Var11111110.g = false;
                                kd1Var11111110.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var11111111 = dhVar2.d;
                            g10Var11111111.e.j = false;
                            g10Var11111111.g = false;
                            g10Var11111111.n();
                            kd1 kd1Var11111111 = dhVar2.e;
                            kd1Var11111111.e.j = false;
                            kd1Var11111111.g = false;
                            kd1Var11111111.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    }
                    if (zP) {
                        if (mode == i29) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i29) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        dhVar.K(z14, z15);
                    }
                } else {
                    z4 = z3;
                    i14 = 0;
                    zP = false;
                }
                if (zP) {
                }
                int i3111114 = dhVar.F0;
                if (size > 0) {
                    size3 = dhVar.s0.size();
                    zR = dhVar.R(64);
                    bVar4 = dhVar.w0;
                    i24 = 0;
                    while (i24 < size3) {
                        chVar5 = (ch) dhVar.s0.get(i24);
                        if (chVar5 instanceof py) {
                            i27 = size3;
                        } else {
                            chVar5.getClass();
                            if (zR) {
                            }
                            iH = chVar5.h(0);
                            int iH111 = chVar5.h(1);
                            i27 = size3;
                            if (iH == 3) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                            }
                            if (z12) {
                                m6Var.a(0, chVar5, bVar4);
                            }
                        }
                        i24++;
                        size3 = i27;
                    }
                    constraintLayout = bVar4.a;
                    childCount2 = constraintLayout.getChildCount();
                    arrayList3 = constraintLayout.mConstraintHelpers;
                    i25 = 0;
                    while (i25 < childCount2) {
                        childAt = constraintLayout.getChildAt(i25);
                        if (childAt instanceof d) {
                            dVar = (d) childAt;
                            if (dVar.c == null) {
                                a aVar111 = (a) dVar.getLayoutParams();
                                aVar3 = (a) dVar.c.getLayoutParams();
                                chVar2 = aVar3.q0;
                                chVar2.j0 = 0;
                                chVar3 = aVar111.q0;
                                if (chVar3.V[0] != 1) {
                                    chVar3.J(chVar2.n());
                                }
                                chVar4 = aVar111.q0;
                                if (chVar4.V[1] != 1) {
                                    chVar4.G(aVar3.q0.i());
                                }
                                aVar3.q0.j0 = 8;
                            }
                        }
                        i25++;
                        constraintLayout = constraintLayout;
                    }
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i26 < size4) {
                            ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                        }
                    }
                }
                m6Var.c(dhVar);
                arrayList = (ArrayList) m6Var.a;
                size2 = arrayList.size();
                if (size > 0) {
                    m6Var.b(dhVar, 0, iN2, i13);
                }
                if (size2 > 0) {
                    iArr2 = dhVar.V;
                    if (iArr2[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr2[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int iN113 = dhVar.n();
                    dh dhVar111 = (dh) m6Var.c;
                    iMax3 = Math.max(iN113, dhVar111.e0);
                    iMax4 = Math.max(dhVar.i(), dhVar111.f0);
                    i15 = 0;
                    while (true) {
                        aVar = vg.a.f;
                        aVar2 = vg.a.d;
                        if (i15 < size2) {
                            break;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    i16 = 0;
                    while (i16 < 2) {
                        i17 = 0;
                        z7 = false;
                        while (i17 < size2) {
                            ArrayList arrayList112 = arrayList;
                            chVar = (ch) arrayList.get(i17);
                            int i3111115 = size2;
                            if (chVar instanceof h8) {
                                z10 = z6;
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                z10 = z6;
                                if (chVar.j0 == 8) {
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    iN3 = chVar.n();
                                    i22 = chVar.i();
                                    z11 = z5;
                                    int i3111116 = chVar.d0;
                                    i21 = i17;
                                    zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                    bVar3 = bVar;
                                    iN4 = chVar.n();
                                    i20 = i16;
                                    i23 = chVar.i();
                                    if (iN4 != iN3) {
                                        chVar.J(iN4);
                                        if (z11) {
                                            iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                        }
                                        zA = true;
                                    }
                                    if (i23 != i22) {
                                        chVar.G(i23);
                                        if (z10) {
                                            iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                        }
                                        zA = true;
                                    }
                                    if (chVar.F) {
                                        z7 = zA;
                                    } else {
                                        z7 = zA;
                                    }
                                }
                            }
                            i17 = i21 + 1;
                            arrayList = arrayList112;
                            size2 = i3111115;
                            z6 = z10;
                            z5 = z11;
                            bVar = bVar3;
                            i16 = i20;
                        }
                        arrayList2 = arrayList;
                        i18 = size2;
                        z8 = z6;
                        z9 = z5;
                        bVar2 = bVar;
                        i19 = i16;
                        if (z7) {
                            break;
                            break;
                        }
                        i16 = i19 + 1;
                        m6Var.b(dhVar, i16, iN2, i13);
                        arrayList = arrayList2;
                        size2 = i18;
                        z6 = z8;
                        z5 = z9;
                        bVar = bVar2;
                    }
                }
                dhVar.F0 = i3111114;
                oe0.p = dhVar.R(512);
            }
            if (childCount != 0) {
            }
            iMin2 = 0;
            iN = dhVar.n();
            iArr = dhVar.D;
            cmVar = dhVar.u0;
            i10 = iMin;
            if (i10 == iN) {
                cmVar.c = true;
                c = 1;
            } else {
                cmVar.c = true;
                c = 1;
            }
            dhVar.b0 = 0;
            dhVar.c0 = 0;
            iArr[0] = this.mMaxWidth - i7;
            iArr[c] = this.mMaxHeight - i6;
            dhVar.e0 = 0;
            dhVar.f0 = 0;
            dhVar.H(i8);
            dhVar.J(i10);
            dhVar.I(i9);
            dhVar.G(iMin2);
            i11 = this.mMinWidth - i7;
            if (i11 < 0) {
                i11 = 0;
            }
            dhVar.e0 = i11;
            i12 = this.mMinHeight - i6;
            if (i12 < 0) {
                i12 = 0;
            }
            dhVar.f0 = i12;
            dhVar.z0 = iMax10;
            dhVar.A0 = iMax5;
            m6Var = dhVar.t0;
            m6Var.getClass();
            bVar = dhVar.w0;
            size = dhVar.s0.size();
            iN2 = dhVar.n();
            i13 = dhVar.i();
            zX = e.x(i, 128);
            if (zX) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        chVar6 = (ch) dhVar.s0.get(i31);
                        iArr3 = chVar6.V;
                        z18 = z;
                        if (iArr3[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr3[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z19) {
                            z21 = false;
                        } else {
                            z21 = false;
                        }
                        if (chVar6.u()) {
                            i31++;
                            z = z18;
                        } else {
                            i31++;
                            z = z18;
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
            }
            z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
            if (z3) {
                iMin3 = Math.min(iArr[0], i4);
                iMin4 = Math.min(iArr[1], i5);
                if (mode == 1073741824) {
                    dhVar.J(iMin3);
                    cmVar.b = true;
                }
                if (mode2 == 1073741824) {
                    dhVar.G(iMin4);
                    cmVar.b = true;
                }
                if (mode == 1073741824) {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var11111112 = chVar7.d;
                            g10Var11111112.e.j = false;
                            g10Var11111112.g = false;
                            g10Var11111112.n();
                            kd1 kd1Var11111112 = chVar7.e;
                            kd1Var11111112.e.j = false;
                            kd1Var11111112.g = false;
                            kd1Var11111112.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var11111113 = dhVar2.d;
                        g10Var11111113.e.j = false;
                        g10Var11111113.g = false;
                        g10Var11111113.n();
                        kd1 kd1Var11111113 = dhVar2.e;
                        kd1Var11111113.e.j = false;
                        kd1Var11111113.g = false;
                        kd1Var11111113.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                } else {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var11111114 = chVar7.d;
                            g10Var11111114.e.j = false;
                            g10Var11111114.g = false;
                            g10Var11111114.n();
                            kd1 kd1Var11111114 = chVar7.e;
                            kd1Var11111114.e.j = false;
                            kd1Var11111114.g = false;
                            kd1Var11111114.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var11111115 = dhVar2.d;
                        g10Var11111115.e.j = false;
                        g10Var11111115.g = false;
                        g10Var11111115.n();
                        kd1 kd1Var11111115 = dhVar2.e;
                        kd1Var11111115.e.j = false;
                        kd1Var11111115.g = false;
                        kd1Var11111115.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                }
                if (zP) {
                    if (mode == i29) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i29) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    dhVar.K(z14, z15);
                }
            } else {
                z4 = z3;
                i14 = 0;
                zP = false;
            }
            if (zP) {
            }
            int i3111117 = dhVar.F0;
            if (size > 0) {
                size3 = dhVar.s0.size();
                zR = dhVar.R(64);
                bVar4 = dhVar.w0;
                i24 = 0;
                while (i24 < size3) {
                    chVar5 = (ch) dhVar.s0.get(i24);
                    if (chVar5 instanceof py) {
                        i27 = size3;
                    } else {
                        chVar5.getClass();
                        if (zR) {
                        }
                        iH = chVar5.h(0);
                        int iH112 = chVar5.h(1);
                        i27 = size3;
                        if (iH == 3) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                        }
                        if (z12) {
                            m6Var.a(0, chVar5, bVar4);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = bVar4.a;
                childCount2 = constraintLayout.getChildCount();
                arrayList3 = constraintLayout.mConstraintHelpers;
                i25 = 0;
                while (i25 < childCount2) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof d) {
                        dVar = (d) childAt;
                        if (dVar.c == null) {
                            a aVar112 = (a) dVar.getLayoutParams();
                            aVar3 = (a) dVar.c.getLayoutParams();
                            chVar2 = aVar3.q0;
                            chVar2.j0 = 0;
                            chVar3 = aVar112.q0;
                            if (chVar3.V[0] != 1) {
                                chVar3.J(chVar2.n());
                            }
                            chVar4 = aVar112.q0;
                            if (chVar4.V[1] != 1) {
                                chVar4.G(aVar3.q0.i());
                            }
                            aVar3.q0.j0 = 8;
                        }
                    }
                    i25++;
                    constraintLayout = constraintLayout;
                }
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                    }
                }
            }
            m6Var.c(dhVar);
            arrayList = (ArrayList) m6Var.a;
            size2 = arrayList.size();
            if (size > 0) {
                m6Var.b(dhVar, 0, iN2, i13);
            }
            if (size2 > 0) {
                iArr2 = dhVar.V;
                if (iArr2[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr2[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int iN114 = dhVar.n();
                dh dhVar112 = (dh) m6Var.c;
                iMax3 = Math.max(iN114, dhVar112.e0);
                iMax4 = Math.max(dhVar.i(), dhVar112.f0);
                i15 = 0;
                while (true) {
                    aVar = vg.a.f;
                    aVar2 = vg.a.d;
                    if (i15 < size2) {
                        break;
                        break;
                    } else {
                        i15++;
                    }
                }
                i16 = 0;
                while (i16 < 2) {
                    i17 = 0;
                    z7 = false;
                    while (i17 < size2) {
                        ArrayList arrayList113 = arrayList;
                        chVar = (ch) arrayList.get(i17);
                        int i3111118 = size2;
                        if (chVar instanceof h8) {
                            z10 = z6;
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            z10 = z6;
                            if (chVar.j0 == 8) {
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                iN3 = chVar.n();
                                i22 = chVar.i();
                                z11 = z5;
                                int i3111119 = chVar.d0;
                                i21 = i17;
                                zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                bVar3 = bVar;
                                iN4 = chVar.n();
                                i20 = i16;
                                i23 = chVar.i();
                                if (iN4 != iN3) {
                                    chVar.J(iN4);
                                    if (z11) {
                                        iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                    }
                                    zA = true;
                                }
                                if (i23 != i22) {
                                    chVar.G(i23);
                                    if (z10) {
                                        iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                    }
                                    zA = true;
                                }
                                if (chVar.F) {
                                    z7 = zA;
                                } else {
                                    z7 = zA;
                                }
                            }
                        }
                        i17 = i21 + 1;
                        arrayList = arrayList113;
                        size2 = i3111118;
                        z6 = z10;
                        z5 = z11;
                        bVar = bVar3;
                        i16 = i20;
                    }
                    arrayList2 = arrayList;
                    i18 = size2;
                    z8 = z6;
                    z9 = z5;
                    bVar2 = bVar;
                    i19 = i16;
                    if (z7) {
                        break;
                        break;
                    }
                    i16 = i19 + 1;
                    m6Var.b(dhVar, i16, iN2, i13);
                    arrayList = arrayList2;
                    size2 = i18;
                    z6 = z8;
                    z5 = z9;
                    bVar = bVar2;
                }
            }
            dhVar.F0 = i3111117;
            oe0.p = dhVar.R(512);
            iMax2 = Math.max(0, this.mMinHeight);
            iMin2 = iMax2;
            i9 = 2;
            iN = dhVar.n();
            iArr = dhVar.D;
            cmVar = dhVar.u0;
            i10 = iMin;
            if (i10 == iN) {
                cmVar.c = true;
                c = 1;
            } else {
                cmVar.c = true;
                c = 1;
            }
            dhVar.b0 = 0;
            dhVar.c0 = 0;
            iArr[0] = this.mMaxWidth - i7;
            iArr[c] = this.mMaxHeight - i6;
            dhVar.e0 = 0;
            dhVar.f0 = 0;
            dhVar.H(i8);
            dhVar.J(i10);
            dhVar.I(i9);
            dhVar.G(iMin2);
            i11 = this.mMinWidth - i7;
            if (i11 < 0) {
                i11 = 0;
            }
            dhVar.e0 = i11;
            i12 = this.mMinHeight - i6;
            if (i12 < 0) {
                i12 = 0;
            }
            dhVar.f0 = i12;
            dhVar.z0 = iMax10;
            dhVar.A0 = iMax5;
            m6Var = dhVar.t0;
            m6Var.getClass();
            bVar = dhVar.w0;
            size = dhVar.s0.size();
            iN2 = dhVar.n();
            i13 = dhVar.i();
            zX = e.x(i, 128);
            if (zX) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        chVar6 = (ch) dhVar.s0.get(i31);
                        iArr3 = chVar6.V;
                        z18 = z;
                        if (iArr3[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr3[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z19) {
                            z21 = false;
                        } else {
                            z21 = false;
                        }
                        if (chVar6.u()) {
                            i31++;
                            z = z18;
                        } else {
                            i31++;
                            z = z18;
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
            }
            z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
            if (z3) {
                iMin3 = Math.min(iArr[0], i4);
                iMin4 = Math.min(iArr[1], i5);
                if (mode == 1073741824) {
                    dhVar.J(iMin3);
                    cmVar.b = true;
                }
                if (mode2 == 1073741824) {
                    dhVar.G(iMin4);
                    cmVar.b = true;
                }
                if (mode == 1073741824) {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var11111116 = chVar7.d;
                            g10Var11111116.e.j = false;
                            g10Var11111116.g = false;
                            g10Var11111116.n();
                            kd1 kd1Var11111116 = chVar7.e;
                            kd1Var11111116.e.j = false;
                            kd1Var11111116.g = false;
                            kd1Var11111116.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var11111117 = dhVar2.d;
                        g10Var11111117.e.j = false;
                        g10Var11111117.g = false;
                        g10Var11111117.n();
                        kd1 kd1Var11111117 = dhVar2.e;
                        kd1Var11111117.e.j = false;
                        kd1Var11111117.g = false;
                        kd1Var11111117.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                } else {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var11111118 = chVar7.d;
                            g10Var11111118.e.j = false;
                            g10Var11111118.g = false;
                            g10Var11111118.n();
                            kd1 kd1Var11111118 = chVar7.e;
                            kd1Var11111118.e.j = false;
                            kd1Var11111118.g = false;
                            kd1Var11111118.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var11111119 = dhVar2.d;
                        g10Var11111119.e.j = false;
                        g10Var11111119.g = false;
                        g10Var11111119.n();
                        kd1 kd1Var11111119 = dhVar2.e;
                        kd1Var11111119.e.j = false;
                        kd1Var11111119.g = false;
                        kd1Var11111119.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                }
                if (zP) {
                    if (mode == i29) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i29) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    dhVar.K(z14, z15);
                }
            } else {
                z4 = z3;
                i14 = 0;
                zP = false;
            }
            if (zP) {
            }
            int i31111110 = dhVar.F0;
            if (size > 0) {
                size3 = dhVar.s0.size();
                zR = dhVar.R(64);
                bVar4 = dhVar.w0;
                i24 = 0;
                while (i24 < size3) {
                    chVar5 = (ch) dhVar.s0.get(i24);
                    if (chVar5 instanceof py) {
                        i27 = size3;
                    } else {
                        chVar5.getClass();
                        if (zR) {
                        }
                        iH = chVar5.h(0);
                        int iH113 = chVar5.h(1);
                        i27 = size3;
                        if (iH == 3) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                        }
                        if (z12) {
                            m6Var.a(0, chVar5, bVar4);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = bVar4.a;
                childCount2 = constraintLayout.getChildCount();
                arrayList3 = constraintLayout.mConstraintHelpers;
                i25 = 0;
                while (i25 < childCount2) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof d) {
                        dVar = (d) childAt;
                        if (dVar.c == null) {
                            a aVar113 = (a) dVar.getLayoutParams();
                            aVar3 = (a) dVar.c.getLayoutParams();
                            chVar2 = aVar3.q0;
                            chVar2.j0 = 0;
                            chVar3 = aVar113.q0;
                            if (chVar3.V[0] != 1) {
                                chVar3.J(chVar2.n());
                            }
                            chVar4 = aVar113.q0;
                            if (chVar4.V[1] != 1) {
                                chVar4.G(aVar3.q0.i());
                            }
                            aVar3.q0.j0 = 8;
                        }
                    }
                    i25++;
                    constraintLayout = constraintLayout;
                }
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                    }
                }
            }
            m6Var.c(dhVar);
            arrayList = (ArrayList) m6Var.a;
            size2 = arrayList.size();
            if (size > 0) {
                m6Var.b(dhVar, 0, iN2, i13);
            }
            if (size2 > 0) {
                iArr2 = dhVar.V;
                if (iArr2[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr2[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int iN115 = dhVar.n();
                dh dhVar113 = (dh) m6Var.c;
                iMax3 = Math.max(iN115, dhVar113.e0);
                iMax4 = Math.max(dhVar.i(), dhVar113.f0);
                i15 = 0;
                while (true) {
                    aVar = vg.a.f;
                    aVar2 = vg.a.d;
                    if (i15 < size2) {
                        break;
                        break;
                    } else {
                        i15++;
                    }
                }
                i16 = 0;
                while (i16 < 2) {
                    i17 = 0;
                    z7 = false;
                    while (i17 < size2) {
                        ArrayList arrayList114 = arrayList;
                        chVar = (ch) arrayList.get(i17);
                        int i31111111 = size2;
                        if (chVar instanceof h8) {
                            z10 = z6;
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            z10 = z6;
                            if (chVar.j0 == 8) {
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                iN3 = chVar.n();
                                i22 = chVar.i();
                                z11 = z5;
                                int i31111112 = chVar.d0;
                                i21 = i17;
                                zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                bVar3 = bVar;
                                iN4 = chVar.n();
                                i20 = i16;
                                i23 = chVar.i();
                                if (iN4 != iN3) {
                                    chVar.J(iN4);
                                    if (z11) {
                                        iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                    }
                                    zA = true;
                                }
                                if (i23 != i22) {
                                    chVar.G(i23);
                                    if (z10) {
                                        iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                    }
                                    zA = true;
                                }
                                if (chVar.F) {
                                    z7 = zA;
                                } else {
                                    z7 = zA;
                                }
                            }
                        }
                        i17 = i21 + 1;
                        arrayList = arrayList114;
                        size2 = i31111111;
                        z6 = z10;
                        z5 = z11;
                        bVar = bVar3;
                        i16 = i20;
                    }
                    arrayList2 = arrayList;
                    i18 = size2;
                    z8 = z6;
                    z9 = z5;
                    bVar2 = bVar;
                    i19 = i16;
                    if (z7) {
                        break;
                        break;
                    }
                    i16 = i19 + 1;
                    m6Var.b(dhVar, i16, iN2, i13);
                    arrayList = arrayList2;
                    size2 = i18;
                    z6 = z8;
                    z5 = z9;
                    bVar = bVar2;
                }
            }
            dhVar.F0 = i31111110;
            oe0.p = dhVar.R(512);
        }
        if (mode != 0) {
            if (mode != 1073741824) {
                iMin = Math.min(this.mMaxWidth - i7, i4);
                i8 = 1;
            }
            if (mode2 != Integer.MIN_VALUE) {
                if (childCount == 0) {
                    iMax2 = i5;
                }
                iMin2 = iMax2;
                i9 = 2;
                iN = dhVar.n();
                iArr = dhVar.D;
                cmVar = dhVar.u0;
                i10 = iMin;
                if (i10 == iN) {
                    cmVar.c = true;
                    c = 1;
                } else {
                    cmVar.c = true;
                    c = 1;
                }
                dhVar.b0 = 0;
                dhVar.c0 = 0;
                iArr[0] = this.mMaxWidth - i7;
                iArr[c] = this.mMaxHeight - i6;
                dhVar.e0 = 0;
                dhVar.f0 = 0;
                dhVar.H(i8);
                dhVar.J(i10);
                dhVar.I(i9);
                dhVar.G(iMin2);
                i11 = this.mMinWidth - i7;
                if (i11 < 0) {
                    i11 = 0;
                }
                dhVar.e0 = i11;
                i12 = this.mMinHeight - i6;
                if (i12 < 0) {
                    i12 = 0;
                }
                dhVar.f0 = i12;
                dhVar.z0 = iMax10;
                dhVar.A0 = iMax5;
                m6Var = dhVar.t0;
                m6Var.getClass();
                bVar = dhVar.w0;
                size = dhVar.s0.size();
                iN2 = dhVar.n();
                i13 = dhVar.i();
                zX = e.x(i, 128);
                if (zX) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            chVar6 = (ch) dhVar.s0.get(i31);
                            iArr3 = chVar6.V;
                            z18 = z;
                            if (iArr3[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr3[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z19) {
                                z21 = false;
                            } else {
                                z21 = false;
                            }
                            if (chVar6.u()) {
                                i31++;
                                z = z18;
                            } else {
                                i31++;
                                z = z18;
                            }
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                    }
                } else {
                    z2 = z;
                }
                z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                if (z3) {
                    iMin3 = Math.min(iArr[0], i4);
                    iMin4 = Math.min(iArr[1], i5);
                    if (mode == 1073741824) {
                        dhVar.J(iMin3);
                        cmVar.b = true;
                    }
                    if (mode2 == 1073741824) {
                        dhVar.G(iMin4);
                        cmVar.b = true;
                    }
                    if (mode == 1073741824) {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var111111110 = chVar7.d;
                                g10Var111111110.e.j = false;
                                g10Var111111110.g = false;
                                g10Var111111110.n();
                                kd1 kd1Var111111110 = chVar7.e;
                                kd1Var111111110.e.j = false;
                                kd1Var111111110.g = false;
                                kd1Var111111110.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var111111111 = dhVar2.d;
                            g10Var111111111.e.j = false;
                            g10Var111111111.g = false;
                            g10Var111111111.n();
                            kd1 kd1Var111111111 = dhVar2.e;
                            kd1Var111111111.e.j = false;
                            kd1Var111111111.g = false;
                            kd1Var111111111.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    } else {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var111111112 = chVar7.d;
                                g10Var111111112.e.j = false;
                                g10Var111111112.g = false;
                                g10Var111111112.n();
                                kd1 kd1Var111111112 = chVar7.e;
                                kd1Var111111112.e.j = false;
                                kd1Var111111112.g = false;
                                kd1Var111111112.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var111111113 = dhVar2.d;
                            g10Var111111113.e.j = false;
                            g10Var111111113.g = false;
                            g10Var111111113.n();
                            kd1 kd1Var111111113 = dhVar2.e;
                            kd1Var111111113.e.j = false;
                            kd1Var111111113.g = false;
                            kd1Var111111113.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    }
                    if (zP) {
                        if (mode == i29) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i29) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        dhVar.K(z14, z15);
                    }
                } else {
                    z4 = z3;
                    i14 = 0;
                    zP = false;
                }
                if (zP) {
                }
                int i31111113 = dhVar.F0;
                if (size > 0) {
                    size3 = dhVar.s0.size();
                    zR = dhVar.R(64);
                    bVar4 = dhVar.w0;
                    i24 = 0;
                    while (i24 < size3) {
                        chVar5 = (ch) dhVar.s0.get(i24);
                        if (chVar5 instanceof py) {
                            i27 = size3;
                        } else {
                            chVar5.getClass();
                            if (zR) {
                            }
                            iH = chVar5.h(0);
                            int iH114 = chVar5.h(1);
                            i27 = size3;
                            if (iH == 3) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                            }
                            if (z12) {
                                m6Var.a(0, chVar5, bVar4);
                            }
                        }
                        i24++;
                        size3 = i27;
                    }
                    constraintLayout = bVar4.a;
                    childCount2 = constraintLayout.getChildCount();
                    arrayList3 = constraintLayout.mConstraintHelpers;
                    i25 = 0;
                    while (i25 < childCount2) {
                        childAt = constraintLayout.getChildAt(i25);
                        if (childAt instanceof d) {
                            dVar = (d) childAt;
                            if (dVar.c == null) {
                                a aVar114 = (a) dVar.getLayoutParams();
                                aVar3 = (a) dVar.c.getLayoutParams();
                                chVar2 = aVar3.q0;
                                chVar2.j0 = 0;
                                chVar3 = aVar114.q0;
                                if (chVar3.V[0] != 1) {
                                    chVar3.J(chVar2.n());
                                }
                                chVar4 = aVar114.q0;
                                if (chVar4.V[1] != 1) {
                                    chVar4.G(aVar3.q0.i());
                                }
                                aVar3.q0.j0 = 8;
                            }
                        }
                        i25++;
                        constraintLayout = constraintLayout;
                    }
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i26 < size4) {
                            ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                        }
                    }
                }
                m6Var.c(dhVar);
                arrayList = (ArrayList) m6Var.a;
                size2 = arrayList.size();
                if (size > 0) {
                    m6Var.b(dhVar, 0, iN2, i13);
                }
                if (size2 > 0) {
                    iArr2 = dhVar.V;
                    if (iArr2[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr2[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int iN116 = dhVar.n();
                    dh dhVar114 = (dh) m6Var.c;
                    iMax3 = Math.max(iN116, dhVar114.e0);
                    iMax4 = Math.max(dhVar.i(), dhVar114.f0);
                    i15 = 0;
                    while (true) {
                        aVar = vg.a.f;
                        aVar2 = vg.a.d;
                        if (i15 < size2) {
                            break;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    i16 = 0;
                    while (i16 < 2) {
                        i17 = 0;
                        z7 = false;
                        while (i17 < size2) {
                            ArrayList arrayList115 = arrayList;
                            chVar = (ch) arrayList.get(i17);
                            int i31111114 = size2;
                            if (chVar instanceof h8) {
                                z10 = z6;
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                z10 = z6;
                                if (chVar.j0 == 8) {
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    iN3 = chVar.n();
                                    i22 = chVar.i();
                                    z11 = z5;
                                    int i31111115 = chVar.d0;
                                    i21 = i17;
                                    zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                    bVar3 = bVar;
                                    iN4 = chVar.n();
                                    i20 = i16;
                                    i23 = chVar.i();
                                    if (iN4 != iN3) {
                                        chVar.J(iN4);
                                        if (z11) {
                                            iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                        }
                                        zA = true;
                                    }
                                    if (i23 != i22) {
                                        chVar.G(i23);
                                        if (z10) {
                                            iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                        }
                                        zA = true;
                                    }
                                    if (chVar.F) {
                                        z7 = zA;
                                    } else {
                                        z7 = zA;
                                    }
                                }
                            }
                            i17 = i21 + 1;
                            arrayList = arrayList115;
                            size2 = i31111114;
                            z6 = z10;
                            z5 = z11;
                            bVar = bVar3;
                            i16 = i20;
                        }
                        arrayList2 = arrayList;
                        i18 = size2;
                        z8 = z6;
                        z9 = z5;
                        bVar2 = bVar;
                        i19 = i16;
                        if (z7) {
                            break;
                            break;
                        }
                        i16 = i19 + 1;
                        m6Var.b(dhVar, i16, iN2, i13);
                        arrayList = arrayList2;
                        size2 = i18;
                        z6 = z8;
                        z5 = z9;
                        bVar = bVar2;
                    }
                }
                dhVar.F0 = i31111113;
                oe0.p = dhVar.R(512);
            }
            if (mode2 != 0) {
                if (mode2 != 1073741824) {
                    iMin2 = Math.min(this.mMaxHeight - i6, i5);
                    i9 = 1;
                }
                iN = dhVar.n();
                iArr = dhVar.D;
                cmVar = dhVar.u0;
                i10 = iMin;
                if (i10 == iN) {
                    cmVar.c = true;
                    c = 1;
                } else {
                    cmVar.c = true;
                    c = 1;
                }
                dhVar.b0 = 0;
                dhVar.c0 = 0;
                iArr[0] = this.mMaxWidth - i7;
                iArr[c] = this.mMaxHeight - i6;
                dhVar.e0 = 0;
                dhVar.f0 = 0;
                dhVar.H(i8);
                dhVar.J(i10);
                dhVar.I(i9);
                dhVar.G(iMin2);
                i11 = this.mMinWidth - i7;
                if (i11 < 0) {
                    i11 = 0;
                }
                dhVar.e0 = i11;
                i12 = this.mMinHeight - i6;
                if (i12 < 0) {
                    i12 = 0;
                }
                dhVar.f0 = i12;
                dhVar.z0 = iMax10;
                dhVar.A0 = iMax5;
                m6Var = dhVar.t0;
                m6Var.getClass();
                bVar = dhVar.w0;
                size = dhVar.s0.size();
                iN2 = dhVar.n();
                i13 = dhVar.i();
                zX = e.x(i, 128);
                if (zX) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            chVar6 = (ch) dhVar.s0.get(i31);
                            iArr3 = chVar6.V;
                            z18 = z;
                            if (iArr3[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr3[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z19) {
                                z21 = false;
                            } else {
                                z21 = false;
                            }
                            if (chVar6.u()) {
                                i31++;
                                z = z18;
                            } else {
                                i31++;
                                z = z18;
                            }
                            z2 = false;
                        } else {
                            z2 = z;
                        }
                    }
                } else {
                    z2 = z;
                }
                z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
                if (z3) {
                    iMin3 = Math.min(iArr[0], i4);
                    iMin4 = Math.min(iArr[1], i5);
                    if (mode == 1073741824) {
                        dhVar.J(iMin3);
                        cmVar.b = true;
                    }
                    if (mode2 == 1073741824) {
                        dhVar.G(iMin4);
                        cmVar.b = true;
                    }
                    if (mode == 1073741824) {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var111111114 = chVar7.d;
                                g10Var111111114.e.j = false;
                                g10Var111111114.g = false;
                                g10Var111111114.n();
                                kd1 kd1Var111111114 = chVar7.e;
                                kd1Var111111114.e.j = false;
                                kd1Var111111114.g = false;
                                kd1Var111111114.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var111111115 = dhVar2.d;
                            g10Var111111115.e.j = false;
                            g10Var111111115.g = false;
                            g10Var111111115.n();
                            kd1 kd1Var111111115 = dhVar2.e;
                            kd1Var111111115.e.j = false;
                            kd1Var111111115.g = false;
                            kd1Var111111115.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    } else {
                        z4 = z3;
                        z13 = cmVar.b;
                        dhVar2 = cmVar.a;
                        if (z13) {
                            while (r0.hasNext()) {
                                chVar7.f();
                                chVar7.a = false;
                                g10 g10Var111111116 = chVar7.d;
                                g10Var111111116.e.j = false;
                                g10Var111111116.g = false;
                                g10Var111111116.n();
                                kd1 kd1Var111111116 = chVar7.e;
                                kd1Var111111116.e.j = false;
                                kd1Var111111116.g = false;
                                kd1Var111111116.m();
                            }
                            i28 = 0;
                            dhVar2.f();
                            dhVar2.a = false;
                            g10 g10Var111111117 = dhVar2.d;
                            g10Var111111117.e.j = false;
                            g10Var111111117.g = false;
                            g10Var111111117.n();
                            kd1 kd1Var111111117 = dhVar2.e;
                            kd1Var111111117.e.j = false;
                            kd1Var111111117.g = false;
                            kd1Var111111117.m();
                            cmVar.c();
                        } else {
                            i28 = 0;
                        }
                        cmVar.b(cmVar.d);
                        dhVar2.b0 = i28;
                        dhVar2.c0 = i28;
                        dhVar2.d.h.d(i28);
                        dhVar2.e.h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zP = dhVar.P(i28, zX);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zP = true;
                        }
                        if (mode2 == 1073741824) {
                            zP &= dhVar.P(1, zX);
                            i14++;
                        }
                    }
                    if (zP) {
                        if (mode == i29) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i29) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        dhVar.K(z14, z15);
                    }
                } else {
                    z4 = z3;
                    i14 = 0;
                    zP = false;
                }
                if (zP) {
                }
                int i31111116 = dhVar.F0;
                if (size > 0) {
                    size3 = dhVar.s0.size();
                    zR = dhVar.R(64);
                    bVar4 = dhVar.w0;
                    i24 = 0;
                    while (i24 < size3) {
                        chVar5 = (ch) dhVar.s0.get(i24);
                        if (chVar5 instanceof py) {
                            i27 = size3;
                        } else {
                            chVar5.getClass();
                            if (zR) {
                            }
                            iH = chVar5.h(0);
                            int iH115 = chVar5.h(1);
                            i27 = size3;
                            if (iH == 3) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                            }
                            if (z12) {
                                m6Var.a(0, chVar5, bVar4);
                            }
                        }
                        i24++;
                        size3 = i27;
                    }
                    constraintLayout = bVar4.a;
                    childCount2 = constraintLayout.getChildCount();
                    arrayList3 = constraintLayout.mConstraintHelpers;
                    i25 = 0;
                    while (i25 < childCount2) {
                        childAt = constraintLayout.getChildAt(i25);
                        if (childAt instanceof d) {
                            dVar = (d) childAt;
                            if (dVar.c == null) {
                                a aVar115 = (a) dVar.getLayoutParams();
                                aVar3 = (a) dVar.c.getLayoutParams();
                                chVar2 = aVar3.q0;
                                chVar2.j0 = 0;
                                chVar3 = aVar115.q0;
                                if (chVar3.V[0] != 1) {
                                    chVar3.J(chVar2.n());
                                }
                                chVar4 = aVar115.q0;
                                if (chVar4.V[1] != 1) {
                                    chVar4.G(aVar3.q0.i());
                                }
                                aVar3.q0.j0 = 8;
                            }
                        }
                        i25++;
                        constraintLayout = constraintLayout;
                    }
                    size4 = arrayList3.size();
                    if (size4 > 0) {
                        while (i26 < size4) {
                            ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                        }
                    }
                }
                m6Var.c(dhVar);
                arrayList = (ArrayList) m6Var.a;
                size2 = arrayList.size();
                if (size > 0) {
                    m6Var.b(dhVar, 0, iN2, i13);
                }
                if (size2 > 0) {
                    iArr2 = dhVar.V;
                    if (iArr2[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr2[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int iN117 = dhVar.n();
                    dh dhVar115 = (dh) m6Var.c;
                    iMax3 = Math.max(iN117, dhVar115.e0);
                    iMax4 = Math.max(dhVar.i(), dhVar115.f0);
                    i15 = 0;
                    while (true) {
                        aVar = vg.a.f;
                        aVar2 = vg.a.d;
                        if (i15 < size2) {
                            break;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    i16 = 0;
                    while (i16 < 2) {
                        i17 = 0;
                        z7 = false;
                        while (i17 < size2) {
                            ArrayList arrayList116 = arrayList;
                            chVar = (ch) arrayList.get(i17);
                            int i31111117 = size2;
                            if (chVar instanceof h8) {
                                z10 = z6;
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                z10 = z6;
                                if (chVar.j0 == 8) {
                                    z11 = z5;
                                    bVar3 = bVar;
                                    i20 = i16;
                                    i21 = i17;
                                } else {
                                    iN3 = chVar.n();
                                    i22 = chVar.i();
                                    z11 = z5;
                                    int i31111118 = chVar.d0;
                                    i21 = i17;
                                    zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                    bVar3 = bVar;
                                    iN4 = chVar.n();
                                    i20 = i16;
                                    i23 = chVar.i();
                                    if (iN4 != iN3) {
                                        chVar.J(iN4);
                                        if (z11) {
                                            iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                        }
                                        zA = true;
                                    }
                                    if (i23 != i22) {
                                        chVar.G(i23);
                                        if (z10) {
                                            iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                        }
                                        zA = true;
                                    }
                                    if (chVar.F) {
                                        z7 = zA;
                                    } else {
                                        z7 = zA;
                                    }
                                }
                            }
                            i17 = i21 + 1;
                            arrayList = arrayList116;
                            size2 = i31111117;
                            z6 = z10;
                            z5 = z11;
                            bVar = bVar3;
                            i16 = i20;
                        }
                        arrayList2 = arrayList;
                        i18 = size2;
                        z8 = z6;
                        z9 = z5;
                        bVar2 = bVar;
                        i19 = i16;
                        if (z7) {
                            break;
                            break;
                        }
                        i16 = i19 + 1;
                        m6Var.b(dhVar, i16, iN2, i13);
                        arrayList = arrayList2;
                        size2 = i18;
                        z6 = z8;
                        z5 = z9;
                        bVar = bVar2;
                    }
                }
                dhVar.F0 = i31111116;
                oe0.p = dhVar.R(512);
            }
            if (childCount != 0) {
            }
            iMin2 = 0;
            iN = dhVar.n();
            iArr = dhVar.D;
            cmVar = dhVar.u0;
            i10 = iMin;
            if (i10 == iN) {
                cmVar.c = true;
                c = 1;
            } else {
                cmVar.c = true;
                c = 1;
            }
            dhVar.b0 = 0;
            dhVar.c0 = 0;
            iArr[0] = this.mMaxWidth - i7;
            iArr[c] = this.mMaxHeight - i6;
            dhVar.e0 = 0;
            dhVar.f0 = 0;
            dhVar.H(i8);
            dhVar.J(i10);
            dhVar.I(i9);
            dhVar.G(iMin2);
            i11 = this.mMinWidth - i7;
            if (i11 < 0) {
                i11 = 0;
            }
            dhVar.e0 = i11;
            i12 = this.mMinHeight - i6;
            if (i12 < 0) {
                i12 = 0;
            }
            dhVar.f0 = i12;
            dhVar.z0 = iMax10;
            dhVar.A0 = iMax5;
            m6Var = dhVar.t0;
            m6Var.getClass();
            bVar = dhVar.w0;
            size = dhVar.s0.size();
            iN2 = dhVar.n();
            i13 = dhVar.i();
            zX = e.x(i, 128);
            if (zX) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        chVar6 = (ch) dhVar.s0.get(i31);
                        iArr3 = chVar6.V;
                        z18 = z;
                        if (iArr3[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr3[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z19) {
                            z21 = false;
                        } else {
                            z21 = false;
                        }
                        if (chVar6.u()) {
                            i31++;
                            z = z18;
                        } else {
                            i31++;
                            z = z18;
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
            }
            z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
            if (z3) {
                iMin3 = Math.min(iArr[0], i4);
                iMin4 = Math.min(iArr[1], i5);
                if (mode == 1073741824) {
                    dhVar.J(iMin3);
                    cmVar.b = true;
                }
                if (mode2 == 1073741824) {
                    dhVar.G(iMin4);
                    cmVar.b = true;
                }
                if (mode == 1073741824) {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var111111118 = chVar7.d;
                            g10Var111111118.e.j = false;
                            g10Var111111118.g = false;
                            g10Var111111118.n();
                            kd1 kd1Var111111118 = chVar7.e;
                            kd1Var111111118.e.j = false;
                            kd1Var111111118.g = false;
                            kd1Var111111118.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var111111119 = dhVar2.d;
                        g10Var111111119.e.j = false;
                        g10Var111111119.g = false;
                        g10Var111111119.n();
                        kd1 kd1Var111111119 = dhVar2.e;
                        kd1Var111111119.e.j = false;
                        kd1Var111111119.g = false;
                        kd1Var111111119.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                } else {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var1111111110 = chVar7.d;
                            g10Var1111111110.e.j = false;
                            g10Var1111111110.g = false;
                            g10Var1111111110.n();
                            kd1 kd1Var1111111110 = chVar7.e;
                            kd1Var1111111110.e.j = false;
                            kd1Var1111111110.g = false;
                            kd1Var1111111110.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var1111111111 = dhVar2.d;
                        g10Var1111111111.e.j = false;
                        g10Var1111111111.g = false;
                        g10Var1111111111.n();
                        kd1 kd1Var1111111111 = dhVar2.e;
                        kd1Var1111111111.e.j = false;
                        kd1Var1111111111.g = false;
                        kd1Var1111111111.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                }
                if (zP) {
                    if (mode == i29) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i29) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    dhVar.K(z14, z15);
                }
            } else {
                z4 = z3;
                i14 = 0;
                zP = false;
            }
            if (zP) {
            }
            int i31111119 = dhVar.F0;
            if (size > 0) {
                size3 = dhVar.s0.size();
                zR = dhVar.R(64);
                bVar4 = dhVar.w0;
                i24 = 0;
                while (i24 < size3) {
                    chVar5 = (ch) dhVar.s0.get(i24);
                    if (chVar5 instanceof py) {
                        i27 = size3;
                    } else {
                        chVar5.getClass();
                        if (zR) {
                        }
                        iH = chVar5.h(0);
                        int iH116 = chVar5.h(1);
                        i27 = size3;
                        if (iH == 3) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                        }
                        if (z12) {
                            m6Var.a(0, chVar5, bVar4);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = bVar4.a;
                childCount2 = constraintLayout.getChildCount();
                arrayList3 = constraintLayout.mConstraintHelpers;
                i25 = 0;
                while (i25 < childCount2) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof d) {
                        dVar = (d) childAt;
                        if (dVar.c == null) {
                            a aVar116 = (a) dVar.getLayoutParams();
                            aVar3 = (a) dVar.c.getLayoutParams();
                            chVar2 = aVar3.q0;
                            chVar2.j0 = 0;
                            chVar3 = aVar116.q0;
                            if (chVar3.V[0] != 1) {
                                chVar3.J(chVar2.n());
                            }
                            chVar4 = aVar116.q0;
                            if (chVar4.V[1] != 1) {
                                chVar4.G(aVar3.q0.i());
                            }
                            aVar3.q0.j0 = 8;
                        }
                    }
                    i25++;
                    constraintLayout = constraintLayout;
                }
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                    }
                }
            }
            m6Var.c(dhVar);
            arrayList = (ArrayList) m6Var.a;
            size2 = arrayList.size();
            if (size > 0) {
                m6Var.b(dhVar, 0, iN2, i13);
            }
            if (size2 > 0) {
                iArr2 = dhVar.V;
                if (iArr2[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr2[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int iN118 = dhVar.n();
                dh dhVar116 = (dh) m6Var.c;
                iMax3 = Math.max(iN118, dhVar116.e0);
                iMax4 = Math.max(dhVar.i(), dhVar116.f0);
                i15 = 0;
                while (true) {
                    aVar = vg.a.f;
                    aVar2 = vg.a.d;
                    if (i15 < size2) {
                        break;
                        break;
                    } else {
                        i15++;
                    }
                }
                i16 = 0;
                while (i16 < 2) {
                    i17 = 0;
                    z7 = false;
                    while (i17 < size2) {
                        ArrayList arrayList117 = arrayList;
                        chVar = (ch) arrayList.get(i17);
                        int i311111110 = size2;
                        if (chVar instanceof h8) {
                            z10 = z6;
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            z10 = z6;
                            if (chVar.j0 == 8) {
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                iN3 = chVar.n();
                                i22 = chVar.i();
                                z11 = z5;
                                int i311111111 = chVar.d0;
                                i21 = i17;
                                zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                bVar3 = bVar;
                                iN4 = chVar.n();
                                i20 = i16;
                                i23 = chVar.i();
                                if (iN4 != iN3) {
                                    chVar.J(iN4);
                                    if (z11) {
                                        iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                    }
                                    zA = true;
                                }
                                if (i23 != i22) {
                                    chVar.G(i23);
                                    if (z10) {
                                        iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                    }
                                    zA = true;
                                }
                                if (chVar.F) {
                                    z7 = zA;
                                } else {
                                    z7 = zA;
                                }
                            }
                        }
                        i17 = i21 + 1;
                        arrayList = arrayList117;
                        size2 = i311111110;
                        z6 = z10;
                        z5 = z11;
                        bVar = bVar3;
                        i16 = i20;
                    }
                    arrayList2 = arrayList;
                    i18 = size2;
                    z8 = z6;
                    z9 = z5;
                    bVar2 = bVar;
                    i19 = i16;
                    if (z7) {
                        break;
                        break;
                    }
                    i16 = i19 + 1;
                    m6Var.b(dhVar, i16, iN2, i13);
                    arrayList = arrayList2;
                    size2 = i18;
                    z6 = z8;
                    z5 = z9;
                    bVar = bVar2;
                }
            }
            dhVar.F0 = i31111119;
            oe0.p = dhVar.R(512);
            iMax2 = Math.max(0, this.mMinHeight);
            iMin2 = iMax2;
            i9 = 2;
            iN = dhVar.n();
            iArr = dhVar.D;
            cmVar = dhVar.u0;
            i10 = iMin;
            if (i10 == iN) {
                cmVar.c = true;
                c = 1;
            } else {
                cmVar.c = true;
                c = 1;
            }
            dhVar.b0 = 0;
            dhVar.c0 = 0;
            iArr[0] = this.mMaxWidth - i7;
            iArr[c] = this.mMaxHeight - i6;
            dhVar.e0 = 0;
            dhVar.f0 = 0;
            dhVar.H(i8);
            dhVar.J(i10);
            dhVar.I(i9);
            dhVar.G(iMin2);
            i11 = this.mMinWidth - i7;
            if (i11 < 0) {
                i11 = 0;
            }
            dhVar.e0 = i11;
            i12 = this.mMinHeight - i6;
            if (i12 < 0) {
                i12 = 0;
            }
            dhVar.f0 = i12;
            dhVar.z0 = iMax10;
            dhVar.A0 = iMax5;
            m6Var = dhVar.t0;
            m6Var.getClass();
            bVar = dhVar.w0;
            size = dhVar.s0.size();
            iN2 = dhVar.n();
            i13 = dhVar.i();
            zX = e.x(i, 128);
            if (zX) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        chVar6 = (ch) dhVar.s0.get(i31);
                        iArr3 = chVar6.V;
                        z18 = z;
                        if (iArr3[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr3[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z19) {
                            z21 = false;
                        } else {
                            z21 = false;
                        }
                        if (chVar6.u()) {
                            i31++;
                            z = z18;
                        } else {
                            i31++;
                            z = z18;
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
            }
            z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
            if (z3) {
                iMin3 = Math.min(iArr[0], i4);
                iMin4 = Math.min(iArr[1], i5);
                if (mode == 1073741824) {
                    dhVar.J(iMin3);
                    cmVar.b = true;
                }
                if (mode2 == 1073741824) {
                    dhVar.G(iMin4);
                    cmVar.b = true;
                }
                if (mode == 1073741824) {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var1111111112 = chVar7.d;
                            g10Var1111111112.e.j = false;
                            g10Var1111111112.g = false;
                            g10Var1111111112.n();
                            kd1 kd1Var1111111112 = chVar7.e;
                            kd1Var1111111112.e.j = false;
                            kd1Var1111111112.g = false;
                            kd1Var1111111112.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var1111111113 = dhVar2.d;
                        g10Var1111111113.e.j = false;
                        g10Var1111111113.g = false;
                        g10Var1111111113.n();
                        kd1 kd1Var1111111113 = dhVar2.e;
                        kd1Var1111111113.e.j = false;
                        kd1Var1111111113.g = false;
                        kd1Var1111111113.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                } else {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var1111111114 = chVar7.d;
                            g10Var1111111114.e.j = false;
                            g10Var1111111114.g = false;
                            g10Var1111111114.n();
                            kd1 kd1Var1111111114 = chVar7.e;
                            kd1Var1111111114.e.j = false;
                            kd1Var1111111114.g = false;
                            kd1Var1111111114.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var1111111115 = dhVar2.d;
                        g10Var1111111115.e.j = false;
                        g10Var1111111115.g = false;
                        g10Var1111111115.n();
                        kd1 kd1Var1111111115 = dhVar2.e;
                        kd1Var1111111115.e.j = false;
                        kd1Var1111111115.g = false;
                        kd1Var1111111115.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                }
                if (zP) {
                    if (mode == i29) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i29) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    dhVar.K(z14, z15);
                }
            } else {
                z4 = z3;
                i14 = 0;
                zP = false;
            }
            if (zP) {
            }
            int i311111112 = dhVar.F0;
            if (size > 0) {
                size3 = dhVar.s0.size();
                zR = dhVar.R(64);
                bVar4 = dhVar.w0;
                i24 = 0;
                while (i24 < size3) {
                    chVar5 = (ch) dhVar.s0.get(i24);
                    if (chVar5 instanceof py) {
                        i27 = size3;
                    } else {
                        chVar5.getClass();
                        if (zR) {
                        }
                        iH = chVar5.h(0);
                        int iH117 = chVar5.h(1);
                        i27 = size3;
                        if (iH == 3) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                        }
                        if (z12) {
                            m6Var.a(0, chVar5, bVar4);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = bVar4.a;
                childCount2 = constraintLayout.getChildCount();
                arrayList3 = constraintLayout.mConstraintHelpers;
                i25 = 0;
                while (i25 < childCount2) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof d) {
                        dVar = (d) childAt;
                        if (dVar.c == null) {
                            a aVar117 = (a) dVar.getLayoutParams();
                            aVar3 = (a) dVar.c.getLayoutParams();
                            chVar2 = aVar3.q0;
                            chVar2.j0 = 0;
                            chVar3 = aVar117.q0;
                            if (chVar3.V[0] != 1) {
                                chVar3.J(chVar2.n());
                            }
                            chVar4 = aVar117.q0;
                            if (chVar4.V[1] != 1) {
                                chVar4.G(aVar3.q0.i());
                            }
                            aVar3.q0.j0 = 8;
                        }
                    }
                    i25++;
                    constraintLayout = constraintLayout;
                }
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                    }
                }
            }
            m6Var.c(dhVar);
            arrayList = (ArrayList) m6Var.a;
            size2 = arrayList.size();
            if (size > 0) {
                m6Var.b(dhVar, 0, iN2, i13);
            }
            if (size2 > 0) {
                iArr2 = dhVar.V;
                if (iArr2[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr2[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int iN119 = dhVar.n();
                dh dhVar117 = (dh) m6Var.c;
                iMax3 = Math.max(iN119, dhVar117.e0);
                iMax4 = Math.max(dhVar.i(), dhVar117.f0);
                i15 = 0;
                while (true) {
                    aVar = vg.a.f;
                    aVar2 = vg.a.d;
                    if (i15 < size2) {
                        break;
                        break;
                    } else {
                        i15++;
                    }
                }
                i16 = 0;
                while (i16 < 2) {
                    i17 = 0;
                    z7 = false;
                    while (i17 < size2) {
                        ArrayList arrayList118 = arrayList;
                        chVar = (ch) arrayList.get(i17);
                        int i311111113 = size2;
                        if (chVar instanceof h8) {
                            z10 = z6;
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            z10 = z6;
                            if (chVar.j0 == 8) {
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                iN3 = chVar.n();
                                i22 = chVar.i();
                                z11 = z5;
                                int i311111114 = chVar.d0;
                                i21 = i17;
                                zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                bVar3 = bVar;
                                iN4 = chVar.n();
                                i20 = i16;
                                i23 = chVar.i();
                                if (iN4 != iN3) {
                                    chVar.J(iN4);
                                    if (z11) {
                                        iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                    }
                                    zA = true;
                                }
                                if (i23 != i22) {
                                    chVar.G(i23);
                                    if (z10) {
                                        iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                    }
                                    zA = true;
                                }
                                if (chVar.F) {
                                    z7 = zA;
                                } else {
                                    z7 = zA;
                                }
                            }
                        }
                        i17 = i21 + 1;
                        arrayList = arrayList118;
                        size2 = i311111113;
                        z6 = z10;
                        z5 = z11;
                        bVar = bVar3;
                        i16 = i20;
                    }
                    arrayList2 = arrayList;
                    i18 = size2;
                    z8 = z6;
                    z9 = z5;
                    bVar2 = bVar;
                    i19 = i16;
                    if (z7) {
                        break;
                        break;
                    }
                    i16 = i19 + 1;
                    m6Var.b(dhVar, i16, iN2, i13);
                    arrayList = arrayList2;
                    size2 = i18;
                    z6 = z8;
                    z5 = z9;
                    bVar = bVar2;
                }
            }
            dhVar.F0 = i311111112;
            oe0.p = dhVar.R(512);
        }
        if (childCount != 0) {
        }
        iMin = 0;
        if (mode2 != Integer.MIN_VALUE) {
            if (childCount == 0) {
                iMax2 = i5;
            }
            iMin2 = iMax2;
            i9 = 2;
            iN = dhVar.n();
            iArr = dhVar.D;
            cmVar = dhVar.u0;
            i10 = iMin;
            if (i10 == iN) {
                cmVar.c = true;
                c = 1;
            } else {
                cmVar.c = true;
                c = 1;
            }
            dhVar.b0 = 0;
            dhVar.c0 = 0;
            iArr[0] = this.mMaxWidth - i7;
            iArr[c] = this.mMaxHeight - i6;
            dhVar.e0 = 0;
            dhVar.f0 = 0;
            dhVar.H(i8);
            dhVar.J(i10);
            dhVar.I(i9);
            dhVar.G(iMin2);
            i11 = this.mMinWidth - i7;
            if (i11 < 0) {
                i11 = 0;
            }
            dhVar.e0 = i11;
            i12 = this.mMinHeight - i6;
            if (i12 < 0) {
                i12 = 0;
            }
            dhVar.f0 = i12;
            dhVar.z0 = iMax10;
            dhVar.A0 = iMax5;
            m6Var = dhVar.t0;
            m6Var.getClass();
            bVar = dhVar.w0;
            size = dhVar.s0.size();
            iN2 = dhVar.n();
            i13 = dhVar.i();
            zX = e.x(i, 128);
            if (zX) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        chVar6 = (ch) dhVar.s0.get(i31);
                        iArr3 = chVar6.V;
                        z18 = z;
                        if (iArr3[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr3[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z19) {
                            z21 = false;
                        } else {
                            z21 = false;
                        }
                        if (chVar6.u()) {
                            i31++;
                            z = z18;
                        } else {
                            i31++;
                            z = z18;
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
            }
            z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
            if (z3) {
                iMin3 = Math.min(iArr[0], i4);
                iMin4 = Math.min(iArr[1], i5);
                if (mode == 1073741824) {
                    dhVar.J(iMin3);
                    cmVar.b = true;
                }
                if (mode2 == 1073741824) {
                    dhVar.G(iMin4);
                    cmVar.b = true;
                }
                if (mode == 1073741824) {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var1111111116 = chVar7.d;
                            g10Var1111111116.e.j = false;
                            g10Var1111111116.g = false;
                            g10Var1111111116.n();
                            kd1 kd1Var1111111116 = chVar7.e;
                            kd1Var1111111116.e.j = false;
                            kd1Var1111111116.g = false;
                            kd1Var1111111116.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var1111111117 = dhVar2.d;
                        g10Var1111111117.e.j = false;
                        g10Var1111111117.g = false;
                        g10Var1111111117.n();
                        kd1 kd1Var1111111117 = dhVar2.e;
                        kd1Var1111111117.e.j = false;
                        kd1Var1111111117.g = false;
                        kd1Var1111111117.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                } else {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var1111111118 = chVar7.d;
                            g10Var1111111118.e.j = false;
                            g10Var1111111118.g = false;
                            g10Var1111111118.n();
                            kd1 kd1Var1111111118 = chVar7.e;
                            kd1Var1111111118.e.j = false;
                            kd1Var1111111118.g = false;
                            kd1Var1111111118.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var1111111119 = dhVar2.d;
                        g10Var1111111119.e.j = false;
                        g10Var1111111119.g = false;
                        g10Var1111111119.n();
                        kd1 kd1Var1111111119 = dhVar2.e;
                        kd1Var1111111119.e.j = false;
                        kd1Var1111111119.g = false;
                        kd1Var1111111119.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                }
                if (zP) {
                    if (mode == i29) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i29) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    dhVar.K(z14, z15);
                }
            } else {
                z4 = z3;
                i14 = 0;
                zP = false;
            }
            if (zP) {
            }
            int i311111115 = dhVar.F0;
            if (size > 0) {
                size3 = dhVar.s0.size();
                zR = dhVar.R(64);
                bVar4 = dhVar.w0;
                i24 = 0;
                while (i24 < size3) {
                    chVar5 = (ch) dhVar.s0.get(i24);
                    if (chVar5 instanceof py) {
                        i27 = size3;
                    } else {
                        chVar5.getClass();
                        if (zR) {
                        }
                        iH = chVar5.h(0);
                        int iH118 = chVar5.h(1);
                        i27 = size3;
                        if (iH == 3) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                        }
                        if (z12) {
                            m6Var.a(0, chVar5, bVar4);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = bVar4.a;
                childCount2 = constraintLayout.getChildCount();
                arrayList3 = constraintLayout.mConstraintHelpers;
                i25 = 0;
                while (i25 < childCount2) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof d) {
                        dVar = (d) childAt;
                        if (dVar.c == null) {
                            a aVar118 = (a) dVar.getLayoutParams();
                            aVar3 = (a) dVar.c.getLayoutParams();
                            chVar2 = aVar3.q0;
                            chVar2.j0 = 0;
                            chVar3 = aVar118.q0;
                            if (chVar3.V[0] != 1) {
                                chVar3.J(chVar2.n());
                            }
                            chVar4 = aVar118.q0;
                            if (chVar4.V[1] != 1) {
                                chVar4.G(aVar3.q0.i());
                            }
                            aVar3.q0.j0 = 8;
                        }
                    }
                    i25++;
                    constraintLayout = constraintLayout;
                }
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                    }
                }
            }
            m6Var.c(dhVar);
            arrayList = (ArrayList) m6Var.a;
            size2 = arrayList.size();
            if (size > 0) {
                m6Var.b(dhVar, 0, iN2, i13);
            }
            if (size2 > 0) {
                iArr2 = dhVar.V;
                if (iArr2[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr2[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int iN1110 = dhVar.n();
                dh dhVar118 = (dh) m6Var.c;
                iMax3 = Math.max(iN1110, dhVar118.e0);
                iMax4 = Math.max(dhVar.i(), dhVar118.f0);
                i15 = 0;
                while (true) {
                    aVar = vg.a.f;
                    aVar2 = vg.a.d;
                    if (i15 < size2) {
                        break;
                        break;
                    } else {
                        i15++;
                    }
                }
                i16 = 0;
                while (i16 < 2) {
                    i17 = 0;
                    z7 = false;
                    while (i17 < size2) {
                        ArrayList arrayList119 = arrayList;
                        chVar = (ch) arrayList.get(i17);
                        int i311111116 = size2;
                        if (chVar instanceof h8) {
                            z10 = z6;
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            z10 = z6;
                            if (chVar.j0 == 8) {
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                iN3 = chVar.n();
                                i22 = chVar.i();
                                z11 = z5;
                                int i311111117 = chVar.d0;
                                i21 = i17;
                                zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                bVar3 = bVar;
                                iN4 = chVar.n();
                                i20 = i16;
                                i23 = chVar.i();
                                if (iN4 != iN3) {
                                    chVar.J(iN4);
                                    if (z11) {
                                        iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                    }
                                    zA = true;
                                }
                                if (i23 != i22) {
                                    chVar.G(i23);
                                    if (z10) {
                                        iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                    }
                                    zA = true;
                                }
                                if (chVar.F) {
                                    z7 = zA;
                                } else {
                                    z7 = zA;
                                }
                            }
                        }
                        i17 = i21 + 1;
                        arrayList = arrayList119;
                        size2 = i311111116;
                        z6 = z10;
                        z5 = z11;
                        bVar = bVar3;
                        i16 = i20;
                    }
                    arrayList2 = arrayList;
                    i18 = size2;
                    z8 = z6;
                    z9 = z5;
                    bVar2 = bVar;
                    i19 = i16;
                    if (z7) {
                        break;
                        break;
                    }
                    i16 = i19 + 1;
                    m6Var.b(dhVar, i16, iN2, i13);
                    arrayList = arrayList2;
                    size2 = i18;
                    z6 = z8;
                    z5 = z9;
                    bVar = bVar2;
                }
            }
            dhVar.F0 = i311111115;
            oe0.p = dhVar.R(512);
        }
        if (mode2 != 0) {
            if (mode2 != 1073741824) {
                iMin2 = Math.min(this.mMaxHeight - i6, i5);
                i9 = 1;
            }
            iN = dhVar.n();
            iArr = dhVar.D;
            cmVar = dhVar.u0;
            i10 = iMin;
            if (i10 == iN) {
                cmVar.c = true;
                c = 1;
            } else {
                cmVar.c = true;
                c = 1;
            }
            dhVar.b0 = 0;
            dhVar.c0 = 0;
            iArr[0] = this.mMaxWidth - i7;
            iArr[c] = this.mMaxHeight - i6;
            dhVar.e0 = 0;
            dhVar.f0 = 0;
            dhVar.H(i8);
            dhVar.J(i10);
            dhVar.I(i9);
            dhVar.G(iMin2);
            i11 = this.mMinWidth - i7;
            if (i11 < 0) {
                i11 = 0;
            }
            dhVar.e0 = i11;
            i12 = this.mMinHeight - i6;
            if (i12 < 0) {
                i12 = 0;
            }
            dhVar.f0 = i12;
            dhVar.z0 = iMax10;
            dhVar.A0 = iMax5;
            m6Var = dhVar.t0;
            m6Var.getClass();
            bVar = dhVar.w0;
            size = dhVar.s0.size();
            iN2 = dhVar.n();
            i13 = dhVar.i();
            zX = e.x(i, 128);
            if (zX) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        chVar6 = (ch) dhVar.s0.get(i31);
                        iArr3 = chVar6.V;
                        z18 = z;
                        if (iArr3[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr3[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z19) {
                            z21 = false;
                        } else {
                            z21 = false;
                        }
                        if (chVar6.u()) {
                            i31++;
                            z = z18;
                        } else {
                            i31++;
                            z = z18;
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
            }
            z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
            if (z3) {
                iMin3 = Math.min(iArr[0], i4);
                iMin4 = Math.min(iArr[1], i5);
                if (mode == 1073741824) {
                    dhVar.J(iMin3);
                    cmVar.b = true;
                }
                if (mode2 == 1073741824) {
                    dhVar.G(iMin4);
                    cmVar.b = true;
                }
                if (mode == 1073741824) {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var11111111110 = chVar7.d;
                            g10Var11111111110.e.j = false;
                            g10Var11111111110.g = false;
                            g10Var11111111110.n();
                            kd1 kd1Var11111111110 = chVar7.e;
                            kd1Var11111111110.e.j = false;
                            kd1Var11111111110.g = false;
                            kd1Var11111111110.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var11111111111 = dhVar2.d;
                        g10Var11111111111.e.j = false;
                        g10Var11111111111.g = false;
                        g10Var11111111111.n();
                        kd1 kd1Var11111111111 = dhVar2.e;
                        kd1Var11111111111.e.j = false;
                        kd1Var11111111111.g = false;
                        kd1Var11111111111.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                } else {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var11111111112 = chVar7.d;
                            g10Var11111111112.e.j = false;
                            g10Var11111111112.g = false;
                            g10Var11111111112.n();
                            kd1 kd1Var11111111112 = chVar7.e;
                            kd1Var11111111112.e.j = false;
                            kd1Var11111111112.g = false;
                            kd1Var11111111112.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var11111111113 = dhVar2.d;
                        g10Var11111111113.e.j = false;
                        g10Var11111111113.g = false;
                        g10Var11111111113.n();
                        kd1 kd1Var11111111113 = dhVar2.e;
                        kd1Var11111111113.e.j = false;
                        kd1Var11111111113.g = false;
                        kd1Var11111111113.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                }
                if (zP) {
                    if (mode == i29) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i29) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    dhVar.K(z14, z15);
                }
            } else {
                z4 = z3;
                i14 = 0;
                zP = false;
            }
            if (zP) {
            }
            int i311111118 = dhVar.F0;
            if (size > 0) {
                size3 = dhVar.s0.size();
                zR = dhVar.R(64);
                bVar4 = dhVar.w0;
                i24 = 0;
                while (i24 < size3) {
                    chVar5 = (ch) dhVar.s0.get(i24);
                    if (chVar5 instanceof py) {
                        i27 = size3;
                    } else {
                        chVar5.getClass();
                        if (zR) {
                        }
                        iH = chVar5.h(0);
                        int iH119 = chVar5.h(1);
                        i27 = size3;
                        if (iH == 3) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                        }
                        if (z12) {
                            m6Var.a(0, chVar5, bVar4);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = bVar4.a;
                childCount2 = constraintLayout.getChildCount();
                arrayList3 = constraintLayout.mConstraintHelpers;
                i25 = 0;
                while (i25 < childCount2) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof d) {
                        dVar = (d) childAt;
                        if (dVar.c == null) {
                            a aVar119 = (a) dVar.getLayoutParams();
                            aVar3 = (a) dVar.c.getLayoutParams();
                            chVar2 = aVar3.q0;
                            chVar2.j0 = 0;
                            chVar3 = aVar119.q0;
                            if (chVar3.V[0] != 1) {
                                chVar3.J(chVar2.n());
                            }
                            chVar4 = aVar119.q0;
                            if (chVar4.V[1] != 1) {
                                chVar4.G(aVar3.q0.i());
                            }
                            aVar3.q0.j0 = 8;
                        }
                    }
                    i25++;
                    constraintLayout = constraintLayout;
                }
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                    }
                }
            }
            m6Var.c(dhVar);
            arrayList = (ArrayList) m6Var.a;
            size2 = arrayList.size();
            if (size > 0) {
                m6Var.b(dhVar, 0, iN2, i13);
            }
            if (size2 > 0) {
                iArr2 = dhVar.V;
                if (iArr2[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr2[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int iN1111 = dhVar.n();
                dh dhVar119 = (dh) m6Var.c;
                iMax3 = Math.max(iN1111, dhVar119.e0);
                iMax4 = Math.max(dhVar.i(), dhVar119.f0);
                i15 = 0;
                while (true) {
                    aVar = vg.a.f;
                    aVar2 = vg.a.d;
                    if (i15 < size2) {
                        break;
                        break;
                    } else {
                        i15++;
                    }
                }
                i16 = 0;
                while (i16 < 2) {
                    i17 = 0;
                    z7 = false;
                    while (i17 < size2) {
                        ArrayList arrayList1110 = arrayList;
                        chVar = (ch) arrayList.get(i17);
                        int i311111119 = size2;
                        if (chVar instanceof h8) {
                            z10 = z6;
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            z10 = z6;
                            if (chVar.j0 == 8) {
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                iN3 = chVar.n();
                                i22 = chVar.i();
                                z11 = z5;
                                int i3111111110 = chVar.d0;
                                i21 = i17;
                                zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                bVar3 = bVar;
                                iN4 = chVar.n();
                                i20 = i16;
                                i23 = chVar.i();
                                if (iN4 != iN3) {
                                    chVar.J(iN4);
                                    if (z11) {
                                        iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                    }
                                    zA = true;
                                }
                                if (i23 != i22) {
                                    chVar.G(i23);
                                    if (z10) {
                                        iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                    }
                                    zA = true;
                                }
                                if (chVar.F) {
                                    z7 = zA;
                                } else {
                                    z7 = zA;
                                }
                            }
                        }
                        i17 = i21 + 1;
                        arrayList = arrayList1110;
                        size2 = i311111119;
                        z6 = z10;
                        z5 = z11;
                        bVar = bVar3;
                        i16 = i20;
                    }
                    arrayList2 = arrayList;
                    i18 = size2;
                    z8 = z6;
                    z9 = z5;
                    bVar2 = bVar;
                    i19 = i16;
                    if (z7) {
                        break;
                        break;
                    }
                    i16 = i19 + 1;
                    m6Var.b(dhVar, i16, iN2, i13);
                    arrayList = arrayList2;
                    size2 = i18;
                    z6 = z8;
                    z5 = z9;
                    bVar = bVar2;
                }
            }
            dhVar.F0 = i311111118;
            oe0.p = dhVar.R(512);
        }
        if (childCount != 0) {
        }
        iMin2 = 0;
        iN = dhVar.n();
        iArr = dhVar.D;
        cmVar = dhVar.u0;
        i10 = iMin;
        if (i10 == iN) {
            cmVar.c = true;
            c = 1;
        } else {
            cmVar.c = true;
            c = 1;
        }
        dhVar.b0 = 0;
        dhVar.c0 = 0;
        iArr[0] = this.mMaxWidth - i7;
        iArr[c] = this.mMaxHeight - i6;
        dhVar.e0 = 0;
        dhVar.f0 = 0;
        dhVar.H(i8);
        dhVar.J(i10);
        dhVar.I(i9);
        dhVar.G(iMin2);
        i11 = this.mMinWidth - i7;
        if (i11 < 0) {
            i11 = 0;
        }
        dhVar.e0 = i11;
        i12 = this.mMinHeight - i6;
        if (i12 < 0) {
            i12 = 0;
        }
        dhVar.f0 = i12;
        dhVar.z0 = iMax10;
        dhVar.A0 = iMax5;
        m6Var = dhVar.t0;
        m6Var.getClass();
        bVar = dhVar.w0;
        size = dhVar.s0.size();
        iN2 = dhVar.n();
        i13 = dhVar.i();
        zX = e.x(i, 128);
        if (zX) {
            z = true;
        } else {
            z = true;
        }
        if (z) {
            i31 = 0;
            while (true) {
                if (i31 < size) {
                    chVar6 = (ch) dhVar.s0.get(i31);
                    iArr3 = chVar6.V;
                    z18 = z;
                    if (iArr3[0] == 3) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (iArr3[1] == 3) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    if (z19) {
                        z21 = false;
                    } else {
                        z21 = false;
                    }
                    if (chVar6.u()) {
                        i31++;
                        z = z18;
                    } else {
                        i31++;
                        z = z18;
                    }
                    z2 = false;
                } else {
                    z2 = z;
                }
            }
        } else {
            z2 = z;
        }
        z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
        if (z3) {
            iMin3 = Math.min(iArr[0], i4);
            iMin4 = Math.min(iArr[1], i5);
            if (mode == 1073741824) {
                dhVar.J(iMin3);
                cmVar.b = true;
            }
            if (mode2 == 1073741824) {
                dhVar.G(iMin4);
                cmVar.b = true;
            }
            if (mode == 1073741824) {
                z4 = z3;
                z13 = cmVar.b;
                dhVar2 = cmVar.a;
                if (z13) {
                    while (r0.hasNext()) {
                        chVar7.f();
                        chVar7.a = false;
                        g10 g10Var11111111114 = chVar7.d;
                        g10Var11111111114.e.j = false;
                        g10Var11111111114.g = false;
                        g10Var11111111114.n();
                        kd1 kd1Var11111111114 = chVar7.e;
                        kd1Var11111111114.e.j = false;
                        kd1Var11111111114.g = false;
                        kd1Var11111111114.m();
                    }
                    i28 = 0;
                    dhVar2.f();
                    dhVar2.a = false;
                    g10 g10Var11111111115 = dhVar2.d;
                    g10Var11111111115.e.j = false;
                    g10Var11111111115.g = false;
                    g10Var11111111115.n();
                    kd1 kd1Var11111111115 = dhVar2.e;
                    kd1Var11111111115.e.j = false;
                    kd1Var11111111115.g = false;
                    kd1Var11111111115.m();
                    cmVar.c();
                } else {
                    i28 = 0;
                }
                cmVar.b(cmVar.d);
                dhVar2.b0 = i28;
                dhVar2.c0 = i28;
                dhVar2.d.h.d(i28);
                dhVar2.e.h.d(i28);
                i29 = 1073741824;
                if (mode == 1073741824) {
                    zP = dhVar.P(i28, zX);
                    i14 = 1;
                } else {
                    i14 = 0;
                    zP = true;
                }
                if (mode2 == 1073741824) {
                    zP &= dhVar.P(1, zX);
                    i14++;
                }
            } else {
                z4 = z3;
                z13 = cmVar.b;
                dhVar2 = cmVar.a;
                if (z13) {
                    while (r0.hasNext()) {
                        chVar7.f();
                        chVar7.a = false;
                        g10 g10Var11111111116 = chVar7.d;
                        g10Var11111111116.e.j = false;
                        g10Var11111111116.g = false;
                        g10Var11111111116.n();
                        kd1 kd1Var11111111116 = chVar7.e;
                        kd1Var11111111116.e.j = false;
                        kd1Var11111111116.g = false;
                        kd1Var11111111116.m();
                    }
                    i28 = 0;
                    dhVar2.f();
                    dhVar2.a = false;
                    g10 g10Var11111111117 = dhVar2.d;
                    g10Var11111111117.e.j = false;
                    g10Var11111111117.g = false;
                    g10Var11111111117.n();
                    kd1 kd1Var11111111117 = dhVar2.e;
                    kd1Var11111111117.e.j = false;
                    kd1Var11111111117.g = false;
                    kd1Var11111111117.m();
                    cmVar.c();
                } else {
                    i28 = 0;
                }
                cmVar.b(cmVar.d);
                dhVar2.b0 = i28;
                dhVar2.c0 = i28;
                dhVar2.d.h.d(i28);
                dhVar2.e.h.d(i28);
                i29 = 1073741824;
                if (mode == 1073741824) {
                    zP = dhVar.P(i28, zX);
                    i14 = 1;
                } else {
                    i14 = 0;
                    zP = true;
                }
                if (mode2 == 1073741824) {
                    zP &= dhVar.P(1, zX);
                    i14++;
                }
            }
            if (zP) {
                if (mode == i29) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (mode2 == i29) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                dhVar.K(z14, z15);
            }
        } else {
            z4 = z3;
            i14 = 0;
            zP = false;
        }
        if (zP) {
        }
        int i3111111111 = dhVar.F0;
        if (size > 0) {
            size3 = dhVar.s0.size();
            zR = dhVar.R(64);
            bVar4 = dhVar.w0;
            i24 = 0;
            while (i24 < size3) {
                chVar5 = (ch) dhVar.s0.get(i24);
                if (chVar5 instanceof py) {
                    i27 = size3;
                } else {
                    chVar5.getClass();
                    if (zR) {
                    }
                    iH = chVar5.h(0);
                    int iH1110 = chVar5.h(1);
                    i27 = size3;
                    if (iH == 3) {
                        z12 = false;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                    }
                    if (z12) {
                        m6Var.a(0, chVar5, bVar4);
                    }
                }
                i24++;
                size3 = i27;
            }
            constraintLayout = bVar4.a;
            childCount2 = constraintLayout.getChildCount();
            arrayList3 = constraintLayout.mConstraintHelpers;
            i25 = 0;
            while (i25 < childCount2) {
                childAt = constraintLayout.getChildAt(i25);
                if (childAt instanceof d) {
                    dVar = (d) childAt;
                    if (dVar.c == null) {
                        a aVar1110 = (a) dVar.getLayoutParams();
                        aVar3 = (a) dVar.c.getLayoutParams();
                        chVar2 = aVar3.q0;
                        chVar2.j0 = 0;
                        chVar3 = aVar1110.q0;
                        if (chVar3.V[0] != 1) {
                            chVar3.J(chVar2.n());
                        }
                        chVar4 = aVar1110.q0;
                        if (chVar4.V[1] != 1) {
                            chVar4.G(aVar3.q0.i());
                        }
                        aVar3.q0.j0 = 8;
                    }
                }
                i25++;
                constraintLayout = constraintLayout;
            }
            size4 = arrayList3.size();
            if (size4 > 0) {
                while (i26 < size4) {
                    ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                }
            }
        }
        m6Var.c(dhVar);
        arrayList = (ArrayList) m6Var.a;
        size2 = arrayList.size();
        if (size > 0) {
            m6Var.b(dhVar, 0, iN2, i13);
        }
        if (size2 > 0) {
            iArr2 = dhVar.V;
            if (iArr2[0] == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (iArr2[1] == 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            int iN1112 = dhVar.n();
            dh dhVar1110 = (dh) m6Var.c;
            iMax3 = Math.max(iN1112, dhVar1110.e0);
            iMax4 = Math.max(dhVar.i(), dhVar1110.f0);
            i15 = 0;
            while (true) {
                aVar = vg.a.f;
                aVar2 = vg.a.d;
                if (i15 < size2) {
                    break;
                    break;
                } else {
                    i15++;
                }
            }
            i16 = 0;
            while (i16 < 2) {
                i17 = 0;
                z7 = false;
                while (i17 < size2) {
                    ArrayList arrayList1111 = arrayList;
                    chVar = (ch) arrayList.get(i17);
                    int i3111111112 = size2;
                    if (chVar instanceof h8) {
                        z10 = z6;
                        z11 = z5;
                        bVar3 = bVar;
                        i20 = i16;
                        i21 = i17;
                    } else {
                        z10 = z6;
                        if (chVar.j0 == 8) {
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            iN3 = chVar.n();
                            i22 = chVar.i();
                            z11 = z5;
                            int i3111111113 = chVar.d0;
                            i21 = i17;
                            zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                            bVar3 = bVar;
                            iN4 = chVar.n();
                            i20 = i16;
                            i23 = chVar.i();
                            if (iN4 != iN3) {
                                chVar.J(iN4);
                                if (z11) {
                                    iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                }
                                zA = true;
                            }
                            if (i23 != i22) {
                                chVar.G(i23);
                                if (z10) {
                                    iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                }
                                zA = true;
                            }
                            if (chVar.F) {
                                z7 = zA;
                            } else {
                                z7 = zA;
                            }
                        }
                    }
                    i17 = i21 + 1;
                    arrayList = arrayList1111;
                    size2 = i3111111112;
                    z6 = z10;
                    z5 = z11;
                    bVar = bVar3;
                    i16 = i20;
                }
                arrayList2 = arrayList;
                i18 = size2;
                z8 = z6;
                z9 = z5;
                bVar2 = bVar;
                i19 = i16;
                if (z7) {
                    break;
                    break;
                }
                i16 = i19 + 1;
                m6Var.b(dhVar, i16, iN2, i13);
                arrayList = arrayList2;
                size2 = i18;
                z6 = z8;
                z5 = z9;
                bVar = bVar2;
            }
        }
        dhVar.F0 = i3111111111;
        oe0.p = dhVar.R(512);
        iMax2 = Math.max(0, this.mMinHeight);
        iMin2 = iMax2;
        i9 = 2;
        iN = dhVar.n();
        iArr = dhVar.D;
        cmVar = dhVar.u0;
        i10 = iMin;
        if (i10 == iN) {
            cmVar.c = true;
            c = 1;
        } else {
            cmVar.c = true;
            c = 1;
        }
        dhVar.b0 = 0;
        dhVar.c0 = 0;
        iArr[0] = this.mMaxWidth - i7;
        iArr[c] = this.mMaxHeight - i6;
        dhVar.e0 = 0;
        dhVar.f0 = 0;
        dhVar.H(i8);
        dhVar.J(i10);
        dhVar.I(i9);
        dhVar.G(iMin2);
        i11 = this.mMinWidth - i7;
        if (i11 < 0) {
            i11 = 0;
        }
        dhVar.e0 = i11;
        i12 = this.mMinHeight - i6;
        if (i12 < 0) {
            i12 = 0;
        }
        dhVar.f0 = i12;
        dhVar.z0 = iMax10;
        dhVar.A0 = iMax5;
        m6Var = dhVar.t0;
        m6Var.getClass();
        bVar = dhVar.w0;
        size = dhVar.s0.size();
        iN2 = dhVar.n();
        i13 = dhVar.i();
        zX = e.x(i, 128);
        if (zX) {
            z = true;
        } else {
            z = true;
        }
        if (z) {
            i31 = 0;
            while (true) {
                if (i31 < size) {
                    chVar6 = (ch) dhVar.s0.get(i31);
                    iArr3 = chVar6.V;
                    z18 = z;
                    if (iArr3[0] == 3) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (iArr3[1] == 3) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    if (z19) {
                        z21 = false;
                    } else {
                        z21 = false;
                    }
                    if (chVar6.u()) {
                        i31++;
                        z = z18;
                    } else {
                        i31++;
                        z = z18;
                    }
                    z2 = false;
                } else {
                    z2 = z;
                }
            }
        } else {
            z2 = z;
        }
        z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
        if (z3) {
            iMin3 = Math.min(iArr[0], i4);
            iMin4 = Math.min(iArr[1], i5);
            if (mode == 1073741824) {
                dhVar.J(iMin3);
                cmVar.b = true;
            }
            if (mode2 == 1073741824) {
                dhVar.G(iMin4);
                cmVar.b = true;
            }
            if (mode == 1073741824) {
                z4 = z3;
                z13 = cmVar.b;
                dhVar2 = cmVar.a;
                if (z13) {
                    while (r0.hasNext()) {
                        chVar7.f();
                        chVar7.a = false;
                        g10 g10Var11111111118 = chVar7.d;
                        g10Var11111111118.e.j = false;
                        g10Var11111111118.g = false;
                        g10Var11111111118.n();
                        kd1 kd1Var11111111118 = chVar7.e;
                        kd1Var11111111118.e.j = false;
                        kd1Var11111111118.g = false;
                        kd1Var11111111118.m();
                    }
                    i28 = 0;
                    dhVar2.f();
                    dhVar2.a = false;
                    g10 g10Var11111111119 = dhVar2.d;
                    g10Var11111111119.e.j = false;
                    g10Var11111111119.g = false;
                    g10Var11111111119.n();
                    kd1 kd1Var11111111119 = dhVar2.e;
                    kd1Var11111111119.e.j = false;
                    kd1Var11111111119.g = false;
                    kd1Var11111111119.m();
                    cmVar.c();
                } else {
                    i28 = 0;
                }
                cmVar.b(cmVar.d);
                dhVar2.b0 = i28;
                dhVar2.c0 = i28;
                dhVar2.d.h.d(i28);
                dhVar2.e.h.d(i28);
                i29 = 1073741824;
                if (mode == 1073741824) {
                    zP = dhVar.P(i28, zX);
                    i14 = 1;
                } else {
                    i14 = 0;
                    zP = true;
                }
                if (mode2 == 1073741824) {
                    zP &= dhVar.P(1, zX);
                    i14++;
                }
            } else {
                z4 = z3;
                z13 = cmVar.b;
                dhVar2 = cmVar.a;
                if (z13) {
                    while (r0.hasNext()) {
                        chVar7.f();
                        chVar7.a = false;
                        g10 g10Var111111111110 = chVar7.d;
                        g10Var111111111110.e.j = false;
                        g10Var111111111110.g = false;
                        g10Var111111111110.n();
                        kd1 kd1Var111111111110 = chVar7.e;
                        kd1Var111111111110.e.j = false;
                        kd1Var111111111110.g = false;
                        kd1Var111111111110.m();
                    }
                    i28 = 0;
                    dhVar2.f();
                    dhVar2.a = false;
                    g10 g10Var111111111111 = dhVar2.d;
                    g10Var111111111111.e.j = false;
                    g10Var111111111111.g = false;
                    g10Var111111111111.n();
                    kd1 kd1Var111111111111 = dhVar2.e;
                    kd1Var111111111111.e.j = false;
                    kd1Var111111111111.g = false;
                    kd1Var111111111111.m();
                    cmVar.c();
                } else {
                    i28 = 0;
                }
                cmVar.b(cmVar.d);
                dhVar2.b0 = i28;
                dhVar2.c0 = i28;
                dhVar2.d.h.d(i28);
                dhVar2.e.h.d(i28);
                i29 = 1073741824;
                if (mode == 1073741824) {
                    zP = dhVar.P(i28, zX);
                    i14 = 1;
                } else {
                    i14 = 0;
                    zP = true;
                }
                if (mode2 == 1073741824) {
                    zP &= dhVar.P(1, zX);
                    i14++;
                }
            }
            if (zP) {
                if (mode == i29) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (mode2 == i29) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                dhVar.K(z14, z15);
            }
        } else {
            z4 = z3;
            i14 = 0;
            zP = false;
        }
        if (zP) {
        }
        int i3111111114 = dhVar.F0;
        if (size > 0) {
            size3 = dhVar.s0.size();
            zR = dhVar.R(64);
            bVar4 = dhVar.w0;
            i24 = 0;
            while (i24 < size3) {
                chVar5 = (ch) dhVar.s0.get(i24);
                if (chVar5 instanceof py) {
                    i27 = size3;
                } else {
                    chVar5.getClass();
                    if (zR) {
                    }
                    iH = chVar5.h(0);
                    int iH1111 = chVar5.h(1);
                    i27 = size3;
                    if (iH == 3) {
                        z12 = false;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                    }
                    if (z12) {
                        m6Var.a(0, chVar5, bVar4);
                    }
                }
                i24++;
                size3 = i27;
            }
            constraintLayout = bVar4.a;
            childCount2 = constraintLayout.getChildCount();
            arrayList3 = constraintLayout.mConstraintHelpers;
            i25 = 0;
            while (i25 < childCount2) {
                childAt = constraintLayout.getChildAt(i25);
                if (childAt instanceof d) {
                    dVar = (d) childAt;
                    if (dVar.c == null) {
                        a aVar1111 = (a) dVar.getLayoutParams();
                        aVar3 = (a) dVar.c.getLayoutParams();
                        chVar2 = aVar3.q0;
                        chVar2.j0 = 0;
                        chVar3 = aVar1111.q0;
                        if (chVar3.V[0] != 1) {
                            chVar3.J(chVar2.n());
                        }
                        chVar4 = aVar1111.q0;
                        if (chVar4.V[1] != 1) {
                            chVar4.G(aVar3.q0.i());
                        }
                        aVar3.q0.j0 = 8;
                    }
                }
                i25++;
                constraintLayout = constraintLayout;
            }
            size4 = arrayList3.size();
            if (size4 > 0) {
                while (i26 < size4) {
                    ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                }
            }
        }
        m6Var.c(dhVar);
        arrayList = (ArrayList) m6Var.a;
        size2 = arrayList.size();
        if (size > 0) {
            m6Var.b(dhVar, 0, iN2, i13);
        }
        if (size2 > 0) {
            iArr2 = dhVar.V;
            if (iArr2[0] == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (iArr2[1] == 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            int iN1113 = dhVar.n();
            dh dhVar1111 = (dh) m6Var.c;
            iMax3 = Math.max(iN1113, dhVar1111.e0);
            iMax4 = Math.max(dhVar.i(), dhVar1111.f0);
            i15 = 0;
            while (true) {
                aVar = vg.a.f;
                aVar2 = vg.a.d;
                if (i15 < size2) {
                    break;
                    break;
                } else {
                    i15++;
                }
            }
            i16 = 0;
            while (i16 < 2) {
                i17 = 0;
                z7 = false;
                while (i17 < size2) {
                    ArrayList arrayList1112 = arrayList;
                    chVar = (ch) arrayList.get(i17);
                    int i3111111115 = size2;
                    if (chVar instanceof h8) {
                        z10 = z6;
                        z11 = z5;
                        bVar3 = bVar;
                        i20 = i16;
                        i21 = i17;
                    } else {
                        z10 = z6;
                        if (chVar.j0 == 8) {
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            iN3 = chVar.n();
                            i22 = chVar.i();
                            z11 = z5;
                            int i3111111116 = chVar.d0;
                            i21 = i17;
                            zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                            bVar3 = bVar;
                            iN4 = chVar.n();
                            i20 = i16;
                            i23 = chVar.i();
                            if (iN4 != iN3) {
                                chVar.J(iN4);
                                if (z11) {
                                    iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                }
                                zA = true;
                            }
                            if (i23 != i22) {
                                chVar.G(i23);
                                if (z10) {
                                    iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                }
                                zA = true;
                            }
                            if (chVar.F) {
                                z7 = zA;
                            } else {
                                z7 = zA;
                            }
                        }
                    }
                    i17 = i21 + 1;
                    arrayList = arrayList1112;
                    size2 = i3111111115;
                    z6 = z10;
                    z5 = z11;
                    bVar = bVar3;
                    i16 = i20;
                }
                arrayList2 = arrayList;
                i18 = size2;
                z8 = z6;
                z9 = z5;
                bVar2 = bVar;
                i19 = i16;
                if (z7) {
                    break;
                    break;
                }
                i16 = i19 + 1;
                m6Var.b(dhVar, i16, iN2, i13);
                arrayList = arrayList2;
                size2 = i18;
                z6 = z8;
                z5 = z9;
                bVar = bVar2;
            }
        }
        dhVar.F0 = i3111111114;
        oe0.p = dhVar.R(512);
        iMax = Math.max(0, this.mMinWidth);
        iMin = iMax;
        i8 = 2;
        if (mode2 != Integer.MIN_VALUE) {
            if (childCount == 0) {
                iMax2 = i5;
            }
            iMin2 = iMax2;
            i9 = 2;
            iN = dhVar.n();
            iArr = dhVar.D;
            cmVar = dhVar.u0;
            i10 = iMin;
            if (i10 == iN) {
                cmVar.c = true;
                c = 1;
            } else {
                cmVar.c = true;
                c = 1;
            }
            dhVar.b0 = 0;
            dhVar.c0 = 0;
            iArr[0] = this.mMaxWidth - i7;
            iArr[c] = this.mMaxHeight - i6;
            dhVar.e0 = 0;
            dhVar.f0 = 0;
            dhVar.H(i8);
            dhVar.J(i10);
            dhVar.I(i9);
            dhVar.G(iMin2);
            i11 = this.mMinWidth - i7;
            if (i11 < 0) {
                i11 = 0;
            }
            dhVar.e0 = i11;
            i12 = this.mMinHeight - i6;
            if (i12 < 0) {
                i12 = 0;
            }
            dhVar.f0 = i12;
            dhVar.z0 = iMax10;
            dhVar.A0 = iMax5;
            m6Var = dhVar.t0;
            m6Var.getClass();
            bVar = dhVar.w0;
            size = dhVar.s0.size();
            iN2 = dhVar.n();
            i13 = dhVar.i();
            zX = e.x(i, 128);
            if (zX) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        chVar6 = (ch) dhVar.s0.get(i31);
                        iArr3 = chVar6.V;
                        z18 = z;
                        if (iArr3[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr3[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z19) {
                            z21 = false;
                        } else {
                            z21 = false;
                        }
                        if (chVar6.u()) {
                            i31++;
                            z = z18;
                        } else {
                            i31++;
                            z = z18;
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
            }
            z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
            if (z3) {
                iMin3 = Math.min(iArr[0], i4);
                iMin4 = Math.min(iArr[1], i5);
                if (mode == 1073741824) {
                    dhVar.J(iMin3);
                    cmVar.b = true;
                }
                if (mode2 == 1073741824) {
                    dhVar.G(iMin4);
                    cmVar.b = true;
                }
                if (mode == 1073741824) {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var111111111112 = chVar7.d;
                            g10Var111111111112.e.j = false;
                            g10Var111111111112.g = false;
                            g10Var111111111112.n();
                            kd1 kd1Var111111111112 = chVar7.e;
                            kd1Var111111111112.e.j = false;
                            kd1Var111111111112.g = false;
                            kd1Var111111111112.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var111111111113 = dhVar2.d;
                        g10Var111111111113.e.j = false;
                        g10Var111111111113.g = false;
                        g10Var111111111113.n();
                        kd1 kd1Var111111111113 = dhVar2.e;
                        kd1Var111111111113.e.j = false;
                        kd1Var111111111113.g = false;
                        kd1Var111111111113.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                } else {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var111111111114 = chVar7.d;
                            g10Var111111111114.e.j = false;
                            g10Var111111111114.g = false;
                            g10Var111111111114.n();
                            kd1 kd1Var111111111114 = chVar7.e;
                            kd1Var111111111114.e.j = false;
                            kd1Var111111111114.g = false;
                            kd1Var111111111114.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var111111111115 = dhVar2.d;
                        g10Var111111111115.e.j = false;
                        g10Var111111111115.g = false;
                        g10Var111111111115.n();
                        kd1 kd1Var111111111115 = dhVar2.e;
                        kd1Var111111111115.e.j = false;
                        kd1Var111111111115.g = false;
                        kd1Var111111111115.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                }
                if (zP) {
                    if (mode == i29) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i29) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    dhVar.K(z14, z15);
                }
            } else {
                z4 = z3;
                i14 = 0;
                zP = false;
            }
            if (zP) {
            }
            int i3111111117 = dhVar.F0;
            if (size > 0) {
                size3 = dhVar.s0.size();
                zR = dhVar.R(64);
                bVar4 = dhVar.w0;
                i24 = 0;
                while (i24 < size3) {
                    chVar5 = (ch) dhVar.s0.get(i24);
                    if (chVar5 instanceof py) {
                        i27 = size3;
                    } else {
                        chVar5.getClass();
                        if (zR) {
                        }
                        iH = chVar5.h(0);
                        int iH1112 = chVar5.h(1);
                        i27 = size3;
                        if (iH == 3) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                        }
                        if (z12) {
                            m6Var.a(0, chVar5, bVar4);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = bVar4.a;
                childCount2 = constraintLayout.getChildCount();
                arrayList3 = constraintLayout.mConstraintHelpers;
                i25 = 0;
                while (i25 < childCount2) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof d) {
                        dVar = (d) childAt;
                        if (dVar.c == null) {
                            a aVar1112 = (a) dVar.getLayoutParams();
                            aVar3 = (a) dVar.c.getLayoutParams();
                            chVar2 = aVar3.q0;
                            chVar2.j0 = 0;
                            chVar3 = aVar1112.q0;
                            if (chVar3.V[0] != 1) {
                                chVar3.J(chVar2.n());
                            }
                            chVar4 = aVar1112.q0;
                            if (chVar4.V[1] != 1) {
                                chVar4.G(aVar3.q0.i());
                            }
                            aVar3.q0.j0 = 8;
                        }
                    }
                    i25++;
                    constraintLayout = constraintLayout;
                }
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                    }
                }
            }
            m6Var.c(dhVar);
            arrayList = (ArrayList) m6Var.a;
            size2 = arrayList.size();
            if (size > 0) {
                m6Var.b(dhVar, 0, iN2, i13);
            }
            if (size2 > 0) {
                iArr2 = dhVar.V;
                if (iArr2[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr2[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int iN1114 = dhVar.n();
                dh dhVar1112 = (dh) m6Var.c;
                iMax3 = Math.max(iN1114, dhVar1112.e0);
                iMax4 = Math.max(dhVar.i(), dhVar1112.f0);
                i15 = 0;
                while (true) {
                    aVar = vg.a.f;
                    aVar2 = vg.a.d;
                    if (i15 < size2) {
                        break;
                        break;
                    } else {
                        i15++;
                    }
                }
                i16 = 0;
                while (i16 < 2) {
                    i17 = 0;
                    z7 = false;
                    while (i17 < size2) {
                        ArrayList arrayList1113 = arrayList;
                        chVar = (ch) arrayList.get(i17);
                        int i3111111118 = size2;
                        if (chVar instanceof h8) {
                            z10 = z6;
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            z10 = z6;
                            if (chVar.j0 == 8) {
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                iN3 = chVar.n();
                                i22 = chVar.i();
                                z11 = z5;
                                int i3111111119 = chVar.d0;
                                i21 = i17;
                                zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                bVar3 = bVar;
                                iN4 = chVar.n();
                                i20 = i16;
                                i23 = chVar.i();
                                if (iN4 != iN3) {
                                    chVar.J(iN4);
                                    if (z11) {
                                        iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                    }
                                    zA = true;
                                }
                                if (i23 != i22) {
                                    chVar.G(i23);
                                    if (z10) {
                                        iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                    }
                                    zA = true;
                                }
                                if (chVar.F) {
                                    z7 = zA;
                                } else {
                                    z7 = zA;
                                }
                            }
                        }
                        i17 = i21 + 1;
                        arrayList = arrayList1113;
                        size2 = i3111111118;
                        z6 = z10;
                        z5 = z11;
                        bVar = bVar3;
                        i16 = i20;
                    }
                    arrayList2 = arrayList;
                    i18 = size2;
                    z8 = z6;
                    z9 = z5;
                    bVar2 = bVar;
                    i19 = i16;
                    if (z7) {
                        break;
                        break;
                    }
                    i16 = i19 + 1;
                    m6Var.b(dhVar, i16, iN2, i13);
                    arrayList = arrayList2;
                    size2 = i18;
                    z6 = z8;
                    z5 = z9;
                    bVar = bVar2;
                }
            }
            dhVar.F0 = i3111111117;
            oe0.p = dhVar.R(512);
        }
        if (mode2 != 0) {
            if (mode2 != 1073741824) {
                iMin2 = Math.min(this.mMaxHeight - i6, i5);
                i9 = 1;
            }
            iN = dhVar.n();
            iArr = dhVar.D;
            cmVar = dhVar.u0;
            i10 = iMin;
            if (i10 == iN) {
                cmVar.c = true;
                c = 1;
            } else {
                cmVar.c = true;
                c = 1;
            }
            dhVar.b0 = 0;
            dhVar.c0 = 0;
            iArr[0] = this.mMaxWidth - i7;
            iArr[c] = this.mMaxHeight - i6;
            dhVar.e0 = 0;
            dhVar.f0 = 0;
            dhVar.H(i8);
            dhVar.J(i10);
            dhVar.I(i9);
            dhVar.G(iMin2);
            i11 = this.mMinWidth - i7;
            if (i11 < 0) {
                i11 = 0;
            }
            dhVar.e0 = i11;
            i12 = this.mMinHeight - i6;
            if (i12 < 0) {
                i12 = 0;
            }
            dhVar.f0 = i12;
            dhVar.z0 = iMax10;
            dhVar.A0 = iMax5;
            m6Var = dhVar.t0;
            m6Var.getClass();
            bVar = dhVar.w0;
            size = dhVar.s0.size();
            iN2 = dhVar.n();
            i13 = dhVar.i();
            zX = e.x(i, 128);
            if (zX) {
                z = true;
            } else {
                z = true;
            }
            if (z) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        chVar6 = (ch) dhVar.s0.get(i31);
                        iArr3 = chVar6.V;
                        z18 = z;
                        if (iArr3[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr3[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z19) {
                            z21 = false;
                        } else {
                            z21 = false;
                        }
                        if (chVar6.u()) {
                            i31++;
                            z = z18;
                        } else {
                            i31++;
                            z = z18;
                        }
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
            }
            z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
            if (z3) {
                iMin3 = Math.min(iArr[0], i4);
                iMin4 = Math.min(iArr[1], i5);
                if (mode == 1073741824) {
                    dhVar.J(iMin3);
                    cmVar.b = true;
                }
                if (mode2 == 1073741824) {
                    dhVar.G(iMin4);
                    cmVar.b = true;
                }
                if (mode == 1073741824) {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var111111111116 = chVar7.d;
                            g10Var111111111116.e.j = false;
                            g10Var111111111116.g = false;
                            g10Var111111111116.n();
                            kd1 kd1Var111111111116 = chVar7.e;
                            kd1Var111111111116.e.j = false;
                            kd1Var111111111116.g = false;
                            kd1Var111111111116.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var111111111117 = dhVar2.d;
                        g10Var111111111117.e.j = false;
                        g10Var111111111117.g = false;
                        g10Var111111111117.n();
                        kd1 kd1Var111111111117 = dhVar2.e;
                        kd1Var111111111117.e.j = false;
                        kd1Var111111111117.g = false;
                        kd1Var111111111117.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                } else {
                    z4 = z3;
                    z13 = cmVar.b;
                    dhVar2 = cmVar.a;
                    if (z13) {
                        while (r0.hasNext()) {
                            chVar7.f();
                            chVar7.a = false;
                            g10 g10Var111111111118 = chVar7.d;
                            g10Var111111111118.e.j = false;
                            g10Var111111111118.g = false;
                            g10Var111111111118.n();
                            kd1 kd1Var111111111118 = chVar7.e;
                            kd1Var111111111118.e.j = false;
                            kd1Var111111111118.g = false;
                            kd1Var111111111118.m();
                        }
                        i28 = 0;
                        dhVar2.f();
                        dhVar2.a = false;
                        g10 g10Var111111111119 = dhVar2.d;
                        g10Var111111111119.e.j = false;
                        g10Var111111111119.g = false;
                        g10Var111111111119.n();
                        kd1 kd1Var111111111119 = dhVar2.e;
                        kd1Var111111111119.e.j = false;
                        kd1Var111111111119.g = false;
                        kd1Var111111111119.m();
                        cmVar.c();
                    } else {
                        i28 = 0;
                    }
                    cmVar.b(cmVar.d);
                    dhVar2.b0 = i28;
                    dhVar2.c0 = i28;
                    dhVar2.d.h.d(i28);
                    dhVar2.e.h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zP = dhVar.P(i28, zX);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zP = true;
                    }
                    if (mode2 == 1073741824) {
                        zP &= dhVar.P(1, zX);
                        i14++;
                    }
                }
                if (zP) {
                    if (mode == i29) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i29) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    dhVar.K(z14, z15);
                }
            } else {
                z4 = z3;
                i14 = 0;
                zP = false;
            }
            if (zP) {
            }
            int i31111111110 = dhVar.F0;
            if (size > 0) {
                size3 = dhVar.s0.size();
                zR = dhVar.R(64);
                bVar4 = dhVar.w0;
                i24 = 0;
                while (i24 < size3) {
                    chVar5 = (ch) dhVar.s0.get(i24);
                    if (chVar5 instanceof py) {
                        i27 = size3;
                    } else {
                        chVar5.getClass();
                        if (zR) {
                        }
                        iH = chVar5.h(0);
                        int iH1113 = chVar5.h(1);
                        i27 = size3;
                        if (iH == 3) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                        }
                        if (z12) {
                            m6Var.a(0, chVar5, bVar4);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = bVar4.a;
                childCount2 = constraintLayout.getChildCount();
                arrayList3 = constraintLayout.mConstraintHelpers;
                i25 = 0;
                while (i25 < childCount2) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof d) {
                        dVar = (d) childAt;
                        if (dVar.c == null) {
                            a aVar1113 = (a) dVar.getLayoutParams();
                            aVar3 = (a) dVar.c.getLayoutParams();
                            chVar2 = aVar3.q0;
                            chVar2.j0 = 0;
                            chVar3 = aVar1113.q0;
                            if (chVar3.V[0] != 1) {
                                chVar3.J(chVar2.n());
                            }
                            chVar4 = aVar1113.q0;
                            if (chVar4.V[1] != 1) {
                                chVar4.G(aVar3.q0.i());
                            }
                            aVar3.q0.j0 = 8;
                        }
                    }
                    i25++;
                    constraintLayout = constraintLayout;
                }
                size4 = arrayList3.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                    }
                }
            }
            m6Var.c(dhVar);
            arrayList = (ArrayList) m6Var.a;
            size2 = arrayList.size();
            if (size > 0) {
                m6Var.b(dhVar, 0, iN2, i13);
            }
            if (size2 > 0) {
                iArr2 = dhVar.V;
                if (iArr2[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr2[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int iN1115 = dhVar.n();
                dh dhVar1113 = (dh) m6Var.c;
                iMax3 = Math.max(iN1115, dhVar1113.e0);
                iMax4 = Math.max(dhVar.i(), dhVar1113.f0);
                i15 = 0;
                while (true) {
                    aVar = vg.a.f;
                    aVar2 = vg.a.d;
                    if (i15 < size2) {
                        break;
                        break;
                    } else {
                        i15++;
                    }
                }
                i16 = 0;
                while (i16 < 2) {
                    i17 = 0;
                    z7 = false;
                    while (i17 < size2) {
                        ArrayList arrayList1114 = arrayList;
                        chVar = (ch) arrayList.get(i17);
                        int i31111111111 = size2;
                        if (chVar instanceof h8) {
                            z10 = z6;
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            z10 = z6;
                            if (chVar.j0 == 8) {
                                z11 = z5;
                                bVar3 = bVar;
                                i20 = i16;
                                i21 = i17;
                            } else {
                                iN3 = chVar.n();
                                i22 = chVar.i();
                                z11 = z5;
                                int i31111111112 = chVar.d0;
                                i21 = i17;
                                zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                                bVar3 = bVar;
                                iN4 = chVar.n();
                                i20 = i16;
                                i23 = chVar.i();
                                if (iN4 != iN3) {
                                    chVar.J(iN4);
                                    if (z11) {
                                        iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                    }
                                    zA = true;
                                }
                                if (i23 != i22) {
                                    chVar.G(i23);
                                    if (z10) {
                                        iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                    }
                                    zA = true;
                                }
                                if (chVar.F) {
                                    z7 = zA;
                                } else {
                                    z7 = zA;
                                }
                            }
                        }
                        i17 = i21 + 1;
                        arrayList = arrayList1114;
                        size2 = i31111111111;
                        z6 = z10;
                        z5 = z11;
                        bVar = bVar3;
                        i16 = i20;
                    }
                    arrayList2 = arrayList;
                    i18 = size2;
                    z8 = z6;
                    z9 = z5;
                    bVar2 = bVar;
                    i19 = i16;
                    if (z7) {
                        break;
                        break;
                    }
                    i16 = i19 + 1;
                    m6Var.b(dhVar, i16, iN2, i13);
                    arrayList = arrayList2;
                    size2 = i18;
                    z6 = z8;
                    z5 = z9;
                    bVar = bVar2;
                }
            }
            dhVar.F0 = i31111111110;
            oe0.p = dhVar.R(512);
        }
        if (childCount != 0) {
        }
        iMin2 = 0;
        iN = dhVar.n();
        iArr = dhVar.D;
        cmVar = dhVar.u0;
        i10 = iMin;
        if (i10 == iN) {
            cmVar.c = true;
            c = 1;
        } else {
            cmVar.c = true;
            c = 1;
        }
        dhVar.b0 = 0;
        dhVar.c0 = 0;
        iArr[0] = this.mMaxWidth - i7;
        iArr[c] = this.mMaxHeight - i6;
        dhVar.e0 = 0;
        dhVar.f0 = 0;
        dhVar.H(i8);
        dhVar.J(i10);
        dhVar.I(i9);
        dhVar.G(iMin2);
        i11 = this.mMinWidth - i7;
        if (i11 < 0) {
            i11 = 0;
        }
        dhVar.e0 = i11;
        i12 = this.mMinHeight - i6;
        if (i12 < 0) {
            i12 = 0;
        }
        dhVar.f0 = i12;
        dhVar.z0 = iMax10;
        dhVar.A0 = iMax5;
        m6Var = dhVar.t0;
        m6Var.getClass();
        bVar = dhVar.w0;
        size = dhVar.s0.size();
        iN2 = dhVar.n();
        i13 = dhVar.i();
        zX = e.x(i, 128);
        if (zX) {
            z = true;
        } else {
            z = true;
        }
        if (z) {
            i31 = 0;
            while (true) {
                if (i31 < size) {
                    chVar6 = (ch) dhVar.s0.get(i31);
                    iArr3 = chVar6.V;
                    z18 = z;
                    if (iArr3[0] == 3) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (iArr3[1] == 3) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    if (z19) {
                        z21 = false;
                    } else {
                        z21 = false;
                    }
                    if (chVar6.u()) {
                        i31++;
                        z = z18;
                    } else {
                        i31++;
                        z = z18;
                    }
                    z2 = false;
                } else {
                    z2 = z;
                }
            }
        } else {
            z2 = z;
        }
        z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
        if (z3) {
            iMin3 = Math.min(iArr[0], i4);
            iMin4 = Math.min(iArr[1], i5);
            if (mode == 1073741824) {
                dhVar.J(iMin3);
                cmVar.b = true;
            }
            if (mode2 == 1073741824) {
                dhVar.G(iMin4);
                cmVar.b = true;
            }
            if (mode == 1073741824) {
                z4 = z3;
                z13 = cmVar.b;
                dhVar2 = cmVar.a;
                if (z13) {
                    while (r0.hasNext()) {
                        chVar7.f();
                        chVar7.a = false;
                        g10 g10Var1111111111110 = chVar7.d;
                        g10Var1111111111110.e.j = false;
                        g10Var1111111111110.g = false;
                        g10Var1111111111110.n();
                        kd1 kd1Var1111111111110 = chVar7.e;
                        kd1Var1111111111110.e.j = false;
                        kd1Var1111111111110.g = false;
                        kd1Var1111111111110.m();
                    }
                    i28 = 0;
                    dhVar2.f();
                    dhVar2.a = false;
                    g10 g10Var1111111111111 = dhVar2.d;
                    g10Var1111111111111.e.j = false;
                    g10Var1111111111111.g = false;
                    g10Var1111111111111.n();
                    kd1 kd1Var1111111111111 = dhVar2.e;
                    kd1Var1111111111111.e.j = false;
                    kd1Var1111111111111.g = false;
                    kd1Var1111111111111.m();
                    cmVar.c();
                } else {
                    i28 = 0;
                }
                cmVar.b(cmVar.d);
                dhVar2.b0 = i28;
                dhVar2.c0 = i28;
                dhVar2.d.h.d(i28);
                dhVar2.e.h.d(i28);
                i29 = 1073741824;
                if (mode == 1073741824) {
                    zP = dhVar.P(i28, zX);
                    i14 = 1;
                } else {
                    i14 = 0;
                    zP = true;
                }
                if (mode2 == 1073741824) {
                    zP &= dhVar.P(1, zX);
                    i14++;
                }
            } else {
                z4 = z3;
                z13 = cmVar.b;
                dhVar2 = cmVar.a;
                if (z13) {
                    while (r0.hasNext()) {
                        chVar7.f();
                        chVar7.a = false;
                        g10 g10Var1111111111112 = chVar7.d;
                        g10Var1111111111112.e.j = false;
                        g10Var1111111111112.g = false;
                        g10Var1111111111112.n();
                        kd1 kd1Var1111111111112 = chVar7.e;
                        kd1Var1111111111112.e.j = false;
                        kd1Var1111111111112.g = false;
                        kd1Var1111111111112.m();
                    }
                    i28 = 0;
                    dhVar2.f();
                    dhVar2.a = false;
                    g10 g10Var1111111111113 = dhVar2.d;
                    g10Var1111111111113.e.j = false;
                    g10Var1111111111113.g = false;
                    g10Var1111111111113.n();
                    kd1 kd1Var1111111111113 = dhVar2.e;
                    kd1Var1111111111113.e.j = false;
                    kd1Var1111111111113.g = false;
                    kd1Var1111111111113.m();
                    cmVar.c();
                } else {
                    i28 = 0;
                }
                cmVar.b(cmVar.d);
                dhVar2.b0 = i28;
                dhVar2.c0 = i28;
                dhVar2.d.h.d(i28);
                dhVar2.e.h.d(i28);
                i29 = 1073741824;
                if (mode == 1073741824) {
                    zP = dhVar.P(i28, zX);
                    i14 = 1;
                } else {
                    i14 = 0;
                    zP = true;
                }
                if (mode2 == 1073741824) {
                    zP &= dhVar.P(1, zX);
                    i14++;
                }
            }
            if (zP) {
                if (mode == i29) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (mode2 == i29) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                dhVar.K(z14, z15);
            }
        } else {
            z4 = z3;
            i14 = 0;
            zP = false;
        }
        if (zP) {
        }
        int i31111111113 = dhVar.F0;
        if (size > 0) {
            size3 = dhVar.s0.size();
            zR = dhVar.R(64);
            bVar4 = dhVar.w0;
            i24 = 0;
            while (i24 < size3) {
                chVar5 = (ch) dhVar.s0.get(i24);
                if (chVar5 instanceof py) {
                    i27 = size3;
                } else {
                    chVar5.getClass();
                    if (zR) {
                    }
                    iH = chVar5.h(0);
                    int iH1114 = chVar5.h(1);
                    i27 = size3;
                    if (iH == 3) {
                        z12 = false;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                    }
                    if (z12) {
                        m6Var.a(0, chVar5, bVar4);
                    }
                }
                i24++;
                size3 = i27;
            }
            constraintLayout = bVar4.a;
            childCount2 = constraintLayout.getChildCount();
            arrayList3 = constraintLayout.mConstraintHelpers;
            i25 = 0;
            while (i25 < childCount2) {
                childAt = constraintLayout.getChildAt(i25);
                if (childAt instanceof d) {
                    dVar = (d) childAt;
                    if (dVar.c == null) {
                        a aVar1114 = (a) dVar.getLayoutParams();
                        aVar3 = (a) dVar.c.getLayoutParams();
                        chVar2 = aVar3.q0;
                        chVar2.j0 = 0;
                        chVar3 = aVar1114.q0;
                        if (chVar3.V[0] != 1) {
                            chVar3.J(chVar2.n());
                        }
                        chVar4 = aVar1114.q0;
                        if (chVar4.V[1] != 1) {
                            chVar4.G(aVar3.q0.i());
                        }
                        aVar3.q0.j0 = 8;
                    }
                }
                i25++;
                constraintLayout = constraintLayout;
            }
            size4 = arrayList3.size();
            if (size4 > 0) {
                while (i26 < size4) {
                    ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                }
            }
        }
        m6Var.c(dhVar);
        arrayList = (ArrayList) m6Var.a;
        size2 = arrayList.size();
        if (size > 0) {
            m6Var.b(dhVar, 0, iN2, i13);
        }
        if (size2 > 0) {
            iArr2 = dhVar.V;
            if (iArr2[0] == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (iArr2[1] == 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            int iN1116 = dhVar.n();
            dh dhVar1114 = (dh) m6Var.c;
            iMax3 = Math.max(iN1116, dhVar1114.e0);
            iMax4 = Math.max(dhVar.i(), dhVar1114.f0);
            i15 = 0;
            while (true) {
                aVar = vg.a.f;
                aVar2 = vg.a.d;
                if (i15 < size2) {
                    break;
                    break;
                } else {
                    i15++;
                }
            }
            i16 = 0;
            while (i16 < 2) {
                i17 = 0;
                z7 = false;
                while (i17 < size2) {
                    ArrayList arrayList1115 = arrayList;
                    chVar = (ch) arrayList.get(i17);
                    int i31111111114 = size2;
                    if (chVar instanceof h8) {
                        z10 = z6;
                        z11 = z5;
                        bVar3 = bVar;
                        i20 = i16;
                        i21 = i17;
                    } else {
                        z10 = z6;
                        if (chVar.j0 == 8) {
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            iN3 = chVar.n();
                            i22 = chVar.i();
                            z11 = z5;
                            int i31111111115 = chVar.d0;
                            i21 = i17;
                            zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                            bVar3 = bVar;
                            iN4 = chVar.n();
                            i20 = i16;
                            i23 = chVar.i();
                            if (iN4 != iN3) {
                                chVar.J(iN4);
                                if (z11) {
                                    iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                }
                                zA = true;
                            }
                            if (i23 != i22) {
                                chVar.G(i23);
                                if (z10) {
                                    iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                }
                                zA = true;
                            }
                            if (chVar.F) {
                                z7 = zA;
                            } else {
                                z7 = zA;
                            }
                        }
                    }
                    i17 = i21 + 1;
                    arrayList = arrayList1115;
                    size2 = i31111111114;
                    z6 = z10;
                    z5 = z11;
                    bVar = bVar3;
                    i16 = i20;
                }
                arrayList2 = arrayList;
                i18 = size2;
                z8 = z6;
                z9 = z5;
                bVar2 = bVar;
                i19 = i16;
                if (z7) {
                    break;
                    break;
                }
                i16 = i19 + 1;
                m6Var.b(dhVar, i16, iN2, i13);
                arrayList = arrayList2;
                size2 = i18;
                z6 = z8;
                z5 = z9;
                bVar = bVar2;
            }
        }
        dhVar.F0 = i31111111113;
        oe0.p = dhVar.R(512);
        iMax2 = Math.max(0, this.mMinHeight);
        iMin2 = iMax2;
        i9 = 2;
        iN = dhVar.n();
        iArr = dhVar.D;
        cmVar = dhVar.u0;
        i10 = iMin;
        if (i10 == iN) {
            cmVar.c = true;
            c = 1;
        } else {
            cmVar.c = true;
            c = 1;
        }
        dhVar.b0 = 0;
        dhVar.c0 = 0;
        iArr[0] = this.mMaxWidth - i7;
        iArr[c] = this.mMaxHeight - i6;
        dhVar.e0 = 0;
        dhVar.f0 = 0;
        dhVar.H(i8);
        dhVar.J(i10);
        dhVar.I(i9);
        dhVar.G(iMin2);
        i11 = this.mMinWidth - i7;
        if (i11 < 0) {
            i11 = 0;
        }
        dhVar.e0 = i11;
        i12 = this.mMinHeight - i6;
        if (i12 < 0) {
            i12 = 0;
        }
        dhVar.f0 = i12;
        dhVar.z0 = iMax10;
        dhVar.A0 = iMax5;
        m6Var = dhVar.t0;
        m6Var.getClass();
        bVar = dhVar.w0;
        size = dhVar.s0.size();
        iN2 = dhVar.n();
        i13 = dhVar.i();
        zX = e.x(i, 128);
        if (zX) {
            z = true;
        } else {
            z = true;
        }
        if (z) {
            i31 = 0;
            while (true) {
                if (i31 < size) {
                    chVar6 = (ch) dhVar.s0.get(i31);
                    iArr3 = chVar6.V;
                    z18 = z;
                    if (iArr3[0] == 3) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (iArr3[1] == 3) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    if (z19) {
                        z21 = false;
                    } else {
                        z21 = false;
                    }
                    if (chVar6.u()) {
                        i31++;
                        z = z18;
                    } else {
                        i31++;
                        z = z18;
                    }
                    z2 = false;
                } else {
                    z2 = z;
                }
            }
        } else {
            z2 = z;
        }
        z3 = z2 & ((mode != 1073741824 && mode2 == 1073741824) || zX);
        if (z3) {
            iMin3 = Math.min(iArr[0], i4);
            iMin4 = Math.min(iArr[1], i5);
            if (mode == 1073741824) {
                dhVar.J(iMin3);
                cmVar.b = true;
            }
            if (mode2 == 1073741824) {
                dhVar.G(iMin4);
                cmVar.b = true;
            }
            if (mode == 1073741824) {
                z4 = z3;
                z13 = cmVar.b;
                dhVar2 = cmVar.a;
                if (z13) {
                    while (r0.hasNext()) {
                        chVar7.f();
                        chVar7.a = false;
                        g10 g10Var1111111111114 = chVar7.d;
                        g10Var1111111111114.e.j = false;
                        g10Var1111111111114.g = false;
                        g10Var1111111111114.n();
                        kd1 kd1Var1111111111114 = chVar7.e;
                        kd1Var1111111111114.e.j = false;
                        kd1Var1111111111114.g = false;
                        kd1Var1111111111114.m();
                    }
                    i28 = 0;
                    dhVar2.f();
                    dhVar2.a = false;
                    g10 g10Var1111111111115 = dhVar2.d;
                    g10Var1111111111115.e.j = false;
                    g10Var1111111111115.g = false;
                    g10Var1111111111115.n();
                    kd1 kd1Var1111111111115 = dhVar2.e;
                    kd1Var1111111111115.e.j = false;
                    kd1Var1111111111115.g = false;
                    kd1Var1111111111115.m();
                    cmVar.c();
                } else {
                    i28 = 0;
                }
                cmVar.b(cmVar.d);
                dhVar2.b0 = i28;
                dhVar2.c0 = i28;
                dhVar2.d.h.d(i28);
                dhVar2.e.h.d(i28);
                i29 = 1073741824;
                if (mode == 1073741824) {
                    zP = dhVar.P(i28, zX);
                    i14 = 1;
                } else {
                    i14 = 0;
                    zP = true;
                }
                if (mode2 == 1073741824) {
                    zP &= dhVar.P(1, zX);
                    i14++;
                }
            } else {
                z4 = z3;
                z13 = cmVar.b;
                dhVar2 = cmVar.a;
                if (z13) {
                    while (r0.hasNext()) {
                        chVar7.f();
                        chVar7.a = false;
                        g10 g10Var1111111111116 = chVar7.d;
                        g10Var1111111111116.e.j = false;
                        g10Var1111111111116.g = false;
                        g10Var1111111111116.n();
                        kd1 kd1Var1111111111116 = chVar7.e;
                        kd1Var1111111111116.e.j = false;
                        kd1Var1111111111116.g = false;
                        kd1Var1111111111116.m();
                    }
                    i28 = 0;
                    dhVar2.f();
                    dhVar2.a = false;
                    g10 g10Var1111111111117 = dhVar2.d;
                    g10Var1111111111117.e.j = false;
                    g10Var1111111111117.g = false;
                    g10Var1111111111117.n();
                    kd1 kd1Var1111111111117 = dhVar2.e;
                    kd1Var1111111111117.e.j = false;
                    kd1Var1111111111117.g = false;
                    kd1Var1111111111117.m();
                    cmVar.c();
                } else {
                    i28 = 0;
                }
                cmVar.b(cmVar.d);
                dhVar2.b0 = i28;
                dhVar2.c0 = i28;
                dhVar2.d.h.d(i28);
                dhVar2.e.h.d(i28);
                i29 = 1073741824;
                if (mode == 1073741824) {
                    zP = dhVar.P(i28, zX);
                    i14 = 1;
                } else {
                    i14 = 0;
                    zP = true;
                }
                if (mode2 == 1073741824) {
                    zP &= dhVar.P(1, zX);
                    i14++;
                }
            }
            if (zP) {
                if (mode == i29) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (mode2 == i29) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                dhVar.K(z14, z15);
            }
        } else {
            z4 = z3;
            i14 = 0;
            zP = false;
        }
        if (zP) {
        }
        int i31111111116 = dhVar.F0;
        if (size > 0) {
            size3 = dhVar.s0.size();
            zR = dhVar.R(64);
            bVar4 = dhVar.w0;
            i24 = 0;
            while (i24 < size3) {
                chVar5 = (ch) dhVar.s0.get(i24);
                if (chVar5 instanceof py) {
                    i27 = size3;
                } else {
                    chVar5.getClass();
                    if (zR) {
                    }
                    iH = chVar5.h(0);
                    int iH1115 = chVar5.h(1);
                    i27 = size3;
                    if (iH == 3) {
                        z12 = false;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                    }
                    if (z12) {
                        m6Var.a(0, chVar5, bVar4);
                    }
                }
                i24++;
                size3 = i27;
            }
            constraintLayout = bVar4.a;
            childCount2 = constraintLayout.getChildCount();
            arrayList3 = constraintLayout.mConstraintHelpers;
            i25 = 0;
            while (i25 < childCount2) {
                childAt = constraintLayout.getChildAt(i25);
                if (childAt instanceof d) {
                    dVar = (d) childAt;
                    if (dVar.c == null) {
                        a aVar1115 = (a) dVar.getLayoutParams();
                        aVar3 = (a) dVar.c.getLayoutParams();
                        chVar2 = aVar3.q0;
                        chVar2.j0 = 0;
                        chVar3 = aVar1115.q0;
                        if (chVar3.V[0] != 1) {
                            chVar3.J(chVar2.n());
                        }
                        chVar4 = aVar1115.q0;
                        if (chVar4.V[1] != 1) {
                            chVar4.G(aVar3.q0.i());
                        }
                        aVar3.q0.j0 = 8;
                    }
                }
                i25++;
                constraintLayout = constraintLayout;
            }
            size4 = arrayList3.size();
            if (size4 > 0) {
                while (i26 < size4) {
                    ((androidx.constraintlayout.widget.a) arrayList3.get(i26)).getClass();
                }
            }
        }
        m6Var.c(dhVar);
        arrayList = (ArrayList) m6Var.a;
        size2 = arrayList.size();
        if (size > 0) {
            m6Var.b(dhVar, 0, iN2, i13);
        }
        if (size2 > 0) {
            iArr2 = dhVar.V;
            if (iArr2[0] == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (iArr2[1] == 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            int iN1117 = dhVar.n();
            dh dhVar1115 = (dh) m6Var.c;
            iMax3 = Math.max(iN1117, dhVar1115.e0);
            iMax4 = Math.max(dhVar.i(), dhVar1115.f0);
            i15 = 0;
            while (true) {
                aVar = vg.a.f;
                aVar2 = vg.a.d;
                if (i15 < size2) {
                    break;
                    break;
                } else {
                    i15++;
                }
            }
            i16 = 0;
            while (i16 < 2) {
                i17 = 0;
                z7 = false;
                while (i17 < size2) {
                    ArrayList arrayList1116 = arrayList;
                    chVar = (ch) arrayList.get(i17);
                    int i31111111117 = size2;
                    if (chVar instanceof h8) {
                        z10 = z6;
                        z11 = z5;
                        bVar3 = bVar;
                        i20 = i16;
                        i21 = i17;
                    } else {
                        z10 = z6;
                        if (chVar.j0 == 8) {
                            z11 = z5;
                            bVar3 = bVar;
                            i20 = i16;
                            i21 = i17;
                        } else {
                            iN3 = chVar.n();
                            i22 = chVar.i();
                            z11 = z5;
                            int i31111111118 = chVar.d0;
                            i21 = i17;
                            zA = m6Var.a(i16 == 1 ? 2 : 1, chVar, bVar) | z7;
                            bVar3 = bVar;
                            iN4 = chVar.n();
                            i20 = i16;
                            i23 = chVar.i();
                            if (iN4 != iN3) {
                                chVar.J(iN4);
                                if (z11) {
                                    iMax3 = Math.max(iMax3, chVar.g(aVar2).d() + chVar.o() + chVar.X);
                                }
                                zA = true;
                            }
                            if (i23 != i22) {
                                chVar.G(i23);
                                if (z10) {
                                    iMax4 = Math.max(iMax4, chVar.g(aVar).d() + chVar.p() + chVar.Y);
                                }
                                zA = true;
                            }
                            if (chVar.F) {
                                z7 = zA;
                            } else {
                                z7 = zA;
                            }
                        }
                    }
                    i17 = i21 + 1;
                    arrayList = arrayList1116;
                    size2 = i31111111117;
                    z6 = z10;
                    z5 = z11;
                    bVar = bVar3;
                    i16 = i20;
                }
                arrayList2 = arrayList;
                i18 = size2;
                z8 = z6;
                z9 = z5;
                bVar2 = bVar;
                i19 = i16;
                if (z7) {
                    break;
                    break;
                }
                i16 = i19 + 1;
                m6Var.b(dhVar, i16, iN2, i13);
                arrayList = arrayList2;
                size2 = i18;
                z6 = z8;
                z5 = z9;
                bVar = bVar2;
            }
        }
        dhVar.F0 = i31111111116;
        oe0.p = dhVar.R(512);
    }

    @Override // android.view.View
    public final void setId(int i) {
        int id = getId();
        SparseArray sparseArray = this.mChildrenByIds;
        sparseArray.remove(id);
        super.setId(i);
        sparseArray.put(getId(), this);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
