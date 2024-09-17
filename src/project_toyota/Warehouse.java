package project_toyota;

import project_toyota.car.*;

import java.math.BigDecimal;
import java.util.*;

public class Warehouse {
    private static final int WAREHOUSE_CAPACITY = 1000;
    private static int totalCars = 0;
    private List<Camry> typeCamry = new ArrayList<>();
    private List<Solara> typeSolara = new ArrayList<>();
    private List<Hiance> typeHiance = new ArrayList<>();
    private List<Dyna> typeDyna = new ArrayList<>();

    public Car getMostExpensiveCar() {
        Car mostExpensiveCar = null;
        BigDecimal maxPrice = BigDecimal.ZERO;
        for (Camry camry : typeCamry) {
            if (camry.getPrice().compareTo(maxPrice) > 0) {
                maxPrice = camry.getPrice();
                mostExpensiveCar = camry;
            }
        }
        for (Solara solara : typeSolara) {
            if (solara.getPrice().compareTo(maxPrice) > 0) {
                maxPrice = solara.getPrice();
                mostExpensiveCar = solara;
            }
        }
        for (Hiance hiance : typeHiance) {
            if (hiance.getPrice().compareTo(maxPrice) > 0) {
                maxPrice = hiance.getPrice();
                mostExpensiveCar = hiance;
            }
        }
        for (Dyna dyna : typeDyna) {
            if (dyna.getPrice().compareTo(maxPrice) > 0) {
                maxPrice = dyna.getPrice();
                mostExpensiveCar = dyna;
            }
        }
        return mostExpensiveCar;
    }


    public void addCamry(Camry camry){
      if (isWarehouseCapacity()){
          typeCamry.add(camry);
      }
      totalCars++;
  }
    public void addSolara(Solara solara){
        if (isWarehouseCapacity()){
            typeSolara.add(solara);
        }
        totalCars++;
    }
    public void addHiance(Hiance hiance){
        if (isWarehouseCapacity()){
            typeHiance.add(hiance);
        }
        totalCars++;
    }
    public void addDyna(Dyna dyna){
        if (isWarehouseCapacity()){
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
    private boolean isWarehouseCapacity(){
      if (WAREHOUSE_CAPACITY > totalCars){
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
    public void printWarehouseDyna(){
        System.out.println("На складе Dyna - " + typeDyna.size());
    }
    public static int getTotalCars() {
        return totalCars;
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
