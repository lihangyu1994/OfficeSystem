package com.lhy.office.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhy.office.entity.Institution;
import com.lhy.office.mapper.InstitutionMapper;
import com.lhy.office.service.InstitutionService;

@Service
public class InstitutionServiceImpl implements InstitutionService {

	@Autowired
	private InstitutionMapper Institution;

	@Override
	public List<Institution> getInstitutions(Institution institution) {
		return Institution.getInstitutions(institution);
	}

}
