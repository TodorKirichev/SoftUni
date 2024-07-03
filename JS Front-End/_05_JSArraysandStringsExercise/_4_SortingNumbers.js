function solve(arr) {

    let length = arr.length;
    
    let sorted = arr.sort(function(a, b) {
        return a - b
    });

    let final = [];

    if (length % 2 === 0) {
        for (let i = 0; i < length / 2; i++) {
            final.push(sorted.shift());
            final.push(sorted.pop());        
        }
    } else {
        for (let i = 0; i < (length - 1) / 2; i++) {
            final.push(sorted.shift());
            final.push(sorted.pop());        
        }
        final.push(sorted.pop());        
    }

    return final;
}

solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);