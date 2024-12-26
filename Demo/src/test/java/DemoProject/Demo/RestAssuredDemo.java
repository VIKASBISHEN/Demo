package DemoProject.Demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class RestAssuredDemo {
	
	@Test
	  public void f1()
	  {
		 Response response = RestAssured.get("https://api.coindesk.com/v1/bpi/currentprice.json");
		 System.out.println(response.statusCode());
		 JsonPath path=response.jsonPath();
		 Assert.assertEquals(response.body().asString().contains("USD"),true);
		 Assert.assertEquals(response.body().asString().contains("GBP"),true);
		 Assert.assertEquals(response.body().asString().contains("EUR"),true);
		 Assert.assertEquals(path.getString("bpi.GBP.description"), "British Pound Sterling");
		 
	  }
	  

}
