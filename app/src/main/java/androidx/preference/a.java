package androidx.preference;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.fragment.app.m;
import defpackage.he0;
import defpackage.zp;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends m implements DialogInterface.OnClickListener {
    public DialogPreference b;
    public CharSequence c;
    public CharSequence d;
    public CharSequence f;
    public CharSequence g;
    public int i;
    public BitmapDrawable j;
    public int n;

    /* JADX INFO: renamed from: androidx.preference.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class C0021a {
    }

    public final DialogPreference a() {
        if (this.b == null) {
            this.b = (DialogPreference) ((DialogPreference.a) getTargetFragment()).findPreference(requireArguments().getString("key"));
        }
        return this.b;
    }

    public void b(View view) {
        int i;
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.g;
            if (TextUtils.isEmpty(charSequence)) {
                i = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i = 0;
            }
            if (viewFindViewById.getVisibility() != i) {
                viewFindViewById.setVisibility(i);
            }
        }
    }

    public abstract void c(boolean z);

    public void d(androidx.appcompat.app.e.a aVar) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.n = i;
    }

    @Override // androidx.fragment.app.m, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        BitmapDrawable bitmapDrawable;
        super.onCreate(bundle);
        he0 targetFragment = getTargetFragment();
        if (!(targetFragment instanceof DialogPreference.a)) {
            defpackage.d.AnonymousClass0.m("Target fragment must implement TargetFragment interface");
            return;
        }
        DialogPreference.a aVar = (DialogPreference.a) targetFragment;
        String string = requireArguments().getString("key");
        if (bundle != null) {
            this.c = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.d = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.g = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.i = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.j = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) aVar.findPreference(string);
        this.b = dialogPreference;
        this.c = dialogPreference.T;
        this.d = dialogPreference.W;
        this.f = dialogPreference.X;
        this.g = dialogPreference.U;
        this.i = dialogPreference.Y;
        Drawable drawable = dialogPreference.V;
        if (drawable == null || (drawable instanceof BitmapDrawable)) {
            bitmapDrawable = (BitmapDrawable) drawable;
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            bitmapDrawable = new BitmapDrawable(getResources(), bitmapCreateBitmap);
        }
        this.j = bitmapDrawable;
    }

    @Override // androidx.fragment.app.m
    public final Dialog onCreateDialog() {
        this.n = -2;
        androidx.appcompat.app.e.a aVar = new androidx.appcompat.app.e.a(requireContext());
        CharSequence charSequence = this.c;
        AlertController.b bVar = aVar.P;
        bVar.e = charSequence;
        bVar.d = this.j;
        aVar.setPositiveButton(this.d, this);
        bVar.k = this.f;
        bVar.m = this;
        requireContext();
        int i = this.i;
        View viewInflate = i != 0 ? getLayoutInflater().inflate(i, (ViewGroup) null) : null;
        if (viewInflate != null) {
            b(viewInflate);
            bVar.y = viewInflate;
            bVar.D = false;
        } else {
            bVar.g = this.g;
        }
        d(aVar);
        androidx.appcompat.app.e eVarCreate = aVar.create();
        if (this instanceof zp) {
            Window window = eVarCreate.getWindow();
            if (Build.VERSION.SDK_INT >= 30) {
                window.getDecorView().getWindowInsetsController().show(WindowInsets.Type.ime());
                return eVarCreate;
            }
            zp zpVar = (zp) this;
            zpVar.r = SystemClock.currentThreadTimeMillis();
            zpVar.f();
        }
        return eVarCreate;
    }

    @Override // androidx.fragment.app.m, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        c(this.n == -1);
    }

    @Override // androidx.fragment.app.m, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.c);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.d);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.g);
        bundle.putInt("PreferenceDialogFragment.layout", this.i);
        BitmapDrawable bitmapDrawable = this.j;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }
}
