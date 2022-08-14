package com.moon.shop.domain.qna;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.moon.shop.domain.QnaResponse;
import com.moon.shop.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Qna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="qna_id")
    private int id;

    @Column(nullable = false, length = 100, name = "qna_title")
    private String qnaTitle;

    @Lob
    @Column(name="qna_contents")
    private String qnaContents;

    //enum
    //private String  qna_status;

    private int count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy = "qna", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"qna"})
    private List<QnaResponse> responseList;

    @CreationTimestamp
    private Timestamp qnaDateCreated;

}
