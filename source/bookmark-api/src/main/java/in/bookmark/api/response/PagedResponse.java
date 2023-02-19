package in.bookmark.api.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagedResponse<T> {
	
	private List<T> contents;
	
	private Integer totalPages;
	
	private Long totalRecords;
	
	private Boolean hasNext;
	
	private Boolean hasPrevious;
	
	private Boolean isLast;
	
	private Boolean isFirst;

}
