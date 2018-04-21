

package Comparator;

import java.util.Comparator;

import com.zengsy.pojo.Product;

/**
 * 比较器，用于对套餐进行排序
 * 1. ProductAllComparator 综合比较器
 把 销量x评价 高的放前面
 2. ProductReviewComparator 人气比较器
 把 评价数量多的放前面
 3. ProductDateComparator 新品比较器
 把 创建日期晚的放前面
 4. ProductSaleCountComparator 销量比较器
 把 销量高的放前面
 5. ProductPriceComparator 价格比较器
 把 价格低的放前面
 */
public class ProductAllComparator implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		return p2.getReviewCount()*p2.getSaleCount()-p1.getReviewCount()*p1.getSaleCount();
	}

}

