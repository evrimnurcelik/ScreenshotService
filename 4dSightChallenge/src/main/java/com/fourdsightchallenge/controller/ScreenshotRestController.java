package com.fourdsightchallenge.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fourdsightchallenge.service.ScreenshotService;

@RestController
public class ScreenshotRestController {

	@Autowired
	private ScreenshotService screenshotService;

	@RequestMapping(value = "/api/screenshot", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getScreenhsots(
			@RequestParam(name = "fileName", required = true, defaultValue = "urls") String fileName) {
		List<File> screenshots = screenshotService.getScreenshots(fileName);
		return new ResponseEntity<>(screenshots, HttpStatus.OK);
	}

}
