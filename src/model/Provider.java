package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the provider database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Provider.findAll", query="SELECT p FROM Provider p"),
@NamedQuery(name="Provider.findId", query="SELECT p FROM Provider p WHERE p.idProvider= :id")
}) 
public class Provider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProvider;

	private String name;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="provider")
	private List<Product> products;

	public Provider() {
	}

	public int getIdProvider() {
		return this.idProvider;
	}

	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProvider(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProvider(null);

		return product;
	}

}