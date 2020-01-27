# Version 1.0.6
* Add `Config` plugin to share base app settings between modules. Example:
    ```
    appConfig {
        compileSdkVersion = 29
        buildToolsVersion = "29.0.2"
        applicationId = "com.don11995.template"
        minSdkVersion = 21
        targetSdkVersion = 29
        majorVersion = 1
        minorVersion = 0
        buildVersion = 0
    }
    ```
    In other modules use `Config` singleton with the same names of fields as in `appConfig` block.
* Update `kotlinter` to version 2.3.0
* Fix Security module to correct detect file names of `aab` and `apk` archives

# Version 1.0.5
* Update firebase to version 17.2.2
* Update Google Truth lib to version 1.0.1

# Version 1.0.4
* Throw an error when CRC build is set, but no needed data set

# Version 1.0.3
* Update kotlinter version to `2.2.0`
* Update detekt version to `1.4.0`
* Update mockito version to `3.2.4`
* Update coroutines version to `1.3.3`
* Symbols: Remove `autoUploadSymbols = true`. Now to upload symbols use
next in `buildType` section:
    ```
    buildTypes {
        release {
            isUploadSymbols = true
        }
    }
    ```
* Security: Remove auto creation release sources. To generate release 
sources now is needed to add flag to concrete `buildType`. 
Same applied for CRC calculation:
    ```
    buildTypes {
        release {
            isReleaseSourcesEnabled = true
            isCalculateCrcEnabled = true
        }
    }
    ```
# Version 1.0.2
* Update gradle plugin version to `3.5.3`

# Version 1.0.1
* Add function to auto upload symbols for crashlytics on release build
    ```
    symbols {
        autoUploadSymbols = true
    }
    ```

# Version 1.0.0
* Init version
