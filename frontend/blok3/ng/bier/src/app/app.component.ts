import { Component } from '@angular/core';

@Component({ // annotation = decorator in TS
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {
  title: string = 'bier';
}
