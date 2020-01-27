@file:Suppress("InvalidPackageDeclaration")

object Deps {
    // CLASSPATH
    const val gradleClasspath: String =
        "${Classpath.gradleClasspath}:${Versions.gradleVersion}"
    const val kotlinClasspath: String =
        "${Classpath.kotlinClasspath}:${Versions.kotlinVersion}"
    const val fabricToolsClasspath: String =
        "${Classpath.fabricToolsClasspath}:${Versions.fabricVersion}"
    const val gradleUpdatesClasspath: String =
        "${Classpath.gradleUpdatesClasspath}:${Versions.gradleUpdatesVersion}"
    const val gmsClasspath: String = "${Classpath.gmsClasspath}:${Versions.gmsVersion}"
    const val navigationArgsClasspath: String =
        "${Classpath.navigationArgsClasspath}:${Versions.navigationArgsVersion}"

    // LIBS
    // Kotlin base
    const val kotlinStdLib: String = "${Libs.kotlinStdLib}:${Versions.kotlinVersion}"
    const val kotlinReflectLib: String = "${Libs.kotlinReflectLib}:${Versions.kotlinVersion}"
    // Annotation
    const val annotationLib: String = "${Libs.annotationLib}:${Versions.annotationVersion}"
    // Core
    const val coreKtxLib: String = "${Libs.coreKtxLib}:${Versions.coreKtxVersion}"
    // Activity
    const val activityLib: String = "${Libs.activityLib}:" +
            Versions.activityVersion
    // Fragment
    const val fragmentLib: String = "${Libs.fragmentLib}:" +
            Versions.fragmentVersion
    const val fragmentTestingLib: String = "${Libs.fragmentTestingLib}:" +
            Versions.fragmentVersion
    // Collections
    const val collectionsLib: String = "${Libs.collectionsLib}:" +
            Versions.collectionsVersion
    // Lifecycle
    const val lifecycleKapt: String = "${Libs.lifecycleKapt}:${Versions.lifecycleVersion}"
    const val lifecycleLib: String =
        "${Libs.lifecycleLib}:${Versions.lifecycleVersion}"
    const val lifecycleReactiveLib: String =
        "${Libs.lifecycleReactiveLib}:${Versions.lifecycleVersion}"
    const val lifecycleTestLib: String =
        "${Libs.lifecycleTestLib}:${Versions.lifecycleVersion}"
    // Coroutines
    const val kotlinCoroutinesCoreLib: String =
        "${Libs.kotlinCoroutinesCoreLib}:${Versions.coroutinesVersion}"
    const val kotlinCoroutinesAndroidLib: String =
        "${Libs.kotlinCoroutinesAndroidLib}:${Versions.coroutinesVersion}"
    const val kotlinCoroutinesRxLib: String =
        "${Libs.kotlinCoroutinesRxLib}:${Versions.coroutinesVersion}"
    // Navigation
    const val navigationRuntimeLib: String =
        "${Libs.navigationRuntimeLib}:${Versions.navigationVersion}"
    const val navigationFragmentKtxLib: String =
        "${Libs.navigationFragmentKtxLib}:${Versions.navigationVersion}"
    const val navigationUiKtxLib: String = "${Libs.navigationUiKtxLib}:" +
            Versions.navigationVersion
    // Room
    const val roomKapt: String = "${Libs.roomKapt}:${Versions.roomVersion}"
    const val roomRuntimeLib: String = "${Libs.roomRuntimeLib}:${Versions.roomVersion}"
    const val roomKtxLib: String = "${Libs.roomKtxLib}:${Versions.roomVersion}"
    const val roomRxLib: String = "${Libs.roomRxLib}:${Versions.roomVersion}"
    const val roomGuavaLib: String = "${Libs.roomGuavaLib}:${Versions.roomVersion}"
    const val roomTestLib: String = "${Libs.roomTestLib}:${Versions.roomVersion}"
    // Work Manager
    const val workManagerLib: String = "${Libs.workManagerLib}:" +
            Versions.workManagerVersion
    const val workManagerRxLib: String = "${Libs.workManagerRxLib}:" +
            Versions.workManagerVersion
    const val workManagerGcmLib: String = "${Libs.workManagerGcmLib}:" +
            Versions.workManagerVersion
    const val workManagerTestLib: String = "${Libs.workManagerTestLib}:" +
            Versions.workManagerVersion
    // Firebase
    const val firebaseAnalyticsLib: String = "${Libs.firebaseAnalyticsLib}:" +
            Versions.firebaseVersion
    // App compat
    const val appCompatLib: String = "${Libs.appCompatLib}:${Versions.appCompatVersion}"
    // ConstraintLayout
    const val constraintLayoutLib: String =
        "${Libs.constraintLayoutLib}:${Versions.constraintLayoutVersion}"
    const val constraintLayoutSolverLib: String =
        "${Libs.constraintLayoutSolverLib}:${Versions.constraintLayoutVersion}"
    // Material
    const val materialLib: String = "${Libs.materialLib}:${Versions.materialVersion}"
    // Gson
    const val gsonLib: String = "${Libs.gsonLib}:${Versions.gsonVersion}"
    // Koin
    const val koinScopeLib: String = "${Libs.koinScopeLib}:${Versions.koinVersion}"
    const val koinViewModelLib: String = "${Libs.koinViewModelLib}:${Versions.koinVersion}"
    const val koinTestLib: String = "${Libs.koinTestLib}:${Versions.koinVersion}"
    // SimpleLog
    const val simpleLogKapt: String = "${Libs.simpleLogKapt}:${Versions.simpleLogVersion}"
    const val simpleLogLib: String = "${Libs.simpleLogLib}:${Versions.simpleLogVersion}"
    // Glide
    const val glideKapt: String = "${Libs.glideKapt}:${Versions.glideVersion}"
    const val glideLib: String = "${Libs.glideLib}:${Versions.glideVersion}"
    // Rx
    const val rxJavaLib: String = "${Libs.rxJavaLib}:${Versions.rxJavaVersion}"
    const val rxKotlinLib: String = "${Libs.rxKotlinLib}:${Versions.rxKotlinVersion}"
    const val rxAndroidLib: String = "${Libs.rxAndroidLib}:${Versions.rxAndroidVersion}"
    // Jetty
    const val jettyClientLib: String = "${Libs.jettyClientLib}:${Versions.jettyVersion}"
    const val jettyServletLib: String = "${Libs.jettyServletLib}:${Versions.jettyVersion}"
    const val jettyServerLib: String = "${Libs.jettyServerLib}:${Versions.jettyVersion}"
    // OkHttp
    const val okHttpLib: String = "${Libs.okHttpLib}:${Versions.okHttpVersion}"
    const val okHttpLoggingLib: String = "${Libs.okHttpLoggingLib}:" +
            Versions.okHttpVersion
    const val okHttpMockServerLib: String = "${Libs.okHttpMockServerLib}:" +
            Versions.okHttpVersion
    // Retrofit
    const val retrofitLib: String = "${Libs.retrofitLib}:${Versions.retrofitVersion}"
    const val retrofitGsonLib: String = "${Libs.retrofitGsonLib}:" +
            Versions.retrofitVersion
    // Crashlytics
    const val crashlyticsLib: String = "${Libs.crashlyticsLib}:" +
            "${Versions.crashlyticsVersion}@aar"
    const val crashlyticsNdkLib: String =
        "${Libs.crashlyticsNdkLib}:${Versions.crashlyticsNdkVersion}@aar"
    // Leak canary
    const val leakCanaryLib: String = "${Libs.leakCanaryLib}:${Versions.leakCanaryVersion}"
    const val leakCanaryWatcherLib: String =
        "${Libs.leakCanaryWatcherLib}:${Versions.leakCanaryVersion}"
    // Block canary
    const val blockCanaryLib: String = "${Libs.blockCanaryLib}:" +
            Versions.blockCanaryVersion
    const val blockCanaryNoOpLib: String = "${Libs.blockCanaryNoOpLib}:" +
            Versions.blockCanaryVersion

