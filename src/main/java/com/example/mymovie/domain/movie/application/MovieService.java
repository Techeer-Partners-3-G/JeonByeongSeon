package com.example.mymovie.domain.movie.application;

import com.example.mymovie.domain.movie.domain.Movie;
import com.example.mymovie.domain.movie.domain.MovieRepository;
import com.example.mymovie.domain.movie.dto.request.CreateMovieRequest;
import com.example.mymovie.domain.movie.dto.request.FindAllMoviesRequest;
import com.example.mymovie.domain.movie.dto.request.UpdateMoiveRequest;
import com.example.mymovie.domain.movie.dto.response.MovieResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired // 생성자 주입을 통해 MovieRepository 의존성 주입
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional // 트랜잭션 관리를 위한 어노테이션
    public void saveMovie(CreateMovieRequest request) {
        // 요청 데이터를 엔티티로 변환하고 저장
        Movie movie = request.toEntity();
        movieRepository.save(movie);
    }

    @Transactional
    public void deleteMovie(Long id) {
        // 주어진 ID로 영화를 삭제
        movieRepository.deleteById(id);
    }

    @Transactional
    public void updateMovie(Long id, UpdateMoiveRequest request) {
        // 주어진 ID로 영화를 찾고, 요청 데이터로 업데이트
        Movie movie = findByIdOrThrow(id);
        movie.update(request.getTitle(), request.getGenre(), request.getOpenDate(), request.getEndDate());
    }

    public MovieResponse findOneMovie(Long id) {
        // 주어진 ID로 영화를 찾아서 응답 객체로 변환
        Movie movie = getOneMovie(id);
        return MovieResponse.of(movie);
    }


    // 여기는 다시 해보기
    public List<MovieResponse> findAllMovies(FindAllMoviesRequest request) {
            List<Movie> movieList;
        if (request.getOnScreen() == null && request.getGenre() == null) {
            return movieRepository.findAll().stream().map(MovieResponse::of).collect(Collectors.toList());
        } else if (request.getOnScreen() == null) {
            movieList = movieRepository.findAllByGenreOrderByOpenDate(request.getGenre());
        } else if (request.getGenre() == null) {
            movieList = movieRepository.findAllByOnScreenOrderByOpenDate(request.getOnScreen());
        } else {
            movieList = movieRepository.findAllByGenreAndOnScreenOrderByOpenDate(request.getGenre(), request.getOnScreen());
        }
        return movieList.stream().map(MovieResponse::of).collect(Collectors.toList());
    }


    private Movie findByIdOrThrow(Long id) {
        // 주어진 ID로 영화를 찾고, 없으면 예외 발생
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
    }

    public Movie getOneMovie(Long id) {
        // 주어진 ID로 영화를 찾는 메서드, 없으면 예외 발생
        return findByIdOrThrow(id);
    }
}
