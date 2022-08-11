package com.moon.shop.service;

import com.moon.shop.domain.QnaResponse;
import com.moon.shop.domain.member.Member;
import com.moon.shop.repository.QnaRepository;
import com.moon.shop.domain.qna.Qna;
import com.moon.shop.repository.QnaResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class QnaService {

    @Autowired
    private QnaRepository qnaRepository;

    @Autowired
    private QnaResponseRepository qnaResponseRepository;

    @Transactional
    public void saveQna(Qna qna, Member member){ //문의글 저장
        qna.setCount(0);
        qna.setMember(member);
        System.out.println(qna + "---> service");
        qnaRepository.save(qna);
    }

    @Transactional(readOnly = true) //문의글 전체 조회
    public List<Qna> qnaList(){
        return qnaRepository.findAll();
    }

    @Transactional(readOnly = true) //문의글 상세 조회
    public Qna qnaDetail(int id){
        return qnaRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("해당 게시글을 찾을 수 없습니다.");
                });
    }

    @Transactional
    public void deleteById(int id){ //문의글 삭제
        qnaRepository.deleteById(id);
    }

    @Transactional
    public void updateQna(int id, Qna requestQna){ //문의글 수정
        Qna qna = qnaRepository.findById(id) //영속화
                .orElseThrow(()->{
                    return new IllegalArgumentException("해당 게시글을 찾을 수 없습니다.");
                });
        qna.setQnaTitle(requestQna.getQnaTitle());
        qna.setQnaContents(requestQna.getQnaContents());
    }

    @Transactional
    public void saveResponse(Member member, int qnaId, QnaResponse requestResponse){ //문의글 답변 저장

        Qna qna = qnaRepository.findById(qnaId) .orElseThrow(()->{
            return new IllegalArgumentException("해당 게시글을 찾을 수 없습니다.");
        });
        requestResponse.setMember(member);
        requestResponse.setQna(qna);
        qnaResponseRepository.save(requestResponse);
    }


}
