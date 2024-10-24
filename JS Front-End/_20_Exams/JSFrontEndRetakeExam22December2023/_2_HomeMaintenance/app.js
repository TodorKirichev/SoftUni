window.addEventListener("load", solve);

function solve() {

    const addButton = document.querySelector('#add-btn');
    const placeInput = document.querySelector('#place');
    const actionInput = document.querySelector('#action');
    const personInput = document.querySelector('#person');
    const taskList = document.querySelector('#task-list');
    const doneList = document.querySelector('#done-list');

    addButton.addEventListener('click', addTask);

    function addTask() {

        const isValidInputs = placeInput.value !== '' && actionInput.value !== '' & personInput.value !== '';

        if (isValidInputs) {

            const li = document.createElement('li');
            li.classList.add('clean-task');

            const article = document.createElement('article');

            const buttonContainer = document.createElement('div');
            buttonContainer.classList.add('buttons');

            const pPlace = document.createElement('p');
            pPlace.textContent = `Place:${placeInput.value}`;

            const pAction = document.createElement('p');
            pAction.textContent = `Action:${actionInput.value}`;

            const pPerson = document.createElement('p');
            pPerson.textContent = `Person:${personInput.value}`;

            article.appendChild(pPlace);
            article.appendChild(pAction);
            article.appendChild(pPerson);

            const editButton = document.createElement('button');
            editButton.classList.add('edit');
            editButton.textContent = 'Edit';

            editButton.addEventListener('click', editTask);

            function editTask() {
                placeInput.value = pPlace.textContent.split(':')[1];
                actionInput.value = pAction.textContent.split(':')[1];
                personInput.value = pPerson.textContent.split(':')[1];

                li.remove();
            }

            const doneButton = document.createElement('button');
            doneButton.classList.add('done');
            doneButton.textContent = 'Done';

            doneButton.addEventListener('click',moveTaskToDoneList);

            function moveTaskToDoneList() {
                editButton.remove();
                doneButton.remove();

                const deleteButton = document.createElement('button');
                deleteButton.classList.add('delete');
                deleteButton.textContent = 'Delete';

                deleteButton.addEventListener('click',deleteTask);

                function deleteTask() {
                    li.remove();
                }

                li.appendChild(deleteButton);

                doneList.appendChild(li);
            }

            buttonContainer.appendChild(editButton);
            buttonContainer.appendChild(doneButton);

            li.appendChild(article);
            li.appendChild(buttonContainer);

            taskList.appendChild(li);

            placeInput.value = '';
            actionInput.value = '';
            personInput.value = '';
        }
    }
}