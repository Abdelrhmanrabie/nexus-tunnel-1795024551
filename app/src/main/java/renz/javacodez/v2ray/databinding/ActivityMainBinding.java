package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.tabs.TabLayout;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityMainBinding {
    public final DrawerLayout drawerLayout;
    public final FloatingActionButton fab;
    public final FrameLayout fabProgressCircle;
    public final LinearLayout layoutTest;
    public final CoordinatorLayout mainContent;
    public final NavigationView navView;
    public final LinearProgressIndicator pbWaiting;
    public final RecyclerView recyclerView;
    private final DrawerLayout rootView;
    public final TabLayout tabGroup;
    public final Toolbar toolbar;
    public final TextView tvTestState;

    private ActivityMainBinding(DrawerLayout drawerLayout, DrawerLayout drawerLayout2, FloatingActionButton floatingActionButton, FrameLayout frameLayout, LinearLayout linearLayout, CoordinatorLayout coordinatorLayout, NavigationView navigationView, LinearProgressIndicator linearProgressIndicator, RecyclerView recyclerView, TabLayout tabLayout, Toolbar toolbar, TextView textView) {
        this.rootView = drawerLayout;
        this.drawerLayout = drawerLayout2;
        this.fab = floatingActionButton;
        this.fabProgressCircle = frameLayout;
        this.layoutTest = linearLayout;
        this.mainContent = coordinatorLayout;
        this.navView = navigationView;
        this.pbWaiting = linearProgressIndicator;
        this.recyclerView = recyclerView;
        this.tabGroup = tabLayout;
        this.toolbar = toolbar;
        this.tvTestState = textView;
    }

    public static ActivityMainBinding bind(View view) {
        DrawerLayout drawerLayout = (DrawerLayout) view;
        int i = R.id.fab;
        FloatingActionButton floatingActionButton = (FloatingActionButton) e.p(view, i);
        if (floatingActionButton != null) {
            i = R.id.fabProgressCircle;
            FrameLayout frameLayout = (FrameLayout) e.p(view, i);
            if (frameLayout != null) {
                i = R.id.layout_test;
                LinearLayout linearLayout = (LinearLayout) e.p(view, i);
                if (linearLayout != null) {
                    i = R.id.main_content;
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) e.p(view, i);
                    if (coordinatorLayout != null) {
                        i = R.id.nav_view;
                        NavigationView navigationView = (NavigationView) e.p(view, i);
                        if (navigationView != null) {
                            i = R.id.pb_waiting;
                            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) e.p(view, i);
                            if (linearProgressIndicator != null) {
                                i = R.id.recycler_view;
                                RecyclerView recyclerView = (RecyclerView) e.p(view, i);
                                if (recyclerView != null) {
                                    i = R.id.tab_group;
                                    TabLayout tabLayout = (TabLayout) e.p(view, i);
                                    if (tabLayout != null) {
                                        i = R.id.toolbar;
                                        Toolbar toolbar = (Toolbar) e.p(view, i);
                                        if (toolbar != null) {
                                            i = R.id.tv_test_state;
                                            TextView textView = (TextView) e.p(view, i);
                                            if (textView != null) {
                                                return new ActivityMainBinding(drawerLayout, drawerLayout, floatingActionButton, frameLayout, linearLayout, coordinatorLayout, navigationView, linearProgressIndicator, recyclerView, tabLayout, toolbar, textView);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public DrawerLayout getRoot() {
        return this.rootView;
    }
}
