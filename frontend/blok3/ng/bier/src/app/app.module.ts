import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SubtitleComponent} from './components/subtitle/subtitle.component';
import {FormsModule} from "@angular/forms";
import {TwoWayDataBindingComponent} from './components/two-way-data-binding/two-way-data-binding.component';
import {CarsComponent} from './components/cars/cars.component';
import {HttpClientModule} from "@angular/common/http";
import { PrettyCarrifyPipe } from './components/pipes/pretty-carrify.pipe';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    SubtitleComponent,
    TwoWayDataBindingComponent,
    CarsComponent,
    PrettyCarrifyPipe,
    NavbarComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  exports: [],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
