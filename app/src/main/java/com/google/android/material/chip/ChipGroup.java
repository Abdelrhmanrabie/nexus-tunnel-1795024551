package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.qd1;
import defpackage.qz;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ChipGroup extends FlowLayout {
    public int checkedId;
    public final CheckedStateTracker checkedStateTracker;
    public final int chipSpacingHorizontal;
    public final int chipSpacingVertical;
    public final PassThroughHierarchyChangeListener passThroughListener;
    public boolean protectFromCheckedChange;
    public final boolean selectionRequired;
    public final boolean singleSelection;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ChipGroup chipGroup = ChipGroup.this;
            if (chipGroup.protectFromCheckedChange) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < chipGroup.getChildCount(); i++) {
                View childAt = chipGroup.getChildAt(i);
                if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                    arrayList.add(Integer.valueOf(childAt.getId()));
                    if (chipGroup.singleSelection) {
                        break;
                    }
                }
            }
            if (arrayList.isEmpty() && chipGroup.selectionRequired) {
                chipGroup.setCheckedStateForView(compoundButton.getId(), true);
                chipGroup.checkedId = compoundButton.getId();
                return;
            }
            int id = compoundButton.getId();
            int i2 = chipGroup.checkedId;
            if (!z) {
                if (i2 == id) {
                    chipGroup.checkedId = -1;
                }
            } else {
                if (i2 != -1 && i2 != id && chipGroup.singleSelection) {
                    chipGroup.setCheckedStateForView(i2, false);
                }
                chipGroup.checkedId = id;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnCheckedChangeListener {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        public ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;

        private PassThroughHierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
            ChipGroup chipGroup;
            int id;
            int i;
            ChipGroup chipGroup2 = ChipGroup.this;
            if (view == chipGroup2 && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    WeakHashMap weakHashMap = qd1.a;
                    view2.setId(View.generateViewId());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked() && (id = chip.getId()) != (i = (chipGroup = (ChipGroup) view).checkedId)) {
                    if (i != -1 && chipGroup.singleSelection) {
                        chipGroup.setCheckedStateForView(i, false);
                    }
                    if (id != -1) {
                        chipGroup.setCheckedStateForView(id, true);
                    }
                    chipGroup.checkedId = id;
                }
                chip.onCheckedChangeListenerInternal = chipGroup2.checkedStateTracker;
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.onHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).onCheckedChangeListenerInternal = null;
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.onHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.eg);
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, R.plurals.a1e), attributeSet, i);
        this.checkedStateTracker = new CheckedStateTracker();
        this.passThroughListener = new PassThroughHierarchyChangeListener();
        this.checkedId = -1;
        this.protectFromCheckedChange = false;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, com.google.android.material.R.styleable.ChipGroup, i, R.plurals.a1e, new int[0]);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        int dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, dimensionPixelOffset);
        if (this.chipSpacingHorizontal != dimensionPixelOffset2) {
            this.chipSpacingHorizontal = dimensionPixelOffset2;
            this.itemSpacing = dimensionPixelOffset2;
            requestLayout();
        }
        int dimensionPixelOffset3 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, dimensionPixelOffset);
        if (this.chipSpacingVertical != dimensionPixelOffset3) {
            this.chipSpacingVertical = dimensionPixelOffset3;
            this.lineSpacing = dimensionPixelOffset3;
            requestLayout();
        }
        this.singleLine = typedArrayObtainStyledAttributes.getBoolean(5, false);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(6, false);
        if (this.singleSelection != z) {
            this.singleSelection = z;
            this.protectFromCheckedChange = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof Chip) {
                    ((Chip) childAt).setChecked(false);
                }
            }
            this.protectFromCheckedChange = false;
            this.checkedId = -1;
        }
        this.selectionRequired = typedArrayObtainStyledAttributes.getBoolean(4, false);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        if (resourceId != -1) {
            this.checkedId = resourceId;
        }
        typedArrayObtainStyledAttributes.recycle();
        super.setOnHierarchyChangeListener(this.passThroughListener);
        WeakHashMap weakHashMap = qd1.a;
        setImportantForAccessibility(1);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i2 = this.checkedId;
                if (i2 != -1 && this.singleSelection) {
                    setCheckedStateForView(i2, false);
                }
                this.checkedId = chip.getId();
            }
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // com.google.android.material.internal.FlowLayout
    public final boolean isSingleLine() {
        return this.singleLine;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i = this.checkedId;
        if (i != -1) {
            setCheckedStateForView(i, true);
            this.checkedId = this.checkedId;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.singleLine) {
            i = 0;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (getChildAt(i2) instanceof Chip) {
                    i++;
                }
            }
        } else {
            i = -1;
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) qz.a(this.rowCount, i, this.singleSelection ? 1 : 2).a);
    }

    public final void setCheckedStateForView(int i, boolean z) {
        View viewFindViewById = findViewById(i);
        if (viewFindViewById instanceof Chip) {
            this.protectFromCheckedChange = true;
            ((Chip) viewFindViewById).setChecked(z);
            this.protectFromCheckedChange = false;
        }
    }

    @Override // android.view.ViewGroup
    public final void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.passThroughListener.onHierarchyChangeListener = onHierarchyChangeListener;
    }
}
