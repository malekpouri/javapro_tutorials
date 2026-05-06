package ir.javapro.entity;

import jakarta.persistence.*;

@Entity
@Table
public class WikimediaEntity {
    public WikimediaEntity() {
    }

    public WikimediaEntity(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String data;
}
