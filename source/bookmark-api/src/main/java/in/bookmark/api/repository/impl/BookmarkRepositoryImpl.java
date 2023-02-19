package in.bookmark.api.repository.impl;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import in.bookmark.api.entity.BookmarkEntity;
import in.bookmark.api.repository.BookmarkRepositoryCustom;
import in.bookmark.api.request.BookmarkCriteriaRequest;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BookmarkRepositoryImpl implements BookmarkRepositoryCustom {

	private final EntityManager em;

	@Override
	public Page<BookmarkEntity> getBookmarkByCriteria(BookmarkCriteriaRequest criteria) {

		StringBuilder fetchJpqlBuilder = new StringBuilder("SELECT bm FROM BookmarkEntity bm");

		StringBuilder countJpqlBuilder = new StringBuilder("SELECT COUNT(bm) FROM BookmarkEntity bm");

		if (Objects.nonNull(criteria.getSearchText()) && !criteria.getSearchText().isEmpty()) {
			fetchJpqlBuilder.append(" WHERE bm.title LIKE :searchText");
			countJpqlBuilder.append(" WHERE bm.title LIKE :searchText");
		}
		
		fetchJpqlBuilder.append(" ORDER BY bm.createdDateTime DESC");

		String fetchJpqlQuery = fetchJpqlBuilder.toString();

		TypedQuery<BookmarkEntity> fetchTypedQuery = this.em.createQuery(fetchJpqlQuery, BookmarkEntity.class);

		String countJpqlQuery = countJpqlBuilder.toString();
		TypedQuery<Long> countTypedQuery = this.em.createQuery(countJpqlQuery, Long.class);

		if (Objects.nonNull(criteria.getSearchText()) && !criteria.getSearchText().isEmpty()) {
			fetchTypedQuery.setParameter("searchText", "%" + criteria.getSearchText() + "%");
			countTypedQuery.setParameter("searchText", "%" + criteria.getSearchText() + "%");
		}

		fetchTypedQuery.setFirstResult((criteria.getPageNumber() - 1) * criteria.getPageSize());
		fetchTypedQuery.setMaxResults(criteria.getPageSize());

		List<BookmarkEntity> entities = fetchTypedQuery.getResultList();

		Long totalRecords = countTypedQuery.getSingleResult();

		Pageable pageable = PageRequest.of(criteria.getPageNumber() - 1, criteria.getPageSize());

		return new PageImpl<>(entities, pageable, totalRecords);
	}

}
