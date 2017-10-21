package com.terabits.dao.mapper;

import java.util.List;

public interface CommunityMapper {
	/**
	 * 获取所有社区
	 * @return
	 */
	public List<String> selectAllCommunity();
}
