package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import defpackage.c9;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {
    public static WeakReference capturedSharedElement;
    public Rect returnEndBounds;
    public boolean entering = true;
    public final boolean transparentWindowBackgroundEnabled = true;
    public final ShapeableViewShapeProvider shapeProvider = new ShapeableViewShapeProvider();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface ShapeProvider {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class ShapeableViewShapeProvider implements ShapeProvider {
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    public static void access$000(Window window) {
        ColorFilter porterDuffColorFilter;
        Drawable background = window.getDecorView().getBackground();
        if (background == null) {
            return;
        }
        Drawable drawableMutate = background.mutate();
        c9[] c9VarArr = c9.c;
        if (Build.VERSION.SDK_INT >= 29) {
            BlendMode blendMode = BlendMode.CLEAR;
            if (blendMode != null) {
                porterDuffColorFilter = new BlendModeColorFilter(0, blendMode);
            } else {
                porterDuffColorFilter = null;
            }
        } else {
            PorterDuff.Mode mode = PorterDuff.Mode.CLEAR;
            if (mode != null) {
                porterDuffColorFilter = new PorterDuffColorFilter(0, mode);
            } else {
                porterDuffColorFilter = null;
            }
        }
        drawableMutate.setColorFilter(porterDuffColorFilter);
    }

    @Override // android.app.SharedElementCallback
    public final Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        capturedSharedElement = new WeakReference(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    public final View onCreateSnapshotView(Context context, Parcelable parcelable) {
        WeakReference weakReference;
        KeyEvent.Callback callback;
        View viewOnCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (viewOnCreateSnapshotView != null && (weakReference = capturedSharedElement) != null && this.shapeProvider != null && (callback = (View) weakReference.get()) != null) {
            ShapeAppearanceModel shapeAppearanceModel = callback instanceof Shapeable ? ((Shapeable) callback).getShapeAppearanceModel() : null;
            if (shapeAppearanceModel != null) {
                viewOnCreateSnapshotView.setTag(R.attr.rn, shapeAppearanceModel);
            }
        }
        return viewOnCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    public final void onMapSharedElements(List list, Map map) {
        View view;
        final Activity activity;
        if (list.isEmpty() || map.isEmpty() || (view = (View) map.get(list.get(0))) == null) {
            return;
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activity = null;
                break;
            } else {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (activity != null) {
            final Window window = activity.getWindow();
            boolean z = this.entering;
            boolean z2 = this.transparentWindowBackgroundEnabled;
            if (z) {
                Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
                if (sharedElementEnterTransition instanceof MaterialContainerTransform) {
                    MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementEnterTransition;
                    window.setSharedElementReenterTransition(null);
                    if (z2) {
                        if (materialContainerTransform.getDuration() >= 0) {
                            window.setTransitionBackgroundFadeDuration(materialContainerTransform.getDuration());
                        }
                        materialContainerTransform.addListener(new TransitionListenerAdapter(this) { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.1
                            @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                            public final void onTransitionEnd(Transition transition) {
                                WeakReference weakReference = MaterialContainerTransformSharedElementCallback.capturedSharedElement;
                                Drawable background = window.getDecorView().getBackground();
                                if (background == null) {
                                    return;
                                }
                                background.mutate().clearColorFilter();
                            }

                            @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                            public final void onTransitionStart(Transition transition) {
                                MaterialContainerTransformSharedElementCallback.access$000(window);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
            if (sharedElementReturnTransition instanceof MaterialContainerTransform) {
                MaterialContainerTransform materialContainerTransform2 = (MaterialContainerTransform) sharedElementReturnTransition;
                materialContainerTransform2.holdAtEndEnabled = true;
                materialContainerTransform2.addListener(new TransitionListenerAdapter(this) { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.2
                    @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public final void onTransitionEnd(Transition transition) {
                        View view2;
                        WeakReference weakReference = MaterialContainerTransformSharedElementCallback.capturedSharedElement;
                        if (weakReference != null && (view2 = (View) weakReference.get()) != null) {
                            view2.setAlpha(1.0f);
                            MaterialContainerTransformSharedElementCallback.capturedSharedElement = null;
                        }
                        Activity activity2 = activity;
                        activity2.finish();
                        activity2.overridePendingTransition(0, 0);
                    }
                });
                if (z2) {
                    if (materialContainerTransform2.getDuration() >= 0) {
                        window.setTransitionBackgroundFadeDuration(materialContainerTransform2.getDuration());
                    }
                    materialContainerTransform2.addListener(new TransitionListenerAdapter(this) { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.3
                        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                        public final void onTransitionStart(Transition transition) {
                            MaterialContainerTransformSharedElementCallback.access$000(window);
                        }
                    });
                }
            }
        }
    }

    @Override // android.app.SharedElementCallback
    public final void onSharedElementEnd(List list, List list2, List list3) {
        if (!list2.isEmpty() && (((View) list2.get(0)).getTag(R.attr.rn) instanceof View)) {
            ((View) list2.get(0)).setTag(R.attr.rn, null);
        }
        if (!this.entering && !list2.isEmpty()) {
            View view = (View) list2.get(0);
            RectF rectF = TransitionUtils.transformAlphaRectF;
            this.returnEndBounds = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        this.entering = false;
    }

    @Override // android.app.SharedElementCallback
    public final void onSharedElementStart(List list, List list2, List list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            ((View) list2.get(0)).setTag(R.attr.rn, list3.get(0));
        }
        if (this.entering || list2.isEmpty() || this.returnEndBounds == null) {
            return;
        }
        View view = (View) list2.get(0);
        view.measure(View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), 1073741824));
        Rect rect = this.returnEndBounds;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
    }
}
