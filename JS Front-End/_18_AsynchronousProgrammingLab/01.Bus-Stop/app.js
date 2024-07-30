function getInfo() {

    const stopIdInput = document.querySelector('#stopId');
    const stopNameOutput = document.querySelector('#stopName');
    const busListOutput = document.querySelector('#buses');
    const URL = 'http://localhost:3030/jsonstore/bus/businfo/';

    stopNameOutput.textContent = '';
    busListOutput.textContent = '';

    fetch(`${URL}${stopIdInput.value}`)
    .then(res => res.json())
    .then(busInfo => {
        stopNameOutput.textContent = busInfo.name;
        const busStops = busInfo.buses;
        for (const key in busStops) {
            const busId = key;
            const busTime = busStops[key];
            const li = document.createElement('li');
            li.textContent = `Bus ${busId} arrives in ${busTime} minutes`
            busListOutput.appendChild(li);
        }
    })
    .catch(error => {
        stopNameOutput.textContent = 'Error';
    });
}