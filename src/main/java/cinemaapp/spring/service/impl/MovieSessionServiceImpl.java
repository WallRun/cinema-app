package cinemaapp.spring.service.impl;

import cinemaapp.spring.dao.MovieSessionDao;
import cinemaapp.spring.model.MovieSession;
import cinemaapp.spring.service.MovieSessionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionDao movieSessionDao;

    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }

    @Override
    public MovieSession get(Long id) {
        return movieSessionDao.get(id).orElseThrow(
                () -> new RuntimeException("Session with id " + id + " not found"));
    }

    @Override
    public MovieSession update(MovieSession movieSession) {
        return movieSessionDao.update(movieSession);
    }

    @Override
    public void delete(Long id) {
        movieSessionDao.delete(id);
    }
}