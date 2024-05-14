package com.microsoft.playwright;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.HashMap;

public class TestReleaseMemory {
  @Test
  public void testReleaseMemory() {
    HashMap<String, String> map = new HashMap<>();
    map.put("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "1");
    try (Playwright playwright = Playwright.create(new Playwright.CreateOptions().setEnv(map))) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
        .setExecutablePath(Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe"))
      );
      Page page = browser.newPage();
      page.onResponse(e->{
        System.out.println("响应:"+e.url());
      });
      Response navigate = page.navigate("https://www.baidu.com");
      System.out.println(page.title());
    }
  }
}
