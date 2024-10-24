const URL = 'http://localhost:3030/jsonstore/matches/';
const list = document.querySelector('#list');
const loadMatchesButton = document.querySelector('#load-matches');
const addMatchButton = document.querySelector('#add-match');
const hostInput = document.querySelector('#host');
const scoreInput = document.querySelector('#score');
const guestInput = document.querySelector('#guest');
const editMatchButton = document.querySelector('#edit-match');
let currentId;

loadMatchesButton.addEventListener('click', loadMatches);

async function loadMatches() {

    try {
        const matches = await (await fetch(URL)).json();

        list.innerHTML = '';

        Object.values(matches).forEach(match => {
            const host = document.createElement('p');
            host.textContent = match.host;

            const score = document.createElement('p');
            score.textContent = match.score;

            const guest = document.createElement('p');
            guest.textContent = match.guest;

            const info = document.createElement('div');
            info.classList.add('info');
            info.appendChild(host);
            info.appendChild(score);
            info.appendChild(guest);

            const changeButton = document.createElement('button');
            changeButton.classList.add('change-btn');
            changeButton.textContent = 'Change';

            changeButton.addEventListener('click', editMatch);

            function editMatch() {
                hostInput.value = host.textContent;
                scoreInput.value = score.textContent;
                guestInput.value = guest.textContent;
                currentId = match._id;

                // li.remove();

                addMatchButton.disabled = 'disabled';
                editMatchButton.removeAttribute('disabled');
            }

            const deleteButton = document.createElement('button');
            deleteButton.classList.add('delete-btn');
            deleteButton.textContent = 'Delete';

            deleteButton.addEventListener('click',deleteMatch);

            async function deleteMatch() {
                try {
                    const headers = {
                        method: 'DELETE',
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }
                    
                    await fetch(`${URL}${match._id}`, headers);
                    loadMatches();

                } catch (error) {
                    console.log(error);
                }
            }

            const buttonContainer = document.createElement('div');
            buttonContainer.classList.add('btn-wrapper');
            buttonContainer.appendChild(changeButton);
            buttonContainer.appendChild(deleteButton);

            const li = document.createElement('li');
            li.classList.add('match');
            li.appendChild(info);
            li.appendChild(buttonContainer);

            list.appendChild(li);
        })
    } catch (error) {
        console.log(error);
    }

}

addMatchButton.addEventListener('click', addMatch);

async function addMatch() {
    const isValidInputs = hostInput.value !== '' && scoreInput.value !== '' && guestInput.value !== '';

    if (isValidInputs) {
        try {
            const newMatch = {
                host: hostInput.value,
                score: scoreInput.value,
                guest: guestInput.value
            }
            const headers = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newMatch)
            }

            await fetch(URL, headers);

            loadMatches();
            clearInputs();

        } catch (error) {
            console.log(error);
        }

    }
}

editMatchButton.addEventListener('click', updateMatchInfo);

async function updateMatchInfo() {

    try {
        const updatedMatch = {
            host: hostInput.value,
            score: scoreInput.value,
            guest: guestInput.value,
            _id: currentId
        }
        const headers = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedMatch)
        }
    
        await fetch(`${URL}${currentId}`, headers);

        loadMatches();
        clearInputs();
        editMatchButton.disabled = 'disabled';
        addMatchButton.removeAttribute('disabled');

    } catch (error) {
        console.log(error);
    }
    
}

function clearInputs() {
    hostInput.value = '';
    scoreInput.value = '';
    guestInput.value = '';
}