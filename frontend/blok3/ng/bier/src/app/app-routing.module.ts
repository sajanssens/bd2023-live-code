import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {BeersComponent} from "./components/beers/beers.component";
import {HomeComponent} from "./components/home/home.component";
import {isLoggedInGuard} from "./guards/is-logged-in.guard";

@NgModule({
  imports: [RouterModule.forRoot([
    {path: '', component: HomeComponent},
    {path: 'home', component: HomeComponent},
    {path: 'beers', component: BeersComponent, canActivate: [isLoggedInGuard]},
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
