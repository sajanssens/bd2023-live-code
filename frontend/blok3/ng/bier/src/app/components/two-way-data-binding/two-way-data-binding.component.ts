import {Component} from '@angular/core';

@Component({
  selector: 'app-two-way-data-binding',
  templateUrl: './two-way-data-binding.component.html',
  styleUrls: ['./two-way-data-binding.component.less']
})
export class TwoWayDataBindingComponent {
  inputValue: string = '';

  getallen = [10, 20, 30]

  resetInputValue() {
    this.inputValue = '';
  }
}
