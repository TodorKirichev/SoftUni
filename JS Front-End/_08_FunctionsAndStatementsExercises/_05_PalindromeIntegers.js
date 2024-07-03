function solve(arr) {

    function checkPalindromes(number) {
        let numAsString = number.toString();

        for (let i = 0; i < numAsString.length / 2; i++) {
            if (numAsString[i] !== numAsString[numAsString.length - 1 - i]) {
                return false;
            }
            return true;
        }
    }
    
    for (const number of arr) {
        console.log(checkPalindromes(number));
    }

}

solve([123,323,421,121]);
solve([32,2,232,1010]);