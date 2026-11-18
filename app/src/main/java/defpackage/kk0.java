package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.os.AsyncTask;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class kk0 extends AsyncTask {
    public Exception a;
    public a b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface a {
        void a(String str);
    }

    public static ArrayList a(Context context) throws Exception {
        Network activeNetwork;
        LinkProperties linkProperties;
        ArrayList arrayList = new ArrayList();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetwork = connectivityManager.getActiveNetwork()) != null && (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) != null) {
                Iterator<InetAddress> it = linkProperties.getDnsServers().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getHostAddress());
                }
            }
            return arrayList;
        } catch (Exception e) {
            throw new Exception("getActiveNetworkDnsResolvers failed", e);
        }
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        try {
            return a(((Context[]) objArr)[0]);
        } catch (Exception e) {
            this.a = e;
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        List list = (List) obj;
        Exception exc = this.a;
        if (exc != null) {
            exc.printStackTrace();
        } else if (list != null) {
            this.b.a((String) list.get(list.size() == 2 ? 1 : 0));
        }
    }
}
