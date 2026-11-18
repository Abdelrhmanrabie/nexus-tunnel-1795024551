package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.d;
import defpackage.fg1;
import defpackage.o01;
import defpackage.qd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public static final /* synthetic */ int $r8$clinit = 0;
    public Behavior behavior;
    public int bottomInset;
    public int fabAlignmentMode;
    public final AnimatorListenerAdapter fabAnimationListener;
    public boolean fabAttached;
    public final int fabOffsetEndMode;
    public final TransformationCallback fabTransformationCallback;
    public final boolean hideOnScroll;
    public int leftInset;
    public final MaterialShapeDrawable materialShapeDrawable;
    public AnimatorSet menuAnimator;
    public final Integer navigationIconTint;
    public final boolean paddingBottomSystemWindowInsets;
    public final boolean paddingLeftSystemWindowInsets;
    public final boolean paddingRightSystemWindowInsets;
    public int rightInset;

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$4, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    class AnonymousClass4 extends AnimatorListenerAdapter {
        public AnonymousClass4() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            int i = BottomAppBar.$r8$clinit;
            BottomAppBar.this.getClass();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            int i = BottomAppBar.$r8$clinit;
            BottomAppBar.this.getClass();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$5, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    class AnonymousClass5 extends FloatingActionButton.OnVisibilityChangedListener {
        public final /* synthetic */ int val$targetMode;

        public AnonymousClass5(int i) {
            this.val$targetMode = i;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
        public final void onHidden(FloatingActionButton floatingActionButton) {
            int i = BottomAppBar.$r8$clinit;
            floatingActionButton.setTranslationX(BottomAppBar.this.getFabTranslationX(this.val$targetMode));
            floatingActionButton.show(new FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5.1
                @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                public final void onShown() {
                    BottomAppBar bottomAppBar = BottomAppBar.this;
                    int i2 = BottomAppBar.$r8$clinit;
                    bottomAppBar.getClass();
                }
            }, true);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface AnimationListener {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public final Rect fabContentRect;
        public final View.OnLayoutChangeListener fabLayoutListener;
        public int originalBottomMargin;
        public WeakReference viewRef;

        public Behavior() {
            this.fabLayoutListener = new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    Behavior behavior = Behavior.this;
                    WeakReference weakReference = behavior.viewRef;
                    Rect rect = behavior.fabContentRect;
                    BottomAppBar bottomAppBar = (BottomAppBar) weakReference.get();
                    if (bottomAppBar != null) {
                        int i9 = bottomAppBar.fabOffsetEndMode;
                        MaterialShapeDrawable materialShapeDrawable = bottomAppBar.materialShapeDrawable;
                        if (view instanceof FloatingActionButton) {
                            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                            rect.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                            floatingActionButton.offsetRectWithShadow(rect);
                            int iHeight = rect.height();
                            float f = iHeight;
                            if (f != bottomAppBar.getTopEdgeTreatment().fabDiameter) {
                                bottomAppBar.getTopEdgeTreatment().fabDiameter = f;
                                materialShapeDrawable.invalidateSelf();
                            }
                            float cornerSize = floatingActionButton.getShapeAppearanceModel().topLeftCornerSize.getCornerSize(new RectF(rect));
                            if (cornerSize != bottomAppBar.getTopEdgeTreatment().fabCornerSize) {
                                bottomAppBar.getTopEdgeTreatment().fabCornerSize = cornerSize;
                                materialShapeDrawable.invalidateSelf();
                            }
                            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                            if (behavior.originalBottomMargin == 0) {
                                ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.bottomInset + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.jn) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                                ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.leftInset;
                                ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.rightInset;
                                if (ViewUtils.isLayoutRtl(floatingActionButton)) {
                                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = i9 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
                                    return;
                                } else {
                                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = i9 + ((ViewGroup.MarginLayoutParams) fVar).rightMargin;
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    view.removeOnLayoutChangeListener(this);
                }
            };
            this.fabContentRect = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.fabLayoutListener = new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    Behavior behavior = Behavior.this;
                    WeakReference weakReference = behavior.viewRef;
                    Rect rect = behavior.fabContentRect;
                    BottomAppBar bottomAppBar = (BottomAppBar) weakReference.get();
                    if (bottomAppBar != null) {
                        int i9 = bottomAppBar.fabOffsetEndMode;
                        MaterialShapeDrawable materialShapeDrawable = bottomAppBar.materialShapeDrawable;
                        if (view instanceof FloatingActionButton) {
                            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                            rect.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                            floatingActionButton.offsetRectWithShadow(rect);
                            int iHeight = rect.height();
                            float f = iHeight;
                            if (f != bottomAppBar.getTopEdgeTreatment().fabDiameter) {
                                bottomAppBar.getTopEdgeTreatment().fabDiameter = f;
                                materialShapeDrawable.invalidateSelf();
                            }
                            float cornerSize = floatingActionButton.getShapeAppearanceModel().topLeftCornerSize.getCornerSize(new RectF(rect));
                            if (cornerSize != bottomAppBar.getTopEdgeTreatment().fabCornerSize) {
                                bottomAppBar.getTopEdgeTreatment().fabCornerSize = cornerSize;
                                materialShapeDrawable.invalidateSelf();
                            }
                            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                            if (behavior.originalBottomMargin == 0) {
                                ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.bottomInset + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.jn) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                                ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.leftInset;
                                ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.rightInset;
                                if (ViewUtils.isLayoutRtl(floatingActionButton)) {
                                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = i9 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
                                    return;
                                } else {
                                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = i9 + ((ViewGroup.MarginLayoutParams) fVar).rightMargin;
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    view.removeOnLayoutChangeListener(this);
                }
            };
            this.fabContentRect = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            final BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.viewRef = new WeakReference(bottomAppBar);
            int i2 = BottomAppBar.$r8$clinit;
            View viewFindDependentView = bottomAppBar.findDependentView();
            if (viewFindDependentView != null) {
                WeakHashMap weakHashMap = qd1.a;
                if (!viewFindDependentView.isLaidOut()) {
                    CoordinatorLayout.f fVar = (CoordinatorLayout.f) viewFindDependentView.getLayoutParams();
                    fVar.d = 49;
                    this.originalBottomMargin = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                    if (viewFindDependentView instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) viewFindDependentView;
                        if (floatingActionButton.getShowMotionSpec() == null) {
                            floatingActionButton.setShowMotionSpecResource();
                        }
                        if (floatingActionButton.getHideMotionSpec() == null) {
                            floatingActionButton.setHideMotionSpecResource();
                        }
                        floatingActionButton.addOnLayoutChangeListener(this.fabLayoutListener);
                        floatingActionButton.addOnHideAnimationListener(bottomAppBar.fabAnimationListener);
                        floatingActionButton.addOnShowAnimationListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.9
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationStart(Animator animator) {
                                BottomAppBar bottomAppBar2 = BottomAppBar.this;
                                bottomAppBar2.fabAnimationListener.onAnimationStart(animator);
                                View viewFindDependentView2 = bottomAppBar2.findDependentView();
                                FloatingActionButton floatingActionButton2 = viewFindDependentView2 instanceof FloatingActionButton ? (FloatingActionButton) viewFindDependentView2 : null;
                                if (floatingActionButton2 != null) {
                                    floatingActionButton2.setTranslationX(bottomAppBar2.getFabTranslationX(bottomAppBar2.fabAlignmentMode));
                                }
                            }
                        });
                        floatingActionButton.addTransformationCallback(bottomAppBar.fabTransformationCallback);
                    }
                    bottomAppBar.setCutoutState();
                }
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i);
            super.onLayoutChild(coordinatorLayout, bottomAppBar, i);
            return false;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            return bottomAppBar.hideOnScroll && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view2, view3, i, i2);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SavedState extends d {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.SavedState.1
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int fabAlignmentMode;
        public boolean fabAttached;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // defpackage.d, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }
    }

    public BottomAppBar(Context context) {
        this(context, null);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.cn);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, R.plurals.a0p), attributeSet, i);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.materialShapeDrawable = materialShapeDrawable;
        this.fabAttached = true;
        this.fabAnimationListener = new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                final BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.getClass();
                final int i2 = bottomAppBar.fabAlignmentMode;
                final boolean z = bottomAppBar.fabAttached;
                WeakHashMap weakHashMap = qd1.a;
                if (bottomAppBar.isLaidOut()) {
                    AnimatorSet animatorSet = bottomAppBar.menuAnimator;
                    if (animatorSet != null) {
                        animatorSet.cancel();
                    }
                    ArrayList arrayList = new ArrayList();
                    View viewFindDependentView = bottomAppBar.findDependentView();
                    final ActionMenuView actionMenuView = null;
                    FloatingActionButton floatingActionButton = viewFindDependentView instanceof FloatingActionButton ? (FloatingActionButton) viewFindDependentView : null;
                    if (floatingActionButton == null || !floatingActionButton.isOrWillBeShown$1()) {
                        i2 = 0;
                        z = false;
                    }
                    for (int i3 = 0; i3 < bottomAppBar.getChildCount(); i3++) {
                        View childAt = bottomAppBar.getChildAt(i3);
                        if (childAt instanceof ActionMenuView) {
                            actionMenuView = (ActionMenuView) childAt;
                            break;
                        }
                    }
                    if (actionMenuView != null) {
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                        if (Math.abs(actionMenuView.getTranslationX() - bottomAppBar.getActionMenuViewTranslationX(actionMenuView, i2, z)) > 1.0f) {
                            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                            objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.7
                                public boolean cancelled;

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationCancel(Animator animator2) {
                                    this.cancelled = true;
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator2) {
                                    if (this.cancelled) {
                                        return;
                                    }
                                    BottomAppBar bottomAppBar2 = BottomAppBar.this;
                                    bottomAppBar2.getClass();
                                    bottomAppBar2.translateActionMenuView(actionMenuView, i2, z);
                                }
                            });
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.setDuration(150L);
                            animatorSet2.playSequentially(objectAnimatorOfFloat2, objectAnimatorOfFloat);
                            arrayList.add(animatorSet2);
                        } else if (actionMenuView.getAlpha() < 1.0f) {
                            arrayList.add(objectAnimatorOfFloat);
                        }
                    }
                    AnimatorSet animatorSet3 = new AnimatorSet();
                    animatorSet3.playTogether(arrayList);
                    bottomAppBar.menuAnimator = animatorSet3;
                    animatorSet3.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.6
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator2) {
                            int i4 = BottomAppBar.$r8$clinit;
                            BottomAppBar bottomAppBar2 = BottomAppBar.this;
                            bottomAppBar2.getClass();
                            bottomAppBar2.menuAnimator = null;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator2) {
                            int i4 = BottomAppBar.$r8$clinit;
                            BottomAppBar.this.getClass();
                        }
                    });
                    bottomAppBar.menuAnimator.start();
                }
            }
        };
        this.fabTransformationCallback = new TransformationCallback<FloatingActionButton>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.2
            @Override // com.google.android.material.animation.TransformationCallback
            public final void onScaleChanged(View view) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                BottomAppBar.this.materialShapeDrawable.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
            }

            @Override // com.google.android.material.animation.TransformationCallback
            public final void onTranslationChanged(View view) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                float translationX = floatingActionButton.getTranslationX();
                int i2 = BottomAppBar.$r8$clinit;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                BottomAppBarTopEdgeTreatment topEdgeTreatment = bottomAppBar.getTopEdgeTreatment();
                MaterialShapeDrawable materialShapeDrawable2 = bottomAppBar.materialShapeDrawable;
                if (topEdgeTreatment.horizontalOffset != translationX) {
                    bottomAppBar.getTopEdgeTreatment().horizontalOffset = translationX;
                    materialShapeDrawable2.invalidateSelf();
                }
                float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
                if (bottomAppBar.getTopEdgeTreatment().cradleVerticalOffset != fMax) {
                    BottomAppBarTopEdgeTreatment topEdgeTreatment2 = bottomAppBar.getTopEdgeTreatment();
                    if (fMax < 0.0f) {
                        topEdgeTreatment2.getClass();
                        d.AnonymousClass0.m$2("cradleVerticalOffset must be positive.");
                        return;
                    } else {
                        topEdgeTreatment2.cradleVerticalOffset = fMax;
                        materialShapeDrawable2.invalidateSelf();
                    }
                }
                materialShapeDrawable2.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
            }
        };
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.BottomAppBar, i, R.plurals.a0p, new int[0]);
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 0);
        if (typedArrayObtainStyledAttributes.hasValue(8)) {
            this.navigationIconTint = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(8, -1));
            Drawable navigationIcon = getNavigationIcon();
            if (navigationIcon != null) {
                setNavigationIcon(navigationIcon);
            }
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(4, 0);
        float dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 0);
        float dimensionPixelOffset3 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
        this.fabAlignmentMode = typedArrayObtainStyledAttributes.getInt(2, 0);
        typedArrayObtainStyledAttributes.getInt(3, 0);
        this.hideOnScroll = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.paddingBottomSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(9, false);
        this.paddingLeftSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(10, false);
        this.paddingRightSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(11, false);
        typedArrayObtainStyledAttributes.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R.dimen.jm);
        BottomAppBarTopEdgeTreatment bottomAppBarTopEdgeTreatment = new BottomAppBarTopEdgeTreatment(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        RelativeCornerSize relativeCornerSize = ShapeAppearanceModel.PILL;
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
        builder.topEdge = bottomAppBarTopEdgeTreatment;
        materialShapeDrawable.setShapeAppearanceModel(builder.build());
        materialShapeDrawable.setShadowCompatibilityMode();
        materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        materialShapeDrawable.initializeElevationOverlay(context2);
        setElevation(dimensionPixelSize);
        materialShapeDrawable.setTintList(colorStateList);
        WeakHashMap weakHashMap = qd1.a;
        setBackground(materialShapeDrawable);
        ViewUtils.doOnApplyWindowInsets(this, attributeSet, i, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.3
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public final fg1 onApplyWindowInsets(View view, fg1 fg1Var, ViewUtils.RelativePadding relativePadding) {
                boolean z;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                if (bottomAppBar.paddingBottomSystemWindowInsets) {
                    bottomAppBar.bottomInset = fg1Var.a();
                }
                boolean z2 = false;
                if (bottomAppBar.paddingLeftSystemWindowInsets) {
                    z = bottomAppBar.leftInset != fg1Var.b();
                    bottomAppBar.leftInset = fg1Var.b();
                } else {
                    z = false;
                }
                if (bottomAppBar.paddingRightSystemWindowInsets) {
                    boolean z3 = bottomAppBar.rightInset != fg1Var.c();
                    bottomAppBar.rightInset = fg1Var.c();
                    z2 = z3;
                }
                if (!z && !z2) {
                    return fg1Var;
                }
                AnimatorSet animatorSet = bottomAppBar.menuAnimator;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                bottomAppBar.setCutoutState();
                bottomAppBar.setActionMenuViewPosition();
                return fg1Var;
            }
        });
    }

    public final View findDependentView() {
        if (getParent() instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) getParent();
            List list = (List) ((o01) coordinatorLayout.mChildDag.b).getOrDefault(this, null);
            ArrayList<View> arrayList = coordinatorLayout.mTempDependenciesList;
            arrayList.clear();
            if (list != null) {
                arrayList.addAll(list);
            }
            for (View view : arrayList) {
                if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                    return view;
                }
            }
        }
        return null;
    }

    public final int getActionMenuViewTranslationX(ActionMenuView actionMenuView, int i, boolean z) {
        if (i != 1 || !z) {
            return 0;
        }
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        int measuredWidth = zIsLayoutRtl ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).a & 8388615) == 8388611) {
                measuredWidth = zIsLayoutRtl ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((zIsLayoutRtl ? actionMenuView.getRight() : actionMenuView.getLeft()) + (zIsLayoutRtl ? this.rightInset : -this.leftInset));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public final CoordinatorLayout.c getBehavior() {
        if (this.behavior == null) {
            this.behavior = new Behavior();
        }
        return this.behavior;
    }

    public final float getFabTranslationX(int i) {
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (i == 1) {
            return ((getMeasuredWidth() / 2) - (this.fabOffsetEndMode + (zIsLayoutRtl ? this.leftInset : this.rightInset))) * (zIsLayoutRtl ? -1 : 1);
        }
        return 0.0f;
    }

    public final BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().topEdge;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            AnimatorSet animatorSet = this.menuAnimator;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            setCutoutState();
        }
        setActionMenuViewPosition();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        this.fabAlignmentMode = savedState.fabAlignmentMode;
        this.fabAttached = savedState.fabAttached;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.fabAlignmentMode;
        savedState.fabAttached = this.fabAttached;
        return savedState;
    }

    public final void setActionMenuViewPosition() {
        ActionMenuView actionMenuView;
        int i = 0;
        while (true) {
            if (i >= getChildCount()) {
                actionMenuView = null;
                break;
            }
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                actionMenuView = (ActionMenuView) childAt;
                break;
            }
            i++;
        }
        if (actionMenuView == null || this.menuAnimator != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        View viewFindDependentView = findDependentView();
        FloatingActionButton floatingActionButton = viewFindDependentView instanceof FloatingActionButton ? (FloatingActionButton) viewFindDependentView : null;
        if (floatingActionButton == null || !floatingActionButton.isOrWillBeShown$1()) {
            translateActionMenuView(actionMenuView, 0, false);
        } else {
            translateActionMenuView(actionMenuView, this.fabAlignmentMode, this.fabAttached);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    public final void setCutoutState() {
        float f;
        getTopEdgeTreatment().horizontalOffset = getFabTranslationX(this.fabAlignmentMode);
        View viewFindDependentView = findDependentView();
        if (this.fabAttached) {
            View viewFindDependentView2 = findDependentView();
            FloatingActionButton floatingActionButton = viewFindDependentView2 instanceof FloatingActionButton ? (FloatingActionButton) viewFindDependentView2 : null;
            if (floatingActionButton == null || !floatingActionButton.isOrWillBeShown$1()) {
                f = 0.0f;
            } else {
                f = 1.0f;
            }
        } else {
            f = 0.0f;
        }
        this.materialShapeDrawable.setInterpolation(f);
        if (viewFindDependentView != null) {
            viewFindDependentView.setTranslationY(-getTopEdgeTreatment().cradleVerticalOffset);
            viewFindDependentView.setTranslationX(getFabTranslationX(this.fabAlignmentMode));
        }
    }

    @Override // android.view.View
    public final void setElevation(float f) {
        MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
        materialShapeDrawable.setElevation(f);
        int shadowRadius = materialShapeDrawable.getShadowRadius() - materialShapeDrawable.getShadowOffsetY();
        if (this.behavior == null) {
            this.behavior = new Behavior();
        }
        Behavior behavior = this.behavior;
        behavior.additionalHiddenOffsetY = shadowRadius;
        if (behavior.currentState == 1) {
            setTranslationY(behavior.height + shadowRadius);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.navigationIconTint != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.navigationIconTint.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void setTitle(CharSequence charSequence) {
    }

    public final void translateActionMenuView(final ActionMenuView actionMenuView, final int i, final boolean z) {
        new Runnable() { // from class: com.google.android.material.bottomappbar.BottomAppBar.8
            @Override // java.lang.Runnable
            public final void run() {
                int i2 = i;
                boolean z2 = z;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                ActionMenuView actionMenuView2 = actionMenuView;
                actionMenuView2.setTranslationX(bottomAppBar.getActionMenuViewTranslationX(actionMenuView2, i2, z2));
            }
        }.run();
    }
}
