package defpackage;

import androidx.activity.OnBackPressedDispatcher;
import java.util.ListIterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class nm0 extends oc0 implements nw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ OnBackPressedDispatcher b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ nm0(OnBackPressedDispatcher onBackPressedDispatcher, int i) {
        super(1);
        this.G0 = i;
        this.b = onBackPressedDispatcher;
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        int i = this.G0;
        OnBackPressedDispatcher onBackPressedDispatcher = this.b;
        Object obj2 = null;
        if (i != 0) {
            if (onBackPressedDispatcher.d == null) {
                z6 z6Var = onBackPressedDispatcher.c;
                ListIterator listIterator = z6Var.listIterator(z6Var.d);
                while (listIterator.hasPrevious()) {
                    Object objPrevious = listIterator.previous();
                    if (((mm0) objPrevious).a) {
                        obj2 = objPrevious;
                        break;
                    }
                }
            }
            return tb1.a;
        }
        z6 z6Var2 = onBackPressedDispatcher.c;
        ListIterator listIterator2 = z6Var2.listIterator(z6Var2.d);
        while (listIterator2.hasPrevious()) {
            Object objPrevious2 = listIterator2.previous();
            if (((mm0) objPrevious2).a) {
                obj2 = objPrevious2;
                break;
            }
        }
        mm0 mm0Var = (mm0) obj2;
        if (onBackPressedDispatcher.d != null) {
            onBackPressedDispatcher.b();
        }
        onBackPressedDispatcher.d = mm0Var;
        return tb1.a;
    }
}
