import {Injectable} from '@angular/core';
import {Beer} from "../components/model/Beer";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({providedIn: 'root'})
export class BeerService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Beer[]> {
    return this.http.get<Beer[]>('http://localhost:3000/beers')
  }

  add(c: Beer): Observable<Beer> {
    return this.http.post<Beer>('http://localhost:3000/beers', c);
  }

  delete(id?: number): Observable<void> {
    return this.http.delete<void>('http://localhost:3000/beers/' + id);
  }

  search(searchterm: string): Observable<Beer[]> {
    return this.http.get<Beer[]>('http://localhost:3000/beers?q=' + searchterm)
  }
}
