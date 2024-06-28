package com.bidease.org.prebid.mobile.reflection.sdk;

import com.bidease.org.prebid.mobile.reflection.Reflection;
import com.bidease.org.prebid.mobile.rendering.sdk.ManagersResolver;

public class ManagersResolverReflection {

    public static void resetManagers(ManagersResolver resolver) {
        Reflection.setVariableTo(resolver, "deviceManager", null);
        Reflection.setVariableTo(resolver, "locationManager", null);
        Reflection.setVariableTo(resolver, "connectionManager", null);
        Reflection.setVariableTo(resolver, "userConsentManager", null);
    }

}
