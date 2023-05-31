import {Component, EventEmitter, Input, Output} from '@angular/core';
import {outputAst} from "@angular/compiler";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.less']
})
export class SearchComponent {

  @Input() placeholder = "search terms..."
  @Output() search = new EventEmitter<string>()

  searchterm: string = '';

  handleClick() {
    this.search.emit(this.searchterm)
  }
}
