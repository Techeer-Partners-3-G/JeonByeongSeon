package com.example.mymovie.domain.movie.api;

import com.example.mymovie.domain.movie.application.MovieService;
import com.example.mymovie.domain.movie.dto.request.CreateMovieRequest;
import com.example.mymovie.domain.movie.dto.request.FindAllMoviesRequest;
import com.example.mymovie.domain.movie.dto.request.UpdateMoiveRequest;
import com.example.mymovie.domain.movie.dto.response.MovieResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "영화 관리", description = "영화 관리 API")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(summary = "새 영화 생성", description = "시스템에 새 영화를 추가합니다.")
    @PostMapping
    public void saveMovie(@RequestBody CreateMovieRequest request) {
        movieService.saveMovie(request);
    }

    @Operation(summary = "영화 정보 업데이트", description = "지정된 영화의 상세 정보를 업데이트합니다.")
    @PatchMapping
    public void updateMovie(@PathVariable Long id, @RequestBody UpdateMoiveRequest request) {
        movieService.updateMovie(id, request);
    }

    @Operation(summary = "영화 삭제", description = "지정된 ID의 영화를 삭제합니다.")
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @Operation(summary = "ID로 영화 조회", description = "주어진 ID로 단일 영화의 상세 정보를 검색합니다.")
    @GetMapping("/{id}")
    public MovieResponse findOneMovie(@PathVariable Long id) {
        return movieService.findOneMovie(id);
    }



    @Operation(summary = "모든 영화 조회", description = "요청 파라미터에 기반하여 모든 영화를 검색합니다.")
    @GetMapping
    public List<MovieResponse> findAllMovies(FindAllMoviesRequest request) {
        return movieService.findAllMovies(request);
    }
}
