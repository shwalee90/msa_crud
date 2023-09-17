package org.egovframe.cloud.boardservice.service.board;

import lombok.RequiredArgsConstructor;
import org.egovframe.cloud.boardservice.api.board.dto.BoardListResponseDto;
import org.egovframe.cloud.boardservice.api.board.dto.BoardResponseDto;
import org.egovframe.cloud.boardservice.api.board.dto.BoardSaveRequestDto;
import org.egovframe.cloud.boardservice.api.board.dto.BoardUpdateRequestDto;
import org.egovframe.cloud.boardservice.api.board.dto.LanguageResponseDto;
import org.egovframe.cloud.boardservice.domain.board.Board;
import org.egovframe.cloud.boardservice.domain.board.BoardRepository;
import org.egovframe.cloud.boardservice.domain.board.Language;
import org.egovframe.cloud.boardservice.domain.board.LanguageRepository;
import org.egovframe.cloud.common.dto.RequestDto;
import org.egovframe.cloud.common.exception.EntityNotFoundException;
import org.egovframe.cloud.common.service.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.validation.Valid;

/**
 * org.egovframe.cloud.boardservice.service.board.BoardService
 * <p>
 * 게시판 서비스 클래스
 *
 * @author 표준프레임워크센터 jooho
 * @version 1.0
 * @since 2021/07/26
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2021/07/26    jooho       최초 생성
 * </pre>
 */
@Transactional
@RequiredArgsConstructor
@Service
public class LanguageService extends AbstractService {

      private final LanguageRepository languageRepository;

    /**
     * 게시판 단건 조회
     *
     * @param language_id lanugage 번호
     * @return LanguageResponseDto 응답 DTO
     */
    public LanguageResponseDto findById(Integer language_id) {
    	Language entity = findLanguage(language_id);
        
        
        
        return new LanguageResponseDto(entity);
    }


    /**
     * language번호로 엔티티 조회
     *
     * @param language 번호
     * @return language 엔티티
     */

	  private Language findLanguage(Integer language_id) throws EntityNotFoundException {
	  return languageRepository.findById(language_id)
	          .orElseThrow(() -> new EntityNotFoundException(getMessage("valid.notexists.format", new Object[]{getMessage("language")})));
	}
	  
    /**
     * 게시판 등록
     *
     * @param requestDto 등록 요청 DTO
     * @return LanguageResponseDto 응답 DTO
     */
	  
    @Transactional
	public LanguageResponseDto save(@Valid LanguageResponseDto requestDto) {
		Language entity = languageRepository.save(requestDto.toEntity());
		
        return new LanguageResponseDto(entity);
	}
	
	
    /**
    * 게시판 수정
    *
    * @param language 번호
    * @param requestDto 등록 요청 DTO
    * @return LanguageResponseDto 응답 DTO
    */
	@Transactional
	public LanguageResponseDto update(Integer languageNo, @Valid LanguageResponseDto requestDto) {
      Language entity = findLanguage(languageNo);

      // 수정
      entity.update(requestDto.getName());

      return new LanguageResponseDto(entity);
	}



	 @Transactional
	 public void delete(Integer boardNo) {
		 Language entity = findLanguage(boardNo);
	
	     // 삭제
		 languageRepository.delete(entity);
	 }


    
}
