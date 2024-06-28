package com.bidease.org.prebid.mobile.rendering.listeners;

import org.jetbrains.annotations.NotNull;
import com.bidease.org.prebid.mobile.api.data.InitializationStatus;
import com.bidease.org.prebid.mobile.api.exceptions.InitError;

public interface SdkInitializationListener {

    void onInitializationComplete(@NotNull InitializationStatus status);

    @Deprecated
    default void onSdkInit() {
    }

    @Deprecated
    default void onSdkFailedToInit(InitError error) {
    }

}
