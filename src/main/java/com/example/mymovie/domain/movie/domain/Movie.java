package com.example.mymovie.domain.movie.domain;

import com.example.mymovie.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "movie")
@SQLDelete(sql = "UPDATE  movie set deleted_at = current_timestamp WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
public class Movie extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieGenre genre;

    @Column(name = "open_date", nullable = false)
    private LocalDate openDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "on_screen", nullable = false)
    private boolean onScreen;


    public Movie(String title, MovieGenre genre, LocalDate openDate, LocalDate endDate, boolean onScreen) {
        this.title = title;
        this.genre = genre;
        this.openDate = openDate;
        this.endDate = endDate;
        this.onScreen = onScreen;
    }

    public void update(String title, MovieGenre genre, LocalDate openDate, LocalDate endDate) {
        this.title = title;
        this.genre = genre;
        this.openDate = openDate;
        this.endDate = endDate;
        this.onScreen = LocalDate.now().isAfter(openDate) && LocalDate.now().isBefore(endDate);

        // 유효성 검사 추가
        validate();
    }



    private void validate() {
        if (openDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Open date must be before end date.");
        }

    }




}
