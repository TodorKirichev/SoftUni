function addItem() {

    const menu = document.querySelector('#menu');
    let newItemText = document.querySelector('#newItemText');
    let newItemValue = document.querySelector('#newItemValue');
    
    const newOption = document.createElement('option');
    newOption.textContent = newItemText.value;
    newOption.value = newItemValue.value 
    if (newItemText.value !== '' && newItemValue.value !== '') {
         menu.appendChild(newOption);
        newItemText.value = '';
        newItemValue.value = '';
    }
}