package com.bidease.org.prebid.mobile.testutils;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONObject;
import com.bidease.org.prebid.mobile.api.rendering.PrebidMobileInterstitialControllerInterface;
import com.bidease.org.prebid.mobile.api.rendering.pluginrenderer.PluginEventListener;
import com.bidease.org.prebid.mobile.api.rendering.pluginrenderer.PrebidMobilePluginRenderer;
import com.bidease.org.prebid.mobile.configuration.AdUnitConfiguration;
import com.bidease.org.prebid.mobile.rendering.bidding.data.bid.BidResponse;
import com.bidease.org.prebid.mobile.rendering.bidding.display.InterstitialController;
import com.bidease.org.prebid.mobile.rendering.bidding.interfaces.InterstitialControllerListener;
import com.bidease.org.prebid.mobile.rendering.bidding.listeners.DisplayVideoListener;
import com.bidease.org.prebid.mobile.rendering.bidding.listeners.DisplayViewListener;

public class FakePrebidMobilePluginRenderer {
    public static PrebidMobilePluginRenderer getFakePrebidRenderer(
            InterstitialController mockInterstitialController,
            View mockBannerAdView,
            Boolean isSupportRenderingFor,
            String rendererName,
            String rendererVersion
    ) {
        return new PrebidMobilePluginRenderer() {
            @Override
            public String getName() { return rendererName; }

            @Override
            public String getVersion() { return rendererVersion; }

            @Nullable
            @Override
            public JSONObject getData() { return null; }

            @Override
            public void registerEventListener(PluginEventListener pluginEventListener, String listenerKey) { }

            @Override
            public void unregisterEventListener(String listenerKey) { }

            @Override
            public View createBannerAdView(
                    @NonNull Context context,
                    @NonNull DisplayViewListener displayViewListener,
                    @Nullable DisplayVideoListener displayVideoListener,
                    @NonNull AdUnitConfiguration adUnitConfiguration,
                    @NonNull BidResponse bidResponse
            ) {
                return mockBannerAdView;
            }

            @Override
            public PrebidMobileInterstitialControllerInterface createInterstitialController(
                    @NonNull Context context,
                    @NonNull InterstitialControllerListener interstitialControllerListener,
                    @NonNull AdUnitConfiguration adUnitConfiguration,
                    @NonNull BidResponse bidResponse
            ) {
                return mockInterstitialController;
            }

            @Override
            public boolean isSupportRenderingFor(AdUnitConfiguration adUnitConfiguration) {
                return isSupportRenderingFor;
            }
        };
    }
}
