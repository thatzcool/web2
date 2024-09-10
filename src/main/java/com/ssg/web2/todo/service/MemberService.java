package com.ssg.web2.todo.service;


import com.ssg.web2.todo.dao.MemberDAO;
import com.ssg.web2.todo.domain.MemberVO;
import com.ssg.web2.todo.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {

       INSTANCE;

       private MemberDAO dao;
       private ModelMapper modelMapper;

       MemberService() {

           dao = new MemberDAO();
           modelMapper = new ModelMapper();
       }

       //MemberService는  여러 곳에서 동일한 객체로 사용할 수 있도록 enum으로 하나의 객체만을 구성하고 MemberDAO를 이용하도록 구조화함

       public MemberDTO login(String mid, String mpw) throws  Exception {

           MemberVO vo = dao.getWithPassword(mid,mpw);
           MemberDTO dto = modelMapper.map(vo,MemberDTO.class);

           return dto;
       }


}
