package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class lx0 extends ContextWrapper {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends ContextWrapper {
        public a(Context context) {
            super(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final Object getSystemService(String str) {
            if (!"window".equals(str)) {
                return super.getSystemService(str);
            }
            return new b(lx0.this, (WindowManager) getBaseContext().getSystemService(str));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements WindowManager {
        public final WindowManager b;

        public b(lx0 lx0Var, WindowManager windowManager) {
            this.b = windowManager;
        }

        @Override // android.view.ViewManager
        public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
            try {
                this.b.addView(view, layoutParams);
            } catch (WindowManager.BadTokenException e) {
                e.getMessage();
                int i = lx0.$r8$clinit;
            } catch (Throwable unused) {
            }
        }

        @Override // android.view.WindowManager
        public final Display getDefaultDisplay() {
            return this.b.getDefaultDisplay();
        }

        @Override // android.view.ViewManager
        public final void removeView(View view) {
            this.b.removeView(view);
        }

        @Override // android.view.WindowManager
        public final void removeViewImmediate(View view) {
            this.b.removeViewImmediate(view);
        }

        @Override // android.view.ViewManager
        public final void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
            this.b.updateViewLayout(view, layoutParams);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return new a(getBaseContext().getApplicationContext());
    }
}
