package persistence;
import java.util.List;

	public interface CategoryDAO {
		public List<CategoryDTO> getCategoryList();		
		public int insertCategory(CategoryDTO Category);	
		public int updateCategory(CategoryDTO Category);	
		public int deleteCategory(int categoryCode);		
		public CategoryDTO getCategoryByName(String categoryName);		
		public CategoryDTO getCategoryByCode(String categoryCode);		
	
}
