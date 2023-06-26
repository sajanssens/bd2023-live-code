import {Component} from '@angular/core';
import {Beer} from "../model/Beer";
import {BeerService} from "../../services/beer.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-beer-details',
  templateUrl: './beer.component.html'
})
export class BeerComponent {

  beer: Beer = {} as Beer
  show: boolean = false;
  private editMode = false;

  constructor(private beerService: BeerService, private route: ActivatedRoute, private router: Router) {
    if (this.route.snapshot.paramMap.has('id')) {
      this.show = true;
      this.editMode = true;
      const id = this.route.snapshot.paramMap.get('id') ?? 0
      this.beerService.get(+id).subscribe(b => this.beer = b);
    }
  }

  save() {
    if (this.editMode) {
      this.beerService.update(this.beer)
      this.router.navigate(['beers'])
    } else {
      this.beerService.add(this.beer)
    }
    this.beer = {} as Beer
    this.show = false
  }

  toggle() {
    this.show = !this.show;
  }

  cancel() {
    this.show = false;
    if (this.editMode) {
      this.router.navigate(['beers'])
    }
  }
}
