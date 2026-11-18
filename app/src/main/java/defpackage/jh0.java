package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.c;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class jh0 extends se0 {
    public static final Method J;
    public b.c I;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends jp {
        public final int t;
        public final int u;
        public jh0 v;
        public h w;

        public a(Context context, boolean z) {
            super(context, z);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.t = 21;
                this.u = 22;
            } else {
                this.t = 22;
                this.u = 21;
            }
        }

        @Override // defpackage.jp, android.view.View
        public final boolean onHoverEvent(MotionEvent motionEvent) {
            e eVar;
            int headersCount;
            b.c cVar;
            b.c cVar2;
            int iPointToPosition;
            int i;
            if (this.v != null) {
                ListAdapter adapter = getAdapter();
                int i2 = 0;
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    eVar = (e) headerViewListAdapter.getWrappedAdapter();
                } else {
                    eVar = (e) adapter;
                    headersCount = 0;
                }
                h item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= eVar.getCount()) ? null : eVar.getItem(i);
                h hVar = this.w;
                if (hVar != item) {
                    f fVar = eVar.b;
                    if (hVar != null && (cVar2 = this.v.I) != null) {
                        b.this.j.removeCallbacksAndMessages(fVar);
                    }
                    this.w = item;
                    if (item != null && (cVar = this.v.I) != null) {
                        b bVar = b.this;
                        bVar.j.removeCallbacksAndMessages(null);
                        ArrayList arrayList = bVar.o;
                        int size = arrayList.size();
                        while (true) {
                            if (i2 >= size) {
                                i2 = -1;
                                break;
                            }
                            if (fVar == ((b.d) arrayList.get(i2)).b) {
                                break;
                            }
                            i2++;
                        }
                        if (i2 != -1) {
                            int i3 = i2 + 1;
                            bVar.j.postAtTime(new c(cVar, i3 < arrayList.size() ? (b.d) arrayList.get(i3) : null, item, fVar), fVar, SystemClock.uptimeMillis() + 200);
                        }
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public final boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.t) {
                if (listMenuItemView.isEnabled() && listMenuItemView.b.hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i != this.u) {
                return super.onKeyDown(i, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((e) adapter).b.close(false);
            return true;
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                J = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    @Override // defpackage.se0
    public final jp o(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.v = this;
        return aVar;
    }
}
