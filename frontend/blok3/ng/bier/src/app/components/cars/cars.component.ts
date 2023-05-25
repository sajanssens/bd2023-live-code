import {Component, OnDestroy, OnInit} from '@angular/core';
import {CarService} from "../../services/car.service";
import {Observable, Subscription} from "rxjs";
import {Car} from "../model/Car";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.less']
})
export class CarsComponent implements OnInit, OnDestroy {

  cars$ = {} as Observable<Car[]>
  cars: Car[] = []
  // carService: CarService
  message: string = ''
  private subscription: Subscription = {} as Subscription
  make: string = '';
  model: string = '';
  price: number = 0.0

  constructor(private carService: CarService) {
  }

  delete(id?: number) {
    this.carService.delete(id).subscribe(
      // this.cars.find((c) => c.id === id)
    )
  }

  save() {
    let car: Car = {make: this.make, model: this.model, price: this.price}
    this.carService.add(car).subscribe(
      addedCar => {
        console.log('Car added: ' + JSON.stringify(addedCar))
        this.cars.push(addedCar)
      }
    );
  }

  ngOnInit(): void {
    this.cars$ = this.carService.getAll()
    this.subscription = this.carService.getAll().subscribe((cars) => this.cars = cars);
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }
}
