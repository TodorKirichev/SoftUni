function solve(stringWords, stringTemplate) {

    let words = stringWords.split(', ');

    let template = stringTemplate.split(' ');

    for (const word of words) {
        
        for (let i = 0; i < template.length; i++) {

            let templateWord = template[i];

            if (word.length === templateWord.length && templateWord.charAt(0) === '*') {
                template[i] = word;
            }
        }
    }

    console.log(template.join(' '));
}

solve('great, learning',
'softuni is ***** place for ******** new programming languages'
);