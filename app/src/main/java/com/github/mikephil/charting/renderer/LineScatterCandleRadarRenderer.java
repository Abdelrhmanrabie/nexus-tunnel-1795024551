package com.github.mikephil.charting.renderer;

import android.graphics.Path;
import com.android.volley.toolbox.HurlStack;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class LineScatterCandleRadarRenderer extends BarLineScatterCandleBubbleRenderer {
    public final Path mHighlightLinePath;

    public LineScatterCandleRadarRenderer(HurlStack hurlStack, ViewPortHandler viewPortHandler) {
        super(hurlStack, viewPortHandler);
        this.mHighlightLinePath = new Path();
    }
}
