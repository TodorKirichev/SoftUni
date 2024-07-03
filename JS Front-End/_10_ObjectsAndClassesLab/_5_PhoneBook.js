function solve(arr) {

    let collection = {};

    for (const person of arr) {
        let name = person.split(' ')[0];
        let phone = person.split(' ')[1];

        collection[name] = phone;
    }

    Object.entries(collection).forEach(entry => console.log(`${entry[0]} -> ${entry[1]}`));
}

solve(['Tim 0834212554',
'Peter 0877547887',
'Bill 0896543112',
'Tim 0876566344']
);