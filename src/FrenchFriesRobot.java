import java.util.*;

class FrenchFriesRobot extends Robot{
    private Integer original;
    private Integer bbq;
    private Integer seaweed;
    private Integer blackpepper;
    private Integer price;

    FrenchFriesRobot (Integer prices) {
        this.original = 0;
        this.bbq = 3;
        this.seaweed = 3;
        this.blackpepper = 4;
        this.price = prices;
    }

    int process (Integer frenchfrieschoice) {
        totalprice = 0;
        if(frenchfrieschoice==1) {
            this.totalprice = this.totalprice + this.original;
        }
        else if(frenchfrieschoice==2) {
            this.totalprice = this.totalprice + this.bbq;
        }
        else if(frenchfrieschoice==3) {
            this.totalprice = this.totalprice + this.seaweed;
        }
        else if(frenchfrieschoice==4) {
            this.totalprice = this.totalprice + this.blackpepper;
        }
        return this.totalprice;
    }
}
