import java.util.*;

class DrinkRobot extends Robot{
    private Integer cola;
    private Integer sprite;
    private Integer blacktea;
    private Integer lemontea;
    private Integer price;

    DrinkRobot (Integer prices) {
        this.cola = 0;
        this.sprite = 0;
        this.blacktea = 0;
        this.lemontea = 5;
        this.price = prices;
    }

    int process (Integer drinkchoice) {
        totalprice = 0;
        if(drinkchoice==1) {
            this.totalprice = this.totalprice + this.cola;
        }
        else if(drinkchoice==2) {
            this.totalprice = this.totalprice + this.sprite;
        }
        else if(drinkchoice==3) {
            this.totalprice = this.totalprice + this.blacktea;
        }
        else if(drinkchoice==4) {
            this.totalprice = this.totalprice + this.lemontea;
        }
        return this.totalprice;
    }

}
