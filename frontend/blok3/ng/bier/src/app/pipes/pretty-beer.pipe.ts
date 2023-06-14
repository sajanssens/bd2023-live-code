import {Pipe, PipeTransform} from '@angular/core';
import {Beer} from "../components/model/Beer";

@Pipe({
  name: 'prettyBeer'
})
export class PrettyBeerPipe implements PipeTransform {

  transform(beer: Beer): string {
    return `${beer.make} ${beer.type}`;
  }

}
