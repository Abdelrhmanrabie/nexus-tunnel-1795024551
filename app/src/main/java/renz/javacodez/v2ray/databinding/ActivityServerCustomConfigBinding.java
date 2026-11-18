package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import com.blacksquircle.ui.editorkit.widget.TextProcessor;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityServerCustomConfigBinding {
    public final TextProcessor editor;
    public final EditText etRemarks;
    private final ScrollView rootView;

    private ActivityServerCustomConfigBinding(ScrollView scrollView, TextProcessor textProcessor, EditText editText) {
        this.rootView = scrollView;
        this.editor = textProcessor;
        this.etRemarks = editText;
    }

    public static ActivityServerCustomConfigBinding bind(View view) {
        int i = R.id.editor;
        TextProcessor textProcessor = (TextProcessor) e.p(view, i);
        if (textProcessor != null) {
            i = R.id.et_remarks;
            EditText editText = (EditText) e.p(view, i);
            if (editText != null) {
                return new ActivityServerCustomConfigBinding((ScrollView) view, textProcessor, editText);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityServerCustomConfigBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityServerCustomConfigBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_server_custom_config, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
