function solve(input) {

    class Cat {
        constructor(name, age) {
            this.catName = name;
            this.age = age;
        }

        meow() {
            console.log(`${this.catName}, age ${this.age} says Meow`);
        }
    }

    let cats = [];

    for (const info of input) {
        let [name, age] = info.split(' ');

        let cat = new Cat(name, age);

        cats.push(cat);
    }

    cats.forEach(cat => cat.meow());
}

solve(['Mellow 2', 'Tom 5']);