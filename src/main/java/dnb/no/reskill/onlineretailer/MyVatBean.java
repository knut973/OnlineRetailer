package dnb.no.reskill.onlineretailer;

public class MyVatBean {

    private double percent = 100;

    public void setPercent(int percentFromServiceClass) {
        this.percent = percentFromServiceClass / percent;
    }

    public double getPercent() {
        return percent;
    }

    @Override
    public String toString(){
    return "Current percentage is " +percent;
    }
}