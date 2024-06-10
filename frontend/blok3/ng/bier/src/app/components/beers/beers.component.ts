import {Component, OnInit} from '@angular/core';
import {BeerService} from "../../services/beer.service";
import {Observable} from "rxjs";
import {Beer} from "../model/Beer";

@Component({
  selector: 'app-beers',
  templateUrl: './beers.component.html',
  styleUrls: ['./beers.component.less']
})
export class BeersComponent implements OnInit {
  beers$ = {} as Observable<Beer[]>
  message: string = ''

  constructor(private beerService: BeerService) {
  }

  ngOnInit(): void {
    this.beers$ = this.beerService.beersAreUpdated$;
    this.beerService.getAll()
  }

  delete(e: Event, id?: number) {
    this.beerService.delete(id)
    e.stopPropagation();
  }

  handleSearch(e: string) {
    this.beerService.search(e)
  }

}
