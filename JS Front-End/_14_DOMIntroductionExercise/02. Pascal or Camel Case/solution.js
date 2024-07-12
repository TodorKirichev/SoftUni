function solve() {
  const text = document.getElementById('text').value;
  const convention = document.getElementById('naming-convention').value;

  let words = text.toLowerCase().split(' ');

  let result = '';

  switch (convention) {
    case 'Camel Case':
      let firstWord = words.shift();
      result += firstWord;
      for (const word of words) {
        result += word.charAt(0).toUpperCase() + word.slice(1);
      }
      break;
    case 'Pascal Case':
      for (const word of words) {
        result += word.charAt(0).toUpperCase() + word.slice(1);
      }
      break;
    default:
      result = 'Error!';
      break;
  }

  document.getElementById('result').textContent = result;
}
solve();