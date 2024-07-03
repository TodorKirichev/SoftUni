function solve(startingYield) {
    let extractedSpice = 0;
    let days = 0;
  
    while (startingYield >= 100) {
        days++;
        extractedSpice += startingYield - 26;
        startingYield -= 10;
  
      if (startingYield < 26) {
        break;
      }
  
      if (startingYield < 100) {
        extractedSpice -= 26;
      }
    }
    console.log(days);
    console.log(extractedSpice);
  }

  solve(450);