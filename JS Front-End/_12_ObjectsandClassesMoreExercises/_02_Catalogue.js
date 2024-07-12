function solve(input) {

    let objects = [];

    for (const obj of input) {
        let[name, price] = obj.split(' : ');

        let newObj = {
            name,
            price
        }

        objects.push(newObj);
    }
    objects.sort((a, b) => (a.name).localeCompare(b.name));

    let firstGroupChar = objects[0].name.charAt(0);
    console.log(firstGroupChar);
    
    for (const object of objects) {
        if (object.name.charAt(0) !== firstGroupChar) {
            firstGroupChar = object.name.charAt(0);
            console.log(firstGroupChar);
        }

        console.log(`${object.name}: ${object.price}`);

    }
    
}

solve([
    'Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10'
    ]);