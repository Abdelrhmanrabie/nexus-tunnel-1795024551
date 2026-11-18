package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.toolbox.DiskBasedCache;
import defpackage.bj;
import defpackage.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class RequestQueue {
    public final DiskBasedCache mCache;
    public CacheDispatcher mCacheDispatcher;
    public final PriorityBlockingQueue mCacheQueue;
    public final HashSet mCurrentRequests;
    public final bj mDelivery;
    public final NetworkDispatcher[] mDispatchers;
    public final ArrayList mEventListeners;
    public final ArrayList mFinishedListeners;
    public final g mNetwork;
    public final PriorityBlockingQueue mNetworkQueue;
    public final AtomicInteger mSequenceGenerator;

    public RequestQueue(DiskBasedCache diskBasedCache, g gVar) {
        bj bjVar = new bj(new Handler(Looper.getMainLooper()));
        this.mSequenceGenerator = new AtomicInteger();
        this.mCurrentRequests = new HashSet();
        this.mCacheQueue = new PriorityBlockingQueue();
        this.mNetworkQueue = new PriorityBlockingQueue();
        this.mFinishedListeners = new ArrayList();
        this.mEventListeners = new ArrayList();
        this.mCache = diskBasedCache;
        this.mNetwork = gVar;
        this.mDispatchers = new NetworkDispatcher[4];
        this.mDelivery = bjVar;
    }

    public final void sendRequestEvent() {
        synchronized (this.mEventListeners) {
            try {
                Iterator it = this.mEventListeners.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
