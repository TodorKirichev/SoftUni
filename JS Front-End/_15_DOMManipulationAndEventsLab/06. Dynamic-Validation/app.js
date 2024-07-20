function validate() {
    const inputEmail = document.getElementById('email');

    let pattern = /[a-z]+\@[a-z]+\.[a-z]+/;

    inputEmail.addEventListener('change', change);

    function change(e) {

        if (!pattern.test(e.target.value)) {
            e.target.classList.add('error');
            console.log('asd');
        } else {
            e.target.classList.remove('error');
        }
    }
}