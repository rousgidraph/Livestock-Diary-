package code;

public class LiveStock_dao {

    String stock_name ;
    String stock_food ;
    String stock_health ;
    String stock_product ;
    String stock_tips ;

    public LiveStock_dao(String stock_name, String stock_food, String stock_health, String stock_product, String stock_tips) {
        this.stock_name = stock_name;
        this.stock_food = stock_food;
        this.stock_health = stock_health;
        this.stock_product = stock_product;
        this.stock_tips = stock_tips;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public String getStock_food() {
        return stock_food;
    }

    public void setStock_food(String stock_food) {
        this.stock_food = stock_food;
    }

    public String getStock_health() {
        return stock_health;
    }

    public void setStock_health(String stock_health) {
        this.stock_health = stock_health;
    }

    public String getStock_product() {
        return stock_product;
    }

    public void setStock_product(String stock_product) {
        this.stock_product = stock_product;
    }

    public String getStock_tips() {
        return stock_tips;
    }

    public void setStock_tips(String stock_tips) {
        this.stock_tips = stock_tips;
    }
}
