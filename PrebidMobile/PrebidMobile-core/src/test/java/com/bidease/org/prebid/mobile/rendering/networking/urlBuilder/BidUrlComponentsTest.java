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

package com.bidease.org.prebid.mobile.rendering.networking.urlBuilder;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.bidease.org.prebid.mobile.rendering.models.openrtb.BidRequest;
import com.bidease.org.prebid.mobile.rendering.networking.parameters.AdRequestInput;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 19)
public class BidUrlComponentsTest {

    @Test
    public void whenGetQueryArgString_ReturnBidRequestJson() throws JSONException {
        AdRequestInput adRequestInput = new AdRequestInput();
        BidRequest mockBidRequest = mock(BidRequest.class);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("test", "test");

        when(mockBidRequest.getJsonObject()).thenReturn(jsonObject);
        adRequestInput.setBidRequest(mockBidRequest);

        BidUrlComponents bidUrlComponents = new BidUrlComponents("", adRequestInput);
        assertEquals(jsonObject.toString(), bidUrlComponents.getQueryArgString());
    }
}