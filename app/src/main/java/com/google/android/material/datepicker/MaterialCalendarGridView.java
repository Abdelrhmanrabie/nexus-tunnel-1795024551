package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.google.android.material.internal.ViewUtils;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.a1;
import defpackage.ko0;
import defpackage.o1;
import defpackage.qd1;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {
    public final Calendar dayCompute;
    public final boolean nestedScrollable;

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dayCompute = UtcDates.getUtcCalendarOf(null);
        if (MaterialDatePicker.readMaterialCalendarStyleBoolean(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(org.hamotunnelplus.xyz.R.attr.ee);
            setNextFocusRightId(org.hamotunnelplus.xyz.R.attr.fq);
        }
        this.nestedScrollable = MaterialDatePicker.readMaterialCalendarStyleBoolean(getContext(), org.hamotunnelplus.xyz.R.style.vi);
        qd1.l(this, new a1(this) { // from class: com.google.android.material.datepicker.MaterialCalendarGridView.1
            @Override // defpackage.a1
            public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
                AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
                this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCollectionInfo(null);
            }
        });
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final Adapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((MonthAdapter) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int iDaysFromStartOfWeekToFirstOfMonth;
        int width;
        int iDaysFromStartOfWeekToFirstOfMonth2;
        int width2;
        int i;
        int width3;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter monthAdapter = (MonthAdapter) super.getAdapter();
        DateSelector dateSelector = monthAdapter.dateSelector;
        CalendarStyle calendarStyle = monthAdapter.calendarStyle;
        Month month = monthAdapter.month;
        int iDaysFromStartOfWeekToFirstOfMonth3 = month.daysFromStartOfWeekToFirstOfMonth();
        int i2 = month.daysInWeek;
        int iMax = Math.max(iDaysFromStartOfWeekToFirstOfMonth3, materialCalendarGridView.getFirstVisiblePosition());
        int iMin = Math.min(monthAdapter.lastPositionInMonth(), materialCalendarGridView.getLastVisiblePosition());
        Long item = monthAdapter.getItem(iMax);
        Long item2 = monthAdapter.getItem(iMin);
        Iterator it = dateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            ko0 ko0Var = (ko0) it.next();
            Object obj = ko0Var.a;
            if (obj != null) {
                Object obj2 = ko0Var.b;
                if (obj2 != null) {
                    Long l = (Long) obj;
                    long jLongValue = l.longValue();
                    Long l2 = (Long) obj2;
                    long jLongValue2 = l2.longValue();
                    if (item == null || item2 == null || l.longValue() > item2.longValue() || l2.longValue() < item.longValue()) {
                        materialCalendarGridView = this;
                        it = it;
                        month = month;
                        monthAdapter = monthAdapter;
                    } else {
                        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(materialCalendarGridView);
                        long jLongValue3 = item.longValue();
                        Iterator it2 = it;
                        Calendar calendar = materialCalendarGridView.dayCompute;
                        Month month2 = month;
                        if (jLongValue < jLongValue3) {
                            if (iMax % i2 == 0) {
                                width = 0;
                            } else {
                                View childAt = materialCalendarGridView.getChildAt((iMax - 1) - materialCalendarGridView.getFirstVisiblePosition());
                                width = !zIsLayoutRtl ? childAt.getRight() : childAt.getLeft();
                            }
                            iDaysFromStartOfWeekToFirstOfMonth = iMax;
                        } else {
                            calendar.setTimeInMillis(jLongValue);
                            iDaysFromStartOfWeekToFirstOfMonth = month2.daysFromStartOfWeekToFirstOfMonth() + (calendar.get(5) - 1);
                            View childAt2 = materialCalendarGridView.getChildAt(iDaysFromStartOfWeekToFirstOfMonth - materialCalendarGridView.getFirstVisiblePosition());
                            width = (childAt2.getWidth() / 2) + childAt2.getLeft();
                        }
                        if (jLongValue2 > item2.longValue()) {
                            if ((iMin + 1) % i2 == 0) {
                                width2 = materialCalendarGridView.getWidth();
                            } else {
                                View childAt3 = materialCalendarGridView.getChildAt(iMin - materialCalendarGridView.getFirstVisiblePosition());
                                width2 = !zIsLayoutRtl ? childAt3.getRight() : childAt3.getLeft();
                            }
                            iDaysFromStartOfWeekToFirstOfMonth2 = iMin;
                        } else {
                            calendar.setTimeInMillis(jLongValue2);
                            iDaysFromStartOfWeekToFirstOfMonth2 = month2.daysFromStartOfWeekToFirstOfMonth() + (calendar.get(5) - 1);
                            View childAt4 = materialCalendarGridView.getChildAt(iDaysFromStartOfWeekToFirstOfMonth2 - materialCalendarGridView.getFirstVisiblePosition());
                            width2 = (childAt4.getWidth() / 2) + childAt4.getLeft();
                        }
                        int itemId = (int) monthAdapter.getItemId(iDaysFromStartOfWeekToFirstOfMonth);
                        int itemId2 = (int) monthAdapter.getItemId(iDaysFromStartOfWeekToFirstOfMonth2);
                        while (itemId <= itemId2) {
                            int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                            MonthAdapter monthAdapter2 = monthAdapter;
                            int numColumns2 = (materialCalendarGridView.getNumColumns() + numColumns) - 1;
                            int i3 = width2;
                            View childAt5 = materialCalendarGridView.getChildAt(numColumns - materialCalendarGridView.getFirstVisiblePosition());
                            int top = childAt5.getTop() + calendarStyle.day.insets.top;
                            int bottom = childAt5.getBottom() - calendarStyle.day.insets.bottom;
                            if (zIsLayoutRtl) {
                                int i4 = iDaysFromStartOfWeekToFirstOfMonth2 > numColumns2 ? 0 : i3;
                                int width4 = numColumns > iDaysFromStartOfWeekToFirstOfMonth ? getWidth() : width;
                                i = i4;
                                width3 = width4;
                            } else {
                                i = numColumns > iDaysFromStartOfWeekToFirstOfMonth ? 0 : width;
                                width3 = iDaysFromStartOfWeekToFirstOfMonth2 > numColumns2 ? getWidth() : i3;
                            }
                            canvas.drawRect(i, top, width3, bottom, calendarStyle.rangeFill);
                            itemId++;
                            materialCalendarGridView = this;
                            monthAdapter = monthAdapter2;
                            width2 = i3;
                        }
                        materialCalendarGridView = this;
                        it = it2;
                        month = month2;
                    }
                }
            } else {
                materialCalendarGridView = this;
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        boolean z2;
        int iDaysFromStartOfWeekToFirstOfMonth;
        if (z) {
            if (i == 33) {
                iDaysFromStartOfWeekToFirstOfMonth = ((MonthAdapter) super.getAdapter()).lastPositionInMonth();
            } else if (i == 130) {
                iDaysFromStartOfWeekToFirstOfMonth = ((MonthAdapter) super.getAdapter()).month.daysFromStartOfWeekToFirstOfMonth();
            } else {
                z2 = true;
            }
            setSelection(iDaysFromStartOfWeekToFirstOfMonth);
            return;
        }
        z2 = false;
        super.onFocusChanged(z2, i, rect);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= ((MonthAdapter) super.getAdapter()).month.daysFromStartOfWeekToFirstOfMonth()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(((MonthAdapter) super.getAdapter()).month.daysFromStartOfWeekToFirstOfMonth());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i, int i2) {
        if (!this.nestedScrollable) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof MonthAdapter)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i) {
        if (i < ((MonthAdapter) super.getAdapter()).month.daysFromStartOfWeekToFirstOfMonth()) {
            i = ((MonthAdapter) super.getAdapter()).month.daysFromStartOfWeekToFirstOfMonth();
        }
        super.setSelection(i);
    }
}
