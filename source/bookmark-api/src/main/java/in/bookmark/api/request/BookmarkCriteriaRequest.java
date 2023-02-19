package in.bookmark.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkCriteriaRequest {
	
	private String searchText;
	
	private Integer pageNumber = 1;
	
	private Integer pageSize = 2;

}
