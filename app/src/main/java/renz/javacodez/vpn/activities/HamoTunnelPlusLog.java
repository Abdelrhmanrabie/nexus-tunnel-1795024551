package renz.javacodez.vpn.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.fb$1;
import defpackage.uh;
import defpackage.z2;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.vpn.service.RenzOpenVPNservice;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class HamoTunnelPlusLog extends d implements AdapterView.OnItemLongClickListener {
    public RecyclerView j;
    public ArrayList<RenzOpenVPNservice.j> n;
    public z2 o;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView.o oVar;
            HamoTunnelPlusLog hamoTunnelPlusLog = HamoTunnelPlusLog.this;
            if (hamoTunnelPlusLog.n.size() > 0) {
                RecyclerView recyclerView = hamoTunnelPlusLog.j;
                int size = hamoTunnelPlusLog.n.size() - 1;
                if (recyclerView.mLayoutSuppressed || (oVar = recyclerView.mLayout) == null) {
                    return;
                }
                oVar.smoothScrollToPosition(recyclerView, size);
            }
        }
    }

    @Override // renz.javacodez.vpn.activities.d
    public final void B() {
        RenzOpenVPNservice renzOpenVPNservice = this.b;
        ArrayDeque<RenzOpenVPNservice.j> arrayDeque = renzOpenVPNservice != null ? renzOpenVPNservice.o : null;
        if (arrayDeque != null) {
            Iterator<RenzOpenVPNservice.j> it = arrayDeque.iterator();
            while (it.hasNext()) {
                this.n.add(it.next());
                this.o.notifyDataSetChanged();
            }
        }
    }

    public final void K() {
        if (this.n.size() > 0) {
            this.n.clear();
            RenzOpenVPNservice renzOpenVPNservice = this.b;
            ArrayDeque<RenzOpenVPNservice.j> arrayDeque = renzOpenVPNservice != null ? renzOpenVPNservice.o : null;
            if (arrayDeque != null) {
                arrayDeque.clear();
            }
            this.o.notifyDataSetChanged();
            H("Log Deleted!");
        }
    }

    @Override // renz.javacodez.vpn.activities.d, renz.javacodez.vpn.service.RenzOpenVPNservice.g
    public final void a(RenzOpenVPNservice.f fVar) {
        if (fVar.j == R.string.mz) {
            this.n.clear();
            this.o.notifyDataSetChanged();
        }
    }

    @Override // renz.javacodez.vpn.activities.d, renz.javacodez.vpn.service.RenzOpenVPNservice.g
    public final void d(RenzOpenVPNservice.j jVar) {
        if (this.n.size() > 50 && !jVar.a.contains("CONNECTED")) {
            K();
        }
        this.n.add(jVar);
        this.o.notifyDataSetChanged();
        this.j.postDelayed(new a(), 1000L);
    }

    @Override // renz.javacodez.vpn.activities.d, androidx.fragment.app.n, androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.co);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.attr.pl);
        this.j = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.j.mHasFixedSize = true;
        ArrayList<RenzOpenVPNservice.j> arrayList = new ArrayList<>();
        this.n = arrayList;
        z2 z2Var = new z2(arrayList);
        this.o = z2Var;
        this.j.setAdapter(z2Var);
        bindService(new Intent(this, (Class<?>) RenzOpenVPNservice.class).setAction(uh.a(-4153964395806L)), this.c, 65);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.d, menu);
        return true;
    }

    @Override // defpackage.w4, androidx.fragment.app.n, android.app.Activity
    public final void onDestroy() {
        u();
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.n.size() <= 0) {
            return true;
        }
        ((ClipboardManager) getSystemService("clipboard")).setText(fb$1.m(new StringBuilder(), this.n.get(i).a, "\n"));
        H("Log Copied!");
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.attr.qm) {
            StringBuilder sb = new StringBuilder();
            if (this.n.size() > 0) {
                Iterator<RenzOpenVPNservice.j> it = this.n.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().a + "\n");
                }
            }
            ((ClipboardManager) getSystemService("clipboard")).setText(sb.toString());
            H("Log Copied!");
        } else if (itemId == R.attr.qo) {
            K();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
