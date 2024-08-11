const URL = 'http://localhost:3030/jsonstore/gifts/';
const loadPresentsButton = document.querySelector('#load-presents');
const giftList = document.querySelector('#gift-list');
const addPresentButton = document.querySelector('#add-present');
const editPresentButton = document.querySelector('#edit-present');
const giftInput = document.querySelector('#gift');
const forInput = document.querySelector('#for');
const priceInput = document.querySelector('#price');
let currentId;

loadPresentsButton.addEventListener('click', loadPresents);

function loadPresents() {
    fetch(URL)
        .then(res => res.json())
        .then(presents => {
            
            giftList.innerHTML = "";

            Object.values(presents).forEach(present => {

                const divGiftSock = document.createElement('div');
                divGiftSock.classList.add('gift-sock');

                const divContent = document.createElement('div');
                divContent.classList.add('content');

                const divButtonsContainer = document.createElement('div');
                divButtonsContainer.classList.add('buttons-container');

                const pPresent = document.createElement('p');
                pPresent.textContent = present.gift;

                const pFor = document.createElement('p');
                pFor.textContent = present.for;

                const pPrice = document.createElement('p');
                pPrice.textContent = present.price;

                divContent.appendChild(pPresent);
                divContent.appendChild(pFor);
                divContent.appendChild(pPrice);

                const changeButton = document.createElement('button');
                changeButton.classList.add('change-btn');
                changeButton.textContent = 'Change';

                changeButton.addEventListener('click', changePresent);

                function changePresent() {
                    giftInput.value = pPresent.textContent;
                    forInput.value = pFor.textContent;
                    priceInput.value = pPrice.textContent;

                    currentId = present._id;

                    divGiftSock.remove();

                    addPresentButton.disabled = 'disabled';
                    editPresentButton.removeAttribute('disabled');
                }

                const deleteButton = document.createElement('button');
                deleteButton.classList.add('delete-btn');
                deleteButton.textContent = 'Delete';

                deleteButton.addEventListener('click',deletePresent);

                function deletePresent() {
                    fetch(`${URL}${present._id}`, {
                        method: 'DELETE',
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    })
                    .then(loadPresents);
                }

                divButtonsContainer.appendChild(changeButton);
                divButtonsContainer.appendChild(deleteButton);

                divGiftSock.appendChild(divContent);
                divGiftSock.appendChild(divButtonsContainer);

                giftList.appendChild(divGiftSock);
            })
        })
}

addPresentButton.addEventListener('click', addPresent);

function addPresent() {
    
    const newPresent = {
        gift: giftInput.value,
        for: forInput.value,
        price: priceInput.value
    }

    fetch(URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newPresent)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to update present');
            }
            return response.json();
        })
        .then(loadPresents)
        .catch(error => console.error('Error:', error));

    cleanInputs();
}

editPresentButton.addEventListener('click', editPresent);

function editPresent() {

    const updatedPresent = {
        gift: giftInput.value,
        for: forInput.value,
        price: priceInput.value,
        _id: currentId
    }
    console.log(currentId);

    fetch(`${URL}${currentId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedPresent)
    })
    .then(loadPresents);

    addPresentButton.removeAttribute('disabled');
    editPresentButton.disabled = 'disabled';

    cleanInputs();
}

function cleanInputs() {
    giftInput.value = '';
    forInput.value = '';
    priceInput.value = '';
}