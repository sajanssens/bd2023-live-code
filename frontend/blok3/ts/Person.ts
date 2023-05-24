export class Person {

    // manually create a field:
    private _age: number;
    public shoesize: number = 0;

    /*public by default*/
    nogIets: number = 0;

    //                       creates a private field too, but no get/set
    constructor(age: number, private name: string) {
        this._age = age
    }

    // properties: special syntax for get and set
    public get age() {
        console.log('get age() called')
        return this._age
    }

    public set age(theAge: number) {
        console.log('set age() called')
        this._age = theAge;
    }

    public getName() {
        console.log('getName called')
        return this.name
    }

    public setName(n: string) {
        console.log('setName called')
        this.name = n
    }

}

// test: ---------------------------------

let p = new Person(43, 'Bram')

// age
p.age = 42         // set
console.log(p.age) // get

// not allowed:
// p.name = 'iets'
// let name = p.name

// but:
p.setName('iets')
console.log(p.getName());

let { age, shoesize } = p;   // Object destructuring

// age = 15

console.log(age);
console.log(p.age);
console.log(shoesize);


interface Aged {
    age: number;
}

function printAge(aged: Aged) {
    console.log(aged.age);
}

const frank = { age: 23, name: 'Frank' };
printAge(frank);

interface FrozenPoint {
    readonly x: number;
    readonly y: number;
}
