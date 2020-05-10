import React from "react";
import { makeGetCall } from "./rest-client";
import "../App.css";
export default function LibraryList(props) {
  const { list, showBooksHandler } = props;
  return (
    <div>
      <h1>Libraries list</h1>
      <table>
        <Library list={list} showBooksHandler={showBooksHandler} />
      </table>
    </div>
  );
}


export function Library(props) {
  var resp = props.list;

  var libEle = resp.map((lib) => {
    return (
      <tr key={lib.id}>
        <td>
          <h3>{lib.name}</h3>
        </td>
        <td>
          <button onClick={() => props.showBooksHandler(lib.id, lib.name)}>
            Show Books
          </button>
        </td>
      </tr>
    );
  });

  return <tbody className="listItem">{libEle}</tbody>;
}
