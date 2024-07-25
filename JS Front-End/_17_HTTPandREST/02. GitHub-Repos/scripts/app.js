function loadRepos() {
   const URL = 'https://api.github.com/users/testnakov/repos';

   fetch(URL)
   .then(res => res.text())
   .then(data => {
      const output = document.querySelector('#res');
      output.textContent = data;
   })
   .catch(error => console.log(error));
}