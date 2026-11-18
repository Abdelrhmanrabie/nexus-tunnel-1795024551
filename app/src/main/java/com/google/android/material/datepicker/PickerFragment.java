package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
abstract class PickerFragment<S> extends Fragment {
    public final LinkedHashSet onSelectionChangedListeners = new LinkedHashSet();

    public void addOnSelectionChangedListener(OnSelectionChangedListener onSelectionChangedListener) {
        this.onSelectionChangedListeners.add(onSelectionChangedListener);
    }
}
