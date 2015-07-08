//
//  AlmaZBarReaderViewController.h
//  Paolo Messina
//
//  Created by Paolo Messina on 06/07/15.
//
//

#import "InAppPdf.h"
#import "InAppPdfViewController.h"


#pragma mark - Synthesize

@implementation InAppPdf
@synthesize command;


#pragma mark - Cordova Plugin

- (void)pluginInitialize
{
    
}

#pragma mark - Plugin API

- (void)show: (CDVInvokedUrlCommand*)command;
{
    InAppPdfViewController *showCtrl = [[InAppPdfViewController alloc] initWithNibName:@"inAppPdfView" bundle:nil];
    self.command = command;
    
    // Get user parameters
    NSDictionary *params = (NSDictionary*) [command argumentAtIndex:0];
    /*bool *showClose = [params objectForKey:@"showClose"];
    NSString *title = [params objectForKey:@"title"];
    NSString *url = [params objectForKey:@"url"];
    NSString *barColor = [params objectForKey:@"barColor"];
    
    self.showCtrl.showClose = showClose;
    self.showCtrl.title = title;
    self.showCtrl.url = url;
    self.showCtrl.barColor = barColor;*/
    [showCtrl setData:params];
    
    
    [self.viewController presentViewController:showCtrl animated:YES completion:nil];
}


#pragma mark - Helpers

- (void)sendScanResult: (CDVPluginResult*)result
{
    [self.commandDelegate sendPluginResult: result callbackId: self.command.callbackId];
}


@end

