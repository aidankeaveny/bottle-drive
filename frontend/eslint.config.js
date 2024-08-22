// @ts-nocheck
import react from 'eslint-plugin-react';

// Begin fix
react.configs.recommended.plugins = { react };
react.configs.recommended.languageOptions = {
  parserOptions: react.configs.recommended.parserOptions
};
delete react.configs.recommended.parserOptions;
// End fix

export default [
  react.configs.recommended,
  // Now add your own config
  {
    languageOptions: {},
    files: [`**/*.{js,jsx,ts,tsx}`],
    plugins: {
      react
    },
    settings: {
      react: {
        version: "detect", // Automatically detect the React version
      },
    },
    rules: {
      'semi': ['error', 'always'], // Add semicolon rule
    },
  }
];