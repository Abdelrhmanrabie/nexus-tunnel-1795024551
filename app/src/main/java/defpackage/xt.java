package defpackage;

import com.jcraft.jzlib.GZIPHeader;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class xt {
    public static final a A;
    public static final a B;
    public static final a C;
    public static final a D;
    public static final a E;
    public static final a F;
    public static final a G;
    public static final a H;
    public static final a I;
    public static final a J;
    public static final a K;
    public static final a L;
    public static final a M;
    public static final a a;
    public static final a b;
    public static final a c;
    public static final b d;
    public static final b e;
    public static final b f;
    public static final a g;
    public static final a h;
    public static final a i;
    public static final a j;
    public static final a k;
    public static final a l;
    public static final a m;
    public static final a n;
    public static final b o;
    public static final a p;
    public static final a q;
    public static final a r;
    public static final a s;
    public static final a t;
    public static final a u;
    public static final a v;
    public static final a w;
    public static final a x;
    public static final a y;
    public static final a z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends c {
        public final Boolean c(int i) {
            return Boolean.valueOf((i & (1 << this.a)) != 0);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends c {
        public final h30.a[] c;

        /* JADX WARN: Illegal instructions before constructor call */
        public b(int i, h30.a[] aVarArr) {
            if (aVarArr == null) {
                d.AnonymousClass0.m$4("Argument for @NotNull parameter 'enumEntries' of kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField.bitWidth must not be null");
                throw null;
            }
            int i2 = 1;
            int length = aVarArr.length - 1;
            if (length != 0) {
                for (int i3 = 31; i3 >= 0; i3--) {
                    if (((1 << i3) & length) != 0) {
                        i2 = 1 + i3;
                    }
                }
                throw new IllegalStateException("Empty enum: " + aVarArr.getClass());
            }
            super(i, i2, 0);
            this.c = aVarArr;
        }

        public final h30.a c(int i) {
            int i2 = (1 << this.b) - 1;
            int i3 = this.a;
            int i4 = (i & (i2 << i3)) >> i3;
            for (h30.a aVar : this.c) {
                if (aVar.getNumber() == i4) {
                    return aVar;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class c {
        public final /* synthetic */ int G0;
        public final int a;
        public final int b;

        public c(int i, int i2, int i3) {
            this.G0 = i3;
            if (i3 != 1) {
                this.a = i;
                this.b = i2;
            } else {
                this.b = i;
                this.a = i2;
            }
        }

        public static a a(c cVar) {
            return new a(cVar.a + cVar.b, 1, 0);
        }

        public abstract byte[] getMatrix();

        public abstract byte[] getRow(byte[] bArr, int i);

        public String toString() {
            char c;
            if (this.G0 != 1) {
                return super.toString();
            }
            int i = this.b;
            byte[] row = new byte[i];
            int i2 = this.a;
            StringBuilder sb = new StringBuilder((i + 1) * i2);
            for (int i3 = 0; i3 < i2; i3++) {
                row = getRow(row, i3);
                for (int i4 = 0; i4 < i; i4++) {
                    int i5 = row[i4] & GZIPHeader.OS_UNKNOWN;
                    if (i5 < 64) {
                        c = '#';
                    } else if (i5 < 128) {
                        c = '+';
                    } else {
                        c = i5 < 192 ? '.' : ' ';
                    }
                    sb.append(c);
                }
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    static {
        a aVar = new a(0, 1, 0);
        a = aVar;
        b = c.a(aVar);
        a aVar2 = new a(0, 1, 0);
        c = aVar2;
        b bVar = new b(1, ur0.values());
        d = bVar;
        hr0[] hr0VarArrValues = hr0.values();
        int i2 = bVar.b + 1;
        b bVar2 = new b(i2, hr0VarArrValues);
        e = bVar2;
        zq0.c[] cVarArrValues = zq0.c.values();
        int i3 = i2 + bVar2.b;
        b bVar3 = new b(i3, cVarArrValues);
        f = bVar3;
        a aVarA = c.a(bVar3);
        g = aVarA;
        a aVarA2 = c.a(aVarA);
        h = aVarA2;
        a aVarA3 = c.a(aVarA2);
        i = aVarA3;
        a aVarA4 = c.a(aVarA3);
        j = aVarA4;
        a aVarA5 = c.a(aVarA4);
        k = aVarA5;
        l = c.a(aVarA5);
        a aVarA6 = c.a(bVar);
        m = aVarA6;
        n = c.a(aVarA6);
        b bVar4 = new b(i3, gr0.values());
        o = bVar4;
        a aVarA7 = c.a(bVar4);
        p = aVarA7;
        a aVarA8 = c.a(aVarA7);
        q = aVarA8;
        a aVarA9 = c.a(aVarA8);
        r = aVarA9;
        a aVarA10 = c.a(aVarA9);
        s = aVarA10;
        a aVarA11 = c.a(aVarA10);
        t = aVarA11;
        a aVarA12 = c.a(aVarA11);
        u = aVarA12;
        a aVarA13 = c.a(aVarA12);
        v = aVarA13;
        w = c.a(aVarA13);
        a aVarA14 = c.a(bVar4);
        x = aVarA14;
        a aVarA15 = c.a(aVarA14);
        y = aVarA15;
        a aVarA16 = c.a(aVarA15);
        z = aVarA16;
        a aVarA17 = c.a(aVarA16);
        A = aVarA17;
        a aVarA18 = c.a(aVarA17);
        B = aVarA18;
        a aVarA19 = c.a(aVarA18);
        C = aVarA19;
        a aVarA20 = c.a(aVarA19);
        D = aVarA20;
        a aVarA21 = c.a(aVarA20);
        E = aVarA21;
        F = c.a(aVarA21);
        a aVarA22 = c.a(aVar2);
        G = aVarA22;
        a aVarA23 = c.a(aVarA22);
        H = aVarA23;
        I = c.a(aVarA23);
        a aVarA24 = c.a(bVar2);
        J = aVarA24;
        a aVarA25 = c.a(aVarA24);
        K = aVarA25;
        L = c.a(aVarA25);
        M = new a(0, 1, 0);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0021  */
    /* JADX WARN: Code duplicated, block: B:18:0x002b  */
    public static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 == 1) {
            objArr[0] = "modality";
        } else if (i2 == 2) {
            objArr[0] = "kind";
        } else if (i2 == 5) {
            objArr[0] = "modality";
        } else if (i2 == 6) {
            objArr[0] = "memberKind";
        } else if (i2 == 8) {
            objArr[0] = "modality";
        } else if (i2 == 9) {
            objArr[0] = "memberKind";
        } else if (i2 != 11) {
            objArr[0] = "visibility";
        } else {
            objArr[0] = "modality";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i2) {
            case 3:
                objArr[2] = "getConstructorFlags";
                break;
            case 4:
            case 5:
            case 6:
                objArr[2] = "getFunctionFlags";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "getPropertyFlags";
                break;
            case 10:
            case 11:
                objArr[2] = "getAccessorFlags";
                break;
            default:
                objArr[2] = "getClassFlags";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }
}
