import java.util.*;

class Chef implements Runnable {
    private Integer[] Packets = new Integer[1000];
    private String[] Chefs = new String[1000];
    private Integer data;

    Chef (Integer datas) {
        this.data = datas;
    }



    @Override
    public void run() {
        if(this.data<3) {
            System.out.println("Chef Kendall will prepare your dish");
        }
        else if(this.data>=3) {
            System.out.println("Chef Kendall and Chef Jenna will prepare your dish");
        }
    }
}

