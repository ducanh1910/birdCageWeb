package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {
    private Long Id;
    private String Name;
    private boolean isActivated;
    private boolean isDeleted;
}
