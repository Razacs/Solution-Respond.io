const { defineConfig } = require('cypress');

module.exports = defineConfig({
  "reporter": "mochawesome",
  "reporterOptions": {
    "reportDir": "cypress/results",
    "reportFilename": "report",
    "overwrite": false,
    "html": true,
    "json": true,
    "charts": true,
    "timestamp": "mmddyyyy_HHMMss"
  },
  e2e: {
    // We've imported your old cypress plugins here.
    // You may want to clean this up later by importing these.
    setupNodeEvents(on, config) {
      return require('./cypress/plugins/index.js')(on, config);
    }

  }
});