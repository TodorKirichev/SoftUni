function solve(arr) {

    let user = arr.shift();

    let passwords = arr;
    
    let correctPassword = '';

    for (let i = user.length - 1; i >= 0; i--) {
        correctPassword += user[i];       
    }

    let counter = 1;

    for (const password of passwords) {
        if (password === correctPassword) {
            console.log(`User ${user} logged in.`);
            return;
        } else if (counter < 4) {
            console.log('Incorrect password. Try again.');
        } else {
            console.log(`User ${user} blocked!`);
            return;
        }
        counter++;
    }
}

solve(['Acer','login','go','let me in','recA']);
solve(['sunny','rainy','cloudy','sunny','not sunny']);