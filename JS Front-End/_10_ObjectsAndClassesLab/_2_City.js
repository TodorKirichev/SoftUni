function solve(person) {
    Object.entries(person).forEach(entry => console.log(`${entry[0]} -> ${entry[1]}`));
}

solve({
    name: "Sofia",
    area: 492,
    population: 1238438,
    country: "Bulgaria",
    postCode: "1000"
}
);