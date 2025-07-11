package Pronotion.web_server.dto;

public class TeamDto {

    private Long id;
    private String name;

    public TeamDto() {
        // Default no-arg constructor for Jackson
    }

    public TeamDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TeamDto(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
