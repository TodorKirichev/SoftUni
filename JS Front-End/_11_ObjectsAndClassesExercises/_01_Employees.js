function solve(input) {

    let listEmployee = [];
    
    for (const line of input) {
        let name = line;
        let personalNumber = name.length;

        let person = {
            name: name,
            personalNumber: personalNumber
        }

        listEmployee.push(person);
    }

    listEmployee.forEach(e => console.log(`Name: ${e.name} -- Personal Number: ${e.personalNumber}`));
}

solve([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
    ]
    );