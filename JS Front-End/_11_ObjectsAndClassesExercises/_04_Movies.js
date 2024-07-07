function solve(commands) {
    
    let listMovies = [];

    for (const command of commands) {
        let commandInfo = command.split(' ');

        let movie = {};

        if (commandInfo.includes('addMovie')) {
            movie.name = command.split('addMovie ')[1];
            listMovies.push(movie);
        } else if (commandInfo.includes('directedBy')) {
            let [name, director] = command.split(' directedBy ');
            movie = listMovies.find(m => m.name === name);
            if (movie) {
                movie.director = director;
            }   
        } else if (commandInfo.includes('onDate')) {
            let [name, date] = command.split(' onDate ');
            movie = listMovies.find(m => m.name === name);
            if (movie) {
                movie.date = date;
            }
            
        }
    }
    listMovies
    .filter(m => m.name !== undefined && m.director !== undefined && m.date !== undefined)
    .forEach(m => console.log(JSON.stringify(m)))

}

solve([
    'addMovie The Avengers',
    'addMovie Superman',
    'The Avengers directedBy Anthony Russo',
    'The Avengers onDate 30.07.2010',
    'Captain America onDate 30.07.2010',
    'Captain America directedBy Joe Russo'
    ]
    );