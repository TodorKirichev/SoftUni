const URL = 'http://localhost:3030/jsonstore/tasks/';
const list = document.querySelector('#list');
const loadHistoryButton = document.querySelector('#load-history');
const addWeatherButton = document.querySelector('#add-weather');
const locationInput = document.querySelector('#location');
const temperatureInput = document.querySelector('#temperature');
const dateInput = document.querySelector('#date');
const editWeatherButton = document.querySelector('#edit-weather');
let currentId;

loadHistoryButton.addEventListener('click', loadHistory);

async function loadHistory() {

    try {
        const response = await fetch(URL);

        const records = await response.json();

        list.innerHTML = '';

        console.log(records);
        Object.values(records).forEach(record => {

            const divContainer = document.createElement('div');
            divContainer.classList.add('container');

            const location = document.createElement('h2');
            location.textContent = record.location;

            const date = document.createElement('h3');
            date.textContent = record.date;

            const temperature = document.createElement('h3');
            temperature.id = 'celsius';
            temperature.textContent = record.temperature;

            const buttonContainer = document.createElement('div');
            buttonContainer.classList.add('buttons-container');

            const changeButton = document.createElement('button');
            changeButton.classList.add('change-btn');
            changeButton.textContent = 'Change';

            changeButton.addEventListener('click', changeRecord);

            function changeRecord() {
                locationInput.value = location.textContent;
                temperatureInput.value = temperature.textContent;
                dateInput.value = date.textContent;

                currentId = record._id;

                divContainer.remove();

                addWeatherButton.disabled = 'disabled';

                editWeatherButton.removeAttribute('disabled');
            }

            const deleteButton = document.createElement('button');
            deleteButton.classList.add('delete-btn');
            deleteButton.textContent = 'Delete';

            deleteButton.addEventListener('click', deleteRecord);

            async function deleteRecord() {
                const headers = {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }

                try {
                    await fetch(`${URL}${record._id}`, headers);
                    loadHistory();
                } catch (error) {
                    console.log(error);
                }

            }

            buttonContainer.appendChild(changeButton);
            buttonContainer.appendChild(deleteButton);

            divContainer.appendChild(location);
            divContainer.appendChild(date);
            divContainer.appendChild(temperature);
            divContainer.appendChild(buttonContainer);

            list.appendChild(divContainer);
        })
    } catch (error) {
        console.log(error);
    }
}

addWeatherButton.addEventListener('click', addRecord);

async function addRecord() {

    const isValidInputs = locationInput.value !== '' && temperatureInput.value !== '' && dateInput.value !== '';

    if (isValidInputs) {
        try {
            const newRecord = {
                location: locationInput.value,
                temperature: temperatureInput.value,
                date: dateInput.value
            }

            const headers = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newRecord)
            }

            await fetch(URL, headers);

            loadHistory();

            clearInputs();

        } catch (error) {
            console.log(error);
        }
    }
}

editWeatherButton.addEventListener('click', editRecord);

async function editRecord() {
    const updatedRecord = {
        location: locationInput.value,
        temperature: temperatureInput.value,
        date: dateInput.value,
        _id: currentId
    }

    const headers = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedRecord)
    }

    await fetch(`${URL}${currentId}`, headers);

    loadHistory();

    clearInputs();

    addWeatherButton.removeAttribute('disabled');

    editWeatherButton.disabled = 'disabled';
}

function clearInputs() {
    locationInput.value = '';
    temperatureInput.value = '';
    dateInput.value = '';
}