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
import { SignUpComponent } from './landing-page/sign-up/sign-up.component';
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './landing-page/login/login.component';

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
    SignUpComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
