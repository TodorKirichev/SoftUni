function checkLoading(number) {
    
    let result = [];

        for (let i = 0; i < 10; i++) {
            result[i] = '.'        
        }

    for (let i = 0; i < number / 10; i++) {
        result[i] = '%';        
    }

    let finalResult = `${number}% [${result.join('')}]`;

    if (number < 100) {
        console.log(finalResult);
        console.log('Still loading...');
    } else {
        console.log('100% Complete!');
        console.log(`[${result.join('')}]`);
    }
    
}

checkLoading(100);