package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.d;
import defpackage.qd1;
import java.util.HashMap;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class TimePickerView extends ConstraintLayout implements TimePickerControls {
    public final ClockFaceView clockFace;
    public final ClockHandView clockHandView;
    public final Chip hourView;
    public final Chip minuteView;
    public MaterialTimePicker onDoubleTapListener;
    public TimePickerClockPresenter onPeriodChangeListener;
    public TimePickerClockPresenter onSelectionChangeListener;
    public final MaterialButtonToggleGroup toggle;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnDoubleTapListener {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnPeriodChangeListener {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnSelectionChange {
    }

    public TimePickerView(Context context) {
        this(context, null);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimePickerClockPresenter timePickerClockPresenter = TimePickerView.this.onSelectionChangeListener;
                if (timePickerClockPresenter != null) {
                    timePickerClockPresenter.setSelection(((Integer) view.getTag(R.attr.x0)).intValue(), true);
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.d5, this);
        this.clockFace = (ClockFaceView) findViewById(R.attr.q2);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.attr.q6);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.onButtonCheckedListeners.add(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.google.android.material.timepicker.TimePickerView.2
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public final void onButtonChecked(int i2, boolean z) {
                int i3 = i2 == R.attr.q5 ? 1 : 0;
                TimePickerClockPresenter timePickerClockPresenter = TimePickerView.this.onPeriodChangeListener;
                if (timePickerClockPresenter == null || !z) {
                    return;
                }
                timePickerClockPresenter.time.setPeriod(i3);
            }
        });
        Chip chip = (Chip) findViewById(R.attr.qa);
        this.minuteView = chip;
        Chip chip2 = (Chip) findViewById(R.attr.q8);
        this.hourView = chip2;
        this.clockHandView = (ClockHandView) findViewById(R.attr.q3);
        WeakHashMap weakHashMap = qd1.a;
        chip.setAccessibilityLiveRegion(2);
        chip2.setAccessibilityLiveRegion(2);
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.google.android.material.timepicker.TimePickerView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onDoubleTap(MotionEvent motionEvent) {
                MaterialTimePicker materialTimePicker = TimePickerView.this.onDoubleTapListener;
                if (materialTimePicker == null) {
                    return false;
                }
                materialTimePicker.inputMode = 1;
                materialTimePicker.updateInputMode(materialTimePicker.modeButton);
                TimePickerTextInputPresenter timePickerTextInputPresenter = materialTimePicker.timePickerTextInputPresenter;
                ChipTextInputComboView chipTextInputComboView = timePickerTextInputPresenter.minuteTextInput;
                TimeModel timeModel = timePickerTextInputPresenter.time;
                chipTextInputComboView.setChecked(timeModel.selection == 12);
                timePickerTextInputPresenter.hourTextInput.setChecked(timeModel.selection == 10);
                return true;
            }
        });
        View.OnTouchListener onTouchListener = new View.OnTouchListener(this) { // from class: com.google.android.material.timepicker.TimePickerView.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        chip.setOnTouchListener(onTouchListener);
        chip2.setOnTouchListener(onTouchListener);
        chip.setTag(R.attr.x0, 12);
        chip2.setTag(R.attr.x0, 10);
        chip.setOnClickListener(onClickListener);
        chip2.setOnClickListener(onClickListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateToggleConstraints();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            updateToggleConstraints();
        }
    }

    public final void updateToggleConstraints() {
        b.a aVar;
        if (this.toggle.getVisibility() == 0) {
            b bVar = new b();
            bVar.e(this);
            WeakHashMap weakHashMap = qd1.a;
            char c = getLayoutDirection() == 0 ? (char) 2 : (char) 1;
            Integer numValueOf = Integer.valueOf(R.attr.q1);
            HashMap map = bVar.e;
            if (map.containsKey(numValueOf) && (aVar = (b.a) map.get(Integer.valueOf(R.attr.q1))) != null) {
                b.C0008b c0008b = aVar.e;
                switch (c) {
                    case 1:
                        c0008b.j = -1;
                        c0008b.i = -1;
                        c0008b.G = -1;
                        c0008b.N = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                        break;
                    case 2:
                        c0008b.l = -1;
                        c0008b.k = -1;
                        c0008b.H = -1;
                        c0008b.P = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                        break;
                    case 3:
                        c0008b.n = -1;
                        c0008b.m = -1;
                        c0008b.I = 0;
                        c0008b.O = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                        break;
                    case 4:
                        c0008b.o = -1;
                        c0008b.p = -1;
                        c0008b.J = 0;
                        c0008b.Q = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                        break;
                    case 5:
                        c0008b.q = -1;
                        c0008b.r = -1;
                        c0008b.s = -1;
                        c0008b.M = 0;
                        c0008b.T = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                        break;
                    case 6:
                        c0008b.t = -1;
                        c0008b.u = -1;
                        c0008b.L = 0;
                        c0008b.S = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                        break;
                    case 7:
                        c0008b.v = -1;
                        c0008b.w = -1;
                        c0008b.K = 0;
                        c0008b.R = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                        break;
                    case '\b':
                        c0008b.C = -1.0f;
                        c0008b.B = -1;
                        c0008b.A = -1;
                        break;
                    default:
                        d.AnonymousClass0.m$2("unknown constraint");
                        return;
                }
            }
            bVar.c(this);
            this.mConstraintSet = null;
            requestLayout();
        }
    }
}
