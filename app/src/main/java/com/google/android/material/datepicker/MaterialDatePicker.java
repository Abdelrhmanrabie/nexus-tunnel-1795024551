package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.a;
import androidx.fragment.app.m;
import androidx.fragment.app.q;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import defpackage.d;
import defpackage.e;
import defpackage.qd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialDatePicker<S> extends m {
    public MaterialShapeDrawable background;
    public MaterialCalendar calendar;
    public CalendarConstraints calendarConstraints;
    public Button confirmButton;
    public DateSelector dateSelector;
    public boolean fullscreen;
    public TextView headerSelectionText;
    public CheckableImageButton headerToggleButton;
    public int inputMode;
    public int overrideThemeResId;
    public PickerFragment pickerFragment;
    public CharSequence titleText;
    public int titleTextResId;
    public final LinkedHashSet onPositiveButtonClickListeners = new LinkedHashSet();
    public final LinkedHashSet onNegativeButtonClickListeners = new LinkedHashSet();
    public final LinkedHashSet onCancelListeners = new LinkedHashSet();
    public final LinkedHashSet onDismissListeners = new LinkedHashSet();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Builder<S> {
        public final DateSelector dateSelector;

        private Builder(DateSelector<S> dateSelector) {
            this.dateSelector = dateSelector;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputMode {
    }

    public static int getPaddedPickerWidth(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.kj);
        int i = Month.current().daysInWeek;
        return ((i - 1) * resources.getDimensionPixelOffset(R.dimen.l3)) + (resources.getDimensionPixelSize(R.dimen.kp) * i) + (dimensionPixelOffset * 2);
    }

    public static boolean readMaterialCalendarStyleBoolean(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.style.t_, MaterialCalendar.class.getCanonicalName()), new int[]{i});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    public final DateSelector getDateSelector() {
        if (this.dateSelector == null) {
            this.dateSelector = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.dateSelector;
    }

    @Override // androidx.fragment.app.m, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.onCancelListeners.iterator();
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
        this.overrideThemeResId = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.dateSelector = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.titleTextResId = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.titleText = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.inputMode = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.m
    public final Dialog onCreateDialog() {
        Context contextRequireContext = requireContext();
        Context contextRequireContext2 = requireContext();
        int defaultThemeResId = this.overrideThemeResId;
        if (defaultThemeResId == 0) {
            defaultThemeResId = getDateSelector().getDefaultThemeResId(contextRequireContext2);
        }
        Dialog dialog = new Dialog(contextRequireContext, defaultThemeResId);
        Context context = dialog.getContext();
        this.fullscreen = readMaterialCalendarStyleBoolean(context, android.R.attr.windowFullscreen);
        int iResolveOrThrow = MaterialAttributes.resolveOrThrow(context, R.style.gx, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R.style.t_, R.plurals.a1t);
        this.background = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(context);
        this.background.setFillColor(ColorStateList.valueOf(iResolveOrThrow));
        MaterialShapeDrawable materialShapeDrawable2 = this.background;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap weakHashMap = qd1.a;
        materialShapeDrawable2.setElevation(decorView.getElevation());
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewFindViewById;
        LinearLayout.LayoutParams layoutParams;
        View viewInflate = layoutInflater.inflate(this.fullscreen ? R.layout.ds : R.layout.dr, viewGroup);
        Context context = viewInflate.getContext();
        if (this.fullscreen) {
            viewFindViewById = viewInflate.findViewById(R.attr.re);
            layoutParams = new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -2);
        } else {
            viewFindViewById = viewInflate.findViewById(R.attr.rf);
            layoutParams = new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -1);
        }
        viewFindViewById.setLayoutParams(layoutParams);
        TextView textView = (TextView) viewInflate.findViewById(R.attr.rq);
        this.headerSelectionText = textView;
        WeakHashMap weakHashMap = qd1.a;
        textView.setAccessibilityLiveRegion(1);
        this.headerToggleButton = (CheckableImageButton) viewInflate.findViewById(R.attr.rs);
        TextView textView2 = (TextView) viewInflate.findViewById(R.attr.rw);
        CharSequence charSequence = this.titleText;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.titleTextResId);
        }
        this.headerToggleButton.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.headerToggleButton;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, e.s(context, R.drawable.mc));
        stateListDrawable.addState(new int[0], e.s(context, R.drawable.me));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.headerToggleButton.setChecked(this.inputMode != 0);
        qd1.l(this.headerToggleButton, null);
        CheckableImageButton checkableImageButton2 = this.headerToggleButton;
        this.headerToggleButton.setContentDescription(checkableImageButton2.getContext().getString(checkableImageButton2.checked ? R.string.jh : R.string.jj));
        this.headerToggleButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                materialDatePicker.confirmButton.setEnabled(materialDatePicker.getDateSelector().isSelectionComplete());
                materialDatePicker.headerToggleButton.toggle();
                CheckableImageButton checkableImageButton3 = materialDatePicker.headerToggleButton;
                materialDatePicker.headerToggleButton.setContentDescription(checkableImageButton3.getContext().getString(checkableImageButton3.checked ? R.string.jh : R.string.jj));
                materialDatePicker.startPickerFragment();
            }
        });
        this.confirmButton = (Button) viewInflate.findViewById(R.attr.fq);
        boolean zIsSelectionComplete = getDateSelector().isSelectionComplete();
        Button button = this.confirmButton;
        if (zIsSelectionComplete) {
            button.setEnabled(true);
        } else {
            button.setEnabled(false);
        }
        this.confirmButton.setTag("CONFIRM_BUTTON_TAG");
        this.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                for (MaterialPickerOnPositiveButtonClickListener materialPickerOnPositiveButtonClickListener : materialDatePicker.onPositiveButtonClickListeners) {
                    materialDatePicker.getDateSelector().getClass();
                    materialPickerOnPositiveButtonClickListener.onPositiveButtonClick();
                }
                materialDatePicker.dismissInternal(false, false);
            }
        });
        Button button2 = (Button) viewInflate.findViewById(R.attr.ee);
        button2.setTag("CANCEL_BUTTON_TAG");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                Iterator it = materialDatePicker.onNegativeButtonClickListeners.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                materialDatePicker.dismissInternal(false, false);
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.m, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.onDismissListeners.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.m, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.overrideThemeResId);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.dateSelector);
        CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.calendarConstraints);
        Month month = this.calendar.current;
        if (month != null) {
            builder.openAt = Long.valueOf(month.timeInMillis);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", builder.validator);
        Month monthCreate = Month.create(builder.start);
        Month monthCreate2 = Month.create(builder.end);
        CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = builder.openAt;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(monthCreate, monthCreate2, dateValidator, l == null ? null : Month.create(l.longValue())));
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.titleTextResId);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.titleText);
    }

    @Override // androidx.fragment.app.m, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.fullscreen) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.background);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.kr);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.background, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
        }
        startPickerFragment();
    }

    @Override // androidx.fragment.app.m, androidx.fragment.app.Fragment
    public final void onStop() {
        this.pickerFragment.onSelectionChangedListeners.clear();
        super.onStop();
    }

    public final void startPickerFragment() {
        Context contextRequireContext = requireContext();
        int defaultThemeResId = this.overrideThemeResId;
        if (defaultThemeResId == 0) {
            defaultThemeResId = getDateSelector().getDefaultThemeResId(contextRequireContext);
        }
        DateSelector dateSelector = getDateSelector();
        CalendarConstraints calendarConstraints = this.calendarConstraints;
        MaterialCalendar materialCalendar = new MaterialCalendar();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", defaultThemeResId);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.openAt);
        materialCalendar.setArguments(bundle);
        this.calendar = materialCalendar;
        PickerFragment pickerFragment = materialCalendar;
        if (this.headerToggleButton.checked) {
            DateSelector dateSelector2 = getDateSelector();
            CalendarConstraints calendarConstraints2 = this.calendarConstraints;
            MaterialTextInputPicker materialTextInputPicker = new MaterialTextInputPicker();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", defaultThemeResId);
            bundle2.putParcelable("DATE_SELECTOR_KEY", dateSelector2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
            materialTextInputPicker.setArguments(bundle2);
            pickerFragment = materialTextInputPicker;
        }
        this.pickerFragment = pickerFragment;
        updateHeader();
        q childFragmentManager = getChildFragmentManager();
        childFragmentManager.getClass();
        a aVar = new a(childFragmentManager);
        aVar.d(R.attr.re, this.pickerFragment, null, 2);
        if (aVar.g) {
            d.AnonymousClass0.m("This transaction is already being added to the back stack");
            return;
        }
        aVar.h = false;
        aVar.q.z(aVar, false);
        this.pickerFragment.addOnSelectionChangedListener(new OnSelectionChangedListener<Object>() { // from class: com.google.android.material.datepicker.MaterialDatePicker.3
            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public final void onIncompleteSelectionChanged() {
                MaterialDatePicker.this.confirmButton.setEnabled(false);
            }

            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public final void onSelectionChanged(Object obj) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                materialDatePicker.updateHeader();
                materialDatePicker.confirmButton.setEnabled(materialDatePicker.getDateSelector().isSelectionComplete());
            }
        });
    }

    public final void updateHeader() {
        String selectionDisplayString = getDateSelector().getSelectionDisplayString(getContext());
        this.headerSelectionText.setContentDescription(String.format(getString(R.string.it), selectionDisplayString));
        this.headerSelectionText.setText(selectionDisplayString);
    }
}
