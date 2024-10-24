const URL = 'http://localhost:3030/jsonstore/tasks/';
const loadMealsButton = document.querySelector('#load-meals');
const list = document.querySelector('#list');
const foodInput = document.querySelector('#food');
const timeInput = document.querySelector('#time');
const caloriesInput = document.querySelector('#calories');
const addMealButton = document.querySelector('#add-meal');
const editMealButton = document.querySelector('#edit-meal');
let currentId;

loadMealsButton.addEventListener('click', loadMeals);

async function loadMeals() {

    list.innerHTML = '';

    const meals = await (await fetch(URL)).json();
    console.log(meals);

    Object.values(meals).forEach(meal => {
        const divMeal = document.createElement('div');
        divMeal.classList.add('meal');

        const food = document.createElement('h2');
        food.textContent = meal.food;

        const time = document.createElement('h3');
        time.textContent = meal.time;

        const calories = document.createElement('h3');
        calories.textContent = meal.calories;

        divMeal.appendChild(food);
        divMeal.appendChild(time);
        divMeal.appendChild(calories);

        const buttonContainer = document.createElement('div');
        buttonContainer.classList.add('meal-buttons');

        const changeButton = document.createElement('button');
        changeButton.classList.add('change-meal');
        changeButton.textContent = 'Change';

        changeButton.addEventListener('click', changeMeal);

        function changeMeal() {
            foodInput.value = food.textContent;
            timeInput.value = time.textContent;
            caloriesInput.value = calories.textContent;

            currentId = meal._id;

            divMeal.remove();

            addMealButton.disabled = 'disabled';
            editMealButton.removeAttribute('disabled');
        }

        const deleteButton = document.createElement('button');
        deleteButton.classList.add('delete-meal');
        deleteButton.textContent = 'Delete';

        deleteButton.addEventListener('click', deleteMeal);

        async function deleteMeal() {
            await fetch(`${URL}${meal._id}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            })

            loadMeals();
        }

        buttonContainer.appendChild(changeButton);
        buttonContainer.appendChild(deleteButton);

        divMeal.appendChild(buttonContainer);

        list.appendChild(divMeal);
    })
}

addMealButton.addEventListener('click', addMeal);

async function addMeal() {

    const newMeal = {
        food: foodInput.value,
        time: timeInput.value,
        calories: caloriesInput.value
    }

    await fetch(URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newMeal)
    })

    loadMeals();
    clearInputs();
}

editMealButton.addEventListener('click', editMeal);

async function editMeal() {
    
    const updatedMeal = {
        food: foodInput.value,
        time: timeInput.value,
        calories: caloriesInput.value,
        _id: currentId
    }

    await fetch(`${URL}${currentId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedMeal)
    })

    loadMeals();
    clearInputs();

    addMealButton.removeAttribute('disabled');
    editMealButton.disabled = 'disabled';
}

function clearInputs() {
    foodInput.value = '';
    timeInput.value = '';
    caloriesInput.value = '';
}