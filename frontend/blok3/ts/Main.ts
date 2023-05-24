import {Person} from "./Person";
import {PipeTransform} from "./InterfaceDemo";

let p2: Person = new Person(43, "")

const concatPipe: PipeTransform = {
    transform(name: string, ...args: any[]): string {
        return [name, ...args].join(' ');
    },
};

class CSVPipe implements PipeTransform {
    transform(value: any, ...args: any[]): any {
        return [value, ...args].join(',');
    }
}

console.log(concatPipe.transform("Hallo", "ik", "ben"));
console.log(new CSVPipe().transform("Hallo", "ik", "ben"));
