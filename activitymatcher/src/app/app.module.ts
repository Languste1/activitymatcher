import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ActivitySwipeComponent } from './activity-swipe/activity-swipe.component';
import { ActivityComponent } from './activity/activity.component';
import { SelectionIndoorOutdoorComponent } from './selection-indoor-outdoor/selection-indoor-outdoor.component';
import { ActivityMatchComponent } from './activity-match/activity-match.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    NavbarComponent,
    ActivitySwipeComponent,
    ActivityComponent,
    NavbarComponent,
    SelectionIndoorOutdoorComponent,
    ActivityMatchComponent,
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
