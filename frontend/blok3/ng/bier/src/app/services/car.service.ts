import {Injectable} from '@angular/core';
import {Car} from "../components/model/Car";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class CarService {


  constructor(private http: HttpClient) {

  }

  getAll(): Observable<Car[]> {
    // this.http.get<Car[]>('http://localhost:3000/cars').subscribe(
    //   (c) => console.log(c)
    // )
    return this.http.get<Car[]>('http://localhost:3000/cars')
  }

  // get(i: number): Car {
  //   // return this.cars[i]

  // }

}
