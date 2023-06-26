import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {BeersComponent} from "./components/beers/beers.component";
import {HomeComponent} from "./components/home/home.component";
import {BeerComponent} from "./components/beer/beer.component";
import {LoginComponent} from "./components/login/login.component";
import {authGuard} from "./guards/auth.guard";

@NgModule({
  imports: [RouterModule.forRoot([
    {path: '', component: HomeComponent},
    {path: 'home', component: HomeComponent},
    {path: 'beers', component: BeersComponent, canActivate: [authGuard]},
    {path: 'beers/:id', component: BeerComponent, canActivate: [authGuard]},
    {path: 'login', component: LoginComponent},
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
