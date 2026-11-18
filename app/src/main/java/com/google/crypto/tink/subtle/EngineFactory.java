package com.google.crypto.tink.subtle;

import com.android.volley.toolbox.HurlStack;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class EngineFactory {
    public static final EngineFactory MESSAGE_DIGEST;
    public final FipsPolicy policy;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class FipsPolicy {
        public final /* synthetic */ int G0;
        public final HurlStack jceFactory;

        public /* synthetic */ FipsPolicy(HurlStack hurlStack, int i) {
            this.G0 = i;
            this.jceFactory = hurlStack;
        }

        public final Object getInstance() throws GeneralSecurityException {
            int i = this.G0;
            int i2 = 0;
            Exception exc = null;
            if (i == 0) {
                String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"};
                ArrayList arrayList = new ArrayList();
                while (i2 < 3) {
                    Provider provider = Security.getProvider(strArr[i2]);
                    if (provider != null) {
                        arrayList.add(provider);
                    }
                    i2++;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        return this.jceFactory.getInstance((Provider) it.next());
                    } catch (Exception e) {
                        if (exc == null) {
                            exc = e;
                        }
                    }
                }
                throw new GeneralSecurityException("No good Provider found.", exc);
            }
            if (i != 1) {
                return this.jceFactory.getInstance(null);
            }
            String[] strArr2 = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList2 = new ArrayList();
            while (i2 < 2) {
                Provider provider2 = Security.getProvider(strArr2[i2]);
                if (provider2 != null) {
                    arrayList2.add(provider2);
                }
                i2++;
            }
            Iterator it2 = arrayList2.iterator();
            Exception exc2 = null;
            while (true) {
                boolean zHasNext = it2.hasNext();
                HurlStack hurlStack = this.jceFactory;
                if (!zHasNext) {
                    return hurlStack.getInstance(null);
                }
                try {
                    return hurlStack.getInstance((Provider) it2.next());
                } catch (Exception e2) {
                    if (exc2 == null) {
                        exc2 = e2;
                    }
                }
            }
        }
    }

    static {
        new EngineFactory(new HurlStack(5));
        new EngineFactory(new HurlStack(9));
        new EngineFactory(new HurlStack(11));
        MESSAGE_DIGEST = new EngineFactory(new HurlStack(10));
        new EngineFactory(new HurlStack(6));
        new EngineFactory(new HurlStack(8));
        new EngineFactory(new HurlStack(7));
    }

    public EngineFactory(HurlStack hurlStack) {
        this.policy = TinkFipsUtil.isRestrictedToFips.get() ? new FipsPolicy(hurlStack, 0) : "The Android Project".equals(System.getProperty("java.vendor")) ? new FipsPolicy(hurlStack, 1) : new FipsPolicy(hurlStack, 2);
    }
}
