package com.bidease.org.prebid.mobile.rendering.bidding.loader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bidease.org.prebid.mobile.api.data.AdFormat;
import com.bidease.org.prebid.mobile.configuration.AdUnitConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BidLoaderCache {
    @Nullable
    private static BidLoaderCache instance = null;

    @NonNull
    public static BidLoaderCache getInstance() {
        BidLoaderCache localInstance = instance;
        if (localInstance == null) {
            synchronized (BidLoaderCache.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new BidLoaderCache();
                }
            }
        }
        return localInstance;
    }

    @NonNull
    private final Map<String, String> cache = new ConcurrentHashMap<>();

    private BidLoaderCache() {}

    public void putResponse(final @NonNull AdUnitConfiguration adUnitConfiguration, final @NonNull String response) {
        for (String key : getKeys(adUnitConfiguration)) {
            cache.put(key, response);
        }
    }

    @Nullable
    public String getResponse(final @NonNull AdUnitConfiguration adUnitConfiguration) {
        for (String key : getKeys(adUnitConfiguration)) {
            if (cache.containsKey(key)) {
                return cache.get(key);
            }
        }
        return null;
    }

    public void removeResponse(final @NonNull AdUnitConfiguration adUnitConfiguration) {
        for (String key : getKeys(adUnitConfiguration)) {
            cache.remove(key);
        }
    }

    public void removeNativeResponses() {
        Set<String> keys = cache.keySet();
        for (String key : keys) {
            if (key.contains(AdFormat.NATIVE.toString())) {
                cache.remove(key);
            }
        }
    }

    @NonNull
    private List<String> getKeys(final @NonNull AdUnitConfiguration adUnitConfiguration) {
        List<String> keys = new ArrayList<>();
        for (AdFormat adFormat : adUnitConfiguration.getAdFormats()) {
            StringBuilder key = new StringBuilder(adFormat.toString());
            if (adUnitConfiguration.getImpTagId() != null) {
                key.append(adUnitConfiguration.getImpTagId());
            }
            key.append(key);
        }
        return keys;
    }
}
