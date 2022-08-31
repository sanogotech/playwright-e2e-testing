
from playwright.sync_api import Playwright, sync_playwright
def run(playwright: Playwright) -> None:
    browser = playwright.chromium.launch(headless=False)
    context = browser.new_context()
    # Open new page
    page = context.new_page()
    # Go to https://www.macieenligne.ci/
    page.goto("https://www.macieenligne.ci/")
    # Click text=Besoin d'aide
    page.click("text=Besoin d'aide")
    # assert page.url == "https://www.macieenligne.ci/besoin_daide"
    # ---------------------
    context.close()
    browser.close()
with sync_playwright() as playwright:
    run(playwright)
