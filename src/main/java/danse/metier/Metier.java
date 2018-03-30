package danse.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import danse.entities.Box;
import danse.entities.Category;
import danse.entities.Colour;
import danse.entities.Kind;
import danse.entities.Product;
import danse.entities.Size;
import danse.entities.SizeQuantity;
import danse.entities.Type;
import danse.repositories.BoxRepository;
import danse.repositories.CategoryRepository;
import danse.repositories.ColourRepository;
import danse.repositories.KindRepository;
import danse.repositories.ProductRepository;
import danse.repositories.SizeQuantityRepository;
import danse.repositories.SizeRepository;
import danse.repositories.TypeRepository;

@Service("metier")
public class Metier implements IMetier{

	// répositories
	@Autowired
	private BoxRepository boxRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ColourRepository colourRepository;
	
	@Autowired
	private KindRepository kindRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private SizeQuantityRepository sizeQuantityRepository;
	@Autowired
	private SizeRepository sizeRepository;
	
	@Override
	public List<Type> getAllTypes() {
		return Lists.newArrayList(typeRepository.findAll());
	}
	@Override
	public List<Colour> getAllColours() {
		return Lists.newArrayList(colourRepository.findAll());
	}
	@Override
	public List<Kind> getAllKinds() {
		return Lists.newArrayList(kindRepository.findAll());
	}
	@Override
	public List<Product> getAllProducts() {
		return Lists.newArrayList(productRepository.findAll());
	}
	@Override
	public List<Box> getAllBoxes() {
		return Lists.newArrayList(boxRepository.findAll());
	}
	@Override
	public List<Size> getAllSizes() {
		return Lists.newArrayList(sizeRepository.findAll());
	}
	@Override
	public List<SizeQuantity> getAllSizeQuantities() {
		return Lists.newArrayList(sizeQuantityRepository.findAll());
	}
	@Override
	public List<Category> getAllCategories() {
		return Lists.newArrayList(categoryRepository.findAll());
	}
	
	@Override
	public Product addProduct(String name, String comment, String picture, Integer totalQuantity,
			Colour colour, Kind kind, Category category, Box box, Type type,List<SizeQuantity> sizeQuantities) {
		Product product = productRepository.save(new Product(name, picture, comment, totalQuantity, category, type, colour, box, kind));
		product.setSizeQuantities(sizeQuantities);
		for (SizeQuantity sizeQuantity : sizeQuantities) {
			sizeQuantity.getSizeQuantityPk().setProduct(product);
			try {
			sizeQuantityRepository.save(sizeQuantity);
			}catch(Exception e) {System.out.println(e);}
			sizeQuantity.getSizeQuantityPk().setProduct(null);
		}
		return product;
	}
	@Override
	public Product getProduct(long idProduct) {
		return productRepository.findById(idProduct).get();
	}
	@Override
	public Size getSize(Long idSize) {
		return sizeRepository.findById(idSize).get();
	}
	@Override
	public Type getType(Long idType) {
		return typeRepository.findById(idType).get();
	}
	@Override
	public Kind getKind(Long idKind) {
		return kindRepository.findById(idKind).get();
	}
	@Override
	public Colour getColour(Long idColour) {
		Optional<Colour> result = colourRepository.findById(idColour);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	@Override
	public Category getCategory(Long idCategory) {
		return categoryRepository.findById(idCategory).get();
	}
	@Override
	public Box getBox(Long idBox) {
		return boxRepository.findById(idBox).get();
	}
	@Override
	public void deleteType(Long id) {
		typeRepository.deleteById(id);
		
	}
	@Override
	public void deleteKind(Long id) {
		kindRepository.deleteById(id);
		
	}
	@Override
	public void deleteColour(Long id) {
		productRepository.deleteColorOfProducts(id);
		colourRepository.deleteById(id);
		
	}
	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
		
	}
	@Override
	public void deleteBox(Long id) {
		boxRepository.deleteById(id);
		
	}
	@Override
	public void deleteSize(Long id) {
		sizeRepository.deleteById(id);
		
	}
	@Override
	public void deleteSizeQuantity(Long idProduct, Long idSize) {
		System.out.println("ici10");
		sizeQuantityRepository.deleteSizeQuantity(idProduct, idSize);
		
	}
	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		
	}
	@Override
	public Type addOrUpdateType(Type type) {
		return typeRepository.save(type);
	}
	@Override
	public Kind addOrUpdateKind(Kind kind) {
		return kindRepository.save(kind);
	}
	@Override
	public Colour addOrUpdateColour(Colour colour) {
		return colourRepository.save(colour);
	}
	@Override
	public Product addOrUpdateProduct(Product product) {
		return productRepository.save(product);
	}
	@Override
	public Box addOrUpdateBox(Box box) {
		return boxRepository.save(box);
	}
	@Override
	public Size addOrUpdateSize(Size size) {
		return sizeRepository.save(size);
	}
	@Override
	public SizeQuantity addOrUpdateSizeQuantity(SizeQuantity sizeQuantity) {
		return sizeQuantityRepository.save(sizeQuantity);
	}
	@Override
	public Category addOrUpdateCategory(Category category) {
		return categoryRepository.save(category);
	}
	@Override
	public SizeQuantity getSizeQuanity(Long idProduct, Long idSize) {
		return sizeQuantityRepository.getSizeQuantity(idProduct, idSize);
	}
	
	
		
}
