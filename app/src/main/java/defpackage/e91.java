package defpackage;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.openvpn.ovpn3.XMLRPC;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class e91 implements xb0$b {
    public final /* synthetic */ int G0;
    public final Object a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public Object g;

    public e91(Context context) {
        this.G0 = 2;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.d = layoutParams;
        this.e = new Rect();
        this.f = new int[2];
        this.g = new int[2];
        this.a = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.a1, (ViewGroup) null);
        this.b = viewInflate;
        this.c = (TextView) viewInflate.findViewById(R.attr.r2);
        layoutParams.setTitle("j71");
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.plurals.f;
        layoutParams.flags = 24;
    }

    public e91(ViewPortHandler viewPortHandler) {
        this.G0 = 1;
        this.c = new Matrix();
        this.b = new Matrix();
        this.g = new float[1];
        this.d = new Matrix();
        this.f = new float[2];
        this.a = new Matrix();
        new Matrix();
        this.e = viewPortHandler;
    }

    public e91(hg hgVar, ij0 ij0Var, v8 v8Var, ai0 ai0Var, dd ddVar, List list) {
        this.G0 = 3;
        this.b = hgVar;
        this.c = ij0Var;
        this.d = v8Var;
        this.e = ai0Var;
        this.f = ddVar;
        this.g = list;
        this.a = new ArrayList();
    }

    public e91(hn hnVar, e91 e91Var, List list, String str, String str2) {
        Map linkedHashMap;
        int i = 0;
        this.G0 = 0;
        this.a = hnVar;
        this.b = e91Var;
        this.c = str;
        this.d = str2;
        ff0 ff0Var = hnVar.a.a;
        this.e = ff0Var.d(new g91(this, 1));
        this.f = ff0Var.d(new g91(this, 2));
        if (list.isEmpty()) {
            linkedHashMap = vq.b;
        } else {
            linkedHashMap = new LinkedHashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                pr0 pr0Var = (pr0) it.next();
                linkedHashMap.put(Integer.valueOf(pr0Var.f), new Cdo((hn) this.a, pr0Var, i));
                i++;
            }
        }
        this.g = linkedHashMap;
    }

    public static final ArrayList e(nr0 nr0Var, e91 e91Var) {
        nr0 nr0VarA;
        List list = nr0Var.f;
        fi0 fi0Var = ((hn) e91Var.a).d;
        int i = nr0Var.d;
        if ((i & 256) == 256) {
            nr0VarA = nr0Var.s;
        } else {
            nr0VarA = (i & 512) == 512 ? fi0Var.a(nr0Var.t) : null;
        }
        Iterable iterableE = nr0VarA != null ? e(nr0VarA, e91Var) : null;
        if (iterableE == null) {
            iterableE = uq.b;
        }
        return he.X0(iterableE, list);
    }

    @Override // defpackage.xb0$b
    public void a() {
        ai0 ai0Var = (ai0) this.e;
        ij0 ij0Var = (ij0) this.c;
        wc1 wc1VarO0 = e.O0(ij0Var, ai0Var);
        ArrayList arrayList = (ArrayList) this.a;
        if (wc1VarO0 != null) {
            ((HashMap) ((hg) this.b).e).put(ij0Var, new h7(e.G0(arrayList), new jn(wc1VarO0.getType(), 1)));
            return;
        }
        if (((v8) this.d).r((dd) this.f) && ij0Var.b().equals(XMLRPC.TAG_VALUE)) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (obj instanceof r4) {
                    arrayList2.add(obj);
                }
            }
            List list = (List) this.g;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                list.add((g4) ((r4) it.next()).a);
            }
        }
    }

    @Override // defpackage.xb0$b
    public xb0$a b(dd ddVar) {
        ArrayList arrayList = new ArrayList();
        v8 v8Var = (v8) this.d;
        return new oo(new hg(v8Var, e4.c((ji0) v8Var.c, ddVar, (oo) v8Var.d), ddVar, arrayList, t11.a), this, arrayList);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    public v91 c(int i) {
        v91 v91Var = (v91) this.g.get(Integer.valueOf(i));
        if (v91Var != null) {
            return v91Var;
        }
        e91 e91Var = (e91) this.b;
        if (e91Var == null) {
            return null;
        }
        return e91Var.c(i);
    }

    @Override // defpackage.xb0$b
    public void c(Object obj) {
        ArrayList arrayList = (ArrayList) this.a;
        qg qgVarB = b2.b(obj);
        if (qgVarB == null) {
            qgVarB = new rr$a(e4.j("Unsupported annotation argument: ", (ij0) this.c));
        }
        arrayList.add(qgVarB);
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0293  */
    /* JADX WARN: Code duplicated, block: B:119:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:121:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:123:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:126:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:128:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:129:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:132:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:13:0x0035  */
    /* JADX WARN: Code duplicated, block: B:15:0x0047  */
    /* JADX WARN: Code duplicated, block: B:162:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:164:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:165:0x03c1 A[PHI: r3
      0x03c1: PHI (r3v5 u01) = (r3v3 u01), (r3v20 u01) binds: [B:169:0x03d5, B:163:0x03b4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:166:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:168:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:16:0x004b  */
    /* JADX WARN: Code duplicated, block: B:171:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:175:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:176:0x0400  */
    /* JADX WARN: Code duplicated, block: B:178:0x0405  */
    /* JADX WARN: Code duplicated, block: B:181:0x040e  */
    /* JADX WARN: Code duplicated, block: B:184:0x041d  */
    /* JADX WARN: Code duplicated, block: B:188:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:? A[LOOP:1: B:44:0x011b->B:189:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0053  */
    /* JADX WARN: Code duplicated, block: B:191:0x0239 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x0233 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x01df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0078  */
    /* JADX WARN: Code duplicated, block: B:23:0x007e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0098  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:38:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:42:0x0102 A[LOOP:0: B:40:0x00fc->B:42:0x0102, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x0121  */
    /* JADX WARN: Code duplicated, block: B:53:0x0137 A[LOOP:2: B:51:0x0131->B:53:0x0137, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x0145 A[PHI: r6
      0x0145: PHI (r6v34 od) = (r6v11 od), (r6v15 od), (r6v22 od), (r6v38 od), (r6v42 od) binds: [B:37:0x00db, B:33:0x00c5, B:19:0x0059, B:54:0x013f, B:14:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:56:0x014a  */
    /* JADX WARN: Code duplicated, block: B:60:0x0166  */
    /* JADX WARN: Code duplicated, block: B:62:0x016c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0176  */
    /* JADX WARN: Code duplicated, block: B:66:0x017c  */
    /* JADX WARN: Code duplicated, block: B:69:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:73:0x01bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:75:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:78:0x01db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:84:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:91:0x0200  */
    /* JADX WARN: Code duplicated, block: B:92:0x0203  */
    /* JADX WARN: Code duplicated, block: B:94:0x0208  */
    /* JADX WARN: Code duplicated, block: B:95:0x020f  */
    /* JADX WARN: Code duplicated, block: B:97:0x0213  */
    /* JADX WARN: Code duplicated, block: B:98:0x021f  */
    /* JADX WARN: Instruction removed from duplicated block: B:171:0x03d8, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r24v0, types: [e91] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v15, types: [nr0] */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v5, types: [nr0] */
    /* JADX WARN: Type inference failed for: r9v8, types: [oo] */
    public u01 d(nr0 nr0Var, boolean z) {
        int i;
        int i2;
        u01 u01Var;
        int i3;
        String string;
        od odVarC;
        int i4;
        String string2;
        Iterator it;
        Object next;
        v91 v91Var;
        a91 a91VarF;
        in inVar;
        ArrayList arrayList;
        Iterator it2;
        int i5;
        boolean zHasNext;
        fi0 fi0Var;
        u01 u01Var2;
        List listG1;
        u01 u01Var3;
        boolean zI;
        boolean z2;
        u01 u01VarF;
        u01 u01VarA;
        u01 u01VarT1;
        int size;
        od odVarB;
        Object objC;
        ca1 ca1Var;
        int size2;
        u01 u01VarF2;
        ?? r9;
        int i6;
        ?? A;
        nr0 nr0Var2;
        Object next2;
        int i7;
        nr0.b bVar;
        v91 v91Var2;
        nr0.b.c cVar;
        u01 u01Var4;
        int iOrdinal;
        ad1 ad1Var;
        int i8;
        ?? r10;
        nr0 nr0VarA;
        ca1 da1Var;
        nr0 nr0Var3;
        String string3;
        c81 c81Var;
        ArrayList arrayList2;
        Iterator it3;
        Iterator it4;
        int i9;
        hn hnVar = (hn) this.a;
        ok okVar = hnVar.c;
        fn fnVar = hnVar.a;
        jj0 jj0Var = hnVar.b;
        if (nr0Var.m()) {
            i = nr0Var.o;
        } else {
            if ((nr0Var.d & 128) == 128) {
                i = nr0Var.r;
            }
            i2 = 0;
            u01Var = null;
            if (nr0Var.m()) {
                odVarC = (od) ((ff0.j) this.e).invoke(Integer.valueOf(nr0Var.o));
                if (odVarC == null) {
                    i4 = nr0Var.o;
                    dd ddVarX = e.x(jj0Var, i4);
                    sy0 sy0VarW = fz0.w(nr0Var, new g91(this, i2));
                    c81Var = new c81(sy0VarW, ba.b$20);
                    arrayList2 = new ArrayList();
                    it3 = sy0VarW.iterator();
                    while (it3.hasNext()) {
                        arrayList2.add(c81Var.b.invoke(it3.next()));
                    }
                    it4 = fz0.w(ddVarX, f91.d).iterator();
                    i9 = 0;
                    while (it4.hasNext()) {
                        it4.next();
                        i9++;
                        if (i9 >= 0) {
                            throw new ArithmeticException("Count overflow has happened.");
                        }
                    }
                    while (arrayList2.size() < i9) {
                        arrayList2.add(0);
                    }
                    odVarC = fnVar.l.a(ddVarX, arrayList2);
                }
                a91VarF = odVarC.h();
            } else {
                i3 = nr0Var.d;
                if ((i3 & 32) == 32) {
                    odVarC = c(nr0Var.p);
                    if (odVarC == null) {
                        StringBuilder sb = new StringBuilder("Unknown type parameter ");
                        sb.append(nr0Var.p);
                        sb.append(". Please try recompiling module containing \"");
                        string = fb$1.m(sb, (String) this.d, '\"');
                        pr.a aVar = pr.a;
                        a91VarF = pr.f(e.n("[ERROR : ", string, "]"), pr.b);
                    } else {
                        a91VarF = odVarC.h();
                    }
                } else if ((i3 & 64) == 64) {
                    string2 = jj0Var.getString(nr0Var.q);
                    it = he.g1(this.g.values()).iterator();
                    do {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!((v91) next).getName().b().equals(string2));
                    v91Var = (v91) next;
                    if (v91Var == null) {
                        StringBuilder sbQ = ak.q("Deserialized type parameter ", string2, " in ");
                        sbQ.append(okVar);
                        string = sbQ.toString();
                        pr.a aVar2 = pr.a;
                        a91VarF = pr.f(e.n("[ERROR : ", string, "]"), pr.b);
                    } else {
                        odVarC = v91Var;
                        a91VarF = odVarC.h();
                    }
                } else if ((i3 & 128) == 128) {
                    odVarC = (od) ((ff0.j) this.f).invoke(Integer.valueOf(nr0Var.r));
                    if (odVarC == null) {
                        i4 = nr0Var.r;
                        dd ddVarX2 = e.x(jj0Var, i4);
                        sy0 sy0VarW2 = fz0.w(nr0Var, new g91(this, i2));
                        c81Var = new c81(sy0VarW2, ba.b$20);
                        arrayList2 = new ArrayList();
                        it3 = sy0VarW2.iterator();
                        while (it3.hasNext()) {
                            arrayList2.add(c81Var.b.invoke(it3.next()));
                        }
                        it4 = fz0.w(ddVarX2, f91.d).iterator();
                        i9 = 0;
                        while (it4.hasNext()) {
                            it4.next();
                            i9++;
                            if (i9 >= 0) {
                                throw new ArithmeticException("Count overflow has happened.");
                            }
                        }
                        while (arrayList2.size() < i9) {
                            arrayList2.add(0);
                        }
                        odVarC = fnVar.l.a(ddVarX2, arrayList2);
                    }
                    a91VarF = odVarC.h();
                } else {
                    string = "Unknown type";
                    pr.a aVar3 = pr.a;
                    a91VarF = pr.f(e.n("[ERROR : ", string, "]"), pr.b);
                }
            }
            if (pr.h(a91VarF.b())) {
                string3 = a91VarF.toString();
                if (string3 != null) {
                    return new or(a91VarF, pr.c(string3, false));
                }
                pr.a(9);
                throw null;
            }
            inVar = new in(fnVar.a, new qn(nr0Var, this));
            ArrayList arrayListE = e(nr0Var, this);
            arrayList = new ArrayList(ae.y0(arrayListE));
            it2 = arrayListE.iterator();
            i5 = 0;
            while (true) {
                zHasNext = it2.hasNext();
                fi0Var = hnVar.d;
                boolean z3 = true;
                if (zHasNext) {
                    u01Var2 = u01Var;
                    listG1 = he.g1(arrayList);
                    od odVarB2 = a91VarF.b();
                    if (z || !(odVarB2 instanceof co)) {
                        u01Var3 = u01Var2;
                        zI = e.i(xt.a, nr0Var.w);
                        z2 = nr0Var.g;
                        if (zI) {
                            size = a91VarF.getParameters().size() - listG1.size();
                            if (size == 0) {
                                u01 u01VarF3 = e4.f(inVar, a91VarF, listG1, z2);
                                odVarB = u01VarF3.L0().b();
                                if (odVarB == null) {
                                    objC = u01Var3;
                                } else {
                                    objC = e.C(odVarB);
                                }
                                if (objC == mx.f || (ca1Var = (ca1) he.U0(e.J(u01VarF3))) == null) {
                                    u01VarA = u01Var3;
                                } else {
                                    fc0 type = ca1Var.getType();
                                    od odVarB3 = type.L0().b();
                                    Object objG = odVarB3 == null ? u01Var3 : ym.g(odVarB3);
                                    if (type.K0().size() == 1 && (e4.a(objG, m21.d) || e4.a(objG, i91.a))) {
                                        fc0 type2 = ((ca1) he.a1(type.K0())).getType();
                                        boolean z4 = okVar instanceof ja;
                                        Object obj = okVar;
                                        if (!z4) {
                                            obj = u01Var3;
                                        }
                                        ja jaVar = (ja) obj;
                                        e4.a(jaVar == null ? u01Var3 : ym.c(jaVar), r41.a);
                                        ub0 ub0VarK = u01VarF3.L0().k();
                                        s4 annotations = u01VarF3.getAnnotations();
                                        fc0 fc0VarG = e.G(u01VarF3);
                                        List listJ = e.J(u01VarF3);
                                        int size3 = listJ.size() - 1;
                                        if (size3 < 0) {
                                            size3 = 0;
                                        }
                                        List listE1 = he.e1(listJ, size3);
                                        ArrayList arrayList3 = new ArrayList(ae.y0(listE1));
                                        Iterator it5 = listE1.iterator();
                                        while (it5.hasNext()) {
                                            arrayList3.add(((ca1) it5.next()).getType());
                                        }
                                        u01VarA = e.u(ub0VarK, annotations, fc0VarG, arrayList3, type2, true).P0(u01VarF3.M0());
                                    } else {
                                        u01VarA = u01VarF3;
                                    }
                                }
                            } else if (size != 1 && (size2 = listG1.size() - 1) >= 0) {
                                ub0 ub0VarK2 = a91VarF.k();
                                ub0VarK2.getClass();
                                u01VarF2 = e4.f(inVar, ub0VarK2.j(m21.c.c(ij0.f(e4.j(mx.g.c, Integer.valueOf(size2))))).h(), listG1, z2);
                            } else {
                                u01VarA = u01Var3;
                            }
                            if (u01VarA == null) {
                                u01VarA = u01VarF2;
                                u01VarT1 = pr.g(listG1, e4.j("Bad suspend function in metadata with constructor: ", a91VarF));
                                r9 = u01Var3;
                            } else {
                                u01VarT1 = u01VarF;
                                r9 = u01Var3;
                                u01VarA = u01VarF2;
                                u01VarT1 = u01VarA;
                                r9 = u01Var3;
                            }
                        } else {
                            u01VarF = e4.f(inVar, a91VarF, listG1, z2);
                            if (e.i(xt.b, nr0Var.w)) {
                                u01VarA = b2.a((cc1) u01VarF);
                                if (u01VarA == null) {
                                    u01VarT1 = u01VarF;
                                    r9 = u01Var3;
                                    throw new IllegalStateException(("null DefinitelyNotNullType for '" + u01VarF + '\'').toString());
                                }
                                u01VarT1 = u01VarF;
                                r9 = u01Var3;
                                u01VarA = u01VarF2;
                                u01VarT1 = u01VarA;
                                r9 = u01Var3;
                            }
                        }
                    } else {
                        ke keVar = new ke(15);
                        ?? r11 = u01Var2;
                        oo ooVarA = b2.a((oo) r11, (co) odVarB2, listG1);
                        s4$a$a s4_a_a = e4.f47a;
                        u01 u01VarB = keVar.b(ooVarA, s4_a_a, false, 0, true);
                        if (!ma1.g(u01VarB) && !nr0Var.g) {
                            z3 = false;
                        }
                        u01 u01VarP0 = u01VarB.P0(z3);
                        ArrayList arrayListV0 = he.V0(inVar, u01VarB.getAnnotations());
                        u01VarT1 = u01VarP0.R0(arrayListV0.isEmpty() ? s4_a_a : new t4(0, arrayListV0));
                        r9 = r11;
                    }
                    u01VarT1 = u01VarF;
                    r9 = u01Var3;
                    i6 = nr0Var.d;
                    if ((i6 & 1024) == 1024) {
                        nr0Var2 = nr0Var.u;
                    } else if ((i6 & 2048) == 2048) {
                        A = r9;
                        A = fi0Var.a(nr0Var.v);
                    }
                    if (A != 0) {
                        A = nr0Var2;
                        u01VarT1 = e.t1(u01VarT1, d(A, false));
                    }
                    A = nr0Var2;
                    if (nr0Var.m()) {
                        e.x(jj0Var, nr0Var.o);
                        fnVar.r.getClass();
                    }
                    return u01VarT1;
                }
                next2 = it2.next();
                i7 = i5 + 1;
                if (i5 >= 0) {
                    ?? r17 = u01Var;
                    e.q0();
                    throw r17;
                }
                bVar = (nr0.b) next2;
                v91Var2 = (v91) he.N0(a91VarF.getParameters(), i5);
                cVar = bVar.d;
                u01Var4 = u01Var;
                if (cVar == nr0.b.c.g) {
                    iOrdinal = cVar.ordinal();
                    if (iOrdinal != 0) {
                        ad1Var = ad1.IN_VARIANCE;
                    } else if (iOrdinal != 1) {
                        ad1Var = ad1.OUT_VARIANCE;
                    } else {
                        if (iOrdinal != 2) {
                            if (iOrdinal != 3) {
                                throw new IllegalArgumentException(e4.j("Only IN, OUT and INV are supported. Actual argument: ", cVar));
                            }
                            d.AnonymousClass0.m();
                            return u01Var4;
                        }
                        ad1Var = ad1.INVARIANT;
                    }
                    i8 = bVar.c;
                    if ((i8 & 2) == 2) {
                        nr0Var3 = bVar.f;
                    } else if ((i8 & 4) == 4) {
                        nr0VarA = fi0Var.a(bVar.g);
                    } else {
                        r10 = u01Var4;
                    }
                    if (r10 == 0) {
                        r10 = nr0VarA;
                        r10 = nr0Var3;
                        da1Var = new da1(pr.d("No type recorded"));
                    } else {
                        r10 = nr0VarA;
                        r10 = nr0Var3;
                        da1Var = new da1(f(r10), ad1Var);
                    }
                } else if (v91Var2 == null) {
                    da1Var = new n21(fnVar.b.k());
                } else {
                    da1Var = new da1(v91Var2);
                }
                arrayList.add(da1Var);
                i5 = i7;
                u01Var = u01Var4;
            }
        }
        if (e.x(jj0Var, i).c) {
            fnVar.g.getClass();
        }
        i2 = 0;
        u01Var = null;
        if (nr0Var.m()) {
            odVarC = (od) ((ff0.j) this.e).invoke(Integer.valueOf(nr0Var.o));
            if (odVarC == null) {
                i4 = nr0Var.o;
                dd ddVarX3 = e.x(jj0Var, i4);
                sy0 sy0VarW3 = fz0.w(nr0Var, new g91(this, i2));
                c81Var = new c81(sy0VarW3, ba.b$20);
                arrayList2 = new ArrayList();
                it3 = sy0VarW3.iterator();
                while (it3.hasNext()) {
                    arrayList2.add(c81Var.b.invoke(it3.next()));
                }
                it4 = fz0.w(ddVarX3, f91.d).iterator();
                i9 = 0;
                while (it4.hasNext()) {
                    it4.next();
                    i9++;
                    if (i9 >= 0) {
                        throw new ArithmeticException("Count overflow has happened.");
                    }
                }
                while (arrayList2.size() < i9) {
                    arrayList2.add(0);
                }
                odVarC = fnVar.l.a(ddVarX3, arrayList2);
            }
            a91VarF = odVarC.h();
        } else {
            i3 = nr0Var.d;
            if ((i3 & 32) == 32) {
                odVarC = c(nr0Var.p);
                if (odVarC == null) {
                    StringBuilder sb2 = new StringBuilder("Unknown type parameter ");
                    sb2.append(nr0Var.p);
                    sb2.append(". Please try recompiling module containing \"");
                    string = fb$1.m(sb2, (String) this.d, '\"');
                    pr.a aVar4 = pr.a;
                    a91VarF = pr.f(e.n("[ERROR : ", string, "]"), pr.b);
                } else {
                    a91VarF = odVarC.h();
                }
            } else if ((i3 & 64) == 64) {
                string2 = jj0Var.getString(nr0Var.q);
                it = he.g1(this.g.values()).iterator();
                do {
                    if (it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!((v91) next).getName().b().equals(string2));
                v91Var = (v91) next;
                if (v91Var == null) {
                    StringBuilder sbQ2 = ak.q("Deserialized type parameter ", string2, " in ");
                    sbQ2.append(okVar);
                    string = sbQ2.toString();
                    pr.a aVar5 = pr.a;
                    a91VarF = pr.f(e.n("[ERROR : ", string, "]"), pr.b);
                } else {
                    odVarC = v91Var;
                    a91VarF = odVarC.h();
                }
            } else if ((i3 & 128) == 128) {
                odVarC = (od) ((ff0.j) this.f).invoke(Integer.valueOf(nr0Var.r));
                if (odVarC == null) {
                    i4 = nr0Var.r;
                    dd ddVarX4 = e.x(jj0Var, i4);
                    sy0 sy0VarW4 = fz0.w(nr0Var, new g91(this, i2));
                    c81Var = new c81(sy0VarW4, ba.b$20);
                    arrayList2 = new ArrayList();
                    it3 = sy0VarW4.iterator();
                    while (it3.hasNext()) {
                        arrayList2.add(c81Var.b.invoke(it3.next()));
                    }
                    it4 = fz0.w(ddVarX4, f91.d).iterator();
                    i9 = 0;
                    while (it4.hasNext()) {
                        it4.next();
                        i9++;
                        if (i9 >= 0) {
                            throw new ArithmeticException("Count overflow has happened.");
                        }
                    }
                    while (arrayList2.size() < i9) {
                        arrayList2.add(0);
                    }
                    odVarC = fnVar.l.a(ddVarX4, arrayList2);
                }
                a91VarF = odVarC.h();
            } else {
                string = "Unknown type";
                pr.a aVar6 = pr.a;
                a91VarF = pr.f(e.n("[ERROR : ", string, "]"), pr.b);
            }
        }
        if (pr.h(a91VarF.b())) {
            string3 = a91VarF.toString();
            if (string3 != null) {
                return new or(a91VarF, pr.c(string3, false));
            }
            pr.a(9);
            throw null;
        }
        inVar = new in(fnVar.a, new qn(nr0Var, this));
        ArrayList arrayListE2 = e(nr0Var, this);
        arrayList = new ArrayList(ae.y0(arrayListE2));
        it2 = arrayListE2.iterator();
        i5 = 0;
        while (true) {
            zHasNext = it2.hasNext();
            fi0Var = hnVar.d;
            boolean z5 = true;
            if (zHasNext) {
                u01Var2 = u01Var;
                listG1 = he.g1(arrayList);
                od odVarB4 = a91VarF.b();
                if (z) {
                    u01Var3 = u01Var2;
                    zI = e.i(xt.a, nr0Var.w);
                    z2 = nr0Var.g;
                    if (zI) {
                        size = a91VarF.getParameters().size() - listG1.size();
                        if (size == 0) {
                            u01 u01VarF4 = e4.f(inVar, a91VarF, listG1, z2);
                            odVarB = u01VarF4.L0().b();
                            if (odVarB == null) {
                                objC = u01Var3;
                            } else {
                                objC = e.C(odVarB);
                            }
                            if (objC == mx.f) {
                                u01VarA = u01Var3;
                            } else {
                                u01VarA = u01Var3;
                            }
                        } else if (size != 1) {
                            u01VarA = u01Var3;
                        } else {
                            ub0 ub0VarK3 = a91VarF.k();
                            ub0VarK3.getClass();
                            u01VarF2 = e4.f(inVar, ub0VarK3.j(m21.c.c(ij0.f(e4.j(mx.g.c, Integer.valueOf(size2))))).h(), listG1, z2);
                        }
                        if (u01VarA == null) {
                            u01VarA = u01VarF2;
                            u01VarT1 = pr.g(listG1, e4.j("Bad suspend function in metadata with constructor: ", a91VarF));
                            r9 = u01Var3;
                        } else {
                            u01VarT1 = u01VarF;
                            r9 = u01Var3;
                            u01VarA = u01VarF2;
                            u01VarT1 = u01VarA;
                            r9 = u01Var3;
                        }
                    } else {
                        u01VarF = e4.f(inVar, a91VarF, listG1, z2);
                        if (e.i(xt.b, nr0Var.w)) {
                            u01VarA = b2.a((cc1) u01VarF);
                            if (u01VarA == null) {
                                u01VarT1 = u01VarF;
                                r9 = u01Var3;
                                throw new IllegalStateException(("null DefinitelyNotNullType for '" + u01VarF + '\'').toString());
                            }
                            u01VarT1 = u01VarF;
                            r9 = u01Var3;
                            u01VarA = u01VarF2;
                            u01VarT1 = u01VarA;
                            r9 = u01Var3;
                        }
                    }
                } else {
                    u01Var3 = u01Var2;
                    zI = e.i(xt.a, nr0Var.w);
                    z2 = nr0Var.g;
                    if (zI) {
                        size = a91VarF.getParameters().size() - listG1.size();
                        if (size == 0) {
                            u01 u01VarF5 = e4.f(inVar, a91VarF, listG1, z2);
                            odVarB = u01VarF5.L0().b();
                            if (odVarB == null) {
                                objC = u01Var3;
                            } else {
                                objC = e.C(odVarB);
                            }
                            if (objC == mx.f) {
                                u01VarA = u01Var3;
                            } else {
                                u01VarA = u01Var3;
                            }
                        } else if (size != 1) {
                            u01VarA = u01Var3;
                        } else {
                            ub0 ub0VarK4 = a91VarF.k();
                            ub0VarK4.getClass();
                            u01VarF2 = e4.f(inVar, ub0VarK4.j(m21.c.c(ij0.f(e4.j(mx.g.c, Integer.valueOf(size2))))).h(), listG1, z2);
                        }
                        if (u01VarA == null) {
                            u01VarA = u01VarF2;
                            u01VarT1 = pr.g(listG1, e4.j("Bad suspend function in metadata with constructor: ", a91VarF));
                            r9 = u01Var3;
                        } else {
                            u01VarT1 = u01VarF;
                            r9 = u01Var3;
                            u01VarA = u01VarF2;
                            u01VarT1 = u01VarA;
                            r9 = u01Var3;
                        }
                    } else {
                        u01VarF = e4.f(inVar, a91VarF, listG1, z2);
                        if (e.i(xt.b, nr0Var.w)) {
                            u01VarA = b2.a((cc1) u01VarF);
                            if (u01VarA == null) {
                                u01VarT1 = u01VarF;
                                r9 = u01Var3;
                                throw new IllegalStateException(("null DefinitelyNotNullType for '" + u01VarF + '\'').toString());
                            }
                            u01VarT1 = u01VarF;
                            r9 = u01Var3;
                            u01VarA = u01VarF2;
                            u01VarT1 = u01VarA;
                            r9 = u01Var3;
                        }
                    }
                }
                u01VarT1 = u01VarF;
                r9 = u01Var3;
                i6 = nr0Var.d;
                if ((i6 & 1024) == 1024) {
                    nr0Var2 = nr0Var.u;
                } else if ((i6 & 2048) == 2048) {
                    A = r9;
                    A = fi0Var.a(nr0Var.v);
                }
                if (A != 0) {
                    A = nr0Var2;
                    u01VarT1 = e.t1(u01VarT1, d(A, false));
                }
                A = nr0Var2;
                if (nr0Var.m()) {
                    e.x(jj0Var, nr0Var.o);
                    fnVar.r.getClass();
                }
                return u01VarT1;
            }
            next2 = it2.next();
            i7 = i5 + 1;
            if (i5 >= 0) {
                ?? r18 = u01Var;
                e.q0();
                throw r18;
            }
            bVar = (nr0.b) next2;
            v91Var2 = (v91) he.N0(a91VarF.getParameters(), i5);
            cVar = bVar.d;
            u01Var4 = u01Var;
            if (cVar == nr0.b.c.g) {
                iOrdinal = cVar.ordinal();
                if (iOrdinal != 0) {
                    ad1Var = ad1.IN_VARIANCE;
                } else if (iOrdinal != 1) {
                    ad1Var = ad1.OUT_VARIANCE;
                } else {
                    if (iOrdinal != 2) {
                        if (iOrdinal != 3) {
                            throw new IllegalArgumentException(e4.j("Only IN, OUT and INV are supported. Actual argument: ", cVar));
                        }
                        d.AnonymousClass0.m();
                        return u01Var4;
                    }
                    ad1Var = ad1.INVARIANT;
                }
                i8 = bVar.c;
                if ((i8 & 2) == 2) {
                    nr0Var3 = bVar.f;
                } else if ((i8 & 4) == 4) {
                    nr0VarA = fi0Var.a(bVar.g);
                } else {
                    r10 = u01Var4;
                }
                if (r10 == 0) {
                    r10 = nr0VarA;
                    r10 = nr0Var3;
                    da1Var = new da1(pr.d("No type recorded"));
                } else {
                    r10 = nr0VarA;
                    r10 = nr0Var3;
                    da1Var = new da1(f(r10), ad1Var);
                }
            } else if (v91Var2 == null) {
                da1Var = new n21(fnVar.b.k());
            } else {
                da1Var = new da1(v91Var2);
            }
            arrayList.add(da1Var);
            i5 = i7;
            u01Var = u01Var4;
        }
    }

    @Override // defpackage.xb0$b
    public void d(dd ddVar, ij0 ij0Var) {
        ((ArrayList) this.a).add(new kr(ddVar, ij0Var));
    }

    @Override // defpackage.xb0$b
    public void e(ed edVar) {
        ((ArrayList) this.a).add(new m90(edVar));
    }

    public fc0 f(nr0 nr0Var) {
        nr0 nr0VarA;
        if ((nr0Var.d & 2) != 2) {
            return d(nr0Var, true);
        }
        hn hnVar = (hn) this.a;
        String string = hnVar.b.getString(nr0Var.i);
        u01 u01VarD = d(nr0Var, true);
        fi0 fi0Var = hnVar.d;
        int i = nr0Var.d;
        if ((i & 4) == 4) {
            nr0VarA = nr0Var.j;
        } else {
            nr0VarA = (i & 8) == 8 ? fi0Var.a(nr0Var.n) : null;
        }
        u01 u01VarD2 = d(nr0VarA, true);
        if (hnVar.a.j.G0 != 1) {
            throw new IllegalArgumentException("This method should not be used.");
        }
        if (e4.a(string, "kotlin.jvm.PlatformType")) {
            return nr0Var.h(w80.g) ? new ls0(u01VarD, u01VarD2, 0) : e4.c(u01VarD, u01VarD2);
        }
        return pr.d("Error java flexible type with id: " + string + ". (" + u01VarD + ".." + u01VarD2 + ')');
    }

    public MPPointD getPixelForValues(float f, float f2) {
        float[] fArr = (float[]) this.f;
        fArr[0] = f;
        fArr[1] = f2;
        pointValuesToPixel(fArr);
        return MPPointD.getInstance(fArr[0], fArr[1]);
    }

    public MPPointD getValuesByTouchPoint(float f, float f2) {
        MPPointD mPPointD = MPPointD.getInstance(0.0d, 0.0d);
        getValuesByTouchPoint(f, f2, mPPointD);
        return mPPointD;
    }

    public void getValuesByTouchPoint(float f, float f2, MPPointD mPPointD) {
        float[] fArr = (float[]) this.f;
        fArr[0] = f;
        fArr[1] = f2;
        Matrix matrix = (Matrix) this.d;
        matrix.reset();
        ((Matrix) this.b).invert(matrix);
        matrix.mapPoints(fArr);
        ((ViewPortHandler) this.e).mMatrixTouch.invert(matrix);
        matrix.mapPoints(fArr);
        ((Matrix) this.c).invert(matrix);
        matrix.mapPoints(fArr);
        mPPointD.x = fArr[0];
        mPPointD.y = fArr[1];
    }

    public void pathValueToPixel(Path path) {
        path.transform((Matrix) this.c);
        path.transform(((ViewPortHandler) this.e).mMatrixTouch);
        path.transform((Matrix) this.b);
    }

    public void pointValuesToPixel(float[] fArr) {
        ((Matrix) this.c).mapPoints(fArr);
        ((ViewPortHandler) this.e).mMatrixTouch.mapPoints(fArr);
        ((Matrix) this.b).mapPoints(fArr);
    }

    public void prepareMatrixOffset() {
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.e;
        Matrix matrix = (Matrix) this.b;
        matrix.reset();
        matrix.postTranslate(viewPortHandler.mContentRect.left, viewPortHandler.mChartHeight - viewPortHandler.offsetBottom());
    }

    public void prepareMatrixValuePx(float f, float f2, float f3, float f4) {
        Matrix matrix = (Matrix) this.c;
        ViewPortHandler viewPortHandler = (ViewPortHandler) this.e;
        float fWidth = viewPortHandler.mContentRect.width() / f2;
        float fHeight = viewPortHandler.mContentRect.height() / f3;
        if (Float.isInfinite(fWidth)) {
            fWidth = 0.0f;
        }
        if (Float.isInfinite(fHeight)) {
            fHeight = 0.0f;
        }
        matrix.reset();
        matrix.postTranslate(-f, -f4);
        matrix.postScale(fWidth, -fHeight);
    }

    public String toString() {
        if (this.G0 != 0) {
            return super.toString();
        }
        e91 e91Var = (e91) this.b;
        return e4.j((String) this.c, e91Var == null ? AppConfig.CUSTOM : e4.j(". Child of ", (String) e91Var.c));
    }
}
