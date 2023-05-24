import {Component} from '@angular/core';
import {CarService} from "../../services/car.service";
import {Car} from "../model/Car";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.less']
})
export class CarsComponent {

  constructor(private carService: CarService) {
  }


  cars(): Car[] {
    return this.carService.getAll()
  }
}
