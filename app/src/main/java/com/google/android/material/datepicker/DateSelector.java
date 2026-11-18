package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface DateSelector<S> extends Parcelable {
    int getDefaultThemeResId(Context context);

    ArrayList getSelectedDays();

    ArrayList getSelectedRanges();

    Object getSelection();

    String getSelectionDisplayString(Context context);

    boolean isSelectionComplete();

    View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, OnSelectionChangedListener onSelectionChangedListener);

    void select(long j);
}
