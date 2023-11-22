package com.example.mymovie.domain.movie.dto.request;


import com.example.mymovie.domain.movie.domain.MovieGenre;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Schema(description = "전체 영화 조회를 위한 요청 객체")
public class FindAllMoviesRequest {

    @Schema(description = "조회할 영화의 장르를 지정")
    private MovieGenre genre;

    @Schema(description = "현재 상영 중인 영화만 조회할 지 여부를 지정")
    private Boolean onScreen;

//    public FindAllMoviesRequest() {
//    }

}
