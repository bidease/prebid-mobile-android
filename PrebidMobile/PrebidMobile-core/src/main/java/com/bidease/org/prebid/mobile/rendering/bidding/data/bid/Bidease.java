package com.bidease.org.prebid.mobile.rendering.bidding.data.bid;

import androidx.annotation.Nullable;

public class Bidease {
    @Nullable
    private final String clickTarget;

    public Bidease(final @Nullable String clickTarget) {
        this.clickTarget = clickTarget;
    }

    @Nullable
    public String getClickTarget() {
        return clickTarget;
    }
}
