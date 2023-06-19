import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
import {serverUrl} from '../../environments/environment';
import {User} from "../components/model/User";

@Injectable({providedIn: 'root'}) // ApplicationScoped
export class UserService {

  public static readonly emptyUser = {} as User;

  private uri = serverUrl + '/users';
  loggedInUser: User = UserService.emptyUser;

  loggedIn$ = new Subject<string>();
  // loggedOut$ = new Subject<string>();

  message$ = new Subject<string>();

  constructor(private http: HttpClient) {
  }

  login(u: User): void {
    console.log(`${this.uri}/login` + JSON.stringify(u))

    this.http.post<User>(`${this.uri}/login`, u, {observe: 'response'} /* = to receive the full httpresponse instead of only the body */)
      .subscribe(
        data => {
          // get the body from the response:
          this.loggedInUser = data.body ?? UserService.emptyUser;
          this.loggedIn$.next(this.loggedInUser.username);
          this.message$.next(`Gebruiker ${this.loggedInUser.username} is ingelogd.`);
          localStorage.setItem('loggedInUser', JSON.stringify(this.loggedInUser));

          // or get a header from the response:
          const token = data.headers.get('Authorization')?.substr(7);
          localStorage.setItem('token', JSON.stringify(token));
        }, error => {
          console.log(error);
          this.message$.next(`Inloggen is mislukt.  Reden: ${error.statusText}.`);
        }
      );
  }


  logout(): void {
    this.loggedInUser = UserService.emptyUser
    // this.loggedOut$.next("loggedOut$");
  }


}

