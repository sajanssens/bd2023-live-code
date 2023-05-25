import { Pipe, PipeTransform } from '@angular/core';
import {Car} from "../model/Car";

@Pipe({
  name: 'prettyCarrify'
})
export class PrettyCarrifyPipe implements PipeTransform {

  transform(value: Car): string {
    return `${value.make} - ${value.model}`;
  }

}
