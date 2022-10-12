"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.detectVPN = detectVPN;
var _reactNative = require("react-native");
const LINKING_ERROR = `The package 'react-native-vpn-status' doesn't seem to be linked. Make sure: \n\n` + _reactNative.Platform.select({
  ios: "- You have run 'pod install'\n",
  default: ''
}) + '- You rebuilt the app after installing the package\n' + '- You are not using Expo managed workflow\n';
const VpnStatus = _reactNative.NativeModules.VpnStatus ? _reactNative.NativeModules.VpnStatus : new Proxy({}, {
  get() {
    throw new Error(LINKING_ERROR);
  }
});
function detectVPN() {
  return VpnStatus.detectVPN();
}
//# sourceMappingURL=index.js.map