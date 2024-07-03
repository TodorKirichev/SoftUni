function validatePassword(password) {
    
    function checkLength() {
        if (password.length < 6 || password.length > 10) {
            return false;
        }
        return true;
    }

    function checkLettersAndDigits() {
        let pattern = /\w+/;
        let isLetterOrDigit = true;
        for (let i = 0; i < password.length; i++) {
            if (!pattern.test(password[i])) {
                isLetterOrDigit = false;
                break;
            }
        }
        return isLetterOrDigit;
    }

    function checkAtLeastTwoDigits() {
        let pattern = /\d/g;

        let matches = password.match(pattern);

        if (matches && matches.length >= 2) {
            return true;
        }
        return false;
    }

    if (checkLength() && checkLettersAndDigits() && checkAtLeastTwoDigits()) {
        console.log('Password is valid');
    } else {
        if (!checkLength()) {
            console.log('Password must be between 6 and 10 characters');
        }
        if (!checkLettersAndDigits()) {
            console.log('Password must consist only of letters and digits');
        }
        if (!checkAtLeastTwoDigits()) {
            console.log('Password must have at least 2 digits');
        }
    }
}


validatePassword('Pa$s$s');