import java.util.Comparator;

public class CarEnhanced implements Comparable<CarEnhanced>, Comparator<CarEnhanced> {
   private String name;
   private Double price;
   
   CarEnhanced(String name, double price) {
      this.name = name;
      this.price = price;
   }

   public String getName() {
      return name;
   }

   public Double getPrice() {
      return price;
   }

   @Override
   public int compareTo(CarEnhanced car) {
      return (this.name).compareTo(car.getName());
   }

   @Override
   public int compare(CarEnhanced c1, CarEnhanced c2) {
      return c1.getName().compareTo(c2.getName());
   }

   @Override
   public int hashCode() {
      return price.hashCode();
   }

   @Override
   public String toString() {
      return this.name + " > " + this.price;
   }
}
