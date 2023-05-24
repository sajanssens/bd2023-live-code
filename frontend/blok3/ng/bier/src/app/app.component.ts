import {Component} from '@angular/core';

@Component({ // annotation = decorator in TS
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {
  title: string = 'bier';
  isVisible = false;
  inputValue = 'tiep hier iets...'

  cars = [
    {make: 'Opel', model: 'Astra', price: 29995},
    {make: 'Porsche', model: '911', price: 145000},
    {make: 'Fiat', model: 'Uno', price: 1800}
  ];

  buttonId = 'veryImportantButton'

  toggle() {
    this.isVisible = !this.isVisible
  }

  resetInputValue() {
    this.inputValue = ''
  }
}
