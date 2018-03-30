package danse.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="size_quantity")
public class SizeQuantity{
	@EmbeddedId
	private SizeQuantityPk sizeQuantityPk = new SizeQuantityPk();
	
	private Integer quantity;
	
	public SizeQuantity() {
		
	}	

	public SizeQuantity(SizeQuantityPk sizeQuantityPk, Integer quantity) {
		this.sizeQuantityPk = sizeQuantityPk;
		this.quantity=quantity;
	}

	

	public SizeQuantityPk getSizeQuantityPk() {
		return sizeQuantityPk;
	}

	public void setSizeQuantityPk(SizeQuantityPk sizeQuantityPk) {
		this.sizeQuantityPk = sizeQuantityPk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
	    return String.format("SizeQuantity[idProduct='%s', idSize='%s', quantity='%s']",sizeQuantityPk.getProduct(), sizeQuantityPk.getSize(),quantity);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((sizeQuantityPk == null) ? 0 : sizeQuantityPk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SizeQuantity other = (SizeQuantity) obj;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (sizeQuantityPk == null) {
			if (other.sizeQuantityPk != null)
				return false;
		} else if (!sizeQuantityPk.equals(other.sizeQuantityPk))
			return false;
		return true;
	}

	
	
	
}
