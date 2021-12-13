package com.Admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Admin.Models.WashPacks;
import com.Admin.repository.WashPackRepository;

public class WashPackService {

	@Autowired
	WashPackRepository washPackRepository;

	public String savepack(WashPacks pack) {

		washPackRepository.save(pack);
		return " Pack saved successfully with id :" + pack.getId();
	}


	public List<WashPacks> getpack() {

		return washPackRepository.findAll();
	}

	
	public String deletepack(int id) {

		washPackRepository.deleteById(id);
		return "pack deleted with id " + id;
	}

}
