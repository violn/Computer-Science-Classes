public class CarHash extends Object{
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

    //method to compare state of this and other object
     //which is passed as a parameter
     //if all states are same between two objects then
     //this method will result true, else false
   @Override
   public boolean equals(Object b) {
      boolean result = false;
      if (b instanceof CarHash) {
      CarHash c = (CarHash) b;
      result = c.getName().equalsIgnoreCase(getName()) && 
               c.getPrice() == getPrice();
      }
      return result;
   }
   //Require to override when overriding equals() method
   //so that two equals objects will return same hashcode
   //which will avoid duplicate elements in Hash 
   //like collections, such as HashSet
   @Override
   public int hashCode() {
         return (int) price;
   }

}
