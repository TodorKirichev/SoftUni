function sumEvenAndOddDigits(number) {

    let stringNumber = number.toString();
    
    function sumEven(stringNumber) {

        let sum = 0;

        for (let i = 0; i < stringNumber.length; i++) {

            let digit = Number(stringNumber.charAt(i));

            if (digit % 2 === 0) {
                sum += digit;
            }
        }

        return sum;
    }

    function sumOdd(stringNumber) {
        
        let sum = 0;

        for (let i = 0; i < stringNumber.length; i++) {

            let digit = Number(stringNumber.charAt(i));

            if (digit % 2 !== 0) {
                sum += digit;          
            }
        }

        return sum;
    }

    let result = `Odd sum = ${sumOdd(stringNumber)}, Even sum = ${sumEven(stringNumber)}`;

    console.log(result);
}

sumEvenAndOddDigits(3495892137259234);