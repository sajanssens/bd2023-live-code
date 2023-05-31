import {Component} from '@angular/core';
import {Beer} from "../model/Beer";
import {BeerService} from "../../services/beer.service";

@Component({
  selector: 'app-beer-details',
  templateUrl: './beer-details.component.html'
})
export class BeerDetailsComponent {

  beer: Beer = {} as Beer

  constructor(private beerService: BeerService) {
  }

  save() {
    this.beerService.add(this.beer)
  }


}
