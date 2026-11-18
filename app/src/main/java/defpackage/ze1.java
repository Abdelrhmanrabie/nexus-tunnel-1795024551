package defpackage;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ze1 extends ye1 {
    @Override // defpackage.ye1
    public final void d(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // defpackage.ye1
    public final float e(View view) {
        return view.getTransitionAlpha();
    }

    @Override // defpackage.ye1
    public final void f(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // defpackage.ye1
    public final void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // defpackage.ye1
    public final void h(ViewGroup viewGroup, Matrix matrix) {
        viewGroup.transformMatrixToLocal(matrix);
    }

    @Override // defpackage.ye1
    public final void i(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }
}
