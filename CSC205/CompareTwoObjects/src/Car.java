public class Car implements Comparable<Car> {
   private String name;
   private double price;

   Car(String name, double price) {
      this.name = name;
      this.price = price;
   }

   public String getName() {
      return name;
   }

   public double getPrice() {
      return price;
   }

   @Override
   public int compareTo(Car car) {
      return (int)(this.price - car.getPrice());
   }
}
