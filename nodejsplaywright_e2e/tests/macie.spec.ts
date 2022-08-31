
const { test, expect } = require('@playwright/test');
test('test', async ({ page }) => {
  // Go to https://www.macieenligne.ci/
  await page.goto('https://www.macieenligne.ci/');
  // Click text=Besoin d'aide
  await page.click('text=Besoin d\'aide');
  expect(page.url()).toBe('https://www.macieenligne.ci/besoin_daide');
});