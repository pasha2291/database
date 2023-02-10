package by.a1qa.models.db;

import lombok.Data;

@Data
public class SessionTable extends BaseDataBaseModel {
    private String sessionKey;
    private String createdTime;
    private int buildNumber;
}
