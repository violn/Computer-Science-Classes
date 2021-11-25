import java.util.Comparator;

public class CarEnhanced implements Comparable<CarEnhanced> , Comparator<CarEnhanced>{
    private String name;
    private Double price;
    
    CarEnhanced() {
    }
 
    CarEnhanced(String name, double price) {
       this.name = name;
       this.price = price;
    }
 
    public String getName() {
       return name;
    }
 
    public Double getgetPrice() {
       return price;
    }

   @Override
   public int compareTo(CarEnhanced o) {
      // TODO Auto-generated method stub
      return (int)( this.getgetPrice() - o.getgetPrice());
   }
 

   //  @Override
   //  // Overriding the compare method to sort the age @Override
   //  public int compare(CarEnhanced firstCar, CarEnhanced secondCar) {
   //     return (int)(firstCar.price - secondCar.price);
   //  }

  
   // @Override
   // public int compareTo(CarEnhanced car) {
   //    // TODO Auto-generated method stub
   //    return (this.price).compareTo(car.getgetPrice());
   // }

   @Override
   public int hashCode() {
         return price.hashCode();
   }

   @Override
   public int compare(CarEnhanced c1, CarEnhanced c2) {
      // TODO Auto-generated method stub
      return c1.getName().compareTo(c2.getName());
   }

   public String toString(){
      return  this.price + "> "+ this.name;
   }
}
