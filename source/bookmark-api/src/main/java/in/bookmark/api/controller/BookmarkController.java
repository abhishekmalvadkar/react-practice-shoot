package in.bookmark.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bookmark.api.request.BookmarkCreateRequest;
import in.bookmark.api.response.ApiResponse;
import in.bookmark.api.response.BookmarkResponse;
import in.bookmark.api.service.BookmarkService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;
    

    @GetMapping("/status")
    public String status(){
        return "UP";
    }

    @GetMapping("/bookmarks")
    public ApiResponse<List<BookmarkResponse>> getBookmarks(){
        List<BookmarkResponse> bookmarks = this.bookmarkService.getBookmarks();
        ApiResponse<List<BookmarkResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setData(bookmarks);
        apiResponse.setStatus(HttpStatus.OK.value());
        return apiResponse;
    }

    @PostMapping("/bookmarks")
    public ApiResponse<Integer> createBookmark(@RequestBody BookmarkCreateRequest bookmarkCreateRequest){
        Integer bookmarkId = this.bookmarkService.createBookmark(bookmarkCreateRequest);
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setData(bookmarkId);
        apiResponse.setStatus(HttpStatus.CREATED.value());
        return apiResponse;

    }



}
