package web.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    private String nameRole;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.MERGE)
    private Set<User> user;

    public Role(String role) {
        this.nameRole = role;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return nameRole;
    }

    public void setRole(String role) {
        this.nameRole = role;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        return nameRole.equals(role.nameRole);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nameRole.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.nameRole;
    }
}
