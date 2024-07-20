function solve() {
    const inputNumber = document.querySelector('#input');
    const outputUnits = document.querySelector('#selectMenuTo');
    const button = document.querySelector('button');
    const outputField = document.querySelector('#result');

    // outputUnits.removeChild(document.querySelector('#selectMenuTo option'));

    const binaryOption = document.createElement('option');
    binaryOption.textContent = 'Binary';
    binaryOption.value = 'binary';
    outputUnits.appendChild(binaryOption);

    const hexaDecimalOption = document.createElement('option');
    hexaDecimalOption.textContent = 'Hexadecimal';
    hexaDecimalOption.value = 'hexadecimal';
    outputUnits.appendChild(hexaDecimalOption);

    const functions = {
        binary: (decimal) => {
            if (decimal === 0) return "0";
            let binary = "";
            while (decimal > 0) {
                binary = (decimal % 2) + binary;
                decimal = Math.floor(decimal / 2);
            }
            return binary;
        },
        hexadecimal: (decimal) => {
            if (decimal === 0) return "0";
            const hexDigits = "0123456789ABCDEF";
            let hexadecimal = "";
            while (decimal > 0) {
                let remainder = decimal % 16;
                hexadecimal = hexDigits[remainder] + hexadecimal;
                decimal = Math.floor(decimal / 16);
            }
            return hexadecimal;
        }
    }

    button.addEventListener('click', convert);

    function convert() {
        let converter = functions[outputUnits.value];
        outputField.value = converter(inputNumber.value);
    }
}