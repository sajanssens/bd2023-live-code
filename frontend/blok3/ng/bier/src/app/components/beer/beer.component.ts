import {Component, DEFAULT_CURRENCY_CODE, Inject, LOCALE_ID} from '@angular/core';
import {Beer} from "../model/Beer";
import {BeerService} from "../../services/beer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import {getCurrencySymbol} from "@angular/common";

let BASE_URL;

@Component({
  selector: 'app-beer-details',
  templateUrl: './beer.component.html'
})
export class BeerComponent {

  beer: Beer = {} as Beer
  show: boolean = false;
  private editMode = false;
  formClass: string = 'needs-validation';

  constructor(private beerService: BeerService,
              private route: ActivatedRoute,
              private router: Router,
              @Inject(DEFAULT_CURRENCY_CODE) private currencyCode: string,
              @Inject(LOCALE_ID) private localeId: string
  ) {
    if (this.route.snapshot.paramMap.has('id')) {
      this.show = true;
      this.editMode = true;
      const id = this.route.snapshot.paramMap.get('id') ?? 0
      this.beerService.get(+id).subscribe(b => this.beer = b);
    }
  }

  save(beerForm: NgForm) {
    this.formClass = 'was-validated'
    if (!beerForm.valid) return

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


  currency() {
    return getCurrencySymbol(this.currencyCode, "narrow", this.localeId);
  }
}
