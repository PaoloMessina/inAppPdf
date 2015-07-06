#import <Cordova/CDV.h>

@interface InAppPdf : CDVPlugin{
    CDVInvokedUrlCommand* command;
}

@property (nonatomic, retain) CDVInvokedUrlCommand *command;

- (void)show: (CDVInvokedUrlCommand*)command;

@end
