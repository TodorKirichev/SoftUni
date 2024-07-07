function solve(input) {
    
    class Song {
        constructor(typeList, name, time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }

    let numOfSongs = input.shift();

    let songs = [];

    for (let i = 0; i < numOfSongs; i++) {
        let [typeList, name, time] = input[i].split('_');
        
        let song = new Song(typeList, name, time);
        songs.push(song);
    }

    let typeListToPrint = input[numOfSongs];

    songs
    .filter(song => song.typeList === typeListToPrint || typeListToPrint === 'all')
    .forEach(song => console.log(song.name));
}

solve([4,
    'favourite_DownTown_3:14',
    'listenLater_Andalouse_3:24',
    'favourite_In To The Night_3:58',
    'favourite_Live It Up_3:48',
    'listenLater']
    );