package com.lhy.office.mapper;

import java.util.List;

import com.lhy.office.entity.Institution;

public interface InstitutionMapper {
	/**
	 * 查询结构列表
	 * @param institution
	 * @return
	 */
	public List<Institution> getInstitutions(Institution institution);

}
