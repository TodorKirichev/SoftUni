function calculate(first, second, operator) {

  switch (operator) {

    case "multiply":
      return first * second;
    case "divide":
      return first / second;
    case "add":
      return first + second;
    case "subtract":
      return first - second;

  }

}

console.log(calculate(5, 5, "multiply"));
console.log(calculate(40, 8, "divide"));
console.log(calculate(12, 19, "add"));
console.log(calculate(50, 13, "subtract"));
