const URL = 'http://localhost:3030/jsonstore/tasks/';
const loadVacationButton = document.querySelector('#load-vacations');
const list = document.querySelector('#list');
const addVacationButton = document.querySelector('#add-vacation');
const nameInput = document.querySelector('#name');
const daysInput = document.querySelector('#num-days');
const dateInput = document.querySelector('#from-date');
const editVacationButton = document.querySelector('#edit-vacation');
let currentId;

loadVacationButton.addEventListener('click', loadVacations);

async function loadVacations() {
    try {
        const vacations = await (await fetch(URL)).json();

        list.innerHTML = '';

        Object.values(vacations).forEach(vacation => {
            const name = document.createElement('h2');
            name.textContent = vacation.name;

            const date = document.createElement('h3');
            date.textContent = vacation.date;

            const days = document.createElement('h3');
            days.textContent = vacation.days;

            const changeButton = document.createElement('button');
            changeButton.classList.add('change-btn');
            changeButton.textContent = 'Change';

            changeButton.addEventListener('click', changeVacation);

            function changeVacation() {
                nameInput.value = name.textContent
                daysInput.value = days.textContent;
                dateInput.value = date.textContent;

                currentId = vacation._id;

                container.remove();

                editVacationButton.removeAttribute('disabled');
                addVacationButton.disabled = 'disabled';
            }

            const doneButton = document.createElement('button');
            doneButton.classList.add('done-btn');
            doneButton.textContent = 'Done';

            doneButton.addEventListener('click', deleteVacation);

            async function deleteVacation() {
                const headers = {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }

                await fetch(`${URL}${vacation._id}`, headers);

                loadVacations();
            }

            const container = document.createElement('div');
            container.classList.add('container');

            container.appendChild(name);
            container.appendChild(date);
            container.appendChild(days);
            container.appendChild(changeButton);
            container.appendChild(doneButton);

            list.appendChild(container);
        })
    } catch (error) {
        console.log(error);
    }
}

addVacationButton.addEventListener('click', addVacation);

async function addVacation(e) {
    e.preventDefault();

    const isValidInputs = nameInput.value !== '' && daysInput.value !== '' && dateInput.value !== '';
    if (isValidInputs) {
        const newVacation = {
            name: nameInput.value,
            days: daysInput.value,
            date: dateInput.value
        }

        const headers = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newVacation)
        }

        try {
            await fetch(URL, headers);

            loadVacations();
            clearInputs();
        } catch (error) {

        }
    }
}

editVacationButton.addEventListener('click', editVacation);

async function editVacation(e) {
    e.preventDefault();

    const updatedVacation = {
        name: nameInput.value,
        days: daysInput.value,
        date: dateInput.value,
        _id: currentId
    }

    const headers = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application.json'
        },
        body: JSON.stringify(updatedVacation)
    }

    await fetch(`${URL}${currentId}`, headers);

    loadVacations();
    clearInputs();

    editVacationButton.disabled = 'disabled';
    addVacationButton.removeAttribute('disabled');
}

function clearInputs() {
    nameInput.value = '';
    daysInput.value = '';
    dateInput.value = '';
}