package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import androidx.core.widget.NestedScrollView;
import defpackage.b2;
import defpackage.ti0;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class AlertController {
    public NestedScrollView A;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final boolean O;
    public final c P;
    public final Context a;
    public final f b;
    public final Window c;
    public CharSequence e;
    public CharSequence f;
    public RecycleListView g;
    public View h;
    public int j;
    public int l;
    public Button o;
    public CharSequence p;
    public Message q;
    public Button s;
    public CharSequence t;
    public Message u;
    public Button w;
    public CharSequence x;
    public Message y;
    public boolean n = false;
    public int I = -1;
    public final a Q = new a();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class RecycleListView extends ListView {
        public final int b;
        public final int c;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b2.u);
            this.c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Message messageObtain;
            Message message;
            Message message2;
            AlertController alertController = AlertController.this;
            if ((view != alertController.o || (message2 = alertController.q) == null) && (view != alertController.s || (message2 = alertController.u) == null)) {
                messageObtain = (view != alertController.w || (message = alertController.y) == null) ? null : Message.obtain(message);
            } else {
                messageObtain = Message.obtain(message2);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            alertController.P.obtainMessage(1, alertController.b).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b {
        public int B;
        public boolean[] E;
        public boolean F;
        public boolean G;
        public ti0.a I;
        public final ContextThemeWrapper a;
        public final LayoutInflater b;
        public Drawable d;
        public CharSequence e;
        public View f;
        public CharSequence g;
        public CharSequence h;
        public DialogInterface.OnClickListener j;
        public CharSequence k;
        public DialogInterface.OnClickListener m;
        public DialogInterface.OnCancelListener r;
        public g t;
        public CharSequence[] u;
        public ListAdapter v;
        public DialogInterface.OnClickListener w;
        public View y;
        public int z;
        public boolean D = false;
        public int H = -1;
        public boolean q = true;

        public b(ContextThemeWrapper contextThemeWrapper) {
            this.a = contextThemeWrapper;
            this.b = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class c extends Handler {
        public final WeakReference a;

        public c(DialogInterface dialogInterface) {
            this.a = new WeakReference(dialogInterface);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.a.get(), message.what);
            } else {
                if (i != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class d extends ArrayAdapter<CharSequence> {
        public d(Context context, int i, CharSequence[] charSequenceArr) {
            super(context, i, R.id.text1, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, f fVar, Window window) {
        this.a = context;
        this.b = fVar;
        this.c = window;
        this.P = new c(fVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, b2.e, org.hamotunnelplus.xyz.R.style.ar, 0);
        this.J = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.K = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.N = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.O = typedArrayObtainStyledAttributes.getBoolean(6, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        fVar.getDelegate().t(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.P.obtainMessage(i, onClickListener) : null;
        if (i == -3) {
            this.x = charSequence;
            this.y = messageObtainMessage;
        } else if (i == -2) {
            this.t = charSequence;
            this.u = messageObtainMessage;
        } else if (i != -1) {
            defpackage.d.AnonymousClass0.m$2("Button does not exist");
        } else {
            this.p = charSequence;
            this.q = messageObtainMessage;
        }
    }
}
