function printMatrix(number) {

    let createRow = number => (number + " ").repeat(number);

    for (let i = 0; i < number; i++) {
        console.log(createRow(number)); 
    }

}

printMatrix(7);