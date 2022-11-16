package com.sda.mihai.bookmanagement.model;


import javax.persistence.*;

@Entity
@Table(name = "book_review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "score")
    private Integer Score;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Review() {

    }

    public Review(Integer score, String comment) {
        Score = score;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "BookReview{" +
                "id=" + id +
                ", Score=" + Score +
                ", comment='" + comment + '\'' +
                '}';
    }
}
