function solve(input) {
    // let words = input.toLowerCase().split(' ');

    // let oddWords = [];

    // while (words.length > 0) {
    //     let searchedWord = words.shift();
    //     let counter = 1;

    //     for (let i = 0; i < words.length; i++) {
    //         let word = words[i];

    //         if (word === searchedWord) {
    //             counter++;
    //             words.splice(i,1);
    //         }
    //     }
    //     if (counter % 2 !== 0) {
    //         oddWords.push(searchedWord);
    //     }
    // }
    // console.log(oddWords.join(' '));

    let wordsInput = input.toLowerCase().split(' ');

    let words = {};

    for (const word of wordsInput) {
        words[word] = 0;
    }

    for (const word of wordsInput) {
        if (words.hasOwnProperty(word)) {
            words[word]++;
        }
    }

    let result = [];

    for (const key in words) {
        if (words[key] % 2 != 0) {
            result.push(key);
        }
    }

    console.log(result.join(' '));
    
}

solve('Cake IS SWEET is Soft CAKE sweet Food');