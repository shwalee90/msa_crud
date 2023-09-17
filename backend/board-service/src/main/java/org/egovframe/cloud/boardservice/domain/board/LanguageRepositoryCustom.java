package org.egovframe.cloud.boardservice.domain.board;

import org.egovframe.cloud.boardservice.api.board.dto.BoardResponseDto;
import org.egovframe.cloud.boardservice.api.board.dto.LanguageResponseDto;
import org.egovframe.cloud.common.dto.RequestDto;
import org.egovframe.cloud.boardservice.api.board.dto.BoardListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LanguageRepositoryCustom {

    List<LanguageResponseDto> findAllByLanguageIdIn(List<Integer> languageNos);

}
