package com.terabits.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.terabits.dao.mapper.CommunityMapper;
import com.terabits.utils.DBTools;

@Repository("communityDao")
public class CommunityDao {
	public List<String> selectAllCommunity() {
		SqlSession session = DBTools.getSession();
		CommunityMapper mapper = session.getMapper(CommunityMapper.class);
        List<String> nameS = new ArrayList<String>();
        try {
        	nameS = mapper.selectAllCommunity();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
        	session.close();
        }
        return nameS;
	}
}
