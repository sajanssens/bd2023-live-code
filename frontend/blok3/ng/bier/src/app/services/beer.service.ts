import {Injectable} from '@angular/core';
import {Beer} from "../components/model/Beer";
import {HttpClient} from "@angular/common/http";
import {Subject} from "rxjs";

@Injectable({providedIn: 'root'})
export class BeerService {

  private _beersAreUpdated$ = new Subject<Beer[]>()

  get beersAreUpdated$() {
    return this._beersAreUpdated$
  }

  constructor(private http: HttpClient) {
  }

  getAll(): void {
    this.http.get<Beer[]>('http://localhost:3000/beers').subscribe(
      (beersFromBackend) => this._beersAreUpdated$.next(beersFromBackend)
    )
  }

  add(c: Beer): void {
    this.http.post<Beer>('http://localhost:3000/beers', c).subscribe(
      () => this.getAll()
    )
  }

  delete(id?: number): void {
    this.http.delete<void>('http://localhost:3000/beers/' + id).subscribe(
      () => this.getAll()
    )
  }

  search(searchterm: string): void {
    this.http.get<Beer[]>('http://localhost:3000/beers?q=' + searchterm).subscribe(
      (beersFromBackend) => this._beersAreUpdated$.next(beersFromBackend)
    )
  }

  get(id: number) {
    return this.http.get<Beer>(`http://localhost:3000/beers/${id}`)
  }

  update(beer: Beer) {
    return this.http.patch<Beer>(`http://localhost:3000/beers/${beer.id}`, beer)
      .subscribe(() => this.getAll());
  }
}
