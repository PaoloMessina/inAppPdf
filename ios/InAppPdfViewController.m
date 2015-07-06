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

@synthesize data;

@implementation InAppPdfViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    NSLog(@"%@", data);
    bool *showClose = [params objectForKey:@"showClose"];
    NSString *title = [params objectForKey:@"title"];
    NSString *url = [params objectForKey:@"url"];
    NSString *barColor = [params objectForKey:@"barColor"];
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

@end
