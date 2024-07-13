function deleteByEmail() {
    const emailToDelete = document.querySelector('input[type=text]').value;
    const rows = document.querySelectorAll('tbody tr');
    let msg = '';

    for (const row of rows) {
        const email = row.querySelector('td:last-of-type');
        if (email.textContent == emailToDelete) {
            row.remove();
            msg = 'Deleted.';
        } else {
            msg = 'Not found.';
        }
    }
    document.querySelector('#result').textContent = msg;
    document.querySelector('input[type=text]').value = '';

}