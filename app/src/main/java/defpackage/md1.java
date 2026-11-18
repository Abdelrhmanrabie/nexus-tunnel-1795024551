package defpackage;

import android.text.TextUtils;
import android.view.View;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class md1 extends j51 {
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public md1(int i) {
        super(R.attr.a0c, CharSequence.class, 64, 30);
        this.G0 = i;
        if (i != 3) {
        } else {
            super(R.attr.a07, Boolean.class, 0, 28);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ md1(int i, Class cls, int i2, int i3, int i4) {
        super(i, cls, i2, i3);
        this.G0 = i4;
    }

    @Override // defpackage.j51
    public final Object b(View view) {
        boolean zIsScreenReaderFocusable;
        int i = this.G0;
        if (i == 0) {
            zIsScreenReaderFocusable = view.isScreenReaderFocusable();
        } else {
            if (i == 1) {
                return view.getAccessibilityPaneTitle();
            }
            if (i == 2) {
                return view.getStateDescription();
            }
            zIsScreenReaderFocusable = view.isAccessibilityHeading();
        }
        return Boolean.valueOf(zIsScreenReaderFocusable);
    }

    @Override // defpackage.j51
    public final void c(View view, Object obj) {
        int i = this.G0;
        if (i == 0) {
            view.setScreenReaderFocusable(((Boolean) obj).booleanValue());
            return;
        }
        if (i == 1) {
            view.setAccessibilityPaneTitle((CharSequence) obj);
        } else if (i != 2) {
            view.setAccessibilityHeading(((Boolean) obj).booleanValue());
        } else {
            view.setStateDescription((CharSequence) obj);
        }
    }

    @Override // defpackage.j51
    public final boolean f(Object obj, Object obj2) {
        int i = this.G0;
        if (i == 0) {
            Boolean bool = (Boolean) obj;
            Boolean bool2 = (Boolean) obj2;
            return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
        }
        if (i == 1 || i == 2) {
            return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
        }
        Boolean bool3 = (Boolean) obj;
        Boolean bool4 = (Boolean) obj2;
        return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
    }
}
