/*
    Title: Vending Machine
    Abstract: Mimic the functionality of a Vending Machine
    Author: Reece Whitelaw
    Date: 10/6/2021
 */
public class VendingMachine {

    private int options = 4;
    private int serialNumber;
    private String location;
    private int itemCounts[] = new int[options];
    private int orderCounts[] = new int[options];
    private int soldCounts[] = new int[options];
    private double itemCosts[] = new double[options];
    private String itemLabels[] = new String [options];


    public VendingMachine(int serialNumber){
        this.serialNumber = serialNumber;
        this.location = "UNKNOWN";
        itemLabels[0] = "Water";
        itemLabels[1] = "Coffee";
        itemLabels[2] = "Fritos";
        itemLabels[3] = "Lily's";
        itemCosts[0] = 1.5;
        itemCosts[1] = 2;
        itemCosts[2] = 1;
        itemCosts[3] = 2.5;

    }

    public VendingMachine(int serialNumber, String location){
        this.serialNumber = serialNumber;
        this.location = location;
        itemLabels[0] = "Water";
        itemLabels[1] = "Coffee";
        itemLabels[2] = "Fritos";
        itemLabels[3] = "Lily's";
        itemCosts[0] = 1.5;
        itemCosts[1] = 2;
        itemCosts[2] = 1;
        itemCosts[3] = 2.5;


    }

    public String toString(){
        System.out.println("===== Vending Machine Information =====");
        String retur = "Serial Number: " + serialNumber + "\nLocation: " + location +
                "\nContents: \n";
        for(int i = 0; i < options;i++ ){
        retur = retur + (i + 1) + ". " + itemLabels[i] + " $" + itemCosts[i] + "0 " + itemCounts[i] + " (Sold: " + soldCounts[i] + ")\n";
        }
        return retur;
    }

    public boolean buyItem(int itemindex){
        if(itemCounts[itemindex - 1] > 0){
            System.out.println("You selected " + itemLabels[itemindex - 1] + ". Quantity: 1" +"\n");
            return true;
        }
        return false;
    }

    public boolean buyItem(int itemindex, int amount){
        if(itemindex == 0){
            return false;
        }
        if(itemCounts[itemindex - 1] >= amount){
            orderCounts[itemindex - 1] += amount;
            itemCounts[itemindex - 1] -= amount;
            System.out.println("You selected " + itemLabels[itemindex - 1] + ". Quantity: " + amount);
            return true;
        }else{
            System.out.println("You selected " + itemLabels[itemindex - 1] + ". Quantity: " + amount);
            System.out.println("Selection failed. We don't have enough " + itemLabels[itemindex - 1] + ".");
            return false;
        }
    }

    public boolean pay(double payment){
        displayReceipt();
        System.out.println("Paying for order with $" + payment + "0");
        double totalcost = 0;
        for(int i = 0; i < 4; i++){
            totalcost += orderCounts[i] * itemCosts[i];
            if(orderCounts[i] > 1){
                soldCounts[i] = orderCounts[i];
            }
        }
        totalcost = totalcost + (totalcost * .1);
        if(totalcost > payment){
            //cant afford it :(
            System.out.println("Insufficient money. $" + (payment + "0 returned") );
            return false;
        }else{
            System.out.println("Sufficient money. $" + (payment-totalcost) + "0 returned");
            return true;
        }
    }

    public void displayReceipt(){
        double cost = 0;
        System.out.print("Order Receipt: " + "\n");
        for(int i = 0; i < 4; i++){
            if(orderCounts[i] > 0) {
                System.out.println(itemLabels[i] + ": " + orderCounts[i] + " X $" + itemCosts[i] + "0 = " + "$" + (orderCounts[i] * itemCosts[i]) + "0");
                cost += orderCounts[i] * itemCosts[i];
            }
        }
        System.out.print("Tax (10%): $" + (cost * 0.1) + "0" + "\n");
        System.out.print("Total: $" + (cost + (cost*0.1))+ "0" + "\n");
    }

    public int returnItem(int itemId, int quantity){
        if(itemId == 0){
            return(itemCounts[itemId - 1]);
        }
        if(quantity > orderCounts[itemId - 1]){
            orderCounts[itemId-1] = 0;
            System.out.print("You returned " + itemLabels[itemId - 1] + ". Quantity: " + quantity +'\n');
            return(itemCounts[itemId - 1]);
        }
        itemCounts[itemId - 1] += quantity;
        orderCounts[itemId - 1] -= quantity;
        System.out.print("You returned " + itemLabels[itemId - 1] + ". Quantity: " + quantity +'\n');
        return(itemId);
    }
    public boolean equals(VendingMachine vm){
        for(int i = 0; i < 3; i++){
            if(vm.itemCounts[i] != vm.itemCounts[i + 1]){
                return false;
            }
        }
        return true;
    }

    public void resetItems(int water, int coffee, int fritos, int lilys){
        itemCounts[0] = water;
        itemCounts[1] = coffee;
        itemCounts[2] = fritos;
        itemCounts[3] = lilys;

    }

    public void addItems(int water, int coffee, int fritos, int lilys){
        itemCounts[0] += water;
        itemCounts[1] += coffee;
        itemCounts[2] += fritos;
        itemCounts[3] += lilys;
    }

    public int getSerialNumber(){
        return this.serialNumber;
    }

    public void setSerialNumber(int serialNumber){
        this.serialNumber = serialNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double orderTotal() {
        double cost = 0;
        if(orderCounts[0] >= 1){
            cost += (orderCounts[1] * 1.50);
        }
        if(orderCounts[1] >= 1){
            cost += (orderCounts[1] * 2.00);
        }
        if(orderCounts[2] >= 1){
            cost += (orderCounts[1] * 1.00);
        }
        if(orderCounts[3] >= 1){
            cost += (orderCounts[1] * 2.50);
        }
        cost += cost * 0.1;
        return cost;
    }

    public String toDollars( double amount){
        double harhar =Math.floor(amount/0.01);
        String hoohee = "" + harhar;
        return hoohee;

    }
}
