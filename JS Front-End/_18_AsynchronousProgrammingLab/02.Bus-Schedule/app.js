function solve() {
    const departButton = document.querySelector('#depart');
    const arriveButton = document.querySelector('#arrive');
    const output = document.querySelector('#info .info');
    const URL = 'http://localhost:3030/jsonstore/bus/schedule';

    let busStop = {
        name: '',
        next: 'depot'
    }

    function depart() {
        departButton.disabled = true;
        arriveButton.disabled = false;
        fetch(`${URL}/${busStop.next}`)
        .then(res => res.json())
        .then(busStopInfo => {
            busStop = busStopInfo;
            output.textContent = `Next stop ${busStop.name}`;
        })
        .catch(error => {
            departButton.disabled = true;
            arriveButton.disabled = true;
            output.textContent = 'Error';
        })
    }

    async function arrive() {
        arriveButton.disabled = true;
        departButton.disabled = false;
        output.textContent = `Arriving at ${busStop.name}`;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();