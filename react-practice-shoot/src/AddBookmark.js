import { useState } from "react";
import { Link } from "react-router-dom";

function AddBookmark() {

    const [title, setTitle] = useState(null);
    const [url, setUrl] = useState(null);

    function addBookmark() {

        const body = {
            bookmarkTitle : title,
            bookmarkUrl : url
        };

        console.log(body);

        fetch("http://localhost:8080/api/bookmarks" , {
            method : 'POST',
            headers : {
                'Content-Type' : 'application/json'
            },
            body : JSON.stringify(body)
        }) // Will give you promise
      .then((response) => response.json()) // Will give you promise , response.json() will give body as promise , only response will give you body , headers , status etc...
      .then((apiRespoonse) => {
        window.location.href = "/";
      })
      .catch(error => console.error(error));
        
    }
    
  return (
    <>
      <div className="container mt-2">
        <div className="mb-2">
          <Link to="/">
            <button className="btn btn-success">View Bookmarks</button>
          </Link>
        </div>
        <div>
          <h1>Add Bookmark</h1>
          <form>
            <div className="form-group">
              <label>Bookmark Title</label>
              <input
                type="text"
                className="form-control"
                placeholder="Enter bookmark title" onChange={e => setTitle(e.target.value)}
              />
              {title}
            </div><br/>
            <div className="form-group">
              <label>Bookmark URL</label>
              <input
                type="text"
                className="form-control"
                placeholder="Bookmark URL" onChange={e => setUrl(e.target.value)}
              />
              {url}
            </div><br/>
            <div className="form-group">
              <button className="btn btn-primary" onClick={addBookmark}>
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>
    </>
  );
}

export default AddBookmark;
