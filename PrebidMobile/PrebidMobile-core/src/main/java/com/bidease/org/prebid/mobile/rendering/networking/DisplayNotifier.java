package com.bidease.org.prebid.mobile.rendering.networking;

import androidx.annotation.NonNull;

import com.bidease.org.prebid.mobile.rendering.networking.tracking.TrackingManager;

public class DisplayNotifier {
    @NonNull
    private final String bUrl;

    public DisplayNotifier(final @NonNull String bUrl) {
        this.bUrl = bUrl;
    }

    public void notifyDisplay() {
        TrackingManager.getInstance().fireEventTrackingURL(bUrl);
    }
}
