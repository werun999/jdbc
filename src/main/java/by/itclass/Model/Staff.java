package by.itclass.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class Staff {
    private String name;
    private int age;
    private String department;
}
