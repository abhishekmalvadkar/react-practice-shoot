package in.bookmark.api.repository;

import org.springframework.data.domain.Page;

import in.bookmark.api.entity.BookmarkEntity;
import in.bookmark.api.request.BookmarkCriteriaRequest;

public interface BookmarkRepositoryCustom {
	
	Page<BookmarkEntity> getBookmarkByCriteria(BookmarkCriteriaRequest criteria);

}
