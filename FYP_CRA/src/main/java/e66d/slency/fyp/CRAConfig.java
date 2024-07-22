/**
 * 
 * I declare that this code was written by me, slenc. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Slency
 * Student ID: 22009748
 * Class: E63C
 * Date created: 2024-Jul-21 3:09:24 pm 
 * 
 */

package e66d.slency.fyp;

/**
 * @author slenc
 *
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CRAConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:uploads/");
	}

}
