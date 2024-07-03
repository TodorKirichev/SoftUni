function solve(arr) {
    
    let sumEven = 0;
    let sumOdd = 0;

    for (const e of arr) {
        if (e % 2 === 0) {
            sumEven += e;
        } else {
            sumOdd += e;
        }
    }

    const diff = sumEven - sumOdd;
    console.log(diff);
}

solve([3,5,7,9]);