package in.bookmark.api.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkResponse {

    private Integer bookmarkId;
    private String bookmarkUrl;
    private String bookmarkTitle;
    private String createdDateTimeStr;

}
