package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b extends CursorAdapter {
    public final int b;
    public final int c;
    public final /* synthetic */ AlertController.RecycleListView d;
    public final /* synthetic */ AlertController f;
    public final /* synthetic */ AlertController.b g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AlertController.b bVar, Context context, Cursor cursor, AlertController.RecycleListView recycleListView, AlertController alertController) {
        super(context, cursor, false);
        this.g = bVar;
        this.d = recycleListView;
        this.f = alertController;
        Cursor cursor2 = getCursor();
        bVar.getClass();
        this.b = cursor2.getColumnIndexOrThrow(null);
        this.c = cursor2.getColumnIndexOrThrow(null);
    }

    @Override // android.widget.CursorAdapter
    public final void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.b));
        this.d.setItemChecked(cursor.getPosition(), cursor.getInt(this.c) == 1);
    }

    @Override // android.widget.CursorAdapter
    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.g.b.inflate(this.f.L, viewGroup, false);
    }
}
