package com.bidease.org.prebid.mobile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

public class CreativeResourceLoadingTracker {
    @Nullable
    private static CreativeResourceLoadingTracker instance;

    @NonNull
    public static CreativeResourceLoadingTracker getInstance() {
        CreativeResourceLoadingTracker localInstance = instance;
        if (localInstance == null) {
            synchronized (CreativeResourceLoadingTracker.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new CreativeResourceLoadingTracker();
                }
            }
        }
        return localInstance;
    }

    @Nullable
    private Handler handler = null;

    private CreativeResourceLoadingTracker() {}

    public void track(@NonNull Item item) {
        if (handler != null) {
            handler.process(item);
        }
    }

    public void registerHandler(@Nullable Handler handler) {
        this.handler = handler;
    }

    public interface Handler {
        void process(Item item);
    }

    public static class Item {
        @NonNull
        public final String bidId;
        public final int duration;
        @NonNull
        public final String requestId;
        public final int status;
        @NonNull
        public final String url;

        public Item(@NonNull String bidId, int duration, @NonNull String requestId, int status, @NonNull String url) {
            this.bidId = bidId;
            this.duration = duration;
            this.requestId = requestId;
            this.status = status;
            this.url = url;
        }

        @NonNull
        public JSONObject toJSONObject() {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("bid_id", bidId);
                jsonObject.put("duration", duration);
                jsonObject.put("request_id", requestId);
                jsonObject.put("status", status);
                jsonObject.put("url", url);
            } catch (JSONException ignored) {}
            return jsonObject;
        }
    }
}
