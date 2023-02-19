package in.bookmark.api.mapper;

import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Component;

import in.bookmark.api.entity.BookmarkEntity;
import in.bookmark.api.request.BookmarkCreateRequest;
import in.bookmark.api.response.BookmarkResponse;

@Component
public class BookmarkMapper {
	
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");

    public BookmarkEntity toEntity(BookmarkCreateRequest request){
        BookmarkEntity entity = new BookmarkEntity();
        entity.setTitle(request.getBookmarkTitle());
        entity.setUrl(request.getBookmarkUrl());
        entity.setCreatedDateTime(LocalDateTime.now());
        entity.setUpdatedDateTime(LocalDateTime.now());
        return entity;
        
    }
    
    public BookmarkResponse toDto(BookmarkEntity entity) {
    	BookmarkResponse bookmarkResponse = new BookmarkResponse();
    	bookmarkResponse.setBookmarkId(entity.getId());
    	bookmarkResponse.setBookmarkTitle(entity.getTitle());
    	bookmarkResponse.setBookmarkUrl(entity.getUrl());
    	bookmarkResponse.setCreatedDateTimeStr(dateTimeFormatter.format(entity.getCreatedDateTime()));
    	
    	return bookmarkResponse;
    }
    
    public List<BookmarkResponse> toDtoList(List<BookmarkEntity> entites) {
    	return entites.stream()
    			.map(this::toDto).collect(toList());
    }
    
}
