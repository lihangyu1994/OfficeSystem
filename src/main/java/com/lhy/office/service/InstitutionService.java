package com.lhy.office.service;

import java.util.List;

import com.lhy.office.entity.Institution;

public interface InstitutionService {
	/**
	 * 查询结构列表
	 * @param institution
	 * @return
	 */
	public List<Institution> getInstitutions(Institution institution);
}
