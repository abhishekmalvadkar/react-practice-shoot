package in.bookmark.api.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import in.bookmark.api.entity.BookmarkEntity;
import in.bookmark.api.request.BookmarkCreateRequest;

@Component
public class BookmarkMapper {

    public BookmarkEntity toEntity(BookmarkCreateRequest request){
        BookmarkEntity entity = new BookmarkEntity();
        entity.setTitle(request.getBookmarkTitle());
        entity.setUrl(request.getBookmarkUrl());
        entity.setCreatedDateTime(LocalDateTime.now());
        entity.setUpdatedDateTime(LocalDateTime.now());
        return entity;
        
    }
    
}
