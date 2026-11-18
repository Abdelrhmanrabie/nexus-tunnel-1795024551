package renz.javacodez.v2ray.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.crypto.tink.subtle.Hex;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.InvertedLuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeReader;
import defpackage.bw0;
import defpackage.e;
import defpackage.fc;
import defpackage.g;
import defpackage.m6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class QRCodeDecoder {
    private static final Map<DecodeHintType, Object> HINTS;
    public static final QRCodeDecoder INSTANCE = new QRCodeDecoder();

    static {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        HINTS = enumMap;
        BarcodeFormat barcodeFormat = BarcodeFormat.QR_CODE;
        ArrayList arrayListC = e.c(BarcodeFormat.AZTEC, BarcodeFormat.CODABAR, BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.DATA_MATRIX, BarcodeFormat.EAN_8, BarcodeFormat.EAN_13, BarcodeFormat.ITF, BarcodeFormat.MAXICODE, BarcodeFormat.PDF_417, barcodeFormat, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED, BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.UPC_EAN_EXTENSION);
        enumMap.put(DecodeHintType.TRY_HARDER, barcodeFormat);
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, arrayListC);
        enumMap.put(DecodeHintType.CHARACTER_SET, fc.a);
    }

    private QRCodeDecoder() {
    }

    public static /* synthetic */ Bitmap createQRCode$default(QRCodeDecoder qRCodeDecoder, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 800;
        }
        return qRCodeDecoder.createQRCode(str, i);
    }

    private final Bitmap getDecodeAbleBitmap(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i2 = options.outHeight / 400;
            if (i2 > 0) {
                i = i2;
            }
            options.inSampleSize = i;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception unused) {
            return null;
        }
    }

    public final Bitmap createQRCode(String str, int i) {
        Object aVar;
        try {
            Map mapSingletonMap = Collections.singletonMap(EncodeHintType.CHARACTER_SET, fc.a);
            BarcodeFormat[] barcodeFormatArr = BarcodeFormat.$VALUES;
            BitMatrix bitMatrixEncode = Hex.encode(str, i, i, mapSingletonMap);
            int i2 = i * i;
            int[] iArr = new int[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                iArr[i3] = bitMatrixEncode.get(i3 % i, i3 / i) ? -16777216 : -1;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, i, 0, 0, i, i);
            aVar = bitmapCreateBitmap;
        } catch (Throwable th) {
            aVar = new bw0.a(th);
        }
        boolean z = aVar instanceof bw0.a;
        Object obj = aVar;
        if (z) {
            obj = null;
        }
        return (Bitmap) obj;
    }

    public final Map<DecodeHintType, Object> getHINTS() {
        return HINTS;
    }

    public final String syncDecodeQRCode(Bitmap bitmap) {
        Object aVar;
        if (bitmap == null) {
            return null;
        }
        try {
            int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            RGBLuminanceSource rGBLuminanceSource = new RGBLuminanceSource(bitmap.getWidth(), bitmap.getHeight(), iArr);
            QRCodeReader qRCodeReader = new QRCodeReader();
            try {
                aVar = (String) qRCodeReader.decode(new g(7, (Object) new m6(rGBLuminanceSource), false), Collections.singletonMap(DecodeHintType.TRY_HARDER, Boolean.TRUE)).b;
            } catch (NotFoundException unused) {
                aVar = (String) qRCodeReader.decode(new g(7, (Object) new m6(new InvertedLuminanceSource(rGBLuminanceSource)), false), Collections.singletonMap(DecodeHintType.TRY_HARDER, Boolean.TRUE)).b;
            }
        } catch (Throwable th) {
            aVar = new bw0.a(th);
        }
        return (String) (aVar instanceof bw0.a ? null : aVar);
    }

    public final String syncDecodeQRCode(String str) {
        return syncDecodeQRCode(getDecodeAbleBitmap(str));
    }
}
