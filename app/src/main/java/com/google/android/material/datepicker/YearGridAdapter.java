package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class YearGridAdapter extends RecyclerView.g<ViewHolder> {
    public final MaterialCalendar materialCalendar;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class ViewHolder extends RecyclerView.d0 {
        public final TextView textView;

        public ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }

    public YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.materialCalendar = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final int getItemCount() {
        return this.materialCalendar.calendarConstraints.yearSpan;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final void onBindViewHolder(RecyclerView.d0 d0Var, int i) {
        MaterialCalendar materialCalendar = this.materialCalendar;
        final int i2 = materialCalendar.calendarConstraints.start.year + i;
        TextView textView = ((ViewHolder) d0Var).textView;
        String string = textView.getContext().getString(R.string.j4);
        textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        textView.setContentDescription(String.format(string, Integer.valueOf(i2)));
        CalendarStyle calendarStyle = materialCalendar.calendarStyle;
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        CalendarItemStyle calendarItemStyle = todayCalendar.get(1) == i2 ? calendarStyle.todayYear : calendarStyle.year;
        Iterator it = materialCalendar.dateSelector.getSelectedDays().iterator();
        while (it.hasNext()) {
            todayCalendar.setTimeInMillis(((Long) it.next()).longValue());
            if (todayCalendar.get(1) == i2) {
                calendarItemStyle = calendarStyle.selectedYear;
            }
        }
        calendarItemStyle.styleItem(textView);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.YearGridAdapter.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YearGridAdapter yearGridAdapter = YearGridAdapter.this;
                Month monthCreate = Month.create(i2, yearGridAdapter.materialCalendar.current.month);
                CalendarConstraints calendarConstraints = yearGridAdapter.materialCalendar.calendarConstraints;
                Month month = calendarConstraints.end;
                Month month2 = calendarConstraints.start;
                if (monthCreate.compareTo(month2) < 0) {
                    monthCreate = month2;
                } else if (monthCreate.compareTo(month) > 0) {
                    monthCreate = month;
                }
                yearGridAdapter.materialCalendar.setCurrentMonth(monthCreate);
                yearGridAdapter.materialCalendar.setSelector(MaterialCalendar.CalendarSelector.DAY);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dm, viewGroup, false));
    }
}
