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

package com.bidease.org.prebid.mobile.rendering.models.openrtb.bidRequests.imps;

import androidx.annotation.VisibleForTesting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.bidease.org.prebid.mobile.rendering.models.openrtb.bidRequests.BaseBid;
import com.bidease.org.prebid.mobile.rendering.models.openrtb.bidRequests.imps.pmps.Format;

import java.util.HashSet;

public class Banner extends BaseBid {

    public Integer pos = null;
    public int[] api;
    public int w;
    public int h;

    private HashSet<Format> formats = new HashSet<>();

    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = new JSONObject();

        if (w != 0 && h != 0) {
            toJSON(jsonObject, "w", this.w);
            toJSON(jsonObject, "h", this.h);
        }

        toJSON(jsonObject, "pos", this.pos);

        if (api != null) {
            JSONArray jsonArray = new JSONArray();
            for (int apiItem : api) {
                jsonArray.put(apiItem);
            }
            toJSON(jsonObject, "api", jsonArray);
        }

        if (formats.size() > 0) {
            JSONArray formatsArray = new JSONArray();
            for (Format format : formats) {
                formatsArray.put(format.getJsonObject());
            }
            toJSON(jsonObject, "format", formatsArray);
        }

        return jsonObject;
    }

    public void addFormat(int w, int h) {
        formats.add(new Format(w, h));
    }

    @VisibleForTesting
    public HashSet<Format> getFormats() {
        return formats;
    }
}
