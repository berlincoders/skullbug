// tailwind.config.js
module.exports = {
  content: [
    "./src/main/resources/templates/**/*.{html,js}", // Adjust the path according to where your Thymeleaf templates are located
    "./src/main/resources/static/**/*.html", // If you have any static HTML files
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}
