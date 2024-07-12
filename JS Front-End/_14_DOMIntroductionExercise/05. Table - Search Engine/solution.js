function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      const tRows = document.querySelectorAll('tbody tr');
      const searchText = document.getElementById('searchField').value;

      for (const row of tRows) {
         row.className = '';
         const rowElements = row.getElementsByTagName('td');
         for (const td of rowElements) {
            if (td.textContent.includes(searchText)) {
               row.className = 'select';
            }
         }
      }

   }
}