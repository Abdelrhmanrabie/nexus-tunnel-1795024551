package defpackage;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class kg1 {
    public static final kg1 d;
    public static final kg1 f;
    public static final b g;
    public static final c i;
    public static final kg1 j;
    public static final /* synthetic */ kg1[] n;
    public final lg1 b;
    public final int c;

    /* JADX INFO: Fake field, exist only in values array */
    kg1 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    kg1 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    kg1 EF2;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final enum a extends kg1 {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final enum b extends kg1 {
        @Override // defpackage.kg1
        public final boolean a() {
            return false;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final enum c extends kg1 {
        @Override // defpackage.kg1
        public final boolean a() {
            return false;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final enum d extends kg1 {
        @Override // defpackage.kg1
        public final boolean a() {
            return false;
        }
    }

    static {
        kg1 kg1Var = new kg1("DOUBLE", 0, lg1.DOUBLE, 1);
        kg1 kg1Var2 = new kg1("FLOAT", 1, lg1.FLOAT, 5);
        lg1 lg1Var = lg1.LONG;
        kg1 kg1Var3 = new kg1("INT64", 2, lg1Var, 0);
        kg1 kg1Var4 = new kg1("UINT64", 3, lg1Var, 0);
        lg1 lg1Var2 = lg1.INT;
        kg1 kg1Var5 = new kg1("INT32", 4, lg1Var2, 0);
        d = kg1Var5;
        kg1 kg1Var6 = new kg1("FIXED64", 5, lg1Var, 1);
        kg1 kg1Var7 = new kg1("FIXED32", 6, lg1Var2, 5);
        kg1 kg1Var8 = new kg1("BOOL", 7, lg1.BOOLEAN, 0);
        f = kg1Var8;
        a aVar = new a("STRING", 8, lg1.STRING, 2);
        lg1 lg1Var3 = lg1.MESSAGE;
        b bVar = new b("GROUP", 9, lg1Var3, 3);
        g = bVar;
        c cVar = new c("MESSAGE", 10, lg1Var3, 2);
        i = cVar;
        d dVar = new d("BYTES", 11, lg1.BYTE_STRING, 2);
        kg1 kg1Var9 = new kg1("UINT32", 12, lg1Var2, 0);
        kg1 kg1Var10 = new kg1("ENUM", 13, lg1.ENUM, 0);
        j = kg1Var10;
        n = new kg1[]{kg1Var, kg1Var2, kg1Var3, kg1Var4, kg1Var5, kg1Var6, kg1Var7, kg1Var8, aVar, bVar, cVar, dVar, kg1Var9, kg1Var10, new kg1("SFIXED32", 14, lg1Var2, 5), new kg1("SFIXED64", 15, lg1Var, 1), new kg1("SINT32", 16, lg1Var2, 0), new kg1("SINT64", 17, lg1Var, 0)};
    }

    public kg1(String str, int i2, lg1 lg1Var, int i3) {
        super(str, i2);
        this.b = lg1Var;
        this.c = i3;
    }

    public static kg1 valueOf(String str) {
        return (kg1) Enum.valueOf(kg1.class, str);
    }

    public static kg1[] values() {
        return (kg1[]) n.clone();
    }

    public boolean a() {
        return !(this instanceof a);
    }
}
