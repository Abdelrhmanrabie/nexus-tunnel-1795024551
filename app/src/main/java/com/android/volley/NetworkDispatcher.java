package com.android.volley;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.StringRequest;
import defpackage.bj;
import defpackage.dq;
import defpackage.g;
import defpackage.oo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkDispatcher extends Thread {
    public final DiskBasedCache mCache;
    public final bj mDelivery;
    public final g mNetwork;
    public final BlockingQueue mQueue;
    public volatile boolean mQuit = false;

    public NetworkDispatcher(PriorityBlockingQueue priorityBlockingQueue, g gVar, DiskBasedCache diskBasedCache, bj bjVar) {
        this.mQueue = priorityBlockingQueue;
        this.mNetwork = gVar;
        this.mCache = diskBasedCache;
        this.mDelivery = bjVar;
    }

    public final void processRequest$1() {
        oo ooVar;
        StringRequest stringRequest = (StringRequest) this.mQueue.take();
        bj bjVar = this.mDelivery;
        SystemClock.elapsedRealtime();
        stringRequest.sendEvent();
        int i = 1;
        Object obj = null;
        try {
            try {
                stringRequest.addMarker("network-queue-take");
                stringRequest.isCanceled();
                TrafficStats.setThreadStatsTag(stringRequest.mDefaultTrafficStatsTag);
                Response responsePerformRequest = this.mNetwork.performRequest(stringRequest);
                stringRequest.addMarker("network-http-complete");
                if (responsePerformRequest.intermediate && stringRequest.hasHadResponseDelivered()) {
                    stringRequest.finish("not-modified");
                    synchronized (stringRequest.mLock$1) {
                        ooVar = stringRequest.mRequestCompleteListener;
                    }
                    if (ooVar != null) {
                        ooVar.onNoUsableResponseReceived(stringRequest);
                    }
                    stringRequest.sendEvent();
                    return;
                }
                Response networkResponse = StringRequest.parseNetworkResponse(responsePerformRequest);
                Cache$Entry cache$Entry = (Cache$Entry) networkResponse.cacheEntry;
                stringRequest.addMarker("network-parse-complete");
                if (stringRequest.mShouldCache && cache$Entry != null) {
                    this.mCache.put(stringRequest.mUrl, cache$Entry);
                    stringRequest.addMarker("network-cache-written");
                }
                stringRequest.markDelivered();
                bjVar.postResponse(stringRequest, networkResponse, null);
                stringRequest.notifyListenerResponseReceived(networkResponse);
                stringRequest.sendEvent();
            } catch (VolleyError e) {
                SystemClock.elapsedRealtime();
                bjVar.getClass();
                stringRequest.addMarker("post-error");
                ((ExecutorDelivery$1) bjVar.a).execute(new dq(stringRequest, new Response(e), obj, i));
                stringRequest.notifyListenerResponseNotUsable();
            } catch (Exception e2) {
                VolleyLog.buildMessage("Unhandled exception %s", e2.toString());
                VolleyError volleyError = new VolleyError(e2);
                SystemClock.elapsedRealtime();
                bjVar.getClass();
                stringRequest.addMarker("post-error");
                ((ExecutorDelivery$1) bjVar.a).execute(new dq(stringRequest, new Response(volleyError), obj, i));
                stringRequest.notifyListenerResponseNotUsable();
            }
        } catch (Throwable th) {
            stringRequest.sendEvent();
            throw th;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                processRequest$1();
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.buildMessage("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
