package com.dhartford.mts.service.interf;

import com.dhartford.mts.entity.interf.Genre;

public interface GenreService {
	
	Genre addGenre(Genre genre);
	
	Genre getGenre(long id);

}
