function solve(string) {
    
    let arr = string.toUpperCase().match(/\w+/g);

    console.log(arr.join(', '));
    
}

solve('Hi, how are you?');