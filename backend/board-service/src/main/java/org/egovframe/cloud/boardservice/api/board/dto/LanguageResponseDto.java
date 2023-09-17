package org.egovframe.cloud.boardservice.api.board.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.egovframe.cloud.boardservice.api.posts.dto.PostsSimpleResponseDto;
import org.egovframe.cloud.boardservice.domain.board.Board;
import org.egovframe.cloud.boardservice.domain.board.Language;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

/**
 * org.egovframe.cloud.boardservice.api.board.dto.BoardResponseDto
 * <p>
 * 게시판 상세 응답 DTO 클래스
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
@Getter
@NoArgsConstructor
public class LanguageResponseDto implements Serializable {

    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = -7139346671431363426L;

    /**
     * language 번호
     */
    private Integer languageId;

    /**
     * language 제목
     */
    private String name;

    /**
     * 마지막 업데이트 시간
     */
    private java.time.LocalDateTime lastUpdate;

    /**
     * 게시판 상세 응답 DTO 생성자
     *
     * @param languageId       language 번호
     * @param name       	   language 제목
     * @param lastUpdate       마지막 업데이트 시간
     */
    public LanguageResponseDto(Integer languageId, String name, java.time.LocalDateTime lastUpdate) {
        this.languageId = languageId;
        this.name = name;
        this.lastUpdate = lastUpdate;
        
    }

    /**
     *
     * @param entity language 엔티티
     */
    public LanguageResponseDto(Language entity) {
    	this.languageId = entity.getLanguageId();
        this.name = entity.getName();
        this.lastUpdate = entity.getLastUpdate();
        
    }

    /**
     *
     * @return language 엔티티
     */
    public Language toEntity() {
        return Language.builder()
                .languageId(languageId)
        		.name(name)
                .lastUpdate(lastUpdate)
                .build();
    }


}
