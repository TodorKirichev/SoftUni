function addItem() {
    const ul = document.getElementById('items');
    const input = document.querySelector('input:first-of-type');
    const text = input.value;

    const newLi = document.createElement('li');
    newLi.textContent = text;

    const a = document.createElement('a');
    a.textContent = '[Delete]';
    a.href = '#';

    newLi.appendChild(a);

    const deleteEl = () => {
        newLi.remove();
    }

    a.addEventListener('click', deleteEl);

    if (text !== '') {
        ul.appendChild(newLi);
    }

    input.value = '';
}