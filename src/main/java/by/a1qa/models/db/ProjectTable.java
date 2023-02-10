package by.a1qa.models.db;

import lombok.Data;

import java.util.Objects;

@Data
public class ProjectTable extends BaseDataBaseModel {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectTable projectTable = (ProjectTable) o;
        return Objects.equals(getName(), projectTable.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName());
    }
}
