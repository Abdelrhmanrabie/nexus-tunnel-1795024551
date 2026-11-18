package defpackage;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class vf0 {
    public int hitCount;
    public final LinkedHashMap map;
    public final int maxSize;
    public int missCount;
    public int size;

    public vf0(int i) {
        if (i <= 0) {
            d.AnonymousClass0.m$2("maxSize <= 0");
            throw null;
        }
        this.maxSize = i;
        this.map = new LinkedHashMap(0, 0.75f, true);
    }

    public final Object get(Object obj) {
        synchronized (this) {
            try {
                Object obj2 = this.map.get(obj);
                if (obj2 != null) {
                    this.hitCount++;
                    return obj2;
                }
                this.missCount++;
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object put(Object obj, Object obj2) {
        Object objPut;
        synchronized (this) {
            try {
                this.size++;
                objPut = this.map.put(obj, obj2);
                if (objPut != null) {
                    this.size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        trimToSize(this.maxSize);
        return objPut;
    }

    public final synchronized String toString() {
        int i;
        int i2;
        int i3;
        try {
            i = this.hitCount;
            i2 = this.missCount;
            int i4 = i2 + i;
            i3 = i4 != 0 ? (i * 100) / i4 : 0;
            Locale locale = Locale.US;
        } catch (Throwable th) {
            throw th;
        }
        return "LruCache[maxSize=" + this.maxSize + ",hits=" + i + ",misses=" + i2 + ",hitRate=" + i3 + "%]";
    }

    public final void trimToSize(int i) {
        while (true) {
            synchronized (this) {
                try {
                    if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                        break;
                    }
                    if (this.size > i && !this.map.isEmpty()) {
                        Map.Entry entry = (Map.Entry) this.map.entrySet().iterator().next();
                        Object key = entry.getKey();
                        entry.getValue();
                        this.map.remove(key);
                        this.size--;
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }
}
