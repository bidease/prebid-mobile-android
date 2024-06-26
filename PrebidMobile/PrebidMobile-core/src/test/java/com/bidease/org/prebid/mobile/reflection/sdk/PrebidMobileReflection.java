package com.bidease.org.prebid.mobile.reflection.sdk;

import android.content.Context;

import org.mockito.Mockito;
import com.bidease.org.prebid.mobile.PrebidMobile;
import com.bidease.org.prebid.mobile.reflection.Reflection;
import com.bidease.org.prebid.mobile.rendering.sdk.InitializationNotifier;
import com.bidease.org.prebid.mobile.rendering.sdk.PrebidContextHolder;

public class PrebidMobileReflection {

    public static void setCustomStatusEndpoint(String url) {
        Reflection.setStaticVariableTo(PrebidMobile.class, "customStatusEndpoint", url);
    }

    public static String getCustomStatusEndpoint() {
        return Reflection.getStaticFieldOf(PrebidMobile.class, "customStatusEndpoint");
    }

    public static void setFlagsThatSdkIsInitialized() {
        Reflection.setStaticVariableTo(InitializationNotifier.class, "tasksCompletedSuccessfully", true);
        Reflection.setStaticVariableTo(InitializationNotifier.class, "initializationInProgress", false);
        PrebidContextHolder.setContext(Mockito.mock(Context.class));
    }

    public static void setFlagsThatSdkIsNotInitialized() {
        Reflection.setStaticVariableTo(InitializationNotifier.class, "tasksCompletedSuccessfully", false);
        Reflection.setStaticVariableTo(InitializationNotifier.class, "initializationInProgress", false);
        PrebidContextHolder.clearContext();
    }

}
