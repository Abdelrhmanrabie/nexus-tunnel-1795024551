package defpackage;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class wb0 {
    public final a a;
    public final q80 b;
    public final String[] c;
    public final String[] d;
    public final String[] e;
    public final String f;
    public final int g;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public enum a {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);

        public static final LinkedHashMap c;
        public final int b;

        static {
            int i = 0;
            a[] aVarArrValues = values();
            int iE = ye1.e(aVarArrValues.length);
            LinkedHashMap linkedHashMap = new LinkedHashMap(iE < 16 ? 16 : iE);
            int length = aVarArrValues.length;
            while (i < length) {
                a aVar = aVarArrValues[i];
                i++;
                linkedHashMap.put(Integer.valueOf(aVar.b), aVar);
            }
            c = linkedHashMap;
        }

        a(int i) {
            this.b = i;
        }
    }

    public wb0(a aVar, q80 q80Var, String[] strArr, String[] strArr2, String[] strArr3, String str, int i) {
        this.a = aVar;
        this.b = q80Var;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str;
        this.g = i;
    }

    public final String toString() {
        return this.a + " version=" + this.b;
    }
}
