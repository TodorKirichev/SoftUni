function solve(text, word) {
    
    let counter = 0;

    let arrOfWords = text.split(/\s+/);

    for (const e of arrOfWords) {
        if (e === word) {
            counter++;
        }
    }
    console.log(counter);
}

solve('softuni is great place for learning new programming languages',
'softuni'
);