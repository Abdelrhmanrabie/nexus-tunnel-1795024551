package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.a1;
import defpackage.o1;
import defpackage.qd1;
import defpackage.qz;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    public static final /* synthetic */ int $r8$clinit = 0;
    public int checkedId;
    public final CheckedStateTracker checkedStateTracker;
    public Integer[] childOrder;
    public final Comparator childOrderComparator;
    public final LinkedHashSet onButtonCheckedListeners;
    public final ArrayList originalCornerData;
    public final PressedStateTracker pressedStateTracker;
    public final boolean selectionRequired;
    public final boolean singleSelection;
    public boolean skipCheckedStateTracker;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class CheckedStateTracker implements MaterialButton.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        @Override // com.google.android.material.button.MaterialButton.OnCheckedChangeListener
        public final void onCheckedChanged(MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            if (materialButtonToggleGroup.skipCheckedStateTracker) {
                return;
            }
            if (materialButtonToggleGroup.singleSelection) {
                materialButtonToggleGroup.checkedId = z ? materialButton.getId() : -1;
            }
            if (materialButtonToggleGroup.updateCheckedStates(materialButton.getId(), z)) {
                materialButtonToggleGroup.dispatchOnButtonChecked(materialButton.getId(), materialButton.checked);
            }
            materialButtonToggleGroup.invalidate();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class CornerData {
        public static final AbsoluteCornerSize noCorner = new AbsoluteCornerSize(0.0f);
        public final CornerSize bottomLeft;
        public final CornerSize bottomRight;
        public final CornerSize topLeft;
        public final CornerSize topRight;

        public CornerData(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            this.topLeft = cornerSize;
            this.topRight = cornerSize3;
            this.bottomRight = cornerSize4;
            this.bottomLeft = cornerSize2;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnButtonCheckedListener {
        void onButtonChecked(int i, boolean z);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        private PressedStateTracker() {
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public final void onPressedChanged() {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public MaterialButtonToggleGroup(Context context) {
        this(context, null);
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.sx);
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, R.plurals.a1s), attributeSet, i);
        this.originalCornerData = new ArrayList();
        this.checkedStateTracker = new CheckedStateTracker();
        this.pressedStateTracker = new PressedStateTracker();
        this.onButtonCheckedListeners = new LinkedHashSet();
        this.childOrderComparator = new Comparator<MaterialButton>() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.1
            @Override // java.util.Comparator
            public final int compare(MaterialButton materialButton, MaterialButton materialButton2) {
                MaterialButton materialButton3 = materialButton;
                MaterialButton materialButton4 = materialButton2;
                int iCompareTo = Boolean.valueOf(materialButton3.checked).compareTo(Boolean.valueOf(materialButton4.checked));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompareTo2 = Boolean.valueOf(materialButton3.isPressed()).compareTo(Boolean.valueOf(materialButton4.isPressed()));
                if (iCompareTo2 != 0) {
                    return iCompareTo2;
                }
                MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
                return Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton3)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton4)));
            }
        };
        this.skipCheckedStateTracker = false;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, com.google.android.material.R.styleable.MaterialButtonToggleGroup, i, R.plurals.a1s, new int[0]);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(2, false);
        if (this.singleSelection != z) {
            this.singleSelection = z;
            this.skipCheckedStateTracker = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i2);
                materialButton.setChecked(false);
                dispatchOnButtonChecked(materialButton.getId(), false);
            }
            this.skipCheckedStateTracker = false;
            this.checkedId = -1;
            dispatchOnButtonChecked(-1, true);
        }
        this.checkedId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        this.selectionRequired = typedArrayObtainStyledAttributes.getBoolean(1, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayObtainStyledAttributes.recycle();
        WeakHashMap weakHashMap = qd1.a;
        setImportantForAccessibility(1);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            if (materialButton.getId() == -1) {
                WeakHashMap weakHashMap = qd1.a;
                materialButton.setId(View.generateViewId());
            }
            materialButton.setMaxLines(1);
            MaterialButtonHelper materialButtonHelper = materialButton.materialButtonHelper;
            materialButton.setEllipsize(TextUtils.TruncateAt.END);
            if (materialButton.isUsingOriginalBackground()) {
                materialButtonHelper.checkable = true;
            }
            materialButton.onCheckedChangeListeners.add(this.checkedStateTracker);
            materialButton.onPressedChangeListenerInternal = this.pressedStateTracker;
            if (materialButton.isUsingOriginalBackground()) {
                materialButtonHelper.shouldDrawSurfaceColorStroke = true;
                MaterialShapeDrawable materialShapeDrawable = materialButtonHelper.getMaterialShapeDrawable(false);
                MaterialShapeDrawable materialShapeDrawable2 = materialButtonHelper.getMaterialShapeDrawable(true);
                if (materialShapeDrawable != null) {
                    float f = materialButtonHelper.strokeWidth;
                    ColorStateList colorStateList = materialButtonHelper.strokeColor;
                    materialShapeDrawable.setStrokeWidth(f);
                    materialShapeDrawable.setStrokeColor(colorStateList);
                    if (materialShapeDrawable2 != null) {
                        float f2 = materialButtonHelper.strokeWidth;
                        int color = materialButtonHelper.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(materialButtonHelper.materialButton, R.style.gx) : 0;
                        materialShapeDrawable2.setStrokeWidth(f2);
                        materialShapeDrawable2.setStrokeColor(ColorStateList.valueOf(color));
                    }
                }
            }
            if (materialButton.checked) {
                updateCheckedStates(materialButton.getId(), true);
                int id = materialButton.getId();
                this.checkedId = id;
                dispatchOnButtonChecked(id, true);
            }
            ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.originalCornerData.add(new CornerData(shapeAppearanceModel.topLeftCornerSize, shapeAppearanceModel.bottomLeftCornerSize, shapeAppearanceModel.topRightCornerSize, shapeAppearanceModel.bottomRightCornerSize));
            qd1.l(materialButton, new a1() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.2
                @Override // defpackage.a1
                public final void onInitializeAccessibilityNodeInfo(View view2, o1 o1Var) {
                    int i2;
                    AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
                    int i3 = MaterialButtonToggleGroup.$r8$clinit;
                    boolean z = view2 instanceof MaterialButton;
                    MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
                    if (z) {
                        i2 = 0;
                        for (int i4 = 0; i4 < materialButtonToggleGroup.getChildCount(); i4++) {
                            if (materialButtonToggleGroup.getChildAt(i4) == view2) {
                                accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) qz.a(((MaterialButton) view2).checked, 0, 1, i2, 1).a);
                            }
                            if ((materialButtonToggleGroup.getChildAt(i4) instanceof MaterialButton) && materialButtonToggleGroup.isChildVisible(i4)) {
                                i2++;
                            }
                        }
                    } else {
                        materialButtonToggleGroup.getClass();
                    }
                    i2 = -1;
                    accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) qz.a(((MaterialButton) view2).checked, 0, 1, i2, 1).a);
                }
            });
        }
    }

    public final void adjustChildMarginsAndUpdateLayout() {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                i = -1;
                break;
            } else if (isChildVisible(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        for (int i2 = i + 1; i2 < getChildCount(); i2++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i2);
            MaterialButton materialButton2 = (MaterialButton) getChildAt(i2 - 1);
            int iMin = Math.min(materialButton.isUsingOriginalBackground() ? materialButton.materialButtonHelper.strokeWidth : 0, materialButton2.isUsingOriginalBackground() ? materialButton2.materialButtonHelper.strokeWidth : 0);
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(-iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -iMin;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || i == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(i)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put((MaterialButton) getChildAt(i), Integer.valueOf(i));
        }
        this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void dispatchOnButtonChecked(int i, boolean z) {
        Iterator it = this.onButtonCheckedListeners.iterator();
        while (it.hasNext()) {
            ((OnButtonCheckedListener) it.next()).onButtonChecked(i, z);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.childOrder;
        return (numArr == null || i2 >= numArr.length) ? i2 : numArr[i2].intValue();
    }

    public final boolean isChildVisible(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        MaterialButton materialButton;
        super.onFinishInflate();
        int i = this.checkedId;
        if (i == -1 || (materialButton = (MaterialButton) findViewById(i)) == null) {
            return;
        }
        materialButton.setChecked(true);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && isChildVisible(i2)) {
                i++;
            }
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) qz.a(1, i, this.singleSelection ? 1 : 2).a);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.onCheckedChangeListeners.remove(this.checkedStateTracker);
            materialButton.onPressedChangeListenerInternal = null;
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.originalCornerData.remove(iIndexOfChild);
        }
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    public final boolean updateCheckedStates(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i2);
            if (materialButton.checked) {
                arrayList.add(Integer.valueOf(materialButton.getId()));
            }
        }
        if (this.selectionRequired && arrayList.isEmpty()) {
            View viewFindViewById = findViewById(i);
            if (viewFindViewById instanceof MaterialButton) {
                this.skipCheckedStateTracker = true;
                ((MaterialButton) viewFindViewById).setChecked(true);
                this.skipCheckedStateTracker = false;
            }
            this.checkedId = i;
            return false;
        }
        if (z && this.singleSelection) {
            arrayList.remove(Integer.valueOf(i));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                View viewFindViewById2 = findViewById(iIntValue);
                if (viewFindViewById2 instanceof MaterialButton) {
                    this.skipCheckedStateTracker = true;
                    ((MaterialButton) viewFindViewById2).setChecked(false);
                    this.skipCheckedStateTracker = false;
                }
                dispatchOnButtonChecked(iIntValue, false);
            }
        }
        return true;
    }

    public final void updateChildShapes() {
        int i;
        CornerData cornerData;
        int childCount = getChildCount();
        int childCount2 = getChildCount();
        int i2 = 0;
        while (true) {
            i = -1;
            if (i2 >= childCount2) {
                i2 = -1;
                break;
            } else if (isChildVisible(i2)) {
                break;
            } else {
                i2++;
            }
        }
        for (int childCount3 = getChildCount() - 1; childCount3 >= 0; childCount3--) {
            if (isChildVisible(childCount3)) {
                i = childCount3;
                break;
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i3);
            if (materialButton.getVisibility() != 8) {
                ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
                shapeAppearanceModel.getClass();
                ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel);
                CornerData cornerData2 = (CornerData) this.originalCornerData.get(i3);
                if (i2 != i) {
                    boolean z = getOrientation() == 0;
                    if (i3 == i2) {
                        if (z) {
                            AbsoluteCornerSize absoluteCornerSize = CornerData.noCorner;
                            if (ViewUtils.isLayoutRtl(this)) {
                                AbsoluteCornerSize absoluteCornerSize2 = CornerData.noCorner;
                                cornerData = new CornerData(absoluteCornerSize2, absoluteCornerSize2, cornerData2.topRight, cornerData2.bottomRight);
                            } else {
                                CornerSize cornerSize = cornerData2.topLeft;
                                CornerSize cornerSize2 = cornerData2.bottomLeft;
                                AbsoluteCornerSize absoluteCornerSize3 = CornerData.noCorner;
                                cornerData = new CornerData(cornerSize, cornerSize2, absoluteCornerSize3, absoluteCornerSize3);
                            }
                        } else {
                            CornerSize cornerSize3 = cornerData2.topLeft;
                            AbsoluteCornerSize absoluteCornerSize4 = CornerData.noCorner;
                            cornerData = new CornerData(cornerSize3, absoluteCornerSize4, cornerData2.topRight, absoluteCornerSize4);
                        }
                    } else if (i3 != i) {
                        cornerData2 = null;
                    } else if (z) {
                        AbsoluteCornerSize absoluteCornerSize5 = CornerData.noCorner;
                        if (ViewUtils.isLayoutRtl(this)) {
                            CornerSize cornerSize4 = cornerData2.topLeft;
                            CornerSize cornerSize5 = cornerData2.bottomLeft;
                            AbsoluteCornerSize absoluteCornerSize6 = CornerData.noCorner;
                            cornerData = new CornerData(cornerSize4, cornerSize5, absoluteCornerSize6, absoluteCornerSize6);
                        } else {
                            AbsoluteCornerSize absoluteCornerSize7 = CornerData.noCorner;
                            cornerData = new CornerData(absoluteCornerSize7, absoluteCornerSize7, cornerData2.topRight, cornerData2.bottomRight);
                        }
                    } else {
                        AbsoluteCornerSize absoluteCornerSize8 = CornerData.noCorner;
                        cornerData = new CornerData(absoluteCornerSize8, cornerData2.bottomLeft, absoluteCornerSize8, cornerData2.bottomRight);
                    }
                    cornerData2 = cornerData;
                }
                if (cornerData2 == null) {
                    builder.setAllCornerSizes(0.0f);
                } else {
                    builder.topLeftCornerSize = cornerData2.topLeft;
                    builder.bottomLeftCornerSize = cornerData2.bottomLeft;
                    builder.topRightCornerSize = cornerData2.topRight;
                    builder.bottomRightCornerSize = cornerData2.bottomRight;
                }
                materialButton.setShapeAppearanceModel(builder.build());
            }
        }
    }
}
