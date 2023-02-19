package in.bookmark.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.bookmark.api.entity.BookmarkEntity;
import in.bookmark.api.mapper.BookmarkMapper;
import in.bookmark.api.repository.BookmarkRepository;
import in.bookmark.api.request.BookmarkCreateRequest;
import in.bookmark.api.request.BookmarkCriteriaRequest;
import in.bookmark.api.response.BookmarkResponse;
import in.bookmark.api.response.PagedResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    private final BookmarkMapper mapper;

    public PagedResponse<BookmarkResponse> getBookmarks(BookmarkCriteriaRequest criteria) {
        Page<BookmarkEntity> pagedEntities = this.bookmarkRepository.getBookmarkByCriteria(criteria);
        List<BookmarkResponse> dtos = this.mapper.toDtoList(pagedEntities.getContent());
        PagedResponse<BookmarkResponse> pagedResponse = new PagedResponse<>();
        pagedResponse.setContents(dtos);
        pagedResponse.setHasNext(pagedEntities.hasNext());
        pagedResponse.setHasPrevious(pagedEntities.hasPrevious());
        pagedResponse.setIsFirst(pagedEntities.isFirst());
        pagedResponse.setIsLast(pagedEntities.isLast());
        pagedResponse.setTotalPages(pagedEntities.getTotalPages());
        pagedResponse.setTotalRecords(pagedEntities.getTotalElements());
        return pagedResponse;
    }

    public Integer createBookmark(BookmarkCreateRequest bookmarkCreateRequest) {
        BookmarkEntity entity = this.mapper.toEntity(bookmarkCreateRequest);
        BookmarkEntity savedEntity = this.bookmarkRepository.save(entity);
        return savedEntity.getId();
        
    }

}
