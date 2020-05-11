import React from "react";
import { render } from "@testing-library/react";
import App from "./App";

import { create } from "react-test-renderer";
import renderer from "react-test-renderer";

test("Matches the APP snapshot", () => {
  const button = create(<App />);
  expect(button.toJSON()).toMatchSnapshot();
});

