import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SubtitleComponent} from './components/subtitle/subtitle.component';
import {FormsModule} from "@angular/forms";
import {TwoWayDataBindingComponent} from './components/two-way-data-binding/two-way-data-binding.component';
import {BeersComponent} from './components/beers/beers.component';
import {HttpClientModule} from "@angular/common/http";
import { PrettyBeerPipe } from './pipes/pretty-beer.pipe';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { BeerDetailsComponent } from './components/beer-details/beer-details.component';
import { SearchComponent } from './components/search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    SubtitleComponent,
    TwoWayDataBindingComponent,
    BeersComponent,
    PrettyBeerPipe,
    NavbarComponent,
    HomeComponent,
    BeerDetailsComponent,
    SearchComponent,
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
