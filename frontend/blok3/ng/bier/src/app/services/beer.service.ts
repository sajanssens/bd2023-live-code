import {Injectable} from '@angular/core';
import {Beer} from "../components/model/Beer";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {serverUrl} from "../../environments/environment";

@Injectable({providedIn: 'root'})
export class BeerService {

  private url = `${serverUrl}/beers`;
  private _beersAreUpdated$ = new Subject<Beer[]>()

  constructor(private http: HttpClient) {
  }

  get beersAreUpdated$() {
    return this._beersAreUpdated$
  }

  getAll(): void {
    this.http.get<Beer[]>(this.url).subscribe(
      (beersFromBackend) => {
        this._beersAreUpdated$.next(beersFromBackend)
      }
    )
  }

  add(b: Beer): void {
    this.http.post<Beer>(this.url, b).subscribe(
      () => this.getAll()
    )
  }

  delete(id?: number): void {
    this.http.delete<void>(`${this.url}/${id}`).subscribe(
      () => this.getAll()
    )
  }

  search(term: string): void {
    this.http.get<Beer[]>(`${this.url}?q=${term}`).subscribe(
      (beersFromBackend) => this._beersAreUpdated$.next(beersFromBackend)
    )
  }

  get(id: number): Observable<Beer> {
    return this.http.get<Beer>(`${this.url}/${id}`)
  }

  update(b: Beer): void {
    this.http.patch<Beer>(`${this.url}/${b.id}`, b)
      .subscribe(() => this.getAll());
  }
}
