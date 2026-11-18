package defpackage;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class b0 implements oh0 {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends FilterInputStream {
        public int b;

        public a(int i, ByteArrayInputStream byteArrayInputStream) {
            super(byteArrayInputStream);
            this.b = i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int available() {
            return Math.min(super.available(), this.b);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read() throws IOException {
            if (this.b <= 0) {
                return -1;
            }
            int i = super.read();
            if (i >= 0) {
                this.b--;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.b;
            if (i3 <= 0) {
                return -1;
            }
            int i4 = super.read(bArr, i, Math.min(i2, i3));
            if (i4 >= 0) {
                this.b -= i4;
            }
            return i4;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final long skip(long j) throws IOException {
            long jSkip = super.skip(Math.min(j, this.b));
            if (jSkip >= 0) {
                this.b = (int) (((long) this.b) - jSkip);
            }
            return jSkip;
        }
    }

    public abstract void a(yd ydVar);

    public abstract int getSerializedSize();

    public abstract yx.a newBuilderForType();

    public abstract yx.a toBuilder();
}
