package com.google.android.material.datepicker;

import android.R;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a0;
import androidx.recyclerview.widget.w;
import com.google.android.material.button.MaterialButton;
import defpackage.a1;
import defpackage.d;
import defpackage.ko0;
import defpackage.o1;
import defpackage.qd1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {
    public CalendarConstraints calendarConstraints;
    public CalendarSelector calendarSelector;
    public CalendarStyle calendarStyle;
    public Month current;
    public DateSelector dateSelector;
    public View dayFrame;
    public RecyclerView recyclerView;
    public int themeResId;
    public View yearFrame;
    public RecyclerView yearSelector;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public enum CalendarSelector {
        DAY,
        YEAR
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnDayClickListener {
        void onDayClick(long j);
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public final void addOnSelectionChangedListener(OnSelectionChangedListener onSelectionChangedListener) {
        this.onSelectionChangedListeners.add(onSelectionChangedListener);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.themeResId = bundle.getInt("THEME_RES_ID_KEY");
        this.dateSelector = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.current = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int i2;
        w wVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new CalendarStyle(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.calendarConstraints.start;
        if (MaterialDatePicker.readMaterialCalendarStyleBoolean(contextThemeWrapper, R.attr.windowFullscreen)) {
            i = org.hamotunnelplus.xyz.R.layout.dl;
            i2 = 1;
        } else {
            i = org.hamotunnelplus.xyz.R.layout.dg;
            i2 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(org.hamotunnelplus.xyz.R.dimen.l5) + resources.getDimensionPixelOffset(org.hamotunnelplus.xyz.R.dimen.l7) + resources.getDimensionPixelSize(org.hamotunnelplus.xyz.R.dimen.l6);
        int dimensionPixelSize = resources.getDimensionPixelSize(org.hamotunnelplus.xyz.R.dimen.kq);
        int i3 = MonthAdapter.MAXIMUM_WEEKS;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(org.hamotunnelplus.xyz.R.dimen.l4) * (i3 - 1)) + (resources.getDimensionPixelSize(org.hamotunnelplus.xyz.R.dimen.kl) * i3) + resources.getDimensionPixelOffset(org.hamotunnelplus.xyz.R.dimen.ki));
        GridView gridView = (GridView) viewInflate.findViewById(org.hamotunnelplus.xyz.R.attr.rd);
        qd1.l(gridView, new a1(this) { // from class: com.google.android.material.datepicker.MaterialCalendar.1
            @Override // defpackage.a1
            public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
                AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
                this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCollectionInfo(null);
            }
        });
        gridView.setAdapter((ListAdapter) new DaysOfWeekAdapter());
        gridView.setNumColumns(month.daysInWeek);
        gridView.setEnabled(false);
        this.recyclerView = (RecyclerView) viewInflate.findViewById(org.hamotunnelplus.xyz.R.attr.rg);
        final int i4 = i2;
        this.recyclerView.setLayoutManager(new SmoothCalendarLayoutManager(getContext(), i2, false) { // from class: com.google.android.material.datepicker.MaterialCalendar.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            public final void calculateExtraLayoutSpace(RecyclerView.a0 a0Var, int[] iArr) {
                int i5 = i4;
                MaterialCalendar materialCalendar = MaterialCalendar.this;
                if (i5 == 0) {
                    iArr[0] = materialCalendar.recyclerView.getWidth();
                    iArr[1] = materialCalendar.recyclerView.getWidth();
                } else {
                    iArr[0] = materialCalendar.recyclerView.getHeight();
                    iArr[1] = materialCalendar.recyclerView.getHeight();
                }
            }
        });
        this.recyclerView.setTag("MONTHS_VIEW_GROUP_TAG");
        final MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.dateSelector, this.calendarConstraints, new OnDayClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.3
            @Override // com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener
            public final void onDayClick(long j) {
                MaterialCalendar materialCalendar = MaterialCalendar.this;
                if (materialCalendar.calendarConstraints.validator.isValid(j)) {
                    materialCalendar.dateSelector.select(j);
                    Iterator it = materialCalendar.onSelectionChangedListeners.iterator();
                    while (it.hasNext()) {
                        ((OnSelectionChangedListener) it.next()).onSelectionChanged(materialCalendar.dateSelector.getSelection());
                    }
                    materialCalendar.recyclerView.mAdapter.notifyDataSetChanged();
                    RecyclerView recyclerView3 = materialCalendar.yearSelector;
                    if (recyclerView3 != null) {
                        recyclerView3.mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
        this.recyclerView.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(org.hamotunnelplus.xyz.R.integer.ae);
        RecyclerView recyclerView3 = (RecyclerView) viewInflate.findViewById(org.hamotunnelplus.xyz.R.attr.rj);
        this.yearSelector = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.mHasFixedSize = true;
            recyclerView3.setLayoutManager(new GridLayoutManager(contextThemeWrapper, integer));
            this.yearSelector.setAdapter(new YearGridAdapter(this));
            this.yearSelector.addItemDecoration(new RecyclerView.n() { // from class: com.google.android.material.datepicker.MaterialCalendar.4
                public final Calendar startItem = UtcDates.getUtcCalendarOf(null);
                public final Calendar endItem = UtcDates.getUtcCalendarOf(null);

                @Override // androidx.recyclerview.widget.RecyclerView.n
                public final void onDraw(Canvas canvas, RecyclerView recyclerView4) {
                    Object obj;
                    RecyclerView.g gVar = recyclerView4.mAdapter;
                    if (gVar instanceof YearGridAdapter) {
                        RecyclerView.o oVar = recyclerView4.mLayout;
                        if (oVar instanceof GridLayoutManager) {
                            MaterialCalendar materialCalendar = ((YearGridAdapter) gVar).materialCalendar;
                            GridLayoutManager gridLayoutManager = (GridLayoutManager) oVar;
                            MaterialCalendar materialCalendar2 = MaterialCalendar.this;
                            for (ko0 ko0Var : materialCalendar2.dateSelector.getSelectedRanges()) {
                                Object obj2 = ko0Var.a;
                                if (obj2 != null && (obj = ko0Var.b) != null) {
                                    long jLongValue = ((Long) obj2).longValue();
                                    Calendar calendar = this.startItem;
                                    calendar.setTimeInMillis(jLongValue);
                                    long jLongValue2 = ((Long) obj).longValue();
                                    Calendar calendar2 = this.endItem;
                                    calendar2.setTimeInMillis(jLongValue2);
                                    int i5 = calendar.get(1) - materialCalendar.calendarConstraints.start.year;
                                    int i6 = calendar2.get(1) - materialCalendar.calendarConstraints.start.year;
                                    View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i5);
                                    View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(i6);
                                    int i7 = gridLayoutManager.b;
                                    int i8 = i5 / i7;
                                    int i9 = i6 / i7;
                                    int i10 = i8;
                                    while (i10 <= i9) {
                                        View viewFindViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.b * i10);
                                        if (viewFindViewByPosition3 != null) {
                                            canvas.drawRect(i10 == i8 ? (viewFindViewByPosition.getWidth() / 2) + viewFindViewByPosition.getLeft() : 0, viewFindViewByPosition3.getTop() + materialCalendar2.calendarStyle.year.insets.top, i10 == i9 ? (viewFindViewByPosition2.getWidth() / 2) + viewFindViewByPosition2.getLeft() : recyclerView4.getWidth(), viewFindViewByPosition3.getBottom() - materialCalendar2.calendarStyle.year.insets.bottom, materialCalendar2.calendarStyle.rangeFill);
                                        }
                                        i10++;
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
        if (viewInflate.findViewById(org.hamotunnelplus.xyz.R.attr.r7) != null) {
            final MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(org.hamotunnelplus.xyz.R.attr.r7);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            qd1.l(materialButton, new a1() { // from class: com.google.android.material.datepicker.MaterialCalendar.5
                @Override // defpackage.a1
                public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, o1Var.a);
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    o1Var.m(materialCalendar.getString(materialCalendar.dayFrame.getVisibility() == 0 ? org.hamotunnelplus.xyz.R.string.jk : org.hamotunnelplus.xyz.R.string.ji));
                }
            });
            MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(org.hamotunnelplus.xyz.R.attr.r9);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(org.hamotunnelplus.xyz.R.attr.r8);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.yearFrame = viewInflate.findViewById(org.hamotunnelplus.xyz.R.attr.rj);
            this.dayFrame = viewInflate.findViewById(org.hamotunnelplus.xyz.R.attr.rc);
            setSelector(CalendarSelector.DAY);
            materialButton.setText(this.current.getLongName(viewInflate.getContext()));
            this.recyclerView.addOnScrollListener(new RecyclerView.t() { // from class: com.google.android.material.datepicker.MaterialCalendar.6
                @Override // androidx.recyclerview.widget.RecyclerView.t
                public final void onScrollStateChanged(RecyclerView recyclerView4, int i5) {
                    if (i5 == 0) {
                        recyclerView4.announceForAccessibility(materialButton.getText());
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.t
                public final void onScrolled(RecyclerView recyclerView4, int i5, int i6) {
                    int iFindLastVisibleItemPosition;
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) materialCalendar.recyclerView.mLayout;
                    if (i5 < 0) {
                        View viewFindOneVisibleChild = linearLayoutManager.findOneVisibleChild(0, linearLayoutManager.getChildCount(), false);
                        iFindLastVisibleItemPosition = viewFindOneVisibleChild == null ? -1 : RecyclerView.o.getPosition(viewFindOneVisibleChild);
                    } else {
                        iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    }
                    MonthsPagerAdapter monthsPagerAdapter2 = monthsPagerAdapter;
                    materialCalendar.current = monthsPagerAdapter2.calendarConstraints.start.monthsLater(iFindLastVisibleItemPosition);
                    materialButton.setText(monthsPagerAdapter2.calendarConstraints.start.monthsLater(iFindLastVisibleItemPosition).getLongName(monthsPagerAdapter2.context));
                }
            });
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    CalendarSelector calendarSelector = materialCalendar.calendarSelector;
                    CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
                    if (calendarSelector == calendarSelector2) {
                        materialCalendar.setSelector(CalendarSelector.DAY);
                    } else if (calendarSelector == CalendarSelector.DAY) {
                        materialCalendar.setSelector(calendarSelector2);
                    }
                }
            });
            materialButton3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) materialCalendar.recyclerView.mLayout;
                    View viewFindOneVisibleChild = linearLayoutManager.findOneVisibleChild(0, linearLayoutManager.getChildCount(), false);
                    int position = (viewFindOneVisibleChild == null ? -1 : RecyclerView.o.getPosition(viewFindOneVisibleChild)) + 1;
                    if (position < materialCalendar.recyclerView.mAdapter.getItemCount()) {
                        materialCalendar.setCurrentMonth(monthsPagerAdapter.calendarConstraints.start.monthsLater(position));
                    }
                }
            });
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    int iFindLastVisibleItemPosition = ((LinearLayoutManager) materialCalendar.recyclerView.mLayout).findLastVisibleItemPosition() - 1;
                    if (iFindLastVisibleItemPosition >= 0) {
                        materialCalendar.setCurrentMonth(monthsPagerAdapter.calendarConstraints.start.monthsLater(iFindLastVisibleItemPosition));
                    }
                }
            });
        }
        if (!MaterialDatePicker.readMaterialCalendarStyleBoolean(contextThemeWrapper, R.attr.windowFullscreen) && (recyclerView2 = (wVar = new w()).a) != (recyclerView = this.recyclerView)) {
            a0.a aVar = wVar.b;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.mScrollListeners;
                if (arrayList != null) {
                    arrayList.remove(aVar);
                }
                wVar.a.mOnFlingListener = null;
            }
            wVar.a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.mOnFlingListener != null) {
                    d.AnonymousClass0.m("An instance of OnFlingListener already set.");
                    return null;
                }
                recyclerView.addOnScrollListener(aVar);
                wVar.a.mOnFlingListener = wVar;
                new Scroller(wVar.a.getContext(), new DecelerateInterpolator());
                wVar.b();
            }
        }
        this.recyclerView.scrollToPosition(monthsPagerAdapter.calendarConstraints.start.monthsUntil(this.current));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.themeResId);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.current);
    }

    public final void setCurrentMonth(Month month) {
        int i;
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.recyclerView.mAdapter;
        final int iMonthsUntil = monthsPagerAdapter.calendarConstraints.start.monthsUntil(month);
        int iMonthsUntil2 = iMonthsUntil - monthsPagerAdapter.calendarConstraints.start.monthsUntil(this.current);
        boolean z = Math.abs(iMonthsUntil2) > 3;
        boolean z2 = iMonthsUntil2 > 0;
        this.current = month;
        if (!z || !z2) {
            if (z) {
                i = iMonthsUntil + 3;
            }
            this.recyclerView.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.10
                @Override // java.lang.Runnable
                public final void run() {
                    RecyclerView.o oVar;
                    RecyclerView recyclerView = MaterialCalendar.this.recyclerView;
                    if (recyclerView.mLayoutSuppressed || (oVar = recyclerView.mLayout) == null) {
                        return;
                    }
                    oVar.smoothScrollToPosition(recyclerView, iMonthsUntil);
                }
            });
        }
        i = iMonthsUntil - 3;
        this.recyclerView.scrollToPosition(i);
        this.recyclerView.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.10
            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView.o oVar;
                RecyclerView recyclerView = MaterialCalendar.this.recyclerView;
                if (recyclerView.mLayoutSuppressed || (oVar = recyclerView.mLayout) == null) {
                    return;
                }
                oVar.smoothScrollToPosition(recyclerView, iMonthsUntil);
            }
        });
    }

    public final void setSelector(CalendarSelector calendarSelector) {
        this.calendarSelector = calendarSelector;
        if (calendarSelector != CalendarSelector.YEAR) {
            if (calendarSelector == CalendarSelector.DAY) {
                this.yearFrame.setVisibility(8);
                this.dayFrame.setVisibility(0);
                setCurrentMonth(this.current);
                return;
            }
            return;
        }
        RecyclerView recyclerView = this.yearSelector;
        recyclerView.mLayout.scrollToPosition(this.current.year - ((YearGridAdapter) recyclerView.mAdapter).materialCalendar.calendarConstraints.start.year);
        this.yearFrame.setVisibility(0);
        this.dayFrame.setVisibility(8);
    }
}
