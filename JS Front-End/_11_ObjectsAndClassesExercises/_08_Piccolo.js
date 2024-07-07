function solve(input) {
    let parking = [];

    for (const car of input) {
        let [direction, carNumber] = car.split(', ');
        
        if (direction === 'IN' && !parking.includes(carNumber)) {
            parking.push(carNumber);
        }

        if (direction === 'OUT') {
            parking = parking.filter(c => c !== carNumber);
        }
    }

    if (parking.length > 0) {
        parking.sort((a, b) => a.localeCompare(b)).forEach(c => console.log(c));
    } else {
        console.log('Parking Lot is Empty');
    }
}

solve(['IN, CA2844AA',
'IN, CA1234TA',
'OUT, CA2844AA',
'IN, CA9999TT',
'IN, CA2866HI',
'OUT, CA1234TA',
'IN, CA2844AA',
'OUT, CA2866HI',
'IN, CA9876HH',
'IN, CA2822UU']
);
solve(['IN, CA2844AA',
'IN, CA1234TA',
'OUT, CA2844AA',
'OUT, CA1234TA']
);