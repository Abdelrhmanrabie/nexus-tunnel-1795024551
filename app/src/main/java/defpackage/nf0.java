package defpackage;

import java.io.Writer;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class nf0 extends Writer {
    public final StringBuilder b = new StringBuilder(128);

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        StringBuilder sb = this.b;
        if (sb.length() > 0) {
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        StringBuilder sb = this.b;
        if (sb.length() > 0) {
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            StringBuilder sb = this.b;
            if (c != '\n') {
                sb.append(c);
            } else if (sb.length() > 0) {
                sb.delete(0, sb.length());
            }
        }
    }
}
