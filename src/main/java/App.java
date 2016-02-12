import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/coinApp.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/result", (request, response) -> {
      HashMap model = new HashMap();
      String centsString = request.queryParams("userInput");
      System.out.println ("userInput: " + centsString);
      Integer cents = Integer.parseInt(centsString);
      System.out.println("cents " + cents);
      HashMap<String, Integer> coins = new HashMap<String, Integer>();
      coins = giveChange(cents);
      int quarters = coins.get("Quarters");
      int dimes = coins.get("Dimes");
      int nickels = coins.get("Nickels");
      int pennies = coins.get("Pennies");
      String displayCoins = String.format("You need %s quarters, %s dimes, %s nickels, and %s pennies", quarters, dimes, nickels, pennies);


      model.put("template", "templates/coinResult.vtl");
      model.put("result", String.format(displayCoins));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

//Looks good, clean code

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
