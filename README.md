# CallRecorder
Enable call recording function on OnePlus devices.

### Instructions
* Install app
* Connect phone via adb
* Run next command to grant settings permission: `adb shell pm grant com.don11995.oneplus.callrecorder android.permission.WRITE_SECURE_SETTINGS`
* Run the app

After this call recording will be enabled and will be enabled on boot
automatically

### Known issues
* After the "Airplane mode" the application must be restarted.
  Otherwise, the option will not be enabled immediately.
