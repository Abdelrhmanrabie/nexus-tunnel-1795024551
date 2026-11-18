package com.github.ybq.android.spinkit.animation;

import android.util.Property;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class IntProperty extends Property {
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntProperty(String str, int i) {
        super(i != 1 ? Integer.class : Float.class, str);
        this.G0 = i;
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        if (this.G0 != 0) {
            setValue(obj, ((Float) obj2).floatValue());
        } else {
            setValue(((Integer) obj2).intValue(), obj);
        }
    }

    public abstract void setValue(int i, Object obj);

    public abstract void setValue(Object obj, float f);
}
