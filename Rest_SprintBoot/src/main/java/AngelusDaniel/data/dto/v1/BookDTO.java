package AngelusDaniel.data.dto.v1;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({ "id", "title", "author", "price", "launchDate"})
public class BookDTO extends RepresentationModel<BookDTO> implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String title;
  private String author;
  private Double price;
  private Date launchDate;


  public BookDTO() {
  }


  public static long getSerialversionuid() {
    return serialVersionUID;
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public String getAuthor() {
    return author;
  }


  public void setAuthor(String author) {
    this.author = author;
  }


  public Double getPrice() {
    return price;
  }


  public void setPrice(Double price) {
    this.price = price;
  }

  
  public Date getLaunchDate() {
    return launchDate;
  }


  public void setLaunchDate(Date launchDate) {
    this.launchDate = launchDate;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + ((author == null) ? 0 : author.hashCode());
    result = prime * result + ((price == null) ? 0 : price.hashCode());
    result = prime * result + ((launchDate == null) ? 0 : launchDate.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    BookDTO other = (BookDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (author == null) {
      if (other.author != null)
        return false;
    } else if (!author.equals(other.author))
      return false;
    if (price == null) {
      if (other.price != null)
        return false;
    } else if (!price.equals(other.price))
      return false;
    if (launchDate == null) {
      if (other.launchDate != null)
        return false;
    } else if (!launchDate.equals(other.launchDate))
      return false;
    return true;
  }


  
  
}
