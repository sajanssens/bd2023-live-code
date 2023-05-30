import {Component, OnDestroy, OnInit} from '@angular/core';
import {CarService} from "../../services/car.service";
import {Observable, Subscription} from "rxjs";
import {Car} from "../model/Car";
import {NgForm} from "@angular/forms";

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

  save(ngForm: NgForm) {
    if (ngForm.valid) {
      console.log(ngForm.value);

      this.carService.add(this.carToAdd).subscribe(
        addedCar => this.cars.push(addedCar)
      )
      this.carToAdd = {} as Car
      ngForm.reset()
    } else {
      this.message = "Er zitten fouten in het formulier..."
    }
  }


  buttonEnabled() {
  }

  ngOnInit(): void {
    this.cars$ = this.carService.getAll()
    this.subscription = this.carService.getAll().subscribe((cars) => this.cars = cars);
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }

  createMake(): string {
    return "make"
  }
}
