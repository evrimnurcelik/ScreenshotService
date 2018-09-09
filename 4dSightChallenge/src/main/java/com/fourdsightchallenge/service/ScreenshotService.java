package com.fourdsightchallenge.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.fourdsightchallenge.screenshot.util.ScreenshotUtil;

@Service
public class ScreenshotService {
	public List<File> getScreenshots(String filename) {
		List<String> urls = ScreenshotUtil.getUrls(filename);
		File screenshot = null;
		List<File> screenshots = new ArrayList<>();
		for (String url : CollectionUtils.emptyIfNull(urls)) {
			screenshot = ScreenshotUtil.getScreenshot(url);
			screenshots.add(screenshot);
		}
		return screenshots;
	}

}
