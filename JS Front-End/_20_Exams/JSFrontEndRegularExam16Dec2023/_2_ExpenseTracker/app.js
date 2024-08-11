window.addEventListener("load", solve);

function solve() {
    const addButton = document.querySelector('#add-btn');
    const previewList = document.querySelector('#preview-list');
    const expenseInput = document.querySelector('#expense');
    const amountInput = document.querySelector('#amount');
    const dateInput = document.querySelector('#date');
    const expenseList = document.querySelector('#expenses-list');
    const deleteButton = document.querySelector('.btn.delete');

    addButton.addEventListener('click', addExpense);

    function addExpense() {
        const isValidInputs = expenseInput.value !== '' & amountInput.value !== '' && dateInput.value !== '';

        if (isValidInputs) {
            const li = document.createElement('li');
        li.classList.add('expense-item');

        const article = document.createElement('article');

        const type = document.createElement('p');
        type.textContent = `Type: ${expenseInput.value}`;

        const amount = document.createElement('p');
        amount.textContent = `Amount: ${amountInput.value}$`;

        const date = document.createElement('p');
        date.textContent = `Date: ${dateInput.value}`;

        article.appendChild(type);
        article.appendChild(amount);
        article.appendChild(date);

        const buttonContainer = document.createElement('div');
        buttonContainer.classList.add('buttons');

        const editButton = document.createElement('button');
        editButton.classList.add('btn', 'edit');
        editButton.textContent = 'edit';

        editButton.addEventListener('click', editExpense);

        function editExpense() {
            expenseInput.value = type.textContent.split(': ')[1];
            amountInput.value = amount.textContent.split(': ')[1].split('$')[0];
            dateInput.value = date.textContent.split(': ')[1];

            li.remove();

            addButton.removeAttribute('disabled');
        }

        const okButton = document.createElement('button');
        okButton.classList.add('btn', 'ok');
        okButton.textContent = 'ok';

        okButton.addEventListener('click', addToExpenseList);

        function addToExpenseList() {
            buttonContainer.remove();

            expenseList.appendChild(li);

            addButton.removeAttribute('disabled');
        }

        buttonContainer.appendChild(editButton);
        buttonContainer.appendChild(okButton);

        li.appendChild(article);
        li.appendChild(buttonContainer);

        previewList.appendChild(li);

        addButton.disabled = 'disabled';

        expenseInput.value = '';
        amountInput.value = '';
        dateInput.value = '';
        }
    }

    deleteButton.addEventListener('click', reload);

    function reload() {
        location.reload();
    }
}