function solve(input) {
    let words = input.shift().split(' ');

    let searchedWords = {};

    for (const word of words) {
        searchedWords[word] = 0;
    }

    for (const word of input) {
       if (searchedWords.hasOwnProperty(word)) {
        searchedWords[word] += 1;
       }
    }

    
    let sorted = Object.entries(searchedWords).sort((a, b) => b[1] - a[1]);

    searchedWords = Object.fromEntries(sorted);

    for (const key in searchedWords) {
        console.log(`${key} - ${searchedWords[key]}`);
    }

}

solve([
    'is the', 
    'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence']
    )