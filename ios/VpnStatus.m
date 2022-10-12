#import "VpnStatus.h"

@implementation VpnStatus

RCT_EXPORT_MODULE()

// Example method
// See // https://reactnative.dev/docs/native-modules-ios

RCT_EXPORT_METHOD(detectVPN:(RCTPromiseResolveBlock)resolve
                  reject:(RCTPromiseRejectBlock)reject)
{
    CFDictionaryRef cfDict = CFNetworkCopySystemProxySettings();
    NSDictionary *nsDict = (__bridge NSDictionary*)cfDict;
    NSDictionary *keys = [nsDict valueForKey:@"__SCOPED__"];
    BOOL isConnected = NO;

    for (id key in keys) {
        // NSLog(@"keys==>%@", keys);
        if ([@"tap" isEqual: key] || [@"tun" isEqual: key] || [@"ppp" isEqual: key] || [@"ipsec" isEqual: key]
        || [@"ipsec0" isEqual: key] || [key containsString: @"utun"]  || [key containsString: @"ipsec"]) {
            isConnected = YES;
        }
    }
    resolve(@(isConnected));
}

@end
