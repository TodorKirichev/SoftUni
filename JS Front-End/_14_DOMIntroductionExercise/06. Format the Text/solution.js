function solve() {
  const textSentences = document.getElementById('input').value.split('.');
  textSentences.pop();

  let textParagraphs = [];
  let counter = 0;
  let paragraph = '';

while (textSentences.length > 0) {
  
  if (counter % 3 === 0 && counter !== 0) {
    textParagraphs.push(`<p>${paragraph}</p>\n`);
    paragraph = '';
    counter = 0;
    continue;
    }
  counter++;
  let sentence = textSentences.shift();
  paragraph += sentence + '.';
}
textParagraphs.push(`<p>${paragraph}</p>\n`);
document.getElementById('output').innerHTML = textParagraphs;
}