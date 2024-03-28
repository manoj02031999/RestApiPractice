package restUtils;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.response.Response;
import reporting.ExtentReportManager;
import reporting.SetUp;

import java.util.*;

public class AssertionUtils {
    public static  void assertExpectedValuesWithJsonPath(Response response, Map<String,Object> expectedValuesMap){
        List<AssertionKeys> actualValuesMap = new ArrayList<>();
        actualValuesMap.add(new AssertionKeys("JSON PATH","EXPECTE VALUE","ACTUAL VALUE","RESULT"));
        boolean allMatched = true;

        Set<String> jsonPaths = expectedValuesMap.keySet();
        for (String jsonPath : jsonPaths){
            Optional<Object> actualValue = Optional.ofNullable(response.jsonPath().get(jsonPath));
            if (actualValue.isPresent()){
                Object value = actualValue.get();
                if (value.equals(expectedValuesMap.get(jsonPath))){
                    actualValuesMap.add(new AssertionKeys(jsonPath,expectedValuesMap.get(jsonPath),value,"MATCHED"));
                }else {
                    allMatched = false;
                    actualValuesMap.add(new AssertionKeys(jsonPath,expectedValuesMap.get(jsonPath),value,"NOT MATCHED"));
                }
            }else {
                allMatched = false;
                actualValuesMap.add(new AssertionKeys(jsonPath,expectedValuesMap.get(jsonPath),"VALUE NOT FOUND","NOT MATCHED"));
            }
        }
        if (allMatched){
            ExtentReportManager.logPassDetails("All Asserions are Passed 😊😊😊👌");
        }else {
            ExtentReportManager.logPassDetails("All Assertions are Not Passed 😒😒😒👎");
        }

        String[][] finalAssertionMap = actualValuesMap.stream().map(assertions -> new String[] {assertions.getJsonPath(),
        String.valueOf(assertions.getExpectedValue()),String.valueOf(assertions.getActualValue()),assertions.getResult()})
                .toArray(String[][]::new);
        SetUp.extentTest.get().info(MarkupHelper.createTable(finalAssertionMap));
    }
}
