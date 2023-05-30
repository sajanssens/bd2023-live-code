import {Component} from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeComponent {
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
