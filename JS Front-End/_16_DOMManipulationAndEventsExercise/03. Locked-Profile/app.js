function lockedProfile() {
    const buttons = document.getElementsByTagName('button');

    for (const button of buttons) {
        button.addEventListener('click', showInfo);

        function showInfo(e) {
            const unlockInput = e.target.parentNode.querySelector('input[value=unlock]');

            if (unlockInput.checked) {
                if (button.textContent === 'Show more') {
                    button.previousElementSibling.style.display = 'block';
                    button.textContent = 'Hide it';
                } else {
                    button.previousElementSibling.style.display = 'none';
                    button.textContent = 'Show more';
                }
            }
        }
    }
}