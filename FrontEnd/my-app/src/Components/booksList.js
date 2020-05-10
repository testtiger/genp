import React from "react";
import "../App.css";
export default function BooksList(props) {
  if (props.libId === null) {
    return <span>No library selected</span>;
  }
  return (
    <React.Fragment>
      <h1>BookList</h1>
      <Book list={props.list} clickHandler={props.clickHandler} />
    </React.Fragment>
  );
}

function Book(props) {
  var resp = props.list;
  if (props.list.length === 0) {
    return <span>No Books present under lib</span>;
  }
  var bookEle = resp.map((book) => {
    return (
      <li key={book.bookId}>
        <span>{book.name}</span>
        <span>{book.author}</span>
        <button
          onClick={() => {
            props.clickHandler(book.bookId, book.name);
          }}
        >
          Show details
        </button>
      </li>
    );
  });

  return <ul className="listItem">{bookEle}</ul>;
}
