function solve(input) {
    const numOfHeroes = Number(input.shift());
    let heroes = [];

    for (let i = 0; i < numOfHeroes; i++) {
        const heroInfo = input.shift().split(' ');
        const name = heroInfo[0];
        const hp = heroInfo[1];
        const bullets = heroInfo[2];

        const hero = {
            name,
            hp,
            bullets
        }

        heroes.push(hero);
    }

    let command = input.shift();

    while (command !== 'Ride Off Into Sunset') {
        
        const [commandName, arg1, arg2, arg3] = command.split(' - ');
        let attacker;
        let target;
        
        switch (commandName) {
            case 'FireShot':
                attacker = heroes.find(h => h.name === arg1);
                target = arg2;

                if (attacker.bullets > 0) {
                    attacker.bullets -= 1;
                    console.log(`"${attacker.name} has successfully hit ${target} and now has ${attacker.bullets} bullets!`);
                } else {
                    console.log(`${attacker.name} doesn't have enough bullets to shoot at ${target}!`);
                }
            break;

            case 'TakeHit':
                target = heroes.find(h => h.name === arg1);
                let dmg = arg2;
                attacker = arg3;
                target.hp -= dmg;

                if (target.hp > 0) {
                    console.log(`${target.name} took a hit for ${dmg} HP from ${attacker} and now has ${target.hp} HP!`);
                } else {
                    console.log(`${target.name} was gunned down by ${attacker}!`);
                    heroes = heroes.filter(h => h.hp > 0);
                }

                break;
            
            case 'Reload':
                attacker = heroes.find(h => h.name === arg1);
                const currentBullets = Number(attacker.bullets);
                if (currentBullets < 6) {
                    attacker.bullets = 6;
                    console.log(`${attacker.name} reloaded ${6 - currentBullets} bullets!`);
                } else {
                    console.log(`${attacker.name}'s pistol is fully loaded!`);
                }
                break;

            case 'PatchUp':
                attacker = heroes.find(h => h.name === arg1);
                let amount = Number(arg2);

                if (attacker.hp < 100) {
                    attacker.hp += amount;
                    if (attacker.hp > 100) {
                        attacker.hp = 100;
                    }
                    console.log(`${attacker.name} patched up and recovered ${Math.min(100 - attacker.hp, amount)} HP!`);
                } else {
                    console.log(`${attacker.name} is in full health!`);
                }
                break;
        }

        command = input.shift();
    }
    heroes.forEach(h => {
        console.log(`${h.name}\n HP: ${h.hp}\n Bullets: ${h.bullets}`);
    })
}

solve();