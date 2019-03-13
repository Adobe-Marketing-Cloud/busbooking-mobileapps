//
//  CustomPopupView.m
//  TargetMobileTester
//
//  Created by Anil Bunkar on 29/06/18.
//  Copyright © 2018 adobe. All rights reserved.
//

#import "CustomPopupView.h"

@implementation CustomPopupView

- (id) initWithFrame:(CGRect)frame {
    self = [super initWithFrame:frame];
    if (self) {
        [self customInIt];
    }
    return self;
}

- (void)customInIt {
    [[NSBundle mainBundle] loadNibNamed:NSStringFromClass([self class]) owner:self options:nil];
    [self addSubview:self.contentView];
    [self.contentView setFrame:self.bounds];
    [self.contentView.layer setCornerRadius:6];
}

- (IBAction)dismissMe:(id)sender {
    [self removeFromSuperview];
}


@end
