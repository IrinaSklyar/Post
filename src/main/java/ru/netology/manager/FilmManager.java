package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@NoArgsConstructor

public class FilmManager {
    private Film[] films = new Film[0];
    private int filmsToReturn = 4;

    public FilmManager(int filmsToReturn) {
        this.filmsToReturn = filmsToReturn;
    }

    public void add(Film film) {
        Film[] tmp = new Film[films.length + 1];

        System.arraycopy(films, 0, tmp, 0, films.length);

        tmp[tmp.length - 1] = film;

        films = tmp;
    }

    public Film[] getFilm() {
        int arrayLength = filmsToReturn;
        if (films.length <= arrayLength) {
            arrayLength = films.length;
        }
        Film[] result = new Film[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}

