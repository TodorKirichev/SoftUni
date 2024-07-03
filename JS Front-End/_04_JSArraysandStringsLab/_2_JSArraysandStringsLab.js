function solve(n, arr) {

    let reversedArr = [];
    
    for (let i = n - 1; i >= 0; i--) {
        reversedArr.push(arr[i]);
    }

    console.log(reversedArr.join(' '));
}

solve(4, [-1, 20, 99, 5]);