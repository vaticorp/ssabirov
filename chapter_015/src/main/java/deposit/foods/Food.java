package deposit.foods;

/**
 * This class represents base-class.
 * @author Svyatoslav Sabirov.
 * @since 25.07.2018
 * @version 7.
 */
public class Food {

    private String name;
    private long expaireDate;
    private long createDate;
    private double price;
    private int discount;
    private boolean canReproduct;

    public Food(String name, long expaireDate, long createDate, double price, int discount, boolean canReproduct) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
        this.canReproduct = canReproduct;
    }

    public Food() {
    }

    public boolean isCanReproduct() {
        return canReproduct;
    }

    public void setCanReproduct(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(long expaireDate) {
        this.expaireDate = expaireDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double percentExpaireDate() {
        return 100 * (this.expaireDate - System.currentTimeMillis()) / (this.expaireDate - this.createDate);
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", expaireDate=" + expaireDate +
                ", createDate=" + createDate +
                ", price=" + price +
                ", discount=" + discount +
                ", canReproduct=" + canReproduct +
                '}';
    }
}
