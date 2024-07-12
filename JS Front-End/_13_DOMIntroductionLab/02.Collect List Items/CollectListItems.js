function extractText() {
    const items = document.querySelectorAll('#items li');

    for (const item of items) {
        document.querySelector('#result').value += item.textContent + '\n';
    }

}