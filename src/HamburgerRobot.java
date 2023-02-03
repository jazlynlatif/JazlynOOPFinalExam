import java.util.*;

class HamburgerRobot extends Robot {
    private Integer beef;
    private Integer fire;
    private Integer cheese;
    private Integer vegan;

    HamburgerRobot() {
        this.beef = 0;
        this.fire = 10;
        this.cheese = 15;
        this.vegan = 20;
    }

    int process (Integer burgerchoice) {
        this.totalprice = 0;
        if(burgerchoice==1) {
            this.totalprice = this.totalprice + this.beef;
        }
        else if(burgerchoice==2) {
            this.totalprice = this.totalprice + this.fire;
        }
        else if(burgerchoice==3) {
            this.totalprice = this.totalprice + this.cheese;
        }
        else if(burgerchoice==4) {
            this.totalprice = this.totalprice + this.vegan;
        }
        return this.totalprice;
    }
}
