package com.bidease.org.prebid.mobile.reflection;

import com.bidease.org.prebid.mobile.AdUnit;
import com.bidease.org.prebid.mobile.rendering.bidding.loader.BidLoader;

public class AdUnitReflection {

    public static void setBidLoader(AdUnit adUnit, BidLoader bidLoader) {
        Reflection.setVariableTo(adUnit, "bidLoader", bidLoader);
    }

}
