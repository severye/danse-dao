package danse.metier;

import java.util.List;

import danse.entities.Box;
import danse.entities.Category;
import danse.entities.Colour;
import danse.entities.Kind;
import danse.entities.Product;
import danse.entities.Size;
import danse.entities.SizeQuantity;
import danse.entities.Type;

public interface IMetier {

	public List<Type> getAllTypes();
	public List<Colour> getAllColours();
	public List<Kind> getAllKinds();
	public List<Product> getAllProducts();
	public List<Box> getAllBoxes();
	public List<Size> getAllSizes();
	public List<SizeQuantity> getAllSizeQuantities();
	public List<Category> getAllCategories();
	
	public Product addProduct(String name, String comment, String picture, Integer totalQuantity, Colour colour, Kind kind, Category category,Box box,Type type,List<SizeQuantity> sizeQuantities);
	
	public Product getProduct(long idProduct);
	public Size getSize(Long idSize);
	public Type getType(Long idType);
	public Kind getKind(Long idKind);
	public Colour getColour(Long idColour);
	public Category getCategory(Long idCategory);
	public Box getBox(Long idBox);
	public SizeQuantity getSizeQuanity(Long idProduct, Long idSize);
	
	public void deleteType(Long id);
	public void deleteKind(Long id);
	public void deleteColour(Long id);
	public void deleteProduct(Long id);
	public void deleteBox(Long id);
	public void deleteSize(Long id);
	public void deleteSizeQuantity(Long idProduct, Long idSize);
	public void deleteCategory(Long id);
	
	public Type addOrUpdateType(Type type);
	public Kind addOrUpdateKind(Kind kind);
	public Colour addOrUpdateColour(Colour colour);
	public Product addOrUpdateProduct(Product product);
	public Box addOrUpdateBox(Box box);
	public Size addOrUpdateSize(Size size);
	public SizeQuantity addOrUpdateSizeQuantity(SizeQuantity sizeQuantity);
	public Category addOrUpdateCategory(Category category);
}
