package in.bookmark.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkCreateRequest {

    private String bookmarkUrl;
    private String bookmarkTitle;

}
