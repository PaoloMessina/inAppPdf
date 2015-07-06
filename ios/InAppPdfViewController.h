//
//  AlmaZBarReaderViewController.h
//  BarCodeMix
//
//  Created by eCompliance on 23/01/15.
//
//

#import "InAppPdfView.h"

@interface InAppPdfViewController

@property (nonatomic, weak) IBOutlet UILabel *titleLabel;
@property (nonatomic, weak) IBOutlet UIButton *closeButton;
@property (nonatomic, weak) IBOutlet UIButton *backButton;
@property (nonatomic, weak) IBOutlet UIWebView *viewWeb;

@property (nonatomic, retain) NSDictionary *data;

@end
