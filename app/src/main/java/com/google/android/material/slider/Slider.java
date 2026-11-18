package com.google.android.material.slider;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.SeekBar;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Slider extends BaseSlider<Slider, OnChangeListener, OnSliderTouchListener> {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnChangeListener extends BaseOnChangeListener<Slider> {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnSliderTouchListener extends BaseOnSliderTouchListener<Slider> {
    }

    public Slider(Context context) {
        this(context, null);
    }

    public Slider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.a0m);
    }

    public Slider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.value});
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            setValues(Float.valueOf(typedArrayObtainStyledAttributes.getFloat(0, 0.0f)));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public final CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public final float getValueFrom() {
        return this.valueFrom;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public final float getValueTo() {
        return this.valueTo;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public final boolean pickActiveThumb() {
        if (this.activeThumbIdx != -1) {
            return true;
        }
        this.activeThumbIdx = 0;
        return true;
    }
}
