package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.m;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import defpackage.ak;
import defpackage.e;
import defpackage.qd1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialTimePicker extends m implements TimePickerView.OnDoubleTapListener {
    public Object activePresenter;
    public Button cancelButton;
    public int clockIcon;
    public int keyboardIcon;
    public MaterialButton modeButton;
    public CharSequence negativeButtonText;
    public CharSequence positiveButtonText;
    public ViewStub textInputStub;
    public TimeModel time;
    public TimePickerClockPresenter timePickerClockPresenter;
    public TimePickerTextInputPresenter timePickerTextInputPresenter;
    public TimePickerView timePickerView;
    public CharSequence titleText;
    public final LinkedHashSet positiveButtonListeners = new LinkedHashSet();
    public final LinkedHashSet negativeButtonListeners = new LinkedHashSet();
    public final LinkedHashSet cancelListeners = new LinkedHashSet();
    public final LinkedHashSet dismissListeners = new LinkedHashSet();
    public int titleResId = 0;
    public int positiveButtonTextResId = 0;
    public int negativeButtonTextResId = 0;
    public int inputMode = 0;
    public int overrideThemeResId = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Builder {
        public Builder() {
            new TimeModel();
        }
    }

    @Override // androidx.fragment.app.m, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.cancelListeners.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.m, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
        this.time = timeModel;
        if (timeModel == null) {
            this.time = new TimeModel();
        }
        this.inputMode = bundle.getInt("TIME_PICKER_INPUT_MODE", 0);
        this.titleResId = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
        this.titleText = bundle.getCharSequence("TIME_PICKER_TITLE_TEXT");
        this.positiveButtonTextResId = bundle.getInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", 0);
        this.positiveButtonText = bundle.getCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT");
        this.negativeButtonTextResId = bundle.getInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", 0);
        this.negativeButtonText = bundle.getCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT");
        this.overrideThemeResId = bundle.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", 0);
    }

    @Override // androidx.fragment.app.m
    public final Dialog onCreateDialog() {
        Context contextRequireContext = requireContext();
        int i = this.overrideThemeResId;
        if (i == 0) {
            TypedValue typedValueResolve = MaterialAttributes.resolve(requireContext(), R.style.tn);
            i = typedValueResolve == null ? 0 : typedValueResolve.data;
        }
        Dialog dialog = new Dialog(contextRequireContext, i);
        Context context = dialog.getContext();
        int iResolveOrThrow = MaterialAttributes.resolveOrThrow(context, R.style.gx, MaterialTimePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R.style.tm, R.plurals.a3b);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, com.google.android.material.R.styleable.MaterialTimePicker, R.style.tm, R.plurals.a3b);
        this.clockIcon = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.keyboardIcon = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(iResolveOrThrow));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        View decorView = window.getDecorView();
        WeakHashMap weakHashMap = qd1.a;
        materialShapeDrawable.setElevation(decorView.getElevation());
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.d6, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R.attr.qh);
        this.timePickerView = timePickerView;
        timePickerView.onDoubleTapListener = this;
        this.textInputStub = (ViewStub) viewGroup2.findViewById(R.attr.qb);
        this.modeButton = (MaterialButton) viewGroup2.findViewById(R.attr.qf);
        TextView textView = (TextView) viewGroup2.findViewById(R.attr.m5);
        int i = this.titleResId;
        if (i != 0) {
            textView.setText(i);
        } else if (!TextUtils.isEmpty(this.titleText)) {
            textView.setText(this.titleText);
        }
        updateInputMode(this.modeButton);
        Button button = (Button) viewGroup2.findViewById(R.attr.qg);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                Iterator it = materialTimePicker.positiveButtonListeners.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                materialTimePicker.dismissInternal(false, false);
            }
        });
        int i2 = this.positiveButtonTextResId;
        if (i2 != 0) {
            button.setText(i2);
        } else if (!TextUtils.isEmpty(this.positiveButtonText)) {
            button.setText(this.positiveButtonText);
        }
        Button button2 = (Button) viewGroup2.findViewById(R.attr.qc);
        this.cancelButton = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                Iterator it = materialTimePicker.negativeButtonListeners.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                materialTimePicker.dismissInternal(false, false);
            }
        });
        int i3 = this.negativeButtonTextResId;
        if (i3 != 0) {
            this.cancelButton.setText(i3);
        } else if (!TextUtils.isEmpty(this.negativeButtonText)) {
            this.cancelButton.setText(this.negativeButtonText);
        }
        Button button3 = this.cancelButton;
        if (button3 != null) {
            button3.setVisibility(this.mCancelable ? 0 : 8);
        }
        this.modeButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                materialTimePicker.inputMode = materialTimePicker.inputMode == 0 ? 1 : 0;
                materialTimePicker.updateInputMode(materialTimePicker.modeButton);
            }
        });
        return viewGroup2;
    }

    @Override // androidx.fragment.app.m, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.activePresenter = null;
        this.timePickerClockPresenter = null;
        this.timePickerTextInputPresenter = null;
        TimePickerView timePickerView = this.timePickerView;
        if (timePickerView != null) {
            timePickerView.onDoubleTapListener = null;
            this.timePickerView = null;
        }
    }

    @Override // androidx.fragment.app.m, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.dismissListeners.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.m, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.time);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.inputMode);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.titleResId);
        bundle.putCharSequence("TIME_PICKER_TITLE_TEXT", this.titleText);
        bundle.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", this.positiveButtonTextResId);
        bundle.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", this.positiveButtonText);
        bundle.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", this.negativeButtonTextResId);
        bundle.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", this.negativeButtonText);
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.overrideThemeResId);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.google.android.material.timepicker.TimePickerPresenter, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.material.timepicker.TimePickerPresenter, java.lang.Object] */
    public final void updateInputMode(MaterialButton materialButton) {
        TimePickerPresenter timePickerPresenter;
        Pair pair;
        TimePickerClockPresenter timePickerClockPresenter;
        if (materialButton == null || this.timePickerView == null || this.textInputStub == null) {
            return;
        }
        ?? r0 = this.activePresenter;
        if (r0 != 0) {
            r0.hide();
        }
        int i = this.inputMode;
        TimePickerView timePickerView = this.timePickerView;
        ViewStub viewStub = this.textInputStub;
        if (i == 0) {
            TimePickerClockPresenter timePickerClockPresenter2 = this.timePickerClockPresenter;
            if (timePickerClockPresenter2 == null) {
                timePickerClockPresenter = timePickerClockPresenter2;
                timePickerClockPresenter = new TimePickerClockPresenter(timePickerView, this.time);
            }
            timePickerClockPresenter = timePickerClockPresenter2;
            this.timePickerClockPresenter = timePickerClockPresenter;
            timePickerPresenter = timePickerClockPresenter;
        } else {
            if (this.timePickerTextInputPresenter == null) {
                this.timePickerTextInputPresenter = new TimePickerTextInputPresenter((LinearLayout) viewStub.inflate(), this.time);
            }
            TimePickerTextInputPresenter timePickerTextInputPresenter = this.timePickerTextInputPresenter;
            timePickerTextInputPresenter.minuteTextInput.setChecked(false);
            timePickerTextInputPresenter.hourTextInput.setChecked(false);
            timePickerPresenter = this.timePickerTextInputPresenter;
        }
        this.activePresenter = timePickerPresenter;
        timePickerPresenter.show();
        this.activePresenter.invalidate();
        int i2 = this.inputMode;
        if (i2 == 0) {
            pair = new Pair(Integer.valueOf(this.keyboardIcon), Integer.valueOf(R.string.hj));
        } else {
            if (i2 != 1) {
                throw new IllegalArgumentException(ak.h(i2, "no icon for mode: "));
            }
            pair = new Pair(Integer.valueOf(this.clockIcon), Integer.valueOf(R.string.he));
        }
        int iIntValue = ((Integer) pair.first).intValue();
        Drawable drawableS = iIntValue != 0 ? e.s(materialButton.getContext(), iIntValue) : null;
        if (materialButton.icon != drawableS) {
            materialButton.icon = drawableS;
            materialButton.updateIcon(true);
            materialButton.updateIconPosition(materialButton.getMeasuredWidth(), materialButton.getMeasuredHeight());
        }
        materialButton.setContentDescription(getResources().getString(((Integer) pair.second).intValue()));
        materialButton.sendAccessibilityEvent(4);
    }
}
