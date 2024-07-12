function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick () {
      const input = document.querySelector('#input textarea');

      let restaurants = [];

      for (const restaurant of input) {
         let[name, workers] = restaurant.split(' - ');

         let currentRestaurant = {
            name,
            workers
         }
         if (restaurants.includes()) {
            
         }
      }
      
   }
}