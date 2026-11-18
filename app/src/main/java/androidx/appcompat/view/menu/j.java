package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface j {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface a {
        boolean a(f fVar);

        void onCloseMenu(f fVar, boolean z);
    }

    boolean collapseItemActionView(h hVar);

    boolean expandItemActionView(h hVar);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, f fVar);

    void onCloseMenu(f fVar, boolean z);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(m mVar);

    void setCallback(a aVar);

    void updateMenuView(boolean z);
}
