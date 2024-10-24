function attachEvents() {
    const inputLocation = document.querySelector('#location');
    const getWeatherButton = document.querySelector('#submit');

    const weatherSymbols = {
        Sunny: '☀',
        'Partly sunny': '⛅',
        Overcast: '☁',
        Rain: '☂',
    }

    getWeatherButton.addEventListener('click', getWeather);

    function getWeather() {

        fetch('http://localhost:3030/jsonstore/forecaster/locations')
        .then(res => res.json())
        .then(locations => {
            let locationCode;
            for (const location of locations) {
                if (location.name === inputLocation.value) {
                    locationCode = location.code;
                }
            }
            fetch(`http://localhost:3030/jsonstore/forecaster/today/${locationCode}`)
            .then(res => res.json())
            .then(info => {
                let {name, forecast} = info;

                document.querySelector('#forecast').style.display = 'block';

                const currentOutput = document.querySelector('#current');

                const forecastsDiv = document.createElement('div');
                forecastsDiv.classList.add('forecasts');

                const conditionSymbolSpan = document.createElement('span');
                conditionSymbolSpan.classList.add('condition', 'symbol');
                conditionSymbolSpan.textContent = weatherSymbols[forecast.condition];
                
                const conditionSpan = document.createElement('span');
                conditionSpan.classList.add('condition');

                const nameSpan = document.createElement('span');
                nameSpan.classList.add('forecast-data');
                nameSpan.textContent = name;

                const temperaturesSpan = document.createElement('span');
                temperaturesSpan.classList.add('forecast-data');
                temperaturesSpan.textContent = `${forecast.low}°/${forecast.high}°`;

                const conditionWeatherSpan = document.createElement('span');
                conditionWeatherSpan.classList.add('forecast-data');
                conditionWeatherSpan.textContent = forecast.condition;

                conditionSpan.appendChild(nameSpan);
                conditionSpan.appendChild(temperaturesSpan);
                conditionSpan.appendChild(conditionWeatherSpan);

                forecastsDiv.appendChild(conditionSymbolSpan);
                forecastsDiv.appendChild(conditionSpan);

                currentOutput.appendChild(forecastsDiv);

            })

            fetch(`http://localhost:3030/jsonstore/forecaster/upcoming/${locationCode}`)
            .then(res => res.json())
            .then(info => {
                let {forecast} = info;
                
                const upcomingOutput = document.querySelector('#upcoming');

                const forecastInfoDiv = document.createElement('div');
                forecastInfoDiv.classList.add('forecast-info');

                for (const day of forecast) {

                    const upcomingSpan = document.createElement('span');
                    upcomingSpan.classList.add('upcoming');

                    const symbolSpan = document.createElement('span');
                    symbolSpan.classList.add('symbol');
                    symbolSpan.textContent = weatherSymbols[day.condition];

                    const temperatureSpan = document.createElement('span');
                    temperatureSpan.classList.add('forecast-data');
                    temperatureSpan.textContent = `${day.low}°/${day.high}°`;

                    const conditionSpan = document.createElement('span');
                    conditionSpan.classList.add('forecast-data');
                    conditionSpan.textContent = day.condition;

                    upcomingSpan.appendChild(symbolSpan);
                    upcomingSpan.appendChild(temperatureSpan);
                    upcomingSpan.appendChild(conditionSpan);

                    forecastInfoDiv.appendChild(upcomingSpan);
                }
                upcomingOutput.appendChild(forecastInfoDiv);
            })
        });
    }
}

attachEvents();