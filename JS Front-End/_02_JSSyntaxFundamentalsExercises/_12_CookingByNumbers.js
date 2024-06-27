function cookingByNumbers(num, ...arr) {
    let number = Number(num);

    for (const command of arr) {
        switch (command) {
            case 'chop':
                number /= 2;
                break;
            case 'dice':
                number = Math.sqrt(number);
                break;
            case 'spice':
                number += 1;
                break;
            case 'bake':
                number *= 3;
                break;
            case 'fillet':
                number -= number * 0.2;
                break;
        }
        console.log(number);
    }
}

cookingByNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet');