package org.egovframe.cloud.boardservice.api.board;

import lombok.RequiredArgsConstructor;
import org.egovframe.cloud.common.dto.RequestDto;
import org.egovframe.cloud.boardservice.api.board.dto.BoardListResponseDto;
import org.egovframe.cloud.boardservice.api.board.dto.BoardResponseDto;
import org.egovframe.cloud.boardservice.api.board.dto.BoardSaveRequestDto;
import org.egovframe.cloud.boardservice.api.board.dto.BoardUpdateRequestDto;
import org.egovframe.cloud.boardservice.api.board.dto.LanguageResponseDto;
import org.egovframe.cloud.boardservice.service.board.BoardService;
import org.egovframe.cloud.boardservice.service.board.LanguageService;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * org.egovframe.cloud.boardservice.api.board.BoardApiController
 * <p>
 * 게시판 Rest API 컨트롤러 클래스
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
@RequiredArgsConstructor
@RestController
public class LanguageApiController {

    /**
     * 게시판 서비스
     */
    private final LanguageService languageService;

    private final Environment env;

    /**
     * language Table 단건 조회
     *
     * @param languegeNo \
     * @return LanguageResponseDto 응답 DTO
     */
    @GetMapping("/api/v1/languages/{languegeNo}")
    public LanguageResponseDto findById(@PathVariable Integer languegeNo) {
        return languageService.findById(languegeNo);
    }

    /**
     * language 등록
     *
     * @param LanguageResponseDto 등록 요청 DTO
     * @return LanguageResponseDto 상세 응답 DTO
     */
    @PostMapping("/api/v1/languages")
    @ResponseStatus(HttpStatus.CREATED)
    public LanguageResponseDto save(@RequestBody @Valid LanguageResponseDto requestDto) {
        return languageService.save(requestDto);
    }

    /**
     * language 수정
     *
     * @param languegeNo    게시판 번호
     * @param LanguageResponseDto 게시판 수정 요청 DTO
     * @return LanguageResponseDto 게시판 상세 응답 DTO
     */
    @PutMapping("/api/v1/languages/{languageNo}")
    public LanguageResponseDto update(@PathVariable Integer languageNo, @RequestBody @Valid LanguageResponseDto requestDto) {
        return languageService.update(languageNo, requestDto);
    }

    /**
     * language 삭제
     *
     * @param languageNo 
     */
    @DeleteMapping("/api/v1/languages/{languageNo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer languageNo) {
    	languageService.delete(languageNo);
    }

}
