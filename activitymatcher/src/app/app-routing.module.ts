import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {SelectionIndoorOutdoorComponent} from "./selection-indoor-outdoor/selection-indoor-outdoor.component";
import {ActivitySwipeComponent} from "./activity-swipe/activity-swipe.component";

const routes: Routes = [
  {path: "", component: LandingPageComponent},
  {path: "swipe", component: ActivitySwipeComponent},
  {path: "selection", component: SelectionIndoorOutdoorComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
