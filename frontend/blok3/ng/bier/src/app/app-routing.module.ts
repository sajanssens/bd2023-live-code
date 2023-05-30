import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CarsComponent} from "./components/cars/cars.component";
import {HomeComponent} from "./components/home/home.component";
import {isLoggedInGuard} from "./guards/is-logged-in.guard";

@NgModule({
  imports: [RouterModule.forRoot([
    {path: '', component: HomeComponent},
    {path: 'home', component: HomeComponent},
    {path: 'cars', component: CarsComponent, canActivate: [isLoggedInGuard]},
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
