const URL = 'http://localhost:3030/jsonstore/records';
const loadRecordsButton = document.querySelector('#load-records');
const ul = document.querySelector('#list');
const addRecordButton = document.querySelector('#add-record');
const nameInput = document.querySelector('#p-name');
const stepsInput = document.querySelector('#steps');
const caloriesInput = document.querySelector('#calories');
const editRecordButton = document.querySelector('#edit-record');
let currentLiElements = [];
let changeButtons = [];

loadRecordsButton.addEventListener('click',loadRecords);

function loadRecords(e) {

    ul.innerHTML = '';

    fetch(URL)
    .then(res => res.json())
    .then(records => {
        console.log(records);
        Object.values(records).forEach(record => {
            const pName = document.createElement('p');
            pName.textContent = record.name;

            const pSteps = document.createElement('p');
            pSteps.textContent = record.steps;

            const pCalories = document.createElement('p');
            pCalories.textContent = record.calories;

            const divInfo = document.createElement('div');
            divInfo.classList.add('info');
            divInfo.appendChild(pName);
            divInfo.appendChild(pSteps);
            divInfo.appendChild(pCalories);

            const changeButton = document.createElement('button');
            changeButton.classList.add('change-btn');
            changeButton.textContent = 'Change';

            changeButtons.push(changeButton);

            changeButton.addEventListener('click', changeRecord);

            function changeRecord() {
                nameInput.value = pName.textContent;
                stepsInput.value = pSteps.textContent;
                caloriesInput.value = pCalories.textContent;
                currentChangeRecordId = record._id;

                addRecordButton.disabled = 'disabled';
                editRecordButton.removeAttribute('disabled');
                currentChangeRecordId = record._id;
            }

            const deleteButton = document.createElement('button');
            deleteButton.classList.add('delete-btn');
            deleteButton.textContent = 'Delete';

            deleteButton.addEventListener('click', deleteRecord);

            function deleteRecord() {
                fetch(`${URL}/${record._id}`,{
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                loadRecords();
            }

            const buttonContainer = document.createElement('div');
            buttonContainer.classList.add('btn-wrapper');
            buttonContainer.appendChild(changeButton);
            buttonContainer.appendChild(deleteButton);

            const liElement = document.createElement('li');
            liElement.classList.add('record');
            liElement.appendChild(divInfo);
            liElement.appendChild(buttonContainer);

            ul.appendChild(liElement);

            
        })
    })
}

addRecordButton.addEventListener('click', addRecord);

function addRecord(e) {

    const isValidInputs = nameInput.value !== '' && stepsInput.value !== '' && caloriesInput.value !=='';

    if (isValidInputs) {
        const record = {
            name: nameInput.value,
            steps: stepsInput.value,
            calories: caloriesInput.value
        }

        fetch(URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(record)
        })
        .then(loadRecords)
       

        nameInput.value = '';
        stepsInput.value = '';
        caloriesInput.value = '';
        
    }
}

editRecordButton.addEventListener('click', editRecord);

function editRecord(e) {

    const newDataRecord = {
        name: nameInput.value,
        steps: stepsInput.value,
        calories: caloriesInput.value,
        _id: currentChangeRecordId
    }

    fetch(`${URL}/${currentChangeRecordId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newDataRecord)
    })
    .then(loadRecords())

    
    addRecordButton.removeAttribute('disabled');
    editRecordButton.disabled = 'disabled';

    nameInput.value = '';
    stepsInput.value = '';
    caloriesInput.value = '';
}