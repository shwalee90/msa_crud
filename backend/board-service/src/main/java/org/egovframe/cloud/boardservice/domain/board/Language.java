package org.egovframe.cloud.boardservice.domain.board;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.egovframe.cloud.boardservice.domain.posts.Posts;
import org.egovframe.cloud.servlet.domain.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.joda.time.DateTime;

/**
 * org.egovframe.cloud.boardservice.domain.board.Board
 * <p>
 * 게시판 엔티티 클래스
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
@Entity
@Table(name = "language", catalog = "sakila")
public class Language {

    /**
     * language 번호
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(9)")
    private Integer languageId;

    /**
     * language 제목
     */
    @Column(nullable = false, length = 100)
    private String name;
    
    /**
     *  최근 수정시간
     */
    @Column(nullable = false, length = 100)
    private LocalDateTime lastUpdate;

 
    /**
     * 빌더 패턴 클래스 생성자
     *
     * @param languageId       language 번호
     * @param name       	   language 제목
     * @param lastUpdate       마지막 업데이트 시간
     */

    @Builder
    public Language(Integer languageId, String name, LocalDateTime lastUpdate) {
        this.languageId = languageId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    /**
     * 게시판 속성 값 수정
     *
     * @param boardName         language 명
     * @param lastUpdate        마지막 업데이트 시간

     * @return Language 엔티티
     */
    public Language update(String name) {
        this.name = name;
        this.lastUpdate = LocalDateTime.now();
        return this;
    }

}
