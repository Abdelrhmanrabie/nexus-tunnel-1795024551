package defpackage;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class mh$c implements mh$b, mh$e {
    public final /* synthetic */ int G0 = 0;
    public final ClipData a;
    public final int b;
    public int c;
    public Uri d;
    public Bundle e;

    public mh$c(ClipData clipData, int i) {
        this.a = clipData;
        this.b = i;
    }

    public mh$c(mh$c mh_c) {
        ClipData clipData = mh_c.a;
        clipData.getClass();
        this.a = clipData;
        int i = mh_c.b;
        if (i < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i > 5) {
            Locale locale2 = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
        }
        this.b = i;
        int i2 = mh_c.c;
        if ((i2 & 1) == i2) {
            this.c = i2;
            this.d = mh_c.d;
            this.e = mh_c.e;
            return;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
    }

    @Override // defpackage.mh$e
    public ContentInfo a() {
        return null;
    }

    @Override // defpackage.mh$b
    public void a(Uri uri) {
        this.d = uri;
    }

    @Override // defpackage.mh$e
    /* JADX INFO: renamed from: b */
    public ClipData mo5b() {
        return this.a;
    }

    @Override // defpackage.mh$b
    public void b(int i) {
        this.c = i;
    }

    @Override // defpackage.mh$b
    public bj build() {
        return new bj(26, new mh$c(this));
    }

    @Override // defpackage.mh$e
    public int c() {
        return this.c;
    }

    @Override // defpackage.mh$e
    public int g() {
        return this.b;
    }

    @Override // defpackage.mh$b
    public void setExtras(Bundle bundle) {
        this.e = bundle;
    }

    public String toString() {
        String strValueOf;
        String str;
        if (this.G0 != 1) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
        sb.append(this.a.getDescription());
        sb.append(", source=");
        int i = this.b;
        if (i == 0) {
            strValueOf = "SOURCE_APP";
        } else if (i == 1) {
            strValueOf = "SOURCE_CLIPBOARD";
        } else if (i == 2) {
            strValueOf = "SOURCE_INPUT_METHOD";
        } else if (i == 3) {
            strValueOf = "SOURCE_DRAG_AND_DROP";
        } else if (i != 4) {
            strValueOf = i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT";
        } else {
            strValueOf = "SOURCE_AUTOFILL";
        }
        sb.append(strValueOf);
        sb.append(", flags=");
        int i2 = this.c;
        sb.append((i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2));
        Uri uri = this.d;
        String str2 = AppConfig.CUSTOM;
        if (uri == null) {
            str = AppConfig.CUSTOM;
        } else {
            str = ", hasLinkUri(" + uri.toString().length() + ")";
        }
        sb.append(str);
        if (this.e != null) {
            str2 = ", hasExtras";
        }
        return fb$1.m(sb, str2, "}");
    }
}
