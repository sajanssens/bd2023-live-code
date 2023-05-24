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

  buttonId = 'veryImportantButton'

  toggle() {
    this.isVisible = !this.isVisible
  }

  resetInputValue() {
    this.inputValue = ''
  }
}
