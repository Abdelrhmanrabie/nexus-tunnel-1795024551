package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.d;
import defpackage.md1;
import defpackage.qd1;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class MonthsPagerAdapter extends RecyclerView.g<ViewHolder> {
    public final CalendarConstraints calendarConstraints;
    public final Context context;
    public final DateSelector dateSelector;
    public final int itemHeight;
    public final MaterialCalendar.OnDayClickListener onDayClickListener;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class ViewHolder extends RecyclerView.d0 {
        public final MaterialCalendarGridView monthGrid;
        public final TextView monthTitle;

        public ViewHolder(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.attr.r_);
            this.monthTitle = textView;
            WeakHashMap weakHashMap = qd1.a;
            new md1(3).e(textView, Boolean.TRUE);
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(R.attr.r5);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public MonthsPagerAdapter(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, MaterialCalendar.OnDayClickListener onDayClickListener) {
        Month month = calendarConstraints.start;
        Month month2 = calendarConstraints.end;
        Month month3 = calendarConstraints.openAt;
        if (month.compareTo(month3) > 0) {
            d.AnonymousClass0.m$2("firstPage cannot be after currentPage");
            throw null;
        }
        if (month3.compareTo(month2) > 0) {
            d.AnonymousClass0.m$2("currentPage cannot be after lastPage");
            throw null;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.kl) * MonthAdapter.MAXIMUM_WEEKS;
        int dimensionPixelSize2 = MaterialDatePicker.readMaterialCalendarStyleBoolean(context, android.R.attr.windowFullscreen) ? context.getResources().getDimensionPixelSize(R.dimen.kl) : 0;
        this.context = context;
        this.itemHeight = dimensionPixelSize + dimensionPixelSize2;
        this.calendarConstraints = calendarConstraints;
        this.dateSelector = dateSelector;
        this.onDayClickListener = onDayClickListener;
        if (this.mObservable.a()) {
            d.AnonymousClass0.m("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            throw null;
        }
        this.mHasStableIds = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final int getItemCount() {
        return this.calendarConstraints.monthSpan;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final long getItemId(int i) {
        return this.calendarConstraints.start.monthsLater(i).firstOfMonth.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final void onBindViewHolder(RecyclerView.d0 d0Var, int i) {
        ViewHolder viewHolder = (ViewHolder) d0Var;
        CalendarConstraints calendarConstraints = this.calendarConstraints;
        Month monthMonthsLater = calendarConstraints.start.monthsLater(i);
        viewHolder.monthTitle.setText(monthMonthsLater.getLongName(viewHolder.itemView.getContext()));
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder.monthGrid.findViewById(R.attr.r5);
        if (materialCalendarGridView.getAdapter() == null || !monthMonthsLater.equals(materialCalendarGridView.getAdapter().month)) {
            MonthAdapter monthAdapter = new MonthAdapter(monthMonthsLater, this.dateSelector, calendarConstraints);
            materialCalendarGridView.setNumColumns(monthMonthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        } else {
            materialCalendarGridView.invalidate();
            MonthAdapter adapter = materialCalendarGridView.getAdapter();
            DateSelector dateSelector = adapter.dateSelector;
            Iterator it = adapter.previouslySelectedDates.iterator();
            while (it.hasNext()) {
                adapter.updateSelectedStateForDate(materialCalendarGridView, ((Long) it.next()).longValue());
            }
            if (dateSelector != null) {
                Iterator it2 = dateSelector.getSelectedDays().iterator();
                while (it2.hasNext()) {
                    adapter.updateSelectedStateForDate(materialCalendarGridView, ((Long) it2.next()).longValue());
                }
                adapter.previouslySelectedDates = dateSelector.getSelectedDays();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.datepicker.MonthsPagerAdapter.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                MaterialCalendarGridView materialCalendarGridView2 = materialCalendarGridView;
                MonthAdapter adapter2 = materialCalendarGridView2.getAdapter();
                if (i2 < adapter2.month.daysFromStartOfWeekToFirstOfMonth() || i2 > adapter2.lastPositionInMonth()) {
                    return;
                }
                MonthsPagerAdapter.this.onDayClickListener.onDayClick(materialCalendarGridView2.getAdapter().getItem(i2).longValue());
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.di, viewGroup, false);
        if (!MaterialDatePicker.readMaterialCalendarStyleBoolean(viewGroup.getContext(), android.R.attr.windowFullscreen)) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.p(-1, this.itemHeight));
        return new ViewHolder(linearLayout, true);
    }
}
