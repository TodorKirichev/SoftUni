function addItem() {
    const ul = document.getElementById('items');
    const input = document.querySelector('input:first-of-type');
    const text = input.value;

    const newLi = document.createElement('li');
    newLi.textContent = text;
    ul.appendChild(newLi);

    input.value = '';
}