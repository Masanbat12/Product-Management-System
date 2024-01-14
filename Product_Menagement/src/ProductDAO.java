package src;
import src.entities.Product;
import src.database.DatabaseUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> getAllProducts() throws Exception {
        List<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM products";
        try (Connection conn = src.database.DatabaseUtility.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setStockQuantity(rs.getInt("stock_quantity"));
                
                products.add(product);
            }
        }
        
        return products;
    }
    public void addProduct(Product product) throws SQLException {
    String sql = "INSERT INTO products (name, description, price, stock_quantity) VALUES (?, ?, ?, ?)";
    
    try (Connection conn = src.database.DatabaseUtility.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
         
        stmt.setString(1, product.getName());
        stmt.setString(2, product.getDescription());
        stmt.setDouble(3, product.getPrice());
        stmt.setInt(4, product.getStockQuantity());
        
        stmt.executeUpdate();
    }
}


    // Similarly, you can add methods to insert, update, and delete products...
}
