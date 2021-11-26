public class CarHash extends Object {
   private String name;
   private double price;

   CarHash() {
   }

   CarHash(String name, double price) {
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
   public boolean equals(Object b) {
      boolean result = false;
      if (b instanceof CarHash c) {
         c = (CarHash) b;
         result = c.getName().equalsIgnoreCase(getName()) && c.getPrice() == getPrice();
      }
      return result;
   }

   @Override
   public int hashCode() {
      return (int) price;
   }

}
