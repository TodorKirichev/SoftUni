function checkSameDigits(number) {
    
    let numberString = String(number);
    let isSame = true;
    let sum = 0;

    for (let i = 0; i < numberString.length; i++) {
        if (numberString.charAt(i) != numberString.charAt(0)) {
            isSame = false;
        }        
        sum += Number(numberString.charAt(i));
    }

    console.log(isSame);
    console.log(sum);
}

checkSameDigits(1234);