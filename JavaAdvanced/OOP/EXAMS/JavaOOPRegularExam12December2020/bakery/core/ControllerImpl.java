package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.core.interfaces.Controller;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.bakedFoods.Bread;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.bakedFoods.Cake;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.bakedFoods.interfaces.BakedFood;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.drinks.Tea;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.drinks.Water;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.drinks.interfaces.Drink;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.tables.InsideTable;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.tables.OutsideTable;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.tables.interfaces.Table;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.repositories.interfaces.*;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double income;


    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {

        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        this.income = 0;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood food = foodRepository.getByName(name);
        if (food != null) {
            throw new IllegalArgumentException(String.format("%s %s is already in the menu", type, name));
        }
        switch (type) {
            case "Bread":
                food = new Bread(name, price);
                break;
            case "Cake":
                food = new Cake(name, price);
                break;
        }
        foodRepository.add(food);
        return String.format("Added %s (%s) to the menu", name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = drinkRepository.getByNameAndBrand(name, brand);
        if (drink != null) {
            throw new IllegalArgumentException(String.format("%s %s is already in the menu", type, name));
        }
        switch (type) {
            case "Tea":
                drink = new Tea(name, portion, brand);
                break;
            case "Water":
                drink = new Water(name, portion, brand);
                break;
        }
        drinkRepository.add(drink);
        return String.format("Added %s (%s) to the drink menu", name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = tableRepository.getByNumber(tableNumber);
        if (table != null) {
            throw new IllegalArgumentException(String.format("Table %d is already added to the restaurant", tableNumber));
        }
        switch (type) {
            case "InsideTable":
                table = new InsideTable(tableNumber, capacity);
                break;
            case "OutsideTable":
                table = new OutsideTable(tableNumber, capacity);
                break;
        }
        tableRepository.add(table);
        return String.format("Added table number %d in the SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery", tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table table = tableRepository.getAll().stream()
                .filter(t -> !t.isReserved() && t.getCapacity() >= numberOfPeople).findFirst().orElse(null);
        if (table == null) {
            return String.format("No available table for %d people", numberOfPeople);
        }
        table.reserve(numberOfPeople);
        return String.format("Table %d has been reserved for %d people", table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = tableRepository.getByNumber(tableNumber);
        if (table == null || !table.isReserved()) {
            return String.format("Could not find table %d", tableNumber);
        }
        BakedFood food = foodRepository.getByName(foodName);
        if (food == null) {
            return String.format("No %s in the menu", foodName);
        }
        table.orderFood(food);
        return String.format("Table %d ordered %s", tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table table = tableRepository.getByNumber(tableNumber);
        if (table == null || !table.isReserved()) {
            return String.format("Could not find table %d", tableNumber);
        }
        Drink drink = drinkRepository.getByNameAndBrand(drinkName, drinkBrand);
        if (drink == null) {
            return String.format("There is no %s %s available", drinkName, drinkBrand);
        }
        table.orderDrink(drink);
        return String.format("Table %d ordered %s %s", tableNumber, drinkName, drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        income += bill;
        table.clear();
        return String.format("Table: %d%nBill: %.2f", tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        List<Table> freeTables = tableRepository.getAll().stream()
                .filter(t -> !t.isReserved()).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        freeTables.forEach(t -> sb.append(t.getFreeTableInfo()).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format("Total income: %.2flv", income);
    }
}
