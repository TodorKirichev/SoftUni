window.addEventListener("load", solve);

function solve() {
    const nameInput = document.querySelector('#name');
    const phoneNumberInput = document.querySelector('#phone');
    const categoryInput = document.querySelector('#category');
    const addButton = document.querySelector('#add-btn');
    const checkUl = document.querySelector('#check-list');
    const contactUl = document.querySelector('#contact-list');

    addButton.addEventListener('click',addContact);

    function addContact() {
      let isValidInputs = nameInput.value !== '' && phoneNumberInput.value !== '' & categoryInput.value !== '';

      if (isValidInputs) {
        const li = document.createElement('li');
        const article = document.createElement('article');
        const buttonContainer = document.createElement('div');
        buttonContainer.classList.add('buttons');

        const pName = document.createElement('p');
        pName.textContent = `name:${nameInput.value}`;

        const pPhone = document.createElement(`p`);
        pPhone.textContent = `phone:${phoneNumberInput.value}`;

        const pCategory = document.createElement('p');
        pCategory.textContent = `category:${categoryInput.value}`;

        article.appendChild(pName);
        article.appendChild(pPhone);
        article.appendChild(pCategory);

        const editButton = document.createElement('button');
        editButton.classList.add('edit-btn');
        editButton.addEventListener('click', editContact);

        function editContact() {
          nameInput.value = pName.textContent.split(':')[1];
          phoneNumberInput.value = pPhone.textContent.split(':')[1];
          categoryInput.value = pCategory.textContent.split(':')[1];

          li.remove();
        }

        const saveButton = document.createElement('button');
        saveButton.classList.add('save-btn');
        saveButton.addEventListener('click',saveContact);

        function saveContact() {
          buttonContainer.remove();

          const deleteButton = document.createElement('button');
          deleteButton.classList.add('del-btn');
          deleteButton.addEventListener('click', deleteContact);

          function deleteContact() {
            li.remove();
          }

          li.appendChild(deleteButton);

          contactUl.appendChild(li);

        }

        buttonContainer.appendChild(editButton);
        buttonContainer.appendChild(saveButton);

        li.appendChild(article);
        li.appendChild(buttonContainer);

        checkUl.appendChild(li)

        nameInput.value = '';
        phoneNumberInput.value = '';
        categoryInput.value = '';
      }
    }


  }
  