    // TESTS
    const val junitLib: String = "${Libs.junitLib}:${Versions.junitVersion}"
    const val robolectricLib: String = "${Libs.robolectricLib}:" +
            Versions.robolectricVersion
    const val mockitoLib: String = "${Libs.mockitoLib}:${Versions.mockitoVersion}"
    const val powerMockApiMockitoLib: String =
        "${Libs.powerMockApiMockitoLib}:${Versions.powerMockVersion}"
    const val powerMockJunitLib: String = "${Libs.powerMockJunitLib}:${Versions.powerMockVersion}"
    const val powerMockJunitRuleLib: String =
        "${Libs.powerMockJunitRuleLib}:${Versions.powerMockVersion}"
    const val powerMockXstreamLib: String =
        "${Libs.powerMockXstreamLib}:${Versions.powerMockVersion}"
    const val testCoreLib: String = "${Libs.testCoreLib}:${Versions.testCoreVersion}"
    const val testRunnerLib: String = "${Libs.testRunnerLib}:${Versions.testRunnerVersion}"
    const val testRulesLib: String = "${Libs.testRulesLib}:${Versions.testRulesVersion}"
    const val testExtJunitLib: String = "${Libs.testExtJunitLib}:" +
            Versions.testJunitVersion
    const val testExtTruthLib: String = "${Libs.testExtTruthLib}:" +
            Versions.testTruthVersion
    const val googleTruthLib: String = "${Libs.googleTruthLib}:" +
            Versions.googleTruthVersion
    const val mockkLib: String = "${Libs.mockkLib}:${Versions.mockkVersion}"
}
