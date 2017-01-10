package cw.sas.model;

/**
 * Created by User on 1/10/2017.
 */
public enum Status {

    ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

    public String getType() {

        return type;
    }

    private String type;

    private Status(String type) {

        this.type = type;
    }

}
