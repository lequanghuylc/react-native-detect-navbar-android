# react-native-detect-navbar-android
Detect soft navigation bar for Android devices, so you'll know which one has physical keys (Home, Back, Menu) and which does not.

Note: this project is Android only, and it will not work if you use it to detect soft key being hidden. Pull Request is welcomed.

## Installation Process

* download this from npm

```bash
npm install react-native-detect-navbar-android --save
```

* Run `react-native link` or...

* Edit `android/settings.gradle`:

  ```diff
  + include ':react-native-detect-navbar-android'
  + project(':react-native-detect-navbar-android').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-detect-navbar-android/android')
  ```

* Edit `android/app/build.gradle`:

  ```diff
  dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile "com.android.support:appcompat-v7:23.0.1"
    compile "com.facebook.react:react-native:+"
  + compile project(':react-native-detect-navbar-android')
  }
  ```

* Edit your `android/app/src/main/java/.../MainApplication.java`:

  ```diff
  + import import com.rndetectnavbarandroid.RNDetectNavbarAndroidPackage;
  ```
  
  ```diff
    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
        new MainReactPackage()
  +     , new RNDetectNavbarAndroidPackage()
      );
    }
  ```

## Usage

```js
import DetectNavbar from 'react-native-detect-navbar-android';
// or
import {DetectNavbar} from 'react-native-detect-navbar-android';
// or
const DetectNavbar = require('react-native-detect-navbar-android');

// methods (Android Only, don't call on iOS)
DetectNavbar.hasSoftKeys().then((bool) => {
  if(bool) {
    console.log('Has Soft NavBar');
  } else {
    console.log('Has Hard Key NavBar');
  }
});
```
