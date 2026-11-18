package com.android.volley;

import android.os.Process;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.StringRequest;
import defpackage.bj;
import defpackage.f2;
import defpackage.oo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class CacheDispatcher extends Thread {
    public static final boolean DEBUG = VolleyLog.DEBUG;
    public final DiskBasedCache mCache;
    public final BlockingQueue mCacheQueue;
    public final bj mDelivery;
    public final BlockingQueue mNetworkQueue;
    public volatile boolean mQuit = false;
    public final oo mWaitingRequestManager;

    public CacheDispatcher(PriorityBlockingQueue priorityBlockingQueue, PriorityBlockingQueue priorityBlockingQueue2, DiskBasedCache diskBasedCache, bj bjVar) {
        this.mCacheQueue = priorityBlockingQueue;
        this.mNetworkQueue = priorityBlockingQueue2;
        this.mCache = diskBasedCache;
        this.mDelivery = bjVar;
        this.mWaitingRequestManager = new oo(this, priorityBlockingQueue2, bjVar);
    }

    public final void processRequest$1() {
        bj bjVar;
        StringRequest stringRequest = (StringRequest) this.mCacheQueue.take();
        stringRequest.addMarker("cache-queue-take");
        stringRequest.sendEvent();
        try {
            stringRequest.isCanceled();
            Cache$Entry cache$Entry = this.mCache.get(stringRequest.mUrl);
            if (cache$Entry == null) {
                stringRequest.addMarker("cache-miss");
                if (!this.mWaitingRequestManager.maybeAddToWaitingRequests(stringRequest)) {
                    this.mNetworkQueue.put(stringRequest);
                }
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (cache$Entry.ttl < jCurrentTimeMillis) {
                stringRequest.addMarker("cache-hit-expired");
                stringRequest.mCacheEntry = cache$Entry;
                if (!this.mWaitingRequestManager.maybeAddToWaitingRequests(stringRequest)) {
                    this.mNetworkQueue.put(stringRequest);
                }
                return;
            }
            stringRequest.addMarker("cache-hit");
            Response networkResponse = StringRequest.parseNetworkResponse(new Response(cache$Entry.data, cache$Entry.responseHeaders));
            stringRequest.addMarker("cache-hit-parsed");
            if (cache$Entry.softTtl < jCurrentTimeMillis) {
                stringRequest.addMarker("cache-hit-refresh-needed");
                stringRequest.mCacheEntry = cache$Entry;
                networkResponse.intermediate = true;
                boolean zMaybeAddToWaitingRequests = this.mWaitingRequestManager.maybeAddToWaitingRequests(stringRequest);
                bjVar = this.mDelivery;
                if (!zMaybeAddToWaitingRequests) {
                    bjVar.postResponse(stringRequest, networkResponse, new f2(this, stringRequest, 2, false));
                }
            }
            bjVar = this.mDelivery;
            bjVar.postResponse(stringRequest, networkResponse, null);
        } finally {
            stringRequest.sendEvent();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (DEBUG) {
            VolleyLog.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.mCache.initialize();
        while (true) {
            try {
                processRequest$1();
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.buildMessage("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
