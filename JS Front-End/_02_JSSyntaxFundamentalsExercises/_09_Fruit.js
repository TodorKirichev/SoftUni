function calculatePrice(fruit, weight, money) {

    let weightInKg = (weight / 1000);
    
    console.log(`I need $${(money * weightInKg).toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${fruit}.`);
}

calculatePrice('apple', 1563, 2.35);