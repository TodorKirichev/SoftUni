function changeNumber(number) {

    function checkAverage(num) {
        let sumDigits = 0;
        for (let i = 0; i < num.toString().length; i++) {
            sumDigits += Number(num.toString()[i]);
        }
        if (sumDigits / num.toString().length > 5) {
            return true;
        } else {
            return false;
        }
    }

    while (!checkAverage(number)) {
        number = Number(number.toString() + 9);
    }

    console.log(number);
}

changeNumber(5835);