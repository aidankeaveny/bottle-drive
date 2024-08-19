import globals from "globals";
import js from "@eslint/js";
import react from "@eslint-react/eslint-plugin"; // Make sure this is the correct import

export default [
  js.configs.recommended,
  {
    files: ["**/*.{js,mjs,cjs,jsx}"],
    languageOptions: { 
      globals: globals.browser,
      parserOptions: {
        ecmaVersion: 2021,
        sourceType: "module",
        ecmaFeatures: {
          jsx: true,
        },
      },
    },
    plugins: {
      react: react,
    },
    settings: {
      react: {
        version: "detect", // Automatically detect the React version
      },
    },
    rules: {
      "semi": ["error", "always"],
    },
    ...react.configs.recommended,
  },
];
