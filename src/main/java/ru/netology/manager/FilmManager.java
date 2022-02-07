package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Film;

@Data


public class FilmManager {
    private Film[] films = new Film[0];
    private int defaultFilmLength = 10;

    FilmManager() {
    }

    public FilmManager(int userLength) {
        if (userLength > 0) {
            defaultFilmLength = userLength;
        }

    }

    public void addFilm(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int Ind = tmp.length - 1;
        tmp[Ind] = film;
        films = tmp;
    }

    public Film[] getAddFilm() {
        int filmsLength = films.length;
        int localFilmLength = defaultFilmLength;
        if (films.length < localFilmLength) {
            localFilmLength = filmsLength;
        }
        Film[] result = new Film[localFilmLength];

        for (int i = 0; i < result.length; i++) {
            int ind = filmsLength - i - 1;
            result[i] = films[ind];
        }
        return result;
    }

}