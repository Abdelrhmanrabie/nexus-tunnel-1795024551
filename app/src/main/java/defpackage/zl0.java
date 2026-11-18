package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class zl0 implements yl0 {
    public final Object b;
    public Object c;

    public zl0(Map map) {
        this.b = map;
        this.c = new ff0("Java nullability annotation states").d(new i(21, this));
    }

    public zl0(yx.c cVar) {
        dt dtVar = cVar.b;
        dtVar.getClass();
        Iterator it = ((m11$d) dtVar.a.entrySet()).iterator();
        this.b = it;
        if (it.hasNext()) {
            this.c = (Map.Entry) it.next();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:65:0x01ab  */
    public void a(int i, yd ydVar) {
        long jDoubleToRawLongBits;
        int iFloatToRawIntBits;
        long jLongValue;
        int iIntValue;
        int iIntValue2;
        long jDoubleToRawLongBits2;
        int iFloatToRawIntBits2;
        long jLongValue2;
        int iIntValue3;
        while (true) {
            Map.Entry entry = (Map.Entry) this.c;
            if (entry == null || ((yx.d) entry.getKey()).b >= i) {
                return;
            }
            yx.d dVar = (yx.d) ((Map.Entry) this.c).getKey();
            Object value = ((Map.Entry) this.c).getValue();
            dt dtVar = dt.d;
            kg1 kg1Var = dVar.c;
            int i2 = dVar.b;
            if (dVar.d) {
                for (Object obj : (List) value) {
                    if (kg1Var != kg1.g) {
                        ydVar.x(i2, kg1Var.c);
                        switch (kg1Var.ordinal()) {
                            case 0:
                                jDoubleToRawLongBits2 = Double.doubleToRawLongBits(((Double) obj).doubleValue());
                                ydVar.u(jDoubleToRawLongBits2);
                                break;
                            case 1:
                                iFloatToRawIntBits2 = Float.floatToRawIntBits(((Float) obj).floatValue());
                                ydVar.t(iFloatToRawIntBits2);
                                break;
                            case 2:
                            case 3:
                                jLongValue2 = ((Long) obj).longValue();
                                ydVar.w(jLongValue2);
                                break;
                            case 4:
                                ydVar.n(number);
                                break;
                            case 5:
                            case 15:
                                jDoubleToRawLongBits2 = ((Long) obj).longValue();
                                ydVar.u(jDoubleToRawLongBits2);
                                break;
                            case 6:
                            case 14:
                                iFloatToRawIntBits2 = ((Integer) obj).intValue();
                                ydVar.t(iFloatToRawIntBits2);
                                break;
                            case 7:
                                ydVar.q(((Boolean) obj).booleanValue() ? 1 : 0);
                                break;
                            case 8:
                                byte[] bytes = ((String) obj).getBytes("UTF-8");
                                ydVar.v(bytes.length);
                                ydVar.s(bytes);
                                break;
                            case 9:
                                ((b0) obj).a(ydVar);
                                break;
                            case 10:
                                ydVar.p((b0) obj);
                                break;
                            case 11:
                                if (obj instanceof fa) {
                                    fa faVar = (fa) obj;
                                    ydVar.v(faVar.size());
                                    ydVar.r(faVar);
                                } else {
                                    byte[] bArr = (byte[]) obj;
                                    ydVar.v(bArr.length);
                                    ydVar.s(bArr);
                                }
                                break;
                            case 12:
                                iIntValue3 = ((Integer) obj).intValue();
                                ydVar.v(iIntValue3);
                                break;
                            case 13:
                                int number = obj instanceof h30.a ? ((h30.a) obj).getNumber() : ((Integer) obj).intValue();
                                ydVar.n(number);
                                break;
                            case 16:
                                int iIntValue4 = ((Integer) obj).intValue();
                                iIntValue3 = (iIntValue4 >> 31) ^ (iIntValue4 << 1);
                                ydVar.v(iIntValue3);
                                break;
                            case 17:
                                long jLongValue3 = ((Long) obj).longValue();
                                jLongValue2 = (jLongValue3 >> 63) ^ (jLongValue3 << 1);
                                ydVar.w(jLongValue2);
                                break;
                        }
                    } else {
                        ydVar.x(i2, 3);
                        ((b0) obj).a(ydVar);
                        ydVar.x(i2, 4);
                    }
                }
            } else if (kg1Var != kg1.g) {
                ydVar.x(i2, kg1Var.c);
                switch (kg1Var.ordinal()) {
                    case 0:
                        jDoubleToRawLongBits = Double.doubleToRawLongBits(((Double) value).doubleValue());
                        ydVar.u(jDoubleToRawLongBits);
                        break;
                    case 1:
                        iFloatToRawIntBits = Float.floatToRawIntBits(((Float) value).floatValue());
                        ydVar.t(iFloatToRawIntBits);
                        break;
                    case 2:
                    case 3:
                        jLongValue = ((Long) value).longValue();
                        ydVar.w(jLongValue);
                        break;
                    case 4:
                        iIntValue = ((Integer) value).intValue();
                        ydVar.n(iIntValue);
                        break;
                    case 5:
                    case 15:
                        jDoubleToRawLongBits = ((Long) value).longValue();
                        ydVar.u(jDoubleToRawLongBits);
                        break;
                    case 6:
                    case 14:
                        iFloatToRawIntBits = ((Integer) value).intValue();
                        ydVar.t(iFloatToRawIntBits);
                        break;
                    case 7:
                        ydVar.q(((Boolean) value).booleanValue() ? 1 : 0);
                        break;
                    case 8:
                        byte[] bytes2 = ((String) value).getBytes("UTF-8");
                        ydVar.v(bytes2.length);
                        ydVar.s(bytes2);
                        break;
                    case 9:
                        ((b0) value).a(ydVar);
                        break;
                    case 10:
                        ydVar.p((b0) value);
                        break;
                    case 11:
                        if (value instanceof fa) {
                            fa faVar2 = (fa) value;
                            ydVar.v(faVar2.size());
                            ydVar.r(faVar2);
                        } else {
                            byte[] bArr2 = (byte[]) value;
                            ydVar.v(bArr2.length);
                            ydVar.s(bArr2);
                        }
                        break;
                    case 12:
                        iIntValue2 = ((Integer) value).intValue();
                        ydVar.v(iIntValue2);
                        break;
                    case 13:
                        if (value instanceof h30.a) {
                            iIntValue = ((h30.a) value).getNumber();
                        } else {
                            iIntValue = ((Integer) value).intValue();
                        }
                        ydVar.n(iIntValue);
                        break;
                    case 16:
                        int iIntValue5 = ((Integer) value).intValue();
                        iIntValue2 = (iIntValue5 >> 31) ^ (iIntValue5 << 1);
                        ydVar.v(iIntValue2);
                        break;
                    case 17:
                        long jLongValue4 = ((Long) value).longValue();
                        jLongValue = (jLongValue4 >> 63) ^ (jLongValue4 << 1);
                        ydVar.w(jLongValue);
                        break;
                }
            } else {
                ydVar.x(i2, 3);
                ((b0) value).a(ydVar);
                ydVar.x(i2, 4);
            }
            Iterator it = (Iterator) this.b;
            this.c = it.hasNext() ? (Map.Entry) it.next() : null;
        }
    }
}
