package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class t8 {
    public static final String d;
    public static final String e;
    public static final t8 f;
    public static final t8 g;
    public final boolean a;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public static final byte[] e = new byte[1792];
        public final String a;
        public final int b;
        public int c;
        public char d;

        static {
            for (int i = 0; i < 1792; i++) {
                e[i] = Character.getDirectionality(i);
            }
        }

        public a(String str) {
            this.a = str;
            this.b = str.length();
        }

        public final byte a() {
            int i = this.c - 1;
            String str = this.a;
            char cCharAt = str.charAt(i);
            this.d = cCharAt;
            boolean zIsLowSurrogate = Character.isLowSurrogate(cCharAt);
            int i2 = this.c;
            if (zIsLowSurrogate) {
                int iCodePointBefore = Character.codePointBefore(str, i2);
                this.c -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.c = i2 - 1;
            char c = this.d;
            return c < 1792 ? e[c] : Character.getDirectionality(c);
        }
    }

    static {
        c5 c5Var = d61.a;
        d = Character.toString((char) 8206);
        e = Character.toString((char) 8207);
        f = new t8(false);
        g = new t8(true);
    }

    public t8(boolean z) {
        c5 c5Var = d61.a;
        this.a = z;
    }

    public static int a(String str) {
        byte directionality;
        a aVar = new a(str);
        aVar.c = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = aVar.c;
            if (i4 < aVar.b && i == 0) {
                String str2 = aVar.a;
                char cCharAt = str2.charAt(i4);
                aVar.d = cCharAt;
                boolean zIsHighSurrogate = Character.isHighSurrogate(cCharAt);
                int i5 = aVar.c;
                if (zIsHighSurrogate) {
                    int iCodePointAt = Character.codePointAt(str2, i5);
                    aVar.c = Character.charCount(iCodePointAt) + aVar.c;
                    directionality = Character.getDirectionality(iCodePointAt);
                } else {
                    aVar.c = i5 + 1;
                    char c = aVar.d;
                    directionality = c < 1792 ? a.e[c] : Character.getDirectionality(c);
                }
                if (directionality != 0) {
                    if (directionality == 1 || directionality == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (directionality != 9) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
        }
        if (i != 0) {
            if (i2 == 0) {
                while (aVar.c > 0) {
                    switch (aVar.a()) {
                        case 14:
                        case 15:
                            if (i == i3) {
                                return -1;
                            }
                            i3--;
                            break;
                        case 16:
                        case 17:
                            if (i == i3) {
                                return 1;
                            }
                            i3--;
                            break;
                        case 18:
                            i3++;
                            break;
                        default:
                            break;
                    }
                }
            } else {
                return i2;
            }
        }
        return 0;
    }

    public static int b(String str) {
        a aVar = new a(str);
        aVar.c = aVar.b;
        int i = 0;
        while (true) {
            int i2 = i;
            while (aVar.c > 0) {
                byte bA = aVar.a();
                if (bA == 0) {
                    if (i2 == 0) {
                        return -1;
                    }
                    if (i == 0) {
                        i = i2;
                    }
                } else if (bA == 1 || bA == 2) {
                    if (i2 == 0) {
                        return 1;
                    }
                    if (i == 0) {
                        i = i2;
                    }
                } else if (bA != 9) {
                    switch (bA) {
                        case 14:
                        case 15:
                            if (i == i2) {
                                return -1;
                            }
                            i2--;
                            break;
                        case 16:
                        case 17:
                            if (i == i2) {
                                return 1;
                            }
                            i2--;
                            break;
                        case 18:
                            i2++;
                            break;
                        default:
                            if (i == 0) {
                                i = i2;
                            }
                            break;
                    }
                } else {
                    continue;
                }
            }
            return 0;
        }
    }
}
