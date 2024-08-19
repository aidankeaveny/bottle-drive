import globals from "globals";
import js from "@eslint/js";
import react from "@eslint-react/eslint-plugin";

export default [
  js.configs.recommended,
  {
    files: ["**/*.{js,mjs,cjs,jsx}"],
    ...react.configs.recommended,
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

    // ignores: [
    //   "assets/**", 
    //   "node_modules/**", 
    //   "dist/**", 
    //   ".vite/**", 
    //   ".cache/**",
    //   "build/**"
    // ],
  },
  
  // {
  //   plugins: {
  //     react: pluginReact,
  //   },
  //   settings: {
  //     react: {
  //       version: "detect",  // Automatically detect the React version
  //     },
  //   },
  // },
  // pluginReact.configs.flat.recommended,
];
