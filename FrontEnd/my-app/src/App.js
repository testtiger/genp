import React from "react";
import logo from "./logo.svg";
import "./App.css";
import LibraryList from "./Components/libraryList.js";
import { makeGetCall } from "./Components/rest-client";
import BooksList from "./Components/booksList";
const url = "/api/libs";
class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      libs: [],
      bookList: [],
      selectedLibId: null,
      selectedLibName: null,
      selectedBook: null,
    };
    this.showBooksHandler = this.showBooksHandler.bind(this);
    this.openBookHandler = this.openBookHandler.bind(this);
  }
  componentDidMount() {
    this.fetchLibraries();
  }

  fetchLibraries() {
    var self = this;
    makeGetCall(url).then((response) => {
      console.log("libs are ============>", response);
      self.setState({ libs: response });
    });
  }
  resetSelection() {
    this.setState({ selectedBook: null });
  }
  showBooksHandler(id, name) {
    this.setState({ selectedLibId: id, selectedLibName: name });
    this.fetchBooks(id);
    this.resetSelection();
  }
  fetchBooks(libId) {
    var uri = url + "/" + libId + "/books";
    var self = this;
    makeGetCall(uri).then((response) => {
      self.setState({ bookList: response });
    });
  }

  openBookHandler(id, name) {
    this.fetchBookDetails(this.state.selectedLibId, id);
  }
  fetchBookDetails(libId, bookId) {
    var uri = url + "/" + libId + "/books/" + bookId;
    var self = this;
    makeGetCall(uri).then((response) => {
      self.setState({ selectedBook: response });
    });
  }

  render() {
    var bookDetails = showNoSelectedText("book");

    return (
      <div className="App">
        <header className="App-header">
          <p>Libraries App.</p>
        </header>
        <div className="container">
          <div className="column">
            <LibraryList
              list={this.state.libs}
              showBooksHandler={this.showBooksHandler}
            />
          </div>
          <div className="column">
            <h4>
              Books List{" "}
              {this.state.selectedLibName
                ? "for " + this.state.selectedLibName
                : ""}
            </h4>
            <BooksList
              libId={this.state.selectedLibId}
              name={this.state.selectedLibName}
              list={this.state.bookList}
              clickHandler={this.openBookHandler}
            />
          </div>
          <div className="column">{bookDetails}</div>
        </div>
      </div>
    );
  }
}

export default App;

function showNoSelectedText(text) {
  return <span>Select A {text} to display</span>;
}
