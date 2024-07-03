function solve(text, word) {

    function repeat(word) {
        let string = '';
        for (let i = 0; i < word.length; i++) {
            string += '*';
        }
        return string;
    }
    
    let censored = text.replace(word, repeat(word));

    while(censored.includes(word)) {
        censored = censored.replace(word, repeat(word));
    }
    console.log(censored);
}

solve('Find the hidden word', 'hidden');