import {DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SubtitleComponent} from './components/subtitle/subtitle.component';
import {FormsModule} from "@angular/forms";
import {TwoWayDataBindingComponent} from './components/two-way-data-binding/two-way-data-binding.component';
import {BeersComponent} from './components/beers/beers.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {PrettyBeerPipe} from './pipes/pretty-beer.pipe';
import {NavbarComponent} from './components/navbar/navbar.component';
import {HomeComponent} from './components/home/home.component';
import {BeerComponent} from './components/beer/beer.component';
import {SearchComponent} from './components/search/search.component';
import {LoginComponent} from './components/login/login.component';
import {JwtInterceptor} from "./guards/jwt.interceptor";
import {registerLocaleData} from "@angular/common";
import locale from '@angular/common/locales/nl';

registerLocaleData(locale);

@NgModule({
  declarations: [
    AppComponent,
    SubtitleComponent,
    TwoWayDataBindingComponent,
    BeersComponent,
    PrettyBeerPipe,
    NavbarComponent,
    HomeComponent,
    BeerComponent,
    SearchComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  exports: [],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: LOCALE_ID, useValue: 'nl-NL'},
    {provide: DEFAULT_CURRENCY_CODE, useValue: 'EUR'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
