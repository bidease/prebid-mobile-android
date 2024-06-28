package com.bidease.org.prebid.mobile.rendering.sdk.scripts;

import com.bidease.org.prebid.mobile.rendering.loading.FileDownloadListener;

public interface DownloadListenerCreator {

    FileDownloadListener create(String filePath);

}