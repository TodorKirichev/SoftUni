function solve(heroes) {

    let listHeroes = [];
    
    for (const hero of heroes) {
        let [name, level, items] = hero.split(' / ');

        let heroObj = {
            name: name,
            level: level,
            items: items
        }

        listHeroes.push(heroObj);
    }

    listHeroes
    .sort((a, b) => a.level - b.level)
    .forEach(h => {
        console.log(`Hero: ${h.name}`);
        console.log(`level => ${h.level}`);
        console.log(`items => ${h.items}`);
    })
}

solve([
    'Batman / 2 / Banana, Gun',
    'Superman / 18 / Sword',
    'Poppy / 28 / Sentinel, Antara'
    ]
    );