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

package com.bidease.org.prebid.mobile.api.mediation;

import android.app.Activity;
import android.content.Context;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.bidease.org.prebid.mobile.AdSize;
import com.bidease.org.prebid.mobile.PrebidMobile;
import com.bidease.org.prebid.mobile.api.data.AdFormat;
import com.bidease.org.prebid.mobile.api.data.BannerAdPosition;
import com.bidease.org.prebid.mobile.configuration.AdUnitConfiguration;
import com.bidease.org.prebid.mobile.rendering.bidding.config.MockMediationUtils;
import com.bidease.org.prebid.mobile.rendering.bidding.loader.BidLoader;
import com.bidease.org.prebid.mobile.rendering.utils.broadcast.ScreenStateReceiver;
import com.bidease.org.prebid.mobile.test.utils.WhiteBox;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.EnumSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 19)
public class MediationBannerAdUnitTest {

    private Context context;
    private MediationBannerAdUnit mediationBannerAdUnit;
    @Mock
    private ScreenStateReceiver mockScreenStateReceiver;
    @Mock
    private BidLoader mockBidLoader;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        context = Robolectric.buildActivity(Activity.class).create().get();
        PrebidMobile.setPrebidServerAccountId("id");
        mediationBannerAdUnit = new MediationBannerAdUnit(context, "config", mock(AdSize.class), new MockMediationUtils());

        WhiteBox.setInternalState(mediationBannerAdUnit, "bidLoader", mockBidLoader);
        WhiteBox.setInternalState(mediationBannerAdUnit, "screenStateReceiver", mockScreenStateReceiver);

        assertEquals(BannerAdPosition.UNDEFINED.getValue(), mediationBannerAdUnit.getAdPosition().getValue());
    }

    @After
    public void cleanup() {
        PrebidMobile.setPrebidServerAccountId(null);
    }

    @Test
    public void whenInitAdConfig_PrepareAdConfigForBanner() {
        AdSize adSize = new AdSize(1, 2);
        mediationBannerAdUnit.initAdConfig("config", adSize);
        AdUnitConfiguration adConfiguration = mediationBannerAdUnit.adUnitConfig;
        assertEquals("config", adConfiguration.getConfigId());
        assertEquals(EnumSet.of(AdFormat.BANNER), adConfiguration.getAdFormats());
        assertTrue(adConfiguration.getSizes().contains(adSize));
    }

    @Test
    public void whenSetRefreshInterval_ChangeRefreshIntervalInAdConfig() {
        assertEquals(30_000, mediationBannerAdUnit.adUnitConfig.getAutoRefreshDelay());
        mediationBannerAdUnit.setRefreshInterval(15);
        assertEquals(30_000, mediationBannerAdUnit.adUnitConfig.getAutoRefreshDelay());
    }

    @Test
    public void whenDestroy_UnregisterReceiver() {
        mediationBannerAdUnit.destroy();

        verify(mockScreenStateReceiver, times(1)).unregister();
    }

    @Test
    public void whenStopRefresh_BidLoaderCancelRefresh() {
        mediationBannerAdUnit.stopRefresh();

        verify(mockBidLoader, times(1)).cancelRefresh();
    }

    @Test
    public void setAdPosition_EqualsGetAdPosition() {
        mediationBannerAdUnit.setAdPosition(null);
        assertEquals(BannerAdPosition.UNDEFINED, mediationBannerAdUnit.getAdPosition());

        mediationBannerAdUnit.setAdPosition(BannerAdPosition.FOOTER);
        assertEquals(BannerAdPosition.FOOTER, mediationBannerAdUnit.getAdPosition());

        mediationBannerAdUnit.setAdPosition(BannerAdPosition.HEADER);
        assertEquals(BannerAdPosition.HEADER, mediationBannerAdUnit.getAdPosition());

        mediationBannerAdUnit.setAdPosition(BannerAdPosition.SIDEBAR);
        assertEquals(BannerAdPosition.SIDEBAR, mediationBannerAdUnit.getAdPosition());

        mediationBannerAdUnit.setAdPosition(BannerAdPosition.UNKNOWN);
        assertEquals(BannerAdPosition.UNKNOWN, mediationBannerAdUnit.getAdPosition());
    }

}