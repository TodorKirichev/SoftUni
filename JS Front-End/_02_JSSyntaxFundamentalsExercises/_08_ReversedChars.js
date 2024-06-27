function reverseChars(a, b, c) {
    
    let string = '' + a + b + c;
    let reversedString = '';

    for (let i = string.length; i >= 0; i--) {
        reversedString += string.charAt(i) + ' ';
    }

    console.log(reversedString);
}

reverseChars('1',
'L',
'&'
);