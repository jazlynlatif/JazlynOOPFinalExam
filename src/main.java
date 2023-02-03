import java.io.IOException;
import java.util.*;

public class Main {
    static DrinkRobot drinkrobot = new DrinkRobot(null);
    static FrenchFriesRobot frenchfriesrobot = new FrenchFriesRobot(null);
    static FriedChickenRobot friedchickenrobot = new FriedChickenRobot();
    static HamburgerRobot hamburgerrobot = new HamburgerRobot();
    static HotdogRobot hotdogrobot = new HotdogRobot();
    static ArrayList<Order> orders = new ArrayList<Order>();
    
    public static Integer Totalpriceses;

    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" ");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int purchaselist() {
        Scanner Jazlyn = new Scanner(System.in);
        int gather;
        System.out.print("\033[H\033[2J");
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|No | Main Menu         | French Fries  | Drink         | Price     |");
        System.out.println("+-------------------------------------------------------------------+");
        for(int i=0;i<orders.size();i++) {
            orders.get(i).print_data();
        }
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("                                                        |-----------|");
        System.out.println("                                                        |Total Price|");
        System.out.println("                                                        |-----------|");
        System.out.println("                                                        |" +Totalpriceses + "\t    |");
        System.out.println("                                                        |-----------|");
        int number=0;
        do {
            System.out.println("Total Price");
            System.out.println("Do you want to,");
            System.out.println("(1) Back to Menu");
            System.out.println("(2) Finish Order");
            System.out.println("(1/2)?");
            number = Jazlyn.nextInt();
        } while(number<1||number>2);
        return number;
    }

    static int finalscene(Integer noorder) {
        Scanner Jazlyn = new Scanner(System.in);
        String yesorno;
        int sizes;
        sizes = orders.size();
        System.out.print("\033[H\033[2J");
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|No | Main Menu         | French Fries  | Drink         | Price     |");
        System.out.println("+-------------------------------------------------------------------+");
        for(int i=0;i<sizes;i++) {
            orders.get(i).print_data();
        }
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("                                                        |-----------|");
        System.out.println("                                                        |Total Price|");
        System.out.println("                                                        |-----------|");
        System.out.println("                                                        |" +Totalpriceses + "\t    |");
        System.out.println("                                                        |-----------|");
        int number=0;
        do {
            System.out.println("\nAre You Sure? (Y/N)");
            yesorno = Jazlyn.next();
            if(yesorno.equals("Y")) {
                number = 100;
            }
            else if(yesorno.equals("N")) {
                number = 1;
                return number;
            }
        } while (number!=100);

        System.out.println("Processing...\n");

        Runnable TaskA = new Chef(noorder);
        Runnable TaskB = new Time(noorder);
    
        Thread threadOne = new Thread(TaskA);
        Thread threadTwo = new Thread(TaskB);
    
        threadOne.start(); 
        threadTwo.start();

        promptEnterKey();

        System.out.println("Your order will be prepared as soon as you pay");
        System.out.println("Please pay in the cashier\n");

        System.out.println("To Print Receipt");
        promptEnterKey();

        System.out.print("\033[H\033[2J");
        System.out.println("\n+-------------------------------------------------------------------+");
        System.out.println("+                              Receipt                              +");
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|No | Main Menu         | French Fries  | Drink         | Price     |");
        System.out.println("+-------------------------------------------------------------------+");
        for(int i=0;i<sizes;i++) {
            orders.get(i).print_data();
        }
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("                                                        |-----------|");
        System.out.println("                                                        |Total Price|");
        System.out.println("                                                        |-----------|");
        System.out.println("                                                        |" +Totalpriceses + "\t    |");
        System.out.println("                                                        |-----------|");        

        System.out.println("Please go to the nearest cashier to pay");
        System.out.println("Thank You! Till We Meet Again");
        return number;

    } 

    static int drinks () {
        Scanner Jazlyn = new Scanner(System.in);
        int drink;
        do {
        System.out.println("\nChoose Drink Type,");
        System.out.println("(1) Coca Cola     (+Rp0.0)");
        System.out.println("(2) Soda Sprite   (+Rp0.0)");
        System.out.println("(3) Black Tea     (+Rp0.0)");
        System.out.println("(4) Lemon Tea     (+Rp5.000,00)");
        System.out.println("Option (1-4) : ");
        drink = Jazlyn.nextInt();
        if(drink < 1 || drink > 4) {
            System.out.println("\nUnavailable Number Entered. Try Again");
        }
        } while (drink<1||drink>4);
        return drink;
    }

    

    static String drinkstxt(Integer drink) {
        String name="no drink";
        if(drink==1) {
            name = "Coca Cola";
        }
        else if(drink==2) {
            name = "Soda Sprite";
        }
        else if(drink==3) {
            name = "Black tea";
        }
        else if(drink==4) {
            name = "Lemon tea";
        }
        return name;
    }

    static String frenchfriestxt(Integer frenchfry) {
        String name="no drink";
        if(frenchfry==1) {
            name = "Original";
        }
        else if(frenchfry==2) {
            name = "Barbeque";
        }
        else if(frenchfry==3) {
            name = "Seaweed";
        }
        else if(frenchfry==4) {
            name = "Blackpepper";
        }
        return name;
    }


    static int frenchfriess () {
        Scanner Jazlyn = new Scanner(System.in);
        int frenchfries;
        do{
        System.out.println("\nChoose French Fries,");
        System.out.println("(1) Original      (+Rp0.0)");
        System.out.println("(2) Barbeque      (+Rp3.000,00)");
        System.out.println("(3) Seaweed       (+Rp3.000,00)");
        System.out.println("(4) Black Pepper  (+Rp4.000,00)");
        System.out.println("Option (1-4) : ");
        frenchfries = Jazlyn.nextInt();
        if(frenchfries < 1 || frenchfries > 4) {
            System.out.println("\nUnavailable Number Entered. Try Again");
        }
        } while (frenchfries<1||frenchfries>4);
        return frenchfries;
    }

    static int packageA(Integer noorder) {
        Scanner Jazlyn = new Scanner(System.in);
        int hotdog, frenchfries, drink, totalprice=50, addprice=0, number=0;
        String yesorno, addon="Hot Dog", drinklist, frenchlist;
        System.out.print("\033[H\033[2J"); 
        System.out.println("Package A   : Hotdog, French Fries, Drink");
        System.out.println("Price       : Rp50.000,00\n");

        do{
            System.out.println("Choose Hotdog Type,");
            System.out.println("(1) Original      (+Rp0.0)");
            System.out.println("(2) Fire Hotdog   (+Rp10.000,00)");
            System.out.println("(3) Cheese Hotdog (+Rp15.000,00)");
            System.out.println("(4) Vegan Hotdog  (+Rp20.000,00)");
            System.out.println("Option (1-4) : ");
            hotdog = Jazlyn.nextInt();
        } while (hotdog<1||hotdog>4);

        if(hotdog==1) {
            addon = "Original Hotdog";
        }
        else if(hotdog==2) {
            addon = "Fire Hotdog";
        }
        else if(hotdog==3) {
            addon = "Cheese Hotdog";
        }
        else if(hotdog==4) {
            addon = "Vegan Hotdog";
        }

        frenchfries = frenchfriess();
        drink = drinks();

        addprice = addprice + hotdogrobot.process(hotdog);
        addprice = addprice + frenchfriesrobot.process(frenchfries);
        addprice = addprice + drinkrobot.process(drink);
        totalprice = totalprice + addprice;

        Totalpriceses = Totalpriceses + totalprice;

        frenchlist=frenchfriestxt(frenchfries);
        drinklist=drinkstxt(drink);

        noorder= noorder + 1;
        orders.add(new Order(noorder, addon, frenchlist, drinklist, totalprice));

        System.out.println("\n+----------------------+");
        System.out.println("| Total Price     : " +totalprice +" |");
        System.out.println("+----------------------+");

        do {
            System.out.println("Another Order? (Y/N)");
            yesorno = Jazlyn.next();
            if(yesorno.equals("Y")) {
                number = 1;
            }
            else if(yesorno.equals("N")) {
                number = 2;
            }
        } while (number<1||number>2);
        return number;

        
    }
    static int packageB(Integer noorder) {
        Scanner Jazlyn = new Scanner(System.in);
        int burger, frenchfries, drink, totalprice = 60, addprice=0, number=0;
        String yesorno, addon="Burger", drinklist, frenchlist;
        System.out.print("\033[H\033[2J"); 
        System.out.println("Package A   : Hamburger, French Fries, Drink");
        System.out.println("Price       : Rp60.000,00\n");
        
        do {
            System.out.println("Choose Burger Type,");
            System.out.println("(1) Beef Burger   (+Rp0.0)");
            System.out.println("(2) Fire Burger   (+Rp10.000,00)");
            System.out.println("(3) Cheese Burger (+Rp15.000,00)");
            System.out.println("(4) Vegan Burger  (+Rp20.000,00)");
            System.out.println("Option (1-4) : ");
            burger = Jazlyn.nextInt();
        } while (burger<1||burger>4);

        if(burger==1) {
            addon = "Original Burger";
        }
        else if(burger==2) {
            addon = "Fire Burger";
        }
        else if(burger==3) {
            addon = "Cheese Burger";
        }
        else if(burger==4) {
            addon = "Vegan Burger";
        }
            
        frenchfries = frenchfriess();
        drink = drinks();
        
        addprice = addprice + hamburgerrobot.process(burger);
        addprice = addprice + frenchfriesrobot.process(frenchfries);
        addprice = addprice + drinkrobot.process(drink);
        totalprice = totalprice + addprice;

        Totalpriceses = Totalpriceses + totalprice;

        frenchlist=frenchfriestxt(frenchfries);
        drinklist=drinkstxt(drink);

        noorder= noorder + 1;
        orders.add(new Order(noorder, addon, frenchlist, drinklist, totalprice));

        System.out.println("\n+----------------------+");
        System.out.println("| Total Price     : " +totalprice +" |");
        System.out.println("+----------------------+");
        
        do {
            System.out.println("Another Order? (Y/N)");
            yesorno = Jazlyn.next();
            if(yesorno.equals("Y")) {
            number = 1;
            }
            else if(yesorno.equals("N")) {
                number = 2;
            }
        } while (number<1||number>2);
        return number;
    }
    
    static int packageC(Integer noorder) {
        Scanner Jazlyn = new Scanner(System.in);
        int friedchicken, frenchfries, drink, totalprice = 55, addprice=0, number=0;
        String yesorno, addon="Fried Chicken", drinklist, frenchlist;
        System.out.print("\033[H\033[2J"); 
        System.out.println("Package A   : Fried Chicken , French Fries, Drink");
        System.out.println("Price       : Rp55.000,00\n");

        do{
            System.out.println("Choose Fried Chicken Type,");
            System.out.println("(1) Original             (+Rp0.0)");
            System.out.println("(2) Fire Fried Chicken   (+Rp10.000,00)");
            System.out.println("(3) Cheesy Fried Chicken (+Rp15.000,00)");
            System.out.println("(4) Garlic Fried Chicken (+Rp15.000,00)");
            System.out.println("Option (1-4) : ");
            friedchicken = Jazlyn.nextInt();
        } while (friedchicken<1||friedchicken>4);

        if(friedchicken==1) {
            addon = "Original Burger";
        }
        else if(friedchicken==2) {
            addon = "Fire Burger";
        }
        else if(friedchicken==3) {
            addon = "Cheese Burger";
        }
        else if(friedchicken==4) {
            addon = "Vegan Burger";
        }
        
    
        frenchfries = frenchfriess();
        drink = drinks();

        addprice = addprice + friedchickenrobot.process(friedchicken);
        addprice = addprice + frenchfriesrobot.process(frenchfries);
        addprice = addprice + drinkrobot.process(drink);
        totalprice = totalprice + addprice;

        Totalpriceses = Totalpriceses + totalprice;

        frenchlist=frenchfriestxt(frenchfries);
        drinklist=drinkstxt(drink);

        noorder= noorder + 1;
        orders.add(new Order(noorder, addon, frenchlist, drinklist, totalprice));
    
        System.out.println("\n+----------------------+");
        System.out.println("| Total Price     : " +totalprice +" |");
        System.out.println("+----------------------+");

        do {
            System.out.println("Another Order? (Y/N)");
            yesorno = Jazlyn.next();
            if(yesorno.equals("Y")) {
                number = 1;
            }
            else if(yesorno.equals("N")) {
                number = 2;
            }
        } while (number<1||number>2);
        return number;
    }

    public static void main(String[] args) throws Exception {
        Scanner Jazlyn = new Scanner(System.in);
        String chosen;
        int order=0, number=0, non;
        Totalpriceses=0;
        do{
            non=0;
            System.out.print("\033[H\033[2J");
            System.out.println("+-------------------------------------------------+");
            System.out.println("|              Cheong Sun Restaurant              |");
            System.out.println("+-------------------------------------------------+");
            System.out.println("Menu Options,");
            System.out.println("- Package A   : Hotdog, French Fries, Drink");
            System.out.println("- Package B   : Hamburger, French Fries, Drink");
            System.out.println("- Package C   : Fried Chicken, French Fries, Drink");
            if(order>0) {
                System.out.println("Press P for Purchases");
                System.out.println("Press F to Finish Order");
            }
            System.out.println("\nChoose Package ");
            chosen = Jazlyn.nextLine();
            if(chosen.equals("A")) {
                number=packageA(order);
            }
            else if(chosen.equals("B")) {
                number=packageB(order);
            }
            else if(chosen.equals("C")) {
                number=packageC(order);
            }
            else if(chosen.equals("P")) {
                number=purchaselist();
                order = order - 1;
            }
            else if(chosen.equals("F")) {
                number= 2;
            }
            else number= 200;
            if(number==1) {
                order = order +1;
            }
            else if(number==2) {
                number=finalscene(order);
                if(number==1) {
                    order = order - 1;
                }
            }
            else if(number==200) {
                non = 200;
            }
            else order = 0;
            if(number==100) {
                System.exit(0);
            }
        } while(order!=0||non==200);
    }
}
