function sumOfDigits(number) {

    let sum = 0;
    
    for (const iterator of String(number)) {
        sum += Number(iterator);
    }

    console.log(sum);
}

sumOfDigits(245678);