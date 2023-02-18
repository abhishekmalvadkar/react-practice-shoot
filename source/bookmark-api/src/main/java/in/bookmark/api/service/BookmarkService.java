package in.bookmark.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.bookmark.api.entity.BookmarkEntity;
import in.bookmark.api.mapper.BookmarkMapper;
import in.bookmark.api.repository.BookmarkRepository;
import in.bookmark.api.request.BookmarkCreateRequest;
import in.bookmark.api.response.BookmarkResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    private final BookmarkMapper mapper;

    public List<BookmarkResponse> getBookmarks() {
        List<BookmarkEntity> bookmarkEntities = this.bookmarkRepository.findAll();

        List<BookmarkResponse> bookmarks = bookmarkEntities.stream()
                .map(bookmarkEntity -> {
                    return new BookmarkResponse(bookmarkEntity.getId(), bookmarkEntity.getUrl(),
                            bookmarkEntity.getTitle(), bookmarkEntity.getCreatedDateTime(),
                            bookmarkEntity.getUpdatedDateTime());
                }).collect(Collectors.toList());
        return bookmarks;
    }

    public Integer createBookmark(BookmarkCreateRequest bookmarkCreateRequest) {
        BookmarkEntity entity = this.mapper.toEntity(bookmarkCreateRequest);
        BookmarkEntity savedEntity = this.bookmarkRepository.save(entity);
        return savedEntity.getId();
        
    }

}
