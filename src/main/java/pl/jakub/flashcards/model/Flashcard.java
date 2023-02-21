package pl.jakub.flashcards.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flashcard {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Can not be empty.")
    private String front;

    @NotEmpty(message = "Can not be empty.")
    private String back;
}
