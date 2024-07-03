function checkSign(first, second, third) {

    function getSign(number) {
        return number < 0;
    }

    if (getSign(first) && !getSign(second) && !getSign(third) 
        || !getSign(first) && getSign(second) && !getSign(third) 
        || !getSign(first) && !getSign(second) && getSign(third)
        || getSign(first) && getSign(second) && getSign(third)) {
        console.log('Negative');
    } else {
        console.log('Positive');
    }
    
}

checkSign(-6,
    -12,
     14
    );