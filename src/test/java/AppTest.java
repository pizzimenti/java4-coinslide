import org.junit.*;
import static org.junit.Assert.*;
import java.util.HashMap;


import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();


  @Test
  public void giveChange_25cents_1quarter() {
    App testApp = new App();

    assertEquals("{Nickels=0, Dimes=0, Quarters=1, Pennies=0}", testApp.giveChange(25).toString());
  }


  //Remove unnecessary comments? Also could probably use more tests? (Integration tests too)



  // @Test
  // public void giveChange_45cents_1quarter2dimes() {
  //   App testApp = new App();
  //
  //   // HashMap<String, Integer> coins = new HashMap<String, Integer>();
  //   // coins.put("Quarters", 1);
  //   // coins.put("Dimes", 2);
  //   // coins.put("Nickels", 0);
  //   // coins.put("Pennies", 0);
  //
  //   HashMap testMap = testApp.giveChange(45);
  //   Integer testQuarters = testMap.get("Quarters");
  //
  //   assertEquals(1, 1);
  // }

  // @Test
  // public void giveChange_25cents_1quarter() {
  //   App testApp = new App();
  //   numberOfCoins = testApp.giveChange(25);
  //   assertEquals(1,numberOfCoins.get());
  // }

  // @Test
  // public void rootTest() {
  //     goTo("http://localhost:4567/");
  //     assertThat(pageSource()).contains("Leap year detector");
  // }
}
