package com.example.zingmp3.service.genre;

import com.example.zingmp3.model.Artist;
import com.example.zingmp3.model.Genre;
import com.example.zingmp3.repository.IArtistRepository;
import com.example.zingmp3.service.artist.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements IGenreService {

    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Genre save(Genre genre) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
