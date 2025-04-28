package com.bidease.org.prebid.mobile.rendering.networking.tracking;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONObject;

public class BideaseEvent {
    @Nullable
    public String ipv4;
    @Nullable
    public String ipv6;
    @Nullable
    public String uniqueId;
    @Nullable
    public String type;
    @Nullable
    public String bidId;
    public long duration;
    @Nullable
    public String requestId;
    public int status;
    @Nullable
    public String url;

    public String toJsonString() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("duration", duration);
            jsonObject.put("status", status);
            if (ipv4 != null) {
                jsonObject.put("ipv4", ipv4);
            }
            if (ipv6 != null) {
                jsonObject.put("ipv6", ipv6);
            }
            if (uniqueId != null) {
                jsonObject.put("unique_id", uniqueId);
            }
            if (type != null) {
                jsonObject.put("type", type);
            }
            if (bidId != null) {
                jsonObject.put("bid_id", bidId);
            }
            if (requestId != null) {
                jsonObject.put("request_id", requestId);
            }
            if (url != null) {
                jsonObject.put("url", url);
            }
            jsonArray.put(jsonObject);
        } catch (Throwable ignored) {}
        return jsonArray.toString();
    }
}
