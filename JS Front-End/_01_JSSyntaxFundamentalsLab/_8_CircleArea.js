function solve(input) {
    
    let result;

    if (typeof(input) === 'number') {
        result = (input ** 2) * Math.PI;
        result = result.toFixed(2);
    } else {
        result = `We can not calculate the circle area, because we receive a ${typeof(input)}.`
    }
    console.log(result);
}

solve('asd');