package in.bookmark.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.bookmark.api.entity.BookmarkEntity;

public interface BookmarkRepository extends JpaRepository<BookmarkEntity , Integer> {
    
}
