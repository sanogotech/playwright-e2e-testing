
package com.macrosoftas;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestExample {
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
  public void shouldClickButton() {
    page.navigate("data:text/html,<script>var result;</script><button onclick='result=\"Clicked\"'>Go</button>");
    page.click("button");
    assertEquals("Clicked", page.evaluate("result"));
  }

  @Test
  public void shouldCheckTheBox() {
    page.setContent("<input id='checkbox' type='checkbox'></input>");
    page.check("input");
    assertTrue((Boolean) page.evaluate("() => window['checkbox'].checked"));
  }

  @Test
  public void shouldSearchWiki() {
    page.navigate("https://www.wikipedia.org/");
    page.click("input[name=\"search\"]");
    page.fill("input[name=\"search\"]", "playwright");
    page.press("input[name=\"search\"]", "Enter");
    assertEquals("https://fr.wikipedia.org/w/index.php?title=Sp%C3%A9cial:Recherche&search=playwright&go=Go&ns0=1", page.url());
  }
}