package com.google.zxing.qrcode.decoder;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum DataMask {
    /* JADX INFO: Fake field, exist only in values array */
    EF2 { // from class: com.google.zxing.qrcode.decoder.DataMask.1
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public final boolean isMasked(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF7 { // from class: com.google.zxing.qrcode.decoder.DataMask.2
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public final boolean isMasked(int i, int i2) {
            return (i & 1) == 0;
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF12 { // from class: com.google.zxing.qrcode.decoder.DataMask.3
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public final boolean isMasked(int i, int i2) {
            return i2 % 3 == 0;
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF17 { // from class: com.google.zxing.qrcode.decoder.DataMask.4
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public final boolean isMasked(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF22 { // from class: com.google.zxing.qrcode.decoder.DataMask.5
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public final boolean isMasked(int i, int i2) {
            return (((i2 / 3) + (i / 2)) & 1) == 0;
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF27 { // from class: com.google.zxing.qrcode.decoder.DataMask.6
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public final boolean isMasked(int i, int i2) {
            return (i * i2) % 6 == 0;
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF32 { // from class: com.google.zxing.qrcode.decoder.DataMask.7
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public final boolean isMasked(int i, int i2) {
            return (i * i2) % 6 < 3;
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF37 { // from class: com.google.zxing.qrcode.decoder.DataMask.8
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public final boolean isMasked(int i, int i2) {
            return ((((i * i2) % 3) + (i + i2)) & 1) == 0;
        }
    };

    public abstract boolean isMasked(int i, int i2);
}
