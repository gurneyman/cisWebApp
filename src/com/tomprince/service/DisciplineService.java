package com.tomprince.service;

import java.util.List;

import com.tomprince.domain.Discipline;

public interface DisciplineService {
	public Discipline getByAbbreviation(String abbreviation);
	public List<Discipline> getAll();
}
