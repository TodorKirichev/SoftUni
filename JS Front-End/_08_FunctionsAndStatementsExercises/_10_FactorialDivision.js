function calculateFactorial(num1, num2) {

    function findFactorial(number) {
        if (number <= 0) {
            return 1;
        }
        return findFactorial(number - 1) * number;
    }
    let facNum1 = findFactorial(num1);
    let facNum2 = findFactorial(num2);

    let result = facNum1 / facNum2;

    console.log(result.toFixed(2));
}

calculateFactorial(6, 2);