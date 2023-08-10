package cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@shopping-cart",
    features = "src/test/resources/features",
    glue = "steps")
public class RunCucumberIT {
}
