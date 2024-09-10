package com.ssg.web2.todo.dao;

import com.ssg.web2.todo.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

    public MemberVO getWithPassword(String mid, String mpw) throws Exception {

        String sql = "select mid, mpw, mname from tbl_member where mid = ? and mpw = ?";

        MemberVO member = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, mid);
        pstmt.setString(2, mpw);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();

        member = MemberVO.builder()
                .mid(rs.getString(1)).mpw(rs.getString(2)).mname(rs.getString(3)).build();

        return  member;


    }
}
