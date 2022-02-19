package com.spring01.ex.model.shop;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Inject
	SqlSession sqlSession;
	
	
	@Override
	public List<ProductDTO> list() {
		return sqlSession.selectList("product.list");
	}

	@Override
	public ProductDTO detail(int product_code) {		
		return sqlSession.selectOne("product.detail", product_code);
	}

	@Override
	public void update(ProductDTO dto) {
		sqlSession.update("product.update", dto);

	}

	@Override
	public void delete(int product_code) {
		sqlSession.delete("product.delete", product_code);
	}

	@Override
	public void insert(ProductDTO dto) {
		sqlSession.insert("product_insert", dto);
	}
	
	@Override
	public String file_info(int product_code) { // product_code에 맞는 첨부 이미지 파일 이름을 리턴함. 
		return sqlSession.selectOne("product_file", product_code);
	}

}
