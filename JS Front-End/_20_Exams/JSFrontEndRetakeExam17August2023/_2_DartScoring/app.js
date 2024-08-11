window.addEventListener("load", solve);

function solve() {
  const addButton = document.querySelector('#add-btn');
  const sureList = document.querySelector('#sure-list');
  const playerInput = document.querySelector('#player');
  const scoreInput = document.querySelector('#score');
  const roundInput = document.querySelector('#round');
  const scoreboardList = document.querySelector('#scoreboard-list');
  const clearButton = document.querySelector('.btn.clear');

  addButton.addEventListener('click', addScore);

  function addScore() {
    const isValidInputs = playerInput.value !== '' && scoreInput.value !== '' && roundInput.value !== '';

    if (isValidInputs) {
      const li = document.createElement('li');
      li.classList.add('dart-item');

      const article = document.createElement('article');

      const name = document.createElement('p');
      name.textContent = playerInput.value;

      const score = document.createElement('p');
      score.textContent = `Score: ${scoreInput.value}`;

      const round = document.createElement('p');
      round.textContent = `Round: ${roundInput.value}`;

      article.appendChild(name);
      article.appendChild(score);
      article.appendChild(round);

      const editButton = document.createElement('button');
      editButton.classList.add('btn', 'edit');
      editButton.textContent = 'edit';

      editButton.addEventListener('click', editScore);

      function editScore() {
        playerInput.value = name.textContent;
        scoreInput.value = score.textContent.split(': ')[1];
        roundInput.value = round.textContent.split(': ')[1];

        addButton.removeAttribute('disabled');

        li.remove();
      }

      const okButton = document.createElement('button');
      okButton.classList.add('btn', 'ok');
      okButton.textContent = 'ok';

      okButton.addEventListener('click', addToScoreboardList);

      function addToScoreboardList() {
        editButton.remove();
        okButton.remove();

        scoreboardList.appendChild(li);

        addButton.removeAttribute('disabled');
      }

      li.appendChild(article);
      li.appendChild(editButton);
      li.appendChild(okButton);

      sureList.appendChild(li);

      addButton.disabled = 'disabled';
      clearInputs();

    }
  }

  clearButton.addEventListener('click',reload);

  function reload() {
    location.reload();
  }

  function clearInputs() {
    playerInput.value = '';
    scoreInput.value = '';
    roundInput.value = '';
  }
}