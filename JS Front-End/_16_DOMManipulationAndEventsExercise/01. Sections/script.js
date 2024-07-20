function create(words) {
   const divContainer = document.querySelector('#content');
   for (const word of words) {
      const div = document.createElement('div');
      const p = document.createElement('p');

      p.textContent = word;
      div.appendChild(p);
      p.style.display = 'none';
      divContainer.appendChild(div);

      div.addEventListener('click', show);

      function show(e) {
         e.target.querySelector('p').style.display = 'block';
      }
   }

   
}