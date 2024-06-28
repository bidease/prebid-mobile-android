# Save names for all Prebid classes
-keepnames class com.bidease.org.prebid.mobile.**
-keepnames interface com.bidease.org.prebid.mobile.**
-keepnames enum com.bidease.org.prebid.mobile.**

# Google Ad Manager and AdMob
-keep class com.bidease.org.prebid.mobile.PrebidNativeAd { *; }
-keep class com.google.android.gms.ads.admanager.AdManagerAdView { *; }
-keep class com.google.android.gms.ads.admanager.AdManagerAdRequest { *; }
-keep class com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder { *; }
-keep interface com.google.android.gms.ads.nativead.NativeCustomFormatAd { *; }
-keep interface com.google.android.gms.ads.formats.NativeCustomTemplateAd { *; }