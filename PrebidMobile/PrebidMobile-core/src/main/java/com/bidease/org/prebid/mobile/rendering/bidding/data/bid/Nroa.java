package com.bidease.org.prebid.mobile.rendering.bidding.data.bid;

import androidx.annotation.NonNull;

public class Nroa {
    @NonNull
    private final String erid;

    public Nroa(@NonNull String erid) {
        this.erid = erid;
    }

    @NonNull
    public String getErid() {
        return erid;
    }
}
