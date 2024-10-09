window.addEventListener("load", solve);

function solve() {
  const addButton = document.querySelector('#add-btn');
  const nameInput = document.querySelector('#name');
  const timeInput = document.querySelector('#time');
  const descriptionInput = document.querySelector('#description');
  const previewList = document.querySelector('#preview-list');
  const archiveList = document.querySelector('#archive-list');

  addButton.addEventListener('click', addHistoricEvent);

  function addHistoricEvent() {

    const isValidInputs = nameInput.value !== '' && timeInput.value !== '' && descriptionInput.value !== '';

    if (isValidInputs) {
      const name = document.createElement('p');
      name.textContent = nameInput.value;

      const time = document.createElement('p');
      time.textContent = timeInput.value;

      const description = document.createElement('p');
      description.textContent = descriptionInput.value;

      const article = document.createElement('article');
      article.appendChild(name);
      article.appendChild(time);
      article.appendChild(description);

      const editButton = document.createElement('button');
      editButton.classList.add('edit-btn');
      editButton.textContent = 'Edit';

      editButton.addEventListener('click', editHistoricEvent);

      function editHistoricEvent() {
        nameInput.value = name.textContent;
        timeInput.value = time.textContent
        descriptionInput.value = description.textContent;

        li.remove();

        addButton.removeAttribute('disabled');
      }

      const nextButton = document.createElement('button');
      nextButton.classList.add('next-btn');
      nextButton.textContent = 'Next';

      nextButton.addEventListener('click', archiveHistoricEvent);

      function archiveHistoricEvent() {
        archiveList.appendChild(li);
        buttonContainer.remove();

        const archiveButton = document.createElement('button');
        archiveButton.classList.add('archive-btn');
        archiveButton.textContent = 'Archive';

        archiveButton.addEventListener('click', deleteHistoricEvent);

        function deleteHistoricEvent() {
          li.remove();

          addButton.removeAttribute('disabled');
        }

        li.appendChild(archiveButton);
      }

      const buttonContainer = document.createElement('div');
      buttonContainer.classList.add('buttons');
      buttonContainer.appendChild(editButton);
      buttonContainer.appendChild(nextButton);

      const li = document.createElement('li');
      li.appendChild(article);
      li.appendChild(buttonContainer);

      previewList.appendChild(li);

      clearInputs();

      addButton.disabled = 'disabled';
    }
  }

  function clearInputs() {
    nameInput.value = '';
    timeInput.value = '';
    descriptionInput.value = '';
  }
}