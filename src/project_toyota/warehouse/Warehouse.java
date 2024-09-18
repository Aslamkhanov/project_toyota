package project_toyota.warehouse;

import project_toyota.car.Camry;
import project_toyota.car.Dyna;
import project_toyota.car.Hiance;
import project_toyota.car.Solara;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private static final int WAREHOUSE_CAPACITY = 1000;
    private static int totalCars = 0;
    private List<Camry> typeCamry = new ArrayList<>();
    private List<Solara> typeSolara = new ArrayList<>();
    private List<Hiance> typeHiance = new ArrayList<>();
    private List<Dyna> typeDyna = new ArrayList<>();

    public static int getTotalCars() {
        return totalCars;
    }

    public void addCamry(Camry camry) {
        if (isWarehouseCapacity()) {
            typeCamry.add(camry);
        }
        totalCars++;
    }

    public void addSolara(Solara solara) {
        if (isWarehouseCapacity()) {
            typeSolara.add(solara);
        }
        totalCars++;
    }

    public void addHiance(Hiance hiance) {
        if (isWarehouseCapacity()) {
            typeHiance.add(hiance);
        }
        totalCars++;
    }

    public void addDyna(Dyna dyna) {
        if (isWarehouseCapacity()) {
            typeDyna.add(dyna);
        }
        totalCars++;
    }

    public Camry takeCamry(Camry camry) {
        typeCamry.removeIf(car -> car.equals(camry));
        totalCars--;
        return camry;
    }

    public Solara takeSolara(Solara solara) {
        typeSolara.removeIf(car -> car.equals(solara));
        totalCars--;
        return solara;
    }

    public Hiance takeHiance(Hiance hiance) {
        typeHiance.removeIf(car -> car.equals(hiance));
        totalCars--;
        return hiance;
    }

    public Dyna takeDyna(Dyna dyna) {
        typeDyna.removeIf(car -> car.equals(dyna));
        totalCars--;
        return dyna;
    }

    private boolean isWarehouseCapacity() {
        if (WAREHOUSE_CAPACITY > totalCars) {
            return true;
        }
        System.out.println("На складе нет места!");
        return false;
    }

    public void printWarehouseCamry() {
        System.out.println("На складе Camry - " + typeCamry.size());
    }

    public void printWarehouseSolara() {
        System.out.println("На складе Solara - " + typeSolara.size());
    }

    public void printWarehouseHiance() {
        System.out.println("На складе Hiance - " + typeHiance.size());
    }

    public void printWarehouseDyna() {
        System.out.println("На складе Dyna - " + typeDyna.size());
    }

    public List<Camry> getTypeCamry() {
        return typeCamry;
    }

    public List<Solara> getTypeSolara() {
        return typeSolara;
    }

    public List<Hiance> getTypeHiance() {
        return typeHiance;
    }

    public List<Dyna> getTypeDyna() {
        return typeDyna;
    }
}
