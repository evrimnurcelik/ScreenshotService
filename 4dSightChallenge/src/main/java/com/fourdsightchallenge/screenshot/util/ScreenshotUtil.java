package com.fourdsightchallenge.screenshot.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenshotUtil {

	private static final String PREFIX = "src/main/resources/";

	public static List<String> getUrls(String filename) {
		BufferedReader br = null;
		FileReader fr = null;
		List<String> urls = new ArrayList<>();
		String fullPath = PREFIX + filename + ".txt";
		try {
			fr = new FileReader(fullPath);
			br = new BufferedReader(fr);
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				urls.add(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return urls;
	}

	public static File getScreenshot(String url) {
		System.setProperty("webdriver.gecko.driver","C:\\SeleniumGecko\\geckodriver.exe");
		final WebDriver driver = new FirefoxDriver();
		final File screenShot = new File("screenshot.png").getAbsoluteFile();
		File outputFile = null;
		try {
			driver.get(url);
			outputFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(outputFile, screenShot);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		return outputFile;

	}
}