package defpackage;

import android.graphics.Color;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class fb$1 {
    public static ClassCastException m(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static String m(StringBuilder sb, String str, char c) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    public static String m(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String m(pu0 pu0Var, Class cls, StringBuilder sb) {
        sb.append(pu0Var.b(cls));
        return sb.toString();
    }

    public static void m(String str, String str2, String str3, String str4, String str5) {
        Color.parseColor(str);
        Color.parseColor(str2);
        Color.parseColor(str3);
        Color.parseColor(str4);
        Color.parseColor(str5);
    }

    public static /* synthetic */ boolean m(Object obj) {
        return obj != null;
    }
}
