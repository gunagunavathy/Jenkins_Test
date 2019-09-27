/*package com.dhanjyothi.config;

import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.dhanjyothi.filter.SampleFilter;
public class DhanJyothiWeb extends  AbstractAnnotationConfigDispatcherServletInitializer{

@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { DhanJyothiConfig.class};
}	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"} ;
		}
	
	@Override
 	protected Filter[] getServletFilters() {
 
		return new Filter[] {
			      new SampleFilter()
	};
	}

}
*/