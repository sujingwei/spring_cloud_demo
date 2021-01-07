package top.aoae.article.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
	
	/** id */
	private Integer id;
	
	/** 文章类型 */
	private Byte type;
	
	/** 文章标题 */
	private String title;
	
	/** 文章正文 */
	private String content;
	
}
