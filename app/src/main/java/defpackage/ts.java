package defpackage;

import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ts extends h0 {
    public final a d = new a(0);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends ThreadLocal {
        public final /* synthetic */ int G0;

        public /* synthetic */ a(int i) {
            this.G0 = i;
        }

        @Override // java.lang.ThreadLocal
        public final Object initialValue() {
            if (this.G0 == 0) {
                return new Random();
            }
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextLong();
            return secureRandom;
        }
    }

    @Override // defpackage.h0
    public final Random b() {
        return (Random) this.d.get();
    }
}
