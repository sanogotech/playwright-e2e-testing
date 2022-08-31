const { chromium } = require('playwright');
(async () => {
  const browser = await chromium.launch({
    headless: false
  });
  const context = await browser.newContext();
  // Open new page
  const page = await context.newPage();
  // Go to https://www.macieenligne.ci/
  await page.goto('https://www.macieenligne.ci/');
  // Click text=Besoin d'aide
  await page.click('text=Besoin d\'aide');
  // assert.equal(page.url(), 'https://www.macieenligne.ci/besoin_daide');
  // ---------------------
  await context.close();
  await browser.close();
})();