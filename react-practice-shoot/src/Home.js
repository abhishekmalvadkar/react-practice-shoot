import { Fragment, useEffect, useState } from "react";
import { Link } from "react-router-dom";

function Home() {
  const [bookmarks, setBookmarks] = useState([]);
  const [isFirst, setIsFirst] = useState(false);
  const [isLast, setIsLast] = useState(false);
  const [hasNext, setHasNext] = useState(false);
  const [hasPrev, setHasPrev] = useState(false);
  const [pageNumber, setPageNumber] = useState(1);
  const [searchText, setSearchText] = useState(null);

  useEffect(() => {
    fetchBookmarks();
  }, [pageNumber]);

  console.log("bookmark list", bookmarks);
  return (
    <>
      <div className="container mt-2">
        <div className="row mb-2">
          <div className="col-md-6">
            <Link to="/add-bookmark">
              <button className="btn btn-success">Add Bookmark</button>
            </Link>
          </div>
          <div className="col-md-3">
            <input
              type="text"
              className="form-control"
              value={searchText}
              onChange={(e) => setSearchText(e.target.value)}
            />
          </div>
          <div className="col-md-3">
            <button className="btn btn-primary" onClick={fetchBookmarks}>
              Search
            </button>
          </div>
        </div>
        <div>
          <h1>My Bookmark List</h1>
          {bookmarks.length > 0 ? (
            bookmarks.map((bookmark) => {
              return (
                <Fragment key={bookmark.bookmarkId}>
                  <div className="card mt-3">
                    <div className="card-body">
                      <h5 className="card-title">{bookmark.bookmarkTitle}</h5>
                      <p className="card-text">
                        Published on : {bookmark.createdDateTime}
                      </p>
                      <a
                        href={bookmark.bookmarkUrl}
                        target="_blank"
                        className="btn btn-primary"
                        rel="noreferrer"
                      >
                        Go To Link
                      </a>
                    </div>
                  </div>
                </Fragment>
              );
            })
          ) : (
            <>
              <div class="alert alert-primary" role="alert">
                No Data To Display
              </div>
            </>
          )}
          <br />
          <div className="row">
            {hasPrev ? (
              <>
                <div className="col-md-6 left">
                  <button className="btn btn-success" onClick={onPrev}>
                    Previous
                  </button>
                </div>
              </>
            ) : (
              <>
                <div className="col-md-6 left"></div>
              </>
            )}
            {hasNext ? (
              <>
                <div className="col-md-6 right">
                  <button className="btn btn-success" onClick={onNext}>
                    Next
                  </button>
                </div>
              </>
            ) : (
              <>
                <div className="col-md-6 right"></div>
              </>
            )}
          </div>
        </div>
      </div>
    </>
  );

  function onPrev() {
    const page = pageNumber - 1;
    setPageNumber(page);
  }

  function onNext() {
    const page = pageNumber + 1;
    setPageNumber(page);
  }

  function fetchBookmarks() {
    const bookmarkCriteria = {
      searchText: searchText,
      pageNumber: pageNumber,
      pageSize: 2,
    };
    fetch("http://localhost:8080/api/bookmarks/criteria", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(bookmarkCriteria),
    }) // Will give you promise
      .then((response) => response.json()) // Will give you promise , response.json() will give body as promise , only response will give you body , headers , status etc...
      .then((apiRespoonse) => {
        const data = apiRespoonse.data;
        setBookmarks(data.contents);
        setIsFirst(data.isFirst);
        setIsLast(data.isLast);
        setHasNext(data.hasNext);
        setHasPrev(data.hasPrevious);
      });
  }
}

export default Home;
