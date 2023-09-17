package org.egovframe.cloud.boardservice.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer>, LanguageRepositoryCustom {

}
