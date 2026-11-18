package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class bt0 {
    public static final List a;
    public static final Map b;
    public static final Map c;

    static {
        Class cls = Boolean.TYPE;
        pu0 pu0Var = ou0.a;
        int i = 0;
        List<h90> listAsList = Arrays.asList(pu0Var.b(cls), pu0Var.b(Byte.TYPE), pu0Var.b(Character.TYPE), pu0Var.b(Double.TYPE), pu0Var.b(Float.TYPE), pu0Var.b(Integer.TYPE), pu0Var.b(Long.TYPE), pu0Var.b(Short.TYPE));
        a = listAsList;
        ArrayList arrayList = new ArrayList(ae.y0(listAsList));
        for (h90 h90Var : listAsList) {
            arrayList.add(new jo0(e.C(h90Var), e.D(h90Var)));
        }
        b = ye1.j(arrayList);
        List<h90> list = a;
        ArrayList arrayList2 = new ArrayList(ae.y0(list));
        for (h90 h90Var2 : list) {
            arrayList2.add(new jo0(e.D(h90Var2), e.C(h90Var2)));
        }
        c = ye1.j(arrayList2);
        List listAsList2 = Arrays.asList(lw.class, nw.class, bx.class, cx.class, dx.class, ex.class, fx.class, gx.class, hx.class, ix.class, mw.class, ow.class, pw.class, qw.class, rw.class, sw.class, tw.class, uw.class, vw.class, ww.class, yw.class, zw.class, ax.class);
        ArrayList arrayList3 = new ArrayList(ae.y0(listAsList2));
        for (Object obj : listAsList2) {
            int i2 = i + 1;
            if (i < 0) {
                e.q0();
                throw null;
            }
            arrayList3.add(new jo0((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        ye1.j(arrayList3);
    }

    public static final dd a(Class cls) {
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(e4.j("Can't compute ClassId for primitive type: ", cls));
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException(e4.j("Can't compute ClassId for array type: ", cls));
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null && cls.getSimpleName().length() != 0) {
            Class<?> declaringClass = cls.getDeclaringClass();
            return declaringClass == null ? dd.l(new cv(cls.getName())) : a(declaringClass).d(ij0.f(cls.getSimpleName()));
        }
        cv cvVar = new cv(cls.getName());
        return new dd(cvVar.e(), cv.j(cvVar.a.g()), true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final String b(Class cls) {
        if (!cls.isPrimitive()) {
            if (cls.isArray()) {
                String name = cls.getName();
                int i = q31.$r8$clinit;
                return name.replace('.', '/');
            }
            StringBuilder sb = new StringBuilder("L");
            String name2 = cls.getName();
            int i2 = q31.$r8$clinit;
            sb.append(name2.replace('.', '/'));
            sb.append(';');
            return sb.toString();
        }
        String name3 = cls.getName();
        switch (name3.hashCode()) {
            case -1325958191:
                if (name3.equals(XMLRPC.TYPE_DOUBLE)) {
                    return "D";
                }
                break;
            case 104431:
                if (name3.equals(XMLRPC.TYPE_INT)) {
                    return "I";
                }
                break;
            case 3039496:
                if (name3.equals("byte")) {
                    return "B";
                }
                break;
            case 3052374:
                if (name3.equals("char")) {
                    return "C";
                }
                break;
            case 3327612:
                if (name3.equals("long")) {
                    return "J";
                }
                break;
            case 3625364:
                if (name3.equals("void")) {
                    return "V";
                }
                break;
            case 64711720:
                if (name3.equals(XMLRPC.TYPE_BOOLEAN)) {
                    return "Z";
                }
                break;
            case 97526364:
                if (name3.equals("float")) {
                    return "F";
                }
                break;
            case 109413500:
                if (name3.equals("short")) {
                    return "S";
                }
                break;
        }
        throw new IllegalArgumentException(e4.j("Unsupported primitive type: ", cls));
    }

    public static final List c(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return uq.b;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getOwnerType() == null ? ae.M0(parameterizedType.getActualTypeArguments()) : fz0.E(new yt(fz0.w(type, ba.b$9), ba.b$10, ez0.d));
    }
}
