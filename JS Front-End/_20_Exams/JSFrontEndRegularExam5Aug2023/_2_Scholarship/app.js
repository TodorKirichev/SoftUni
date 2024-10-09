window.addEventListener("load", solve);

function solve() {
  const nextButton = document.querySelector('#next-btn');
  const previewList = document.querySelector('#preview-list');
  const studentInput = document.querySelector('#student');
  const universityInput = document.querySelector('#university');
  const scoreInput = document.querySelector('#score');
  const candidateList = document.querySelector('#candidates-list');

  nextButton.addEventListener('click', addStudent);

  function addStudent() {
    const isValidInputs = studentInput.value !== '' && universityInput.value !== '' && scoreInput.value !== '';

    if (isValidInputs) {

      const name = document.createElement('h4');
      name.textContent = studentInput.value;

      const university = document.createElement('p');
      university.textContent = `University: ${universityInput.value}`;

      const score = document.createElement('p');
      score.textContent = `Score: ${scoreInput.value}`;

      const article = document.createElement('article');
      article.appendChild(name);
      article.appendChild(university);
      article.appendChild(score);

      const editButton = document.createElement('button');
      editButton.classList.add('action-btn', 'edit');
      editButton.textContent = 'edit';

      editButton.addEventListener('click', editRecord);

      function editRecord() {
        studentInput.value = name.textContent;
        universityInput.value = university.textContent.split(' ')[1];
        scoreInput.value = score.textContent.split(' ')[1];

        li.remove();

        nextButton.removeAttribute('disabled');
      }

      const applyButton = document.createElement('button');
      applyButton.classList.add('action-btn', 'apply');
      applyButton.textContent = 'apply';

      applyButton.addEventListener('click',saveRecord);

      function saveRecord() {

        editButton.remove();
        applyButton.remove();

        candidateList.appendChild(li);

        nextButton.removeAttribute('disabled');
      }

      const li = document.createElement('li');
      li.classList.add('application');

      li.appendChild(article);
      li.appendChild(editButton);
      li.appendChild(applyButton);

      previewList.appendChild(li);

      nextButton.disabled = 'disabled';

      clearInputs();
    }
  }

  function clearInputs() {
    studentInput.value = '';
    universityInput.value = '';
    scoreInput.value = '';
  }
}