// import {AdDao} from "./classesandinterfaces/AdDao";
//
// // let p2: Person = new Person(43, "")
// //
// // const concatPipe: PipeTransform = {
// //     transform(name: string, ...args: any[]): string {
// //         return [name, ...args].join(' ');
// //     },
// // };
// //
// // class CSVPipe implements PipeTransform {
// //     transform(value: any, ...args: any[]): any {
// //         return [value, ...args].join(',');
// //     }
// // }
// //
// // console.log(concatPipe.transform("Hallo", "ik", "ben"));
// // console.log(new CSVPipe().transform("Hallo", "ik", "ben"));
//
// // const ditIsEenObject = {}
//
//
// const response = `{
//     "title": "Hitchhikers",
//     "price": 42,
//     "user": {
//         "email": "arthur.dent@douglas-adams.co.uk",
//         "password": "928y9ghnfe89t"
//     }
// }`
//
// const ad = JSON.parse(response) as AdDto // is een object van type any
// const dao = new AdDao()
//
// dao.markAsSold(ad)
// console.log(ad);
//
// function markAsSold(ad: AdDto) {
//     ad.sold = true
// }

let car = {make: 'Tesla', model: 'Model X', price: 62000, id: 1}
console.log(JSON.stringify(car));

const ages = [car, car, car];

function checkAge(age: number) {
    return age > 10;
}

function myFunction() {
    ages.find((c) => c.id < 10);
}

main();

function main() {
    const han = {
        name: 'Han Solo',
        age: 42
    };

    const {name, age} = han; // Object destructuring

    console.log(`${name} is ${age}`);
}

