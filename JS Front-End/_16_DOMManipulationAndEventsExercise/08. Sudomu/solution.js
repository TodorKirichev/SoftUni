function solve() {

    let[check, clear] = document.getElementsByTagName('button');
    const inputs = Array.from(document.getElementsByTagName('input'));
    const table = document.querySelector('table');
    const paragraph = document.querySelector('div#check p');
    
    check.addEventListener('click', checkSudomu);
    
    function checkSudomu() {
        
        let isCorrect = true;
        let counterCol = 0;
        let setRow = new Set();
        let setCol = new Set();

        for (let i = 0; i < inputs.length; i++) {

            setRow.add(inputs[i].value);
            console.log(inputs[i].value);
    
            if ((i + 1) % 3 === 0 && i !== 0) {
                if (setRow.size < 3) {
                    isCorrect = false;
                }
                setRow.clear();
            }
        }
    
        for (let i = 0; i < inputs.length; i++) {

            setCol.add(inputs[counterCol].value);
            
            counterCol+=3;
    
            if ((i + 1) % 3 === 0 && i !== 0) {
                if (setCol.size < 3) {
                    isCorrect = false;
                }
                setCol.clear();
                counterCol = (i + 1) / 3;
            }
        }

        if (isCorrect) {
            table.style.border = '1px solid green';
            paragraph.textContent = 'You solve it! Congratulations!';
            paragraph.style.color = 'green';
        } else {
            table.style.border = '1px solid red';
            paragraph.textContent = 'NOP! You are not done yet...';
            paragraph.style.color = 'red';
        }
    }

    clear.addEventListener('click', clearInputs);

    function clearInputs() {
        inputs.forEach(i => i.value = '');
        paragraph.textContent = '';
        table.style.border = 'initial';
    }
    
    
}