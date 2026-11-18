package com.google.android.material.tabs;

import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.e4;
import defpackage.fe1;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class TabLayoutMediator {
    public final TabConfigurationStrategy tabConfigurationStrategy;
    public final TabLayout tabLayout;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class PagerAdapterObserver extends RecyclerView.i {
        public PagerAdapterObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onChanged() {
            TabLayoutMediator.this.tabLayout.removeAllTabs();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeChanged() {
            TabLayoutMediator.this.tabLayout.removeAllTabs();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeChanged(int i, Preference preference) {
            TabLayoutMediator.this.tabLayout.removeAllTabs();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface TabConfigurationStrategy {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class TabLayoutOnPageChangeCallback extends e4 {
        public TabLayoutOnPageChangeCallback(TabLayout tabLayout) {
            new WeakReference(tabLayout);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
        public ViewPagerOnTabSelectedListener(fe1 fe1Var, boolean z) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(TabLayout.Tab tab) {
            throw null;
        }
    }

    public TabLayoutMediator(TabLayout tabLayout, fe1 fe1Var, TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, fe1Var, true, tabConfigurationStrategy);
    }

    public TabLayoutMediator(TabLayout tabLayout, fe1 fe1Var, boolean z, TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, fe1Var, z, true, tabConfigurationStrategy);
    }

    public TabLayoutMediator(TabLayout tabLayout, fe1 fe1Var, boolean z, boolean z2, TabConfigurationStrategy tabConfigurationStrategy) {
        this.tabLayout = tabLayout;
        this.tabConfigurationStrategy = tabConfigurationStrategy;
    }
}
