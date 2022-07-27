package skyflight.domain;

import java.util.Objects;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "article")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Article {

	private @Id @GeneratedValue Long id;
	@Column() private String title;
	@Column() private boolean featured;
	@Column() private String url;
	@Column() private String imageUrl;
	@Column() private String newsSite;
	@Column() private String summary;
	@Column() private String publishedAt;

	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private List<Launch> launches;

	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private List<Event> events;

	Article() {}

	Article(String title, boolean featured, String url, String imageUrl, String newsSite, String summary, String publishedAt) {

		this.title = title;
		this.featured = featured;
		this.url = url;
		this.imageUrl = imageUrl;
		this.newsSite = newsSite;
		this.summary = summary;
		this.publishedAt = publishedAt;
	}

	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean getFeatured() {
		return this.featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getNewsSite() {
		return this.newsSite;
	}

	public void setNewsSite(String newsSite) {
		this.newsSite = newsSite;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPublishedAt() {
		return this.publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getLaunches() {
		if(this.launches == null){
			this.launches = new ArrayList<>();
		}
		return this.launches;
	}

	public void setLaunches(String launches) {
		this.launches = launches;
	}

	public String getEvents() {
		if(this.events == null){
			this.events = new ArrayList<>();
		}
		return this.events;
	}

	public void setEvents(String events) {
		this.publishedAt = events;
	}

	@Override
	public String toString() {
		return "Article{" + "id=" + this.id + ", title='" + this.title + '\'' + ", url='" + this.url + '\'' + '}';
	}
}
