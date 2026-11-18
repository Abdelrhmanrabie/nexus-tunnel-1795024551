package com.android.volley.toolbox;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.Cache$Entry;
import com.android.volley.Request$Priority;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.google.crypto.tink.subtle.Hex;
import defpackage.b81;
import defpackage.hk0;
import defpackage.oo;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class StringRequest implements Comparable {
    public Cache$Entry mCacheEntry;
    public final int mDefaultTrafficStatsTag;
    public final HamoTunnelPlusMain.q mErrorListener;
    public final VolleyLog.MarkerLog mEventLog;
    public final HamoTunnelPlusMain.p mListener;
    public final Object mLock;
    public final Object mLock$1;
    public oo mRequestCompleteListener;
    public RequestQueue mRequestQueue;
    public boolean mResponseDelivered;
    public final hk0 mRetryPolicy;
    public Integer mSequence;
    public final boolean mShouldCache;
    public final String mUrl;

    public StringRequest(String str, HamoTunnelPlusMain.p pVar, HamoTunnelPlusMain.q qVar) {
        Uri uri;
        String host;
        this.mEventLog = VolleyLog.MarkerLog.ENABLED ? new VolleyLog.MarkerLog() : null;
        this.mLock$1 = new Object();
        this.mShouldCache = true;
        int iHashCode = 0;
        this.mResponseDelivered = false;
        this.mCacheEntry = null;
        this.mUrl = str;
        this.mErrorListener = qVar;
        hk0 hk0Var = new hk0();
        hk0Var.b = 2500;
        this.mRetryPolicy = hk0Var;
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.mDefaultTrafficStatsTag = iHashCode;
        this.mLock = new Object();
        this.mListener = pVar;
    }

    public static Response parseNetworkResponse(Response response) {
        String str;
        Cache$Entry cache$Entry;
        long j;
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        Map map = (Map) response.result;
        byte[] bArr = (byte[]) response.error;
        try {
            str = new String(bArr, Hex.parseCharset(map));
        } catch (UnsupportedEncodingException unused) {
            str = new String(bArr);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (map != null) {
            String str2 = (String) map.get("Date");
            long dateAsEpoch = str2 != null ? Hex.parseDateAsEpoch(str2) : 0L;
            String str3 = (String) map.get("Cache-Control");
            int i = 0;
            if (str3 != null) {
                String[] strArrSplit = str3.split(",", 0);
                z = false;
                j2 = 0;
                j3 = 0;
                j = 0;
                while (true) {
                    if (i < strArrSplit.length) {
                        String strTrim = strArrSplit[i].trim();
                        if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                            cache$Entry = null;
                        } else {
                            if (strTrim.startsWith("max-age=")) {
                                try {
                                    j2 = Long.parseLong(strTrim.substring(8));
                                } catch (Exception unused2) {
                                }
                            } else if (strTrim.startsWith("stale-while-revalidate=")) {
                                j3 = Long.parseLong(strTrim.substring(23));
                            } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                                z = true;
                            }
                            i++;
                        }
                    } else {
                        i = 1;
                    }
                }
            } else {
                j = 0;
                z = false;
                j2 = 0;
                j3 = 0;
            }
            String str4 = (String) map.get("Expires");
            long dateAsEpoch2 = str4 != null ? Hex.parseDateAsEpoch(str4) : j;
            String str5 = (String) map.get("Last-Modified");
            long dateAsEpoch3 = str5 != null ? Hex.parseDateAsEpoch(str5) : j;
            String str6 = (String) map.get("ETag");
            if (i != 0) {
                j5 = (j2 * 1000) + jCurrentTimeMillis;
                if (z) {
                    j6 = j5;
                } else {
                    Long.signum(j3);
                    j6 = (j3 * 1000) + j5;
                }
                j4 = j6;
            } else {
                if (dateAsEpoch > j && dateAsEpoch2 >= dateAsEpoch) {
                    j = (dateAsEpoch2 - dateAsEpoch) + jCurrentTimeMillis;
                }
                j4 = j;
                j5 = j4;
            }
            Cache$Entry cache$Entry2 = new Cache$Entry();
            cache$Entry2.data = bArr;
            cache$Entry2.etag = str6;
            cache$Entry2.softTtl = j5;
            cache$Entry2.ttl = j4;
            cache$Entry2.serverDate = dateAsEpoch;
            cache$Entry2.lastModified = dateAsEpoch3;
            cache$Entry2.responseHeaders = map;
            cache$Entry2.allResponseHeaders = (List) response.cacheEntry;
            cache$Entry = cache$Entry2;
        } else {
            cache$Entry = null;
        }
        return new Response(str, cache$Entry);
    }

    public final void addMarker(String str) {
        if (VolleyLog.MarkerLog.ENABLED) {
            this.mEventLog.add(str, Thread.currentThread().getId());
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        StringRequest stringRequest = (StringRequest) obj;
        Request$Priority[] request$PriorityArr = Request$Priority.$VALUES;
        stringRequest.getClass();
        return this.mSequence.intValue() - stringRequest.mSequence.intValue();
    }

    public final void deliverError(VolleyError volleyError) {
        HamoTunnelPlusMain.q qVar;
        synchronized (this.mLock$1) {
            qVar = this.mErrorListener;
        }
        if (qVar != null) {
            qVar.onErrorResponse(volleyError);
        }
    }

    public final void finish(String str) {
        RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            synchronized (requestQueue.mCurrentRequests) {
                requestQueue.mCurrentRequests.remove(this);
            }
            synchronized (requestQueue.mFinishedListeners) {
                Iterator it = requestQueue.mFinishedListeners.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
            requestQueue.sendRequestEvent();
        }
        if (VolleyLog.MarkerLog.ENABLED) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new b81.a(this, str, id, 1));
            } else {
                this.mEventLog.add(str, id);
                this.mEventLog.finish(toString());
            }
        }
    }

    public final boolean hasHadResponseDelivered() {
        boolean z;
        synchronized (this.mLock$1) {
            z = this.mResponseDelivered;
        }
        return z;
    }

    public final void isCanceled() {
        synchronized (this.mLock$1) {
        }
    }

    public final void markDelivered() {
        synchronized (this.mLock$1) {
            this.mResponseDelivered = true;
        }
    }

    public final void notifyListenerResponseNotUsable() {
        oo ooVar;
        synchronized (this.mLock$1) {
            ooVar = this.mRequestCompleteListener;
        }
        if (ooVar != null) {
            ooVar.onNoUsableResponseReceived(this);
        }
    }

    public final void notifyListenerResponseReceived(Response response) {
        oo ooVar;
        synchronized (this.mLock$1) {
            ooVar = this.mRequestCompleteListener;
        }
        if (ooVar != null) {
            ooVar.onResponseReceived(this, response);
        }
    }

    public final void sendEvent() {
        RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            requestQueue.sendRequestEvent();
        }
    }

    public final void setNetworkRequestCompleteListener(oo ooVar) {
        synchronized (this.mLock$1) {
            this.mRequestCompleteListener = ooVar;
        }
    }

    public final String toString() {
        String str = "0x" + Integer.toHexString(this.mDefaultTrafficStatsTag);
        StringBuilder sb = new StringBuilder("[ ] ");
        isCanceled();
        sb.append(this.mUrl);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(Request$Priority.NORMAL);
        sb.append(" ");
        sb.append(this.mSequence);
        return sb.toString();
    }
}
