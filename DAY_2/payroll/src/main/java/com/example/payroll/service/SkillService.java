package com.example.payroll.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payroll.model.Department;
import com.example.payroll.model.Skill;
import com.example.payroll.repository.SkillRepository;

@Service
public class SkillService {
	@Autowired
	SkillRepository skill;

	
	@Transactional
	public Skill get(int id) {

	//LOGGER.info("Start");

	return skill.findById(id).get();
}
	@Transactional
    public void save(Skill sk) {

	//LOGGER.info("Start");

	skill.save(sk);



	
}
	
}
