package edu.miu.waa.project.backend.enumSet;

public enum RoleValue {
    OWNER("OWNER"), ADMIN("ADMIN"), CUSTOMER("CUSTOMER");

    public final String value;

    RoleValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
