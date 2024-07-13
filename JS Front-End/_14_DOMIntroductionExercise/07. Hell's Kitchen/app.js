function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick () {
      const input = JSON.parse(document.querySelector('#inputs textarea').value);
      // const input = ["PizzaHut - Peter 500, George 300, Mark 800",
      // "TheLake - Bob 1300, Joe 780, Jane 660"];

      let restaurants = {};

      for (const line of input) {
         let restaurantName = line.split(' - ')[0];
         let workers = line.split(' - ')[1].split(', ');

         for (const worker of workers) {
            let[name, salary] = worker.split(' ');

            if (!restaurants.hasOwnProperty(restaurantName)) {
               restaurants[restaurantName] = {};
            }
            restaurants[restaurantName][name] = Number(salary);
            
         }
      }
         let bestRestaurant = '';
         let avgSalary = 0;

         for (const restaurant of Object.entries(restaurants)) {
            let restaurantName = restaurant[0];
            let workers = Object.entries(restaurant[1]);

            let totalSalaries = 0;

            for (const worker of workers) {
               let salary = worker[1];

               totalSalaries += salary;
            }
            let currentAvgSalary = totalSalaries / workers.length;

            if (currentAvgSalary > avgSalary) {
               avgSalary = currentAvgSalary;
               bestRestaurant = restaurantName;
            }
         }
         let sortedWorkersBySalary = Object.entries(restaurants[bestRestaurant]).sort((a, b) => b[1] - a[1]);
         
         let bestRestaurantOutput = `Name: ${bestRestaurant} Average Salary: ${avgSalary.toFixed(2)} Best Salary: ${sortedWorkersBySalary[0][1].toFixed(2)}`;
         let workersOutput = sortedWorkersBySalary.map(w => `Name: ${w[0]} With Salary: ${w[1]}`).join(' ');

         document.querySelector('#bestRestaurant p').textContent = bestRestaurantOutput;
         document.querySelector('#workers p').textContent = workersOutput;
      
   }

}
