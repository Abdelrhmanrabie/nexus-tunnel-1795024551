package defpackage;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.e;
import androidx.lifecycle.i;
import androidx.lifecycle.m;

/* JADX INFO: renamed from: if, reason: invalid class name */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class Cif extends Activity implements he0, jb0$a {
    private final o01 extraDataMap = new o01();
    private final i lifecycleRegistry = new i(this);

    /* JADX INFO: renamed from: if$a */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class a {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (ak.a(decorView, keyEvent)) {
            return true;
        }
        return ak.b(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (ak.a(getWindow().getDecorView(), keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public <T extends a> T getExtraData(Class<T> cls) {
        if (this.extraDataMap.getOrDefault(cls, null) == null) {
            return null;
        }
        d.AnonymousClass0.m$1();
        return null;
    }

    public e getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = m.$r8$clinit;
        m.b.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        i iVar = this.lifecycleRegistry;
        e.b bVar = e.b.CREATED;
        iVar.e("setCurrentState");
        iVar.g(bVar);
        super.onSaveInstanceState(bundle);
    }

    public void putExtraData(a aVar) {
        this.extraDataMap.put(a.class, aVar);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0044  */
    /* JADX WARN: Code duplicated, block: B:36:0x005a  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean shouldDumpInternalState(String[] strArr) {
        boolean z = false;
        if (strArr != null && strArr.length != 0) {
            String str = strArr[0];
            switch (str.hashCode()) {
                case -645125871:
                    if (str.equals("--translation") && Build.VERSION.SDK_INT >= 31) {
                        z = true;
                    }
                    break;
                case 100470631:
                    if (str.equals("--dump-dumpable")) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            z = true;
                        }
                    }
                    break;
                case 472614934:
                    if (str.equals("--list-dumpables")) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            z = true;
                        }
                    }
                    break;
                case 1159329357:
                    if (str.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29) {
                        z = true;
                    }
                    break;
                case 1455016274:
                    if (str.equals("--autofill") && Build.VERSION.SDK_INT >= 26) {
                        z = true;
                    }
                    break;
            }
        }
        return !z;
    }

    @Override // defpackage.jb0$a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
