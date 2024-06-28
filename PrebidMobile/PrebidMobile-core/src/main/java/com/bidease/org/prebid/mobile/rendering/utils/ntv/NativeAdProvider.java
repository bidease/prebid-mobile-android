package com.bidease.org.prebid.mobile.rendering.utils.ntv;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bidease.org.prebid.mobile.LogUtil;
import com.bidease.org.prebid.mobile.NativeAdUnit;
import com.bidease.org.prebid.mobile.PrebidNativeAd;
import com.bidease.org.prebid.mobile.rendering.bidding.events.EventsNotifier;

public class NativeAdProvider {

    private static final String TAG = "NativeAdProvider";

    @Nullable
    public static PrebidNativeAd getNativeAd(@NonNull Bundle extras) {
        String cacheId = extras.getString(NativeAdUnit.BUNDLE_KEY_CACHE_ID);

        if (cacheId == null || cacheId.isEmpty()) {
            LogUtil.error(TAG, "Cache id is null, can't get native ad.");
            return null;
        }

        PrebidNativeAd nativeAd = PrebidNativeAd.create(cacheId);
        if (nativeAd == null) {
            LogUtil.error(TAG, "PrebidNativeAd is null");
            return null;
        }
        EventsNotifier.notify(nativeAd.getWinEvent());

        return nativeAd;
    }

}
