function solve(text) {
    
    const pattern = /[A-Z][a-z]*/g;

    let arr = text.match(pattern);

    console.log(arr.join(', '));
}

solve('SplitMeIfYouCanHaHaYouCantOrYouCan');