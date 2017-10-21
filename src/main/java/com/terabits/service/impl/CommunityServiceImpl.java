package com.terabits.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terabits.dao.CommunityDao;
import com.terabits.service.CommunityService;
@Service("communityService")
public class CommunityServiceImpl implements CommunityService{
	
	@Autowired
	private CommunityDao communityDao;
	public List<String> getAllCommunity() {
		return communityDao.selectAllCommunity();
	}

}
