package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class fi0 implements bx {
    public final List a;

    public /* synthetic */ fi0(List list) {
        this.a = list;
    }

    public fi0(qr0 qr0Var) {
        List list = qr0Var.d;
        if ((qr0Var.c & 1) == 1) {
            int i = qr0Var.f;
            ArrayList arrayList = new ArrayList(ae.y0(list));
            int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    e.q0();
                    throw null;
                }
                nr0 nr0VarG = (nr0) obj;
                if (i2 >= i) {
                    nr0VarG.getClass();
                    nr0.c cVarO = nr0.o(nr0VarG);
                    cVarO.f |= 2;
                    cVarO.i = true;
                    nr0VarG = cVarO.g();
                    if (!nr0VarG.isInitialized()) {
                        throw new we();
                    }
                }
                arrayList.add(nr0VarG);
                i2 = i3;
            }
            list = arrayList;
        }
        this.a = list;
    }

    public nr0 a(int i) {
        return (nr0) this.a.get(i);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00b2  */
    @Override // defpackage.bx
    public Object invoke(Object obj, Object obj2) {
        Object next;
        jo0 jo0Var;
        String str;
        Object next2;
        String str2;
        CharSequence charSequence = (CharSequence) obj;
        int iIntValue = ((Integer) obj2).intValue();
        List list = this.a;
        if (list.size() != 1) {
            if (iIntValue < 0) {
                iIntValue = 0;
            }
            y20 y20Var = new y20(iIntValue, charSequence.length(), 1);
            boolean z = charSequence instanceof String;
            int i = y20Var.d;
            int i2 = y20Var.c;
            if (!z) {
                if ((i > 0 && iIntValue <= i2) || (i < 0 && i2 <= iIntValue)) {
                    while (true) {
                        Iterator it = list.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            str = (String) next;
                        } while (!q31.o0(str, false, charSequence, iIntValue, str.length()));
                        String str3 = (String) next;
                        if (str3 == null) {
                            if (iIntValue == i2) {
                                jo0Var = null;
                                break;
                            }
                            iIntValue += i;
                        } else {
                            jo0Var = new jo0(Integer.valueOf(iIntValue), str3);
                            break;
                        }
                    }
                } else {
                    jo0Var = null;
                    break;
                }
            } else if ((i > 0 && iIntValue <= i2) || (i < 0 && i2 <= iIntValue)) {
                while (true) {
                    Iterator it2 = list.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                        str2 = (String) next2;
                    } while (!str2.regionMatches(0, (String) charSequence, iIntValue, str2.length()));
                    String str4 = (String) next2;
                    if (str4 == null) {
                        if (iIntValue == i2) {
                            jo0Var = null;
                            break;
                        }
                        iIntValue += i;
                    } else {
                        jo0Var = new jo0(Integer.valueOf(iIntValue), str4);
                        break;
                    }
                }
            } else {
                jo0Var = null;
                break;
            }
        } else {
            String str5 = (String) he.Z0(list);
            int iK0 = q31.k0(charSequence, str5, iIntValue, 4);
            if (iK0 < 0) {
                jo0Var = null;
                break;
            }
            jo0Var = new jo0(Integer.valueOf(iK0), str5);
        }
        if (jo0Var == null) {
            return null;
        }
        return new jo0(jo0Var.b, Integer.valueOf(((String) jo0Var.c).length()));
    }
}
