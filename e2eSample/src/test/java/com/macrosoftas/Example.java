package com.macrosoftas;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.util.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example {
	
	// Shared between all tests in this class.
  private static Playwright playwright;
  private static Browser browser;

  // New instance for each test method.
  BrowserContext context;
  Page page;

  @BeforeAll
  public static void launchBrowser() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch();
  }

  @AfterAll
  public static void closeBrowser() {
    playwright.close();
  }

  @BeforeEach
  public void createContextAndPage() {
    context = browser.newContext();
    page = context.newPage();
  }

  @AfterEach
  public void closeContext() {
    context.close();
  }

   @Test
  public  void testMaCIE() {
  
      // Go to https://www.macieenligne.ci/
      page.navigate("https://www.macieenligne.ci/");
      // Click text=Besoin d'aide
      page.click("text=Besoin d'aide");
      // assert page.url().equals("https://www.macieenligne.ci/besoin_daide");
    }
  
}