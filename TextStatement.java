import java.util.Enumeration;

public class TextStatement extends Statement {
    
   private String getPrologue(Customer aCustomer) {
      return "Rental Record for " + aCustomer.getName() + "\n";
   }

   private String getFigures(Rental aRental) {
      return "\t" + aRental.getMovie().getTitle()+ "\t" + String.valueOf(aRental.getCharge()) + "\n";
   }

   private String getFooter(Customer aCustomer) {
      return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n" +
            "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
            " frequent renter points";
   }    
      
    public String value(Customer aCustomer) {
      
      Enumeration rentals = aCustomer.getRentals();
      String result = getPrologue(aCustomer);
      
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         //show figures for this rental
         result += getFigures(each);
      }
    result += getFooter(aCustomer);
    return result;
   }



}