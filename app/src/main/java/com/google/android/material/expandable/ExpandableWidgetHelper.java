package com.google.android.material.expandable;

import android.view.View;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ExpandableWidgetHelper {
    public boolean expanded = false;
    public int expandedComponentIdHint = 0;
    public final View widget;

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandableWidgetHelper(ExpandableWidget expandableWidget) {
        this.widget = (View) expandableWidget;
    }
}
