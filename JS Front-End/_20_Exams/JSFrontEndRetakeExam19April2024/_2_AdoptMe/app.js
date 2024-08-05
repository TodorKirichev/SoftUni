window.addEventListener("load", solve);

function solve() {
    const ul = document.querySelector('#adoption-info');
    const list = document.querySelector('#adopted-list');
    const button = document.querySelector('#adopt-btn');
    const typeInput = document.querySelector('#type');
    const ageInput = document.querySelector('#age');
    const genderInput = document.querySelector('#gender');

    button.addEventListener('click', addPet);

    function addPet(e) {
      e.preventDefault();
      const isValidInputs = typeInput.value !== '' && ageInput.value !== '' && genderInput.value !== '';

      if (isValidInputs) {

        const editButton = document.createElement('button');
        editButton.classList.add('edit-btn');
        editButton.textContent = 'Edit';
        editButton.addEventListener('click', editRecord);

        function editRecord(e) {
          e.preventDefault();

          typeInput.value = nameElement.textContent.split(':')[1];
          ageInput.value = ageElement.textContent.split(':')[1];
          genderInput.value = genderElement.textContent.split(':')[1];
          liElement.remove();
        }

        const doneButton = document.createElement('button');
        doneButton.classList.add('done-btn');
        doneButton.textContent = 'Done';

        doneButton.addEventListener('click', createRecord);

        function createRecord(e) {
          e.preventDefault();

          liElement.removeChild(buttonContainer);

          const clearButton = document.createElement('button');
          clearButton.classList.add('clear-btn');
          clearButton.textContent = 'Clear';

          clearButton.addEventListener('click', deleteRecord);

          function deleteRecord(e) {
            e.preventDefault();
            liElement.remove();
          }

          liElement.appendChild(clearButton);

          list.appendChild(liElement);
        }

        const buttonContainer = document.createElement('div');
        buttonContainer.classList.add('buttons');
        buttonContainer.appendChild(editButton);
        buttonContainer.appendChild(doneButton);

        const nameElement = document.createElement('p');
        nameElement.textContent = `Pet:${typeInput.value}`;

        const genderElement = document.createElement('p');
        genderElement.textContent = `Gender:${genderInput.value}`;

        const ageElement = document.createElement('p');
        ageElement.textContent = `Age:${ageInput.value}`;

        const articleElement = document.createElement('article');
        articleElement.appendChild(nameElement);
        articleElement.appendChild(genderElement);
        articleElement.appendChild(ageElement);

        const liElement = document.createElement('li');
        liElement.appendChild(articleElement);
        liElement.appendChild(buttonContainer);

        ul.appendChild(liElement);

        typeInput.value = '';
        ageInput.value = '';
        genderInput.value = '';
      }
    }
  }
  