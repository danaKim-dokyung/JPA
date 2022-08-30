package com.moon.shop.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class QnaResponse {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="qna_response_id")
    private int id;

    @Column(nullable = false, length = 200, name = "qna_response_content")
    private String qnaResponseContent;

    @ManyToOne
    @JoinColumn(name="qna_id")
    private Qna qna;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @CreationTimestamp
    @Column(name="create_date")
    private Timestamp createDate;


}
