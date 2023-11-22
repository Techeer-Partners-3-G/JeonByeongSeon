package com.example.mymovie.domain.movie.dto.request;


import com.example.mymovie.domain.movie.domain.Movie;
import com.example.mymovie.domain.movie.domain.MovieGenre;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Schema(description = "영화 정보 업데이트 요청")
public class UpdateMoiveRequest {

    @Schema(description = "영화 제목", required = true, example = "영화 제목을 입력하세요")
    private String title;

    @Schema(description = "영화 장르", required = true, example = "장르를 선택하세요")
    private MovieGenre genre;

    @Schema(description = "영화 개봉 날짜", required = true, example = "yyyy-MM-dd")
    private LocalDate openDate;

    @Schema(description = "영화 종료 날짜", required = true, example = "yyyy-MM-dd")
    private LocalDate endDate;

//    public UpdateMoiveRequest() {
//    }


}
