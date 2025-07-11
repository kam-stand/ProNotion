package Pronotion.web_server.dto;

public class TeamDto {

    public String name;
    public Long id;

    public TeamDto() {

    }
    public TeamDto(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
