package dan.med.eboutique.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private Long idRole;
	@Column(name="name_role")
	private String roleName;
	
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	//Contructeur sans parametre
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Contructeur avec parametre
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
}
