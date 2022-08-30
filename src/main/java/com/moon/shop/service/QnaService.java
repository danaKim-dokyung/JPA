package com.moon.shop.service;

import com.moon.shop.domain.QnaResponse;
import com.moon.shop.domain.Member;
import com.moon.shop.repository.MemberRepository;
import com.moon.shop.repository.QnaRepository;
import com.moon.shop.domain.Qna;
import com.moon.shop.repository.QnaResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QnaService {

    private final QnaRepository qnaRepository;

    private final QnaResponseRepository qnaResponseRepository;

    private final MemberRepository memberRepository;

    @Transactional
    public void saveQna(Qna qna, Member member){ //문의글 저장
        qna.setCount(0);
        qna.setMember(member);
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
    public void saveResponse(Member member, int qnaId, QnaResponse requestQnaResponse){ //문의글 답변 저장

        Qna qna = qnaRepository.findById(qnaId) .orElseThrow(()->{
            return new IllegalArgumentException("해당 게시글을 찾을 수 없습니다.");
        });
        requestQnaResponse.setMember(member);
        requestQnaResponse.setQna(qna);
        qnaResponseRepository.save(requestQnaResponse);
    }

    @Transactional
    public void deleteResponse(int qnaResponseId){ //문의글 답변 삭제
        qnaRepository.deleteById(qnaResponseId);
    }


}
