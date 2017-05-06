'use strict';

import {NativeModules, Platform} from 'react-native';
const {RNDetectNavbarAndroid} = NativeModules;

function unSupportedError() {
  throw new Error('[react-native-detect-navbar-android] does not support iOS');
}

const DetectNavbar = Platform.OS === 'android' ? {
  hasSoftKeys() {
    return RNDetectNavbarAndroid.hasSoftKeys();
  }
} : {
  hasSoftKeys: unSupportedError
};

export {DetectNavbar};
export default DetectNavbar;
