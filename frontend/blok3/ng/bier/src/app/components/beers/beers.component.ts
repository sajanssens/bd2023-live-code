import {Component, OnInit} from '@angular/core';
import {BeerService} from "../../services/beer.service";
import {Observable, Subscription} from "rxjs";
import {Beer} from "../model/Beer";

@Component({
  selector: 'app-beers',
  templateUrl: './beers.component.html',
  styleUrls: ['./beers.component.less']
})
export class BeersComponent implements OnInit {
  beers$ = {} as Observable<Beer[]>
  message: string = ''

  private subscription: Subscription = {} as Subscription
  beerToAdd: Beer = {} as Beer

  constructor(private beerService: BeerService) {
  }

  ngOnInit(): void {
    this.beers$ = this.beerService.beersAreUpdated$;
    this.beerService.getAll()
  }

  delete(id?: number) {
    this.beerService.delete(id)
  }

  handleSearch(e: string) {
    if (typeof (e) == 'string') {
      this.beerService.search(e)
    }
  }

}
