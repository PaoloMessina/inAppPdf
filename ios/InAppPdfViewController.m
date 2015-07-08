//
//  InAppPdfViewController.m
//  Paolo Messina
//
//  Created by Paolo Messina on 06/07/15.
//
//

#import "InAppPdfViewController.h"

@interface InAppPdfViewController ()

@end

@implementation InAppPdfViewController

#define UIColorFromRGB(rgbValue) [UIColor colorWithRed:((float)((rgbValue & 0xFF0000) >> 16))/255.0 green:((float)((rgbValue & 0xFF00) >> 8))/255.0 blue:((float)(rgbValue & 0xFF))/255.0 alpha:1.0]

#pragma mark View lifecycle

- (void)viewWillAppear:(BOOL)animated {
    // View defaults to full size.  If you want to customize the view's size, or its subviews (e.g. webView),
    // you can do so here.
    // Lower screen 20px on ios 7
    if ([[[UIDevice currentDevice] systemVersion] floatValue] >= 7) {
        CGRect viewBounds = [self.container bounds];
        viewBounds.origin.y = 20;
        viewBounds.size.height = viewBounds.size.height - 20;
        self.container.frame = viewBounds;
        NSString *barColor = [self.data objectForKey:@"barColor"];
        if([barColor containsString:@"#"])barColor = [barColor stringByReplacingOccurrencesOfString:@"#" withString:@""];
        unsigned int baseValue;
        [[NSScanner scannerWithString:barColor] scanHexInt:&baseValue];
        self.view.backgroundColor = UIColorFromRGB(baseValue);
        self.barView.backgroundColor = UIColorFromRGB(baseValue);
        
    }
    [super viewWillAppear:animated];
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    NSLog(@"%@", self.data);
    bool *showClose = [[self.data objectForKey:@"showClose"] boolValue];
    NSString *title = [self.data objectForKey:@"title"];
    NSString *url = [self.data objectForKey:@"url"];
    NSString *barColor = [self.data objectForKey:@"barColor"];
    
    [self.viewWeb setDelegate:self];
    
    NSURL *targetURL = [NSURL URLWithString:url];
    NSURLRequest *request = [NSURLRequest requestWithURL:targetURL];
    [self.viewWeb loadRequest:request];
    [self.viewWeb setScalesPageToFit:YES];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*-(BOOL)shouldAutorotate{
    return NO;
}*/

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

#pragma mark UIWebDelegate implementation

/*- (void)webViewDidFinishLoad:(UIWebView*)theWebView
{
    if ([[[UIDevice currentDevice] systemVersion] floatValue] >= 7) {
        
    }
    // Black base color for background matches the native apps
    theWebView.backgroundColor = [UIColor blackColor];
    
    return [self webViewDidFinishLoad:theWebView];
}*/

-(IBAction) close:(id)sender{
    [self dismissViewControllerAnimated:YES completion:nil];
}

@end
