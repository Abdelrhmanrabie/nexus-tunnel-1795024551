package defpackage;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o6 {
    public final Object a;

    public o6() {
        this.a = null;
        ArrayList arrayList = new ArrayList();
        arrayList.add("10.0.0.1");
        arrayList.add("172.16.0.1");
        arrayList.add("192.168.0.1");
        arrayList.add("169.254.1.1");
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                    if (inetAddress instanceof Inet4Address) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (hostAddress.startsWith("10.")) {
                            arrayList.remove("10.0.0.1");
                        } else if (hostAddress.length() >= 6 && hostAddress.substring(0, 6).compareTo("172.16") >= 0 && hostAddress.substring(0, 6).compareTo("172.31") <= 0) {
                            arrayList.remove("172.16.0.1");
                        } else if (hostAddress.startsWith("192.168")) {
                            arrayList.remove("192.168.0.1");
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (arrayList.size() > 0) {
            this.a = (String) arrayList.get(0);
        } else {
            this.a = "172.16.0.1";
        }
    }

    public void a(Object obj) {
        ((ArrayList) this.a).add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        boolean z = obj instanceof Object[];
        Object obj2 = this.a;
        if (z) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList arrayList = (ArrayList) obj2;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(arrayList, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            ((ArrayList) obj2).addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                ((ArrayList) obj2).add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                ((ArrayList) obj2).add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        String str = (String) this.a;
        if (str.compareTo("10.0.0.1") == 0) {
            return 8;
        }
        if (str.compareTo("172.16.0.1") == 0) {
            return 12;
        }
        if (str.compareTo("192.168.0.1") == 0) {
            return 16;
        }
        return str.compareTo("169.254.1.1") == 0 ? 24 : 0;
    }

    public String d() {
        String str = (String) this.a;
        if (str.compareTo("10.0.0.1") == 0) {
            return "10.0.0.2";
        }
        if (str.compareTo("172.16.0.1") == 0) {
            return "172.16.0.2";
        }
        if (str.compareTo("192.168.0.1") == 0) {
            return "192.168.0.2";
        }
        if (str.compareTo("169.254.1.1") == 0) {
            return "169.254.1.2";
        }
        return null;
    }

    public int e() {
        return ((ArrayList) this.a).size();
    }

    public Object[] f(Object[] objArr) {
        return ((ArrayList) this.a).toArray(objArr);
    }
}
