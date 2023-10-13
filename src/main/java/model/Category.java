package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @Column(name = "category_id", nullable = false)
    private Long id;

    @Size(max = 750)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_activated")
    private boolean isActivated;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Category(String name) {
        this.name = name;
        this.isActivated = true;
        this.isDeleted = false;
    }
}