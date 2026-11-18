package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.view.menu.f;
import com.android.volley.Cache$Entry;
import com.android.volley.CacheDispatcher;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import net.lingala.zip4j.ZipFile;
import org.hamotunnelplus.xyz.R;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class oo implements y1.a, xb0$a {
    public static oo e;
    public final Object a;
    public Object b;
    public final Object c;
    public final Object d;

    public oo(int i) {
        Object d7Var;
        if (i != 4) {
            this.a = new gp0(10);
            this.b = new o01();
            this.c = new ArrayList();
            d7Var = new HashSet();
        } else {
            this.a = new d7();
            this.b = new SparseArray();
            this.c = new qf0();
            d7Var = new d7();
        }
        this.d = d7Var;
    }

    public oo(Context context, ActionMode.Callback callback) {
        this.d = context;
        this.a = callback;
        this.c = new ArrayList();
        this.b = new o01();
    }

    public oo(ContextWrapper contextWrapper) {
        this.d = new HashSet();
        this.c = new Random();
        this.a = contextWrapper;
    }

    public oo(CacheDispatcher cacheDispatcher, BlockingQueue blockingQueue, bj bjVar) {
        this.d = new HashMap();
        this.c = bjVar;
        this.a = cacheDispatcher;
        this.b = blockingQueue;
    }

    public oo(ff0 ff0Var, gi0 gi0Var) {
        this.a = ff0Var;
        this.b = gi0Var;
        this.c = ff0Var.g(new kl0$c(this, 1));
        this.d = ff0Var.g(new kl0$c(this, 0));
    }

    public oo(hg hgVar, e91 e91Var, ArrayList arrayList) {
        this.b = hgVar;
        this.d = e91Var;
        this.c = arrayList;
        this.a = hgVar;
    }

    public /* synthetic */ oo(Object obj, Object obj2, Object obj3, Object obj4) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
    }

    public oo(on onVar) {
        this.d = onVar;
        List list = onVar.g.w;
        int iE = ye1.e(ae.y0(list));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iE < 16 ? 16 : iE);
        for (Object obj : list) {
            linkedHashMap.put(e.E(onVar.r.b, ((dr0) obj).f), obj);
        }
        this.a = linkedHashMap;
        on onVar2 = (on) this.d;
        this.b = onVar2.r.a.a.d(new dd0.c(4, this, onVar2));
        ff0 ff0Var = ((on) this.d).r.a.a;
        ca0 ca0Var = new ca0(14, this);
        ff0Var.getClass();
        this.c = new ff0.h(ff0Var, ca0Var);
    }

    public oo(v8 v8Var, y91 y91Var) {
        this.a = v8Var;
        this.b = y91Var;
        m6 m6Var = new m6((js0) null);
        this.c = m6Var;
        this.d = new js0(m6Var);
    }

    public static JSONArray a(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put((JSONObject) it.next());
        }
        return jSONArray;
    }

    public ai0 a(dd ddVar, List list) {
        return (ai0) ((ff0.c) this.d).invoke(new kl0$a(ddVar, list));
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0120  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4, types: [a91] */
    /* JADX WARN: Type inference failed for: r11v3, types: [da1] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v6, types: [ca1] */
    /* JADX WARN: Type inference failed for: r11v7, types: [da1] */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r15v9, types: [java.lang.Object, rc0] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.util.ArrayList] */
    public u01 a(tt0 tt0Var, n60 n60Var, u01 u01Var) {
        u01 u01Var2;
        a91 a91VarH;
        List listG1;
        boolean z;
        ?? da1Var;
        ?? arrayList;
        ca1 ca1VarG;
        ai0 ai0VarA0;
        v8 v8Var = (v8) this.a;
        c60 c60Var = (c60) v8Var.a;
        s4 wc0Var = u01Var == null ? new wc0(v8Var, tt0Var, false) : u01Var.getAnnotations();
        b50 b50VarB = tt0Var.b();
        ad1 ad1Var = ad1.OUT_VARIANCE;
        int i = n60Var.a;
        int i2 = n60Var.b;
        boolean z2 = n60Var.c;
        if (b50VarB != null) {
            boolean z3 = false;
            if (b50VarB instanceof qt0) {
                qt0 qt0Var = (qt0) b50VarB;
                cv cvVarE = qt0Var.e();
                u01Var2 = null;
                if (z2 && cvVarE.equals(w60.a)) {
                    tu0 tu0Var = c60Var.p;
                    tu0Var.getClass();
                    ja0 ja0Var = tu0.e[0];
                    tu0Var.c.getClass();
                    ij0 ij0VarF = ij0.f(e.f(ja0Var.getName()));
                    od odVarE = ((vg0) tu0Var.b.getValue()).e(ij0VarF, dl0.c);
                    ai0 ai0Var = odVarE instanceof ai0 ? (ai0) odVarE : null;
                    ai0VarA0 = ai0Var == null ? tu0Var.a.a(new dd(m21.f, ij0VarF), Collections.singletonList(1)) : ai0Var;
                } else {
                    ai0VarA0 = e.a0(cvVarE, c60Var.o.k());
                    if (ai0VarA0 == null) {
                        ai0VarA0 = null;
                    } else {
                        String str = l60.a;
                        dv dvVarG = xm.g(ai0VarA0);
                        HashMap map = l60.k;
                        if (map.containsKey(dvVarG)) {
                            if (i2 == 3 || i == 1) {
                                ai0VarA0 = e.q(ai0VarA0);
                            } else {
                                fu0 fu0Var = (fu0) he.U0(tt0Var.x());
                                iu0 iu0Var = fu0Var instanceof iu0 ? (iu0) fu0Var : null;
                                if (iu0Var != null && iu0Var.p() != null) {
                                    Type[] upperBounds = iu0Var.a.getUpperBounds();
                                    if (e4.a(upperBounds.length == 0 ? null : upperBounds[0], Object.class)) {
                                        cv cvVar = (cv) map.get(xm.g(ai0VarA0));
                                        if (cvVar == null) {
                                            d.AnonymousClass0.m$1("Given class ", ai0VarA0, " is not a read-only collection");
                                            return null;
                                        }
                                        v91 v91Var = (v91) he.U0(ym.e(ai0VarA0).j(cvVar).h().getParameters());
                                        if (v91Var != null && v91Var.j() != ad1Var) {
                                            ai0VarA0 = e.q(ai0VarA0);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (ai0VarA0 == null) {
                    bj bjVar = (bj) c60Var.k.a;
                    bjVar.getClass();
                    ai0VarA0 = bjVar.a(qt0Var);
                }
                if (ai0VarA0 != null) {
                    a91VarH = ai0VarA0.h();
                }
            } else {
                u01Var2 = null;
                if (!(b50VarB instanceof gu0)) {
                    throw new IllegalStateException(e4.j("Unknown classifier kind: ", b50VarB));
                }
                v91 v91VarA = ((y91) this.b).a((gu0) b50VarB);
                a91VarH = v91VarA == null ? null : v91VarA.h();
            }
            if (a91VarH == null) {
                return u01Var2;
            }
            boolean z4 = (i2 == 3 || z2 || i == 1) ? false : true;
            if (e4.a(u01Var == null ? u01Var2 : u01Var.L0(), a91VarH) && !tt0Var.s() && z4) {
                return u01Var.P0(true);
            }
            boolean z5 = tt0Var.s() || (tt0Var.x().isEmpty() && !a91VarH.getParameters().isEmpty());
            List<v91> parameters = a91VarH.getParameters();
            if (z5) {
                arrayList = new ArrayList(ae.y0(parameters));
                for (v91 v91Var2 : parameters) {
                    if (e.J(v91Var2, u01Var2, n60Var.d)) {
                        ca1VarG = w60.a(v91Var2, n60Var);
                    } else {
                        a91 a91Var = a91VarH;
                        a91VarH = a91Var;
                        de0 de0Var = new de0(c60Var.a, new u60(this, v91Var2, tt0Var, n60Var, a91Var));
                        n60 n60VarB = tt0Var.s() ? n60Var : n60Var.b(1);
                        ((js0) this.d).getClass();
                        ca1VarG = js0.g(v91Var2, n60VarB, de0Var);
                    }
                    arrayList.add(ca1VarG);
                    u01Var2 = null;
                }
            } else {
                if (parameters.size() != tt0Var.x().size()) {
                    ArrayList arrayList2 = new ArrayList(ae.y0(parameters));
                    Iterator it = parameters.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new da1(pr.d(((v91) it.next()).getName().b())));
                    }
                    listG1 = he.g1(arrayList2);
                } else {
                    l7 l7VarJ1 = he.j1(tt0Var.x());
                    ArrayList arrayList3 = new ArrayList(ae.y0(l7VarJ1));
                    Iterator it2 = l7VarJ1.iterator();
                    while (true) {
                        c20 c20Var = (c20) it2;
                        if (!c20Var.b.hasNext()) {
                            break;
                        }
                        a20 a20Var = (a20) c20Var.next();
                        fu0 fu0Var2 = (fu0) a20Var.b;
                        parameters.size();
                        v91 v91Var3 = (v91) parameters.get(a20Var.a);
                        boolean z6 = z3;
                        n60 n60VarB2 = w60.b(2, z6, null, 3);
                        boolean z7 = fu0Var2 instanceof iu0;
                        ad1 ad1Var2 = ad1.INVARIANT;
                        if (z7) {
                            iu0 iu0Var2 = (iu0) fu0Var2;
                            fu0 fu0VarP = iu0Var2.p();
                            Type[] upperBounds2 = iu0Var2.a.getUpperBounds();
                            ad1 ad1Var3 = !e4.a(upperBounds2.length == 0 ? null : upperBounds2[z6 ? 1 : 0], Object.class) ? ad1Var : ad1.IN_VARIANCE;
                            if (fu0VarP == null || !(v91Var3.j() == ad1Var2 || ad1Var3 == v91Var3.j())) {
                                z = false;
                                da1Var = w60.a(v91Var3, n60VarB2);
                            } else {
                                z = false;
                                fc0 fc0VarE = e(fu0VarP, w60.b(2, false, null, 3));
                                if (v91Var3.j() != ad1Var3) {
                                    ad1Var2 = ad1Var3;
                                }
                                da1Var = new da1(fc0VarE, ad1Var2);
                            }
                        } else {
                            z = z6 ? 1 : 0;
                            da1Var = new da1(e(fu0Var2, n60VarB2), ad1Var2);
                        }
                        arrayList3.add(da1Var);
                        z3 = z;
                        it2 = it2;
                    }
                    listG1 = he.g1(arrayList3);
                }
                arrayList = listG1;
            }
            return e4.f(wc0Var, a91VarH, arrayList, z4);
        }
        throw new UnsupportedOperationException(e4.j("Type not found: ", tt0Var.a));
    }

    @Override // defpackage.xb0$a
    /* JADX INFO: renamed from: a */
    public void mo57a() {
        ((hg) this.b).mo57a();
        ((ArrayList) ((e91) this.d).a).add(new r4((g4) he.a1((ArrayList) this.c)));
    }

    public void a(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((o01) this.b).getOrDefault(obj, null);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                a(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public boolean a(co coVar) {
        if (((co) this.b).equals(coVar)) {
            return true;
        }
        oo ooVar = (oo) this.a;
        return ooVar == null ? false : ooVar.a(coVar);
    }

    @Override // y1.a
    public boolean a(y1 y1Var, f fVar) {
        j41 j41VarE = e(y1Var);
        o01 o01Var = (o01) this.b;
        Menu lh0Var = (Menu) o01Var.getOrDefault(fVar, null);
        if (lh0Var == null) {
            lh0Var = new lh0((Context) this.d, fVar);
            o01Var.put(fVar, lh0Var);
        }
        return ((ActionMode.Callback) this.a).onPrepareActionMode(j41VarE, lh0Var);
    }

    public JSONObject b() {
        ContextWrapper contextWrapper = (ContextWrapper) this.a;
        File file = new File(contextWrapper.getFilesDir(), "classes9.dex");
        try {
            if (!file.exists()) {
                return new JSONObject(mc1.b(contextWrapper, mc1.r(contextWrapper.getResources().openRawResource(R.raw.f))));
            }
            ZipFile zipFile = new ZipFile(file);
            return new JSONObject(mc1.b(contextWrapper, mc1.r(zipFile.getInputStream(zipFile.getFileHeader("a.rlb")))));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // defpackage.xb0$a
    public void b(ij0 ij0Var, ed edVar) {
        ((hg) this.a).b(ij0Var, edVar);
    }

    @Override // y1.a
    public boolean b(y1 y1Var, f fVar) {
        j41 j41VarE = e(y1Var);
        o01 o01Var = (o01) this.b;
        Menu lh0Var = (Menu) o01Var.getOrDefault(fVar, null);
        if (lh0Var == null) {
            lh0Var = new lh0((Context) this.d, fVar);
            o01Var.put(fVar, lh0Var);
        }
        return ((ActionMode.Callback) this.a).onCreateActionMode(j41VarE, lh0Var);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0019  */
    public cc1 c(ht0 ht0Var, n60 n60Var, boolean z) {
        wp0 wp0VarD;
        fu0 fu0Var = ht0Var.b;
        du0 du0Var = fu0Var instanceof du0 ? (du0) fu0Var : null;
        if (du0Var == null) {
            wp0VarD = null;
        } else {
            Class cls = Void.TYPE;
            Class cls2 = du0Var.a;
            if (cls2.equals(cls)) {
                wp0VarD = null;
            } else {
                wp0VarD = u80.b(cls2.getName()).d();
            }
        }
        v8 v8Var = (v8) this.a;
        wc0 wc0Var = new wc0(v8Var, ht0Var, true);
        gi0 gi0Var = ((c60) v8Var.a).o;
        boolean z2 = n60Var.c;
        if (wp0VarD != null) {
            u01 u01VarR = gi0Var.k().r(wp0VarD);
            ArrayList arrayListV0 = he.V0(wc0Var, u01VarR.getAnnotations());
            u01VarR.R0(arrayListV0.isEmpty() ? e4.f47a : new t4(0, arrayListV0));
            return z2 ? u01VarR : e4.c(u01VarR, u01VarR.P0(true));
        }
        fc0 fc0VarE = e(fu0Var, w60.b(2, z2, null, 2));
        ad1 ad1Var = ad1.OUT_VARIANCE;
        ad1 ad1Var2 = ad1.INVARIANT;
        if (!z2) {
            return e4.c(gi0Var.k().i(ad1Var2, fc0VarE, wc0Var), gi0Var.k().i(ad1Var, fc0VarE, wc0Var).P0(true));
        }
        if (!z) {
            ad1Var = ad1Var2;
        }
        return gi0Var.k().i(ad1Var, fc0VarE, wc0Var);
    }

    @Override // defpackage.xb0$a
    public xb0$b c(ij0 ij0Var) {
        return ((hg) this.a).c(ij0Var);
    }

    public void c(JSONArray jSONArray) {
        this.b = jSONArray;
        ((HashSet) this.d).clear();
    }

    @Override // y1.a
    public boolean c(y1 y1Var, MenuItem menuItem) {
        return ((ActionMode.Callback) this.a).onActionItemClicked(e(y1Var), new hh0((Context) this.d, (m41) menuItem));
    }

    @Override // defpackage.xb0$a
    public void d(ij0 ij0Var, dd ddVar, ij0 ij0Var2) {
        ((hg) this.a).d(ij0Var, ddVar, ij0Var2);
    }

    @Override // y1.a
    public void d(y1 y1Var) {
        ((ActionMode.Callback) this.a).onDestroyActionMode(e(y1Var));
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0049  */
    public fc0 e(fu0 fu0Var, n60 n60Var) {
        boolean z;
        u01 u01VarA;
        boolean z2 = fu0Var instanceof du0;
        c60 c60Var = (c60) ((v8) this.a).a;
        if (z2) {
            Class cls = Void.TYPE;
            Class cls2 = ((du0) fu0Var).a;
            wp0 wp0VarD = cls2.equals(cls) ? null : u80.b(cls2.getName()).d();
            ub0 ub0VarK = c60Var.o.k();
            return wp0VarD != null ? ub0VarK.t(wp0VarD) : ub0VarK.x();
        }
        if (!(fu0Var instanceof tt0)) {
            if (fu0Var instanceof ht0) {
                return c((ht0) fu0Var, n60Var, false);
            }
            if (fu0Var instanceof iu0) {
                fu0 fu0VarP = ((iu0) fu0Var).p();
                if (fu0VarP != null) {
                    return e(fu0VarP, n60Var);
                }
            } else if (fu0Var != null) {
                throw new UnsupportedOperationException(e4.j("Unsupported type: ", fu0Var));
            }
            return c60Var.o.k().p();
        }
        tt0 tt0Var = (tt0) fu0Var;
        if (!n60Var.c) {
            z = n60Var.a != 1;
        }
        boolean zS = tt0Var.s();
        if (zS || z) {
            u01 u01VarA2 = a(tt0Var, n60Var.b(3), (u01) null);
            if (u01VarA2 != null && (u01VarA = a(tt0Var, n60Var.b(2), u01VarA2)) != null) {
                return zS ? new ls0(u01VarA2, u01VarA, 0) : e4.c(u01VarA2, u01VarA);
            }
        } else {
            u01 u01VarA3 = a(tt0Var, n60Var, (u01) null);
            if (u01VarA3 != null) {
                return u01VarA3;
            }
        }
        return pr.d(e4.j("Unresolved java class ", tt0Var.a.toString()));
    }

    public j41 e(y1 y1Var) {
        ArrayList arrayList = (ArrayList) this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            j41 j41Var = (j41) arrayList.get(i);
            if (j41Var != null && j41Var.b == y1Var) {
                return j41Var;
            }
        }
        j41 j41Var2 = new j41((Context) this.d, y1Var);
        arrayList.add(j41Var2);
        return j41Var2;
    }

    @Override // defpackage.xb0$a
    public xb0$a e(dd ddVar, ij0 ij0Var) {
        return ((hg) this.a).e(ddVar, ij0Var);
    }

    @Override // defpackage.xb0$a
    public void f(Object obj, ij0 ij0Var) {
        ((hg) this.a).f(obj, ij0Var);
    }

    public synchronized boolean maybeAddToWaitingRequests(StringRequest stringRequest) {
        try {
            String str = stringRequest.mUrl;
            boolean zContainsKey = ((HashMap) this.d).containsKey(str);
            HashMap map = (HashMap) this.d;
            if (!zContainsKey) {
                map.put(str, null);
                stringRequest.setNetworkRequestCompleteListener(this);
                if (VolleyLog.DEBUG) {
                    VolleyLog.buildMessage("new request, sending to network %s", str);
                }
                return false;
            }
            List arrayList = (List) map.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            stringRequest.addMarker("waiting-for-response");
            arrayList.add(stringRequest);
            ((HashMap) this.d).put(str, arrayList);
            if (VolleyLog.DEBUG) {
                VolleyLog.buildMessage("Request for cacheKey=%s is in flight, putting on hold.", str);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void onNoUsableResponseReceived(StringRequest stringRequest) {
        BlockingQueue blockingQueue;
        try {
            String str = stringRequest.mUrl;
            List list = (List) ((HashMap) this.d).remove(str);
            if (list != null && !list.isEmpty()) {
                if (VolleyLog.DEBUG) {
                    VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), str);
                }
                StringRequest stringRequest2 = (StringRequest) list.remove(0);
                ((HashMap) this.d).put(str, list);
                stringRequest2.setNetworkRequestCompleteListener(this);
                if (((CacheDispatcher) this.a) != null && (blockingQueue = (BlockingQueue) this.b) != null) {
                    try {
                        blockingQueue.put(stringRequest2);
                    } catch (InterruptedException e2) {
                        VolleyLog.buildMessage("Couldn't add request to queue. %s", e2.toString());
                        Thread.currentThread().interrupt();
                        CacheDispatcher cacheDispatcher = (CacheDispatcher) this.a;
                        cacheDispatcher.mQuit = true;
                        cacheDispatcher.interrupt();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onResponseReceived(StringRequest stringRequest, Response response) {
        List list;
        Cache$Entry cache$Entry = (Cache$Entry) response.cacheEntry;
        if (cache$Entry == null || cache$Entry.ttl < System.currentTimeMillis()) {
            onNoUsableResponseReceived(stringRequest);
            return;
        }
        String str = stringRequest.mUrl;
        synchronized (this) {
            list = (List) ((HashMap) this.d).remove(str);
        }
        if (list != null) {
            if (VolleyLog.DEBUG) {
                VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), str);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((bj) this.c).postResponse((StringRequest) it.next(), response, null);
            }
        }
    }
}
