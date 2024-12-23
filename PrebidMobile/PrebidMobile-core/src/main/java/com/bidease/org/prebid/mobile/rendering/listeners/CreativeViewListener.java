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

package com.bidease.org.prebid.mobile.rendering.listeners;

import android.view.ViewGroup;
import com.bidease.org.prebid.mobile.rendering.models.AbstractCreative;

public interface CreativeViewListener {
    /**
     * Is called when creative finish its lifecycle.
     *
     * @param creative
     */
    void creativeDidComplete(AbstractCreative creative);

    /**
     * Is called when ad's content is rendered in the displayed view.
     * @param creative
     * @param url
     */
    void creativeWasClicked(AbstractCreative creative, String url);

    /**
     * Is called when user closes the creatives clickthrough.
     * @param creative
     */
    void creativeInterstitialDidClose(AbstractCreative creative);

    void creativeDidExpand(AbstractCreative creative);  // MRAID banner only

    void creativeDidCollapse(AbstractCreative creative);    // MRAID banner only

    void creativeInterstitialDialogShown(ViewGroup rootViewGroup);

    void creativeMuted(AbstractCreative creative);

    void creativeUnMuted(AbstractCreative creative);

    void creativePaused(AbstractCreative creative);

    void creativeResumed(AbstractCreative creative);

    void creativeInterstitialShouldOpenStore(AbstractCreative creative);

    boolean creativeShouldTriggerClickOnClose();
}
