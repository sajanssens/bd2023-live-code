import {Injectable} from '@angular/core';
import {Car} from "../components/model/Car";


@Injectable({
  providedIn: 'root'
})
export class CarService {
  cars = [
    {make: 'Opel', model: 'Astra', price: 29995},
    {make: 'Porsche', model: '911', price: 145000},
    {make: 'Fiat', model: 'Uno', price: 1800}
  ] as Car[];

  getAll(): Car[] {
    return this.cars
  }

  get(i: number): Car {
    return this.cars[i]
  }

}
