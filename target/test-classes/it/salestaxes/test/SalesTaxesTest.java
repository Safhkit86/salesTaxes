package it.salestaxes.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import it.salestaxes.ReceiptGenerator;
import it.salestaxes.constants.Constants.GoodsCategories;
import it.salestaxes.dtos.BasketDTO;
import it.salestaxes.dtos.GoodDTO;
import it.salestaxes.dtos.ReceiptDTO;
import it.salestaxes.utils.Utils;

/**
 * Class that contains test methods used by the application.
 * 
 * @author ivan.savocchia
 *
 */

public class SalesTaxesTest {
	
	private static BigDecimal SALES_TAXES1 = new BigDecimal("1.50");
	private static BigDecimal TOTAL1 = new BigDecimal("29.83");
	private static BigDecimal SALES_TAXES2 = new BigDecimal("7.65");
	private static BigDecimal TOTAL2 = new BigDecimal("65.15");
	private static BigDecimal SALES_TAXES3 = new BigDecimal("6.65");
	private static BigDecimal TOTAL3 = new BigDecimal("74.63");
	
	
	/**
	 * Test method for input 1.
	 */
	
	@Test
	public void generateReceiptTest1() {
		BasketDTO b = new BasketDTO();
		List<GoodDTO> goods = new ArrayList<GoodDTO>();
		b.setGoods(goods);
		
		GoodDTO g1 = new GoodDTO();
		g1.setName("book");
		g1.setCategory(GoodsCategories.BOOKS);
		g1.setImported(false);
		g1.setShelfPrice(new BigDecimal("12.49"));
		goods.add(g1);
		
		GoodDTO g2 = new GoodDTO();
		g2.setName("music CD");
		g2.setCategory(GoodsCategories.OTHER);
		g2.setImported(false);
		g2.setShelfPrice(new BigDecimal("14.99"));
		goods.add(g2);
		
		GoodDTO g3 = new GoodDTO();
		g3.setName("chocolate bar");
		g3.setCategory(GoodsCategories.FOOD);
		g3.setImported(false);
		g3.setShelfPrice(new BigDecimal("0.85"));
		goods.add(g3);
		
		
		System.out.println("Output 1:");
		
		
		ReceiptDTO receipt = null;
		
		try {
			receipt = ReceiptGenerator.generateReceipt(b);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}		
		
		Assert.assertNotNull(receipt);
		
		BigDecimal salesTaxes = receipt.getSalesTaxes();
		Assert.assertNotNull(salesTaxes);
		BigDecimal total = receipt.getTotal();
		Assert.assertNotNull(total);
		
		Assert.assertTrue(salesTaxes.compareTo(SALES_TAXES1) == 0);
		Assert.assertTrue(total.compareTo(TOTAL1) == 0);
		
		Assert.assertTrue(true);
	}
	
	
	/**
	 * Test method for input 2.
	 */
	
	@Test
	public void generateReceiptTest2() {
		BasketDTO b = new BasketDTO();
		List<GoodDTO> goods = new ArrayList<GoodDTO>();
		b.setGoods(goods);
		
		GoodDTO g1 = new GoodDTO();
		g1.setName("box of chocolates");
		g1.setCategory(GoodsCategories.FOOD);
		g1.setImported(true);
		g1.setShelfPrice(BigDecimal.TEN);
		goods.add(g1);
		
		GoodDTO g2 = new GoodDTO();
		g2.setName("bottle of perfume");
		g2.setCategory(GoodsCategories.OTHER);
		g2.setImported(true);
		g2.setShelfPrice(new BigDecimal("47.50"));
		goods.add(g2);
		
		
		System.out.println("Output 2:");
		
		
		ReceiptDTO receipt = null;
		
		try {
			receipt = ReceiptGenerator.generateReceipt(b);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}	
		
		Assert.assertNotNull(receipt);
		
		BigDecimal salesTaxes = receipt.getSalesTaxes();
		Assert.assertNotNull(salesTaxes);
		BigDecimal total = receipt.getTotal();
		Assert.assertNotNull(total);
		
		Assert.assertTrue(salesTaxes.compareTo(SALES_TAXES2) == 0);
		Assert.assertTrue(total.compareTo(TOTAL2) == 0);
		
		Assert.assertTrue(true);
	}
	
	
	/**
	 * Test method for input 3.
	 */
	
	@Test
	public void generateReceiptTest3() {
		BasketDTO b = new BasketDTO();
		List<GoodDTO> goods = new ArrayList<GoodDTO>();
		b.setGoods(goods);
		
		GoodDTO g1 = new GoodDTO();
		g1.setName(" bottle of perfume");
		g1.setCategory(GoodsCategories.OTHER);
		g1.setImported(true);
		g1.setShelfPrice(new BigDecimal("27.99"));
		goods.add(g1);
		
		GoodDTO g2 = new GoodDTO();
		g2.setName("bottle of perfume");
		g2.setCategory(GoodsCategories.OTHER);
		g2.setImported(false);
		g2.setShelfPrice(new BigDecimal("18.99"));
		goods.add(g2);
		
		GoodDTO g3 = new GoodDTO();
		g3.setName("packet of headache pills");
		g3.setCategory(GoodsCategories.MEDICAL_PRODUCTS);
		g3.setImported(false);
		g3.setShelfPrice(new BigDecimal("9.75"));
		goods.add(g3);
		
		GoodDTO g4 = new GoodDTO();
		g4.setName("box of chocolates");
		g4.setCategory(GoodsCategories.FOOD);
		g4.setImported(true);
		g4.setShelfPrice(new BigDecimal("11.25"));
		goods.add(g4);
		
		
		System.out.println("Output 3:");
		
		
		ReceiptDTO receipt = null;
		
		try {
			receipt = ReceiptGenerator.generateReceipt(b);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
		Assert.assertNotNull(receipt);
		
		BigDecimal salesTaxes = receipt.getSalesTaxes();
		Assert.assertNotNull(salesTaxes);
		BigDecimal total = receipt.getTotal();
		Assert.assertNotNull(total);
		
		Assert.assertTrue(salesTaxes.compareTo(SALES_TAXES3) == 0);
		Assert.assertTrue(total.compareTo(TOTAL3) == 0);
		
		Assert.assertTrue(true);
	}
}
