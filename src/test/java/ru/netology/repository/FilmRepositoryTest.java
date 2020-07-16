package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {
    FilmRepository repository = new FilmRepository();
    Film film1 = new Film(1, "Breaking Bad", "Crime drama", "https://www.imdb.com/title/tt0903747/", 2020, "USA");
    Film film2 = new Film(2, "Untouchable", "Comedy Drama", "https://www.imdb.com/title/tt0903750/", 2011, "France");
    Film film3 = new Film(3, "The Godfather", "Crime drama", "https://www.imdb.com/title/tt0903756/", 1972, "USA");
    Film film4 = new Film(4, " The Lord of the Rings", "Crime drama", "https://www.imdb.com/title/tt0903757/", 2003, "USA");

    @Test
    void shouldSave() {
        Film[] expected = new Film[]{film1};
        repository.save(film1);

        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldReturn() {
        Film[] expected = new Film[]{film1, film2, film3, film4};
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);

        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldReturnEmptyArray() {
        assertArrayEquals(new Film[0], repository.findAll());
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Film[] expected = new Film[0];
        Film[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Film expected = new Film(4, " The Lord of the Rings", "Crime drama", "https://www.imdb.com/title/tt0903757/", 2003, "USA");
        Film actual = repository.findById(4);

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {

        repository.removeById(3);
        Film [] expected = new Film [] {film1,film2, film3, film4};
        Film [] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}
