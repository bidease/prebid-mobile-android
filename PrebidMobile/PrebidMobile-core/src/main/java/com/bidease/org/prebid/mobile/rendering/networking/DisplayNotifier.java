package com.bidease.org.prebid.mobile.rendering.networking;

import android.util.Base64;

import androidx.annotation.NonNull;

import com.bidease.org.prebid.mobile.rendering.bidding.data.bid.Bid;
import com.bidease.org.prebid.mobile.rendering.models.internal.MacrosModel;
import com.bidease.org.prebid.mobile.rendering.networking.tracking.TrackingManager;
import com.bidease.org.prebid.mobile.rendering.utils.helpers.MacrosResolutionHelper;

import java.util.HashMap;
import java.util.Map;

public class DisplayNotifier {
    @NonNull
    private final String bUrl;

    public DisplayNotifier(final @NonNull String bUrl) {
        this.bUrl = bUrl;
    }

    public void notifyDisplay(final @NonNull String auctionMinToWin) {
        TrackingManager.getInstance().fireEventTrackingURL(substituteMacros(bUrl, auctionMinToWin));
    }

    private String substituteMacros(final @NonNull String url, final @NonNull String auctionMinToWin) {
        Map<String, MacrosModel> macrosModelMap = new HashMap<>();

        macrosModelMap.put(MacrosModel.MACROS_AUCTION_MIN_TO_WIN, new MacrosModel(auctionMinToWin));
        macrosModelMap.put(MacrosModel.MACROS_AUCTION_MINIMUM_BID_TO_WIN, new MacrosModel(auctionMinToWin));

        return MacrosResolutionHelper.resolveAuctionMacros(url, macrosModelMap);
    }
}
