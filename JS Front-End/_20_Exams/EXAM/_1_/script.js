function solve(input) {
    const numOfHeroes = input.shift();
    const superHeroes = {};

    for (let i = 0; i < numOfHeroes; i++) {
        const [name, powers, energy] = input.shift().split('-');
        const superHero = {
            name,
            powers: powers.split(','),
            energy: Number(energy)
        }
        superHeroes[name] = superHero;
    }

    let line = input.shift();

    while (line !== 'Evil Defeated!') {

        const [command, superheroName, ...args] = line.split(' * ');
        const superHero = superHeroes[superheroName];

        switch (command) {
            case 'Use Power':
                const superpower = args[0];
                const energyRequired = Number(args[1]);

                if (superHero.energy >= energyRequired && superHero.powers.includes(superpower)) {
                    superHero.energy -= energyRequired;
                    console.log(`${superheroName} has used ${superpower} and now has ${superHero.energy} energy!`);
                } else {
                    console.log(`${superheroName} is unable to use ${superpower} or lacks energy!`);
                }
                break;

            case 'Train':
                const trainingEnergy = Number(args[0]);

                if (superHero.energy === 100) {
                    console.log(`${superheroName} is already at full energy!`);
                } else {
                    console.log(`${superheroName} has trained and gained ${Math.min(trainingEnergy, (100 - superHero.energy))} energy!`);
                    superHero.energy += trainingEnergy;
                    if (superHero.energy > 100) {
                        superHero.energy = 100;
                    }
                }
                break;

            case 'Learn':
                const newSuperpower = args[0];

                if (superHero.powers.includes(newSuperpower)) {
                    console.log(`${superheroName} already knows ${newSuperpower}.`);
                } else {
                    superHero.powers.push(newSuperpower);
                    console.log(`${superheroName} has learned ${newSuperpower}!`);
                }
                break;
        }

        line = input.shift();
    }

    for (const key in superHeroes) {
        console.log(`Superhero: ${key}`);
        console.log(`- Superpowers: ${superHeroes[key].powers.join(', ')}`);
        console.log(`- Energy: ${superHeroes[key].energy}`);
    }
}

solve( ([
    "2",
    "Iron Man-Repulsor Beams,Flight-100",
    "Thor-Lightning Strike,Hammer Throw-50",
    "Train * Thor * 20",
    "Learn * Thor * Hammer Throw",
    "Use Power * Iron Man * Repulsor Beams * 30",
    "Evil Defeated!"
])
);