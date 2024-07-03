function convertToObject(string) {
    let person = JSON.parse(string);
    Object.entries(person).forEach(entry => console.log(`${entry[0]}: ${entry[1]}`));
}

convertToObject('{"name": "George", "age": 40, "town": "Sofia"}');