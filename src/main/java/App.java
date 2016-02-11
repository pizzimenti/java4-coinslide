import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    //
    // int cents = request.queryParams("cents");
    // HashMap<String, Integer> coins = new HashMap<String, Integer>();
    // coins = giveChange(cents);
    //
    // String displayChange = "You need %s quarters, %s dimes, %s nickels, % pennies"

  }


  public static HashMap giveChange(int cents) {

    int quarters;
    int dimes;
    int nickels;
    int pennies;

    quarters = cents / 25;
    cents = cents % 25;

    dimes = cents / 10;
    cents = cents % 10;

    nickels = cents / 5;
    cents = cents % 5;

    pennies = cents / 1;
    cents = cents % 1;

    HashMap<String, Integer> coins = new HashMap<String, Integer>();
    coins.put("Quarters", quarters);
    coins.put("Dimes", dimes);
    coins.put("Nickels", nickels);
    coins.put("Pennies", pennies);

    return coins;
    // int numQuarters = coins.get("Quarters");
    // System.out.println(numQuarters);
    // return numQuarters;
  }
}
