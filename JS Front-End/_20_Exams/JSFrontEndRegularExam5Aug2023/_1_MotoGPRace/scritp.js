function solve(input) {
    const numOfRIders = input.shift();

    const riders = {};

    for (let i = 0; i < numOfRIders; i++) {
        const [riderName, fuelCapacity, position] = input.shift().split('|');

        riders[riderName] = {
            fuelCapacity :Number(fuelCapacity),
            position: Number(position)
        }
    }

    let line = input.shift();

    while (line !== 'Finish') {

        const [command, rider, arg1, arg2] = line.split(' - ');

        switch(command) {
            case 'StopForFuel':
                const minFuel = Number(arg1);
                const changedPosition = Number(arg2);

                if (riders[rider].fuelCapacity < minFuel) {
                    riders[rider].position = changedPosition;
                    console.log(`${rider} stopped to refuel but lost his position, now he is ${changedPosition}.`);
                } else {
                    console.log(`${rider} does not need to stop for fuel!`);
                }
                break;
            case 'Overtaking':
                const rider2 = arg1;
                const rider1Position = riders[rider].position;
                const rider2Position = riders[rider2].position;

                if (rider1Position < rider2Position) {
                    riders[rider].position = rider2Position;
                    riders[rider2].position = rider1Position;
                    console.log(`${rider} overtook ${rider2}!`);
                }
                break;
            case 'EngineFail':
                const lapsLeft = Number(arg1);

                delete riders[rider];
                console.log(`${rider} is out of the race because of a technical issue, ${lapsLeft} laps before the finish.`);
                break;
        }

        line = input.shift();
    }

    for (const key in riders) {
        console.log(key);
        console.log(`  Final position: ${riders[key].position}`);
    }
}

solve((["4",
"Valentino Rossi|100|1",
"Marc Marquez|90|3",
"Jorge Lorenzo|80|4",
"Johann Zarco|80|2",
"StopForFuel - Johann Zarco - 90 - 5",
"Overtaking - Marc Marquez - Jorge Lorenzo",
"EngineFail - Marc Marquez - 10",
"Finish"])
);