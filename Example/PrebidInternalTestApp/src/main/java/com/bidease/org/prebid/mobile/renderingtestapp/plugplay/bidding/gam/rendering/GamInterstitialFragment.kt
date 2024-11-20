/*
 *    Copyright 2018-2021 Prebid.org, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.bidease.org.prebid.mobile.renderingtestapp.plugplay.bidding.gam.rendering

import com.bidease.org.prebid.mobile.AdSize
import com.bidease.org.prebid.mobile.api.data.AdUnitFormat
import com.bidease.org.prebid.mobile.api.rendering.InterstitialAdUnit
import com.bidease.org.prebid.mobile.eventhandlers.GamInterstitialEventHandler
import com.bidease.org.prebid.mobile.renderingtestapp.plugplay.bidding.base.BaseBidInterstitialFragment
import com.bidease.org.prebid.mobile.renderingtestapp.utils.CommandLineArgumentParser
import java.util.*

open class GamInterstitialFragment : BaseBidInterstitialFragment() {
    override fun initInterstitialAd(adUnitFormat: AdUnitFormat, adUnitId: String?, configId: String?, width: Int, height: Int) {
        val interstitialEventHandler = GamInterstitialEventHandler(requireActivity(), adUnitId)
        interstitialAdUnit = if (adUnitFormat == AdUnitFormat.VIDEO) {
            InterstitialAdUnit(
                requireContext(),
                configId,
                EnumSet.of(adUnitFormat),
                interstitialEventHandler
            )
        }
        else {
            InterstitialAdUnit(
                requireContext(),
                configId,
                interstitialEventHandler
            ).apply {
                setMinSizePercentage(AdSize(width, height))
            }
        }

        interstitialAdUnit?.setInterstitialAdUnitListener(this)
        interstitialAdUnit?.let {
            CommandLineArgumentParser.addAdUnitSpecificData(it)
        }
    }
}