package skyflight.domain;

import java.util.Objects;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "lauch")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Launch {

	private @Id @GeneratedValue Long id;
	@Column() private String provider;

	@Column() 
	@ManyToOne
	private Article article;

	Launch() {}

	Launch(String provider) {
		this.provider = provider;
	}

	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getArticle() {
		return this.article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Launch))
			return false;
		Launch launch = (Launch) o;
		return Objects.equals(this.id, launch.id) && Objects.equals(this.provider, launch.provider);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.provider);
	}

	@Override
	public String toString() {
		return "Launch{" + "id=" + this.id + ", provider='" + this.provider '\'' + '}';
	}
}
