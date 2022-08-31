package com.moon.shop.service;

import com.moon.shop.config.auth.PrincipalDetail;
import com.moon.shop.domain.QnaResponse;
import com.moon.shop.domain.Member;

import com.moon.shop.repository.MemberRepository;
import com.moon.shop.repository.QnaRepository;
import com.moon.shop.domain.Qna;
import com.moon.shop.repository.QnaResponseRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QnaService {

    private final QnaRepository qnaRepository;
    private final QnaResponseRepository qnaResponseRepository;
    private final MemberRepository memberRepository;

    //문의글 저장
    @Transactional
    public void saveQna(Qna qna, Member member){
        qna.setCount(0);
        qna.setMember(member);
        qnaRepository.save(qna);
    }

    //문의글 전체 조회
    @Transactional(readOnly = true)
    public List<Qna> qnaList(){
        return qnaRepository.findAll();
    }

    //문의글 상세 조회
    @Transactional(readOnly = true)
    public Qna qnaDetail(int id){
        return qnaRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("해당 게시글을 찾을 수 없습니다.");
                });
    }

    //문의글 삭제
    @Transactional
    public void deleteById(int id){ //문의글 삭제
        qnaRepository.deleteById(id);
    }

    //문의글 수정
    @Transactional
    public void updateQna(int id, Qna requestQna){
        Qna qna = qnaRepository.findById(id) //영속화
                .orElseThrow(()->{
                    return new IllegalArgumentException("해당 게시글을 찾을 수 없습니다.");
                });
        qna.setQnaTitle(requestQna.getQnaTitle());
        qna.setQnaContents(requestQna.getQnaContents());
    }

    //문의글 답변 저장
    @Transactional
    public void saveResponse(Member member, int qnaId, QnaResponse requestQnaResponse){

        Qna qna = qnaRepository.findById(qnaId) .orElseThrow(()->{
            return new IllegalArgumentException("해당 게시글을 찾을 수 없습니다.");
        });
        requestQnaResponse.setMember(member);
        requestQnaResponse.setQna(qna);
        qnaResponseRepository.save(requestQnaResponse);
    }

    //문의글 답변 삭제
    @Transactional
    public void deleteResponse(int qnaResponseId){ //문의글 답변 삭제
        qnaRepository.deleteById(qnaResponseId);
    }


}
