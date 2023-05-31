import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.less']
})
export class SearchComponent {

  @Input() placeholder = "search terms..."
  @Output() search = new EventEmitter<string>()

  input: string = '';

  go() {
    this.search.emit(this.input)
  }

  clearIfEmpty() {
    if (this.input === '') {
      this.search.emit(this.input)
    }
  }
}
