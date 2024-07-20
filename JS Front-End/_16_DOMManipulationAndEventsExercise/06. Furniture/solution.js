function solve() {

  const input = document.querySelector('#exercise textarea:first-of-type');
  const generateBtn = document.querySelector('#exercise button:first-of-type');

  let output = document.querySelector('#exercise textarea:last-of-type');
  const buyBtn = document.querySelector('#exercise button:last-of-type');

  const table = document.querySelector('tbody');

  let totalPrice = 0;

  generateBtn.addEventListener('click', generate);

  function generate() {
    const furnitures = JSON.parse(input.value);

    for (const furniture of furnitures) {
      let tr = document.createElement('tr');
      
      let tdImg = document.createElement('td');
      let img = document.createElement('img');
      img.setAttribute('src', furniture.img);
      tdImg.appendChild(img);
      tr.appendChild(tdImg);
      
      let tdName = document.createElement('td');
      tdName.classList.add('name');
      let pName = document.createElement('p');
      pName.textContent = furniture.name;
      tdName.appendChild(pName);
      tr.appendChild(tdName);
      
      let tdPrice = document.createElement('td');
      tdPrice.classList.add('price');
      let pPrice = document.createElement('p');
      pPrice.textContent = furniture.price;
      tdPrice.appendChild(pPrice);
      tr.appendChild(tdPrice);
      
      let tdDecFactor = document.createElement('td');
      tdDecFactor.classList.add('decFactor');
      let pDecFactor = document.createElement('p');
      pDecFactor.textContent = furniture.decFactor;
      tdDecFactor.appendChild(pDecFactor);
      tr.appendChild(tdDecFactor);

      let tdCheckbox = document.createElement('td');
      let input = document.createElement('input');
      input.setAttribute('type', 'checkbox');
      tdCheckbox.appendChild(input);
      tr.appendChild(tdCheckbox);

      console.log(tr);
      table.appendChild(tr);
    }
  }

  buyBtn.addEventListener('click', buy);

  function buy() {
    let checkedItems = [];
    const inputs = document.querySelectorAll('input');
    let totalDecFactor = 0;
    let numOfCheckedItems = 0;

    for (const input of inputs) {
      if (input.checked) {
        let name = input.parentElement.parentElement.querySelector('td.name p').textContent;
        let price = Number(input.parentElement.parentElement.querySelector('td.price p').textContent);
        let decFactor = Number(input.parentElement.parentElement.querySelector('td.decFactor p').textContent);
        totalDecFactor += decFactor;
        numOfCheckedItems++;
        totalPrice += price;
        checkedItems.push(name);
      }
    }

    let avgDecFactor = totalDecFactor / numOfCheckedItems;
    output.value += `Bought furniture: ${checkedItems.join(', ')}\n`;
    output.value += `Total price: ${totalPrice.toFixed(2)}\n`;
    output.value += `Average decoration factor: ${avgDecFactor}`;
  }
}