import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {SelectionIndoorOutdoorComponent} from "./selection-indoor-outdoor/selection-indoor-outdoor.component";

const routes: Routes = [
  {path: "", component: LandingPageComponent},
  {path: "selection", component: SelectionIndoorOutdoorComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
