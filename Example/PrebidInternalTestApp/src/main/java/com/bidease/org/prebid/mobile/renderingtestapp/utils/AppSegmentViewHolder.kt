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

package com.bidease.org.prebid.mobile.renderingtestapp.utils

import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import segmented_control.widget.custom.android.com.segmentedcontrol.custom_segment.SegmentViewHolderImpl

class AppSegmentViewHolder(
        sectionView: View) : SegmentViewHolderImpl(sectionView) {
    init {
        if (sectionView is ViewGroup) {
            for (i in 0 until sectionView.childCount) {
                val childAt = sectionView.getChildAt(i)
                if (childAt is TextView) {
                    childAt.ellipsize = TextUtils.TruncateAt.END
                    childAt.maxLines = 1
                }
            }
        }
    }
}
