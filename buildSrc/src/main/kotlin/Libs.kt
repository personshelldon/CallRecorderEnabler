@file:Suppress("InvalidPackageDeclaration")

internal object Libs {

    // Kotlin base
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val kotlinReflectLib = "org.jetbrains.kotlin:kotlin-reflect"
    // Annotation
    const val annotationLib = "androidx.annotation:annotation"
    // Core
    const val coreKtxLib = "androidx.core:core-ktx"
    // Activity
    const val activityLib = "androidx.activity:activity-ktx"
    // Fragment
    const val fragmentLib = "androidx.fragment:fragment-ktx"
    const val fragmentTestingLib = "androidx.fragment:fragment-testing"
    // Collections
    const val collectionsLib = "androidx.collection:collection-ktx"
    // Lifecycle
    const val lifecycleKapt = "androidx.lifecycle:lifecycle-compiler"
    const val lifecycleLib = "androidx.lifecycle:lifecycle-extensions"
    const val lifecycleReactiveLib = "androidx.lifecycle:lifecycle-reactivestreams-ktx"
    const val lifecycleTestLib = "androidx.arch.core:core-testing"
    // Coroutines
    const val kotlinCoroutinesCoreLib = "org.jetbrains.kotlinx:kotlinx-coroutines-core"
    const val kotlinCoroutinesAndroidLib = "org.jetbrains.kotlinx:kotlinx-coroutines-android"
    const val kotlinCoroutinesRxLib = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2"
    // Navigation
    const val navigationRuntimeLib = "androidx.navigation:navigation-runtime-ktx"
    const val navigationFragmentKtxLib = "androidx.navigation:navigation-fragment-ktx"
    const val navigationUiKtxLib = "androidx.navigation:navigation-ui-ktx"
    // Room
    const val roomKapt = "androidx.room:room-compiler"
    const val roomRuntimeLib = "androidx.room:room-runtime"
    const val roomKtxLib = "androidx.room:room-ktx"
    const val roomRxLib = "androidx.room:room-rxjava2"
    const val roomGuavaLib = "androidx.room:room-guava"
    const val roomTestLib = "androidx.room:room-testing"
    // Work Manager
    const val workManagerLib = "androidx.work:work-runtime-ktx"
    const val workManagerRxLib = "androidx.work:work-rxjava2"
    const val workManagerGcmLib = "androidx.work:work-gcm"
    const val workManagerTestLib = "androidx.work:work-testing"
    // Firebase
    const val firebaseAnalyticsLib = "com.google.firebase:firebase-analytics"
    // App compat
    const val appCompatLib = "androidx.appcompat:appcompat"
    // ConstraintLayout
    const val constraintLayoutLib = "androidx.constraintlayout:constraintlayout"
    const val constraintLayoutSolverLib =
        "androidx.constraintlayout:constraintlayout-solver"
    // Material
    const val materialLib = "com.google.android.material:material"
    // Gson
    const val gsonLib = "com.google.code.gson:gson"
    // Koin
    const val koinScopeLib = "org.koin:koin-androidx-scope"
    const val koinViewModelLib = "org.koin:koin-androidx-viewmodel"
    const val koinTestLib = "org.koin:koin-test"
    // SimpleLog
    const val simpleLogKapt = "com.don11995.log:simple-log-processor"
    const val simpleLogLib = "com.don11995.log:simple-log"
    // Glide
    const val glideKapt = "com.github.bumptech.glide:compiler"
    const val glideLib = "com.github.bumptech.glide:glide"
    // Rx
    const val rxJavaLib = "io.reactivex.rxjava2:rxjava"
    const val rxKotlinLib = "io.reactivex.rxjava2:rxkotlin"
    const val rxAndroidLib = "io.reactivex.rxjava2:rxandroid"
    // Jetty
    const val jettyClientLib = "org.eclipse.jetty:jetty-client"
    const val jettyServletLib = "org.eclipse.jetty:jetty-servlet"
    const val jettyServerLib = "org.eclipse.jetty:jetty-server"
    // OkHttp
    const val okHttpLib = "com.squareup.okhttp3:okhttp"
    const val okHttpLoggingLib = "com.squareup.okhttp3:logging-interceptor"
    const val okHttpMockServerLib = "com.squareup.okhttp3:mockwebserver"
    // Retrofit
    const val retrofitLib = "com.squareup.retrofit2:retrofit"
    const val retrofitGsonLib = "com.squareup.retrofit2:converter-gson"
    // Crashlytics
    const val crashlyticsLib = "com.crashlytics.sdk.android:crashlytics"
    const val crashlyticsNdkLib = "com.crashlytics.sdk.android:crashlytics-ndk"
    // Leak canary
    const val leakCanaryLib = "com.squareup.leakcanary:leakcanary-android"
    const val leakCanaryWatcherLib =
        "com.squareup.leakcanary:leakcanary-object-watcher-android"
    // Block canary
    const val blockCanaryLib = "com.github.markzhai:blockcanary-android"
    const val blockCanaryNoOpLib = "com.github.markzhai:blockcanary-no-op"

    // TESTS
    const val junitLib = "junit:junit"
    const val robolectricLib = "org.robolectric:robolectric"
    const val mockitoLib = "org.mockito:mockito-core"
    const val powerMockApiMockitoLib = "org.powermock:powermock-api-mockito2"
    const val powerMockJunitLib = "org.powermock:powermock-module-junit4"
    const val powerMockJunitRuleLib = "org.powermock:powermock-module-junit4-rule"
    const val powerMockXstreamLib = "org.powermock:powermock-classloading-xstream"
    const val testCoreLib = "androidx.test:core"
    const val testRunnerLib = "androidx.test:runner"
    const val testRulesLib = "androidx.test:rules"
    const val testExtJunitLib = "androidx.test.ext:junit"
    const val testExtTruthLib = "androidx.test.ext:truth"
    const val googleTruthLib = "com.google.truth:truth"
    const val mockkLib = "io.mockk:mockk"
}
