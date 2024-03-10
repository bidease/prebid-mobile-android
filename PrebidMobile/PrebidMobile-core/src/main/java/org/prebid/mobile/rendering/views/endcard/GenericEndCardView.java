package org.prebid.mobile.rendering.views.endcard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.prebid.mobile.core.R;

public class GenericEndCardView extends FrameLayout {
    @NonNull
    private ImageView closeImageView;

    @NonNull
    private ImageView skipImageView;

    @NonNull
    private ImageView appIconImageView;

    @NonNull
    private TextView appNamTextView;

    @NonNull
    private Button getButton;

    public GenericEndCardView(@NonNull Context context) {
        super(context);
        init();
    }

    public GenericEndCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GenericEndCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lyt_generic_end_card, this);
        closeImageView = findViewById(R.id.iv_close_interstitial);
        skipImageView = findViewById(R.id.iv_skip);
        appIconImageView = findViewById(R.id.app_icon);
        appNamTextView = findViewById(R.id.app_name);
        getButton = findViewById(R.id.get_button);
    }

    public void setCloseButtonVisible(boolean visible) {
        closeImageView.setVisibility(visible ? VISIBLE : GONE);
    }

    public void setSkipButtonVisible(boolean visible) {
        skipImageView.setVisibility(visible ? VISIBLE : GONE);
    }

    public void setAppIcon(@Nullable Drawable appIconDrawable) {
        appIconImageView.setImageDrawable(appIconDrawable);
    }

    public void setAppName(@Nullable String appName) {
        appNamTextView.setText(appName);
    }

    public void setOnCloseClick(@Nullable Runnable onCloseClick) {
        if (onCloseClick == null) {
            closeImageView.setOnClickListener(null);
            return;
        }
        closeImageView.setOnClickListener(view -> onCloseClick.run());
    }

    public void setOnSkipClick(@Nullable Runnable onSkipClick) {
        if (onSkipClick == null) {
            skipImageView.setOnClickListener(null);
            return;
        }
        skipImageView.setOnClickListener(view -> onSkipClick.run());
    }

    public void setOnGetClick(@Nullable Runnable onGetClick) {
        if (onGetClick == null) {
            getButton.setOnClickListener(null);
            return;
        }
        getButton.setOnClickListener(view -> onGetClick.run());
    }
}
