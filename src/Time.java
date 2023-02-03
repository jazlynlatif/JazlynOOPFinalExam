import java.util.*;

class Time implements Runnable{
    private Integer[] Packets = new Integer[1000];
    private Integer[] Time = new Integer[1000];
    private Integer data;
    private Integer timetotal;

    Time (Integer datas) {
        this.data = datas;
    }


    @Override
    public void run() {
        this.timetotal = 10;
        this.timetotal = this.timetotal + (this.data*3 - this.data);
        System.out.println("Your Order will be ready in " + this.timetotal + " minutes");
    }
}
