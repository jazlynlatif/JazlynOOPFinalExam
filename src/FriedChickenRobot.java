import java.util.*;

class FriedChickenRobot extends Robot {
    private Integer original;
    private Integer fire;
    private Integer cheesy;
    private Integer garlic;

    FriedChickenRobot () {
        this.original = 0;
        this.fire = 10;
        this.cheesy = 15;
        this.garlic = 15;
    }

    int process (Integer friedchickenchoice) {
        this.totalprice = 0;
        if(friedchickenchoice==1) {
            this.totalprice = this.totalprice + this.original;
        }
        else if(friedchickenchoice==2) {
            this.totalprice = this.totalprice + this.fire;
        }
        else if(friedchickenchoice==3) {
            this.totalprice = this.totalprice + this.cheesy;
        }
        else if(friedchickenchoice==4) {
            this.totalprice = this.totalprice + this.garlic;
        }
        return this.totalprice;
    }
}
