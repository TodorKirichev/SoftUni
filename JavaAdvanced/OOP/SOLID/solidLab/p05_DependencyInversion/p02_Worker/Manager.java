package SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p05_DependencyInversion.p02_Worker;

public class Manager {

    public Manager(Worker worker) {
        worker.work();
    }
}
