import {Injectable} from '@angular/core';
import {Car} from "../components/model/Car";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({providedIn: 'root'})
export class CarService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Car[]> {
    return this.http.get<Car[]>('http://localhost:3000/cars')
  }

  // get(i: number): Car {
  //   // return this.cars[i]
  // }


  add(c: Car): Observable<Car> {
    return this.http.post<Car>('http://localhost:3000/cars', c);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>('http://localhost:3000/cars/' + id);
  }
}
