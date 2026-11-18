package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import com.jcraft.jzlib.GZIPHeader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class yg$a {
    public final /* synthetic */ int G0;
    public int a;
    public final Object b;
    public int c;

    public yg$a(int i, int i2) {
        this.G0 = 2;
        this.b = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i2, i);
        this.c = i;
        this.a = i2;
    }

    public yg$a(Context context, XmlResourceParser xmlResourceParser) {
        this.G0 = 0;
        this.b = new ArrayList();
        this.c = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), ak.E);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.a = typedArrayObtainStyledAttributes.getResourceId(index, this.a);
            } else if (index == 1) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.c);
                this.c = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new b().e((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public yg$a(byte[] bArr) {
        this.G0 = 1;
        this.b = bArr;
    }

    public int available() {
        return ((((byte[]) this.b).length - this.c) * 8) - this.a;
    }

    public byte get(int i, int i2) {
        return ((byte[][]) this.b)[i2][i];
    }

    public int readBits(int i) {
        byte[] bArr = (byte[]) this.b;
        if (i <= 0 || i > 32 || i > available()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.a;
        int i3 = 0;
        if (i2 > 0) {
            int i4 = 8 - i2;
            int i5 = i < i4 ? i : i4;
            int i6 = i4 - i5;
            int i7 = this.c;
            int i8 = (((255 >> (8 - i5)) << i6) & bArr[i7]) >> i6;
            i -= i5;
            int i9 = i2 + i5;
            this.a = i9;
            if (i9 == 8) {
                this.a = 0;
                this.c = i7 + 1;
            }
            i3 = i8;
        }
        if (i > 0) {
            while (i >= 8) {
                int i10 = i3 << 8;
                int i11 = this.c;
                int i12 = i10 | (bArr[i11] & GZIPHeader.OS_UNKNOWN);
                this.c = i11 + 1;
                i -= 8;
                i3 = i12;
            }
            if (i > 0) {
                int i13 = 8 - i;
                int i14 = ((bArr[this.c] & ((255 >> i13) << i13)) >> i13) | (i3 << i);
                this.a += i;
                return i14;
            }
        }
        return i3;
    }

    public void set(int i, int i2, int i3) {
        ((byte[][]) this.b)[i2][i] = (byte) i3;
    }

    public void set(int i, int i2, boolean z) {
        ((byte[][]) this.b)[i2][i] = z ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        if (this.G0 != 2) {
            return super.toString();
        }
        int i = this.c;
        int i2 = this.a;
        StringBuilder sb = new StringBuilder((i * 2 * i2) + 2);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                byte b = ((byte[][]) this.b)[i3][i4];
                sb.append(b != 0 ? b != 1 ? "  " : " 1" : " 0");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
