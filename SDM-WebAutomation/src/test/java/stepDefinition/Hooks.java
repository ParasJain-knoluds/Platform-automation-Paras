package stepDefinition;

import ddtConfig.DataReader;
import ddtConfig.ExcelDataReader;
import ddtConfig.ReaderConfig;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.TestContextSetup;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Hooks {
   TestContextSetup tcs;
    public Hooks(TestContextSetup tcs){
        this.tcs=tcs;
    }

    @Before
    public void setUp() throws InterruptedException {
        tcs.pom.getFooter().signInGoogle();
        tcs.pom.getFooter().closeFooterPopup();
    }

    @After
    public void tearDown() throws IOException {
        tcs.base.initializeDriver().quit();
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = tcs.base.driver;
        if (scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }
    }

    @DataTableType
    public DataReader excelToDataTable(Map<String, String> entry) {
        ReaderConfig config = new ReaderConfig.ReaderConfigBuilder()
                .setFileName(entry.get("Excel"))
                .setFileLocation(entry.get("Location"))
                .setSheetName(entry.get("Sheet"))
                .setColumnName(Integer.parseInt(entry.getOrDefault("ColumnHeader", "0")))
                .setIndex(Integer.valueOf(entry.getOrDefault("Index", "0")))
                .build();
        return new ExcelDataReader(config);
    }

}
