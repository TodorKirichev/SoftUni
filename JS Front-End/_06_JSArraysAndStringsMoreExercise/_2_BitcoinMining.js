function solve(arr) {
    
    const bitcoinPrice = 11949.16;
    const goldPrice = 67.51;

    let money = 0;

    let bitcoinsBought = 0;
    let firstBitcoin = 0;

    for (let i = 1; i <= arr.length; i++) {
        money += arr[i - 1] * goldPrice;

        if (i % 3 === 0) {
            money -= (arr[i - 1] * goldPrice) * 0.3;
        }
        
        while (money >= bitcoinPrice) {
            bitcoinsBought++;
            money -= bitcoinPrice;
            if (firstBitcoin) {
                continue;
            } else {
                firstBitcoin = i;
            }
        }
    }

    console.log(`Bought bitcoins: ${bitcoinsBought}`);
    if (firstBitcoin) {
        console.log(`Day of the first purchased bitcoin: ${firstBitcoin}`);
    }
    console.log(`Left money: ${money.toFixed(2)} lv.`);
}

solve([100, 200, 300]);
solve([50, 100]);
solve([3124.15, 504.212, 2511.124]);