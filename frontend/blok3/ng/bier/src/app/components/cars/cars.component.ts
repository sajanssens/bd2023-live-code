import {Component} from '@angular/core';
import {CarService} from "../../services/car.service";
import {Observable} from "rxjs";
import {Car} from "../model/Car";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.less']
})
export class CarsComponent {

  cars$ = {} as Observable<Car[]>
  cars: Car[] = {} as Car[]

  constructor(private carService: CarService) {
    this.cars$ = this.carService.getAll()
    this.carService.getAll().subscribe((cars) => this.cars = cars)
  }

}
