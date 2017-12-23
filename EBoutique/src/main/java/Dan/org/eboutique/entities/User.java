package Dan.org.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id") //Si nous voulons sp�cifier les noms de la colonne nous utilisons cette annotation
	private Long idUser;
	@Column(name="user_name")
	private String userName;
	@Column(name="user_password")
	private String password;
	private boolean actived; //Est ce que l'utilisateur est activ� ou pas
	@OneToMany
	@JoinColumn(name ="user_id")//l'association n'etant pas bidirectionnelle nous sp�cifions la cl� �trang�re ici
	private Collection<Role> roles;
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	//Constructeur sans parametre
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Constructeur avec parametre
	public User(String userName, String password, boolean actived) {
		super();
		this.userName = userName;
		this.password = password;
		this.actived = actived;
	} 
	

}
