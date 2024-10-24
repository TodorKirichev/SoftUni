function solve(input) {
    const numOfBaristas = input.shift();

    const baristas = {};

    for (let i = 0; i < numOfBaristas; i++) {
        const [name, shift, listOfCoffees] = input.shift().split(" ");

        baristas[name] = {
            shift,
            listOfCoffees: listOfCoffees.split(',')
        }
    }
    let command = input.shift();

    while (command !== 'Closed') {

        const [commandName, baristaName, arg1, arg2] = command.split(' / ');

        switch(commandName) {
            case 'Prepare':
                const shift = arg1;
                const coffeeType = arg2;
                if (baristas[baristaName].shift === shift && baristas[baristaName].listOfCoffees.includes(coffeeType)) {
                    console.log(`${baristaName} has prepared a ${coffeeType} for you!`);
                } else {
                    console.log(`${baristaName} is not available to prepare a ${coffeeType}.`);
                }
                break;
            case 'Change Shift':
                const newShift = arg1;
                baristas[baristaName].shift = newShift;
                console.log(`${baristaName} has updated his shift to: ${newShift}`);
                break;
            case 'Learn':
                const newCoffeeType = arg1;
                if (baristas[baristaName].listOfCoffees.includes(newCoffeeType)) {
                    console.log(`${baristaName} knows how to make ${newCoffeeType}.`);
                } else {
                    baristas[baristaName].listOfCoffees.push(newCoffeeType);
                    console.log(`${baristaName} has learned a new coffee type: ${newCoffeeType}.`);
                }
                break;
        }

        command = input.shift();
    }

    for (const key in baristas) {
        console.log(`Barista: ${key}, Shift: ${baristas[key].shift}, Drinks: ${baristas[key].listOfCoffees.join(', ')}`);
    }
}

solve([
    '3',
      'Alice day Espresso,Cappuccino',
      'Bob night Latte,Mocha',
      'Carol day Americano,Mocha',
      'Prepare / Alice / day / Espresso',
      'Change Shift / Bob / night',
      'Learn / Carol / Latte',
      'Learn / Bob / Latte',
      'Prepare / Bob / night / Latte',
      'Closed']
    );