package utility;

/**
 * 作者：饮木
 */
public class FormInformation {
    private String name;
    private String role;
    private String id;

    public String getName() {
        return name;
    }

    public FormInformation(String name, String role, String id) {
        this.name = name;
        this.role = role;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
