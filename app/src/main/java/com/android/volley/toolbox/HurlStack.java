package com.android.volley.toolbox;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.android.volley.Header;
import com.github.jorgecastilloprz.progressarc.animations.ArcAnimationFactory$1;
import com.github.jorgecastilloprz.progressarc.animations.ArcAnimationFactory$Type;
import com.github.jorgecastilloprz.progressarc.animations.GrowArcAnimation;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.trilead.ssh2.auth.SignatureProxy;
import defpackage.yd;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class HurlStack {
    public final /* synthetic */ int G0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class UrlConnectionInputStream extends FilterInputStream {
        public final HttpURLConnection mConnection;

        /* JADX WARN: Illegal instructions before constructor call */
        public UrlConnectionInputStream(HttpURLConnection httpURLConnection) {
            InputStream errorStream;
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
                errorStream = httpURLConnection.getErrorStream();
            }
            super(errorStream);
            this.mConnection = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            super.close();
            this.mConnection.disconnect();
        }
    }

    public HurlStack() {
        this.G0 = 1;
        new ArrayList();
    }

    public /* synthetic */ HurlStack(int i) {
        this.G0 = i;
    }

    public static ValueAnimator buildAnimation(ArcAnimationFactory$Type arcAnimationFactory$Type, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, Animator.AnimatorListener animatorListener) {
        GrowArcAnimation growArcAnimation;
        ValueAnimator valueAnimatorOfFloat;
        DecelerateInterpolator decelerateInterpolator;
        int i = ArcAnimationFactory$1.$SwitchMap$com$github$jorgecastilloprz$progressarc$animations$ArcAnimationFactory$Type[arcAnimationFactory$Type.ordinal()];
        if (i != 1) {
            if (i == 2) {
                growArcAnimation = new GrowArcAnimation(0);
                valueAnimatorOfFloat = ValueAnimator.ofFloat(20.0f, 300.0f);
                growArcAnimation.growAnim = valueAnimatorOfFloat;
                decelerateInterpolator = new DecelerateInterpolator();
            } else if (i != 3) {
                growArcAnimation = new GrowArcAnimation(1);
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(300.0f, 20.0f);
                growArcAnimation.growAnim = valueAnimatorOfFloat2;
                valueAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
                valueAnimatorOfFloat2.setDuration(2000L);
                valueAnimatorOfFloat2.addUpdateListener(animatorUpdateListener);
                valueAnimatorOfFloat2.addListener(animatorListener);
            } else {
                growArcAnimation = new GrowArcAnimation(3);
                valueAnimatorOfFloat = ValueAnimator.ofFloat(300.0f, 20.0f);
                growArcAnimation.growAnim = valueAnimatorOfFloat;
                decelerateInterpolator = new DecelerateInterpolator();
            }
            valueAnimatorOfFloat.setInterpolator(decelerateInterpolator);
            valueAnimatorOfFloat.setDuration(1000L);
            valueAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
            valueAnimatorOfFloat.addListener(animatorListener);
        } else {
            growArcAnimation = new GrowArcAnimation(2);
            ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 360.0f);
            growArcAnimation.growAnim = valueAnimatorOfFloat3;
            valueAnimatorOfFloat3.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat3.setDuration(2000L);
            valueAnimatorOfFloat3.addUpdateListener(animatorUpdateListener);
            valueAnimatorOfFloat3.setRepeatCount(-1);
            valueAnimatorOfFloat3.setRepeatMode(1);
        }
        return growArcAnimation.growAnim;
    }

    public static ArrayList convertHeaders(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new Header((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    public static yd executeRequest(StringRequest stringRequest, Map map) throws Throwable {
        String str = stringRequest.mUrl;
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(Collections.EMPTY_MAP);
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int i = stringRequest.mRetryPolicy.b;
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i);
        boolean z = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        "https".equals(url.getProtocol());
        try {
            for (String str2 : map2.keySet()) {
                httpURLConnection.setRequestProperty(str2, (String) map2.get(str2));
            }
            httpURLConnection.setRequestMethod("GET");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if ((100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304) {
                yd ydVar = new yd(responseCode, convertHeaders(httpURLConnection.getHeaderFields()), -1, null);
                httpURLConnection.disconnect();
                return ydVar;
            }
            try {
                return new yd(responseCode, convertHeaders(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new UrlConnectionInputStream(httpURLConnection));
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static float getFillLinePosition(LineDataSet lineDataSet, LineChart lineChart) {
        float fMax = Math.max(lineChart.mAxisLeft.mAxisMaximum, lineChart.mAxisRight.mAxisMaximum);
        float fMin = Math.min(lineChart.mAxisLeft.mAxisMinimum, lineChart.mAxisRight.mAxisMinimum);
        LineData lineData = lineChart.mData;
        if (lineDataSet.mYMax > 0.0f && lineDataSet.mYMin < 0.0f) {
            return 0.0f;
        }
        if (lineData.mYMax > 0.0f) {
            fMax = 0.0f;
        }
        if (lineData.mYMin < 0.0f) {
            fMin = 0.0f;
        }
        return lineDataSet.mYMin >= 0.0f ? fMin : fMax;
    }

    public Object getInstance(Provider provider) {
        switch (this.G0) {
            case 5:
                return provider == null ? Cipher.getInstance(SignatureProxy.SHA512) : Cipher.getInstance(SignatureProxy.SHA512, provider);
            case 6:
                return provider == null ? KeyAgreement.getInstance(SignatureProxy.SHA512) : KeyAgreement.getInstance(SignatureProxy.SHA512, provider);
            case 7:
                return provider == null ? KeyFactory.getInstance(SignatureProxy.SHA512) : KeyFactory.getInstance(SignatureProxy.SHA512, provider);
            case 8:
                return provider == null ? KeyPairGenerator.getInstance(SignatureProxy.SHA512) : KeyPairGenerator.getInstance(SignatureProxy.SHA512, provider);
            case 9:
                return provider == null ? Mac.getInstance(SignatureProxy.SHA512) : Mac.getInstance(SignatureProxy.SHA512, provider);
            case 10:
                return provider == null ? MessageDigest.getInstance(SignatureProxy.SHA512) : MessageDigest.getInstance(SignatureProxy.SHA512, provider);
            default:
                return provider == null ? Signature.getInstance(SignatureProxy.SHA512) : Signature.getInstance(SignatureProxy.SHA512, provider);
        }
    }
}
