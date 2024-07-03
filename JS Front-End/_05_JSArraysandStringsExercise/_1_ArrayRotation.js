function solve(arr, rotations) {
    
    let rotatedArr = arr.slice();

    for (let i = 0; i < rotations; i++) {
        let element = rotatedArr.shift();
        rotatedArr.push(element);        
    }

    console.log(rotatedArr.join(' '));
}

solve([2, 4, 15, 31], 5);