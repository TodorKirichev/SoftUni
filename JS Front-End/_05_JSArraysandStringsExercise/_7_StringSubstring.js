function solve(word, text) {

    let arr = text.toLowerCase().split(' ');

    if (arr.includes(word)) {
        console.log(word);
    } else {
        console.log(`${word} not found!`);
    }
}

solve('javascript',
'JavaScript is the best programming language'
);