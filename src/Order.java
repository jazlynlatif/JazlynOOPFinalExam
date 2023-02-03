import java.util.*;

class Order {
    private Integer noorder;
    private String mainmenu;
    private String frenchf;
    private String drink;
    private Integer totalprice;

    Order(Integer no_order, String main_menu, String frenchfries, String drinks, Integer total_price) {

        this.noorder = no_order;
        this.mainmenu = main_menu;
        this.frenchf = frenchfries;
        this.drink = drinks;
        this.totalprice = total_price;
    }

    void set_data(Integer no_order, String main_menu, String frenchfries, String drinks, Integer total_price) {
        this.noorder = no_order;
        this.mainmenu = main_menu;
        this.frenchf = frenchfries;
        this.drink = drinks;
        this.totalprice = total_price;
    }
    
    void set_noorder(Integer no_order) {
        this.noorder = no_order;
    }
    
    void set_mainmenu(String main_menu) {
        this.mainmenu = main_menu;
    }

    void set_frenchf(String frenchfries) {
        this.frenchf = frenchfries;
    }

    void set_drink(String drinks) {
        this.drink = drinks;
    }

    void set_totalprice(Integer total_price) {
        this.totalprice = total_price;
    }

    void print_data() {
        System.out.println("|  " + this.noorder + "|" + this.mainmenu +"\t|" + this.frenchf + "\t|" + this.drink + "\t|" 
        + this.totalprice + "\t    |");
    }

}
