package com.fourdsightchallenge.screenshot;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fourdsightchallenge.controller.ScreenshotRestController;
import com.fourdsightchallenge.screenshot.Application;
import com.fourdsightchallenge.service.ScreenshotService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Mock
	private ScreenshotService screenshotService;
	@InjectMocks
	private ScreenshotRestController controller;

	private static final String PREFIX = "src/main/resources/";

	@Test
	public void testOKScreenshotService() {
		ResponseEntity<Object> response = null;

		List<File> screenshots = new ArrayList<>();
		File file = new File(PREFIX + "screenshot8788380469791765398.png");
		screenshots.add(file);
		when(screenshotService.getScreenshots(anyString())).thenReturn(screenshots);

		response = controller.getScreenhsots("urls");
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

}
