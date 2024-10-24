function solve(input) {
    const numOfAstronauts = input.shift();
    const astronauts = {};

    for (let i = 0; i < numOfAstronauts; i++) {
        const [name, oxygen, energy] = input.shift().split(' ');
        
        astronauts[name] = {
            oxygen: Number(oxygen),
            energy: Number(energy)
        }
    }

    let line = input.shift();

    while (line !== 'End') {

        const [command, astronautName, arg1] = line.split(' - ');

        switch(command) {
            case 'Explore':

                const energyNeeded = Number(arg1);

                if (astronauts[astronautName].energy >= energyNeeded) {
                    astronauts[astronautName].energy -= energyNeeded;
                    console.log(`${astronautName} has successfully explored a new area and now has ${astronauts[astronautName].energy} energy!`);
                } else {
                    console.log(`${astronautName} does not have enough energy to explore!`);
                }
                break;

            case 'Refuel':
                const amountEnergy = Number(arg1);
                const currentEnergy = astronauts[astronautName].energy;

                astronauts[astronautName].energy += amountEnergy;

                if (astronauts[astronautName].energy > 200) {
                    astronauts[astronautName].energy = 200;
                }

                console.log(`${astronautName} refueled their energy by ${Math.min((200 - currentEnergy), amountEnergy)}!`);

                break;

            case 'Breathe':
                const amountOxygen = Number(arg1);
                const currentOxygen = astronauts[astronautName].oxygen;

                astronauts[astronautName].oxygen += amountOxygen;

                if (astronauts[astronautName].oxygen > 100) {
                    astronauts[astronautName].oxygen = 100;
                }

                console.log(`${astronautName} took a breath and recovered ${Math.min((100 - currentOxygen), amountOxygen)} oxygen!`);
                break;
        }

        line = input.shift();
    }

    for (const key in astronauts) {
        console.log(`Astronaut: ${key}, Oxygen: ${astronauts[key].oxygen}, Energy: ${astronauts[key].energy}`);
    }
    
}

solve([    '4',
'Alice 60 100',
'Bob 40 80',
'Charlie 70 150',
'Dave 80 180',
'Explore - Bob - 60',
'Refuel - Alice - 30',
'Breathe - Charlie - 50',
'Refuel - Dave - 40',
'Explore - Bob - 40',
'Breathe - Charlie - 30',
'Explore - Alice - 40',
'End']
);