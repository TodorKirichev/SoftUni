function solve(stock, products) {

    let listStock = [];
    
    for (let i = 0; i < stock.length; i+=2) {
        let productName = stock[i];
        let quantity = stock[i + 1];
        
        let product = {
            name: productName,
            quantity: Number(quantity)
        }
        listStock.push(product)
    }

    let listDelivery = [];

    for (let i = 0; i < products.length; i+=2) {
        let productName = products[i];
        let quantity = products[i + 1];
        
        let product = {
            name: productName,
            quantity: Number(quantity)
        }
        listDelivery.push(product);
    }

    // let productsStock = listStock.map(p => p.name);

    // for (const productD of listDelivery) {
    //     if (productsStock.includes(productD.name)) {
    //         listStock.filter(p => p.name === productD.name).map(p => p.quantity += productD.quantity);
    //     } else {
    //         listStock.push(productD);
    //     }
    // }

    for (const productD of listDelivery) {
        let productS = listStock.find(p => p.name === productD.name);

        if (productS) {
            productS.quantity += productD.quantity;
        } else {
            listStock.push(productD)
        }
    }

    listStock.forEach(p => console.log(`${p.name} -> ${p.quantity}`))
}

solve([
    'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
    ],
    [
    'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
    ]
    );