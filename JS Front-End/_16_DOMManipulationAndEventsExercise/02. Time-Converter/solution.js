function attachEventsListeners() {

    const daysButton = document.querySelector('#daysBtn');
    const daysInput = document.querySelector('#days');

    const hoursButton = document.querySelector('#hoursBtn');
    const hoursInput = document.querySelector('#hours');
    
    const minutesButton = document.querySelector('#minutesBtn');
    const minutesInput = document.querySelector('#minutes');

    const secondsButton = document.querySelector('#secondsBtn');
    const secondsInput = document.querySelector('#seconds');

    daysButton.addEventListener('click', convertDays);
    hoursButton.addEventListener('click', convertHours);
    minutesButton.addEventListener('click', convertMinutes);
    secondsButton.addEventListener('click', convertSeconds);

    function convertDays() {
        hoursInput.value = daysInput.value * 24;
        minutesInput.value = hoursInput.value * 60;
        secondsInput.value = minutesInput.value * 60;

    }

    function convertHours() {
        daysInput.value = hoursInput.value / 24;
        minutesInput.value = hoursInput.value * 60;
        secondsInput.value = minutesInput.value * 60;

    }

    function convertMinutes() {
        hoursInput.value = minutesInput.value / 60;
        daysInput.value = hoursInput.value / 24;
        secondsInput.value = minutesInput.value * 60;
    }

    function convertSeconds() {
        minutesInput.value = secondsInput.value / 60;
        hoursInput.value = minutesInput.value / 60;
        daysInput.value = hoursInput.value / 24;
    }
}