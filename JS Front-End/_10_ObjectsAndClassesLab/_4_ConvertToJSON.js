function convertToJSON(firstNAme, lastName, hairColor) {
    
    let person = {
        name: firstNAme,
        lastName,
        hairColor
    }

    let converted = JSON.stringify(person);

    console.log(converted);
}

convertToJSON('George', 'Jones', 'Brown');