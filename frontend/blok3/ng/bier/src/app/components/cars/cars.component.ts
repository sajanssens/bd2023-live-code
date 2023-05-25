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
  message: string = ''

  private subscription: Subscription = {} as Subscription
  carToAdd: Car = {} as Car

  constructor(private carService: CarService) {
  }

  delete(id?: number) {
    this.carService.delete(id).subscribe(
      () => this.cars = this.cars.filter(c => c.id !== id)
    )
  }

  save() {
    this.carService.add(this.carToAdd).subscribe(
      addedCar => this.cars.push(addedCar)
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
