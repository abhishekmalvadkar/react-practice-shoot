import { Fragment, useEffect, useState } from "react";
import { Link } from "react-router-dom";

function Home() {
  const [bookmarks, setBookmarks] = useState([]);

  useEffect(() => {
    fetchBookmarks();
  }, []);

  console.log("bookmark list", bookmarks);
  return (
    <>
      <div className="container mt-2">
        <div className="mb-2">
        <Link to="/add-bookmark"><button className="btn btn-success">Add Bookmark</button></Link>
        </div>
        <div>
          <h1>My Bookmark List</h1>
          {bookmarks
            ? bookmarks.map((bookmark) => {
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
            : "Loading....."}
        </div>
      </div>
    </>
  );

  function fetchBookmarks() {
    fetch("http://localhost:8080/api/bookmarks") // Will give you promise
      .then((response) => response.json()) // Will give you promise , response.json() will give body as promise , only response will give you body , headers , status etc...
      .then((apiRespoonse) => setBookmarks(apiRespoonse.data));
  }
}

export default Home;
