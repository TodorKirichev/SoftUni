function solve(input) {

    let dictionary = input.map(JSON.parse);
    
    let result = {};

    for (const obj of dictionary) {
        let word = Object.keys(obj)[0];

        result[word] = obj[word];
    }

    Object.entries(result).sort((a,b) => a[0].localeCompare(b[0]))
    .forEach(e => console.log(`Term: ${e[0]} => Definition: ${e[1]}`));
}

solve(['{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}',
    '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}',
    '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
    '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
    '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}']);