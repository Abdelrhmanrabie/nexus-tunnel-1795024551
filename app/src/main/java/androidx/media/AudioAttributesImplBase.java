package androidx.media;

import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {
    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        int i = AudioAttributesCompat.$r8$clinit;
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{0, 0, 0, -1});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat: usage=USAGE_UNKNOWN content=0 flags=0x");
        int i = AudioAttributesCompat.$r8$clinit;
        sb.append(Integer.toHexString(0).toUpperCase());
        return sb.toString();
    }
}
