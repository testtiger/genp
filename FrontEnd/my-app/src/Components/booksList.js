import React from "react";
import "../App.css";
export default function BooksList(props) {
  if (props.libId === null) {
    return <span>No library selected</span>;
  }
  return (
    <React.Fragment>
      <table>
        <Book list={props.list} clickHandler={props.clickHandler} />
      </table>
    </React.Fragment>
  );
}

export function Book(props) {
  var resp = props.list;
  if (props.list.length === 0) {
    return <span>No Books present under lib</span>;
  }
  var bookEle = resp.map((book) => {
    return (
      <tr key={book.bookId}>
        <td>
          <h5>
            {(function () {
              let b = book.name;
              return b.toUpperCase();
            })()}
          </h5>
        </td>
        <td>
          <span>by {book.author}</span>
        </td>
        <td>
          <button
            onClick={() => {
              props.clickHandler(book.bookId, book.name);
            }}
          >
            Show details
          </button>
        </td>
      </tr>
    );
  });

  return <tbody className="listItem">{bookEle}</tbody>;
}
