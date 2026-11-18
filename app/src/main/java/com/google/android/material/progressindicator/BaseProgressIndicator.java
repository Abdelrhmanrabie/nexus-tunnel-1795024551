package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.vectordrawable.graphics.drawable.a;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.d;
import defpackage.qd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.WeakHashMap;
import net.lingala.zip4j.util.InternalZipConstants;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final AnimatorDurationScaleProvider animatorDurationScaleProvider;
    public final Runnable delayedHide;
    public final Runnable delayedShow;
    public final a hideAnimationCallback;
    public boolean isIndeterminateModeChangeRequested;
    public final boolean isParentDoneInitializing;
    public final int minHideDelay;
    public final BaseProgressIndicatorSpec spec;
    public int storedProgress;
    public final a switchIndeterminateModeCallback;
    public final int visibilityAfterHide;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface HideAnimationBehavior {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowAnimationBehavior {
    }

    public BaseProgressIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, R.plurals.a2q), attributeSet, i);
        this.isIndeterminateModeChangeRequested = false;
        this.visibilityAfterHide = 4;
        this.delayedShow = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.1
            @Override // java.lang.Runnable
            public final void run() {
                int i3 = BaseProgressIndicator.$r8$clinit;
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                if (baseProgressIndicator.minHideDelay > 0) {
                    SystemClock.uptimeMillis();
                }
                baseProgressIndicator.setVisibility(0);
            }
        };
        this.delayedHide = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.2
            @Override // java.lang.Runnable
            public final void run() {
                BaseProgressIndicator.access$100(BaseProgressIndicator.this);
            }
        };
        this.switchIndeterminateModeCallback = new a() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.3
            @Override // androidx.vectordrawable.graphics.drawable.a
            public final void onAnimationEnd() {
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.setIndeterminate(false);
                baseProgressIndicator.setProgressCompat(baseProgressIndicator.storedProgress);
            }
        };
        this.hideAnimationCallback = new a() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.4
            @Override // androidx.vectordrawable.graphics.drawable.a
            public final void onAnimationEnd() {
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                if (baseProgressIndicator.isIndeterminateModeChangeRequested) {
                    return;
                }
                baseProgressIndicator.setVisibility(baseProgressIndicator.visibilityAfterHide);
            }
        };
        Context context2 = getContext();
        this.spec = createSpec(context2, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.BaseProgressIndicator, i, i2, new int[0]);
        typedArrayObtainStyledAttributes.getInt(5, -1);
        this.minHideDelay = Math.min(typedArrayObtainStyledAttributes.getInt(3, -1), InternalZipConstants.AES_HASH_ITERATIONS);
        typedArrayObtainStyledAttributes.recycle();
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        this.isParentDoneInitializing = true;
    }

    public static void access$100(BaseProgressIndicator baseProgressIndicator) {
        ((DrawableWithAnimatedVisibilityChange) baseProgressIndicator.getCurrentDrawable()).setVisible(false, false, true);
        if (((DeterminateDrawable) super.getProgressDrawable()) == null || !((DeterminateDrawable) super.getProgressDrawable()).isVisible()) {
            if (((IndeterminateDrawable) super.getIndeterminateDrawable()) == null || !((IndeterminateDrawable) super.getIndeterminateDrawable()).isVisible()) {
                baseProgressIndicator.setVisibility(4);
            }
        }
    }

    public abstract BaseProgressIndicatorSpec createSpec(Context context, AttributeSet attributeSet);

    @Override // android.widget.ProgressBar
    public final Drawable getCurrentDrawable() {
        return isIndeterminate() ? (IndeterminateDrawable) super.getIndeterminateDrawable() : (DeterminateDrawable) super.getProgressDrawable();
    }

    @Override // android.widget.ProgressBar
    public final Drawable getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public final IndeterminateDrawable getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public final Drawable getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }

    @Override // android.widget.ProgressBar
    public final DeterminateDrawable getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (((DeterminateDrawable) super.getProgressDrawable()) != null && ((IndeterminateDrawable) super.getIndeterminateDrawable()) != null) {
            ((IndeterminateDrawable) super.getIndeterminateDrawable()).animatorDelegate.registerAnimatorsCompleteCallback(this.switchIndeterminateModeCallback);
        }
        DeterminateDrawable determinateDrawable = (DeterminateDrawable) super.getProgressDrawable();
        a aVar = this.hideAnimationCallback;
        if (determinateDrawable != null) {
            DeterminateDrawable determinateDrawable2 = (DeterminateDrawable) super.getProgressDrawable();
            if (determinateDrawable2.animationCallbacks == null) {
                determinateDrawable2.animationCallbacks = new ArrayList();
            }
            if (!determinateDrawable2.animationCallbacks.contains(aVar)) {
                determinateDrawable2.animationCallbacks.add(aVar);
            }
        }
        if (((IndeterminateDrawable) super.getIndeterminateDrawable()) != null) {
            IndeterminateDrawable indeterminateDrawable = (IndeterminateDrawable) super.getIndeterminateDrawable();
            if (indeterminateDrawable.animationCallbacks == null) {
                indeterminateDrawable.animationCallbacks = new ArrayList();
            }
            if (!indeterminateDrawable.animationCallbacks.contains(aVar)) {
                indeterminateDrawable.animationCallbacks.add(aVar);
            }
        }
        if (visibleToUser()) {
            if (this.minHideDelay > 0) {
                SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.delayedHide);
        removeCallbacks(this.delayedShow);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).hideNow();
        IndeterminateDrawable indeterminateDrawable = (IndeterminateDrawable) super.getIndeterminateDrawable();
        a aVar = this.hideAnimationCallback;
        if (indeterminateDrawable != null) {
            ((IndeterminateDrawable) super.getIndeterminateDrawable()).unregisterAnimationCallback(aVar);
            ((IndeterminateDrawable) super.getIndeterminateDrawable()).animatorDelegate.unregisterAnimatorsCompleteCallback();
        }
        if (((DeterminateDrawable) super.getProgressDrawable()) != null) {
            ((DeterminateDrawable) super.getProgressDrawable()).unregisterAnimationCallback(aVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i2) {
        DrawingDelegate drawingDelegate;
        try {
            super.onMeasure(i, i2);
            if (isIndeterminate()) {
                drawingDelegate = ((IndeterminateDrawable) super.getIndeterminateDrawable()) == null ? null : ((IndeterminateDrawable) super.getIndeterminateDrawable()).drawingDelegate;
            } else if (((DeterminateDrawable) super.getProgressDrawable()) != null) {
                drawingDelegate = ((DeterminateDrawable) super.getProgressDrawable()).drawingDelegate;
            }
            if (drawingDelegate == null) {
                return;
            }
            int preferredWidth = drawingDelegate.getPreferredWidth();
            int preferredHeight = drawingDelegate.getPreferredHeight();
            setMeasuredDimension(preferredWidth < 0 ? getMeasuredWidth() : preferredWidth + getPaddingLeft() + getPaddingRight(), preferredHeight < 0 ? getMeasuredHeight() : preferredHeight + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        boolean z = i == 0;
        if (this.isParentDoneInitializing) {
            ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(visibleToUser(), false, z);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.isParentDoneInitializing) {
            ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(visibleToUser(), false, false);
        }
    }

    @Override // android.widget.ProgressBar
    public final synchronized void setIndeterminate(boolean z) {
        try {
            if (z == isIndeterminate()) {
                return;
            }
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
            if (drawableWithAnimatedVisibilityChange != null) {
                drawableWithAnimatedVisibilityChange.hideNow();
            }
            super.setIndeterminate(z);
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
            if (drawableWithAnimatedVisibilityChange2 != null) {
                drawableWithAnimatedVisibilityChange2.setVisible(visibleToUser(), false, false);
            }
            if ((drawableWithAnimatedVisibilityChange2 instanceof IndeterminateDrawable) && visibleToUser()) {
                ((IndeterminateDrawable) drawableWithAnimatedVisibilityChange2).animatorDelegate.startAnimator();
            }
            this.isIndeterminateModeChangeRequested = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar
    public final void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else if (!(drawable instanceof IndeterminateDrawable)) {
            d.AnonymousClass0.m$2("Cannot set framework drawable as indeterminate drawable.");
        } else {
            ((DrawableWithAnimatedVisibilityChange) drawable).hideNow();
            super.setIndeterminateDrawable(drawable);
        }
    }

    @Override // android.widget.ProgressBar
    public final synchronized void setProgress(int i) {
        if (isIndeterminate()) {
            return;
        }
        setProgressCompat(i);
    }

    public void setProgressCompat(int i) {
        if (!isIndeterminate()) {
            super.setProgress(i);
            if (((DeterminateDrawable) super.getProgressDrawable()) != null) {
                ((DeterminateDrawable) super.getProgressDrawable()).jumpToCurrentState();
                return;
            }
            return;
        }
        if (((DeterminateDrawable) super.getProgressDrawable()) != null) {
            this.storedProgress = i;
            this.isIndeterminateModeChangeRequested = true;
            if (((IndeterminateDrawable) super.getIndeterminateDrawable()).isVisible()) {
                ContentResolver contentResolver = getContext().getContentResolver();
                this.animatorDurationScaleProvider.getClass();
                if (Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) != 0.0f) {
                    ((IndeterminateDrawable) super.getIndeterminateDrawable()).animatorDelegate.requestCancelAnimatorAfterCurrentCycle();
                    return;
                }
            }
            this.switchIndeterminateModeCallback.onAnimationEnd();
        }
    }

    @Override // android.widget.ProgressBar
    public final void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
            return;
        }
        if (!(drawable instanceof DeterminateDrawable)) {
            d.AnonymousClass0.m$2("Cannot set framework drawable as progress drawable.");
            return;
        }
        DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
        determinateDrawable.setVisible(false, false, false);
        super.setProgressDrawable(determinateDrawable);
        determinateDrawable.setLevel((int) ((getProgress() / getMax()) * 10000.0f));
    }

    public final boolean visibleToUser() {
        WeakHashMap weakHashMap = qd1.a;
        if (!isAttachedToWindow() || getWindowVisibility() != 0) {
            return false;
        }
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }
}
