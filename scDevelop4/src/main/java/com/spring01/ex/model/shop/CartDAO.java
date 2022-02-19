package com.spring01.ex.model.shop;

import java.util.List;

public interface CartDAO {
	public List<CartDTO> cart_money();
	public void insert(CartDTO dto);
	public List<CartDTO> list(String userid);
	public void delete(int cart_id);
	public void delete_all(String userid);
	public int sum_money(String userid);
	public void modify(CartDTO dto);
}
