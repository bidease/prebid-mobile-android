/*
 *    Copyright 2018-2019 Prebid.org, Inc.
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
package com.bidease.org.prebid.mobile.prebidkotlindemo.activities.ads.inapp

import android.os.Bundle
import com.bidease.org.prebid.mobile.AdSize
import com.bidease.org.prebid.mobile.api.rendering.BannerView
import com.bidease.org.prebid.mobile.prebidkotlindemo.activities.BaseAdActivity

class InAppDisplayBannerMraidExpandActivity : BaseAdActivity() {

    companion object {
        const val CONFIG_ID = "prebid-demo-mraid-expand-1-part"
        const val WIDTH = 320
        const val HEIGHT = 50
    }

    private var adView: BannerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createAd()
    }

    private fun createAd() {
        adView = BannerView(
            this,
            CONFIG_ID,
            AdSize(WIDTH, HEIGHT)
        )

        adWrapperView.addView(adView)
        adView?.setAutoRefreshDelay(refreshTimeSeconds)
        adView?.loadAd()
    }


    override fun onDestroy() {
        super.onDestroy()
        adView?.destroy()
    }

}
