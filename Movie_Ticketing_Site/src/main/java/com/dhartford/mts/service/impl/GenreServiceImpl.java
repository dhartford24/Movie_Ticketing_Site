package com.dhartford.mts.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhartford.mts.entity.interf.Genre;
import com.dhartford.mts.repository.GenreRepository;
import com.dhartford.mts.service.interf.GenreService;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public Genre addGenre(Genre genre) {
		long newId = genreRepository.addGenre(genre);
		return genreRepository.getGenre(newId);
	}
	
	@Override
	public Genre getGenre(long id) {
		return genreRepository.getGenre(id);
	}
	
}
