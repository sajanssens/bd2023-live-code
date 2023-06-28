import {Component} from '@angular/core';
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.less']
})
export class NavbarComponent {
  loggedInMessage = 'Not logged in.';

  constructor(private userService: UserService) {
    userService.loggedInMessage$.subscribe(m =>
      this.loggedInMessage = m
    )
  }

  isLoggedIn() {
    return this.userService.isLoggedIn();
  }

  logout() {
    return this.userService.logout();
  }
}
