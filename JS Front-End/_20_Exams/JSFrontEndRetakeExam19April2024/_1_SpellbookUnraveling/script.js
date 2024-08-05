function solve(commands) {

    let spell = commands.shift();

    let command = commands.shift();
    
    while (command !== 'End') {
        
        if (command.includes('RemoveEven')) {
            let newSpell = '';
            for (let i = 0; i < spell.length; i++) {
                if (i % 2 === 0) {
                    newSpell += spell[i];
                }
            }
            spell = newSpell;
        } else if (command.includes('TakePart')) {
            const startIndex = command.split('!')[1];
            const endIndex = command.split('!')[2];

            spell = spell.slice(startIndex, endIndex);
        } else if (command.includes('Reverse')) {
            const string = command.split('!')[1];
            if (spell.includes(string)) {
                spell = spell.replace(string, '');
                let reversedString = string.split('').reverse().join('');
                spell = spell += reversedString;
            } else {
                console.log('Error');
                command = commands.shift();
                continue;
            }
        }

        console.log(spell);
        command = commands.shift();
    }
    console.log(`The concealed spell is: ${spell}`);
}

solve((["hZwemtroiui5tfone1haGnanbvcaploL2u2a2n2i2m", 
"TakePart!31!42",
"RemoveEven",
"Reverse!anim",
"Reverse!sad",
"End"])
);