const URL = 'http://localhost:3030/jsonstore/games/';

const loadButton = document.querySelector('#load-games');
const gamesList = document.querySelector('#games-list');
const addButton = document.querySelector('#add-game');
const editButton = document.querySelector('#edit-game');
const nameInput = document.querySelector('#g-name');
const typeInput = document.querySelector('#type');
const playersInput = document.querySelector('#players');

let currentId;

loadButton.addEventListener('click', loadGames);

async function loadGames() {
    try {
        const games = await (await fetch(URL)).json();

        gamesList.innerHTML = '';

        Object.values(games).forEach(game => {

            const pName = document.createElement('p');
            pName.textContent = game.name;

            const pType = document.createElement('p');
            pType.textContent = game.type;

            const pPlayers = document.createElement('p');
            pPlayers.textContent = game.players;

            const divContent = document.createElement('div');
            divContent.classList.add('content');
            divContent.appendChild(pName);
            divContent.appendChild(pType);
            divContent.appendChild(pPlayers);

            const changeButton = document.createElement('button');
            changeButton.classList.add('change-btn');
            changeButton.textContent = 'Change';
            changeButton.addEventListener('click', getInfo);

            function getInfo() {
                nameInput.value = pName.textContent;
                typeInput.value = pType.textContent;
                playersInput.value = pPlayers.textContent;
                currentId = game._id;

                addButton.disabled = 'disabled';
                editButton.removeAttribute('disabled');
            }

            const deleteButton = document.createElement('button');
            deleteButton.classList.add('delete-btn');
            deleteButton.textContent = 'Delete';
            deleteButton.addEventListener('click', deleteGame);

            function deleteGame() {
                fetch(`${URL}${game._id}`, {
                        method: 'DELETE',
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    })
                    .then(loadGames);
            }

            const buttonsContainer = document.createElement('div');
            buttonsContainer.appendChild(changeButton);
            buttonsContainer.appendChild(deleteButton);

            const divBoardGame = document.createElement('div');
            divBoardGame.classList.add('board-game');
            divBoardGame.appendChild(divContent);
            divBoardGame.appendChild(buttonsContainer);

            gamesList.appendChild(divBoardGame);
        })

    } catch (error) {
        console.log(error);
    }
}

addButton.addEventListener('click', addContact);

async function addContact() {
    try {
        await fetch(URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(getData())
        })
        loadGames();
        clearInputs();
    } catch (error) {
        console.log(error);
    }
}

editButton.addEventListener('click', editGame);

async function editGame() {
    try {
        await fetch(`${URL}${currentId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(getData())
        })
        addButton.removeAttribute('disabled');
        editButton.disabled = 'disabled';

        loadGames();
        clearInputs();
        
    } catch (error) {
        console.log(error);
    }
}

function getData() {
    return {
        name: nameInput.value,
        type: typeInput.value,
        players: playersInput.value,
        _id: currentId
    }
}

function clearInputs() {
    nameInput.value = '';
    typeInput.value = '';
    playersInput.value = '';
}