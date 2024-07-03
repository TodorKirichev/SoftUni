function solve(input) {
    
    let meetings = {};

    for (const meeting of input) {
        let [weekday, personName] = meeting.split(' ');

        if (meetings[weekday]) {
            console.log(`Conflict on ${weekday}!`);
        } else {
            console.log(`Scheduled for ${weekday}`);
            meetings[weekday] = personName;
        }
    }

    Object.entries(meetings).forEach(entry => console.log(`${entry[0]} -> ${entry[1]}`));

}

solve(['Monday Peter',
'Wednesday Bill',
'Monday Tim',
'Friday Tim']
);