package skyflight.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skyflight.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
    Page findAll(Pageable pageable);
}

