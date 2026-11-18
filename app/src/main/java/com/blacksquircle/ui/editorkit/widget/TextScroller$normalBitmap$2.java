package com.blacksquircle.ui.editorkit.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import defpackage.lw;
import defpackage.oc0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class TextScroller$normalBitmap$2 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ TextScroller this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextScroller$normalBitmap$2(TextScroller textScroller, int i) {
        super(0);
        this.G0 = i;
        this.this$0 = textScroller;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        Bitmap bitmapCreateBitmap;
        Drawable drawable;
        Canvas canvas;
        int i = this.G0;
        TextScroller textScroller = this.this$0;
        if (i != 0) {
            int width = textScroller.getWidth();
            int i2 = textScroller.thumbHeight;
            bitmapCreateBitmap = Bitmap.createBitmap(width, i2, Bitmap.Config.ARGB_8888);
            drawable = textScroller.thumbDragging;
            drawable.setBounds(new Rect(0, 0, textScroller.getWidth(), i2));
            canvas = new Canvas(bitmapCreateBitmap);
        } else {
            int width2 = textScroller.getWidth();
            int i3 = textScroller.thumbHeight;
            bitmapCreateBitmap = Bitmap.createBitmap(width2, i3, Bitmap.Config.ARGB_8888);
            drawable = textScroller.thumbNormal;
            drawable.setBounds(new Rect(0, 0, textScroller.getWidth(), i3));
            canvas = new Canvas(bitmapCreateBitmap);
        }
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
