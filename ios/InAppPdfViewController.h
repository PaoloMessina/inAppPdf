//
//  AlmaZBarReaderViewController.h
//  BarCodeMix
//
//  Created by eCompliance on 23/01/15.
//
//

@interface InAppPdfViewController : UIViewController <UIWebViewDelegate>

@property (nonatomic, weak) IBOutlet UIView *container;
@property (nonatomic, weak) IBOutlet UILabel *titleLabel;
@property (nonatomic, weak) IBOutlet UIButton *closeButton;
@property (nonatomic, weak) IBOutlet UIButton *backButton;
@property (nonatomic, weak) IBOutlet UIView *barView;
@property (nonatomic, weak) IBOutlet UIWebView *viewWeb;

@property (nonatomic, retain) NSDictionary *data;

-(IBAction) close:(id)sender;

@end
