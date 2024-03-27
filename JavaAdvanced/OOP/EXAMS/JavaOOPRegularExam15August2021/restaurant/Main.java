package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.core.ControllerImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.core.EngineImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.core.interfaces.Controller;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.entities.drinks.interfaces.Beverages;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.entities.tables.interfaces.Table;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.io.ConsoleReader;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.io.ConsoleWriter;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.repositories.BeverageRepositoryImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.repositories.HealthFoodRepositoryImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.repositories.TableRepositoryImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {

        HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthFoodRepositoryImpl();
        BeverageRepository<Beverages> beverageRepository = new BeverageRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
