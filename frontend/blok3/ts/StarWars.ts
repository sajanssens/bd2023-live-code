// let y: Jedi = {age: 17700, name: 'Yoda'};

class Jedi {

    age?: number = 0
    name: string

    constructor(a?: number, n = "unknown") {
        this.age = a
        this.name = n
    }

    doeIetsMetAge() {
        let j = 0
        if (this.age !== undefined) {
            j = this.age.valueOf()
        }
        // ... is hetzelfde als:
        let i = this.age?.valueOf() ?? 0
    }
}

let y1 = new Jedi()
y1.doeIetsMetAge()
let yToo = new Jedi(42)
let yToo2 = new Jedi(42, "xyz")
let yToo3 = new Jedi(undefined, "xyz")

yToo.age = 17700
yToo.name = "Yoda"

