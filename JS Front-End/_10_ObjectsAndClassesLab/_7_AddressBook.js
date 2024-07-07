function solve(input) {
    
    let list = {};

    for (const info of input) {

        let [name, address] = info.split(':');
        list[name] = address;
    }

    Object.entries(list).sort((a, b) => a[0].localeCompare(b[0])).forEach(person => console.log(`${person[0]} -> ${person[1]}`));
}

solve(['Bob:Huxley Rd',
'John:Milwaukee Crossing',
'Peter:Fordem Ave',
'Bob:Redwing Ave',
'George:Mesta Crossing',
'Ted:Gateway Way',
'Bill:Gateway Way',
'John:Grover Rd',
'Peter:Huxley Rd',
'Jeff:Gateway Way',
'Jeff:Huxley Rd']
);