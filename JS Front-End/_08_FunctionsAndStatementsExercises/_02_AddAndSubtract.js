function calculate(first, second, third) {
    
    function sum(a, b) {
        return a + b;
    }

    function subtract(a, b) {
        return a - b;
    }

    return subtract(sum(first,second), third);
}

console.log(calculate(1,
    17,
    30
    ));