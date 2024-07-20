function solve() {
   const addButtons = document.querySelectorAll('.add-product');
   let textarea = document.querySelector('textarea');
   const checkoutButton = document.querySelector('.checkout');
   const products = {};

   Array.from(addButtons).forEach(b => b.addEventListener('click', addProduct));

   function addProduct(e) {
      const name = e.target.parentNode.parentNode.querySelector('.product-title').textContent;
      const price = Number(e.target.parentNode.parentNode.querySelector('.product-line-price').textContent);
      if (products[name]) {
         products[name] += price;
      } else {
         products[name] = price;
      }
      textarea.textContent += `Added ${name} for ${price.toFixed(2)} to the cart.\n`;
   }

   checkoutButton.addEventListener('click', calculateTotalMoney);

   function calculateTotalMoney(e) {
      let totalPrice = Object.values(products).reduce((acc,p) => acc + p, 0);
      Array.from(addButtons).forEach(b => b.setAttribute('disabled', 'disabled'));
      checkoutButton.setAttribute('disabled', 'disabled');
      textarea.textContent += `You bought ${Object.keys(products).join(', ')} for ${totalPrice.toFixed(2)}.`;
   }
}