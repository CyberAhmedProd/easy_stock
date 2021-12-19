package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Integer, Article> {
    Article findArticleByCode(String code);
}
