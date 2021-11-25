public class SplitEmails {
public static void main(String[] args) {
    //Gets each email in a string array with split by having a comma as the delimiter
    String sourceString = "poohpool@signet.co,swd@websource.co.in, jobs@websource.co.in, info@rupizxpress.com, mla@mla-india.com";
    System.out.println(" Source String is " + sourceString);
    for (String email : sourceString.split(",")) {
        for (String details : email.split("@")) {
            System.out.println("Details are  " + details);
        }
        System.out.println(" --------- NEXT - RECORD -------- ");
    }
}
}
