package restapi.cassandra.model;

import java.io.Serializable;

public class StringResult implements Serializable {

    private static final long serialVersionUID = 1L;
    private String result;

    public StringResult(
        String result) {
        super();
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}