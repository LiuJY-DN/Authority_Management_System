package com.yu.ssm.dao;

import com.yu.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    @Select("select * from Member where id = #{id}")
    Member findById(String id) throws Exception;
}

