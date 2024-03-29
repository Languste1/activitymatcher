import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {SelectionIndoorOutdoorComponent} from "./selection-indoor-outdoor/selection-indoor-outdoor.component";
import {ActivitySwipeComponent} from "./activity-swipe/activity-swipe.component";
import {ActivityMatchComponent} from "./activity-match/activity-match.component";
import {SignUpComponent} from "./landing-page/sign-up/sign-up.component";

const routes: Routes = [
  {path: "", component: LandingPageComponent},
  {path: "sign-up", component: SignUpComponent},
  {path: "swipe", component: ActivitySwipeComponent},
  {path: "selection", component: SelectionIndoorOutdoorComponent},
  {path: "match", component: ActivityMatchComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

