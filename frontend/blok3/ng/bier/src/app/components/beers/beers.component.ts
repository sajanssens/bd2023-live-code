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

  delete(id?: number) {
    this.beerService.delete(id).subscribe(
      // () => this.beers = this.beers.filter(c => c.id !== id)
    )
  }

  ngOnInit(): void {
    this.beers$ = this.beerService.getAll()
  }


  createPlaceholder(): string {
    return "welk bier?";
  }

  handleSearch(e: string) {
    console.log("handleSearch " + e)
    this.beers$ = this.beerService.search(e)
  }
}
