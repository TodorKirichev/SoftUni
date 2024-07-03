function solve(lostFights, helmet, sword, shield, armor) {

    let totalPrice = 0;

    for (let i = 1; i <= lostFights; i++) {
        if (i % 2 === 0) {
            totalPrice += helmet;
        }
        if (i % 3 === 0) {
            totalPrice += sword;
        }
        if (i % 6 === 0) {
            totalPrice += shield;
        }
        if (i % 12 === 0) {
            totalPrice += armor;
        }
    }

    console.log(`Gladiator expenses: ${totalPrice.toFixed(2)} aureus`);
}

solve(23,
    12.50,
    21.50,
    40,
    200
    );