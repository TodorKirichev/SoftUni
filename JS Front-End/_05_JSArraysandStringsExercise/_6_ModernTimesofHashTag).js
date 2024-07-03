function solve(string) {
    
    const pattern = /[#][a-zA-Z]+/g;

    const matches = string.match(pattern);

    matches.forEach(element => {
        let finalEl = element.replace('#', '');
        console.log(finalEl);
    });
}

solve('Nowadays everyone uses # to tag a #special word in #socialMedia');