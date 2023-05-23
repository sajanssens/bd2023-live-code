class HelloWorld {
    static sayHello(m: string): void {
        let data: string = 'Hello world';
        console.log(data);
    }
}

HelloWorld.sayHello('Bram');

let jedi = 'yoda'; // type inference
// jedi = 2

let n = 3;
const pi = 3.14;
// @ts-ignore
const bigInt = 9007199254740992n;
const str = 'a string using "single quotes"';
const foo1 = Symbol('foo');
const foo2 = Symbol('foo');
const bar = Symbol('bar');
const bool = true;
const nu77 = null;
const und = undefined;

function check(s: Symbol) {

}

const str3 =
    `a string using back ticks
     can be multi line
     pi is: ${pi}, or (${Math.floor(pi)})`;

console.log(typeof null)
console.log(typeof undefined)

let x: null = null





