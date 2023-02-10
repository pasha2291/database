package by.a1qa.models.db;

import lombok.Data;

import java.util.Objects;

@Data
public class AuthorTable extends BaseDataBaseModel {
    private String name;
    private String login;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthorTable authorTable = (AuthorTable) o;
        return Objects.equals(getName(), authorTable.getName())
                && Objects.equals(getLogin(), authorTable.getLogin())
                && Objects.equals(getEmail(), authorTable.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLogin(), getEmail());
    }
}
