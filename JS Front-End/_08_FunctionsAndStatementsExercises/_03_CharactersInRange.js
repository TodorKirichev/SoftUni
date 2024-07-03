function printBetween(first, second) {
    
    function getSmallest(first, second) {
        return Math.min(first.charCodeAt(0), second.charCodeAt(0));
    }

    function getBiggest(first, second) {
        return Math.max(first.charCodeAt(0), second.charCodeAt(0));
    }

    let smaller = getSmallest(first, second);

    let bigger = getBiggest(first, second);

    let result = '';

    for (let i = smaller + 1; i < bigger; i++) {
        let string = String.fromCharCode(i) + ' ';
        result += string;  
    }

    console.log(result);
}

printBetween('C',
'#'
);