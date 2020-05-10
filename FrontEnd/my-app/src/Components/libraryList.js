import React from "react";
import { makeGetCall } from "./rest-client";
import "../App.css";
export default function LibraryList(props) {
  const { list, showBooksHandler } = props;
  return (
    <div>
      <h1>Libraries list</h1>
      <Library list={list} showBooksHandler={showBooksHandler} />
    </div>
  );
}

export function Library(props) {
  var resp = props.list;

  var libEle = resp.map((lib) => {
    return (
      <li key={lib.id}>
        <span>{lib.name}</span>
        <button onClick={() => props.showBooksHandler(lib.id, lib.name)}>
          Show Books
        </button>
      </li>
    );
  });

  return <ul className="listItem">{libEle}</ul>;
}
