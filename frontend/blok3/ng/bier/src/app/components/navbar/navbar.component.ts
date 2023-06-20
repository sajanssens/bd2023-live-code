import {Component} from '@angular/core';
import {isLoggedInGuard} from "../../guards/is-logged-in.guard";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.less']
})
export class NavbarComponent {

  constructor(private userService: UserService) {
  }

  isLoggedIn() {
    return this.userService.isLoggedIn();
  }

  logout() {
    return this.userService.logout();
  }
}
