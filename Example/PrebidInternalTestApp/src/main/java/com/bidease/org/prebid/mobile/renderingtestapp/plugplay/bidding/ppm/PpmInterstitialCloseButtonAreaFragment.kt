package com.bidease.org.prebid.mobile.renderingtestapp.plugplay.bidding.ppm

import com.bidease.org.prebid.mobile.api.data.AdUnitFormat
import com.bidease.org.prebid.mobile.api.rendering.InterstitialAdUnit
import com.bidease.org.prebid.mobile.renderingtestapp.plugplay.bidding.base.BaseBidInterstitialFragment
import com.bidease.org.prebid.mobile.api.data.Position
import java.util.*

class PpmInterstitialCloseButtonAreaFragment : BaseBidInterstitialFragment() {

    override fun initInterstitialAd(
        adUnitFormat: AdUnitFormat,
        adUnitId: String?,
        configId: String?,
        width: Int,
        height: Int
    ) {
        interstitialAdUnit = if (adUnitFormat == AdUnitFormat.VIDEO) {
            InterstitialAdUnit(
                requireContext(),
                configId,
                EnumSet.of(adUnitFormat)
            )
        } else {
            InterstitialAdUnit(requireContext(), configId)
        }
        interstitialAdUnit?.setInterstitialAdUnitListener(this)
        interstitialAdUnit?.setCloseButtonArea(0.40)
        interstitialAdUnit?.setCloseButtonPosition(Position.TOP_LEFT)
    }

}