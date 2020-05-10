import React from 'react';
import { render } from '@testing-library/react';
import App from './App';

import { shallow } from "enzyme";

import LibraryList from "./Components/libraryList.js";
import BooksList from "./Components/booksList";
import { Library } from "./Components/booksList";


test("expect component is called at least once", () => {
  const wrapper = shallow(<LibraryList />);
  expect(wrapper.find(Library).length).toEqual(1);
  
});


test("expect component is called at least once", () => {
  const wrapper = shallow(<LibraryList />);
  expect(wrapper.find(Library).length).toEqual(1);
});
