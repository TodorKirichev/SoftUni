function focused() {
    const inputs = document.querySelectorAll('input');

    Array.from(inputs).forEach(i => {
        i.addEventListener('focus', focus);
        function focus(e) {
            e.target.parentNode.classList.add('focused');
        }

        i.addEventListener('blur', blur);
        function blur(e) {
            e.target.parentNode.classList.remove('focused');
        }
    })
}