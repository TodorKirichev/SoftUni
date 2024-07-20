function attachEventsListeners() {
    let [input, button, ouput] = document.getElementsByTagName('input');
    let [inputUnits, outputUnits] = document.getElementsByTagName('select');

    let conversions = {
        'km': 1000,
        'm': 1,
        'cm': 0.01,
        'mm': 0.001,
        'mi': 1609.34,
        'yrd': 0.9144,
        'ft': 0.3048,
        'in': 0.0254
    }

    button.addEventListener('click', convert);

    function convert() {
        ouput.value = input.value * conversions[inputUnits.value] / conversions[outputUnits.value];

    }
}