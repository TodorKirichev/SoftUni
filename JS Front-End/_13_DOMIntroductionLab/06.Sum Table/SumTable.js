function sumTable() {
    const prices = document.querySelectorAll('table tr:not(:last-of-type) td:last-of-type');
    const total = document.querySelector('#sum');
    
    let sum = 0;
    
    for (const price of prices) {
        sum += Number(price.textContent);
        }
    console.log(sum);

    total.textContent = sum;
}