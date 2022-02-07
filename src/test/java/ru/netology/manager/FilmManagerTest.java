package ru.netology.manager;

import lombok.Data;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

@Data
class FilmManagerTest {
    private final Film first = new Film(1, "The Green Mile", "Drama");
    private final Film second = new Film(2, "The Shawshank Redemption", "Drama");
    private final Film third = new Film(3, "The Lord of the Rings: The Return of the King", "Fantasy");
    private final Film fourth = new Film(4, "Schindler's List", "Drama");
    private final Film fifth = new Film(5, "Forrest Gump", "Comedy");
    private final Film sixth = new Film(6, "Intouchables", "Comedy");
    private final Film seventh = new Film(7, "Pulp Fiction", "Criminal");
    private final Film eighth = new Film(8, "Inception", "Detective");
    private final Film ninth = new Film(9, "Matrix", "Adventure");
    private final Film tenth = new Film(10, "Klaus", "Family");

    Film[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

    @Test
    void shouldShowFilm() {
        FilmManager manager = new FilmManager(10);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        Film[] actual = manager.getAddFilm();
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldShowFilmOverMax() {
        FilmManager manager = new FilmManager(11);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        Film[] actual = manager.getAddFilm();
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldShowFiveFilmConversely() {
        FilmManager manager = new FilmManager(5);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        Film[] expected = {fifth, fourth, third, second, first};
        Film[] actual = manager.getAddFilm();
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldShowFilmCorrect() {
        FilmManager manager = new FilmManager(5);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        Film filmAdd = new Film(11, "Fight Club", "Criminal");
        manager.addFilm(filmAdd);
        Film[] actual = manager.getAddFilm();
        Film[] expected = {new Film(11, "Fight Club", "Criminal"), tenth, ninth, eighth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNothing() {
        FilmManager manager = new FilmManager();
        Film[] actual = manager.getAddFilm();
        Film[] expected = {};
        assertArrayEquals(expected, actual);
    }
}
