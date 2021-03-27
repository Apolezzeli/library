package ar.com.ada.second.library.model.entity;

import ar.com.ada.second.library.model.mapper.converter.YearAttributeConverter;
import lombok.*;

import javax.persistence.*;
import java.time.Year;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String editorial;

    @Column(nullable = false)
    private String editionPlace;

    @Convert(converter = YearAttributeConverter.class)
    @Column(nullable = false)
    private Year editionYear;

    @Column(nullable = false)
    private Integer libraryCopies;

    @Column(nullable = false)
    private String bookCondition;


}
