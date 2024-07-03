function clean(arr) {
    let carClean = 0;

    for (const type of arr) {
        switch (type) {
            case 'soap':
                carClean += 10;
                break;
            case 'water':
                carClean *= 1.2;
                break;
            case 'vacuum cleaner':
                carClean *= 1.25;
                break;
            case 'mud':
                carClean *= 0.9;
                break;
        }
    }

    console.log(`The car is ${carClean.toFixed(2)}% clean.`);
}

clean(['soap', 'soap', 'vacuum cleaner', 'mud', 'soap', 'water']);