function search() {
   let elements = document.getElementsByTagName('li');

   const searchText = document.getElementById('searchText').value;
   let matches = 0;

   for (const element of elements) {
      if (element.textContent.toLowerCase().includes(searchText.toLowerCase())) {
         element.style.fontWeight = 'bold';
         element.style.textDecoration = 'underline';
         matches++;
      }
   }
   document.getElementById('result').textContent = `${matches} matches found`;
}
