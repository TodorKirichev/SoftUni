function solve() {
  let correctAnswers = ["onclick", "JSON.stringify()", "A programming API for HTML and XML documents"];
  let rightAnswers = 0;
  let index = 0;

  const answers = Array.from(document.querySelectorAll('.answer-text'));
  answers.forEach(a => a.addEventListener('click', checkAnswer));

  function checkAnswer(e) {
   
      if (correctAnswers.includes(e.target.textContent)) {
        rightAnswers++;
      }

      let currentSection = document.querySelectorAll("section")[index];
      currentSection.style.display = 'none';

      if (document.querySelectorAll("section")[index + 1] !== undefined) {
        document.querySelectorAll("section")[index + 1].style.display = "block";
        index ++;
      } else {
        document.querySelector("#results").style.display = "block";
        if (rightAnswers !== 3) {
          document.querySelector("#results h1").textContent = `You have ${rightAnswers} right answers`
        } else {
          document.querySelector("#results h1").textContent = "You are recognized as top JavaScript fan!"
        }
      }
  }
}
