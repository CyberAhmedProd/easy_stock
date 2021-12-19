package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Integer, Article> {
    @Query("select a from article where code_article = :code and designation = :designation")
    List<Article> findByCustomQuery(@Param("code") String code, @Param("designation") String designation);

    @Query(value="select * from article where code_article = :code", nativeQuery = true)
    List<Article> findByCustomQuery(@Param("code") String code);

    List<Article> findByCodeArticleIgnoreCaseAndDesignationIgnoreCase(String codeArticle, String designation);
}
