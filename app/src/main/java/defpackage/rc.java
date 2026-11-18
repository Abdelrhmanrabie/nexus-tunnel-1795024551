package defpackage;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.github.guilhe.views.CircularProgressView;
import com.mecofarid.squeezeloader.SqueezeLoader;
import java.util.WeakHashMap;
import renz.javacodez.v2ray.helper.SimpleItemTouchHelperCallback;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rc implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;

    public /* synthetic */ rc(int i, Object obj) {
        this.G0 = i;
        this.b = obj;
    }

    public /* synthetic */ rc(CircularProgressView circularProgressView, float f) {
        this.G0 = 0;
        this.b = circularProgressView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.G0;
        Object obj = this.b;
        if (i == 0) {
            CircularProgressView circularProgressView = (CircularProgressView) obj;
            DecelerateInterpolator decelerateInterpolator = CircularProgressView.DEFAULT_INTERPOLATOR;
            circularProgressView.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            circularProgressView.invalidate();
            return;
        }
        if (i != 1) {
            if (i != 2) {
                SimpleItemTouchHelperCallback.returnViewToOriginalPosition$lambda$2$lambda$1((RecyclerView.d0) obj, valueAnimator);
                return;
            } else {
                ((View) ((cg1) ((bj) obj).a).d.getParent()).invalidate();
                return;
            }
        }
        SqueezeLoader squeezeLoader = (SqueezeLoader) obj;
        if (valueAnimator == null) {
            d.AnonymousClass0.m("it must not be null");
            return;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new y81("null cannot be cast to non-null type kotlin.Float");
        }
        squeezeLoader.mSqueezebarDisplacement = ((Float) animatedValue).floatValue();
        WeakHashMap weakHashMap = qd1.a;
        squeezeLoader.postInvalidateOnAnimation();
        squeezeLoader.mAnimationFraction = valueAnimator.getAnimatedFraction();
        System.out.println((Object) "Josiah animation ");
    }
}
