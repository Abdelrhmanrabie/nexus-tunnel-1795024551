package renz.javacodez.vpn.activities;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import defpackage.w4;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ExceptionActivity extends w4 {
    @Override // androidx.fragment.app.n, androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        setContentView(linearLayout);
        ScrollView scrollView = new ScrollView(this);
        TextView textView = new TextView(this);
        scrollView.addView(textView);
        linearLayout.addView(scrollView);
        textView.setText(getIntent().getStringExtra("error"));
    }
}
