# remove-bg
Remove.bg is a free service to remove the background of any photo. It works 100% automatically: You don't have to manually select the background/foreground layers to separate them - just select your image and instantly download the result image with the background removed!

<img src="https://raw.githubusercontent.com/theapache64/remove-bg/master/demo.gif" width="300">

## Installation

```gradle
implementation 'com.theapache64.removebg:removebg:1.0.0'
```

### Usage

Initialize the SDK from your `Application` class. You can get your key from [here](https://www.remove.bg/profile#api-key)

```kotlin


import android.app.Application
import com.theapache64.removebg.RemoveBg

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        RemoveBg.init("YOUR-API-KEY")
    }
}
```

and you can use it like this

```kotlin
RemoveBg.from(imageFile, object : RemoveBg.RemoveBgCallback {

    override fun onProcessing() {
        // will be invoked once finished uploading the image
    }

    override fun onUploadProgress(progress: Float) {
        // will be invoked on uploading 
    }

    override fun onError(errors: List<ErrorResponse.Error>) {
        // will be invoked if there's any error occurred
    }

    override fun onSuccess(bitmap: Bitmap) {
        // will be invoked when background removed 
    }

})
```

### Example

This repository contains a complete example of the SDK.
Download the project and compile with your [API-KEY](https://www.remove.bg/profile#api-key).

### Author

theapache64

