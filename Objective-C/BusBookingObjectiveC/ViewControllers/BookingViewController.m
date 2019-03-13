//
//  BookingViewController.m
//  BusBookingObjectiveC
//
//  Created by Anil Bunkar on 04/07/18.
//  Copyright © 2018 Adobe Systems. All rights reserved.
//

#import "BookingViewController.h"

@interface BookingViewController ()
@property (weak, nonatomic) IBOutlet UIButton *nonStopButton;

@end

@implementation BookingViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}
- (IBAction)nonStopButtonToggled:(id)sender {
    if (self.nonStopButton.isSelected) {
        self.nonStopButton.selected = NO;
    } else {
        self.nonStopButton.selected = YES;
    }
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
